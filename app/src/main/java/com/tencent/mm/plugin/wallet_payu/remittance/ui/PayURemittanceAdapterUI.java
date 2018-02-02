package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.Intent;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.z.ak;

@a(7)
public class PayURemittanceAdapterUI extends RemittanceAdapterUI {
    protected final void bnG() {
        b(new e(this.gAb), false);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        super.d(i, i2, str, kVar);
        if (kVar instanceof e) {
            this.pLL = false;
        }
        if (i != 0 || i2 != 0 || !(kVar instanceof e)) {
            return false;
        }
        e eVar = (e) kVar;
        this.gAb = eVar.username;
        if (bh.ov(this.gAb)) {
            x.d("MicroMsg.PayURemittanceAdapterUI", "Username empty & fishsh. scene=" + this.irz);
            finish();
            return true;
        }
        Intent intent = new Intent();
        intent.putExtra("fee", eVar.ljg);
        intent.putExtra("desc", eVar.desc);
        intent.putExtra("scan_remittance_id", eVar.pLe);
        intent.putExtra("receiver_true_name", com.tencent.mm.wallet_core.ui.e.aaA(eVar.pLd));
        g.Dk();
        if (((h) g.h(h.class)).EY().WN(this.gAb) != null) {
            c(this.gAb, eVar.scene, intent);
        } else {
            x.d("MicroMsg.PayURemittanceAdapterUI", "Receiver in contactStg and try to get contact");
            ak.a.hfL.a(this.gAb, "", new 1(this, bh.Wp(), eVar, intent));
        }
        return true;
    }

    protected final void c(String str, int i, Intent intent) {
        Intent intent2;
        x.i("MicroMsg.PayURemittanceAdapterUI", "startRemittanceUI scene=" + this.irz + ", name=" + str);
        if (intent != null) {
            intent2 = new Intent(intent);
        } else {
            intent2 = new Intent();
        }
        intent2.setClass(this, PayURemittanceUI.class);
        intent2.putExtra("receiver_name", str);
        intent2.putExtra("scene", this.irz);
        intent2.putExtra("pay_scene", i);
        startActivity(intent2);
        setResult(-1);
        finish();
    }
}
