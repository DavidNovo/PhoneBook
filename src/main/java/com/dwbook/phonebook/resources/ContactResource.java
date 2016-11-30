package com.dwbook.phonebook.resources;

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
 *
 * This is also where I define the URIs I want to expose.
 *
 * The @Produces defines the type of contact the URIs produce.
 * the @Path define a URI template.
 *
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
     *
     * This method returns a contact with the given id.
     * This is mapped to HTTP GET, path /{id}
     */
    @GET
    @Path("/{id}")
    public Response getContact(@PathParam("id") int id) {
        // retrieve information about the contact with theprovided id
        // ...

        // build a response using JSON
        return Response
                .ok("{contact_id: " + id + ", name: \"Dummy Name\",phone: \"+0123456789\" }")
                .build();
    }

    /**
     *
     * This method uses the send name and phone to create a new contact.
     *
     * The happy path of this method will return a 201 Created HTTP response
     * code alone with the URI of the newly created resource.
     *
     * @param name
     * @param phone
     * @return
     *
     */
    @POST
    public Response createContact(
            @FormParam("name") String name,
            @FormParam("phone") String phone) {
        // store the new contact
        // ...
        return Response
                .created(null)
                .build();
    }

    /**
     * This method deletes a contact with the supplied id.
     *
     * @param id
     * @return
     */
    @DELETE
    @Path("/{id}")
    public Response deleteContact(@PathParam("id") int id) {
        // delete the contact with the provided id
        // ...

        // the HTTP response code will be 204 No Content
        return Response
                .noContent()
                .build();
    }

    /**
     * This method updates a contact with the supplied ID.
     * The new values are also supplied.
     *
     * @param id
     * @param name
     * @param phone
     * @return
     */
    @PUT
    @Path("/{id}")
    public Response updateContact(
            @PathParam("id") int id,
            @FormParam("name") String name,
            @FormParam("phone") String phone) {
        // update the contact with the provided ID
        // ...
        return Response
                .ok("{contact_id: "+ id +", name: \""+ name +"\",phone: \""+ phone +"\" }")
                .build();
    }
}
