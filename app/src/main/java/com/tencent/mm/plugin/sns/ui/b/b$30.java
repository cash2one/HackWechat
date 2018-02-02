package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class b$30 implements OnClickListener {
    final /* synthetic */ b rPY;

    b$30(b bVar) {
        this.rPY = bVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof String) {
            m Lm = ae.bvv().Lm((String) view.getTag());
            if (Lm != null && Lm.xl(32)) {
                x.i("MicroMsg.TimelineClickListener", "click the ad tailLink button");
                a bxT = Lm.bxT();
                if (bxT == null) {
                    x.e("MicroMsg.TimelineClickListener", "the adInfo is null");
                } else if (bh.ov(bxT.rdX)) {
                    x.e("MicroMsg.TimelineClickListener", "the adActionExtTailLink is null");
                } else {
                    x.i("MicroMsg.TimelineClickListener", "open webview url : " + bxT.rdX);
                    Intent intent = new Intent();
                    intent.putExtra("jsapiargs", new Bundle());
                    intent.putExtra("useJs", true);
                    intent.putExtra("rawUrl", bxT.rdX);
                    com.tencent.mm.plugin.sns.c.a.ifs.j(intent, this.rPY.activity);
                }
            }
        }
    }
}
