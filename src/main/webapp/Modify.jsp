
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
    width: 300px;
    height: 330px;
    margin-left: 39%;
    border-radius: 13px;
    margin-top: 3%;
}
.text{
    width: 190px;
    font-size: 20px;
    padding: 7px 3px;
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
<title>Modify</title>
<script>
function openPage(){
var selection = document.form.rb;

  if(selection[0].checked == true){
  window.location.replace("UpdateBook.jsp");
  }
  else if(selection[1].checked == true){
  window.location.replace("LoginFailed.jsp");
  }
  else if(selection[2].checked == true){
	  window.location.replace("LoginFailed.jsp");
  }
  else if(selection[3].checked == true){
	  window.location.replace("LoginFailed.jsp");
  }
  else if(selection[4].checked == true){
	  window.location.replace("LoginFailed.jsp");
  }
}
</script>
</head>
<body>
<div class="back" style="background-image: url('https://i.pinimg.com/originals/67/18/22/671822c2f63dd5f65d8fd15c9710420b.jpg');">
<h2 class="heading">Library Management System</h2>
<div class="box">
<h2 style="
    padding-top: 25px;
">Choose which document you want to modify:</h2>

<form name="form">
<input type="radio" name="rb" value="Books" onclick="openPage();"><span class="text">Books</span><br/>
<input type="radio" name="rb" value="Thesis" onclick="openPage();"><span class="text">Thesis</span><br/>
<input type="radio" name="rb" value="Technical Report" onclick="openPage();"><span class="text">Technical Report</span><br/>
<input type="radio" name="rb" value="Magazine" onclick="openPage();"><span class="text">Magazine</span><br/>
<input type="radio" name="rb" value="Journal" onclick="openPage();"><span class="text">Journal</span>
</form>
</div>
</div>

</body>
</html>