package com.tencent.mm.plugin.wallet.pay.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.Orders.DeductShowInfo;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.ArrayList;
import java.util.List;

public class WalletPayDeductUI extends MMPreference implements OnClickListener, e {
    private Dialog ilS = null;
    protected f jKn;
    private String kLA;
    protected Button lRZ;
    protected Orders pPl;
    protected MMSwitchBtn sFi;
    protected ArrayList<Preference> sFj;
    protected TextView sFk;
    private TextView sFl;
    private TextView sFm;
    private String sFn;
    private String sFo;
    private Bankcard sFp;
    private LinearLayout sFq;
    protected boolean sFr = false;
    private int sFs = 0;
    private String sFt;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jKn = this.yjd;
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(c.white)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(a.f.divider);
            if (findViewById != null) {
                findViewById.setBackgroundColor(getResources().getColor(c.transparent));
            }
            customView = customView.findViewById(16908309);
            if (customView != null && (customView instanceof TextView)) {
                ((TextView) customView).setTextColor(getResources().getColor(c.white));
            }
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            if (d.fM(23)) {
                window.setStatusBarColor(getResources().getColor(c.ubx));
                getWindow().getDecorView().setSystemUiVisibility(8192);
            } else {
                getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
            }
        }
        Intent intent = getIntent();
        if (intent == null) {
            x.e("MicroMsg.WalletPayDeductUI", "intent is null");
            finish();
            return;
        }
        this.pPl = (Orders) intent.getParcelableExtra("orders");
        if (this.pPl == null || this.pPl.sOb == null) {
            x.e("MicroMsg.WalletPayDeductUI", "Orders data or deductInfo is null   : " + this.pPl);
            finish();
        }
        cd(this.pPl.sOb.sOw);
        setResult(0);
        setBackBtn(new 1(this), h.dvO);
        g.Dk();
        g.Di().gPJ.a(385, this);
        initView();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        g.Dk();
        g.Di().gPJ.b(385, this);
    }

    public final int XB() {
        return -1;
    }

    protected final void initView() {
        boolean z;
        this.sFk = (TextView) this.mController.contentView.findViewById(a.f.ufN);
        this.lRZ = (Button) this.mController.contentView.findViewById(a.f.cAg);
        this.sFq = (LinearLayout) findViewById(a.f.usV);
        ((TextView) findViewById(a.f.ujf)).setText(this.pPl.sOb.title);
        ((TextView) findViewById(a.f.title)).setText(((Commodity) this.pPl.sNW.get(0)).desc);
        ((TextView) findViewById(a.f.uku)).setText(com.tencent.mm.wallet_core.ui.e.aay(this.pPl.paz));
        ((TextView) findViewById(a.f.fpO)).setText(((Commodity) this.pPl.sNW.get(0)).ljg);
        TextView textView = (TextView) findViewById(a.f.gVw);
        TextView textView2 = (TextView) findViewById(a.f.uje);
        if (bh.ov(this.pPl.sOb.sOy)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(this.pPl.sOb.sOy);
        }
        this.sFl = (TextView) findViewById(a.f.ujg);
        this.sFm = (TextView) findViewById(a.f.ueW);
        if (this.pPl.sOb.sGa == 1) {
            z = true;
        } else {
            z = false;
        }
        this.sFr = z;
        this.sFs = this.pPl.sOb.sFs;
        this.kLA = this.pPl.sOb.kLA;
        this.sFt = this.pPl.sOb.sFt;
        x.i("MicroMsg.WalletPayDeductUI", "open: %s, show_type: %s", new Object[]{Boolean.valueOf(this.sFr), Integer.valueOf(this.sFs)});
        if (this.sFs == 0) {
            this.sFi = (MMSwitchBtn) findViewById(a.f.checkbox);
            this.sFi.nB(this.sFr);
            this.sFi.zvp = new 2(this);
            jD(this.sFr);
        } else {
            if (!bh.ov(this.kLA)) {
                this.lRZ.setText(this.kLA);
            }
            if (!bh.ov(this.sFt)) {
                this.sFk.setText(this.sFt);
                this.sFk.setVisibility(0);
            }
            findViewById(a.f.ujd).setVisibility(8);
            bKf();
        }
        x.d("MicroMsg.WalletPayDeductUI", "show pay way layout: %d", new Object[]{Integer.valueOf(this.pPl.sOb.sOx)});
        if (this.pPl.sOb.sOx == 1) {
            g.Dk();
            this.sFo = (String) g.Dj().CU().get(w.a.xrz, "");
            g.Dk();
            this.sFn = (String) g.Dj().CU().get(w.a.xry, "");
            if (bh.ov(this.sFn) || bh.ov(this.sFn)) {
                x.i("MicroMsg.WalletPayDeductUI", "need do pay manager");
                this.ilS = com.tencent.mm.wallet_core.ui.g.a(this.mController.xIM, false, null);
                k cVar = new com.tencent.mm.plugin.wallet.pwd.a.c();
                g.Dk();
                g.Di().gPJ.a(cVar, 0);
            } else {
                this.sFm.setText(this.sFo);
                bKe();
            }
        } else {
            this.sFq.setVisibility(8);
        }
        if (bh.ov(this.pPl.sOb.sOv)) {
            textView.setVisibility(8);
        } else {
            String string = getString(i.uRh);
            String string2 = getString(i.uRi);
            CharSequence a = com.tencent.mm.pluginsdk.ui.d.i.a(this, getString(i.uRg, new Object[]{string, string2}));
            com.tencent.mm.plugin.wallet_core.ui.g gVar = new com.tencent.mm.plugin.wallet_core.ui.g(this.mController.xIM);
            CharSequence spannableString = new SpannableString(a);
            spannableString.setSpan(gVar, a.length() - string2.length(), a.length(), 33);
            textView.setTextColor(getResources().getColor(c.bsO));
            textView.setText(spannableString);
            textView.setOnClickListener(this);
            textView.setVisibility(0);
        }
        this.lRZ.setOnClickListener(this);
    }

    private void bKe() {
        p.bJN();
        ag bJO = p.bJO();
        if (this.sFp == null) {
            this.sFp = bJO.a(null, null, true, true, true);
        }
        if (this.sFp == null) {
            x.i("MicroMsg.WalletPayDeductUI", "no bank card!");
            finish();
            return;
        }
        CharSequence spannableString = new SpannableString(this.sFp.field_desc);
        com.tencent.mm.plugin.wallet_core.ui.g gVar = new com.tencent.mm.plugin.wallet_core.ui.g(this.mController.xIM);
        gVar.sTw = new 3(this, bJO.jB(true));
        spannableString.setSpan(gVar, 0, spannableString.length(), 18);
        this.sFl.setText(spannableString);
        this.sFl.setMovementMethod(LinkMovementMethod.getInstance());
    }

    protected final void jD(boolean z) {
        if (z) {
            findViewById(16908298).setVisibility(0);
            if (this.pPl.sOb.sOx == 1) {
                this.sFq.setVisibility(0);
            } else {
                this.sFq.setVisibility(8);
            }
            bKf();
            if (o.bLq().bLM()) {
                this.sFk.setVisibility(8);
                this.lRZ.setText(i.uRm);
            } else {
                this.sFk.setVisibility(0);
                this.sFk.setText(i.uRl);
                this.lRZ.setText(i.uRj);
            }
        } else {
            if (this.sFj != null && this.sFj.size() > 0) {
                int size = this.sFj.size();
                for (int i = 0; i < size; i++) {
                    this.jKn.bk(((Preference) this.sFj.get(i)).ibD, true);
                }
            }
            findViewById(16908298).setVisibility(8);
            this.sFq.setVisibility(8);
            this.sFk.setVisibility(8);
            this.lRZ.setText(i.uRk);
        }
        x.i("MicroMsg.WalletPayDeductUI", "isCheck=" + this.sFi.zvg);
    }

    private void bKf() {
        if (this.sFj != null && this.sFj.size() > 0) {
            int size = this.sFj.size();
            for (int i = 0; i < size; i++) {
                this.jKn.bk(((Preference) this.sFj.get(i)).ibD, false);
            }
            this.jKn.notifyDataSetChanged();
        }
    }

    private void cd(List<DeductShowInfo> list) {
        if (list == null || list.size() == 0) {
            x.e("MicroMsg.WalletPayDeductUI", "showinfos is null or length is 0");
        } else if (this.sFj == null) {
            int size = list.size();
            this.sFj = new ArrayList();
            for (int i = 0; i < size; i++) {
                DeductShowInfo deductShowInfo = (DeductShowInfo) list.get(i);
                if (!(deductShowInfo == null || bh.ov(deductShowInfo.name))) {
                    Preference dVar = new com.tencent.mm.plugin.wallet_core.ui.d(this);
                    dVar.setTitle(deductShowInfo.name);
                    dVar.ndc = deductShowInfo.value;
                    dVar.ndg = false;
                    int i2 = a.f.uyJ;
                    String str = deductShowInfo.url;
                    if (dVar.ltB != null) {
                        dVar.ltB.setTag(i2, str);
                    }
                    dVar.setKey("deduct_info_" + i);
                    this.sFj.add(dVar);
                    this.jKn.a(dVar);
                    this.jKn.bk(dVar.ibD, true);
                }
            }
        }
    }

    protected final int getLayoutId() {
        return a.g.uFA;
    }

    public final boolean a(f fVar, Preference preference) {
        Object obj = null;
        if (preference instanceof com.tencent.mm.plugin.wallet_core.ui.d) {
            Object tag;
            com.tencent.mm.plugin.wallet_core.ui.d dVar = (com.tencent.mm.plugin.wallet_core.ui.d) preference;
            int i = a.f.uyJ;
            if (dVar.ltB != null) {
                tag = dVar.ltB.getTag(i);
            } else {
                tag = null;
            }
            if (tag != null) {
                obj = tag;
            }
            if (obj != null) {
                String str = (String) obj;
                if (!bh.ov(str)) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("showShare", false);
                    com.tencent.mm.bm.d.b(this, "webview", ".ui.tools.WebViewUI", intent);
                    return true;
                }
            }
        }
        return false;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.cAg) {
            Intent intent = new Intent();
            if (this.sFs == 0) {
                intent.putExtra("auto_deduct_flag", this.sFi.zvg ? 1 : 0);
            } else {
                intent.putExtra("auto_deduct_flag", this.pPl.sOb.sGa);
            }
            if (this.sFp != null) {
                intent.putExtra("deduct_bank_type", this.sFp.field_bankcardType);
                intent.putExtra("deduct_bind_serial", this.sFp.field_bindSerial);
                x.i("MicroMsg.WalletPayDeductUI", "deduct bankType: %s", new Object[]{this.sFp.field_bankcardType});
            }
            setResult(-1, intent);
            finish();
        } else if (id == a.f.gVw && !bh.ov(this.pPl.sOb.sOv)) {
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", this.pPl.sOb.sOv);
            intent2.putExtra("showShare", false);
            com.tencent.mm.bm.d.b(this, "webview", ".ui.tools.WebViewUI", intent2);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.WalletPayDeductUI", "errType: %d, errCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (!(kVar instanceof com.tencent.mm.plugin.wallet.pwd.a.c)) {
            x.d("MicroMsg.WalletPayDeductUI", "other tenpay scene");
        } else if (i == 0 && i2 == 0) {
            g.Dk();
            this.sFo = (String) g.Dj().CU().get(w.a.xrz, getString(i.uUK));
            g.Dk();
            this.sFn = (String) g.Dj().CU().get(w.a.xry, getString(i.uUM));
            this.sFm.setText(this.sFo);
            bKe();
        }
        if (this.ilS != null) {
            this.ilS.dismiss();
        }
    }
}
