package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.remittance.model.n;
import com.tencent.mm.plugin.remittance.model.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.ui.e;

public class RemittanceHKUI extends RemittanceBaseUI {
    private int pOW;
    private String pOX;
    private String pOY;
    private String pOZ;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ji(1529);
        ji(1257);
        this.pOW = getIntent().getIntExtra("hk_currency", 0);
        this.pOX = getIntent().getStringExtra("hk_currencyuint");
        this.pOY = getIntent().getStringExtra("hk_notice");
        this.pOZ = getIntent().getStringExtra("hk_notice_url");
        this.llY.xv(this.pOX);
        this.pMd.setText(this.pOX);
    }

    public void onDestroy() {
        super.onDestroy();
        jj(1529);
        jj(1257);
    }

    public final void bnH() {
    }

    public final void dQ(String str, String str2) {
        x.d("MicroMsg.RemittanceHKUI", "do scene gen pay");
        int i = 0;
        if (this.pLT == 33) {
            i = 1;
        }
        b(new o(Math.round(this.pLR * 100.0d), this.gAb, this.pLS, this.pMg, this.gAT, this.pLU, this.pOW, i), true);
    }

    public final void bnK() {
        u.makeText(this.mController.xIM, getString(i.uNX, new Object[]{this.pOX}), 0).show();
    }

    public final void bnN() {
        if (!bh.ov(this.pOY)) {
            TextView textView = (TextView) findViewById(f.ufy);
            textView.setText(this.pOY);
            textView.setOnClickListener(new 1(this));
        }
    }

    public final void bnI() {
        int i;
        x.d("MicroMsg.RemittanceHKUI", "do scene cancel");
        if (this.pLT == 33) {
            i = 1;
        } else {
            i = 0;
        }
        b(new n(this.gAb, this.pLU, this.pOW, ((long) this.pLR) * 100, i), false);
    }

    public final void b(int i, int i2, String str, k kVar, boolean z) {
        if (kVar instanceof o) {
            o oVar = (o) kVar;
            if (i != 0 || i2 != 0) {
                h.b(this.mController.xIM, str, "", false);
                return;
            } else if (bh.ov(oVar.pKC)) {
                x.e("MicroMsg.RemittanceHKUI", "empty payurl");
                return;
            } else {
                e.r(this.mController.xIM, oVar.pKC, 4);
                return;
            }
        }
        super.b(i, i2, str, kVar, z);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 4 && i2 == -1) {
            finish();
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final void bnR() {
    }
}
