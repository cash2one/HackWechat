package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.f;
import com.tencent.mm.ui.base.a;

@a(3)
public class WalletChangeLoanRepayBankcardUI extends WalletChangeBankcardUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new 1(this));
    }

    protected final f bJY() {
        this.szk = o.bLr().sPU;
        bJX();
        return new f(this, this.szk, this.sEM, this.pPl);
    }

    protected final void zf(int i) {
        int size = this.szk != null ? this.szk.size() : 0;
        if (this.szk != null && i < size) {
            Bankcard bankcard = (Bankcard) this.szk.get(i);
            this.szl = bankcard;
            this.sEN.sSZ = bankcard.field_bindSerial;
            this.pNB.setEnabled(true);
            this.sEN.notifyDataSetChanged();
            Intent intent = new Intent();
            intent.putExtra("bindSerial", bankcard.field_bindSerial);
            intent.putExtra("ret", 0);
            setResult(-1, intent);
        } else if (size == i) {
            Intent intent2 = new Intent();
            intent2.putExtra("ret", -1003);
            setResult(-1, intent2);
        }
        finish();
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
