package com.tencent.rtmp.sharp.jni;

import android.annotation.TargetApi;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.rtmp.sharp.jni.TraeAudioManager.f;

class TraeAudioManager$f$3 implements OnAudioFocusChangeListener {
    final /* synthetic */ f a;

    TraeAudioManager$f$3(f fVar) {
        this.a = fVar;
    }

    @TargetApi(8)
    public void onAudioFocusChange(int i) {
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "focusChange:" + i + " _focusSteamType:" + this.a.o + " currMode:" + this.a.p._am.getMode() + " _activeMode:" + this.a.p._activeMode);
        }
    }
}
