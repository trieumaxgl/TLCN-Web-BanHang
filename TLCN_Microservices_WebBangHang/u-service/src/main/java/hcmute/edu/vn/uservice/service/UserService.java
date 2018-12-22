package hcmute.edu.vn.uservice.service;

import hcmute.edu.vn.uservice.api.v1.dto.UserDto;
import hcmute.edu.vn.uservice.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserService {
    CrudRepository<User, Integer> getRepo();
    User findByEmailAndPassWord(String userName, String passWord);
    User findByFirstnameAndLastname(String firstname, String lastname);
    User findByEmailAndStatus (String email, int status);
    User updateUser (UserDto userDto,int id);

}
