package com.tencent.mm.plugin.music.model.d;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c;
import com.google.android.exoplayer2.g.b;
import com.google.android.exoplayer2.h.k;
import com.google.android.exoplayer2.h.m;
import com.google.android.exoplayer2.h.o;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.b.h;
import com.google.android.exoplayer2.v;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.av.d;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.opensdk.constants.ConstantsAPI$Token;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URL;
import java.util.ArrayList;

public final class a extends com.tencent.mm.plugin.music.model.g.a implements com.google.android.exoplayer2.h.d.a, com.google.android.exoplayer2.metadata.e.a {
    private long aBM;
    int aBO = 0;
    protected String aBs;
    boolean auM = false;
    protected com.tencent.mm.av.a fAA;
    int hkt = 0;
    boolean oKF;
    private String oKJ = "";
    private long oKL = 0;
    public com.google.android.exoplayer2.h.f.a oLA;
    public com.google.android.exoplayer2.source.f oLB;
    f oLC = new f();
    public a oLD = new a(this, (byte) 0);
    e oLE = new e();
    d oLF = new d(this, (byte) 0);
    b oLG = new c(this);
    public Handler oLH = new 1(this, Looper.myLooper());
    public boolean oLI = false;
    asv oLu;
    private d oLv;
    int oLw = 0;
    public v oLx;
    public b oLy;
    private k oLz;

    private static class f {
        int[] oLK;

        private f() {
            this.oLK = new int[]{1, 1, 1, 1};
        }

        final void q(boolean z, int i) {
            int r = r(z, i);
            x.i("MicroMsg.Music.ExoMusicPlayer", "request setMostRecentState [" + z + "," + i + "], lastState=" + this.oLK[3] + ",newState=" + r);
            if (this.oLK[3] != r) {
                this.oLK[0] = this.oLK[1];
                this.oLK[1] = this.oLK[2];
                this.oLK[2] = this.oLK[3];
                this.oLK[3] = r;
                x.v("MicroMsg.Music.ExoMusicPlayer", "MostRecentState [" + this.oLK[0] + "," + this.oLK[1] + "," + this.oLK[2] + "," + this.oLK[3] + "]");
            }
        }

        static int r(boolean z, int i) {
            return (z ? -268435456 : 0) | i;
        }

        final boolean a(int[] iArr, boolean z) {
            int i = z ? 268435455 : -1;
            int length = this.oLK.length - iArr.length;
            boolean z2 = true;
            for (int i2 = length; i2 < this.oLK.length; i2++) {
                z2 &= (this.oLK[i2] & i) == (iArr[i2 - length] & i) ? 1 : 0;
            }
            return z2;
        }
    }

    private class e implements com.google.android.exoplayer2.a.e {
        final /* synthetic */ a oLJ;

        private e(a aVar) {
            this.oLJ = aVar;
        }

        public final void c(com.google.android.exoplayer2.b.d dVar) {
            x.i("MicroMsg.Music.ExoMusicPlayer", "audioEnabled [" + this.oLJ.ben() + "]");
        }

        public final void bW(int i) {
            x.i("MicroMsg.Music.ExoMusicPlayer", "audioSessionId [" + i + "]");
        }

        public final void a(String str, long j, long j2) {
            x.i("MicroMsg.Music.ExoMusicPlayer", "audioDecoderInitialized [" + this.oLJ.ben() + ", " + str + "]");
        }

        public final void d(Format format) {
            x.i("MicroMsg.Music.ExoMusicPlayer", "audioFormatChanged [" + this.oLJ.ben() + ", " + Format.a(format) + "]");
        }

        public final void d(com.google.android.exoplayer2.b.d dVar) {
            x.i("MicroMsg.Music.ExoMusicPlayer", "audioDisabled [" + this.oLJ.ben() + "]");
        }

        public final void c(int i, long j, long j2) {
            x.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", null, "internalError [" + this.oLJ.ben() + ", " + ("audioTrackUnderrun [" + i + ", " + j + ", " + j2 + "]") + "]", new Object[0]);
        }
    }

