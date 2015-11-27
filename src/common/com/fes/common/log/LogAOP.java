package com.fes.common.log;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.FileAppender;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.fes.common.utils.DateUtils;

@Aspect
@Service
public class LogAOP {

	/**
	 * 注:此次日志功能,只需要 LogAOp,LogPool,以及 LogInterceptor 3 个类,其余的都不需要了(比如  makelog )
	 * 
	 * LogAop,主要负责记录流程的开始与结束,以及当流程技术的时候,将信息 debug
	 * LogPool,主要存放sql语句
	 * LogInterceptor, 拦截mybaits的执行过程,获取 sql 语句以及参数
	 * 
	 */

	private String s_head = "...START...\r\n";
	private String s_tail = "---OVER---\r\n";
	private DateUtils du = new DateUtils();

	// 匹配 cn.binq.his.*.controller 包下的,所有类的所有方法
	// (前提是,方法中至少包含request这个参数,否则不会匹配),并且返回值为任意类型
	// @Around("execution(* cn.binq.his.*.controller.*.*(..,javax.servlet.http.HttpServletRequest,..))")
	@Around("execution(* cn.binq.*.*.controller.*.*(..))")
	public Object ipSD(ProceedingJoinPoint pjp) {
		// 被通知方法的返回值
		Object returnValue = null;

		try {
			// 获取被通知方法的参数列表
			Object[] args = pjp.getArgs();

			String head = action(args) + pjp.getSignature() + " \r\n"; // 获取方法签名(就是执行的那个controller方法的名字)

			// 让controller的方法继续执行
			// 这之间就是我们的业务逻辑了,具体里面执行了多少次servie,dao或者访问数据库,我们都不管
			returnValue = pjp.proceed();

			// 所有的业务逻辑执行完毕之后,取出存放在map中的sql(具体存放sql的方法可以查看 LogInterceptor 插件)
			StringBuffer sqls = LogPool.getLogMap().get(Thread.currentThread().getId());

			if (sqls != null && !"".equals(sqls) && !sqls.equals(null)) {

				String s_sqls = sqls.toString() + "\r\n";

				String tail = "[DEBUG]{" + du.showDate("yyyy-MM-dd HH:mm:ss,sss") + "} " + s_tail;// 拼结尾

				String packagePath = this.getPackage(pjp.getSignature().toString()); // 获取模块名
				// 根据模块名，动态改变log文件的文件名

				this.isExist(packagePath);

				// 将信息打印出去
				LogPool.getLog().debug(head + s_sqls + tail);

			}

			// 最后controller的方法return(流程结束),我们要把刚存进去的信息 remove掉
			LogPool.getLogMap().remove(Thread.currentThread().getId());

		}
		catch (Throwable e) {
			e.printStackTrace();
			LogPool.getLogMap().remove(Thread.currentThread().getId());
		}
		// 将controller的返回值,返还给客户端, 此次流程结束
		return returnValue;
	}

	// 取出 ip ,用户名, 以及时间等等信息,作为日志流程的head部分
	public String action(Object[] args) {
		String username = null;
		String ip = null;
		for (int i = 0; i < args.length; i++) {
			if (args[i] instanceof HttpServletRequest) {
				HttpServletRequest request = (HttpServletRequest) args[i];
				username = (String) request.getSession().getAttribute("loginUser");
				ip = request.getRemoteAddr();
				break;
			}
		}
		return new String(s_head + "用户: " + username + ", IP: " + ip + ", 时间戳:[" + du.showDate("yyyy-MM-dd HH:mm:ss,sss") + "], 方法签名: ");
	}

	// 判断是出自哪个包里面的
	public String getPackage(String str) {
		str = str.split("\\.")[3];
		return str;
	}

	// 生成对应模块的文件夹
	public void isExist(String packagePath) {
		try {
			FileAppender a = (FileAppender) LogPool.getLog().getAppender("file");
			String basePath = a.getFile();
			String[] ss = basePath.split("/");
			String path = "";
			// 判断是否在当前包
			if (!ss[2].equals(packagePath)) {
				path = ss[0] + "/" + ss[1] + "/" + packagePath + "/";
				File f = new File(path);
				if (!f.exists() || !f.isDirectory()) {
					f.mkdir();
				}
				basePath = path + packagePath + ".log";
			}

			// 判断是否过了一天应该建立新文件了
			File f = new File(basePath);
			if (f.exists()) {
				Date d1 = new Date(f.lastModified());
				Date d2 = new Date(System.currentTimeMillis());

				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

				if (!sf.format(d1).equals(sf.format(d2))) {

					File f2 = new File(basePath + "." + sf.format(d1) + ".log");

					f.renameTo(f2);
				}
			}
			a.setFile(basePath);
			a.activateOptions();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}