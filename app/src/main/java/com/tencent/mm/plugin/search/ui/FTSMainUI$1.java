package com.tencent.mm.plugin.search.ui;

import android.view.View;
import android.view.View.OnClickListener;

class FTSMainUI$1 implements OnClickListener {
    final /* synthetic */ FTSMainUI qdk;

    FTSMainUI$1(FTSMainUI fTSMainUI) {
        this.qdk = fTSMainUI;
    }

    public final void onClick(View view) {
        this.qdk.onClickSnsHotArticle((String) view.getTag());
    }
}
