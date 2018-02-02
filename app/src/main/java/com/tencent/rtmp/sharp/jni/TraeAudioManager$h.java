package com.tencent.rtmp.sharp.jni;

class TraeAudioManager$h extends TraeAudioManager$k {
    final /* synthetic */ TraeAudioManager a;

    TraeAudioManager$h(TraeAudioManager traeAudioManager) {
        this.a = traeAudioManager;
        super(traeAudioManager);
    }

    public void a() {
        if (TraeAudioManager.IsUpdateSceneFlag) {
            e();
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "connect earphone: do nothing");
        }
    }

    public String b() {
        return TraeAudioManager.DEVICE_EARPHONE;
    }

    public void c() {
    }
}
