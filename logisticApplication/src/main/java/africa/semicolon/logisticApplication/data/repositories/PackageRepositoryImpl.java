package africa.semicolon.logisticApplication.data.repositories;

import africa.semicolon.logisticApplication.data.models.Package;

import java.util.*;

public class PackageRepositoryImpl implements PackageRepository{

    private final Map<Integer, Package> database = new HashMap<>();
    @Override
    public Package save(Package aPackage) {
        Integer id = null;
        if(aPackage.getId() == null ){
            id = database.size() + 1;
            aPackage.setId(id);

            id = aPackage.getId();
            database.put(id, aPackage);
            return database.get(id);
        }
       return null;
    }


    @Override
    public List<Package> findById() {
        List<Package> all = new ArrayList<>();
        Set<Integer>Keys = database.keySet();
        for(Integer key: Keys){
            all.add(database.get(key));
        }
//        Keys.forEach(key->all.add(database.get(key)));
        return all;
    }




    @Override
    public void delete(Package aPackage) {
        database.remove(aPackage.getId());
    }

    @Override
    public void delete(Integer id) {
        database.remove(id);
    }

    @Override
    public Package findById(Integer id) {
        return database.get(id);
    }
}




