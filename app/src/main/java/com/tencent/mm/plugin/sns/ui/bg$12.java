package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bnp;

class bg$12 implements OnClickListener {
    final /* synthetic */ bg rMH;

    bg$12(bg bgVar) {
        this.rMH = bgVar;
    }

    public final void onClick(View view) {
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
                intent.putExtra("sns_object_data", str);
                intent.putExtra("preceding_scence", 10);
                intent.putExtra("download_entrance_scene", 13);
                d.b(view.getContext(), "emoji", ".ui.EmojiStoreDetailUI", intent);
            }
        }
    }
}
