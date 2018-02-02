package com.tencent.mm.plugin.emoji.ui;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.mm.R;

class EmojiCustomUI$d {
    View lCk;
    ImageView lCl;
    CheckBox lCm;

    public EmojiCustomUI$d(View view) {
        this.lCk = view.findViewById(R.h.cro);
        this.lCl = (ImageView) view.findViewById(R.h.image);
        this.lCm = (CheckBox) view.findViewById(R.h.checked);
    }
}
