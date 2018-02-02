package com.tencent.mm.plugin.emoji;

import android.content.Context;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.n;
import com.tencent.mm.api.o.a;
import com.tencent.mm.pluginsdk.ui.chat.k;
import com.tencent.mm.view.SmileyPanelImpl;

class PluginEmoji$3 implements a {
    final /* synthetic */ PluginEmoji lte;

    PluginEmoji$3(PluginEmoji pluginEmoji) {
        this.lte = pluginEmoji;
    }

    public final SmileyPanel ak(Context context) {
        return new SmileyPanelImpl(context);
    }

    public final n tn() {
        return new k();
    }
}
