package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelmulti.f;
import com.tencent.mm.z.ar;

class InviteFriendsBy3rdUI$8 implements OnCancelListener {
    final /* synthetic */ InviteFriendsBy3rdUI rYL;
    final /* synthetic */ f rYN;

    InviteFriendsBy3rdUI$8(InviteFriendsBy3rdUI inviteFriendsBy3rdUI, f fVar) {
        this.rYL = inviteFriendsBy3rdUI;
        this.rYN = fVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.rYN);
    }
}
