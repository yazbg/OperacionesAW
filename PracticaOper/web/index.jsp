<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Personas</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 1200px;
            margin: 50px auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: #333;
        }
        .add-persona {
            display: block;
            width: 200px;
            margin: 20px auto;
            padding: 10px;
            text-align: center;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }
        .add-persona:hover {
            background-color: #45a049;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .action-links a {
            margin-right: 10px;
            color: #008CBA;
            text-decoration: none;
        }
        .action-links a:hover {
            text-decoration: underline;
        }
        .delete-form {
            display: inline;
        }
        .delete-form input[type="submit"] {
            background: none;
            border: none;
            color: #f44336;
            padding: 0;
            cursor: pointer;
            text-decoration: underline;
        }
        .delete-form input[type="submit"]:hover {
            color: #e53935;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Personas Listadas</h2>
        <a class="add-persona" href="new.jsp">Agregar Nueva Persona</a>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>NIF</th>
                    <th>Nombre</th>
                    <th>Apellido 1</th>
                    <th>Apellido 2</th>
                    <th>Ciudad</th>
                    <th>Dirección</th>
                    <th>Teléfono</th>
                    <th>Fecha de Nacimiento</th>
                    <th>Sexo</th>
                    <th>Tipo</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${Listapersonas}" var="persona">
                    <tr>
                        <td><c:out value="${persona.id}" /></td>
                        <td><c:out value="${persona.nif}" /></td>
                        <td><c:out value="${persona.nombre}" /></td>
                        <td><c:out value="${persona.apellido1}" /></td>
                        <td><c:out value="${persona.apellido2}" /></td>
                        <td><c:out value="${persona.ciudad}" /></td>
                        <td><c:out value="${persona.direccion}" /></td>
                        <td><c:out value="${persona.telefono}" /></td>
                        <td><c:out value="${persona.fechaNacimiento}" /></td>
                        <td><c:out value="${persona.sexo}" /></td>
                        <td><c:out value="${persona.tipo}" /></td>
                        <td class="action-links">
                            <a href="ServletUniversidad?action=edit&id=${persona.id}">Editar</a>
                            <form class="delete-form" action="ServletUniversidad" method="post">
                                <input type="hidden" name="action" value="delete">
                                <input type="hidden" name="id" value="${persona.id}">
                                <input type="submit" value="Borrar">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>