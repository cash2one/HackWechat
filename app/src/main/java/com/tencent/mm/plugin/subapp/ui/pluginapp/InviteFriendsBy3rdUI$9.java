package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.z.ar;

class InviteFriendsBy3rdUI$9 implements OnCancelListener {
    final /* synthetic */ i nMv;
    final /* synthetic */ InviteFriendsBy3rdUI rYL;

    InviteFriendsBy3rdUI$9(InviteFriendsBy3rdUI inviteFriendsBy3rdUI, i iVar) {
        this.rYL = inviteFriendsBy3rdUI;
        this.nMv = iVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.nMv);
    }
}
