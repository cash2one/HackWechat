package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tenpay.android.wechat.TenpaySecureEditText;

class RemittanceBusiUI$a {
    private View kpZ;
    final /* synthetic */ RemittanceBusiUI pOd;
    private float pOl;
    private float pOm;
    private float pOn;
    private TenpaySecureEditText pOo;
    private TextView pOp;
    private View pOq;

    RemittanceBusiUI$a(RemittanceBusiUI remittanceBusiUI, int i, int i2, float f) {
        this.pOd = remittanceBusiUI;
        this.pOl = (float) i;
        this.pOm = (float) i2;
        this.pOn = f;
    }

    final void update() {
        RemittanceBusiUI.b(this.pOd).setTextSize(1, RemittanceBusiUI.a(this.pOd).pOm);
        RemittanceBusiUI.c(this.pOd).setTextSize(1, RemittanceBusiUI.a(this.pOd).pOl);
        if (this.pOp == null) {
            this.pOp = (TextView) RemittanceBusiUI.d(this.pOd).findViewById(f.uAj);
        }
        if (this.pOp != null) {
            this.pOp.setTextSize(this.pOl);
        }
        if (this.pOo == null) {
            this.pOo = (TenpaySecureEditText) RemittanceBusiUI.d(this.pOd).findViewById(f.uyz);
        }
        if (this.pOo != null) {
            this.pOo.setTextSize(this.pOm);
        }
        if (this.kpZ == null) {
            this.kpZ = this.pOo.findViewById(f.urF);
        }
        if (this.kpZ != null) {
            this.kpZ.setMinimumHeight(b.b(this.pOd, RemittanceBusiUI.a(this.pOd).pOm));
        }
        if (this.pOq == null) {
            this.pOq = this.pOd.findViewById(f.uAE);
        }
        if (this.pOq != null) {
            ((LayoutParams) this.pOq.getLayoutParams()).topMargin = b.b(this.pOd, this.pOn);
        }
    }
}
