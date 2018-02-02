package com.tencent.mm.ui.bindgooglecontact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.z.ar;

class GoogleFriendUI$5 implements OnCancelListener {
    final /* synthetic */ GoogleFriendUI ykV;

    GoogleFriendUI$5(GoogleFriendUI googleFriendUI) {
        this.ykV = googleFriendUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        GoogleFriendUI.c(this.ykV);
        ar.CG().c(GoogleFriendUI.d(this.ykV));
    }
}
