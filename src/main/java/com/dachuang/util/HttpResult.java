package com.dachuang.util;

import com.dachuang.enums.ResultCodeEnum;
import org.apache.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;

public class HttpResult extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public HttpResult() {
        put("code", 200);
        put("msg", "success");
    }

    /**
     * 请求返回结果失败
     *
     * @return 返回结果
     */
    public static HttpResult error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    /**
     * 请求返回结果失败
     *
     * @param msg 失败返回信息
     * @return 返回结果
     */
    public static HttpResult error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    /**
     * 请求返回结果失败
     *
     * @param code 失败响应码
     * @param msg  失败返回信息
     * @return 返回结果
     */
    public static HttpResult error(int code, String msg) {
        HttpResult httpResult = new HttpResult();
        httpResult.put("code", code);
        httpResult.put("msg", msg);
        return httpResult;
    }


    /**
     * 请求返回结果失败
     *
     * @param resultCodeEnum 响应结果集
     * @return 返回结果
     */
    public static HttpResult error(ResultCodeEnum resultCodeEnum) {
        HttpResult httpResult = new HttpResult();
        httpResult.put("code", resultCodeEnum.getCode());
        httpResult.put("msg", resultCodeEnum.getMessage());
        return httpResult;
    }
    /**
     * 请求返回结果成功
     *
     * @param msg 成功返回信息
     * @return 返回结果
     */
    public static HttpResult success(String msg) {
        HttpResult httpResult = new HttpResult();
        httpResult.put("msg", msg);
        return httpResult;
    }

    /**
     * 请求返回结果成功
     *
     * @param map 返回数据集
     * @return 返回结果
     */
    public static HttpResult success(Map<String, Object> map) {
        HttpResult httpResult = new HttpResult();
        httpResult.putAll(map);
        return httpResult;
    }

    /**
     * 请求返回结果成功
     *
     * @return 返回结果
     */
    public static HttpResult success() {
        return new HttpResult();
    }

    /**
     * 请求返回结果成功
     *
     * @param data 数据
     * @return 返回结果
     */
    public static HttpResult success(Object data){
        return success().put("data", data);
    }

    /**
     * 往请求返回结果添加数据
     *
     * @param key   数据名称
     * @param value 数据值
     * @return 返回结果
     */
    @Override
    public HttpResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    /**
     * 封装成 msg code data形式
     *
     * @param data 需要封装得数据
     * @return 返回结果
     */
    public HttpResult setData(Object data) {
        super.put("data", data);
        return this;
    }
}
