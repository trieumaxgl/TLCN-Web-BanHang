package hcmute.edu.vn.nuservice.service.impl;

import hcmute.edu.vn.nuservice.exception.NotFoundException;
import hcmute.edu.vn.nuservice.model.Cart;
import hcmute.edu.vn.nuservice.repository.CartRepository;
import hcmute.edu.vn.nuservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;

    @Override
    public Cart findById(Long id){
        Optional<Cart> cart = cartRepository.findById(id);
        if(!cart.isPresent())
            throw new NotFoundException("Cart Not Found!!!");
        return cart.get();
    }

    @Override
    public Cart addNewCart(Cart cart){
        Cart addCart = cartRepository.save(cart);
        return cartRepository.save(addCart);
    }
}
