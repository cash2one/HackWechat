package com.tencent.mm.plugin.aa;

import android.widget.Toast;
import com.tencent.mm.g.a.bn;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.plugin.aa.b.4;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class b$4$1 implements a<Void, com.tencent.mm.ae.a.a<c>> {
    final /* synthetic */ bn ifF;
    final /* synthetic */ 4 ifG;

    b$4$1(4 4, bn bnVar) {
        this.ifG = 4;
        this.ifF = bnVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.ae.a.a aVar = (com.tencent.mm.ae.a.a) obj;
        x.i("MicroMsg.SubCoreAA", "close aa urge notify cgiback, errType: %s, errCode: %s", new Object[]{Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
        if (aVar.errType == 0 && aVar.errCode == 0) {
            x.i("MicroMsg.SubCoreAA", "close aa urge notify success");
            if (((c) aVar.fJJ).liH > 0 && !bh.ov(((c) aVar.fJJ).liI)) {
                Toast.makeText(ac.getContext(), ((c) aVar.fJJ).liI, 0).show();
                g.pQN.a(407, 29, 1, false);
            } else if (((c) aVar.fJJ).liH == 0) {
                Toast.makeText(ac.getContext(), i.uIg, 0).show();
                g.pQN.a(407, 27, 1, false);
                if (!bh.ov(((c) aVar.fJJ).vCY)) {
                    h.h(this.ifF.fpH.fpG, ((c) aVar.fJJ).vCY);
                }
            } else {
                x.i("MicroMsg.SubCoreAA", "illegal resp");
                g.pQN.a(407, 29, 1, false);
            }
        } else {
            x.i("MicroMsg.SubCoreAA", "close aa urge notify failed");
            Toast.makeText(ac.getContext(), i.uIf, 1).show();
            g.pQN.a(407, 28, 1, false);
        }
        return zBS;
    }
}
