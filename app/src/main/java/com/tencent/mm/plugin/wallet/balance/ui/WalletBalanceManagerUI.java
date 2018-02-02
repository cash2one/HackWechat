package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.st;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.wallet.balance.a;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ECardInfo;
import com.tencent.mm.plugin.wallet_core.model.aa;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.j;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.j.6;
import com.tencent.mm.plugin.wallet_core.ui.j.7;
import com.tencent.mm.plugin.wallet_core.ui.j.8;
import com.tencent.mm.plugin.wallet_core.ui.j.9;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class WalletBalanceManagerUI extends WalletBaseUI implements j {
    protected int irz;
    protected TextView szP;
    protected Button szQ;
    protected View szR;
    protected View szS;
    protected TextView szT;
    protected Bankcard szU;
    protected TextView szq;

    static /* synthetic */ void c(WalletBalanceManagerUI walletBalanceManagerUI) {
        Bundle bundle = new Bundle();
        walletBalanceManagerUI.vf.get("key_pay_info");
        Parcelable payInfo = new PayInfo();
        payInfo.fCV = 21;
        bundle.putParcelable("key_pay_info", payInfo);
        bundle.putInt("key_scene", 21);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_is_bind_bankcard", true);
        bundle.putInt("from_bind_ui", a.sxZ);
        com.tencent.mm.wallet_core.a.a((Activity) walletBalanceManagerUI, a.class, bundle, null);
    }

    protected final int getLayoutId() {
        return g.uEr;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((b) com.tencent.mm.kernel.g.h(b.class)).a(this, null);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(c.ubt));
        }
        if (d.fM(21)) {
            getWindow().setStatusBarColor(getResources().getColor(c.ubv));
        }
        cmS();
        nR(WebView.NIGHT_MODE_COLOR);
        setBackBtn(new 1(this), h.uGl);
        this.irz = getIntent().getIntExtra("key_scene_balance_manager", 0);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("key_inc_bal_amt_flag");
        ECardInfo eCardInfo = (ECardInfo) intent.getParcelableExtra("key_ecard_info");
        if (TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(stringExtra)) {
            if (eCardInfo != null) {
                View inflate = LayoutInflater.from(this).inflate(g.uFb, null);
                ImageView imageView = (ImageView) inflate.findViewById(f.bWl);
                int b = BackwardSupportUtil.b.b(this, 15.0f);
                bh.j(imageView, b, b, b, b);
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(f.upO);
                Button button = (Button) inflate.findViewById(f.uxp);
                TextView textView = (TextView) inflate.findViewById(f.upM);
                CheckBox checkBox = (CheckBox) inflate.findViewById(f.checkbox);
                TextView textView2 = (TextView) inflate.findViewById(f.uhL);
                ((TextView) inflate.findViewById(f.euB)).setText(eCardInfo.title);
                linearLayout.removeAllViews();
                Iterator it = eCardInfo.sMl.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    View inflate2 = LayoutInflater.from(this).inflate(g.uFa, null);
                    ((TextView) inflate2.findViewById(f.uAI)).setText(str);
                    linearLayout.addView(inflate2);
                }
                b = eCardInfo.sMo.length();
                int length = (eCardInfo.sMo + eCardInfo.sMp).length();
                CharSequence spannableString = new SpannableString(eCardInfo.sMo + eCardInfo.sMp);
                spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(c.ubF)), b, length, 33);
                textView.setText(spannableString);
                textView.setOnClickListener(new 6(eCardInfo, this));
                Dialog dialog = new Dialog(this, com.tencent.mm.plugin.wxpay.a.j.eYV);
                dialog.setContentView(inflate);
                dialog.setTitle(null);
                dialog.setOnCancelListener(new 7(dialog));
                imageView.setOnClickListener(new 8(dialog));
                button.setOnClickListener(new 9(eCardInfo, this, dialog));
                if (eCardInfo.sMf == 1) {
                    checkBox.setOnCheckedChangeListener(new j$10(button));
                    if (eCardInfo.sMg == 1) {
                        checkBox.setChecked(true);
                    } else {
                        checkBox.setChecked(false);
                        button.setEnabled(false);
                        button.setClickable(false);
                    }
                } else {
                    checkBox.setVisibility(8);
                }
                int length2 = eCardInfo.sMh.length();
                length = (eCardInfo.sMh + eCardInfo.sMi).length();
                CharSequence spannableString2 = new SpannableString(eCardInfo.sMh + eCardInfo.sMi);
                spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(c.ubF)), length2, length, 33);
                textView2.setText(spannableString2);
                textView2.setOnClickListener(new j$2(eCardInfo, this));
                dialog.show();
            } else {
                x.w("MicroMsg.WalletBalanceManagerUI", "ecard info is null");
            }
        }
        ji(621);
        o.bLx();
        aa.a(this);
        initView();
        p.ft(2, 0);
        com.tencent.mm.plugin.report.service.g.pQN.h(11850, new Object[]{Integer.valueOf(6), Integer.valueOf(0)});
        e.HF(10);
    }

    public void bJt() {
        com.tencent.mm.plugin.wallet.a.p.bJN();
        b(new com.tencent.mm.plugin.wallet_core.c.x(null, 10), com.tencent.mm.plugin.wallet.a.p.bJO().szU == null);
    }

    public void onDestroy() {
        jj(621);
        o.bLx();
        aa.b(this);
        super.onDestroy();
    }

    public void bJu() {
        G(WalletBalanceSaveUI.class);
    }

    protected final void initView() {
        setMMTitle(i.uPo);
        this.szP = (TextView) findViewById(f.uxH);
        this.szq = (TextView) findViewById(f.uxv);
        ((Button) findViewById(f.cAg)).setOnClickListener(new 5(this));
        this.szQ = (Button) findViewById(f.uxw);
        this.szQ.setOnClickListener(new 6(this));
        TextView textView = (TextView) findViewById(f.uxx);
        if (!w.cfi().equals("zh_CN") ? true : bh.PT()) {
            textView.setVisibility(8);
        } else {
            textView.setOnClickListener(new 7(this));
            textView.setVisibility(0);
        }
        ((TextView) findViewById(f.uAh)).setText(u.cBC());
        this.szR = findViewById(f.ulP);
        this.szT = (TextView) findViewById(f.ulQ);
        this.szS = findViewById(f.ulO);
        com.tencent.mm.sdk.b.b stVar = new st();
        stVar.fKA.fKC = "2";
        stVar.fqI = new 8(this, stVar);
        com.tencent.mm.sdk.b.a.xef.m(stVar);
    }

    public void onResume() {
        au();
        bJt();
        super.onResume();
        b bVar = (b) com.tencent.mm.kernel.g.h(b.class);
        bVar.a(this, bVar.bNx(), null);
    }

    public final void au() {
        boolean z;
        com.tencent.mm.plugin.wallet.a.p.bJN();
        this.szU = com.tencent.mm.plugin.wallet.a.p.bJO().szU;
        if (this.szU != null) {
            if (this.szU.sLf >= 0.0d) {
                this.szP.setText(e.u(this.szU.sLf));
            } else {
                this.szP.setText(getString(i.uRT));
            }
            com.tencent.mm.plugin.wallet.a.p.bJN();
            if ((com.tencent.mm.plugin.wallet.a.p.bJO().bLQ().sPW & 4) > 0) {
                z = true;
            } else {
                z = false;
            }
            x.i("MicroMsg.WalletSwitchConfig", "isBalanceFetchOn, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(com.tencent.mm.plugin.wallet.a.p.bJO().bLQ().sPW)});
            int i = (!z || this.szU.sLf <= 0.0d) ? 0 : 1;
            if (i != 0) {
                this.szQ.setVisibility(0);
            } else {
                this.szQ.setVisibility(8);
            }
            bJv();
        }
        View findViewById = findViewById(f.umr);
        com.tencent.mm.kernel.g.Dk();
        if (((Integer) com.tencent.mm.kernel.g.Dj().CU().get(com.tencent.mm.storage.w.a.xvT, Integer.valueOf(-1))).intValue() == 1) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        if ((new ae().sPW & WXMediaMessage.THUMB_LENGTH_LIMIT) > 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.WalletSwitchConfig", "isShowRealnameGuide, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(new ae().sPW)});
        if (z) {
            com.tencent.mm.kernel.g.Dk();
            String str = (String) com.tencent.mm.kernel.g.Dj().CU().get(com.tencent.mm.storage.w.a.xrw, getString(i.uMO));
            this.szR.setVisibility(0);
            this.szT.setTextColor(getResources().getColor(c.ubu));
            this.szT.setText(str);
            this.szS.setVisibility(8);
            this.szR.setOnClickListener(new 9(this));
            return;
        }
        com.tencent.mm.plugin.wallet.a.p.bJN();
        if (com.tencent.mm.plugin.wallet.a.p.bJO().bLW()) {
            this.szR.setVisibility(0);
            this.szR.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WalletBalanceManagerUI szV;

                {
                    this.szV = r1;
                }

                public final void onClick(View view) {
                    com.tencent.mm.kernel.g.Dk();
                    com.tencent.mm.kernel.g.Dj().CU().a(com.tencent.mm.storage.w.a.xvT, Integer.valueOf(-1));
                    Intent intent = new Intent(this.szV, WalletLqtDetailUI.class);
                    intent.putExtra("key_account_type", 1);
                    this.szV.startActivity(intent);
                }
            });
            TextView textView = this.szT;
            com.tencent.mm.plugin.wallet.a.p.bJN();
            textView.setText(com.tencent.mm.plugin.wallet.a.p.bJO().bLT());
            this.szS.setVisibility(0);
            return;
        }
        com.tencent.mm.plugin.wallet.a.p.bJN();
        ag bJO = com.tencent.mm.plugin.wallet.a.p.bJO();
        if (bJO != null) {
            if ((bJO.bLQ().sPW & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) > 0) {
                z = true;
            } else {
                z = false;
            }
            x.i("MicroMsg.WalletSwitchConfig", "isSupportLCT, ret = %s switchBit %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(bJO.bLQ().sPW)});
            if (!(!z || TextUtils.isEmpty(bJO.bLT()) || TextUtils.isEmpty(bJO.bLU()))) {
                this.szR.setVisibility(0);
                this.szT.setText(bJO.bLT());
                this.szS.setVisibility(0);
                this.szR.setOnClickListener(new 11(this, bJO));
                return;
            }
        }
        this.szR.setVisibility(8);
    }

    private void bJv() {
        String str;
        JSONObject jSONObject;
        Throwable e;
        this.mController.removeAllOptionMenu();
        JSONObject jSONObject2 = null;
        boolean z;
        try {
            str = (String) com.tencent.mm.kernel.g.Dj().CU().get(com.tencent.mm.storage.w.a.xxt, "");
            if (bh.ov(str)) {
                z = false;
                jSONObject = null;
            } else {
                jSONObject = new JSONObject(str);
                try {
                    z = jSONObject.optBoolean("is_show_menu", false);
                } catch (JSONException e2) {
                    e = e2;
                    jSONObject2 = jSONObject;
                    x.printErrStackTrace("MicroMsg.WalletBalanceManagerUI", e, "", new Object[0]);
                    z = false;
                    jSONObject = jSONObject2;
                    if (jSONObject == null) {
                    }
                    x.i("MicroMsg.WalletBalanceManagerUI", "go old menu logic");
                    com.tencent.mm.plugin.wallet.a.p.bJN();
                    com.tencent.mm.plugin.wallet.a.p.bJO();
                    str = this.szU.field_bindSerial;
                    if (bh.ov(this.szU.sLi)) {
                        a(getString(i.uPm), new 2(this), com.tencent.mm.ui.p.b.xJI);
                    }
                }
            }
        } catch (JSONException e3) {
            e = e3;
            x.printErrStackTrace("MicroMsg.WalletBalanceManagerUI", e, "", new Object[0]);
            z = false;
            jSONObject = jSONObject2;
            if (jSONObject == null) {
            }
            x.i("MicroMsg.WalletBalanceManagerUI", "go old menu logic");
            com.tencent.mm.plugin.wallet.a.p.bJN();
            com.tencent.mm.plugin.wallet.a.p.bJO();
            str = this.szU.field_bindSerial;
            if (bh.ov(this.szU.sLi)) {
                a(getString(i.uPm), new 2(this), com.tencent.mm.ui.p.b.xJI);
            }
        }
        if (jSONObject == null && r0) {
            x.i("MicroMsg.WalletBalanceManagerUI", "go new menu logic");
            addIconOptionMenu(0, h.duY, new 12(this, jSONObject, new ArrayList()));
            return;
        }
        x.i("MicroMsg.WalletBalanceManagerUI", "go old menu logic");
        com.tencent.mm.plugin.wallet.a.p.bJN();
        com.tencent.mm.plugin.wallet.a.p.bJO();
        str = this.szU.field_bindSerial;
        if (bh.ov(this.szU.sLi)) {
            a(getString(i.uPm), new 2(this), com.tencent.mm.ui.p.b.xJI);
        }
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0 && !(kVar instanceof com.tencent.mm.plugin.wallet.bind.a.b) && (kVar instanceof com.tencent.mm.plugin.wallet_core.c.x)) {
            au();
        }
        return false;
    }

    public final void sp(int i) {
        com.tencent.mm.plugin.wallet.a.p.bJN();
        this.szU = com.tencent.mm.plugin.wallet.a.p.bJO().szU;
        if (this.szU != null) {
            if (this.szU.sLf >= 0.0d) {
                this.szP.setText(e.u(this.szU.sLf));
            } else {
                this.szP.setText(getString(i.uRT));
            }
            bJv();
        }
    }

    protected void onNewIntent(Intent intent) {
        x.i("MicroMsg.WalletBalanceManagerUI", "jumpFethProcess from bind ui flag:" + intent.getIntExtra("from_bind_ui", 0));
        if (intent.getIntExtra("from_bind_ui", 0) == a.sxZ) {
            com.tencent.mm.wallet_core.a.a((Activity) this, com.tencent.mm.plugin.wallet.balance.b.class, null, null);
            e.HF(15);
        }
    }
}
