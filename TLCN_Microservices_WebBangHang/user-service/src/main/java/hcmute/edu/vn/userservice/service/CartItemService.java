package hcmute.edu.vn.userservice.service;

import hcmute.edu.vn.userservice.model.Cart_Item;

import java.util.List;

public interface CartItemService {
    List<Cart_Item> retrieveAllCartItem(Long id);
    Cart_Item addItemInCart(Cart_Item cart_item);
    void deleteItemInCart(Cart_Item cart_item);
    boolean deleteAllItemInCart(Long cartId);
}
