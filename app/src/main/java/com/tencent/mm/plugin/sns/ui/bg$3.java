package com.tencent.mm.plugin.sns.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

class bg$3 implements OnClickListener {
    final /* synthetic */ bg rMH;

    bg$3(bg bgVar) {
        this.rMH = bgVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener");
        if (view.getTag() instanceof r) {
            r rVar = (r) view.getTag();
            bnp com_tencent_mm_protocal_c_bnp = rVar.rsq;
            m Lm = ae.bvv().Lm(rVar.frH);
            if (this.rMH.rrV != null) {
                this.rMH.rrV.bva().v(Lm);
            }
            if (com_tencent_mm_protocal_c_bnp.wQu == null) {
                x.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener weappInfo is null");
                return;
            }
            String str = com_tencent_mm_protocal_c_bnp.wQu.username;
            String str2 = com_tencent_mm_protocal_c_bnp.wQu.path;
            x.i("MicroMsg.TimeLineClickEvent", "username: " + str + "pagepath: " + str2);
            b qpVar = new qp();
            qpVar.fIi.userName = str;
            qpVar.fIi.fIk = str2;
            qpVar.fIi.scene = HardCoderJNI.FUNC_RESET_SCREEN_RESOLUTION;
            qpVar.fIi.fnp = com_tencent_mm_protocal_c_bnp.nGJ + ":" + com_tencent_mm_protocal_c_bnp.ksU;
            Bundle bundle = new Bundle();
            bundle.putString("stat_send_msg_user", Lm.field_userName);
            bundle.putString("stat_msg_id", "sns_" + i.eq(Lm.field_snsId));
            a.xef.m(qpVar);
        }
    }
}
