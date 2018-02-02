package com.google.android.exoplayer2.e;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.a;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.d;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.r;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.k;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public abstract class b extends a {
    private static final byte[] apr = t.al("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private final com.google.android.exoplayer2.drm.b<d> acy;
    private Format aeo;
    private ByteBuffer[] agD;
    private com.google.android.exoplayer2.drm.a<d> apA;
    public MediaCodec apB;
    public a apC;
    private int apD;
    private boolean apE;
    private boolean apF;
    private boolean apG;
    private boolean apH;
    private boolean apI;
    private boolean apJ;
    private boolean apK;
    private boolean apL;
    private ByteBuffer[] apM;
    private long apN;
    private int apO;
    private int apP;
    private boolean apQ;
    private boolean apR;
    private int apS;
    private int apT;
    private boolean apU;
    private boolean apV;
    private boolean apW;
    private boolean apX;
    private boolean apY;
    private boolean apZ;
    private final c aps;
    private final boolean apt;
    private final e apu;
    private final e apv;
    private final k apw;
    private final List<Long> apx;
    private final BufferInfo apy;
    private com.google.android.exoplayer2.drm.a<d> apz;
    public com.google.android.exoplayer2.b.d aqa;

    public abstract int a(c cVar, Format format);

    public abstract void a(a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto);

    public abstract boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z);

    public b(int i, c cVar, com.google.android.exoplayer2.drm.b<d> bVar, boolean z) {
        super(i);
        com.google.android.exoplayer2.i.a.an(t.SDK_INT >= 16);
        this.aps = (c) com.google.android.exoplayer2.i.a.Y(cVar);
        this.acy = bVar;
        this.apt = z;
        this.apu = new e(0);
        this.apv = new e(0);
        this.apw = new k();
        this.apx = new ArrayList();
        this.apy = new BufferInfo();
        this.apS = 0;
        this.apT = 0;
    }

    public final int hU() {
        return 8;
    }

    public final int b(Format format) {
        try {
            int a = a(this.aps, format);
            if ((a & 7) <= 2) {
                return a;
            }
            com.google.android.exoplayer2.drm.b bVar = this.acy;
            boolean jp = format.adY == null ? true : bVar == null ? false : bVar.jp();
            if (jp) {
                return a;
            }
            return (a & -8) | 2;
        } catch (Exception e) {
            throw com.google.android.exoplayer2.e.a(e, this.index);
        }
    }

    public a a(c cVar, Format format, boolean z) {
        return cVar.b(format.adV, z);
    }

    public final void jK() {
        boolean z = false;
        if (this.apB == null && this.aeo != null) {
            boolean z2;
            this.apz = this.apA;
            String str = this.aeo.adV;
            MediaCrypto mediaCrypto = null;
            if (this.apz != null) {
                d dVar = (d) this.apz.jo();
                if (dVar == null) {
                    Exception jn = this.apz.jn();
                    if (jn != null) {
                        throw com.google.android.exoplayer2.e.a(jn, this.index);
                    }
                    return;
                }
                MediaCrypto mediaCrypto2 = dVar.aiv;
                boolean z3 = !dVar.aiw && dVar.aiv.requiresSecureDecoderComponent(str);
                z2 = z3;
                mediaCrypto = mediaCrypto2;
            } else {
                z2 = false;
            }
            if (this.apC == null) {
                try {
                    this.apC = a(this.aps, this.aeo, z2);
                    if (this.apC == null && z2) {
                        this.apC = a(this.aps, this.aeo, false);
                        if (this.apC != null) {
                            new StringBuilder("Drm session requires secure decoder for ").append(str).append(", but no secure decoder available. Trying to proceed with ").append(this.apC.name).append(".");
                        }
                    }
                } catch (Throwable e) {
                    a(new a(this.aeo, e, z2, -49998));
                }
                if (this.apC == null) {
                    a(new a(this.aeo, null, z2, -49999));
                }
            }
            if (a(this.apC)) {
                boolean z4;
                String str2 = this.apC.name;
                int i = (t.SDK_INT <= 24 && "OMX.Exynos.avc.dec.secure".equals(str2) && (t.MODEL.startsWith("SM-T585") || t.MODEL.startsWith("SM-A520"))) ? 2 : (t.SDK_INT >= 24 || !(("OMX.Nvidia.h264.decode".equals(str2) || "OMX.Nvidia.h264.decode.secure".equals(str2)) && ("flounder".equals(t.DEVICE) || "flounder_lte".equals(t.DEVICE) || "grouper".equals(t.DEVICE) || "tilapia".equals(t.DEVICE)))) ? 0 : 1;
                this.apD = i;
                Format format = this.aeo;
                if (t.SDK_INT < 21 && format.adX.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str2)) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.apE = z4;
                if (t.SDK_INT < 18 || ((t.SDK_INT == 18 && ("OMX.SEC.avc.dec".equals(str2) || "OMX.SEC.avc.dec.secure".equals(str2))) || (t.SDK_INT == 19 && t.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str2) || "OMX.Exynos.avc.dec.secure".equals(str2))))) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.apF = z4;
                if (t.SDK_INT > 17 || !("OMX.rk.video_decoder.avc".equals(str2) || "OMX.allwinner.video.decoder.avc".equals(str2))) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                this.apG = z4;
                if ((t.SDK_INT > 23 || !"OMX.google.vorbis.decoder".equals(str2)) && !(t.SDK_INT <= 19 && "hb2000".equals(t.DEVICE) && ("OMX.amlogic.avc.decoder.awesome".equals(str2) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str2)))) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                this.apH = z4;
                if (t.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str2)) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.apI = z4;
                format = this.aeo;
                if (t.SDK_INT <= 18 && format.aef == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str2)) {
                    z = true;
                }
                this.apJ = z;
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    r.beginSection("createCodec:" + str2);
                    this.apB = MediaCodec.createByCodecName(str2);
                    r.endSection();
                    r.beginSection("configureCodec");
                    a(this.apC, this.apB, this.aeo, mediaCrypto);
                    r.endSection();
                    r.beginSection("startCodec");
                    this.apB.start();
                    r.endSection();
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    b(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                    this.apM = this.apB.getInputBuffers();
                    this.agD = this.apB.getOutputBuffers();
                } catch (Throwable e2) {
                    a(new a(this.aeo, e2, z2, str2));
                }
                this.apN = this.state == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                this.apO = -1;
                this.apP = -1;
                this.apZ = true;
                com.google.android.exoplayer2.b.d dVar2 = this.aqa;
                dVar2.ahX++;
            }
        }
    }

    private void a(a aVar) {
        throw com.google.android.exoplayer2.e.a(aVar, this.index);
    }

    public boolean a(a aVar) {
        return true;
    }

    public void ac(boolean z) {
        this.aqa = new com.google.android.exoplayer2.b.d();
    }

    public void a(long j, boolean z) {
        this.apW = false;
        this.apX = false;
        if (this.apB != null) {
            this.apN = -9223372036854775807L;
            this.apO = -1;
            this.apP = -1;
            this.apZ = true;
            this.apY = false;
            this.apQ = false;
            this.apx.clear();
            this.apK = false;
            this.apL = false;
            if (this.apF || (this.apH && this.apV)) {
                jL();
                jK();
            } else if (this.apT != 0) {
                jL();
                jK();
            } else {
                this.apB.flush();
                this.apU = false;
            }
            if (this.apR && this.aeo != null) {
                this.apS = 1;
            }
        }
    }

    public void hW() {
        this.aeo = null;
        try {
            jL();
        } finally {
            this.apz = null;
            this.apA = null;
        }
    }

    public void jL() {
        this.apN = -9223372036854775807L;
        this.apO = -1;
        this.apP = -1;
        this.apY = false;
        this.apQ = false;
        this.apx.clear();
        this.apM = null;
        this.agD = null;
        this.apC = null;
        this.apR = false;
        this.apU = false;
        this.apE = false;
        this.apF = false;
        this.apD = 0;
        this.apG = false;
        this.apH = false;
        this.apJ = false;
        this.apK = false;
        this.apL = false;
        this.apV = false;
        this.apS = 0;
        this.apT = 0;
        this.apu.aif = null;
        if (this.apB != null) {
            com.google.android.exoplayer2.b.d dVar = this.aqa;
            dVar.ahY++;
            try {
                this.apB.stop();
                try {
                    this.apB.release();
                } finally {
                    this.apB = null;
                    if (!(this.apz == null || this.apA == this.apz)) {
                        this.apz = null;
                    }
                }
            } catch (Throwable th) {
                this.apB.release();
            } finally {
                this.apB = null;
                if (!(this.apz == null || this.apA == this.apz)) {
                    this.apz = null;
                }
            }
        }
    }

    public void hV() {
    }

    public void onStopped() {
    }

    public final void c(long j, long j2) {
        if (this.apX) {
            iV();
            return;
        }
        int a;
        if (this.aeo == null) {
            this.apv.clear();
            a = a(this.apw, this.apv, true);
            if (a == -5) {
                e(this.apw.aeo);
            } else if (a == -4) {
                com.google.android.exoplayer2.i.a.an(this.apv.iY());
                this.apW = true;
                jO();
                return;
            } else {
                return;
            }
        }
        jK();
        if (this.apB != null) {
            r.beginSection("drainAndFeed");
            do {
            } while (d(j, j2));
            do {
            } while (jM());
            r.endSection();
        } else {
            this.acj.D(j - this.ack);
            this.apv.clear();
            a = a(this.apw, this.apv, false);
            if (a == -5) {
                e(this.apw.aeo);
            } else if (a == -4) {
                com.google.android.exoplayer2.i.a.an(this.apv.iY());
                this.apW = true;
                jO();
            }
        }
        this.aqa.jc();
    }

    private boolean jM() {
        if (this.apB == null || this.apT == 2 || this.apW) {
            return false;
        }
        if (this.apO < 0) {
            this.apO = this.apB.dequeueInputBuffer(0);
            if (this.apO < 0) {
                return false;
            }
            this.apu.aif = this.apM[this.apO];
            this.apu.clear();
        }
        if (this.apT == 1) {
            if (!this.apG) {
                this.apV = true;
                this.apB.queueInputBuffer(this.apO, 0, 0, 0, 4);
                this.apO = -1;
            }
            this.apT = 2;
            return false;
        } else if (this.apK) {
            this.apK = false;
            this.apu.aif.put(apr);
            this.apB.queueInputBuffer(this.apO, 0, apr.length, 0, 0);
            this.apO = -1;
            this.apU = true;
            return true;
        } else {
            int i;
            int i2;
            if (this.apY) {
                i = -4;
                i2 = 0;
            } else {
                if (this.apS == 1) {
                    for (i2 = 0; i2 < this.aeo.adX.size(); i2++) {
                        this.apu.aif.put((byte[]) this.aeo.adX.get(i2));
                    }
                    this.apS = 2;
                }
                int position = this.apu.aif.position();
                i = a(this.apw, this.apu, false);
                i2 = position;
            }
            if (i == -3) {
                return false;
            }
            if (i == -5) {
                if (this.apS == 2) {
                    this.apu.clear();
                    this.apS = 1;
                }
                e(this.apw.aeo);
                return true;
            } else if (this.apu.iY()) {
                if (this.apS == 2) {
                    this.apu.clear();
                    this.apS = 1;
                }
                this.apW = true;
                if (this.apU) {
                    try {
                        if (this.apG) {
                            return false;
                        }
                        this.apV = true;
                        this.apB.queueInputBuffer(this.apO, 0, 0, 0, 4);
                        this.apO = -1;
                        return false;
                    } catch (Exception e) {
                        throw com.google.android.exoplayer2.e.a(e, this.index);
                    }
                }
                jO();
                return false;
            } else if (!this.apZ || this.apu.iZ()) {
                boolean z;
                this.apZ = false;
                boolean jd = this.apu.jd();
                if (this.apz == null || (!jd && this.apt)) {
                    z = false;
                } else {
                    i = this.apz.getState();
                    if (i == 1) {
                        throw com.google.android.exoplayer2.e.a(this.apz.jn(), this.index);
                    }
                    z = i != 4;
                }
                this.apY = z;
                if (this.apY) {
                    return false;
                }
                if (this.apE && !jd) {
                    h.d(this.apu.aif);
                    if (this.apu.aif.position() == 0) {
                        return true;
                    }
                    this.apE = false;
                }
                try {
                    long j = this.apu.aig;
                    if (this.apu.iX()) {
                        this.apx.add(Long.valueOf(j));
                    }
                    this.apu.je();
                    jN();
                    if (jd) {
                        CryptoInfo cryptoInfo = this.apu.aie.ahU;
                        if (i2 != 0) {
                            if (cryptoInfo.numBytesOfClearData == null) {
                                cryptoInfo.numBytesOfClearData = new int[1];
                            }
                            int[] iArr = cryptoInfo.numBytesOfClearData;
                            iArr[0] = i2 + iArr[0];
                        }
                        this.apB.queueSecureInputBuffer(this.apO, 0, cryptoInfo, j, 0);
                    } else {
                        this.apB.queueInputBuffer(this.apO, 0, this.apu.aif.limit(), j, 0);
                    }
                    this.apO = -1;
                    this.apU = true;
                    this.apS = 0;
                    com.google.android.exoplayer2.b.d dVar = this.aqa;
                    dVar.ahZ++;
                    return true;
                } catch (Exception e2) {
                    throw com.google.android.exoplayer2.e.a(e2, this.index);
                }
            } else {
                this.apu.clear();
                if (this.apS == 2) {
                    this.apS = 1;
                }
                return true;
            }
        }
    }

    public void b(String str, long j, long j2) {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(Format format) {
        Format format2 = this.aeo;
        this.aeo = format;
        if (!t.h(this.aeo.adY, format2 == null ? null : format2.adY)) {
            if (this.aeo.adY == null) {
                this.apA = null;
            } else if (this.acy == null) {
                throw com.google.android.exoplayer2.e.a(new IllegalStateException("Media requires a DrmSessionManager"), this.index);
            } else {
                com.google.android.exoplayer2.drm.b bVar = this.acy;
                Looper.myLooper();
                DrmInitData drmInitData = this.aeo.adY;
                this.apA = bVar.jq();
            }
        }
        if (this.apA == this.apz && this.apB != null && a(this.apC.apn, format2, this.aeo)) {
            boolean z;
            this.apR = true;
            this.apS = 1;
            if (this.apD == 2 || (this.apD == 1 && this.aeo.width == format2.width && this.aeo.height == format2.height)) {
                z = true;
            } else {
                z = false;
            }
            this.apK = z;
        } else if (this.apU) {
            this.apT = 1;
        } else {
            jL();
            jK();
        }
    }

    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
    }

    public void jN() {
    }

    public boolean a(boolean z, Format format, Format format2) {
        return false;
    }

    public boolean it() {
        return this.apX;
    }

    public boolean is() {
        if (!(this.aeo == null || this.apY)) {
            if ((this.acl ? this.acm : this.acj.is()) || this.apP >= 0 || (this.apN != -9223372036854775807L && SystemClock.elapsedRealtime() < this.apN)) {
                return true;
            }
        }
        return false;
    }

    private boolean d(long j, long j2) {
        boolean z;
        if (this.apP < 0) {
            if (this.apI && this.apV) {
                try {
                    this.apP = this.apB.dequeueOutputBuffer(this.apy, 0);
                } catch (IllegalStateException e) {
                    jO();
                    if (this.apX) {
                        jL();
                    }
                    return false;
                }
            }
            this.apP = this.apB.dequeueOutputBuffer(this.apy, 0);
            if (this.apP >= 0) {
                if (this.apL) {
                    this.apL = false;
                    this.apB.releaseOutputBuffer(this.apP, false);
                    this.apP = -1;
                    return true;
                } else if ((this.apy.flags & 4) != 0) {
                    jO();
                    this.apP = -1;
                    return false;
                } else {
                    ByteBuffer byteBuffer = this.agD[this.apP];
                    if (byteBuffer != null) {
                        byteBuffer.position(this.apy.offset);
                        byteBuffer.limit(this.apy.offset + this.apy.size);
                    }
                    long j3 = this.apy.presentationTimeUs;
                    int size = this.apx.size();
                    for (int i = 0; i < size; i++) {
                        if (((Long) this.apx.get(i)).longValue() == j3) {
                            this.apx.remove(i);
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    this.apQ = z;
                }
            } else if (this.apP == -2) {
                MediaFormat outputFormat = this.apB.getOutputFormat();
                if (this.apD != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                    this.apL = true;
                } else {
                    if (this.apJ) {
                        outputFormat.setInteger("channel-count", 1);
                    }
                    onOutputFormatChanged(this.apB, outputFormat);
                }
                return true;
            } else if (this.apP == -3) {
                this.agD = this.apB.getOutputBuffers();
                return true;
            } else {
                if (this.apG && (this.apW || this.apT == 2)) {
                    jO();
                }
                return false;
            }
        }
        if (this.apI && this.apV) {
            try {
                z = a(j, j2, this.apB, this.agD[this.apP], this.apP, this.apy.flags, this.apy.presentationTimeUs, this.apQ);
            } catch (IllegalStateException e2) {
                jO();
                if (this.apX) {
                    jL();
                }
                return false;
            }
        }
        z = a(j, j2, this.apB, this.agD[this.apP], this.apP, this.apy.flags, this.apy.presentationTimeUs, this.apQ);
        if (!z) {
            return false;
        }
        long j4 = this.apy.presentationTimeUs;
        this.apP = -1;
        return true;
    }

    public void iV() {
    }

    private void jO() {
        if (this.apT == 2) {
            jL();
            jK();
            return;
        }
        this.apX = true;
        iV();
    }
}
