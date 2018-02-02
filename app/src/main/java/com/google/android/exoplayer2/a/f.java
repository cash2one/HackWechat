package com.google.android.exoplayer2.a;

import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.p;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.LinkedList;

public final class f {
    public static boolean afN = false;
    public static boolean afO = false;
    p acX;
    int aeR;
    b aeS;
    final c afP;
    final g afQ;
    private final l afR;
    final d[] afS;
    final f afT;
    final ConditionVariable afU = new ConditionVariable(true);
    private final long[] afV;
    final a afW;
    final LinkedList<g> afX;
    AudioTrack afY;
    AudioTrack afZ;
    private long agA;
    float agB;
    private d[] agC;
    private ByteBuffer[] agD;
    ByteBuffer agE;
    private ByteBuffer agF;
    private byte[] agG;
    private int agH;
    private int agI;
    boolean agJ;
    boolean agK;
    boolean agL;
    boolean agM;
    long agN;
    int aga;
    int agb;
    boolean agc;
    long agd;
    p age;
    private long agf;
    private long agg;
    private ByteBuffer agh;
    int agi;
    private int agj;
    private int agk;
    private long agl;
    private long agm;
    private boolean agn;
    private long ago;
    private Method agp;
    int agq;
    long agr;
    long ags;
    int agt;
    private long agu;
    private long agv;
    int agw;
    int agx;
    long agy;
    private long agz;
    int bufferSize;
    int encoding;
    int sampleRate;

    public static final class d extends Exception {
        public final int ahb;

        public d(int i, int i2, int i3, int i4) {
            super("AudioTrack init failed: " + i + ", Config(" + i2 + ", " + i3 + ", " + i4 + ")");
            this.ahb = i;
        }
    }

    public f(c cVar, d[] dVarArr, f fVar) {
        this.afP = cVar;
        this.afT = fVar;
        if (t.SDK_INT >= 18) {
            try {
                this.agp = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException e) {
            }
        }
        if (t.SDK_INT >= 19) {
            this.afW = new b();
        } else {
            this.afW = new a((byte) 0);
        }
        this.afQ = new g();
        this.afR = new l();
        this.afS = new d[(dVarArr.length + 3)];
        this.afS[0] = new j();
        this.afS[1] = this.afQ;
        System.arraycopy(dVarArr, 0, this.afS, 2, dVarArr.length);
        this.afS[dVarArr.length + 2] = this.afR;
        this.afV = new long[10];
        this.agB = 1.0f;
        this.agx = 0;
        this.aeS = b.aft;
        this.aeR = 0;
        this.acX = p.aev;
        this.agI = -1;
        this.agC = new d[0];
        this.agD = new ByteBuffer[0];
        this.afX = new LinkedList();
    }

