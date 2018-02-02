package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ProgressBar;
import com.tencent.mm.g.a.pi;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.aoy;
import com.tencent.mm.protocal.c.bld;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.s;
import java.util.LinkedList;
import java.util.List;

public final class al implements z {
    private String desc = "";
    MMActivity fmM;
    String fqR = "";
    private boolean frp = false;
    String fvC = "";
    ProgressDialog iln = null;
    private View kpZ = null;
    ProgressBar lAk;
    private int rsj;
    private b rsp = null;
    private c ruA = new 1(this);
    aw ruB = null;
    private boolean ruw = false;
    private Bitmap rux = null;
    a rxm;
    com.tencent.mm.plugin.sight.decode.ui.c rxn = null;
    String videoPath = "";

    public al(MMActivity mMActivity) {
        this.fmM = mMActivity;
    }

    public final void F(Bundle bundle) {
        this.rsp = b.q(this.fmM.getIntent());
        this.fvC = this.fmM.getIntent().getStringExtra("KSightThumbPath");
        this.videoPath = this.fmM.getIntent().getStringExtra("KSightPath");
        this.fqR = this.fmM.getIntent().getStringExtra("sight_md5");
        this.rsj = this.fmM.getIntent().getIntExtra("Ksnsupload_source", 0);
        com.tencent.mm.sdk.b.b piVar = new pi();
        piVar.fHh.type = 2;
        com.tencent.mm.sdk.b.a.xef.m(piVar);
        if (bh.ov(this.videoPath)) {
            this.videoPath = bh.az(piVar.fHi.fHm, "");
            x.e("MicroMsg.SightWidget", "videoPath is null %s", new Object[]{this.videoPath});
        }
        this.fqR = bh.ov(this.fqR) ? bh.az(piVar.fHi.fHk, "") : this.fqR;
        x.i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", new Object[]{this.fvC, this.videoPath, this.fqR});
        com.tencent.mm.sdk.b.a.xef.b(this.ruA);
    }

    public final void G(Bundle bundle) {
    }

    public final boolean bzj() {
        return true;
    }

    public final View bzk() {
        this.kpZ = View.inflate(this.fmM, g.qIs, null);
        this.rxm = (a) this.kpZ.findViewById(f.image);
        this.rxm.wj(com.tencent.mm.bv.a.fromDPToPix(this.fmM, 90));
        this.lAk = (ProgressBar) this.kpZ.findViewById(f.ctq);
        this.fmM.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        this.kpZ.findViewById(f.bTD).setOnClickListener(new 2(this));
        x.i("MicroMsg.SightWidget", "videoPath " + this.videoPath + " thumbPath " + this.fvC + " " + FileOp.me(this.videoPath) + " " + FileOp.me(this.fvC));
        if (FileOp.bO(this.videoPath)) {
            this.rxm.aA(this.videoPath, false);
            this.lAk.setVisibility(8);
            x.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", new Object[]{this.videoPath, this.fqR});
        } else {
            n JM = i.JM(this.fvC);
            if (JM != null) {
                this.rux = JM.EC();
                if (i.m(this.rux)) {
                    this.rxm.B(this.rux);
                }
            }
            this.lAk.setVisibility(0);
        }
        return this.kpZ;
    }

    public final boolean a(int i, int i2, org.b.d.i iVar, String str, List<String> list, aoy com_tencent_mm_protocal_c_aoy, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        if (this.ruB != null) {
            return false;
        }
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
        this.ruB.bM(list2).wO(i);
        this.ruB.wQ(this.rsj);
        this.ruB.e(null, null, null, i4, i5);
        if (FileOp.bO(this.videoPath)) {
            bAb();
            return true;
        }
        x.i("MicroMsg.SightWidget", "commit file is not exist " + this.videoPath);
        Context context = this.fmM;
        this.fmM.getString(j.dGO);
        this.iln = h.a(context, this.fmM.getString(j.qMh), true, new 3(this));
        return true;
    }

    final void bAb() {
        if (!this.ruw) {
            if (this.ruB.l(this.videoPath, this.fvC, this.desc, this.fqR)) {
                com.tencent.mm.sdk.b.b piVar = new pi();
                piVar.fHh.type = 0;
                piVar.fHh.fHj = true;
                com.tencent.mm.sdk.b.a.xef.m(piVar);
                this.ruw = true;
                int commit = this.ruB.commit();
                if (this.rsp != null) {
                    this.rsp.iw(commit);
                    e.rdF.c(this.rsp);
                }
                ae.bvC().rwy = 0;
                Intent intent = new Intent();
                intent.putExtra("sns_resume_state", false);
                intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                intent.setClass(this.fmM, SnsTimeLineUI.class);
                intent.addFlags(67108864);
                this.fmM.startActivity(intent);
                this.fmM.setResult(-1);
                this.fmM.finish();
                return;
            }
            x.i("MicroMsg.SightWidget", "videopath " + FileOp.me(this.videoPath) + " thumb: " + FileOp.me(this.fvC));
            u.makeText(this.fmM, j.eKc, 0).show();
        }
    }

    public final boolean a(int i, Intent intent) {
        return false;
    }

    public final boolean bzl() {
        if (this.iln != null) {
            this.iln.dismiss();
        }
        com.tencent.mm.sdk.b.a.xef.c(this.ruA);
        if (i.m(this.rux)) {
            this.rux.recycle();
        }
        return false;
    }
}
