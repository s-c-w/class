package realize.manager.dao;

import lombok.Data;

import java.io.Serializable;

@Data
public class Manager implements Serializable {
    private String managerId;
    private String managerPassword;
}
