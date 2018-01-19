package jp.co.frevoworks.javaee.todo.app.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * 例外クラスマッパー.
 *
 * @author DCOM
 */
@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {

        try {
            int code;
            String message;
            if (e instanceof WebApplicationException) {
                WebApplicationException wae = (WebApplicationException) e;
                code = wae.getResponse().getStatus();
                message = e.getMessage();
            } else {
                code = Status.INTERNAL_SERVER_ERROR.getStatusCode();
                message = e.getMessage();
            }

            Map<String, Object> result = new HashMap<>();
            result.put("code", code);
            result.put("message", message);

            return Response
                    .status(code)
                    .type(MediaType.APPLICATION_JSON)
                    .entity(new ObjectMapper().writeValueAsString(result))
                    .build();
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(e);
        }
    }
}
