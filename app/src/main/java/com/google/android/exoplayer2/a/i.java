package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCodecInfo.AudioCapabilities;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.a.e$a.1;
import com.google.android.exoplayer2.a.e$a.2;
import com.google.android.exoplayer2.a.e$a.3;
import com.google.android.exoplayer2.drm.d;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.e.a;
import com.google.android.exoplayer2.e.b;
import com.google.android.exoplayer2.e.c;
import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.p;
import java.nio.ByteBuffer;
import java.util.Arrays;

@TargetApi(16)
public final class i extends b implements f {
    private int aef;
    private int aeg;
    private final e$a ahl;
    private final f ahm;
    private boolean ahn;
    private boolean aho;
    private MediaFormat ahp;
    private long ahq;
    private boolean ahr;

    public i(c cVar, com.google.android.exoplayer2.drm.b<d> bVar, Handler handler, e eVar, c cVar2, d... dVarArr) {
        super(1, cVar, bVar, true);
        this.ahm = new f(cVar2, dVarArr, new a(this, (byte) 0));
        this.ahl = new e$a(handler, eVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final int a(c cVar, Format format) {
        boolean z = false;
        String str = format.adV;
        if (!g.Z(str)) {
            return 0;
        }
        int i;
        if (t.SDK_INT >= 21) {
            i = 32;
        } else {
            i = 0;
        }
        if (N(str) && cVar.jP() != null) {
            return (i | 8) | 4;
        }
        a b = cVar.b(str, false);
        if (b == null) {
            return 1;
        }
        if (t.SDK_INT >= 21) {
            int i2;
            boolean z2;
            if (format.sampleRate != -1) {
                i2 = format.sampleRate;
                if (b.apq == null) {
                    b.P("sampleRate.caps");
                    z2 = false;
                } else {
                    AudioCapabilities audioCapabilities = b.apq.getAudioCapabilities();
                    if (audioCapabilities == null) {
                        b.P("sampleRate.aCaps");
                        z2 = false;
                    } else if (audioCapabilities.isSampleRateSupported(i2)) {
                        z2 = true;
                    } else {
                        b.P("sampleRate.support, " + i2);
                        z2 = false;
                    }
                }
            }
            if (format.aef != -1) {
                int i3 = format.aef;
                if (b.apq == null) {
                    b.P("channelCount.caps");
                    z2 = false;
                } else {
                    AudioCapabilities audioCapabilities2 = b.apq.getAudioCapabilities();
                    if (audioCapabilities2 == null) {
                        b.P("channelCount.aCaps");
                        z2 = false;
                    } else {
                        String str2 = b.name;
                        String str3 = b.mimeType;
                        int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
                        if (maxInputChannelCount > 1 || (t.SDK_INT >= 26 && maxInputChannelCount > 0)) {
                            i2 = maxInputChannelCount;
                        } else if ("audio/mpeg".equals(str3) || "audio/3gpp".equals(str3) || "audio/amr-wb".equals(str3) || "audio/mp4a-latm".equals(str3) || "audio/vorbis".equals(str3) || "audio/opus".equals(str3) || "audio/raw".equals(str3) || "audio/flac".equals(str3) || "audio/g711-alaw".equals(str3) || "audio/g711-mlaw".equals(str3) || "audio/gsm".equals(str3)) {
                            i2 = maxInputChannelCount;
                        } else {
                            i2 = "audio/ac3".equals(str3) ? 6 : "audio/eac3".equals(str3) ? 16 : 30;
                            new StringBuilder("AssumedMaxChannelAdjustment: ").append(str2).append(", [").append(maxInputChannelCount).append(" to ").append(i2).append("]");
                        }
                        if (i2 < i3) {
                            b.P("channelCount.support, " + i3);
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                    }
                }
            }
        }
        z = true;
        return (z ? 4 : 3) | (i | 8);
    }

    protected final a a(c cVar, Format format, boolean z) {
        if (N(format.adV)) {
            a jP = cVar.jP();
            if (jP != null) {
                this.ahn = true;
                return jP;
            }
        }
        this.ahn = false;
        return super.a(cVar, format, z);
    }

    private boolean N(String str) {
        f fVar = this.ahm;
        if (fVar.afP != null) {
            if (Arrays.binarySearch(fVar.afP.afy, f.M(str)) >= 0) {
                return true;
            }
        }
        return false;
    }

    protected final void a(a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        boolean z = t.SDK_INT < 24 && "OMX.SEC.aac.dec".equals(aVar.name) && "samsung".equals(t.MANUFACTURER) && (t.DEVICE.startsWith("zeroflte") || t.DEVICE.startsWith("herolte") || t.DEVICE.startsWith("heroqlte"));
        this.aho = z;
        if (this.ahn) {
            this.ahp = format.ip();
            this.ahp.setString("mime", "audio/raw");
            mediaCodec.configure(this.ahp, null, mediaCrypto, 0);
            this.ahp.setString("mime", format.adV);
            return;
        }
        mediaCodec.configure(format.ip(), null, mediaCrypto, 0);
        this.ahp = null;
    }

    public final f hO() {
        return this;
    }

    protected final void b(String str, long j, long j2) {
        e$a com_google_android_exoplayer2_a_e_a = this.ahl;
        if (com_google_android_exoplayer2_a_e_a.afB != null) {
            com_google_android_exoplayer2_a_e_a.handler.post(new 2(com_google_android_exoplayer2_a_e_a, str, j, j2));
        }
    }

    protected final void e(Format format) {
        super.e(format);
        e$a com_google_android_exoplayer2_a_e_a = this.ahl;
        if (com_google_android_exoplayer2_a_e_a.afB != null) {
            com_google_android_exoplayer2_a_e_a.handler.post(new 3(com_google_android_exoplayer2_a_e_a, format));
        }
        this.aeg = "audio/raw".equals(format.adV) ? format.aeg : 2;
        this.aef = format.aef;
    }

    protected final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i;
        int[] iArr;
        Object obj = this.ahp != null ? 1 : null;
        String string = obj != null ? this.ahp.getString("mime") : "audio/raw";
        if (obj != null) {
            mediaFormat = this.ahp;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.aho && integer == 6 && this.aef < 6) {
            int[] iArr2 = new int[this.aef];
            for (i = 0; i < this.aef; i++) {
                iArr2[i] = i;
            }
            iArr = iArr2;
        } else {
            iArr = null;
        }
        try {
            f fVar = this.ahm;
            int i2 = this.aeg;
            boolean z = !"audio/raw".equals(string);
            int M = z ? f.M(string) : i2;
            if (z) {
                i2 = integer;
                i = M;
                M = 0;
            } else {
                fVar.agq = t.au(i2, integer);
                fVar.afQ.ahe = iArr;
                d[] dVarArr = fVar.afS;
                int length = dVarArr.length;
                i2 = 0;
                i = integer;
                integer = M;
                M = 0;
                while (i2 < length) {
                    d dVar = dVarArr[i2];
                    int r = dVar.r(integer2, i, integer) | M;
                    if (dVar.isActive()) {
                        i = dVar.iy();
                        integer = dVar.iz();
                    }
                    i2++;
                    M = r;
                }
                if (M != 0) {
                    fVar.iC();
                }
                i2 = i;
                i = integer;
            }
            switch (i2) {
                case 1:
                    integer = 4;
                    break;
                case 2:
                    integer = 12;
                    break;
                case 3:
                    integer = 28;
                    break;
                case 4:
                    integer = com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX;
                    break;
                case 5:
                    integer = 220;
                    break;
                case 6:
                    integer = 252;
                    break;
                case 7:
                    integer = 1276;
                    break;
                case 8:
                    integer = com.google.android.exoplayer2.b.CHANNEL_OUT_7POINT1_SURROUND;
                    break;
                default:
                    throw new f.c("Unsupported channel count: " + i2);
            }
            if (t.SDK_INT <= 23 && "foster".equals(t.DEVICE) && "NVIDIA".equals(t.MANUFACTURER)) {
                switch (i2) {
                    case 3:
                    case 5:
                        integer = 252;
                        break;
                    case 7:
                        integer = com.google.android.exoplayer2.b.CHANNEL_OUT_7POINT1_SURROUND;
                        break;
                }
            }
            if (t.SDK_INT <= 25 && "fugu".equals(t.DEVICE) && z && i2 == 1) {
                integer = 12;
            }
            if (M != 0 || !fVar.isInitialized() || fVar.encoding != i || fVar.sampleRate != integer2 || fVar.aga != integer) {
                f fVar2;
                fVar.reset();
                fVar.encoding = i;
                fVar.agc = z;
                fVar.sampleRate = integer2;
                fVar.aga = integer;
                if (!z) {
                    i = 2;
                }
                fVar.agb = i;
                fVar.agt = t.au(2, i2);
                if (!z) {
                    integer = AudioTrack.getMinBufferSize(integer2, integer, fVar.agb);
                    com.google.android.exoplayer2.i.a.an(integer != -2);
                    M = integer * 4;
                    i = ((int) fVar.w(250000)) * fVar.agt;
                    integer = (int) Math.max((long) integer, fVar.w(750000) * ((long) fVar.agt));
                    if (M < i) {
                        fVar2 = fVar;
                    } else if (M > integer) {
                        i = integer;
                        fVar2 = fVar;
                    } else {
                        i = M;
                        fVar2 = fVar;
                    }
                } else if (fVar.agb == 5 || fVar.agb == 6) {
                    i = 20480;
                    fVar2 = fVar;
                } else {
                    i = 49152;
                    fVar2 = fVar;
                }
                fVar2.bufferSize = i;
                fVar.agd = z ? -9223372036854775807L : fVar.v((long) (fVar.bufferSize / fVar.agt));
                fVar.b(fVar.acX);
            }
        } catch (Throwable e) {
            throw new f.c(e);
        } catch (Exception e2) {
            throw e.a(e2, this.index);
        }
    }

    protected static void iR() {
    }

    protected static void iS() {
    }

    protected static void iT() {
    }

    protected final void ac(boolean z) {
        boolean z2 = false;
        super.ac(z);
        e$a com_google_android_exoplayer2_a_e_a = this.ahl;
        com.google.android.exoplayer2.b.d dVar = this.aqa;
        if (com_google_android_exoplayer2_a_e_a.afB != null) {
            com_google_android_exoplayer2_a_e_a.handler.post(new 1(com_google_android_exoplayer2_a_e_a, dVar));
        }
        int i = this.aci.aez;
        if (i != 0) {
            f fVar = this.ahm;
            if (t.SDK_INT >= 21) {
                z2 = true;
            }
            com.google.android.exoplayer2.i.a.an(z2);
            if (!fVar.agL || fVar.aeR != i) {
                fVar.agL = true;
                fVar.aeR = i;
                fVar.reset();
                return;
            }
            return;
        }
        f fVar2 = this.ahm;
        if (fVar2.agL) {
            fVar2.agL = false;
            fVar2.aeR = 0;
            fVar2.reset();
        }
    }

    protected final void a(long j, boolean z) {
        super.a(j, z);
        this.ahm.reset();
        this.ahq = j;
        this.ahr = true;
    }

    protected final void hV() {
        super.hV();
        this.ahm.play();
    }

    protected final void onStopped() {
        f fVar = this.ahm;
        fVar.agK = false;
        if (fVar.isInitialized()) {
            fVar.iJ();
            fVar.afW.pause();
        }
        super.onStopped();
    }

    protected final void hW() {
        try {
            f fVar = this.ahm;
            fVar.reset();
            fVar.iG();
            for (d reset : fVar.afS) {
                reset.reset();
            }
            fVar.aeR = 0;
            fVar.agK = false;
            try {
                super.hW();
            } finally {
                this.aqa.jc();
                this.ahl.e(this.aqa);
            }
        } catch (Throwable th) {
            super.hW();
        } finally {
            this.aqa.jc();
            this.ahl.e(this.aqa);
        }
    }

    public final boolean it() {
        if (super.it()) {
            f fVar = this.ahm;
            boolean z = !fVar.isInitialized() || (fVar.agJ && !fVar.iE());
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean is() {
        return this.ahm.iE() || super.is();
    }

    public final long iN() {
        long ah = this.ahm.ah(it());
        if (ah != Long.MIN_VALUE) {
            if (!this.ahr) {
                ah = Math.max(this.ahq, ah);
            }
            this.ahq = ah;
            this.ahr = false;
        }
        return this.ahq;
    }

    public final p b(p pVar) {
        return this.ahm.b(pVar);
    }

    public final p iU() {
        return this.ahm.acX;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        Exception e;
        if (this.ahn && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            r2 = this.aqa;
            r2.aib++;
            f fVar = this.ahm;
            if (fVar.agx == 1) {
                fVar.agx = 2;
            }
            return true;
        } else {
            try {
                Object obj;
                f fVar2 = this.ahm;
                boolean z2 = fVar2.agE == null || byteBuffer == fVar2.agE;
                com.google.android.exoplayer2.i.a.am(z2);
                if (!fVar2.isInitialized()) {
                    fVar2.afU.block();
                    fVar2.afZ = fVar2.iL();
                    int audioSessionId = fVar2.afZ.getAudioSessionId();
                    if (f.afN && t.SDK_INT < 21) {
                        if (!(fVar2.afY == null || audioSessionId == fVar2.afY.getAudioSessionId())) {
                            fVar2.iG();
                        }
                        if (fVar2.afY == null) {
                            fVar2.afY = new AudioTrack(3, 4000, 4, 2, 2, 0, audioSessionId);
                        }
                    }
                    if (fVar2.aeR != audioSessionId) {
                        fVar2.aeR = audioSessionId;
                        fVar2.afT.bW(audioSessionId);
                    }
                    fVar2.afW.a(fVar2.afZ, fVar2.iK());
                    fVar2.iF();
                    fVar2.agM = false;
                    if (fVar2.agK) {
                        fVar2.play();
                    }
                }
                if (fVar2.iK()) {
                    if (fVar2.afZ.getPlayState() == 2) {
                        fVar2.agM = false;
                    } else if (fVar2.afZ.getPlayState() == 1) {
                    }
                    obj = null;
                    if (obj == null) {
                        return false;
                    }
                    mediaCodec.releaseOutputBuffer(i, false);
                    r2 = this.aqa;
                    r2.aia++;
                    return true;
                }
                z2 = fVar2.agM;
                fVar2.agM = fVar2.iE();
                if (!(!z2 || fVar2.agM || fVar2.afZ.getPlayState() == 1)) {
                    fVar2.afT.d(fVar2.bufferSize, com.google.android.exoplayer2.b.j(fVar2.agd), SystemClock.elapsedRealtime() - fVar2.agN);
                }
                if (fVar2.agE == null) {
                    if (byteBuffer.hasRemaining()) {
                        if (fVar2.agc && fVar2.agw == 0) {
                            int i3 = fVar2.agb;
                            if (i3 == 7 || i3 == 8) {
                                i3 = h.c(byteBuffer);
                            } else if (i3 == 5) {
                                i3 = a.ix();
                            } else if (i3 == 6) {
                                i3 = a.a(byteBuffer);
                            } else {
                                throw new IllegalStateException("Unexpected audio encoding: " + i3);
                            }
                            fVar2.agw = i3;
                        }
                        if (fVar2.age != null) {
                            if (fVar2.iD()) {
                                fVar2.afX.add(new f$g(fVar2.age, Math.max(0, j3), fVar2.v(fVar2.iI())));
                                fVar2.age = null;
                                fVar2.iC();
                            }
                            obj = null;
                            if (obj == null) {
                                return false;
                            }
                            mediaCodec.releaseOutputBuffer(i, false);
                            r2 = this.aqa;
                            r2.aia++;
                            return true;
                        }
                        if (fVar2.agx == 0) {
                            fVar2.agy = Math.max(0, j3);
                            fVar2.agx = 1;
                        } else {
                            long v = fVar2.agy + fVar2.v(fVar2.iH());
                            if (fVar2.agx == 1 && Math.abs(v - j3) > 200000) {
                                new StringBuilder("Discontinuity detected [expected ").append(v).append(", got ").append(j3).append("]");
                                fVar2.agx = 2;
                            }
                            if (fVar2.agx == 2) {
                                fVar2.agy = (j3 - v) + fVar2.agy;
                                fVar2.agx = 1;
                                fVar2.afT.ir();
                            }
                        }
                        if (fVar2.agc) {
                            fVar2.ags += (long) fVar2.agw;
                        } else {
                            fVar2.agr += (long) byteBuffer.remaining();
                        }
                        fVar2.agE = byteBuffer;
                    } else {
                        obj = 1;
                        if (obj == null) {
                            return false;
                        }
                        mediaCodec.releaseOutputBuffer(i, false);
                        r2 = this.aqa;
                        r2.aia++;
                        return true;
                    }
                }
                if (fVar2.agc) {
                    fVar2.a(fVar2.agE, j3);
                } else {
                    fVar2.t(j3);
                }
                if (!fVar2.agE.hasRemaining()) {
                    fVar2.agE = null;
                    obj = 1;
                    if (obj == null) {
                        return false;
                    }
                    mediaCodec.releaseOutputBuffer(i, false);
                    r2 = this.aqa;
                    r2.aia++;
                    return true;
                }
                obj = null;
                if (obj == null) {
                    return false;
                }
                mediaCodec.releaseOutputBuffer(i, false);
                r2 = this.aqa;
                r2.aia++;
                return true;
            } catch (f.d e2) {
                e = e2;
                throw e.a(e, this.index);
            } catch (f$h e3) {
                e = e3;
                throw e.a(e, this.index);
            }
        }
    }

    protected final void iV() {
        try {
            f fVar = this.ahm;
            if (!fVar.agJ && fVar.isInitialized() && fVar.iD()) {
                fVar.afW.x(fVar.iI());
                fVar.agi = 0;
                fVar.agJ = true;
            }
        } catch (Exception e) {
            throw e.a(e, this.index);
        }
    }

    public final void c(int i, Object obj) {
        f fVar;
        switch (i) {
            case 2:
                fVar = this.ahm;
                float floatValue = ((Float) obj).floatValue();
                if (fVar.agB != floatValue) {
                    fVar.agB = floatValue;
                    fVar.iF();
                    return;
                }
                return;
            case 3:
                b bVar = (b) obj;
                fVar = this.ahm;
                if (!fVar.aeS.equals(bVar)) {
                    fVar.aeS = bVar;
                    if (!fVar.agL) {
                        fVar.reset();
                        fVar.aeR = 0;
                        return;
                    }
                    return;
                }
                return;
            default:
                super.c(i, obj);
                return;
        }
    }
}
