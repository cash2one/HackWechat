package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

final class n extends m implements Callback {
    private final Context aGj;
    private final long aOA;
    private final HashMap<a, b> aOy = new HashMap();
    private final com.google.android.gms.common.stats.b aOz;
    private final Handler mHandler;

    private final class b {
        IBinder aMY;
        ComponentName aOD;
        final a aOE = new a(this);
        final Set<ServiceConnection> aOF = new HashSet();
        boolean aOG;
        final a aOH;
        final /* synthetic */ n aOI;
        int mState = 2;

        public b(n nVar, a aVar) {
            this.aOI = nVar;
            this.aOH = aVar;
        }

        public final void a(ServiceConnection serviceConnection, String str) {
            this.aOI.aOz.a(this.aOI.aGj, serviceConnection, str, this.aOH.oP(), 3);
            this.aOF.add(serviceConnection);
        }

        public final boolean a(ServiceConnection serviceConnection) {
            return this.aOF.contains(serviceConnection);
        }

        public final void aJ(String str) {
            this.aOG = this.aOI.aOz.a(this.aOI.aGj, str, this.aOH.oP(), this.aOE, 129);
            if (this.aOG) {
                this.mState = 3;
                return;
            }
            try {
                this.aOI.aOz.a(this.aOI.aGj, this.aOE);
            } catch (IllegalArgumentException e) {
            }
        }

        public final boolean oQ() {
            return this.aOF.isEmpty();
        }
    }

    n(Context context) {
        this.aGj = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.aOz = com.google.android.gms.common.stats.b.pi();
        this.aOA = 5000;
    }

    private void a(a aVar, ServiceConnection serviceConnection) {
        w.i(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.aOy) {
            b bVar = (b) this.aOy.get(aVar);
            if (bVar == null) {
                throw new IllegalStateException("Nonexistent connection status for service config: " + aVar);
            } else if (bVar.a(serviceConnection)) {
                bVar.aOI.aOz.a(bVar.aOI.aGj, serviceConnection, null, null, 4);
                bVar.aOF.remove(serviceConnection);
                if (bVar.oQ()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, bVar), this.aOA);
                }
            } else {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + aVar);
            }
        }
    }

    private boolean a(a aVar, ServiceConnection serviceConnection, String str) {
        boolean z;
        w.i(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.aOy) {
            b bVar = (b) this.aOy.get(aVar);
            if (bVar != null) {
                this.mHandler.removeMessages(0, bVar);
                if (!bVar.a(serviceConnection)) {
                    bVar.a(serviceConnection, str);
                    switch (bVar.mState) {
                        case 1:
                            serviceConnection.onServiceConnected(bVar.aOD, bVar.aMY);
                            break;
                        case 2:
                            bVar.aJ(str);
                            break;
                        default:
                            break;
                    }
                }
                throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + aVar);
            }
            bVar = new b(this, aVar);
            bVar.a(serviceConnection, str);
            bVar.aJ(str);
            this.aOy.put(aVar, bVar);
            z = bVar.aOG;
        }
        return z;
    }

    public final boolean a(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return a(new a(componentName), serviceConnection, str);
    }

    public final boolean a(String str, String str2, ServiceConnection serviceConnection, String str3) {
        return a(new a(str, str2), serviceConnection, str3);
    }

    public final void b(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        a(new a(componentName), serviceConnection);
    }

    public final void b(String str, String str2, ServiceConnection serviceConnection, String str3) {
        a(new a(str, str2), serviceConnection);
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                b bVar = (b) message.obj;
                synchronized (this.aOy) {
                    if (bVar.oQ()) {
                        if (bVar.aOG) {
                            bVar.aOI.aOz.a(bVar.aOI.aGj, bVar.aOE);
                            bVar.aOG = false;
                            bVar.mState = 2;
                        }
                        this.aOy.remove(bVar.aOH);
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
