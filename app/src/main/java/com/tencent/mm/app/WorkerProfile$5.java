package com.tencent.mm.app;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.g.a.io;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.t;

class WorkerProfile$5 extends c<io> {
    final /* synthetic */ WorkerProfile fgz;

    WorkerProfile$5(WorkerProfile workerProfile) {
        this.fgz = workerProfile;
        this.xen = io.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        io ioVar = (io) bVar;
        String str = ioVar.fyX.fyY;
        String str2 = ioVar.fyX.url;
        x.i("MicroMsg.WorkerProfile", "summertoken KickOffline callback wording[%s], url[%s]", new Object[]{str, str2});
        g.pQN.a(322, 21, 1, true);
        Context cmG = LauncherUI.cmG();
        g gVar = g.pQN;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(4021);
        String str3 = "%s|%s|%b";
        Object[] objArr2 = new Object[3];
        objArr2[0] = str;
        objArr2[1] = str2;
        boolean z = cmG == null || cmG.isFinishing();
        objArr2[2] = Boolean.valueOf(z);
        objArr[1] = String.format(str3, objArr2);
        gVar.h(11098, objArr);
        if (cmG == null || cmG.isFinishing()) {
            g.pQN.a(322, 22, 1, true);
            gVar = g.pQN;
            objArr = new Object[2];
            objArr[0] = Integer.valueOf(4022);
            str3 = "%s|%s|%b";
            objArr2 = new Object[3];
            objArr2[0] = str;
            objArr2[1] = str2;
            objArr2[2] = Boolean.valueOf(cmG == null);
            objArr[1] = String.format(str3, objArr2);
            gVar.h(11098, objArr);
            x.w("MicroMsg.WorkerProfile", "summertoken KickOffline error LauncherUI is null launcherisFirst[%b], launcheruiOnTop[%b] return", new Object[]{Boolean.valueOf(this.fgz.fgo), Boolean.valueOf(this.fgz.fgp)});
        }
        t.a(cmG, str, str2, new Intent().setClass(cmG, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864));
        return false;
    }
}
