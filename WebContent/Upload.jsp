<!DOCTYPE html>
<html lang="en">
<head>
  <title>Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <h2>Upload</h2>
  <form action="./upload" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <label for="file">File:</label>
      <input type="file" class="form-control" id="file" name="file">
    </div>
    <button type="submit" class="btn btn-default">Upload</button>
  </form>
</div>
</body>
</html>