package ro.sda.eshop.repository;

import java.util.List;

public interface Repository <T> {
    T find(Long id);
    List<T> findAll();
    void save(T t);
    void saveAll(List<T> t);
    void delete(Long id);
}
