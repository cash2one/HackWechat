package com.tencent.mm.plugin.base.stub;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class WXEntryActivity$2 implements OnCancelListener {
    final /* synthetic */ WXEntryActivity kvo;

    WXEntryActivity$2(WXEntryActivity wXEntryActivity) {
        this.kvo = wXEntryActivity;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        WXEntryActivity.b(this.kvo);
        this.kvo.finish();
    }
}
