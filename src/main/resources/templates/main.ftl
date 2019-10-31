    <#import "/spring.ftl" as spring/>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
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
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">

                <li class="nav-item">
                    <a class="nav-link" href="/admin">Администратор</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/worker">Мастер</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/">Бухгалтер</a>
                </li>
            </ul>
        </div>
    </nav>



    </div>

    </body>
    </html>
