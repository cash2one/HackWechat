package com.tencent.mm.plugin.label.ui;

import com.tencent.mm.plugin.label.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.z;
import java.util.ArrayList;

class ContactLabelManagerUI$4 implements Runnable {
    final /* synthetic */ ContactLabelManagerUI nPj;
    final /* synthetic */ boolean nPl;

    ContactLabelManagerUI$4(ContactLabelManagerUI contactLabelManagerUI, boolean z) {
        this.nPj = contactLabelManagerUI;
        this.nPl = z;
    }

    public final void run() {
        ContactLabelManagerUI.a(this.nPj, e.aUW().cii());
        if (ContactLabelManagerUI.g(this.nPj) == null || ContactLabelManagerUI.g(this.nPj).size() <= 0) {
            x.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[updateData] Empty");
            if (ContactLabelManagerUI.h(this.nPj)) {
                g.pQN.h(11346, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
                ContactLabelManagerUI.i(this.nPj);
            }
            ag.y(new 1(this));
            return;
        }
        x.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[updateData] Normal");
        if (ContactLabelManagerUI.h(this.nPj)) {
            g.pQN.h(11346, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
            ContactLabelManagerUI.i(this.nPj);
        }
        if (ContactLabelManagerUI.g(this.nPj) != null && ContactLabelManagerUI.g(this.nPj).size() > 0) {
            int size = ContactLabelManagerUI.g(this.nPj).size();
            e.aUW().aUR();
            for (int i = 0; i < size; i++) {
                int i2 = ((z) ContactLabelManagerUI.g(this.nPj).get(i)).field_labelID;
                ArrayList WE = e.aUW().WE(String.valueOf(i2));
                if (WE == null || WE.size() <= 0) {
                    ContactLabelManagerUI.j(this.nPj).put(Integer.valueOf(i2), Integer.valueOf(0));
                } else {
                    ContactLabelManagerUI.j(this.nPj).put(Integer.valueOf(i2), Integer.valueOf(WE.size()));
                }
            }
        }
        ag.y(new 2(this));
    }

    public final String toString() {
        return super.toString() + "|updateData";
    }
}
