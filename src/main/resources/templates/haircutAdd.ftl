<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <#--<title>Add new customer</title>-->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />

    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>

    <style type="text/css">
        html, body {
            height: 100%;
        }
        body {
            background-image: url('http://getwallpapers.com/wallpaper/full/d/b/0/272602.jpg');
            background-size: cover;
            background-repeat: no-repeat;
            background-position: center;
            background-attachment: fixed;
        }
    </style>
</head>
<body>

<div class = "container">
    <fieldset>
        <legend>Add haircut</legend>
        <form name="haircutAdd" action="" method="POST">
            <#--name:<@spring.formInput "customerForm.name" "" "text"/>-->
            <#--  <h3>wCustomer Add in worker</h3>-->

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon1">Name:</span>
                </div>
                <@spring.formInput "haircutForm.name" "class='form-control'" "text"/>
            </div>

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon1">Gender:</span>
                </div>
                <@spring.formSingleSelect "haircutForm.gender", genders, "class='form-control'"/>
            </div>

            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon1">Price:</span>
                </div>
                <@spring.formInput "haircutForm.cost" "class='form-control'" "text"/>
            </div>




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
