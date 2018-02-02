package com.tencent.mm.plugin.wallet.balance.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.su;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.balance.b;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

@a(19)
public class WalletBalanceResultUI extends WalletBaseUI {
    protected Button lRZ;
    protected TextView oid;
    public TextView pHJ;
    public Orders pPl;
    protected TextView rSD;
    public TextView sAd;
    protected TextView sAe;
    public CheckBox sAf;
    public Bankcard sAg;

    static /* synthetic */ void a(WalletBalanceResultUI walletBalanceResultUI) {
        if (walletBalanceResultUI.vf.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) walletBalanceResultUI.vf.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceResultUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet");
                realnameGuideHelper.b(walletBalanceResultUI, bundle, new 2(walletBalanceResultUI));
                walletBalanceResultUI.vf.remove("key_realname_guide_helper");
                return;
            }
            return;
        }
        walletBalanceResultUI.bJw();
    }

    protected final int getLayoutId() {
        return g.uEs;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pPl = (Orders) this.vf.getParcelable("key_orders");
        initView();
        au();
    }

    public void initView() {
        setMMTitle((String) cCd().um(0));
        this.rSD = (TextView) findViewById(f.uxz);
        this.rSD.setText(cCd().um(1));
        this.sAe = (TextView) findViewById(f.uxE);
        this.oid = (TextView) findViewById(f.uxD);
        CharSequence um = cCd().um(2);
        if (bh.M(um)) {
            this.sAe.setVisibility(8);
            this.oid.setVisibility(8);
        } else {
            this.sAe.setVisibility(0);
            this.oid.setVisibility(0);
            this.oid.setText(um);
        }
        ImageView imageView = (ImageView) findViewById(f.uxC);
        int i = this.vf.getInt("key_balance_result_logo", -1);
        if (i > 0) {
            imageView.setImageResource(i);
        } else {
            imageView.setImageResource(h.uGE);
        }
        this.pHJ = (TextView) findViewById(f.uxy);
        this.sAd = (TextView) findViewById(f.uxF);
        TextView textView = (TextView) findViewById(f.uxG);
        if (cCc() instanceof b) {
            textView.setText(getString(i.uPu));
        }
        this.sAf = (CheckBox) findViewById(f.ufH);
        this.sAg = (Bankcard) this.vf.getParcelable("key_bankcard");
        if (this.sAg != null) {
            this.sAf.setVisibility(8);
        } else {
            this.sAf.setVisibility(0);
        }
        this.lRZ = (Button) findViewById(f.cAg);
        this.lRZ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletBalanceResultUI sAh;

            {
                this.sAh = r1;
            }

            public final void onClick(View view) {
                WalletBalanceResultUI.a(this.sAh);
            }
        });
        showHomeBtn(false);
        enableBackMenu(false);
    }

    private void bJw() {
        if (this.sAf.getVisibility() == 0 && this.sAf.isChecked()) {
            PayInfo payInfo = (PayInfo) this.vf.getParcelable("key_pay_info");
            l(new com.tencent.mm.plugin.wallet.balance.a.a(this.vf.getInt("key_pay_flag", 0), this.vf.getString("key_pwd1"), this.vf.getString("key_verify_code"), payInfo.fuH, payInfo.fCV));
            return;
        }
        bJx();
    }

    public void au() {
        if (this.pPl != null) {
            this.sAd.setText(e.d(this.pPl.pNX, this.pPl.paz));
            if (this.pPl.sNW != null && this.pPl.sNW.size() > 0) {
                Commodity commodity = (Commodity) this.pPl.sNW.get(0);
                if (bh.ov(commodity.sOm)) {
                    this.pHJ.setText(commodity.pax);
                } else {
                    this.pHJ.setText(commodity.pax + " " + getString(i.uUJ) + commodity.sOm);
                }
            }
            if (!(cCc() instanceof b)) {
                return;
            }
            if (this.pPl.pKL > 0.0d) {
                findViewById(f.uxB).setVisibility(0);
                TextView textView = (TextView) findViewById(f.uxA);
                textView.setText(e.d(this.pPl.pKL, this.pPl.paz));
                textView.setVisibility(0);
                return;
            }
            x.i("MicroMsg.WalletBalanceResultUI", "fetch_fee is 0");
        }
    }

    public final void bJx() {
        if (!cCd().k(this.pPl)) {
            super.bJx();
        }
    }

    public void onBackPressed() {
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0 || !(kVar instanceof com.tencent.mm.plugin.wallet.balance.a.a)) {
            return false;
        }
        p.bJN();
        p.bJO().sQg = bh.Wo();
        com.tencent.mm.sdk.b.b suVar = new su();
        suVar.fKE.scene = 15;
        suVar.fqI = new Runnable(this) {
            final /* synthetic */ WalletBalanceResultUI sAh;

            {
                this.sAh = r1;
            }

            public final void run() {
                x.i("MicroMsg.WalletBalanceResultUI", "update user info succ, end process");
            }
        };
        com.tencent.mm.sdk.b.a.xef.m(suVar);
        bJx();
        return true;
    }
}
