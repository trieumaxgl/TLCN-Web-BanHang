package hcmute.edu.vn.adservice.service.impl;
import hcmute.edu.vn.adservice.exception.NotFoundException;
import hcmute.edu.vn.adservice.api.v1.dto.Attach_FileDTO;
import hcmute.edu.vn.adservice.api.v1.mapper.Attach_FileMapper;
import hcmute.edu.vn.adservice.model.Attach_File;
import hcmute.edu.vn.adservice.repository.Attach_FileRepository;
import hcmute.edu.vn.adservice.service.Attach_FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class Attach_FileImpl  implements Attach_FileService {
    @Autowired
    Attach_FileRepository attachFileRepository;

//    @Autowired
//    Attach_FileMapper attachFileMapper;
    @Override
    public Attach_File dtoToAttachFile(Attach_FileDTO attachFileDTO) {

        Attach_File attachFile = new Attach_File();
        attachFile.setId(attachFileDTO.getId());
        attachFile.setImage(attachFileDTO.getImage());
        return attachFile;
    }

    @Override
    public Attach_File saveAttachFile(Attach_File attachFile) {
        return attachFileRepository.save(attachFile);
    }

    @Override
    public List<Attach_File> fillAll(int itemId) {
        return attachFileRepository.findAll();
    }

}
