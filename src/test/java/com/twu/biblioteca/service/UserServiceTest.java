package com.twu.biblioteca.service;

import com.twu.biblioteca.Reader;
import com.twu.biblioteca.Writer;
import com.twu.biblioteca.model.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    public List<User> userList() {
        User firstUser = new User("password1", "111-1111");
        User secondUser = new User("password2", "222-2222");
        User thirdUser = new User("password3", "333-3333");

        List<User> userList = Arrays.asList(firstUser, secondUser, thirdUser);

        return userList;
    }

    @Test
    public void loginInUser() {
        Reader reader = mock(Reader.class);
        Writer writer = mock(Writer.class);

        UserService userService = new UserService(userList(), reader, writer);

        when(reader.nextLine()).thenReturn("111-1111", "password1");
        User user = userService.login();

        assertThat(user.getLibraryNumber(), is("111-1111"));
        assertThat(user.getPassword(), is("password1"));
    }
}