package com.tencent.mm.plugin.appbrand.media;

import android.media.AudioRecord;
import android.os.Looper;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.g.a.li;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.plugin.appbrand.media.encode.c;
import com.tencent.mm.plugin.appbrand.media.encode.d;
import com.tencent.mm.plugin.appbrand.media.record.RecordParam;
import com.tencent.mm.plugin.appbrand.media.record.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;

public final class f {
    public a jzD = null;
    public boolean jzE = false;
    Object jzF = new Object();
    public RecordParam jzG;
    public int jzH = a.jzS;
    c jzI = null;
    boolean jzJ = false;
    int jzK = 0;
    long jzL = 0;
    private int jzM = 0;
    private af jzN;
    private a.a jzO = new 1(this);
    private c.a jzP = new 4(this);
    private ak jzp = null;
    private long mDuration = 0;
    private String mFilePath;
    private long mStartTime = 0;

    class AnonymousClass6 implements Runnable {
        final /* synthetic */ f jzQ;
        final /* synthetic */ RecordParam jzR;

        public AnonymousClass6(f fVar, RecordParam recordParam) {
            this.jzQ = fVar;
            this.jzR = recordParam;
        }

        public final void run() {
            synchronized (this.jzQ.jzF) {
                this.jzQ.jzG = this.jzR;
                f.a(this.jzQ);
            }
        }
    }

    static /* synthetic */ void a(f fVar) {
        try {
            x.i("MicroMsg.AudioRecordMgr", "_start in runnable");
            if (fVar.air()) {
                fVar.jzJ = false;
                fVar.jzK = 0;
                if (fVar.aiq()) {
                    int i;
                    c cVar = fVar.jzI;
                    a aVar = fVar.jzD;
                    if (aVar.fkb != null) {
                        com.tencent.mm.e.b.c cVar2 = aVar.fkb;
                        if (cVar2.fkQ > 0) {
                            i = cVar2.fkQ;
                        } else {
                            int minBufferSize = AudioRecord.getMinBufferSize(cVar2.mSampleRate, cVar2.fkO, 2);
                            x.i("MicroMsg.MMPcmRecorder", "getDefaultMinBufferSize minBufSize:%d", new Object[]{Integer.valueOf(minBufferSize)});
                            if (minBufferSize == -2 || minBufferSize == -1) {
                                i = 0;
                            } else {
                                cVar2.fkQ = minBufferSize * cVar2.fkx;
                                i = cVar2.fkQ;
                            }
                        }
                    } else {
                        i = 0;
                    }
                    cVar.kW(i);
                    fVar.jzI.kX(fVar.jzG.afs);
                    fVar.jzM = 0;
                    fVar.mDuration = (long) fVar.jzG.duration;
                    fVar.mStartTime = System.currentTimeMillis();
                    fVar.jzL = fVar.mDuration;
                    x.i("MicroMsg.AudioRecordMgr", "mDuration:%d, mCurrentTime:%d", new Object[]{Long.valueOf(fVar.mDuration), Long.valueOf(fVar.mStartTime)});
                    fVar.aiu().post(new 10(fVar));
                    x.i("MicroMsg.AudioRecordMgr", "onStart");
                    fVar.jzH = a.jzT;
                    fVar.jzE = true;
                    b liVar = new li();
                    liVar.fCH.action = 0;
                    liVar.fCH.state = "start";
                    if (fVar.jzG != null) {
                        liVar.fCH.appId = fVar.jzG.appId;
                    }
                    com.tencent.mm.sdk.b.a.xef.a(liVar, Looper.getMainLooper());
                    x.i("MicroMsg.AudioRecordMgr", "start record success");
                    return;
                }
                fVar.onError(6);
                x.e("MicroMsg.AudioRecordMgr", "start record fail");
                return;
            }
            fVar.onError(2);
            x.e("MicroMsg.AudioRecordMgr", "init encoder fail");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AudioRecordMgr", e, "_start", new Object[0]);
            fVar.onError(4);
        }
    }

