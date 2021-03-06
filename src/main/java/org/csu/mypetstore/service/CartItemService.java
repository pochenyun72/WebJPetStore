package org.csu.mypetstore.service;

import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.CartItem;
import org.csu.mypetstore.persistence.CartItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService
{
    @Autowired
    private CartItemMapper cartItemMapper;

    public List<CartItem> get()
    {
        return cartItemMapper.get();
    }

    public void insertCart(CartItem cartItem)
    {
        cartItemMapper.insertCart(cartItem);
    }

    public void update(CartItem cartItem)
    {
        cartItemMapper.update(cartItem);
    }

    public void removeItemById(String itemId)
    {
        cartItemMapper.removeItemById(itemId);
    }

    public List<CartItem> getItemByUsername(String username)
    {
        return cartItemMapper.getItemByUsername(username);
    }

    public void removeAllItemByUsername(String username)
    {
        cartItemMapper.removeAllItemByUsername(username);
    }

    public void merge(Cart cart)
    {
        removeAllItemByUsername(cart.getUsername());
        System.out.println("cart.getCartItemList().size():" + cart.getCartItemList().size());
        for (int i = 0; i < cart.getCartItemList().size(); i++)
        {
            insertCart(cart.getCartItemList().get(i));
        }
    }
}