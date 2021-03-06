<#include "../default_macros.ftl"/>
<#import "../adsense.ftl" as ad/>
<#macro menu>
	<#if user??>
	<@menubox title="home.user.albuns">
		<#if user.albuns??>
		<#list user.albuns as album>
		<@menuitem title="${album.name}" css="" link="${base}/album/${album.id}/${album.name}"/>
		<#if album_index = 4>
			<#if album_has_next>
				<@menuitem title="list.album" css="selected" link="${base}/album/list"/>
			</#if>
			<#break/>
		</#if>
		</#list>
		</#if>
		<@menuitem title="new.album" css="selected" link="${base}/album/new"/>
	</@menubox>
	</#if>
	<@menubox title="">
		<@ad.menu/>
	</@menubox>
</#macro>