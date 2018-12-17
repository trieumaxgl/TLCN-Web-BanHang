package hcmute.edu.vn.nuservice.controller;

import hcmute.edu.vn.nuservice.api.v1.data.DataReturnOne;
import hcmute.edu.vn.nuservice.api.v1.dto.ItemDto;
import hcmute.edu.vn.nuservice.api.v1.dto.UserDto;
import hcmute.edu.vn.nuservice.api.v1.data.DataReturnList;
import hcmute.edu.vn.nuservice.exception.NotFoundException;
import hcmute.edu.vn.nuservice.api.v1.mapper.UserMapper;
import hcmute.edu.vn.nuservice.api.v1.mapper.ItemMapper;
import hcmute.edu.vn.nuservice.model.Items;
import hcmute.edu.vn.nuservice.model.User;
import hcmute.edu.vn.nuservice.model.Role;
import hcmute.edu.vn.nuservice.service.ItemService;
import hcmute.edu.vn.nuservice.service.RoleService;
import hcmute.edu.vn.nuservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/nuser/")
@CrossOrigin
public class NonUserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ItemMapper itemMapper;



    @PostMapping("/register")
    public UserDto register(@RequestBody User user){
        user.setStatus(1);
        return userMapper.userToUserDto(userService.registerUser(user));
    }

    @PostMapping("/login/{email}/{passWord}")
    public DataReturnOne<UserDto> login(@PathVariable String email, @PathVariable String passWord){
        //return userMapper.userToUserDto(userService.findByEmailAndPassWord(email, passWord));

        DataReturnOne<UserDto> dataReturnOne = new DataReturnOne<>();
        User user = new User();
        try {
            user = userService.findByEmailAndPassWord(email, passWord);
            user.setRoles(userService.findByEmailAndPassWord(email, passWord).getRoles());
            dataReturnOne.setMessage("Đăng nhập thành công");
            dataReturnOne.setData(userMapper.userToUserDto(user));
        }
        catch (NotFoundException ex) {
            dataReturnOne.setSuccess("false");
            dataReturnOne.setMessage("Sai Email hoặc Mật khẩu");

        }


        return dataReturnOne;
    }

    @GetMapping("/items")
    public DataReturnList<ItemDto> getAllItems(){
        DataReturnList<ItemDto> dataReturnList = new DataReturnList<>();
        List<Items> items = itemService.findAllItems();
        if(items.isEmpty()){
            dataReturnList.setMessage("Items is Empty !!!");
            dataReturnList.setSuccess("false");
        }
        else {
            dataReturnList.setMessage("Get All Products");
            dataReturnList.setSuccess("true");
            dataReturnList.setData(items.stream().map(itemMapper::itemToItemDto).collect(Collectors.toList()));
        }

        return dataReturnList;
    }

    @GetMapping("/item/{itemId}")
    public DataReturnOne<ItemDto> getItemsById(@PathVariable int itemId){
        DataReturnOne<ItemDto> dataReturnRecord = new DataReturnOne<>();
        Items item = itemService.findById(itemId);

        if(item == null){
            dataReturnRecord.setMessage("Not Found Product !!!");
            dataReturnRecord.setSuccess("false");
        }else{
            dataReturnRecord.setMessage("Get Product By Id");
            dataReturnRecord.setSuccess("true");
            dataReturnRecord.setData(itemMapper.itemToItemDto(item));
        }

        return dataReturnRecord;
    }
}
