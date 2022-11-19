package com.example.socialmedia2.base;

import com.example.socialmedia2.exceptions.BadRequestException;
import com.example.socialmedia2.exceptions.NotFoundExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class BaseServiceImpl<T extends BaseEntity<ID>, ID extends Serializable,
        R extends BaseRepository<T, ID>> implements BaseService<T, ID> {

    protected final R repository;

    @Override
    @Transactional
    public T saveOrUpdate(T t) {
        if (t.getId() == null) {
            t = repository.save(t);
            return t;
        } else if (t.getId() != null) {
            t = repository.save(t);
        }
        throw new BadRequestException("this your want is bad request");
    }

    @Override
    public void deleteById(ID id) {
        T t = findById(id);
        if (t.getId() == null) {
            throw new NotFoundExceptions("your entity not found");
        } else
            repository.deleteById(t.getId());
    }

    @Override
    public void deleteEntity(T t) {
        repository.delete(t);
    }

    @Override
    public T findById(ID id) {
        Optional<T> t = repository.findById(id);
        if (t.isPresent()) {
            return repository.findById(id).get();
        } else
            throw new NotFoundExceptions("your entity not found");
    }

    @Override
    public List<T> findAll() {

        return repository.findAll();
    }
}
