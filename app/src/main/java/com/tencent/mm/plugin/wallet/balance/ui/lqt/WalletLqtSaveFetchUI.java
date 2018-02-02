package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ae.k;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.wallet.balance.a.a.i;
import com.tencent.mm.plugin.wallet.balance.a.a.m;
import com.tencent.mm.plugin.wallet.balance.a.a.n;
import com.tencent.mm.plugin.wallet.balance.a.a.o;
import com.tencent.mm.plugin.wallet.balance.a.a.o.7;
import com.tencent.mm.plugin.wallet.balance.a.a.o.8;
import com.tencent.mm.plugin.wallet.balance.a.a.o.9;
import com.tencent.mm.plugin.wallet.balance.a.a.p;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.pluginsdk.ui.d.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.ape;
import com.tencent.mm.protocal.c.aua;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class WalletLqtSaveFetchUI extends WalletLqtBasePresenterUI {
    private int accountType;
    private Dialog iib;
    private int mode;
    private HashMap<String, Integer> oYE = new HashMap();
    private o sAY = new o(this.syO, this.syP, this);
    private p sAZ = new p(this.sAY);
    private ViewGroup sBa;
    private WalletFormView sBb;
    private TextView sBc;
    private TextView sBd;
    private Button sBe;
    private TextView sBf;
    private TextView sBg;
    private ViewGroup sBh;
    private TextView sBi;
    private CheckBox sBj;
    private TextView sBk;
    private TextView sBl;
    private TextView sBm;
    private CharSequence sBn;
    private Bankcard sBo;
    private int sBp;
    private String sBq;
    private String sBr;
    private long sBs = -1;
    private String sBt;
    private boolean sBu = false;
    private m syO = ((m) t(m.class));
    private n syP = ((n) q(n.class));
    private Bankcard szl;

    static /* synthetic */ void a(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
        Bankcard bankcard;
        String str;
        int i;
        View inflate;
        int i2 = 0;
        walletLqtSaveFetchUI.oYE.clear();
        g gVar = new g(walletLqtSaveFetchUI, g.ztq, true);
        List jt = i.syp.jt(walletLqtSaveFetchUI.mode == 1);
        if (jt == null || jt.size() == 0) {
            com.tencent.mm.plugin.wallet.a.p.bJN();
            jt = com.tencent.mm.plugin.wallet.a.p.bJO().bMa();
        }
        List linkedList = new LinkedList();
        if (r0 != null) {
            for (Bankcard bankcard2 : r0) {
                if (bankcard2.bKP()) {
                    com.tencent.mm.plugin.wallet.a.p.bJN();
                    if (!com.tencent.mm.plugin.wallet.a.p.bJO().bLJ()) {
                        linkedList.add(bankcard2);
                    }
                }
                if (walletLqtSaveFetchUI.mode == 1 && (bankcard2.field_support_lqt_turn_in == 1 || bankcard2.bKP())) {
                    linkedList.add(bankcard2);
                }
                if (walletLqtSaveFetchUI.mode == 2 && (bankcard2.field_support_lqt_turn_out == 1 || bankcard2.bKP())) {
                    linkedList.add(bankcard2);
                }
            }
        }
        String str2 = walletLqtSaveFetchUI.szl != null ? walletLqtSaveFetchUI.szl.field_bindSerial : null;
        if (bh.ov(str2)) {
            str2 = walletLqtSaveFetchUI.sBt;
            if (bh.ov(walletLqtSaveFetchUI.sBt)) {
                com.tencent.mm.kernel.g.Dk();
                str = (String) com.tencent.mm.kernel.g.Dj().CU().get(a.xxu, "");
                i = 0;
                while (i2 < linkedList.size()) {
                    bankcard2 = (Bankcard) linkedList.get(i2);
                    int i3 = (bh.ov(bankcard2.field_bindSerial) || !str.equals(bankcard2.field_bindSerial)) ? i : i2;
                    i2++;
                    i = i3;
                }
                gVar.rKC = new 11(walletLqtSaveFetchUI, linkedList, gVar);
                gVar.rKD = new 12(walletLqtSaveFetchUI, gVar, linkedList);
                inflate = View.inflate(walletLqtSaveFetchUI, com.tencent.mm.plugin.wxpay.a.g.uCh, null);
                if (walletLqtSaveFetchUI.mode != 1) {
                    ((TextView) inflate.findViewById(f.umA)).setText(com.tencent.mm.plugin.wxpay.a.i.uSS);
                    ((TextView) inflate.findViewById(f.umz)).setText(com.tencent.mm.plugin.wxpay.a.i.uSR);
                } else {
                    ((TextView) inflate.findViewById(f.umA)).setText(com.tencent.mm.plugin.wxpay.a.i.uSu);
                    ((TextView) inflate.findViewById(f.umz)).setText(com.tencent.mm.plugin.wxpay.a.i.uSt);
                }
                gVar.pEa = true;
                gVar.ztz = i;
                gVar.ztx = true;
                gVar.dO(inflate);
                gVar.bUk();
            }
        }
        str = str2;
        i = 0;
        while (i2 < linkedList.size()) {
            bankcard2 = (Bankcard) linkedList.get(i2);
            if (!bh.ov(bankcard2.field_bindSerial)) {
            }
            i2++;
            i = i3;
        }
        gVar.rKC = new 11(walletLqtSaveFetchUI, linkedList, gVar);
        gVar.rKD = new 12(walletLqtSaveFetchUI, gVar, linkedList);
        inflate = View.inflate(walletLqtSaveFetchUI, com.tencent.mm.plugin.wxpay.a.g.uCh, null);
        if (walletLqtSaveFetchUI.mode != 1) {
            ((TextView) inflate.findViewById(f.umA)).setText(com.tencent.mm.plugin.wxpay.a.i.uSu);
            ((TextView) inflate.findViewById(f.umz)).setText(com.tencent.mm.plugin.wxpay.a.i.uSt);
        } else {
            ((TextView) inflate.findViewById(f.umA)).setText(com.tencent.mm.plugin.wxpay.a.i.uSS);
            ((TextView) inflate.findViewById(f.umz)).setText(com.tencent.mm.plugin.wxpay.a.i.uSR);
        }
        gVar.pEa = true;
        gVar.ztz = i;
        gVar.ztx = true;
        gVar.dO(inflate);
        gVar.bUk();
    }

    static /* synthetic */ void g(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
        Bundle bundle = new Bundle();
        Parcelable parcelable = (PayInfo) walletLqtSaveFetchUI.vf.get("key_pay_info");
        if (parcelable == null) {
            parcelable = new PayInfo();
            parcelable.fuH = "";
            if (walletLqtSaveFetchUI.mode == 1) {
                if (walletLqtSaveFetchUI.accountType == 0) {
                    parcelable.fCV = 45;
                } else {
                    parcelable.fCV = 52;
                }
            } else if (walletLqtSaveFetchUI.accountType == 0) {
                parcelable.fCV = 51;
            } else {
                parcelable.fCV = 53;
            }
        }
        if (parcelable != null) {
            bundle.putParcelable("key_pay_info", parcelable);
        }
        if (walletLqtSaveFetchUI.mode == 1) {
            if (walletLqtSaveFetchUI.accountType == 0) {
                bundle.putInt("key_scene", 45);
            } else {
                bundle.putInt("key_scene", 52);
            }
            bundle.putInt("key_bind_scene", 16);
        } else {
            if (walletLqtSaveFetchUI.accountType == 0) {
                bundle.putInt("key_scene", 51);
            } else {
                bundle.putInt("key_scene", 53);
            }
            bundle.putInt("key_bind_scene", 17);
        }
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_is_bind_bankcard", true);
        com.tencent.mm.wallet_core.a.a(walletLqtSaveFetchUI, b.class, bundle, new 14(walletLqtSaveFetchUI));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.WalletLqtSaveFetchUI", "WalletLqtSaveFetchUI onCreate");
        this.sBb = (WalletFormView) findViewById(f.umu);
        this.sBe = (Button) findViewById(f.cAg);
        this.sBf = (TextView) findViewById(f.ums);
        this.sBg = (TextView) findViewById(f.umt);
        this.sBc = (TextView) findViewById(f.umv);
        this.sBd = (TextView) findViewById(f.ulW);
        this.sBm = (TextView) findViewById(f.uAj);
        this.sBh = (ViewGroup) findViewById(f.umw);
        this.sBi = (TextView) findViewById(f.umy);
        this.sBj = (CheckBox) findViewById(f.umx);
        this.sBa = (ViewGroup) findViewById(f.cuM);
        this.sBk = (TextView) findViewById(f.ukP);
        this.sBl = (TextView) findViewById(f.ukQ);
        this.mode = getIntent().getIntExtra("lqt_save_fetch_mode", 1);
        this.sBp = getIntent().getIntExtra("lqt_max_redeem_amount", -1);
        this.sBq = getIntent().getStringExtra("lqt_redeem_invalid_amount_hint");
        this.sBr = getIntent().getStringExtra("lqt_profile_wording");
        this.accountType = getIntent().getIntExtra("lqt_account_type", 0);
        if (this.mode == 1) {
            com.tencent.mm.kernel.g.Dk();
            this.sBt = (String) com.tencent.mm.kernel.g.Dj().CU().get(a.xxv, "");
        } else {
            com.tencent.mm.kernel.g.Dk();
            this.sBt = (String) com.tencent.mm.kernel.g.Dj().CU().get(a.xxw, "");
        }
        if (bh.ov(this.sBt)) {
            com.tencent.mm.kernel.g.Dk();
            this.sBt = (String) com.tencent.mm.kernel.g.Dj().CU().get(a.xxu, "");
        }
        x.i("MicroMsg.WalletLqtSaveFetchUI", "onCreate, accountType: %s, mode: %s, mCurrentSerial: %s", new Object[]{Integer.valueOf(this.accountType), Integer.valueOf(this.mode), this.sBt});
        b(this.sBb, 2, false, false);
        if (this.mode == 1) {
            this.sBc.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uST));
            this.sBe.setText(com.tencent.mm.plugin.wxpay.a.i.uSZ);
            this.sBm.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uSW));
        } else if (this.mode == 2) {
            this.sBc.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uSv));
            this.sBe.setText(com.tencent.mm.plugin.wxpay.a.i.uSK);
            this.sBm.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uSA));
        }
        this.sBb.a(new 5(this));
        this.sBe.setOnClickListener(new 6(this));
        if (!bh.ov(this.sBr)) {
            TextView textView = (TextView) findViewById(f.umq);
            textView.setText(this.sBr);
            textView.setVisibility(0);
        }
        this.sBf.setText("");
        this.sBf.setClickable(true);
        this.sBf.setOnTouchListener(new l(this));
        jx(false);
        if (this.mode == 1) {
            this.sBa.setVisibility(4);
        }
        if (this.sBd.findViewById(f.uAi) != null) {
            this.sBd.findViewById(f.uAi).setVisibility(8);
        }
        OnClickListener 1 = new 1(this);
        this.sBd.setOnClickListener(1);
        if (findViewById(f.uhA) != null) {
            findViewById(f.uhA).setOnClickListener(1);
        }
        if (this.mode == 1) {
            i iVar = i.syp;
            iVar.jw(true);
            ape com_tencent_mm_protocal_c_ape = iVar.syj;
            this.sBo = com_tencent_mm_protocal_c_ape != null ? ab.a(com_tencent_mm_protocal_c_ape.wvT) : null;
            if (this.sBo == null) {
                com.tencent.mm.plugin.wallet.a.p.bJN();
                this.sBo = com.tencent.mm.plugin.wallet.a.p.bJO().szU;
            }
            if (this.sBo != null) {
                String string = getString(com.tencent.mm.plugin.wxpay.a.i.uSn, new Object[]{Double.valueOf(this.sBo.sLf)});
                int length = string.length();
                CharSequence spannableString = new SpannableString(string + getString(com.tencent.mm.plugin.wxpay.a.i.uSo));
                spannableString.setSpan(new a(new 7(this)), length, spannableString.length(), 18);
                this.sBn = spannableString;
                this.sBf.setText(spannableString);
            }
            this.sBa.setVisibility(0);
        }
        bJz();
    }

    private void bJz() {
        Bankcard bankcard;
        int i;
        List jt = i.syp.jt(this.mode == 1);
        if (jt == null || jt.size() == 0) {
            com.tencent.mm.plugin.wallet.a.p.bJN();
            jt = com.tencent.mm.plugin.wallet.a.p.bJO().bMa();
        }
        List linkedList = new LinkedList();
        if (r0 != null) {
            for (Bankcard bankcard2 : r0) {
                if (bankcard2.bKP()) {
                    com.tencent.mm.plugin.wallet.a.p.bJN();
                    if (!com.tencent.mm.plugin.wallet.a.p.bJO().bLJ()) {
                        linkedList.add(bankcard2);
                    }
                }
                if (this.mode == 1 && bankcard2.field_support_lqt_turn_in == 1) {
                    linkedList.add(bankcard2);
                }
                if (this.mode == 2 && bankcard2.field_support_lqt_turn_out == 1) {
                    linkedList.add(bankcard2);
                }
            }
        }
        this.szl = i.syp.js(this.mode == 1);
        if (this.szl == null) {
            com.tencent.mm.plugin.wallet.a.p.bJN();
            this.szl = com.tencent.mm.plugin.wallet.a.p.bJO().szU;
        }
        String str = "MicroMsg.WalletLqtSaveFetchUI";
        String str2 = "defaultBankcard: %s, save mCurrentSerial: %s";
        Object[] objArr = new Object[2];
        objArr[0] = this.szl != null ? this.szl.field_bindSerial : "";
        objArr[1] = this.sBt;
        x.i(str, str2, objArr);
        if (!bh.ov(this.sBt)) {
            for (i = 0; i < linkedList.size(); i++) {
                bankcard2 = (Bankcard) linkedList.get(i);
                if (!bh.ov(bankcard2.field_bindSerial) && this.sBt.equals(bankcard2.field_bindSerial)) {
                    this.szl = bankcard2;
                }
            }
        }
        this.sBd.setText(this.szl.field_desc);
        this.sBd.setVisibility(0);
        this.sBk.setVisibility(8);
        this.sBl.setVisibility(8);
        if (this.mode == 2) {
            if (!this.szl.bKP() && !bh.ov(this.szl.field_avail_save_wording)) {
                this.sBk.setText(this.szl.field_avail_save_wording);
                this.sBk.setVisibility(0);
            } else if (this.szl.bKP()) {
                boolean z;
                i iVar = i.syp;
                if (this.mode == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (!bh.ov(iVar.ju(z))) {
                    TextView textView = this.sBk;
                    i iVar2 = i.syp;
                    if (this.mode == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    textView.setText(iVar2.ju(z));
                    this.sBk.setVisibility(0);
                }
            }
            if (!bh.ov(this.szl.field_fetchArriveTimeWording)) {
                this.sBl.setText(this.szl.field_fetchArriveTimeWording);
                this.sBl.setVisibility(0);
            }
        } else if (!(this.mode != 1 || this.szl.bKP() || bh.ov(this.szl.field_avail_save_wording))) {
            this.sBk.setText(this.szl.field_avail_save_wording);
            this.sBk.setVisibility(0);
        }
        String string;
        CharSequence spannableString;
        if (this.mode == 1) {
            setMMTitle(getString(com.tencent.mm.plugin.wxpay.a.i.uSZ));
            ArrayList stringArrayListExtra = getIntent().getStringArrayListExtra("lqt_protocol_list");
            boolean booleanExtra = getIntent().getBooleanExtra("lqt_is_show_protocol", false);
            if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0 || !booleanExtra) {
                this.sBh.setVisibility(8);
            } else {
                this.sBh.setVisibility(0);
                this.sBj.setChecked(getIntent().getBooleanExtra("lqt_is_agree_protocol", false));
                this.sBh.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ WalletLqtSaveFetchUI sBv;

                    {
                        this.sBv = r1;
                    }

                    public final void onClick(View view) {
                        this.sBv.sBj.setChecked(!this.sBv.sBj.isChecked());
                    }
                });
                this.sBj.setOnCheckedChangeListener(new 3(this));
                string = getString(com.tencent.mm.plugin.wxpay.a.i.uSO);
                i = string.length();
                spannableString = new SpannableString(string + getString(com.tencent.mm.plugin.wxpay.a.i.uSP));
                spannableString.setSpan(new a(new 4(this, stringArrayListExtra)), i, spannableString.length(), 17);
                this.sBi.setText(spannableString);
                this.sBi.setClickable(true);
                this.sBi.setOnTouchListener(new l());
            }
        } else if (this.mode == 2) {
            findViewById(f.uyW).setVisibility(8);
            this.sBh.setVisibility(8);
            setMMTitle(getString(com.tencent.mm.plugin.wxpay.a.i.uSL));
            this.sBg.setVisibility(8);
            com.tencent.mm.plugin.wallet.balance.a.a.l bJn = com.tencent.mm.plugin.wallet.balance.a.a.l.bJn();
            int i2;
            if (this.szl == null || !this.szl.bKP()) {
                i2 = bJn.syE == null ? 0 : bJn.syE.wBU;
                if (r.iep) {
                    i2 = 100;
                }
                String string2 = getString(com.tencent.mm.plugin.wxpay.a.i.uSH, new Object[]{Double.valueOf(D(String.valueOf(i2), "100", 2))});
                int length = string2.length();
                CharSequence spannableString2 = new SpannableString(string2 + getString(com.tencent.mm.plugin.wxpay.a.i.uSI));
                spannableString2.setSpan(new a(new 9(this, i2)), length, spannableString2.length(), 18);
                this.sBn = spannableString2;
                this.sBf.setText(spannableString2);
                if (bJn.syE != null && (bJn.syE.wBV > 0 || r.iep)) {
                    i2 = bJn.syE.wBV;
                    this.sBg.setVisibility(0);
                    this.sBg.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uSF, new Object[]{Double.valueOf(D(String.valueOf(i2), "100", 2))}));
                }
                aua com_tencent_mm_protocal_c_aua = bJn.syE;
                if (!(com_tencent_mm_protocal_c_aua == null || com_tencent_mm_protocal_c_aua.wBW == null || com_tencent_mm_protocal_c_aua.wBW.size() <= 0)) {
                    findViewById(f.uyW).setVisibility(0);
                    findViewById(f.uyW).setOnClickListener(new 10(this, com_tencent_mm_protocal_c_aua));
                }
            } else {
                i2 = getIntent().getIntExtra("lqt_balance", 0);
                if (r.iep) {
                    i2 = 100;
                }
                if (i2 > 0) {
                    string = getString(com.tencent.mm.plugin.wxpay.a.i.uSG, new Object[]{Double.valueOf(D(String.valueOf(i2), "100", 2))});
                    i = string.length();
                    spannableString = new SpannableString(string + getString(com.tencent.mm.plugin.wxpay.a.i.uSI));
                    spannableString.setSpan(new a(new 8(this, i2)), i, spannableString.length(), 18);
                    this.sBn = spannableString;
                    this.sBf.setText(spannableString);
                }
            }
        }
        if (this.mode == 1) {
            if (this.szl == null || !this.szl.bKP()) {
                this.sBf.setText("");
            } else {
                this.sBf.setText(this.sBn);
            }
        }
        this.sBb.setText(this.sBb.getText());
    }

    private List<Bankcard> bJA() {
        List jt = i.syp.jt(this.mode == 1);
        if (jt == null || jt.size() == 0) {
            com.tencent.mm.plugin.wallet.a.p.bJN();
            jt = com.tencent.mm.plugin.wallet.a.p.bJO().bMa();
        }
        List<Bankcard> linkedList = new LinkedList();
        if (r0 != null) {
            for (Bankcard bankcard : r0) {
                if (bankcard.bKP()) {
                    com.tencent.mm.plugin.wallet.a.p.bJN();
                    if (!com.tencent.mm.plugin.wallet.a.p.bJO().bLJ()) {
                        linkedList.add(bankcard);
                    }
                }
                if (this.mode == 1 && (bankcard.field_support_lqt_turn_in == 1 || bankcard.bKP())) {
                    linkedList.add(bankcard);
                }
                if (this.mode == 2 && (bankcard.field_support_lqt_turn_out == 1 || bankcard.bKP())) {
                    linkedList.add(bankcard);
                }
            }
        }
        return linkedList;
    }

    protected void onNewIntent(Intent intent) {
        x.i("MicroMsg.WalletLqtSaveFetchUI", "onNewIntent");
        super.onNewIntent(intent);
        List bJA = bJA();
        if (this.mode == 1) {
            this.sAZ.szc.dW(this.mode, this.accountType).e(new 13(this, bJA));
        }
    }

    private void jx(boolean z) {
        if (!z) {
            this.sBe.setEnabled(false);
        } else if (this.sBh.getVisibility() == 0) {
            if (this.sBj.isChecked() && this.sBu) {
                this.sBe.setEnabled(true);
            } else {
                this.sBe.setEnabled(false);
            }
        } else if (this.sBu) {
            this.sBe.setEnabled(true);
        }
    }

    public void onResume() {
        super.onResume();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uFi;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        o oVar = this.sAY;
        if (i == o.syM && i2 == -1) {
            Orders orders = (Orders) intent.getParcelableExtra("key_orders");
            if (orders != null && orders.sNW != null && orders.sNW.size() > 0) {
                x.i("MicroMsg.LqtSaveFetchLogic", "onActivityResult, doQueryPurchaseResult, accountType: %s", new Object[]{Integer.valueOf(oVar.accountType)});
                oVar.fuI = ((Commodity) orders.sNW.get(0)).fuI;
                x.i("MicroMsg.LqtSaveFetchLogic", "doQueryPurchaseResult");
                oVar.syQ.agz();
                com.tencent.mm.vending.g.g.a(oVar.syR, oVar.fuI, Integer.valueOf(oVar.syS), Integer.valueOf(oVar.accountType)).b(oVar.syP.syI).e(new 7(oVar)).a(new d.a(oVar) {
                    final /* synthetic */ o syW;

                    {
                        this.syW = r1;
                    }

                    public final void aW(Object obj) {
                        x.i("MicroMsg.LqtSaveFetchLogic", "doQueryPurchaseResult interrupt: %s", new Object[]{obj});
                        this.syW.syQ.bJB();
                        if (this.syW.igh != null) {
                            this.syW.igh.cl(obj);
                        }
                    }
                });
            }
        } else if (i == o.syN && i2 == -1) {
            String stringExtra = intent.getStringExtra("lqt_fetch_enc_pwd");
            x.i("MicroMsg.LqtSaveFetchLogic", "onActivityResult, doRedeemFund, accountType: %s", new Object[]{Integer.valueOf(oVar.accountType)});
            x.i("MicroMsg.LqtSaveFetchLogic", "doRedeemFund");
            oVar.syQ.agz();
            com.tencent.mm.vending.c.a aVar = oVar.syP.syJ;
            int i3 = oVar.syT;
            com.tencent.mm.vending.g.g.a(Integer.valueOf(i3), stringExtra, oVar.syU, Integer.valueOf(oVar.accountType)).b(aVar).e(new 9(oVar)).a(new 8(oVar));
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        o oVar = this.sAY;
        x.i("MicroMsg.LqtSaveFetchLogic", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, kVar});
        if (kVar instanceof com.tencent.mm.plugin.wallet_core.c.x) {
            com.tencent.mm.plugin.wallet.a.p.bJN();
            oVar.syV = com.tencent.mm.plugin.wallet.a.p.bJO().szU;
            if (oVar.igh != null) {
                oVar.igh.t(new Object[]{kVar});
                oVar.igh.resume();
            }
        }
        return super.d(i, i2, str, kVar);
    }

    public final void agz() {
        if (this.iib == null) {
            this.iib = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
        } else {
            this.iib.show();
        }
    }

    public final void bJB() {
        if (this.iib != null) {
            this.iib.dismiss();
        }
    }

    public final void bJC() {
        boolean z;
        int i = 0;
        if (this.mode == 1) {
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Dj().CU().a(a.xxv, this.sBt);
        } else {
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Dj().CU().a(a.xxw, this.sBt);
        }
        i iVar = i.syp;
        if (this.mode == 1) {
            z = true;
        } else {
            z = false;
        }
        iVar.jw(z);
        ape com_tencent_mm_protocal_c_ape = z ? iVar.syj : iVar.syk;
        if (com_tencent_mm_protocal_c_ape != null) {
            x.i("MicroMsg.LqtBindQueryInfoCache", "isReqAgainAfterDeal: %s", new Object[]{Boolean.valueOf(com_tencent_mm_protocal_c_ape.wvV)});
            i = com_tencent_mm_protocal_c_ape.wvV;
        }
        if (i != 0) {
            x.i("MicroMsg.WalletLqtSaveFetchUI", "saveOrfetchDone, req again after deal");
            this.sAZ.szc.dW(this.mode, this.accountType);
        }
    }

    public final void Ib(String str) {
        Toast.makeText(this, str, 1).show();
    }

    public void onDestroy() {
        super.onDestroy();
        this.sAY = null;
        this.sAZ = null;
    }

    private static double D(String str, String str2, int i) {
        try {
            return new BigDecimal(bh.getDouble(str.trim(), 0.0d) == 0.0d ? "0" : str.trim()).divide(new BigDecimal(str2.trim()), 5, 2).doubleValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", e, "", new Object[0]);
            return 0.0d;
        }
    }

    private static int ex(String str, String str2) {
        int i = 0;
        try {
            double d = bh.getDouble(str, 0.0d);
            double d2 = bh.getDouble(str2, 0.0d);
            if (d == 0.0d) {
                str = "0";
            }
            BigDecimal bigDecimal = new BigDecimal(str);
            if (d2 == 0.0d) {
                str2 = "0";
            }
            i = bigDecimal.multiply(new BigDecimal(str2)).intValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", e, "", new Object[0]);
        }
        return i;
    }
}
