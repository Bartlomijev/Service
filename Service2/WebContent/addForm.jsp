<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Form</title>
</head>
<body>
<h1>Podaj dane sprzętu: </h1>
    <form action="InputServlet">

        Nazwa sprzętu: <br>
        <input type="text" name="deviceName"><br>
        Imię i nazwisko klienta:<br>
       <input type="text" name="clientName"><br>
        Adres klienta: <br>
        <input type="text" name="clientAddress"><br>
        <br>	
         <input type="submit" value="Wyślij"><br>
    </form>
    
   <a href="index.jsp">powrót do strony głównej</a> <br>
</body>
</html>