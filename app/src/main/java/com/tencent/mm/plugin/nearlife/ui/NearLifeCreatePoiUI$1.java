package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;

class NearLifeCreatePoiUI$1 implements OnClickListener {
    final /* synthetic */ NearLifeCreatePoiUI oRe;

    NearLifeCreatePoiUI$1(NearLifeCreatePoiUI nearLifeCreatePoiUI) {
        this.oRe = nearLifeCreatePoiUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("ui_title", R.l.exY);
        if (NearLifeCreatePoiUI.a(this.oRe) != null) {
            intent.putExtra("extra_province", NearLifeCreatePoiUI.a(this.oRe).hxv);
            intent.putExtra("extra_city", NearLifeCreatePoiUI.a(this.oRe).hxw);
        }
        d.b(this.oRe.mController.xIM, "address", ".ui.WalletMultiRcptSelectUI", intent, 1);
    }
}
