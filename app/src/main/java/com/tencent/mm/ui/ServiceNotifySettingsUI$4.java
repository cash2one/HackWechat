package com.tencent.mm.ui;

import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.a.sg;
import com.tencent.mm.protocal.c.bmx;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.Iterator;
import java.util.LinkedList;

class ServiceNotifySettingsUI$4 implements e {
    final /* synthetic */ ServiceNotifySettingsUI xMq;
    final /* synthetic */ boolean xMr;
    final /* synthetic */ boolean xMs;
    final /* synthetic */ LinkedList xMt;
    final /* synthetic */ int xMu;

    ServiceNotifySettingsUI$4(ServiceNotifySettingsUI serviceNotifySettingsUI, boolean z, boolean z2, LinkedList linkedList, int i) {
        this.xMq = serviceNotifySettingsUI;
        this.xMr = z;
        this.xMs = z2;
        this.xMt = linkedList;
        this.xMu = i;
    }

    public final void a(int i, int i2, String str, k kVar) {
        ar.CG().b(1176, this);
        x.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(BatchSwitchServiceNotifyOption), errType : %s, errCode : %s, errMsg : %s.", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            u.makeText(this.xMq, R.l.ezD, 0).show();
            if (this.xMr) {
                ar.Hg();
                c.CU().a(a.xsq, Boolean.valueOf(this.xMs));
                com.tencent.mm.sdk.b.a.xef.m(new mx());
            }
            Iterator it = this.xMt.iterator();
            while (it.hasNext()) {
                bmx com_tencent_mm_protocal_c_bmx = (bmx) it.next();
                b sgVar = new sg();
                sgVar.fJX.fnl = com_tencent_mm_protocal_c_bmx.wPY;
                sgVar.fJX.action = 1;
                sgVar.fJX.fJZ = this.xMu;
                com.tencent.mm.sdk.b.a.xef.m(sgVar);
            }
        }
    }
}
