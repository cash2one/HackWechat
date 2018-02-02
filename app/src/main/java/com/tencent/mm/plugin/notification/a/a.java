package com.tencent.mm.plugin.notification.a;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class a implements b {
    private final String TAG = "MicroMsg.NotificationObserver";
    private af mHandler = new 1(this, Looper.getMainLooper());
    private final int oTN = 50;
    public boolean oTO = false;

    public final void a(int i, m mVar, Object obj) {
        x.i("MicroMsg.NotificationObserver", "event: %d", new Object[]{Integer.valueOf(i)});
        if (!(obj instanceof String) || bh.ov((String) obj)) {
            x.d("MicroMsg.NotificationObserver", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        int i2;
        if (ar.GZ()) {
            i2 = 0;
        } else {
            ar.Hg();
            i2 = (int) c.EY().WM((String) obj).gJd;
        }
        this.mHandler.removeMessages(i2);
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putString("com.tencent.mm.notification.observer", (String) obj);
        obtain.setData(bundle);
        obtain.what = i2;
        this.mHandler.sendMessageDelayed(obtain, 50);
    }
}
