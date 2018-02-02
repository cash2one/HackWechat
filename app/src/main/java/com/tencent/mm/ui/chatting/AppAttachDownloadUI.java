package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.f;
import com.tencent.mm.ae.k;
import com.tencent.mm.bc.m;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.g.a.iw;
import com.tencent.mm.g.a.ll;
import com.tencent.mm.modelsimple.aj;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.ab.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.y;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.g;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AppAttachDownloadUI extends MMActivity implements e, a, j.a {
    private boolean fBV;
    private String fDP;
    private au fEJ;
    private String fileName;
    private long fqm;
    private String fzO;
    private String hbp;
    private int hts;
    private String iHF;
    private ProgressBar lAk;
    private f lAl;
    private Button mHK;
    private String mediaId;
    private Button mvX;
    private View mwb;
    private String nBp;
    private MMImageView pqk;
    private ImageView pql;
    private ab vex;
    private TextView xUr;
    private View ypk;
    private TextView ypl;
    private TextView ypm;
    private boolean ypn;
    private g.a ypo;
    private boolean ypp = false;
    private boolean ypq = false;
    private boolean ypr = true;
    private int yps = 5000;
    private LinearLayout ypt;
    private LinearLayout ypu;

    static /* synthetic */ void a(AppAttachDownloadUI appAttachDownloadUI, boolean z) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        if (z) {
            b dhVar = new dh();
            dhVar.frQ.fqm = appAttachDownloadUI.fqm;
            com.tencent.mm.sdk.b.a.xef.m(dhVar);
            switch (appAttachDownloadUI.hts) {
                case 0:
                    arrayList.add(appAttachDownloadUI.getString(R.l.eEC));
                    arrayList.add(appAttachDownloadUI.getString(R.l.dZa));
                    arrayList2.add(Integer.valueOf(0));
                    arrayList2.add(Integer.valueOf(3));
                    if (dhVar.frR.frp) {
                        arrayList.add(appAttachDownloadUI.getString(R.l.dZe));
                        arrayList2.add(Integer.valueOf(4));
                        break;
                    }
                    break;
                case 6:
                    arrayList.add(appAttachDownloadUI.getString(R.l.eEC));
                    arrayList.add(appAttachDownloadUI.getString(R.l.dZa));
                    arrayList2.add(Integer.valueOf(0));
                    arrayList2.add(Integer.valueOf(3));
                    Long Rc = com.tencent.mm.pluginsdk.b.a.Rc(appAttachDownloadUI.iHF);
                    if (dhVar.frR.frp || (Rc != null && com.tencent.mm.pluginsdk.model.app.g.m(appAttachDownloadUI.mController.xIM, Rc.longValue()))) {
                        arrayList.add(appAttachDownloadUI.getString(R.l.dZe));
                        arrayList2.add(Integer.valueOf(4));
                    }
                    if (d.OQ("favorite")) {
                        arrayList.add(appAttachDownloadUI.getString(R.l.eAd));
                        arrayList2.add(Integer.valueOf(2));
                        break;
                    }
                    break;
                default:
                    arrayList.add(appAttachDownloadUI.getString(R.l.eEC));
                    arrayList2.add(Integer.valueOf(0));
                    break;
            }
        } else if (d.OQ("favorite")) {
            arrayList.add(appAttachDownloadUI.getString(R.l.eAd));
            arrayList2.add(Integer.valueOf(2));
        }
        if (com.tencent.mm.sdk.a.b.ceK()) {
            if (appAttachDownloadUI.fileName.startsWith("fts_template") && appAttachDownloadUI.fileName.endsWith(".zip")) {
                arrayList.add(appAttachDownloadUI.getString(R.l.dYU));
                arrayList2.add(Integer.valueOf(5));
            } else if (appAttachDownloadUI.fileName.startsWith("was_template") && appAttachDownloadUI.fileName.endsWith(".zip")) {
                arrayList.add(appAttachDownloadUI.getString(R.l.dYV));
                arrayList2.add(Integer.valueOf(6));
            }
            if (appAttachDownloadUI.fileName.startsWith("fts_feature") && appAttachDownloadUI.fileName.endsWith(".zip")) {
                arrayList.add(appAttachDownloadUI.getString(R.l.dYT));
                arrayList2.add(Integer.valueOf(7));
            }
            if (appAttachDownloadUI.fileName.startsWith("wrd_template") && appAttachDownloadUI.fileName.endsWith(".zip")) {
                arrayList.add(appAttachDownloadUI.getString(R.l.dYS));
                arrayList2.add(Integer.valueOf(8));
            }
        }
        h.a(appAttachDownloadUI, null, arrayList, arrayList2, null, false, new 3(appAttachDownloadUI));
    }

    static /* synthetic */ void c(AppAttachDownloadUI appAttachDownloadUI) {
        boolean z;
        if (appAttachDownloadUI.ypo != null) {
            z = appAttachDownloadUI.ypo.hbf != 0 || appAttachDownloadUI.ypo.hbb > 26214400;
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
            Object[] objArr = new Object[6];
            objArr[0] = appAttachDownloadUI.ypo.hbi;
            objArr[1] = Integer.valueOf(appAttachDownloadUI.ypo.hbf == 1 ? 7 : 5);
            objArr[2] = Integer.valueOf(appAttachDownloadUI.ypo.hbb);
            objArr[3] = Integer.valueOf(2);
            objArr[4] = Long.valueOf((System.currentTimeMillis() - appAttachDownloadUI.fEJ.field_createTime) / 1000);
            objArr[5] = appAttachDownloadUI.iHF;
            gVar.h(14665, objArr);
        } else {
            z = false;
        }
        Intent intent = new Intent(appAttachDownloadUI, MsgRetransmitUI.class);
        intent.putExtra("Retr_Msg_content", appAttachDownloadUI.fDP);
        intent.putExtra("Retr_Msg_Type", 2);
        intent.putExtra("Retr_Msg_Id", appAttachDownloadUI.fEJ.field_msgId);
        intent.putExtra("Retr_Big_File", z);
        appAttachDownloadUI.startActivity(intent);
    }

    static /* synthetic */ void d(AppAttachDownloadUI appAttachDownloadUI) {
        b cfVar = new cf();
        com.tencent.mm.pluginsdk.model.f.a(cfVar, appAttachDownloadUI.fEJ);
        cfVar.fqp.activity = appAttachDownloadUI;
        cfVar.fqp.fqw = 39;
        com.tencent.mm.sdk.b.a.xef.m(cfVar);
    }

    static /* synthetic */ void e(AppAttachDownloadUI appAttachDownloadUI) {
        Intent intent = new Intent(appAttachDownloadUI, AppAttachFileListUI.class);
        intent.setFlags(67108864);
        appAttachDownloadUI.startActivity(intent);
        com.tencent.mm.plugin.report.service.g.pQN.h(11168, new Object[]{Integer.valueOf(6), Integer.valueOf(1)});
    }

    static /* synthetic */ void f(AppAttachDownloadUI appAttachDownloadUI) {
        Intent intent = new Intent(appAttachDownloadUI, ChattingSendDataToDeviceUI.class);
        intent.putExtra("Retr_Msg_Id", appAttachDownloadUI.fEJ.field_msgId);
        appAttachDownloadUI.startActivity(intent);
    }

    static /* synthetic */ void g(AppAttachDownloadUI appAttachDownloadUI) {
        if (appAttachDownloadUI.cqT() != null) {
            b iwVar = new iw();
            iwVar.fzw.fpm = 27;
            iwVar.fzw.fpn = 1;
            if (appAttachDownloadUI.cqT() != null) {
                iwVar.fzw.filePath = appAttachDownloadUI.cqT().field_fileFullPath;
            }
            com.tencent.mm.sdk.b.a.xef.m(iwVar);
            u.makeText(ac.getContext(), String.format("current template is %d", new Object[]{Integer.valueOf(com.tencent.mm.plugin.aj.a.g.zN(0))}), 1).show();
        }
    }

    static /* synthetic */ void h(AppAttachDownloadUI appAttachDownloadUI) {
        b bcVar = new bc();
        bcVar.fpl.fpm = 35;
        bcVar.fpl.fpn = 1;
        if (appAttachDownloadUI.cqT() != null) {
            bcVar.fpl.filePath = appAttachDownloadUI.cqT().field_fileFullPath;
        }
        com.tencent.mm.sdk.b.a.xef.m(bcVar);
        u.makeText(ac.getContext(), String.format("apply success", new Object[0]), 1).show();
    }

    static /* synthetic */ void i(AppAttachDownloadUI appAttachDownloadUI) {
        b iwVar = new iw();
        iwVar.fzw.fpm = 40;
        iwVar.fzw.fpn = 1;
        if (appAttachDownloadUI.cqT() != null) {
            iwVar.fzw.filePath = appAttachDownloadUI.cqT().field_fileFullPath;
            iwVar.fzw.filePath = appAttachDownloadUI.cqT().field_fileFullPath;
        }
        com.tencent.mm.sdk.b.a.xef.m(iwVar);
        u.makeText(ac.getContext(), String.format("current wxa template is %d", new Object[]{Integer.valueOf(m.Ri())}), 1).show();
    }

    static /* synthetic */ void j(AppAttachDownloadUI appAttachDownloadUI) {
        b iwVar = new iw();
        iwVar.fzw.fpm = 27;
        iwVar.fzw.fpn = 2;
        if (appAttachDownloadUI.cqT() != null) {
            iwVar.fzw.filePath = appAttachDownloadUI.cqT().field_fileFullPath;
        }
        com.tencent.mm.sdk.b.a.xef.m(iwVar);
        u.makeText(ac.getContext(), String.format("current browse template is %d", new Object[]{Integer.valueOf(com.tencent.mm.plugin.aj.a.g.zN(1))}), 1).show();
    }

    static /* synthetic */ void u(AppAttachDownloadUI appAttachDownloadUI) {
        com.tencent.mm.pluginsdk.model.app.b cqT = appAttachDownloadUI.cqT();
        if (cqT == null) {
            x.e("MicroMsg.AppAttachDownloadUI", "open fail, info is null");
        } else if (cqT.field_fileFullPath == null || cqT.field_fileFullPath.length() == 0) {
            x.e("MicroMsg.AppAttachDownloadUI", "open fail, field fileFullPath is null");
        } else {
            com.tencent.mm.pluginsdk.ui.tools.a.b(appAttachDownloadUI, cqT.field_fileFullPath, appAttachDownloadUI.iHF, 1);
            appAttachDownloadUI.mvX.setEnabled(false);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        init();
    }

    private void init() {
        boolean z;
        setMMTitle(R.l.ccS);
        this.fqm = getIntent().getLongExtra("app_msg_id", -1);
        if (this.fqm == -1) {
            z = false;
        } else {
            ar.Hg();
            this.fEJ = c.Fa().dH(this.fqm);
            if (this.fEJ == null || this.fEJ.field_msgId == 0 || this.fEJ.field_content == null) {
                z = false;
            } else {
                this.ypn = s.eV(this.fEJ.field_talker);
                this.fDP = this.fEJ.field_content;
                if (this.ypn && this.fEJ.field_isSend == 0) {
                    String str = this.fEJ.field_content;
                    if (this.ypn && str != null) {
                        str = ba.hQ(str);
                    }
                    this.fDP = str;
                }
                this.ypo = g.a.fT(this.fDP);
                if (this.ypo == null) {
                    x.e("MicroMsg.AppAttachDownloadUI", "summerapp parse msgContent error, %s", new Object[]{this.fDP});
                    z = false;
                } else {
                    if (t.ov(this.ypo.fny) && !t.ov(this.ypo.hbi)) {
                        x.e("MicroMsg.AppAttachDownloadUI", "summerapp msgContent format error, %s", new Object[]{this.fDP});
                        this.ypo.fny = this.ypo.hbi.hashCode();
                    }
                    this.hts = this.ypo.type;
                    this.mediaId = this.ypo.fny;
                    this.fileName = t.ou(this.ypo.title);
                    this.iHF = t.ou(this.ypo.hbc).toLowerCase();
                    this.nBp = t.ou(this.ypo.filemd5);
                    this.fzO = t.ou(this.ypo.fzO);
                    this.hbp = t.ou(this.ypo.hbp);
                    x.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams msgId[%d], sender[%d], msgContent[%s], appType[%d], mediaId[%s], fileName[%s]", new Object[]{Long.valueOf(this.fqm), Integer.valueOf(this.fEJ.field_isSend), this.fDP, Integer.valueOf(this.hts), this.mediaId, this.fileName});
                    com.tencent.mm.pluginsdk.model.app.b cqT = cqT();
                    if (cqT == null) {
                        x.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo is null");
                        this.ypq = false;
                    } else {
                        File file = new File(cqT.field_fileFullPath);
                        if (cqT.field_offset > 0) {
                            this.ypq = true;
                        } else {
                            this.ypq = false;
                        }
                        x.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo field_fileFullPath[%s], field_offset[%d], isDownloadStarted[%b]", new Object[]{cqT.field_fileFullPath, Long.valueOf(cqT.field_offset), Boolean.valueOf(this.ypq)});
                    }
                    z = a(cqT) ? com.tencent.mm.pluginsdk.ui.tools.a.a(this, cqT.field_fileFullPath, this.iHF, 1) : true;
                }
            }
        }
        if (z) {
            File file2 = new File(com.tencent.mm.compatible.util.e.gHs);
            if (!file2.exists()) {
                file2.mkdir();
            }
            an.aqd().c(this);
            initView();
            return;
        }
        finish();
    }

    protected void onDestroy() {
        an.aqd().j(this);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        ar.CG().a(221, this);
        ar.CG().a(728, this);
        b llVar = new ll();
        llVar.fCN.fCO = true;
        com.tencent.mm.sdk.b.a.xef.a(llVar, getMainLooper());
        x.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI req pause auto download logic");
        this.mvX.setEnabled(true);
    }

    protected void onPause() {
        ar.CG().b(221, this);
        ar.CG().b(728, this);
        super.onPause();
        b llVar = new ll();
        llVar.fCN.fCO = false;
        com.tencent.mm.sdk.b.a.xef.a(llVar, getMainLooper());
        x.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI cancel pause auto download logic");
    }

    protected final void initView() {
        this.pqk = (MMImageView) findViewById(R.h.ccT);
        this.mwb = findViewById(R.h.ccK);
        this.lAk = (ProgressBar) findViewById(R.h.ccJ);
        this.pql = (ImageView) findViewById(R.h.ccO);
        this.mHK = (Button) findViewById(R.h.ccy);
        this.mvX = (Button) findViewById(R.h.ccI);
        this.ypk = findViewById(R.h.ccz);
        this.xUr = (TextView) findViewById(R.h.ccF);
        this.ypl = (TextView) findViewById(R.h.ccA);
        this.ypm = (TextView) findViewById(R.h.ccE);
        this.ypt = (LinearLayout) findViewById(R.h.ccG);
        this.ypu = (LinearLayout) findViewById(R.h.ctm);
        this.pql.setOnClickListener(new 5(this));
        this.mHK.setOnClickListener(new 6(this));
        this.mvX.setOnClickListener(new 7(this));
        switch (this.hts) {
            case 0:
            case 7:
                if (!bh.VW(this.iHF)) {
                    this.pqk.setImageResource(R.k.dvx);
                    break;
                } else {
                    this.pqk.setImageResource(R.g.byV);
                    break;
                }
            case 2:
                this.pqk.setImageResource(R.g.byV);
                break;
            case 4:
                this.pqk.setImageResource(R.k.dvA);
                break;
            case 6:
                this.pqk.setImageResource(r.Ry(this.iHF));
                break;
            default:
                this.pqk.setImageResource(R.k.dvx);
                break;
        }
        setBackBtn(new 1(this));
        this.fBV = getIntent().getBooleanExtra("app_show_share", true);
        if (this.fBV) {
            addIconOptionMenu(0, R.k.duY, new 2(this));
        }
        this.ypp = false;
        com.tencent.mm.pluginsdk.model.app.b cqT = cqT();
        boolean z = (cqT == null || !new File(cqT.field_fileFullPath).exists()) ? false : cqT.aOC() || (this.fEJ.field_isSend == 1 && cqT.field_isUpload);
        if (z) {
            x.i("MicroMsg.AppAttachDownloadUI", "summerapp isCanOpenFile");
            this.ypp = true;
            cqU();
        } else if (cqT != null && cqT.aOC() && !new File(cqT.field_fileFullPath).exists()) {
            x.i("MicroMsg.AppAttachDownloadUI", "summerapp set fail info[%s]", new Object[]{cqT});
            this.ypt.setVisibility(8);
            this.ypu.setVisibility(0);
        } else if (!this.ypp) {
            this.lAl = new 4(this);
            switch (this.hts) {
                case 0:
                case 6:
                    if (this.ypq) {
                        this.mHK.setVisibility(0);
                    } else {
                        this.mHK.setVisibility(8);
                    }
                    this.mwb.setVisibility(8);
                    this.ypk.setVisibility(8);
                    this.mvX.setVisibility(8);
                    this.xUr.setVisibility(8);
                    this.ypm.setVisibility(0);
                    if (this.fileName.equals("")) {
                        this.ypm.setText(getString(R.l.ezK));
                    } else {
                        this.ypm.setText(this.fileName);
                    }
                    String mimeType = getMimeType();
                    if (mimeType == null || mimeType.equals("")) {
                        this.xUr.setText(getString(R.l.dYW));
                    } else {
                        this.xUr.setText(getString(R.l.dYX));
                    }
                    if (bh.VW(this.iHF)) {
                        this.xUr.setVisibility(8);
                        break;
                    }
                    break;
                case 2:
                    this.mwb.setVisibility(8);
                    this.ypk.setVisibility(8);
                    if (this.ypq) {
                        this.mHK.setVisibility(0);
                    } else {
                        this.mHK.setVisibility(8);
                    }
                    this.mvX.setVisibility(8);
                    this.ypm.setVisibility(8);
                    this.xUr.setVisibility(8);
                    break;
                case 7:
                    if (this.ypq) {
                        this.mHK.setVisibility(0);
                    } else {
                        this.mHK.setVisibility(8);
                    }
                    this.mwb.setVisibility(8);
                    this.ypk.setVisibility(8);
                    this.mvX.setVisibility(8);
                    this.ypm.setVisibility(8);
                    this.xUr.setVisibility(8);
                    this.xUr.setText(getString(R.l.dYX));
                    break;
            }
            x.i("MicroMsg.AppAttachDownloadUI", "summerapp progressCallBack[%s], isDownloadFinished[%b], isDownloadStarted[%b]", new Object[]{this.lAl, Boolean.valueOf(this.ypp), Boolean.valueOf(this.ypq)});
            if (this.hts == 2 || !(this.ypp || this.ypq)) {
                this.mwb.setVisibility(0);
                this.mHK.setVisibility(8);
                this.ypk.setVisibility(0);
                if (cqS()) {
                    this.vex = new ab(this.fqm, this.mediaId, this.lAl);
                    ar.CG().a(this.vex, 0);
                    aj.t(this.fEJ);
                }
            }
        }
    }

    private boolean cqS() {
        com.tencent.mm.pluginsdk.model.app.b bVar;
        boolean z;
        int i = -1;
        com.tencent.mm.pluginsdk.model.app.b cqT = cqT();
        String str;
        if (cqT == null) {
            l.c(this.fqm, this.fDP, null);
            cqT = cqT();
            if (cqT != null) {
                String str2 = "MicroMsg.AppAttachDownloadUI";
                str = "summerapp tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]";
                Object[] objArr = new Object[8];
                objArr[0] = Long.valueOf(cqT.xjy);
                objArr[1] = Long.valueOf(cqT.field_totalLen);
                objArr[2] = cqT.field_fileFullPath;
                objArr[3] = Long.valueOf(cqT.field_type);
                objArr[4] = cqT.field_mediaId;
                objArr[5] = Long.valueOf(cqT.field_msgInfoId);
                objArr[6] = Boolean.valueOf(cqT.field_isUpload);
                if (cqT.field_signature != null) {
                    i = cqT.field_signature.length();
                }
                objArr[7] = Integer.valueOf(i);
                x.i(str2, str, objArr);
                if (this.ypo.hbf != 0 || this.ypo.hbb > 26214400) {
                    boolean z2;
                    if (t.ov(cqT.field_signature)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    bVar = cqT;
                    z = z2;
                }
            }
            z = true;
            bVar = cqT;
        } else {
            File file = new File(cqT.field_fileFullPath);
            if (cqT.field_status == 199 && !file.exists()) {
                x.i("MicroMsg.AppAttachDownloadUI", "summerapp tryInitAttachInfo info exist but file not!");
                l.c(this.fqm, this.fDP, null);
            }
            str = "MicroMsg.AppAttachDownloadUI";
            String str3 = "summerapp tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]";
            Object[] objArr2 = new Object[10];
            objArr2[0] = Long.valueOf(cqT.xjy);
            objArr2[1] = Long.valueOf(cqT.field_totalLen);
            objArr2[2] = cqT.field_fileFullPath;
            objArr2[3] = Long.valueOf(cqT.field_type);
            objArr2[4] = cqT.field_mediaId;
            objArr2[5] = Long.valueOf(cqT.field_msgInfoId);
            objArr2[6] = Boolean.valueOf(cqT.field_isUpload);
            objArr2[7] = Boolean.valueOf(file.exists());
            objArr2[8] = Long.valueOf(cqT.field_status);
            if (cqT.field_signature != null) {
                i = cqT.field_signature.length();
            }
            objArr2[9] = Integer.valueOf(i);
            x.i(str, str3, objArr2);
            z = true;
            bVar = cqT;
        }
        if (!z) {
            ar.CG().a(new y(bVar, this.hbp, this.nBp, this.fileName, this.iHF, this.fzO), 0);
        }
        return z;
    }

    private String getMimeType() {
        g.a fT = g.a.fT(this.fDP);
        String str = null;
        if (fT.hbc != null && fT.hbc.length() > 0) {
            str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fT.hbc);
        }
        if (str != null && str.length() != 0) {
            return str;
        }
        x.w("MicroMsg.AppAttachDownloadUI", "getMimeType fail, not a built-in mimetype, use \"*/{fileext}\" instead");
        return "*/" + fT.hbc;
    }

    private com.tencent.mm.pluginsdk.model.app.b cqT() {
        com.tencent.mm.pluginsdk.model.app.b fo = an.aqd().fo(this.fqm);
        if (fo != null) {
            x.i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId [%d] stack[%s]", new Object[]{Long.valueOf(this.fqm), t.Ws()});
        } else {
            fo = l.RI(this.mediaId);
            if (fo == null) {
                x.i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId and mediaId is null stack[%s]", new Object[]{t.Ws()});
            } else if (!(fo.field_msgInfoId == this.fqm || com.tencent.mm.a.e.bO(fo.field_fileFullPath))) {
                l.c(this.fqm, this.fDP, null);
                com.tencent.mm.pluginsdk.model.app.b fo2 = an.aqd().fo(this.fqm);
                if (fo2 == null) {
                    x.w("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo create new info from local but failed stack[%s]", new Object[]{t.Ws()});
                } else {
                    com.tencent.mm.sdk.f.e.post(new 8(this, fo, fo2), "copyAttachFromLocal");
                }
            }
        }
        return fo;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.tencent.mm.pluginsdk.ui.tools.a.a(this, i, i2, intent, this.ypr, R.l.dZc, R.l.dZd, 1);
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        com.tencent.mm.pluginsdk.model.app.b cqT = cqT();
        if (cqT != null) {
            long j = cqT.field_totalLen;
            this.ypl.setText(getString(R.l.dYY, new Object[]{t.bx(cqT.field_offset), t.bx(j)}));
            int i = cqT.field_totalLen == 0 ? 0 : (int) ((cqT.field_offset * 100) / cqT.field_totalLen);
            x.v("MicroMsg.AppAttachDownloadUI", "summerapp attach progress:" + i + " offset:" + r4 + " totallen:" + j);
            this.lAk.setProgress(i);
            if (cqT.field_status == 199 && i >= 100 && !this.ypp) {
                this.ypp = true;
                if (cqT != null) {
                    Toast.makeText(this, getString(R.l.dZh) + " : " + cqT.field_fileFullPath.replaceFirst(com.tencent.mm.compatible.util.e.bnD, com.tencent.mm.compatible.util.e.gHr), this.yps).show();
                    com.tencent.mm.pluginsdk.ui.tools.a.a(this, cqT.field_fileFullPath, this.iHF, 1);
                }
                ag.h(new Runnable(this) {
                    final /* synthetic */ AppAttachDownloadUI ypv;

                    {
                        this.ypv = r1;
                    }

                    public final void run() {
                        this.ypv.cqU();
                    }
                }, 200);
            }
            if (this.mwb.getVisibility() != 0 && i < 100 && !cqT.field_isUpload && cqT.field_status == 101) {
                x.i("MicroMsg.AppAttachDownloadUI", "summerapp still downloading updateProgress progress[%d]", new Object[]{Integer.valueOf(i)});
                this.mwb.setVisibility(0);
                this.mHK.setVisibility(8);
                this.ypk.setVisibility(0);
            }
        }
    }

    private void cqU() {
        Intent intent;
        switch (this.hts) {
            case 0:
            case 6:
                if (!cqV()) {
                    return;
                }
                if (bh.VW(this.iHF)) {
                    com.tencent.mm.pluginsdk.model.app.b cqT = cqT();
                    Intent intent2 = new Intent(this, ShowImageUI.class);
                    intent2.putExtra("key_message_id", this.fEJ.field_msgId);
                    intent2.putExtra("key_image_path", cqT.field_fileFullPath);
                    intent2.putExtra("key_favorite", true);
                    startActivity(intent2);
                    finish();
                    return;
                }
                String mimeType = getMimeType();
                this.xUr.setVisibility(0);
                this.mwb.setVisibility(8);
                this.ypk.setVisibility(8);
                this.mHK.setVisibility(8);
                this.ypm.setVisibility(0);
                if (this.fileName.equals("")) {
                    this.ypm.setText(getString(R.l.ezK));
                } else {
                    this.ypm.setText(this.fileName);
                }
                if (mimeType == null || mimeType.equals("")) {
                    this.mvX.setVisibility(8);
                    this.xUr.setText(getString(R.l.dYW));
                    return;
                }
                this.mvX.setVisibility(0);
                this.xUr.setText(getString(R.l.dYX));
                return;
            case 2:
                if (cqV()) {
                    intent = new Intent(this, ImageGalleryUI.class);
                    intent.putExtra("img_gallery_msg_id", this.fEJ.field_msgId);
                    intent.putExtra("img_gallery_talker", this.fEJ.field_talker);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0, 0);
                    return;
                }
                return;
            case 7:
                intent = new Intent();
                intent.putExtra("App_MsgId", this.fqm);
                setResult(-1, intent);
                finish();
                return;
            default:
                this.mvX.setVisibility(0);
                this.mwb.setVisibility(8);
                this.ypk.setVisibility(8);
                return;
        }
    }

    private boolean cqV() {
        com.tencent.mm.pluginsdk.model.app.b cqT = cqT();
        if (cqT == null) {
            return true;
        }
        if (com.tencent.mm.a.e.bO(cqT.field_fileFullPath)) {
            this.mwb.setVisibility(8);
            this.ypk.setVisibility(8);
            this.mHK.setVisibility(8);
            return true;
        }
        this.ypt.setVisibility(8);
        this.ypu.setVisibility(0);
        return false;
    }

    protected final int getLayoutId() {
        return R.i.dfx;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd type[%d], [%d, %d, %s]", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar.getType() != 221 && kVar.getType() != 728) {
            return;
        }
        if (kVar.getType() == 728 && i == 0 && i2 == 0) {
            com.tencent.mm.pluginsdk.model.app.b cqT = cqT();
            if (cqT == null) {
                x.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd getAppAttachInfo is null");
            } else {
                String str2 = "MicroMsg.AppAttachDownloadUI";
                String str3 = "summerapp onSceneEnd CheckBigFileDownload ok signature len[%d] start NetSceneDownloadAppAttach";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(cqT.field_signature == null ? -1 : cqT.field_signature.length());
                x.i(str2, str3, objArr);
            }
            this.vex = new ab(this.fqm, this.mediaId, this.lAl);
            ar.CG().a(this.vex, 0);
            return;
        }
        if (this.vex == null && (kVar instanceof ab)) {
            ab abVar = (ab) kVar;
            com.tencent.mm.pluginsdk.model.app.b cqT2 = cqT();
            if (!(cqT2 == null || t.ov(cqT2.field_mediaSvrId) || !cqT2.field_mediaSvrId.equals(abVar.getMediaId()))) {
                this.vex = abVar;
                x.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd reset downloadAppAttachScene[%s] by mediaSvrId[%s]", new Object[]{this.vex, cqT2.field_mediaSvrId});
            }
        }
        if (i == 0 && i2 == 0) {
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
            Object[] objArr2 = new Object[6];
            objArr2[0] = this.ypo.hbi;
            objArr2[1] = Integer.valueOf(this.ypo.hbf == 1 ? 7 : 5);
            objArr2[2] = Integer.valueOf(this.ypo.hbb);
            objArr2[3] = Integer.valueOf(0);
            objArr2[4] = Integer.valueOf(0);
            objArr2[5] = this.iHF;
            gVar.h(14665, objArr2);
            return;
        }
        if (i2 != 0 && com.tencent.mm.sdk.a.b.ceK()) {
            Toast.makeText(this, "errCode[" + i2 + "]", 0).show();
        }
        if (i2 == -5103059) {
            this.ypu.setVisibility(0);
            this.ypt.setVisibility(8);
            if (this.hts == 6) {
                gVar = com.tencent.mm.plugin.report.service.g.pQN;
                objArr2 = new Object[6];
                objArr2[0] = this.ypo.hbi;
                objArr2[1] = Integer.valueOf(this.ypo.hbf == 1 ? 7 : 5);
                objArr2[2] = Integer.valueOf(this.ypo.hbb);
                objArr2[3] = Integer.valueOf(1);
                objArr2[4] = Integer.valueOf(0);
                objArr2[5] = this.iHF;
                gVar.h(14665, objArr2);
                return;
            }
            return;
        }
        this.mwb.setVisibility(8);
        this.mHK.setVisibility(0);
        this.ypk.setVisibility(8);
        x.e("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd, download fail, type = " + kVar.getType() + " errType = " + i + ", errCode = " + i2);
    }

    public final void bYO() {
        Toast.makeText(this, R.l.dZf, 0).show();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        init();
    }

    private static boolean a(com.tencent.mm.pluginsdk.model.app.b bVar) {
        if (bVar == null) {
            return false;
        }
        File file = new File(bVar.field_fileFullPath);
        if (file.exists() && file.length() == bVar.field_totalLen) {
            return true;
        }
        return false;
    }
}
