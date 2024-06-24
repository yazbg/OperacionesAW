package mrysi.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import mrysi.beans.Universidad;
import mrysi.daos.UniversidadDAOImp;

public class ServletUniversidad extends HttpServlet {

    private UniversidadDAOImp universidadDAO;

    @Override
    public void init() throws ServletException {
        universidadDAO = new UniversidadDAOImp();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action == null ? "list" : action) {
                case "create":
                    createPersona(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updatePersona(request, response);
                    break;
                case "delete":
                    deletePersona(request, response);
                    break;
                case "list":
                default:
                    listPersonas(request, response);
                    break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ServletException("Error accediendo a la base de datos.", ex);
        }
    }

    private void listPersonas(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List<Universidad> listapersonas = universidadDAO.readAll();
        request.setAttribute("Listapersonas", listapersonas);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    private void createPersona(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Universidad universidad = new Universidad();
        universidad.setNif(request.getParameter("nif"));
        universidad.setNombre(request.getParameter("nombre"));
        universidad.setApellido1(request.getParameter("apellido1"));
        universidad.setApellido2(request.getParameter("apellido2"));
        universidad.setCiudad(request.getParameter("ciudad"));
        universidad.setDireccion(request.getParameter("direccion"));
        universidad.setTelefono(request.getParameter("telefono"));
        universidad.setFechaNacimiento(request.getParameter("fecha_nacimiento"));
        universidad.setSexo(request.getParameter("sexo"));
        universidad.setTipo(request.getParameter("tipo"));

        universidadDAO.insert(universidad);
        response.sendRedirect("ServletUniversidad?action=list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Universidad persona = universidadDAO.read(id);
        request.setAttribute("persona", persona);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        dispatcher.forward(request, response);
    }

    private void updatePersona(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Universidad universidad = new Universidad();
        universidad.setId(id);
        universidad.setNif(request.getParameter("nif"));
        universidad.setNombre(request.getParameter("nombre"));
        universidad.setApellido1(request.getParameter("apellido1"));
        universidad.setApellido2(request.getParameter("apellido2"));
        universidad.setCiudad(request.getParameter("ciudad"));
        universidad.setDireccion(request.getParameter("direccion"));
        universidad.setTelefono(request.getParameter("telefono"));
        universidad.setFechaNacimiento(request.getParameter("fecha_nacimiento"));
        universidad.setSexo(request.getParameter("sexo"));
        universidad.setTipo(request.getParameter("tipo"));

        universidadDAO.update(universidad);
        response.sendRedirect("ServletUniversidad?action=list");
    }

    private void deletePersona(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        universidadDAO.delete(id);
        response.sendRedirect("ServletUniversidad?action=list");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet para manejar operaciones CRUD en la tabla persona";
    }
}