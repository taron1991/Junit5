package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class UserTest {

    private User user;
    private User user1;
    private User user2;

    @BeforeAll
    public void setUp() throws Exception {
        user = new User("Евгений", 35, Gender.MALE);
        user1 = new User("Марина", 34, Gender.FEMALE);
        user2 = new User("Алина", 7, Gender.FEMALE);
    }

    @Test
    public void getAllUsers() {
        //getAllUsers уже сформирован(в конструкторе)
        List<User> expected = User.getAllUsers();

        List<User> actual = new ArrayList<>();
        actual.add(user);
        actual.add(user1);
        actual.add(user2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getAllUsers_NO_NULL() {
        List<User> expected = User.getAllUsers();
        Assertions.assertNotNull(expected);
    }

    @Test
    public void getAllUsers_MALE() {
        List<User> expected = User.getAllUsers(Gender.MALE);

        List<User> actual = new ArrayList<>();
        actual.add(user);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getAllUsers_MALE_NO_NULL() {
        //добавим проверку на null
        List<User> expected = User.getAllUsers(Gender.MALE);
        Assertions.assertNotNull(expected);
    }

    @Test
    public void getAllUsers_FEMALE() {
        List<User> expected = User.getAllUsers(Gender.FEMALE);

        List<User> actual = new ArrayList<>();
        actual.add(user1);
        actual.add(user2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getAllUsers_FEMALE_NO_NULL() {
        //добавим проверку на null
        List<User> expected = User.getAllUsers(Gender.FEMALE);
        Assertions.assertNotNull(expected);
    }

    @Test
    public void getHowManyUsers() {
        int expected = User.getHowManyUsers();

        int actual = 3;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getHowManyUsers_MALE() {
        int expected = User.getHowManyUsers(Gender.MALE);

        int actual = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getHowManyUsers_FEMALE() {
        int expected = User.getHowManyUsers(Gender.FEMALE);

        int actual = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getAllAgeUsers() {
        int expected = User.getAllAgeUsers();

        int actual = 35 + 34 + 7;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getAllAgeUsers_MALE() {
        int expected = User.getAllAgeUsers(Gender.MALE);

        int actual = 35;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getAllAgeUsers_FEMALE() {
        int expected = User.getAllAgeUsers(Gender.FEMALE);

        int actual = 34 + 7;

        Assertions.assertEquals(expected, actual);
    }
}

