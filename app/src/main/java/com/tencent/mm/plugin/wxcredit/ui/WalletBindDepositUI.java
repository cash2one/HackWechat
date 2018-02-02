package com.tencent.mm.plugin.wxcredit.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;

public class WalletBindDepositUI extends WalletBaseUI {
    private boolean nmA = true;
    private Button sCT;
    private ElementQuery sJK = new ElementQuery();
    private WalletFormView sRi;
    private WalletFormView sSa;
    private WalletFormView tZy;

    static /* synthetic */ boolean e(WalletBindDepositUI walletBindDepositUI) {
        if (!walletBindDepositUI.sRi.XO()) {
            u.makeText(walletBindDepositUI, i.uQj, 0).show();
            return false;
        } else if (!walletBindDepositUI.sSa.XO()) {
            u.makeText(walletBindDepositUI, i.uQc, 0).show();
            return false;
        } else if (walletBindDepositUI.tZy.XO()) {
            return true;
        } else {
            u.makeText(walletBindDepositUI, i.uQu, 0).show();
            return false;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final int getLayoutId() {
        return g.uEn;
    }

    public final void initView() {
        setMMTitle(i.uPQ);
        this.sRi = (WalletFormView) findViewById(f.uyj);
        a.a(this.sRi);
        this.sSa = (WalletFormView) findViewById(f.uyy);
        this.tZy = (WalletFormView) findViewById(f.urD);
        a.c(this, this.tZy);
        this.sCT = (Button) findViewById(f.cAg);
        e(this.sRi, 0, false);
        e(this.tZy, 0, false);
        this.sSa.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletBindDepositUI tZz;

            {
                this.tZz = r1;
            }

            public final void onClick(View view) {
                if (!bh.ov(this.tZz.sRi.getText())) {
                    if (this.tZz.nmA) {
                        this.tZz.cCd().q(r0);
                        this.tZz.nmA = false;
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("key_support_bankcard", 1);
                    bundle.putString("key_bank_type", this.tZz.sJK.oZz);
                    bundle.putInt("key_bankcard_type", 1);
                    com.tencent.mm.wallet_core.a.ag(this.tZz).a(this.tZz, WalletCardSelectUI.class, bundle, 1);
                }
            }
        });
        this.sCT.setOnClickListener(new 2(this));
    }

    private void au() {
        if (bh.ov(this.sJK.nBM)) {
            this.sSa.setText("");
        } else if (2 == this.sJK.sMz) {
            this.sSa.setText(this.sJK.nBM + " " + getString(i.uRc));
        } else {
            this.sSa.setText(this.sJK.nBM + " " + getString(i.uRr));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.WalletBindDepositUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    ElementQuery elementQuery = (ElementQuery) intent.getParcelableExtra("elemt_query");
                    if (elementQuery.bLb()) {
                        this.sJK = elementQuery;
                        au();
                        return;
                    }
                    h.h(this, i.uPP, i.dGO);
                    return;
                default:
                    return;
            }
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        boolean z = false;
        if (i == 0 && i2 == 0 && (kVar instanceof t)) {
            t tVar = (t) kVar;
            if (tVar.sII != null) {
                if (tVar.sII.bLb()) {
                    this.sJK = tVar.sII;
                    au();
                    if (this.sJK.sMx && this.sJK.isError()) {
                        h.h(this, i.uPD, i.dGO);
                        return true;
                    }
                    c ag = com.tencent.mm.wallet_core.a.ag(this);
                    if (ag != null) {
                        int i3 = this.sJK.sIJ;
                        if (ag != null) {
                            if (ag.msB.containsKey("key_support_bankcard")) {
                                int cBi = ag.cBi();
                                z = cBi == 0 ? true : Bankcard.dY(cBi, i3);
                            } else {
                                z = true;
                            }
                        }
                        if (!z) {
                            if (ag.bMX()) {
                                x.w("MicroMsg.WalletBindDepositUI", "Overseas user try to bind domestic card!");
                                h.h(this, i.uOM, i.dGO);
                            } else {
                                x.w("MicroMsg.WalletBindDepositUI", "Domestic user try to bind international card!");
                                h.h(this, i.uOL, i.dGO);
                            }
                            this.sRi.bmK();
                            return true;
                        }
                    }
                    au();
                    return true;
                }
                h.h(this, i.uPP, i.dGO);
                return true;
            }
        }
        return false;
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
