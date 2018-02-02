package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.bh;

class h$1 implements a {
    final /* synthetic */ h pjk;

    h$1(h hVar) {
        this.pjk = hVar;
    }

    public final void od(int i) {
    }

    public final void oe(int i) {
        if (this.pjk.pjj.Ca(i)) {
            String Cb = this.pjk.pjj.Cb(i);
            if (!bh.ov(Cb)) {
                Intent intent = new Intent();
                intent.setClass(this.pjk.context, ContactInfoUI.class);
                intent.putExtra("Contact_User", Cb);
                intent.putExtra("Contact_RoomNickname", this.pjk.kZS.gu(Cb));
                this.pjk.context.startActivity(intent);
            }
        }
    }

    public final void axM() {
    }

    public final void of(int i) {
    }
}
