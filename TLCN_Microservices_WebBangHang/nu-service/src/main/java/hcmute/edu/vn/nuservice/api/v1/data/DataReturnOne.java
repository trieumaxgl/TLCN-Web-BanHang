package hcmute.edu.vn.nuservice.api.v1.data;

import lombok.Data;

@Data
public class DataReturnOne<T> {
    private String message;
    private String success="true";
    private T data;
}
