package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.ui.a.a$c;

class av$5 implements OnClickListener {
    final /* synthetic */ av rHD;

    av$5(av avVar) {
        this.rHD = avVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof a$c) {
            a$c com_tencent_mm_plugin_sns_ui_a_a_c = (a$c) view.getTag();
            if (com_tencent_mm_plugin_sns_ui_a_a_c == null) {
                return;
            }
            if (this.rHD.rsb.containsKey(com_tencent_mm_plugin_sns_ui_a_a_c.frH) && ((Integer) this.rHD.rsb.get(com_tencent_mm_plugin_sns_ui_a_a_c.frH)).equals(Integer.valueOf(1))) {
                this.rHD.rsb.put(com_tencent_mm_plugin_sns_ui_a_a_c.frH, Integer.valueOf(2));
                this.rHD.rHo.notifyDataSetChanged();
                return;
            }
            this.rHD.rsb.put(com_tencent_mm_plugin_sns_ui_a_a_c.frH, Integer.valueOf(1));
            if (com_tencent_mm_plugin_sns_ui_a_a_c.mUL.getTop() < 0) {
                this.rHD.qZo.b(com_tencent_mm_plugin_sns_ui_a_a_c.mUL, com_tencent_mm_plugin_sns_ui_a_a_c.position, com_tencent_mm_plugin_sns_ui_a_a_c.mUL.getTop(), com_tencent_mm_plugin_sns_ui_a_a_c.rNI.bzi());
            } else {
                this.rHD.rHo.notifyDataSetChanged();
            }
        }
    }
}
