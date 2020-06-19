package com.shaowen.pollAPI.Result;

import com.shaowen.pollAPI.exception.BaseErrorInfoInterface;
import enums.CommonEnum;
import org.json.JSONObject;

public class ResultBody {

  private String code;
  private String message;
  private Object result;
  public ResultBody() {
  }

  public ResultBody(BaseErrorInfoInterface errorInfo) {
    this.code = errorInfo.getResultCode();
    this.message = errorInfo.getResultMsg();
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getResult() {
    return result;
  }

  public void setResult(Object result) {
    this.result = result;
  }

  /**
   * Success
   *
   * @return
   *
   */
  public static ResultBody success() {
    return success(null);
  }

  /**
   * Success
   * @param data
   * @return
   */
  public static ResultBody success(Object data) {
    ResultBody rb = new ResultBody();
    rb.setCode(CommonEnum.SUCCESS.getResultCode());
    rb.setMessage(CommonEnum.SUCCESS.getResultMsg());
    rb.setResult(data);
    return rb;
  }

  /**
   * error
   */
  public static ResultBody error(BaseErrorInfoInterface errorInfo) {
    ResultBody rb = new ResultBody();
    rb.setCode(errorInfo.getResultCode());
    rb.setMessage(errorInfo.getResultMsg());
    rb.setResult(null);
    return rb;
  }

  /**
   * error
   */
  public static ResultBody error(String code, String message) {
    ResultBody rb = new ResultBody();
    rb.setCode(code);
    rb.setMessage(message);
    rb.setResult(null);
    return rb;
  }

  /**
   * error
   */
  public static ResultBody error( String message) {
    ResultBody rb = new ResultBody();
    rb.setCode("-1");
    rb.setMessage(message);
    rb.setResult(null);
    return rb;
  }

//  @Override
//  public String toString() {
//    return JSONObject.toJSONString(this);
//  }

}
