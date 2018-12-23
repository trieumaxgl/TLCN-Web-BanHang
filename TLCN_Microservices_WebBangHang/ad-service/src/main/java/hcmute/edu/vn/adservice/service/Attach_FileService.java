package hcmute.edu.vn.adservice.service;

import hcmute.edu.vn.adservice.api.v1.dto.Attach_FileDTO;
import hcmute.edu.vn.adservice.model.Attach_File;
import java.util.List;

public interface Attach_FileService {

    Attach_File dtoToAttachFile(Attach_FileDTO attachFileDTO);

    Attach_File saveAttachFile(Attach_File attachFile);

    List<Attach_FileDTO> findItemAttachFile(int id);
    List<Attach_FileDTO> findAll();
    Attach_File findById(Attach_FileDTO attachFileDTO,int id);
}
