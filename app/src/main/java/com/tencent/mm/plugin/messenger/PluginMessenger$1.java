package com.tencent.mm.plugin.messenger;

import android.os.Bundle;
import android.text.SpannableString;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.sdk.platformtools.bh;
import java.lang.ref.WeakReference;
import java.util.Map;

class PluginMessenger$1 implements b {
    final /* synthetic */ PluginMessenger oom;

    PluginMessenger$1(PluginMessenger pluginMessenger) {
        this.oom = pluginMessenger;
    }

    public final /* synthetic */ CharSequence a(Map map, String str, Bundle bundle, WeakReference weakReference) {
        return map == null ? null : new SpannableString(bh.ou((String) map.get(str + ".plain")));
    }
}
