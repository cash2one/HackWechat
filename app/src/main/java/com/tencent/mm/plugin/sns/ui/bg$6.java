package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.x;

class bg$6 implements OnClickListener {
    final /* synthetic */ bg rMH;

    bg$6(bg bgVar) {
        this.rMH = bgVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.TimeLineClickEvent", "cardRediretListener");
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
                intent.putExtra("key_from_scene", 12);
                if (TextUtils.isEmpty(str)) {
                    x.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData is empty");
                    return;
                }
                String[] split = str.split("#");
                if (split.length >= 2) {
                    x.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData[0]:" + split[0]);
                    intent.putExtra("key_card_id", split[0]);
                    intent.putExtra("key_card_ext", split[1]);
                    d.b(this.rMH.context, "card", ".ui.CardDetailUI", intent);
                } else if (split.length == 1) {
                    x.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include cardExt");
                    x.i("MicroMsg.TimeLineClickEvent", "cardRediretListener card_id :" + str);
                    intent.putExtra("key_card_id", split[0]);
                    intent.putExtra("key_card_ext", "");
                    d.b(this.rMH.context, "card", ".ui.CardDetailUI", intent);
                } else {
                    x.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include card_id and cardExt");
                    x.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData :" + str);
                }
            }
        }
    }
}
