package com.tencent.mm.ui.chatting.b;

import android.annotation.SuppressLint;
import com.tencent.mm.a.n;
import com.tencent.mm.modelsimple.j;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bd;
import java.util.LinkedList;
import java.util.List;

public final class i {
    public p fhr;
    int hXU = -1;
    @SuppressLint({"HandlerLeak"})
    public af handler = new 1(this);
    int yzJ;
    public boolean yzK = false;

    public i(p pVar) {
        this.fhr = pVar;
    }

    public final void keepSignalling() {
        if (this.yzJ == -2) {
            ar.CG().a(new bd(new 3(this)), 0);
        }
    }

    public final void stopSignalling() {
        ar.CG().a(new bd(new 4(this)), 0);
    }

    public final void FE(int i) {
        int intValue = ((Integer) ar.He().get(35, Integer.valueOf(10))).intValue();
        List linkedList = new LinkedList();
        linkedList.add(this.fhr.crz());
        if (intValue == -2) {
            if (this.fhr.csd() && (i == 1 || i == 2)) {
                x.d("MicroMsg.DirectScendImp", "oreh old logic doDirectSend not support chatStatus:%d", new Object[]{Integer.valueOf(i)});
                return;
            }
            x.d("MicroMsg.DirectScendImp", "oreh old logic doDirectSend done chatStatus:%d", new Object[]{Integer.valueOf(i)});
            ar.CG().a(new j(linkedList, n.eh(i)), 0);
        } else if (this.fhr.csd() || com.tencent.mm.storage.x.Wz(this.fhr.csi().field_username) || com.tencent.mm.storage.x.Wx(this.fhr.csi().field_username) || this.fhr.csi().cia()) {
            x.d("MicroMsg.DirectScendImp", "oreh doDirectSend not support");
        } else {
            long bz = bh.bz(this.fhr.cst());
            if (intValue == -1 || bz > ((long) intValue) * 1000) {
                x.d("MicroMsg.DirectScendImp", "oreh doDirectSend interval too long: %d;  interval: %d", new Object[]{Long.valueOf(bz / 1000), Integer.valueOf(intValue)});
                return;
            }
            x.d("MicroMsg.DirectScendImp", "oreh doDirectSend done chatStatus:%d, delt:%d", new Object[]{Integer.valueOf(i), Long.valueOf(bz / 1000)});
            ar.CG().a(new j(linkedList, n.eh(i)), 0);
        }
    }
}
