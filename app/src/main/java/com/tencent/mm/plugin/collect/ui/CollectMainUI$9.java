package com.tencent.mm.plugin.collect.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aqz;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class CollectMainUI$9 implements OnClickListener {
    final /* synthetic */ CollectMainUI lnh;
    final /* synthetic */ aqz lnk;

    CollectMainUI$9(CollectMainUI collectMainUI, aqz com_tencent_mm_protocal_c_aqz) {
        this.lnh = collectMainUI;
        this.lnk = com_tencent_mm_protocal_c_aqz;
    }

    public final void onClick(View view) {
        Intent intent;
        if (this.lnk.type == 1) {
            if (this.lnk.url.equals("wxpay://f2f/f2fdetail")) {
                intent = new Intent(this.lnh.mController.xIM, CollectBillUI.class);
                intent.putExtra("key_from_scene", 0);
                this.lnh.startActivityForResult(intent, 4097);
                g.pQN.h(13944, new Object[]{Integer.valueOf(1)});
                g.pQN.h(14526, new Object[]{Integer.valueOf(1), Integer.valueOf(1), this.lnk.fyY, "", "", "", Integer.valueOf(2)});
                if (this.lnk.wyT == 1) {
                    g.pQN.h(14526, new Object[]{Integer.valueOf(3), Integer.valueOf(1), this.lnk.fyY, "", "", "", Integer.valueOf(2)});
                }
            }
        } else if (this.lnk.type == 2) {
            if (bh.ov(this.lnk.url)) {
                x.w("MicroMsg.CollectMainUI", "empty bottom h5 url");
                return;
            }
            e.l(this.lnh.mController.xIM, this.lnk.url, false);
            g.pQN.h(14526, new Object[]{Integer.valueOf(1), Integer.valueOf(2), this.lnk.fyY, "", "", this.lnk.url, Integer.valueOf(2)});
            if (this.lnk.wyT == 1) {
                g.pQN.h(14526, new Object[]{Integer.valueOf(3), Integer.valueOf(2), this.lnk.fyY, "", "", this.lnk.url, Integer.valueOf(2)});
            }
        } else if (this.lnk.type == 3) {
            b qpVar = new qp();
            qpVar.fIi.userName = this.lnk.wyQ;
            qpVar.fIi.fIk = bh.az(this.lnk.wyR, "");
            qpVar.fIi.scene = 1072;
            qpVar.fIi.fIl = 0;
            a.xef.m(qpVar);
            g.pQN.h(14526, new Object[]{Integer.valueOf(1), Integer.valueOf(3), this.lnk.fyY, this.lnk.wyQ, this.lnk.wyR, "", Integer.valueOf(2)});
            if (this.lnk.wyT == 1) {
                g.pQN.h(14526, new Object[]{Integer.valueOf(3), Integer.valueOf(3), this.lnk.fyY, this.lnk.wyQ, this.lnk.wyR, "", Integer.valueOf(2)});
            }
        } else {
            intent = new Intent(this.lnh.mController.xIM, CollectBillUI.class);
            intent.putExtra("key_from_scene", 0);
            this.lnh.startActivityForResult(intent, 4097);
            g.pQN.h(13944, new Object[]{Integer.valueOf(1)});
        }
        this.lnh.lmX.setVisibility(4);
        this.lnh.lmY.setVisibility(8);
    }
}
