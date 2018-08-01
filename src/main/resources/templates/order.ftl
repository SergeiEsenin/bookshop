<#import "parts/order.fmt" as o>
<@o.order true>
<div class="col">
    <form   method="post">
        <h1>If you would like to buy pls write down your contacts</h1>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Name :</label>
            <div class="col-sm-6">
                <input type="text" name="buyerName" class="form-control"
                        placeholder="Name"/>

            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Quantity:</label>
            <div class="col-sm-6">
                <input type="number" name="quantity" class="form-control"
                       placeholder="Quantity"/>
            </div>
        </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Mobile number:</label>
                <div class="col-sm-6">
                    <input type="text" name="number"
                           class="form-control"
                           placeholder="Mob number" required/>
                </div>
            </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-primary" type="submit">Buy</button>
    </form>
</div>
</@o.order>