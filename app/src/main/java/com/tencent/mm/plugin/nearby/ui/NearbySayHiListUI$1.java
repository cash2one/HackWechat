package com.tencent.mm.plugin.nearby.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.a;
import com.tencent.mm.sdk.platformtools.x;

class NearbySayHiListUI$1 implements OnClickListener {
    final /* synthetic */ View oPn;
    final /* synthetic */ NearbySayHiListUI oPo;

    NearbySayHiListUI$1(NearbySayHiListUI nearbySayHiListUI, View view) {
        this.oPo = nearbySayHiListUI;
        this.oPn = view;
    }

    public final void onClick(View view) {
        NearbySayHiListUI.a(this.oPo, NearbySayHiListUI.a(this.oPo) + 8);
        x.d("MicroMsg.SayHiListUI", "dkfooter more btn:" + NearbySayHiListUI.a(this.oPo));
        a b = NearbySayHiListUI.b(this.oPo);
        int a = NearbySayHiListUI.a(this.oPo);
        b.aUn();
        b.asN = a;
        b.Xy();
        if (NearbySayHiListUI.c(this.oPo) <= NearbySayHiListUI.a(this.oPo)) {
            NearbySayHiListUI.d(this.oPo).removeFooterView(this.oPn);
            x.d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + NearbySayHiListUI.a(this.oPo));
        }
    }
}
