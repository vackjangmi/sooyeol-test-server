package sooyeol.api.model.collection;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "person")
@ToString
public class PersonCollections {

    @Id
    private String id;
    private String name;
    private String job;

    @Builder
    public PersonCollections(String id, String name, String job) {
        this.id = id;
        this.name = name;
        this.job = job;
    }

}