package com.tencent.mm.plugin.talkroom.model;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import com.tencent.mm.plugin.talkroom.component.a.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class g$1 implements ServiceConnection {
    final /* synthetic */ g scg;

    g$1(g gVar) {
        this.scg = gVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        x.i("MicroMsg.TalkRoomServer", "onServiceConnected ");
        if (iBinder == null) {
            g.a(this.scg).J("enterTalkRoom bindServie or protocalInit failed", 3, -1);
            return;
        }
        g.a(this.scg, a.T(iBinder));
        if (g.b(this.scg) >= 2) {
            new af(Looper.getMainLooper()).post(new 1(this));
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        x.i("MicroMsg.TalkRoomServer", "onServiceDisconnected ");
    }
}
