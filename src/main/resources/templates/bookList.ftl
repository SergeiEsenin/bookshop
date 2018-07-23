<#import "parts/main.fmt" as m>


<@m.page>


<form method="post" action="/add" enctype="multipart/form-data">
  <div class="row">
    <div class="col mt-2">
      <input type="text" class="form-control" placeholder="Book name" name="title" >
    </div>
    <div class="col mt-2">
      <input type="text" class="form-control" placeholder="Price" name="price" >
    </div>

  </div>
    <div class="row">
      <div class="col mt-2">
      <select class=" mt-2" multiple name="genres"  >

                 <option checked="checked">ScienceFiction</option>
                 <option checked>Satire</option>
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
           <input type="text" class="form-control" placeholder="Pls input authors through ," name="authors" >
            </div>
      </div>

      <div class="row">
  <div class="col  mt-2">

                 <div class="custom-file">
                     <input type="file" name="file" id="customFile" required>
                     <label class="custom-file-label" for="customFile">Choose file</label>


</div>
</div>
 <div class="col  mt-2">
  <button type="submit" class="btn btn-primary ">Submit</button>
</div>
</div>

</form>

<h1 class="mt-2"><center>List of books</center></h1>
<table>
<thead>
<tr>
    <th> Edit</th>
<th> Title</th>
<th> Authors</th>
<th> Price</th>
<th> Genre</th>
<th> Delete</th>
</tr>

</thead>
<tbody>
<#list books as b>
<tr>
<td><a href="add/${b.id}">Edit</a></td>
<td>${b.name}</td>
<td><#list b.authors as a>${a}<#sep>,  </#list></td>
<td>${b.price}</td>
<td><#list b.genres as g >${g}<#sep>,  </#list></td>
<td><a href="del/${b.id}">Delete</a></td>
</tr>
</#list>
</tbody>
</table>




</@m.page>