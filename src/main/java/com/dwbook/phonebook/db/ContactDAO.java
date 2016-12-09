package com.dwbook.phonebook.db;


import com.dwbook.phonebook.api.Contact;
import com.dwbook.phonebook.db.mappers.ContactMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 * Created by davidnovogrodsky_wrk on 12/5/16.
 *
 * These are the standard CRUD operations against a database.
 * None of these methods are attached to a URI or an HTTP verb.
 *
 * The resource calls these methods.
 *
 * This interface uses the http://jdbi.org/ library
 *
 */
public interface ContactDAO  {

    /**
     * This method retrieves contacts from the database.
     *
     * @param id
     * @return
     */
    @Mapper(ContactMapper.class)@SqlQuery("select * from contact where id = :id")Contact getContactById(@Bind("id") int id);


    /**
     * This method creates contacts using information passed to the method.
     *
     * The annotation @GetGeneratedKeys retrieves the generated key, or ID, of the newly created row.
     *
     * @param firstName
     * @param lastName
     * @param phone
     * @return
     */
    @GetGeneratedKeys
    @SqlUpdate("insert into contact (id, firstName, lastName, phone) values (NULL, :firstName, :lastName, :phone)")
    int createContact(@Bind("firstName") String firstName, @Bind("lastName") String lastName, @Bind("phone") String phone);


    /**
     * This method updates an existing contact.
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param phone
     */
    @SqlUpdate("update contact set firstName = :firstName, lastName = :lastName, phone = :phone where id = :id")
    void updateContact(@Bind("id") int id, @Bind("firstName") String firstName,
                       @Bind("lastName") String lastName,@Bind("phone") String phone);


    /**
     * this method deletes a contact with the given id.
     * @param id
     */
    @SqlUpdate("delete from contact where id = :id")
    void deleteContact(@Bind("id") int id);

}
