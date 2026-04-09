package dolpi.StockFlow.Repository;

import Models.Warehouse;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WarehouseRepository extends MongoRepository<Warehouse, String> {

    List<Warehouse> findByCompanyId(
            String companyId);
}