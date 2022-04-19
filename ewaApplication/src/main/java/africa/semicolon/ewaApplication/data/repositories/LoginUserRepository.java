package africa.semicolon.ewaApplication.data.repositories;

import africa.semicolon.ewaApplication.data.models.LoginUser;

import java.util.List;
import java.util.Optional;

public interface LoginUserRepository {

    LoginUser save(LoginUser loginUser);
    List<LoginUser> findAllUsers();
    void deleteAllUsers();
    Optional<LoginUser> findUserById(Integer userId);
    void delete(Integer userId);
    void delete(LoginUser loginUser);
}
