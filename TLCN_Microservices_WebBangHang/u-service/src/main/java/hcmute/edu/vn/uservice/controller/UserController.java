package hcmute.edu.vn.uservice.controller;

import hcmute.edu.vn.uservice.api.v1.data.DataReturnList;
import hcmute.edu.vn.uservice.api.v1.data.DataReturnOne;
import hcmute.edu.vn.uservice.api.v1.dto.ItemDto;
import hcmute.edu.vn.uservice.api.v1.dto.ItemInCartDto;
import hcmute.edu.vn.uservice.api.v1.mapper.ItemInCartMapper;
import hcmute.edu.vn.uservice.api.v1.mapper.ItemMapper;
import hcmute.edu.vn.uservice.model.*;
import hcmute.edu.vn.uservice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("api/v1/user/")
public class UserController {
    @Autowired
    private UserService userService;


    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ItemInCartMapper itemInCartMapper;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private BillService billService;

    @Autowired
    private BillItemService billItemService;

    @GetMapping("/itemincart/{firstName}/{lastName}")
    public DataReturnList<ItemInCartDto> getItemInCart(@PathVariable String firstName, @PathVariable String lastName){
        Cart cart = userService.findByFirstnameAndLastname(firstName,lastName).getCart();

        DataReturnList<ItemInCartDto> productInCartDtoDataReturnList=new DataReturnList<>();
        productInCartDtoDataReturnList.setData(cartItemService.retrieveAllCartItem(cart.getId())
                .stream()
                .map(itemInCartMapper::cartItemToItemInCartDto)
                .collect(Collectors.toList()));
        productInCartDtoDataReturnList.setMessage("Get All Product in Cart!!!");
        return productInCartDtoDataReturnList;
    }

    @PostMapping("/additemincart/{firstName}/{lastName}/{itemId}/{quantity}")
    public DataReturnOne<ItemInCartDto> addItemInCart(@PathVariable String firstName, @PathVariable String lastName, @PathVariable int itemId, @PathVariable Long quantity){
        DataReturnOne<ItemInCartDto> dataReturnRecord = new DataReturnOne<>();

        Cart cart = userService.findByFirstnameAndLastname(firstName,lastName).getCart();
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

    @DeleteMapping("/deleteitemincart/{firstName}/{lastName}/{itemId}")
    public DataReturnOne<ItemDto> deleteItemInCart(@PathVariable String firstName, @PathVariable String lastName, @PathVariable int itemId){
        DataReturnOne<ItemDto> dataReturnRecord = new DataReturnOne<>();

        Cart cart = userService.findByFirstnameAndLastname(firstName,lastName).getCart();
        Items items = itemService.findById(itemId);

        Cart_Item_Id cart_item_id = new Cart_Item_Id(cart, items);

        Cart_Item cart_item = new Cart_Item();
        cart_item.setId(cart_item_id);

        cartItemService.deleteItemInCart(cart_item);

        dataReturnRecord.setMessage("Delete Product In Cart Successfully !!!");
        dataReturnRecord.setData(itemMapper.itemToItemDto(items));

        return dataReturnRecord;
    }

    @DeleteMapping("/deleteallitemincart/{firstName}/{lastName}")
    public boolean deleteAllItemInCart(@PathVariable String firstName, @PathVariable String lastName){
        Cart cart = userService.findByFirstnameAndLastname(firstName,lastName).getCart();
        return cartItemService.deleteAllItemInCart(cart.getId());
    }

    @PostMapping("/thanhtoan/{firstName}/{lastName}")
    public boolean thanhToan(@PathVariable String firstName, @PathVariable String lastName){
        User user = userService.findByFirstnameAndLastname(firstName,lastName);

        Bill bill = new Bill();
        bill.setTotal(Long.valueOf(0));
        bill.setStatus(Integer.valueOf(0));
        bill.setUser(user);

        Bill billAdd = billService.addBill(bill);

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
            bill_item.setTotal(cart_item.getId().getItems().getPrice());
            bill_item.setQuantity(cart_item.getQuantity());

            bill_items.add(billItemService.addBillItem(bill_item));
        }

        return cartItemService.deleteAllItemInCart(cart.getId());
    }
}
