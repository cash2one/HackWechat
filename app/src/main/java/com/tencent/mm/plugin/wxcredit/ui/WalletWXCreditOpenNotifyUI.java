package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletWXCreditOpenNotifyUI extends WalletBaseUI {
    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.uGg;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Dj().CU().set(196658, Boolean.valueOf(false));
        initView();
    }

    protected final void initView() {
        int i = 0;
        setMMTitle(i.uXY);
        showHomeBtn(false);
        enableBackMenu(false);
        addTextOptionMenu(0, getString(i.dFl), new 1(this));
        ((TextView) findViewById(f.uAo)).setText(e.u(this.vf.getDouble("key_total_amount")));
        Button button = (Button) findViewById(f.cAg);
        button.setOnClickListener(new 2(this));
        if (!this.vf.getBoolean("key_can_upgrade_amount", true)) {
            i = 8;
        }
        button.setVisibility(i);
    }
}
