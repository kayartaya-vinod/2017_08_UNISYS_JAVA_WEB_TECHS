<%@ include file="header.txt" %>
<h3>Login required!</h3>
<form action="login" method="POST">
  <div class="form-group">
    <label for="username">Username</label>
    <input type="text" class="form-control" id="username" name="username" placeholder="Enter username">
  </div>
  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" class="form-control" id="password" name="password" placeholder="Enter the secret code">
  </div>

  <button type="submit" class="btn btn-default">Login</button>
</form>
<%@ include file="footer.txt" %>