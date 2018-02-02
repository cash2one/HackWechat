package com.tencent.wework.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.wework.api.model.BaseMessage;
import com.tencent.wework.api.model.WWBaseRespMessage;
import com.tencent.wework.api.utils.Log;

class WWAPIImpl$1 extends BroadcastReceiver {
    final /* synthetic */ WWAPIImpl Apw;

    WWAPIImpl$1(WWAPIImpl wWAPIImpl) {
        this.Apw = wWAPIImpl;
    }

    public void onReceive(Context context, Intent intent) {
        try {
            if (WWAPIImpl.a(this.Apw).equals(intent.getScheme())) {
                BaseMessage n = BaseMessage.n(intent.getData());
                if (n instanceof WWBaseRespMessage) {
                    new Handler(Looper.getMainLooper()).post(new 1(this, n));
                    return;
                }
                return;
            }
            Log.w("WWAPIImpl", "invalid schema: " + intent.getScheme());
        } catch (Throwable th) {
            Log.e("WWAPIImpl", "handle broadcast failed", th);
        }
    }
}
