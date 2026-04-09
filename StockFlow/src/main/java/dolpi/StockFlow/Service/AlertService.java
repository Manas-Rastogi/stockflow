package dolpi.StockFlow.Service;

import Models.Inventory;
import Models.Product;
import Models.Supplier;
import Models.Warehouse;
import dolpi.StockFlow.DTO.AlertDTO;
import dolpi.StockFlow.Repository.InventoryRepository;
import dolpi.StockFlow.Repository.ProductRepository;
import dolpi.StockFlow.Repository.SupplierRepository;
import dolpi.StockFlow.Repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlertService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    public List<AlertDTO> getLowStockAlerts(
            String companyId) {

        List<AlertDTO> alerts = new ArrayList<>();

        // Step 1 Find Compamy Where House
        List<Warehouse> warehouses =
                warehouseRepository
                        .findByCompanyId(companyId);

        // Step 2 ALl warehouse check
        for (Warehouse warehouse : warehouses) {

            List<Inventory> inventories =
                    inventoryRepository
                            .findByWarehouseId(warehouse.getId());

            // Step 3 Check Low Cost
            for (Inventory inventory : inventories) {

                if (inventory.getQuantity() <
                        inventory.getLowStockThreshold()) {

                    Product product = productRepository
                            .findById(inventory.getProductId())
                            .orElse(null);

                    if (product == null) continue;

                    Supplier supplier = supplierRepository
                            .findById(product.getSupplierId())
                            .orElse(null);

                    // Step 4 Craete Alert
                    AlertDTO alert = new AlertDTO(
                            product.getId(),
                            product.getName(),
                            product.getSku(),
                            warehouse.getId(),
                            warehouse.getName(),
                            inventory.getQuantity(),
                            inventory.getLowStockThreshold(),
                            supplier != null ?
                                    supplier.getName() : "N/A",
                            supplier != null ?
                                    supplier.getContactEmail() : "N/A"
                    );
                    alerts.add(alert);
                }
            }
        }
        return alerts;
    }
}