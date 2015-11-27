package com.fes.common.mybatis.plugin;

import java.sql.Connection;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;

import com.fes.common.log.LogPool;
import com.fes.common.utils.DateUtils;

//拦截statementhandler这个类(其实也可以拦截其他类,比如Executor,但都能达到效果)
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class LogInterceptor implements Interceptor {

	private Properties properties;
	private DateUtils du = new DateUtils();

	public Object intercept(Invocation invocation) throws Throwable {

		// 获取到 statement 对象
		RoutingStatementHandler statement = (RoutingStatementHandler) invocation.getTarget();

		// 获取到 boungsql 对象,此对象封装了 与 sql 语句, 参数,以及jdbctype,javatype 等等一些信息...
		BoundSql boundSql = statement.getBoundSql();

		// 取出实际参数(参数有可能是一个model,有可能是一个map,还有可能是string)
		Object parameterObject = boundSql.getParameterObject();
		// 将这个参数对象就行格式化,以使得我们能够通过统一的getvalue()方法取出里面的值
		MetaObject metaObject = MetaObject.forObject(parameterObject);

		// 取出参数列表(这个不同与上面的 parameterObject,比如 : select * from table where name =
		// ? and pass = ?)
		// ParameterMapping 里面封装的了 name, pass , 而 parameterObject 封装的则是(?)所对应的值
		List<ParameterMapping> pm = boundSql.getParameterMappings();

		// 取出sql语句以及加上时间戳
		StringBuffer sql = new StringBuffer("[" + du.showDate("HH:mm:ss,sss") + "] ");
		sql.append(boundSql.getSql().replaceAll("\\s+|\t|\r|\n", " ")); // 取出空格及换行符等等...

		// 判断这个sql语句有几个参数
		if (pm.size() > 0) {
			// new 一个数组,存放这些参数,以便于稍后的工作
			Object[] params = new Object[pm.size()];

			int i = 0;
			int pmlen = pm.size();
			for (; i < pmlen; i++) {

				String propertyName = pm.get(i).getProperty(); // 取出参数名(如name,
																// pass)

				Object value = metaObject.getValue(propertyName); // 通过参数名取出参数的值
																	// (假设 xu,
																	// 123)

				params[i] = value; // 把值存到数组里面去
			}
			// 格式化 sql 语句和 参数
			sql = makeSQL(sql, params);
		}

		// 取出当前线程id
		long key = Thread.currentThread().getId();
		// 取出在这前面存入的sql语句(因为有可能一个controller的流程多次调用了 dao, 会有多次操作数据库)
		StringBuffer str = LogPool.getLogMap().get(key);

		// 如果在这之前确实有,则把它取出来, 加上这一次的 sql语句,在重新存入 map 中去
		try {
			LogPool.getLogMap().put(key, str.append("\r\n").append(sql));

		}
		catch (NullPointerException e) {
			// 如果前面没有,说明这是这个流程的第一条sql,直接存放起来
			LogPool.getLogMap().put(key, sql);
		}
		// 存放sql的任务到此结束,mybatis继续执行自己的事情(如果此流程只有一次执行sql语句,此时可以回去看 LogAop 类了)
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	// 格式化
	public StringBuffer makeSQL(StringBuffer sql, Object[] params) {
		// 循环替换里面的 ?
		String str = sql.toString();
		if (sql.indexOf("?") != -1) {
			for (int i = 0; i < params.length; i++) {
				try {
					str = str.replaceFirst("\\?", "'" + params[i].toString() + "'");

				}
				catch (NullPointerException e) {

					str = str.replaceFirst("\\?", "''");
				}
			}
		}
		return new StringBuffer(str);
	}
}
