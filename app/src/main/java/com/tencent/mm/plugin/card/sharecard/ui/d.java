package com.tencent.mm.plugin.card.sharecard.ui;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.card.base.a;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.report.service.g;
import java.util.ArrayList;

public final class d implements a {
    private c kOD;

    public final /* synthetic */ b nD(int i) {
        return this.kOD != null ? (ShareCardInfo) this.kOD.getItem(i) : null;
    }

    public d(c cVar) {
        this.kOD = cVar;
    }

    public final void onCreate() {
        if (this.kOD != null) {
            am.auA().c(this.kOD);
        }
    }

    public final void onDestroy() {
        if (this.kOD != null) {
            am.auA().j(this.kOD);
            c cVar = this.kOD;
            cVar.kOB.release();
            cVar.kOB = null;
            cVar.aUn();
            int i = (int) (cVar.endTime - cVar.beginTime);
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(281);
            iDKey.SetKey(24);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(281);
            iDKey2.SetKey(25);
            iDKey2.SetValue((long) i);
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            g.pQN.a(arrayList, true);
            this.kOD = null;
        }
    }

    public final void Hv() {
        if (this.kOD != null) {
            this.kOD.a(null, null);
        }
    }
}
