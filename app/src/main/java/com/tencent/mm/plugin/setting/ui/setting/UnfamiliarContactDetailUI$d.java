package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ay.a;
import com.tencent.mm.ay.c;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.g;
import com.tencent.mm.protocal.c.avd;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class UnfamiliarContactDetailUI$d implements e, Runnable {
    int index = 0;
    int ooY = 0;
    final /* synthetic */ UnfamiliarContactDetailUI qma;
    g qmp;
    Collection<Integer> qmq;
    int qmr = 0;
    LinkedList<String> qms = new LinkedList();
    LinkedList<b> qmt = new LinkedList();

    UnfamiliarContactDetailUI$d(UnfamiliarContactDetailUI unfamiliarContactDetailUI, Collection<Integer> collection, g gVar) {
        this.qma = unfamiliarContactDetailUI;
        this.qmq = collection;
        this.qmp = gVar;
    }

    public final void run() {
        this.ooY = this.qmq.size();
        for (Integer intValue : this.qmq) {
            int intValue2 = intValue.intValue();
            this.index++;
            int size = this.qmq.size();
            int i = this.index;
            if (UnfamiliarContactDetailUI.e(this.qma) != null) {
                this.qmt.add(new c(UnfamiliarContactDetailUI.e(this.qma).vY(intValue2).jLe.field_username));
                if (this.qmt.size() % 20 == 0 || i == size) {
                    com.tencent.mm.kernel.g.Dk();
                    com.tencent.mm.kernel.g.Di().gPJ.a(new a(this.qmt), 0);
                    this.qmt.clear();
                }
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() != 681) {
            return;
        }
        if (((a) kVar).hIJ == null || ((a) kVar).hIJ.hIM == null) {
            x.e("MicroMsg.UnfamiliarContactUI", "[onSceneEnd] rr is null!");
            return;
        }
        avd com_tencent_mm_protocal_c_avd = ((a) kVar).hIJ.hIM.hIO;
        if (com_tencent_mm_protocal_c_avd.vJU != 0 || com_tencent_mm_protocal_c_avd.wCP == null || com_tencent_mm_protocal_c_avd.wCP.wkm == null) {
            x.e("MicroMsg.UnfamiliarContactUI", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_avd.vJU)});
            return;
        }
        List list = ((a) kVar).hIK;
        x.i("MicroMsg.UnfamiliarContactUI", "[onSceneEnd] list size:%s, result:%s", new Object[]{Integer.valueOf(list.size()), Integer.valueOf(com_tencent_mm_protocal_c_avd.wCP.wkm.size())});
        for (int i3 = 0; i3 < list.size(); i3++) {
            b bVar = (b) list.get(i3);
            if (bVar.getCmdId() == 4 && (bVar instanceof c)) {
                this.ooY--;
                c cVar = (c) bVar;
                if (((Integer) r5.get(i3)).intValue() == 0) {
                    this.qmr++;
                    af WO = ((h) com.tencent.mm.kernel.g.h(h.class)).EY().WO(cVar.username);
                    if (WO != null) {
                        WO.Ah();
                        ba.a(WO.field_username, null);
                        ar.Hg();
                        com.tencent.mm.z.c.EY().a(WO.field_username, WO);
                        ar.Hg();
                        com.tencent.mm.z.c.Fd().WX(WO.field_username);
                        this.qms.add(WO.field_username);
                    }
                } else {
                    x.e("MicroMsg.UnfamiliarContactUI", "delete contact fail! ret:%s", new Object[]{r5.get(i3), cVar.username});
                }
            } else {
                x.w("MicroMsg.UnfamiliarContactUI", "cmdId:%s operation:%s", new Object[]{Integer.valueOf(bVar.getCmdId()), bVar.toString()});
            }
        }
        if (this.ooY <= 0) {
            Iterator it = this.qms.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                Iterator it2 = UnfamiliarContactDetailUI.f(this.qma).iterator();
                while (it2.hasNext()) {
                    if (((UnfamiliarContactDetailUI.b) it2.next()).jLe.field_username.equals(str2)) {
                        it2.remove();
                    }
                }
            }
            UnfamiliarContactDetailUI.a(this.qma, UnfamiliarContactDetailUI.f(this.qma));
            this.qma.runOnUiThread(new 1(this));
        }
    }
}
