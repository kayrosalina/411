<html lang = "en">

<head>
    <meta charset="UTF-8">
    <title> Testing Status </title>
    <link rel="stylesheet" type="text/css" href="home.css">

    <%--navbar--%>
    <link href="https://fonts.googleapis.com/css?family=Quicksand:500" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script type="text/javascript">
        $(window).on('scroll', function(){
            if($(window).scrollTop()){ $('nav').addClass('black'); }
            else{ $('nav').removeClass('black'); }
        })
    </script>

    <%--piecharts--%>
    <script src="jquery.easypiechart.js"></script>
    <script>
        $(function(){
            $('.chart').easyPieChart({
                size: 200,
                barColor: '#000080',
                scaleColor: false,
                lineWidth: 12,
                trackColor: '#999999',
                lineCap: 'circle',
                animate: 3000,
            });
        });
    </script>

    <%--blocks--%>

</head>

    <body>
        <div class="wrapper">
            <nav>
                <div class="CyberSmart">CyberSmart</div>
                <ul>
                    <li><a href="/Test">Level Up</a></li>
                    <li><a href="/Test">Safety Tips</a></li>
                    <li><a href="/Test">Awards</a></li>
                    <li><a class="active" href="/Logout">LogOut</a></li>
                </ul>
            </nav>

            <section class="banner">
                <div class="container">
                    <h1>WELCOME TO CYBERSMART!</h1>
                    <h1>EVERYDAY TRAINING FOR A SMART WORKFORCE</h1>
                </div>
            </section>
        </div>


        <div class="container">
            <div class="box">
                <div class="container">
                    <h3>Current</h3>
                    <h3>Status</h3>
                </div>
            </div>
            <div class="box">
                <div class="chart" data-percent = "20"> 20% </div>
                <h2>E-mail</h2>
            </div>
            <div class="box">
                <div class="chart" data-percent = "40"> 40% </div>
                <h2>Password</h2>
            </div>
            <div class="box">
                <div class="chart" data-percent = "80"> 80% </div>
                <h2>Social Media</h2>
            </div>
        </div>



        <div class="xop-section">
            <ul class="xop-grid">
                <li>
                    <div class="xop-box xop-img">
                            <div class="xop-info">
                                <h3>GOALS</h3>
                                <p>Learn something new.</p>
                                <a class="active" href="/Test">VIEW NOTES</a>
                            </div>
                    </div>
                </li>
                <li>
                    <div class="xop-box xop-img">
                            <div class="xop-info">
                                <h3>DEADLINES</h3>
                                <p>Password: </p>
                                <p>E-mail: </p>
                                <p>Social Media: </p>
                                <a class="active" href="/Test">CONTINUE TESTING</a>
                            </div>

                    </div>
                </li>
                <li>
                    <div class="xop-box xop-img">
                            <div class="xop-info">
                                <h3>MOTIVATION</h3>
                                <p>If you don't try, you've already failed.</p>
                                <a class="active" href="/Test">PRINT CERTIFICATES</a>
                            </div>

                    </div>
                </li>
            </ul>
        </div>

<%--trophy--%>

        <%--<div class="content">--%>
            <%--<div class="trophy">--%>
                <%--<h3>MOST IMPROVED</h3>--%>
                <%--<p>Password Complexity</p>--%>
            <%--</div>--%>
            <%--<div class="anxious">--%>
                <%--<h3>MOST VULNERABLE</h3>--%>
                <%--<p>Social Media Tags</p>--%>
            <%--</div>--%>
        <%--</div>--%>

        <div class="row">
            <div class="column">
                <img src="trophy.PNG" style="width:70%">
            </div>
            <div class="column">
                <h5>MOST IMPROVED</h5>
                <p>Password Complexity</p>
            </div>
            <div class="column">
                <img src="anxious.jpg" style="width:70%">
            </div>
            <div class="column">
                <h5>MOST VULNERABLE</h5>
                <p>Social Media Tags</p>
            </div>
        </div>

    </body>
</html>