package com.tencent.mars.app;

import com.tencent.mars.app.AppLogic.DeviceInfo;

public interface AppLogic$ICallBack {
    AppLogic$AccountInfo getAccountInfo();

    String getAppFilePath();

    int getClientVersion();

    String getCurLanguage();

    DeviceInfo getDeviceType();
}
