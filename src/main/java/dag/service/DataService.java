package dag.service;

import dag.dto.RestDto;

public interface DataService {
    RestDto save(String value);

    RestDto read(String hashCode);
}
