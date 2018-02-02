package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.e;
import com.tencent.mm.plugin.sns.i$e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.aoy;
import com.tencent.mm.protocal.c.bld;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.v;
import com.tencent.mm.z.s;
import java.util.LinkedList;
import java.util.List;

public final class ac implements z {
    private String appName = "";
    String fFm = "";
    MMActivity fmM;
    private TextView ihS = null;
    private c jeX = new 1(this);
    private View kpZ;
    boolean lio = false;
    String mediaId;
    private int rsj;
    private CdnImageView rsk = null;
    private TextView rsl = null;
    private b rsp = null;
    private boolean rtD = false;
    private boolean rtE = false;
    WXMediaMessage rtF = null;
    ImageView rus;
    private Bitmap rut;

    public ac(MMActivity mMActivity) {
        this.fmM = mMActivity;
        a.xef.b(this.jeX);
    }

    public final void F(Bundle bundle) {
        this.rtF = new Req(this.fmM.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
        this.mediaId = this.fmM.getIntent().getStringExtra("Ksnsupload_musicid");
        this.rsp = b.q(this.fmM.getIntent());
        this.fFm = bh.az(this.fmM.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = bh.az(this.fmM.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.rtD = this.fmM.getIntent().getBooleanExtra("KThrid_app", false);
        this.rtE = this.fmM.getIntent().getBooleanExtra("KSnsAction", false);
        this.rsj = this.fmM.getIntent().getIntExtra("Ksnsupload_source", 0);
    }

    public final void G(Bundle bundle) {
    }

    public final boolean bzj() {
        return true;
    }

    final void bzF() {
        new af(this.fmM.getMainLooper()).post(new 2(this));
    }

    public final View bzk() {
        this.kpZ = v.fv(this.fmM).inflate(g.qIq, null);
        this.rsk = (CdnImageView) this.kpZ.findViewById(f.qCp);
        this.ihS = (TextView) this.kpZ.findViewById(f.qFN);
        this.rsl = (TextView) this.kpZ.findViewById(f.qDj);
        this.kpZ.findViewById(f.state).setVisibility(8);
        this.ihS.setText(this.rtF.title);
        if (this.rtF.thumbData != null) {
            this.rut = d.bl(this.rtF.thumbData);
        }
        this.rsk.setImageBitmap(this.rut);
        if (bh.ov(this.rtF.description)) {
            this.rsl.setVisibility(8);
        } else {
            this.rsl.setText(this.rtF.description);
            this.rsl.setVisibility(0);
        }
        this.rus = (ImageView) this.kpZ.findViewById(f.state);
        this.rus.setVisibility(0);
        if (com.tencent.mm.av.b.Qq() && this.lio) {
            this.rus.setImageResource(i$e.bDR);
        } else {
            this.rus.setImageResource(i$e.bDS);
        }
        this.rus.setOnClickListener(new 4(this));
        i.b(this.rsk, this.fmM);
        return this.kpZ;
    }

    public final boolean a(int i, int i2, org.b.d.i iVar, String str, List<String> list, aoy com_tencent_mm_protocal_c_aoy, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        ae.bvr();
        aw a = av.a(this.rtF, str, this.fFm, this.appName);
        if (a == null) {
            x.e("MicroMsg.MusicWidget", "packHelper == null, %s, %s", new Object[]{this.fFm, this.appName});
            return false;
        }
        pInt.value = a.afu;
        if (i3 > com.tencent.mm.plugin.sns.c.a.qQF) {
            a.wM(4);
        }
        a.wQ(this.rsj);
        if (this.rtD) {
            a.wQ(5);
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
        a.ai(linkedList);
        if (iVar != null) {
            a.ed(iVar.token, iVar.wyk);
        }
        a.a(com_tencent_mm_protocal_c_aoy);
        if (z) {
            a.wR(1);
        } else {
            a.wR(0);
        }
        a.bM(list2).wO(i);
        a.e(null, null, null, i4, i5);
        if (this.rtE && this.rtF != null) {
            a.KA(this.rtF.mediaTagName);
            a.U(this.fFm, this.rtF.messageExt, this.rtF.messageAction);
        }
        int commit = a.commit();
        if (this.rsp != null) {
            this.rsp.iw(commit);
            e.rdF.c(this.rsp);
        }
        ae.bvr().buj();
        this.fmM.finish();
        return false;
    }

    public final boolean a(int i, Intent intent) {
        return false;
    }

    public final boolean bzl() {
        if (!(this.rut == null || this.rut.isRecycled())) {
            this.rut.recycle();
        }
        a.xef.c(this.jeX);
        if (com.tencent.mm.av.b.Qq() && this.lio) {
            bzF();
        }
        return com.tencent.mm.av.b.Qq();
    }
}
