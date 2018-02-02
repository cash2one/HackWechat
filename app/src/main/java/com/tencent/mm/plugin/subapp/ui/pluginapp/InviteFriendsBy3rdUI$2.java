package com.tencent.mm.plugin.subapp.ui.pluginapp;

import com.tencent.mm.pluginsdk.ui.applet.o.b;

class InviteFriendsBy3rdUI$2 implements b {
    final /* synthetic */ String iGf;
    final /* synthetic */ int nMu;
    final /* synthetic */ InviteFriendsBy3rdUI rYL;

    InviteFriendsBy3rdUI$2(InviteFriendsBy3rdUI inviteFriendsBy3rdUI, String str, int i) {
        this.rYL = inviteFriendsBy3rdUI;
        this.iGf = str;
        this.nMu = i;
    }

    public final void gg(boolean z) {
        if (z) {
            InviteFriendsBy3rdUI.a(this.rYL, this.nMu, InviteFriendsBy3rdUI.b(this.rYL) == null ? this.iGf : InviteFriendsBy3rdUI.b(this.rYL).getText().toString());
        }
    }
}
