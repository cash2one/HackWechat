package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.MediaPlayer;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.d.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class s implements d {
    String fileName;
    MediaPlayer hXM;
    b hXN;
    a hXe;
    d.b hXf;
    int status;

    public final boolean aK(boolean r6) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1444)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1466)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r5 = this;
        r1 = 1;
        r0 = 0;
        r2 = r5.status;
        if (r2 == r1) goto L_0x001f;
    L_0x0006:
        r1 = "MicroMsg.VoicePlayer";
        r2 = new java.lang.StringBuilder;
        r3 = "pause not STATUS_PLAYING error status:";
        r2.<init>(r3);
        r3 = r5.status;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.x.e(r1, r2);
    L_0x001e:
        return r0;
    L_0x001f:
        r2 = "MicroMsg.VoicePlayer";	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r3 = "pause mediaPlayer.pause()";	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r2 = r5.hXM;	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r2.pause();	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r0 = r5.hXN;
        if (r0 == 0) goto L_0x0041;
    L_0x0031:
        if (r6 == 0) goto L_0x0041;
    L_0x0033:
        r0 = "MicroMsg.VoicePlayer";
        r2 = "pause audioFocusHelper.abandonFocus()";
        com.tencent.mm.sdk.platformtools.x.d(r0, r2);
        r0 = r5.hXN;
        r0.zd();
    L_0x0041:
        r0 = 2;
        r5.status = r0;
        r0 = r1;
        goto L_0x001e;
    L_0x0046:
        r1 = move-exception;
        r2 = "MicroMsg.VoicePlayer";	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r4 = "pause File[";	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r4 = r5.fileName;	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r4 = "] ErrMsg[";	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r1 = r1.getStackTrace();	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r1 = r3.append(r1);	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r3 = "]";	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        com.tencent.mm.sdk.platformtools.x.e(r2, r1);	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r1 = -1;	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r5.status = r1;	 Catch:{ Exception -> 0x0046, all -> 0x008d }
        r1 = r5.hXN;
        if (r1 == 0) goto L_0x001e;
    L_0x007c:
        if (r6 == 0) goto L_0x001e;
    L_0x007e:
        r1 = "MicroMsg.VoicePlayer";
        r2 = "pause audioFocusHelper.abandonFocus()";
        com.tencent.mm.sdk.platformtools.x.d(r1, r2);
        r1 = r5.hXN;
        r1.zd();
        goto L_0x001e;
    L_0x008d:
        r0 = move-exception;
        r1 = r5.hXN;
        if (r1 == 0) goto L_0x00a2;
    L_0x0092:
        if (r6 == 0) goto L_0x00a2;
    L_0x0094:
        r1 = "MicroMsg.VoicePlayer";
        r2 = "pause audioFocusHelper.abandonFocus()";
        com.tencent.mm.sdk.platformtools.x.d(r1, r2);
        r1 = r5.hXN;
        r1.zd();
    L_0x00a2:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvoice.s.aK(boolean):boolean");
    }

    public final boolean vc() {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1444)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1466)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r5 = this;
        r1 = 1;
        r0 = 0;
        r2 = r5.status;
        r3 = 2;
        if (r2 == r3) goto L_0x0020;
    L_0x0007:
        r1 = "MicroMsg.VoicePlayer";
        r2 = new java.lang.StringBuilder;
        r3 = "resume not STATUS_PAUSE error status:";
        r2.<init>(r3);
        r3 = r5.status;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.x.e(r1, r2);
    L_0x001f:
        return r0;
    L_0x0020:
        r2 = "MicroMsg.VoicePlayer";	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r3 = "resume mediaPlayer.start()";	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r2 = r5.hXM;	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r2.start();	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r0 = r5.hXN;
        if (r0 == 0) goto L_0x0040;
    L_0x0032:
        r0 = "MicroMsg.VoicePlayer";
        r2 = "resume audioFocusHelper.requestFocus()";
        com.tencent.mm.sdk.platformtools.x.d(r0, r2);
        r0 = r5.hXN;
        r0.requestFocus();
    L_0x0040:
        r5.status = r1;
        r0 = r1;
        goto L_0x001f;
    L_0x0044:
        r1 = move-exception;
        r2 = "MicroMsg.VoicePlayer";	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r4 = "resume File[";	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r4 = r5.fileName;	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r4 = "] ErrMsg[";	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r1 = r1.getStackTrace();	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r1 = r3.append(r1);	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r3 = "]";	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r1);	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r1 = -1;	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r5.status = r1;	 Catch:{ Exception -> 0x0044, all -> 0x0089 }
        r1 = r5.hXN;
        if (r1 == 0) goto L_0x001f;
    L_0x007a:
        r1 = "MicroMsg.VoicePlayer";
        r2 = "resume audioFocusHelper.requestFocus()";
        com.tencent.mm.sdk.platformtools.x.d(r1, r2);
        r1 = r5.hXN;
        r1.requestFocus();
        goto L_0x001f;
    L_0x0089:
        r0 = move-exception;
        r1 = r5.hXN;
        if (r1 == 0) goto L_0x009c;
    L_0x008e:
        r1 = "MicroMsg.VoicePlayer";
        r2 = "resume audioFocusHelper.requestFocus()";
        com.tencent.mm.sdk.platformtools.x.d(r1, r2);
        r1 = r5.hXN;
        r1.requestFocus();
    L_0x009c:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvoice.s.vc():boolean");
    }

    public final boolean vo() {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1444)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1466)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r5 = this;
        r1 = 1;
        r0 = 0;
        r2 = r5.status;
        if (r2 == r1) goto L_0x0024;
    L_0x0006:
        r2 = r5.status;
        r3 = 2;
        if (r2 == r3) goto L_0x0024;
    L_0x000b:
        r1 = "MicroMsg.VoicePlayer";
        r2 = new java.lang.StringBuilder;
        r3 = "stop not STATUS_PLAYING or STATUS_PAUSE error status:";
        r2.<init>(r3);
        r3 = r5.status;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.x.e(r1, r2);
    L_0x0023:
        return r0;
    L_0x0024:
        r2 = "MicroMsg.VoicePlayer";	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r3 = "stop mediaPlayer.stop()";	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r2 = r5.hXM;	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r2.stop();	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r2 = r5.hXM;	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r2.release();	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r2 = r5.hXN;
        if (r2 == 0) goto L_0x0049;
    L_0x003b:
        r2 = "MicroMsg.VoicePlayer";
        r3 = "stop audioFocusHelper.abandonFocus()";
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);
        r2 = r5.hXN;
        r2.zd();
    L_0x0049:
        r5.status = r0;
        r0 = r1;
        goto L_0x0023;
    L_0x004d:
        r1 = move-exception;
        r2 = "MicroMsg.VoicePlayer";	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r4 = "stop File[";	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r4 = r5.fileName;	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r4 = "] ErrMsg[";	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r1 = r1.getStackTrace();	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r1 = r3.append(r1);	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r3 = "]";	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r1);	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r1 = -1;	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r5.status = r1;	 Catch:{ Exception -> 0x004d, all -> 0x0092 }
        r1 = r5.hXN;
        if (r1 == 0) goto L_0x0023;
    L_0x0083:
        r1 = "MicroMsg.VoicePlayer";
        r2 = "stop audioFocusHelper.abandonFocus()";
        com.tencent.mm.sdk.platformtools.x.d(r1, r2);
        r1 = r5.hXN;
        r1.zd();
        goto L_0x0023;
    L_0x0092:
        r0 = move-exception;
        r1 = r5.hXN;
        if (r1 == 0) goto L_0x00a5;
    L_0x0097:
        r1 = "MicroMsg.VoicePlayer";
        r2 = "stop audioFocusHelper.abandonFocus()";
        com.tencent.mm.sdk.platformtools.x.d(r1, r2);
        r1 = r5.hXN;
        r1.zd();
    L_0x00a5:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvoice.s.vo():boolean");
    }

    public final int getStatus() {
        return this.status;
    }

    public s() {
        this.fileName = "";
        this.hXe = null;
        this.hXf = null;
        this.status = 0;
        this.hXM = new j();
        UJ();
        UK();
        x.d("MicroMsg.VoicePlayer", "VoicePlayer");
    }

    public s(Context context) {
        this();
        this.hXN = new b(context);
        x.d("MicroMsg.VoicePlayer", "VoicePlayer context");
    }

    public final void a(a aVar) {
        this.hXe = aVar;
    }

    public final void a(d.b bVar) {
        this.hXf = bVar;
    }

    private void UJ() {
        this.hXM.setOnCompletionListener(new 1(this));
    }

    private void UK() {
        this.hXM.setOnErrorListener(new 2(this));
    }

    public final void aM(boolean z) {
        x.d("MicroMsg.VoicePlayer", "setSpeakerOn=" + z);
        if (this.hXM != null) {
            if (aq.vd()) {
                x.v("MicroMsg.VoicePlayer", "setSpeakOn return when calling");
                return;
            }
            int currentPosition = this.hXM.getCurrentPosition();
            vo();
            this.hXM = new j();
            UJ();
            UK();
            d(this.fileName, z, currentPosition);
        }
    }

    public final boolean K(String str, boolean z) {
        return d(str, z, 0);
    }

    public final boolean c(String str, boolean z, int i) {
        return d(str, z, i);
    }

    private boolean d(String str, boolean z, int i) {
        if (this.status != 0) {
            x.e("MicroMsg.VoicePlayer", "startPlay error status:" + this.status);
            return false;
        }
        x.i("MicroMsg.VoicePlayer", "startPlay speakerOn:%s,seekTo:%s,", new Object[]{Boolean.valueOf(z), Integer.valueOf(i)});
        this.fileName = str;
        try {
            c(z, i);
        } catch (Throwable e) {
            try {
                c(true, i);
            } catch (Exception e2) {
                x.e("MicroMsg.VoicePlayer", "startPlay File[" + this.fileName + "] failed");
                x.e("MicroMsg.VoicePlayer", "exception:%s", new Object[]{bh.i(e)});
                this.status = -1;
                return false;
            }
        }
        this.status = 1;
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(boolean z, int i) {
        int i2 = 3;
        if (e.bO(this.fileName)) {
            try {
                x.d("MicroMsg.VoicePlayer", "playImp speakerOn:%s,seekTo:%s,type:%s", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(z ? 3 : 0)});
                if (q.gFV.gCG) {
                    q.gFV.dump();
                }
                i2 = r1;
                if (this.hXN != null) {
                    x.d("MicroMsg.VoicePlayer", "playImp audioFocusHelper.requestFocus");
                    this.hXN.requestFocus();
                }
                this.hXM.setAudioStreamType(i2);
                this.hXM.setDataSource(this.fileName);
                this.hXM.prepare();
                if (i > 0) {
                    this.hXM.seekTo(i);
                }
                this.hXM.start();
            } catch (Throwable e) {
                x.e("MicroMsg.VoicePlayer", "playImp : fail, exception = " + e.getMessage());
                x.e("MicroMsg.VoicePlayer", "exception:%s", new Object[]{bh.i(e)});
                if (this.hXN != null) {
                    this.hXN.zd();
                }
            }
        }
    }

    public final boolean isPlaying() {
        return this.status == 1;
    }

    public final double vf() {
        if (this.status != 1 && this.status != 2) {
            return 0.0d;
        }
        try {
            int currentPosition = this.hXM.getCurrentPosition();
            int duration = this.hXM.getDuration();
            if (duration != 0) {
                return ((double) currentPosition) / ((double) duration);
            }
            x.e("MicroMsg.VoicePlayer", "getDuration File[" + this.fileName + "] Failed");
            return 0.0d;
        } catch (Exception e) {
            x.e("MicroMsg.VoicePlayer", "getNowProgress File[" + this.fileName + "] ErrMsg[" + e.getStackTrace() + "]");
            vo();
            return 0.0d;
        }
    }

    public final void b(b.a aVar) {
        if (this.hXN != null && aVar != null) {
            this.hXN.a(aVar);
        }
    }
}
