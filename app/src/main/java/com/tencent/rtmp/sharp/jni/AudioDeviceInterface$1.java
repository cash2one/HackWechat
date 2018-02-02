package com.tencent.rtmp.sharp.jni;

import com.tencent.rtmp.sharp.jni.TraeAudioSession.a;

class AudioDeviceInterface$1 implements a {
    final /* synthetic */ AudioDeviceInterface a;

    AudioDeviceInterface$1(AudioDeviceInterface audioDeviceInterface) {
        this.a = audioDeviceInterface;
    }

    public void a(boolean z) {
        if (!z) {
            try {
                AudioDeviceInterface.access$000(this.a).lock();
                AudioDeviceInterface.access$102(this.a, true);
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "onVoicecallPreprocessRes signalAll");
                }
                AudioDeviceInterface.access$200(this.a).signalAll();
                AudioDeviceInterface.access$000(this.a).unlock();
            } catch (Exception e) {
            }
        }
    }

    public void a(String[] strArr, String str, String str2, String str3) {
        if (AudioDeviceInterface.access$300(this.a)) {
            AudioDeviceInterface.access$400(this.a, str);
        }
    }

    public void b(boolean z) {
    }

    public void a(int i, String[] strArr, String str, String str2, String str3) {
    }

    public void a(int i, String str, boolean z) {
    }

    public void a(int i, boolean z) {
    }

    public void a(int i, String str) {
        if (i == 0) {
            AudioDeviceInterface.access$400(this.a, str);
        }
    }

    public void b(int i, String str) {
    }

    public void c(int i, String str) {
    }

    public void a(int i) {
    }

    public void a(int i, int i2) {
    }

    public void b(int i) {
        try {
            AudioDeviceInterface.access$000(this.a).lock();
            AudioDeviceInterface.access$102(this.a, true);
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "onVoicecallPreprocessRes signalAll");
            }
            AudioDeviceInterface.access$200(this.a).signalAll();
            AudioDeviceInterface.access$000(this.a).unlock();
        } catch (Exception e) {
        }
    }

    public void a(String str, String str2) {
    }

    public void a(String str, long j) {
    }
}
