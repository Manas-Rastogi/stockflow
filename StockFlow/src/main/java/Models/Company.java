package Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "companies")
@Data
public class Company {

    @Id
    private String id;

    private String name;

    private String email;

    private LocalDateTime createdAt;
}
