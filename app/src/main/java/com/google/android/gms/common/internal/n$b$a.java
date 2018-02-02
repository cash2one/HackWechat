package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.n.b;

public class n$b$a implements ServiceConnection {
    final /* synthetic */ b aOJ;

    public n$b$a(b bVar) {
        this.aOJ = bVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (n.a(this.aOJ.aOI)) {
            this.aOJ.aMY = iBinder;
            this.aOJ.aOD = componentName;
            for (ServiceConnection onServiceConnected : this.aOJ.aOF) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.aOJ.mState = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (n.a(this.aOJ.aOI)) {
            this.aOJ.aMY = null;
            this.aOJ.aOD = componentName;
            for (ServiceConnection onServiceDisconnected : this.aOJ.aOF) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.aOJ.mState = 2;
        }
    }
}
