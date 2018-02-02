package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class j$3 implements OnClickListener {
    final /* synthetic */ j nOi;

    j$3(j jVar) {
        this.nOi = jVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.TalkUIController", "user choose end this call because isNotFree");
        j.b(this.nOi);
    }
}
