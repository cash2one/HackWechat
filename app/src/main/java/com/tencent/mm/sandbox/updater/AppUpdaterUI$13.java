package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class AppUpdaterUI$13 implements OnCancelListener {
    final /* synthetic */ AppUpdaterUI xcq;

    AppUpdaterUI$13(AppUpdaterUI appUpdaterUI) {
        this.xcq = appUpdaterUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.d("MicroMsg.AppUpdaterUI", "click cancel button");
        AppUpdaterUI.a(this.xcq, 12);
        AppUpdaterUI.i(this.xcq);
    }
}
