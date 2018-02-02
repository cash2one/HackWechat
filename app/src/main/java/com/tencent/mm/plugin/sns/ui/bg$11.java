package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.x;

class bg$11 implements OnClickListener {
    final /* synthetic */ bg rMH;

    bg$11(bg bgVar) {
        this.rMH = bgVar;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.TimeLineClickEvent", "hardTVRedirectListener");
        if (view.getTag() instanceof r) {
            r rVar = (r) view.getTag();
            bnp com_tencent_mm_protocal_c_bnp = rVar.rsq;
            if (com_tencent_mm_protocal_c_bnp.wQo.vYd.size() > 0) {
                m Lm = ae.bvv().Lm(rVar.frH);
                if (this.rMH.rrV != null) {
                    this.rMH.rrV.bva().v(Lm);
                }
                String str = ((aqr) com_tencent_mm_protocal_c_bnp.wQo.vYd.get(0)).rsn;
                Intent intent = new Intent();
                intent.putExtra("key_TV_xml", str);
                intent.putExtra("key_TV_getProductInfoScene", 2);
                d.b(view.getContext(), "shake", ".ui.TVInfoUI", intent);
            }
        }
    }
}
