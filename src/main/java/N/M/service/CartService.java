package N.M.service;


import N.M.Model.CartItem;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    private final List<CartItem> cartItems = new ArrayList<>();

    public List<CartItem> getAllCartItems() {
        return cartItems;
    }

    public CartItem getCartItemById(Long id) {
        return cartItems.stream()
                .filter(cartItem -> cartItem.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Cart item not found"));
    }

    public CartItem addCartItem(CartItem cartItem) {
        cartItem.setId((long) (cartItems.size() + 1)); // Simple ID generation
        cartItems.add(cartItem);
        return cartItem;
    }

    public void removeCartItem(Long id) {
        cartItems.removeIf(cartItem -> cartItem.getId().equals(id));
    }
}
