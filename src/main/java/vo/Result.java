package vo;

import lombok.Data;

@Data
public class Result<T>{
    //将构造器私有化，只能内部创建
    private Result(){}

    public Result(Integer code, String message, T data, Long count) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.count = count;
    }

    private Integer code;//返回码 0成功
    private String message;
    private T data;
    private Long count;//分页查询的总记录数
    public static Result<Object> success(){
        Result result=new Result(0,"success",null,null);
        return result;
    }
    public static Result<Object> success(String message){
        Result result=new Result(0,message,null,null);
        return result;
    }
    public static Result<Object> success(Object data,Long count){
        Result result=new Result(0,"success",data,count);
        return result;
    }
    public static Result<Object> success(Object data){
        Result result=new Result(0,"success",data,null);
        return result;
    }
    public static Result<Object> fail(){
        Result result=new Result(1,"fail",null,null);
        return result;
    }
    public static Result<Object> fail(String message){
        Result result=new Result(1,message,null,null);
        return result;
    }
}
