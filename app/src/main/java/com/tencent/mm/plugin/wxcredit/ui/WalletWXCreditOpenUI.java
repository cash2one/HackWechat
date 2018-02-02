package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class WalletWXCreditOpenUI extends WalletBaseUI {
    private Button lRZ;
    private Bankcard sDc;

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.uGi;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.sDc = (Bankcard) this.vf.getParcelable("key_bankcard");
        initView();
    }

    protected final void initView() {
        setMMTitle(i.uYc);
        ((CheckBox) findViewById(f.uex)).setOnCheckedChangeListener(new 1(this));
        findViewById(f.bJC).setOnClickListener(new 2(this));
        this.lRZ = (Button) findViewById(f.cAg);
        this.lRZ.setOnClickListener(new 3(this));
    }
}
