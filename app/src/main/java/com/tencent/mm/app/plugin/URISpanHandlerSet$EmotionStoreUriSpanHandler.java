package com.tencent.mm.app.plugin;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.bm.d;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.applet.k;
import com.tencent.mm.pluginsdk.ui.d.f;

@a
class URISpanHandlerSet$EmotionStoreUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet fhe;

    URISpanHandlerSet$EmotionStoreUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.fhe = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final k cH(String str) {
        if (!str.trim().startsWith("weixin://emoticonstore/")) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf("/");
        Object obj = "";
        if (lastIndexOf != -1) {
            obj = str.substring(lastIndexOf + 1);
        }
        return new k(str, 29, obj);
    }

    final int[] uC() {
        return new int[]{29};
    }

    final boolean a(k kVar, f fVar) {
        if (kVar.type != 29) {
            return false;
        }
        if (fVar != null) {
            fVar.a(kVar);
        }
        Intent intent = new Intent();
        intent.putExtra("download_entrance_scene", 21);
        intent.putExtra("extra_id", (String) kVar.A(String.class));
        intent.putExtra("preceding_scence", 3);
        d.b(URISpanHandlerSet.a(this.fhe), "emoji", ".ui.EmojiStoreDetailUI", intent);
        if (fVar != null) {
            fVar.b(kVar);
        }
        return true;
    }

    final boolean a(String str, boolean z, t tVar, Bundle bundle) {
        return false;
    }
}
