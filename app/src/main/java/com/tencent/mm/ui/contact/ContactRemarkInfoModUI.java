package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.bb.c$a;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.sc;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.c.arq;
import com.tencent.mm.protocal.c.asc;
import com.tencent.mm.protocal.c.awz;
import com.tencent.mm.protocal.c.axa;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.tools.a.c.a;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.s;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContactRemarkInfoModUI extends MMActivity implements e {
    private String bgp;
    private String fWy;
    private String hKt;
    private x jLe;
    private ProgressDialog kVi;
    private String nPP;
    private int phF;
    private MMTagPanel pli;
    private List<String> plj;
    private b plk = new 1(this);
    private String username;
    private String vtR;
    private MMClearEditText yRD;
    private TextView yRE;
    private MMEditText yRF;
    private TextView yRG;
    private TextView yRH;
    private TextView yRI;
    private TextView yRJ;
    private ImageView yRK;
    private ImageView yRL;
    private TextView yRM;
    private View yRN;
    private View yRO;
    private String yRP;
    private boolean yRQ = false;
    private boolean yRR = false;
    private boolean yRS = false;
    private boolean yRT = false;
    private boolean yRU = false;
    private a yRV = new a(this, (byte) 0);
    private TextView yRW;
    private ScrollView yRX;
    private ProfileEditPhoneNumberView yRY;
    private String yRZ;
    private String ySa;
    private String ySb;
    boolean ySc = true;
    boolean ySd = false;
    private boolean ySe = false;

    private class c extends ClickableSpan {
        public String iIj;
        final /* synthetic */ ContactRemarkInfoModUI ySf;

        public c(ContactRemarkInfoModUI contactRemarkInfoModUI, String str) {
            this.ySf = contactRemarkInfoModUI;
            this.iIj = str;
        }

        public final void onClick(View view) {
            this.ySf.yRS = true;
            this.ySf.A(true, -1);
            this.ySf.yRD.setText(i.b(this.ySf, t.ou(this.iIj), this.ySf.yRD.getTextSize()));
            this.ySf.yRD.setSelection(this.ySf.yRD.getText().length());
            this.ySf.yRN.setVisibility(8);
        }

        public final void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.ySf.getResources().getColor(R.e.brA));
            textPaint.setUnderlineText(false);
        }
    }

    static /* synthetic */ void a(ContactRemarkInfoModUI contactRemarkInfoModUI, boolean z) {
        ar.Hg();
        if (!com.tencent.mm.z.c.isSDCardAvailable()) {
            u.fI(contactRemarkInfoModUI);
        }
        if (z) {
            h.a(contactRemarkInfoModUI, "", new String[]{contactRemarkInfoModUI.getString(R.l.eJt), contactRemarkInfoModUI.getString(R.l.dEw)}, "", new com.tencent.mm.ui.base.h.c(contactRemarkInfoModUI) {
                final /* synthetic */ ContactRemarkInfoModUI ySf;

                {
                    this.ySf = r1;
                }

                public final void jl(int i) {
                    switch (i) {
                        case 0:
                            com.tencent.mm.sdk.platformtools.x.d("MiroMsg.ContactRemarkInfoModUI", "pick up an image");
                            Intent intent = new Intent();
                            intent.putExtra("max_select_count", 1);
                            intent.putExtra("query_source_type", 0);
                            intent.putExtra("send_btn_string", " ");
                            intent.addFlags(67108864);
                            d.b(this.ySf, "gallery", ".ui.GalleryEntryUI", intent, 200);
                            return;
                        case 1:
                            com.tencent.mm.sdk.platformtools.x.d("MiroMsg.ContactRemarkInfoModUI", "delete the remark image when download failed.");
                            this.ySf.cvS();
                            return;
                        default:
                            return;
                    }
                }
            });
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("max_select_count", 1);
        intent.putExtra("query_source_type", 0);
        intent.putExtra("send_btn_string", " ");
        intent.addFlags(67108864);
        d.b(contactRemarkInfoModUI, "gallery", ".ui.GalleryEntryUI", intent, 200);
    }

    static /* synthetic */ void c(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        Intent intent = new Intent();
        intent.putExtra("label_id_list", contactRemarkInfoModUI.nPP);
        if (contactRemarkInfoModUI.plj != null) {
            intent.putStringArrayListExtra("label_str_list", (ArrayList) contactRemarkInfoModUI.plj);
        }
        intent.putExtra("label_username", contactRemarkInfoModUI.username);
        d.b(contactRemarkInfoModUI, "label", ".ui.ContactLabelUI", intent, 600);
    }

    static /* synthetic */ void q(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        com.tencent.mm.ui.tools.a.c.d(contactRemarkInfoModUI.yRD).GN(100).a(new 4(contactRemarkInfoModUI));
        com.tencent.mm.ui.tools.a.c.d(contactRemarkInfoModUI.yRF).GN(800).a(new a(contactRemarkInfoModUI) {
            final /* synthetic */ ContactRemarkInfoModUI ySf;

            {
                this.ySf = r1;
            }

            public final void uY(String str) {
            }

            public final void amI() {
            }

            public final void aem() {
                h.h(this.ySf, R.l.eLO, R.l.eLT);
                this.ySf.ySc = false;
            }
        });
        if (contactRemarkInfoModUI.ySc) {
            String obj;
            com.tencent.mm.sdk.platformtools.x.i("MiroMsg.ContactRemarkInfoModUI", "[dealModRemarkDesc] :%s", contactRemarkInfoModUI.username);
            if (contactRemarkInfoModUI.cvQ()) {
                obj = contactRemarkInfoModUI.yRF.getText().toString();
                contactRemarkInfoModUI.fWy = obj;
                com.tencent.mm.bq.a com_tencent_mm_protocal_c_arq = new arq();
                com_tencent_mm_protocal_c_arq.wzx = contactRemarkInfoModUI.username;
                com_tencent_mm_protocal_c_arq.nfe = obj;
                ar.Hg();
                com.tencent.mm.z.c.EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(54, com_tencent_mm_protocal_c_arq));
            }
            String obj2 = contactRemarkInfoModUI.yRD.getText().toString();
            com.tencent.mm.sdk.platformtools.x.i("MiroMsg.ContactRemarkInfoModUI", "Set New RemarkName : " + obj2 + ", Report kvStat, addContactScene = " + contactRemarkInfoModUI.phF);
            g.pQN.h(10448, Integer.valueOf(contactRemarkInfoModUI.phF));
            switch (contactRemarkInfoModUI.jLe.getSource()) {
                case 10:
                case 11:
                case 13:
                    com.tencent.mm.modelfriend.b kR = af.OD().kR(contactRemarkInfoModUI.jLe.field_username);
                    if (!(kR == null || t.ov(kR.Nt()))) {
                        if (t.ov(obj2)) {
                            kR.NB();
                        } else {
                            kR.hvp &= -2;
                        }
                        af.OD().a(kR.Nr(), kR);
                        break;
                    }
            }
            ar.Hg();
            bf EZ = com.tencent.mm.z.c.EZ().EZ(contactRemarkInfoModUI.jLe.field_username);
            if ((EZ == null || t.ov(EZ.field_encryptUsername)) && !t.ov(contactRemarkInfoModUI.jLe.field_encryptUsername)) {
                ar.Hg();
                EZ = com.tencent.mm.z.c.EZ().EZ(contactRemarkInfoModUI.jLe.field_encryptUsername);
            }
            if (!(EZ == null || t.ov(EZ.field_encryptUsername))) {
                ar.Hg();
                com.tencent.mm.z.c.EZ().Fa(EZ.field_encryptUsername);
            }
            if (contactRemarkInfoModUI.na(false)) {
                contactRemarkInfoModUI.bgp = obj2;
                com.tencent.mm.sdk.platformtools.x.i("MiroMsg.ContactRemarkInfoModUI", "usernamne %s operationSetRemark %s", contactRemarkInfoModUI.jLe.field_username, obj2);
                s.b(contactRemarkInfoModUI.jLe, obj2);
            } else {
                com.tencent.mm.sdk.platformtools.x.i("MiroMsg.ContactRemarkInfoModUI", "remarkNameChanged", Boolean.valueOf(contactRemarkInfoModUI.na(false)));
            }
            contactRemarkInfoModUI.cvP();
            obj = contactRemarkInfoModUI.bgp;
            obj2 = contactRemarkInfoModUI.fWy;
            String str = contactRemarkInfoModUI.hKt;
            com.tencent.mm.sdk.platformtools.x.i("MiroMsg.ContactRemarkInfoModUI", "[saveRemarkInfo] :%s :%s", contactRemarkInfoModUI.username, obj);
            ar.Hg();
            com.tencent.mm.g.b.af WO = com.tencent.mm.z.c.EY().WO(contactRemarkInfoModUI.username);
            if (WO == null || ((int) WO.gJd) <= 0 || !com.tencent.mm.l.a.fZ(WO.field_type)) {
                com.tencent.mm.sdk.platformtools.x.e("MiroMsg.ContactRemarkInfoModUI", "[saveRemarkInfo] is error!");
            } else {
                contactRemarkInfoModUI.jLe.da(obj);
                contactRemarkInfoModUI.jLe.dw(obj2);
                contactRemarkInfoModUI.jLe.dx(str);
                contactRemarkInfoModUI.jLe.AM();
                ar.Hg();
                boolean Q = com.tencent.mm.z.c.EY().Q(contactRemarkInfoModUI.jLe);
                com.tencent.mm.sdk.platformtools.x.i("MiroMsg.ContactRemarkInfoModUI", "saveRemarkInfo ret %s", Boolean.valueOf(Q));
                str = "MiroMsg.ContactRemarkInfoModUI";
                String str2 = "remarkDesc (%s, %s, %s)";
                Object[] objArr = new Object[3];
                objArr[0] = Boolean.valueOf(obj2 == null);
                objArr[1] = Integer.valueOf(obj2 == null ? 0 : obj2.length());
                objArr[2] = obj2 == null ? "" : bh.VT(obj2);
                com.tencent.mm.sdk.platformtools.x.i(str, str2, objArr);
                com.tencent.mm.sdk.b.a.xef.m(new sc());
            }
            if (!contactRemarkInfoModUI.cvR()) {
                contactRemarkInfoModUI.finish();
            } else if (contactRemarkInfoModUI.yRU) {
                ar.CG().a(new com.tencent.mm.bb.a(contactRemarkInfoModUI.username), 0);
                contactRemarkInfoModUI.getString(R.l.dGO);
                contactRemarkInfoModUI.kVi = h.a(contactRemarkInfoModUI, contactRemarkInfoModUI.getString(R.l.dUD), false, new 8(contactRemarkInfoModUI));
            } else {
                ar.CG().a(new com.tencent.mm.bb.b(contactRemarkInfoModUI.username, contactRemarkInfoModUI.yRP), 0);
                contactRemarkInfoModUI.getString(R.l.dGO);
                contactRemarkInfoModUI.kVi = h.a(contactRemarkInfoModUI, contactRemarkInfoModUI.getString(R.l.dUE), false, null);
            }
        }
    }

    private void axO() {
        boolean z;
        ProfileEditPhoneNumberView profileEditPhoneNumberView = this.yRY;
        ArrayList can = profileEditPhoneNumberView.can();
        if (can == null || can.isEmpty()) {
            if (profileEditPhoneNumberView.vkK != null) {
                z = true;
            }
            z = false;
        } else if (profileEditPhoneNumberView.vkK == null) {
            z = true;
        } else if (can.size() != profileEditPhoneNumberView.vkK.length) {
            z = true;
        } else {
            Iterator it = can.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (!((String) it.next()).equals(profileEditPhoneNumberView.vkK[i])) {
                    z = true;
                    break;
                }
                i++;
            }
            z = false;
        }
        this.ySe = z;
        if (cvQ() || cvR() || na(false) || this.ySe) {
            enableOptionMenu(true);
        } else {
            enableOptionMenu(false);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.CG().a(575, (e) this);
        ar.CG().a(576, (e) this);
        this.phF = getIntent().getIntExtra("Contact_Scene", 9);
        this.vtR = getIntent().getStringExtra("Contact_RoomNickname");
        this.yRT = getIntent().getBooleanExtra("view_mode", false);
        this.ySb = getIntent().getStringExtra("contact_auto_app_phone_from_chatting");
        this.yRZ = getIntent().getStringExtra("contact_phone_number_by_md5");
        this.ySa = getIntent().getStringExtra("contact_phone_number_list");
        this.username = getIntent().getStringExtra("Contact_User");
        if (t.ov(this.username)) {
            finish();
            return;
        }
        ar.Hg();
        this.jLe = com.tencent.mm.z.c.EY().WO(this.username);
        this.bgp = this.jLe.field_conRemark;
        this.fWy = this.jLe.fWy;
        this.hKt = this.jLe.fWz;
        this.nPP = this.jLe.field_contactLabelIds;
        this.plj = com.tencent.mm.plugin.label.a.a.aUX().Dq(this.nPP);
        initView();
        axO();
    }

    public void onResume() {
        super.onResume();
        ar.Hg();
        com.tencent.mm.z.c.EY().a(this.plk);
        bjM();
    }

    protected void onPause() {
        ar.Hg();
        com.tencent.mm.z.c.EY().b(this.plk);
        super.onPause();
    }

    public void onDestroy() {
        ar.CG().b(575, (e) this);
        ar.CG().b(576, (e) this);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.deW;
    }

    private void A(boolean z, int i) {
        if (this.yRS) {
            this.yRG.setVisibility(8);
            if (z && t.ov(this.fWy)) {
                this.yRH.setVisibility(0);
                this.yRO.setVisibility(8);
            } else if (i == R.h.bXN) {
                this.yRH.setVisibility(8);
                this.yRO.setVisibility(0);
            }
            this.yRD.setVisibility(0);
            return;
        }
        this.yRG.setVisibility(0);
        this.yRH.setVisibility(0);
        this.yRD.setVisibility(8);
        this.yRO.setVisibility(8);
    }

    protected final void initView() {
        boolean z;
        this.yRE = (TextView) findViewById(R.h.bXH);
        this.yRG = (TextView) findViewById(R.h.bXP);
        this.yRH = (TextView) findViewById(R.h.bXN);
        this.yRI = (TextView) findViewById(R.h.bXO);
        this.yRD = (MMClearEditText) findViewById(R.h.bXG);
        this.yRF = (MMEditText) findViewById(R.h.bXF);
        this.yRK = (ImageView) findViewById(R.h.cHB);
        this.yRL = (ImageView) findViewById(R.h.cHC);
        this.yRJ = (TextView) findViewById(R.h.cZH);
        this.yRO = findViewById(R.h.bXE);
        this.yRY = (ProfileEditPhoneNumberView) findViewById(R.h.cwT);
        this.yRY.lFr = this.jLe;
        ProfileEditPhoneNumberView profileEditPhoneNumberView = this.yRY;
        String str = this.yRZ;
        String str2 = this.ySa;
        profileEditPhoneNumberView.vkI = str;
        profileEditPhoneNumberView.vkJ = str2;
        profileEditPhoneNumberView.bjL();
        this.yRY.vkN = new 10(this);
        this.pli = (MMTagPanel) findViewById(R.h.bXD);
        this.pli.ndg = false;
        this.yRX = (ScrollView) findViewById(R.h.cJh);
        this.yRW = (TextView) findViewById(R.h.bXB);
        this.yRW.setText(R.l.evu);
        this.pli.setOnClickListener(this.yRV);
        this.yRW.setOnClickListener(this.yRV);
        setMMTitle(R.l.dVF);
        if (t.ov(this.bgp)) {
            this.yRD.setText(i.b(this, t.ou(this.jLe.AP()), this.yRD.getTextSize()));
            this.yRG.setText(i.b(this, t.ou(this.jLe.AP()), this.yRD.getTextSize()));
        } else {
            this.yRD.setText(i.b(this, t.ou(this.bgp), this.yRD.getTextSize()));
            this.yRG.setText(i.b(this, t.ou(this.bgp), this.yRG.getTextSize()));
        }
        this.yRD.setSelection(this.yRD.getText().length());
        this.yRF.setText(i.b(this, t.ou(this.fWy), this.yRH.getTextSize()));
        this.yRF.setSelection(this.yRF.getText().length());
        if (!t.ov(this.fWy)) {
            this.yRH.setText(i.b(this, t.ou(this.fWy), this.yRH.getTextSize()));
            this.yRH.setTextColor(getResources().getColor(R.e.btv));
        }
        this.yRG.setOnClickListener(new 12(this));
        this.yRH.setOnClickListener(new 13(this));
        this.yRD.addTextChangedListener(new 14(this));
        this.yRJ.setText(com.tencent.mm.ui.tools.h.aY(800, this.yRF.getEditableText().toString()));
        this.yRF.setOnFocusChangeListener(new 15(this));
        this.yRF.addTextChangedListener(new b(this, (byte) 0));
        if (t.ov(this.hKt)) {
            this.yRI.setVisibility(0);
            this.yRK.setVisibility(8);
        } else {
            this.yRI.setVisibility(8);
            this.yRK.setVisibility(0);
            com.tencent.mm.bb.c.QL();
            if (com.tencent.mm.bb.c.lP(this.username)) {
                cvO();
            } else {
                com.tencent.mm.bb.c.QL().a(this.username, this.hKt, new c$a(this) {
                    final /* synthetic */ ContactRemarkInfoModUI ySf;

                    {
                        this.ySf = r1;
                    }

                    public final void bQ(boolean z) {
                        this.ySf.yRK.post(new 1(this, z));
                    }
                });
            }
        }
        this.yRK.setOnClickListener(new 16(this));
        this.yRI.setOnClickListener(new 17(this));
        com.tencent.mm.modelfriend.b kR = af.OD().kR(this.jLe.field_username);
        if (kR == null || t.ov(kR.Nt()) || kR.Nt().equals(this.yRD.getText().toString())) {
            z = false;
        } else {
            this.yRM = (TextView) findViewById(R.h.cwZ);
            this.yRN = findViewById(R.h.cwU);
            this.yRN.setVisibility(0);
            this.yRM.setText(t.ou(getString(R.l.dWt, new Object[]{kR.Nt()})));
            CharSequence jVar = new j(getString(R.l.eXQ));
            jVar.setSpan(new c(this, kR.Nt()), 0, jVar.length(), 17);
            this.yRM.append(" ");
            this.yRM.append(jVar);
            this.yRM.setMovementMethod(LinkMovementMethod.getInstance());
            z = true;
        }
        if (!(z || this.phF != 14 || t.ov(this.vtR) || this.vtR.equals(this.yRD.getText().toString()))) {
            this.yRM = (TextView) findViewById(R.h.cwZ);
            this.yRN = findViewById(R.h.cwU);
            this.yRN.setVisibility(0);
            this.yRM.setText(i.b(this, t.ou(getString(R.l.dWs, new Object[]{this.vtR})), this.yRM.getTextSize()));
            jVar = new j(getString(R.l.eXQ));
            jVar.setSpan(new c(this, this.vtR), 0, jVar.length(), 17);
            this.yRM.append(" ");
            this.yRM.append(jVar);
            this.yRM.setMovementMethod(LinkMovementMethod.getInstance());
        }
        a(0, getString(R.l.dFl), new 18(this), p.b.xJz);
        setBackBtn(new 2(this));
        if (t.ov(this.bgp)) {
            enableOptionMenu(true);
        } else {
            enableOptionMenu(false);
        }
        this.yRL.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ContactRemarkInfoModUI ySf;

            {
                this.ySf = r1;
            }

            public final void onClick(View view) {
                ContactRemarkInfoModUI.a(this.ySf, true);
                this.ySf.cvN();
            }
        });
        if (!this.yRT) {
            this.yRS = true;
            A(true, -1);
        }
        cvN();
    }

    private void cvN() {
        this.yRE.setFocusableInTouchMode(true);
        this.yRE.requestFocus();
        this.yRD.clearFocus();
        this.yRF.clearFocus();
        this.yRY.clearFocus();
        aWs();
    }

    private void cvO() {
        Bitmap lR = com.tencent.mm.bb.c.QL().lR(this.username);
        if (lR != null) {
            this.yRI.setVisibility(8);
            this.yRL.setVisibility(8);
            this.yRK.setVisibility(0);
            this.yRK.setImageBitmap(lR);
        }
        this.yRQ = true;
    }

    private void ZA(String str) {
        if (!t.ov(str)) {
            File file = new File(str);
            if (!file.exists()) {
                return;
            }
            if (file.length() > 204800) {
                h.b(this, getString(R.l.dUC), null, true);
                return;
            }
            Bitmap b = BackwardSupportUtil.b.b(this.yRP, com.tencent.mm.bv.a.getDensity(this));
            if (b != null) {
                this.yRI.setVisibility(8);
                this.yRL.setVisibility(8);
                this.yRK.setVisibility(0);
                this.yRK.setImageBitmap(b);
                this.yRQ = true;
            }
        }
    }

    private void cvP() {
        if (this.ySe) {
            String str;
            com.tencent.mm.bq.a com_tencent_mm_protocal_c_asc = new asc();
            com_tencent_mm_protocal_c_asc.wzx = this.username;
            axa com_tencent_mm_protocal_c_axa = new axa();
            ArrayList can = this.yRY.can();
            com_tencent_mm_protocal_c_axa.ksO = can == null ? 0 : can.size();
            com_tencent_mm_protocal_c_axa.wEp = new LinkedList();
            if (can != null) {
                Iterator it = can.iterator();
                while (it.hasNext()) {
                    str = (String) it.next();
                    awz com_tencent_mm_protocal_c_awz = new awz();
                    com_tencent_mm_protocal_c_awz.wEo = str;
                    com_tencent_mm_protocal_c_axa.wEp.add(com_tencent_mm_protocal_c_awz);
                }
            }
            com_tencent_mm_protocal_c_asc.wzt = com_tencent_mm_protocal_c_axa;
            ar.Hg();
            com.tencent.mm.z.c.EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(60, com_tencent_mm_protocal_c_asc));
            ar.Hg();
            com.tencent.mm.g.b.af WO = com.tencent.mm.z.c.EY().WO(this.username);
            if (WO != null && ((int) WO.gJd) > 0 && com.tencent.mm.l.a.fZ(WO.field_type)) {
                String str2;
                str = "";
                if (can != null) {
                    Iterator it2 = can.iterator();
                    str2 = str;
                    while (it2.hasNext()) {
                        str2 = (str2 + ((String) it2.next())) + ",";
                    }
                } else {
                    str2 = str;
                }
                com.tencent.mm.sdk.platformtools.x.i("MiroMsg.ContactRemarkInfoModUI", "[dealModPhoneNumberList] username:%s %s", this.username, str2);
                this.jLe.dC(str2);
                ar.Hg();
                com.tencent.mm.z.c.EY().Q(this.jLe);
            }
        }
    }

    private boolean na(boolean z) {
        String obj = this.yRD.getText().toString();
        if (z) {
            boolean z2;
            if ((this.bgp == null || !this.bgp.equals(obj)) && !(t.ov(this.bgp) && t.ov(obj))) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 || (obj != null && obj.equals(this.jLe.field_nickname))) {
                return false;
            }
            return true;
        } else if ((this.bgp == null || !this.bgp.equals(obj)) && (!t.ov(this.bgp) || !t.ov(obj))) {
            return true;
        } else {
            return false;
        }
    }

    private boolean cvQ() {
        String obj = this.yRF.getText().toString();
        return (this.fWy == null || !this.fWy.equals(obj)) && !(t.ov(this.fWy) && t.ov(obj));
    }

    private boolean cvR() {
        return !t.ov(this.yRP) || this.yRU;
    }

    private void goBack() {
        boolean cvR = cvR();
        boolean na = na(true);
        boolean cvQ = cvQ();
        if (cvR || na || cvQ) {
            h.a(this, getString(R.l.dWe), null, getString(R.l.dWg), getString(R.l.dWf), new 9(this), new 11(this));
            return;
        }
        aWs();
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return false;
        }
        goBack();
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        com.tencent.mm.sdk.platformtools.x.i("MiroMsg.ContactRemarkInfoModUI", "onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (intent == null) {
            com.tencent.mm.sdk.platformtools.x.e("MiroMsg.ContactRemarkInfoModUI", "data shouldnot be null");
            return;
        }
        Context applicationContext;
        String b;
        switch (i) {
            case 100:
                applicationContext = getApplicationContext();
                ar.Hg();
                b = k.b(applicationContext, intent, com.tencent.mm.z.c.Fi());
                if (b != null) {
                    this.yRP = ZB(b);
                    ZA(this.yRP);
                    this.yRR = true;
                    this.yRU = false;
                    axO();
                    return;
                }
                return;
            case 200:
                applicationContext = getApplicationContext();
                ar.Hg();
                b = com.tencent.mm.ui.tools.a.c(applicationContext, intent, com.tencent.mm.z.c.Fi());
                if (b != null) {
                    this.yRP = ZB(b);
                    ZA(this.yRP);
                    this.yRR = true;
                    this.yRU = false;
                    axO();
                    return;
                }
                return;
            case 400:
                if (intent.getBooleanExtra("response_delete", false)) {
                    cvS();
                    return;
                }
                return;
            case 600:
                if (na(true) || cvQ() || cvR() || intent.getBooleanExtra("hasLableChange", false)) {
                    enableOptionMenu(true);
                    return;
                } else {
                    enableOptionMenu(false);
                    return;
                }
            default:
                return;
        }
    }

    private void cvS() {
        this.yRU = true;
        this.yRL.setVisibility(8);
        this.yRI.setVisibility(0);
        this.yRK.setVisibility(8);
        this.yRK.setImageBitmap(null);
        axO();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        com.tencent.mm.sdk.platformtools.x.i("MiroMsg.ContactRemarkInfoModUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.kVi != null) {
            this.kVi.dismiss();
            this.kVi = null;
        }
        if (i == 0 && i2 == 0) {
            if (kVar.getType() == 575) {
                if (this.yRP != null) {
                    File file = new File(this.yRP);
                    if (file.exists()) {
                        com.tencent.mm.bb.c.QL();
                        file.renameTo(new File(com.tencent.mm.bb.c.lO(this.username)));
                    }
                }
                String str2 = ((com.tencent.mm.bb.b) kVar).hKt;
                if (!t.ov(str2)) {
                    this.hKt = str2;
                }
            } else if (kVar.getType() == 576) {
                this.yRP = null;
                this.hKt = null;
                this.yRQ = false;
                ar.Hg();
                this.jLe = com.tencent.mm.z.c.EY().WO(this.username);
                this.jLe.dx("");
                ar.Hg();
                com.tencent.mm.z.c.EY().a(this.username, this.jLe);
            }
            finish();
            return;
        }
        h.b(this, getString(R.l.dEO), null, true);
    }

    private String ZB(String str) {
        if (!com.tencent.mm.a.e.bO(str)) {
            return null;
        }
        int UJ = ExifHelper.UJ(str);
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.bb.c.QL();
        String stringBuilder2 = stringBuilder.append(com.tencent.mm.bb.c.lO(this.username)).append(".tmp").toString();
        if (!com.tencent.mm.sdk.platformtools.d.a(str, 960, 960, CompressFormat.JPEG, 70, stringBuilder2)) {
            com.tencent.mm.sdk.platformtools.x.e("MiroMsg.ContactRemarkInfoModUI", "createThumbNail big pic fail");
            return null;
        } else if (UJ == 0 || com.tencent.mm.sdk.platformtools.d.a(stringBuilder2, UJ, CompressFormat.JPEG, 70, stringBuilder2)) {
            return stringBuilder2;
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MiroMsg.ContactRemarkInfoModUI", "rotate big pic fail");
            return null;
        }
    }

    private void bjM() {
        ar.Hg();
        this.jLe = com.tencent.mm.z.c.EY().WO(this.username);
        this.nPP = this.jLe.field_contactLabelIds;
        this.plj = com.tencent.mm.plugin.label.a.a.aUX().Dq(this.nPP);
        if (t.ov(this.nPP)) {
            this.pli.setVisibility(8);
            this.yRW.setVisibility(0);
            return;
        }
        this.pli.setVisibility(0);
        this.yRW.setVisibility(8);
        this.pli.a(this.plj, this.plj);
    }
}
