<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->

<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->

<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->

<!-- BEGIN HEAD -->

<head>

<meta charset="utf-8" />

<title>订单管理</title>

<meta content="width=device-width, initial-scale=1.0" name="viewport" />

<meta content="" name="description" />

<meta content="" name="author" />

<!-- BEGIN GLOBAL MANDATORY STYLES -->

<link href="views/media/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />

<link href="views/media/css/bootstrap-responsive.min.css"
	rel="stylesheet" type="text/css" />

<link href="views/media/css/font-awesome.min.css" rel="stylesheet"
	type="text/css" />

<link href="views/media/css/style-metro.css" rel="stylesheet"
	type="text/css" />

<link href="views/media/css/style.css" rel="stylesheet" type="text/css" />

<link href="views/media/css/style-responsive.css" rel="stylesheet"
	type="text/css" />

<link href="views/media/css/default.css" rel="stylesheet"
	type="text/css" id="style_color" />

<link href="views/media/css/uniform.default.css" rel="stylesheet"
	type="text/css" />

<!-- END GLOBAL MANDATORY STYLES -->

<!-- BEGIN PAGE LEVEL STYLES -->

<link rel="stylesheet" type="text/css"
	href="views/media/css/select2_metro.css" />

<link rel="stylesheet" href="views/media/css/DT_bootstrap.css" />



<!-- END PAGE LEVEL STYLES -->

<link rel="shortcut icon" href="views/media/image/favicon.ico" />

</head>

<!-- END HEAD -->

<!-- BEGIN BODY -->

