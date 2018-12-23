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
import java.util.stream.Collectors;

@Service
public class Attach_FileImpl  implements Attach_FileService {
    @Autowired
    Attach_FileRepository attachFileRepository;
    @Autowired
    Attach_FileMapper attachFileMapper;

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
    public List<Attach_FileDTO> findItemAttachFile(int id) {
        List<Attach_File> attachFiles = attachFileRepository.findItemByAttachFile(id);
        return attachFiles.stream().map(attachFileMapper::AttachFileToAttachFileDTO).collect(Collectors.toList());
    }

    @Override
    public List<Attach_FileDTO> findAll() {
        List<Attach_File> attachFiles = attachFileRepository.findAll();
        return attachFiles.stream().map(attachFileMapper::AttachFileToAttachFileDTO).collect(Collectors.toList());
    }

    @Override
    public Attach_File findById(Attach_FileDTO attachFileDTO,int id){
        Attach_File attachFile = attachFileRepository.findById(id).get();
        if(attachFile == null)
            throw new NotFoundException("Attach file not found!!");
        attachFile.setImage(attachFileDTO.getImage());
        return attachFileRepository.save(attachFile);
    }
}
