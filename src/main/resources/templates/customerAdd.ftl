<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add new customer</title>
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
        <legend>Add customer</legend>
        <form name="customer" action="" method="POST">
            <#--name:<@spring.formInput "customerForm.name" "" "text"/>-->
            <br>Name:<@spring.formInput "customerForm.name" "" "text"/>
            <br>Surname:<@spring.formInput "customerForm.surname" "" "text"/>
            <br>Patronimic:<@spring.formInput "customerForm.patronimic" "" "text"/>
            <br>Phone:<@spring.formInput "customerForm.phoneNumber" "" "text"/>
            <br>Gender:<@spring.formSingleSelect "customerForm.gender", genders,""/>


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
