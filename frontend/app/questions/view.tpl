<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h1>Page with 2 panels</h1>

  <div class="row">
    <div class="col-xs-5" style="background-color:lightgray;">
      <div ng-view>

<div class="panel panel-default" >
        <div class="panel-body" style="background-color: lightgray;">

                                                          </div>
</div>
</div>
    </div>

<div class="col-xs-1" style="background-color:lightgray;">

    </div>
    <div class="col-xs-5" style="background-color:lightgray;" width="">
     <div ng-view>
<div class="panel panel-default">
<div class="panel-body" style="background-color: lightgray;">

     </div>
     </div>
</div>
    </div>
  </div>
</div>

</body>
</html>

