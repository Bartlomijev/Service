<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List, pl.ComputerService.device.Device"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Table view</title>
</head>
<body>


    <h2>Lista urządzeń</h2>
    <table style="width:50%" border="1">
    <tr>
        <th>ID</th>
        <th>Nazwa</th>
         <th>Dane Klienta</th>
          <th>Adres</th>
           <th>Status naprawy</th>
    </tr>
    <%
   List<Device> devicesTable;
    devicesTable = (List<Device>)request.getAttribute("devicesTable");
   if(devicesTable != null)
	   for(Device dev: devicesTable){
   %> 
    <tr>
        <th><%= dev.getId() %></th>
        <th><%= dev.getDeviceName() %></th>
        <th><%= dev.getClientName() %></th>
        <th><%= dev.getAddress() %></th>
        <th><%= dev.isRepairStatus() %></th>
    </tr>
   
   <%
	   }
   %> 
   
   
    </table>
<br>
<a href="index.jsp">powrót do strony głównej</a> 
</body>

</html>