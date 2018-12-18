package hcmute.edu.vn.adservice.service.impl;

import hcmute.edu.vn.adservice.exception.NotFoundException;
import hcmute.edu.vn.adservice.model.Type;
import hcmute.edu.vn.adservice.repository.TypeRepository;
import hcmute.edu.vn.adservice.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeRepository typeRepository;

    @Override
    public Type findById(int id, int status){
        Optional<Type> type = typeRepository.findByIdAndStatus(id,status);
        if(!type.isPresent())
            throw new NotFoundException("Type Not Found !!!");
        return type.get();
    }
}
