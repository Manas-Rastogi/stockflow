package dolpi.StockFlow.Repository;

import Models.Supplier;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SupplierRepository
        extends MongoRepository<Supplier, String> {

}
