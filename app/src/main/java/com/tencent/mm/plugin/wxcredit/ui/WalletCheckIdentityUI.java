package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;

public class WalletCheckIdentityUI extends WalletBaseUI {
    private WalletFormView sGY;
    private WalletFormView sRj;
    private String tZA;

    static /* synthetic */ boolean a(WalletCheckIdentityUI walletCheckIdentityUI, String str, String str2) {
        if (bh.ov(str)) {
            u.makeText(walletCheckIdentityUI, i.uQM, 0).show();
            return false;
        } else if (!bh.ov(str2) && str2.length() >= 4 && (!bh.ov(walletCheckIdentityUI.tZA) || walletCheckIdentityUI.sGY.XO())) {
            return true;
        } else {
            u.makeText(walletCheckIdentityUI, i.uyt, 0).show();
            return false;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.uGc;
    }

    public final void initView() {
        setMMTitle(i.uQN);
        this.sRj = (WalletFormView) findViewById(f.urM);
        a.e(this, this.sRj);
        this.sGY = (WalletFormView) findViewById(f.ukS);
        a.b(this.sGY);
        e(this.sGY, 1, false);
        CharSequence string = this.vf.getString("key_pre_name");
        this.tZA = this.vf.getString("key_pre_indentity");
        if (!bh.ov(string)) {
            this.sRj.pEg.setText(string);
            this.sRj.setHint(getString(i.uQG));
        }
        if (!bh.ov(this.tZA)) {
            this.sGY.pEC = 4;
            this.sGY.pEg.setText(this.tZA);
            this.sGY.setHint(getString(i.uQp));
        }
        findViewById(f.cAg).setOnClickListener(new 1(this));
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
