package com.tencent.mm.plugin.remittance.ui;

import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.remittance.model.w;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class RemittanceResendMsgUI extends WalletBaseUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.contentView.setVisibility(8);
        setTitleVisibility(8);
        String stringExtra = getIntent().getStringExtra("transaction_id");
        String stringExtra2 = getIntent().getStringExtra("receiver_name");
        int intExtra = getIntent().getIntExtra("resend_msg_from_flag", 1);
        int intExtra2 = getIntent().getIntExtra("invalid_time", 0);
        if (!bh.ov(stringExtra2)) {
            k(stringExtra, stringExtra2, intExtra2, intExtra);
        }
    }

    public void k(String str, String str2, int i, int i2) {
        k wVar = new w(str, str2, i, i2);
        wVar.gOs = "RemittanceProcess";
        l(wVar);
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof w)) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            h.bu(this, getString(i.uOd));
            finish();
            return true;
        }
        h.bu(this, str);
        finish();
        return true;
    }

    protected final int getLayoutId() {
        return -1;
    }
}
