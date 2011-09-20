<#include "album_macros.ftl"/>

<@page title="album.create">
	
	<form action="${base}/album/save">
		<fieldset>
			<label><@s.text name="album.form.name"/></label>
			<input type="text" name="album.name"/>
		</fieldset>
		<fieldset>
			<label><@s.text name="album.form.description"/></label>
			<input type="text" name="album.description"/>
		</fieldset>
		<fieldset>
			<input type="submit"/>
		</fieldset>
	</form>

</@page>