package hcmute.edu.vn.uservice.controller;

import hcmute.edu.vn.uservice.exception.NotFoundException;
import hcmute.edu.vn.uservice.api.v1.data.DataReturnList;
import hcmute.edu.vn.uservice.api.v1.data.DataReturnOne;
import hcmute.edu.vn.uservice.api.v1.dto.ItemDto;
import hcmute.edu.vn.uservice.api.v1.dto.ItemInCartDto;
import hcmute.edu.vn.uservice.api.v1.dto.UserDto;
import hcmute.edu.vn.uservice.api.v1.mapper.ItemInCartMapper;
import hcmute.edu.vn.uservice.api.v1.mapper.ItemMapper;
import hcmute.edu.vn.uservice.api.v1.mapper.UserMapper;
import hcmute.edu.vn.uservice.model.*;
import hcmute.edu.vn.uservice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("api/v1/user/")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ItemInCartMapper itemInCartMapper;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private BillService billService;

    @Autowired
    private BillItemService billItemService;

    @GetMapping("/{email}")
    public DataReturnOne<UserDto> getUser(@PathVariable(value = "email") String email){
        DataReturnOne<UserDto> returnOne = new DataReturnOne<>();
        User user = userService.findByEmailAndStatus(email,1);
        returnOne.setMessage("get user info");
        returnOne.setData(userMapper.userToUserDto(user));
        return returnOne;
    }

    @PostMapping("/update/{email}")
    public ResponseEntity<Object> updateUser(@RequestBody UserDto userDto, @PathVariable(value="email") String email) {
        User user = userService.findByEmailAndStatus(email,1);
        userService.updateUser(userDto,user.getId());
        DataReturnOne<UserDto> returnOne = new DataReturnOne<>();
        try {
            returnOne.setMessage("Thay doi thong tin thanh cong");
            returnOne.setSuccess("true");
            returnOne.setData(userDto);
        }
        catch (NotFoundException ex) {
            returnOne.setSuccess("false");
            returnOne.setMessage("Thay doi thong tin that bai");
        }
        return ResponseEntity.ok(returnOne);
    }


    @GetMapping("/itemincart/{email}")
    public DataReturnList<ItemInCartDto> getItemInCart(@PathVariable String email){
        Cart cart = userService.findByEmailAndStatus(email,1).getCart();

        DataReturnList<ItemInCartDto> productInCartDtoDataReturnList=new DataReturnList<>();
        productInCartDtoDataReturnList.setData(cartItemService.retrieveAllCartItem(cart.getId())
                .stream()
                .map(itemInCartMapper::cartItemToItemInCartDto)
                .collect(Collectors.toList()));
        productInCartDtoDataReturnList.setMessage("Get All Product in Cart!!!");
        return productInCartDtoDataReturnList;
    }

    @PostMapping("/additemincart/{email}/{itemId}/{quantity}")
    public DataReturnOne<ItemInCartDto> addItemInCart(@PathVariable String email, @PathVariable int itemId, @PathVariable Long quantity){
        DataReturnOne<ItemInCartDto> dataReturnRecord = new DataReturnOne<>();

        Cart cart = userService.findByEmailAndStatus(email,1).getCart();
        Items items = itemService.findById(itemId);

        Cart_Item_Id cart_item_id = new Cart_Item_Id();
        cart_item_id.setCart(cart);
        cart_item_id.setItems(items);

        Cart_Item cart_item = new Cart_Item();
        cart_item.setId(cart_item_id);
        cart_item.setQuantity(quantity);

        dataReturnRecord.setData(itemInCartMapper.cartItemToItemInCartDto(cartItemService.addItemInCart(cart_item)));
        dataReturnRecord.setMessage("Add Product To Cart Successfully !!!");

        return dataReturnRecord;
    }

    @DeleteMapping("/deleteitemincart/{email}/{itemId}")
    public DataReturnOne<ItemDto> deleteItemInCart(@PathVariable String email, @PathVariable int itemId){
        DataReturnOne<ItemDto> dataReturnRecord = new DataReturnOne<>();

        Cart cart = userService.findByEmailAndStatus(email,1).getCart();
        Items items = itemService.findById(itemId);

        Cart_Item_Id cart_item_id = new Cart_Item_Id(cart, items);

        Cart_Item cart_item = new Cart_Item();
        cart_item.setId(cart_item_id);

        cartItemService.deleteItemInCart(cart_item);

        dataReturnRecord.setMessage("Delete Product In Cart Successfully !!!");
        dataReturnRecord.setData(itemMapper.itemToItemDto(items));

        return dataReturnRecord;
    }

    @DeleteMapping("/deleteallitemincart/{email}")
    public boolean deleteAllItemInCart(@PathVariable String email){
        Cart cart = userService.findByEmailAndStatus(email,1).getCart();
        return cartItemService.deleteAllItemInCart(cart.getId());
    }

    @PostMapping("/thanhtoan/{email}")
    public boolean thanhToan(@PathVariable String email){
        User user = userService.findByEmailAndStatus(email,1);
        Long total = Long.valueOf(0);

        Bill billAdd = billService.addBill(user);

        System.out.println(billAdd.getId());

        Cart cart = user.getCart();
        List<Cart_Item> cart_items = cartItemService.retrieveAllCartItem(cart.getId());

        List<Bill_Item> bill_items = new ArrayList<>();

        for (Cart_Item cart_item: cart_items) {

            Bill_Item_Id bill_item_id = new Bill_Item_Id();
            bill_item_id.setBill(billAdd);
            bill_item_id.setItems(cart_item.getId().getItems());

            Bill_Item bill_item = new Bill_Item();
            bill_item.setId(bill_item_id);
            bill_item.setStatus(1);
            Long tongGia= cart_item.getId().getItems().getPrice()*cart_item.getQuantity();
            bill_item.setTotal(tongGia);
            bill_item.setQuantity(cart_item.getQuantity());

            bill_items.add(billItemService.addBillItem(bill_item));

            total = total + tongGia;
        }

        billService.updateBill(billAdd.getId(),total);

        return cartItemService.deleteAllItemInCart(cart.getId());
    }
}
