package com.tencent.mm.vending.app;

import android.os.Handler;
import android.os.Message;
import android.util.SparseIntArray;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    private static b zBe;
    Map<c, a> zBf = new ConcurrentHashMap();
    final SparseIntArray zBg = new SparseIntArray();
    final Handler zBh = new Handler(this, com.tencent.mm.vending.i.b.cAb().zCY.getLooper()) {
        final /* synthetic */ b zBi;

        public final void handleMessage(Message message) {
            a aVar = (a) message.obj;
            switch (message.what) {
                case 1:
                    aVar.onCreate();
                    synchronized (aVar.zAU) {
                        aVar.zAX = true;
                        aVar.zAU.notify();
                    }
                    return;
                case 4:
                    aVar.onDestroy();
                    return;
                default:
                    return;
            }
        }
    };

    static {
        zBe = null;
        zBe = new b();
    }

    public static b czG() {
        return zBe;
    }
}
