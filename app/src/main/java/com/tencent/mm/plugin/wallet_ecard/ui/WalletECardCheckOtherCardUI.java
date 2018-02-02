package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;

public class WalletECardCheckOtherCardUI extends WalletECardBaseUI implements a {
    private Button lRZ;
    private String lmC;
    private WalletFormView pHP;
    private WalletFormView sZO;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lmC = this.vf.getString(com.tencent.mm.plugin.wallet_ecard.a.a.sZo, "");
        setMMTitle(getString(i.uJa));
        this.zIY.ji(385);
        initView();
    }

    protected final void initView() {
        this.pHP = (WalletFormView) findViewById(f.uhF);
        this.sZO = (WalletFormView) findViewById(f.uhG);
        this.lRZ = (Button) findViewById(f.uhH);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.pHP);
        com.tencent.mm.wallet_core.ui.formview.a.c(this, this.sZO);
        if (bh.ov(this.lmC)) {
            this.pHP.setHint(getString(i.uIY));
        } else {
            this.pHP.setHint(getString(i.uIX, new Object[]{this.lmC}));
        }
        this.sZO.setHint(getString(i.uIZ));
        this.pHP.zJH = this;
        this.sZO.zJH = this;
        e(this.pHP, 0, false);
        e(this.sZO, 0, false);
        this.lRZ.setEnabled(false);
        this.lRZ.setClickable(false);
        this.lRZ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletECardCheckOtherCardUI sZP;

            {
                this.sZP = r1;
            }

            public final void onClick(View view) {
                x.i("MicroMsg.WalletECardCheckOtherCardUI", "do check card");
                if (this.sZP.pHP.XO() && this.sZP.sZO.XO()) {
                    String text = this.sZP.pHP.getText();
                    String text2 = this.sZP.sZO.getText();
                    this.sZP.cCd().k(new Object[]{text, text2});
                    return;
                }
                x.w("MicroMsg.WalletECardCheckOtherCardUI", "input invalid");
            }
        });
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.uBL;
    }

    public void onDestroy() {
        super.onDestroy();
        this.zIY.jj(385);
    }

    public final void hx(boolean z) {
        x.d("MicroMsg.WalletECardCheckOtherCardUI", "is valid: %s", new Object[]{Boolean.valueOf(z)});
        if (this.pHP.XO() && this.sZO.XO()) {
            this.lRZ.setEnabled(true);
            this.lRZ.setClickable(true);
            return;
        }
        this.lRZ.setEnabled(false);
        this.lRZ.setClickable(false);
    }
}
