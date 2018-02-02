package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.ipcall.a.e.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aid;
import com.tencent.mm.protocal.c.bwo;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IPCallShareCouponUI extends MMActivity implements e {
    private String gAT = null;
    private String mTitle = null;
    private c nIB = new 1(this);
    private ProgressDialog nIK;
    private RelativeLayout nMB;
    private TextView nMC;
    private ImageView nMD;
    private RelativeLayout nME;
    private TextView nMF;
    private ImageView nMG;
    private LinearLayout nMH;
    private LinearLayout nMI;
    private LinearLayout nMJ;
    private LinearLayout nMK;
    private ImageView nML;
    private LinearLayout nMM;
    private ImageView nMN;
    private TextView nMO;
    private TextView nMP;
    private TextView nMQ;
    private ImageView nMR;
    private TextView nMS;
    private TextView nMT;
    private View nMU;
    private IPCallDynamicTextView nMV;
    private b nMW = new b();
    private LinkedList<bwo> nMX = null;
    private boolean nMY = false;
    private String nMg = null;
    private String nMh = null;
    private String nMi = null;
    private String nMj = null;
    private String nMk = null;
    private String nMl = null;
    private String nMm = null;
    private String nMn = null;

    static /* synthetic */ void d(IPCallShareCouponUI iPCallShareCouponUI) {
        b bVar = iPCallShareCouponUI.nMW;
        bVar.nFW++;
        g.pQN.a(257, 2, 1, true);
        String string = ac.getContext().getString(R.l.eqR);
        try {
            com.tencent.mm.kernel.g.Dh();
            int Cg = a.Cg();
            String encode = URLEncoder.encode(d.vAx, ProtocolPackage.ServerEncoding);
            String encode2 = URLEncoder.encode(bh.cgr(), ProtocolPackage.ServerEncoding);
            String encode3 = URLEncoder.encode(q.yE(), ProtocolPackage.ServerEncoding);
            String encode4 = URLEncoder.encode(d.vAs, ProtocolPackage.ServerEncoding);
            String encode5 = URLEncoder.encode(d.vAt, ProtocolPackage.ServerEncoding);
            String encode6 = URLEncoder.encode(d.vAu, ProtocolPackage.ServerEncoding);
            String encode7 = URLEncoder.encode(ar.CB(), ProtocolPackage.ServerEncoding);
            string = string + "&version=" + d.vAz + "&lang=" + w.eL(ac.getContext()) + ("&uin=" + Cg + "&deviceName=" + encode + "&timeZone=" + encode2 + "&imei=" + encode3 + "&deviceBrand=" + encode4 + "&deviceModel=" + encode5 + "&ostype=" + encode6 + "&clientSeqID=" + encode7 + "&signature=" + URLEncoder.encode(bh.fa(ac.getContext()), ProtocolPackage.ServerEncoding) + "&scene=0");
        } catch (UnsupportedEncodingException e) {
            x.e("MicroMsg.IPCallShareCouponUI", "[royle]UnsupportedEncodingException:%s", new Object[]{e.getMessage()});
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("showShare", false);
        com.tencent.mm.bm.d.b(iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    static /* synthetic */ void e(IPCallShareCouponUI iPCallShareCouponUI) {
        b bVar = iPCallShareCouponUI.nMW;
        bVar.nFX++;
        g.pQN.a(257, 3, 1, true);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", iPCallShareCouponUI.getString(R.l.eqv));
        intent.putExtra("showShare", false);
        com.tencent.mm.bm.d.b(iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    static /* synthetic */ void f(IPCallShareCouponUI iPCallShareCouponUI) {
        b bVar = iPCallShareCouponUI.nMW;
        bVar.nFV++;
        g.pQN.a(257, 1, 1, true);
        ar.Hg();
        com.tencent.mm.z.c.CU().a(com.tencent.mm.storage.w.a.xpq, Boolean.valueOf(false));
        iPCallShareCouponUI.nMR.setVisibility(8);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", iPCallShareCouponUI.getString(R.l.eqG));
        intent.putExtra("showShare", false);
        com.tencent.mm.bm.d.b(iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    static /* synthetic */ void i(IPCallShareCouponUI iPCallShareCouponUI) {
        aid aUQ = com.tencent.mm.plugin.ipcall.b.c.aUQ();
        if (aUQ != null && !bh.ov(aUQ.wpB)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", aUQ.wpB);
            intent.putExtra("showShare", false);
            com.tencent.mm.bm.d.b(iPCallShareCouponUI, "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        ar.CG().a(257, this);
        com.tencent.mm.sdk.b.a.xef.b(this.nIB);
        setMMTitle(R.l.erw);
        setBackBtn(new 8(this));
        this.mController.removeAllOptionMenu();
        addIconOptionMenu(0, R.g.bDI, new 6(this));
        this.nMV = (IPCallDynamicTextView) findViewById(R.h.bME);
        this.nMB = (RelativeLayout) findViewById(R.h.cGo);
        this.nMC = (TextView) findViewById(R.h.cGr);
        this.nMD = (ImageView) findViewById(R.h.cGp);
        ar.Hg();
        if (((Boolean) com.tencent.mm.z.c.CU().get(com.tencent.mm.storage.w.a.xpo, Boolean.valueOf(false))).booleanValue()) {
            this.nMD.setVisibility(0);
        }
        ar.Hg();
        this.nMC.setText((String) com.tencent.mm.z.c.CU().get(com.tencent.mm.storage.w.a.xpn, ""));
        this.nME = (RelativeLayout) findViewById(R.h.cEj);
        this.nMF = (TextView) findViewById(R.h.cCg);
        this.nMG = (ImageView) findViewById(R.h.cCe);
        ar.Hg();
        this.nMF.setText((String) com.tencent.mm.z.c.CU().get(com.tencent.mm.storage.w.a.xpp, ""));
        this.nMS = (TextView) findViewById(R.h.bZk);
        this.nMT = (TextView) findViewById(R.h.cCd);
        this.nMU = findViewById(R.h.cOH);
        this.nMH = (LinearLayout) findViewById(R.h.ceS);
        this.nMR = (ImageView) findViewById(R.h.czm);
        ar.Hg();
        if (((Boolean) com.tencent.mm.z.c.CU().get(com.tencent.mm.storage.w.a.xpq, Boolean.valueOf(false))).booleanValue()) {
            this.nMR.setVisibility(0);
        }
        this.nMO = (TextView) findViewById(R.h.cAD);
        this.nMP = (TextView) findViewById(R.h.bJG);
        this.nMQ = (TextView) findViewById(R.h.cPy);
        this.nMI = (LinearLayout) findViewById(R.h.cNI);
        this.nMJ = (LinearLayout) findViewById(R.h.cyx);
        this.nMM = (LinearLayout) findViewById(R.h.cKw);
        this.nMN = (ImageView) findViewById(R.h.cKx);
        this.nMK = (LinearLayout) findViewById(R.h.cxw);
        this.nML = (ImageView) findViewById(R.h.cxx);
        ar.Hg();
        if (((Boolean) com.tencent.mm.z.c.CU().get(com.tencent.mm.storage.w.a.xpw, Boolean.valueOf(false))).booleanValue()) {
            this.nML.setVisibility(0);
        }
        if (com.tencent.mm.plugin.ipcall.b.c.aUP()) {
            z = true;
        } else {
            z = com.tencent.mm.k.g.zY().getInt("WCOPurchaseSwitch", 0) == 1;
        }
        if (z) {
            this.nMB.setVisibility(8);
        }
        z = (com.tencent.mm.plugin.ipcall.b.c.aUP() || com.tencent.mm.k.g.zY().getInt("WCOPackagePurchaseSwitch", 0) == 0) ? false : true;
        if (z) {
            this.nME.setVisibility(0);
        }
        if (com.tencent.mm.k.g.zY().getInt("WCOAccountDetailSwitch", 0) == 1) {
            this.nMH.setVisibility(8);
        }
        if (com.tencent.mm.plugin.ipcall.b.c.aUP()) {
            z = true;
        } else {
            z = com.tencent.mm.k.g.zY().getInt("WCOInviteFriend", 0) == 1;
        }
        if (z) {
            this.nMI.setVisibility(8);
        }
        this.nMO.setOnClickListener(new 9(this));
        this.nMP.setOnClickListener(new 10(this));
        this.nMH.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ IPCallShareCouponUI nMZ;

            {
                this.nMZ = r1;
            }

            public final void onClick(View view) {
                IPCallShareCouponUI.f(this.nMZ);
            }
        });
        this.nMI.setOnClickListener(new 12(this));
        this.nMK.setOnClickListener(new 13(this));
        this.nMJ.setOnClickListener(new 14(this));
        this.nMB.setOnClickListener(new 15(this));
        this.nME.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ IPCallShareCouponUI nMZ;

            {
                this.nMZ = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(this.nMZ.mController.xIM, IPCallPackageUI.class);
                this.nMZ.startActivity(intent);
            }
        });
        this.nMM.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ IPCallShareCouponUI nMZ;

            {
                this.nMZ = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                String str = this.nMZ.getString(R.l.erc) + "&usedcc=";
                List aTm = com.tencent.mm.plugin.ipcall.a.c.aTj().aTm();
                if (aTm == null || aTm.size() <= 0) {
                    str = str + com.tencent.mm.plugin.ipcall.b.a.Dd(com.tencent.mm.plugin.ipcall.b.c.aUO());
                } else {
                    int size = aTm.size();
                    if (size > 5) {
                        size = 5;
                    }
                    int i = 0;
                    while (i < size) {
                        String Dd = com.tencent.mm.plugin.ipcall.b.a.Dd(((Integer) aTm.get(i)).toString());
                        if (bh.ov(Dd)) {
                            Dd = str;
                        } else {
                            Dd = str + Dd + "|";
                        }
                        i++;
                        str = Dd;
                    }
                    if (str.endsWith("|")) {
                        str = str.substring(0, str.length() - 1);
                    }
                }
                intent.putExtra("rawUrl", str);
                intent.putExtra("showShare", false);
                com.tencent.mm.bm.d.b(this.nMZ, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        aid aUQ = com.tencent.mm.plugin.ipcall.b.c.aUQ();
        if (aUQ != null) {
            a(aUQ);
            amg();
        } else {
            this.nMV.setText("0");
            Context context = this.mController.xIM;
            getString(R.l.dGO);
            this.nIK = h.a(context, getString(R.l.eqO), true, new 4(this));
        }
        if (com.tencent.mm.plugin.ipcall.b.c.aUP()) {
            String string = getString(R.l.esk);
            CharSequence charSequence = string + getString(R.l.esj);
            5 5 = new 5(this);
            Spannable newSpannable = Factory.getInstance().newSpannable(charSequence);
            int length = string.length();
            int length2 = newSpannable.length();
            if (length < 0 || length >= length2 || length2 < 0 || length2 > newSpannable.length()) {
                newSpannable.setSpan(5, 0, newSpannable.length(), 33);
            } else {
                newSpannable.setSpan(5, length, length2, 33);
            }
            this.nMQ.setText(newSpannable);
            this.nMQ.setMovementMethod(LinkMovementMethod.getInstance());
            this.nMQ.setVisibility(0);
        } else {
            this.nMQ.setVisibility(8);
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.h.csC);
        if (linearLayout != null && this.nMB.getVisibility() == 8 && this.nME.getVisibility() == 8) {
            linearLayout.setVisibility(8);
        }
        linearLayout = (LinearLayout) findViewById(R.h.csD);
        if (linearLayout != null && this.nMI.getVisibility() == 8 && this.nMJ.getVisibility() == 8) {
            linearLayout.setVisibility(8);
        }
        this.nMW.start();
    }

    protected void onResume() {
        super.onResume();
        com.tencent.mm.plugin.ipcall.a.f.b.aUc().gb(false);
    }

    protected void onDestroy() {
        super.onDestroy();
        ar.CG().b(257, this);
        com.tencent.mm.sdk.b.a.xef.c(this.nIB);
        this.nMW.nFU = System.currentTimeMillis();
        this.nMW.finish();
    }

    protected final int getLayoutId() {
        return R.i.dma;
    }

    private void amg() {
        if (!bh.ov(this.nMl)) {
            if (this.nMk == null) {
                this.nMV.setValue(this.nMl, this.nMl);
            } else {
                this.nMV.setValue(this.nMk, this.nMl);
            }
            this.nMk = this.nMl;
        }
        this.nMS.getText();
        this.nMS.setText(this.nMm);
        if (bh.ov(this.nMm)) {
            this.nMS.setVisibility(8);
        } else {
            this.nMS.setVisibility(0);
        }
        StringBuffer stringBuffer = new StringBuffer("");
        if (this.nMX != null && this.nMX.size() > 0) {
            Iterator it = this.nMX.iterator();
            while (it.hasNext()) {
                bwo com_tencent_mm_protocal_c_bwo = (bwo) it.next();
                if (!(com_tencent_mm_protocal_c_bwo == null || bh.ov(com_tencent_mm_protocal_c_bwo.wXG))) {
                    stringBuffer.append(com_tencent_mm_protocal_c_bwo.wXG).append('\n');
                }
            }
        }
        if (bh.ov(stringBuffer.toString())) {
            this.nMT.setText("");
            this.nMT.setVisibility(8);
        } else {
            if (stringBuffer.charAt(stringBuffer.length() - 1) == '\n') {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
            this.nMT.setText(stringBuffer.toString());
            this.nMT.setVisibility(0);
        }
        if (this.nMS.getVisibility() == 0 && this.nMT.getVisibility() == 0) {
            this.nMU.setVisibility(0);
        } else {
            this.nMU.setVisibility(8);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof com.tencent.mm.plugin.ipcall.a.d.g)) {
            return;
        }
        if (i == 0 && i2 == 0) {
            a(((com.tencent.mm.plugin.ipcall.a.d.g) kVar).nFC);
            amg();
            if (this.nIK != null && this.nIK.isShowing()) {
                this.nIK.dismiss();
            }
        } else if (this.nIK != null && this.nIK.isShowing()) {
            this.nIK.dismiss();
            h.a(this.mController.xIM, getString(R.l.eqM), getString(R.l.eqI), new 7(this));
        }
    }

    private void a(aid com_tencent_mm_protocal_c_aid) {
        this.nMg = com_tencent_mm_protocal_c_aid.wpr;
        this.gAT = com_tencent_mm_protocal_c_aid.nfe;
        this.nMh = com_tencent_mm_protocal_c_aid.wps;
        this.mTitle = com_tencent_mm_protocal_c_aid.fon;
        this.nMi = com_tencent_mm_protocal_c_aid.nGK;
        this.nMj = com_tencent_mm_protocal_c_aid.wpt;
        this.nMl = com_tencent_mm_protocal_c_aid.wpu;
        this.nMm = com_tencent_mm_protocal_c_aid.wpv;
        this.nMn = com_tencent_mm_protocal_c_aid.wpw;
        this.nMX = com_tencent_mm_protocal_c_aid.wpf;
    }
}
