package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.k.h;
import com.google.android.gms.common.internal.s.a;

public final class k$e implements ServiceConnection {
    final /* synthetic */ k aOk;
    private final int aOn;

    public k$e(k kVar, int i) {
        this.aOk = kVar;
        this.aOn = i;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        w.i(iBinder, "Expecting a valid IBinder");
        k.a(this.aOk, a.i(iBinder));
        k kVar = this.aOk;
        kVar.mHandler.sendMessage(kVar.mHandler.obtainMessage(6, this.aOn, -1, new h(kVar)));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.aOk.mHandler.sendMessage(this.aOk.mHandler.obtainMessage(4, this.aOn, 1));
    }
}
