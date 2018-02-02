package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.os.Bundle;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_payu.a.c;
import com.tencent.mm.plugin.wallet_payu.create.a.d;
import com.tencent.mm.plugin.wxpay.a$e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.MMFormMobileInputView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;

@a(3)
public class WalletPayUStartOpenUI extends WalletBaseUI {
    private String phQ;
    private WalletPayUOpenIntroView tci;
    private MMFormMobileInputView tcj;
    private EditText tck;
    private EditText tcl;
    private Button tcm;
    private TextView tcn;
    private TextView tco;
    private String tcp;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.phQ = this.vf.getString("key_mobile");
        this.tcp = this.vf.getString("dial_code");
        if (bh.ov(this.tcp)) {
            this.tcp = "27";
        }
        this.tci = (WalletPayUOpenIntroView) findViewById(f.ulg);
        WalletPayUOpenIntroView walletPayUOpenIntroView = this.tci;
        walletPayUOpenIntroView.tcg = new d[]{new d(a$e.udw, i.uVl, i.uVg), new d(a$e.udx, i.uVm, i.uVh), new d(a$e.udy, i.uVn, i.uVi)};
        walletPayUOpenIntroView.Yo = new ArrayList();
        if (walletPayUOpenIntroView.tcg != null) {
            for (int i = 0; i < walletPayUOpenIntroView.tcg.length; i++) {
                walletPayUOpenIntroView.Yo.add(LayoutInflater.from(walletPayUOpenIntroView.mContext).inflate(g.uDt, null));
            }
        }
        walletPayUOpenIntroView.tcf = new WalletPayUOpenIntroView.a(walletPayUOpenIntroView, (byte) 0);
        walletPayUOpenIntroView.tcd.a(walletPayUOpenIntroView.tcf);
        walletPayUOpenIntroView.tce.eR(walletPayUOpenIntroView.tcg == null ? 0 : walletPayUOpenIntroView.tcg.length, 0);
        this.tcj = (MMFormMobileInputView) findViewById(f.uwA);
        this.tcm = (Button) findViewById(f.cPe);
        this.tck = this.tcj.yas;
        this.tcl = this.tcj.yat;
        if (!bh.ov(this.phQ)) {
            this.tcl.setText(this.phQ);
        }
        if (!bh.ov(this.tcp)) {
            this.tck.setText(this.tcp);
        }
        TextWatcher 1 = new 1(this);
        this.tcl.addTextChangedListener(1);
        this.tck.addTextChangedListener(1);
        this.tcm.setOnClickListener(new 2(this));
        this.tcn = (TextView) findViewById(f.uwz);
        c.a(this, this.tcn);
        this.tco = (TextView) findViewById(f.uwB);
        this.tco.setText(u.cBC());
    }

    public void onResume() {
        super.onResume();
        bNs();
    }

    private String bJP() {
        return this.tcj.getCountryCode().startsWith("+") ? this.tcj.getCountryCode().substring(1) : this.tcj.getCountryCode();
    }

    private void bNs() {
        if (this.tcj.getVisibility() == 0) {
            boolean z = (bh.ov(bJP()) || bh.ov(this.tcl.getText().toString())) ? false : true;
            if (z) {
                this.tcp = bJP();
                MMFormMobileInputView mMFormMobileInputView = this.tcj;
                this.phQ = mMFormMobileInputView.yat != null ? ao.Vk(mMFormMobileInputView.yat.getText().toString()) : "";
                this.tcm.setEnabled(true);
                return;
            }
            this.tcm.setEnabled(false);
        }
    }

    protected final boolean bKa() {
        return true;
    }

    protected final int getLayoutId() {
        return g.uDr;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }
}
