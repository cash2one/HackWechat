package com.tencent.mars.app;

public class AppLogic {
    private static final String TAG = "mars.app.NativeAppJni$C2Java";
    private static ICallBack callBack = null;

    public static void setCallBack(ICallBack iCallBack) {
        callBack = iCallBack;
    }

    public static String getAppFilePath() {
        if (callBack == null) {
            return null;
        }
        return callBack.getAppFilePath();
    }

    private static AccountInfo getAccountInfo() {
        if (callBack == null) {
            return null;
        }
        return callBack.getAccountInfo();
    }

    private static int getClientVersion() {
        if (callBack == null) {
            return 0;
        }
        return callBack.getClientVersion();
    }

    private static DeviceInfo getDeviceType() {
        if (callBack == null) {
            return null;
        }
        return callBack.getDeviceType();
    }

    private static String getCurLanguage() {
        if (callBack == null) {
            return null;
        }
        return callBack.getCurLanguage();
    }
}
