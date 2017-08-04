<%--  <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"--%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> --%>
<meta http-equiv="Content-Type" content="text/html" ; charset=UTF-8">
<title>Reset Password Page</title>
</head>
<body>
	<h2>Reset Password Page</h2>
	<form method ="POST" action="/demo/resetPassword" data-toggle="validator"/>
	<table>
                <tr>
                    <td>Enter New password :</td>
                    <!-- <td><input type=”password” name=”newpswd”/></td> -->
                    <td><input type="password" pattern="[A-Za-z0-9@#$%!^&*]{6,30}" name="inputPassword" class="form-control" id="inputPassword" placeholder="Enter New Password" 
                    data-error="Password should not be null. It should be greater than 6 and less than 30 characters . Use only A-Z, a-z, 0-9, @ # $ % ! ^ & * charecters" required/>
                    </td>
                </tr>
                
                <tr>
                    <td>Enter Confirm Password:  </td>
                    <td><input type ="password" name ="inputPassword1" class="form-control" id="inputPassword1" data-match="#inputPassword" 
                    placeholder="Enter New Password Again" 
	 data-error="It should not be null and should match with above password" required/></td>
                </tr>
                
                <tr>
                    <td><input type="hidden" name="password" value= <%=request.getParameter("inputPassword")%>/></td>
                    <td><input type="hidden" name="password1" value= <%=request.getParameter("inputPassword1")%>/></td>
                	<td><input type="hidden" name="token" value= <%=request.getParameter("token")%>/></td>
                </tr>
                
                <tr>
                    <td><input type ="submit" value="Submit"/>
                   <%-- <td><<button style="width:20%" type="submit "value=”Cancel” /> --%>
                    </td>
                </tr>
            </table>
        </form>
</body>
</html>