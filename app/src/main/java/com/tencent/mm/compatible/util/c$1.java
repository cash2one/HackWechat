package com.tencent.mm.compatible.util;

import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements OnAudioFocusChangeListener {
    final /* synthetic */ c gHq;

    c$1(c cVar) {
        this.gHq = cVar;
    }

    public final void onAudioFocusChange(int i) {
        if (this.gHq.gHo != null) {
            x.d("MicroMsg.AudioFocusHelper", "jacks change: %d", new Object[]{Integer.valueOf(i)});
            this.gHq.gHo.es(i);
        }
    }
}
