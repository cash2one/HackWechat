package com.tencent.rtmp.sharp.jni;

class TraeAudioManager$i extends TraeAudioManager$k {
    final /* synthetic */ TraeAudioManager a;

    TraeAudioManager$i(TraeAudioManager traeAudioManager) {
        this.a = traeAudioManager;
        super(traeAudioManager);
    }

    public void a() {
        if (!TraeAudioManager.IsMusicScene && TraeAudioManager.IsUpdateSceneFlag) {
            this.a._am.setWiredHeadsetOn(true);
        }
        e();
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "connect headset: do nothing");
        }
    }

    public String b() {
        return TraeAudioManager.DEVICE_WIREDHEADSET;
    }

    public void c() {
    }
}
