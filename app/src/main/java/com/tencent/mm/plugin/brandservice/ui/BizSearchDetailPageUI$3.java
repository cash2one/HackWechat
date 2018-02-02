package com.tencent.mm.plugin.brandservice.ui;

import com.tencent.mm.plugin.brandservice.ui.c.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.je;
import com.tencent.mm.protocal.c.jj;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.a;

class BizSearchDetailPageUI$3 implements b {
    final /* synthetic */ BizSearchDetailPageUI kFp;

    BizSearchDetailPageUI$3(BizSearchDetailPageUI bizSearchDetailPageUI) {
        this.kFp = bizSearchDetailPageUI;
    }

    public final void a(c cVar, a aVar, int i, String str, int i2, int i3) {
        if (BizSearchDetailPageUI.e(this.kFp) == 1 && aVar.type == 5) {
            jj jjVar = (jj) aVar.data;
            if (jjVar.vPF == null || jjVar.vPF.vPn == null) {
                x.e("MicroMsg.BrandService.BizSearchDetailPageUI", "bcdItem.ContactItem == null || bcdItem.ContactItem.ContactItem == null");
                return;
            }
            je nt = cVar.nt(i3);
            String str2 = bh.ou(BizSearchDetailPageUI.a(this.kFp)) + "," + i + "," + bh.ou(str) + "," + i2 + "," + cVar.kFv + "," + (nt == null ? "" : nt.vPs + ",1");
            g.pQN.k(10866, str2);
            x.d("MicroMsg.BrandService.BizSearchDetailPageUI", "report : " + str2);
            if ((jjVar.vPF.vPn.wvf & 8) > 0) {
                g.pQN.k(10298, str + ",35");
            }
        }
    }
}
