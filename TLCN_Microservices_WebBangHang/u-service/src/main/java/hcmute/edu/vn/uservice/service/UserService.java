package hcmute.edu.vn.uservice.service;

import hcmute.edu.vn.uservice.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserService {
    CrudRepository<User, Integer> getRepo();
    User findByEmailAndPassWord(String userName, String passWord);
    User findByFirstnameAndLastname(String firstname, String lastname);
}
