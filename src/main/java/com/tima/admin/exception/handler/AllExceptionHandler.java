package com.tima.admin.exception.handler;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;
import com.tima.admin.enums.ResultEnum;
import com.tima.admin.exception.ServiceException;
import com.tima.admin.util.ResultVOUtil;
import com.tima.admin.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class AllExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultVO handlerException(HttpServletRequest request, Exception e) {
        log.error("【异常拦截】" + "[" + request.getRequestURI() + "]" + "接口出现错误," + e.getMessage());
        if (e instanceof ServiceException) { //业务异常 如账号密码错误
            return ResultVOUtil.returnFail(((ServiceException) e).getCode(), e.getMessage());
        } else if (e instanceof NoHandlerFoundException) { //404接口不存在
            return ResultVOUtil.returnFail(ResultEnum.NO_HANDLER.getCode(), ResultEnum.NO_HANDLER.getMessage());
        } else if (e instanceof ServletException) { //400接口报错
            return ResultVOUtil.returnFail(ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getMessage());
        } else { //500错误
            log.error("系统内部错误", e);
            return ResultVOUtil.returnFail(ResultEnum.SERVER_ERROR.getCode(), ResultEnum.SERVER_ERROR.getMessage());
        }
    }
    /**
     * 字段验证异常处理
     *
     * @param req 请求内容
     * @param e   异常信息
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultVO methodArgumentNotValidExceptionErrorHandler(HttpServletRequest request, Exception e) {
    	log.error("【字段验证异常拦截】" + "[" + request.getRequestURI() + "]" + "接口出现错误," + e.getMessage());
        MethodArgumentNotValidException c = (MethodArgumentNotValidException) e;
        List<FieldError> errors = c.getBindingResult().getFieldErrors();        
        StringBuffer errorMsg = new StringBuffer();
        for (FieldError err : errors) {
            String message = err.getDefaultMessage();
            errorMsg.append(err.getField() + ":" + message + ",");
        }

        return ResultVOUtil.returnFail(ResultEnum.NO_VALID_PARAM.getCode(), errorMsg.toString());
    }
}