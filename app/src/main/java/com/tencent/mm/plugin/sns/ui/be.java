package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX$Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.h.e;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.aoy;
import com.tencent.mm.protocal.c.bld;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.s;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class be implements z {
    private String appName = "";
    private String fFm = "";
    private MMActivity fmM;
    private int rsj;
    private b rsp = null;
    private boolean rtD = false;
    private boolean rtE = false;
    private WXMediaMessage rtF = null;
    private String ruH = "";

    public be(MMActivity mMActivity) {
        this.fmM = mMActivity;
    }

    public final void F(Bundle bundle) {
        this.rsp = b.q(this.fmM.getIntent());
        this.ruH = this.fmM.getIntent().getStringExtra("Kdescription");
        this.fFm = bh.az(this.fmM.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = bh.az(this.fmM.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.rtD = this.fmM.getIntent().getBooleanExtra("KThrid_app", false);
        this.rtE = this.fmM.getIntent().getBooleanExtra("KSnsAction", false);
        this.rsj = this.fmM.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.rtF = new SendMessageToWX$Req(this.fmM.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
    }

    public final void G(Bundle bundle) {
    }

    public final boolean bzj() {
        return true;
    }

    public final View bzk() {
        return null;
    }

    public final boolean a(int i, int i2, i iVar, String str, List<String> list, aoy com_tencent_mm_protocal_c_aoy, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        ae.bvr();
        aw a = av.a(this.rtF, str, this.fFm, this.appName);
        if (a == null) {
            x.e("MicroMsg.TextWidget", "packHelper == null, %s, %s", new Object[]{this.fFm, this.appName});
            return false;
        }
        pInt.value = a.afu;
        if (i3 > a.qQF) {
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
        return false;
    }
}
