<%--  <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"--%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reset Password Page</title>
</head>
<body>
	<h2>Reset Password Page</h2>
	<form method ="POST" action="resetPassword" data-toggle="validator"/>
	<table>
                <tr>
                    <td>Enter New password :</td>
                    <td><input type=”password” name=”newpswd”/></td>
                </tr>
                <tr>
                    <td>Enter Confirm Password:  </td>
                    <td><input type=”password” name=”compswd” /></td>
                </tr>
                <tr>
                    <td><input type=”submit” value=”submit” />
                    <td><input type=”reset” value=”Cancel” />
                    </td>
                </tr>
            </table>
        </form>
</body>
</html>