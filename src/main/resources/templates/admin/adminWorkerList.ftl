<#import "panelForAdmin.ftl" as c />
<@c.page title = "workerForm">
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>worker list</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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
<div>

    <br>
    <div>

        <table class="table table-striped">

            <tr class="thead-light">

                <th>Name</th>
                <th>Surname</th>
                <th>Delete</th>

            </tr>

            <#list workers as worker>
            <tr>
                <td>${worker.name}</td>
                <td>${worker.surname}</td>


                <td><a href="/admin/worker/delete/${worker.id}"/>delete</td>

            </tr>
        </#list>

        </table>

    </div>

    <a href="/worker/create">create new worker</a>

</div>

</body>
</html>
</@c.page>