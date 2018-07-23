<#import "parts/main.fmt" as m>
<#import "parts/login.fmt" as l>



<@m.page>



  <div class="form-row">
    <div class="form-group col-md-6">

      <form method="get" action="/main" class="form-inline">
          <input type="text" name="filter" value="${filter?ifExists}" >
<button type="submit" class="btn btn-primary ml-2" > Filter</button>
      </form>
    </div>
</div>



  Список сообщений
<div class="card-columns">
<#list books as b>
<div class="card my-3" style="width: 18rem;">
    <div>
              <#if b.filename?? >
                  <img src ="/img/${b.filename}" class="card-img-top">
              </#if>

    </div>
        <div class="m-2">
        <span>${b.name}</span>
        </div>
        <#list b.authors as a>
        <i> ${a}</i>
        </#list>
     <#list b.genres as a>
        <i> ${a}</i>
     </#list>
        <div class="card-footer text-muted">
${b.price}
</div>

    </div>
    <#else>
    Nothing to show

</#list>
</div>



</@m.page>