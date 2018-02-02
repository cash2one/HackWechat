package com.tencent.mm.ui.bindmobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.z.ar;

class MobileFriendUI$9 implements OnCancelListener {
    final /* synthetic */ MobileFriendUI ymF;

    MobileFriendUI$9(MobileFriendUI mobileFriendUI) {
        this.ymF = mobileFriendUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (MobileFriendUI.a(this.ymF) != null) {
            ar.CG().c(MobileFriendUI.a(this.ymF));
        }
    }
}
