package com.tencent.mm.plugin.bottle.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements OnClickListener {
    final /* synthetic */ a kBG;

    a$1(a aVar) {
        this.kBG = aVar;
    }

    public final void onClick(View view) {
        x.v("MicroMsg.BottleConversationAdapter", "on delView clicked");
        this.kBG.kBF.aUz();
        if (this.kBG.kBE != null) {
            this.kBG.kBE.bo(view.getTag());
        }
    }
}
