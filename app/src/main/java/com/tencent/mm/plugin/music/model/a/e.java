package com.tencent.mm.plugin.music.model.a;

import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.R;
import com.tencent.mm.ac.a;
import com.tencent.mm.ac.c;
import com.tencent.mm.g.a.t;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.music.model.a.d.1;
import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.plugin.music.model.f.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import java.net.URL;
import java.util.ArrayList;

public final class e extends d {
    int aBO;
    AudioType audioType;
    String fnF;
    protected a fnH;
    long gKo;
    boolean hkB;
    int hkt;
    af jzN;
    int lJY;
    CommonPlayer oKD;
    private c oKE;
    boolean oKF;
    boolean oKG;
    a oKH;
    private IMediaHTTPService oKI;
    String oKJ;
    boolean oKK;
    private long oKL;
    boolean oKM;
    long oKN;
    private PlayerListenerCallback oKO;

    public e() {
        this.fnF = "";
        this.oKG = false;
        this.hkB = false;
        this.oKJ = "";
        this.aBO = 0;
        this.lJY = 0;
        this.hkt = 0;
        this.oKK = false;
        this.oKL = 0;
        this.audioType = AudioType.UNSUPPORT;
        this.oKM = false;
        this.oKN = 0;
        this.gKo = 0;
        this.oKO = new PlayerListenerCallback(this) {
            a oKP = null;
            final /* synthetic */ e oKQ;

            {
                this.oKQ = r2;
            }

            static /* synthetic */ void a(AnonymousClass1 anonymousClass1) {
                x.i("MicroMsg.Audio.QQAudioPlayer", "_onPrepared");
                anonymousClass1.oKP = anonymousClass1.oKQ.fnH;
                if (anonymousClass1.oKQ.hkB || anonymousClass1.oKQ.oKG) {
                    x.i("MicroMsg.Audio.QQAudioPlayer", "isPausedOnBackground or isForcePause is true, do stop player and not send event");
                    if (anonymousClass1.oKQ.oKD != null) {
                        anonymousClass1.oKQ.oKD.stop();
                    }
                    if (anonymousClass1.oKQ.oKG) {
                        anonymousClass1.oKQ.bdV();
                    }
                } else if (anonymousClass1.oKQ.hkt != 0) {
                    x.i("MicroMsg.Audio.QQAudioPlayer", "seek to startTime:%d", new Object[]{Integer.valueOf(anonymousClass1.oKQ.hkt)});
                    anonymousClass1.oKQ.if(anonymousClass1.oKQ.hkt);
                } else {
                    if (!(anonymousClass1.oKQ.oKD == null || anonymousClass1.oKQ.oKD.getCurrentAudioInformation() == null || anonymousClass1.oKQ.oKD.getCurrentAudioInformation().getAudioType() == null)) {
                        anonymousClass1.oKQ.audioType = anonymousClass1.oKQ.oKD.getCurrentAudioInformation().getAudioType();
                        if (anonymousClass1.oKQ.audioType != null) {
                            x.i("MicroMsg.Audio.QQAudioPlayer", "getAudioType:%d", new Object[]{Integer.valueOf(anonymousClass1.oKQ.audioType.getValue())});
                        }
                        e eVar = anonymousClass1.oKQ;
                        if (eVar.audioType != null) {
                            x.i("MicroMsg.Audio.QQAudioPlayer", "idKeyReportAudioMimeType audioType:%d, isStatMineType:%b", new Object[]{Integer.valueOf(eVar.audioType.getValue()), Boolean.valueOf(eVar.oKM)});
                            if (!eVar.oKM) {
                                x.i("MicroMsg.Audio.QQAudioPlayer", "idKeyReportAudioMimeType OK");
                                eVar.oKM = true;
                                IDKey iDKey = new IDKey();
                                iDKey.SetID(688);
                                int value = eVar.audioType.getValue();
                                value = value == 2 ? 42 : value == 3 ? 43 : value == 4 ? 44 : value == 5 ? 45 : value == 6 ? 46 : value == 7 ? 47 : value == 8 ? 48 : value == 9 ? 49 : 50;
                                iDKey.SetKey(value);
                                iDKey.SetValue(1);
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(iDKey);
                                g.pQN.a(arrayList, true);
                            }
                        }
                    }
                    anonymousClass1.oKQ.bdS();
                    if (anonymousClass1.oKQ.oKK) {
                        x.i("MicroMsg.Audio.QQAudioPlayer", "start to play");
                        try {
                            if (anonymousClass1.oKQ.oKD != null) {
                                anonymousClass1.oKQ.oKD.setVolume((float) anonymousClass1.oKQ.fnH.hky, (float) anonymousClass1.oKQ.fnH.hky);
                                anonymousClass1.oKQ.oKD.start();
                            }
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e, "_onPrepared", new Object[0]);
                            anonymousClass1.oKQ.ts(502);
                            anonymousClass1.oKQ.tt(502);
                        }
                        anonymousClass1.oKQ.oKF = true;
                        return;
                    }
                    x.i("MicroMsg.Audio.QQAudioPlayer", "autoplay is false, don't start auto play!");
                }
            }

            static /* synthetic */ void b(AnonymousClass1 anonymousClass1) {
                x.i("MicroMsg.Audio.QQAudioPlayer", "_onPreparing");
                anonymousClass1.oKP = anonymousClass1.oKQ.fnH;
                if (anonymousClass1.oKP == null) {
                    x.e("MicroMsg.Audio.QQAudioPlayer", "cbMusic is null");
                } else if (anonymousClass1.oKQ.hkB || anonymousClass1.oKQ.oKG) {
                    x.i("MicroMsg.Audio.QQAudioPlayer", "isPausedOnBackground or isForcePause is true, do stop player and not send event");
                } else {
                    d dVar = anonymousClass1.oKQ;
                    x.i("MicroMsg.Audio.BaseAudioPlayer", "onPreparintEvent %b", new Object[]{Boolean.valueOf(dVar.Qq())});
                    b tVar = new t();
                    tVar.fnK.action = 9;
                    tVar.fnK.state = "waiting";
                    tVar.fnK.fnF = dVar.bdR();
                    tVar.fnK.appId = dVar.getAppId();
                    com.tencent.mm.sdk.b.a.xef.a(tVar, Looper.getMainLooper());
                }
            }

            static /* synthetic */ void c(AnonymousClass1 anonymousClass1) {
                x.i("MicroMsg.Audio.QQAudioPlayer", "_onStart");
                anonymousClass1.oKP = anonymousClass1.oKQ.fnH;
                if (anonymousClass1.oKQ.hkB || anonymousClass1.oKQ.oKG) {
                    x.i("MicroMsg.Audio.QQAudioPlayer", "isPausedOnBackground or isForcePause is true, do stop player and not send event");
                    if (anonymousClass1.oKQ.oKD != null && anonymousClass1.oKQ.oKF) {
                        anonymousClass1.oKQ.oKF = false;
                        anonymousClass1.oKQ.oKD.stop();
                        return;
                    }
                    return;
                }
                anonymousClass1.oKQ.bdT();
                if (anonymousClass1.oKQ.oKH != null) {
                    anonymousClass1.oKQ.oKH.isStop = true;
                }
                anonymousClass1.oKQ.oKH = new a(anonymousClass1.oKQ, (byte) 0);
                Runnable runnable = anonymousClass1.oKQ.oKH;
                runnable.isStop = false;
                com.tencent.mm.sdk.f.e.post(runnable, "audio_play_progress_runnable");
            }

            static /* synthetic */ void d(AnonymousClass1 anonymousClass1) {
                x.i("MicroMsg.Audio.QQAudioPlayer", "_onPause");
                anonymousClass1.oKQ.bdV();
            }

            static /* synthetic */ void e(AnonymousClass1 anonymousClass1) {
                x.i("MicroMsg.Audio.QQAudioPlayer", "_onStop");
                if (anonymousClass1.oKP == null) {
                    x.e("MicroMsg.Audio.QQAudioPlayer", "currentMusic is null");
                    return;
                }
                anonymousClass1.oKQ.oKF = false;
                anonymousClass1.oKQ.gKo = System.currentTimeMillis();
                if (!anonymousClass1.oKQ.fnF.equalsIgnoreCase(anonymousClass1.oKP.fnF)) {
                    return;
                }
                if (anonymousClass1.oKQ.hkB) {
                    x.i("MicroMsg.Audio.QQAudioPlayer", "stop play, but send pause state event");
                    anonymousClass1.oKQ.bdV();
                    return;
                }
                anonymousClass1.oKQ.bdW();
            }

            static /* synthetic */ void f(AnonymousClass1 anonymousClass1) {
                x.i("MicroMsg.Audio.QQAudioPlayer", "_onCompletion");
                anonymousClass1.oKQ.bdY();
                if (anonymousClass1.oKQ.oKH != null) {
                    anonymousClass1.oKQ.oKH.isStop = true;
                    anonymousClass1.oKQ.oKH = null;
                }
                anonymousClass1.oKQ.gKo = System.currentTimeMillis();
                x.i("MicroMsg.Audio.QQAudioPlayer", "play end, isPausedOnBackground:%b, playParam.loop:%b, isStartPlaying:%b, ", new Object[]{Boolean.valueOf(anonymousClass1.oKQ.hkB), Boolean.valueOf(anonymousClass1.oKQ.fnH.hkw), Boolean.valueOf(anonymousClass1.oKQ.oKF)});
                if (anonymousClass1.oKQ.hkB) {
                    anonymousClass1.oKQ.oKF = false;
                    anonymousClass1.oKQ.hkt = 0;
                    anonymousClass1.oKQ.oKK = true;
                    x.i("MicroMsg.Audio.QQAudioPlayer", "isPausedOnBackground is true, do stop player and don't play again");
                } else if (anonymousClass1.oKQ.oKG) {
                    anonymousClass1.oKQ.oKF = false;
                    anonymousClass1.oKQ.hkt = 0;
                    anonymousClass1.oKQ.oKK = true;
                    x.i("MicroMsg.Audio.QQAudioPlayer", "isForcePause is true, do stop player and don't play again");
                } else if (anonymousClass1.oKQ.fnH.hkw && anonymousClass1.oKQ.oKF) {
                    x.i("MicroMsg.Audio.QQAudioPlayer", "play end normally and loop play again");
                    anonymousClass1.oKQ.oKF = false;
                    anonymousClass1.oKQ.hkt = 0;
                    anonymousClass1.oKQ.oKK = true;
                    anonymousClass1.oKQ.bea();
                } else {
                    x.i("MicroMsg.Audio.QQAudioPlayer", "play end, but not loop play");
                    anonymousClass1.oKQ.oKF = false;
                    anonymousClass1.oKQ.hkt = 0;
                    anonymousClass1.oKQ.oKK = true;
                }
            }

            public final void onBufferingUpdate(BaseMediaPlayer baseMediaPlayer, int i) {
            }

            public final void onCompletion(BaseMediaPlayer baseMediaPlayer) {
                x.i("MicroMsg.Audio.QQAudioPlayer", "onCompletion");
            }

            public final void onSeekComplete(BaseMediaPlayer baseMediaPlayer) {
                this.oKQ.jzN.post(new 1(this));
            }

            public final void onError(BaseMediaPlayer baseMediaPlayer, int i, int i2, int i3) {
                x.e("MicroMsg.Audio.QQAudioPlayer", "onError what:%d, extra:%d, errCode:%d, audioId:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), this.oKQ.fnF});
                if (this.oKP == null) {
                    x.e("MicroMsg.Audio.QQAudioPlayer", "onError, currentParam is null");
                    return;
                }
                boolean isNetworkConnected = an.isNetworkConnected(ac.getContext());
                if (i2 == 80 && isNetworkConnected) {
                    x.e("MicroMsg.Audio.QQAudioPlayer", "connect success, but download is fail!");
                }
                if (this.oKQ.aBO > 0) {
                    x.e("MicroMsg.Audio.QQAudioPlayer", "errorCount %d", new Object[]{Integer.valueOf(this.oKQ.aBO)});
                    return;
                }
                this.oKQ.oKF = false;
                e eVar = this.oKQ;
                eVar.aBO++;
                this.oKQ.lJY = i2;
                this.oKQ.gKo = System.currentTimeMillis();
                this.oKQ.tt(i2);
                if (this.oKQ.fnF.equalsIgnoreCase(this.oKP.fnF)) {
                    this.oKQ.stopPlay();
                    ag.y(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 oKR;

                        {
                            this.oKR = r1;
                        }

                        public final void run() {
                            ar.Hg();
                            if (((Boolean) com.tencent.mm.z.c.CU().get(w.a.xuy, Boolean.valueOf(false))).booleanValue()) {
                                Toast.makeText(ac.getContext(), ac.getContext().getString(R.l.ewQ), 0).show();
                            }
                        }
                    });
                }
                this.oKQ.ts(i2);
                if (this.oKQ.oKH != null) {
                    this.oKQ.oKH.isStop = true;
                    this.oKQ.oKH = null;
                }
                if (i == 91 && i2 == 55) {
                    x.i("MicroMsg.Audio.QQAudioPlayer", "unknow format ,delete file");
                    com.tencent.mm.plugin.music.model.b.e.deleteFile(this.oKQ.oKJ);
                }
            }

            public final void onPrepared(BaseMediaPlayer baseMediaPlayer) {
                x.i("MicroMsg.Audio.QQAudioPlayer", "onPrepared");
            }

            public final void onStateChanged(int i) {
                this.oKQ.jzN.post(new 3(this, i));
            }

            public final void onStarted(BaseMediaPlayer baseMediaPlayer) {
                x.i("MicroMsg.Audio.QQAudioPlayer", "onStarted");
            }
        };
        this.fnF = com.tencent.mm.ac.b.Jx();
        c.bdM();
        this.oKz = new aq();
        this.oKz.eV(ac.getContext());
        this.oKz.a(new 1(this));
        x.i("MicroMsg.Audio.QQAudioPlayer", "create QQAudioPlayer instance");
        this.jzN = new af(Looper.myLooper());
    }

    public final void Gg(String str) {
        x.i("MicroMsg.Audio.QQAudioPlayer", "setAudioId:%s", new Object[]{str});
        this.fnF = str;
    }

    public final void c(a aVar) {
        this.fnH = aVar;
        this.hkt = aVar.hkt;
        this.oKK = aVar.hkv;
        if (this.oKD != null && Qq()) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "audioId:%s, param.src:%s setVoume %f", new Object[]{this.fnF, this.oKJ, Double.valueOf(this.fnH.hky)});
            this.oKD.setVolume((float) this.fnH.hky, (float) this.fnH.hky);
        }
    }

    public final void d(a aVar) {
        if (aVar == null) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "startPlay fail, play param is null");
            bdZ();
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.oKL;
        if (this.fnH == null || !this.fnH.a(aVar) || j > 100) {
            f.tp(aVar.fromScene);
            this.oKL = currentTimeMillis;
            this.fnH = aVar;
            x.i("MicroMsg.Audio.QQAudioPlayer", "startPlay, currentTime:%d, fromScene:%d, audioId:%s", new Object[]{Long.valueOf(currentTimeMillis), Integer.valueOf(this.fnH.fromScene), this.fnF});
            if (this.oKD != null && Qq()) {
                this.oKD.stop();
            }
            this.aBO = 0;
            this.hkt = aVar.hkt;
            this.oKK = aVar.hkv;
            this.audioType = null;
            this.oKM = false;
            this.hkB = false;
            this.oKG = false;
            bea();
            return;
        }
        this.fnH = aVar;
        this.hkt = aVar.hkt;
        this.oKK = aVar.hkv;
        x.e("MicroMsg.Audio.QQAudioPlayer", "startPlay, is playing for audio src:%s, don't play again in 3 second, interval:%d", new Object[]{this.oKJ, Long.valueOf(j)});
    }

    private void bea() {
        int i = 1;
        x.i("MicroMsg.Audio.QQAudioPlayer", "initPlayer");
        if (!TextUtils.isEmpty(this.fnH.filePath) && this.fnH.hkz == null) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "play with local file, filePath:%s", new Object[]{this.fnH.filePath});
            if (this.oKD == null) {
                this.oKD = new CommonPlayer(this.oKO);
            }
            this.oKD.reset();
            try {
                this.oKD.setDataSource(this.fnH.filePath);
                this.oKD.prepare();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e, "initPlayer exception", new Object[0]);
                ts(HardCoderJNI.SCENE_DB);
                tt(HardCoderJNI.SCENE_DB);
            }
        } else if (TextUtils.isEmpty(this.fnH.filePath) || this.fnH.hkz == null) {
            boolean z;
            URL url;
            x.i("MicroMsg.Audio.QQAudioPlayer", "play with src url :%s", new Object[]{this.fnH.hks});
            this.oKJ = this.fnH.hks;
            if (com.tencent.mm.plugin.music.model.g.FM(this.oKJ)) {
                x.i("MicroMsg.Audio.QQAudioPlayer", "can match shake music wifi url");
                z = true;
            } else {
                z = false;
            }
            x.i("MicroMsg.Audio.QQAudioPlayer", "mSrc:%s", new Object[]{this.oKJ});
            String str = "MicroMsg.Audio.QQAudioPlayer";
            String str2 = "isqqmusic:%d";
            Object[] objArr = new Object[1];
            if (!z) {
                i = 0;
            }
            objArr[0] = Integer.valueOf(i);
            x.i(str, str2, objArr);
            com.tencent.mm.plugin.music.model.b.e.Gl(this.oKJ);
            com.tencent.mm.plugin.music.model.b.e.at(this.oKJ, z);
            try {
                url = new URL(this.oKJ);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e2, "initPlayer", new Object[0]);
                url = null;
            }
            if (url == null) {
                x.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer url is null");
                ts(500);
                tt(500);
                return;
            }
            if (this.oKD == null) {
                this.oKD = new CommonPlayer(this.oKO);
            }
            this.oKD.reset();
            if (this.oKI == null) {
                this.oKI = new d();
            }
            try {
                this.oKD.setDataSource(this.oKI, Uri.parse(url.toString()));
                this.oKD.prepare();
            } catch (Throwable e22) {
                x.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + e22.getMessage());
                x.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e22, "initPlayer", new Object[0]);
                ts(HardCoderJNI.SCENE_DB);
                tt(HardCoderJNI.SCENE_DB);
            }
        } else {
            x.i("MicroMsg.Audio.QQAudioPlayer", "play with inputStream, filePath:%s", new Object[]{this.fnH.filePath});
            if (this.oKD == null) {
                this.oKD = new CommonPlayer(this.oKO);
            }
            this.oKD.reset();
            try {
                this.oKD.setDataSource(new com.tencent.mm.plugin.music.model.f.b(this.fnH.hkz));
                this.oKD.prepare();
            } catch (Throwable e222) {
                x.e("MicroMsg.Audio.QQAudioPlayer", "initPlayer exception:" + e222.getMessage());
                x.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e222, "initPlayer", new Object[0]);
                ts(HardCoderJNI.SCENE_DB);
                tt(HardCoderJNI.SCENE_DB);
            }
        }
    }

    public final void pause() {
        x.i("MicroMsg.Audio.QQAudioPlayer", "pause, audioId:%s", new Object[]{this.fnF});
        this.oKG = true;
        if (this.oKD != null && Qq()) {
            try {
                x.i("MicroMsg.Audio.QQAudioPlayer", "pause success");
                this.oKD.pause();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e, "pause", new Object[0]);
                ts(503);
                tt(503);
            }
        } else if (this.oKD != null && isCompleted()) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "pause fail, play complete, set isStartPlaying false");
            this.oKF = false;
        }
    }

    public final void beb() {
        x.i("MicroMsg.Audio.QQAudioPlayer", "pauseAndAbandonFocus");
        pause();
    }

    public final void resume() {
        this.aBO = 0;
        boolean bec = bec();
        boolean Qq = Qq();
        this.oKG = false;
        x.i("MicroMsg.Audio.QQAudioPlayer", "resume, isPreparing:%b, isPlayingMusic:%b, isStartPlaying:%b, audioId:%s", new Object[]{Boolean.valueOf(bec), Boolean.valueOf(Qq), Boolean.valueOf(this.oKF), this.fnF});
        if (this.oKD != null && !isPrepared() && !bec && !Qq && !this.oKF) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "audio play is complete, need initPlayer again");
            this.hkt = 0;
            this.oKK = true;
            this.hkB = false;
            bea();
            f.tp(this.fnH.fromScene);
        } else if (this.oKD == null) {
        } else {
            if ((isPaused() || isPrepared()) && !Qq) {
                x.i("MicroMsg.Audio.QQAudioPlayer", "audio play is paused, need start to play");
                try {
                    this.oKD.setVolume((float) this.fnH.hky, (float) this.fnH.hky);
                    this.oKD.start();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e, "resume", new Object[0]);
                    ts(502);
                    tt(502);
                }
                this.oKF = true;
            }
        }
    }

    public final boolean Qq() {
        if (this.oKD == null || this.oKD.getPlayerState() != 4) {
            return false;
        }
        return true;
    }

    public final boolean bec() {
        if (this.oKD == null || this.oKD.getPlayerState() != 3) {
            return false;
        }
        return true;
    }

    public final boolean isPrepared() {
        if (this.oKD == null || this.oKD.getPlayerState() != 2) {
            return false;
        }
        return true;
    }

    public final boolean isPaused() {
        if (this.oKD == null || this.oKD.getPlayerState() != 5) {
            return false;
        }
        return true;
    }

    public final boolean isCompleted() {
        if (this.oKD == null || this.oKD.getPlayerState() != 7) {
            return false;
        }
        return true;
    }

    public final boolean isStopped() {
        if (this.oKD == null || this.oKD.getPlayerState() != 6) {
            return false;
        }
        return true;
    }

    public final boolean Qr() {
        return this.oKF && !bec();
    }

    public final void stopPlay() {
        x.i("MicroMsg.Audio.QQAudioPlayer", "stopPlay");
        this.hkB = false;
        bed();
    }

    final void bed() {
        try {
            if (this.oKD != null) {
                this.oKD.setVolume(0.0f, 0.0f);
                this.oKD.stop();
            }
            if (this.oKH != null) {
                this.oKH.isStop = true;
                this.oKH = null;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Audio.QQAudioPlayer", e, "stopPlay", new Object[0]);
            ts(504);
            tt(504);
        }
        this.oKF = false;
        this.oKG = true;
        this.gKo = System.currentTimeMillis();
    }

    public final int bee() {
        if (this.oKD != null) {
            return (int) this.oKD.getCurrentPosition();
        }
        return -1;
    }

    public final int getDuration() {
        if (this.oKD != null) {
            return this.oKD.getDuration();
        }
        return -1;
    }

    public final boolean if(int i) {
        int duration = getDuration();
        x.i("MicroMsg.Audio.QQAudioPlayer", "seekToMusic pos:%d, duration:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(duration)});
        if (duration < 0) {
            x.e("MicroMsg.Audio.QQAudioPlayer", "position is invalid, position:%d, duration:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(duration)});
            stopPlay();
            return false;
        } else if (i > duration) {
            x.e("MicroMsg.Audio.QQAudioPlayer", "position is invalid, position:%d, duration:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(duration)});
            return false;
        } else {
            if (this.oKD != null) {
                x.i("MicroMsg.Audio.BaseAudioPlayer", "onSeekingEvent");
                b tVar = new t();
                tVar.fnK.action = 10;
                tVar.fnK.state = "seeking";
                tVar.fnK.fnF = bdR();
                tVar.fnK.appId = getAppId();
                com.tencent.mm.sdk.b.a.xef.a(tVar, Looper.getMainLooper());
                this.oKD.seekTo(i);
            }
            return true;
        }
    }

    public final c bef() {
        int bufferedPercentage;
        boolean z = false;
        if (this.oKE == null) {
            this.oKE = new c();
        }
        int duration = getDuration();
        int bee = bee();
        boolean Qq = Qq();
        if (this.oKD != null) {
            bufferedPercentage = this.oKD.getBufferedPercentage();
        } else {
            bufferedPercentage = 0;
        }
        if (bufferedPercentage < 0 || bufferedPercentage > 100) {
            bufferedPercentage = 0;
        }
        if (bufferedPercentage < 0) {
            bufferedPercentage = 0;
        }
        this.oKE.fnG = bee;
        this.oKE.duration = duration;
        c cVar = this.oKE;
        if (!Qq) {
            z = true;
        }
        cVar.hkA = z;
        this.oKE.hkB = this.hkB;
        this.oKE.hkC = (bufferedPercentage * duration) / 100;
        if (this.fnH == null) {
            return null;
        }
        this.oKE.hkt = this.fnH.hku;
        this.oKE.hkD = this.fnH.hks;
        return this.oKE;
    }

    public final String bdR() {
        return this.fnF;
    }

    public final String getAppId() {
        if (this.fnH != null) {
            return this.fnH.appId;
        }
        return "";
    }

    private void tt(int i) {
        IDKey iDKey = new IDKey();
        iDKey.SetID(688);
        iDKey.SetKey(1);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(688);
        int i2 = this.fnH.fromScene;
        x.i("MicroMsg.PlayerErrorHandler", "getQQAudioPlayerErrSceneIdKey, scene:" + i2);
        switch (i2) {
        }
        iDKey2.SetKey(9);
        iDKey2.SetValue(1);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(688);
        x.i("MicroMsg.PlayerErrorHandler", "getQQAudioPlayerErrIdKey, errCode:" + i);
        switch (i) {
            case 53:
                i2 = 17;
                break;
            case 54:
                i2 = 18;
                break;
            case 55:
                i2 = 19;
                break;
            case 62:
                i2 = 20;
                break;
            case 63:
                i2 = 21;
                break;
            case 64:
                i2 = 22;
                break;
            case 66:
                i2 = 23;
                break;
            case 67:
                i2 = 24;
                break;
            case 69:
                i2 = 25;
                break;
            case 70:
                i2 = 36;
                break;
            case 74:
                i2 = 26;
                break;
            case 80:
                i2 = 27;
                break;
            case 101:
                i2 = 28;
                break;
            case 102:
                i2 = 29;
                break;
            case 500:
                i2 = 31;
                break;
            case HardCoderJNI.SCENE_DB /*501*/:
                i2 = 32;
                break;
            case 502:
                i2 = 33;
                break;
            case 503:
                i2 = 34;
                break;
            case 504:
                i2 = 35;
                break;
            default:
                i2 = 30;
                break;
        }
        iDKey3.SetKey(i2);
        iDKey3.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        arrayList.add(iDKey3);
        g.pQN.a(arrayList, true);
    }

    public final void release() {
        x.i("MicroMsg.Audio.QQAudioPlayer", "release");
        this.oKv = null;
        if (this.oKD != null) {
            this.oKD.release();
            this.oKD = null;
        }
        if (this.oKz != null) {
            this.oKz.end();
            this.oKz.cfS();
        }
    }

    public final void beg() {
        if (this.fnF.equalsIgnoreCase(this.fnH.fnF) && this.oKD != null && Qq()) {
            int currentPosition = (int) this.oKD.getCurrentPosition();
            int duration = this.oKD.getDuration();
            if (currentPosition > 0 && duration > 0 && this.oKB != null) {
                this.oKB.cj(currentPosition, duration);
            }
        }
    }

    public final boolean bdP() {
        return true;
    }
}
