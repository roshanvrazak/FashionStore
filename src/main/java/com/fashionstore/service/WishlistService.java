package com.fashionstore.service;
import java.util.List;

import com.fashionstore.entity.Customer;
import com.fashionstore.entity.Wishlist;

public interface WishlistService {

    Wishlist getWishlistItemById(Long wishlistItemId);

    List<Wishlist> getWishlistItemsByCustomer(Customer customer);

    Wishlist createWishlistItem(Wishlist wishlistItem);

    void deleteWishlistItem(Long wishlistItemId);
}
