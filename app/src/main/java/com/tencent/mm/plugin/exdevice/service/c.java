package com.tencent.mm.plugin.exdevice.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.service.h.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c implements ServiceConnection {
    public a lQd;
    public volatile boolean lQe;
    private List<Runnable> lQf = new LinkedList();

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        List arrayList;
        x.i("MicroMsg.exdevice.ExDeviceServiceConnection", "onServiceConnected");
        x xVar = new x(a.J(iBinder));
        u.a(xVar);
        ac.cfz();
        xVar.a(com.tencent.mm.plugin.exdevice.b.a.aDE());
        xVar.b(com.tencent.mm.plugin.exdevice.model.a.aDP());
        if (!xVar.a(ad.aEw())) {
            x.e("MicroMsg.exdevice.ExDeviceServiceConnection", "simpleBluetoothRegistOnRecv error");
        }
        if (this.lQd != null) {
            this.lQd.onServiceConnected();
        }
        this.lQe = true;
        synchronized (this.lQf) {
            arrayList = new ArrayList(this.lQf);
            this.lQf.clear();
        }
        for (int i = 0; i < arrayList.size(); i++) {
            Runnable runnable = (Runnable) arrayList.get(i);
            if (runnable != null) {
                runnable.run();
            }
        }
        arrayList.clear();
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        x.i("MicroMsg.exdevice.ExDeviceServiceConnection", "onServiceDisconnected");
        this.lQe = false;
        u.a(null);
        ac.cfz();
        if (!ar.Hi() || ar.Cs()) {
            x.i("MicroMsg.exdevice.ExDeviceServiceConnection", "no user login, ignore this disconnection");
        } else {
            cx(ac.getContext());
        }
    }

    public final void cx(Context context) {
        if (!d.cy(context)) {
            x.i("MicroMsg.exdevice.ExDeviceServiceConnection", "ensureServiceInstance return false");
        } else if (context.bindService(new Intent(context, ExDeviceService.class), this, 1)) {
            x.i("MicroMsg.exdevice.ExDeviceServiceConnection", "bind exdeviceservice success");
        } else {
            x.e("MicroMsg.exdevice.ExDeviceServiceConnection", "bind exdeviceservice failed");
        }
    }

    public final boolean v(Runnable runnable) {
        if (this.lQe) {
            runnable.run();
        } else {
            synchronized (this.lQf) {
                this.lQf.add(runnable);
            }
        }
        return true;
    }
}
