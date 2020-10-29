<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js" integrity="sha384-LtrjvnR4Twt/qOuYxE721u19sVFLVSA4hf/rRt6PrZTmiPltdZcI7q7PXQBYTKyf" crossorigin="anonymous"></script>
    <title>SMS Sender</title>
</head>
<body style="text-align:center">
    <br>
    <br>
    <h2>Welcome</h2>
    <br>
    <br>
    ${msg}
    <br>
    <br>
    <p>* Message not more than 100 letters </p>
    <p>* Phone Number Ex- 01818112233 (11 digits) </p>
    <br>
    <form class="form-inline" style="padding-left:400px;" action="/sendMessage" method="POST">
      <div class="form-group mx-sm-3 mb-2">
          <input type="text" name="message" class="form-control" minlength="2" maxlength="100" placeholder="your message" required>
        </div>
      <div class="form-group mx-lg-3 mb-2">
        <input type="text" name="phone" class="form-control" minlength="11"  placeholder="phone number" required>
      </div>
      <button type="submit" class="btn btn-primary mb-2">Send  Message</button>
    </form>
    <br>
    <br>
    <br>
    <br>
    <h4 style="color:green;">Developed by <a href="https://www.facebook.com/sohanbappy1510/">SohanBappy</a></h4>
</body>
<footer>

</footer>
</html>