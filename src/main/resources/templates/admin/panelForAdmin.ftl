<#macro page title>
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
           <#-- <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>-->
            <li class="nav-item">
                <a class="nav-link" href="/admin/work/list/">Записи</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/customer/list">Клиенты</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" >Расписание</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" >Финансы</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" >Финансы</a>
            </li>
        </ul>
    </div>
</nav>

  <#nested/>

</div>

</body>
</html>
</#macro>