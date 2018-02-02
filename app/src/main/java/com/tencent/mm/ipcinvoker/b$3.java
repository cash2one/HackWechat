package com.tencent.mm.ipcinvoker;

import android.content.ServiceConnection;
import android.util.Log;
import com.tencent.mm.ipcinvoker.b.a;
import com.tencent.mm.sdk.platformtools.x;

class b$3 implements Runnable {
    final /* synthetic */ String gMo;
    final /* synthetic */ b gMp;
    final /* synthetic */ a gMq;

    b$3(b bVar, a aVar, String str) {
        this.gMp = bVar;
        this.gMq = aVar;
        this.gMo = str;
    }

    public final void run() {
        synchronized (this.gMq) {
            ServiceConnection serviceConnection = this.gMq.gMs;
        }
        if (serviceConnection == null) {
            x.i("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, ServiceConnection is null.", new Object[]{this.gMo});
            return;
        }
        try {
            e.getContext().unbindService(serviceConnection);
        } catch (Throwable e) {
            x.e("IPC.IPCBridgeManager", "unbindService(%s) error, %s", new Object[]{this.gMo, Log.getStackTraceString(e)});
        }
        synchronized (b.a(this.gMp)) {
            b.a(this.gMp).remove(this.gMo);
        }
        synchronized (this.gMq) {
            this.gMq.gMr = null;
            this.gMq.gMt = false;
            this.gMq.gMs = null;
        }
    }
}
