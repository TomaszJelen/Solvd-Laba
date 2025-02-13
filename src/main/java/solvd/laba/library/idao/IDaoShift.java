package solvd.laba.library.idao;

import solvd.laba.library.model.Shift;

import java.sql.SQLException;
import java.util.List;

public interface IDaoShift extends IDao<Shift> {
    List<Shift> readByLibrarian(Long librarianId);
}
