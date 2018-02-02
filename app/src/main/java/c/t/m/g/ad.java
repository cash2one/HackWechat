package c.t.m.g;

import android.os.Build;

final class ad implements Runnable {
    private /* synthetic */ String a;

    ad(String str) {
        this.a = str;
    }

    public final void run() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Print SDKBaseInfo on tag:" + this.a);
            stringBuilder.append("\r\nPlatformProtocalType:2");
            stringBuilder.append("\r\nappContext:" + m.j());
            stringBuilder.append("\r\nbootSessionId:" + m.k());
            stringBuilder.append("\r\nbootTime:" + m.l());
            stringBuilder.append("\r\nappId:" + m.m());
            stringBuilder.append("\r\nisSDKMode:" + m.n());
            stringBuilder.append("\r\nbundle:" + m.o());
            stringBuilder.append("\r\nappVersionName:" + m.a);
            stringBuilder.append("\r\nappVersionCode:" + m.c);
            stringBuilder.append("\r\nappLabelName:" + m.b);
            stringBuilder.append("\r\nuuid:" + m.d);
            stringBuilder.append("\r\nchannelId:" + m.e);
            stringBuilder.append("\r\nsdkVersion:" + m.p());
            stringBuilder.append("\r\nsProcessName:" + m.q());
            stringBuilder.append("\r\npid:" + m.f);
            stringBuilder.append("\r\nsProcessNameSubfix:" + m.r());
            stringBuilder.append("\r\nsIsMainProcess:" + m.s());
            stringBuilder.append("\r\npsInRemoteProcess:" + m.g);
            stringBuilder.append("\r\nisTestMode:false");
            if (m.j() != null) {
                stringBuilder.append("\r\ndeviceid:" + cb.a());
            }
            stringBuilder.append("\r\nfinger:" + Build.FINGERPRINT);
        } catch (Throwable th) {
        }
    }
}
