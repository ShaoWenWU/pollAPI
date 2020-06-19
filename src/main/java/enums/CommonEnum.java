package enums;

import com.shaowen.pollAPI.exception.BaseErrorInfoInterface;

public enum CommonEnum implements BaseErrorInfoInterface {


  // error definition
  SUCCESS("200", "OK!"),
  BODY_NOT_MATCH("400"," Bad Request!"),
  SIGNATURE_NOT_MATCH("401","Unauthorized!"),
  NOT_FOUND("404", "Not Found!"),
  INTERNAL_SERVER_ERROR("500", "Internal Server Error!"),
  SERVER_BUSY("503","Service Unavailable!");

  /** error code */
  private String resultCode;

  /** error message */
  private String resultMsg;

  CommonEnum(String resultCode, String resultMsg) {
    this.resultCode = resultCode;
    this.resultMsg = resultMsg;
  }

  @Override
  public String getResultCode() {
    return resultCode;
  }

  @Override
  public String getResultMsg() {
    return resultMsg;
  }

}
