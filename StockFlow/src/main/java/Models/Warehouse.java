package Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "warehouses")
@Data
public class Warehouse {

    @Id
    private String id;

    private String name;

    private String companyId;

    private String location;
}