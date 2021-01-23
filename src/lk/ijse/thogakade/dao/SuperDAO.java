package lk.ijse.thogakade.dao;

import lk.ijse.thogakade.entity.SuperEntity;

import java.io.Serializable;
import java.util.ArrayList;

public interface SuperDAO<Entity extends SuperEntity,ID extends Serializable> {
    public boolean add(Entity entity)throws Exception;
    public boolean update(Entity entity)throws Exception;
    public boolean delete(ID id)throws Exception;
    public Entity search(ID id)throws Exception;
    public ArrayList<Entity> getAll()throws Exception;
}
