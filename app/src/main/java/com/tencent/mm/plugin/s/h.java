package com.tencent.mm.plugin.s;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.Pair;
import com.tencent.mm.plugin.a.g;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.nio.ByteBuffer;

public abstract class h {
    private ByteBuffer[] agD;
    private ByteBuffer[] apM;
    private int apO;
    private int apP;
    private BufferInfo apy = new BufferInfo();
    long aqA;
    private volatile Object lock = new Object();
    protected g opD;
    protected af opE;
    private boolean opF = false;
    b opG = null;
    protected long opH = 0;
    MediaFormat opI;
    private String opJ;
    int opK;
    MediaExtractor opL;
    private f opM;
    protected MediaCodec opN;
    private boolean opO = false;
    private boolean opP = false;
    protected String path;
    protected int state;

    abstract boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, BufferInfo bufferInfo);

    abstract boolean a(MediaCodec mediaCodec);

    abstract String aZy();

    public h(g gVar, af afVar) {
        this.opD = gVar;
        this.opE = afVar;
        this.state = 0;
        this.apO = -1;
        this.apP = -1;
    }

    public final void setPath(String str) {
        this.path = str;
    }

    private void aZG() {
        if (this.opG != null) {
            this.opH = this.opG.aZz() * 1000;
        }
    }

    public final void aZH() {
        x.i("MicroMsg.TrackDataSource", "%s flush codec", new Object[]{asP()});
        this.apP = -1;
        this.apO = -1;
        try {
            if (this.opN != null) {
                this.opN.flush();
            }
        } catch (Exception e) {
        }
    }

    public void release() {
        x.i("MicroMsg.TrackDataSource", "%s release", new Object[]{asP()});
        if (this.opL != null) {
            this.opL.release();
            this.opL = null;
        }
        if (this.opN != null) {
            this.opN.release();
            this.opN = null;
        }
        if (this.opM != null) {
            f fVar = this.opM;
            if (fVar.opm != null) {
                try {
                    fVar.opm.close();
                } catch (IOException e) {
                }
            }
            fVar.ifb.clear();
            fVar.ifb = null;
            fVar.ifc.clear();
            fVar.ifc = null;
            fVar.opn = null;
        }
        x.i("MicroMsg.TrackDataSource", "%s finish release", new Object[]{asP()});
    }

    protected final void kL() {
        if (this.opN != null) {
            x.i("MicroMsg.TrackDataSource", "%s release decoder", new Object[]{asP()});
            aZH();
            this.agD = null;
            this.apM = null;
            long Wq = bh.Wq();
            synchronized (this.lock) {
                x.i("MicroMsg.TrackDataSource", "%s wait lock cost[%d]", new Object[]{asP(), Long.valueOf(bh.bA(Wq))});
                try {
                    this.opN.stop();
                    this.opN.release();
                    this.opN = null;
                } catch (Exception e) {
                    this.opN.release();
                    this.opN = null;
                } catch (Throwable th) {
                    this.opN = null;
                }
            }
            x.i("MicroMsg.TrackDataSource", "%s finish release decoder [%d]", new Object[]{asP(), Long.valueOf(bh.bA(Wq))});
        }
    }

    protected final boolean aZI() {
        try {
            x.i("MicroMsg.TrackDataSource", "%s start to prepare decoder mime[%s]", new Object[]{asP(), this.opJ});
            this.opN = MediaCodec.createDecoderByType(this.opJ);
            a(this.opN);
            this.opN.start();
            this.apM = this.opN.getInputBuffers();
            this.agD = this.opN.getOutputBuffers();
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TrackDataSource", e, "%s prepare decoder init decoder error ", new Object[]{asP()});
            this.opD.Fe(aZy());
            return false;
        }
    }

    public final void start() {
        x.i("MicroMsg.TrackDataSource", "%s start to play", new Object[]{asP()});
        setState(3);
        onStart();
    }

    public final void pause() {
        x.i("MicroMsg.TrackDataSource", "%s start to pause", new Object[]{asP()});
        setState(4);
        onPause();
    }

    public final long sC(int i) {
        x.i("MicroMsg.TrackDataSource", "%s start to seek to ms[%d] isFeedEnd[%b]", new Object[]{asP(), Integer.valueOf(i), Boolean.valueOf(this.opF)});
        aZH();
        this.opF = false;
        if (this.opM != null) {
            try {
                f fVar = this.opM;
                long j = (long) (i * 1000);
                int i2 = 0;
                while (i2 < fVar.ifc.size()) {
                    Pair pair = (Pair) fVar.ifc.get(i2);
                    if (j < ((Long) pair.second).longValue()) {
                        break;
                    } else if (j == ((Long) pair.second).longValue()) {
                        fVar.opo = ((Integer) pair.first).intValue();
                        fVar.opn = (g) fVar.ifb.get(fVar.opo);
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == 0 || i2 == fVar.ifc.size() - 1) {
                    fVar.opo = ((Integer) ((Pair) fVar.ifc.get(i2)).first).intValue();
                    fVar.opn = (g) fVar.ifb.get(fVar.opo);
                    if (this.opM.opn.ife < 0) {
                        w(((long) i) * 1000, -1);
                    }
                    if (this.opM.opn.ife < 0) {
                        w(0, -1);
                        this.opD.aZF();
                    }
                    x.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d]", new Object[]{asP(), Long.valueOf(this.opM.opn.ife)});
                    return this.opM.opn.ife / 1000;
                }
                fVar.opo = ((Integer) ((Pair) fVar.ifc.get(i2 - 1)).first).intValue();
                fVar.opn = (g) fVar.ifb.get(fVar.opo);
                if (this.opM.opn.ife < 0) {
                    w(((long) i) * 1000, -1);
                }
                if (this.opM.opn.ife < 0) {
                    w(0, -1);
                    this.opD.aZF();
                }
                x.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d]", new Object[]{asP(), Long.valueOf(this.opM.opn.ife)});
                return this.opM.opn.ife / 1000;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TrackDataSource", e, "%s extractor seek exception %s", new Object[]{asP(), e.toString()});
                return 0;
            }
        }
        try {
            this.opL.seekTo((long) (i * 1000), 0);
            if (this.opL.getSampleTime() < 0) {
                w(((long) i) * 1000, -1);
            }
            if (this.opL.getSampleTime() < 0) {
                w(0, -1);
                this.opD.aZF();
            }
            x.i("MicroMsg.TrackDataSource", "%s finish to seek extractor [%d, %d]", new Object[]{asP(), Long.valueOf(this.opL.getSampleTime()), Long.valueOf(this.opL.getCachedDuration())});
            return this.opL.getSampleTime() / 1000;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.TrackDataSource", e2, "%s extractor seek exception %s", new Object[]{asP(), e2.toString()});
            return 0;
        }
    }

    public final boolean aZJ() {
        x.i("MicroMsg.TrackDataSource", "%s start to prepare path %s", new Object[]{asP(), this.path});
        long Wq = bh.Wq();
        long j = 0;
        try {
            x.i("MicroMsg.TrackDataSource", "%s start to init extractor", new Object[]{asP()});
            this.opL = new MediaExtractor();
            this.opL.setDataSource(this.path);
            int trackCount = this.opL.getTrackCount();
            this.opK = -1;
            for (int i = 0; i < trackCount; i++) {
                MediaFormat trackFormat = this.opL.getTrackFormat(i);
                String string = trackFormat.getString("mime");
                if (string != null && string.contains(aZy())) {
                    b(trackFormat, string, i);
                    break;
                }
            }
            if (this.opK < 0) {
                x.w("MicroMsg.TrackDataSource", "%s prepare track but can not find track index.[%d, %d]", new Object[]{asP(), Integer.valueOf(trackCount), Integer.valueOf(this.opK)});
                this.opD.Fd("can not find ");
                return false;
            }
            this.opL.selectTrack(this.opK);
            this.opM = null;
            long Wq2 = bh.Wq();
            try {
                x.i("MicroMsg.TrackDataSource", "%s start to init decoder mime[%s] state[%d]", new Object[]{asP(), this.opJ, Integer.valueOf(this.state)});
                if (!d.sy(this.state)) {
                    synchronized (this.lock) {
                        this.opN = MediaCodec.createDecoderByType(this.opJ);
                        a(this.opN);
                        this.opN.start();
                        this.apM = this.opN.getInputBuffers();
                        this.agD = this.opN.getOutputBuffers();
                    }
                    j = bh.Wq();
                }
                setState(1);
                x.i("MicroMsg.TrackDataSource", "%s finish to prepare cost[%d %d %d]", new Object[]{asP(), Long.valueOf(bh.bA(Wq)), Long.valueOf(Wq2 - Wq), Long.valueOf(j - Wq)});
                return true;
            } catch (Exception e) {
                x.e("MicroMsg.TrackDataSource", "%s prepare init decoder error %s", new Object[]{asP(), e.toString()});
                this.opD.Fe(aZy());
                return false;
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.TrackDataSource", e2, "%s prepare init extractor error", new Object[]{asP()});
            this.opD.Fd(e2.toString());
            return false;
        } catch (Throwable e22) {
            x.e("MicroMsg.TrackDataSource", "%s prepare init extractor error %s", new Object[]{asP(), e22.toString()});
            this.opD.Fd(e22.toString());
            return false;
        }
    }

    protected final int v(long j, long j2) {
        g gVar;
        String aZy;
        x.d("MicroMsg.TrackDataSource", "%s start to do some work time[%d %d] state %d", new Object[]{asP(), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(this.state)});
        if (this.opN != null) {
            do {
                try {
                    if (d(j, j2)) {
                    }
                } catch (Throwable e) {
                    if (this.opO) {
                        x.e("MicroMsg.TrackDataSource", "%s do some work drain output buffer error %s", new Object[]{asP(), e.toString()});
                    } else {
                        this.opO = true;
                        x.printErrStackTrace("MicroMsg.TrackDataSource", e, "%s do some work drain output buffer error", new Object[]{asP()});
                    }
                    if (!d.sy(this.state)) {
                        aZH();
                    }
                    gVar = this.opD;
                    aZy = aZy();
                    if (!gVar.opC && gVar.opx) {
                        com.tencent.mm.plugin.report.service.g.pQN.a(354, 158, 1, false);
                        com.tencent.mm.plugin.report.service.g.pQN.h(13836, new Object[]{Integer.valueOf(506), Long.valueOf(bh.Wo()), aZy});
                        gVar.opC = true;
                    }
                }
                break;
            } while (!d.sy(this.state));
            try {
                x.d("MicroMsg.TrackDataSource", "%s start to feed input buffer index %d [%d, %b]", new Object[]{asP(), Integer.valueOf(this.apO), Integer.valueOf(this.state), Boolean.valueOf(this.opF)});
                if (d.sy(this.state) || this.opF) {
                    x.i("MicroMsg.TrackDataSource", "%s feed input buffer is end.", new Object[]{asP()});
                } else {
                    if (this.apO < 0) {
                        this.apO = this.opN.dequeueInputBuffer(0);
                        if (this.apO < 0) {
                            x.d("MicroMsg.TrackDataSource", "%s can not dequeue effect input buffer", new Object[]{asP()});
                        }
                    }
                    ByteBuffer byteBuffer = this.apM[this.apO];
                    int w;
                    long j3;
                    int i;
                    if (this.opM != null) {
                        w = this.opM.w(byteBuffer);
                        j3 = this.opM.opn.ife;
                        i = this.opM.opn.iff;
                        x.d("MicroMsg.TrackDataSource", "%s read data index[%d, %d] sample info[%d, %d]", new Object[]{asP(), Integer.valueOf(this.apO), Integer.valueOf(w), Long.valueOf(j3), Integer.valueOf(i)});
                        if (w <= 0) {
                            this.opN.queueInputBuffer(this.apO, 0, 0, 0, 4);
                            this.opF = true;
                        } else {
                            this.opN.queueInputBuffer(this.apO, 0, w, j3, 0);
                            this.apO = -1;
                            f fVar = this.opM;
                            fVar.opo++;
                            if (fVar.opo < fVar.opp) {
                                fVar.opn = (g) fVar.ifb.get(fVar.opo);
                                x.d("MicroMsg.Mp4Extractor", "curr sample [%s]", new Object[]{fVar.opn});
                            }
                        }
                    } else if (this.opD.opA) {
                        this.opN.queueInputBuffer(this.apO, 0, 0, this.aqA * 1000, 4);
                        this.opF = true;
                        this.opD.opA = false;
                    } else {
                        w = this.opL.readSampleData(byteBuffer, 0);
                        j3 = this.opL.getSampleTime();
                        x.d("MicroMsg.TrackDataSource", "%s read data index[%d, %d] sample info[%d, %d]", new Object[]{asP(), Integer.valueOf(this.apO), Integer.valueOf(w), Long.valueOf(j3), Integer.valueOf(this.opL.getSampleFlags())});
                        A(i, j3);
                        if (w <= 0) {
                            this.opN.queueInputBuffer(this.apO, 0, 0, this.aqA * 1000, 4);
                            this.opF = true;
                        } else {
                            this.opN.queueInputBuffer(this.apO, 0, w, j3, 0);
                            this.apO = -1;
                            this.opL.advance();
                            long sampleTime = this.opL.getSampleTime();
                            if (this.opD.opz) {
                                if (this.opH == 0) {
                                    if (w(j3, sampleTime)) {
                                        x.w("MicroMsg.TrackDataSource", "%s feed input buffer next[%d] onlineCacheMs[%d]", new Object[]{asP(), Long.valueOf(sampleTime), Long.valueOf(this.opH)});
                                        if (Math.abs(this.opL.getSampleTime() - j3) >= 3000000) {
                                            x.w("MicroMsg.TrackDataSource", "%s reset extractor finish but seek time is not right[%d, %d]", new Object[]{asP(), Long.valueOf(this.opL.getSampleTime()), Long.valueOf(j3)});
                                            this.opE.obtainMessage(5, -2, -2).sendToTarget();
                                        }
                                        aZG();
                                    }
                                } else if (sampleTime < 0 || (sampleTime / 1000) + 1200 > this.opH) {
                                    x.w("MicroMsg.TrackDataSource", "%s feed input buffer next[%d] onlineCacheMs[%d]", new Object[]{asP(), Long.valueOf(sampleTime), Long.valueOf(this.opH)});
                                    if (w(j3, -1)) {
                                        this.opE.obtainMessage(5, -3, -3).sendToTarget();
                                    }
                                    aZG();
                                }
                            } else if (w(j3, sampleTime)) {
                                x.w("MicroMsg.TrackDataSource", "%s feed input buffer isOnlineVideo[%b] next[%d] onlineCacheMs[%d]", new Object[]{asP(), Boolean.valueOf(this.opD.opz), Long.valueOf(sampleTime), Long.valueOf(this.opH)});
                                if (Math.abs(this.opL.getSampleTime() - j3) >= 1000000) {
                                    x.w("MicroMsg.TrackDataSource", "%s reset extractor finish but seek time is not right[%d, %d]", new Object[]{asP(), Long.valueOf(this.opL.getSampleTime()), Long.valueOf(j3)});
                                    this.opD.opA = true;
                                }
                            }
                            x.d("MicroMsg.TrackDataSource", "%s finish to feed input buffer [%d, %d]", new Object[]{asP(), Long.valueOf(j3), Long.valueOf(sampleTime)});
                        }
                    }
                }
            } catch (Throwable e2) {
                if (this.opP) {
                    x.e("MicroMsg.TrackDataSource", "%s do some work feed input buffer error %s", new Object[]{asP(), e2.toString()});
                } else {
                    this.opP = true;
                    x.printErrStackTrace("MicroMsg.TrackDataSource", e2, "%s do some work feed input buffer error", new Object[]{asP()});
                }
                if (!d.sy(this.state)) {
                    aZH();
                }
                gVar = this.opD;
                aZy = aZy();
                if (!gVar.opB && gVar.opx) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(354, 157, 1, false);
                    com.tencent.mm.plugin.report.service.g.pQN.h(13836, new Object[]{Integer.valueOf(505), Long.valueOf(bh.Wo()), aZy});
                    gVar.opB = true;
                }
            }
        }
        x.d("MicroMsg.TrackDataSource", "%s finish to do some work. state %d", new Object[]{asP(), Integer.valueOf(this.state)});
        return this.state;
    }

    private boolean d(long j, long j2) {
        x.d("MicroMsg.TrackDataSource", "%s drain output buffer time[%d %d] index %d", new Object[]{asP(), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(this.apP)});
        if (this.apP < 0) {
            synchronized (this.lock) {
                this.apP = this.opN.dequeueOutputBuffer(this.apy, 0);
            }
            if (this.apP >= 0) {
                if ((this.apy.flags & 4) != 0) {
                    x.i("MicroMsg.TrackDataSource", "%s process end of stream", new Object[]{asP()});
                    setState(9);
                    this.apP = -1;
                    return false;
                }
                ByteBuffer byteBuffer = this.agD[this.apP];
                if (byteBuffer != null) {
                    byteBuffer.position(this.apy.offset);
                    byteBuffer.limit(this.apy.offset + this.apy.size);
                }
            } else if (this.apP == -2) {
                this.opI = this.opN.getOutputFormat();
                b(this.opN);
                return true;
            } else if (this.apP == -3) {
                this.agD = this.opN.getOutputBuffers();
                return true;
            } else {
                x.d("MicroMsg.TrackDataSource", "%s drain output buffer error outputIndex[%d]", new Object[]{asP(), Integer.valueOf(this.apP)});
                return false;
            }
        }
        if ((this.state == 1 ? 1 : null) != null) {
            setState(2);
        }
        x.d("MicroMsg.TrackDataSource", "%s process output buffer index %d ", new Object[]{asP(), Integer.valueOf(this.apP)});
        synchronized (this.lock) {
            if (a(j, j2, this.opN, this.agD[this.apP], this.apP, this.apy)) {
                this.apP = -1;
                return true;
            }
            return false;
        }
    }

    protected final boolean w(long j, long j2) {
        long Wq = bh.Wq();
        try {
            if ((j / 1000) + 1000 < this.aqA && j2 == -1) {
                this.opD.opy = true;
                this.opF = false;
                this.opL.release();
                this.opL = new MediaExtractor();
                this.opL.setDataSource(this.path);
                this.opL.selectTrack(this.opK);
                this.opL.seekTo(j, 2);
                long sampleTime = this.opL.getSampleTime();
                x.w("MicroMsg.TrackDataSource", "%s it don't play end. currTime[%d] afterSeek[%d] nextSampleTime[%d] onlineCacheMs[%d] cost[%d]", new Object[]{asP(), Long.valueOf(j), Long.valueOf(sampleTime), Long.valueOf(j2), Long.valueOf(this.opH), Long.valueOf(bh.bA(Wq))});
                return true;
            }
        } catch (Exception e) {
            x.e("MicroMsg.TrackDataSource", "%s reset extractor error %s", new Object[]{asP(), e.toString()});
        }
        return false;
    }

    protected boolean A(int i, long j) {
        return false;
    }

    protected void b(MediaFormat mediaFormat, String str, int i) {
        x.i("MicroMsg.TrackDataSource", "%s found media format mime[%s] track[%d]", new Object[]{asP(), str, Integer.valueOf(i)});
        this.opK = i;
        this.opJ = str;
        this.aqA = mediaFormat.getLong("durationUs") / 1000;
        this.opI = mediaFormat;
    }

    protected void b(MediaCodec mediaCodec) {
    }

    protected void onStart() {
    }

    protected void onPause() {
    }

    protected final void setState(int i) {
        x.i("MicroMsg.TrackDataSource", "%s set state old %d new %d", new Object[]{asP(), Integer.valueOf(this.state), Integer.valueOf(i)});
        this.state = i;
    }

    public final String asP() {
        return aZy() + "_" + this.opD.asP();
    }
}
