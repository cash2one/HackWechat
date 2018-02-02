package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.remittance.bankcard.a.l;
import com.tencent.mm.plugin.wxpay.a$c;
import com.tencent.mm.plugin.wxpay.a$e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.azt;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.u;

@a(19)
public class BankRemitDetailUI extends BankRemitBaseUI {
    private int jxi;
    private int mState;
    private ImageView pIA;
    private ImageView pIB;
    private ImageView pIC;
    private TextView pID;
    private TextView pIE;
    private TextView pIF;
    private TextView pIG;
    private TextView pIH;
    private TextView pII;
    private View pIJ;
    private View pIK;
    private LinearLayout pIL;
    private Button pIM;
    private ViewGroup pIN;
    private String pIO;

    static /* synthetic */ void a(BankRemitDetailUI bankRemitDetailUI, int i, String str) {
        int i2 = 1;
        switch (i) {
            case 1:
                bankRemitDetailUI.pIB.setScaleType(ScaleType.CENTER_CROP);
                bankRemitDetailUI.pIB.setImageResource(h.uGp);
                bankRemitDetailUI.pIH.setTextColor(bankRemitDetailUI.getResources().getColor(a$c.btv));
                bankRemitDetailUI.pIE.setText(i.uHB);
                if (!bh.ov(str)) {
                    bankRemitDetailUI.pIH.setText(str);
                    bankRemitDetailUI.pIH.setVisibility(0);
                    break;
                }
                break;
            case 2:
                bankRemitDetailUI.pIK.setBackground(bankRemitDetailUI.getResources().getDrawable(a$e.ucw));
                bankRemitDetailUI.pIC.setScaleType(ScaleType.CENTER_CROP);
                bankRemitDetailUI.pIC.setImageResource(h.uGo);
                bankRemitDetailUI.pIF.setTextColor(bankRemitDetailUI.getResources().getColor(a$c.btv));
                if (!bh.ov(str)) {
                    bankRemitDetailUI.pII.setText(str);
                    bankRemitDetailUI.pII.setVisibility(0);
                    break;
                }
                break;
            case 3:
                bankRemitDetailUI.pIB.setScaleType(ScaleType.CENTER_CROP);
                bankRemitDetailUI.pIB.setImageResource(h.uGm);
                bankRemitDetailUI.pIE.setTextColor(bankRemitDetailUI.getResources().getColor(a$c.btv));
                bankRemitDetailUI.pIE.setText(i.uHC);
                if (!bh.ov(str)) {
                    bankRemitDetailUI.pIH.setText(str);
                    bankRemitDetailUI.pIH.setVisibility(0);
                    break;
                }
                break;
            case 4:
                bankRemitDetailUI.pIB.setScaleType(ScaleType.CENTER_CROP);
                bankRemitDetailUI.pIB.setImageResource(h.uGn);
                bankRemitDetailUI.pIE.setTextColor(bankRemitDetailUI.getResources().getColor(a$c.btv));
                bankRemitDetailUI.pIE.setText(i.uHE);
                if (!bh.ov(str)) {
                    bankRemitDetailUI.pIH.setText(str);
                    bankRemitDetailUI.pIH.setVisibility(0);
                    break;
                }
                break;
            case 5:
                bankRemitDetailUI.pIC.setScaleType(ScaleType.CENTER_CROP);
                bankRemitDetailUI.pIC.setImageResource(h.uGn);
                bankRemitDetailUI.pIF.setTextColor(bankRemitDetailUI.getResources().getColor(a$c.btv));
                bankRemitDetailUI.pIF.setText(i.uHD);
                if (!bh.ov(str)) {
                    bankRemitDetailUI.pII.setText(str);
                    bankRemitDetailUI.pII.setVisibility(0);
                    break;
                }
                break;
            default:
                x.w("MicroMsg.BankRemitDetailUI", "unknown state: %s", new Object[]{Integer.valueOf(bankRemitDetailUI.mState)});
                i2 = 0;
                break;
        }
        if (i2 != 0) {
            bankRemitDetailUI.findViewById(f.ugp).setVisibility(8);
        }
    }

