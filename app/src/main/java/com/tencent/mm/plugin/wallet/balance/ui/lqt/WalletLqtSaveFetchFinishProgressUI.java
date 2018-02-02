package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultItemView;
import com.tencent.mm.plugin.wxpay.a$c;
import com.tencent.mm.plugin.wxpay.a$e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bbp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class WalletLqtSaveFetchFinishProgressUI extends WalletBaseUI {
    private ImageView pIA;
    private ImageView pIB;
    private ImageView pIC;
    private TextView pID;
    private TextView pIE;
    private TextView pIF;
    private TextView pIG;
    private TextView pIH;
    private TextView pII;
    private LinearLayout pIL;
    private bbp sAR;

    public void onCreate(Bundle bundle) {
        String format;
        super.onCreate(bundle);
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_redeem_res");
        this.sAR = new bbp();
        try {
            this.sAR.aF(byteArrayExtra);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletLqtSaveFetchFinishProgressUI", e, "parse redeemFundRes error!", new Object[0]);
            finish();
        }
        String str = "MicroMsg.WalletLqtSaveFetchFinishProgressUI";
        String str2 = "onCreate, redeemRes: %s";
        Object[] objArr = new Object[1];
        if (this.sAR != null) {
            format = String.format("status:%s, wording_for_status2:%s, pre_arrive_time_wording:%s, redeem_fee:%s, bank_name:%s, card_tail:%s, failure_wording:%s", new Object[]{Integer.valueOf(this.sAR.status), this.sAR.wHU, this.sAR.wHV, Integer.valueOf(this.sAR.wEO), this.sAR.nBM, this.sAR.pay, this.sAR.wHW});
        } else {
            format = "";
        }
        objArr[0] = format;
        x.i(str, str2, objArr);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a$c.white)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(f.divider);
            if (findViewById != null) {
                findViewById.setBackgroundColor(getResources().getColor(a$c.bsL));
            }
            customView = customView.findViewById(16908308);
            if (customView != null && (customView instanceof TextView)) {
                ((TextView) customView).setTextColor(getResources().getColor(a$c.black));
            }
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(a$c.white));
            if (VERSION.SDK_INT >= 23) {
                getWindow().getDecorView().setSystemUiVisibility(8192);
            }
        }
        this.mController.contentView.setFitsSystemWindows(true);
        initView();
        showHomeBtn(false);
        enableBackMenu(false);
        lV(false);
        setMMTitle(i.uSD);
        setBackBtn(new 1(this));
    }

    protected final void initView() {
        this.pIA = (ImageView) findViewById(f.ugh);
        this.pIB = (ImageView) findViewById(f.ugi);
        this.pIC = (ImageView) findViewById(f.ugj);
        this.pIA.setImageResource(a$e.ucu);
        this.pIB.setScaleType(ScaleType.CENTER_CROP);
        this.pIB.setImageResource(h.uGH);
        this.pIC.setImageResource(a$e.ucv);
        this.pID = (TextView) findViewById(f.ugm);
        this.pIE = (TextView) findViewById(f.ugn);
        this.pIF = (TextView) findViewById(f.ugo);
        this.pID.setText(i.uSM);
        this.pIE.setText(this.sAR.wHU);
        this.pIE.setTextColor(getResources().getColor(a$c.btv));
        this.pIF.setText(i.uPd);
        this.pIG = (TextView) findViewById(f.uge);
        this.pIH = (TextView) findViewById(f.ugf);
        this.pII = (TextView) findViewById(f.ugg);
        this.pIG.setVisibility(8);
        this.pIH.setText(this.sAR.wHV);
        this.pIH.setVisibility(0);
        this.pII.setVisibility(8);
        this.pIL = (LinearLayout) findViewById(f.ufZ);
        this.pIL.setBackgroundResource(a$e.uct);
        View walletBalanceFetchResultItemView = new WalletBalanceFetchResultItemView(this, true);
        walletBalanceFetchResultItemView.c(i.uSQ, e.u((double) (((float) this.sAR.wEO) / 100.0f)));
        this.pIL.addView(walletBalanceFetchResultItemView);
        if (!bh.ov(this.sAR.nBM)) {
            CharSequence charSequence = this.sAR.nBM;
            if (!bh.ov(this.sAR.pay)) {
                charSequence = charSequence + " " + getString(i.uUJ) + this.sAR.pay;
            }
            View walletBalanceFetchResultItemView2 = new WalletBalanceFetchResultItemView(this);
            walletBalanceFetchResultItemView2.c(i.uSC, charSequence);
            this.pIL.addView(walletBalanceFetchResultItemView2);
        }
        if (!bh.ov(this.sAR.wHW)) {
            walletBalanceFetchResultItemView = new WalletBalanceFetchResultItemView(this);
            walletBalanceFetchResultItemView.c(i.uSz, this.sAR.wHW);
            this.pIL.addView(walletBalanceFetchResultItemView);
        }
        ((Button) findViewById(f.ugb)).setOnClickListener(new 2(this));
        findViewById(f.ugp).setVisibility(8);
        findViewById(f.uga).setVisibility(8);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.uBa;
    }
}