    static /* synthetic */ void a(f fVar, long j) {
        fVar.TG();
        x.i("MicroMsg.AudioRecordMgr", "startTimer");
        fVar.jzp = new ak(new 5(fVar), false);
        fVar.jzp.J(j, j);
    }

    static /* synthetic */ void b(f fVar) {
        try {
            x.i("MicroMsg.AudioRecordMgr", "_resume in runnable");
            if (fVar.jzI == null) {
                fVar.onError(3);
                x.e("MicroMsg.AudioRecordMgr", "resume record fail");
            } else if (fVar.jzL <= 0) {
                fVar.ait();
                x.e("MicroMsg.AudioRecordMgr", "resume record fail, record time reach max time, to stop record");
            } else if (fVar.aiq()) {
                fVar.mStartTime = System.currentTimeMillis();
                x.i("MicroMsg.AudioRecordMgr", "mLimitTime:%d, currentTime:%d", new Object[]{Long.valueOf(fVar.jzL), Long.valueOf(fVar.mStartTime)});
                fVar.aiu().post(new 11(fVar));
                x.i("MicroMsg.AudioRecordMgr", "onResume");
                fVar.jzH = a.jzU;
                fVar.jzE = true;
                b liVar = new li();
                liVar.fCH.action = 1;
                liVar.fCH.state = "resume";
                if (fVar.jzG != null) {
                    liVar.fCH.appId = fVar.jzG.appId;
                }
                com.tencent.mm.sdk.b.a.xef.a(liVar, Looper.getMainLooper());
                x.i("MicroMsg.AudioRecordMgr", "resume record success");
            } else {
                fVar.onError(7);
                x.e("MicroMsg.AudioRecordMgr", "resume record fail");
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AudioRecordMgr", e, "_resume", new Object[0]);
            fVar.onError(5);
        }
    }

    final void TG() {
        x.i("MicroMsg.AudioRecordMgr", "stopTimer");
        if (this.jzp != null) {
            this.jzp.TG();
        }
        this.jzp = null;
    }

    public final boolean vg() {
        return this.jzH == a.jzV;
    }

    public final boolean aip() {
        return this.jzH == a.jzW;
    }

    public final boolean vi() {
        x.i("MicroMsg.AudioRecordMgr", JsApiStopRecordVoice.NAME);
        if (this.jzD == null && this.jzI == null) {
            x.e("MicroMsg.AudioRecordMgr", "mRecord is null and mAudioEncoder is null, stop fail");
            return false;
        }
        e.post(new Runnable(this) {
            final /* synthetic */ f jzQ;

            {
                this.jzQ = r1;
            }

            public final void run() {
                synchronized (this.jzQ.jzF) {
                    this.jzQ.ait();
                }
            }
        }, "app_brand_stop_record");
        return true;
    }

    private boolean aiq() {
        x.i("MicroMsg.AudioRecordMgr", "startRecordInternal");
        if (this.jzD != null) {
            this.jzD.vi();
            this.jzD = null;
            x.i("MicroMsg.AudioRecordMgr", "mRecorder is not null, stop it, and not callback stop event");
        }
        if (this.jzD == null) {
            this.jzD = new a(this.jzG);
            this.jzD.jAs = this.jzO;
        }
        a aVar = this.jzD;
        x.i("MicroMsg.AppBrandRecorder", JsApiStartRecordVoice.NAME);
        if (aVar.fkb != null) {
            aVar.fkb.vi();
            aVar.fkb = null;
        }
        aVar.jAr = System.currentTimeMillis();
        x.i("MicroMsg.AppBrandRecorder", "start time ticket:%d", new Object[]{Long.valueOf(aVar.jAr)});
        aVar.fkb = new com.tencent.mm.e.b.c(aVar.sampleRate, aVar.aef, aVar.fky);
        if ("mp3".equalsIgnoreCase(aVar.jAq.jfm)) {
            aVar.fkb.et(40);
        } else {
            aVar.fkb.et(20);
        }
        aVar.fkb.aO(false);
        aVar.fkb.fkK = aVar.jAt;
        x.i("MicroMsg.AudioRecordMgr", "record start:%b", new Object[]{Boolean.valueOf(aVar.fkb.vr())});
        return aVar.fkb.vr();
    }

    private boolean air() {
        c aVar;
        boolean tl;
        x.i("MicroMsg.AudioRecordMgr", "initEncode");
        if (this.jzI != null) {
            this.jzI.close();
            this.jzI = null;
        }
        String str = this.jzG.jfm;
        String str2 = this.jzG.gHg;
        File file = new File(g.Dj().gQi, SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuilder append = new StringBuilder(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE).append(ab.UZ(str2));
        if (!TextUtils.isEmpty(str)) {
            if ("aac".equalsIgnoreCase(str)) {
                str = ".m4a";
            } else if ("mp3".equalsIgnoreCase(str)) {
                str = ".mp3";
            } else if ("wav".equalsIgnoreCase(str)) {
                str = ".wav";
            }
            x.d("MicroMsg.AudioRecordUtil", "getAudioFilePath audio name %s path %s", new Object[]{append.append(str).toString(), new File(file, append.append(str).toString()).getAbsoluteFile()});
            this.mFilePath = r3.getAbsolutePath();
            x.i("MicroMsg.AudioRecordMgr", "mFilePath:%s", new Object[]{this.mFilePath});
            str = this.jzG.jfm;
            x.i("MicroMsg.AudioEncodeFactory", "createEncodeByType:%s", new Object[]{str});
            if (g.tk(str)) {
                if ("aac".equalsIgnoreCase(str)) {
                    aVar = new com.tencent.mm.plugin.appbrand.media.encode.a();
                } else if ("mp3".equalsIgnoreCase(str)) {
                    aVar = new d();
                } else if ("wav".equalsIgnoreCase(str)) {
                    aVar = new com.tencent.mm.plugin.appbrand.media.encode.e();
                }
                this.jzI = aVar;
                if (this.jzI == null) {
                    return false;
                }
                tl = g.tl(this.mFilePath);
                if (tl) {
                    x.e("MicroMsg.AudioRecordMgr", "prepare cache file fail");
                    return tl;
                }
                try {
                    tl = this.jzI.f(this.mFilePath, this.jzG.sampleRate, this.jzG.jAv, this.jzG.jAw);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AudioRecordMgr", e, "init encoder fail", new Object[0]);
                    tl = false;
                }
                this.jzI.a(this.jzP);
                return tl;
            }
            aVar = null;
            this.jzI = aVar;
            if (this.jzI == null) {
                return false;
            }
            tl = g.tl(this.mFilePath);
            if (tl) {
                tl = this.jzI.f(this.mFilePath, this.jzG.sampleRate, this.jzG.jAv, this.jzG.jAw);
                this.jzI.a(this.jzP);
                return tl;
            }
            x.e("MicroMsg.AudioRecordMgr", "prepare cache file fail");
            return tl;
        }
        str = "";
        x.d("MicroMsg.AudioRecordUtil", "getAudioFilePath audio name %s path %s", new Object[]{append.append(str).toString(), new File(file, append.append(str).toString()).getAbsoluteFile()});
        this.mFilePath = r3.getAbsolutePath();
        x.i("MicroMsg.AudioRecordMgr", "mFilePath:%s", new Object[]{this.mFilePath});
        str = this.jzG.jfm;
        x.i("MicroMsg.AudioEncodeFactory", "createEncodeByType:%s", new Object[]{str});
        if (g.tk(str)) {
            if ("aac".equalsIgnoreCase(str)) {
                aVar = new com.tencent.mm.plugin.appbrand.media.encode.a();
            } else if ("mp3".equalsIgnoreCase(str)) {
                aVar = new d();
            } else if ("wav".equalsIgnoreCase(str)) {
                aVar = new com.tencent.mm.plugin.appbrand.media.encode.e();
            }
            this.jzI = aVar;
            if (this.jzI == null) {
                return false;
            }
            tl = g.tl(this.mFilePath);
            if (tl) {
                x.e("MicroMsg.AudioRecordMgr", "prepare cache file fail");
                return tl;
            }
            tl = this.jzI.f(this.mFilePath, this.jzG.sampleRate, this.jzG.jAv, this.jzG.jAw);
            this.jzI.a(this.jzP);
            return tl;
        }
        aVar = null;
        this.jzI = aVar;
        if (this.jzI == null) {
            return false;
        }
        tl = g.tl(this.mFilePath);
        if (tl) {
            tl = this.jzI.f(this.mFilePath, this.jzG.sampleRate, this.jzG.jAv, this.jzG.jAw);
            this.jzI.a(this.jzP);
            return tl;
        }
        x.e("MicroMsg.AudioRecordMgr", "prepare cache file fail");
        return tl;
    }

    final void ais() {
        x.i("MicroMsg.AudioRecordMgr", "pause record in runnable");
        boolean vi;
        try {
            if (vg()) {
                x.e("MicroMsg.AudioRecordMgr", "is paused, don't pause again");
                return;
            }
            if (this.jzD != null) {
                vi = this.jzD.vi();
                this.jzD = null;
            } else {
                vi = false;
            }
            aiu().post(new 2(this));
            x.i("MicroMsg.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", new Object[]{Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis() - this.mStartTime), Integer.valueOf(this.jzM)});
            this.jzM = (int) (((long) this.jzM) + r4);
            this.jzL = this.mDuration - ((long) this.jzM);
            x.i("MicroMsg.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", new Object[]{Long.valueOf(this.jzL), Integer.valueOf(this.jzM)});
            x.i("MicroMsg.AudioRecordMgr", "stop:%b", new Object[]{Boolean.valueOf(vi)});
            if (vi) {
                x.i("MicroMsg.AudioRecordMgr", "onPause");
                this.jzH = a.jzV;
                this.jzE = false;
                b liVar = new li();
                liVar.fCH.action = 3;
                liVar.fCH.state = "pause";
                if (this.jzG != null) {
                    liVar.fCH.appId = this.jzG.appId;
                }
                com.tencent.mm.sdk.b.a.xef.a(liVar, Looper.getMainLooper());
                x.i("MicroMsg.AudioRecordMgr", "pause record success");
                return;
            }
            onError(8);
            x.e("MicroMsg.AudioRecordMgr", "pause record fail");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AudioRecordMgr", e, "_pause", new Object[0]);
            vi = false;
        }
    }

    private void ait() {
        x.i("MicroMsg.AudioRecordMgr", "stop record in runnable");
        boolean vi;
        try {
            if (aip()) {
                x.e("MicroMsg.AudioRecordMgr", "is stopped, don't stop again");
                return;
            }
            if (this.jzD != null) {
                vi = this.jzD.vi();
                this.jzD = null;
            } else {
                x.e("MicroMsg.AudioRecordMgr", "mRecorder is null, has stop record!");
                vi = true;
            }
            this.jzJ = true;
            x.i("MicroMsg.AudioRecordMgr", "mPcmDuration:%d", new Object[]{Integer.valueOf(this.jzK)});
            if (this.jzI != null) {
                this.jzI.flush();
                this.jzI.close();
                this.jzI = null;
            }
            aiu().post(new 3(this));
            long currentTimeMillis = System.currentTimeMillis();
            x.i("MicroMsg.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", new Object[]{Long.valueOf(currentTimeMillis), Long.valueOf(System.currentTimeMillis() - this.mStartTime), Integer.valueOf(this.jzM)});
            this.jzM = (int) (((long) this.jzM) + r6);
            this.jzL = this.mDuration - ((long) this.jzM);
            x.i("MicroMsg.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", new Object[]{Long.valueOf(this.jzL), Integer.valueOf(this.jzM)});
            x.i("MicroMsg.AudioRecordMgr", "stop:%b", new Object[]{Boolean.valueOf(vi)});
            if (vi) {
                long length;
                x.i("MicroMsg.AudioRecordMgr", "onStop");
                this.jzH = a.jzW;
                this.jzE = false;
                b liVar = new li();
                liVar.fCH.action = 2;
                liVar.fCH.state = "stop";
                if (this.jzG != null) {
                    liVar.fCH.appId = this.jzG.appId;
                }
                liVar.fCH.duration = this.jzM;
                liVar.fCH.filePath = this.mFilePath;
                li.a aVar = liVar.fCH;
                File file = new File(this.mFilePath);
                if (file.exists()) {
                    x.i("MicroMsg.AudioRecordUtil", "exist audio file");
                    length = file.length();
                } else {
                    x.i("MicroMsg.AudioRecordUtil", "audio file not exit, path:%s", new Object[]{r0});
                    length = -1;
                }
                aVar.fileSize = (int) length;
                com.tencent.mm.sdk.b.a.xef.a(liVar, Looper.getMainLooper());
                x.i("MicroMsg.AudioRecordMgr", "stop record success");
            } else {
                onError(9);
                x.e("MicroMsg.AudioRecordMgr", "stop record fail");
            }
            this.jzG = null;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AudioRecordMgr", e, "_stop", new Object[0]);
            vi = false;
        }
    }

    private af aiu() {
        if (this.jzN == null) {
            this.jzN = new af(Looper.getMainLooper());
        }
        return this.jzN;
    }

    protected final void onError(int i) {
        x.i("MicroMsg.AudioRecordMgr", "onError errType:%d", new Object[]{Integer.valueOf(i)});
        if (this.jzH != a.jzX) {
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(689);
            iDKey.SetKey(1);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(689);
            iDKey2.SetKey(i.kU(i));
            iDKey2.SetValue(1);
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            com.tencent.mm.plugin.report.service.g.pQN.a(arrayList, true);
        }
        this.jzH = a.jzX;
        this.jzE = false;
        b liVar = new li();
        liVar.fCH.action = 4;
        liVar.fCH.state = "error";
        if (this.jzG != null) {
            liVar.fCH.appId = this.jzG.appId;
        }
        liVar.fCH.errCode = i;
        li.a aVar = liVar.fCH;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("errType:" + i + ", err:");
        switch (i) {
            case 1:
                stringBuilder.append("error PCM record callback");
                break;
            case 2:
                stringBuilder.append("init encoder fail, occur exception");
                break;
            case 3:
                stringBuilder.append("encoder un initial occur exception");
                break;
            case 4:
                stringBuilder.append("start record occur exception");
                break;
            case 5:
                stringBuilder.append("resume record occur exception");
                break;
            case 6:
                stringBuilder.append("fail to start record");
                break;
            case 7:
                stringBuilder.append("fail to resume record");
                break;
            case 8:
                stringBuilder.append("fail to pause record");
                break;
            case 9:
                stringBuilder.append("fail to stop record");
                break;
            case 15:
                stringBuilder.append("check param invalid");
                break;
            case 16:
                stringBuilder.append("not support format type");
                break;
            case 17:
                stringBuilder.append("fail to init mp3 encoder");
                break;
            case 18:
                stringBuilder.append("mp3 file not found exception");
                break;
            case 19:
                stringBuilder.append("mp3 encode exception");
                break;
            case 20:
                stringBuilder.append("mp3 write buffer exception");
                break;
            case 21:
                stringBuilder.append("fail to init aac encoder");
                break;
            case 22:
                stringBuilder.append("fail to create mp4 file");
                break;
            case 23:
                stringBuilder.append("aac encode exception");
                break;
            case 24:
                stringBuilder.append("create cache file fail");
                break;
            case 25:
                stringBuilder.append("init encoder fail");
                break;
            case 26:
                stringBuilder.append("not support sample rate");
                break;
            default:
                stringBuilder.append("unknow error");
                break;
        }
        aVar.fnL = stringBuilder.toString();
        com.tencent.mm.sdk.b.a.xef.a(liVar, Looper.getMainLooper());
    }
}
