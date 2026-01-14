package com.mcp.project.ShoppingCartMCPServer.tools;

import com.mcp.project.ShoppingCartMCPServer.entity.CartItem;
import com.mcp.project.ShoppingCartMCPServer.repository.CartItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ShoppingCartMCPService {

    @Autowired
    private CartItemRepository cartItemRepository;

    //Sample catalogue
    private static final Map<String,Double> products = Map.of(
        "Iphone 17 pro", 149000.0,"Redmi 15 Pro", 49000.0,"Airpods S3", 12500.0,"Apple wired earphones", 2500.0,
            "MacBook Air", 249000.0,"Ipad Mini SE10", 120000.0
    );

    @Tool(name = "addToCart",
            description = "Add a product to the shopping cart. If the product already exists, it updates the quantity.")
    public String addToCart(@ToolParam String productName, @ToolParam int quantity){

        if(!products.containsKey(productName)){
            return "product not found";
        }

        Double price = products.get(productName);

        CartItem cartItem=cartItemRepository.findByProductName(productName);

        if(cartItem==null){
            cartItem = new CartItem();
            cartItem.setProductId(productName);
            cartItem.setProductName(productName);
            cartItem.setQuantity(quantity);
        }else{
            cartItem.setQuantity(cartItem.getQuantity()+quantity);
        }
        cartItem.setPrice(cartItem.getQuantity()*price);
        cartItemRepository.save(cartItem);
        return quantity + " " + productName + " added to cart. Total price: " + (cartItem.getPrice());
    }

    @Tool(
            name = "removeCart",
            description = "Remove a product from the shopping cart."
    )
    @Transactional
    public String removeCart(@ToolParam String productName){
        cartItemRepository.deleteByProductName(productName);
        return productName + " removed from cart.";
    }

    @Tool(name = "updateQuantity", description = "Updates the item as per quantity specified from the shopping cart. Can also be commanded stating removing from shopping cart the quantity specified for the item.")
    @Transactional
    public void updateQuantity(@ToolParam String productName, @ToolParam int quantity) {
        int updated = cartItemRepository.updateQuantityByProductName(productName, quantity);

        if (updated == 0) {
            throw new IllegalArgumentException("Product not found: " + productName);
        }
    }

   @Tool(
            name = "getCarts",
            description = "Retrieve the current shopping cart items."
    )
    public List<CartItem> getCarts(){
        return cartItemRepository.findAll();
    }

    @Tool(
            name = "getCartTotal",
            description = "Calculate the total price of items in the shopping cart."
    )
    public double getCartTotal() {
        return cartItemRepository.findAll().stream()
                .mapToDouble(CartItem::getPrice)
                .sum();
    }

}