    public final long ah(boolean z) {
        Object obj = (!isInitialized() || this.agx == 0) ? null : 1;
        if (obj == null) {
            return Long.MIN_VALUE;
        }
        long iP;
        if (this.afZ.getPlayState() == 3) {
            long iN = this.afW.iN();
            if (iN != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - this.agm >= 30000) {
                    this.afV[this.agj] = iN - nanoTime;
                    this.agj = (this.agj + 1) % 10;
                    if (this.agk < 10) {
                        this.agk++;
                    }
                    this.agm = nanoTime;
                    this.agl = 0;
                    for (int i = 0; i < this.agk; i++) {
                        this.agl += this.afV[i] / ((long) this.agk);
                    }
                }
                if (!iK() && nanoTime - this.ago >= 500000) {
                    this.agn = this.afW.iO();
                    if (this.agn) {
                        iP = this.afW.iP() / 1000;
                        long iQ = this.afW.iQ();
                        if (iP >= this.agz) {
                            String str;
                            if (Math.abs(iP - nanoTime) > 5000000) {
                                str = "Spurious audio timestamp (system clock mismatch): " + iQ + ", " + iP + ", " + nanoTime + ", " + iN + ", " + iH() + ", " + iI();
                                if (afO) {
                                    throw new e(str);
                                }
                                this.agn = false;
                            } else if (Math.abs(v(iQ) - iN) > 5000000) {
                                str = "Spurious audio timestamp (frame position mismatch): " + iQ + ", " + iP + ", " + nanoTime + ", " + iN + ", " + iH() + ", " + iI();
                                if (afO) {
                                    throw new e(str);
                                }
                            }
                        }
                        this.agn = false;
                    }
                    if (!(this.agp == null || this.agc)) {
                        try {
                            this.agA = (((long) ((Integer) this.agp.invoke(this.afZ, null)).intValue()) * 1000) - this.agd;
                            this.agA = Math.max(this.agA, 0);
                            if (this.agA > 5000000) {
                                new StringBuilder("Ignoring impossibly large audio latency: ").append(this.agA);
                                this.agA = 0;
                            }
                        } catch (Exception e) {
                            this.agp = null;
                        }
                    }
                    this.ago = nanoTime;
                }
            }
        }
        iP = System.nanoTime() / 1000;
        if (this.agn) {
            iP = v(w(iP - (this.afW.iP() / 1000)) + this.afW.iQ());
        } else {
            if (this.agk == 0) {
                iP = this.afW.iN();
            } else {
                iP += this.agl;
            }
            if (!z) {
                iP -= this.agA;
            }
        }
        return u(iP) + this.agy;
    }

    final void iC() {
        int i;
        ArrayList arrayList = new ArrayList();
        for (d dVar : this.afS) {
            if (dVar.isActive()) {
                arrayList.add(dVar);
            } else {
                dVar.flush();
            }
        }
        int size = arrayList.size();
        this.agC = (d[]) arrayList.toArray(new d[size]);
        this.agD = new ByteBuffer[size];
        for (i = 0; i < size; i++) {
            d dVar2 = this.agC[i];
            dVar2.flush();
            this.agD[i] = dVar2.iB();
        }
    }

    public final void play() {
        this.agK = true;
        if (isInitialized()) {
            this.agz = System.nanoTime() / 1000;
            this.afZ.play();
        }
    }

    final void t(long j) {
        int length = this.agC.length;
        int i = length;
        while (i >= 0) {
            ByteBuffer byteBuffer = i > 0 ? this.agD[i - 1] : this.agE != null ? this.agE : d.afA;
            if (i == length) {
                a(byteBuffer, j);
            } else {
                d dVar = this.agC[i];
                dVar.b(byteBuffer);
                ByteBuffer iB = dVar.iB();
                this.agD[i] = iB;
                if (iB.hasRemaining()) {
                    i++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i--;
            } else {
                return;
            }
        }
    }

    final boolean a(ByteBuffer byteBuffer, long j) {
        if (!byteBuffer.hasRemaining()) {
            return true;
        }
        boolean z;
        int remaining;
        int position;
        if (this.agF != null) {
            if (this.agF == byteBuffer) {
                z = true;
            } else {
                z = false;
            }
            a.am(z);
        } else {
            this.agF = byteBuffer;
            if (t.SDK_INT < 21) {
                remaining = byteBuffer.remaining();
                if (this.agG == null || this.agG.length < remaining) {
                    this.agG = new byte[remaining];
                }
                position = byteBuffer.position();
                byteBuffer.get(this.agG, 0, remaining);
                byteBuffer.position(position);
                this.agH = 0;
            }
        }
        position = byteBuffer.remaining();
        if (t.SDK_INT < 21) {
            remaining = this.bufferSize - ((int) (this.agu - (this.afW.iM() * ((long) this.agt))));
            if (remaining > 0) {
                remaining = this.afZ.write(this.agG, this.agH, Math.min(position, remaining));
                if (remaining > 0) {
                    this.agH += remaining;
                    byteBuffer.position(byteBuffer.position() + remaining);
                }
            } else {
                remaining = 0;
            }
        } else if (this.agL) {
            if (j != -9223372036854775807L) {
                z = true;
            } else {
                z = false;
            }
            a.an(z);
            AudioTrack audioTrack = this.afZ;
            if (this.agh == null) {
                this.agh = ByteBuffer.allocate(16);
                this.agh.order(ByteOrder.BIG_ENDIAN);
                this.agh.putInt(1431633921);
            }
            if (this.agi == 0) {
                this.agh.putInt(4, position);
                this.agh.putLong(8, 1000 * j);
                this.agh.position(0);
                this.agi = position;
            }
            int remaining2 = this.agh.remaining();
            if (remaining2 > 0) {
                remaining = audioTrack.write(this.agh, remaining2, 1);
                if (remaining < 0) {
                    this.agi = 0;
                } else if (remaining < remaining2) {
                    remaining = 0;
                }
            }
            remaining = audioTrack.write(byteBuffer, position, 1);
            if (remaining < 0) {
                this.agi = 0;
            } else {
                this.agi -= remaining;
            }
        } else {
            remaining = this.afZ.write(byteBuffer, position, 1);
        }
        this.agN = SystemClock.elapsedRealtime();
        if (remaining < 0) {
            throw new h(remaining);
        }
        if (!this.agc) {
            this.agu += (long) remaining;
        }
        if (remaining != position) {
            return false;
        }
        if (this.agc) {
            this.agv += (long) this.agw;
        }
        this.agF = null;
        return true;
    }

    final boolean iD() {
        boolean z;
        if (this.agI == -1) {
            this.agI = this.agc ? this.agC.length : 0;
            z = true;
        } else {
            z = false;
        }
        while (this.agI < this.agC.length) {
            d dVar = this.agC[this.agI];
            if (z) {
                dVar.iA();
            }
            t(-9223372036854775807L);
            if (!dVar.it()) {
                return false;
            }
            this.agI++;
            z = true;
        }
        if (this.agF != null) {
            a(this.agF, -9223372036854775807L);
            if (this.agF != null) {
                return false;
            }
        }
        this.agI = -1;
        return true;
    }

    public final boolean iE() {
        if (isInitialized()) {
            if (iI() > this.afW.iM()) {
                return true;
            }
            boolean z = iK() && this.afZ.getPlayState() == 2 && this.afZ.getPlaybackHeadPosition() == 0;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final p b(p pVar) {
        if (this.agc) {
            this.acX = p.aev;
            return this.acX;
        }
        l lVar = this.afR;
        lVar.aew = t.g(pVar.aew, 0.1f, 8.0f);
        float f = lVar.aew;
        l lVar2 = this.afR;
        float f2 = pVar.pitch;
        lVar2.pitch = t.g(f2, 0.1f, 8.0f);
        p pVar2 = new p(f, f2);
        Object obj = this.age != null ? this.age : !this.afX.isEmpty() ? ((g) this.afX.getLast()).acX : this.acX;
        if (!pVar2.equals(obj)) {
            if (isInitialized()) {
                this.age = pVar2;
            } else {
                this.acX = pVar2;
            }
        }
        return this.acX;
    }

    final void iF() {
        if (!isInitialized()) {
            return;
        }
        if (t.SDK_INT >= 21) {
            this.afZ.setVolume(this.agB);
            return;
        }
        AudioTrack audioTrack = this.afZ;
        float f = this.agB;
        audioTrack.setStereoVolume(f, f);
    }

    public final void reset() {
        if (isInitialized()) {
            this.agr = 0;
            this.ags = 0;
            this.agu = 0;
            this.agv = 0;
            this.agw = 0;
            if (this.age != null) {
                this.acX = this.age;
                this.age = null;
            } else if (!this.afX.isEmpty()) {
                this.acX = ((g) this.afX.getLast()).acX;
            }
            this.afX.clear();
            this.agf = 0;
            this.agg = 0;
            this.agE = null;
            this.agF = null;
            for (int i = 0; i < this.agC.length; i++) {
                d dVar = this.agC[i];
                dVar.flush();
                this.agD[i] = dVar.iB();
            }
            this.agJ = false;
            this.agI = -1;
            this.agh = null;
            this.agi = 0;
            this.agx = 0;
            this.agA = 0;
            iJ();
            if (this.afZ.getPlayState() == 3) {
                this.afZ.pause();
            }
            AudioTrack audioTrack = this.afZ;
            this.afZ = null;
            this.afW.a(null, false);
            this.afU.close();
            new 1(this, audioTrack).start();
        }
    }

    final void iG() {
        if (this.afY != null) {
            final AudioTrack audioTrack = this.afY;
            this.afY = null;
            new Thread(this) {
                final /* synthetic */ f agP;

                public final void run() {
                    audioTrack.release();
                }
            }.start();
        }
    }

    private long u(long j) {
        while (!this.afX.isEmpty() && j >= ((g) this.afX.getFirst()).adL) {
            g gVar = (g) this.afX.remove();
            this.acX = gVar.acX;
            this.agg = gVar.adL;
            this.agf = gVar.ahc - this.agy;
        }
        if (this.acX.aew == 1.0f) {
            return (this.agf + j) - this.agg;
        }
        if (!this.afX.isEmpty() || this.afR.ahR < 1024) {
            return this.agf + ((long) (((double) this.acX.aew) * ((double) (j - this.agg))));
        }
        return t.a(j - this.agg, this.afR.ahQ, this.afR.ahR) + this.agf;
    }

    final boolean isInitialized() {
        return this.afZ != null;
    }

    final long v(long j) {
        return (1000000 * j) / ((long) this.sampleRate);
    }

    final long w(long j) {
        return (((long) this.sampleRate) * j) / 1000000;
    }

    final long iH() {
        return this.agc ? this.ags : this.agr / ((long) this.agq);
    }

    final long iI() {
        return this.agc ? this.agv : this.agu / ((long) this.agt);
    }

    final void iJ() {
        this.agl = 0;
        this.agk = 0;
        this.agj = 0;
        this.agm = 0;
        this.agn = false;
        this.ago = 0;
    }

    final boolean iK() {
        return t.SDK_INT < 23 && (this.agb == 5 || this.agb == 6);
    }

    final AudioTrack iL() {
        AudioTrack audioTrack;
        if (t.SDK_INT >= 21) {
            AudioAttributes build;
            int i;
            if (this.agL) {
                build = new Builder().setContentType(3).setFlags(16).setUsage(1).build();
            } else {
                b bVar = this.aeS;
                if (bVar.afw == null) {
                    bVar.afw = new Builder().setContentType(bVar.afu).setFlags(bVar.flags).setUsage(bVar.afv).build();
                }
                build = bVar.afw;
            }
            AudioFormat build2 = new AudioFormat.Builder().setChannelMask(this.aga).setEncoding(this.agb).setSampleRate(this.sampleRate).build();
            if (this.aeR != 0) {
                i = this.aeR;
            } else {
                i = 0;
            }
            audioTrack = new AudioTrack(build, build2, this.bufferSize, 1, i);
        } else {
            int cZ = t.cZ(this.aeS.afv);
            if (this.aeR == 0) {
                audioTrack = new AudioTrack(cZ, this.sampleRate, this.aga, this.agb, this.bufferSize, 1);
            } else {
                audioTrack = new AudioTrack(cZ, this.sampleRate, this.aga, this.agb, this.bufferSize, 1, this.aeR);
            }
        }
        int state = audioTrack.getState();
        if (state == 1) {
            return audioTrack;
        }
        try {
            audioTrack.release();
        } catch (Exception e) {
        }
        throw new d(state, this.sampleRate, this.aga, this.bufferSize);
    }

    static int M(String str) {
        int i = -1;
        switch (str.hashCode()) {
            case -1095064472:
                if (str.equals("audio/vnd.dts")) {
                    i = 2;
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    i = 0;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    i = 1;
                    break;
                }
                break;
            case 1505942594:
                if (str.equals("audio/vnd.dts.hd")) {
                    i = 3;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                return 5;
            case 1:
                return 6;
            case 2:
                return 7;
            case 3:
                return 8;
            default:
                return 0;
        }
    }
}
