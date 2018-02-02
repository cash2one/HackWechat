package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.remittance.model.BusiRemittanceResp;
import com.tencent.mm.plugin.remittance.model.c;
import com.tencent.mm.plugin.remittance.model.g;
import com.tencent.mm.plugin.remittance.model.r;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.protocal.c.io;
import com.tencent.mm.protocal.c.vu;
import com.tencent.mm.protocal.c.vv;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.2;
import com.tencent.mm.ui.widget.picker.b.3;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.z.ak;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RemittanceBusiUI extends WalletBaseUI {
    private String oWp;
    private int ofD;
    private ScrollView pJd;
    private int pLT;
    private String pMN;
    private String pMS;
    private String pMT;
    private String pMX;
    private LinearLayout pMf;
    private String pMo;
    private boolean pMr;
    private boolean pMu;
    private WalletFormView pNA;
    private Button pNB;
    private LinearLayout pNC;
    private LinearLayout pND;
    private TextView pNE;
    private View pNF;
    private TextView pNG;
    private String pNH;
    private double pNI;
    private String pNJ;
    private String pNK;
    private String pNL;
    private String pNM;
    private int pNN;
    private boolean pNO;
    private String pNP;
    private int pNQ;
    private int pNR;
    private String pNS;
    private a pNT = new a();
    private String pNU = "";
    private String pNV = "";
    boolean pNW = false;
    private double pNX = -1.0d;
    private boolean pNY = false;
    g pNZ = null;
    private BusiRemittanceResp pNb;
    private TextView pNr;
    private TextView pNs;
    private TextView pNt;
    private TextView pNu;
    private TextView pNv;
    private TextView pNw;
    private TextView pNx;
    private View pNy;
    private CdnImageView pNz;
    private a pOa;
    private a pOb;
    private Runnable pOc = new Runnable(this) {
        final /* synthetic */ RemittanceBusiUI pOd;

        {
            this.pOd = r1;
        }

        public final void run() {
            RemittanceBusiUI.D(this.pOd);
        }
    };

    static /* synthetic */ void A(RemittanceBusiUI remittanceBusiUI) {
        List list = null;
        if (remittanceBusiUI.pLT == 33) {
            if (remittanceBusiUI.pNb.pKh != null) {
                list = remittanceBusiUI.pNb.pKh.vON;
            }
        } else if (remittanceBusiUI.pNT.bnE()) {
            list = remittanceBusiUI.pNT.bnD();
            if (list.size() == 0) {
                x.i("MicroMsg.RemittanceBusiUI", "can not find favor %s", new Object[]{Integer.valueOf(list.size())});
                return;
            }
        } else {
            list = remittanceBusiUI.pNb.pKg;
        }
        remittanceBusiUI.pNI = remittanceBusiUI.bnS();
        if (((int) Math.round(remittanceBusiUI.pNI * 100.0d)) <= 0) {
            remittanceBusiUI.bB(list);
        } else if (!remittanceBusiUI.pNT.bnE()) {
            remittanceBusiUI.a(new 4(remittanceBusiUI), new 5(remittanceBusiUI), 0);
        } else if (remittanceBusiUI.pNZ == null) {
            remittanceBusiUI.bB(list);
        } else if (remittanceBusiUI.pNZ.pKr) {
            remittanceBusiUI.bB(list);
        } else {
            remittanceBusiUI.pNZ.pKp = new c(remittanceBusiUI) {
                final /* synthetic */ RemittanceBusiUI pOd;

                {
                    this.pOd = r1;
                }

                public final void bA(List<vv> list) {
                    this.pOd.bB(list);
                }
            };
        }
    }

    static /* synthetic */ void D(RemittanceBusiUI remittanceBusiUI) {
        boolean z = false;
        if (remittanceBusiUI.pNb == null) {
            x.e("MicroMsg.RemittanceBusiUI", "busi_resp is null");
            if (remittanceBusiUI.pNZ != null) {
                remittanceBusiUI.pNZ.pKt = true;
                return;
            }
            return;
        }
        remittanceBusiUI.pNI = remittanceBusiUI.bnS();
        x.i("MicroMsg.RemittanceBusiUI", "update updateBilling %s", new Object[]{Integer.valueOf((int) Math.round(remittanceBusiUI.pNI * 100.0d))});
        if (((int) Math.round(remittanceBusiUI.pNI * 100.0d)) <= 0) {
            remittanceBusiUI.pNZ.pKt = true;
            remittanceBusiUI.pNT.bnC();
            remittanceBusiUI.pNx.setTextColor(-7829368);
            remittanceBusiUI.pNx.setText(remittanceBusiUI.pNb.pKc);
            if (remittanceBusiUI.pNZ != null) {
                remittanceBusiUI.pNZ.pKt = true;
                return;
            }
            return;
        }
        remittanceBusiUI.pNx.setText(i.uMW);
        k kVar = remittanceBusiUI.pNZ;
        if (remittanceBusiUI.pNZ.pKp != null) {
            z = true;
        }
        remittanceBusiUI.b(kVar, z);
    }

    static /* synthetic */ void e(RemittanceBusiUI remittanceBusiUI) {
        x.i("MicroMsg.RemittanceBusiUI", "do cancel pay");
        remittanceBusiUI.b(new r(remittanceBusiUI.pNJ, remittanceBusiUI.pNH, remittanceBusiUI.pNM, remittanceBusiUI.pMo), false);
    }

    static /* synthetic */ void m(RemittanceBusiUI remittanceBusiUI) {
        if (bh.ov(remittanceBusiUI.pMT)) {
            remittanceBusiUI.pNv.setText("");
            remittanceBusiUI.pNw.setText(i.uvp);
            return;
        }
        remittanceBusiUI.pNv.setText(remittanceBusiUI.getString(i.uMY, new Object[]{remittanceBusiUI.pMT}));
        remittanceBusiUI.pNw.setText(i.uNM);
    }

    static /* synthetic */ void p(RemittanceBusiUI remittanceBusiUI) {
        x.i("MicroMsg.RemittanceBusiUI", "do place order");
        if (remittanceBusiUI.pNb == null) {
            x.e("MicroMsg.RemittanceBusiUI", "doPlaceOrder busi_resp is null");
            return;
        }
        if (!remittanceBusiUI.pNO) {
            remittanceBusiUI.Xa();
        }
        int round = (int) Math.round(remittanceBusiUI.pNI * 100.0d);
        io ioVar = remittanceBusiUI.pNT.pLJ;
        remittanceBusiUI.b(new com.tencent.mm.plugin.remittance.model.i(remittanceBusiUI.pMo, remittanceBusiUI.pNH, remittanceBusiUI.pLT, remittanceBusiUI.pNL, remittanceBusiUI.pMT, round, remittanceBusiUI.ofD, remittanceBusiUI.pNM, remittanceBusiUI.pNP, remittanceBusiUI.pNR, remittanceBusiUI.pNQ, remittanceBusiUI.pNJ, remittanceBusiUI.pNT.pLI, ioVar == null ? "" : ioVar.vOQ, remittanceBusiUI.pNb.pKd), true);
    }

    private double bnS() {
        if (this.pNO || this.pLT == 33) {
            return this.pNI;
        }
        this.pNI = bh.getDouble(this.pNA.getText(), 0.0d);
        return this.pNI;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.plugin.report.service.g.pQN.h(15235, new Object[]{Integer.valueOf(1)});
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.c.ubp)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(f.divider);
            if (findViewById != null) {
                findViewById.setBackgroundColor(getResources().getColor(a.c.bsL));
            }
            customView = customView.findViewById(16908308);
            if (customView != null && (customView instanceof TextView)) {
                ((TextView) customView).setTextColor(getResources().getColor(a.c.black));
            }
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(a.c.ubp));
        }
        if (d.fM(21)) {
            if (d.fM(23)) {
                getWindow().getDecorView().setSystemUiVisibility(8192);
            } else {
                getWindow().setStatusBarColor(Color.parseColor("#E5E5E5"));
            }
        }
        setBackBtn(new 12(this), h.dvO);
        ji(1633);
        ji(1241);
        ji(2677);
        ji(2504);
        ji(2702);
        setMMTitle(i.uMX);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ RemittanceBusiUI pOd;

            {
                this.pOd = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                RemittanceBusiUI.e(this.pOd);
                this.pOd.finish();
                return false;
            }
        });
        this.pLT = getIntent().getIntExtra("pay_scene", 31);
        this.pNH = getIntent().getStringExtra("scan_remittance_id");
        this.pNI = getIntent().getDoubleExtra("fee", 0.0d);
        this.pNJ = getIntent().getStringExtra("receiver_name");
        this.pNK = getIntent().getStringExtra("receiver_true_name");
        this.ofD = getIntent().getIntExtra("pay_channel", 0);
        this.pNL = getIntent().getStringExtra("desc");
        this.pNN = getIntent().getIntExtra("busi_type", 0);
        this.pMN = getIntent().getStringExtra("mch_name");
        this.pNP = getIntent().getStringExtra("mch_type");
        this.pNR = getIntent().getIntExtra("mch_time", 0);
        this.pNQ = getIntent().getIntExtra("get_pay_wifi", 0);
        this.pMo = getIntent().getStringExtra("rcvr_open_id");
        this.pNM = getIntent().getStringExtra("rcvr_ticket");
        this.pNS = getIntent().getStringExtra("receiver_tips");
        this.pNb = (BusiRemittanceResp) getIntent().getParcelableExtra("BusiRemittanceResp");
        if (this.pNb != null) {
            boolean z = this.pLT == 32 && (this.pNb.pKi == 1 || (this.pNb != null && this.pNb.pKg.size() > 0));
            this.pNW = z;
        }
        if (this.pNI > 0.0d) {
            this.pNO = true;
        } else {
            this.pNO = false;
        }
        if (this.pNN == 0) {
            x.w("MicroMsg.RemittanceBusiUI", "wrong busi type!");
            finish();
        }
        this.pOa = new a(this, 28, 28, 2.0f);
        this.pOb = new a(this, 50, 50, 8.0f);
        initView();
    }

    protected final void initView() {
        this.pJd = (ScrollView) findViewById(f.uwl);
        this.pNr = (TextView) findViewById(f.uvA);
        this.pNs = (TextView) findViewById(f.uvB);
        this.pNt = (TextView) findViewById(f.uvx);
        this.pNu = (TextView) findViewById(f.uvv);
        this.pNv = (TextView) findViewById(f.uvq);
        this.pNw = (TextView) findViewById(f.uvp);
        this.pNz = (CdnImageView) findViewById(f.uvy);
        this.pNA = (WalletFormView) findViewById(f.uvz);
        this.pNB = (Button) findViewById(f.uvC);
        this.pNC = (LinearLayout) findViewById(f.uvw);
        this.pMf = (LinearLayout) findViewById(f.uvs);
        this.pND = (LinearLayout) findViewById(f.uvr);
        this.pNx = (TextView) findViewById(f.ukr);
        this.pNy = findViewById(f.uvt);
        this.pNE = (TextView) findViewById(f.uvu);
        this.pNF = findViewById(f.ukA);
        this.pNG = (TextView) findViewById(f.ukz);
        if (this.pNO) {
            if (!bh.ov(this.pNL)) {
                this.pNt.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this, this.pNL, this.pNt.getTextSize()));
            }
            this.pNu.setText(e.t(this.pNI));
            this.pNC.setVisibility(0);
            this.pMf.setVisibility(8);
        } else {
            boolean z;
            if (this.pNb != null) {
                if (this.pNb.pKg.size() > 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (this.pNb.pKh != null && this.pNb.pKh.vON.size() > 0) {
                    z = false;
                }
            } else {
                z = true;
            }
            b(this.pNA, 2, false, z);
            this.pNA.a(new TextWatcher(this) {
                final /* synthetic */ RemittanceBusiUI pOd;

                {
                    this.pOd = r1;
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void afterTextChanged(Editable editable) {
                    if (editable.toString().startsWith(".")) {
                        editable.insert(0, "0");
                    }
                    String obj = editable.toString();
                    int indexOf = obj.indexOf(".");
                    int length = obj.length();
                    if (indexOf >= 0 && length - indexOf > 2) {
                        editable.delete(indexOf + 3, length);
                    }
                    if (this.pOd.pLT == 32) {
                        this.pOd.a(null, null, this.pOd.pNb == null ? 400 : this.pOd.pNb.pKk);
                    }
                }
            });
            this.pNC.setVisibility(8);
            this.pMf.setVisibility(0);
        }
        if (com.tencent.mm.kernel.g.Dh().Cy()) {
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.l.a WO = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().WO(this.pNJ);
            if (WO == null || ((int) WO.gJd) == 0) {
                ak.a.hfL.a(this.pNJ, "", new 16(this));
            }
        }
        bnP();
        this.pND.setOnClickListener(new 17(this));
        this.pNB.setOnClickListener(new 18(this));
        this.pJd.setOnTouchListener(new 19(this));
        this.ofE = new 20(this);
        if (!(this.pNb == null || this.pNb.pKh == null)) {
            this.pNT.pLJ = this.pNb.pKh;
            this.pNT.It(this.pNb.pKh.vOP);
        }
        if (bnT()) {
            com.tencent.mm.plugin.report.service.g.pQN.h(15235, new Object[]{Integer.valueOf(2)});
        }
    }

    private void bnP() {
        ag.y(new 21(this));
    }

    private boolean bnT() {
        if (this.pNy == null || this.pNb == null) {
            return false;
        }
        boolean z;
        x.i("MicroMsg.RemittanceBusiUI", "tryShowFavor ");
        if (this.pNb.pKh == null || this.pNb.pKh.vOO.size() <= 0) {
            z = false;
        } else {
            z = true;
        }
        if (this.pNb.pKg.size() > 0) {
            z = true;
        }
        if (this.pNT.bnD().size() > 0) {
            z = true;
        }
        if (z) {
            this.pNF.setVisibility(0);
            this.pOa.update();
            this.pNy.setVisibility(0);
            this.pNx.setText(this.pNb.pKc);
            this.pNx.setTextColor(-7829368);
            this.pNG.setText(e.t(bnS()));
            vu vuVar = this.pNT.pLI;
            if (vuVar != null) {
                this.pNx.setTextColor(-30434);
                this.pNx.setText(vuVar.pKc);
                this.pNG.setText(e.t(((double) vuVar.wfG) / 100.0d));
            } else {
                a aVar = this.pNT;
                CharSequence charSequence = aVar.pLJ == null ? "" : aVar.pLJ.vOR;
                if (!bh.ov(charSequence)) {
                    this.pNx.setTextColor(-7829368);
                    this.pNx.setText(charSequence);
                }
            }
            findViewById(f.uko).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ RemittanceBusiUI pOd;

                {
                    this.pOd = r1;
                }

                public final void onClick(View view) {
                    com.tencent.mm.plugin.report.service.g.pQN.h(15235, new Object[]{Integer.valueOf(3)});
                    RemittanceBusiUI.A(this.pOd);
                }
            });
            return true;
        }
        this.pNy.setVisibility(8);
        this.pOb.update();
        this.pNF.setVisibility(8);
        return false;
    }

    private void bB(final List<vv> list) {
        final b bVar = new b(this);
        ArrayList arrayList = new ArrayList();
        vu vuVar = this.pNT.pLI;
        HashSet hashSet = new HashSet();
        final HashSet hashSet2 = new HashSet();
        if (this.pNT.bnF() && vuVar != null) {
            Iterator it = vuVar.vON.iterator();
            while (it.hasNext()) {
                hashSet.add(Long.valueOf(((vv) it.next()).wfN));
            }
        }
        int i = 0;
        for (vv vvVar : list) {
            if (hashSet.contains(Long.valueOf(vvVar.wfN))) {
                arrayList.add(Integer.valueOf(i));
            }
            i++;
        }
        CharSequence string = getString(i.uNO);
        if (string != null && string.length() > 0) {
            bVar.zye.setVisibility(0);
            bVar.zyf.setText(string);
        }
        bVar.zyg = arrayList;
        bVar.rKC = new 6(this, list, hashSet2);
        bVar.rKD = new p.d(this) {
            final /* synthetic */ RemittanceBusiUI pOd;

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                if (!hashSet2.contains(Integer.valueOf(i)) && i < list.size()) {
                    boolean z;
                    int intValue;
                    com.tencent.mm.plugin.report.service.g.pQN.h(15235, new Object[]{Integer.valueOf(4)});
                    vv vvVar = (vv) list.get(i);
                    b bVar = bVar;
                    List<Integer> czw = bVar.zyh != null ? bVar.zyh.czw() : new ArrayList();
                    boolean contains = czw.contains(Integer.valueOf(i));
                    if (contains) {
                        z = false;
                    } else {
                        z = true;
                    }
                    List linkedList = new LinkedList();
                    for (Integer intValue2 : czw) {
                        intValue = intValue2.intValue();
                        if (intValue < list.size() && (z || i != intValue)) {
                            linkedList.add((vv) list.get(intValue));
                        }
                    }
                    if (z) {
                        linkedList.add(vvVar);
                    }
                    a B = this.pOd.pNT;
                    if (!z) {
                        vvVar = null;
                    }
                    B.a(linkedList, vvVar);
                    vu vuVar = this.pOd.pNT.pLI;
                    HashSet hashSet = new HashSet();
                    if (vuVar != null) {
                        Iterator it = vuVar.vON.iterator();
                        while (it.hasNext()) {
                            hashSet.add(Long.valueOf(((vv) it.next()).wfN));
                        }
                    }
                    HashMap hashMap = new HashMap();
                    intValue = 0;
                    for (vv vvVar2 : list) {
                        if (hashSet.contains(Long.valueOf(vvVar2.wfN))) {
                            hashMap.put(Integer.valueOf(intValue), Boolean.valueOf(true));
                        } else {
                            hashMap.put(Integer.valueOf(intValue), Boolean.valueOf(false));
                        }
                        if (intValue == i) {
                            hashMap.put(Integer.valueOf(intValue), Boolean.valueOf(contains));
                        }
                        intValue++;
                    }
                    b bVar2 = bVar;
                    if (bVar2.zyh != null) {
                        bVar2.zyh.zyk = hashMap;
                        bVar2.zyh.notifyDataSetChanged();
                    }
                }
            }
        };
        bVar.zyi = new 8(this);
        if (bVar.rKC != null) {
            bVar.rKC.a(bVar.rKE);
        }
        bVar.zyh = new b.a(bVar, bVar.mContext);
        bVar.zyh.czv();
        bVar.zyd.setAdapter(bVar.zyh);
        bVar.krY.setOnClickListener(new 2(bVar));
        bVar.krZ.setOnClickListener(new 3(bVar));
        if (bVar.yIe != null) {
            if (bVar.rKE != null && bVar.rKE.size() > 3) {
                LayoutParams layoutParams = (LayoutParams) bVar.lCk.getLayoutParams();
                layoutParams.height = bVar.yIf;
                bVar.lCk.setLayoutParams(layoutParams);
            }
            bVar.yIe.show();
        }
    }

    private void a(c cVar, com.tencent.mm.plugin.remittance.model.d dVar, int i) {
        if (this.pNW) {
            this.pNG.setText(e.t(bnS()));
            ag.K(this.pOc);
            this.pNI = bnS();
            long round = Math.round(this.pNI * 100.0d);
            if (round <= 0) {
                this.pNT.bnC();
                this.pNx.setTextColor(-7829368);
                this.pNx.setText(this.pNb.pKc);
                if (this.pNZ != null) {
                    this.pNZ.pKt = true;
                    return;
                }
                return;
            }
            this.pNZ = new g((int) round, this.ofD, this.pNb.pKd, this.pNL, this.pMN, this.pNb.pKe, this.pMo, this.pNJ, this.pNb.pKf, cVar == null ? 0 : 1, cVar, dVar);
            ag.h(this.pOc, (long) i);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        jj(1633);
        jj(1241);
        jj(2677);
        jj(2504);
        jj(2702);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.remittance.model.i) {
            com.tencent.mm.plugin.remittance.model.i iVar = (com.tencent.mm.plugin.remittance.model.i) kVar;
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.RemittanceBusiUI", "net error: %s", new Object[]{kVar});
            } else if (iVar.pKw.kLO == 0) {
                this.pMS = iVar.pKw.vHq;
                this.oWp = iVar.pKw.vHr;
                this.pMX = iVar.pKw.vHs;
                this.pNU = iVar.pKw.vPd;
                this.pNV = iVar.pKw.vPc;
                if (!a(iVar)) {
                    Iu(iVar.pKw.fwY);
                }
            } else {
                x.e("MicroMsg.RemittanceBusiUI", "place order response: %s, %s", new Object[]{Integer.valueOf(iVar.pKw.kLO), iVar.pKw.kLP});
                if (iVar.pKw.vPb == null || bh.ov(iVar.pKw.vPb.odw)) {
                    Toast.makeText(this, iVar.pKw.kLP, 1).show();
                } else {
                    a(iVar);
                }
                if (iVar.pKw.vPe == 1) {
                    a(null, null, 0);
                }
            }
        } else if (kVar instanceof com.tencent.mm.plugin.remittance.model.h) {
            x.i("MicroMsg.RemittanceBusiUI", "pay check callback");
            return true;
        } else if (kVar instanceof g) {
            x.i("MicroMsg.RemittanceBusiUI", "onSceneEnd %s errType %s errCode %s", new Object[]{kVar, Integer.valueOf(i), Integer.valueOf(i2)});
            g gVar = (g) kVar;
            if (!gVar.pKs.equals(this.pNZ.pKs) || gVar.pKt) {
                gVar.pKr = true;
                x.e("MicroMsg.RemittanceBusiUI", "ignore this getFavor new coming soon %s", new Object[]{Boolean.valueOf(gVar.pKt)});
                return true;
            }
            com.tencent.mm.plugin.remittance.model.d dVar;
            if (i != 0 || i2 != 0) {
                this.pNT.bnC();
                if (!(this.pNb == null || bh.ov(this.pNb.pKc))) {
                    this.pNx.setText(this.pNb.pKc);
                }
                this.pNx.setTextColor(-7829368);
                this.pNx.setText(getString(i.uMV));
                dVar = gVar.pKq;
                if (dVar != null) {
                    dVar.a(i, i2, gVar);
                }
            } else if (gVar.pKo.kLO == 0) {
                this.pNT.pLJ = gVar.pKo.pKh;
                this.pNT.It(gVar.pKo.pKh.vOP);
                bnT();
                c cVar = gVar.pKp;
                x.i("MicroMsg.RemittanceBusiUI", "GetFavorAfterAction %s", new Object[]{cVar});
                if (cVar != null) {
                    cVar.bA(this.pNT.bnD());
                }
            } else {
                this.pNT.bnC();
                this.pNx.setTextColor(-7829368);
                this.pNx.setText(gVar.pKo.kLP);
                dVar = gVar.pKq;
                if (dVar != null) {
                    dVar.a(i, i2, gVar);
                }
            }
            gVar.pKr = true;
            return true;
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.RemittanceBusiUI", "onActivityResult requestCode %s resultCode %s %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), intent});
        if (i == 1) {
            if (i2 == -1) {
                String stringExtra = intent.getStringExtra("key_trans_id");
                double doubleExtra = intent.getDoubleExtra("key_total_fee", -1.0d);
                x.i("MicroMsg.RemittanceBusiUI", "onActivityResult _transId: %s _totalFee: %s", new Object[]{stringExtra, Double.valueOf(doubleExtra)});
                if (bh.ov(this.oWp)) {
                    this.oWp = stringExtra;
                }
                if (doubleExtra >= 0.0d) {
                    this.pNX = doubleExtra;
                }
                x.i("MicroMsg.RemittanceBusiUI", "goto busi result");
                Intent intent2 = new Intent(this, RemittanceBusiResultUI.class);
                intent2.putExtra("key_pay_desc", this.pMT);
                intent2.putExtra("key_rcv_desc", this.pNL);
                if (this.pNb != null) {
                    intent2.putExtra("BusiRemittanceResp", this.pNb);
                }
                intent2.putExtra("key_mch_name", this.pMN);
                intent2.putExtra("key_rcver_name", this.pNJ);
                intent2.putExtra("key_rcver_true_name", this.pNK);
                if (this.pNX >= 0.0d) {
                    intent2.putExtra("key_money", this.pNX);
                } else {
                    intent2.putExtra("key_money", this.pNI);
                }
                intent2.putExtra("key_f2f_id", this.pMS);
                intent2.putExtra("key_trans_id", this.oWp);
                intent2.putExtra("key_check_sign", this.pMX);
                intent2.putExtra("key_rcvr_open_id", this.pMo);
                intent2.putExtra("key_channel", this.ofD);
                if (this.pNb != null) {
                    intent2.putExtra("key_succ_show_avatar_type", this.pNb.pKj);
                    intent2.putExtra("key_succ_show_avatar_show", this.pNb.pKa);
                    intent2.putExtra("key_succ_show_avatar_url", this.pNb.pKb);
                }
                if (this.pNb != null) {
                    intent2.putExtra("key_scan_sceen", this.pNb.pKd);
                }
                intent2.putExtra("key_succ_page_extend", this.pNV);
                vu vuVar = this.pNT.pLI;
                int round = (int) Math.round(this.pNI * 100.0d);
                cd cdVar = new cd();
                cdVar.fCR = this.ofD;
                cdVar.vHq = this.pMS;
                cdVar.vHr = this.oWp;
                cdVar.pKd = this.pNb.pKd;
                cdVar.scene = this.pLT;
                cdVar.vHs = this.pMX;
                cdVar.vHt = vuVar;
                cdVar.vHu = this.pNJ;
                cdVar.pLn = this.pMo;
                cdVar.vHv = round;
                try {
                    intent2.putExtra("AfterPlaceOrderCommReq", cdVar.toByteArray());
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.RemittanceBusiUI", e, "", new Object[0]);
                }
                startActivity(intent2);
                finish();
                x.i("MicroMsg.RemittanceBusiUI", "do pay check");
                int round2 = (int) Math.round(this.pNI * 100.0d);
                cd cdVar2 = new cd();
                cdVar2.fCR = this.ofD;
                cdVar2.vHq = this.pMS;
                cdVar2.vHr = this.oWp;
                cdVar2.pKd = this.pNb.pKd;
                cdVar2.scene = this.pLT;
                cdVar2.vHs = this.pMX;
                cdVar2.vHt = this.pNT.pLI;
                cdVar2.vHu = this.pNJ;
                cdVar2.pLn = this.pMo;
                cdVar2.vHv = round2;
                b(new com.tencent.mm.plugin.remittance.model.h(cdVar2, this.pNU), false);
            } else {
                x.i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor");
                bnU();
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    private void bnU() {
        vu vuVar = this.pNT.pLI;
        if (vuVar == null) {
            x.i("MicroMsg.RemittanceBusiUI", "do NetSceneBusiF2fUnlockFavor FavorComposeInfo is null");
            return;
        }
        int round = (int) Math.round(this.pNI * 100.0d);
        cd cdVar = new cd();
        cdVar.fCR = this.ofD;
        cdVar.vHq = this.pMS;
        cdVar.vHr = this.oWp;
        cdVar.pKd = this.pNb.pKd;
        cdVar.scene = this.pLT;
        cdVar.vHs = this.pMX;
        cdVar.vHt = vuVar;
        cdVar.vHu = this.pNJ;
        cdVar.pLn = this.pMo;
        cdVar.vHv = round;
        b(new com.tencent.mm.plugin.remittance.model.k(cdVar, this.pNU), false);
    }

    protected final int getLayoutId() {
        return a.g.uDZ;
    }

    private boolean a(final com.tencent.mm.plugin.remittance.model.i iVar) {
        boolean z;
        if (this.pMr) {
            z = false;
        } else if (bh.ov(iVar.pKw.vPa)) {
            z = false;
        } else {
            this.pMr = true;
            com.tencent.mm.ui.base.h.a(this, iVar.pKw.vPa, getString(i.dGt), getString(i.uMT), getString(i.dEn), new 10(this, iVar), new 11(this));
            z = true;
        }
        if (z) {
            return z;
        }
        if (iVar.pKw.vPb == null) {
            return false;
        }
        this.pMu = true;
        com.tencent.mm.ui.base.h.a(this, iVar.pKw.kLP, "", iVar.pKw.vPb.odx, iVar.pKw.vPb.odw, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ RemittanceBusiUI pOd;

            public final void onClick(DialogInterface dialogInterface, int i) {
                x.i("MicroMsg.RemittanceBusiUI", "goto h5: %s", new Object[]{iVar.pKw.vPb.liO});
                e.l(this.pOd.mController.xIM, iVar.pKw.vPb.liO, false);
            }
        }, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ RemittanceBusiUI pOd;

            {
                this.pOd = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        return true;
    }

    private void Iu(String str) {
        x.i("MicroMsg.RemittanceBusiUI", "do start pay");
        PayInfo payInfo = new PayInfo();
        payInfo.fuH = str;
        payInfo.fCV = this.pLT;
        if (this.ofD > 0) {
            payInfo.fCR = this.ofD;
        }
        Bundle bundle = new Bundle();
        bundle.putString("extinfo_key_1", this.pNJ);
        bundle.putString("extinfo_key_2", this.pNK);
        bundle.putString("extinfo_key_3", this.pNL);
        bundle.putString("extinfo_key_5", getIntent().getStringExtra("receiver_tips"));
        bundle.putString("extinfo_key_7", this.pMT);
        payInfo.vzx = bundle;
        payInfo.pLj = 1;
        com.tencent.mm.pluginsdk.wallet.h.a(this, false, "", payInfo, this.pNK, new Intent(), 1);
    }
}
