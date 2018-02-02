package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleRecommendView;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.RecommendView;
import com.tencent.mm.pluginsdk.ui.chat.e.a;

class i$6 implements a {
    final /* synthetic */ i lyj;

    i$6(i iVar) {
        this.lyj = iVar;
    }

    public final /* synthetic */ RecommendView h(Context context, boolean z) {
        return new EmojiStoreV2SingleRecommendView(context, z);
    }
}
