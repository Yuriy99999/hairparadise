<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>main</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h3>admin</h3>
    <br>
    <td><a href="/admin/" type = "button" class = "btn btn - success"/>Администратор</td>
    <td><a href="/worker/" type = "button" class = "btn btn - success"/>Мастер</td>
    <td><a  type = "button" class = "btn btn - success"/>Бухгалтер</td>


</div>

</body>
</html>