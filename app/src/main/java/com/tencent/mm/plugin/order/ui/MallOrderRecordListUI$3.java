package com.tencent.mm.plugin.order.ui;

import com.tencent.mm.ui.base.MMLoadMoreListView.a;

class MallOrderRecordListUI$3 implements a {
    final /* synthetic */ MallOrderRecordListUI pcu;

    MallOrderRecordListUI$3(MallOrderRecordListUI mallOrderRecordListUI) {
        this.pcu = mallOrderRecordListUI;
    }

    public final void axW() {
        if (!this.pcu.acS) {
            this.pcu.acS = true;
            MallOrderRecordListUI mallOrderRecordListUI = this.pcu;
            mallOrderRecordListUI.wn += 10;
            this.pcu.biJ();
        }
    }
}
