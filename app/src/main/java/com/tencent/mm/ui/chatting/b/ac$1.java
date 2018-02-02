package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import com.tencent.mm.storage.au;

class ac$1 implements OnClickListener {
    final /* synthetic */ au heR;
    final /* synthetic */ MenuItem xJp;
    final /* synthetic */ ac yCz;

    public ac$1(ac acVar, au auVar, MenuItem menuItem) {
        this.yCz = acVar;
        this.heR = auVar;
        this.xJp = menuItem;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ac acVar = this.yCz;
        au auVar = this.heR;
        this.xJp.getGroupId();
        acVar.aV(auVar);
        dialogInterface.dismiss();
    }
}
