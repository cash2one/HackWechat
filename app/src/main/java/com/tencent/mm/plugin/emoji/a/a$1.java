package com.tencent.mm.plugin.emoji.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.emoji.model.h$a;

class a$1 implements OnClickListener {
    final /* synthetic */ h$a ltC;
    final /* synthetic */ a ltD;

    a$1(a aVar, h$a com_tencent_mm_plugin_emoji_model_h_a) {
        this.ltD = aVar;
        this.ltC = com_tencent_mm_plugin_emoji_model_h_a;
    }

    public final void onClick(View view) {
        if (this.ltD.a(this.ltC, view)) {
            this.ltD.b(this.ltC, view);
        }
    }
}
