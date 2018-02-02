package com.tencent.mm.plugin.wallet.bind.ui;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.appbrand.jsapi.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.plugin.wallet.pay.a.a.b;
import com.tencent.mm.plugin.wallet.pay.a.a.c;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

@a(19)
public class WalletResetInfoUI extends WalletBaseUI implements WalletFormView.a {
    private TextView jCQ;
    private Orders pPl;
    private Bankcard sAg;
    private Button sCT;
    private WalletFormView sCU;
    private WalletFormView sCV;
    private WalletFormView sCW;
    private WalletFormView sCX;
    private Authen sCY;
    private ElementQuery sCZ;

    protected final int getLayoutId() {
        return g.uFK;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
        this.jCQ = (TextView) findViewById(f.uAd);
        Bankcard bankcard = (Bankcard) this.vf.getParcelable("key_switch_phone_reset_bank_card");
        if (bankcard == null) {
            bankcard = (Bankcard) this.vf.getParcelable("key_bankcard");
        }
        this.sAg = bankcard;
        this.pPl = (Orders) this.vf.getParcelable("key_orders");
        this.sCY = (Authen) this.vf.getParcelable("key_authen");
        if (TextUtils.isEmpty(this.vf.getString("key_pwd1", ""))) {
            this.vf.putString("key_pwd1", this.sCY.sKs);
            x.e("Micromsg.WalletResetInfoUI", "pwd is empty, reset it to input");
        }
        this.sCZ = (ElementQuery) this.vf.getParcelable("elemt_query");
        this.sCU = (WalletFormView) findViewById(f.ufh);
        this.sCV = (WalletFormView) findViewById(f.ujb);
        com.tencent.mm.wallet_core.ui.formview.a.a(this, this.sCV);
        this.sCW = (WalletFormView) findViewById(f.uja);
        com.tencent.mm.wallet_core.ui.formview.a.b(this, this.sCW);
        this.sCX = (WalletFormView) findViewById(f.urD);
        com.tencent.mm.wallet_core.ui.formview.a.c(this, this.sCX);
        this.sCV.zJH = this;
        this.sCW.zJH = this;
        this.sCX.zJH = this;
        MMScrollView mMScrollView = (MMScrollView) findViewById(f.cYz);
        mMScrollView.a(mMScrollView, mMScrollView);
        if (this.sAg != null) {
            this.sCU.setText(this.sAg.field_desc);
        } else {
            this.sCU.setVisibility(8);
        }
        bJM();
        if (bJL()) {
            b(new t("", "", null), true);
        }
    }

    private boolean bJL() {
        return this.vf.getInt("key_err_code", av.CTRL_INDEX) == av.CTRL_INDEX && this.sCZ == null;
    }

    private void bJM() {
        switch (this.vf.getInt("key_err_code", av.CTRL_INDEX)) {
            case e.CTRL_INDEX /*402*/:
                setMMTitle(i.uWe);
                this.sCW.setVisibility(0);
                this.jCQ.setText(i.uWd);
                break;
            case ap.CTRL_INDEX /*403*/:
                setMMTitle(i.uWj);
                this.sCV.setVisibility(0);
                this.jCQ.setText(i.uWi);
                break;
            default:
                if (this.vf.getBoolean("key_balance_change_phone_need_confirm_phone", true)) {
                    setMMTitle(i.uWh);
                    this.sCX.setVisibility(0);
                } else {
                    setMMTitle(i.uWf);
                }
                if (this.sAg != null) {
                    x.d("Micromsg.WalletResetInfoUI", "bankPhone: %s", new Object[]{this.sAg.field_bankPhone});
                    this.jCQ.setText(String.format(getString(i.uWg), new Object[]{this.sAg.field_bankPhone}));
                }
                if (this.sCZ == null && this.sAg != null) {
                    this.sCZ = o.bLy().MT(this.sAg.field_bankcardType);
                }
                if (this.sCZ != null && this.sCZ.sMu) {
                    this.sCW.setVisibility(0);
                }
                if (this.sCZ != null && this.sCZ.sMv) {
                    this.sCV.setVisibility(0);
                    break;
                }
        }
        this.sCT = (Button) findViewById(f.cAg);
        this.sCT.setOnClickListener(new 1(this));
        XK();
        if (bJL()) {
            uD(4);
        } else {
            uD(0);
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        x.d("Micromsg.WalletResetInfoUI", " errCode: " + i2 + " errMsg :" + str);
        if (i == 0 && i2 == 0) {
            Bundle bundle = this.vf;
            if ((kVar instanceof b) || (kVar instanceof c)) {
                b bVar = (b) kVar;
                bundle.putBoolean("key_need_verify_sms", !bVar.sEr);
                bundle.putString("kreq_token", bVar.token);
                if (bVar.sFA) {
                    bundle.putParcelable("key_orders", bVar.sEs);
                }
                Parcelable parcelable = bVar.oWt;
                if (parcelable != null) {
                    bundle.putParcelable("key_realname_guide_helper", parcelable);
                }
                bundle.putInt("key_err_code", 0);
                com.tencent.mm.wallet_core.a.j(this, bundle);
                return true;
            } else if ((kVar instanceof t) && this.sAg != null) {
                this.sCZ = o.bLy().MU(this.sAg.field_bindSerial);
                bJM();
            }
        }
        return false;
    }

    private boolean XK() {
        boolean z;
        if (this.sCV.dQ(null)) {
            z = true;
        } else {
            z = false;
        }
        if (!this.sCX.dQ(null)) {
            z = false;
        }
        if (!this.sCW.dQ(null)) {
            z = false;
        }
        if (this.pPl == null || this.sCY == null) {
            z = false;
        }
        if (z) {
            this.sCT.setEnabled(true);
            this.sCT.setClickable(true);
        } else {
            this.sCT.setEnabled(false);
            this.sCT.setClickable(false);
        }
        return z;
    }

    public final void hx(boolean z) {
        XK();
    }
}
