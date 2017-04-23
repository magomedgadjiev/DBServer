package models.user;

import java.util.List;
import javax.jws.soap.SOAPBinding;
import javax.sql.DataSource;

interface UserDAO {
    /**
     * This is the method to be used to initialize
     * database resources ie. connection.
     */

    public void createTable();

    public void  dropTable();
    /**
     * This is the method to be used to create
     * a record in the Student table.
     */
    public void create(String nickname, String fullname, String abbout, String email);

    /**
     * This is the method to be used to list down
     * a record from the Student table corresponding
     * to a passed student id.
     */
    /**
     * This is the method to be used to list down
     * all the records from the Student table.
     */
    public List<User> listUsers();


    public User getUserByNickname(String nickname);

    public List<User> getUserByNicknameAndEmail(String nickname, String Email);

    public User getUserByEmail(String email);

    public void updateFullname(String fullname, String nickname);

    public void updateAbbout(String about, String nickname);

    public void updateEmail(String email, String nickname);

    /**
     * This is the method to be used to delete
     * a record from the Student table corresponding
     * to a passed student id.
     */
    public void delete();

    public int getCount();

    /**
     * This is the method to be used to update
     * a record into the Student table.
     */
    public void update(String nickname, String about, String fullname, String email);
}