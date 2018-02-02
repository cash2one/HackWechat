package com.tencent.mm.plugin.order.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.ui.base.h;

class MallOrderRecordListUI$2 implements OnItemLongClickListener {
    final /* synthetic */ MallOrderRecordListUI pcu;

    MallOrderRecordListUI$2(MallOrderRecordListUI mallOrderRecordListUI) {
        this.pcu = mallOrderRecordListUI;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < this.pcu.pcq.size()) {
            h.a(this.pcu, this.pcu.getResources().getString(a$i.uTQ), null, this.pcu.getResources().getString(a$i.dEw), new 1(this, i));
        }
        return true;
    }
}
