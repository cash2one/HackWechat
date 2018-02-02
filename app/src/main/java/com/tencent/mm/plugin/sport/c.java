package com.tencent.mm.plugin.sport;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.b.b;
import com.tencent.mm.plugin.sport.b.e;
import com.tencent.mm.plugin.sport.c.a;
import com.tencent.mm.plugin.sport.c.d;
import com.tencent.mm.plugin.sport.c.f;
import com.tencent.mm.plugin.sport.c.i;
import com.tencent.mm.plugin.sport.c.l;
import com.tencent.mm.plugin.sport.c.m;
import com.tencent.mm.plugin.sport.c.n;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.Date;
import java.util.List;

public final class c implements b {
    public final void bDc() {
        a deviceStepManager = ((PluginSport) g.k(PluginSport.class)).getDeviceStepManager();
        x.i("MicroMsg.Sport.DeviceStepManager", "uploadDeviceStep");
        deviceStepManager.bDm();
        deviceStepManager.fb(deviceStepManager.bDl());
    }

    public final void a(String str, String str2, int i, int i2, int i3, String str3) {
        g.CG().a(new f(str, str2, i, i2, i3, str3, 1), 0);
    }

    public final boolean dz(Context context) {
        return n.dz(context);
    }

    public final boolean bDd() {
        return n.bDd();
    }

    public final void I(int i, long j) {
        i.M(i, j);
    }

    public final void bDe() {
        if (ac.cfw()) {
            ((PluginSport) g.k(PluginSport.class)).getSportFileStorage().reset();
            com.tencent.mm.plugin.sport.a.a aVar = ((PluginSport) g.k(PluginSport.class)).getDeviceStepManager().rTI;
            if (aVar != null) {
                try {
                    aVar.bDj();
                } catch (RemoteException e) {
                }
            }
            new File(com.tencent.mm.plugin.sport.b.a.rTC).delete();
        }
    }

    public final void d(Activity activity, String str) {
        ag.y(new 1(this, activity, str));
    }

    public final void bDf() {
        if (n.rUl != null) {
            n.rUl.dismiss();
            n.rUl = null;
        }
    }

    public final List<e> B(long j, long j2) {
        l sportStepManager = ((PluginSport) g.k(PluginSport.class)).getSportStepManager();
        x.i("MicroMsg.Sport.SportStepManager", "getSportItemListByPeriod: begin=%s end=%s", sportStepManager.rUg.format(new Date(j)), sportStepManager.rUg.format(new Date(j2)));
        ((PluginSport) g.k(PluginSport.class)).getSportStepStorage();
        return m.C(j, j2);
    }

    public final e bDg() {
        ((PluginSport) g.k(PluginSport.class)).getSportStepManager();
        ((PluginSport) g.k(PluginSport.class)).getSportStepStorage();
        return m.bDg();
    }

    public final void a(long j, long j2, com.tencent.mm.plugin.sport.b.c cVar) {
        x.i("MicroMsg.Sport.SportStepManager", "updateSportStepFromServer: begin=%s end=%s", r0.rUg.format(new Date(j)), ((PluginSport) g.k(PluginSport.class)).getSportStepManager().rUg.format(new Date(j2)));
        k dVar = new d(j, j2, cVar);
        g.CG().a(1734, r0.hnN);
        g.CG().a(dVar, 0);
    }
}
