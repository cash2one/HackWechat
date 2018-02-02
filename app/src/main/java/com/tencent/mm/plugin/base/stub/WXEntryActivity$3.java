package com.tencent.mm.plugin.base.stub;

import android.view.View;
import android.view.View.OnClickListener;

class WXEntryActivity$3 implements OnClickListener {
    final /* synthetic */ WXEntryActivity kvo;

    WXEntryActivity$3(WXEntryActivity wXEntryActivity) {
        this.kvo = wXEntryActivity;
    }

    public final void onClick(View view) {
        WXEntryActivity.c(this.kvo);
        this.kvo.finish();
    }
}
