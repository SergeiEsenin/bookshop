<#import "parts/main.fmt" as m>


<@m.page>


<form method="post" enctype="multipart/form-data" >
  <div class="row">
    <div class="col">
      <input type="text" class="form-control" placeholder="Book name" name="title" value="${book.name}">
    </div>
    <div class="col">
      <input type="text" class="form-control" placeholder="Price" name="price" value="${book.price}">
    </div>

  </div>



   <div class="row">
         <div class="col ">
         <select class="selectpicker" multiple name="genres" >

                    <option>ScienceFiction</option>
                    <option>Satire</option>
                    <option>Drama</option>
                    <option>Action</option>
                    <option>Adventure</option>
                    <option>Romance</option>
                    <option>Mystery</option>
                    <option>Horror</option>
                    <option>Religion</option>
                    <option>Science</option>
                    <option>History</option>
                    <option>Poetry</option>
                    <option>Comics</option>
                    <option>Art</option>
                    <option>Biographies</option>
                    <option>Fantasy</option>
                  </select>
         </div>

      <div class="col  mt-2">
      <#if book.authorsStringed??>
           <input type="text" class="form-control" placeholder="Pls input authors through ," name="authors" value="${book.authorsStringed}">
</#if>
            </div>


      </div>
      <div class="row">
  <div class="col  mt-2">

                 <div class="custom-file">
                     <input type="file" name="file" id="customFile" <#if book.finalpass??> value="${book.finalpass}" </#if> required>
                     <label class="custom-file-label" for="customFile">Choose file</label>


</div>
</div>
 <div class="col  mt-2">
  <div class="form-group">
     <textarea class="form-control" rows="3" name="annotation">
      <#if book.annotation??> ${book.annotation} </#if> </textarea>
   </div>
 </div>
</div>
<div class="row">
 <div class="col  mt-2">
 <input type="hidden" name="_csrf" value="${_csrf.token}" />
  <button type="submit" class="btn btn-primary ">Submit</button>
</div>
</div>

</form>
</@m.page>