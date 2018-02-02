package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import com.tencent.mm.modelappbrand.g;

class SelectConversationUI$24 implements OnDismissListener {
    final /* synthetic */ String iTD;
    final /* synthetic */ View zS;
    final /* synthetic */ SelectConversationUI zpv;

    SelectConversationUI$24(SelectConversationUI selectConversationUI, String str, View view) {
        this.zpv = selectConversationUI;
        this.iTD = str;
        this.zS = view;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        ((g) com.tencent.mm.kernel.g.h(g.class)).a(this.iTD, this.zS);
    }
}
