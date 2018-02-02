package com.tencent.mm.plugin.label.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.platformtools.c;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.label.b.d;
import com.tencent.mm.plugin.label.ui.widget.MMLabelPanel;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.brp;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.MMTagPanelScrollView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.p.b;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ContactLabelUI extends ContactLabelBaseUI implements e {
    private String gAb;
    private MMTagPanelScrollView nPF;
    private MMLabelPanel nPG;
    private TextView nPH;
    private View nPI;
    private View nPJ;
    private TextView nPK;
    private MMLabelPanel nPL;
    private ListView nPM;
    private ScrollView nPN;
    private b nPO;
    private String nPP;
    private ArrayList<String> nPQ;
    private HashSet<String> nPR = new HashSet();
    private HashSet<String> nPS = new HashSet();
    private ArrayList<String> nPT = new ArrayList();
    private int nPU = a.nPZ;
    private boolean nPV = false;
    private ArrayList<String> nPW;
    private boolean nPf = true;

    static /* synthetic */ void a(ContactLabelUI contactLabelUI) {
        x.i("MicroMsg.Label.ContactLabelUI", "cpan[save]");
        if (contactLabelUI.nPG == null) {
            x.w("MicroMsg.Label.ContactLabelUI", "save fail. input view is null.");
            return;
        }
        contactLabelUI.Ds(contactLabelUI.getString(R.l.esE));
        String cpC;
        if (contactLabelUI.nPV) {
            x.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLabelStranger]");
            if (contactLabelUI.nPG != null) {
                cpC = contactLabelUI.nPG.cpC();
                if (!bh.ov(cpC)) {
                    contactLabelUI.nPG.bi(cpC, true);
                    contactLabelUI.nPG.cpD();
                    contactLabelUI.ap(cpC, contactLabelUI.nPV);
                }
            }
            if (contactLabelUI.nPS != null && contactLabelUI.nPS.size() > 0) {
                x.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLabelStranger] save local");
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(contactLabelUI.nPS);
                if (!arrayList.isEmpty()) {
                    int size = arrayList.size();
                    List arrayList2 = new ArrayList();
                    for (int i = 0; i < size; i++) {
                        z zVar = new z();
                        cpC = (String) arrayList.get(i);
                        zVar.field_isTemporary = true;
                        zVar.field_labelName = cpC;
                        zVar.field_labelPYFull = c.ol(cpC);
                        zVar.field_labelPYShort = c.om(cpC);
                        zVar.field_labelID = -((int) System.nanoTime());
                        x.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLabelStranger]field_labelID:%s field_labelName:%s", new Object[]{Integer.valueOf(zVar.field_labelID), zVar.field_labelName});
                        arrayList2.add(zVar);
                    }
                    com.tencent.mm.plugin.label.e.aUW().cF(arrayList2);
                }
            }
            x.i("MicroMsg.Label.ContactLabelUI", "cpan[saveStranger]");
            ar.Hg();
            com.tencent.mm.sdk.e.c EZ = com.tencent.mm.z.c.EZ().EZ(contactLabelUI.gAb);
            if (contactLabelUI.nPG != null) {
                String aW = a.aUX().aW(contactLabelUI.nPG.cpH());
                if (bh.ov(aW)) {
                    EZ.field_contactLabels = "";
                    ar.Hg();
                    com.tencent.mm.z.c.EZ().a(EZ);
                } else {
                    EZ.field_contactLabels = aW;
                    if (bh.ov(EZ.field_encryptUsername)) {
                        EZ.field_encryptUsername = contactLabelUI.gAb;
                    }
                    ar.Hg();
                    com.tencent.mm.z.c.EZ().a(EZ);
                }
            }
            contactLabelUI.aVh();
            return;
        }
        x.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLabel]");
        if (contactLabelUI.nPG != null) {
            cpC = contactLabelUI.nPG.cpC();
            if (!bh.ov(cpC)) {
                cpC = cpC.trim();
                contactLabelUI.nPG.bi(cpC, true);
                contactLabelUI.nPG.cpD();
                contactLabelUI.ap(cpC, contactLabelUI.nPV);
            }
        }
        if (contactLabelUI.nPS == null || contactLabelUI.nPS.size() <= 0) {
            x.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLable] doSaveContact");
            contactLabelUI.aVg();
            return;
        }
        x.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLable] doScene");
        List arrayList3 = new ArrayList();
        arrayList3.addAll(contactLabelUI.nPS);
        ar.CG().a(new com.tencent.mm.plugin.label.b.a(arrayList3), 0);
        if (contactLabelUI.nPT == null || contactLabelUI.nPS.isEmpty()) {
            g.pQN.h(11347, new Object[]{Integer.valueOf(0), Integer.valueOf(0)});
            return;
        }
        g.pQN.h(11347, new Object[]{Integer.valueOf(0), Integer.valueOf(1)});
    }

    static /* synthetic */ void a(ContactLabelUI contactLabelUI, String str) {
        if (contactLabelUI.nPQ != null && contactLabelUI.nPQ.contains(str)) {
            contactLabelUI.nPR.add(str);
        }
        if (contactLabelUI.nPS != null && contactLabelUI.nPS.contains(str)) {
            contactLabelUI.nPS.remove(str);
        }
        if (contactLabelUI.aVi()) {
            contactLabelUI.enableOptionMenu(true);
        }
    }

    static /* synthetic */ void a(ContactLabelUI contactLabelUI, ArrayList arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            ag.h(new 10(contactLabelUI), 50);
        } else {
            ag.h(new 11(contactLabelUI), 50);
        }
    }

    static /* synthetic */ void b(ContactLabelUI contactLabelUI, String str) {
        if (bh.ov(str)) {
            contactLabelUI.rL(a.nPZ);
            return;
        }
        contactLabelUI.rL(a.nQa);
        if (contactLabelUI.nPG != null) {
            b bVar = contactLabelUI.nPO;
            List cpH = contactLabelUI.nPG.cpH();
            if (bVar.nPD != null) {
                bVar.nPD.clear();
            }
            if (bVar.nPE != null) {
                bVar.nPE.clear();
            }
            bVar.nPC = bh.az(str, "");
            bVar.nPD = com.tencent.mm.plugin.label.e.aUW().o(str, cpH);
            bVar.notifyDataSetChanged();
        }
    }

    protected final int getLayoutId() {
        return R.i.deT;
    }

    protected final void initView() {
        setMMTitle(getString(R.l.dCu));
        setBackBtn(new 1(this));
        a(0, getString(R.l.dGx), new 5(this), b.xJz);
        this.nPF = (MMTagPanelScrollView) findViewById(R.h.csr);
        this.nPF.yef = 3;
        this.nPG = (MMLabelPanel) findViewById(R.h.csq);
        this.nPH = (TextView) findViewById(R.h.cst);
        this.nPI = findViewById(R.h.csp);
        this.nPJ = findViewById(R.h.cso);
        this.nPJ.setBackgroundDrawable(null);
        this.nPK = (TextView) this.nPJ.findViewById(16908310);
        this.nPK.setText(R.l.csn);
        this.nPL = (MMLabelPanel) findViewById(R.h.csn);
        this.nPM = (ListView) findViewById(R.h.css);
        this.nPN = (ScrollView) findViewById(R.h.csu);
        if (this.nPN != null) {
            this.nPN.setOnTouchListener(new 6(this));
        }
        this.nPG.ydE = true;
        this.nPG.ms(true);
        this.nPG.EP(R.g.bGB);
        this.nPG.ydL = new 7(this);
        this.nPL.ms(false);
        this.nPL.ydL = new 8(this);
        this.nPM.setAdapter(this.nPO);
        this.nPM.setOnItemClickListener(new 9(this));
        enableOptionMenu(false);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nPP = getIntent().getStringExtra("label_id_list");
        this.nPQ = getIntent().getStringArrayListExtra("label_str_list");
        this.gAb = getIntent().getStringExtra("label_username");
        this.nPV = getIntent().getBooleanExtra("is_stranger", false);
        this.nPO = new b(this);
        initView();
        if (!(bh.ov(this.nPP) || this.nPQ == null || this.nPQ.size() <= 0)) {
            this.nPG.a(this.nPQ, this.nPQ);
        }
        if (this.nPV) {
            this.nPW = getIntent().getStringArrayListExtra("label_str_list");
            this.nPG.a(this.nPW, this.nPW);
        }
    }

    protected void onResume() {
        ar.CG().a(635, this);
        ar.CG().a(638, this);
        ag.y(new 12(this));
        super.onResume();
    }

    protected void onPause() {
        ar.CG().b(635, this);
        ar.CG().b(638, this);
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        switch (kVar.getType()) {
            case 635:
                if (i == 0 && i2 == 0) {
                    aVg();
                    return;
                } else {
                    aVc();
                    return;
                }
            case 638:
                if (i == 0 && i2 == 0) {
                    x.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd] success.");
                    aVh();
                    return;
                }
                aVc();
                return;
            default:
                x.w("MicroMsg.Label.ContactLabelUI", "unknow type.");
                return;
        }
    }

    public void onBackPressed() {
        if (aVi()) {
            h.a(this, getString(R.l.eHf), "", getString(R.l.dNh), getString(R.l.dNi), new 2(this), new OnClickListener(this) {
                final /* synthetic */ ContactLabelUI nPX;

                {
                    this.nPX = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.nPX.finish();
                }
            });
        } else {
            super.onBackPressed();
        }
    }

    private void rL(int i) {
        this.nPU = i;
        switch (4.nPY[this.nPU - 1]) {
            case 1:
                this.nPM.setVisibility(8);
                if (this.nPT == null || this.nPT.size() <= 0) {
                    this.nPN.setVisibility(8);
                    this.nPI.setVisibility(8);
                } else {
                    this.nPI.setVisibility(0);
                    this.nPN.setVisibility(0);
                }
                this.nPH.setVisibility(8);
                return;
            case 2:
                this.nPN.setVisibility(8);
                this.nPM.setVisibility(0);
                this.nPI.setVisibility(8);
                this.nPH.setVisibility(8);
                return;
            case 3:
                this.nPM.setVisibility(8);
                this.nPN.setVisibility(8);
                this.nPI.setVisibility(8);
                this.nPH.setVisibility(0);
                this.nPH.setText(R.l.esC);
                return;
            case 4:
                this.nPM.setVisibility(8);
                this.nPN.setVisibility(8);
                this.nPI.setVisibility(8);
                this.nPH.setVisibility(0);
                this.nPH.setText(R.l.esC);
                return;
            default:
                return;
        }
    }

    private void ap(String str, boolean z) {
        if (bh.ov(str)) {
            x.w("MicroMsg.Label.ContactLabelUI", "tag is empty");
            return;
        }
        String trim = str.trim();
        if (bh.ov(trim)) {
            x.w("MicroMsg.Label.ContactLabelUI", "new tag is empty");
            return;
        }
        z WF = com.tencent.mm.plugin.label.e.aUW().WF(trim);
        if (z) {
            if (this.nPT == null || !this.nPT.contains(trim) || WF == null) {
                this.nPS.add(trim);
            }
        } else if (this.nPT == null || !this.nPT.contains(trim) || (WF != null && WF.field_isTemporary)) {
            this.nPS.add(trim);
        }
        if (this.nPR != null && this.nPR.contains(trim)) {
            this.nPR.remove(trim);
        }
        if (aVi()) {
            enableOptionMenu(true);
        }
    }

    private void aVg() {
        x.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]");
        if (this.nPG != null) {
            int size;
            int size2;
            int size3;
            x.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact] doScene");
            String str = "";
            ArrayList cpH = this.nPG.cpH();
            if (cpH.size() > 0) {
                str = com.tencent.mm.plugin.label.c.aY(com.tencent.mm.plugin.label.e.aUW().ae(cpH));
            }
            LinkedList linkedList = new LinkedList();
            brp com_tencent_mm_protocal_c_brp = new brp();
            com_tencent_mm_protocal_c_brp.vYL = str;
            com_tencent_mm_protocal_c_brp.ksU = this.gAb;
            linkedList.add(com_tencent_mm_protocal_c_brp);
            ar.CG().a(new d(linkedList), 0);
            if (this.nPS != null) {
                size = this.nPS.size();
            } else {
                size = 0;
            }
            if (this.nPQ != null) {
                size2 = this.nPQ.size();
            } else {
                size2 = 0;
            }
            if (this.nPR != null) {
                size3 = this.nPR.size();
            } else {
                size3 = 0;
            }
            size2 = ((size3 + this.nPG.cpH().size()) - size2) - size;
            if (size > 0 || size2 > 0) {
                x.d("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", new Object[]{Integer.valueOf(size), Integer.valueOf(size2)});
                g.pQN.h(11220, new Object[]{q.FS(), Integer.valueOf(size), Integer.valueOf(size2), Integer.valueOf(0)});
            }
        }
    }

    private void aVh() {
        aUZ();
        this.nPS.clear();
        this.nPR.clear();
        finish();
    }

    private void aVc() {
        aUZ();
        yE(getString(R.l.dCr));
    }

    private boolean aVi() {
        if (this.nPG != null) {
            if (this.nPQ == null || this.nPQ.size() <= 0) {
                this.nPG.cpH();
                if (this.nPG.cpH().size() > 0) {
                    return true;
                }
            }
            this.nPG.cpH();
            List cpH = this.nPG.cpH();
            Collections.sort(this.nPQ);
            Collections.sort(cpH);
            if (this.nPQ.equals(cpH)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public void finish() {
        if (this.nPG != null) {
            this.nPG.cpG();
        }
        Intent intent = new Intent();
        if (aVi()) {
            intent.putExtra("hasLableChange", true);
        } else {
            intent.putExtra("hasLableChange", false);
        }
        setResult(-1, intent);
        super.finish();
    }
}
