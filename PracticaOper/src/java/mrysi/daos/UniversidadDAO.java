package mrysi.daos;

import java.sql.SQLException;
import java.util.List;
import mrysi.beans.Universidad;

public interface UniversidadDAO {
    void insert(Universidad universidad) throws SQLException;
    void update(Universidad universidad) throws SQLException;
    void delete(Integer id) throws SQLException;
    Universidad read(Integer id) throws SQLException;
    List<Universidad> readAll() throws SQLException;
}