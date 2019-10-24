<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>worker list</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h3>worker list</h3>
    <br>
    <div>

        <table class="table table-striped table-dark">

            <tr class="bg-warning">


                <th>Id</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Delete</th>
                <th>Edit</th>


            </tr>

            <#list workers as worker>
            <tr>
                <td>${worker.id}</td>
                <td>${worker.name}</td>
                <td>${worker.surname}</td>

                <td><a href="/worker/delete/${worker.id}"/>delete</td>
                <td><a href="/worker/update/${worker.id}" type = "button" class = "btn btn - success"/>edit</td>

            </tr>
        </#list>

        </table>

    </div>

    <a href="/worker/create">create new work</a>

</div>

</body>
</html>