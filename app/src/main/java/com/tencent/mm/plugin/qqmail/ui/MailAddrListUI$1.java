package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.i;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.j$a;

class MailAddrListUI$1 extends j$a {
    final /* synthetic */ MailAddrListUI psL;

    MailAddrListUI$1(MailAddrListUI mailAddrListUI) {
        this.psL = mailAddrListUI;
    }

    public final void onComplete() {
        if (MailAddrListUI.a(this.psL) != null) {
            MailAddrListUI.a(this.psL).dismiss();
        }
        MailAddrListUI.a(this.psL, MailAddrListUI.b(this.psL).HJ(null));
        if (MailAddrListUI.c(this.psL).size() == 0) {
            MailAddrListUI.d(this.psL).setText(R.l.eMM);
            MailAddrListUI.d(this.psL).setVisibility(0);
        }
        String[] stringArrayExtra = this.psL.getIntent().getStringArrayExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA");
        for (String HK : stringArrayExtra == null ? new String[]{""} : stringArrayExtra) {
            i HK2 = j.HK(HK);
            if (HK2 != null) {
                int i;
                for (i iVar : MailAddrListUI.c(this.psL)) {
                    if (iVar.nQt.equalsIgnoreCase(HK2.nQt)) {
                        MailAddrListUI.e(this.psL).c(iVar);
                        i = 1;
                        break;
                    }
                }
                i = 0;
                if (i == 0) {
                    MailAddrListUI.e(this.psL).c(HK2);
                }
            }
        }
        this.psL.setMMTitle(this.psL.getString(R.l.eAg) + (MailAddrListUI.e(this.psL).bkT() > 0 ? "(" + MailAddrListUI.e(this.psL).bkT() + ")" : ""));
        MailAddrListUI.e(this.psL).notifyDataSetChanged();
    }
}
