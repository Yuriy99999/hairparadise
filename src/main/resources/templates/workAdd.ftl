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

<div>
    <fieldset>
        <legend>Add work</legend>
        <form name="work" action="" method="POST">

            <br>Worker:<@spring.formSingleSelect "workForm.worker", mavs,""/>
            <br>Customer:<@spring.formSingleSelect "workForm.customer", mavs1,""/>
            <br>
            <@spring.formInput "workForm.date" "" "text"/>
            <script>
                $('#date').datepicker({
                    uiLibrary: 'bootstrap4'
                });
            </script>
            <br>
            <br>Time:<@spring.formInput "workForm.time" "" "text"/>
            <br>Haircut:<@spring.formSingleSelect "workForm.haircut", mavs2,""/>
            <br>Status:<@spring.formInput "workForm.status" "" "text"/>



            <br>

            <script>

            </script>
            <br>
            <input type="submit" value="Create"/>
        </form>
    </fieldset>
</div>

</body>
</html>
