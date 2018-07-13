<#import "parts/main.fmt" as m>



<@m.page>


<@c.page>
  <div class="form-row">
    <div class="form-group col-md-6">

      <form method="get" action="/main" class="form-inline">
          <input type="text" name="filter" value="${filter?ifExists}" >
<button type="submit" class="btn btn-primary ml-2" > Filter</button>
      </form>
    </div>
</div>
 <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Add new Message
  </a>

 <div class="collapse  <#if message??>show</#if>" id="collapseExample">
     <div class="form-group mt-3">
         <form method="post" enctype="multipart/form-data">
             <div class="form-group">
                 <input type="text" class="form-control ${(textError??)?string('is-invalid','')}"
                 value="<#if message??>${message.text}</#if>" name="text" placeholder="Введите сообщение" />

<#if textError??>
<div class= "invalid- feedback">
${textError}
</div>
</div>
</#if>
             <div class="form-group">
                 <input type="text" class="form-control" value="<#if message??>${message.tag}</#if>"
                 name="tag" placeholder="Тэг">


             <#if tagError??>
             <div class= "invalid- feedback">
             ${tagError}
             </div>
             </#if>
             </div>

             <div class="form-group">
                 <div class="custom-file">
                     <input type="file" name="file" id="customFile">
                     <label class="custom-file-label" for="customFile">Choose file</label>
                 </div>
             </div>
             <input type="hidden" name="_csrf" value="${_csrf.token}" />
             <div class="form-group">
                 <button type="submit" class="btn btn-primary">Добавить</button>
             </div>
         </form>
     </div>
 </div>

  Список сообщений
<div class="card-columns">
<#list messages as m>
<div class="card my-3" style="width: 18rem;">
    <div>
              <#if m.filename?? >
                <img src ="/img/${m.filename}" class="card-img-top">
        </#if>

        </div>
        <div class="m-2">
        <span>${m.text}</span>
        </div>
        <i> ${m.tag}</i>
        <div class="card-footer text-muted">
        ${m.authorName}
</div>

    </div>
    <#else>
    Nothing to show

</#list>
</div>


</@m.page>