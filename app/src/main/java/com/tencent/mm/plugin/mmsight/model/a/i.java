package com.tencent.mm.plugin.mmsight.model.a;

import android.media.MediaRecorder;
import com.tencent.mm.e.b.c;
import com.tencent.mm.plugin.mmsight.model.a.c.a;
import com.tencent.mm.plugin.mmsight.model.a.c.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

public final class i implements c {
    private int audioSampleRate;
    private int huc;
    private MediaRecorder ouJ;
    private boolean ouK = false;
    a oux;
    private af ouz = new 1(this);

    public final int a(com.tencent.mm.plugin.mmsight.model.a.c.a r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r7 = this;
        r3 = 1;
        r0 = 0;
        r1 = "MicroMsg.MMSightAACMediaRecorder";
        r2 = "start, onPcmReady: %s";
        r3 = new java.lang.Object[r3];
        r3[r0] = r8;
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);
        r7.oux = r8;
        r1 = r7.ouJ;	 Catch:{ Exception -> 0x0024, all -> 0x003f }
        if (r1 == 0) goto L_0x001e;	 Catch:{ Exception -> 0x0024, all -> 0x003f }
    L_0x0015:
        r1 = r7.ouK;	 Catch:{ Exception -> 0x0024, all -> 0x003f }
        if (r1 != 0) goto L_0x001e;	 Catch:{ Exception -> 0x0024, all -> 0x003f }
    L_0x0019:
        r1 = r7.ouJ;	 Catch:{ Exception -> 0x0024, all -> 0x003f }
        r1.start();	 Catch:{ Exception -> 0x0024, all -> 0x003f }
    L_0x001e:
        r1 = r7.ouz;
        r1.sendEmptyMessage(r0);
    L_0x0023:
        return r0;
    L_0x0024:
        r1 = move-exception;
        r2 = "MicroMsg.MMSightAACMediaRecorder";	 Catch:{ Exception -> 0x0024, all -> 0x003f }
        r3 = "start record aac.mp4 error:%s";	 Catch:{ Exception -> 0x0024, all -> 0x003f }
        r4 = 1;	 Catch:{ Exception -> 0x0024, all -> 0x003f }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0024, all -> 0x003f }
        r5 = 0;	 Catch:{ Exception -> 0x0024, all -> 0x003f }
        r6 = r1.getMessage();	 Catch:{ Exception -> 0x0024, all -> 0x003f }
        r4[r5] = r6;	 Catch:{ Exception -> 0x0024, all -> 0x003f }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r1, r3, r4);	 Catch:{ Exception -> 0x0024, all -> 0x003f }
        r1 = r7.ouz;
        r1.sendEmptyMessage(r0);
        r0 = -1;
        goto L_0x0023;
    L_0x003f:
        r1 = move-exception;
        r2 = r7.ouz;
        r2.sendEmptyMessage(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.model.a.i.a(com.tencent.mm.plugin.mmsight.model.a.c$a):int");
    }

    public i(int i, int i2) {
        this.audioSampleRate = i;
        this.huc = i2;
        x.i("MicroMsg.MMSightAACMediaRecorder", "MMSightAACMediaRecorder, sampleRate: %s, bitrate: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final int ar(int i, String str) {
        x.i("MicroMsg.MMSightAACMediaRecorder", "MMSightAACMediaRecorder init tempPath[%s], sampleRate[%d]", new Object[]{str, Integer.valueOf(this.audioSampleRate)});
        this.ouJ = new MediaRecorder();
        this.ouJ.setAudioSource(1);
        this.ouJ.setOutputFormat(2);
        this.ouJ.setAudioEncoder(3);
        this.ouJ.setAudioChannels(1);
        this.ouJ.setAudioEncodingBitRate(this.huc);
        this.ouJ.setAudioSamplingRate(this.audioSampleRate);
        this.ouJ.setOutputFile(str);
        try {
            this.ouJ.prepare();
            return 0;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", e, "mediaRecorder prepare error: %s", new Object[]{e.getMessage()});
            return -1;
        }
    }

    public final int a(b bVar) {
        x.i("MicroMsg.MMSightAACMediaRecorder", "stop, mediaRecorder: %s, callback: %s", new Object[]{this.ouJ, bVar});
        if (this.ouJ != null) {
            try {
                if (!this.ouK) {
                    this.ouJ.stop();
                    this.ouJ.release();
                }
                this.ouJ = null;
                if (bVar == null) {
                    return 0;
                }
                bVar.bau();
                return 0;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", e, "stop record aac.mp4 error:%s", new Object[]{e.getMessage()});
                return -1;
            }
        } else if (bVar == null) {
            return 0;
        } else {
            bVar.bau();
            return 0;
        }
    }

    public final void clear() {
        try {
            if (this.ouJ != null) {
                if (!this.ouK) {
                    this.ouJ.stop();
                    this.ouJ.release();
                }
                this.ouJ = null;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", e, "clear error: %s", new Object[]{e.getMessage()});
        }
    }

    public final void bar() {
    }

    public final c.a bas() {
        return null;
    }

    public final void gC(boolean z) {
        this.ouK = z;
    }
}
