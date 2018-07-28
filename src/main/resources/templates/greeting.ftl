<#import "parts/main.fmt" as m >
<#include "parts/security.fmt">





<@m.page>
<center><h1> It's work</h1></center>

<#if user??>
<div><p id="demo">Hello, ${name} </p></div>
<#else>
<p> Hello, NoName </p>
</#if>


</@m.page>