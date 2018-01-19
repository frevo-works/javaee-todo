package jp.co.frevoworks.javaee.todo.app.resource;

import java.util.List;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;
import jp.co.frevoworks.javaee.todo.domain.model.Todo;
import jp.co.frevoworks.javaee.todo.domain.service.TodoService;

/**
 * REST Web Service
 *
 * @author frevoworks
 */
@Path("todo")
@RequestScoped
public class TodoResource {

    @Context
    private UriInfo context;

    @Inject
    private TodoService todoService;

    @Inject
    private Validator validator;

    public TodoResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Todo> get() {
        return todoService.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Todo get(@PathParam("id") Integer id) {
        Todo entity = todoService.find(id);
        if (entity == null) {
            throw new WebApplicationException("データがありません。", Status.NOT_FOUND);
        }

        return entity;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Todo post(Todo todo) {
        Set<ConstraintViolation<Todo>> errors = validator.validate(todo);
        if (!errors.isEmpty()) {
            throw new WebApplicationException("入力エラーがあります", Status.BAD_REQUEST);
        }
        todoService.create(todo);
        return todo;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Todo put(@PathParam("id") Integer id, Todo todo) {

        Todo entity = todoService.find(id);

        if (entity == null) {
            throw new WebApplicationException("更新データがありません。", Status.NOT_FOUND);
        }

        Set<ConstraintViolation<Todo>> errors = validator.validate(todo);
        if (!errors.isEmpty()) {
            throw new WebApplicationException("入力エラーがあります", Status.BAD_REQUEST);
        }

        todoService.update(todo);
        return todo;
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") Integer id) {
        this.todoService.delete(id);
    }
}
