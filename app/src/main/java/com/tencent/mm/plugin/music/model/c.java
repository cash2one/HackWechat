package com.tencent.mm.plugin.music.model;

import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    OnAudioFocusChangeListener oJs = new OnAudioFocusChangeListener(this) {
        final /* synthetic */ c oJt;

        {
            this.oJt = r1;
        }

        public final void onAudioFocusChange(int i) {
            x.i("MicroMsg.Music.MusicAudioFocusHelper", "focus change %d", new Object[]{Integer.valueOf(i)});
            if (i == -2 || i == -3) {
                x.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus lossTransient");
                if (h.bdz().bdn().Qr()) {
                    h.bdz().bdn().bdN();
                }
            } else if (i == 1 || i == 2 || i == 3) {
                x.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus gain");
                if (h.bdz().bdn().Qr()) {
                    h.bdz().bdn().resume();
                }
            } else if (i == -1) {
                x.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus loss, passive pause");
                if (h.bdz().bdn().Qr()) {
                    h.bdz().bdn().bdN();
                    h.bdz();
                    e.bdu();
                    h.bdz().bdv();
                }
                h.bdB().abandonAudioFocus(this.oJt.oJs);
            }
        }
    };

    public final boolean requestFocus() {
        boolean z;
        int requestAudioFocus = h.bdB().requestAudioFocus(this.oJs, 3, 2);
        String str = "MicroMsg.Music.MusicAudioFocusHelper";
        String str2 = "request audio focus %b";
        Object[] objArr = new Object[1];
        if (requestAudioFocus == 1) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (requestAudioFocus == 1) {
            return true;
        }
        return false;
    }

    public final void bdl() {
        x.i("MicroMsg.Music.MusicAudioFocusHelper", "abandonFocus");
        h.bdB().abandonAudioFocus(this.oJs);
    }
}
