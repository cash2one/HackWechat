package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.pluginsdk.ui.emoji.PreViewEmojiView;

class m$c {
    PreViewEmojiView lAo;
    final /* synthetic */ m vrP;

    public m$c(m mVar, View view) {
        this.vrP = mVar;
        this.lAo = (PreViewEmojiView) view.findViewById(e.lJv);
        this.lAo.hX = mVar.vrC;
    }
}
