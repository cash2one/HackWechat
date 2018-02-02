package com.tencent.mm.app;

import android.content.Context;
import com.tencent.mm.pluginsdk.q.e;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMAppMgr;

class WorkerProfile$25 implements e {
    final /* synthetic */ WorkerProfile fgz;

    WorkerProfile$25(WorkerProfile workerProfile) {
        this.fgz = workerProfile;
    }

    public final void ar(Context context) {
        MMAppMgr.b(context, true);
    }

    public final boolean uz() {
        if (!(d.vAC || com.tencent.mm.bm.d.Th("whatsnew"))) {
            x.i("MicroMsg.MMAppMgr", "plugin cannot load");
        }
        return false;
    }

    public final void b(Context context, boolean z) {
        MMAppMgr.b(context, z);
    }
}
