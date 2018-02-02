package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.x;

class AppUpdaterUI$12 implements OnClickListener {
    final /* synthetic */ AppUpdaterUI xcq;
    final /* synthetic */ c xct;

    AppUpdaterUI$12(AppUpdaterUI appUpdaterUI, c cVar) {
        this.xcq = appUpdaterUI;
        this.xct = cVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.d("MicroMsg.AppUpdaterUI", "click download button");
        AppUpdaterUI.a(this.xcq, 11);
        if (this.xct != null) {
            this.xct.deleteTempFile();
        }
        j e = AppUpdaterUI.e(this.xcq);
        e.xdB = true;
        e.ceC();
    }
}
