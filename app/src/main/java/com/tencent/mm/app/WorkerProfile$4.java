package com.tencent.mm.app;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.t;

class WorkerProfile$4 extends c<com.tencent.mm.g.a.c> {
    final /* synthetic */ WorkerProfile fgz;

    WorkerProfile$4(WorkerProfile workerProfile) {
        this.fgz = workerProfile;
        this.xen = com.tencent.mm.g.a.c.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        com.tencent.mm.g.a.c cVar = (com.tencent.mm.g.a.c) bVar;
        Context context = cVar.fmL.fmM;
        t.a(context, cVar.fmL.errType, cVar.fmL.errCode, new Intent().setClass(context, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), null);
        return false;
    }
}
