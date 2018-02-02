package com.tencent.mm.plugin.wallet_ecard.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class WalletECardElementInputUI extends WalletECardBaseUI {
    private Button sCT;
    private ElementQuery sJK;
    private WalletFormView sSa;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.uJb);
        initView();
        au();
    }

    protected final void initView() {
        this.sSa = (WalletFormView) findViewById(f.uyy);
        this.sSa.setOnClickListener(new 1(this));
        this.sCT = (Button) findViewById(f.cAg);
        this.sCT.setOnClickListener(new 2(this));
    }

    private void au() {
        if (this.sJK == null) {
            this.sJK = new ElementQuery();
        }
        if (bh.ov(this.sJK.nBM)) {
            this.sSa.setText("");
        } else if (!bh.ov(this.sJK.sMA)) {
            this.sSa.setText(this.sJK.nBM + " " + this.sJK.sMA);
        } else if (2 == this.sJK.sMz) {
            this.sSa.setText(this.sJK.nBM + " " + getString(i.uRc));
        } else {
            this.sSa.setText(this.sJK.nBM + " " + getString(i.uRr));
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.uBM;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.WalletECardElementInputUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    this.sJK = (ElementQuery) intent.getParcelableExtra("elemt_query");
                    au();
                    return;
                default:
                    super.onActivityResult(i, i2, intent);
                    return;
            }
        }
    }
}
