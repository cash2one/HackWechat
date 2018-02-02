package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.wallet.balance.a.a.j;
import com.tencent.mm.plugin.wallet.balance.a.a.k;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.azo;
import com.tencent.mm.protocal.c.rf;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.Iterator;

public class WalletLqtDetailUI extends WalletLqtBasePresenterUI {
    private af handler = new af(Looper.getMainLooper());
    private Dialog iib;
    private Button sAA;
    private Button sAB;
    private LinearLayout sAC;
    private TextView sAD;
    private View sAE;
    private TextView sAF;
    private View sAG;
    private View sAH;
    private CdnImageView sAI;
    private TextView sAJ;
    private TextView sAK;
    private boolean sAL = true;
    private j sAq = ((j) t(j.class));
    private k sAr = ((k) q(k.class));
    private azo sAs;
    private ViewGroup sAt;
    private TextView sAu;
    private WalletTextView sAv;
    private TextView sAw;
    private TextView sAx;
    private TextView sAy;
    private WalletTextView sAz;

    static /* synthetic */ void b(WalletLqtDetailUI walletLqtDetailUI) {
        if (walletLqtDetailUI.sAs != null) {
            walletLqtDetailUI.sAv.setText(e.t(((double) walletLqtDetailUI.sAs.bME) / 100.0d));
            walletLqtDetailUI.sAw.setText(walletLqtDetailUI.sAs.wGB);
            walletLqtDetailUI.sAx.setText(walletLqtDetailUI.sAs.wGC);
            walletLqtDetailUI.sAy.setText(walletLqtDetailUI.sAs.wGD);
            walletLqtDetailUI.sAz.setText(e.t(((double) walletLqtDetailUI.sAs.wGE) / 100.0d));
            walletLqtDetailUI.sAC.removeAllViews();
            if (walletLqtDetailUI.sAs.wGF != null && walletLqtDetailUI.sAs.wGF.size() > 0) {
                Iterator it = walletLqtDetailUI.sAs.wGF.iterator();
                while (it.hasNext()) {
                    rf rfVar = (rf) it.next();
                    LinearLayout linearLayout = (LinearLayout) walletLqtDetailUI.getLayoutInflater().inflate(g.umd, walletLqtDetailUI.sAC, false);
                    TextView textView = (TextView) linearLayout.findViewById(f.umc);
                    ((TextView) linearLayout.findViewById(f.ume)).setText(rfVar.title);
                    textView.setText(rfVar.desc);
                    if (!bh.ov(rfVar.vZl)) {
                        linearLayout.setTag(rfVar.vZl);
                        linearLayout.setOnClickListener(new 6(walletLqtDetailUI, linearLayout));
                    }
                    walletLqtDetailUI.sAC.addView(linearLayout, new LayoutParams(-1, -2, -1.0f));
                }
            }
            walletLqtDetailUI.sAt.setVisibility(0);
            if (walletLqtDetailUI.sAs.bME <= 0) {
                walletLqtDetailUI.sAB.setEnabled(false);
            } else {
                walletLqtDetailUI.sAB.setEnabled(true);
            }
            if (b.ceK()) {
                walletLqtDetailUI.sAB.setEnabled(true);
            }
            if (walletLqtDetailUI.sAs.wGI != null) {
                walletLqtDetailUI.sAD.setText(walletLqtDetailUI.sAs.wGI.title);
                walletLqtDetailUI.sAD.setOnClickListener(new 7(walletLqtDetailUI));
            }
            walletLqtDetailUI.sAE.setVisibility(8);
            if (!(walletLqtDetailUI.sAs.wGK == null || bh.ov(walletLqtDetailUI.sAs.wGK.title))) {
                walletLqtDetailUI.sAE.setVisibility(0);
                walletLqtDetailUI.sAF.setText(walletLqtDetailUI.sAs.wGK.title);
                if (!bh.ov(walletLqtDetailUI.sAs.wGK.vZl)) {
                    walletLqtDetailUI.sAE.setOnClickListener(new 8(walletLqtDetailUI));
                }
            }
            walletLqtDetailUI.sAH.setVisibility(8);
            walletLqtDetailUI.sAG.setVisibility(8);
            if (!(walletLqtDetailUI.sAs.wGL == null || bh.ov(walletLqtDetailUI.sAs.wGL.username))) {
                walletLqtDetailUI.sAI.setUrl(walletLqtDetailUI.sAs.wGL.kJP);
                walletLqtDetailUI.sAJ.setText(walletLqtDetailUI.sAs.wGL.title);
                walletLqtDetailUI.sAK.setText(walletLqtDetailUI.sAs.wGL.desc);
                walletLqtDetailUI.sAH.setOnClickListener(new 9(walletLqtDetailUI));
                walletLqtDetailUI.sAG.setVisibility(0);
                walletLqtDetailUI.sAH.setVisibility(0);
            }
            walletLqtDetailUI.sAD.setVisibility(4);
            walletLqtDetailUI.sAD.post(new 10(walletLqtDetailUI));
            walletLqtDetailUI.sAA.setOnClickListener(new 11(walletLqtDetailUI));
            walletLqtDetailUI.sAB.setOnClickListener(new 12(walletLqtDetailUI));
        }
        walletLqtDetailUI.mController.removeAllOptionMenu();
        if (walletLqtDetailUI.sAs != null) {
            walletLqtDetailUI.addIconOptionMenu(0, a.e.bDI, new 2(walletLqtDetailUI));
        }
    }

