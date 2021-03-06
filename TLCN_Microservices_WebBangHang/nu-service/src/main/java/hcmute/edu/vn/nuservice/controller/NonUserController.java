package hcmute.edu.vn.nuservice.controller;

import hcmute.edu.vn.nuservice.api.v1.data.DataReturnOne;
import hcmute.edu.vn.nuservice.api.v1.dto.ItemDto;
import hcmute.edu.vn.nuservice.api.v1.dto.UserDto;
import hcmute.edu.vn.nuservice.api.v1.data.DataReturnList;
import hcmute.edu.vn.nuservice.exception.NotFoundException;
import hcmute.edu.vn.nuservice.api.v1.mapper.UserMapper;
import hcmute.edu.vn.nuservice.api.v1.mapper.ItemMapper;
import hcmute.edu.vn.nuservice.model.Cart;
import hcmute.edu.vn.nuservice.model.Items;
import hcmute.edu.vn.nuservice.model.User;
import hcmute.edu.vn.nuservice.model.Role;
import hcmute.edu.vn.nuservice.service.CartService;
import hcmute.edu.vn.nuservice.service.ItemService;
import hcmute.edu.vn.nuservice.service.RoleService;
import hcmute.edu.vn.nuservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
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
    private RoleService roleService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private CartService cartService;

    @PostMapping("/register")
    public DataReturnOne<UserDto> register(@RequestBody UserDto userDto){
        User check = userService.findByEmail(userDto.getEmail());
        DataReturnOne<UserDto> dataReturnOne = new DataReturnOne<>();

        if(check != null){
            dataReturnOne.setMessage("Tai khoan da ton tai !!!");
            dataReturnOne.setSuccess("false");
        }
        else {
            User user = userService.userDtoToUser(userDto);
            user.setRoles(roleService.findById(2));
            userService.registerUser(user);

            Cart newCart = new Cart();
            newCart.setUser(userService.findByEmailAndStatus(user.getEmail(),1));
            cartService.addNewCart(newCart);

            user.setCart(cartService.findById(newCart.getId()));

            dataReturnOne.setMessage("Tao tai khoan thanh cong !!!");
            dataReturnOne.setSuccess("true");
            dataReturnOne.setData(userMapper.userToUserDto(userService.updateUser(user.getId())));
        }

        return dataReturnOne;
    }

    @PostMapping("/login/{email}/{passWord}")
    public DataReturnOne<UserDto> login(@PathVariable String email, @PathVariable String passWord){
        //return userMapper.userToUserDto(userService.findByEmailAndPassWord(email, passWord));

        DataReturnOne<UserDto> dataReturnOne = new DataReturnOne<>();
        User user = new User();
        try {
            user = userService.findByEmailAndPassWord(email, passWord);

            dataReturnOne.setMessage("Đăng nhập thành công");
            dataReturnOne.setData(userMapper.userToUserDto(user));
        }
        catch (NotFoundException ex) {
            dataReturnOne.setSuccess("false");
            dataReturnOne.setMessage("Sai Email hoặc Mật khẩu");

        }


        return dataReturnOne;
    }

    @PostMapping("/reset/{email}")
    public ResponseEntity<Object> resetPassword(@PathVariable(value="email") String email) {
        User user = userService.findByEmailAndStatus(email,1);
        userService.resetPassword(user.getId());
        DataReturnOne<User> returnOne = new DataReturnOne<>();
        returnOne.setSuccess("success");
        returnOne.setMessage("Lay lai mat khau thanh cong!");

        return ResponseEntity.ok(returnOne);
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

    @GetMapping("/search")
    public DataReturnList<ItemDto> search(@RequestParam Optional<String> keyword){
        DataReturnList<ItemDto> dataReturnList = new DataReturnList<>();
        try {
            List<Items> items = itemService.findAllByName(keyword);
            dataReturnList.setData(items.stream().map(itemMapper::itemToItemDto)
                    .collect(Collectors.toList()));
            dataReturnList.setMessage("Cac san pham tim thay!!");
        }catch (Exception e){
            dataReturnList.setSuccess("false");
            dataReturnList.setMessage("Khong the lay san pham ???");
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
