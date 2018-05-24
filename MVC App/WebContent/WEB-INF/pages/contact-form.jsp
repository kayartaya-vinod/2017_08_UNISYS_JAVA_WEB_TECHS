<%@include file="header.txt" %>
<style>
	.err {
		color: red;
		font-style: italics;
	}
</style>
<h3 class="text-center">${pageTitle==null ? "Contact details" : pageTitle}</h3>

<form class="form-horizontal" action="save-contact" method="POST">
  <div class="form-group">
    <label for="firstname" class="col-sm-2 control-label">Firstname</label>
    <div class="col-sm-8">
      <input value="${contact.firstname}" type="text" class="form-control" name="firstname" id="firstname" placeholder="Firstname">
    	  <div class="err">${errors.firstname}</div>
    </div>
  </div>
  <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">Lastname</label>
    <div class="col-sm-8">
      <input value="${contact.lastname}" type="text" class="form-control" name="lastname" id="lastname" placeholder="Lastname">
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-2 control-label">Gender</label>
    <div class="col-sm-8">
      <label><input ${contact.gender=="Male"?"checked":"" } type="radio" name="gender" value="Male"> Male</label>
      <label><input ${contact.gender=="Female"?"checked":"" }  type="radio" name="gender" value="Female"> Female</label>
    </div>
  </div>
  <div class="form-group">
    <label for="dob" class="col-sm-2 control-label">Date of birth</label>
    <div class="col-sm-8">
      <input value="${contact.dob}" type="text" class="form-control" name="dob" id="dob" placeholder="Date of birth">
      <div class="err">${errors.dob}</div>
    </div>
  </div>
  <div class="form-group">
    <label for="email" class="col-sm-2 control-label">Email</label>
    <div class="col-sm-8">
      <input value="${contact.email}" type="email" class="form-control" name="email" id="email" placeholder="Email">
      <div class="err">${errors.email}</div>
    </div>
  </div>
  <div class="form-group">
    <label for="phone" class="col-sm-2 control-label">Phone number</label>
    <div class="col-sm-8">
      <input value="${contact.phone}" type="text" class="form-control" name="phone" id="phone" placeholder="Phone number">
      <div class="err">${errors.phone}</div>
    </div>
  </div>
  <div class="form-group">
    <label for="city" class="col-sm-2 control-label">City</label>
    <div class="col-sm-8">
      <input value="${contact.city}" type="text" class="form-control" name="city" id="city" placeholder="City">
    </div>
  </div>
  <div class="form-group">
    <label for="state" class="col-sm-2 control-label">State</label>
    <div class="col-sm-8">
      <input value="${contact.state}" type="text" class="form-control" name="state" id="state" placeholder="State">
    </div>
  </div>
  <div class="form-group">
    <label for="country" class="col-sm-2 control-label">Country</label>
    <div class="col-sm-8">
      <input value="${contact.country}" type="text" class="form-control" name="country" id="country" placeholder="Country">
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-8">
      <button type="submit" class="btn btn-success">
		${btnCaption==null ? "Submit" : btnCaption }
		</button>
    </div>
  </div>
  <input type="hidden" name="id" value="${contact.id}">
</form>
<script>
	$("#firstname").focus();
</script>
<%@include file="footer.txt" %>







