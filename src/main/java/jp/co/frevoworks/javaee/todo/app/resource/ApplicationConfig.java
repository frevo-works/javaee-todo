/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.frevoworks.javaee.todo.app.resource;

import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author h.ono
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends ResourceConfig {
    
    public ApplicationConfig() {
        packages(this.getClass().getPackage().getName());
    }
}
