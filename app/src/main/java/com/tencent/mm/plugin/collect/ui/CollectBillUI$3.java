package com.tencent.mm.plugin.collect.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.collect.b.a;
import com.tencent.mm.sdk.platformtools.x;

class CollectBillUI$3 implements OnItemClickListener {
    final /* synthetic */ CollectBillUI llV;

    CollectBillUI$3(CollectBillUI collectBillUI) {
        this.llV = collectBillUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < 0 || i >= adapterView.getAdapter().getCount()) {
            x.i("MicroMsg.CollectBillUI", "illegal position: %s, count: %s", Integer.valueOf(i), Integer.valueOf(adapterView.getAdapter().getCount()));
            return;
        }
        a aVar = (a) CollectBillUI.b(this.llV).getItemAtPosition(i);
        if (aVar == null) {
            x.w("MicroMsg.CollectBillUI", "invalid position: %d", Integer.valueOf(i));
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("scene", 2);
        intent.putExtra("trans_id", aVar.lie);
        intent.putExtra("bill_id", aVar.lid);
        d.b(this.llV.mController.xIM, "order", ".ui.MallOrderTransactionInfoUI", intent);
    }
}
