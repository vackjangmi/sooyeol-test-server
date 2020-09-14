package sooyeol.api.model.result;

import lombok.Builder;
import lombok.Data;
import sooyeol.api.base.BaseResult;
import sooyeol.api.model.collection.PersonCollections;
import sooyeol.api.model.enums.ResultStatus;

import java.util.List;

@Data
public class PersonResult extends BaseResult {

    private PersonCollections person;

    private List<PersonCollections> persons;

    @Builder
    public PersonResult(ResultStatus status, String message, PersonCollections person, List<PersonCollections> persons) {
        super(status, message);
        this.person = person;
        this.persons = persons;
    }
}
