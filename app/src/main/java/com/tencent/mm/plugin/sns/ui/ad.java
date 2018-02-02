package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mm.g.a.pi;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.h.e;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.aoy;
import com.tencent.mm.protocal.c.aqc;
import com.tencent.mm.protocal.c.bld;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.QImageView;
import com.tencent.mm.z.s;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class ad implements z {
    private String appId;
    private String appName;
    String desc = "";
    MMActivity fmM;
    String fqR = "";
    private boolean frp = false;
    String fvC = "";
    String hbj;
    private String iKB;
    ProgressDialog iln = null;
    private View kpZ = null;
    String nBo;
    private int rsj;
    private b rsp = null;
    private boolean rtD = false;
    private boolean rtE = false;
    private WXMediaMessage rtF = null;
    private c ruA = new c<pi>(this) {
        final /* synthetic */ ad ruF;

        {
            this.ruF = r2;
            this.xen = pi.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            pi piVar = (pi) bVar;
            x.i("MicroMsg.SightWidget", "on sight send result callback, type %d", new Object[]{Integer.valueOf(piVar.fHh.type)});
            switch (piVar.fHh.type) {
                case 1:
                    x.i("MicroMsg.SightWidget", "come event done");
                    this.ruF.videoPath = piVar.fHh.videoPath;
                    this.ruF.fqR = piVar.fHh.fHk;
                    if (this.ruF.iln != null) {
                        this.ruF.iln.dismiss();
                    }
                    if (piVar.fHh.fHj && this.ruF.ruB != null) {
                        ad.a(this.ruF);
                    }
                    x.i("MicroMsg.SightWidget", "mux finish %B videoPath %s %d md5 %s", new Object[]{Boolean.valueOf(piVar.fHh.fHj), piVar.fHh.videoPath, Long.valueOf(FileOp.me(piVar.fHh.videoPath)), this.ruF.fqR});
                    break;
            }
            return false;
        }
    };
    aw ruB = null;
    private int ruC = 0;
    Runnable ruD = new 4(this);
    Runnable ruE = new 5(this);
    SightPlayImageView ruv;
    boolean ruw = false;
    private Bitmap rux = null;
    private aqc ruy = new aqc();
    private boolean ruz = false;
    String videoPath = "";

    static /* synthetic */ void a(ad adVar) {
        if (adVar.ruB != null) {
            if (adVar.iln != null) {
                adVar.iln.dismiss();
            }
            x.i("MicroMsg.SightWidget", "commitDone");
            com.tencent.mm.sdk.b.b piVar = new pi();
            piVar.fHh.type = 0;
            piVar.fHh.fHj = true;
            a.xef.m(piVar);
            adVar.ruw = true;
            int commit = adVar.ruB.commit();
            if (adVar.rsp != null) {
                adVar.rsp.iw(commit);
                e.rdF.c(adVar.rsp);
            }
            ae.bvC().rwy = 0;
            if (adVar.fmM.getIntent() != null && adVar.fmM.getIntent().getBooleanExtra("K_go_to_SnsTimeLineUI", false)) {
                Intent intent = new Intent();
                intent.putExtra("sns_resume_state", false);
                intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                intent.setClass(adVar.fmM, SnsTimeLineUI.class);
                intent.addFlags(67108864);
                adVar.fmM.startActivity(intent);
            }
            adVar.fmM.setResult(-1);
            adVar.fmM.finish();
            ae.bvr().buj();
        }
    }

    public ad(MMActivity mMActivity) {
        this.fmM = mMActivity;
    }

    public final void F(Bundle bundle) {
        this.rsp = b.q(this.fmM.getIntent());
        this.nBo = bh.az(this.fmM.getIntent().getStringExtra("KSightCdnUrl"), "");
        this.hbj = bh.az(this.fmM.getIntent().getStringExtra("KSightCdnThumbUrl"), "");
        this.appId = bh.az(this.fmM.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = bh.az(this.fmM.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.rtD = this.fmM.getIntent().getBooleanExtra("KThrid_app", false);
        this.rtE = this.fmM.getIntent().getBooleanExtra("KSnsAction", false);
        this.ruz = this.fmM.getIntent().getBooleanExtra("Kis_take_photo", false);
        this.rsj = this.fmM.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.iKB = bh.az(this.fmM.getIntent().getStringExtra("reportSessionId"), "");
        Bundle bundleExtra = this.fmM.getIntent().getBundleExtra("Ksnsupload_timeline");
        if (bundleExtra != null) {
            this.rtF = new Req(bundleExtra).message;
        }
        this.fvC = this.fmM.getIntent().getStringExtra("KSightThumbPath");
        this.videoPath = this.fmM.getIntent().getStringExtra("KSightPath");
        this.fqR = this.fmM.getIntent().getStringExtra("sight_md5");
        byte[] byteArrayExtra = this.fmM.getIntent().getByteArrayExtra("KMMSightExtInfo");
        if (byteArrayExtra != null) {
            try {
                this.ruy.aF(byteArrayExtra);
            } catch (Exception e) {
                x.i("MicroMsg.SightWidget", "error %s", new Object[]{e.getMessage()});
            }
        }
        if (this.ruy == null) {
            this.ruy = new aqc();
            this.ruy.wwP = this.ruz;
        }
        com.tencent.mm.sdk.b.b piVar = new pi();
        piVar.fHh.type = 2;
        a.xef.m(piVar);
        if (bh.ov(this.videoPath)) {
            this.videoPath = bh.az(piVar.fHi.fHm, "");
            x.e("MicroMsg.SightWidget", "videoPath is null %s", new Object[]{this.videoPath});
        }
        this.fqR = bh.ov(this.fqR) ? bh.az(piVar.fHi.fHk, "") : this.fqR;
        x.i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", new Object[]{this.fvC, this.videoPath, this.fqR});
        a.xef.b(this.ruA);
    }

    public final void G(Bundle bundle) {
    }

    public final boolean bzj() {
        return true;
    }

    public final View bzk() {
        this.kpZ = View.inflate(this.fmM, i$g.qIr, null);
        this.ruv = (SightPlayImageView) this.kpZ.findViewById(f.cRi);
        this.fmM.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        this.ruv.dt(com.tencent.mm.bv.a.fromDPToPix(this.fmM, 64), com.tencent.mm.bv.a.fromDPToPix(this.fmM, 64));
        this.ruv.a(QImageView.a.zwh);
        this.ruv.quJ = true;
        this.ruv.setOnClickListener(new 2(this));
        x.i("MicroMsg.SightWidget", "videoPath " + this.videoPath + " thumbPath " + this.fvC + " " + FileOp.me(this.videoPath) + " " + FileOp.me(this.fvC));
        if (FileOp.bO(this.videoPath)) {
            x.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", new Object[]{this.videoPath, this.fqR});
        }
        this.ruv.ia(false);
        this.ruv.aA(this.videoPath, false);
        return this.kpZ;
    }

    public final boolean a(int i, int i2, i iVar, String str, List<String> list, aoy com_tencent_mm_protocal_c_aoy, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        if (this.ruB != null) {
            return false;
        }
        if (this.ruw) {
            return true;
        }
        this.ruw = true;
        this.desc = str;
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            LinkedList linkedList2 = new LinkedList();
            List GI = s.GI();
            for (String str3 : list) {
                if (!GI.contains(str3)) {
                    bld com_tencent_mm_protocal_c_bld = new bld();
                    com_tencent_mm_protocal_c_bld.ksU = str3;
                    linkedList.add(com_tencent_mm_protocal_c_bld);
                }
            }
        }
        this.ruB = new aw(15);
        pInt.value = this.ruB.afu;
        if (i3 > com.tencent.mm.plugin.sns.c.a.qQF) {
            this.ruB.wM(3);
        }
        aw Kz = this.ruB.Kz(str);
        LinkedList linkedList3 = new LinkedList();
        Kz.a(com_tencent_mm_protocal_c_aoy).ai(linkedList).wO(i).wP(i2).bM(list2);
        if (z) {
            this.ruB.wR(1);
        } else {
            this.ruB.wR(0);
        }
        this.ruB.bM(list2);
        this.ruB.wQ(this.rsj);
        this.ruB.fHP = this.ruy;
        this.ruB.e(null, null, null, i4, i5);
        if (!bh.ov(this.appId)) {
            this.ruB.KF(this.appId);
        }
        if (!bh.ov(this.appName)) {
            this.ruB.KG(bh.az(this.appName, ""));
        }
        if (this.rtD) {
            this.ruB.wQ(5);
        }
        if (this.rtE && this.rtF != null) {
            this.ruB.KA(this.rtF.mediaTagName);
            this.ruB.U(this.appId, this.rtF.messageExt, this.rtF.messageAction);
        }
        ag.h(this.ruE, 700);
        com.tencent.mm.sdk.f.e.post(new 3(this), "sight_send_ready");
        return true;
    }

    public final boolean a(int i, Intent intent) {
        return false;
    }

    public final boolean bzl() {
        if (this.iln != null) {
            this.iln.dismiss();
        }
        this.ruv.aA(this.videoPath, true);
        a.xef.c(this.ruA);
        if (com.tencent.mm.plugin.sns.data.i.m(this.rux)) {
            this.rux.recycle();
        }
        return false;
    }
}
