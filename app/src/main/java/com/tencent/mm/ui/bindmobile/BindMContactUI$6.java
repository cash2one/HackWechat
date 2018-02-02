package com.tencent.mm.ui.bindmobile;

import android.content.Intent;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.R;
import com.tencent.mm.g.a.sa;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.friend.i$a;
import com.tencent.mm.z.q;

class BindMContactUI$6 implements i$a {
    final /* synthetic */ String kik;
    final /* synthetic */ BindMContactUI ylT;

    BindMContactUI$6(BindMContactUI bindMContactUI, String str) {
        this.ylT = bindMContactUI;
        this.kik = str;
    }

    public final void Eh(int i) {
        Intent intent;
        if (i == 1) {
            if (BindMContactUI.h(this.ylT)) {
                x.i("MicroMsg.BindMContactUI", "to startMySafedeviceListUI");
                if (!q.Ga()) {
                    b saVar = new sa();
                    saVar.fJK.fJL = true;
                    saVar.fJK.fJM = true;
                    a.xef.m(saVar);
                }
                BindMContactUI.i(this.ylT);
                intent = new Intent();
                intent.addFlags(67108864);
                com.tencent.mm.plugin.c.a.ifs.e(this.ylT, intent);
            } else if (BindMContactUI.j(this.ylT)) {
                x.i("MicroMsg.BindMContactUI", "to BindMContactStatusUI for change mobile");
                h.bu(this.ylT, this.ylT.getString(R.l.eGx));
                MMWizardActivity.A(this.ylT, new Intent(this.ylT, BindMContactStatusUI.class));
            } else if (BindMContactUI.k(this.ylT) == 5) {
                x.i("MicroMsg.BindMContactUI", "to finish  finishWizard for get phone number");
                BindMContactUI.l(this.ylT);
            } else {
                if (BindMContactUI.m(this.ylT)) {
                    if (BindMContactUI.n(this.ylT)) {
                        g.pQN.h(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, new Object[]{Integer.valueOf(3), Integer.valueOf(3)});
                    } else {
                        g.pQN.h(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, new Object[]{Integer.valueOf(1), Integer.valueOf(2)});
                    }
                }
                x.i("MicroMsg.BindMContactUI", "to BindMContactStatusUI for contact sync or other");
                MMWizardActivity.A(this.ylT, new Intent(this.ylT, BindMContactStatusUI.class));
            }
        } else if (i == 2) {
            x.i("MicroMsg.BindMContactUI", "reg next to BindMContactVerifyUI for bind mobile");
            intent = new Intent(this.ylT, BindMContactVerifyUI.class);
            intent.putExtra("bindmcontact_mobile", this.kik);
            intent.putExtra("is_bind_for_safe_device", BindMContactUI.h(this.ylT));
            intent.putExtra("is_bind_for_contact_sync", BindMContactUI.n(this.ylT));
            intent.putExtra("is_bind_for_change_mobile", BindMContactUI.j(this.ylT));
            intent.putExtra("KEnterFromBanner", BindMContactUI.m(this.ylT));
            if (BindMContactUI.o(this.ylT) != null) {
                intent.putExtra("BIND_FIND_ME_BY_MOBILE", BindMContactUI.o(this.ylT).isChecked());
            }
            intent.putExtra("BIND_FOR_QQ_REG", BindMContactUI.p(this.ylT));
            intent.putExtra("bind_scene", BindMContactUI.k(this.ylT));
            MMWizardActivity.A(this.ylT, intent);
        }
    }
}
