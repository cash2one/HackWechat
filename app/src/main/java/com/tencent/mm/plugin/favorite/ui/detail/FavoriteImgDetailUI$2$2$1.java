package com.tencent.mm.plugin.favorite.ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteImgDetailUI.2.2;
import com.tencent.mm.ui.base.h;

class FavoriteImgDetailUI$2$2$1 implements OnClickListener {
    final /* synthetic */ 2 mwM;

    FavoriteImgDetailUI$2$2$1(2 2) {
        this.mwM = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        j.a(FavoriteImgDetailUI.b(this.mwM.mwL.mwK).field_localId, new 1(this, h.a(this.mwM.mwL.mwK.mController.xIM, this.mwM.mwL.mwK.getString(R.l.dEx), false, null)));
    }
}
