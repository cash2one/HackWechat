package com.tencent.mm.ipcinvoker;

import android.os.Parcelable;
import android.os.RemoteException;
import com.tencent.mm.ipcinvoker.b.b;
import com.tencent.mm.ipcinvoker.f.a;
import com.tencent.mm.sdk.platformtools.x;

class f$2 implements Runnable {
    final /* synthetic */ Class gMA;
    final /* synthetic */ Parcelable gMD;
    final /* synthetic */ String gMo;
    final /* synthetic */ i gMv;

    f$2(String str, Parcelable parcelable, Class cls, i iVar) {
        this.gMo = str;
        this.gMD = parcelable;
        this.gMA = cls;
        this.gMv = iVar;
    }

    public final void run() {
        if (e.fh(this.gMo)) {
            ((a) o.a(a.class, a.class)).a(f.b(this.gMD, this.gMA), new 1(this));
            return;
        }
        com.tencent.mm.ipcinvoker.b.a ff = b.Bs().ff(this.gMo);
        if (ff == null) {
            x.e("IPC.IPCInvoker", "invokeAsync failed, get bridge is null by process(%s).", new Object[]{this.gMo});
            return;
        }
        b bVar = null;
        try {
            if (this.gMv != null) {
                bVar = new 2(this);
            }
            ff.a(f.b(this.gMD, this.gMA), a.class.getName(), bVar);
        } catch (RemoteException e) {
            x.d("IPC.IPCInvoker", "invokeAsync failed, ipc invoke error : %s", new Object[]{e});
        }
    }
}
