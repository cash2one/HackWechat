package com.tencent.mm.plugin.order.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.e;

class MallOrderRecordListUI$1 implements OnItemClickListener {
    final /* synthetic */ MallOrderRecordListUI pcu;

    MallOrderRecordListUI$1(MallOrderRecordListUI mallOrderRecordListUI) {
        this.pcu = mallOrderRecordListUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Activity activity = this.pcu;
        if (i < activity.pcq.size()) {
            i iVar = (i) activity.pcq.get(i);
            if (iVar != null) {
                Bundle bundle = activity.vf;
                bundle.putString("key_trans_id", iVar.pbi);
                bundle.putInt("key_pay_type", iVar.pbq);
                bundle.putString("bill_id", iVar.pbB);
                a.j(activity, bundle);
            }
        }
        e.HF(26);
    }
}
