package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements OnClickListener {
    final /* synthetic */ b qqi;

    b$1(b bVar) {
        this.qqi = bVar;
    }

    public final void onClick(View view) {
        x.v("MicroMsg.SayHiAdapter", "on delView clicked");
        this.qqi.kBF.aUz();
        if (this.qqi.oPr != null) {
            this.qqi.oPr.bo(view.getTag());
        }
    }
}
