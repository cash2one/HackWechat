package com.tencent.mm.plugin.accountsync.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelfriend.v;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.z.ar;

class InviteFacebookFriendsUI$7 implements OnCancelListener {
    final /* synthetic */ InviteFacebookFriendsUI ilq;
    final /* synthetic */ v ils;
    final /* synthetic */ ak ilt;

    InviteFacebookFriendsUI$7(InviteFacebookFriendsUI inviteFacebookFriendsUI, ak akVar, v vVar) {
        this.ilq = inviteFacebookFriendsUI;
        this.ilt = akVar;
        this.ils = vVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.ilt.TG();
        ar.CG().c(this.ils);
    }
}
