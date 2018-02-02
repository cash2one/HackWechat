package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.j.c$b;

class SnsTimeLineUI$31 implements OnClickListener {
    final /* synthetic */ SnsTimeLineUI rIN;

    SnsTimeLineUI$31(SnsTimeLineUI snsTimeLineUI) {
        this.rIN = snsTimeLineUI;
    }

    public final void onClick(View view) {
        if (!(SnsTimeLineUI.g(this.rIN) == null || SnsTimeLineUI.g(this.rIN).rrt == null)) {
            SnsTimeLineUI.g(this.rIN).rrt.qWT.io(true);
        }
        c$b com_tencent_mm_plugin_sns_j_c_b = (c$b) this.rIN.DW().J(c$b.class);
        b iu = b.iu(725);
        iu.ix(com_tencent_mm_plugin_sns_j_c_b.rRY);
        iu.Sx();
        Intent intent = new Intent();
        intent.setClass(this.rIN, SnsMsgUI.class);
        this.rIN.startActivityForResult(intent, 13);
    }
}
