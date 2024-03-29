<#import "worker/panelForWorker.ftl" as c />
<@c.page title = "workerForm">

<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>haircut list</title>
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

                <th>Code</th>
                <th>Name</th>
                <th>gender</th>
                <th>cost</th>
                <th>Delete</th>
                <th>Edit</th>


            </tr>
            <#list haircuts as haircut>
                <tr>
                    <td>${haircut.code}</td>
                    <td>${haircut.name}</td>
                    <td>${haircut.gender}</td>
                    <td>${haircut.cost}</td>



                    <td><a href="/haircut/delete/${haircut.id}"/>delete</td>
                    <#--<td><a href="/haircut/update/${haircut.id}" type = "button" class = "btn btn - success"/>edit</td>-->

                </tr>
            </#list>

        </table>

    </div>

    <a href="/haircut/create">create new work</a>

</div>

</body>
</html>
</@c.page>