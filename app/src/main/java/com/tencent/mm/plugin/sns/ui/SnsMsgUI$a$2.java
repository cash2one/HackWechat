package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.ui.SnsMsgUI.a;
import com.tencent.mm.sdk.platformtools.x;

class SnsMsgUI$a$2 implements OnClickListener {
    final /* synthetic */ a rDJ;

    SnsMsgUI$a$2(a aVar) {
        this.rDJ = aVar;
    }

    public final void onClick(View view) {
        x.v("MicroMsg.SnsMsgUI", "on delView clicked");
        this.rDJ.kBF.aUz();
        if (this.rDJ.rDI != null) {
            this.rDJ.rDI.bo(view.getTag());
        }
    }
}
