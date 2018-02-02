package com.tencent.mm.plugin.appbrand.widget.input.a;

import android.os.Looper;
import android.os.Message;
import android.text.Selection;
import com.tencent.mm.sdk.platformtools.af;

public final class a {
    private final af H = new 1(this, Looper.getMainLooper());
    public volatile c kaI;

    public final void a(CharSequence charSequence, boolean z) {
        if (charSequence != null) {
            Message obtainMessage = this.H.obtainMessage(1000, Selection.getSelectionEnd(charSequence), 0, charSequence.toString());
            this.H.removeMessages(1000);
            this.H.sendMessageDelayed(obtainMessage, z ? 150 : 0);
        }
    }
}
