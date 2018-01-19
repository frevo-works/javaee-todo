/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.frevoworks.javaee.todo.domain.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jp.co.frevoworks.javaee.todo.domain.model.Todo;

/**
 *
 * @author h.ono
 */
@Stateless
public class TodoService {

    @PersistenceContext
    protected EntityManager entityManager;

    public List<Todo> findAll() {
        return this.entityManager.createNamedQuery("Todo.findAll", Todo.class).getResultList();
    }

    public Todo find(Integer id) {
        return this.entityManager.find(Todo.class, id);
    }

    public void create(Todo todo) {
        this.entityManager.persist(todo);
    }

    public void update(Todo todo) {
        this.entityManager.merge(todo);
    }

    public void delete(int id) {
        Todo entity = find(id);
        this.entityManager.remove(entity);
    }
}
