package Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "inventories")
@Data
public class Inventory {

    @Id
    private String id;

    private String productId;

    private String warehouseId;

    private Integer quantity;

    private Integer lowStockThreshold;
}