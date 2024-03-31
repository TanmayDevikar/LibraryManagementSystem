
<html>
<head>
<style type="text/css">
.heading {
align-text: centre;
color: white;
    font-family: sans-serif;
    font-size: 50px;
    padding-top: 100px;
    opacity: 0;
}
.back{
background-size: 100%;
width: 100%;
height: 100%;
text-color: white;
text-align: center;
}
.box{
    background-color: white;
    width: 280px;
    height: 280px;
    margin-left: 39%;
    border-radius: 13px;
    margin-top: 3%;
}
.text{
height: 27px;
    width: 190px;
    border: 0;
    background-color: aliceblue;
    }
    .button {
     margin: -25px 0;
    background: white;
    border: 1px solid;
    border-radius: 8px;
    padding: 4px 18px;
    font-size: 15px;
    margin-top: -35px;
    }
</style>
<title>Borrow a book</title>
</head>
<body>
<div class="back" style="background-image: url('https://i.pinimg.com/originals/67/18/22/671822c2f63dd5f65d8fd15c9710420b.jpg');">
<h2 class="heading">Library Management System</h2>
<div class="box">
<h2 style="
    padding-top: 40px;
    padding-bottom: 20px;
">Borrow a Book</h2>

<form action = "borrow2Servlet" method="get">
   <input type="text" name="bookId"class="text" placeholder="Book ID"/> <br/><br/><br/><br/><br/>
   <input type="submit" class="button" value="ADD"/>
</form>
</div>
</div>
</body>
</html>