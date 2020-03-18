<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservation Not Available</title>
    </head>
    <body>
        Your reservation for ${exception.courtName} is not available on
    <fmt:formatDate value="${exception.date}" pattern="yyyy-MM-dd" /> at
    ${exception.hour}:00.
</body>
</html>
