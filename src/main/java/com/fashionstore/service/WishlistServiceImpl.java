package com.fashionstore.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashionstore.entity.Customer;
import com.fashionstore.entity.Wishlist;
import com.fashionstore.reporsitory.WishlistRepository;

@Service
public class WishlistServiceImpl implements WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    @Override
    public Wishlist getWishlistItemById(Long wishlistItemId) {
        return wishlistRepository.findById(wishlistItemId).orElse(null);
    }

    @Override
    public List<Wishlist> getWishlistItemsByCustomer(Customer customer) {
        return wishlistRepository.findByCustomer(customer);
    }

    @Override
    public Wishlist createWishlistItem(Wishlist wishlistItem) {
        return wishlistRepository.save(wishlistItem);
    }

    @Override
    public void deleteWishlistItem(Long wishlistItemId) {
        wishlistRepository.deleteById(wishlistItemId);
    }
}
