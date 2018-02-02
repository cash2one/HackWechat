package com.tencent.liteav.audio.impl.Play;

import android.media.AudioTrack;
import com.tencent.liteav.basic.log.TXCLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

class d$1 extends Thread {
    final /* synthetic */ d a;

    d$1(d dVar, String str) {
        this.a = dVar;
        super(str);
    }

    public void run() {
        int i = 3;
        if (d.a(this.a) == null) {
            try {
                int i2;
                if (d.b(this.a) == 1) {
                    i2 = 2;
                } else {
                    i2 = 3;
                }
                if (d.c(this.a) != 8) {
                    i = 2;
                }
                d.a(this.a, new AudioTrack(3, d.d(this.a), i2, i, AudioTrack.getMinBufferSize(d.d(this.a), i2, i), 1));
                TXCLog.i(d.e(), "create audio track, samplerate:" + d.d(this.a) + ", channels:" + d.b(this.a) + ", bits:" + d.c(this.a));
            } catch (Exception e) {
                return;
            }
        }
        try {
            d.a(this.a).play();
            d.a(this.a, true);
            this.a.a(d.e(this.a), d.f(this.a));
            int i3 = 100;
            int i4 = 0;
            while (d.g(this.a)) {
                byte[] nativeGetMixedTracksData = b.nativeGetMixedTracksData(2048);
                if (nativeGetMixedTracksData == null || nativeGetMixedTracksData.length <= 0) {
                    try {
                        sleep(5);
                    } catch (InterruptedException e2) {
                    }
                } else {
                    if (d.h(this.a)) {
                        Arrays.fill(nativeGetMixedTracksData, (byte) 0);
                    }
                    if (i3 != 0 && i4 < 800) {
                        short[] sArr = new short[(nativeGetMixedTracksData.length / 2)];
                        ByteBuffer.wrap(nativeGetMixedTracksData).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(sArr);
                        for (int i5 = 0; i5 < sArr.length; i5++) {
                            sArr[i5] = (short) (sArr[i5] / i3);
                        }
                        ByteBuffer.wrap(nativeGetMixedTracksData).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put(sArr);
                        i4 += nativeGetMixedTracksData.length / ((d.d(this.a) * 2) / 1000);
                        i3 = (i3 * (800 - i4)) / 800;
                    }
                    d.a(this.a).write(nativeGetMixedTracksData, 0, nativeGetMixedTracksData.length);
                }
            }
            try {
                d.a(this.a).pause();
                d.a(this.a).flush();
                d.a(this.a).stop();
                d.a(this.a).release();
                d.a(this.a, null);
            } catch (Exception e3) {
            }
            TXCLog.e(d.e(), "mult-player thread stop finish!");
        } catch (Exception e4) {
        }
    }
}
