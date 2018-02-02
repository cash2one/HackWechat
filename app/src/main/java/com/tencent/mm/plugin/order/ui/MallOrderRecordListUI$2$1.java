package com.tencent.mm.plugin.order.ui;

import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.plugin.order.ui.MallOrderRecordListUI.2;
import com.tencent.mm.ui.base.h$c;

class MallOrderRecordListUI$2$1 implements h$c {
    final /* synthetic */ int kI;
    final /* synthetic */ 2 pcv;

    MallOrderRecordListUI$2$1(2 2, int i) {
        this.pcv = 2;
        this.kI = i;
    }

    public final void jl(int i) {
        switch (i) {
            case 0:
                i iVar = (i) this.pcv.pcu.pcq.get(this.kI);
                if (iVar != null) {
                    this.pcv.pcu.dG(iVar.pbi, iVar.pbB);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
