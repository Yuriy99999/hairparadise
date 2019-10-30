<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>work list</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h3>admin</h3>
    <br>
    <td><a href="/work/list/" type = "button" class = "btn btn - success"/>Записи</td>
    <td><a href="/customer/list/" type = "button" class = "btn btn - success"/>Клиенты</td>
    <td><a  type = "button" class = "btn btn - success"/>Расписание</td>
    <td><a  type = "button" class = "btn btn - success"/>Финансы</td>
    <td><a href="/haircut/list/" type = "button" class = "btn btn - success"/>Услуги</td>

</div>

</body>
</html>