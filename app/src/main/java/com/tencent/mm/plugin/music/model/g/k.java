package com.tencent.mm.plugin.music.model.g;

import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.R;
import com.tencent.mm.av.d;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetClipboardData;
import com.tencent.mm.plugin.appbrand.jsapi.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.appbrand.jsapi.share.i;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiOperateGameCenterMsg;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.af;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.au;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.n;
import com.tencent.mm.plugin.music.model.a.c;
import com.tencent.mm.plugin.music.model.b.e;
import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.BaseMediaPlayer;
import com.tencent.qqmusic.mediaplayer.CommonPlayer;
import com.tencent.qqmusic.mediaplayer.PlayerListenerCallback;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService;
import java.net.URL;
import java.util.ArrayList;

public final class k extends a {
    int aBO = 0;
    AudioType audioType = AudioType.UNSUPPORT;
    protected com.tencent.mm.av.a fAA;
    int hkt = 0;
    public CommonPlayer oKD;
    boolean oKF;
    private IMediaHTTPService oKI;
    String oKJ = "";
    private long oKL = 0;
    private boolean oKM = false;
    private PlayerListenerCallback oKO = new PlayerListenerCallback(this) {
        com.tencent.mm.av.a oMO = null;
        final /* synthetic */ k oMP;

        {
            this.oMP = r2;
        }

        public final void onBufferingUpdate(BaseMediaPlayer baseMediaPlayer, int i) {
        }

        public final void onCompletion(BaseMediaPlayer baseMediaPlayer) {
            x.i("MicroMsg.Music.QQMusicPlayer", "onCompletion");
        }

        public final void onSeekComplete(BaseMediaPlayer baseMediaPlayer) {
            x.i("MicroMsg.Music.QQMusicPlayer", "onSeekComplete");
            if (this.oMP.hkt != 0) {
                x.i("MicroMsg.Music.QQMusicPlayer", "seek complete to startTime :%d", new Object[]{Integer.valueOf(this.oMP.hkt)});
                this.oMP.hkt = 0;
                beE();
                return;
            }
            x.i("MicroMsg.Music.QQMusicPlayer", "_onSeekComplete");
            if (this.oMO == null) {
                x.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                return;
            }
            asv Qn = this.oMO.Qn();
            this.oMP.t(Qn);
            if (this.oMP.Qq()) {
                x.i("MicroMsg.Music.QQMusicPlayer", "seek end, send play event!");
                this.oMP.q(Qn);
            }
        }

        public final void onError(BaseMediaPlayer baseMediaPlayer, int i, int i2, int i3) {
            x.e("MicroMsg.Music.QQMusicPlayer", "onError what:%d, extra:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            com.tencent.mm.av.a bdo = h.bdz().bdo();
            if (bdo == null) {
                x.e("MicroMsg.Music.QQMusicPlayer", "onError, currentMusic is null");
                return;
            }
            this.oMO = this.oMP.fAA;
            if (this.oMO == null) {
                x.e("MicroMsg.Music.QQMusicPlayer", "onError, cbMusic is null");
                return;
            }
            boolean isNetworkConnected = an.isNetworkConnected(ac.getContext());
            if (i2 == 80 && isNetworkConnected) {
                x.e("MicroMsg.Music.QQMusicPlayer", "connect success, but download is fail!");
            }
            if (this.oMP.aBO > 0) {
                x.e("MicroMsg.Music.QQMusicPlayer", "errorCount %d", new Object[]{Integer.valueOf(this.oMP.aBO)});
                return;
            }
            k kVar = this.oMP;
            kVar.aBO++;
            this.oMP.a(this.oMO, i2);
            asv Qn = this.oMO.Qn();
            if (bdo.a(this.oMO)) {
                this.oMP.stopPlay();
                ag.y(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 oMQ;

                    {
                        this.oMQ = r1;
                    }

                    public final void run() {
                        Toast.makeText(ac.getContext(), ac.getContext().getString(R.l.ewQ), 0).show();
                    }
                });
            }
            this.oMP.s(Qn);
            this.oMP.a(Qn, i2);
            if (this.oMP.oMN != null) {
                this.oMP.oMN.isStop = true;
                this.oMP.oMN = null;
            }
            if (i == 91 && i2 == 55) {
                x.i("MicroMsg.Music.QQMusicPlayer", "unknow format ,delete file");
                e.deleteFile(this.oMP.oKJ);
            }
        }

        public final void onPrepared(BaseMediaPlayer baseMediaPlayer) {
            x.i("MicroMsg.Music.QQMusicPlayer", "onPrepared");
        }

        public final void onStateChanged(int i) {
            x.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged state %d", new Object[]{Integer.valueOf(i)});
            if (i == 3) {
                x.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PREPARING!");
                x.i("MicroMsg.Music.QQMusicPlayer", "_onPreparing");
                this.oMO = this.oMP.fAA;
                if (this.oMO == null) {
                    x.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                    return;
                }
                this.oMP.n(this.oMO.Qn());
            } else if (i == 2) {
                x.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PREPARED!");
                beE();
            } else if (i == 4) {
                x.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged STARTED!");
                x.i("MicroMsg.Music.QQMusicPlayer", "_onStart");
                this.oMO = this.oMP.fAA;
                if (this.oMO == null) {
                    x.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                    return;
                }
                this.oMP.p(this.oMO.Qn());
                if (this.oMP.oMN != null) {
                    this.oMP.oMN.isStop = true;
                }
                this.oMP.oMN = new a();
                Runnable runnable = this.oMP.oMN;
                runnable.isStop = false;
                com.tencent.mm.sdk.f.e.post(runnable, "music_play_progress_runnable");
            } else if (i == 5) {
                x.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PAUSED!");
                x.i("MicroMsg.Music.QQMusicPlayer", "_onPause");
                if (this.oMO == null) {
                    x.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                    return;
                }
                this.oMP.r(this.oMO.Qn());
            } else if (i == 6) {
                x.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged STOPPED!");
                x.i("MicroMsg.Music.QQMusicPlayer", "_onStop");
                if (this.oMO == null) {
                    x.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                } else if (h.bdz().bdo() == null) {
                    x.e("MicroMsg.Music.QQMusicPlayer", "currentMusic is null");
                } else if (this.oMP.fAA.a(this.oMO)) {
                    this.oMP.s(this.oMP.fAA.Qn());
                }
            } else if (i == 7) {
                x.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged PLAYBACKCOMPLETED!");
                x.i("MicroMsg.Music.QQMusicPlayer", "_onCompletion");
                if (this.oMO == null) {
                    x.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
                    return;
                }
                this.oMP.oKF = false;
                this.oMP.v(this.oMO.Qn());
                if (this.oMP.oMN != null) {
                    this.oMP.oMN.isStop = true;
                    this.oMP.oMN = null;
                }
            } else if (i == 8) {
                x.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged END!");
                x.i("MicroMsg.Music.QQMusicPlayer", "_onEnd");
            } else if (i == 9) {
                x.i("MicroMsg.Music.QQMusicPlayer", "onStateChanged ERROR!");
            }
        }

        public final void onStarted(BaseMediaPlayer baseMediaPlayer) {
            x.i("MicroMsg.Music.QQMusicPlayer", "onStarted");
        }

        private void beE() {
            x.i("MicroMsg.Music.QQMusicPlayer", "_onPrepared");
            if (this.oMP.hkt != 0) {
                x.i("MicroMsg.Music.QQMusicPlayer", "seek to startTime:%d", new Object[]{Integer.valueOf(this.oMP.hkt)});
                this.oMP.if(this.oMP.hkt);
                return;
            }
            x.i("MicroMsg.Music.QQMusicPlayer", "start to play");
            if (!h.bdC().requestFocus()) {
                x.e("MicroMsg.Music.QQMusicPlayer", "request focus error");
            } else if (this.oMP.fAA == null) {
                x.e("MicroMsg.Music.QQMusicPlayer", "cbMusic is null");
            } else {
                this.oMP.o(this.oMP.fAA.Qn());
                try {
                    if (this.oMP.oKD != null) {
                        this.oMP.oKD.start();
                        if (!(this.oMP.oKD.getCurrentAudioInformation() == null || this.oMP.oKD.getCurrentAudioInformation().getAudioType() == null)) {
                            x.i("MicroMsg.Music.QQMusicPlayer", "getAudioType:%d", new Object[]{Integer.valueOf(this.oMP.oKD.getCurrentAudioInformation().getAudioType().getValue())});
                            this.oMP.audioType = this.oMP.oKD.getCurrentAudioInformation().getAudioType();
                            k.a(this.oMP);
                        }
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e, "_onPrepared", new Object[0]);
                    this.oMP.a(this.oMP.fAA.Qn(), 502);
                    this.oMP.a(this.oMP.fAA, 502);
                }
                this.oMP.oKF = true;
            }
        }
    };
    public boolean oLI = false;
    private d oLv;
    a oMN;

