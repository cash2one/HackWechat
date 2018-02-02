package com.tencent.mm.pluginsdk.ui.websearch;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.sdk.platformtools.x;

class WebSearchVoiceInputLayoutImpl$1 implements OnLongClickListener {
    final /* synthetic */ WebSearchVoiceInputLayoutImpl vzr;

    WebSearchVoiceInputLayoutImpl$1(WebSearchVoiceInputLayoutImpl webSearchVoiceInputLayoutImpl) {
        this.vzr = webSearchVoiceInputLayoutImpl;
    }

    public final boolean onLongClick(View view) {
        x.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onLongClickListener currentState %s", new Object[]{Integer.valueOf(WebSearchVoiceInputLayoutImpl.a(this.vzr))});
        WebSearchVoiceInputLayoutImpl.a(this.vzr, true);
        WebSearchVoiceInputLayoutImpl.b(this.vzr).caq();
        return true;
    }
}
