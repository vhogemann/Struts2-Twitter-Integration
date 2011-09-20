<!-- Twitter Interface Elements -->
<#macro twitter_user_box>
	<div class="round user box">
	<#if user??>
		<a href="http://www.twitter.com/${user.nick}" target="_">
			<img src="${user.image}"/>
			<span class="name">${user.name} <br/>
				<span class="nick">@${user.nick}</span>
			</span>
		</a>
	<#else>
		<a href="/stamp/twitterauth">
			<img src="/stamp/resources/img/twitter_newbird_blue.png" alt="Autorizar Aplicação">
			<span class="name"><@s.text name="twitter.auth.label"/><br/>
				<span class="nick"><@s.text name="twitter.auth.desc"/></span>
			</span>
		</a>
	</#if>
	<#nested>
	</div>
</#macro>

<#macro follow_me>
<a href="http://www.twitter.com/vhogemann"><img src="http://twitter-badges.s3.amazonaws.com/follow_me-c.png" alt="Follow vhogemann on Twitter"/></a>
</#macro>

<!-- Page Structure -->
<#macro head_includes>
	<!-- override @head_includes to include other tags -->
</#macro>

<#macro head title>
	<head>
	    <@head_includes/>
	    <meta http-equiv="Cache-Control" content="no-cache"/>
	    <meta http-equiv="Content-Type" content="text/html; charset=utf8" />
	    <link href="${request.contextPath}/resources/css/styles.css" rel="stylesheet" type="text/css" />
	    <script language="javascript" type="text/javascript" src="${request.contextPath}/resources/js/jquery-1.5.2.min.js"></script>
	    <script language="javascript" type="text/javascript" src="${request.contextPath}/resources/js/jquery-ui-1.8.11.custom.min.js"></script>
	    <script language="javascript" type="text/javascript" src="${request.contextPath}/resources/js/effects.js"></script>
	    <title>${title}</title>
 	</head>
</#macro>

<#macro header title>
	<div class="title">
		<h1><@s.text name="${title}"/></h1>
		<#nested>
	</div>
</#macro>


<!-- 
	
	Macros do MENU
	
-->

<#macro menu>
	<!-- Override @menu to add content -->
</#macro>

<#macro menuitem css link title>
	<li class="${css}"><a href="${link}">${title}</a></li>
</#macro>

<#macro menubox title>
	<div class="round box">
		<#if title??>
		<h2><@s.text name="${title}"/></h2>
		</#if>
		<ul class="menu">
			<#nested>
		</ul>
	</div>
</#macro>

<#macro menulist title items>
	<@menubox title="${title}">
		<#list items as item>
			<@menuitem title="${item.title}" link="${item.link}" css="${item.css}"/>
		</#list>
	</@menubox>
</#macro>

<#macro default_menu>
	<@twitter_user_box>
	
	</@twitter_user_box>
</#macro>

<!--

	Macros da lista de figuras

-->

<#macro stamplist stamps>
	<div class="box">
		<ul class="stamp">
			<#list stamps as stamp>
			<li>
				<div class="round">
					<a href="${stamp.page}" target="_">
					<img src="${stamp.img}" alt="${stamp.nick}"/>
					<h3>${stam.name}</h3>
					<p>${stamp.nick}</p>
					<spam class="description">
						${stamp.description}            
					</spam>
					</a>
				</div>        
			</li>
			</#list>
			<li></li><li></li>
		</ul>
	</div>
</#macro>

<#macro content>
	<!-- override @content to add custom content -->
	<#nested>
</#macro>

<#macro footer>
	<!-- override @footer to add custom content -->
</#macro>

<#macro body title>
	<div class="header">
		<div class="header">
			<@header '${title}'/>
		</div>
	</div>
	<div class="content">
		<@content><#nested></@content>
	</div>
	<div class="footer">
		<@footer/>
	</div>
</#macro>

<#macro page title>
<html>
	<@head '${title}'/>
	<body>
		<div class="wrap">
			<div class="header">
				<@header '${title}'/>
			</div>
			<div class="menu">
				<@default_menu/>
				<@menu/>
			</div>
			<div class="content round">
				<#nested>
			</div>
			<div class="footer">
				<@footer/>
			</div>
		</div>
	</body>
</html>
</#macro>