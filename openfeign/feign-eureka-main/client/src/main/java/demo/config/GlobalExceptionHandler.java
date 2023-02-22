package demo.config;

import feign.FeignException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @describe: 全局异常统一处理
 * @Author MK
 * @PackageName feign-eureka-main
 * @Package demo.config
 * @Date 2023/2/22 10:39
 * @Version 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * @describe: 对当前项目的异常处理
     * @param: [e]
     * @return: java.lang.String
     * @author: MK
     * @version: 1.0.0
     * @date 2023/2/22 10:43
     **/
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String error(Exception e){
        e.printStackTrace();
        return "全局异常报错！";
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public String error(HttpMessageNotReadableException e){
        e.printStackTrace();
        return "http解析异常！";
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public String error(ArithmeticException e){
        e.printStackTrace();
        return "算数异常！";
    }

//    @ExceptionHandler(BadSqlGrammarException.class)
//    @ResponseBody
//    public String error(BadSqlGrammarException e){
//        e.printStackTrace();
//        return "sql异常！";
//    }

    @ExceptionHandler({FeignException.class})
    @ResponseBody
    public String error(FeignException e){
        e.printStackTrace();
        return "openfeign调用错误！";
    }

}
