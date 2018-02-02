package com.tencent.wework.api.utils;

import com.tencent.wework.api.utils.Log.ILogger;

class Log$WWAPILogger implements ILogger {
    ILogger ApF;

    Log$WWAPILogger(ILogger iLogger) {
        this.ApF = iLogger;
    }

    public final void a(int i, String str, String str2, Throwable th) {
        this.ApF.a(i, "WWAPI-" + str, str2, th);
    }
}
