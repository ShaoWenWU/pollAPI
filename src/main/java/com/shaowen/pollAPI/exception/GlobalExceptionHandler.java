package com.shaowen.pollAPI.exception;

import com.shaowen.pollAPI.Result.ResultBody;
import enums.CommonEnum;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

  private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  /**
   * Custom exception handling
   *
   * @param req
   * @param e
   * @return
   */
  @ExceptionHandler(value = BizException.class)
  @ResponseBody
  public ResultBody bizExceptionHandler(HttpServletRequest req, BizException e) {
    logger.error("Error happened！Message：{}", e.getErrorMsg());
    return ResultBody.error(e.getErrorCode(), e.getErrorMsg());
  }

  /**
   * Null pointer exception handling 400
   *
   * @param req
   * @param e
   * @return
   */
  @ExceptionHandler(value = NullPointerException.class)
  @ResponseBody
  public ResultBody exceptionHandler(HttpServletRequest req, NullPointerException e) {
    logger.error("Null pointer error！Message:", e);
    return ResultBody.error(CommonEnum.BODY_NOT_MATCH);
  }

  /**
   * Error Page 404
   *
   * @param req
   * @param e
   * @return
   */
  @ExceptionHandler(value = NoHandlerFoundException.class)
  @ResponseBody
  public ResultBody NoHandlerFoundExceptionHandler(HttpServletRequest req, Exception e) {
    logger.error("Other exception！Message:", e);
    return ResultBody.error(CommonEnum.NOT_FOUND);
  }

  /**
   * Other exceptions
   *
   * @param req
   * @param e
   * @return
   */
  @ExceptionHandler(value = Exception.class)
  @ResponseBody
  public ResultBody exceptionHandler(HttpServletRequest req, Exception e) {
    logger.error("Other exception！Message:", e);
    return ResultBody.error(CommonEnum.INTERNAL_SERVER_ERROR);
  }

}
