package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mm.pluginsdk.ui.applet.o.a;

class e$13 implements OnClickListener {
    final /* synthetic */ a vnl;
    final /* synthetic */ View zS;

    e$13(a aVar, View view) {
        this.vnl = aVar;
        this.zS = view;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.vnl != null) {
            this.vnl.a(true, e.cY(this.zS), e.cZ(this.zS));
        }
    }
}
