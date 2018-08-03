<#import "parts/main.fmt" as c>
<@c.page>
<h1>List of orders</h1>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Quantity</th>
       <th> Mobile number</th>
    </tr>
    </thead>
    <tbody>
<#list orders as order>
<tr>
    <td>${order.name}</td>
    <td>${order.quantity}</td>
    <td >${order.number}></td>
</tr>
</#list>
    </tbody>
</table>
</@c.page>