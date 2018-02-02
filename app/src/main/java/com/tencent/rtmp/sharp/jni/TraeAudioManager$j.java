package com.tencent.rtmp.sharp.jni;

import com.tencent.rtmp.sharp.jni.TraeAudioManager.k;

class TraeAudioManager$j extends k {
    final /* synthetic */ TraeAudioManager a;

    TraeAudioManager$j(TraeAudioManager traeAudioManager) {
        this.a = traeAudioManager;
        super(traeAudioManager);
    }

    public void a() {
        if (!TraeAudioManager.IsMusicScene && TraeAudioManager.IsUpdateSceneFlag) {
            e();
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "connect speakerPhone: do nothing");
        }
    }

    public String b() {
        return TraeAudioManager.DEVICE_SPEAKERPHONE;
    }

    public void c() {
    }
}
