<#import "parts/main.fmt" as m>


<@m.page>


<form method="post" action="/add">
  <div class="row">
    <div class="col mt-2">
      <input type="text" class="form-control" placeholder="Book name" name="title" >
    </div>
    <div class="col">
      <input type="text" class="form-control" placeholder="Price" name="price" >
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
           <input type="text" class="form-control" placeholder="Pls input authors through ," name="authors" >
            </div>


      </div>



  <button type="submit" class="btn btn-primary mt-3">Submit</button>
</form>

<h1>List of books</h1>
<table>
<thead>
<tr>
<th>Edit</th>
<th>Title</th>
<th>Authors</th>
<th>Price</th>
<th>Genre</th>
<th>Delete</th>
</tr>

</thead>
<tbody>
<#list books as b>
<tr>
<td><a href="add/${b.id}">Edit</a></td>
<td>${b.name}</td>
<td><#list b.authors as a>${a.name}<#sep>,  </#list></td>
<td>${b.price}</td>
<td><#list b.genres as g >${g}<#sep>,  </#list></td>
<td><a href="del/${b.id}">Delete</a></td>
</tr>
</#list>
</tbody>
</table>




</@m.page>