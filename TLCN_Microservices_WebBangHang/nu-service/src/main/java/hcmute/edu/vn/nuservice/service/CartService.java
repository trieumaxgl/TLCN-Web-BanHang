package hcmute.edu.vn.nuservice.service;

import hcmute.edu.vn.nuservice.model.Cart;

public interface CartService {
    Cart findById(Long id);
    Cart addNewCart(Cart cart);
}
