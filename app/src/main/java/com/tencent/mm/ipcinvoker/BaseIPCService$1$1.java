package com.tencent.mm.ipcinvoker;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.ipcinvoker.BaseIPCService.1;
import com.tencent.mm.ipcinvoker.b.b;
import com.tencent.mm.sdk.platformtools.x;

class BaseIPCService$1$1 implements Runnable {
    final /* synthetic */ Bundle fhp;
    final /* synthetic */ a gMf;
    final /* synthetic */ b gMg;
    final /* synthetic */ 1 gMh;

    BaseIPCService$1$1(1 1, a aVar, Bundle bundle, b bVar) {
        this.gMh = 1;
        this.gMf = aVar;
        this.fhp = bundle;
        this.gMg = bVar;
    }

    public final void run() {
        this.gMf.a(this.fhp, new c(this) {
            final /* synthetic */ BaseIPCService$1$1 gMi;

            {
                this.gMi = r1;
            }

            public final void i(Bundle bundle) {
                if (this.gMi.gMg != null) {
                    if (bundle != null) {
                        try {
                            bundle.setClassLoader(BaseIPCService.class.getClassLoader());
                        } catch (RemoteException e) {
                            x.e("IPC.BaseIPCService", "%s", new Object[]{e});
                            return;
                        }
                    }
                    this.gMi.gMg.i(bundle);
                }
            }
        });
    }
}
