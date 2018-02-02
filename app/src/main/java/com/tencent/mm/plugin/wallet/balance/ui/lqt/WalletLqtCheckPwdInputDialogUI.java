package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.ui.m;
import com.tencent.mm.plugin.wxpay.a$c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

@a(3)
public class WalletLqtCheckPwdInputDialogUI extends WalletBaseUI {
    private String mTitle = "";
    private String szg = "";
    private m szh;

    public void onCreate(Bundle bundle) {
        int i = 1;
        super.onCreate(bundle);
        uD(4);
        this.mTitle = getIntent().getStringExtra("lqt_fetch_pwd_title");
        this.szg = getIntent().getStringExtra("lqt_fetch_pwd_money");
        x.i("MicroMsg.WalletLqtCheckPwdInputDialogUI", "hy: money : %s, title : %s", new Object[]{bh.ou(this.szg), bh.ou(this.mTitle)});
        if (bh.ov(this.mTitle) || bh.ov(this.szg)) {
            i = 0;
        }
        if (i == 0) {
            h.a(this.mController.xIM, i.uTp, 0, new 1(this));
            return;
        }
        getWindow().setBackgroundDrawableResource(a$c.transparent);
        showDialog();
    }

    private void showDialog() {
        if (this.szh != null && this.szh.isShowing()) {
            this.szh.dismiss();
        }
        if (this.szh == null) {
            this.szg = e.u(bh.getDouble(this.szg, 0.0d));
            this.szh = m.a(this, this.mTitle, this.szg, "", new 2(this), new 3(this), new m.a(this) {
                final /* synthetic */ WalletLqtCheckPwdInputDialogUI sAp;

                {
                    this.sAp = r1;
                }

                public final void bho() {
                    x.i("MicroMsg.WalletLqtCheckPwdInputDialogUI", "hy: pwd cancel.finish");
                    this.sAp.szh.dismiss();
                    this.sAp.finish();
                }
            });
            return;
        }
        this.szh.bmK();
        this.szh.show();
    }

    public final void uw(int i) {
        if (i == 0) {
            finish();
        } else if (i == 1) {
            showDialog();
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return -1;
    }
}
