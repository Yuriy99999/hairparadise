<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add new work</title>
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
        <legend>Add work</legend>
        <form name="work" action="" method="POST">

            <h3>work add GENERAL</h3>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon1">Worker:</span>
                </div>
                <@spring.formSingleSelect "workForm.worker", mavs, "class='form-control'"/>
            </div>

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon1">Customer:</span>
                </div>
                <@spring.formSingleSelect "workForm.customer", mavs1, "class='form-control'"/>
            </div>

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon1">date:</span>
                </div>
                <@spring.formInput "workForm.date" "class='form-control' readonly  width='276'" "text"/>
                <script>
                    $('#date').datepicker({uiLibrary: 'bootstrap4'});
                </script>
            </div>

         <#--   <@spring.formInput "workForm.date" "" "text"/>
            <script>
                $('#date').datepicker({
                    uiLibrary: 'bootstrap4'
                });
            </script>
            -->

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon1">Time:</span>
                </div>
                <@spring.formInput "workForm.time" "class='form-control'" "text"/>
            </div>


            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon1">Haircut:</span>
                </div>
                <@spring.formSingleSelect "workForm.haircut", mavs2, "class='form-control'"/>
            </div>

            <br>

            <script>

            </script>
            <br>
            <input type="submit" class="btn btn-primary" value="Create"/>
        </form>
    </fieldset>
</div>

</body>
</html>
