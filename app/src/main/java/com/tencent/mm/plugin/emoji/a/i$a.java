package com.tencent.mm.plugin.emoji.a;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;

class i$a {
    final /* synthetic */ i luw;
    StoreBannerEmojiView luy;
    ImageView luz;

    public i$a(i iVar, View view) {
        this.luw = iVar;
        this.luy = (StoreBannerEmojiView) view.findViewById(R.h.cdn);
        this.luz = (ImageView) view.findViewById(R.h.cAc);
        this.luy.nyC = 0;
    }
}
