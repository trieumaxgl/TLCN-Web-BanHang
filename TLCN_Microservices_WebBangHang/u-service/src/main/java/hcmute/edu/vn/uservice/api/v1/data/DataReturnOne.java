package hcmute.edu.vn.uservice.api.v1.data;

import lombok.Data;

@Data
public class DataReturnOne<T> {
    private String message;
    private String success="true";
    private T data;
}
