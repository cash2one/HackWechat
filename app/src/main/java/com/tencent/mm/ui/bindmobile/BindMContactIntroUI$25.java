package com.tencent.mm.ui.bindmobile;

import android.content.Intent;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.g.a.sa;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.friend.i.a;
import com.tencent.mm.z.q;

class BindMContactIntroUI$25 implements a {
    final /* synthetic */ String kik;
    final /* synthetic */ BindMContactIntroUI ylI;

    BindMContactIntroUI$25(BindMContactIntroUI bindMContactIntroUI, String str) {
        this.ylI = bindMContactIntroUI;
        this.kik = str;
    }

    public final void Eh(int i) {
        Intent intent;
        if (i == 1) {
            if (BindMContactIntroUI.f(this.ylI)) {
                if (!q.Ga()) {
                    b saVar = new sa();
                    saVar.fJK.fJL = true;
                    saVar.fJK.fJM = true;
                    com.tencent.mm.sdk.b.a.xef.m(saVar);
                }
                BindMContactIntroUI.g(this.ylI);
                intent = new Intent();
                intent.addFlags(67108864);
                com.tencent.mm.plugin.c.a.ifs.e(this.ylI, intent);
                return;
            }
            MMWizardActivity.A(this.ylI, new Intent(this.ylI, BindMContactStatusUI.class).putExtra("is_bind_for_contact_sync", BindMContactIntroUI.h(this.ylI)));
            if (!BindMContactIntroUI.i(this.ylI)) {
                return;
            }
            if (BindMContactIntroUI.h(this.ylI)) {
                g.pQN.h(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, new Object[]{Integer.valueOf(3), Integer.valueOf(3)});
                return;
            }
            g.pQN.h(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, new Object[]{Integer.valueOf(1), Integer.valueOf(2)});
        } else if (i == 2) {
            intent = new Intent(this.ylI, BindMContactVerifyUI.class);
            intent.putExtra("bindmcontact_mobile", this.kik);
            intent.putExtra("is_bind_for_safe_device", BindMContactIntroUI.f(this.ylI));
            intent.putExtra("is_bind_for_contact_sync", BindMContactIntroUI.h(this.ylI));
            intent.putExtra("KEnterFromBanner", BindMContactIntroUI.i(this.ylI));
            MMWizardActivity.A(this.ylI, intent);
        }
    }
}
