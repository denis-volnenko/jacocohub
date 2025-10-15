<#include '/include/header.ftl'>

<h1>АРТЕФАКТЫ</h1>

<table width="100%" cellpadding="10" cellspacing="0" border="1">
    <tr>
        <th>№</th>
        <th align="left">ТИП</th>
        <th align="left">НАЗВАНИЕ</th>
        <th>ПОКРЫТИЕ</th>
    </tr>
    <#assign index = 1>
    <#list artifacts as item>
        <tr>
            <td width="30" nowrap="nowrap" align="center"><#if index??>${index?string["00"]}.</#if></td>
            <td align="left" nowrap="nowrap">${item.type.displayName}</td>
            <td width="100%"><a href="/ui/artifact/${item.id}">${item.name}</a></td>
            <td align="right">${item.coverage}%</td>
        </tr>
        <#assign index = index + 1>
    </#list>
</table>

<#include '/include/footer.ftl'>