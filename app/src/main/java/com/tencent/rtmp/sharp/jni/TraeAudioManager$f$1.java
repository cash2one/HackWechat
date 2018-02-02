package com.tencent.rtmp.sharp.jni;

import com.tencent.rtmp.sharp.jni.TraeAudioManager.f;
import com.tencent.rtmp.sharp.jni.TraeMediaPlayer.a;
import java.util.HashMap;

class TraeAudioManager$f$1 implements a {
    final /* synthetic */ f a;

    TraeAudioManager$f$1(f fVar) {
        this.a = fVar;
    }

    public void a() {
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "_ringPlayer onCompletion _activeMode:" + this.a.p._activeMode + " _preRingMode:" + this.a.k);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(TraeAudioManager.PARAM_ISHOSTSIDE, Boolean.valueOf(true));
        this.a.a(32783, hashMap);
        this.a.j();
    }
}
