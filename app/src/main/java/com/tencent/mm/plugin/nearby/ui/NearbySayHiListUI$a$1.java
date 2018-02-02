package com.tencent.mm.plugin.nearby.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.nearby.ui.NearbySayHiListUI.a;
import com.tencent.mm.sdk.platformtools.x;

class NearbySayHiListUI$a$1 implements OnClickListener {
    final /* synthetic */ a oPs;

    NearbySayHiListUI$a$1(a aVar) {
        this.oPs = aVar;
    }

    public final void onClick(View view) {
        x.v("MicroMsg.SayHiAdapter", "on delView clicked");
        this.oPs.kBF.aUz();
        if (this.oPs.oPr != null) {
            this.oPs.oPr.bo(view.getTag());
        }
    }
}
