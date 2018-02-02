package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import com.tencent.mm.modelappbrand.g;

class SendAppMessageWrapperUI$2 implements OnDismissListener {
    final /* synthetic */ String iTD;
    final /* synthetic */ View zS;
    final /* synthetic */ SendAppMessageWrapperUI zpD;

    SendAppMessageWrapperUI$2(SendAppMessageWrapperUI sendAppMessageWrapperUI, String str, View view) {
        this.zpD = sendAppMessageWrapperUI;
        this.iTD = str;
        this.zS = view;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        ((g) com.tencent.mm.kernel.g.h(g.class)).a(this.iTD, this.zS);
    }
}
