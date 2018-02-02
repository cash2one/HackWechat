package com.tencent.mm.ui.bindmobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class MobileFriendUI$1 implements OnClickListener {
    final /* synthetic */ MobileFriendUI ymF;

    MobileFriendUI$1(MobileFriendUI mobileFriendUI) {
        this.ymF = mobileFriendUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.ymF.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        this.ymF.finish();
    }
}
