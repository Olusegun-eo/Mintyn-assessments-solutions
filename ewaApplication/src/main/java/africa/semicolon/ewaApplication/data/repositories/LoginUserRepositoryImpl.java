package africa.semicolon.ewaApplication.data.repositories;

import africa.semicolon.ewaApplication.data.models.LoginUser;

import java.util.*;

public class LoginUserRepositoryImpl implements LoginUserRepository{
    private final Map<Integer, LoginUser> userDatabase = new HashMap<>();

    @Override
    public LoginUser save(LoginUser loginUser) {
        userDatabase.put(loginUser.getUserLoginId(), loginUser);
        return loginUser;
    }

    @Override
    public List<LoginUser> findAllUsers() {
        List<LoginUser> allUsers = new ArrayList<>();
        Set<Integer> keys = userDatabase.keySet();
        for(Integer key : keys){
            allUsers.add(userDatabase.get(key));
        }
        return allUsers;
    }

    @Override
    public void deleteAllUsers() {
        userDatabase.clear();
    }

    @Override
    public Optional<LoginUser> findUserById(Integer userId) {
        if(userDatabase.containsKey(userId)) return Optional.of(userDatabase.get(userId));
        return Optional.empty();
    }

    @Override
    public void delete(Integer userId) {
        userDatabase.remove(userId);
    }

    @Override
    public void delete(LoginUser loginUser) {
        delete(loginUser.getUserLoginId());
    }
}
