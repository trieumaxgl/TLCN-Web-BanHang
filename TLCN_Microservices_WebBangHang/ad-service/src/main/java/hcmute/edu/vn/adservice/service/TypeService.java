package hcmute.edu.vn.adservice.service;

import hcmute.edu.vn.adservice.model.Type;

import java.util.Optional;

public interface TypeService {
    Type findById(int id, int status);
}
