package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.remittance.model.p;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.q;

@a(7)
public class RemittanceOSRedirect extends WalletBaseUI {
    public String gAb = "";
    private int irz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitleVisibility(8);
        this.irz = getIntent().getIntExtra("scene", 0);
        this.gAb = getIntent().getStringExtra("receiver_name");
        if (this.irz == 0) {
            x.e("MicroMsg.RemittanceOSRedirect", "error scene: %s", new Object[]{Integer.valueOf(this.irz)});
            finish();
        } else if (this.irz == 5) {
            this.zIY.ji(1574);
            l(new com.tencent.mm.plugin.remittance.model.x(q.FZ()));
        } else if (this.irz == 6) {
            this.zIY.ji(1301);
            b(new p(this.gAb), true);
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return true;
    }

    public final void b(int i, int i2, String str, k kVar, boolean z) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.remittance.model.x) {
                com.tencent.mm.plugin.remittance.model.x xVar = (com.tencent.mm.plugin.remittance.model.x) kVar;
                x.i("MicroMsg.RemittanceOSRedirect", "indexScene  %s", new Object[]{xVar.pLC});
                Intent intent = getIntent();
                if (xVar.liR == 1) {
                    h.a(this, 2, this.gAb, 11, null);
                } else {
                    intent.setClass(this, RemittanceOSUI.class);
                    intent.putExtra("os_currency", xVar.liR);
                    intent.putExtra("os_currencyuint", xVar.pLC);
                    intent.putExtra("os_currencywording", xVar.pLD);
                    intent.putExtra("os_notice", xVar.liT);
                    intent.putExtra("os_notice_url", xVar.liU);
                    startActivity(intent);
                }
                finish();
            } else if (kVar instanceof p) {
                p pVar = (p) kVar;
                Intent intent2 = new Intent();
                intent2.setClass(this, RemittanceHKUI.class);
                this.gAb = pVar.pKD;
                if (bh.ov(this.gAb)) {
                    x.e("MicroMsg.RemittanceOSRedirect", "empty username");
                    finish();
                }
                intent2.putExtra("scene", this.irz);
                intent2.putExtra("fee", ((double) pVar.fLR) / 100.0d);
                intent2.putExtra("desc", pVar.desc);
                intent2.putExtra("scan_remittance_id", pVar.pKF);
                intent2.putExtra("receiver_name", pVar.pKD);
                intent2.putExtra("receiver_true_name", pVar.liV);
                intent2.putExtra("receiver_nick_name", pVar.pKE);
                intent2.putExtra("hk_currency", pVar.liR);
                intent2.putExtra("hk_currencyuint", pVar.liS);
                intent2.putExtra("hk_notice", pVar.liT);
                intent2.putExtra("hk_notice_url", pVar.liU);
                int i3 = 32;
                x.i("MicroMsg.RemittanceOSRedirect", "setAmount: %d", new Object[]{Integer.valueOf(pVar.liW)});
                if (pVar.liW == 1) {
                    i3 = 33;
                }
                intent2.putExtra("pay_scene", i3);
                g.Dk();
                if (((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().WN(this.gAb) != null) {
                    startActivity(intent2);
                    finish();
                    return;
                }
                x.d("MicroMsg.RemittanceOSRedirect", "Receiver in contactStg and try to get contact");
                ak.a.hfL.a(this.gAb, "", new 1(this, bh.Wp(), intent2));
            }
        } else if (kVar instanceof com.tencent.mm.plugin.remittance.model.x) {
            x.i("MicroMsg.RemittanceOSRedirect", "indexScene  errMsg %s", new Object[]{str});
            com.tencent.mm.ui.base.h.a(this, str, "", new 2(this));
        } else if (kVar instanceof p) {
            com.tencent.mm.ui.base.h.a(this, str, "", new OnClickListener(this) {
                final /* synthetic */ RemittanceOSRedirect pPb;

                {
                    this.pPb = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.pPb.finish();
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.irz == 5) {
            jj(1574);
        } else if (this.irz == 6) {
            jj(1301);
        }
    }

    protected final int getLayoutId() {
        return -1;
    }
}
