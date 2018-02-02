package com.tencent.mm.remoteservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.mm.remoteservice.c.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class d {
    private Context context;
    private ServiceConnection lrm = new ServiceConnection(this) {
        final /* synthetic */ d xbi;

        {
            this.xbi = r1;
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            this.xbi.xbh = null;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.xbi.xbh = a.ac(iBinder);
            for (Runnable run : (Runnable[]) this.xbi.xbg.toArray(new Runnable[this.xbi.xbg.size()])) {
                run.run();
            }
            this.xbi.xbg.clear();
        }
    };
    List<Runnable> xbg = new LinkedList();
    c xbh;

    public d(Context context) {
        this.context = context;
    }

    public final void I(Runnable runnable) {
        new StringBuilder("RemoteServiceProxy construct, thread id:").append(Thread.currentThread().getId());
        if (isConnected()) {
            runnable.run();
            return;
        }
        this.xbg.add(runnable);
        this.context.bindService(new Intent(this.context, RemoteService.class), this.lrm, 1);
    }

    public final boolean isConnected() {
        return this.xbh != null && this.xbh.asBinder().isBinderAlive();
    }

    public final void release() {
        if (this.xbh != null && this.lrm != null) {
            this.context.unbindService(this.lrm);
            this.xbh = null;
        }
    }

    final void a(b bVar, String str, Bundle bundle) {
        if (isConnected()) {
            try {
                this.xbh.a(bVar.getClass().getName(), str, bundle, bVar);
            } catch (Throwable e) {
                x.e("MicroMsg.RemoteServiceProxy", "exception:%s", new Object[]{bh.i(e)});
            }
        }
    }
}
