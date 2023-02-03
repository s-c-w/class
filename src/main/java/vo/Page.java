package vo;

import lombok.Data;
import java.io.Serializable;

/**
 * 这是一个分页实现
 */
@Data
public class Page implements Serializable {
    private Integer page;
    private Integer limit;
    public Long getStart(){
        return (page-1l)*limit;
    }
}