    static /* synthetic */ void a(BankRemitDetailUI bankRemitDetailUI, azt com_tencent_mm_protocal_c_azt) {
        View bankRemitDetailItemView = new BankRemitDetailItemView(bankRemitDetailUI, true);
        View bankRemitDetailItemView2 = new BankRemitDetailItemView(bankRemitDetailUI, true);
        bankRemitDetailItemView.c(i.uHx, u.cBD() + com.tencent.mm.plugin.remittance.bankcard.model.a.vu(com_tencent_mm_protocal_c_azt.nZd));
        bankRemitDetailItemView2.c(i.uHv, u.cBD() + com.tencent.mm.plugin.remittance.bankcard.model.a.vu(com_tencent_mm_protocal_c_azt.wGW));
        bankRemitDetailUI.pIL.addView(bankRemitDetailItemView);
        bankRemitDetailUI.pIL.addView(bankRemitDetailItemView2);
        if (bankRemitDetailUI.jxi == 1) {
            bankRemitDetailItemView = new BankRemitDetailItemView(bankRemitDetailUI);
            bankRemitDetailItemView2 = new BankRemitDetailItemView(bankRemitDetailUI);
            View bankRemitDetailItemView3 = new BankRemitDetailItemView(bankRemitDetailUI);
            View bankRemitDetailItemView4 = new BankRemitDetailItemView(bankRemitDetailUI);
            View bankRemitDetailItemView5 = new BankRemitDetailItemView(bankRemitDetailUI);
            bankRemitDetailItemView.c(i.uHz, com_tencent_mm_protocal_c_azt.pHM);
            bankRemitDetailItemView2.c(i.uHy, com_tencent_mm_protocal_c_azt.wGX);
            int i = i.uHt;
            bankRemitDetailItemView3.a(bankRemitDetailItemView3.getContext().getString(i), com_tencent_mm_protocal_c_azt.pHN, true);
            bankRemitDetailItemView4.c(i.uHF, com_tencent_mm_protocal_c_azt.wGY);
            if (com_tencent_mm_protocal_c_azt.state == 2) {
                bankRemitDetailItemView5.c(i.uHs, com_tencent_mm_protocal_c_azt.wHa);
            } else {
                bankRemitDetailItemView5.c(i.uHu, com_tencent_mm_protocal_c_azt.wGZ);
            }
            bankRemitDetailUI.pIL.addView(bankRemitDetailItemView);
            bankRemitDetailUI.pIL.addView(bankRemitDetailItemView2);
            bankRemitDetailUI.pIL.addView(bankRemitDetailItemView3);
            bankRemitDetailUI.pIL.addView(bankRemitDetailItemView4);
            bankRemitDetailUI.pIL.addView(bankRemitDetailItemView5);
        } else {
            bankRemitDetailUI.pIL.setBackgroundResource(a$e.uct);
        }
        if (!bh.ov(com_tencent_mm_protocal_c_azt.mPR)) {
            bankRemitDetailItemView = new BankRemitDetailItemView(bankRemitDetailUI);
            bankRemitDetailItemView.c(i.uHA, com_tencent_mm_protocal_c_azt.mPR);
            bankRemitDetailUI.pIL.addView(bankRemitDetailItemView);
        }
        bankRemitDetailUI.findViewById(f.uga).setVisibility(8);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ji(1579);
        this.pIO = getIntent().getStringExtra("key_transfer_bill_id");
        this.jxi = getIntent().getIntExtra("key_enter_scene", 0);
        x.i("MicroMsg.BankRemitDetailUI", "billId: %s, enterScene: %s", new Object[]{this.pIO, Integer.valueOf(this.jxi)});
        initView();
        x.i("MicroMsg.BankRemitDetailUI", "do query detail");
        l(new l(this.pIO));
        if (this.jxi == 0) {
            showHomeBtn(false);
            enableBackMenu(false);
            setMMTitle(i.uHH);
        } else {
            showHomeBtn(true);
            enableBackMenu(true);
            setMMTitle(i.uHG);
        }
        setBackBtn(new 1(this));
    }

    public final void initView() {
        this.pIA = (ImageView) findViewById(f.ugh);
        this.pIB = (ImageView) findViewById(f.ugi);
        this.pIC = (ImageView) findViewById(f.ugj);
        this.pID = (TextView) findViewById(f.ugm);
        this.pIE = (TextView) findViewById(f.ugn);
        this.pIF = (TextView) findViewById(f.ugo);
        this.pIG = (TextView) findViewById(f.uge);
        this.pIH = (TextView) findViewById(f.ugf);
        this.pII = (TextView) findViewById(f.ugg);
        this.pIJ = findViewById(f.ugk);
        this.pIK = findViewById(f.ugl);
        this.pIL = (LinearLayout) findViewById(f.ufZ);
        this.pIN = (ViewGroup) findViewById(f.ugd);
        if (this.jxi == 1) {
            findViewById(f.ugc).setVisibility(8);
            return;
        }
        this.pIM = (Button) findViewById(f.ugb);
        this.pIM.setOnClickListener(new 2(this));
    }

    protected final void ayW() {
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
        }
        BankRemitBaseUI.H(this);
        this.mController.contentView.setFitsSystemWindows(true);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof l) {
            l lVar = (l) kVar;
            lVar.a(new 5(this, lVar)).b(new 4(this, lVar)).c(new 3(this));
        }
        return true;
    }

    protected final int getLayoutId() {
        return g.uBa;
    }

    public void onDestroy() {
        super.onDestroy();
        jj(1579);
    }
}
