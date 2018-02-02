package com.tencent.mm.ui.chatting.gallery;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.storage.au;

class i$1 implements OnClickListener {
    final /* synthetic */ au heR;
    final /* synthetic */ r yFU;
    final /* synthetic */ i yFV;

    i$1(i iVar, au auVar, r rVar) {
        this.yFV = iVar;
        this.heR = auVar;
        this.yFU = rVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        i.yFN = true;
        i.a(this.yFV, this.heR, this.yFU);
    }
}
