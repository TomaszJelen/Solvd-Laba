package solvd.laba.library.service;


import solvd.laba.library.idao.IDaoBookshelf;
import solvd.laba.library.idao.IDaoComputer;
import solvd.laba.library.idao.IDaoRoom;
import solvd.laba.library.model.Bookshelf;
import solvd.laba.library.model.Computer;
import solvd.laba.library.model.Room;
import solvd.laba.library.sql.SqlDaoBookshelf;
import solvd.laba.library.sql.SqlDaoComputer;
import solvd.laba.library.sql.SqlDaoRoom;

import java.sql.SQLException;
import java.util.List;

public class RoomService {
    IDaoRoom daoRoom =  new SqlDaoRoom();
    IDaoComputer daoComputer =  new SqlDaoComputer();
    IDaoBookshelf daoBookshelf =  new SqlDaoBookshelf();
    public Long createRoom(Room entity) throws SQLException, InterruptedException {
        return daoRoom.create(entity).getId();
    }
    public Room readRoom(Long id) throws SQLException, InterruptedException {
        Room room = daoRoom.read(id);
        for (Computer computer : daoComputer.readByRoom(room.getId())) {
            room.getComputers().add(computer);
        }
        for (Bookshelf bookshelf : daoBookshelf.readByRoom(room.getId())) {
            room.getBookshelves().add(bookshelf);
        }
        return room;
    }
    public List<Room> readRooms() throws SQLException, InterruptedException {
        List<Room> rooms = daoRoom.readAll();
        for (Room room : rooms) {
            for (Computer computer : daoComputer.readByRoom(room.getId())) {
                room.getComputers().add(computer);
            }
            for (Bookshelf bookshelf : daoBookshelf.readByRoom(room.getId())) {
                room.getBookshelves().add(bookshelf);
            }
        }
        return rooms;
    }
    public Room updateRoom(Room entity) throws SQLException, InterruptedException {
        Room room = daoRoom.update(entity);
        for (Computer computer : daoComputer.readByRoom(room.getId())) {
            daoComputer.remove(computer.getId());
        }
        for (Bookshelf bookshelf : daoBookshelf.readByRoom(room.getId())) {
            daoBookshelf.remove(bookshelf.getId());
        }
        for (Computer computer : entity.getComputers()) {
            computer.setRoomId(entity.getId());
            daoComputer.create(computer);
        }
        for (Bookshelf bookshelf : entity.getBookshelves()) {
            bookshelf.setRoomId(entity.getId());
            daoBookshelf.create(bookshelf);
        }
        return room;
    }
    public Long removeRoom(Long id) throws SQLException, InterruptedException {
        for (Computer computer : daoComputer.readByRoom(id)) {
            daoComputer.remove(computer.getId());
        }
        for (Bookshelf bookshelf : daoBookshelf.readByRoom(id)) {
            daoBookshelf.remove(bookshelf.getId());
        }
        return daoRoom.remove(id);
    }
}