    private class a implements Runnable {
        boolean isStop;
        final /* synthetic */ k oMP;

        private a(k kVar) {
            this.oMP = kVar;
            this.isStop = true;
        }

        public final void run() {
            x.i("MicroMsg.Music.QQMusicPlayer", "start run play progress task");
            while (!this.isStop) {
                try {
                    if (this.oMP.oKD != null && this.oMP.Qq()) {
                        this.oMP.beg();
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.Music.QQMusicPlayer", "PlayProgressTask run exception:" + e.getMessage());
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e2) {
                }
            }
        }
    }

    static /* synthetic */ void a(k kVar) {
        if (kVar.audioType != null) {
            x.i("MicroMsg.Music.QQMusicPlayer", "idKeyReportMusicMimeType audioType:%d, isStatMineType:%b", new Object[]{Integer.valueOf(kVar.audioType.getValue()), Boolean.valueOf(kVar.oKM)});
            if (!kVar.oKM) {
                x.i("MicroMsg.Music.QQMusicPlayer", "idKeyReportMusicMimeType OK");
                kVar.oKM = true;
                IDKey iDKey = new IDKey();
                iDKey.SetID(558);
                int value = kVar.audioType.getValue();
                value = value == 2 ? 92 : value == 3 ? 93 : value == 4 ? 94 : value == 5 ? 95 : value == 6 ? 96 : value == 7 ? 97 : value == 8 ? 98 : value == 9 ? 99 : 100;
                iDKey.SetKey(value);
                iDKey.SetValue(1);
                ArrayList arrayList = new ArrayList();
                arrayList.add(iDKey);
                g.pQN.a(arrayList, true);
                Object Go = e.Go(kVar.oKJ);
                x.i("MicroMsg.Music.QQMusicPlayer", "mineTypeStr:%s", new Object[]{Go});
                if (kVar.fAA == null || TextUtils.isEmpty(Go)) {
                    x.e("MicroMsg.Music.QQMusicPlayer", "music is null or mineTypeStr is empty");
                    return;
                }
                int Gw = h.Gw(Go);
                g.pQN.h(14486, new Object[]{Integer.valueOf(1), Integer.valueOf(kVar.fAA.field_musicType), Integer.valueOf(Gw), Go});
            }
        }
    }

