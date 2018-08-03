<#import "parts/main.fmt" as c>
<@c.page>
<h1>List of orders</h1>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Quantity</th>
       <th> Mobile number</th>
        <th>Status</th>

    </tr>
    </thead>
    <tbody>
<#list orders as order>
<tr>
    <td>${order.name}</td>
    <td>${order.quantity}</td>
    <td >${order.number}</td>
    <td> <form method="post" action="/order/list">
        <#list status as st>
        <div>
            <label> <input type="checkbox" name="${st}" <#if order.status==st.toString() > checked </#if>> ${st}</label>

        </div>
    </#list>
        <input type="hidden"  value="${order.id}" name="orderId" />
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button type="submit" class="btn btn-primary">Set</button> </form> </td>
</tr>
</#list>
    </tbody>
</table>
</@c.page>