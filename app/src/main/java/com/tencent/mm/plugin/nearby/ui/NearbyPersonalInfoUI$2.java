package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bi;
import com.tencent.mm.z.c;

class NearbyPersonalInfoUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ NearbyPersonalInfoUI oPg;

    NearbyPersonalInfoUI$2(NearbyPersonalInfoUI nearbyPersonalInfoUI) {
        this.oPg = nearbyPersonalInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        bi HQ;
        if (NearbyPersonalInfoUI.a(this.oPg) != -1) {
            HQ = bi.HQ();
            HQ.fWf = NearbyPersonalInfoUI.a(this.oPg);
            bi.a(HQ);
        }
        HQ = bi.HR();
        if (HQ == null) {
            NearbyPersonalInfoUI.b(this.oPg);
        } else {
            String ou = bh.ou(HQ.getProvince());
            bh.ou(HQ.getCity());
            int i = HQ.fWf;
            if (bh.ov(ou) || i == 0) {
                NearbyPersonalInfoUI.b(this.oPg);
            } else {
                this.oPg.startActivity(new Intent(this.oPg, NearbyFriendsUI.class));
                bi HQ2 = bi.HQ();
                if (i != -1) {
                    HQ2.fWf = i;
                }
                ar.Hg();
                c.EX().b(new a(1, bi.a(HQ2)));
                this.oPg.finish();
            }
        }
        return true;
    }
}
