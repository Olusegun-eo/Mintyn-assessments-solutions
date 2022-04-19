package africa.semicolon.ewaApplication.data.repositories;

import africa.semicolon.ewaApplication.data.models.RegisterUser;

import java.util.*;

public class RegisterUserRepositoryImpl implements RegisterUserRepository {

   private final Map<Integer, RegisterUser> userDatabase = new HashMap<>();

    @Override
    public RegisterUser save(RegisterUser aUser) {
        Integer userId = null;
        if (aUser.getUserId() == null) {
            userId = userDatabase.size() + 1;
            aUser.setUserId(userId);

            userId = aUser.getUserId();
            userDatabase.put(userId, aUser);
            return userDatabase.get(userId);
        }
        return null;
    }

    @Override
    public List<RegisterUser> findUserById() {
        List<RegisterUser> allUsers = new ArrayList<>();
        Set<Integer>Keys = userDatabase.keySet();
        for(Integer key: Keys){
            allUsers.add(userDatabase.get(key));
        }
//        Keys.forEach(key->all.add(database.get(key)));
        return allUsers;
    }

    public void delete(RegisterUser aUser) {
        userDatabase.remove(aUser.getUserId());
    }

    @Override
    public void delete(Integer userId) {
        userDatabase.remove(userId);
    }

    public RegisterUser findByUserId(Integer userId) {
        return userDatabase.get(userId);
    }

}