    static /* synthetic */ void a(a aVar) {
        URL url;
        x.i("MicroMsg.Music.ExoMusicPlayer", "initPlayer");
        aVar.oKJ = g.a(bh.ov(aVar.fAA.field_songWifiUrl) ? aVar.fAA.field_songWebUrl : aVar.fAA.field_songWifiUrl, aVar.fAA.field_songWapLinkUrl, an.isWifi(ac.getContext()), new PBool());
        x.i("MicroMsg.Music.ExoMusicPlayer", "mSrc:%s", aVar.oKJ);
        x.i("MicroMsg.Music.ExoMusicPlayer", "field_songWifiUrl:%s", aVar.fAA.field_songWifiUrl);
        try {
            url = new URL(aVar.oKJ);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", e, "initPlayer", new Object[0]);
            x.e("MicroMsg.Music.ExoMusicPlayer", "new URL exception:" + e.getMessage());
            url = null;
        }
        if (url == null) {
            x.e("MicroMsg.Music.ExoMusicPlayer", "initPlayer url is null");
            aVar.a(aVar.fAA.Qn(), 500);
            a(aVar.fAA, -4005, -43);
            return;
        }
        if (aVar.oLx != null && (aVar.oLw != 3 || aVar.oLx.ib())) {
            x.i("MicroMsg.Music.ExoMusicPlayer", "stop it first!");
            aVar.oLw = 3;
            aVar.oLx.ad(false);
            aVar.oLx.stop();
        }
        aVar.oLC.oLK = new int[]{1, 1, 1, 1};
        aVar.aBs = t.d(ac.getContext(), ConstantsAPI$Token.WX_TOKEN_PLATFORMID_VALUE);
        Uri parse = Uri.parse(aVar.oKJ);
        if (aVar.oLx == null) {
            aVar.oLz = new k(aVar.oLH, aVar);
            aVar.oLy = new b();
            aVar.oLx = com.google.android.exoplayer2.g.a(ac.getContext(), aVar.oLy, new c());
        }
        if (aVar.oLA == null) {
            aVar.oLA = new m(ac.getContext(), aVar.oLz, new o(aVar.aBs, aVar.oLz));
        }
        try {
            aVar.auM = false;
            aVar.oLB = new h(parse, aVar.oLA, aVar.oLH, aVar.oLF);
            aVar.oLx.a(aVar.oLD);
            aVar.oLx.aeD.add(aVar);
            aVar.oLx.aeN = aVar.oLE;
            aVar.oLw = 0;
            if (aVar.hkt == 0) {
                x.i("MicroMsg.Music.ExoMusicPlayer", "startTime is 0, play it when ready!");
                aVar.oLx.ad(true);
            } else {
                aVar.oLx.ad(false);
            }
            aVar.oLx.a(aVar.oLB);
            aVar.oKF = true;
            aVar.oLH.sendEmptyMessageDelayed(100, 5000);
        } catch (Throwable e2) {
            x.e("MicroMsg.Music.ExoMusicPlayer", "initPlayer exception:" + e2.getMessage());
            x.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", e2, "initPlayer", new Object[0]);
            aVar.a(aVar.fAA.Qn(), HardCoderJNI.SCENE_DB);
            a(aVar.fAA, -4005, -41);
        }
    }

    public a() {
        b.beu();
    }

