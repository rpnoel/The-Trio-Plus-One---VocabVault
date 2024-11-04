package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;


import org.junit.Test;
import model.DataLoader;
import model.UserList;
import model.User;

public class DataLoaderTest {
    UserList userList = UserList.getInstance();
     @Test
    public void testTesting(){
        assertTrue(true);
    }

    @Test
    public void testUserParse(){
        assertEquals("Tammy", userList.getUser("ttomacka").getFirstName());
    }

    @Test
    public void TestUserCount(){
        int expectedUserCount = 3; 
        ArrayList<User> users = userList.getUsers(); 
    }
}