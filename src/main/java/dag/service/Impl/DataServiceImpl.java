package dag.service.Impl;

import dag.dao.DataDao;
import dag.dto.RestDto;
import dag.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private DataDao dataDao;

    @Override
    public RestDto save(String value) {
        RestDto restDto = new RestDto();
        restDto.setStatus(0);
        return restDto;
    }

    @Override
    public RestDto read(String hashCode) {
        RestDto restDto = new RestDto();
        restDto.setStatus(0);
        return restDto;
    }
}
