package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.product.b.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class MallProductReceiptUI$2 implements OnItemClickListener {
    final /* synthetic */ MallProductReceiptUI pga;

    MallProductReceiptUI$2(MallProductReceiptUI mallProductReceiptUI) {
        this.pga = mallProductReceiptUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d c = MallProductReceiptUI.c(this.pga);
        CharSequence charSequence = (c.pec == null || i >= c.pec.size()) ? null : (String) c.pec.get(i);
        x.d("MicroMsg.MallProductReceiptUI", "onItemClick receipt = " + charSequence);
        if (!bh.ov(charSequence)) {
            MallProductReceiptUI.a(this.pga).setText(charSequence);
        }
    }
}
