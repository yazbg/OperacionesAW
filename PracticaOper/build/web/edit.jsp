<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Persona</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            max-width: 500px;
            width: 100%;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }
        .form-group input[type="submit"] {
            background-color: #008CBA;
            color: white;
            border: none;
            cursor: pointer;
        }
        .form-group input[type="submit"]:hover {
            background-color: #007BB5;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Editar Persona</h2>
        <form action="ServletUniversidad" method="post">
            <input type="hidden" name="id" value="${persona.id}">

            <div class="form-group">
                <label for="nif">NIF:</label>
                <input type="text" id="nif" name="nif" value="${persona.nif}">
            </div>
            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" id="nombre" name="nombre" value="${persona.nombre}">
            </div>
            <div class="form-group">
                <label for="apellido1">Apellido1:</label>
                <input type="text" id="apellido1" name="apellido1" value="${persona.apellido1}">
            </div>
            <div class="form-group">
                <label for="apellido2">Apellido2:</label>
                <input type="text" id="apellido2" name="apellido2" value="${persona.apellido2}">
            </div>
            <div class="form-group">
                <label for="ciudad">Ciudad:</label>
                <input type="text" id="ciudad" name="ciudad" value="${persona.ciudad}">
            </div>
            <div class="form-group">
                <label for="direccion">Dirección:</label>
                <input type="text" id="direccion" name="direccion" value="${persona.direccion}">
            </div>
            <div class="form-group">
                <label for="telefono">Teléfono:</label>
                <input type="text" id="telefono" name="telefono" value="${persona.telefono}">
            </div>
            <div class="form-group">
                <label for="fecha_nacimiento">Fecha de Nacimiento:</label>
                <input type="date" id="fecha_nacimiento" name="fecha_nacimiento" value="${persona.fechaNacimiento}">
            </div>
            <div class="form-group">
                <label for="sexo">Sexo:</label>
                <input type="text" id="sexo" name="sexo" value="${persona.sexo}">
            </div>
            <div class="form-group">
                <label for="tipo">Tipo:</label>
                <input type="text" id="tipo" name="tipo" value="${persona.tipo}">
            </div>

            <input type="hidden" name="action" value="update">
            <div class="form-group">
                <input type="submit" value="Actualizar">
            </div>
        </form>
    </div>
</body>
</html>