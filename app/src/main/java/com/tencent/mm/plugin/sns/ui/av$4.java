package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.abtest.a;
import com.tencent.mm.plugin.sns.ui.a.a$c;
import com.tencent.mm.protocal.c.aqs;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

class av$4 implements OnClickListener {
    final /* synthetic */ av rHD;

    av$4(av avVar) {
        this.rHD = avVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn");
        this.rHD.rHp.rrv = false;
        a.btP();
        if (view.getTag() instanceof a$c) {
            a$c com_tencent_mm_plugin_sns_ui_a_a_c = (a$c) view.getTag();
            if (com_tencent_mm_plugin_sns_ui_a_a_c.rOK != null && com_tencent_mm_plugin_sns_ui_a_a_c.rOK.wQo.vYc == 21) {
                aqs com_tencent_mm_protocal_c_aqs = com_tencent_mm_plugin_sns_ui_a_a_c.roU;
                if (!q.FS().equals(com_tencent_mm_plugin_sns_ui_a_a_c.rOK.ksU) && (com_tencent_mm_protocal_c_aqs == null || com_tencent_mm_protocal_c_aqs.fLD == 0)) {
                    com.tencent.mm.plugin.sns.lucky.ui.a.e(this.rHD.fmM, com_tencent_mm_plugin_sns_ui_a_a_c.rOg.xy(0));
                    return;
                }
            }
            if (this.rHD.fmM instanceof u) {
                ((u) this.rHD.fmM).cH(view);
                return;
            }
            return;
        }
        x.e("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn err1");
    }
}
