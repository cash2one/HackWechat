package com.tencent.mm.plugin.emoji.ui.v2;

import android.view.View;
import android.view.View.OnClickListener;

class d$1 implements OnClickListener {
    final /* synthetic */ int kgc;
    final /* synthetic */ PaddingImageView lIv;
    final /* synthetic */ d lIw;

    d$1(d dVar, PaddingImageView paddingImageView, int i) {
        this.lIw = dVar;
        this.lIv = paddingImageView;
        this.kgc = i;
    }

    public final void onClick(View view) {
        if (d.a(this.lIw) != null) {
            d.a(this.lIw).mv(this.kgc);
        }
    }
}
