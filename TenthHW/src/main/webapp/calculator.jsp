<%--
  Created by IntelliJ IDEA.
  User: КТ
  Date: 15.10.2023
  Time: 2:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="calculator" method="post" action="CalculatorServlet">
    <input type="text" name="expression" id="display" readonly value="${result}">
    <table>
        <tr>
            <td><input type="button" value="7" onclick="appendToDisplay('7')"></td>
            <td><input type="button" value="8" onclick="appendToDisplay('8')"></td>
            <td><input type="button" value="9" onclick="appendToDisplay('9')"></td>
            <td><input type="button" value="/" onclick="appendToDisplay('/')"></td>
        </tr>
        <tr>
            <td><input type="button" value="4" onclick="appendToDisplay('4')"></td>
            <td><input type="button" value="5" onclick="appendToDisplay('5')"></td>
            <td><input type="button" value="6" onclick="appendToDisplay('6')"></td>
            <td><input type="button" value="*" onclick="appendToDisplay('*')"></td>
        </tr>
        <tr>
            <td><input type="button" value="1" onclick="appendToDisplay('1')"></td>
            <td><input type="button" value="2" onclick="appendToDisplay('2')"></td>
            <td><input type="button" value="3" onclick="appendToDisplay('3')"></td>
            <td><input type="button" value="-" onclick="appendToDisplay('-')"></td>
        </tr>
        <tr>
            <td><input type="button" value="0" onclick="appendToDisplay('0')"></td>
            <td><input type="button" value="C" onclick="clearDisplay()"></td>
            <td><input type="button" value="=" onclick="calculateResult()"></td>
            <td><input type="button" value="+" onclick="appendToDisplay('+')"></td>
        </tr>
    </table>
</form>
<script>
    function appendToDisplay(value) {
        document.calculator.display.value += value;
    }

    function clearDisplay() {
        document.calculator.display.value = '';
    }

    function calculateResult() {
        document.calculator.submit();
    }
</script>
</body>
</html>
