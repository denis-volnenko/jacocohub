<#include '/include/header.ftl'>

<h1>АРТЕФАКТЫ</h1>

<#list artifacts as item>
    <p><a href="/ui/artifact/${item.id}">${item.name}</a></p>
</#list>

<#include '/include/footer.ftl'>