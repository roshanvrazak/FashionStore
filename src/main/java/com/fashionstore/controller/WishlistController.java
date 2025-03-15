package com.fashionstore.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fashionstore.entity.Customer;
import com.fashionstore.entity.Wishlist;
import com.fashionstore.service.WishlistService;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @GetMapping("/{wishlistItemId}")
    public ResponseEntity<Wishlist> getWishlistItemById(@PathVariable Long wishlistItemId) {
        Wishlist wishlistItem = wishlistService.getWishlistItemById(wishlistItemId);
        if (wishlistItem != null) {
            return ResponseEntity.ok(wishlistItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/customer/{customerId}") // View Wish list -- in report
    public ResponseEntity<List<Wishlist>> getWishlistItemsByCustomer(@PathVariable Long customerId) {
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        List<Wishlist> wishlistItems = wishlistService.getWishlistItemsByCustomer(customer);
        return ResponseEntity.ok(wishlistItems);
    }

    @PostMapping
    public ResponseEntity<Wishlist> createWishlistItem(@RequestBody Wishlist wishlistItem) {
        Wishlist createdWishlistItem = wishlistService.createWishlistItem(wishlistItem);
        return ResponseEntity.ok(createdWishlistItem);
    }

    @DeleteMapping("/{wishlistItemId}")
    public ResponseEntity<Void> deleteWishlistItem(@PathVariable Long wishlistItemId) {
        wishlistService.deleteWishlistItem(wishlistItemId);
        return ResponseEntity.noContent().build();
    }
}
