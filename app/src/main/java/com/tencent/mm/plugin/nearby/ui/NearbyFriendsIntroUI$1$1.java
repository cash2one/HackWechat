package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.nearby.ui.NearbyFriendsIntroUI.1;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.t;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bi;
import com.tencent.mm.z.c;

class NearbyFriendsIntroUI$1$1 implements OnClickListener {
    final /* synthetic */ 1 oOA;

    NearbyFriendsIntroUI$1$1(1 1) {
        this.oOA = 1;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        boolean z = true;
        ar.Hg();
        c.CU().set(4103, Boolean.valueOf(true));
        ar.Hg();
        t CU = c.CU();
        if (NearbyFriendsIntroUI.c(this.oOA.oOz).isChecked()) {
            z = false;
        }
        CU.set(4104, Boolean.valueOf(z));
        bi HR = bi.HR();
        if (HR == null) {
            this.oOA.oOz.startActivity(new Intent(this.oOA.oOz, NearbyPersonalInfoUI.class));
        } else {
            String ou = bh.ou(HR.getProvince());
            bh.ou(HR.getCity());
            int a = bh.a(Integer.valueOf(HR.fWf), 0);
            if (ou.equals("") || a == 0) {
                this.oOA.oOz.startActivity(new Intent(this.oOA.oOz, NearbyPersonalInfoUI.class));
            } else {
                this.oOA.oOz.startActivity(new Intent(this.oOA.oOz, NearbyFriendsUI.class));
            }
        }
        this.oOA.oOz.finish();
    }
}
