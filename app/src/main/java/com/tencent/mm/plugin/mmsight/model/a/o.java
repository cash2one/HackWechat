package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;

@TargetApi(18)
@Deprecated
public final class o implements e {
    boolean fAs;
    private MediaMuxer ovR;
    private int ovS;
    private int ovT;
    long ovU;

    public final boolean baH() {
        return false;
    }

    public final synchronized void c(MediaFormat mediaFormat) {
        try {
            if (this.ovR != null && this.ovS == -1) {
                this.ovS = this.ovR.addTrack(mediaFormat);
                x.i("MicroMsg.MMSightSystemMediaMuxer", "addX264Track, x264TrackIndex: %s", new Object[]{Integer.valueOf(this.ovS)});
                if (!(this.fAs || this.ovS == -1 || this.ovT == -1)) {
                    x.i("MicroMsg.MMSightSystemMediaMuxer", "start!");
                    this.ovR.start();
                    this.fAs = true;
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMSightSystemMediaMuxer", "addX264Track error: %s", new Object[]{e.getMessage()});
        }
    }

    public final synchronized void d(MediaFormat mediaFormat) {
        try {
            if (this.ovR != null && this.ovT == -1) {
                this.ovT = this.ovR.addTrack(mediaFormat);
                x.i("MicroMsg.MMSightSystemMediaMuxer", "addAACTrack, aacTrackIndex: %s", new Object[]{Integer.valueOf(this.ovT)});
                if (!(this.fAs || this.ovT == -1 || this.ovS == -1)) {
                    x.i("MicroMsg.MMSightSystemMediaMuxer", "start!");
                    this.ovR.start();
                    this.fAs = true;
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMSightSystemMediaMuxer", "addAACTrack error: %s", new Object[]{e.getMessage()});
        }
    }

    public final synchronized void f(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        try {
            if (!(this.ovR == null || this.ovT == -1 || !this.fAs || byteBuffer == null || bufferInfo == null)) {
                long j = bufferInfo.presentationTimeUs;
                bufferInfo.presentationTimeUs = (System.nanoTime() - this.ovU) / 1000;
                long Wq = bh.Wq();
                this.ovR.writeSampleData(this.ovT, byteBuffer, bufferInfo);
                x.v("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData size: %s used %dms oldpts %s fix pts: %s", new Object[]{Integer.valueOf(bufferInfo.size), Long.valueOf(bh.bA(Wq)), Long.valueOf(j), Long.valueOf(bufferInfo.presentationTimeUs)});
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData error: %s", new Object[]{e.getMessage()});
        }
    }

    public final synchronized void g(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        int i = 1;
        synchronized (this) {
            try {
                if (!(this.ovR == null || this.ovS == -1 || !this.fAs)) {
                    int i2 = byteBuffer != null ? 1 : 0;
                    if (bufferInfo == null) {
                        i = 0;
                    }
                    if ((i & i2) != 0) {
                        long j = bufferInfo.presentationTimeUs;
                        bufferInfo.presentationTimeUs = (System.nanoTime() - this.ovU) / 1000;
                        bufferInfo.flags = 1;
                        long Wq = bh.Wq();
                        this.ovR.writeSampleData(this.ovS, byteBuffer, bufferInfo);
                        x.v("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData size: %s used %dms oldpts %s fix pts: %s", new Object[]{Integer.valueOf(bufferInfo.size), Long.valueOf(bh.bA(Wq)), Long.valueOf(j), Long.valueOf(bufferInfo.presentationTimeUs)});
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.MMSightSystemMediaMuxer", "writeX264SampleData error: %s", new Object[]{e.getMessage()});
            }
        }
    }
}
