package com.tencent.mm.plugin.label.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.c;
import com.tencent.mm.plugin.label.b.a;
import com.tencent.mm.plugin.label.b.b;
import com.tencent.mm.plugin.label.ui.widget.InputClearablePreference;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.i;
import com.tencent.mm.protocal.c.anu;
import com.tencent.mm.protocal.c.brp;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContactLabelEditUI extends MMPreference implements e {
    private ProgressDialog ltM;
    private af mHandler = new 1(this, Looper.getMainLooper());
    private boolean nIy = true;
    private String nOI;
    private String nOJ;
    private String nOK;
    private z nOL;
    private String nOM;
    private f nON;
    private ContactListExpandPreference nOO;
    private InputClearablePreference nOP;
    private Preference nOQ;
    private PreferenceTitleCategory nOR;
    private boolean nOS = true;
    private ArrayList<String> nOT = new ArrayList();
    private ArrayList<String> nOU = new ArrayList();
    private HashSet<String> nOV = new HashSet();
    private HashSet<String> nOW = new HashSet();
    private String nOX;

    static /* synthetic */ void a(ContactLabelEditUI contactLabelEditUI, String str) {
        x.i("MicroMsg.Label.ContactLabelEditUI", "cpan[dealRemoveContact]");
        if (contactLabelEditUI.nOT != null && contactLabelEditUI.nOT.contains(str)) {
            contactLabelEditUI.nOT.remove(str);
        }
        if (contactLabelEditUI.nOU != null && contactLabelEditUI.nOU.contains(str)) {
            contactLabelEditUI.nOW.add(str);
        }
        if (contactLabelEditUI.nOV != null && contactLabelEditUI.nOV.contains(str)) {
            contactLabelEditUI.nOV.remove(str);
        }
        if (contactLabelEditUI.mHandler != null) {
            contactLabelEditUI.mHandler.sendEmptyMessage(6001);
        }
    }

    static /* synthetic */ void b(ContactLabelEditUI contactLabelEditUI) {
        x.i("MicroMsg.Label.ContactLabelEditUI", "cpan[saveLabelChange]");
        contactLabelEditUI.Ds(contactLabelEditUI.getString(R.l.esE));
        contactLabelEditUI.nOJ = bh.az(contactLabelEditUI.nOJ, "");
        contactLabelEditUI.nOJ = contactLabelEditUI.nOJ.trim();
        if (bh.ov(contactLabelEditUI.nOJ)) {
            contactLabelEditUI.aUZ();
            contactLabelEditUI.yE(contactLabelEditUI.getString(R.l.esA));
        } else if (h.ZY(contactLabelEditUI.nOJ) > 36) {
            contactLabelEditUI.aUZ();
            contactLabelEditUI.yE(String.format(contactLabelEditUI.getString(R.l.dCt), new Object[]{Integer.valueOf(h.aY(36, ""))}));
        } else if (!(Du(contactLabelEditUI.nOJ) && contactLabelEditUI.nOS) && (!Du(contactLabelEditUI.nOJ) || bh.ov(contactLabelEditUI.nOI) || contactLabelEditUI.nOI.equals(contactLabelEditUI.nOJ))) {
            z WG = com.tencent.mm.plugin.label.e.aUW().WG(contactLabelEditUI.nOK);
            if (contactLabelEditUI.nOS || WG.field_isTemporary) {
                ar.CG().a(new a(contactLabelEditUI.nOJ), 0);
                return;
            }
            ar.CG().a(new com.tencent.mm.plugin.label.b.e(Integer.valueOf(contactLabelEditUI.nOK).intValue(), contactLabelEditUI.nOJ), 0);
        } else {
            contactLabelEditUI.aUZ();
            contactLabelEditUI.yE(contactLabelEditUI.getString(R.l.dCq));
        }
    }

    static /* synthetic */ void d(ContactLabelEditUI contactLabelEditUI) {
        x.i("MicroMsg.Label.ContactLabelEditUI", "cpan[dealAddContact]");
        Intent intent = new Intent();
        intent.putExtra("list_attr", s.p(new int[]{s.yTE, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT}));
        intent.putExtra("list_type", 1);
        intent.putExtra("titile", contactLabelEditUI.getString(R.l.esu));
        intent.putExtra("show_too_many_member", false);
        intent.putExtra("scene", 6);
        if (contactLabelEditUI.nOT != null) {
            intent.putExtra("always_select_contact", bh.d(contactLabelEditUI.nOT, ","));
        }
        d.a((Context) contactLabelEditUI, ".ui.contact.SelectContactUI", intent, 7001);
    }

    static /* synthetic */ void l(ContactLabelEditUI contactLabelEditUI) {
        if (contactLabelEditUI.nOL.field_isTemporary) {
            contactLabelEditUI.a(contactLabelEditUI.nOL);
            return;
        }
        z zVar = contactLabelEditUI.nOL;
        if (zVar == null) {
            x.w("MicroMsg.Label.ContactLabelEditUI", "cpan[doDeleteScene] can not do scene. lable is null");
            return;
        }
        contactLabelEditUI.Ds(contactLabelEditUI.getString(R.l.esx));
        ar.CG().a(new b(zVar.field_labelID), 0);
    }

    public final int XB() {
        return R.o.fbP;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nOX = q.FS();
        this.nOK = getIntent().getStringExtra("label_id");
        this.nOI = getIntent().getStringExtra("label_name");
        this.nOJ = getIntent().getStringExtra("label_name");
        String stringExtra = getIntent().getStringExtra("Select_Contact");
        if (!bh.ov(stringExtra)) {
            List F = bh.F(stringExtra.split(","));
            this.nOT = new ArrayList();
            if (F != null && F.size() > 0) {
                int size = F.size();
                for (int i = 0; i < size; i++) {
                    stringExtra = (String) F.get(i);
                    if (!bh.ov(stringExtra)) {
                        if (!com.tencent.mm.z.s.gE(stringExtra) || this.nOT.contains(stringExtra) || stringExtra.equals(this.nOX)) {
                            x.i("MicroMsg.Label.ContactLabelEditUI", "dz[getIntent] %s is no friend or is user self and just filter", new Object[]{stringExtra});
                        } else {
                            this.nOT.add(stringExtra);
                            this.nOV.add(stringExtra);
                        }
                    }
                }
            }
        }
        ar.CG().a(635, this);
        ar.CG().a(637, this);
        ar.CG().a(638, this);
        initView();
    }

    protected void onResume() {
        com.tencent.mm.modelstat.d.b(3, "ContactLabelEditUI" + getIdentString(), hashCode());
        ar.CG().a(636, this);
        Dt(this.nOJ);
        aVa();
        super.onResume();
    }

    protected void onPause() {
        com.tencent.mm.modelstat.d.b(4, "ContactLabelEditUI" + getIdentString(), hashCode());
        ar.CG().b(636, this);
        super.onPause();
    }

    protected void onDestroy() {
        ar.CG().b(635, this);
        ar.CG().b(637, this);
        ar.CG().b(638, this);
        super.onDestroy();
    }

    protected final void initView() {
        if (bh.ov(this.nOK)) {
            this.nOS = true;
            this.nOM = getString(R.l.eAU);
        } else {
            this.nOS = false;
            this.nOL = com.tencent.mm.plugin.label.e.aUW().WG(this.nOK);
            this.nOM = getString(R.l.eAT);
        }
        setMMTitle(this.nOM);
        setBackBtn(new 7(this));
        a(0, getString(R.l.dGx), new 8(this), p.b.xJz);
        this.nON = this.yjd;
        this.nOO = (ContactListExpandPreference) this.nON.YN("contact_label_contact_list");
        this.nOO.a(this.nON, this.nOO.ibD);
        this.nOO.la(true);
        this.nOO.lb(true);
        this.nOO.caY();
        this.nOO.cbb();
        this.nOO.a(new i.b(this) {
            final /* synthetic */ ContactLabelEditUI nOY;

            {
                this.nOY = r1;
            }

            public final boolean oc(int i) {
                return false;
            }
        });
        this.nOO.a(new 10(this));
        this.nOP = (InputClearablePreference) this.nON.YN("contact_label_name");
        InputClearablePreference inputClearablePreference = this.nOP;
        inputClearablePreference.nQh = getString(R.l.esy);
        if (inputClearablePreference.nQm != null) {
            inputClearablePreference.nQm.setHint(inputClearablePreference.nQh);
        }
        this.nOP.jey = getString(R.l.esC);
        inputClearablePreference = this.nOP;
        inputClearablePreference.nQi = getString(R.l.dCs);
        if (inputClearablePreference.nQo != null) {
            inputClearablePreference.nQo.setText(inputClearablePreference.nQi);
        }
        this.nOP.nQj = 36;
        this.nOP.nQl = this.nOS;
        this.nOP.nQq = new 11(this);
        this.nOP.setText(this.nOJ);
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(6001);
        }
        if (!this.nOS) {
            ar.Dm().F(new 12(this));
        } else if (this.nOT == null || this.nOT.size() <= 0) {
            this.nOO.ad(new ArrayList());
        } else {
            this.nOO.n(null, this.nOT);
        }
        if (this.nKG != null) {
            this.nKG.setOnScrollListener(new OnScrollListener(this) {
                final /* synthetic */ ContactLabelEditUI nOY;

                {
                    this.nOY = r1;
                }

                public final void onScrollStateChanged(AbsListView absListView, int i) {
                    if (i == 2 || i == 1) {
                        this.nOY.aWs();
                    }
                }

                public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                }
            });
        }
        this.nOQ = this.nON.YN("contact_label_delete");
        this.nOR = (PreferenceTitleCategory) this.nON.YN("contact_label_empty_category");
        if (this.nOS) {
            this.nON.c(this.nOQ);
            this.nON.c(this.nOR);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onActivityResult] requestCode:%d resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            switch (i) {
                case 7001:
                    String stringExtra = intent.getStringExtra("Select_Contact");
                    x.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onActivityResult] %s", new Object[]{stringExtra});
                    if (!bh.ov(stringExtra)) {
                        List F = bh.F(stringExtra.split(","));
                        if (F != null && F.size() > 0) {
                            int size = F.size();
                            int i3 = 0;
                            while (i3 < size) {
                                stringExtra = (String) F.get(i3);
                                if (!bh.ov(stringExtra)) {
                                    if (!com.tencent.mm.z.s.gE(stringExtra) || this.nOT.contains(stringExtra) || stringExtra.equals(this.nOX)) {
                                        x.i("MicroMsg.Label.ContactLabelEditUI", "dz[getIntent] %s is no friend or is user self and just filter", new Object[]{stringExtra});
                                    } else {
                                        this.nOT.add(stringExtra);
                                        if (!(this.nOU == null || this.nOU.contains(F.get(i3)))) {
                                            this.nOV.add(stringExtra);
                                        }
                                        if (this.nOW != null && this.nOW.contains(stringExtra)) {
                                            this.nOW.remove(stringExtra);
                                        }
                                    }
                                }
                                i3++;
                            }
                        }
                        if (this.mHandler != null) {
                            this.mHandler.sendEmptyMessage(6001);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        if (bh.ov(str)) {
            x.w("MicroMsg.Label.ContactLabelEditUI", "cpan [onPreferenceTreeClick] key is null.");
        } else {
            if (str.equals("contact_label_delete")) {
                com.tencent.mm.ui.base.h.a(this, getString(R.l.esw), "", getString(R.l.dEw), getString(R.l.dEn), new 14(this), new 2(this));
            }
            x.d("MicroMsg.Label.ContactLabelEditUI", "cpan [onPreferenceTreeClick] key is %s:", new Object[]{str});
        }
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        switch (kVar.getType()) {
            case 635:
                if (i == 0 && i2 == 0) {
                    LinkedList linkedList = ((a) kVar).aUY().vGK;
                    if (linkedList == null || linkedList.size() <= 0) {
                        aVc();
                        return;
                    }
                    x.i("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] add label pair.LabelID:%s pair.LabelName:%s", new Object[]{r0.wuI, ((anu) linkedList.get(0)).wuH});
                    this.nOK = r0.wuI;
                    aVd();
                    return;
                }
                aVc();
                return;
            case 636:
                if (i == 0 && i2 == 0) {
                    a(this.nOL);
                    if (this.mHandler != null) {
                        this.mHandler.sendEmptyMessageDelayed(6002, 300);
                        return;
                    }
                    return;
                }
                x.w("MicroMsg.Label.ContactLabelEditUI", "cpan[onSceneEnd] delete fail.");
                aVe();
                return;
            case 637:
                if (i == 0 && i2 == 0) {
                    int intValue;
                    String str2 = this.nOK;
                    String str3 = this.nOJ;
                    x.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doInsertOrUpdateLable]");
                    try {
                        intValue = Integer.valueOf(str2).intValue();
                    } catch (Exception e) {
                        x.e("MicroMsg.Label.ContactLabelEditUI", "id is not integer type:%s", new Object[]{str2});
                        intValue = -1;
                    }
                    if (intValue != -1) {
                        z WG = com.tencent.mm.plugin.label.e.aUW().WG(str2);
                        if (WG == null) {
                            WG = new z();
                        }
                        WG.field_labelID = intValue;
                        WG.field_labelName = str3;
                        WG.field_labelPYFull = c.ol(str3);
                        WG.field_labelPYShort = c.om(str3);
                        com.tencent.mm.plugin.label.e.aUW().b(true, WG, new String[]{"labelID"});
                    } else {
                        aVc();
                    }
                    aVd();
                    return;
                }
                aVc();
                return;
            case 638:
                if (i == 0 && i2 == 0) {
                    aVb();
                    if (this.mHandler != null) {
                        this.mHandler.sendEmptyMessageDelayed(6002, 300);
                        return;
                    }
                    return;
                }
                aVc();
                return;
            default:
                return;
        }
    }

    private void aVa() {
        if (this.nOO != null) {
            this.nOO.n(null, this.nOT);
            if (this.nOT == null || this.nOT.size() <= 0) {
                this.nOO.caZ();
            }
        }
        if (this.nOP != null) {
            this.nOP.setText(this.nOJ);
        }
    }

    private void Dt(String str) {
        enableOptionMenu(!bh.ov(str));
    }

    private void aVb() {
        int size;
        x.i("MicroMsg.Label.ContactLabelEditUI", "cpan[savaSuccess]");
        aUZ();
        if (this.nOV != null) {
            size = this.nOV.size();
        } else {
            size = 0;
        }
        x.i("MicroMsg.Label.ContactLabelEditUI", "cpan[doUpdateContactList]addnum:%d", new Object[]{Integer.valueOf(size)});
        g.pQN.h(11220, new Object[]{q.FS(), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(size)});
        if (this.nOS) {
            Intent intent = getIntent();
            intent.putExtra("k_sns_label_add_label", this.nOJ);
            setResult(0, intent);
        } else {
            setResult(0);
        }
        finish();
    }

    private void aVc() {
        x.i("MicroMsg.Label.ContactLabelEditUI", "cpan[saveFailed]");
        aUZ();
        yE(getString(R.l.dCr));
    }

    private static boolean Du(String str) {
        if (bh.ov(com.tencent.mm.plugin.label.e.aUW().Do(str))) {
            return false;
        }
        return true;
    }

    private void aVd() {
        int i;
        Iterator it;
        String str;
        String dc;
        String str2 = "MicroMsg.Label.ContactLabelEditUI";
        String str3 = "cpan[doUpdateContactList] addcount:%d,delcount:%d";
        Object[] objArr = new Object[2];
        if (this.nOV == null) {
            i = 0;
        } else {
            i = this.nOV.size();
        }
        objArr[0] = Integer.valueOf(i);
        if (this.nOW == null) {
            i = 0;
        } else {
            i = this.nOW.size();
        }
        objArr[1] = Integer.valueOf(i);
        x.i(str2, str3, objArr);
        LinkedList linkedList = new LinkedList();
        if (this.nOV != null && this.nOV.size() > 0) {
            this.nOV.size();
            it = this.nOV.iterator();
            while (it.hasNext()) {
                String str4 = (String) it.next();
                ar.Hg();
                com.tencent.mm.g.b.af WO = com.tencent.mm.z.c.EY().WO(str4);
                str = WO.field_contactLabelIds;
                dc = com.tencent.mm.plugin.label.c.dc(str, this.nOK);
                x.i("MicroMsg.Label.ContactLabelEditUI", "labels:%s mixLabelIds:%s", new Object[]{str, dc});
                if (!dc.equalsIgnoreCase(str)) {
                    brp com_tencent_mm_protocal_c_brp = new brp();
                    com_tencent_mm_protocal_c_brp.ksU = WO.field_username;
                    com_tencent_mm_protocal_c_brp.vYL = dc;
                    linkedList.add(com_tencent_mm_protocal_c_brp);
                }
            }
        }
        if (this.nOW != null && this.nOW.size() > 0) {
            this.nOW.size();
            it = this.nOW.iterator();
            while (it.hasNext()) {
                str4 = (String) it.next();
                ar.Hg();
                str = com.tencent.mm.z.c.EY().WO(str4).field_contactLabelIds;
                dc = com.tencent.mm.plugin.label.c.dd(str, this.nOK);
                x.i("MicroMsg.Label.ContactLabelEditUI", "username:%s labels:%s mixLabelIds:%s", new Object[]{str4, str, dc});
                if (!dc.equalsIgnoreCase(str)) {
                    com_tencent_mm_protocal_c_brp = new brp();
                    com_tencent_mm_protocal_c_brp.ksU = str4;
                    com_tencent_mm_protocal_c_brp.vYL = dc;
                    linkedList.add(com_tencent_mm_protocal_c_brp);
                }
            }
        }
        if (linkedList.size() > 0) {
            ar.CG().a(new com.tencent.mm.plugin.label.b.d(linkedList), 0);
            return;
        }
        aVb();
    }

    private void Ds(String str) {
        getString(R.l.dGO);
        this.ltM = com.tencent.mm.ui.base.h.a(this, str, true, new 3(this));
    }

    private void aUZ() {
        if (this.ltM != null && this.ltM.isShowing()) {
            this.ltM.dismiss();
        }
    }

    private void yE(String str) {
        com.tencent.mm.ui.base.h.a(this, str, "", new 4(this));
    }

    public void onBackPressed() {
        if ((bh.ov(this.nOJ) || this.nOJ.equals(this.nOI)) && ((this.nOV == null || this.nOV.size() <= 0) && (this.nOW == null || this.nOW.size() <= 0))) {
            setResult(0);
            finish();
            return;
        }
        com.tencent.mm.ui.base.h.a(this, getString(R.l.eHf), "", getString(R.l.dNh), getString(R.l.dNi), new 5(this), new 6(this));
    }

    private void a(z zVar) {
        if (com.tencent.mm.plugin.label.e.aUW().a(true, zVar, new String[]{"labelID"})) {
            setResult(-1);
            finish();
            return;
        }
        x.w("MicroMsg.Label.ContactLabelEditUI", "cpan[doDeleteContactLabel] fail.");
        aVe();
    }

    private void aVe() {
        yE(getString(R.l.dYm));
    }

    protected final String getIdentString() {
        if (this.nOS) {
            return "_New";
        }
        return "_Edit";
    }
}
