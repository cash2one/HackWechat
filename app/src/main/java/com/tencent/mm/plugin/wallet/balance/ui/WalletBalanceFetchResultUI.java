package com.tencent.mm.plugin.wallet.balance.ui;

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
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wxpay.a$c;
import com.tencent.mm.plugin.wxpay.a$e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WalletBalanceFetchResultUI extends WalletBaseUI {
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
    private Orders pPl;

    static /* synthetic */ void a(WalletBalanceFetchResultUI walletBalanceFetchResultUI) {
        if (walletBalanceFetchResultUI.vf.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) walletBalanceFetchResultUI.vf.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceResultUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet");
                realnameGuideHelper.b(walletBalanceFetchResultUI, bundle, new 3(walletBalanceFetchResultUI));
                walletBalanceFetchResultUI.vf.remove("key_realname_guide_helper");
                return;
            }
            return;
        }
        walletBalanceFetchResultUI.cCc().a(walletBalanceFetchResultUI, 0, walletBalanceFetchResultUI.vf);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
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
        this.pPl = (Orders) this.vf.getParcelable("key_orders");
        initView();
        showHomeBtn(false);
        enableBackMenu(false);
        setMMTitle((String) cCd().um(0));
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
        this.pID.setText(i.uPi);
        this.pIE.setText(i.uPg);
        this.pIE.setTextColor(getResources().getColor(a$c.btv));
        this.pIF.setText(i.uPd);
        this.pIG = (TextView) findViewById(f.uge);
        this.pIH = (TextView) findViewById(f.ugf);
        this.pII = (TextView) findViewById(f.ugg);
        this.pIG.setVisibility(8);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        this.pIH.setText(getString(i.uOX, new Object[]{simpleDateFormat.format(new Date(this.pPl.sNQ))}));
        this.pIH.setVisibility(0);
        this.pII.setVisibility(8);
        this.pIL = (LinearLayout) findViewById(f.ufZ);
        this.pIL.setBackgroundResource(a$e.uct);
        View walletBalanceFetchResultItemView = new WalletBalanceFetchResultItemView(this, true);
        walletBalanceFetchResultItemView.c(i.uPu, e.d(this.pPl.pNX, this.pPl.paz));
        this.pIL.addView(walletBalanceFetchResultItemView);
        if (this.pPl.pKL > 0.0d) {
            walletBalanceFetchResultItemView = new WalletBalanceFetchResultItemView(this, true);
            walletBalanceFetchResultItemView.c(i.uPp, e.d(this.pPl.pKL, this.pPl.paz));
            this.pIL.addView(walletBalanceFetchResultItemView);
        }
        if (this.pPl.sNW != null && this.pPl.sNW.size() > 0) {
            CharSequence charSequence;
            Commodity commodity = (Commodity) this.pPl.sNW.get(0);
            String str = commodity.pax;
            if (bh.ov(commodity.sOm)) {
                Object obj = str;
            } else {
                charSequence = str + " " + getString(i.uUJ) + commodity.sOm;
            }
            View walletBalanceFetchResultItemView2 = new WalletBalanceFetchResultItemView(this);
            walletBalanceFetchResultItemView2.c(i.uOU, charSequence);
            this.pIL.addView(walletBalanceFetchResultItemView2);
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