<body class="page-header-fixed">

	<!-- BEGIN HEADER -->

	<div class="header navbar navbar-inverse navbar-fixed-top">

		<!-- BEGIN TOP NAVIGATION BAR -->

		<div class="navbar-inner">

			<div class="container-fluid">

				<!-- BEGIN LOGO -->

				<a class="brand" href="views/index.html"> <img
					src="views/media/image/logo.png" alt="logo" />

				</a>

				<!-- END LOGO -->

				<!-- BEGIN RESPONSIVE MENU TOGGLER -->

				<a href="views/javascript:;" class="btn-navbar collapsed"
					data-toggle="collapse" data-target=".nav-collapse"> <img
					src="views/media/image/menu-toggler.png" alt="" />

				</a>

				<!-- END RESPONSIVE MENU TOGGLER -->

				<!-- BEGIN TOP NAVIGATION MENU -->

				<ul class="nav pull-right">

					<!-- BEGIN NOTIFICATION DROPDOWN -->

					<li class="dropdown" id="header_notification_bar"><a
						href="views/#" class="dropdown-toggle" data-toggle="dropdown">

							<i class="icon-warning-sign"></i> <span class="badge">6</span>

					</a>

						<ul class="dropdown-menu extended notification">

							<li>

								<p>You have 14 new notifications</p>

							</li>

							<li><a href="views/#"> <span class="label label-success"><i
										class="icon-plus"></i></span> New user registered. <span class="time">Just
										now</span>

							</a></li>

							<li><a href="views/#"> <span
									class="label label-important"><i class="icon-bolt"></i></span>

									Server #12 overloaded. <span class="time">15 mins</span>

							</a></li>

							<li><a href="views/#"> <span class="label label-warning"><i
										class="icon-bell"></i></span> Server #2 not respoding. <span
									class="time">22 mins</span>

							</a></li>

							<li><a href="views/#"> <span class="label label-info"><i
										class="icon-bullhorn"></i></span> Application error. <span
									class="time">40 mins</span></a></li>

							<li><a href="views/#"> <span
									class="label label-important"><i class="icon-bolt"></i></span>

									Database overloaded 68%. <span class="time">2 hrs</span>

							</a></li>

							<li><a href="views/#"> <span
									class="label label-important"><i class="icon-bolt"></i></span>

									2 user IP blocked. <span class="time">5 hrs</span>

							</a></li>

							<li class="external"><a href="views/#">See all
									notifications <i class="m-icon-swapright"></i>
							</a></li>

						</ul></li>

					<!-- END NOTIFICATION DROPDOWN -->

					<!-- BEGIN INBOX DROPDOWN -->

					<li class="dropdown" id="header_inbox_bar"><a href="views/#"
						class="dropdown-toggle" data-toggle="dropdown"> <i
							class="icon-envelope"></i> <span class="badge">5</span>

					</a>

						<ul class="dropdown-menu extended inbox">

							<li>

								<p>You have 12 new messages</p>

							</li>

							<li><a href="views/inbox.html?a=view"> <span
									class="photo"><img src="views/media/image/avatar2.jpg"
										alt="" /></span> <span class="subject"> <span class="from">Lisa
											Wong</span> <span class="time">Just Now</span>

								</span> <span class="message"> Vivamus sed auctor nibh congue
										nibh. auctor nibh auctor nibh... </span>

							</a></li>

							<li><a href="views/inbox.html?a=view"> <span
									class="photo"><img src="views/media/image/avatar3.jpg"
										alt="" /></span> <span class="subject"> <span class="from">Richard
											Doe</span> <span class="time">16 mins</span>

								</span> <span class="message"> Vivamus sed congue nibh auctor
										nibh congue nibh. auctor nibh auctor nibh... </span>

							</a></li>

							<li><a href="views/inbox.html?a=view"> <span
									class="photo"><img src="views/media/image/avatar1.jpg"
										alt="" /></span> <span class="subject"> <span class="from">Bob
											Nilson</span> <span class="time">2 hrs</span>

								</span> <span class="message"> Vivamus sed nibh auctor nibh
										congue nibh. auctor nibh auctor nibh... </span>

							</a></li>

							<li class="external"><a href="views/inbox.html">See all
									messages <i class="m-icon-swapright"></i>
							</a></li>

						</ul></li>

					<!-- END INBOX DROPDOWN -->

					<!-- BEGIN TODO DROPDOWN -->

					<li class="dropdown" id="header_task_bar"><a href="views/#"
						class="dropdown-toggle" data-toggle="dropdown"> <i
							class="icon-tasks"></i> <span class="badge">5</span>

					</a>

						<ul class="dropdown-menu extended tasks">

							<li>

								<p>You have 12 pending tasks</p>

							</li>

							<li><a href="views/#"> <span class="task"> <span
										class="desc">New release v1.2</span> <span class="percent">30%</span>

								</span> <span class="progress progress-success "> <span
										style="width: 30%;" class="bar"></span>

								</span>

							</a></li>

							<li><a href="views/#"> <span class="task"> <span
										class="desc">Application deployment</span> <span
										class="percent">65%</span>

								</span> <span class="progress progress-danger progress-striped active">

										<span style="width: 65%;" class="bar"></span>

								</span>

							</a></li>

							<li><a href="views/#"> <span class="task"> <span
										class="desc">Mobile app release</span> <span class="percent">98%</span>

								</span> <span class="progress progress-success"> <span
										style="width: 98%;" class="bar"></span>

								</span>

							</a></li>

							<li><a href="views/#"> <span class="task"> <span
										class="desc">Database migration</span> <span class="percent">10%</span>

								</span> <span class="progress progress-warning progress-striped">

										<span style="width: 10%;" class="bar"></span>

								</span>

							</a></li>

							<li><a href="views/#"> <span class="task"> <span
										class="desc">Web server upgrade</span> <span class="percent">58%</span>

								</span> <span class="progress progress-info"> <span
										style="width: 58%;" class="bar"></span>

								</span>

							</a></li>

							<li><a href="views/#"> <span class="task"> <span
										class="desc">Mobile development</span> <span class="percent">85%</span>

								</span> <span class="progress progress-success"> <span
										style="width: 85%;" class="bar"></span>

								</span>

							</a></li>

							<li class="external"><a href="views/#">See all tasks <i
									class="m-icon-swapright"></i></a></li>

						</ul></li>

					<!-- END TODO DROPDOWN -->

					<!-- BEGIN USER LOGIN DROPDOWN -->

					<li class="dropdown user"><a href="views/#"
						class="dropdown-toggle" data-toggle="dropdown"> <img alt=""
							src="views/media/image/avatar1_small.jpg" /> <span
							class="username">Bob Nilson</span> <i class="icon-angle-down"></i>

					</a>

						<ul class="dropdown-menu">

							<li><a href="views/extra_profile.html"><i
									class="icon-user"></i> My Profile</a></li>

							<li><a href="views/page_calendar.html"><i
									class="icon-calendar"></i> My Calendar</a></li>

							<li><a href="views/inbox.html"><i class="icon-envelope"></i>
									My Inbox(3)</a></li>

							<li><a href="views/#"><i class="icon-tasks"></i> My
									Tasks</a></li>

							<li class="divider"></li>

							<li><a href="views/extra_lock.html"><i class="icon-lock"></i>
									Lock Screen</a></li>

							<li><a href="views/login.html"><i class="icon-key"></i>
									Log Out</a></li>

						</ul></li>

					<!-- END USER LOGIN DROPDOWN -->

				</ul>

				<!-- END TOP NAVIGATION MENU -->

			</div>

		</div>

		<!-- END TOP NAVIGATION BAR -->

	</div>

	<!-- END HEADER -->

	<!-- BEGIN CONTAINER -->

	<div class="page-container row-fluid">

		<!-- BEGIN SIDEBAR -->

		<div class="page-sidebar nav-collapse collapse">

			<!-- BEGIN SIDEBAR MENU -->

			<ul class="page-sidebar-menu">

				<li>
					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->

					<div class="sidebar-toggler hidden-phone"></div> <!-- BEGIN SIDEBAR TOGGLER BUTTON -->

				</li>

				<li>
					<!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->

					<form class="sidebar-search">

						<div class="input-box">

							<a href="views/javascript:;" class="remove"></a> <input
								type="text" placeholder="Search..." /> <input type="button"
								class="submit" value=" " />

						</div>

					</form> <!-- END RESPONSIVE QUICK SEARCH FORM -->

				</li>

				<li class="start "><a href="views/index.html"> <i
						class="icon-home"></i> <span class="title">Dashboard</span>

				</a></li>

				<li class=""><a href="views/javascript:;"> <i
						class="icon-cogs"></i> <span class="title">Layouts</span> <span
						class="arrow "></span>

				</a>

					<ul class="sub-menu">

						<li><a href="views/layout_horizontal_sidebar_menu.html">

								Horzontal & Sidebar Menu</a></li>

						<li><a href="views/layout_horizontal_menu1.html">

								Horzontal Menu 1</a></li>

						<li><a href="views/layout_horizontal_menu2.html">

								Horzontal Menu 2</a></li>

						<li><a href="views/layout_promo.html"> Promo Page</a></li>

						<li><a href="views/layout_email.html"> Email Templates</a></li>

						<li><a href="views/layout_ajax.html"> Content Loading via
								Ajax</a></li>

						<li><a href="views/layout_sidebar_closed.html"> Sidebar
								Closed Page</a></li>

						<li><a href="views/layout_blank_page.html"> Blank Page</a></li>

						<li><a href="views/layout_boxed_page.html"> Boxed Page</a></li>

						<li><a href="views/layout_boxed_not_responsive.html">

								Non-Responsive Boxed Layout</a></li>

					</ul></li>

				<li class=""><a href="views/javascript:;"> <i
						class="icon-bookmark-empty"></i> <span class="title">UI
							Features</span> <span class="arrow "></span>

				</a>

					<ul class="sub-menu">

						<li><a href="views/ui_general.html"> General</a></li>

						<li><a href="views/ui_buttons.html"> Buttons</a></li>

						<li><a href="views/ui_modals.html"> Enhanced Modals</a></li>

						<li><a href="views/ui_tabs_accordions.html"> Tabs &
								Accordions</a></li>

						<li><a href="views/ui_jqueryui.html"> jQuery UI
								Components</a></li>

						<li><a href="views/ui_sliders.html"> Sliders</a></li>

						<li><a href="views/ui_tiles.html"> Tiles</a></li>

						<li><a href="views/ui_typography.html"> Typography</a></li>

						<li><a href="views/ui_tree.html"> Tree View</a></li>

						<li><a href="views/ui_nestable.html"> Nestable List</a></li>

					</ul></li>

				<li class=""><a href="views/javascript:;"> <i
						class="icon-table"></i> <span class="title">Form Stuff</span> <span
						class="arrow "></span>

				</a>

					<ul class="sub-menu">

						<li><a href="views/form_layout.html"> Form Layouts</a></li>

						<li><a href="views/form_samples.html"> Advance Form
								Samples</a></li>

						<li><a href="views/form_component.html"> Form Components</a>

						</li>

						<li><a href="views/form_wizard.html"> Form Wizard</a></li>

						<li><a href="views/form_validation.html"> Form Validation</a></li>

						<li><a href="views/form_fileupload.html"> Multiple File
								Upload</a></li>

						<li><a href="views/form_dropzone.html"> Dropzone File
								Upload</a></li>

					</ul></li>

				<li class=""><a href="views/javascript:;"> <i
						class="icon-briefcase"></i> <span class="title">Pages</span> <span
						class="arrow "></span>

				</a>

					<ul class="sub-menu">

						<li><a href="views/page_timeline.html"> <i
								class="icon-time"></i> Timeline
						</a></li>

						<li><a href="views/page_coming_soon.html"> <i
								class="icon-cogs"></i> Coming Soon
						</a></li>

						<li><a href="views/page_blog.html"> <i
								class="icon-comments"></i> Blog
						</a></li>

						<li><a href="views/page_blog_item.html"> <i
								class="icon-font"></i> Blog Post
						</a></li>

						<li><a href="views/page_news.html"> <i
								class="icon-coffee"></i> News
						</a></li>

						<li><a href="views/page_news_item.html"> <i
								class="icon-bell"></i> News View
						</a></li>

						<li><a href="views/page_about.html"> <i
								class="icon-group"></i> About Us
						</a></li>

						<li><a href="views/page_contact.html"> <i
								class="icon-envelope-alt"></i> Contact Us
						</a></li>

						<li><a href="views/page_calendar.html"> <i
								class="icon-calendar"></i> Calendar
						</a></li>

					</ul></li>

				<li class=""><a href="views/javascript:;"> <i
						class="icon-gift"></i> <span class="title">Extra</span> <span
						class="arrow "></span>

				</a>

					<ul class="sub-menu">

						<li><a href="views/extra_profile.html"> User Profile</a></li>

						<li><a href="views/extra_lock.html"> Lock Screen</a></li>

						<li><a href="views/extra_faq.html"> FAQ</a></li>

						<li><a href="views/inbox.html"> Inbox</a></li>

						<li><a href="views/extra_search.html"> Search Results</a></li>

						<li><a href="views/extra_invoice.html"> Invoice</a></li>

						<li><a href="views/extra_pricing_table.html"> Pricing
								Tables</a></li>

						<li><a href="views/extra_image_manager.html"> Image
								Manager</a></li>

						<li><a href="views/extra_404_option1.html"> 404 Page
								Option 1</a></li>

						<li><a href="views/extra_404_option2.html"> 404 Page
								Option 2</a></li>

						<li><a href="views/extra_404_option3.html"> 404 Page
								Option 3</a></li>

						<li><a href="views/extra_500_option1.html"> 500 Page
								Option 1</a></li>

						<li><a href="views/extra_500_option2.html"> 500 Page
								Option 2</a></li>

					</ul></li>

				<li><a class="active" href="views/javascript:;"> <i
						class="icon-sitemap"></i> <span class="title">3 Level Menu</span>

						<span class="arrow "></span>

				</a>

					<ul class="sub-menu">

						<li><a href="views/javascript:;"> Item 1 <span
								class="arrow"></span>

						</a>

							<ul class="sub-menu">

								<li><a href="views/#">Sample Link 1</a></li>

								<li><a href="views/#">Sample Link 2</a></li>

								<li><a href="views/#">Sample Link 3</a></li>

							</ul></li>

						<li><a href="views/javascript:;"> Item 1 <span
								class="arrow"></span>

						</a>

							<ul class="sub-menu">

								<li><a href="views/#">Sample Link 1</a></li>

								<li><a href="views/#">Sample Link 1</a></li>

								<li><a href="views/#">Sample Link 1</a></li>

							</ul></li>

						<li><a href="views/#"> Item 3 </a></li>

					</ul></li>

				<li><a href="views/javascript:;"> <i
						class="icon-folder-open"></i> <span class="title">4 Level
							Menu</span> <span class="arrow "></span>

				</a>

					<ul class="sub-menu">

						<li><a href="views/javascript:;"> <i class="icon-cogs"></i>

								Item 1 <span class="arrow"></span>

						</a>

							<ul class="sub-menu">

								<li><a href="views/javascript:;"> <i class="icon-user"></i>

										Sample Link 1 <span class="arrow"></span>

								</a>

									<ul class="sub-menu">

										<li><a href="views/#"><i class="icon-remove"></i>
												Sample Link 1</a></li>

										<li><a href="views/#"><i class="icon-pencil"></i>
												Sample Link 1</a></li>

										<li><a href="views/#"><i class="icon-edit"></i>
												Sample Link 1</a></li>

									</ul></li>

								<li><a href="views/#"><i class="icon-user"></i> Sample
										Link 1</a></li>

								<li><a href="views/#"><i class="icon-external-link"></i>
										Sample Link 2</a></li>

								<li><a href="views/#"><i class="icon-bell"></i> Sample
										Link 3</a></li>

							</ul></li>

						<li><a href="views/javascript:;"> <i class="icon-globe"></i>

								Item 2 <span class="arrow"></span>

						</a>

							<ul class="sub-menu">

								<li><a href="views/#"><i class="icon-user"></i> Sample
										Link 1</a></li>

								<li><a href="views/#"><i class="icon-external-link"></i>
										Sample Link 1</a></li>

								<li><a href="views/#"><i class="icon-bell"></i> Sample
										Link 1</a></li>

							</ul></li>

						<li><a href="views/#"> <i class="icon-folder-open"></i>

								Item 3

						</a></li>

					</ul></li>

				<li class=""><a href="views/javascript:;"> <i
						class="icon-user"></i> <span class="title">Login Options</span> <span
						class="arrow "></span>

				</a>

					<ul class="sub-menu">

						<li><a href="views/login.html"> Login Form 1</a></li>

						<li><a href="views/login_soft.html"> Login Form 2</a></li>

					</ul></li>

				<li class="active "><a href="views/javascript:;"> <i
						class="icon-th"></i> <span class="title">Data Tables</span> <span
						class="selected"></span> <span class="arrow open"></span>

				</a>

					<ul class="sub-menu">

						<li><a href="views/table_basic.html"> Basic Tables</a></li>

						<li><a href="views/table_responsive.html"> Responsive
								Tables</a></li>

						<li class="active"><a href="views/table_managed.html">

								Managed Tables</a></li>

						<li><a href="views/table_editable.html"> Editable Tables</a>

						</li>

						<li><a href="views/table_advanced.html"> Advanced Tables</a>

						</li>

					</ul></li>

				<li class=""><a href="views/javascript:;"> <i
						class="icon-file-text"></i> <span class="title">Portlets</span> <span
						class="arrow "></span>

				</a>

					<ul class="sub-menu">

						<li><a href="views/portlet_general.html"> General
								Portlets</a></li>

						<li><a href="views/portlet_draggable.html"> Draggable
								Portlets</a></li>

					</ul></li>

				<li class=""><a href="views/javascript:;"> <i
						class="icon-map-marker"></i> <span class="title">Maps</span> <span
						class="arrow "></span>

				</a>

					<ul class="sub-menu">

						<li><a href="views/maps_google.html"> Google Maps</a></li>

						<li><a href="views/maps_vector.html"> Vector Maps</a></li>

					</ul></li>

				<li class="last "><a href="views/charts.html"> <i
						class="icon-bar-chart"></i> <span class="title">Visual
							Charts</span>

				</a></li>

			</ul>

			<!-- END SIDEBAR MENU -->

		</div>

		<!-- END SIDEBAR -->

		<!-- BEGIN PAGE -->

		<div class="page-content">

			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->

			<div id="portlet-config" class="modal hide">

				<div class="modal-header">

					<button data-dismiss="modal" class="close" type="button"></button>

					<h3>portlet Settings</h3>

				</div>

				<div class="modal-body">

					<p>Here will be a configuration form</p>

				</div>

			</div>

			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->

			<!-- BEGIN PAGE CONTAINER-->

			<div class="container-fluid">

				<!-- BEGIN PAGE HEADER-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN STYLE CUSTOMIZER -->

						<div class="color-panel hidden-phone">

							<div class="color-mode-icons icon-color"></div>

							<div class="color-mode-icons icon-color-close"></div>

							<div class="color-mode">

								<p>THEME COLOR</p>

								<ul class="inline">

									<li class="color-black current color-default"
										data-style="default"></li>

									<li class="color-blue" data-style="blue"></li>

									<li class="color-brown" data-style="brown"></li>

									<li class="color-purple" data-style="purple"></li>

									<li class="color-grey" data-style="grey"></li>

									<li class="color-white color-light" data-style="light"></li>

								</ul>

								<label> <span>Layout</span> <select
									class="layout-option m-wrap small">

										<option value="fluid" selected>Fluid</option>

										<option value="boxed">Boxed</option>

								</select>

								</label> <label> <span>Header</span> <select
									class="header-option m-wrap small">

										<option value="fixed" selected>Fixed</option>

										<option value="default">Default</option>

								</select>

								</label> <label> <span>Sidebar</span> <select
									class="sidebar-option m-wrap small">

										<option value="fixed">Fixed</option>

										<option value="default" selected>Default</option>

								</select>

								</label> <label> <span>Footer</span> <select
									class="footer-option m-wrap small">

										<option value="fixed">Fixed</option>

										<option value="default" selected>Default</option>

								</select>

								</label>

							</div>

						</div>

						<!-- END BEGIN STYLE CUSTOMIZER -->

						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<h3 class="page-title">

							订单管理 <small>订单列表</small>

						</h3>

						<ul class="breadcrumb">

							<li><i class="icon-home"></i> <a href="views/index.html">Home</a>

								<i class="icon-angle-right"></i></li>

							<li><a href="views/#">Data Tables</a> <i
								class="icon-angle-right"></i></li>

							<li><a href="views/#">Managed Tables</a></li>

						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->

					</div>

				</div>

				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">

					<div class="span12">

						<!-- BEGIN EXAMPLE TABLE PORTLET-->

						<div class="portlet box light-grey">



							<div class="portlet-body">




								<form action="../fes/search" method="post">

									<div class="controls controls-row">
										<input name="order_no" class="span3" type="text" placeholder="订单号" />
										<input class="span2" type="text" placeholder="票号" />
										 <input class="span1" type="text" placeholder="PNR" /> 
										 <input class="span2" type="text" placeholder="支付流水号" />
									</div>

									<div class="controls controls-row">

										<div class="input-append date date-picker" data-date="2014-02-12" data-date-format="yyyy-mm-dd" data-date-viewmode="years">
											<input class="m-wrap m-ctrl-medium date-picker" readonly="" size="16" type="text" value="" placeholder="预订时间(S)">
											<span class="add-on"><i class="icon-calendar"></i></span>
										</div>

										<div class="input-append date date-picker" data-date="2014-02-13" data-date-format="yyyy-mm-dd" data-date-viewmode="years">
											<input class="m-wrap m-ctrl-medium date-picker" readonly="" size="16" type="text" value="" placeholder="预订时间(S)">
											<span class="add-on"><i class="icon-calendar"></i></span>
										</div>
										
										<div class="input-append date date-picker">
											<button type="submit" class="btn red">开始查询</button>
										</div>
										
									</div>

								</form>







