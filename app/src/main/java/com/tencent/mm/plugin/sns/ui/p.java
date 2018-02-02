package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.aq.c;
import com.tencent.mm.aq.o;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.aoy;
import com.tencent.mm.protocal.c.bld;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.v;
import com.tencent.mm.z.s;
import java.util.LinkedList;
import java.util.List;

public final class p implements z {
    private String appId = "";
    private String appName = "";
    private String fGz;
    private MMActivity fmM;
    private String fzs = "";
    private int h = -1;
    private String hOf = "";
    private Bitmap hkT = null;
    private TextView ihS = null;
    private View kpZ = null;
    private boolean oqy = false;
    private String rsg = "";
    private byte[] rsh = null;
    private String rsi;
    private int rsj;
    private CdnImageView rsk = null;
    private TextView rsl = null;
    private int rsm;
    private String rsn = "";
    private String rso = "";
    private b rsp = null;
    private String title = "";
    private int w = -1;

    public p(MMActivity mMActivity) {
        this.fmM = mMActivity;
    }

    public final void F(Bundle bundle) {
        this.rsp = b.q(this.fmM.getIntent());
        this.w = this.fmM.getIntent().getIntExtra("Ksnsupload_width", -1);
        this.h = this.fmM.getIntent().getIntExtra("Ksnsupload_height", -1);
        this.rsj = this.fmM.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.hOf = bh.az(this.fmM.getIntent().getStringExtra("Ksnsupload_link"), "");
        this.title = bh.az(this.fmM.getIntent().getStringExtra("Ksnsupload_title"), "");
        this.rsg = bh.az(this.fmM.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
        this.fzs = this.fmM.getIntent().getStringExtra("KsnsUpload_imgPath");
        this.oqy = this.fmM.getIntent().getBooleanExtra("ksnsis_video", false);
        this.fGz = bh.az(this.fmM.getIntent().getStringExtra("src_username"), "");
        this.rsi = bh.az(this.fmM.getIntent().getStringExtra("src_displayname"), "");
        this.rso = bh.az(this.fmM.getIntent().getStringExtra("KContentObjDesc"), "");
        this.rsn = bh.az(this.fmM.getIntent().getStringExtra("KUploadProduct_UserData"), "");
        this.appName = bh.az(this.fmM.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.appId = bh.az(this.fmM.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.rsm = this.fmM.getIntent().getIntExtra("KUploadProduct_subType", 0);
    }

    public final void G(Bundle bundle) {
    }

    public final boolean bzj() {
        return true;
    }

    public final View bzk() {
        this.kpZ = v.fv(this.fmM).inflate(g.qIp, null);
        this.rsk = (CdnImageView) this.kpZ.findViewById(f.qCp);
        this.ihS = (TextView) this.kpZ.findViewById(f.qFN);
        this.rsl = (TextView) this.kpZ.findViewById(f.qDj);
        if (this.oqy) {
            this.kpZ.findViewById(f.state).setVisibility(0);
        } else {
            this.kpZ.findViewById(f.state).setVisibility(8);
        }
        this.ihS.setText(this.title);
        if (!bh.ov(this.rsg)) {
            this.rsk.setVisibility(0);
            this.rsk.setUrl(this.rsg);
        } else if (bh.bw(this.rsh)) {
            this.rsk.setVisibility(8);
        } else {
            this.rsk.setVisibility(0);
            this.hkT = d.bl(this.rsh);
            this.rsk.setImageBitmap(this.hkT);
        }
        i.b(this.rsk, this.fmM);
        return this.kpZ;
    }

    public final boolean a(int i, int i2, org.b.d.i iVar, String str, List<String> list, aoy com_tencent_mm_protocal_c_aoy, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        aw awVar = new aw(10);
        pInt.value = awVar.afu;
        if (i3 > a.qQF) {
            awVar.wM(2);
        }
        if (iVar != null) {
            awVar.ed(iVar.token, iVar.wyk);
        }
        awVar.KE(this.title).KC(this.rso).KD(this.hOf).Kz(str);
        boolean z2 = false;
        if (!bh.ov(this.fzs)) {
            z2 = awVar.a(FileOp.d(this.fzs, 0, -1), this.rso, this.title, this.rsm, this.rsn);
        } else if (!(bh.ov(this.rsg) || o.Pv() == null)) {
            o.Pv();
            Bitmap iG = c.iG(this.rsg);
            if (iG != null) {
                z2 = awVar.a(d.R(iG), this.rso, this.title, this.rsm, this.rsn);
            }
        }
        if (!z2) {
            x.i("MicroMsg.EmojiShareWidget", "set userData user imgurl ");
            z2 = awVar.b(this.rsg, this.rsg, this.rso, this.rsm, this.rsn);
        }
        if (!z2) {
            x.e("MicroMsg.EmojiShareWidget", "set userData faild");
        }
        awVar.wQ(this.rsj);
        awVar.KH(this.fGz);
        awVar.KI(this.rsi);
        if (z) {
            awVar.wR(1);
        } else {
            awVar.wR(0);
        }
        awVar.bM(list2);
        if (!bh.ov(this.appId)) {
            awVar.KF(this.appId);
            awVar.KG(this.appName);
        }
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
        awVar.ai(linkedList).wO(i);
        awVar.e(null, null, null, i4, i5);
        awVar.a(com_tencent_mm_protocal_c_aoy);
        int commit = awVar.commit();
        if (this.rsp != null) {
            this.rsp.iw(commit);
            e.rdF.c(this.rsp);
        }
        ae.bvr().buj();
        this.fmM.finish();
        String yi = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yi(this.rsn);
        com.tencent.mm.plugin.report.service.g.pQN.h(10993, new Object[]{Integer.valueOf(1), yi});
        return false;
    }

    public final boolean a(int i, Intent intent) {
        return false;
    }

    public final boolean bzl() {
        if (!(this.hkT == null || this.hkT.isRecycled())) {
            this.hkT.recycle();
        }
        return false;
    }
}
