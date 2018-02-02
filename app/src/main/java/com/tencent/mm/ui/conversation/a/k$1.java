package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.bk.a;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.az;
import com.tencent.mm.z.bi;
import com.tencent.mm.z.c;

class k$1 implements OnClickListener {
    final /* synthetic */ int iGh;
    final /* synthetic */ int xFz;
    final /* synthetic */ k zaU;

    k$1(k kVar, int i, int i2) {
        this.zaU = kVar;
        this.iGh = i;
        this.xFz = i2;
    }

    public final void onClick(View view) {
        az.Hs().aX(this.iGh, this.xFz);
        Context context = (Context) this.zaU.voC.get();
        if (context != null) {
            g.pQN.h(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, new Object[]{Integer.valueOf(5), Integer.valueOf(1)});
            ar.Hg();
            boolean c = bh.c((Boolean) c.CU().get(4103, null));
            new Intent().putExtra("KEnterFromBanner", true);
            if (c) {
                bi HR = bi.HR();
                if (HR == null) {
                    d.y(context, "nearby", ".ui.NearbyPersonalInfoUI");
                    return;
                }
                String ou = bh.ou(HR.getProvince());
                int a = bh.a(Integer.valueOf(HR.fWf), 0);
                if (bh.ov(ou) || a == 0) {
                    d.y(context, "nearby", ".ui.NearbyPersonalInfoUI");
                    return;
                }
                LauncherUI cmG = LauncherUI.cmG();
                if (cmG != null) {
                    cmG.xGS.xGh.Yp("tab_find_friend");
                }
                a.dV(context);
                return;
            }
            d.y(context, "nearby", ".ui.NearbyFriendsIntroUI");
        }
    }
}
