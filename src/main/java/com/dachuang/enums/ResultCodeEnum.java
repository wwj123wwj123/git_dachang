package com.dachuang.enums;

/**
 * 统一结果集返回码
 * #200 表示成功
 * #1001～1999 区间表示参数错误
 * #2001～2999 区间表示用户错误
 * #3001～3999 区间表示接口异常
 *
 * @author AJAXJJ
 * @date 下午8:05 9/5/2022
 */
public enum ResultCodeEnum {

    /* 成功 */
    SUCCESS(200, "成功"),

    /* 默认失败 */
    COMMON_FAIL(500, "失败"),
    /* 系统错误 */
    CLIENT_AUTHENTICATION_FAILED(801, "客户端认证失败"),
    UNSUPPORTED_GRANT_TYPE(802, "不支持的认证模式"),
    NO_PATH(803,"访问无效"),

    /* 参数错误：1000~1999 */
    PARAM_NOT_VALID(1001, "参数无效"),
    PARAM_IS_BLANK(1002, "参数为空"),
    PARAM_TYPE_ERROR(1003, "参数类型错误"),
    PARAM_NOT_COMPLETE(1004, "参数缺失"),
    INVALID_TOKEN(1005, "无效的token"),
    PARAMETER_CHECK_ERROR(1006, "参数校验异常"),

    /* 用户错误：2001~2999 */
    USER_NOT_LOGIN(2001, "用户未登录"),
    USER_CREDENTIALS_ERROR(2002, "用户名或密码错误"),
    USER_ACCOUNT_NOT_EXIST(2003, "账号不存在"),
    USER_ACCOUNT_ALREADY_EXIST(2004, "账号已存在"),
    USER_NOT_EXIST(2005,"用户不存在"),
    USER_ALREADY_EXIST(2006,"用户已存在"),


    /* 业务错误 */
    NO_PERMISSION(3001, "没有权限"),
    SERVER_ERROR(3002, "系统繁忙，请稍后重试！"),

    /* 微信接口错误 */
    INVALID_JS_CODE(4001,"登录凭证code无效!"),
    API_CALLS_FREQUENT(4002,"API调用太频繁，请稍候再试!"),
    HIGH_RISK_USER(4003,"高风险等级用户，已拦截"),
    SYSTEM_BUSY(4004,"微信API系统繁忙请稍后再试"),
    USER_NOT_FOLLOWING(4005,"用户未绑定"),
    CODE_BE_USED(4006,"登录凭证被使用");


    /**
     * 响应码
     */
    private final Integer code;
    /**
     * 提示信息
     */
    private final String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 获取响应码对应提示信息
     *
     * @param code 响应码
     * @return 提示信息
     */
    public static String getMessage(Integer code) {
        for (ResultCodeEnum result : ResultCodeEnum.values()) {
            if (result.getCode().equals(code)) {
                return result.getMessage();
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}