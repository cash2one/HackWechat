package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class bg$7 implements OnClickListener {
    final /* synthetic */ bg rMH;

    bg$7(bg bgVar) {
        this.rMH = bgVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.TimeLineClickEvent", "noteLinkRedirectListener");
        if (view.getTag() instanceof r) {
            r rVar = (r) view.getTag();
            if (rVar.rsq.wQo.vYc == 26 && !bh.ov(rVar.rsq.wQo.vYf)) {
                b fvVar = new fv();
                fvVar.fvq.type = 37;
                fvVar.fvq.desc = rVar.rsq.wQo.vYf;
                String str = "";
                if (rVar.rsq.wQo.vYd != null && rVar.rsq.wQo.vYd.size() > 0) {
                    String r = am.r(ae.getAccSnsPath(), ((aqr) rVar.rsq.wQo.vYd.get(0)).nGJ);
                    str = i.e((aqr) rVar.rsq.wQo.vYd.get(0));
                    str = FileOp.bO(new StringBuilder().append(r).append(str).toString()) ? r + str : "";
                }
                fvVar.fvq.path = str;
                fvVar.fvq.title = rVar.frH;
                fvVar.fvq.context = this.rMH.context;
                a.xef.m(fvVar);
            }
        }
    }
}
