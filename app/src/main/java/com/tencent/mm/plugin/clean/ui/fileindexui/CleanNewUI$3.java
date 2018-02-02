package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class CleanNewUI$3 implements OnClickListener {
    final /* synthetic */ CleanNewUI lhD;

    CleanNewUI$3(CleanNewUI cleanNewUI) {
        this.lhD = cleanNewUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.CleanNewUI", "clean wechat cache");
    }
}
