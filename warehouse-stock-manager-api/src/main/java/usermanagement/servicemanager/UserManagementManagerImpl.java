package usermanagement.servicemanager;

import springbootservice.consume.api.UserManagementControllerApi;
import springbootservice.consume.model.User;

import javax.annotation.PostConstruct;
import java.util.List;

public class UserManagementManagerImpl implements UserManagementManager {

    private UserManagementControllerApi api;
    private String basePath = "http://localhost:9191/api";

    @PostConstruct
    private void setupApiClient() {
        api = new UserManagementControllerApi();
        api.getApiClient().setBasePath(basePath);
    }

    @Override
    public Object createUser(User user) {
        return api.createUserUsingPOST(user);
    }

    @Override
    public User deleteAllUsersUsingDELETE() {
        return api.deleteAllUsersUsingDELETE();
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
    public List<User> listAllUsersUsingGET() {
        return api.listAllUsersUsingGET();
    }

    @Override
    public Object updateUserUsingPUT(Long id, User user) {
        return api.updateUserUsingPUT(id, user);
    }
}
