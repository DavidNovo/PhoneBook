package com.dwbook.phonebook.db.mappers;

import com.dwbook.phonebook.api.Contact;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by davidnovogrodsky_wrk on 12/5/16.
 */
public class ContactMapper implements ResultSetMapper<Contact> {
    /**
     * This method maps a result set from the database to a Contact POJO.
     *
     * @param index
     * @param r
     * @param ctx
     * @return
     * @throws SQLException
     */
    public Contact map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Contact(r.getInt("id"), r.getString("firstName"),
                r.getString("lastName"), r.getString("phone"));
    }
}

