package sooyeol.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sooyeol.api.base.BaseService;
import sooyeol.api.model.collection.PersonCollections;
import sooyeol.api.model.enums.ResultStatus;
import sooyeol.api.model.result.PersonResult;
import sooyeol.api.repository.PersonMongoDBRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService extends BaseService {

    @Autowired()
    private PersonMongoDBRepository personMongoDBRepository;

    public PersonResult insert(PersonCollections person) {
        PersonCollections data = personMongoDBRepository.insert(person);

        PersonResult result = PersonResult.builder()
                .status(ResultStatus.OK)
                .message("Person collection inserted.")
                .person(data)
                .build();

        return result;
    }

    public PersonResult update(String id, PersonCollections person) {
        person.setId(id);

        PersonCollections data = personMongoDBRepository.save(person);

        PersonResult result = PersonResult.builder()
                .status(ResultStatus.OK)
                .person(data)
                .message("Person collection updated.")
                .build();

        return result;
    }

    public PersonResult delete(String id) {
        PersonCollections person = PersonCollections.builder().id(id).build();

        personMongoDBRepository.delete(person);

        PersonResult result = PersonResult.builder()
                .status(ResultStatus.OK)
                .message("Person collection deleted.")
                .build();

        return result;
    }

    public PersonResult findByName(String name) {
        List<PersonCollections> personList = personMongoDBRepository.findByName(name);

        PersonResult result = PersonResult.builder()
                .status(ResultStatus.OK)
                .message("Person collection found. (" + personList.size() + " rows)")
                .persons(personList)
                .build();

        return result;
    }

    public PersonResult deleteAll() {
        personMongoDBRepository.deleteAll();

        PersonResult result = PersonResult.builder()
                .status(ResultStatus.OK)
                .message("All of person collection deleted.")
                .build();

        return result;
    }

}
