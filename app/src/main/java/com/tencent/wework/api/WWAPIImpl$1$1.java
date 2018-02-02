package com.tencent.wework.api;

import com.tencent.wework.api.WWAPIImpl.1;
import com.tencent.wework.api.model.BaseMessage;
import com.tencent.wework.api.model.WWBaseRespMessage;
import com.tencent.wework.api.utils.Log;

class WWAPIImpl$1$1 implements Runnable {
    final /* synthetic */ BaseMessage Apx;
    final /* synthetic */ 1 Apy;

    WWAPIImpl$1$1(1 1, BaseMessage baseMessage) {
        this.Apy = 1;
        this.Apx = baseMessage;
    }

    public void run() {
        try {
            WWAPIImpl.b(this.Apy.Apw).get(((WWBaseRespMessage) this.Apx).transaction);
            WWAPIImpl.b(this.Apy.Apw).remove(((WWBaseRespMessage) this.Apx).transaction);
        } catch (Throwable th) {
            Log.e("WWAPIImpl", "handle message failed", th);
        }
    }
}
