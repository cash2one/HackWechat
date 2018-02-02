package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.sdk.platformtools.ae;

class MMAppMgr$14 implements OnDismissListener {
    MMAppMgr$14() {
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        ae.Vd("show_wap_adviser");
    }
}
