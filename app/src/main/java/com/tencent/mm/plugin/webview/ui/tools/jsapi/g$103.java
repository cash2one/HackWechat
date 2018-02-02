package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.u;

class g$103 implements Runnable {
    final /* synthetic */ String jkM;
    final /* synthetic */ g tIj;
    final /* synthetic */ String tJq;

    g$103(g gVar, String str, String str2) {
        this.tIj = gVar;
        this.jkM = str;
        this.tJq = str2;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.putExtra("scene_from", 4);
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 5);
        intent.putExtra("Retr_Msg_thumb_path", this.jkM);
        intent.putExtra("emoji_activity_id", this.tJq);
        intent.putExtra(u.FLAG_OVERRIDE_ENTER_ANIMATION, R.a.bpZ);
        if (g.i(this.tIj) instanceof MMActivity) {
            d.a((MMActivity) g.i(this.tIj), ".ui.transmit.SelectConversationUI", intent, 52, this.tIj);
        }
    }
}
