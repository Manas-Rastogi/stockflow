package dolpi.StockFlow.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlertDTO {

    private String productId;

    private String productName;

    private String sku;

    private String warehouseId;

    private String warehouseName;

    private Integer currentStock;

    private Integer threshold;

    private String supplierName;

    private String supplierEmail;
}
