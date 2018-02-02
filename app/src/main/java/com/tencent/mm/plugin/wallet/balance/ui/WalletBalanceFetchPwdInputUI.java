package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.m;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

@a(3)
public class WalletBalanceFetchPwdInputUI extends WalletBaseUI {
    private String mTitle = "";
    private String szg = "";
    private m szh;

    public void onCreate(Bundle bundle) {
        int i = 1;
        super.onCreate(bundle);
        uD(4);
        this.mTitle = this.vf.getString("key_pwd_cash_title");
        this.szg = this.vf.getString("key_pwd_cash_money");
        x.i("MicroMsg.WalletBalanceFetchPwdInputUI", "hy: money : %s, title : %s", new Object[]{bh.ou(this.szg), bh.ou(this.mTitle)});
        if (bh.ov(this.mTitle) || bh.ov(this.szg)) {
            i = 0;
        }
        if (i == 0) {
            h.a(this.mController.xIM, i.uTp, 0, new OnClickListener(this) {
                final /* synthetic */ WalletBalanceFetchPwdInputUI szi;

                {
                    this.szi = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.szi.finish();
                }
            });
        } else {
            showDialog();
        }
    }

    private void showDialog() {
        if (this.szh != null && this.szh.isShowing()) {
            this.szh.dismiss();
        }
        String str = "";
        if (((Orders) this.vf.getParcelable("key_orders")).pKL > 0.0d) {
            str = getResources().getString(i.uOQ, new Object[]{e.d(r0.pKL, r0.paz)});
        }
        if (this.szh == null) {
            this.szh = m.a(this, this.mTitle, this.szg, str, new 2(this), new 3(this), new 4(this));
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
