package usermanagement.servicemanager;

import springbootservice.consume.api.UserManagementControllerApi;
import springbootservice.consume.model.User;
import usermanagement.mapper.UserMapper;
import usermanagement.model.UserDetails;

import javax.annotation.PostConstruct;
import java.util.List;

public class UserManagementManagerImpl implements UserManagementManager {

    private UserManagementControllerApi api;
    private String basePath = "http://localhost:9191/api";

    @PostConstruct
    private void setupApiClient() {
        api = new UserManagementControllerApi();
        api.getApiClient().setBasePath(basePath);
        api.getApiClient().setPassword("admin");
        api.getApiClient().setUsername("$2a$10$vZ99Ww4j7zswcuHbwDc6A.dpHbb4ZeOvVCx7VzozUyvUbofmpSX0m");
    }

    @Override
    public Object createUser(UserDetails userDetails) {
        return api.createUserUsingPOST(UserMapper.INSTANCE.userDetailsToUser(userDetails));
    }

    @Override
    public UserDetails deleteAllUsersUsingDELETE() {
        return UserMapper.INSTANCE.userToUserDetails(api.deleteAllUsersUsingDELETE());
    }

    @Override
    public Object deleteUserUsingDELETE(long id) {
        return api.deleteUserUsingDELETE(id);
    }

    @Override
    public Object getUserUsingGET(long id) {
        return api.getUserUsingGET(id);
    }

    @Override
    public List<UserDetails> listAllUsersUsingGET() {
        return UserMapper.INSTANCE.userListToUserDetailsList(api.listAllUsersUsingGET());
    }

    @Override
    public Object updateUserUsingPUT(Long id, User user) {
        return api.updateUserUsingPUT(id, user);
    }
}
