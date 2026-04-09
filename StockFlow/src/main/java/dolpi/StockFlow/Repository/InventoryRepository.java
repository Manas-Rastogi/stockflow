package dolpi.StockFlow.Repository;

import Models.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface InventoryRepository
        extends MongoRepository<Inventory, String> {

    List<Inventory> findByWarehouseId(
            String warehouseId);
}
