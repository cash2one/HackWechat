package com.tencent.mapsdk.rastercore.d;

import android.os.Handler;
import android.os.Message;
import com.tencent.mapsdk.rastercore.d.a.1;

final class d extends Handler {
    private /* synthetic */ 1 a;

    d(1 1) {
        this.a = 1;
    }

    public final void handleMessage(Message message) {
        if (message != null) {
            switch (message.what) {
                case 1:
                    1.b(this.a).a(1.a(this.a));
                    return;
                default:
                    return;
            }
        }
    }
}
