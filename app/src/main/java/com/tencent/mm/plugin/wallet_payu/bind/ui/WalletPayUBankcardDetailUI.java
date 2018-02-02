package com.tencent.mm.plugin.wallet_payu.bind.ui;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;

public class WalletPayUBankcardDetailUI extends WalletBankcardDetailUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (1 == this.sAg.field_bankcardState) {
            bJE();
            findViewById(f.uxM).setVisibility(8);
            findViewById(f.uxL).setVisibility(8);
        } else {
            jy(false);
        }
        findViewById(f.uxO).setVisibility(8);
        ((TextView) findViewById(f.uxQ)).setText(i.uPH);
    }
}
