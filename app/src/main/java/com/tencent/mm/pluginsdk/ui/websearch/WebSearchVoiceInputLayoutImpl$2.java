package com.tencent.mm.pluginsdk.ui.websearch;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class WebSearchVoiceInputLayoutImpl$2 implements OnTouchListener {
    final /* synthetic */ WebSearchVoiceInputLayoutImpl vzr;

    WebSearchVoiceInputLayoutImpl$2(WebSearchVoiceInputLayoutImpl webSearchVoiceInputLayoutImpl) {
        this.vzr = webSearchVoiceInputLayoutImpl;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                WebSearchVoiceInputLayoutImpl.a(this.vzr, false);
                WebSearchVoiceInputLayoutImpl.a(this.vzr, bh.Wq());
                x.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[]{Integer.valueOf(WebSearchVoiceInputLayoutImpl.c(this.vzr)), Long.valueOf(WebSearchVoiceInputLayoutImpl.d(this.vzr))});
                WebSearchVoiceInputLayoutImpl.b(this.vzr).cas();
                this.vzr.O(false, false);
                break;
            case 1:
                x.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[]{Integer.valueOf(WebSearchVoiceInputLayoutImpl.e(this.vzr)), Boolean.valueOf(WebSearchVoiceInputLayoutImpl.f(this.vzr))});
                if (!WebSearchVoiceInputLayoutImpl.f(this.vzr)) {
                    this.vzr.O(false, true);
                    break;
                }
                this.vzr.O(true, false);
                WebSearchVoiceInputLayoutImpl.a(this.vzr, false);
                WebSearchVoiceInputLayoutImpl.a(this.vzr, 0);
                break;
        }
        return false;
    }
}
