package com.tencent.mm.ipcinvoker;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.ipcinvoker.b.a;
import com.tencent.mm.ipcinvoker.b.b;
import com.tencent.mm.sdk.platformtools.x;

class f$1 implements Runnable {
    final /* synthetic */ Bundle fhp;
    final /* synthetic */ Class gMA;
    final /* synthetic */ c gMB;
    final /* synthetic */ String gMo;

    f$1(String str, Class cls, Bundle bundle, c cVar) {
        this.gMo = str;
        this.gMA = cls;
        this.fhp = bundle;
        this.gMB = cVar;
    }

    public final void run() {
        if (e.fh(this.gMo)) {
            a aVar = (a) o.a(this.gMA, a.class);
            if (aVar == null) {
                x.e("IPC.IPCInvoker", "invokeAsync failed, newInstance(%s) return null.", new Object[]{this.gMA});
                return;
            }
            aVar.a(this.fhp, this.gMB);
            return;
        }
        a ff = b.Bs().ff(this.gMo);
        if (ff == null) {
            x.e("IPC.IPCInvoker", "invokeAsync failed, get bridge is null by process(%s).", new Object[]{this.gMo});
            return;
        }
        b bVar = null;
        try {
            if (this.gMB != null) {
                bVar = new b.a(this) {
                    final /* synthetic */ f$1 gMC;

                    {
                        this.gMC = r1;
                    }

                    public final void i(Bundle bundle) {
                        if (bundle != null) {
                            bundle.setClassLoader(f.class.getClassLoader());
                        }
                        this.gMC.gMB.i(bundle);
                    }
                };
            }
            ff.a(this.fhp, this.gMA.getName(), bVar);
        } catch (RemoteException e) {
            x.d("IPC.IPCInvoker", "invokeAsync failed, ipc invoke error : %s", new Object[]{e});
        }
    }
}
