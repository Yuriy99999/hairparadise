<#import "./panels/panelForWorker.ftl" as c />
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
</head>
<body>
<div class="container">
    <h3>work list</h3>
    <br>
    <div>

        <table class="table table-striped table-dark">

            <tr class="bg-warning">


                <th>Customer name</th>
                <th>Customer surname</th>
                <th>Work Code</th>
                <th>Date</th>
                <th>Time</th>
                <th>Work</th>
                <th>Worker name</th>
                <th>Worker surname</th>
                <th>Price</th>
                <th>Status</th>

                <th>Delete</th>
                <th>Edit</th>


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


                    <td><a href="/work/delete/${work.id}"/>delete</td>
                    <td><a href="/work/update/${work.id}" type = "button" class = "btn btn - success"/>edit</td>

                </tr>
            </#list>

        </table>

    </div>

    <a href="/work/create">create new work</a>

</div>

</body>
</html>
</@c.page>