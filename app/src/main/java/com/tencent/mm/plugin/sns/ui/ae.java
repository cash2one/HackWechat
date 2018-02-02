package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.h.e;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.aoy;
import com.tencent.mm.protocal.c.bld;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.s;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class ae implements z {
    private String appName = "";
    private String fFm = "";
    private MMActivity fmM;
    private int rsj;
    private b rsp = null;
    private boolean rtD = false;
    private boolean rtE = false;
    private WXMediaMessage rtF = null;
    private String ruH = "";
    private boolean ruI = false;

    public ae(MMActivity mMActivity, boolean z) {
        this.fmM = mMActivity;
        this.ruI = z;
    }

    public final void F(Bundle bundle) {
        this.rsp = b.q(this.fmM.getIntent());
        this.ruH = this.fmM.getIntent().getStringExtra("Kdescription");
        this.fFm = bh.az(this.fmM.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = bh.az(this.fmM.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.rtD = this.fmM.getIntent().getBooleanExtra("KThrid_app", false);
        this.rtE = this.fmM.getIntent().getBooleanExtra("KSnsAction", false);
        this.rsj = this.fmM.getIntent().getIntExtra("Ksnsupload_source", 0);
        Bundle bundleExtra = this.fmM.getIntent().getBundleExtra("Ksnsupload_timeline");
        if (bundleExtra != null) {
            this.rtF = new Req(bundleExtra).message;
        }
    }

    public final void G(Bundle bundle) {
    }

    public final boolean bzj() {
        return this.ruI;
    }

    public final View bzk() {
        return null;
    }

    public final boolean a(int i, int i2, i iVar, String str, List<String> list, aoy com_tencent_mm_protocal_c_aoy, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        if (this.fmM.isFinishing()) {
            return false;
        }
        aw awVar = new aw(2);
        pInt.value = awVar.afu;
        if (i3 > a.qQF) {
            awVar.wM(2);
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
        if (z) {
            awVar.wR(1);
        } else {
            awVar.wR(0);
        }
        if (iVar != null) {
            awVar.ed(iVar.token, iVar.wyk);
        }
        awVar.wQ(this.rsj);
        if (this.rtD) {
            awVar.wQ(5);
        }
        if (this.rtE && this.rtF != null) {
            awVar.KA(this.rtF.mediaTagName);
            awVar.U(this.fFm, this.rtF.messageExt, this.rtF.messageAction);
        }
        awVar.e(null, null, null, i4, i5);
        awVar.Kz(str).a(com_tencent_mm_protocal_c_aoy).ai(linkedList).wO(i).wP(i2).bM(list2);
        int commit = awVar.commit();
        if (this.rsp != null) {
            this.rsp.iw(commit);
            e.rdF.c(this.rsp);
        }
        this.fmM.setResult(-1);
        com.tencent.mm.plugin.sns.model.ae.bvr().buj();
        this.fmM.finish();
        return true;
    }

    public final boolean a(int i, Intent intent) {
        return false;
    }

    public final boolean bzl() {
        return false;
    }
}
