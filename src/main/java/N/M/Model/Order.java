package N.M.Model;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private Long id;
    private Long userId;
    private List<CartItem> items;
    private Double totalAmount;
}
