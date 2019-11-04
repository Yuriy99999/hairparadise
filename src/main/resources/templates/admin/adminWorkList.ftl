<#import "panelForAdmin.ftl" as c />
<@c.page title = "workerForm">
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>work list</title>
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


                <th>aCustomer name</th>
                <th>aCustomer surname</th>
                <th>aWork Code</th>
                <th>aDate</th>
                <th>aTime</th>
                <th>aWork</th>
                <th>aWorker name</th>
                <th>aWorker surname</th>
                <th>aPrice</th>
                <th>aStatus</th>

                <#--<th>Delete</th>
                <th>Edit</th>-->


            </tr>

            <#list works as work>
                <tr>
                    <td>${work.customer.name}</td>
                    <td>${work.customer.surname}</td>
                    <td>${work.code}</td>
                    <td>${work.date}</td>
                    <td>${work.time}</td>
                    <td>${work.haircut.name}</td>
                    <td>${work.worker.name}</td>
                    <td>${work.worker.surname}</td>
                    <td>${work.haircut.cost}</td>
                    <td>${work.status}</td>


                  <#--  <td><a href="/work/delete/${work.id}"/>delete</td>
                    <td><a href="/work/update/${work.id}" type = "button" class = "btn btn - success"/>edit</td>-->

                </tr>
            </#list>

        </table>

    </div>

    <#--<a href="/work/create">create new work</a>-->

</div>

</body>
</html>
</@c.page>
