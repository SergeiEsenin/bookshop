<#import "parts/main.fmt" as m>
<#import "parts/login.fmt" as l>
<#include "parts/login.fmt">


<@m.page>


<div class="form-row" xmlns="http://www.w3.org/1999/html">
      <div class="form-group col-md-6">

          <form method="get"  class="form-inline">
              <input type="text" name="filterino" value="${filter?ifExists}">
              <button type="submit" class="btn btn-primary ml-2"> Filter</button>
          </form>
      </div>

      <div class="form-group col-md-6">
          <label>Сортировать по:</label>
          <a href="/shop/priceUp">По возрастанию</a>

          <a href="/shop/priceDown">По убыванию</a>

      </div>


  </div>



  Список сообщений
<div class="card-columns">
<#list books as b>
    <div class="card my-3" style="width: 18rem;">
        <div>
              <#if b.filename?? >
                  <img src="/img/${b.filename}" class="card-img-top">
              </#if>

        </div>
        <div class="m-2">
            <h5 align="center" class="card-title">${b.name}</h5>
        </div>
        <ul class="list-group list-group-flush">
            <li class="list-group-item">
                <strong>Authors:</strong>
                <#list b.authors as a>
                <i>${a}</i>
                    <sep>,</sep>
            </#list></li>
            <li class="list-group-item"><#list b.genres as a>
                <i>${a}</i>
                <sep>,</sep>
            </#list> </li>
            <li class="list-group-item"><strong>Price : </strong>${b.price}</li>
        </ul>


        <div class="card-footer text-muted">
<a href="/shop/${b.id}"> More</a>

        </div>

    </div>
<#else>
    Nothing to show

</#list>
</div>



</@m.page>