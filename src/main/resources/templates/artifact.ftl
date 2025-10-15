<#include '/include/header.ftl'>

<h1>
    <#if artifact.type == 'APPLICATION'>
        ПРИЛОЖЕНИЕ "${artifact.name}"
    </#if>
    <#if artifact.type == 'LIBRARY'>
        БИБЛИОТЕКА "${artifact.name}"
    </#if>
</h1>

<h2>ГРАФИК ПОКРЫТИЯ ТЕСТАМИ</h2>

<iframe width="100%" height="400" style="border: 1px solid black;"></iframe>

<h2>ПОСЛЕДНИЕ РЕЗУЛЬТАТЫ</h2>

<table width="100%" cellpadding="10" cellspacing="0" border="1">

    <tr>
        <th>№</th>
        <th>ДАТА СОЗДАНИЯ</th>
        <th>ВЕТКА</th>
        <th>ПРОЦЕНТ</th>
        <th>INSTRUCTIONS</th>
        <th>BRANCHES</th>
    </tr>

<#assign index = 1>
<#list results as result>
    <tr>
        <td width="30" nowrap="nowrap" align="center"><#if index??>${index?string["00"]}.</#if></td>
        <td width="100%">${result.created}</td>
        <td width="200" nowrap="nowrap">${result.branchId}</td>
        <td align="right">${result.percent}%</td>
        <td align="right">${result.branches}%</td>
        <td align="right">${result.instructions}%</td>
    </tr>
    <#assign index = index + 1>
</#list>
</table>

<#include '/include/footer.ftl'>