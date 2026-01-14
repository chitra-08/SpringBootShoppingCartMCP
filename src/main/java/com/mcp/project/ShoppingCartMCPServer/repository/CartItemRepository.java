package com.mcp.project.ShoppingCartMCPServer.repository;

import com.mcp.project.ShoppingCartMCPServer.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Integer> {

    CartItem findByProductName(String productName);
    void deleteByProductName(String productName);
    @Modifying
    @Transactional
    @Query(
            "update CartItem c " +
                    "set c.quantity = :quantity " +
                    "where c.productName = :productName"
    )
    int updateQuantityByProductName(
            @Param("productName") String productName,
            @Param("quantity") int quantity
    );
}
