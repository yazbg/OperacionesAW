package mrysi.daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import mrysi.beans.ConexionMySQL;
import mrysi.beans.Universidad;

public class UniversidadDAOImp implements UniversidadDAO {

    private final String TABLE_NAME = "persona";
    private ConexionMySQL conMySQL;
    private Connection conn;

    public UniversidadDAOImp() {
        conMySQL = new ConexionMySQL();
    }

    @Override
    public void insert(Universidad universidad) throws SQLException {
        conn = conMySQL.getConnection();
        String query = "INSERT INTO " + TABLE_NAME + " (nif, nombre, apellido1, apellido2, ciudad, direccion, telefono, fecha_nacimiento, sexo, tipo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, universidad.getNif());
            ps.setString(2, universidad.getNombre());
            ps.setString(3, universidad.getApellido1());
            ps.setString(4, universidad.getApellido2());
            ps.setString(5, universidad.getCiudad());
            ps.setString(6, universidad.getDireccion());
            ps.setString(7, universidad.getTelefono());
            ps.setString(8, universidad.getFechaNacimiento());
            ps.setString(9, universidad.getSexo());
            ps.setString(10, universidad.getTipo());
            ps.executeUpdate();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    @Override
    public void update(Universidad universidad) throws SQLException {
        conn = conMySQL.getConnection();
        String query = "UPDATE " + TABLE_NAME + " SET nif = ?, nombre = ?, apellido1 = ?, apellido2 = ?, ciudad = ?, direccion = ?, telefono = ?, fecha_nacimiento = ?, sexo = ?, tipo = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, universidad.getNif());
            ps.setString(2, universidad.getNombre());
            ps.setString(3, universidad.getApellido1());
            ps.setString(4, universidad.getApellido2());
            ps.setString(5, universidad.getCiudad());
            ps.setString(6, universidad.getDireccion());
            ps.setString(7, universidad.getTelefono());
            ps.setString(8, universidad.getFechaNacimiento());
            ps.setString(9, universidad.getSexo());
            ps.setString(10, universidad.getTipo());
            ps.setInt(11, universidad.getId());
            ps.executeUpdate();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        conn = conMySQL.getConnection();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    @Override
    public Universidad read(Integer id) throws SQLException {
        Universidad universidad = null;
        conn = conMySQL.getConnection();
        String query = "SELECT id, nif, nombre, apellido1, apellido2, ciudad, direccion, telefono, fecha_nacimiento, sexo, tipo FROM " + TABLE_NAME + " WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    universidad = new Universidad();
                    universidad.setId(rs.getInt("id"));
                    universidad.setNif(rs.getString("nif"));
                    universidad.setNombre(rs.getString("nombre"));
                    universidad.setApellido1(rs.getString("apellido1"));
                    universidad.setApellido2(rs.getString("apellido2"));
                    universidad.setCiudad(rs.getString("ciudad"));
                    universidad.setDireccion(rs.getString("direccion"));
                    universidad.setTelefono(rs.getString("telefono"));
                    universidad.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                    universidad.setSexo(rs.getString("sexo"));
                    universidad.setTipo(rs.getString("tipo"));
                }
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return universidad;
    }

    @Override
    public List<Universidad> readAll() throws SQLException {
        List<Universidad> universidades = new ArrayList<>();
        conn = conMySQL.getConnection();
        String query = "SELECT id, nif, nombre, apellido1, apellido2, ciudad, direccion, telefono, fecha_nacimiento, sexo, tipo FROM " + TABLE_NAME;
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Universidad universidad = new Universidad();
                    universidad.setId(rs.getInt("id"));
                    universidad.setNif(rs.getString("nif"));
                    universidad.setNombre(rs.getString("nombre"));
                    universidad.setApellido1(rs.getString("apellido1"));
                    universidad.setApellido2(rs.getString("apellido2"));
                    universidad.setCiudad(rs.getString("ciudad"));
                    universidad.setDireccion(rs.getString("direccion"));
                    universidad.setTelefono(rs.getString("telefono"));
                    universidad.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                    universidad.setSexo(rs.getString("sexo"));
                    universidad.setTipo(rs.getString("tipo"));
                    universidades.add(universidad);
                }
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return universidades;
    }
}

