package com.tenpay.android.wechat;

public interface PayuSecureEncrypt$EncrptType {
    public static final int CARD_NUMBER = 50;
    public static final int CVV = 30;
    public static final int DEFAULT = 0;
    public static final int HASHED_PASSWORD = -10;
    public static final int HASHED_SECRET_ANSWER = -20;
    public static final int PASSWORD = 20;
    public static final int SECRET_ANSWER = 40;
    public static final int VERIFY_CODE = 60;
}
