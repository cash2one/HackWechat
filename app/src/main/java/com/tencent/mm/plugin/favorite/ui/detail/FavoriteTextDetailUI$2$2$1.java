package com.tencent.mm.plugin.favorite.ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteTextDetailUI.2.2;
import com.tencent.mm.ui.base.h;

class FavoriteTextDetailUI$2$2$1 implements OnClickListener {
    final /* synthetic */ 2 mxq;

    FavoriteTextDetailUI$2$2$1(2 2) {
        this.mxq = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        j.a(FavoriteTextDetailUI.e(this.mxq.mxp.mxo), new 1(this, h.a(this.mxq.mxp.mxo.mController.xIM, this.mxq.mxp.mxo.getString(R.l.dEx), false, null)));
    }
}
