package org.learnspringframework.restfullwebservices.dao;

import org.learnspringframework.restfullwebservices.data.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

//    JPA/Hibernate > Database
//    we now Use Static List

    private static List<User> users = new ArrayList<>();

    private static Integer countId = 0;

    static {
        users.add(new User(++countId,"Eve", LocalDate.now().minusYears(18)));
        users.add(new User(++countId,"Ali", LocalDate.now().minusYears(30)));
        users.add(new User(++countId,"Rag", LocalDate.now().minusYears(13)));
        users.add(new User(++countId,"John", LocalDate.now().minusYears(25)));
    }


//    public list<users> findAll()
    public List<User> findAll(){
        return users;
    }

//    public saveUser(User user)

//    public User findOne(int id)
    public User findOne(int id){

//        My try
//        for(User u : users){
//            if(u.getId() == id){
//                return u;
//            }
//        }
//        return new User(0, "Not Found", LocalDate.MIN);

        Predicate<? super User> predicate = user -> user.getId() == id;
        return users.stream().filter(predicate).findFirst().get();
    }

    public User save(User user){
        user.setId(++countId);
        users.add(user);
        return user;
    }


}
