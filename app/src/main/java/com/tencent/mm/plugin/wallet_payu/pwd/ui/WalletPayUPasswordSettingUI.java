package com.tencent.mm.plugin.wallet_payu.pwd.ui;

import com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI;
import com.tencent.mm.plugin.wallet_payu.pwd.a.f;
import com.tencent.mm.plugin.wallet_payu.pwd.a.g;
import com.tencent.mm.plugin.wxpay.a$l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.a;

public class WalletPayUPasswordSettingUI extends WalletPasswordSettingUI {
    protected final void bKD() {
        x.d("MicroMsg.WalletPayUPasswordSettingUI", "hy: start payu do forgot pwd");
        a.a(this, f.class, null);
    }

    protected final void bKC() {
        x.d("MicroMsg.WalletPayUPasswordSettingUI", "hy: start payu reset pwd");
        a.a(this, g.class, null);
    }

    protected final void bKE() {
        this.yjd.bk("wallet_modify_gesture_password", true);
        this.yjd.bk("wallet_open_gesture_password", true);
    }

    protected final int bKB() {
        return a$l.vau;
    }
}
