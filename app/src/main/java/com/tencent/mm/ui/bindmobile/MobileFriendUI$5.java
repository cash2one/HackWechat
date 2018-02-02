package com.tencent.mm.ui.bindmobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class MobileFriendUI$5 implements OnClickListener {
    final /* synthetic */ MobileFriendUI ymF;

    MobileFriendUI$5(MobileFriendUI mobileFriendUI) {
        this.ymF = mobileFriendUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.pQN.h(11438, new Object[]{Integer.valueOf(6)});
        x.i("MicroMsg.MobileFriendUI", "[cpan] kv report logid:%d scene:%d", new Object[]{Integer.valueOf(11438), Integer.valueOf(6)});
        ar.Hg();
        c.CU().set(12322, Boolean.valueOf(true));
        m.k(true, true);
        MobileFriendUI.h(this.ymF);
    }
}
