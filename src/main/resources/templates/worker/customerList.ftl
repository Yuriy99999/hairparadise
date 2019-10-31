<#import "panelForWorker.ftl" as c />
<@c.page title = "workerForm">

<#import "/spring.ftl" as spring/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>customer list</title>
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
    <div>
        <br>
        <table class="table table-striped">

            <tr class="thead-light">

                <th>Code</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Patronimic</th>
                <th>Phone</th>
                <th>gender</th>
                <#--<th>Regular</th>-->
                <th>Delete</th>
                <th>Edit</th>


            </tr>
            <#--<#assign regular = "">-->
            <#list customers as customer>

               <#-- <#if customer.isRegular == true>
                    <#assign regular = "da">
                <#else>
                    <#assign regular = "net">
                </#if>-->

                <tr>
                     <td>${customer.code}</td>
                    <td>${customer.name}</td>
                    <td>${customer.surname}</td>
                    <td>${customer.patronimic}</td>
                    <td>${customer.phoneNumber}</td>
                    <td>${customer.gender}</td>
                   <#-- <td>${regular}</td>-->

                    <td><a href="/customer/delete/${customer.id}"/>delete</td>
                    <td><a href="/customer/update/${customer.id}" type = "button" class = "btn btn - success"/>edit</td>

                </tr>
            </#list>

        </table>

    </div>

    <a href="/customer/create">create new customer</a>

</div>

</body>
</html>

</@c.page>