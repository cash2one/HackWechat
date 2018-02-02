package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.protocal.c.cat;
import com.tencent.mm.protocal.c.cbb;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class SendAppMessageTask$1 implements a {
    final /* synthetic */ int hLI;
    final /* synthetic */ LinkedList jrg;
    final /* synthetic */ g.a jrh;
    final /* synthetic */ byte[] jri;
    final /* synthetic */ StringBuilder jrj;
    final /* synthetic */ SendAppMessageTask jrk;

    SendAppMessageTask$1(SendAppMessageTask sendAppMessageTask, LinkedList linkedList, g.a aVar, byte[] bArr, StringBuilder stringBuilder, int i) {
        this.jrk = sendAppMessageTask;
        this.jrg = linkedList;
        this.jrh = aVar;
        this.jri = bArr;
        this.jrj = stringBuilder;
        this.hLI = i;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        x.i("MicroMsg.SendAppMessageTask", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        cat com_tencent_mm_protocal_c_cat = (cat) bVar.hmh.hmo;
        if (i != 0 || i2 != 0 || com_tencent_mm_protocal_c_cat == null || bh.cA(com_tencent_mm_protocal_c_cat.xab)) {
            if (this.jrh.hdz == 3) {
                this.jrh.hdz = 2;
            }
            Iterator it = this.jrg.iterator();
            while (it.hasNext()) {
                SendAppMessageTask.a(this.jrk, this.jrh, this.jri, (String) it.next(), this.jrj, this.hLI);
            }
        } else {
            LinkedList linkedList = com_tencent_mm_protocal_c_cat.xab;
            this.jrk.jrf = new ArrayList();
            int i3 = 0;
            while (i3 < this.jrg.size()) {
                cbb com_tencent_mm_protocal_c_cbb = i3 < linkedList.size() ? (cbb) linkedList.get(i3) : new cbb();
                this.jrh.hdD = com_tencent_mm_protocal_c_cbb.xaq;
                this.jrk.jrf.add(new ShareInfo(com_tencent_mm_protocal_c_cbb.xaq, com_tencent_mm_protocal_c_cbb.xap));
                SendAppMessageTask.a(this.jrk, this.jrh, this.jri, (String) this.jrg.get(i3), this.jrj, this.hLI);
                i3++;
            }
        }
        SendAppMessageTask.a(this.jrk);
        return 0;
    }
}
