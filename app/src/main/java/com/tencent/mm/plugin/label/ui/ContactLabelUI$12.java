package com.tencent.mm.plugin.label.ui;

import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.bf;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.Collection;

class ContactLabelUI$12 implements Runnable {
    final /* synthetic */ ContactLabelUI nPX;

    ContactLabelUI$12(ContactLabelUI contactLabelUI) {
        this.nPX = contactLabelUI;
    }

    public final void run() {
        Collection collection = null;
        ContactLabelUI.g(this.nPX).clear();
        ContactLabelUI.h(this.nPX).clear();
        if (ContactLabelUI.b(this.nPX) != null) {
            af WO;
            String str;
            if (ContactLabelUI.d(this.nPX)) {
                String str2;
                ar.Hg();
                bf EZ = c.EZ().EZ(ContactLabelUI.i(this.nPX));
                if (EZ != null) {
                    str2 = EZ.field_contactLabels;
                }
                if (bh.ov(str2)) {
                    ar.Hg();
                    WO = c.EY().WO(ContactLabelUI.i(this.nPX));
                    String str3 = WO.field_encryptUsername;
                    if (!bh.ov(str3)) {
                        ar.Hg();
                        bf EZ2 = c.EZ().EZ(str3);
                        if (EZ2 != null) {
                            str2 = EZ2.field_contactLabels;
                        }
                    }
                    if (bh.ov(str2)) {
                        str = WO.field_username;
                        ar.Hg();
                        EZ = c.EZ().EZ(str);
                        if (EZ != null) {
                            str2 = EZ.field_contactLabels;
                        }
                    }
                }
                collection = (ArrayList) a.aUX().Dp(str2);
            } else {
                ar.Hg();
                WO = c.EY().WO(ContactLabelUI.i(this.nPX));
                if (WO != null) {
                    str = WO.field_contactLabelIds;
                    if (!bh.ov(str)) {
                        ArrayList arrayList = (ArrayList) a.aUX().Dq(str);
                    }
                }
            }
            ContactLabelUI.b(this.nPX).a(collection, collection);
            ContactLabelUI.a(this.nPX, collection);
        }
        if (ContactLabelUI.c(this.nPX) != null) {
            ContactLabelUI.b(this.nPX, e.aUW().cih());
            if (ContactLabelUI.j(this.nPX) != null && ContactLabelUI.j(this.nPX).size() > 0) {
                ContactLabelUI.d(this.nPX);
                ContactLabelUI.c(this.nPX).a(collection, ContactLabelUI.j(this.nPX));
                if (ContactLabelUI.k(this.nPX)) {
                    g.pQN.h(11346, new Object[]{Integer.valueOf(0), Integer.valueOf(1)});
                    ContactLabelUI.l(this.nPX);
                }
            } else if (ContactLabelUI.k(this.nPX)) {
                g.pQN.h(11346, new Object[]{Integer.valueOf(0), Integer.valueOf(0)});
                ContactLabelUI.l(this.nPX);
            }
        }
        ContactLabelUI.a(this.nPX, ContactLabelUI$a.nPZ);
    }
}
