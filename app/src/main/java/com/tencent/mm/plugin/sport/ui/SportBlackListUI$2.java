package com.tencent.mm.plugin.sport.ui;

import android.content.Intent;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;

class SportBlackListUI$2 implements a {
    final /* synthetic */ SportBlackListUI rUy;

    SportBlackListUI$2(SportBlackListUI sportBlackListUI) {
        this.rUy = sportBlackListUI;
    }

    public final void od(int i) {
        String Cb = SportBlackListUI.a(this.rUy).Cb(i);
        SportBlackListUI.b(this.rUy).remove(Cb);
        SportBlackListUI.a(this.rUy).n(null, SportBlackListUI.b(this.rUy));
        SportBlackListUI.a(this.rUy).refresh();
        ar.Hg();
        s.g(c.EY().WO(Cb));
        d.pY(40);
    }

    public final void of(int i) {
        SportBlackListUI.c(this.rUy);
    }

    public final void oe(int i) {
        String Cb = SportBlackListUI.a(this.rUy).Cb(i);
        Intent intent = new Intent();
        intent.putExtra("Contact_User", Cb);
        com.tencent.mm.bm.d.b(this.rUy, "profile", ".ui.ContactInfoUI", intent);
    }

    public final void axM() {
        SportBlackListUI.a(this.rUy).caZ();
    }
}
