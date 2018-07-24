<#import "parts/main.fmt" as c>
<#import "parts/login.fmt" as l>

<@c.page>

<div><h1>${message!"Type your data"}<h1></div>
    <@l.login "/registration" true/>
</@c.page>