<hr>
								<table class="table table-striped table-bordered table-hover"
									id="sample_1">

									<thead>

										<tr>

											<th style="width: 8px;"><input type="checkbox"
												class="group-checkable" data-set="#sample_1 .checkboxes" /></th>

											<th class="hidden-480">姓名</th>

											<th class="hidden-480">手机号</th>

											<th class="hidden-480">出发城市</th>

											<th class="hidden-480">到达城市</th>
					
											<th class="hidden-240">订单状态</th>

										</tr>

									</thead>

									<tbody>


									<c:forEach var="order" items="${sList}">
										<tr class="odd gradeX">

											<td><input type="checkbox" class="checkboxes" value="1" /></td>

											<td>${order.CONNECT_PERSON}</td>

											<td class="hidden-480">${order.CONNECT_PHONE}</td>

											<td class="hidden-480">${order.DEPARTURE_AIRPORT}</td>

											<td class="center hidden-480">${order.ARRIVAL_AIRPORT}</td>

											<td><span class="label label-${(order.REGISTER_STATUS == 3) ? 'success' : 'warning'}">${order.REGISTER_STATUS}</span></td>

											


										</tr>

									</c:forEach>



									</tbody>

								</table>

							</div>

						</div>

						<!-- END EXAMPLE TABLE PORTLET-->

					</div>

				</div>


				<!-- END PAGE CONTENT-->

			</div>

			<!-- END PAGE CONTAINER-->

		</div>

		<!-- END PAGE -->

	</div>

	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->

	<div class="footer">

		<div class="footer-inner">2015 &copy; AirChina All rights reserved.</div>

		<div class="footer-tools">

			<span class="go-top"> <i class="icon-angle-up"></i>

			</span>

		</div>

	</div>

	<!-- END FOOTER -->

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

	<!-- BEGIN CORE PLUGINS -->

	<script src="views/media/js/jquery-1.10.1.min.js"
		type="text/javascript"></script>

	<script src="views/media/js/jquery-migrate-1.2.1.min.js"
		type="text/javascript"></script>

	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->

	<script src="views/media/js/jquery-ui-1.10.1.custom.min.js"
		type="text/javascript"></script>

	<script src="views/media/js/bootstrap.min.js" type="text/javascript"></script>

	<!--[if lt IE 9]>

	<script src="views/media/js/excanvas.min.js"></script>

	<script src="views/media/js/respond.min.js"></script>  

	<![endif]-->

	<script src="views/media/js/jquery.slimscroll.min.js"
		type="text/javascript"></script>

	<script src="views/media/js/jquery.blockui.min.js"
		type="text/javascript"></script>

	<script src="views/media/js/jquery.cookie.min.js"
		type="text/javascript"></script>

	<script src="views/media/js/jquery.uniform.min.js"
		type="text/javascript"></script>

	<!-- END CORE PLUGINS -->

	<!-- BEGIN PAGE LEVEL PLUGINS -->

	<script type="text/javascript" src="views/media/js/select2.min.js"></script>

	<script type="text/javascript"
		src="views/media/js/jquery.dataTables.js"></script>

	<script type="text/javascript" src="views/media/js/DT_bootstrap.js"></script>

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="views/media/js/app.js"></script>

	<script src="views/media/js/table-managed.js"></script>

	<script>
		jQuery(document).ready(function() {

			App.init();

			TableManaged.init();

		});
	</script>

	<script type="text/javascript">
		var _gaq = _gaq || [];
		_gaq.push([ '_setAccount', 'UA-37564768-1' ]);
		_gaq.push([ '_setDomainName', 'keenthemes.com' ]);
		_gaq.push([ '_setAllowLinker', true ]);
		_gaq.push([ '_trackPageview' ]);
		(function() {
			var ga = document.createElement('script');
			ga.type = 'text/javascript';
			ga.async = true;
			ga.src = ('https:' == document.location.protocol ? 'https://'
					: 'http://')
					+ 'stats.g.doubleclick.net/dc.js';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(ga, s);
		})();
	</script>
</body>

<!-- END BODY -->

</html>