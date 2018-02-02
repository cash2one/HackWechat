package com.tencent.mm.plugin.music.model.notification;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mm.plugin.music.model.notification.MMMusicPlayerService.a;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

class b$2 implements ServiceConnection {
    final /* synthetic */ b oMa;

    b$2(b bVar) {
        this.oMa = bVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        x.i("MicroMsg.Music.MMMusicNotificationHelper", "onServiceConnected");
        if (iBinder instanceof a) {
            this.oMa.oLZ = false;
            this.oMa.oLT = ((a) iBinder).oMd;
            return;
        }
        x.e("MicroMsg.Music.MMMusicNotificationHelper", "service %s isn't MMMusicPlayerService, err, return", iBinder.getClass().getName());
        Assert.assertTrue(false);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        x.i("MicroMsg.Music.MMMusicNotificationHelper", "onServiceDisconnected");
        this.oMa.oLZ = false;
        this.oMa.oLT = null;
    }
}
