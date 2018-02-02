package com.tencent.mm.plugin.recharge.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.telephony.PhoneNumberUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.recharge.model.b;
import com.tencent.mm.plugin.recharge.model.f;
import com.tencent.mm.plugin.recharge.ui.form.InstantAutoCompleteTextView;
import com.tencent.mm.plugin.recharge.ui.form.MallFormView;
import com.tencent.mm.plugin.recharge.ui.form.c$b;
import com.tencent.mm.plugin.recharge.ui.form.c$b.1;
import com.tencent.mm.plugin.recharge.ui.form.c$b.2;
import com.tencent.mm.plugin.recharge.ui.form.c$b.3;
import com.tencent.mm.plugin.recharge.ui.form.c$b.5;
import com.tencent.mm.plugin.recharge.ui.form.c$b.AnonymousClass4;
import com.tencent.mm.plugin.recharge.ui.form.d.a;
import com.tencent.mm.plugin.wallet.a.d;
import com.tencent.mm.plugin.wallet.a.m;
import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.v;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhoneRechargeUI extends MMActivity implements e, a {
    private String desc = "";
    private int errCode = 0;
    private String fnL = "";
    protected Dialog ilS = null;
    private String mAppId = "";
    private View pCN = null;
    private ImageView pCO = null;
    private TextView pCP = null;
    private MallFormView pCQ = null;
    private TextView pCR = null;
    private TextView pCS = null;
    private GridView pCT = null;
    private GridView pCU = null;
    private TextView pCV = null;
    private TextView pCW = null;
    private TextView pCX = null;
    private TextView pCY = null;
    private TextView pCZ = null;
    private ArrayList<n> pCd = null;
    private ArrayList<n> pCe = null;
    private d pCf = null;
    private d pCg = null;
    private d pCh = null;
    private d pCi = null;
    private d pCj = null;
    private TextView pDa = null;
    private b pDb = null;
    private b pDc = null;
    private MallFunction pDd = null;
    private String pDe = "";
    private int pDf;
    private String pDg = "";
    private String pDh = "";
    private c$b pDi = null;
    private m pDj = null;
    private boolean pDk = false;
    private List<String[]> pDl;
    private boolean pfG = false;
    private c pfJ = new 13(this);

    static /* synthetic */ void Ih(String str) {
        x.i("MicroMsg.PhoneRechargeUI", "do scene: %s", new Object[]{str});
        g.CG().a(new f(str), 0);
    }

    static /* synthetic */ com.tencent.mm.plugin.recharge.model.a a(PhoneRechargeUI phoneRechargeUI, String str) {
        x.i("MicroMsg.PhoneRechargeUI", "handle phone number: %s", new Object[]{str});
        com.tencent.mm.plugin.recharge.model.a bmt = com.tencent.mm.plugin.recharge.a.a.bmt();
        if (bmt == null || !str.equals(bmt.pBH)) {
            if (phoneRechargeUI.pDl == null || phoneRechargeUI.pDl.isEmpty()) {
                phoneRechargeUI.pDl = com.tencent.mm.pluginsdk.a.bV(phoneRechargeUI.mController.xIM);
            }
            com.tencent.mm.plugin.recharge.model.a aVar;
            if (phoneRechargeUI.pDl == null || phoneRechargeUI.pDl.isEmpty()) {
                List<com.tencent.mm.plugin.recharge.model.a> bms = com.tencent.mm.plugin.recharge.a.a.bmr().bms();
                if (bms.isEmpty()) {
                    bmt = new com.tencent.mm.plugin.recharge.model.a(str, "", 0);
                    bmt.pBJ = com.tencent.mm.plugin.recharge.model.a.pBF;
                    x.i("MicroMsg.PhoneRechargeUI", "empty history");
                    return bmt;
                }
                for (com.tencent.mm.plugin.recharge.model.a bmt2 : bms) {
                    if (bmt2.pBH.equals(str)) {
                        aVar = new com.tencent.mm.plugin.recharge.model.a(str, bmt2.name, bmt2.pBI, 2);
                        aVar.pBJ = com.tencent.mm.plugin.recharge.model.a.pBF;
                        x.i("MicroMsg.PhoneRechargeUI", "find in history");
                        return aVar;
                    }
                }
                bmt2 = new com.tencent.mm.plugin.recharge.model.a(str, phoneRechargeUI.getString(i.uVS), 0);
                bmt2.pBJ = com.tencent.mm.plugin.recharge.model.a.pBF;
                x.i("MicroMsg.PhoneRechargeUI", "not find in history");
                return bmt2;
            }
            for (String[] strArr : phoneRechargeUI.pDl) {
                String Id = b.Id(strArr[2]);
                if (str.equals(Id)) {
                    aVar = new com.tencent.mm.plugin.recharge.model.a(Id, strArr[1], 1);
                    aVar.pBJ = com.tencent.mm.plugin.recharge.model.a.pBF;
                    x.i("MicroMsg.PhoneRechargeUI", "find in address number");
                    return aVar;
                }
            }
            bmt2 = new com.tencent.mm.plugin.recharge.model.a(str, "", 1);
            bmt2.pBJ = com.tencent.mm.plugin.recharge.model.a.pBF;
            x.i("MicroMsg.PhoneRechargeUI", "not in address");
            return bmt2;
        }
        x.i("MicroMsg.PhoneRechargeUI", "find bind mobile");
        return bmt2;
    }

    static /* synthetic */ boolean a(PhoneRechargeUI phoneRechargeUI, n nVar) {
        if (phoneRechargeUI.pDi.pCu != null) {
            String string;
            com.tencent.mm.plugin.recharge.model.a aVar = phoneRechargeUI.pDi.pCu;
            String text = phoneRechargeUI.pCQ.getText();
            if (aVar.fqd == 1 && bh.ov(aVar.name)) {
                string = phoneRechargeUI.getString(i.uLP, new Object[]{phoneRechargeUI.pCQ.getText(), phoneRechargeUI.getString(i.uVV)});
            } else if (aVar.fqd != 0) {
                if (aVar.fqd != 3 && nVar.sDQ == 1) {
                    String str = "";
                    if (!bh.ov(aVar.name)) {
                        str = aVar.name;
                    } else if (!bh.ov(aVar.pBI)) {
                        str = aVar.pBI;
                    }
                    if (!bh.ov(str)) {
                        string = phoneRechargeUI.getString(i.uLQ, new Object[]{text, str, nVar.name});
                    }
                }
                string = null;
            } else if (bh.ov(aVar.pBI)) {
                string = phoneRechargeUI.getString(i.uLP, new Object[]{text, phoneRechargeUI.getString(i.uVS)});
            } else {
                string = phoneRechargeUI.getString(i.uLR, new Object[]{text});
            }
            if (!bh.ov(string)) {
                h.a((Context) phoneRechargeUI, string, "", phoneRechargeUI.getString(i.uLS), phoneRechargeUI.getString(i.dUa), new 19(phoneRechargeUI, nVar), null);
                return false;
            }
        }
        return true;
    }

    static /* synthetic */ void b(PhoneRechargeUI phoneRechargeUI, String str) {
        phoneRechargeUI.n(new com.tencent.mm.plugin.recharge.model.g(phoneRechargeUI.mAppId, phoneRechargeUI.pDd.pBK, str, "mobile=" + b.Id(phoneRechargeUI.pCQ.getText()) + "&markup=" + (phoneRechargeUI.pDi.pCu != null ? phoneRechargeUI.pDi.pCu.name : "")));
    }

    static /* synthetic */ void d(PhoneRechargeUI phoneRechargeUI, String str) {
        try {
            x.d("MicroMsg.PhoneRechargeUI", "url: %s", new Object[]{str});
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            com.tencent.mm.bm.d.b(phoneRechargeUI, "webview", ".ui.tools.WebViewUI", intent);
        } catch (Exception e) {
            x.e("MicroMsg.PhoneRechargeUI", "hy: url decode failed: raw url: %s", new Object[]{str});
        }
    }

    static /* synthetic */ void g(PhoneRechargeUI phoneRechargeUI) {
        if (phoneRechargeUI.pDj != null) {
            String str = (String) g.Dj().CU().get(w.a.xnU, "");
            g.Dj().CU().a(w.a.xnU, bh.ov(str) ? String.valueOf(phoneRechargeUI.pDj.id) : str + ";" + phoneRechargeUI.pDj.id);
            g.Dj().CU().lH(true);
        }
    }

    private void bmy() {
        this.mAppId = "";
        bmz();
        this.errCode = 0;
        this.fnL = "";
        this.desc = "";
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.CG().a(1571, this);
        g.CG().a(498, this);
        this.pDd = (MallFunction) getIntent().getParcelableExtra("key_func_info");
        if (this.pDd == null) {
            x.e("MicroMsg.PhoneRechargeUI", "hy: function info is null");
            u.makeText(this, "function info is null", 1).show();
            finish();
        }
        bmz();
        setMMTitle(this.pDd.fII);
        setBackBtn(new 1(this));
        this.pCj = new d();
        this.pCj.name = getString(i.uVQ);
        this.pCj.url = getString(i.uVR);
        this.pCN = findViewById(com.tencent.mm.plugin.wxpay.a.f.utz);
        this.pCO = (ImageView) findViewById(com.tencent.mm.plugin.wxpay.a.f.urQ);
        this.pCP = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.urR);
        this.pCQ = (MallFormView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uuS);
        com.tencent.mm.plugin.recharge.ui.form.c.b(this.pCQ);
        this.pDi = new c$b(this.pCQ);
        c$b com_tencent_mm_plugin_recharge_ui_form_c_b = this.pDi;
        x.d(com.tencent.mm.plugin.recharge.ui.form.c.bz(), "hy: setMobileEditTv");
        MallFormView mallFormView = com_tencent_mm_plugin_recharge_ui_form_c_b.pEb;
        TextWatcher 1 = new 1(com_tencent_mm_plugin_recharge_ui_form_c_b);
        if (mallFormView.pEh != null) {
            mallFormView.pEh.addTextChangedListener(1);
        }
        InstantAutoCompleteTextView instantAutoCompleteTextView = (InstantAutoCompleteTextView) com_tencent_mm_plugin_recharge_ui_form_c_b.pEb.pEh;
        com_tencent_mm_plugin_recharge_ui_form_c_b.pCt = com.tencent.mm.pluginsdk.a.bV(com_tencent_mm_plugin_recharge_ui_form_c_b.pEb.getContext());
        com_tencent_mm_plugin_recharge_ui_form_c_b.pEc = new com.tencent.mm.plugin.recharge.ui.form.d(com_tencent_mm_plugin_recharge_ui_form_c_b.pEb, com_tencent_mm_plugin_recharge_ui_form_c_b.pCt);
        com_tencent_mm_plugin_recharge_ui_form_c_b.pEc.pEP = new 2(com_tencent_mm_plugin_recharge_ui_form_c_b);
        com_tencent_mm_plugin_recharge_ui_form_c_b.pEc.pEQ = this;
        com_tencent_mm_plugin_recharge_ui_form_c_b.hy(true);
        instantAutoCompleteTextView.pEa = true;
        instantAutoCompleteTextView.setAdapter(com_tencent_mm_plugin_recharge_ui_form_c_b.pEc);
        instantAutoCompleteTextView.setOnItemClickListener(new 3(com_tencent_mm_plugin_recharge_ui_form_c_b, instantAutoCompleteTextView));
        com_tencent_mm_plugin_recharge_ui_form_c_b.pEb.setOnFocusChangeListener(new AnonymousClass4(com_tencent_mm_plugin_recharge_ui_form_c_b, instantAutoCompleteTextView));
        instantAutoCompleteTextView.setOnClickListener(new 5(com_tencent_mm_plugin_recharge_ui_form_c_b, instantAutoCompleteTextView));
        this.pCT = (GridView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uvf);
        this.pCV = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uvl);
        this.pCW = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uvm);
        this.pCX = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uuR);
        this.pCY = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uvd);
        this.pCR = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uvh);
        this.pCS = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uvj);
        this.pCU = (GridView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uuT);
        this.pCZ = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uvg);
        this.pDa = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uvi);
        this.pCQ.pEk = new 12(this);
        this.pCQ.pEi.setOnClickListener(new 14(this));
        this.pDb = new b();
        this.pDb.pCJ = new 15(this);
        this.pDc = new b();
        this.pDc.pCJ = new 16(this);
        this.pCT.setAdapter(this.pDb);
        this.pCU.setAdapter(this.pDc);
        this.pCO.setOnClickListener(new 17(this));
        this.pCP.setOnClickListener(new 18(this));
        this.pCQ.bmI();
        int eA = (com.tencent.mm.bv.a.eA(this) / 4) - 20;
        x.i("MicroMsg.PhoneRechargeUI", "max width: %s", new Object[]{Integer.valueOf(eA)});
        this.pCV.setMaxWidth(eA);
        this.pCW.setMaxWidth(eA);
        this.pCX.setMaxWidth(eA);
        this.pCY.setMaxWidth(eA);
        this.pDf = getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btv);
        if (!(this.pDi.pCu == null || bh.ov(this.pDi.pCu.name))) {
            this.desc = this.pDi.pCu.name;
        }
        this.pCQ.pEh.setHintTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.ubk));
        if (bh.ov(this.pCQ.getText())) {
            n(new f(""));
        } else {
            n(new f(this.pCQ.getText()));
        }
    }

    private String If(String str) {
        String str2;
        try {
            str2 = "";
            if (!(this.pDi == null || this.pDi.pCu == null || bh.ov(this.pDi.pCu.name))) {
                str2 = this.pDi.pCu.name;
            }
            if (str2.equals(getString(i.uVT))) {
                str2 = "WeChatAccountBindNumber";
            }
            CharSequence text = this.pCQ.getText();
            CharSequence encode = URLEncoder.encode(URLEncoder.encode(str2, ProtocolPackage.ServerEncoding), ProtocolPackage.ServerEncoding);
            if (str.startsWith("http://") || str.startsWith("https://")) {
                x.i("MicroMsg.PhoneRechargeUI", "new url");
                if (str.indexOf("%7Bphone%7D") > 0) {
                    str = str.replace("%7Bphone%7D", text);
                } else {
                    str = str.replace("{phone}", text);
                }
                if (str.indexOf("%7Bremark%7D") > 0) {
                    return str.replace("%7Bremark%7D", encode);
                }
                return str.replace("{remark}", encode);
            }
            x.i("MicroMsg.PhoneRechargeUI", "old url");
            return URLDecoder.decode(str, ProtocolPackage.ServerEncoding) + String.format("?phone=%s&remark=%s", new Object[]{text, encode});
        } catch (Throwable e) {
            Throwable th = e;
            str2 = str;
            x.printErrStackTrace("MicroMsg.PhoneRechargeUI", th, "", new Object[0]);
            return str2;
        }
    }

    private void m(k kVar) {
        if (this.ilS != null && this.ilS.isShowing() && kVar.getType() != 497) {
            this.ilS.dismiss();
            this.ilS = null;
        }
    }

    private void n(final k kVar) {
        if (this.ilS == null || !(this.ilS == null || this.ilS.isShowing())) {
            this.ilS = com.tencent.mm.wallet_core.ui.g.a(this.mController.xIM, true, new OnCancelListener(this) {
                final /* synthetic */ PhoneRechargeUI pDm;

                public final void onCancel(DialogInterface dialogInterface) {
                    g.CG().c(kVar);
                }
            });
        }
        g.CG().a(kVar, 0);
    }

    protected void onResume() {
        super.onResume();
        w(false, true);
    }

    protected void onDestroy() {
        super.onDestroy();
        g.CG().b(1571, this);
        g.CG().b(498, this);
        com.tencent.mm.sdk.b.a.xef.c(this.pfJ);
    }

    private void w(boolean z, boolean z2) {
        boolean z3;
        Iterator it;
        TextView textView;
        CharSequence string;
        MallFunction mallFunction;
        final String str;
        if (this.pDj != null) {
            if (this.pDj != null) {
                String str2 = (String) g.Dj().CU().get(w.a.xnU, "");
                if (bh.ov(str2)) {
                    x.i("MicroMsg.PhoneRechargeUI", "hy: no banner before, show");
                    z3 = false;
                } else {
                    String[] split = str2.split(";");
                    if (split != null) {
                        for (String str3 : split) {
                            if (str3 != null && str3.equals(String.valueOf(this.pDj.id))) {
                                x.i("MicroMsg.PhoneRechargeUI", "hy: found closed. ");
                                z3 = true;
                                break;
                            }
                        }
                    }
                    x.i("MicroMsg.PhoneRechargeUI", "hy: not found closed banner.");
                    z3 = false;
                }
            } else {
                x.e("MicroMsg.PhoneRechargeUI", "hy: no banner");
                z3 = true;
            }
            if (!z3) {
                this.pCN.setVisibility(0);
                this.pCP.setText(this.pDj.name);
                x.d("MicroMsg.PhoneRechargeUI", "hy: Show banner!");
                com.tencent.mm.protocal.f.eB(6, 0);
                this.pDb.pCI = this.pCd;
                this.pDb.notifyDataSetChanged();
                this.pDc.pCI = this.pCe;
                this.pDc.notifyDataSetChanged();
                if (z) {
                    this.pCZ.setVisibility(8);
                } else {
                    it = this.pCd.iterator();
                    while (it.hasNext()) {
                        if (((n) it.next()).status != 0) {
                            z3 = false;
                            break;
                        }
                    }
                    z3 = true;
                    if (z3) {
                        this.pCZ.setVisibility(8);
                    } else {
                        this.pCZ.setVisibility(0);
                    }
                    it = this.pCe.iterator();
                    while (it.hasNext()) {
                        if (((n) it.next()).status != 0) {
                            z3 = false;
                            break;
                        }
                    }
                    z3 = true;
                    if (z3) {
                        this.pDa.setVisibility(0);
                        if (z2) {
                            addTextOptionMenu(0, this.pCj.name, new 2(this));
                        }
                        textView = this.pCR;
                        string = (this.pCd != null || this.pCd.size() <= 0 || bh.ov(((n) this.pCd.get(0)).sDM)) ? getString(i.uVO) : ((n) this.pCd.get(0)).sDM;
                        textView.setText(string);
                        textView = this.pCS;
                        string = (this.pCe != null || this.pCe.size() <= 0 || bh.ov(((n) this.pCe.get(0)).sDM)) ? getString(i.uVP) : ((n) this.pCe.get(0)).sDM;
                        textView.setText(string);
                        if (this.pCi != null || bh.ov(this.pCi.name) || bh.ov(this.pCi.url)) {
                            this.pCW.setVisibility(8);
                        } else {
                            this.pCW.setVisibility(0);
                            this.pCW.setText(this.pCi.name);
                            this.pCW.setOnClickListener(new 3(this));
                        }
                        if (this.pCf != null || bh.ov(this.pCf.name) || bh.ov(this.pCf.url)) {
                            this.pCV.setVisibility(8);
                        } else {
                            this.pCV.setVisibility(0);
                            this.pCV.setText(this.pCf.name);
                            this.pCV.setOnClickListener(new 4(this));
                        }
                        if (this.pCg != null || bh.ov(this.pCg.name) || bh.ov(this.pCg.url)) {
                            this.pCX.setVisibility(8);
                        } else {
                            this.pCX.setVisibility(0);
                            this.pCX.setText(this.pCg.name);
                            this.pCX.setOnClickListener(new OnClickListener(this) {
                                final /* synthetic */ PhoneRechargeUI pDm;

                                {
                                    this.pDm = r1;
                                }

                                public final void onClick(View view) {
                                    x.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[]{this.pDm.If(this.pDm.pCg.url)});
                                    PhoneRechargeUI.d(this.pDm, r0);
                                }
                            });
                        }
                        if (this.pCh != null || bh.ov(this.pCh.name) || bh.ov(this.pCh.url)) {
                            this.pCY.setVisibility(8);
                        } else {
                            this.pCY.setVisibility(0);
                            this.pCY.setText(this.pCh.name);
                            this.pCY.setOnClickListener(new OnClickListener(this) {
                                final /* synthetic */ PhoneRechargeUI pDm;

                                {
                                    this.pDm = r1;
                                }

                                public final void onClick(View view) {
                                    x.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[]{this.pDm.If(this.pDm.pCh.url)});
                                    PhoneRechargeUI.d(this.pDm, r0);
                                }
                            });
                        }
                        mallFunction = this.pDd;
                        if (mallFunction.sQt == null && mallFunction.sQt.sOA == 1 && !bh.ov(mallFunction.sQt.sQJ)) {
                            g.Dk();
                            z3 = !((Boolean) g.Dj().CU().get(w.a.xrE, Boolean.valueOf(false))).booleanValue();
                        } else {
                            z3 = false;
                        }
                        if (!z3) {
                            g.Dk();
                            g.Dj().CU().a(w.a.xrE, Boolean.valueOf(true));
                            x.d("MicroMsg.PhoneRechargeUI", this.pDd.sQt.toString());
                            str = this.pDd.sQt.sQJ;
                            h.a(this.mController.xIM, getString(i.uVY), v.fv(this).inflate(com.tencent.mm.plugin.wxpay.a.g.uDX, null), getString(i.uVZ), getString(i.uVX), new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ PhoneRechargeUI pDm;

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    x.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[]{this.pDm.If(str)});
                                    PhoneRechargeUI.d(this.pDm, r0);
                                }
                            }, new 8(this));
                        }
                    }
                }
                this.pDa.setVisibility(8);
                if (z2) {
                    addTextOptionMenu(0, this.pCj.name, new 2(this));
                }
                textView = this.pCR;
                if (this.pCd != null) {
                }
                textView.setText(string);
                textView = this.pCS;
                if (this.pCe != null) {
                }
                textView.setText(string);
                if (this.pCi != null) {
                }
                this.pCW.setVisibility(8);
                if (this.pCf != null) {
                }
                this.pCV.setVisibility(8);
                if (this.pCg != null) {
                }
                this.pCX.setVisibility(8);
                if (this.pCh != null) {
                }
                this.pCY.setVisibility(8);
                mallFunction = this.pDd;
                if (mallFunction.sQt == null) {
                }
                z3 = false;
                if (!z3) {
                    g.Dk();
                    g.Dj().CU().a(w.a.xrE, Boolean.valueOf(true));
                    x.d("MicroMsg.PhoneRechargeUI", this.pDd.sQt.toString());
                    str = this.pDd.sQt.sQJ;
                    h.a(this.mController.xIM, getString(i.uVY), v.fv(this).inflate(com.tencent.mm.plugin.wxpay.a.g.uDX, null), getString(i.uVZ), getString(i.uVX), /* anonymous class already generated */, new 8(this));
                }
            }
        }
        this.pCN.setVisibility(8);
        x.d("MicroMsg.PhoneRechargeUI", "hy: dismiss banner!");
        this.pDb.pCI = this.pCd;
        this.pDb.notifyDataSetChanged();
        this.pDc.pCI = this.pCe;
        this.pDc.notifyDataSetChanged();
        if (z) {
            it = this.pCd.iterator();
            while (it.hasNext()) {
                if (((n) it.next()).status != 0) {
                    z3 = false;
                    break;
                }
            }
            z3 = true;
            if (z3) {
                this.pCZ.setVisibility(8);
            } else {
                this.pCZ.setVisibility(0);
            }
            it = this.pCe.iterator();
            while (it.hasNext()) {
                if (((n) it.next()).status != 0) {
                    z3 = false;
                    break;
                }
            }
            z3 = true;
            if (z3) {
                this.pDa.setVisibility(0);
                if (z2) {
                    addTextOptionMenu(0, this.pCj.name, new 2(this));
                }
                textView = this.pCR;
                if (this.pCd != null) {
                }
                textView.setText(string);
                textView = this.pCS;
                if (this.pCe != null) {
                }
                textView.setText(string);
                if (this.pCi != null) {
                }
                this.pCW.setVisibility(8);
                if (this.pCf != null) {
                }
                this.pCV.setVisibility(8);
                if (this.pCg != null) {
                }
                this.pCX.setVisibility(8);
                if (this.pCh != null) {
                }
                this.pCY.setVisibility(8);
                mallFunction = this.pDd;
                if (mallFunction.sQt == null) {
                }
                z3 = false;
                if (!z3) {
                    g.Dk();
                    g.Dj().CU().a(w.a.xrE, Boolean.valueOf(true));
                    x.d("MicroMsg.PhoneRechargeUI", this.pDd.sQt.toString());
                    str = this.pDd.sQt.sQJ;
                    h.a(this.mController.xIM, getString(i.uVY), v.fv(this).inflate(com.tencent.mm.plugin.wxpay.a.g.uDX, null), getString(i.uVZ), getString(i.uVX), /* anonymous class already generated */, new 8(this));
                }
            }
        }
        this.pCZ.setVisibility(8);
        this.pDa.setVisibility(8);
        if (z2) {
            addTextOptionMenu(0, this.pCj.name, new 2(this));
        }
        textView = this.pCR;
        if (this.pCd != null) {
        }
        textView.setText(string);
        textView = this.pCS;
        if (this.pCe != null) {
        }
        textView.setText(string);
        if (this.pCi != null) {
        }
        this.pCW.setVisibility(8);
        if (this.pCf != null) {
        }
        this.pCV.setVisibility(8);
        if (this.pCg != null) {
        }
        this.pCX.setVisibility(8);
        if (this.pCh != null) {
        }
        this.pCY.setVisibility(8);
        mallFunction = this.pDd;
        if (mallFunction.sQt == null) {
        }
        z3 = false;
        if (!z3) {
            g.Dk();
            g.Dj().CU().a(w.a.xrE, Boolean.valueOf(true));
            x.d("MicroMsg.PhoneRechargeUI", this.pDd.sQt.toString());
            str = this.pDd.sQt.sQJ;
            h.a(this.mController.xIM, getString(i.uVY), v.fv(this).inflate(com.tencent.mm.plugin.wxpay.a.g.uDX, null), getString(i.uVZ), getString(i.uVX), /* anonymous class already generated */, new 8(this));
        }
    }

    private void bmz() {
        this.pCd = new ArrayList();
        n nVar = new n();
        nVar.name = getString(i.uVE);
        nVar.status = 0;
        n nVar2 = new n();
        nVar2.name = getString(i.uVF);
        nVar2.status = 0;
        n nVar3 = new n();
        nVar3.name = getString(i.uVG);
        nVar3.status = 0;
        n nVar4 = new n();
        nVar4.name = getString(i.uVH);
        nVar4.status = 0;
        n nVar5 = new n();
        nVar5.name = getString(i.uVI);
        nVar5.status = 0;
        n nVar6 = new n();
        nVar6.name = getString(i.uVJ);
        nVar6.status = 0;
        this.pCd.add(nVar);
        this.pCd.add(nVar2);
        this.pCd.add(nVar3);
        this.pCd.add(nVar4);
        this.pCd.add(nVar5);
        this.pCd.add(nVar6);
        this.pCe = new ArrayList();
        nVar = new n();
        nVar.name = getString(i.uVK);
        nVar.status = 0;
        nVar2 = new n();
        nVar2.name = getString(i.uVL);
        nVar2.status = 0;
        nVar3 = new n();
        nVar3.name = getString(i.uVM);
        nVar3.status = 0;
        this.pCe.add(nVar);
        this.pCe.add(nVar2);
        this.pCe.add(nVar3);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uDv;
    }

    private void Ig(String str) {
        h.a((Context) this, str, "", false, new 9(this));
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof f) {
            f fVar = (f) kVar;
            if (fVar.cmdId != 0) {
                x.i("MicroMsg.PhoneRechargeUI", "do delete phone number");
            } else if (bh.ov(fVar.phQ) || fVar.phQ.equals(this.pCQ.getText())) {
                m(kVar);
                if (fVar.pCc) {
                    x.e("MicroMsg.PhoneRechargeUI", "hy: cgi failed.");
                    Ig(fVar.fnL);
                    bmy();
                    return;
                }
                boolean z;
                boolean z2;
                this.mAppId = fVar.appId;
                this.pCd = fVar.pCd;
                this.pCf = fVar.pCf;
                this.pCg = fVar.pCg;
                this.pCh = fVar.pCh;
                this.pCi = fVar.pCi;
                this.errCode = fVar.errCode;
                this.fnL = fVar.fnL;
                this.pDe = fVar.desc;
                x.i("MicroMsg.PhoneRechargeUI", "desc: %s, mobile: %s", new Object[]{this.pDe, this.pCQ.getText()});
                if (bh.ov(this.pDe)) {
                    this.desc = "";
                    this.pDf = getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.btv);
                } else if (this.pDi.pCu != null && this.pDi.pCu.pBH.trim().equals(this.pCQ.getText())) {
                    this.pDi.pCu.pBI = this.pDe;
                    this.pDi.b(this.pDi.pCu);
                }
                this.pDj = fVar.pCk;
                this.pCe = fVar.pCe;
                for (int size = this.pCe.size() - 1; size >= 0; size--) {
                    n nVar = (n) this.pCe.get(size);
                    if (nVar.name.isEmpty()) {
                        this.pCe.remove(nVar);
                    }
                }
                if (fVar.pCj == null || (fVar.pCj.name.equals(this.pCj.name) && fVar.pCj.url.equals(this.pCj.url))) {
                    z = false;
                } else {
                    x.i("MicroMsg.PhoneRechargeUI", "need to update head");
                    this.pCj = fVar.pCj;
                    z = true;
                }
                if (this.pDe.equals("")) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                w(z2, z);
                List list = fVar.pCl;
                if (list != null) {
                    x.d("MicroMsg.PhoneRechargeUI", "update record history");
                    com.tencent.mm.plugin.recharge.a.a.bmr().bt(list);
                    if (this.pDi != null) {
                        if (fVar.pCm) {
                            this.pDi.hy(true);
                        } else {
                            this.pDi.hy(false);
                        }
                    }
                }
                this.pCQ.postDelayed(new 10(this), 300);
            } else {
                x.i("MicroMsg.PhoneRechargeUI", "hy: mobiel num not match.abourt, %s, %s", new Object[]{fVar.phQ, this.pCQ.getText()});
            }
        } else if (kVar instanceof com.tencent.mm.plugin.recharge.model.g) {
            m(kVar);
            if (i == 0 && i2 == 0) {
                PayInfo payInfo = ((com.tencent.mm.plugin.recharge.model.g) kVar).pCn;
                payInfo.fCV = 6;
                payInfo.vzu = 100;
                payInfo.kKe = this.pCQ.getText();
                payInfo.iIj = this.pDi.pCu != null ? this.pDi.pCu.name : "";
                com.tencent.mm.pluginsdk.wallet.h.a(this, payInfo, 2);
                com.tencent.mm.sdk.b.a.xef.b(this.pfJ);
                return;
            }
            Ig(str);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str = null;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    this.pDk = true;
                    List arrayList = new ArrayList();
                    Uri data = intent.getData();
                    if (data != null) {
                        if (com.tencent.mm.pluginsdk.g.a.aZ(this, "android.permission.READ_CONTACTS")) {
                            try {
                                Cursor query = getContentResolver().query(data, null, null, null, null);
                                if (query != null && query.getCount() > 0) {
                                    query.moveToFirst();
                                    int columnIndex = query.getColumnIndex("has_phone_number");
                                    if (columnIndex <= 0 || query.getInt(columnIndex) > 0) {
                                        String string = query.getString(query.getColumnIndex("_id"));
                                        Cursor query2 = getContentResolver().query(Phone.CONTENT_URI, null, "contact_id = " + string, null, null);
                                        if (query2 != null && query2.moveToFirst()) {
                                            String str2 = null;
                                            while (!query2.isAfterLast()) {
                                                columnIndex = query2.getColumnIndex("data1");
                                                int columnIndex2 = query2.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME);
                                                String string2 = query2.getString(columnIndex);
                                                str2 = query2.getString(columnIndex2);
                                                x.d("MicroMsg.PhoneRechargeUI", "hy: username : " + str2);
                                                if (string2 != null) {
                                                    x.d("MicroMsg.PhoneRechargeUI", "hy: phoneNumber : " + string2);
                                                    string = b.Id(string2);
                                                    x.d("MicroMsg.PhoneRechargeUI", "hy: phoneNumber : " + string);
                                                    if (PhoneNumberUtils.isGlobalPhoneNumber(string) && string.length() == 11) {
                                                        arrayList.add(string);
                                                    }
                                                    x.d("MicroMsg.PhoneRechargeUI", "hy: phoneResult : " + string);
                                                }
                                                query2.moveToNext();
                                            }
                                            str = str2;
                                        }
                                        if (query2 != null) {
                                            query2.close();
                                        }
                                    }
                                }
                                if (!(query == null || query.isClosed())) {
                                    query.close();
                                }
                                if (arrayList.size() <= 1) {
                                    if (arrayList.size() != 1) {
                                        h.b(this, getString(i.uLU), "", true);
                                        break;
                                    }
                                    this.pDi.b(new com.tencent.mm.plugin.recharge.model.a((String) arrayList.get(0), str, 1));
                                    bmA();
                                    break;
                                }
                                com.tencent.mm.ui.base.i a = h.a((Context) this, getString(i.uVW), arrayList, -1, new 11(this, arrayList, str));
                                if (a != null) {
                                    a.setCanceledOnTouchOutside(true);
                                    break;
                                }
                            } catch (SecurityException e) {
                                x.e("MicroMsg.PhoneRechargeUI", "hy: permission denied: %s", new Object[]{e.toString()});
                                h.b(this, getString(i.uLW), "", true);
                                break;
                            }
                        }
                        x.e("MicroMsg.PhoneRechargeUI", "no contact permission");
                        return;
                    }
                    x.e("MicroMsg.PhoneRechargeUI", "hy: uri == null");
                    return;
                }
                break;
            case 2:
                if (i2 == -1) {
                    if (!this.pfG) {
                        x.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : ok");
                        com.tencent.mm.plugin.recharge.a.a.bmr().a(new com.tencent.mm.plugin.recharge.model.a(this.pCQ.getText(), this.pCQ.pEj.getText().toString(), 0));
                        finish();
                        this.pfG = true;
                        break;
                    }
                }
                x.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : cancel");
                break;
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    private void bmA() {
        g.CG().a(new f(this.pCQ.getText()), 0);
    }

    public final void bmB() {
        g.CG().a(new f("", 1), 0);
    }
}
