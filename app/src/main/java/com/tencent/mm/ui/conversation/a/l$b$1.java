package com.tencent.mm.ui.conversation.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.conversation.a.l.b;

class l$b$1 implements OnClickListener {
    final /* synthetic */ b zbf;

    l$b$1(b bVar) {
        this.zbf = bVar;
    }

    public final void onClick(View view) {
        b bVar = (b) view.getTag();
        x.i("MicroMsg.MassSightBanner", "on click, massSendId %d, failed %B", new Object[]{Long.valueOf(bVar.zaY), Boolean.valueOf(bVar.zaZ)});
        if (bVar.zaZ) {
            t.bu(bVar.zaY);
        }
    }
}
