<#include '/include/header.ftl'>

<h1>
    ${artifact.type.displayName} "${artifact.name}"
</h1>

<h2>ГРАФИК ПОКРЫТИЯ ТЕСТАМИ</h2>

<iframe width="100%" height="400" style="border: 1px solid black;"></iframe>

<h2>ПОСЛЕДНИЕ РЕЗУЛЬТАТЫ</h2>

<table width="100%" cellpadding="10" cellspacing="0" border="1">

    <tr>
        <th width="30" nowrap="nowrap" align="center">№</th>
        <th width="100%" align="left">ДАТА СОЗДАНИЯ</th>
        <th nowrap="nowrap" align="left">ВЕТКА</th>
        <th nowrap="nowrap" align="right">ВЕРСИЯ</th>
        <th align="right">ПОКРЫТИЕ</th>
    </tr>

<#assign index = 1>
<#list results as result>
    <tr>
        <td width="30" nowrap="nowrap" align="center"><#if index??>${index?string["00"]}.</#if></td>
        <td width="100%">${result.created}</td>
        <#assign branch = controller.getBranch(result.branchId) />
        <td nowrap="nowrap" align="left"><#if branch??>${branch.name}</#if></td>
        <#assign version = controller.getVersion(result.versionId) />
        <td nowrap="nowrap" align="right"><#if version??>${version.name}</#if></td>
        <td align="right">${result.coverage}%</td>
    </tr>
    <#assign index = index + 1>
</#list>
<#if !results?has_content>
    <tr>
        <td colspan="4" align="center">ОТСУТСТВУЮТ ДАННЫЕ</td>
    </tr>
</#if>
</table>

<#include '/include/footer.ftl'>