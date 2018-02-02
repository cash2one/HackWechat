package com.tencent.rtmp.sharp.jni;

import com.tencent.rtmp.sharp.jni.TraeAudioManager.e;

public class TraeAudioManager$e$a {
    String a = TraeAudioManager.DEVICE_NONE;
    boolean b = false;
    int c = 0;
    final /* synthetic */ e d;

    public TraeAudioManager$e$a(e eVar) {
        this.d = eVar;
    }

    public boolean a(String str, int i) {
        if (str == null || str.length() <= 0 || !TraeAudioManager.checkDevName(str)) {
            return false;
        }
        this.a = str;
        this.c = i;
        return true;
    }

    public String a() {
        return this.a;
    }

    public boolean b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public void a(boolean z) {
        this.b = z;
    }
}