    public final void j(com.tencent.mm.av.a aVar) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - this.oKL;
        if (this.fAA != null && this.fAA.a(aVar) && j <= 1000) {
            this.fAA = aVar;
            x.e("MicroMsg.Music.ExoMusicPlayer", "startPlay, is playing for music src:%s, don't play again in 3 second, interval:%d", this.oKJ, Long.valueOf(j));
        } else if (aVar == null) {
            x.e("MicroMsg.Music.ExoMusicPlayer", "music is null");
        } else {
            com.tencent.mm.plugin.music.model.f.a(aVar, false);
            this.oKL = currentTimeMillis;
            this.fAA = aVar;
            x.i("MicroMsg.Music.ExoMusicPlayer", "startPlay, currentTime:%d, startTime:%d", Long.valueOf(currentTimeMillis), Integer.valueOf(aVar.field_startTime));
            if (this.oLx != null && Qq()) {
                this.oLx.stop();
            }
            this.aBO = 0;
            this.hkt = aVar.field_startTime;
            this.aBM = SystemClock.elapsedRealtime();
            this.oLu = aVar.Qn();
            n(this.oLu);
            x.i("MicroMsg.Music.ExoMusicPlayer", "startPlay startTime:%d", Integer.valueOf(this.hkt));
            ag.y(new 2(this));
        }
    }

    public final void pause() {
        this.oLI = false;
        x.i("MicroMsg.Music.ExoMusicPlayer", "pause");
        if (this.oLx != null) {
            this.oLw = 2;
            this.oLx.ad(false);
        }
    }

    public final boolean bdO() {
        return this.oKF && this.oLI;
    }

    public final void bdN() {
        this.oLI = true;
        x.i("MicroMsg.Music.ExoMusicPlayer", "passivePause");
        if (this.oLx != null) {
            this.oLw = 2;
            this.oLx.ad(false);
        }
    }

    public final void beb() {
        x.i("MicroMsg.Music.ExoMusicPlayer", "pauseAndAbandonFocus");
        pause();
        com.tencent.mm.plugin.music.model.h.bdC().bdl();
    }

    public final void resume() {
        this.aBO = 0;
        boolean bec = bec();
        boolean Qq = Qq();
        x.i("MicroMsg.Music.ExoMusicPlayer", "resume, isPreparing:%b, isPlayingMusic:%b", Boolean.valueOf(bec), Boolean.valueOf(Qq));
        if (this.oLx != null) {
            if (com.tencent.mm.plugin.music.model.h.bdC().requestFocus()) {
                this.oLw = 1;
                this.oLx.ad(true);
                q(this.oLu);
            } else {
                x.e("MicroMsg.Music.ExoMusicPlayer", "request focus error");
            }
            this.oKF = true;
        }
    }

    public final boolean Qq() {
        if (this.oLx == null) {
            return false;
        }
        switch (this.oLx.ia()) {
            case 1:
            case 3:
                return this.oLx.ib();
            default:
                return false;
        }
    }

    private boolean bec() {
        if (this.oLx != null) {
            return this.oLx.ic();
        }
        return false;
    }

    public final boolean Qr() {
        return this.oKF && !bec();
    }

    public final void stopPlay() {
        x.i("MicroMsg.Music.ExoMusicPlayer", "stopPlay");
        try {
            if (this.oLx != null) {
                this.oLw = 3;
                this.oLx.ad(false);
                this.oLx.stop();
                s(this.oLu);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Music.ExoMusicPlayer", e, "stopPlay", new Object[0]);
            a(this.fAA.Qn(), 504);
            a(this.fAA, -4005, -42);
        }
        com.tencent.mm.plugin.music.model.h.bdC().bdl();
        this.oKF = false;
        this.oLI = false;
        this.oLH.removeMessages(100);
    }

    public final int getDuration() {
        if (this.oLx != null) {
            return (int) this.oLx.getDuration();
        }
        return 0;
    }

    public final int bem() {
        if (this.oLx != null) {
            return this.oLx.getBufferedPercentage();
        }
        return 0;
    }

    public final boolean if(int i) {
        boolean z = false;
        int duration = getDuration();
        x.i("MicroMsg.Music.ExoMusicPlayer", "seekToMusic pos:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(duration));
        if (duration < 0 || i > duration) {
            x.e("MicroMsg.Music.ExoMusicPlayer", "position is invalid, position:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(duration));
            return false;
        } else if (this.oLx == null) {
            return true;
        } else {
            u(this.fAA.Qn());
            f fVar = this.oLC;
            if ((this.oLC.oLK[3] & -268435456) != 0) {
                z = true;
            }
            fVar.q(z, 100);
            this.oLw = 4;
            this.oLx.seekTo((long) i);
            return true;
        }
    }

    public final d bdQ() {
        int i = 0;
        int duration = getDuration();
        int currentPosition = this.oLx != null ? (int) this.oLx.getCurrentPosition() : 0;
        boolean Qq = Qq();
        int bem = bem();
        if (bem < 0) {
            bem = 0;
        }
        if ((this.oLB instanceof h) && !this.auM) {
            duration = 0;
        }
        if (this.oLv != null) {
            d dVar = this.oLv;
            if (Qq) {
                i = 1;
            }
            dVar.i(duration, currentPosition, i, bem);
        } else {
            if (Qq) {
                i = 1;
            }
            this.oLv = new d(duration, currentPosition, i, bem);
        }
        this.oLv.fAB = true;
        this.oLv.hHY = this.oMe;
        return this.oLv;
    }

    public final boolean bdP() {
        return true;
    }

    final void cU(int i, int i2) {
        x.i("MicroMsg.Music.ExoMusicPlayer", "notifyOnError what:%d, extra:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (this.oLG != null) {
            this.oLG.cW(i, i2);
        }
    }

    final void cV(int i, int i2) {
        x.i("MicroMsg.Music.ExoMusicPlayer", "notifyOnInfo [" + i + "," + i2 + "]");
        if (this.oLG == null) {
            return;
        }
        if (i == 701 || i == 702) {
            this.oLG.tD(i2);
        }
    }

    public final void a(Metadata metadata) {
        x.i("MicroMsg.Music.ExoMusicPlayer", "onMetadata [");
        b.a(metadata, "  ");
        x.i("MicroMsg.Music.ExoMusicPlayer", "]");
    }

    final String ben() {
        return b.dP(SystemClock.elapsedRealtime() - this.aBM);
    }

    static void a(com.tencent.mm.av.a aVar, int i, int i2) {
        IDKey iDKey = new IDKey();
        iDKey.SetID(797);
        iDKey.SetKey(2);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(797);
        int i3 = aVar.field_musicType;
        x.i("MicroMsg.ExoPlayerErrorHandler", "getExoMusicPlayerErrIdKeyByMusicType, musicType:" + i3);
        switch (i3) {
            case 0:
                i3 = 62;
                break;
            case 1:
                i3 = 63;
                break;
            case 4:
                i3 = 64;
                break;
            case 6:
                i3 = 65;
                break;
            case 7:
                i3 = 66;
                break;
            case 8:
                i3 = 67;
                break;
            case 9:
                i3 = 68;
                break;
            case 10:
                i3 = 69;
                break;
            case 11:
                i3 = 70;
                break;
            default:
                i3 = 71;
                break;
        }
        iDKey2.SetKey(i3);
        iDKey2.SetValue(1);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(797);
        x.i("MicroMsg.ExoPlayerErrorHandler", "getExoMusicPlayerErrTypeIdKey, errType:" + i);
        switch (i) {
            case -4999:
                i3 = 9;
                break;
            case -4005:
                i3 = 8;
                break;
            case -4004:
                i3 = 7;
                break;
            case -4003:
                i3 = 6;
                break;
            case -4002:
                i3 = 5;
                break;
            case -4001:
                i3 = 4;
                break;
            case -4000:
                i3 = 3;
                break;
            default:
                i3 = 9;
                break;
        }
        iDKey3.SetKey(i3);
        iDKey3.SetValue(1);
        IDKey iDKey4 = new IDKey();
        iDKey4.SetID(797);
        x.i("MicroMsg.ExoPlayerErrorHandler", "getExoMusicPlayerErrIdKey, errCode:" + i2);
        switch (i2) {
            case -43:
                i3 = 25;
                break;
            case -42:
                i3 = 24;
                break;
            case -41:
                i3 = 23;
                break;
            case -40:
                i3 = 22;
                break;
            case -30:
                i3 = 21;
                break;
            case -13:
                i3 = 20;
                break;
            case -12:
                i3 = 19;
                break;
            case -11:
                i3 = 18;
                break;
            case -10:
                i3 = 17;
                break;
            case -3:
                i3 = 16;
                break;
            case -2:
                i3 = 15;
                break;
            case -1:
                i3 = 14;
                break;
            default:
                i3 = 14;
                break;
        }
        iDKey4.SetKey(i3);
        iDKey4.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        arrayList.add(iDKey3);
        arrayList.add(iDKey4);
        com.tencent.mm.plugin.report.service.g.pQN.a(arrayList, true);
    }
}