    public k() {
        bew();
        c.bdM();
    }

    public final void j(com.tencent.mm.av.a aVar) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.oKL;
        if (this.fAA != null && this.fAA.a(aVar) && j <= 3000) {
            this.fAA = aVar;
            x.e("MicroMsg.Music.QQMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", new Object[]{this.oKJ, Long.valueOf(j)});
        } else if (aVar == null) {
            x.e("MicroMsg.Music.QQMusicPlayer", "music is null");
        } else {
            URL url;
            f.a(aVar, false);
            this.oKL = currentTimeMillis;
            this.fAA = aVar;
            x.i("MicroMsg.Music.QQMusicPlayer", "startPlay, currentTime:%d, startTime:%d", new Object[]{Long.valueOf(currentTimeMillis), Integer.valueOf(aVar.field_startTime)});
            if (this.oKD != null && Qq()) {
                this.oKD.stop();
            }
            this.aBO = 0;
            this.hkt = aVar.field_startTime;
            this.audioType = null;
            this.oKM = false;
            x.i("MicroMsg.Music.QQMusicPlayer", "initPlayer");
            this.oKJ = this.fAA.hHQ;
            x.i("MicroMsg.Music.QQMusicPlayer", "mSrc:%s", new Object[]{this.oKJ});
            x.i("MicroMsg.Music.QQMusicPlayer", "field_songWifiUrl:%s", new Object[]{this.fAA.field_songWifiUrl});
            if (this.oKJ != null) {
                e.Gl(this.oKJ);
                e.bJ(this.oKJ, 0);
                e.bK(this.oKJ, 0);
            }
            try {
                url = new URL(this.oKJ);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e, "initPlayer", new Object[0]);
                x.e("MicroMsg.Music.QQMusicPlayer", "new URL exception:" + e.getMessage());
                url = null;
            }
            if (url == null) {
                x.e("MicroMsg.Music.QQMusicPlayer", "initPlayer url is null");
                a(this.fAA.Qn(), 500);
                a(this.fAA, 500);
                return;
            }
            if (this.oKD == null) {
                this.oKD = new CommonPlayer(this.oKO);
            }
            this.oKD.reset();
            if (this.oKI == null) {
                this.oKI = new com.tencent.mm.plugin.music.model.f.d();
            }
            try {
                this.oKD.setDataSource(this.oKI, Uri.parse(url.toString()));
                this.oKD.prepare();
            } catch (Throwable e2) {
                x.e("MicroMsg.Music.QQMusicPlayer", "initPlayer exception:" + e2.getMessage());
                x.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e2, "initPlayer", new Object[0]);
                a(this.fAA.Qn(), HardCoderJNI.SCENE_DB);
                a(this.fAA, HardCoderJNI.SCENE_DB);
            }
        }
    }

    public final void pause() {
        this.oLI = false;
        x.i("MicroMsg.Music.QQMusicPlayer", "pause");
        if (this.oKD != null && Qq()) {
            try {
                this.oKD.pause();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e, "pause", new Object[0]);
                a(this.fAA.Qn(), 503);
                a(this.fAA, 503);
            }
        }
    }

    public final void beb() {
        x.i("MicroMsg.Music.QQMusicPlayer", "pauseAndAbandonFocus");
        pause();
        h.bdC().bdl();
    }

    public final boolean bdO() {
        return this.oKF && this.oLI;
    }

    public final void bdN() {
        this.oLI = true;
        x.i("MicroMsg.Music.QQMusicPlayer", "passivePause");
        if (this.oKD != null && Qq()) {
            try {
                this.oKD.pause();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e, "passivePause", new Object[0]);
                a(this.fAA.Qn(), 503);
                a(this.fAA, 503);
            }
        }
    }

    public final void resume() {
        this.aBO = 0;
        x.i("MicroMsg.Music.QQMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b", new Object[]{Boolean.valueOf(bec()), Boolean.valueOf(Qq())});
        if (this.oKD != null && !r0 && !r1) {
            if (h.bdC().requestFocus()) {
                try {
                    this.oKD.start();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e, "resume", new Object[0]);
                    a(this.fAA.Qn(), 502);
                    a(this.fAA, 502);
                }
                q(h.bdz().bdp());
            } else {
                x.e("MicroMsg.Music.QQMusicPlayer", "request focus error");
            }
            this.oKF = true;
        }
    }

    public final boolean Qq() {
        if (this.oKD == null || this.oKD.getPlayerState() != 4) {
            return false;
        }
        return true;
    }

    private boolean bec() {
        if (this.oKD == null || this.oKD.getPlayerState() != 3) {
            return false;
        }
        return true;
    }

    public final boolean Qr() {
        return this.oKF && !bec();
    }

    public final void stopPlay() {
        x.i("MicroMsg.Music.QQMusicPlayer", "stopPlay");
        try {
            if (this.oKD != null) {
                this.oKD.stop();
            }
            if (this.oMN != null) {
                this.oMN.isStop = true;
                this.oMN = null;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.QQMusicPlayer", e, "stopPlay", new Object[0]);
            a(this.fAA.Qn(), 504);
            a(this.fAA, 504);
        }
        h.bdC().bdl();
        this.oKF = false;
        this.oLI = false;
    }

    public final int getDuration() {
        if (this.oKD != null) {
            return this.oKD.getDuration();
        }
        return -1;
    }

    public final boolean if(int i) {
        int duration = getDuration();
        x.i("MicroMsg.Music.QQMusicPlayer", "seekToMusic pos:%d, duration:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(duration)});
        if (duration < 0 || i > duration) {
            x.e("MicroMsg.Music.QQMusicPlayer", "position is invalid, position:%d, duration:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(duration)});
            stopPlay();
            return false;
        } else if (this.oKD == null) {
            return true;
        } else {
            u(this.fAA.Qn());
            this.oKD.seekTo(i);
            return true;
        }
    }

    public final d bdQ() {
        int bufferedPercentage;
        int i = 0;
        int duration = getDuration();
        int currentPosition = this.oKD != null ? (int) this.oKD.getCurrentPosition() : -1;
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
        if (this.oLv != null) {
            d dVar = this.oLv;
            if (Qq) {
                i = 1;
            }
            dVar.i(duration, currentPosition, i, bufferedPercentage);
        } else {
            if (Qq) {
                i = 1;
            }
            this.oLv = new d(duration, currentPosition, i, bufferedPercentage);
        }
        this.oLv.fAB = true;
        this.oLv.hHY = this.oMe;
        return this.oLv;
    }

    private void a(com.tencent.mm.av.a aVar, int i) {
        int i2;
        int Gs;
        IDKey iDKey = new IDKey();
        iDKey.SetID(558);
        iDKey.SetKey(4);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(558);
        int i3 = aVar.field_musicType;
        x.i("MicroMsg.PlayerErrorHandler", "getQQMusicPlayerErrIdKeyByMusicType, musicType:" + i3);
        switch (i3) {
            case 0:
                i3 = 49;
                break;
            case 1:
                i3 = 50;
                break;
            case 4:
                i3 = 51;
                break;
            case 5:
                i3 = 52;
                break;
            case 6:
                i3 = 53;
                break;
            case 7:
                i3 = 54;
                break;
            case 8:
                i3 = 55;
                break;
            case 9:
                i3 = 56;
                break;
            case 10:
                i3 = 7;
                break;
            case 11:
                i3 = 8;
                break;
            default:
                i3 = 9;
                break;
        }
        iDKey2.SetKey(i3);
        iDKey2.SetValue(1);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(558);
        iDKey3.SetKey(h.tK(i));
        iDKey3.SetValue(1);
        IDKey iDKey4 = new IDKey();
        iDKey4.SetID(558);
        iDKey4.SetValue(1);
        ArrayList arrayList = new ArrayList();
        if (i == 80) {
            i3 = aVar.field_musicType;
            x.i("MicroMsg.PlayerErrorHandler", "getQQMusicPlayerNetworkErrIdKeyByMusicType, musicType:" + i3);
            switch (i3) {
                case 0:
                    i3 = 167;
                    break;
                case 1:
                    i3 = JsApiSetClipboardData.CTRL_INDEX;
                    break;
                case 4:
                    i3 = y.CTRL_INDEX;
                    break;
                case 6:
                    i3 = 170;
                    break;
                case 7:
                    i3 = 171;
                    break;
                case 8:
                    i3 = 172;
                    break;
                case 9:
                    i3 = af.CTRL_BYTE;
                    break;
                case 10:
                    i3 = GameJsApiOperateGameCenterMsg.CTRL_BYTE;
                    break;
                case 11:
                    i3 = com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac.CTRL_BYTE;
                    break;
                default:
                    i3 = n.CTRL_BYTE;
                    break;
            }
            iDKey4.SetKey(i3);
            arrayList.add(iDKey4);
            i2 = 1;
            Gs = e.Gs(this.oKJ);
            i3 = e.Gt(this.oKJ);
            if (e.Gs(this.oKJ) == ap.CTRL_INDEX) {
                IDKey iDKey5 = new IDKey();
                iDKey5.SetID(558);
                iDKey5.SetValue(1);
                iDKey5.SetKey(h.tK(700));
                arrayList.add(iDKey5);
            }
        } else if (e.Go(this.oKJ) == null || !e.Go(this.oKJ).contains("text/html")) {
            if (i != 70) {
                Object obj;
                switch (i) {
                    case 62:
                    case 63:
                    case 64:
                    case 67:
                    case 74:
                        obj = 1;
                        break;
                    default:
                        obj = null;
                        break;
                }
                if (obj != null) {
                    IDKey iDKey6 = new IDKey();
                    iDKey6.SetID(558);
                    iDKey6.SetValue(1);
                    i3 = aVar.field_musicType;
                    x.i("MicroMsg.PlayerErrorHandler", "getQQMusicPlayerDecodeErrIdKeyByMusicType, musicType:" + i3);
                    switch (i3) {
                        case 0:
                            i3 = 202;
                            break;
                        case 1:
                            i3 = 203;
                            break;
                        case 4:
                            i3 = com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX;
                            break;
                        case 6:
                            i3 = com.tencent.mm.plugin.appbrand.jsapi.a.g.CTRL_INDEX;
                            break;
                        case 7:
                            i3 = b.CTRL_INDEX;
                            break;
                        case 8:
                            i3 = 207;
                            break;
                        case 9:
                            i3 = com.tencent.mm.plugin.appbrand.jsapi.a.f.CTRL_INDEX;
                            break;
                        case 10:
                            i3 = com.tencent.mm.plugin.appbrand.jsapi.a.c.CTRL_INDEX;
                            break;
                        case 11:
                            i3 = i.CTRL_INDEX;
                            break;
                        default:
                            i3 = n.CTRL_BYTE;
                            break;
                    }
                    iDKey6.SetKey(i3);
                    arrayList.add(iDKey6);
                }
                i3 = aVar.field_musicType;
                x.i("MicroMsg.PlayerErrorHandler", "getQQMusicPlayerPlayErrIdKeyByMusicType, musicType:" + i3);
                switch (i3) {
                    case 0:
                        i3 = 178;
                        break;
                    case 1:
                        i3 = 179;
                        break;
                    case 4:
                        i3 = 180;
                        break;
                    case 6:
                        i3 = 181;
                        break;
                    case 7:
                        i3 = au.CTRL_BYTE;
                        break;
                    case 8:
                        i3 = 183;
                        break;
                    case 9:
                        i3 = 184;
                        break;
                    case 10:
                        i3 = 185;
                        break;
                    case 11:
                        i3 = 186;
                        break;
                    default:
                        i3 = n.CTRL_BYTE;
                        break;
                }
                iDKey4.SetKey(i3);
                arrayList.add(iDKey4);
            }
            i3 = 0;
            Gs = 0;
            i2 = 0;
        } else {
            IDKey iDKey7 = new IDKey();
            iDKey7.SetID(558);
            iDKey7.SetValue(1);
            iDKey7.SetKey(h.tK(701));
            arrayList.add(iDKey7);
            i2 = 0;
            i3 = 0;
            Gs = 701;
        }
        g.pQN.h(14777, new Object[]{Integer.valueOf(1), Integer.valueOf(this.fAA.field_musicType), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(Gs), Integer.valueOf(i3)});
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        arrayList.add(iDKey3);
        g.pQN.a(arrayList, true);
    }

    public final void beg() {
        com.tencent.mm.av.a bdo = h.bdz().bdo();
        if (bdo != null && bdo.a(this.fAA) && this.oKD != null && Qq()) {
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
