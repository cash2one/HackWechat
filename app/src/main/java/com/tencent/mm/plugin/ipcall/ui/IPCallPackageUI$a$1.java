package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a.e.f;
import com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI.a;
import com.tencent.mm.protocal.c.bwp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class IPCallPackageUI$a$1 implements OnClickListener {
    final /* synthetic */ a nLj;

    IPCallPackageUI$a$1(a aVar) {
        this.nLj = aVar;
    }

    public final void onClick(View view) {
        bwp com_tencent_mm_protocal_c_bwp = (bwp) this.nLj.getItem(((Integer) view.getTag()).intValue());
        if (com_tencent_mm_protocal_c_bwp == null || bh.ov(com_tencent_mm_protocal_c_bwp.vIR)) {
            x.e("MicroMsg.IPCallPackageUI", "buyBtnClick: proToBuy is null");
            return;
        }
        IPCallPackageUI.b(a.a(this.nLj)).start();
        f b = IPCallPackageUI.b(a.a(this.nLj));
        b.nGb++;
        IPCallPackageUI.b(a.a(this.nLj)).nGf = com_tencent_mm_protocal_c_bwp.vIR;
        h.a(a.a(this.nLj), a.a(this.nLj).getString(R.l.erN, new Object[]{com_tencent_mm_protocal_c_bwp.wEW, com_tencent_mm_protocal_c_bwp.fon}), a.a(this.nLj).getString(R.l.erO), a.a(this.nLj).getString(R.l.erL), a.a(this.nLj).getString(R.l.erM), false, new 1(this, com_tencent_mm_protocal_c_bwp), new 2(this));
    }
}
