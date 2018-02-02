package com.tencent.mm.plugin.collect.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.collect.b.m;
import com.tencent.mm.plugin.collect.b.s;
import com.tencent.mm.plugin.wallet_core.ui.g;
import com.tencent.mm.plugin.wxpay.a$c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;

public class CollectCreateQRCodeUI extends WalletBaseUI {
    private String gAT = "";
    private WalletFormView llY;
    private TextView llZ;

    static /* synthetic */ void d(CollectCreateQRCodeUI collectCreateQRCodeUI) {
        if (bh.ov(collectCreateQRCodeUI.gAT)) {
            collectCreateQRCodeUI.llZ.setTextColor(collectCreateQRCodeUI.getResources().getColor(a$c.btd));
            collectCreateQRCodeUI.llZ.setText(i.uIx);
            return;
        }
        g gVar = new g(collectCreateQRCodeUI.mController.xIM);
        String string = collectCreateQRCodeUI.getString(i.uIz);
        CharSequence a = com.tencent.mm.pluginsdk.ui.d.i.a(collectCreateQRCodeUI, collectCreateQRCodeUI.getString(i.uIy, new Object[]{collectCreateQRCodeUI.gAT, string}));
        CharSequence spannableString = new SpannableString(a);
        spannableString.setSpan(gVar, a.length() - string.length(), a.length(), 33);
        collectCreateQRCodeUI.llZ.setTextColor(collectCreateQRCodeUI.getResources().getColor(a$c.bsO));
        collectCreateQRCodeUI.llZ.setText(spannableString);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ji(1335);
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
        jj(1335);
    }

    protected final void initView() {
        setMMTitle(i.uIw);
        setBackBtn(new 1(this));
        this.llY = (WalletFormView) findViewById(f.urG);
        a.e(this.llY);
        CharSequence stringExtra = getIntent().getStringExtra("key_currency_unit");
        if (bh.ov(stringExtra)) {
            this.llY.jJn.setText(u.cBD());
        } else {
            this.llY.jJn.setText(stringExtra);
        }
        this.llY.a(new 2(this));
        e(this.llY, 2, false);
        ((Button) findViewById(f.cAg)).setOnClickListener(new 3(this));
        this.llZ = (TextView) findViewById(f.uio);
        this.llZ.setOnClickListener(new 4(this));
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uBy;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        Intent intent;
        if (kVar instanceof s) {
            if (i != 0 || i2 != 0) {
                return false;
            }
            s sVar = (s) kVar;
            intent = new Intent();
            intent.putExtra("ftf_pay_url", sVar.ljf);
            intent.putExtra("ftf_fixed_fee", sVar.ljg);
            intent.putExtra("ftf_fixed_fee_type", sVar.fpP);
            intent.putExtra("ftf_fixed_desc", sVar.desc);
            setResult(-1, intent);
            finish();
            return true;
        } else if (!(kVar instanceof m)) {
            return false;
        } else {
            m mVar = (m) kVar;
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.CollectCreateQRCodeUI", "net error: %s", new Object[]{mVar});
                return false;
            } else if (mVar.liH == 0) {
                intent = new Intent();
                intent.putExtra("ftf_pay_url", mVar.liJ);
                intent.putExtra("ftf_fixed_fee", ((double) mVar.fLR) / 100.0d);
                intent.putExtra("ftf_fixed_desc", mVar.desc);
                intent.putExtra("key_currency_unit", mVar.liS);
                setResult(-1, intent);
                finish();
                return true;
            } else if (mVar.liK == 0) {
                h.b(this.mController.xIM, mVar.liI, mVar.liL, false);
                return true;
            } else if (mVar.liK != 1) {
                return false;
            } else {
                if (!(bh.ov(mVar.liM) || bh.ov(mVar.liN))) {
                    h.a(this.mController.xIM, mVar.liI, mVar.liL, mVar.liN, mVar.liM, new 5(this, mVar), new OnClickListener(this) {
                        final /* synthetic */ CollectCreateQRCodeUI lma;

                        {
                            this.lma = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
                return true;
            }
        }
    }
}
