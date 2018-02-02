package com.tencent.mars.magicbox;

public interface IPxxLogic$ICallBack {
    String getCrashFilePath(int i);

    String getUplodLogExtrasInfo();

    void recoverLinkAddrs();

    void setNewDnsDebugHostInfo(String str, int i);

    void uploadLogFail();

    void uploadLogResponse(long j, long j2);

    void uploadLogSuccess();
}
