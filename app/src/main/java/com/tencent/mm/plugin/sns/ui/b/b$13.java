package com.tencent.mm.plugin.sns.ui.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.sdk.platformtools.x;

class b$13 implements OnClickListener {
    final /* synthetic */ b rPY;

    b$13(b bVar) {
        this.rPY = bVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof String) {
            String str = (String) view.getTag();
            x.d("MicroMsg.TimelineClickListener", "localId " + str);
            ai.wJ(u.LG(str));
            ai.wH(u.LG(str));
            ae.bvr().buj();
            this.rPY.bzg();
            if (this.rPY.rPV != null) {
                this.rPY.rPV.bBE();
            }
        }
    }
}
