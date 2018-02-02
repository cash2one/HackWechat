package com.tencent.mm.plugin.masssend.ui;

import android.database.Cursor;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.plugin.masssend.a.a;
import com.tencent.mm.plugin.masssend.a.b;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class MassSendHistoryUI$4 implements d {
    final /* synthetic */ MassSendHistoryUI onL;

    MassSendHistoryUI$4(MassSendHistoryUI massSendHistoryUI) {
        this.onL = massSendHistoryUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (menuItem.getItemId() == 1) {
            a aVar = (a) MassSendHistoryUI.b(this.onL).getItem(menuItem.getGroupId());
            if (aVar != null) {
                if (aVar.aYv().equals(MassSendHistoryUI.b(this.onL).ons)) {
                    MassSendHistoryUI.h(this.onL);
                }
                b aYD = h.aYD();
                String aYv = aVar.aYv();
                Cursor a = aYD.hhp.a("select * from massendinfo ORDER BY createtime DESC  limit 2", null, 0);
                if (a != null) {
                    if (a.getCount() == 0) {
                        a.close();
                    } else if (a.getCount() == 1) {
                        a.moveToFirst();
                        r3 = new a();
                        r3.b(a);
                        a.close();
                        r2 = new ae();
                        r2.setUsername("masssendapp");
                        r2.setContent(ac.getContext().getResources().getString(R.l.dVA));
                        r2.aj(r3.hVE);
                        r2.eR(0);
                        r2.eO(0);
                        ar.Hg();
                        c.Fd().a(r2, "masssendapp");
                    } else {
                        a.moveToPosition(1);
                        r3 = new a();
                        r3.b(a);
                        a.close();
                        r2 = new ae();
                        r2.setUsername("masssendapp");
                        r2.setContent(b.a(r3));
                        r2.aj(r3.hVE);
                        r2.eR(0);
                        r2.eO(0);
                        ar.Hg();
                        c.Fd().a(r2, "masssendapp");
                    }
                }
                if (aYD.hhp.delete("massendinfo", "clientid= ?", new String[]{aYv}) > 0) {
                    aYD.doNotify();
                }
            }
        }
    }
}
