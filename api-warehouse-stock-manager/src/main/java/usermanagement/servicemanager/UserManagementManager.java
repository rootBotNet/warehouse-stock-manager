package usermanagement.servicemanager;

import springbootservice.consume.model.User;
import usermanagement.model.UserDetails;

import java.util.List;

public interface UserManagementManager {

    Object createUser(UserDetails userDetails);

    UserDetails deleteAllUsersUsingDELETE();

    Object deleteUserUsingDELETE(long id);

    Object getUserUsingGET(long id);

    List<UserDetails> listAllUsersUsingGET();

    Object updateUserUsingPUT(Long id, User user);
}
