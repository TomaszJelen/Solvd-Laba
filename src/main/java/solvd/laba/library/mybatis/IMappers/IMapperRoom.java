package solvd.laba.library.mybatis.IMappers;

import solvd.laba.library.idao.IDaoRoom;
import solvd.laba.library.model.Room;

public interface IMapperRoom extends IDaoRoom {
    Long insert(Room entity);
    Long change(Room entity);

}
