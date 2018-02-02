package com.tencent.mm.plugin.music.model.g;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.av.d;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.n;
import com.tencent.mm.plugin.music.model.c.a;
import com.tencent.mm.plugin.music.model.c.a$b;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class f extends a {
    boolean oKF;
    public boolean oLI = false;
    public boolean oMA = false;
    public boolean oMB = false;
    public boolean oMC = false;
    public int oMD = 0;
    private d oME;
    public a$b oMF = new 2(this);
    b oMr;
    public a oMs;
    boolean oMt;
    public boolean oMu = false;
    public boolean oMv = false;
    public boolean oMw = false;
    public boolean oMx = false;
    public boolean oMy = false;
    public boolean oMz = false;

    static /* synthetic */ void a(f fVar, com.tencent.mm.av.a aVar, int i) {
        if (aVar == null) {
            x.e("MicroMsg.Music.MusicPlayer", "currentMusic is null, don't idKeyReportMusicError");
            return;
        }
        x.i("MicroMsg.Music.MusicPlayer", "idKeyReportMusicError, action:%d", new Object[]{Integer.valueOf(i)});
        IDKey iDKey = new IDKey();
        iDKey.SetID(558);
        iDKey.SetKey(3);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(558);
        int i2 = aVar.field_musicType;
        x.i("MicroMsg.PlayerErrorHandler", "getMusicPlayerErrIdKeyByMusicType, musicType:" + i2);
        switch (i2) {
            case 0:
                i2 = 60;
                break;
            case 1:
                i2 = 61;
                break;
            case 4:
                i2 = 62;
                break;
            case 5:
                i2 = 63;
                break;
            case 6:
                i2 = 64;
                break;
            case 7:
                i2 = 5;
                break;
            case 8:
                i2 = 65;
                break;
            case 9:
                i2 = 66;
                break;
            default:
                i2 = 6;
                break;
        }
        iDKey2.SetKey(i2);
        iDKey2.SetValue(1);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(558);
        if (i == -1) {
            iDKey3.SetKey(12);
        } else if (i == 6) {
            iDKey3.SetKey(46);
        } else if (i == -2) {
            iDKey3.SetKey(13);
        } else if (i == 5) {
            iDKey3.SetKey(16);
        } else if (i == 4) {
            iDKey3.SetKey(14);
        } else if (i == 20) {
            iDKey3.SetKey(11);
        } else if (i == 21) {
            iDKey3.SetKey(47);
        } else if (i == 19) {
            iDKey3.SetKey(190);
        }
        iDKey3.SetValue(1);
        ArrayList arrayList = new ArrayList();
        IDKey iDKey4 = new IDKey();
        iDKey4.SetID(558);
        iDKey4.SetValue(1);
        if (i != 19 && (fVar.getMimeType() == null || !fVar.getMimeType().contains("text/html"))) {
            if (i == 21) {
                i2 = aVar.field_musicType;
                x.i("MicroMsg.PlayerErrorHandler", "getMusicPlayerPlayErrIdKeyByMusicType, musicType:" + i2);
                switch (i2) {
                    case 0:
                        i2 = JsApiGetBackgroundAudioState.CTRL_INDEX;
                        break;
                    case 1:
                        i2 = JsApiSetBackgroundAudioState.CTRL_INDEX;
                        break;
                    case 4:
                        i2 = JsApiOperateBackgroundAudio.CTRL_INDEX;
                        break;
                    case 6:
                        i2 = 162;
                        break;
                    case 7:
                        i2 = 163;
                        break;
                    case 8:
                        i2 = 164;
                        break;
                    case 9:
                        i2 = 165;
                        break;
                    default:
                        i2 = n.CTRL_BYTE;
                        break;
                }
                iDKey4.SetKey(i2);
                arrayList.add(iDKey4);
            } else if (i == -1 || i == 6 || i == -2 || i == 5 || i == 4) {
                i2 = aVar.field_musicType;
                x.i("MicroMsg.PlayerErrorHandler", "getMusicPlayerNetworkErrIdKeyByMusicType, musicType:" + i2);
                switch (i2) {
                    case 0:
                        i2 = 151;
                        break;
                    case 1:
                        i2 = com.tencent.mm.plugin.appbrand.jsapi.contact.d.CTRL_INDEX;
                        break;
                    case 4:
                        i2 = 153;
                        break;
                    case 6:
                        i2 = JsApiMakeVoIPCall.CTRL_INDEX;
                        break;
                    case 7:
                        i2 = 155;
                        break;
                    case 8:
                        i2 = 156;
                        break;
                    case 9:
                        i2 = 157;
                        break;
                    default:
                        i2 = n.CTRL_BYTE;
                        break;
                }
                iDKey4.SetKey(i2);
                arrayList.add(iDKey4);
            }
        }
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        arrayList.add(iDKey3);
        x.i("MicroMsg.Music.MusicPlayer", "hasStatForHttpErr:%b, hasStatForUrlErr:%b, hasStatForNetworkErr:%b, hasStatForHttpRangeErr:%b, hasStatDownloadExceptionErr:%b", new Object[]{Boolean.valueOf(fVar.oMu), Boolean.valueOf(fVar.oMw), Boolean.valueOf(fVar.oMz), Boolean.valueOf(fVar.oMv), Boolean.valueOf(fVar.oMx)});
        if (i == -1 && !fVar.oMu) {
            fVar.oMu = true;
            i2 = 0;
            if (fVar.oMs != null) {
                i2 = fVar.oMs.oLr;
            }
            if (i2 == ap.CTRL_INDEX) {
                iDKey = new IDKey();
                iDKey.SetID(558);
                iDKey.SetValue(1);
                iDKey.SetKey(h.tL(700));
                arrayList.add(iDKey);
            }
            g.pQN.a(arrayList, true);
            g.pQN.h(14777, new Object[]{Integer.valueOf(0), Integer.valueOf(aVar.field_musicType), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0)});
        }
        if (i == 6 && !fVar.oMv) {
            fVar.oMv = true;
            g.pQN.a(arrayList, true);
            g.pQN.h(14777, new Object[]{Integer.valueOf(0), Integer.valueOf(aVar.field_musicType), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0)});
        }
        if (i == -2 && !fVar.oMw) {
            fVar.oMw = true;
            g.pQN.a(arrayList, true);
            g.pQN.h(14777, new Object[]{Integer.valueOf(0), Integer.valueOf(aVar.field_musicType), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0)});
        }
        if (i == 5 && !fVar.oMx) {
            fVar.oMx = true;
            g.pQN.a(arrayList, true);
            i2 = 0;
            if (fVar.oMs != null) {
                i2 = fVar.oMs.hey;
            }
            g.pQN.h(14777, new Object[]{Integer.valueOf(0), Integer.valueOf(aVar.field_musicType), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2)});
        }
        if (i == 19 && !fVar.oMy) {
            fVar.oMy = true;
            g.pQN.a(arrayList, true);
            g.pQN.h(14777, new Object[]{Integer.valueOf(0), Integer.valueOf(aVar.field_musicType), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0)});
        }
        if (i == 4 && !fVar.oMz) {
            fVar.oMz = true;
            g.pQN.a(arrayList, true);
            g.pQN.h(14777, new Object[]{Integer.valueOf(0), Integer.valueOf(aVar.field_musicType), Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0)});
        }
        if (i == 20 && !fVar.oMA) {
            fVar.oMA = true;
            if (fVar.oMr != null && (fVar.oMr instanceof e)) {
                fVar.oMD = ((e) fVar.oMr).hey;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(iDKey3);
            g.pQN.a(arrayList2, true);
        }
        if (i == 21 && !fVar.oMB && fVar.oMA) {
            fVar.oMB = true;
            if (fVar.getMimeType() == null || !fVar.getMimeType().contains("text/html")) {
                Object obj;
                int i3 = fVar.oMD;
                IDKey iDKey5 = new IDKey();
                iDKey5.SetID(558);
                iDKey5.SetValue(1);
                iDKey5.SetKey(h.tL(i3));
                arrayList.add(iDKey5);
                switch (fVar.oMD) {
                    case 704:
                    case 705:
                    case 706:
                        obj = 1;
                        break;
                    default:
                        obj = null;
                        break;
                }
                if (obj != null) {
                    iDKey2 = new IDKey();
                    iDKey2.SetID(558);
                    iDKey2.SetValue(1);
                    i2 = aVar.field_musicType;
                    x.i("MicroMsg.PlayerErrorHandler", "getMusicPlayerDecodeErrIdKeyByMusicType, musicType:" + i2);
                    switch (i2) {
                        case 0:
                            i2 = JsApiUploadEncryptedFileToCDN.CTRL_INDEX;
                            break;
                        case 1:
                            i2 = JsApiChooseWeChatContact.CTRL_INDEX;
                            break;
                        case 4:
                            i2 = 196;
                            break;
                        case 6:
                            i2 = 197;
                            break;
                        case 7:
                            i2 = bc.CTRL_INDEX;
                            break;
                        case 8:
                            i2 = 199;
                            break;
                        case 9:
                            i2 = 200;
                            break;
                        default:
                            i2 = n.CTRL_BYTE;
                            break;
                    }
                    iDKey2.SetKey(i2);
                    arrayList.add(iDKey2);
                }
                i2 = i3;
            } else {
                i2 = 701;
                iDKey = new IDKey();
                iDKey.SetID(558);
                iDKey.SetValue(1);
                iDKey.SetKey(h.tL(701));
                arrayList.add(iDKey);
            }
            g.pQN.a(arrayList, true);
            g.pQN.h(14777, new Object[]{Integer.valueOf(0), Integer.valueOf(aVar.field_musicType), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0)});
        }
    }

    public f() {
        bew();
    }

    public final void d(com.tencent.mm.av.a aVar, boolean z) {
        if (this.oMr == null) {
            if (z || !com.tencent.mm.compatible.util.d.fO(15)) {
                x.i("MicroMsg.Music.MusicPlayer", "use MMMediaPlayer");
                this.oMr = new d();
            } else {
                x.i("MicroMsg.Music.MusicPlayer", "use MMPlayer");
                this.oMr = new e();
            }
            this.oMr.m(aVar);
            this.oMr.a(new 1(this));
        }
    }

    public final void pause() {
        this.oLI = false;
        x.i("MicroMsg.Music.MusicPlayer", "pause");
        try {
            if (this.oMr != null && this.oMr.isPlaying()) {
                this.oMr.pause();
                this.oMt = true;
                r(h.bdz().bdp());
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MusicPlayer", e, "pause", new Object[0]);
        }
    }

    public final void beb() {
        x.i("MicroMsg.Music.MusicPlayer", "pauseAndAbandonFocus");
        pause();
        h.bdC().bdl();
    }

    public final boolean bdO() {
        return this.oKF && this.oLI;
    }

    public final void bdN() {
        this.oLI = true;
        x.i("MicroMsg.Music.MusicPlayer", "passivePause");
        try {
            if (this.oMr != null && this.oMr.isPlaying()) {
                this.oMr.pause();
                r(h.bdz().bdp());
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MusicPlayer", e, "passivePause", new Object[0]);
        }
    }

    public final void resume() {
        try {
            if (this.oMr == null || this.oMr.isPlaying()) {
                x.i("MicroMsg.Music.MusicPlayer", "music is playing");
                return;
            }
            x.i("MicroMsg.Music.MusicPlayer", "resume");
            if (h.bdC().requestFocus()) {
                this.oMr.play();
                q(h.bdz().bdp());
                return;
            }
            x.e("MicroMsg.Music.MusicPlayer", "request focus error");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MusicPlayer", e, "resume", new Object[0]);
        }
    }

    public final boolean Qq() {
        boolean z = false;
        if (this.oMr != null) {
            try {
                z = this.oMr.isPlaying();
            } catch (Throwable th) {
            }
        }
        return z;
    }

    public final boolean Qr() {
        return this.oKF;
    }

    public final void stopPlay() {
        x.i("MicroMsg.Music.MusicPlayer", "stopPlay");
        if (this.oMr != null && (this.oMr instanceof e)) {
            String beA = this.oMr.beA();
            if (TextUtils.isEmpty(beA) && this.oMs != null) {
                beA = getMimeType();
            }
            x.i("MicroMsg.Music.MusicPlayer", "idKeyReportMusicMimeType mineType:%s, hasStatForMimeType:%b", new Object[]{beA, Boolean.valueOf(this.oMC)});
            if (!(TextUtils.isEmpty(beA) || this.oMC)) {
                x.i("MicroMsg.Music.MusicPlayer", "idKeyReportMusicMimeType OK");
                this.oMC = true;
                IDKey iDKey = new IDKey();
                iDKey.SetID(558);
                int i = "audio/3gpp".equalsIgnoreCase(beA) ? 70 : "audio/amr-wb".equalsIgnoreCase(beA) ? 71 : ("audio/mpeg".equalsIgnoreCase(beA) || beA.equalsIgnoreCase("audio/mp3")) ? 72 : ("audio/mp4a-latm".equalsIgnoreCase(beA) || beA.startsWith("audio/mp4")) ? 73 : "audio/qcelp".equalsIgnoreCase(beA) ? 74 : "audio/vorbis".equalsIgnoreCase(beA) ? 75 : "audio/opus".equalsIgnoreCase(beA) ? 76 : "audio/g711-alaw".equalsIgnoreCase(beA) ? 77 : "audio/g711-mlaw".equalsIgnoreCase(beA) ? 78 : "audio/raw".equalsIgnoreCase(beA) ? 79 : "audio/flac".equalsIgnoreCase(beA) ? 80 : "audio/gsm".equalsIgnoreCase(beA) ? 81 : "audio/ac3".equalsIgnoreCase(beA) ? 82 : "audio/eac3".equalsIgnoreCase(beA) ? 83 : "audio/x-ms-wma".equalsIgnoreCase(beA) ? 84 : "audio/x-wav".equalsIgnoreCase(beA) ? 85 : ("audio/x-ape".equalsIgnoreCase(beA) || "application/x-ape".equalsIgnoreCase(beA)) ? 86 : 87;
                iDKey.SetKey(i);
                iDKey.SetValue(1);
                ArrayList arrayList = new ArrayList();
                arrayList.add(iDKey);
                g.pQN.a(arrayList, true);
                if (h.bdz().bdo() != null) {
                    int Gw = h.Gw(beA);
                    g.pQN.h(14486, new Object[]{Integer.valueOf(0), Integer.valueOf(r1.field_musicType), Integer.valueOf(Gw), beA});
                }
            }
        }
        try {
            if (this.oMs != null) {
                this.oMs.isStop = true;
                this.oMs = null;
            }
            if (this.oMr != null) {
                this.oMr.stop();
                this.oMr = null;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MusicPlayer", e, "stopPlay", new Object[0]);
        }
        h.bdC().bdl();
        this.oKF = false;
        this.oLI = false;
    }

    public final int getDuration() {
        if (this.oMr != null) {
            return this.oMr.getDuration();
        }
        return -1;
    }

    private int bem() {
        if (this.oMs == null) {
            return 0;
        }
        int i;
        a aVar = this.oMs;
        if (aVar.mrc) {
            x.v("MicroMsg.Music.MusicDownloadTask", "WifiFileLength: %d downloadLength: %d", new Object[]{Long.valueOf(aVar.fAA.field_songWifiFileLength), Long.valueOf(aVar.fAA.field_wifiDownloadedLength)});
            i = aVar.fAA.field_songWifiFileLength != 0 ? (int) ((aVar.fAA.field_wifiDownloadedLength * 100) / aVar.fAA.field_songWifiFileLength) : 0;
        } else {
            x.v("MicroMsg.Music.MusicDownloadTask", "fileLength: %d downloadLength: %d", new Object[]{Long.valueOf(aVar.fAA.field_songFileLength), Long.valueOf(aVar.fAA.field_downloadedLength)});
            i = aVar.fAA.field_songFileLength != 0 ? (int) ((aVar.fAA.field_downloadedLength * 100) / aVar.fAA.field_songFileLength) : 0;
        }
        if (i > 0) {
            return i;
        }
        return 0;
    }

    public final boolean if(int i) {
        x.i("MicroMsg.Music.MusicPlayer", "seekToMusic pos:%d", new Object[]{Integer.valueOf(i)});
        try {
            int duration = getDuration();
            int bem = bem();
            if (duration < 0 || i > duration) {
                x.e("MicroMsg.Music.MusicPlayer", "duration or position is illegal, stop");
                stopPlay();
                return false;
            }
            duration = (int) ((((double) bem) / 100.0d) * ((double) duration));
            if (bem != 100 && i > duration) {
                i = duration - 2000;
                x.i("MicroMsg.Music.MusicPlayer", "on completed seekto, position is %d =", new Object[]{Integer.valueOf(i)});
            }
            if (this.oMr != null && i >= 0) {
                this.oMr.seek((long) i);
                t(h.bdz().bdp());
                return true;
            }
            return false;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.MusicPlayer", e, "seekTo", new Object[0]);
        }
    }

    public final d bdQ() {
        int i;
        int duration = getDuration();
        int bez = this.oMr != null ? this.oMr.bez() : -1;
        if (Qq()) {
            i = 1;
        } else {
            if (this.oKF && (this.oMt || this.oKA)) {
                i = 1;
            } else {
                boolean z = false;
            }
            if (i != 0) {
                i = 0;
            } else {
                i = 2;
            }
        }
        x.i("MicroMsg.Music.MusicPlayer", "get music status = %d", new Object[]{Integer.valueOf(i)});
        int bem = bem();
        if (duration <= 0) {
            bem = 0;
        }
        if (this.oME != null) {
            this.oME.i(duration, bez, i, bem);
        } else {
            this.oME = new d(duration, bez, i, bem);
        }
        this.oME.fAB = false;
        this.oME.hHY = this.oMe;
        return this.oME;
    }

    public final boolean bdP() {
        return false;
    }

    private String getMimeType() {
        String str = "";
        if (this.oMs != null) {
            str = this.oMs.mimeType;
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        com.tencent.mm.av.a bdo = h.bdz().bdo();
        if (bdo != null) {
            return bdo.field_mimetype;
        }
        return str;
    }
}
