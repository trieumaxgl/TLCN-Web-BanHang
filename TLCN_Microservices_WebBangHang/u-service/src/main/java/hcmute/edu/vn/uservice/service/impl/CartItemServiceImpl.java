package hcmute.edu.vn.uservice.service.impl;

import hcmute.edu.vn.uservice.exception.NotFoundException;
import hcmute.edu.vn.uservice.model.Cart_Item;
import hcmute.edu.vn.uservice.repository.CartItemRepository;
import hcmute.edu.vn.uservice.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService{
    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public List<Cart_Item> retrieveAllCartItem(Long cartId) {
        List<Cart_Item> cart_products = cartItemRepository.findById_CartId(cartId);
        if(cart_products.isEmpty())
            throw new NotFoundException("Not Found Product in Your Cart");
        return cart_products;
    }

    @Override
    public Cart_Item addItemInCart(Cart_Item cartProduct) {
        return cartItemRepository.save(cartProduct);
    }

    @Override
    public void deleteItemInCart(Cart_Item cartProduct) {
        cartItemRepository.delete(cartProduct);
    }

    @Override
    public boolean deleteAllItemInCart(Long cartId) {
        List<Cart_Item> cart_products = cartItemRepository.findById_CartId(cartId);

        if(cart_products.isEmpty())
            throw new NotFoundException("Not Found Product in Your Cart");

        for (Cart_Item cart_product:cart_products) {
            deleteItemInCart(cart_product);
        }
        return true;
    }
}
