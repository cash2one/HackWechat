package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.pluginsdk.ui.applet.o.b;

class e$2 implements OnClickListener {
    final /* synthetic */ b vnk;

    e$2(b bVar) {
        this.vnk = bVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.vnk != null) {
            this.vnk.gg(false);
        }
    }
}
