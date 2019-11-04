<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Search by worker</title>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />

    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>

</head>
<body>

<div class="container" >

    <fieldset>
        <legend>Search by worker</legend>
        <form name="work" action="" method="POST">


            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon1">Worker:</span>
                </div>
                <@spring.formSingleSelect "workForm.worker", mavs, "class='form-control'"/>
            </div>


            <br>

            <script>

            </script>
            <br>
            <input type="submit" class="btn btn-primary" value="Search"/>
        </form>
    </fieldset>
</div>

</body>
</html>
