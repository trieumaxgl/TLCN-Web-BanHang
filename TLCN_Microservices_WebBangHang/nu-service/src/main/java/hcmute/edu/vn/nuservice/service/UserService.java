package hcmute.edu.vn.nuservice.service;

import hcmute.edu.vn.nuservice.api.v1.dto.UserDto;
import hcmute.edu.vn.nuservice.model.Cart;
import hcmute.edu.vn.nuservice.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserService {
    CrudRepository<User, Integer> getRepo();
    User findByEmailAndPassWord(String email, String passWord);
    User findByEmailAndStatus(String email,int status);
    User registerUser(User user);
    User userDtoToUser(UserDto userDto);
    User updateUser(int id);
}
