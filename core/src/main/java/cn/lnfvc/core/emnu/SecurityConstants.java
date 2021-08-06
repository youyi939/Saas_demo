package cn.lnfvc.core.emnu;

/**
 * @Author: KenChen
 * @Description:
 * @Date: Create in  2021/8/6 下午4:41
 */
public final class SecurityConstants {
    public static final String AUTH_LOGIN_URL = "/api/token";
    public static final String JWT_SECRET = "1234567891011121314151617181920212223242526272829303132333435363738394041424344454647484950";
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer";
    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_ISSUER = "secure-api";
    public static final String TOKEN_AUDIENCE = "secure-app";
}
