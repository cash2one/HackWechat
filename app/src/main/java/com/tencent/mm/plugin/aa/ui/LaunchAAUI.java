package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.a.a;
import com.tencent.mm.plugin.aa.a.c.e;
import com.tencent.mm.plugin.aa.a.d;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.plugin.aa.a.k;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetSetting;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.ui.d.l;
import com.tencent.mm.protocal.c.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.z.m;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LaunchAAUI extends BaseAAPresenterActivity {
    private String chatroomName = null;
    private TextView ihU;
    private Dialog iib;
    private TextView ijA;
    private TextView ijB;
    private TextView ijC;
    private WalletFormView ijD;
    private TextView ijE;
    private TextView ijF;
    private ViewGroup ijG;
    private ViewGroup ijH;
    private List<String> ijI = new ArrayList();
    private ViewGroup ijJ;
    private ViewGroup ijK;
    private TextView ijL;
    private ViewGroup ijM;
    private Map<String, Double> ijN = new HashMap();
    private Map<String, LaunchAAByPersonNameAmountRow> ijO = new HashMap();
    private Button ijP;
    private TextView ijQ;
    private TextView ijR;
    private d ijS = new d();
    private int ijT = 0;
    private int ijU = 0;
    private boolean ijV = false;
    private boolean ijg = false;
    private e ijw = ((e) q(e.class));
    private boolean ijx = false;
    private MMEditText ijy;
    private TextView ijz;
    private int mode = a.ifI;
    private long timestamp = 0;

    static /* synthetic */ void a(LaunchAAUI launchAAUI) {
        String obj = launchAAUI.ijy.getText().toString();
        ((i) g.h(i.class)).a(launchAAUI.mController, launchAAUI.chatroomName, launchAAUI.getString(com.tencent.mm.plugin.wxpay.a.i.uGV) + (bh.ov(obj) ? launchAAUI.getString(com.tencent.mm.plugin.wxpay.a.i.uJB) : obj), launchAAUI.getString(com.tencent.mm.plugin.wxpay.a.i.uGU), new 8(launchAAUI));
    }

    static /* synthetic */ void a(LaunchAAUI launchAAUI, String str, String str2) {
        launchAAUI.ijR.setVisibility(0);
        launchAAUI.ijR.startAnimation(AnimationUtils.loadAnimation(launchAAUI, com.tencent.mm.plugin.wxpay.a.a.uao));
        launchAAUI.ijR.setText(str);
        launchAAUI.ijR.setOnClickListener(new 21(launchAAUI, str2));
    }

    static /* synthetic */ void a(LaunchAAUI launchAAUI, List list) {
        Intent intent = new Intent(launchAAUI, AASelectContactUI.class);
        intent.putExtra("titile", launchAAUI.getString(com.tencent.mm.plugin.wxpay.a.i.uJE));
        intent.putExtra("list_type", 12);
        intent.putExtra("chatroomName", launchAAUI.chatroomName);
        if (list != null) {
            intent.putExtra("already_select_contact", bh.d(list, ","));
        }
        intent.putExtra("max_select_num", s.eV(launchAAUI.chatroomName) ? (long) Math.min(d.WF(), m.gl(launchAAUI.chatroomName)) : (long) Math.min(d.WF(), 2));
        intent.putExtra("select_type", 1);
        launchAAUI.startActivityForResult(intent, 233);
        com.tencent.mm.plugin.report.service.g.pQN.h(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(2)});
    }

    static /* synthetic */ void e(LaunchAAUI launchAAUI) {
        x.i("MicroMsg.LaunchAAUI", "switchMode");
        launchAAUI.ijx = false;
        if (launchAAUI.mode == a.ifI) {
            launchAAUI.mode = a.ifJ;
            launchAAUI.ijG.setVisibility(8);
            launchAAUI.ijH.setVisibility(8);
            launchAAUI.ijJ.setVisibility(0);
            launchAAUI.ijz.setText(launchAAUI.getString(com.tencent.mm.plugin.wxpay.a.i.uJy, new Object[]{Integer.valueOf(0)}));
            if (launchAAUI.ijN != null && launchAAUI.ijN.size() > d.WE()) {
                com.tencent.mm.plugin.report.service.g.pQN.h(13722, new Object[]{Integer.valueOf(8)});
                launchAAUI.ijx = true;
            }
            if (launchAAUI.ijx) {
                launchAAUI.oF(launchAAUI.getString(com.tencent.mm.plugin.wxpay.a.i.uJv, new Object[]{Integer.valueOf(d.WE())}));
            } else {
                launchAAUI.Xf();
            }
            com.tencent.mm.plugin.report.service.g.pQN.h(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(1)});
        } else {
            launchAAUI.mode = a.ifI;
            launchAAUI.ijG.setVisibility(0);
            launchAAUI.ijH.setVisibility(0);
            launchAAUI.ijJ.setVisibility(8);
            launchAAUI.ijz.setText(com.tencent.mm.plugin.wxpay.a.i.uJr);
            launchAAUI.ijx = false;
            if (launchAAUI.ijI.size() > d.WF()) {
                com.tencent.mm.plugin.report.service.g.pQN.h(13722, new Object[]{Integer.valueOf(8)});
                launchAAUI.ijx = true;
            }
            launchAAUI.Xj();
            com.tencent.mm.plugin.report.service.g.pQN.h(13721, new Object[]{Integer.valueOf(3), Integer.valueOf(1)});
        }
        launchAAUI.Xa();
        launchAAUI.aWs();
        launchAAUI.Xe();
        launchAAUI.Xh();
        launchAAUI.Xg();
        launchAAUI.ijC.post(new Runnable(launchAAUI) {
            final /* synthetic */ LaunchAAUI ijW;

            {
                this.ijW = r1;
            }

            public final void run() {
            }
        });
    }

    static /* synthetic */ void i(LaunchAAUI launchAAUI) {
        Intent intent = new Intent(launchAAUI, LaunchAAByPersonAmountSelectUI.class);
        intent.putExtra("chatroom", launchAAUI.chatroomName);
        intent.putExtra("maxPerAmount", d.WG());
        if (launchAAUI.ijN != null && launchAAUI.ijN.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : launchAAUI.ijN.keySet()) {
                arrayList.add(str + "," + ((Double) launchAAUI.ijN.get(str)).doubleValue());
            }
            intent.putStringArrayListExtra("oldAmountData", arrayList);
        }
        intent.putExtra("maxUserNumber", d.WE());
        launchAAUI.startActivityForResult(intent, JsApiGetSetting.CTRL_INDEX);
        com.tencent.mm.plugin.report.service.g.pQN.h(13721, new Object[]{Integer.valueOf(3), Integer.valueOf(2)});
    }

    static /* synthetic */ void j(LaunchAAUI launchAAUI) {
        if (launchAAUI.mode != a.ifI) {
            launchAAUI.Xf();
            launchAAUI.Xi();
        } else if (!bh.ov(launchAAUI.ijD.getText()) && launchAAUI.ijI != null && launchAAUI.ijI.size() != 0) {
            launchAAUI.Xf();
            com.tencent.mm.plugin.report.service.g.pQN.h(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(3)});
            Map hashMap = new HashMap();
            try {
                Object string;
                String obj = launchAAUI.ijy.getText().toString();
                if (bh.ov(obj)) {
                    string = launchAAUI.getString(com.tencent.mm.plugin.wxpay.a.i.uJB);
                } else {
                    String str = obj;
                }
                double d = bh.getDouble(launchAAUI.ijD.getText(), 0.0d);
                hashMap.put(k.igD, string);
                hashMap.put(k.igE, Double.valueOf(100.0d * d));
                hashMap.put(k.igH, launchAAUI.chatroomName);
                hashMap.put(k.igK, Long.valueOf(launchAAUI.timestamp));
                if ((launchAAUI.ijI != null ? launchAAUI.ijI.size() : 0) > 0) {
                    long aE = h.aE(launchAAUI.ihU.getText(), "100");
                    x.d("MicroMsg.LaunchAAUI", "perAmount: %s", new Object[]{Long.valueOf(aE)});
                    if (aE <= 0 || aE > d.WG()) {
                        x.i("MicroMsg.LaunchAAUI", "illegal avgAmount: %s", new Object[]{Long.valueOf(aE)});
                        return;
                    }
                    hashMap.put(k.igG, Long.valueOf(aE));
                    hashMap.put(k.igJ, launchAAUI.ijI);
                    launchAAUI.iib = com.tencent.mm.wallet_core.ui.g.a(launchAAUI, false, null);
                    com.tencent.mm.vending.g.g.t(Integer.valueOf(launchAAUI.mode), hashMap).b(launchAAUI.ijw.ihw).e(new 10(launchAAUI)).a(new 9(launchAAUI));
                }
                com.tencent.mm.plugin.report.service.g.pQN.h(13723, new Object[]{Integer.valueOf(1), h.oA(launchAAUI.chatroomName), Integer.valueOf(r0), Double.valueOf(d * 100.0d), string});
            } catch (Exception e) {
                x.e("MicroMsg.LaunchAAUI", "launchAAByMoney mode: %s error: %s", new Object[]{Integer.valueOf(launchAAUI.mode), e.getMessage()});
            }
        }
    }

    static /* synthetic */ void l(LaunchAAUI launchAAUI) {
        if (launchAAUI.getIntent().getIntExtra("enter_scene", 1) == 3) {
            launchAAUI.setResult(-1);
            launchAAUI.finish();
            return;
        }
        Intent intent = new Intent();
        intent.setFlags(67108864);
        intent.putExtra("key_should_finish", true);
        com.tencent.mm.bm.d.b(launchAAUI.mController.xIM, "offline", ".ui.WalletOfflineCoinPurseUI", intent);
    }

    public void onCreate(Bundle bundle) {
        List F;
        CharSequence spannableString;
        super.onCreate(bundle);
        x.i("MicroMsg.LaunchAAUI", "LaunchAAUI onCreate");
        setBackBtn(new 1(this));
        this.timestamp = System.currentTimeMillis() / 1000;
        setMMTitle(com.tencent.mm.plugin.wxpay.a.i.uJG);
        com.tencent.mm.vending.g.g.czW().b(this.ijw.ihy).e(new 20(this)).a(new 19(this));
        this.chatroomName = getIntent().getStringExtra("chatroom_name");
        if (bh.ov(this.chatroomName)) {
            x.e("MicroMsg.LaunchAAUI", "chatroomName is null!!!");
            this.chatroomName = "";
        }
        String str = this.chatroomName;
        if (!bh.ov(str)) {
            if (!s.eV(str)) {
                F = bh.F(str.split(","));
                if (F != null) {
                    F.remove(q.FS());
                    if (F.size() > 0) {
                        str = (String) F.get(0);
                    }
                }
            }
            this.chatroomName = str;
            this.iiH = findViewById(f.cIw);
            this.iiH.setOnTouchListener(new 12(this));
            this.ijB = (TextView) findViewById(f.ulD);
            this.ijB.setClickable(true);
            this.ijB.setOnTouchListener(new l(this));
            Xe();
            this.ijP = (Button) findViewById(f.ulw);
            this.ijP.setOnClickListener(new 15(this));
            this.ijQ = (TextView) findViewById(f.ult);
            this.ijR = (TextView) findViewById(f.ulH);
            this.ijy = (MMEditText) findViewById(f.ulE);
            this.ijz = (TextView) findViewById(f.ulG);
            this.ihU = (TextView) findViewById(f.ulu);
            this.ijA = (TextView) findViewById(f.ulv);
            this.ijz.setText(com.tencent.mm.plugin.wxpay.a.i.uJr);
            this.mode = a.ifI;
            this.ijC = (TextView) findViewById(f.uea);
            this.ijC.setClickable(true);
            this.ijC.setOnTouchListener(new l());
            spannableString = new SpannableString(getString(com.tencent.mm.plugin.wxpay.a.i.uIe));
            spannableString.setSpan(new a(new 16(this)), 0, spannableString.length(), 18);
            this.ijC.setText(spannableString);
            this.ijC.setVisibility(8);
            this.ijy.addTextChangedListener(new 17(this));
            this.ijD = (WalletFormView) findViewById(f.ulF);
            this.ijD.a(new 5(this));
            a(this.ijD, 2, false, false);
            this.ijF = (TextView) findViewById(f.ulx);
            this.ijE = (TextView) findViewById(f.uly);
            if (s.eV(this.chatroomName)) {
                x.i("MicroMsg.LaunchAAUI", "is single chat: %s", new Object[]{this.chatroomName});
                F = new ArrayList();
                F.add(q.FS());
                F.add(this.chatroomName);
            } else {
                F = h.oA(this.chatroomName);
            }
            this.ijI = F;
            if (this.ijI.size() > d.WF()) {
                this.ijI.clear();
                this.ijF.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uMk));
                Xg();
            } else if (s.eV(this.chatroomName)) {
                this.ijF.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uJs, new Object[]{Integer.valueOf(F.size())}));
            } else {
                this.ijF.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uJo, new Object[]{Integer.valueOf(F.size())}));
            }
            this.ijF.setOnClickListener(new 6(this, F));
            this.ijG = (ViewGroup) findViewById(f.ulK);
            this.ijH = (ViewGroup) findViewById(f.ulJ);
            this.ijD.requestFocus();
            this.ijx = false;
            this.ijL = (TextView) findViewById(f.ulC);
            this.ijL.setText(com.tencent.mm.plugin.wxpay.a.i.uJz);
            this.ijL.setTextColor(getResources().getColor(c.uaC));
            this.ijJ = (ViewGroup) findViewById(f.ulL);
            this.ijK = (ViewGroup) findViewById(f.ulM);
            this.ijM = (ViewGroup) findViewById(f.ulB);
            this.ijM.setOnClickListener(new 7(this));
            ci(false);
            com.tencent.mm.plugin.report.service.g.pQN.h(13721, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
            this.ijC.post(new 18(this));
        }
        str = "";
        this.chatroomName = str;
        this.iiH = findViewById(f.cIw);
        this.iiH.setOnTouchListener(new 12(this));
        this.ijB = (TextView) findViewById(f.ulD);
        this.ijB.setClickable(true);
        this.ijB.setOnTouchListener(new l(this));
        Xe();
        this.ijP = (Button) findViewById(f.ulw);
        this.ijP.setOnClickListener(new 15(this));
        this.ijQ = (TextView) findViewById(f.ult);
        this.ijR = (TextView) findViewById(f.ulH);
        this.ijy = (MMEditText) findViewById(f.ulE);
        this.ijz = (TextView) findViewById(f.ulG);
        this.ihU = (TextView) findViewById(f.ulu);
        this.ijA = (TextView) findViewById(f.ulv);
        this.ijz.setText(com.tencent.mm.plugin.wxpay.a.i.uJr);
        this.mode = a.ifI;
        this.ijC = (TextView) findViewById(f.uea);
        this.ijC.setClickable(true);
        this.ijC.setOnTouchListener(new l());
        spannableString = new SpannableString(getString(com.tencent.mm.plugin.wxpay.a.i.uIe));
        spannableString.setSpan(new a(new 16(this)), 0, spannableString.length(), 18);
        this.ijC.setText(spannableString);
        this.ijC.setVisibility(8);
        this.ijy.addTextChangedListener(new 17(this));
        this.ijD = (WalletFormView) findViewById(f.ulF);
        this.ijD.a(new 5(this));
        a(this.ijD, 2, false, false);
        this.ijF = (TextView) findViewById(f.ulx);
        this.ijE = (TextView) findViewById(f.uly);
        if (s.eV(this.chatroomName)) {
            x.i("MicroMsg.LaunchAAUI", "is single chat: %s", new Object[]{this.chatroomName});
            F = new ArrayList();
            F.add(q.FS());
            F.add(this.chatroomName);
        } else {
            F = h.oA(this.chatroomName);
        }
        this.ijI = F;
        if (this.ijI.size() > d.WF()) {
            this.ijI.clear();
            this.ijF.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uMk));
            Xg();
        } else if (s.eV(this.chatroomName)) {
            this.ijF.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uJs, new Object[]{Integer.valueOf(F.size())}));
        } else {
            this.ijF.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uJo, new Object[]{Integer.valueOf(F.size())}));
        }
        this.ijF.setOnClickListener(new 6(this, F));
        this.ijG = (ViewGroup) findViewById(f.ulK);
        this.ijH = (ViewGroup) findViewById(f.ulJ);
        this.ijD.requestFocus();
        this.ijx = false;
        this.ijL = (TextView) findViewById(f.ulC);
        this.ijL.setText(com.tencent.mm.plugin.wxpay.a.i.uJz);
        this.ijL.setTextColor(getResources().getColor(c.uaC));
        this.ijJ = (ViewGroup) findViewById(f.ulL);
        this.ijK = (ViewGroup) findViewById(f.ulM);
        this.ijM = (ViewGroup) findViewById(f.ulB);
        this.ijM.setOnClickListener(new 7(this));
        ci(false);
        com.tencent.mm.plugin.report.service.g.pQN.h(13721, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
        this.ijC.post(new 18(this));
    }

    protected final boolean Xd() {
        return false;
    }

    private void Xe() {
        Object string;
        CharSequence string2;
        CharSequence spannableStringBuilder;
        if (this.mode == a.ifI) {
            string = getString(com.tencent.mm.plugin.wxpay.a.i.uJp);
            string2 = getString(com.tencent.mm.plugin.wxpay.a.i.uJq);
            spannableStringBuilder = new SpannableStringBuilder("");
            spannableStringBuilder.append(string);
            spannableStringBuilder.append(string2);
            spannableStringBuilder.setSpan(new a(new a.a(this) {
                final /* synthetic */ LaunchAAUI ijW;

                {
                    this.ijW = r1;
                }

                public final void WO() {
                    LaunchAAUI.e(this.ijW);
                }
            }), string.length(), spannableStringBuilder.length(), 18);
            this.ijB.setText(spannableStringBuilder);
        } else if (this.mode == a.ifJ) {
            string = getString(com.tencent.mm.plugin.wxpay.a.i.uJw);
            string2 = getString(com.tencent.mm.plugin.wxpay.a.i.uJx);
            spannableStringBuilder = new SpannableStringBuilder("");
            spannableStringBuilder.append(string);
            spannableStringBuilder.append(string2);
            spannableStringBuilder.setSpan(new a(new 3(this)), string.length(), spannableStringBuilder.length(), 18);
            this.ijB.setText(spannableStringBuilder);
        }
    }

    private void oF(String str) {
        this.ijV = true;
        this.ijQ.setVisibility(0);
        this.ijQ.startAnimation(AnimationUtils.loadAnimation(this, com.tencent.mm.plugin.wxpay.a.a.uao));
        this.ijQ.setText(str);
    }

    private void Xf() {
        this.ijV = false;
        if (this.ijQ.getVisibility() != 8) {
            this.ijQ.startAnimation(AnimationUtils.loadAnimation(this, com.tencent.mm.plugin.wxpay.a.a.uap));
            this.ijQ.setVisibility(8);
        }
    }

    private void Xg() {
        if (this.mode == a.ifI) {
            if (bh.ov(this.ijD.getText())) {
                ci(false);
                return;
            } else if (this.ijg) {
                ci(false);
                return;
            } else if (this.ijI == null || this.ijI.size() == 0) {
                ci(false);
                return;
            } else if (this.ijI.size() > d.WF() || this.ijx) {
                ci(false);
                return;
            } else {
                x.d("MicroMsg.LaunchAAUI", "b1: %s, b2: %s, avg: %s", new Object[]{this.ijD.getText(), Integer.valueOf(this.ijI.size()), Double.valueOf(h.b(this.ijD.getText(), this.ijI.size(), 5, 4))});
                if (h.b(this.ijD.getText(), this.ijI.size(), 5, 4) < 0.01d) {
                    x.i("MicroMsg.LaunchAAUI", "less than 0.01");
                    ci(false);
                    return;
                }
            }
        } else if (this.ijN == null || this.ijN.size() == 0) {
            ci(false);
            return;
        } else if (this.ijN.size() > d.WF() || this.ijx) {
            ci(false);
            return;
        }
        ci(true);
    }

    private void ci(boolean z) {
        this.ijP.setEnabled(z);
        if (z) {
            this.ijz.setTextColor(getResources().getColor(c.black));
            this.ihU.setTextColor(getResources().getColor(c.black));
            this.ijA.setTextColor(getResources().getColor(c.black));
            return;
        }
        this.ijz.setTextColor(getResources().getColor(c.uaD));
        this.ihU.setTextColor(getResources().getColor(c.uaD));
        this.ijA.setTextColor(getResources().getColor(c.uaD));
    }

    private void Xh() {
        if (this.mode == a.ifI) {
            if (this.ijI == null || this.ijI.size() <= 0) {
                this.ihU.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uGO));
            } else {
                double b = h.b(this.ijD.getText(), this.ijI.size(), 2, 2);
                this.ihU.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uGM, new Object[]{Double.valueOf(b)}));
            }
            this.ijz.setText(com.tencent.mm.plugin.wxpay.a.i.uJr);
        } else if (this.ijN == null || this.ijN.size() == 0) {
            this.ijz.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uJy, new Object[]{Integer.valueOf(0)}));
            this.ihU.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uGO));
        } else {
            double d = 0.0d;
            for (Double doubleValue : this.ijN.values()) {
                d = doubleValue.doubleValue() + d;
            }
            this.ihU.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uGM, new Object[]{Double.valueOf(d)}));
            this.ijz.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uJy, new Object[]{Integer.valueOf(this.ijN.size())}));
        }
    }

    private void Xi() {
        com.tencent.mm.plugin.report.service.g.pQN.h(13721, new Object[]{Integer.valueOf(3), Integer.valueOf(3)});
        Map hashMap = new HashMap();
        try {
            Object string;
            String obj = this.ijy.getText().toString();
            if (bh.ov(obj)) {
                string = getString(com.tencent.mm.plugin.wxpay.a.i.uJB);
            } else {
                String str = obj;
            }
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            long j = 0;
            for (String obj2 : this.ijN.keySet()) {
                double doubleValue = ((Double) this.ijN.get(obj2)).doubleValue();
                j jVar = new j();
                jVar.fLR = (long) (doubleValue * 100.0d);
                jVar.username = obj2;
                arrayList.add(jVar);
                long j2 = jVar.fLR + j;
                arrayList2.add(jVar.fLR);
                j = j2;
            }
            j jVar2 = new j();
            jVar2.username = q.FS();
            jVar2.fLR = j;
            hashMap.put(k.igD, string);
            hashMap.put(k.igE, Long.valueOf(j));
            hashMap.put(k.igJ, arrayList);
            hashMap.put(k.igH, this.chatroomName);
            hashMap.put(k.igK, Long.valueOf(this.timestamp));
            if (this.iib != null) {
                this.iib.dismiss();
            }
            this.iib = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
            com.tencent.mm.vending.g.g.cp(hashMap).b(this.ijw.ihx).e(new 13(this)).a(new 11(this));
            com.tencent.mm.plugin.report.service.g.pQN.h(13723, new Object[]{Integer.valueOf(2), Integer.valueOf(h.oA(this.chatroomName).size()), Integer.valueOf(arrayList.size() + 1), Long.valueOf(j), string, bh.d(arrayList2, ",")});
        } catch (Exception e) {
            x.e("MicroMsg.LaunchAAUI", "launchAAByPerson error: %s", new Object[]{e.getMessage()});
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uCg;
    }

    protected void onStop() {
        super.onStop();
        if (this.ijO != null) {
            this.ijO.clear();
        }
    }

    private void Xj() {
        if (!this.ijx || this.ijV) {
            if (this.ijg && !this.ijV) {
                oF(getString(com.tencent.mm.plugin.wxpay.a.i.uJD, new Object[]{Float.valueOf(((float) d.WG()) / 100.0f)}));
            } else if (!this.ijx && !this.ijg) {
                Xf();
            }
        } else if (this.mode == a.ifI) {
            oF(getString(com.tencent.mm.plugin.wxpay.a.i.uJv, new Object[]{Integer.valueOf(d.WF())}));
        } else {
            oF(getString(com.tencent.mm.plugin.wxpay.a.i.uJv, new Object[]{Integer.valueOf(d.WE())}));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        String stringExtra;
        String[] split;
        int i3;
        if (i == 233) {
            if (i2 == -1) {
                stringExtra = intent.getStringExtra("Select_Contact");
                if (this.mode == a.ifI) {
                    if (!bh.ov(stringExtra)) {
                        split = stringExtra.split(",");
                        this.ijI.clear();
                        this.ijI.addAll(Arrays.asList(split));
                    }
                    List oA = h.oA(this.chatroomName);
                    TextView textView;
                    Object[] objArr;
                    if (oA == null || this.ijI == null || this.ijI.size() != oA.size() || !s.eV(this.chatroomName)) {
                        textView = this.ijF;
                        i3 = com.tencent.mm.plugin.wxpay.a.i.uJs;
                        objArr = new Object[1];
                        objArr[0] = Integer.valueOf(this.ijI != null ? this.ijI.size() : 0);
                        textView.setText(getString(i3, objArr));
                    } else {
                        textView = this.ijF;
                        i3 = com.tencent.mm.plugin.wxpay.a.i.uJo;
                        objArr = new Object[1];
                        objArr[0] = Integer.valueOf(this.ijI != null ? this.ijI.size() : 0);
                        textView.setText(getString(i3, objArr));
                    }
                }
                Xf();
                if (this.ijI == null || this.ijI.size() <= d.WF()) {
                    this.ijx = false;
                } else {
                    this.ijx = true;
                }
                double d = bh.getDouble(this.ijD.getText(), 0.0d);
                if (this.ijI == null || (d * 100.0d) / ((double) this.ijI.size()) <= ((double) d.WG())) {
                    this.ijg = false;
                } else {
                    this.ijg = true;
                    com.tencent.mm.plugin.report.service.g.pQN.h(13722, new Object[]{Integer.valueOf(2)});
                }
                Xg();
                Xh();
                Xj();
            }
        } else if (i == JsApiGetSetting.CTRL_INDEX && i2 == -1) {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("selectUI");
            this.ijN.clear();
            if (stringArrayListExtra != null) {
                try {
                    if (stringArrayListExtra.size() > 0) {
                        Iterator it = stringArrayListExtra.iterator();
                        while (it.hasNext()) {
                            split = ((String) it.next()).split(",");
                            this.ijN.put(split[0], Double.valueOf(bh.getDouble(split[1], 0.0d)));
                        }
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.LaunchAAUI", "onActivityResult, SELECT_AMOUNT_SELECT_REQUEST_CODE error: %s", new Object[]{e.getMessage()});
                    return;
                }
            }
            int dimension;
            if (this.ijN == null || this.ijN.size() <= 0) {
                this.ijL.setText(com.tencent.mm.plugin.wxpay.a.i.uJz);
                this.ijL.setTextColor(getResources().getColor(c.uaC));
                dimension = (int) getResources().getDimension(com.tencent.mm.plugin.wxpay.a.d.ubN);
                this.ijM.setPadding(dimension, dimension, dimension, dimension);
                this.ijM.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.ucH);
                this.ijK.setVisibility(8);
            } else {
                this.ijL.setText(getString(com.tencent.mm.plugin.wxpay.a.i.uJA, new Object[]{Integer.valueOf(this.ijN.size())}));
                this.ijL.setTextColor(getResources().getColor(c.black));
                dimension = (int) getResources().getDimension(com.tencent.mm.plugin.wxpay.a.d.ubN);
                this.ijM.setPadding(dimension, (int) getResources().getDimension(com.tencent.mm.plugin.wxpay.a.d.ubL), dimension, (int) getResources().getDimension(com.tencent.mm.plugin.wxpay.a.d.ubM));
                this.ijM.setBackgroundResource(com.tencent.mm.plugin.wxpay.a.e.ucG);
                this.ijK.setVisibility(0);
            }
            this.ijK.removeAllViews();
            this.ijO.clear();
            if (this.ijN != null && this.ijN.size() > 0) {
                i3 = 0;
                for (String stringExtra2 : this.ijN.keySet()) {
                    double doubleValue = ((Double) this.ijN.get(stringExtra2)).doubleValue();
                    View launchAAByPersonNameAmountRow = new LaunchAAByPersonNameAmountRow(this);
                    if (i3 >= this.ijN.size() - 1) {
                        launchAAByPersonNameAmountRow.iiS.setVisibility(8);
                    }
                    launchAAByPersonNameAmountRow.iiQ.setText(com.tencent.mm.pluginsdk.ui.d.i.b(launchAAByPersonNameAmountRow.getContext(), ((b) g.h(b.class)).L(stringExtra2, this.chatroomName), launchAAByPersonNameAmountRow.iiQ.getTextSize()));
                    launchAAByPersonNameAmountRow.ihU.setText(launchAAByPersonNameAmountRow.getContext().getString(com.tencent.mm.plugin.wxpay.a.i.uGM, new Object[]{Double.valueOf(doubleValue)}));
                    this.ijK.addView(launchAAByPersonNameAmountRow);
                    this.ijO.put(stringExtra2, launchAAByPersonNameAmountRow);
                    i3++;
                }
            }
            if (this.iiH != null) {
                this.iiH.requestLayout();
            }
            this.ijU = 0;
            this.ijC.post(new 14(this));
            Xh();
            Xg();
        }
    }
}
