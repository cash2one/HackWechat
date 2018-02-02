package com.tencent.mm.plugin.emoji.ui;

import android.view.View;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.R;

class EmojiStoreDetailUI$c {
    final /* synthetic */ EmojiStoreDetailUI lDM;
    SquareImageView lDP;

    public EmojiStoreDetailUI$c(EmojiStoreDetailUI emojiStoreDetailUI, View view) {
        this.lDM = emojiStoreDetailUI;
        this.lDP = (SquareImageView) view.findViewById(R.h.cbo);
        this.lDP.setScaleType(ScaleType.FIT_CENTER);
    }
}
