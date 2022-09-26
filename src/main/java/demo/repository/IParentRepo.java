package demo.repository;

import java.util.List;

public interface IParentRepo {

    List<Object> fetchAll();
    Object fetchById(long id);
    boolean save(Object obj);
    boolean update(String name, long id);
    boolean delete(long id);

}
