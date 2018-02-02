package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.ad.d;
import com.tencent.mm.ad.n;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.remittance.model.y;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.z.q;

@a(19)
public class RemittanceOSUI extends RemittanceBaseUI implements d.a {
    private int pPc;
    private String pPd;
    private String pPe;
    private String pPf;
    private String pPg;
    private boolean pPh = false;
    private c pPi = new 1(this);

    public final void bnH() {
    }

    public final void bnJ() {
        g.pQN.h(13337, Integer.valueOf(2));
    }

    public final void bnK() {
        u.makeText(this.mController.xIM, getString(i.uNX, new Object[]{this.pPd}), 0).show();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.sdk.b.a.xef.a(this.pPi);
        this.zIY.ji(1622);
        this.zIY.ji(1574);
        initView();
        this.llY.xv("");
        n.Jz().a((d.a) this);
        this.pPc = getIntent().getIntExtra("os_currency", 0);
        this.pPd = getIntent().getStringExtra("os_currencyuint");
        this.pPe = getIntent().getStringExtra("os_currencywording");
        this.pPf = getIntent().getStringExtra("os_notice");
        this.pPg = getIntent().getStringExtra("os_notice_url");
        this.llY.xv(this.pPd);
        bnN();
    }

    public final void dQ(String str, String str2) {
        String FU = q.FU();
        if (bh.ov(FU)) {
            FU = q.FS();
        }
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.l.a WO = ((h) com.tencent.mm.kernel.g.h(h.class)).EY().WO(this.gAb);
        String str3 = this.gAb;
        if (((int) WO.gJd) != 0) {
            str3 = WO.AQ();
        }
        k yVar = new y(this.pLR, FU, this.gAb, str3, str, this.pPc);
        yVar.gOs = "RemittanceProcess";
        l(yVar);
        g.pQN.h(13337, Integer.valueOf(1), Double.valueOf(this.pLR));
    }

    protected final void Iu(String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        com.tencent.mm.bm.d.b(this, "webview", ".ui.tools.WebViewUI", intent, 3);
        this.pPh = true;
    }

    protected final void Iv(String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        com.tencent.mm.bm.d.b(this, "webview", ".ui.tools.WebViewUI", intent, 3);
        this.pPh = true;
    }

    public final void bnN() {
        if (bh.ov(this.pPf)) {
            x.i("MicroMsg.RemittanceOSUI", "no bulletin data");
        } else {
            e.a((TextView) findViewById(a$f.ufy), "", this.pPf, this.pPg);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xef.c(this.pPi);
        n.Jz().b(this);
        this.zIY.jj(1622);
        this.zIY.jj(1574);
    }

    public final void jh(String str) {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.RemittanceOSUI", "reqcode=" + i + ", resultCode=" + i2 + ", username=" + this.gAb);
        this.pPh = false;
        if (i == 3 && i2 == -1) {
            finish();
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uEc;
    }

    public final void b(int i, int i2, String str, k kVar, boolean z) {
        super.b(i, i2, str, kVar, z);
        if (i == 0 && i2 == 0 && (kVar instanceof y)) {
            int i3;
            final y yVar = (y) kVar;
            boolean z2;
            if (yVar.pKI <= 0) {
                z2 = false;
            } else if (yVar.pLF == 0) {
                com.tencent.mm.ui.base.h.a(this, getString(i.uOa, new Object[]{Integer.valueOf(yVar.pKI)}), getString(i.dGt), getString(i.uNf), getString(i.uNW), new 2(this, yVar), new OnClickListener(this) {
                    final /* synthetic */ RemittanceOSUI pPj;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.pPj.Iv(yVar.pLE);
                    }
                });
                i3 = 1;
            } else if (yVar.pLF == 1) {
                com.tencent.mm.ui.base.h.a(this, getString(i.uOa, new Object[]{Integer.valueOf(yVar.pKI)}), getString(i.dGt), getString(i.uNf), getString(i.uNW), new OnClickListener(this) {
                    final /* synthetic */ RemittanceOSUI pPj;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.pPj.Iu(yVar.pKC);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ RemittanceOSUI pPj;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.pPj.Iv(yVar.pLE);
                    }
                });
                i3 = 1;
            } else {
                z2 = false;
            }
            if (i3 == 0) {
                String str2 = ((y) kVar).pKC;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                intent.putExtra("showShare", false);
                com.tencent.mm.bm.d.b(this, "webview", ".ui.tools.WebViewUI", intent, 3);
            }
        }
    }
}
