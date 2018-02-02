package com.tencent.mm.ui.chatting.gallery;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.chatting.gallery.i.2;

class i$2$1 implements OnClickListener {
    final /* synthetic */ 2 yFX;

    i$2$1(2 2) {
        this.yFX = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface != null) {
            dialogInterface.cancel();
        }
        ag.y(new 1(this));
    }
}
