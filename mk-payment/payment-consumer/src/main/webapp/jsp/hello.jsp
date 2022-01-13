<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>标准jsp页面</title>
    <script src="${pageContext.request.contextPath}/static/js/template-web.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.8.3.js"></script>
</head>
<body>
<button onclick="welcome()" style="width: 400px;height: 200px;font-size: larger;margin: auto;">welcome~</button>

<script type="text/javascript">
    function welcome() {
        alert("欢迎~");
    }
</script>

</body>
</html>
