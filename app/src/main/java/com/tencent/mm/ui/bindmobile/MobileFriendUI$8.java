package com.tencent.mm.ui.bindmobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class MobileFriendUI$8 implements OnClickListener {
    final /* synthetic */ MobileFriendUI ymF;

    MobileFriendUI$8(MobileFriendUI mobileFriendUI) {
        this.ymF = mobileFriendUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.ymF.finish();
    }
}
