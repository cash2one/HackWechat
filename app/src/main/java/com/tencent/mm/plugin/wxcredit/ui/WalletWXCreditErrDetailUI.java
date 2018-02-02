package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class WalletWXCreditErrDetailUI extends WalletBaseUI {
    private Bankcard sAg;
    private String uaf;
    private TextView uag;
    private TextView uah;

    protected final int getLayoutId() {
        return g.uGf;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.uPI);
        initView();
    }

    protected final void initView() {
        this.sAg = (Bankcard) this.vf.getParcelable("key_bankcard");
        this.uaf = this.vf.getString("key_repayment_url");
        if (this.sAg != null) {
            this.uag = (TextView) findViewById(f.uxX);
            this.uag.setOnClickListener(new 1(this));
            this.uah = (TextView) findViewById(f.uxY);
            this.uah.setOnClickListener(new 2(this));
            this.uah.setVisibility(this.vf.getBoolean("key_can_unbind", true) ? 0 : 8);
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }
}
