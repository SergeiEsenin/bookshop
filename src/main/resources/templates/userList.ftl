<#import "parts/main.fmt" as c>
<@c.page>
<h1>List of users</h1>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Role</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
<#list users as user>
<tr>
    <td>${user.username}</td>
    <td><#list user.roles as roles>${roles}<#sep>,  </#list></td>
    <td ><a href="user/${user.id}">Edit</a></td>
</tr>
</#list>
    </tbody>
</table>
</@c.page>