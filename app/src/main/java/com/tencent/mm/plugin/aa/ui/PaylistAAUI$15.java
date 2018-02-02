package com.tencent.mm.plugin.aa.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.i$a;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.wallet_core.ui.e;

class PaylistAAUI$15 implements a {
    final /* synthetic */ PaylistAAUI ikp;

    PaylistAAUI$15(PaylistAAUI paylistAAUI) {
        this.ikp = paylistAAUI;
    }

    public final void aW(Object obj) {
        x.i("MicroMsg.PaylistAAUI", "aapay failed: %s", new Object[]{obj});
        if (PaylistAAUI.d(this.ikp) != null) {
            PaylistAAUI.d(this.ikp).dismiss();
        }
        if (obj == null) {
            Toast.makeText(this.ikp, this.ikp.getString(i.uHf), 1).show();
        } else if (obj instanceof com.tencent.mm.protocal.c.a) {
            final com.tencent.mm.protocal.c.a aVar = (com.tencent.mm.protocal.c.a) obj;
            String str = aVar.fyY;
            String str2 = aVar.odw;
            String str3 = aVar.odx;
            i$a com_tencent_mm_ui_base_i_a = new i$a(this.ikp);
            com_tencent_mm_ui_base_i_a.YG(str);
            com_tencent_mm_ui_base_i_a.YI(str3).a(new OnClickListener(this) {
                final /* synthetic */ PaylistAAUI$15 ikx;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    e.l(this.ikx.ikp.mController.xIM, aVar.liO, false);
                }
            });
            com_tencent_mm_ui_base_i_a.YJ(str2);
            com_tencent_mm_ui_base_i_a.akx().show();
        } else if ((obj instanceof String) && !obj.toString().equalsIgnoreCase("ok")) {
            Toast.makeText(this.ikp, obj.toString(), 1).show();
        }
    }
}
