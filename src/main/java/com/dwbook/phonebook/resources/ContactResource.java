package com.dwbook.phonebook.resources;

import com.dwbook.phonebook.api.Contact;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by davidnovogrodsky_wrk on 11/30/16.
 * <p>
 * This is a resource class.
 * <p>
 * A resource class is responsible for handling HTTP requests and
 * generating JSON responses.
 * <p>
 * This is also where I define the URIs I want to expose.
 * <p>
 * The @Produces defines the type of contact the URIs produce.
 * the @Path define a URI template.
 * <p>
 * Jersey will intercept every incoming HTTP
 * request and try to match it with the defined URI template in order
 * to find which resource class method to invoke.
 */
@Path("/contact")
@Produces(MediaType.APPLICATION_JSON)
public class ContactResource {

    /**
     * @param id
     * @return Response
     * <p>
     * This method returns a contact with the given id.
     * This is mapped to HTTP GET, path /{id}
     */
    @GET
    @Path("/{id}")
    public Response getContact(@PathParam("id") int id) {
        // retrieve information about the contact with the provided id
        // ...

        // the happy path HTTP response codee is 200
        // build a response using JSON
        return Response
                .ok(new Contact(id, "John", "Doe", "1-220-345-6677"))
                .build();
    }

    /**
     * This method uses a representation to create a new contact.
     * <p>
     * The happy path of this method will return a 201 Created HTTP response
     * code alone with the URI of the newly created resource.
     * <p>
     * Since a representation is a parameter, Jersey will deserialize the
     * request body into  a Contact object
     *
     * @param contact
     * @return
     */
    @POST
    public Response createContact(Contact contact) {
        // store the new contact
        // ...
        return Response
                .created(null)
                .build();
    }

    /**
     * This method deletes a contact with the supplied id.
     * <p>
     * This method serves a representation through this resource class.
     *
     * @param id
     * @return
     */
    @DELETE
    @Path("/{id}")
    public Response deleteContact(@PathParam("id") int id) {
        // delete the contact with the provided id
        // ...

        // happy path, the HTTP response code will be 204 No Content
        return Response
                .noContent()
                .build();
    }

    /**
     * This method updates a contact with the supplied ID.
     * The new values are also supplied.
     * <p>
     * This method creates a representation through this resource class.
     * <p>
     * Since a representation is a parameter, Jersey will deserialize the
     * request body into  a Contact object
     *
     * @param id
     * @param contact
     * @return
     */
    @PUT
    @Path("/{id}")
    public Response updateContact(
            @PathParam("id") int id, Contact contact) {
        // update the contact with the provided ID
        // ...


        // the happy path is HTTP 200
        // Response.status(Status.MOVED_PERMANENTLY);
        return Response
                .ok(new Contact(id, contact.getFirstName(), contact.getLastName(), contact.getPhone()))
                .build();
    }
}
