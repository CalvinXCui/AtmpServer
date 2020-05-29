/*
 * This file is part of the Wildfire Chat package.
 * (c) Heavyrain2012 <heavyrain.lee@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package cn.wildfirechat.common;

public enum ErrorCode {
    //General error
    ERROR_CODE_SUCCESS(0, "请求成功"),
    ERROR_CODE_SECRECT_KEY_MISMATCH(1, "私钥不匹配"),
    ERROR_CODE_INVALID_DATA(2, "无效数据"),
    ERROR_CODE_NODE_NOT_EXIST(3, "节点不存在"),
    ERROR_CODE_SERVER_ERROR(4, "服务器错误"),
    ERROR_CODE_NOT_MODIFIED(5, "未修改"),


    //Auth error
    ERROR_CODE_TOKEN_ERROR(6, "令牌错误"),
    ERROR_CODE_USER_FORBIDDEN(8, "用户禁止"),

    //Message error
    ERROR_CODE_NOT_IN_GROUP(9, "不分组"),
    ERROR_CODE_INVALID_MESSAGE(10, "无效讯息"),

    //Group error
    ERROR_CODE_GROUP_ALREADY_EXIST(11, "组已经存在"),


    //user error
    ERROR_CODE_PASSWORD_INCORRECT(15, "密码错误"),

    //user error
    ERROR_CODE_FRIEND_ALREADY_REQUEST(16, "已经发送请求"),
    ERROR_CODE_FRIEND_REQUEST_BLOCKED(18, "好友请求被阻止"),
    ERROR_CODE_FRIEND_REQUEST_EXPIRED(19, "好友请求已过期"),

    ERROR_CODE_NOT_IN_CHATROOM(20, "不在聊天室"),

    ERROR_CODE_NOT_IN_CHANNEL(21, "不在频道中"),

    ERROR_CODE_ALREADY_FRIENDS(23, "已经是好友"),

    ERROR_CODE_GROUP_MUTED(241, "组被静音"),
    ERROR_CODE_SENSITIVE_MATCHED(242, "敏感匹配"),
    ERROR_CODE_SIGN_EXPIRED(243, "标志过期"),
    ERROR_CODE_AUTH_FAILURE(244, "身份验证失败"),
    ERROR_CODE_CLIENT_COUNT_OUT_OF_LIMIT(245, "客户数超出限制"),
    ERROR_CODE_IN_BLACK_LIST(246, "黑名单中的用户"),
    ERROR_CODE_FORBIDDEN_SEND_MSG(247, "禁止全球发送信息"),
    ERROR_CODE_NOT_RIGHT(248, "无权经营"),
    ERROR_CODE_TIMEOUT(249, "超时"),
    ERROR_CODE_OVER_FREQUENCY(250, "频率过快"),
    INVALID_PARAMETER(251, "无效的参数"),
    ERROR_CODE_NOT_EXIST(253, "不存在"),
    ERROR_CODE_NOT_IMPLEMENT(254, "不执行"),


    ERROR_CODE_SUCCESS_GZIPED(255, "gzip响应成功"),;

    public int code;
    public String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ErrorCode fromCode(int code) {
        for (ErrorCode errorCode : ErrorCode.values()) {
            if(errorCode.code == (code&0xff)) {
                return errorCode;
            }
        }
        return ERROR_CODE_SERVER_ERROR;
    }
    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
