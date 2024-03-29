<#import "/spring.ftl" as spring/>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap DatePicker</title>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://unpkg.com/gijgo@1.9.11/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.11/css/gijgo.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="container">
    <h2>Date  picker</h2>
    <div class="row">
        <form name="dateForm" action="" method="POST">
            <div class="col-md-12">
               <!--<input id="date" width="270" />-->

                <br>Date:<@spring.formInput "dateForm.date", "class='from-control' readonly"/>
                <script>
                    $('#date').datepicker({
                        uiLibrary: 'bootstrap4'
                    });
                </script>
                <br/>

            </div>
            <div class="col-md-12">
                <input type="submit" class="btn btn-primary" value="Search"/>
            </div>
        </form>
    </div>
</div>

</body>
</html>