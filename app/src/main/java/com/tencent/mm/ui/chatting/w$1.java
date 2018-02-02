package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;

class w$1 implements OnClickListener {
    final /* synthetic */ w yvp;

    w$1(w wVar) {
        this.yvp = wVar;
    }

    public final void onClick(View view) {
        d.pY(1);
        s.gG("gh_43f2581f6fd6");
        Intent intent = new Intent();
        intent.putExtra("key_is_latest", true);
        intent.putExtra("rank_id", "#");
        intent.putExtra("key_only_show_latest_rank", true);
        intent.putExtra("app_username", r.gu("gh_43f2581f6fd6"));
        intent.putExtra("device_type", 1);
        com.tencent.mm.bm.d.b(view.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", intent);
    }
}
