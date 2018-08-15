package usermanagement.servicemanager;

import springbootservice.consume.model.User;

import java.util.List;

public interface UserManagementManager {

    Object createUser(User user);

    User deleteAllUsersUsingDELETE();

    Object deleteUserUsingDELETE(long id);

    Object getUserUsingGET(long id);

    List<User> listAllUsersUsingGET();

    Object updateUserUsingPUT(Long id, User user);
}
