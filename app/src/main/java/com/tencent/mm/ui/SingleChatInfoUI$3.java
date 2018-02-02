package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.b.af;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.storage.bf;
import com.tencent.mm.ui.contact.e;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class SingleChatInfoUI$3 implements a {
    final /* synthetic */ SingleChatInfoUI xMD;

    SingleChatInfoUI$3(SingleChatInfoUI singleChatInfoUI) {
        this.xMD = singleChatInfoUI;
    }

    public final void od(int i) {
    }

    public final void oe(int i) {
        String Cb = SingleChatInfoUI.b(this.xMD).Cb(i);
        String ou = t.ou(SingleChatInfoUI.b(this.xMD).Cd(i));
        if (t.ov(ou)) {
            ar.Hg();
            bf EZ = c.EZ().EZ(Cb);
            if (!(EZ == null || t.ov(EZ.field_encryptUsername))) {
                ou = EZ.field_conRemark;
            }
        }
        if (!t.ov(Cb)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", Cb);
            intent.putExtra("Contact_RemarkName", ou);
            intent.putExtra("Contact_Nick", t.ou(SingleChatInfoUI.b(this.xMD).Cc(i)));
            intent.putExtra("Contact_RoomMember", true);
            ar.Hg();
            af WO = c.EY().WO(Cb);
            if (WO != null && ((int) WO.gJd) > 0 && com.tencent.mm.l.a.fZ(WO.field_type)) {
                e.a(intent, Cb);
            }
            intent.putExtra("Kdel_from", 0);
            d.b(this.xMD, "profile", ".ui.ContactInfoUI", intent, 0);
        }
    }

    public final void axM() {
        if (SingleChatInfoUI.b(this.xMD) != null) {
            SingleChatInfoUI.b(this.xMD).caZ();
        }
    }

    public final void of(int i) {
        SingleChatInfoUI.c(this.xMD);
    }
}
