<#import "parts/main.fmt" as m>


<@m.page>


<form method="post" action="/add">
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
         <select class="selectpicker" multiple name="genres"  >
                    <option>Mustard</option>
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
      <#list book.authors as author>
           <input type="text" class="form-control" placeholder="Pls input authors through ," name="authors" value="${book.authors}"<#sep>,>
           </#list>
            </div>


      </div>



  <button type="submit" class="btn btn-primary mt-3">Submit</button>
</form>
</@m.page>