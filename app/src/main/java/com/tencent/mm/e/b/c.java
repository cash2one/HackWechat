package com.tencent.mm.e.b;

import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.b.h;
import com.tencent.mm.compatible.b.i;
import com.tencent.mm.compatible.d.m;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.e.c.b;
import com.tencent.mm.g.a.jl;
import com.tencent.mm.g.a.lo;
import com.tencent.mm.g.a.lp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class c {
    private boolean fkA = false;
    long fkB = -1;
    int fkC;
    boolean fkD = false;
    int fkE;
    private boolean fkF = false;
    int fkG = 0;
    boolean fkH = false;
    boolean fkI = false;
    private AudioRecord fkJ;
    public a fkK;
    private f fkL;
    private g fkM;
    b fkN;
    public int fkO = 2;
    public int fkP = 1;
    public int fkQ = 0;
    private f$a fkR = new f$a(this) {
        final /* synthetic */ c fkS;

        {
            this.fkS = r1;
        }

        public final void c(int i, byte[] bArr) {
            c cVar;
            int i2;
            int i3;
            this.fkS.fkG++;
            if (this.fkS.fkI && System.currentTimeMillis() - this.fkS.fkB <= 1000 && ((long) (this.fkS.fkG - 10)) > (System.currentTimeMillis() - this.fkS.fkB) / ((long) this.fkS.fku)) {
                com.tencent.mm.plugin.report.service.g.pQN.a(151, 0, 1, false);
                com.tencent.mm.plugin.report.service.g.pQN.a(151, 4, 1, false);
                x.e("MicroMsg.MMPcmRecorder", "return too many data, force stop, %d, %d", new Object[]{Integer.valueOf(this.fkS.fkG), Long.valueOf((System.currentTimeMillis() - this.fkS.fkB) / ((long) this.fkS.fku))});
                this.fkS.fkH = true;
            }
            if (this.fkS.fkN != null) {
                this.fkS.fkN.u(bArr, i);
            }
            if (i > 0) {
                cVar = this.fkS;
                if (!(cVar.fkD && -2 == cVar.fkr)) {
                    int i4 = i / cVar.fkC;
                    for (i2 = 5; i2 <= cVar.fkE + i4; i2 += 5) {
                        i3 = ((i2 - cVar.fkE) - 1) * cVar.fkC;
                        int i5 = cVar.fkC + i3;
                        if (i3 < 0 || i5 > i) {
                            x.e("MicroMsg.MMPcmRecorder", "error start: %d, end: %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i5)});
                            break;
                        }
                        while (i3 < i5) {
                            if (bArr[i3] != (byte) 0) {
                                cVar.fkr = -1;
                                cVar.fkD = true;
                                break;
                            }
                            i3++;
                        }
                        cVar.fkr++;
                    }
                    cVar.fkE = (cVar.fkE + i4) % 5;
                    if (cVar.fkr == 20) {
                        cVar.fkp = 6;
                        x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_ERROR");
                        if (cVar.fkq == -1 && cVar.fks == -1) {
                            cVar.fkp = 11;
                            x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
                        } else if (cVar.fkq == -1) {
                            cVar.fkp = 8;
                            x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
                        } else if (cVar.fks == -1) {
                            cVar.fkp = 9;
                            x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
                        }
                        com.tencent.mm.plugin.report.service.g.pQN.a(151, 0, 1, false);
                        com.tencent.mm.plugin.report.service.g.pQN.a(151, 5, 1, false);
                        cVar.fkr = -2;
                        cVar.vs();
                    }
                }
            }
            if (!this.fkS.fkw) {
                return;
            }
            if (i > 0) {
                cVar = this.fkS;
                if (cVar.fkq != -1) {
                    i3 = 0;
                    for (i2 = 0; i2 < i / 2; i2++) {
                        short s = (short) ((bArr[(i2 * 2) + 1] << 8) | (bArr[(i2 * 2) + 0] & 255));
                        if (s >= (short) 32760 || s == Short.MIN_VALUE) {
                            i3++;
                        }
                        if (i3 >= 5) {
                            cVar.fkq++;
                            break;
                        }
                    }
                    if (cVar.fkq > 100) {
                        cVar.fkp = 7;
                        x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_ERROR");
                        if (cVar.fkr == -2 && cVar.fks == -1) {
                            cVar.fkp = 11;
                            x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
                        } else if (cVar.fkr == -2) {
                            cVar.fkp = 8;
                            x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
                        } else if (cVar.fks == -1) {
                            cVar.fkp = 10;
                            x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
                        }
                        com.tencent.mm.plugin.report.service.g.pQN.a(151, 0, 1, false);
                        com.tencent.mm.plugin.report.service.g.pQN.a(151, 6, 1, false);
                        cVar.vs();
                        cVar.fkq = -1;
                        return;
                    }
                    return;
                }
                return;
            }
            c cVar2 = this.fkS;
            if (cVar2.fks != -1 && i < 0) {
                cVar2.fks++;
                if (cVar2.fks >= 50) {
                    cVar2.fkp = 5;
                    x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_READRET_ERROR");
                    if (cVar2.fkr == -2 && cVar2.fkq == -1) {
                        cVar2.fkp = 11;
                        x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
                    } else if (cVar2.fkr == -2) {
                        cVar2.fkp = 9;
                        x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
                    } else if (cVar2.fkq == -1) {
                        cVar2.fkp = 10;
                        x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
                    }
                    com.tencent.mm.plugin.report.service.g.pQN.a(151, 0, 1, false);
                    com.tencent.mm.plugin.report.service.g.pQN.a(151, 7, 1, false);
                    cVar2.vs();
                    cVar2.fks = -1;
                }
            }
        }
    };
    public int fkp = 0;
    int fkq = 0;
    int fkr = 0;
    int fks = 0;
    private int fkt = 1;
    public int fku = 120;
    private boolean fkv = false;
    boolean fkw = false;
    public int fkx = 10;
    private int fky = -1;
    public int fkz = -123456789;
    public int mSampleRate = 8000;

    public interface a {
        void aK(int i, int i2);

        void q(byte[] bArr, int i);
    }

    public c(int i, int i2, int i3) {
        this.fkt = i2;
        this.mSampleRate = i;
        this.fky = i3;
        if (this.fkt == 2) {
            this.fkO = 3;
        } else {
            this.fkO = 2;
        }
        if (this.fky == 0 && q.gGe.gEN > 0) {
            this.fku = q.gGe.gEN;
        }
        if (q.gGe.gEY > 0) {
            this.fkO = q.gGe.gEY;
        }
        if (q.gGe.gEI > 0) {
            this.fkx = q.gGe.gEI;
        }
        if (q.gFV.gDl) {
            this.fkN = new b(g.fln, this.fkt, this.mSampleRate);
        }
        this.fkI = 1 == g.t("EnableRecorderCheckUnreasonableData", 1);
        x.i("MicroMsg.MMPcmRecorder", "MMPcmRecorder sampleRate:%d channelCnt:%d durationPreFrame:%d newBufPreFrame:%b Biz:%d", new Object[]{Integer.valueOf(this.mSampleRate), Integer.valueOf(this.fkt), Integer.valueOf(this.fku), Boolean.valueOf(this.fkv), Integer.valueOf(this.fky)});
    }

    public final void et(int i) {
        this.fku = i;
        x.i("MicroMsg.MMPcmRecorder", "mDurationPreFrame: " + this.fku);
    }

    public final void aO(boolean z) {
        this.fkv = z;
        x.i("MicroMsg.MMPcmRecorder", "mNewBufPreFrame: " + this.fkv);
    }

    public final void vq() {
        this.fkw = true;
        x.i("MicroMsg.MMPcmRecorder", "mCheckAudioQuality: " + this.fkw);
    }

    public final void n(int i, boolean z) {
        if (10 == this.fkx || z) {
            this.fkx = i;
            x.i("MicroMsg.MMPcmRecorder", "mMultipleOfMinBuffer: " + this.fkx);
        }
    }

    public final void aP(boolean z) {
        this.fkA = z;
        x.i("MicroMsg.MMPcmRecorder", "mUsePreProcess: " + this.fkA);
    }

    private boolean init() {
        Object obj;
        this.fkP = 1;
        boolean z = q.gGe.gEJ != 2;
        int yp = m.yp();
        int i = q.gFV.gDy;
        if ((yp & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            if (i <= 0) {
                i = 0;
            }
            x.i("MicroMsg.MMPcmRecorder", "CPU ARMv7, enableRecTimerMode: " + i);
        } else {
            i = 1;
        }
        if (i == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        x.d("MicroMsg.MMPcmRecorder", "init, start getMinBufferSize");
        int minBufferSize = AudioRecord.getMinBufferSize(this.mSampleRate, this.fkO, 2);
        if (minBufferSize == -2 || minBufferSize == -1) {
            this.fkP = 3;
            this.fkp = 1;
            x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_MINBUFFER_ERROR " + minBufferSize);
            vs();
            return false;
        }
        int i2;
        AudioRecord audioRecord;
        g gVar;
        x.d("MicroMsg.MMPcmRecorder", "finish getMinBufferSize, minBufSize: %d", new Object[]{Integer.valueOf(minBufferSize)});
        this.fkC = (((this.mSampleRate * 20) * this.fkt) * 2) / 1000;
        int i3 = ((this.mSampleRate * this.fku) * this.fkt) / 1000;
        int i4 = i3 * 2;
        x.i("MicroMsg.MMPcmRecorder", "Construct AudioRecord, minBufSize:%d, sampleRate:%d, sampleCntPreFrame:%d, sizePreFrame:%d, timesOfMinBuffer:%d, readMode:%b", new Object[]{Integer.valueOf(minBufferSize), Integer.valueOf(this.mSampleRate), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(this.fkx), Boolean.valueOf(z)});
        yp = this.fky;
        i = 1;
        if (1 == yp || 6 == yp || 7 == yp) {
            i = VERSION.SDK_INT < 11 ? 1 : 7;
            if (q.gFV.gCG) {
                i = 1;
            }
            if (q.gFV.gDf >= 0) {
                i = q.gFV.gDf;
            }
            if (6 == yp && q.gFV.gDI >= 0) {
                i2 = q.gFV.gDI;
                this.fkJ = new com.tencent.mm.compatible.b.c(i2, this.mSampleRate, this.fkO, this.fkx * minBufferSize);
                if (this.fkJ.getState() == 0) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(151, 0, 1, false);
                    com.tencent.mm.plugin.report.service.g.pQN.a(151, 2, 1, false);
                    this.fkJ.release();
                    this.fkp = 2;
                    x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEWAUDIORECORD_ERROR");
                    if (7 != i2) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    this.fkJ = new com.tencent.mm.compatible.b.c(i, this.mSampleRate, this.fkO, this.fkx * minBufferSize);
                }
                if (this.fkJ.getState() != 0) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(151, 0, 1, false);
                    com.tencent.mm.plugin.report.service.g.pQN.a(151, 2, 1, false);
                    this.fkJ.release();
                    this.fkJ = null;
                    this.fkP = 2;
                    this.fkp = 3;
                    x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_SECNEWAUDIORECORD_ERROR");
                    vs();
                    return false;
                }
                if (z) {
                    this.fkL = new d(this.fkJ, this.fkK, this.fkv, i3, i4);
                } else {
                    audioRecord = this.fkJ;
                    boolean z2 = this.fkv;
                    a aVar = this.fkK;
                    boolean z3 = (this.fky != 1 || this.fky == 6) && obj != null;
                    this.fkL = new e(audioRecord, z2, i4, aVar, z3);
                }
                this.fkL.a(this.fkR);
                if (-123456789 != this.fkz) {
                    this.fkL.eu(this.fkz);
                }
                if (this.fkA) {
                    this.fkM = new g();
                    gVar = this.fkM;
                    audioRecord = this.fkJ;
                    yp = this.fky;
                    x.d("MicroMsg.MMAudioPreProcess", "api " + VERSION.SDK_INT);
                    if (!f.fN(16)) {
                        if (audioRecord == null) {
                            x.d("MicroMsg.MMAudioPreProcess", "audio is null");
                        } else if (1 != yp) {
                            if (q.gGe.gFf == 1) {
                                x.d("MicroMsg.MMAudioPreProcess", "disable by config");
                            } else {
                                if (q.gGe.gFg != 2) {
                                    gVar.gCz = new i(audioRecord);
                                    if (gVar.gCz != null && gVar.gCz.isAvailable()) {
                                        gVar.gCz.xF();
                                    }
                                }
                                if (q.gGe.gFh != 2) {
                                    gVar.gCA = new e(audioRecord);
                                    if (gVar.gCA != null && gVar.gCA.isAvailable()) {
                                        gVar.gCA.xF();
                                    }
                                }
                                if (q.gGe.gFi != 2) {
                                    gVar.gCB = new h(audioRecord);
                                    if (gVar.gCB != null && gVar.gCB.isAvailable()) {
                                        gVar.gCB.xF();
                                    }
                                }
                            }
                        } else if (q.gGe.gEM == 1) {
                            x.d("MicroMsg.MMAudioPreProcess", "disable by config");
                        } else {
                            gVar.gCz = new i(audioRecord);
                            if (gVar.gCz != null && gVar.gCz.isAvailable()) {
                                gVar.gCz.xF();
                            }
                            gVar.gCA = new e(audioRecord);
                            if (gVar.gCA != null && gVar.gCA.isAvailable()) {
                                gVar.gCA.xF();
                            }
                            gVar.gCB = new h(audioRecord);
                            if (gVar.gCB != null && gVar.gCB.isAvailable()) {
                                gVar.gCB.xF();
                            }
                        }
                    }
                }
                return true;
            }
        }
        i2 = i;
        try {
            this.fkJ = new com.tencent.mm.compatible.b.c(i2, this.mSampleRate, this.fkO, this.fkx * minBufferSize);
            if (this.fkJ.getState() == 0) {
                com.tencent.mm.plugin.report.service.g.pQN.a(151, 0, 1, false);
                com.tencent.mm.plugin.report.service.g.pQN.a(151, 2, 1, false);
                this.fkJ.release();
                this.fkp = 2;
                x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEWAUDIORECORD_ERROR");
                if (7 != i2) {
                    i = 0;
                } else {
                    i = 1;
                }
                this.fkJ = new com.tencent.mm.compatible.b.c(i, this.mSampleRate, this.fkO, this.fkx * minBufferSize);
            }
            if (this.fkJ.getState() != 0) {
                if (z) {
                    this.fkL = new d(this.fkJ, this.fkK, this.fkv, i3, i4);
                } else {
                    audioRecord = this.fkJ;
                    boolean z22 = this.fkv;
                    a aVar2 = this.fkK;
                    if (this.fky != 1) {
                    }
                    this.fkL = new e(audioRecord, z22, i4, aVar2, z3);
                }
                this.fkL.a(this.fkR);
                if (-123456789 != this.fkz) {
                    this.fkL.eu(this.fkz);
                }
                if (this.fkA) {
                    this.fkM = new g();
                    gVar = this.fkM;
                    audioRecord = this.fkJ;
                    yp = this.fky;
                    x.d("MicroMsg.MMAudioPreProcess", "api " + VERSION.SDK_INT);
                    if (f.fN(16)) {
                        if (audioRecord == null) {
                            x.d("MicroMsg.MMAudioPreProcess", "audio is null");
                        } else if (1 != yp) {
                            if (q.gGe.gEM == 1) {
                                gVar.gCz = new i(audioRecord);
                                gVar.gCz.xF();
                                gVar.gCA = new e(audioRecord);
                                gVar.gCA.xF();
                                gVar.gCB = new h(audioRecord);
                                gVar.gCB.xF();
                            } else {
                                x.d("MicroMsg.MMAudioPreProcess", "disable by config");
                            }
                        } else if (q.gGe.gFf == 1) {
                            if (q.gGe.gFg != 2) {
                                gVar.gCz = new i(audioRecord);
                                gVar.gCz.xF();
                            }
                            if (q.gGe.gFh != 2) {
                                gVar.gCA = new e(audioRecord);
                                gVar.gCA.xF();
                            }
                            if (q.gGe.gFi != 2) {
                                gVar.gCB = new h(audioRecord);
                                gVar.gCB.xF();
                            }
                        } else {
                            x.d("MicroMsg.MMAudioPreProcess", "disable by config");
                        }
                    }
                }
                return true;
            }
            com.tencent.mm.plugin.report.service.g.pQN.a(151, 0, 1, false);
            com.tencent.mm.plugin.report.service.g.pQN.a(151, 2, 1, false);
            this.fkJ.release();
            this.fkJ = null;
            this.fkP = 2;
            this.fkp = 3;
            x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_SECNEWAUDIORECORD_ERROR");
            vs();
            return false;
        } catch (Exception e) {
            x.e("MicroMsg.MMPcmRecorder", "new AudioRecord failed");
            this.fkp = 12;
            x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEW_AUDIORECORD_EXCEPTION");
            com.tencent.mm.plugin.report.service.g.pQN.a(151, 0, 1, false);
            com.tencent.mm.plugin.report.service.g.pQN.a(151, 1, 1, false);
            return false;
        }
    }

    public final void aQ(boolean z) {
        x.i("MicroMsg.MMPcmRecorder", "switchMute mute:" + z);
        if (this.fkL != null) {
            this.fkL.aQ(z);
        }
    }

    public final boolean vr() {
        boolean z = false;
        x.d("MicroMsg.MMPcmRecorder", JsApiStartRecordVoice.NAME);
        com.tencent.mm.sdk.b.b loVar = new lo();
        loVar.fCX.type = 1;
        loVar.fCX.fCZ = true;
        com.tencent.mm.sdk.b.a.xef.m(loVar);
        this.fkB = System.currentTimeMillis();
        this.fkD = false;
        if (loVar.fCY.fDb) {
            x.e("MicroMsg.MMPcmRecorder", "can't start record due to permission tips policy");
            this.fkp = 13;
        } else {
            AudioManager audioManager = (AudioManager) ac.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            if (audioManager == null || !audioManager.isMicrophoneMute()) {
                this.fkF = false;
                com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
                x.i("MicroMsg.MMPcmRecorder", "startRecord, " + Thread.currentThread().getStackTrace()[2].getMethodName());
                if (this.fkJ != null) {
                    x.e("MicroMsg.MMPcmRecorder", "start error ,is recording ");
                } else {
                    aVar.gHJ = SystemClock.elapsedRealtime();
                    x.d("MicroMsg.MMPcmRecorder", "startRecordInternal, start init");
                    if (init()) {
                        x.i("MicroMsg.MMPcmRecorder", "init cost: " + aVar.zi() + "ms");
                        aVar.gHJ = SystemClock.elapsedRealtime();
                        this.fkJ.startRecording();
                        x.i("MicroMsg.MMPcmRecorder", "startRecording cost: " + aVar.zi());
                        if (this.fkJ.getRecordingState() != 3) {
                            com.tencent.mm.plugin.report.service.g.pQN.a(151, 0, 1, false);
                            com.tencent.mm.plugin.report.service.g.pQN.a(151, 3, 1, false);
                            this.fkP = 2;
                            this.fkp = 4;
                            x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_STARTRECORDING_ERROR");
                            vs();
                        } else if (this.fkL != null) {
                            z = this.fkL.vr();
                        } else {
                            x.e("MicroMsg.MMPcmRecorder", "mRecordMode is null");
                        }
                    } else {
                        x.e("MicroMsg.MMPcmRecorder", "startRecord init error");
                    }
                }
                if (!z) {
                    vi();
                    loVar = new lp();
                    loVar.fDc.type = 1;
                    com.tencent.mm.sdk.b.a.xef.m(loVar);
                }
            } else {
                x.e("MicroMsg.MMPcmRecorder", "microphone is mute");
                this.fkp = 14;
                com.tencent.mm.sdk.b.a.xef.m(new jl());
                com.tencent.mm.plugin.report.service.g.pQN.a(151, 0, 1, false);
                com.tencent.mm.plugin.report.service.g.pQN.a(151, 8, 1, false);
            }
        }
        return z;
    }

    public final synchronized boolean vi() {
        boolean z = true;
        synchronized (this) {
            if (true == this.fkF) {
                x.i("MicroMsg.MMPcmRecorder", "already have stopped");
            } else {
                boolean z2;
                this.fkF = true;
                com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
                if (this.fkN != null) {
                    this.fkN.vG();
                    this.fkN = null;
                }
                aVar.gHJ = SystemClock.elapsedRealtime();
                if (this.fkL != null) {
                    this.fkL.uE();
                    this.fkL = null;
                }
                x.i("MicroMsg.MMPcmRecorder", "cost " + aVar.zi() + "ms to call stopRecord");
                x.i("MicroMsg.MMPcmRecorder", "stopRecord, " + Thread.currentThread().getStackTrace()[2].getMethodName());
                if (this.fkJ == null) {
                    x.e("MicroMsg.MMPcmRecorder", "audioRecord is null");
                    z2 = false;
                } else if (this.fkJ.getState() != 1) {
                    x.e("MicroMsg.MMPcmRecorder", "audioRecord sate error " + this.fkJ.getState());
                    z2 = false;
                } else {
                    aVar.gHJ = SystemClock.elapsedRealtime();
                    this.fkJ.stop();
                    this.fkJ.release();
                    this.fkJ = null;
                    x.i("MicroMsg.MMPcmRecorder", "cost " + aVar.zi() + "ms to call stop and release");
                    z2 = true;
                }
                if (!(this.fkD || -1 == this.fkB || System.currentTimeMillis() - this.fkB < 2000) || this.fkH) {
                    x.i("MicroMsg.MMPcmRecorder", "stopRecord publish PermissionShowDlgEvent");
                    com.tencent.mm.sdk.b.b lpVar = new lp();
                    lpVar.fDc.type = 1;
                    com.tencent.mm.sdk.b.a.xef.m(lpVar);
                    z = false;
                }
                com.tencent.mm.sdk.b.b loVar = new lo();
                loVar.fCX.type = 1;
                loVar.fCX.fCZ = false;
                loVar.fCX.fDa = z;
                com.tencent.mm.sdk.b.a.xef.m(loVar);
                x.i("MicroMsg.MMPcmRecorder", "doNewIDKeyStatOnStopRecord, mRecordDetailState: %d", new Object[]{Integer.valueOf(this.fkp)});
                ArrayList arrayList = new ArrayList();
                arrayList.add(new IDKey(357, 0, 1));
                if (this.fkp != 0) {
                    arrayList.add(new IDKey(357, 1, 1));
                }
                switch (this.fkp) {
                    case 1:
                        arrayList.add(new IDKey(357, 2, 1));
                        break;
                    case 2:
                        arrayList.add(new IDKey(357, 3, 1));
                        break;
                    case 3:
                        arrayList.add(new IDKey(357, 4, 1));
                        break;
                    case 4:
                        arrayList.add(new IDKey(357, 5, 1));
                        break;
                    case 5:
                        arrayList.add(new IDKey(357, 6, 1));
                        break;
                    case 6:
                        arrayList.add(new IDKey(357, 7, 1));
                        break;
                    case 7:
                        arrayList.add(new IDKey(357, 8, 1));
                        break;
                    case 8:
                        arrayList.add(new IDKey(357, 9, 1));
                        break;
                    case 9:
                        arrayList.add(new IDKey(357, 10, 1));
                        break;
                    case 10:
                        arrayList.add(new IDKey(357, 11, 1));
                        break;
                    case 11:
                        arrayList.add(new IDKey(357, 12, 1));
                        break;
                    case 12:
                        arrayList.add(new IDKey(357, 13, 1));
                        break;
                }
                x.i("MicroMsg.MMPcmRecorder", "do idkey, infolist size: %d", new Object[]{Integer.valueOf(arrayList.size())});
                com.tencent.mm.plugin.report.service.g.pQN.a(arrayList, false);
                z = z2;
            }
        }
        return z;
    }

    final void vs() {
        if (this.fkK != null) {
            this.fkK.aK(this.fkP, this.fkp);
        }
    }

    public final int vt() {
        if (this.fkL != null) {
            return this.fkL.vt();
        }
        return -1;
    }
}
