package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class n {
    Boolean hGk = null;

    public n(Context context, a aVar) {
        this.hGk = bm(context);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        context.registerReceiver(new 1(this, aVar, false), intentFilter);
    }

    private Boolean bm(Context context) {
        try {
            x.i("MicroMsg.ScreenState", "reflectScreenOn: byReflect:%s isScreenOn:%s", new Object[]{(Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) context.getSystemService("power"), new Object[0]), this.hGk});
            return (Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) context.getSystemService("power"), new Object[0]);
        } catch (Throwable e) {
            g.pQN.a(99, 154, 1, false);
            x.e("MicroMsg.ScreenState", "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", new Object[]{this.hGk, bh.i(e)});
            return null;
        }
    }
}
