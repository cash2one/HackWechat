package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class b$1 implements OnCancelListener {
    final /* synthetic */ b vnd;

    b$1(b bVar) {
        this.vnd = bVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.vnd.ltM != null) {
            this.vnd.ltM.dismiss();
            this.vnd.ltM = null;
        }
    }
}
