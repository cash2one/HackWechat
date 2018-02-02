package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mm.ax.a;

class y$4 implements OnClickListener {
    final /* synthetic */ y yBS;
    final /* synthetic */ a yBX;
    final /* synthetic */ View zS;

    y$4(y yVar, View view, a aVar) {
        this.yBS = yVar;
        this.zS = view;
        this.yBX = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.yBS.a(this.zS, (com.tencent.mm.ui.chatting.d.a) this.yBX);
    }
}