    static /* synthetic */ ArrayList e(WalletLqtDetailUI walletLqtDetailUI) {
        ArrayList arrayList = new ArrayList();
        if (walletLqtDetailUI.sAs.wGH != null && walletLqtDetailUI.sAs.wGH.size() > 0) {
            Iterator it = walletLqtDetailUI.sAs.wGH.iterator();
            while (it.hasNext()) {
                rf rfVar = (rf) it.next();
                if (!(bh.ov(rfVar.title) || bh.ov(rfVar.vZl))) {
                    arrayList.add(String.format("%s||%s", new Object[]{rfVar.title, rfVar.vZl}));
                }
            }
        }
        return arrayList;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(c.ubB));
        }
        if (d.fM(21)) {
            getWindow().setStatusBarColor(getResources().getColor(c.ubB));
        }
        setMMTitle(getString(i.uTa));
        int intExtra = getIntent().getIntExtra("key_account_type", 1);
        x.i("MicroMsg.WalletLqtDetailUI", "inputAccountType: %s", new Object[]{Integer.valueOf(intExtra)});
        this.sAt = (ViewGroup) findViewById(f.ujl);
        this.sAu = (TextView) findViewById(f.umo);
        this.sAv = (WalletTextView) findViewById(f.ulX);
        this.sAw = (TextView) findViewById(f.ulY);
        this.sAx = (TextView) findViewById(f.ulZ);
        this.sAy = (TextView) findViewById(f.umh);
        this.sAz = (WalletTextView) findViewById(f.umi);
        this.sAA = (Button) findViewById(f.uml);
        this.sAB = (Button) findViewById(f.umg);
        this.sAC = (LinearLayout) findViewById(f.umd);
        this.sAD = (TextView) findViewById(f.umf);
        this.sAE = findViewById(f.uma);
        this.sAF = (TextView) findViewById(f.umb);
        this.sAH = findViewById(f.umn);
        this.sAI = (CdnImageView) findViewById(f.uwS);
        this.sAJ = (TextView) findViewById(f.uwT);
        this.sAK = (TextView) findViewById(f.uwR);
        this.sAG = findViewById(f.umm);
        this.sAD.setVisibility(4);
    }

    public void onResume() {
        super.onResume();
        if (this.sAL) {
            this.sAt.setVisibility(8);
            this.iib = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
            com.tencent.mm.vending.g.g.czW().b(this.sAr.syy).e(new 5(this)).a(new 1(this));
        }
        this.sAL = true;
    }

    protected final int getLayoutId() {
        return g.uFf;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 123 && i2 == -1) {
            this.sAL = false;
            String stringExtra = intent.getStringExtra("lqt_enc_pwd");
            if (this.iib == null) {
                this.iib = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
            } else {
                this.iib.show();
            }
            com.tencent.mm.vending.g.g.t(stringExtra, Integer.valueOf(this.sAs.vXn)).b(this.sAr.syz).e(new 4(this)).a(new 3(this));
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.sAq = null;
        this.sAr = null;
    }
}
