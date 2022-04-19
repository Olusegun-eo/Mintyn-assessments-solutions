package africa.semicolon.ewaApplication.data.repositories;

import africa.semicolon.ewaApplication.data.models.LoginUser;
import africa.semicolon.ewaApplication.data.models.RegisterUser;


import java.util.List;
import java.util.Optional;

//Use Sender repo in logisticApplication as an example
public interface RegisterUserRepository {
    RegisterUser save(RegisterUser aUser);
    List<RegisterUser> findUserById();
    void delete(RegisterUser aUser);
    void delete(Integer userId);
    RegisterUser findByUserId(Integer userId);
}

