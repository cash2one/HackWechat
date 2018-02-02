package com.tencent.mm.plugin.gwallet.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mm.plugin.gwallet.a.b.a;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements ServiceConnection {
    final /* synthetic */ a nzW;
    final /* synthetic */ b nzX;

    b$1(b bVar, a aVar) {
        this.nzX = bVar;
        this.nzW = aVar;
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        b.Cu("Billing service disconnected.");
        this.nzX.nzP = null;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        b.Cu("Billing service connected.");
        this.nzX.nzP = com.a.a.a.a.a.c(iBinder);
        String packageName = this.nzX.mContext.getPackageName();
        try {
            b.Cu("Checking for in-app billing 3 support.");
            int c = this.nzX.nzP.c(3, packageName, "inapp");
            if (c != 0) {
                if (this.nzW != null) {
                    this.nzW.a(new c(c, "Error checking for billing v3 support."));
                }
                this.nzX.nzS = false;
                return;
            }
            b.Cu("In-app billing version 3 supported for " + packageName);
            int c2 = this.nzX.nzP.c(3, packageName, "subs");
            if (c2 == 0) {
                b.Cu("Subscriptions AVAILABLE.");
                this.nzX.nzS = true;
            } else {
                b.Cu("Subscriptions NOT AVAILABLE. Response: " + c2);
            }
            this.nzX.nzR = true;
            if (this.nzW != null) {
                this.nzW.a(new c(0, "Setup successful."));
            }
        } catch (Throwable e) {
            if (this.nzW != null) {
                this.nzW.a(new c(-1001, "RemoteException while setting up in-app billing."));
            }
            x.printErrStackTrace("MicroMsg.IabHelper", e, "", new Object[0]);
        }
    }
}
