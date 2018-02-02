package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class SnsTagDetailUI$9 implements a {
    final /* synthetic */ SnsTagDetailUI rHd;

    SnsTagDetailUI$9(SnsTagDetailUI snsTagDetailUI) {
        this.rHd = snsTagDetailUI;
    }

    public final void od(int i) {
        String Cb = this.rHd.kZG.Cb(i);
        x.d("MicroMsg.SnsTagDetailUI", "roomPref del " + i + " userName : " + Cb);
        g.Dk();
        if (bh.az((String) g.Dj().CU().get(2, null), "").equals(Cb)) {
            h.h(this.rHd.mController.xIM, j.eFp, j.dGO);
            return;
        }
        this.rHd.xe(Cb);
        if (!(this.rHd.rHa + " " + bh.d(this.rHd.rGZ, ",")).equals(this.rHd.fqR) || this.rHd.qUC == 0) {
            this.rHd.enableOptionMenu(true);
        } else {
            this.rHd.enableOptionMenu(false);
        }
    }

    public final void of(int i) {
        x.d("MicroMsg.SnsTagDetailUI", "roomPref add " + i);
        SnsTagDetailUI.a(this.rHd);
    }

    public final void oe(int i) {
        String Cb = this.rHd.kZG.Cb(i);
        Intent intent = new Intent();
        intent.putExtra("Contact_User", Cb);
        com.tencent.mm.plugin.sns.c.a.ifs.d(intent, this.rHd);
    }

    public final void axM() {
        if (this.rHd.kZG != null) {
            this.rHd.kZG.caZ();
        }
    }
}
