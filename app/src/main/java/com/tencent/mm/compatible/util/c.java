package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.compatible.util.b.b;
import com.tencent.mm.sdk.platformtools.x;

@TargetApi(8)
public final class c implements b {
    private Context context;
    private AudioManager gHn;
    a gHo;
    private OnAudioFocusChangeListener gHp = new 1(this);

    public final void a(a aVar) {
        this.gHo = aVar;
    }

    public c(Context context) {
        this.context = context;
    }

    public final boolean requestFocus() {
        if (this.gHn == null && this.context != null) {
            this.gHn = (AudioManager) this.context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        boolean z = this.gHn != null ? 1 == this.gHn.requestAudioFocus(this.gHp, 3, 2) : false;
        x.k("MicroMsg.AudioFocusHelper", "jacks requestFocus: %B, %x", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.gHp.hashCode())});
        return z;
    }

    public final boolean zd() {
        if (this.gHn == null && this.context != null) {
            this.gHn = (AudioManager) this.context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        boolean z = this.gHn != null ? 1 == this.gHn.abandonAudioFocus(this.gHp) : false;
        x.k("MicroMsg.AudioFocusHelper", "jacks abandonFocus: %B, %x", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.gHp.hashCode())});
        return z;
    }
}
