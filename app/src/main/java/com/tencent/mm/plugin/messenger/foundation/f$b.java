package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.s;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

class f$b implements Runnable {
    private String TAG;
    private final s hFL;
    private final LinkedList<ol> mqJ;
    private int ooK;

    public f$b(String str, s sVar, LinkedList<ol> linkedList) {
        this.TAG = str;
        this.hFL = sVar;
        this.mqJ = linkedList;
    }

    public final void run() {
        if (this.hFL != null) {
            int i = this.hFL.hHH;
            if (i != 3) {
                if (!this.hFL.hHG) {
                    if (!(i == 1 || i == 2 || i == 8)) {
                        return;
                    }
                }
                return;
            }
            this.ooK = 0;
            Iterator it = this.mqJ.iterator();
            while (it.hasNext()) {
                ol olVar = (ol) it.next();
                byte[] a = n.a(olVar.vXq);
                if (olVar.vXp == 5) {
                    try {
                        String com_tencent_mm_protocal_c_bdo = ((bw) new bw().aF(a)).vGX.toString();
                        af WO = ((h) g.h(h.class)).EY().WO(com_tencent_mm_protocal_c_bdo);
                        if (com_tencent_mm_protocal_c_bdo.endsWith("@chatroom") && WO.fWn == 0) {
                            this.ooK++;
                        }
                    } catch (IOException e) {
                        x.e(this.TAG, "muteroom idkeyStat: docmd: parse from protobuf to addmsg error, " + e.getMessage());
                    }
                }
            }
            if (this.ooK > 0) {
                if (this.ooK <= 5) {
                    d.pPH.a(202, (long) this.ooK, 1, false);
                } else if (this.ooK <= 10) {
                    d.pPH.a(202, 6, 1, false);
                } else if (this.ooK <= 15) {
                    d.pPH.a(202, 7, 1, false);
                } else if (this.ooK <= 20) {
                    d.pPH.a(202, 8, 1, false);
                } else {
                    d.pPH.a(202, 9, 1, false);
                }
                x.i(this.TAG, "muteroom idkeyStat:muteroomNotNotifyNum = " + this.ooK);
                switch (i) {
                    case 1:
                        d.pPH.a(202, 11, 1, false);
                        break;
                    case 2:
                        d.pPH.a(202, 12, 1, false);
                        break;
                    case 3:
                        d.pPH.a(202, 10, 1, false);
                        break;
                    case 8:
                        d.pPH.a(202, 13, 1, false);
                        break;
                }
                x.i(this.TAG, "muteroom idkeyStat:aiScene = " + i);
            }
        }
    }
}
