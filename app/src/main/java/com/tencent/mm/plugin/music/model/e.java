package com.tencent.mm.plugin.music.model;

import android.content.ContentValues;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mm.g.a.js;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.music.model.b.d;
import com.tencent.mm.plugin.music.model.d.a;
import com.tencent.mm.plugin.music.model.e.c;
import com.tencent.mm.plugin.music.model.g.f;
import com.tencent.mm.plugin.music.model.g.k;
import com.tencent.mm.plugin.music.model.notification.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.afb;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.protocal.c.nf;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.List;

public final class e implements com.tencent.mm.ae.e {
    public int mode = 1;
    public int oJA;
    public List<String> oJB;
    public f oJC = new f();
    public k oJD = new k();
    a oJE = new a();
    b oJF = new b();
    public com.tencent.mm.plugin.music.model.e.b oJG;
    private com.tencent.mm.plugin.music.model.e.a oJH;
    private c oJI;
    public boolean oJJ;
    Runnable oJK = new Runnable(this) {
        final /* synthetic */ e oJL;

        {
            this.oJL = r1;
        }

        public final void run() {
            x.i("MicroMsg.Music.MusicPlayerManager", "stopMusicDelayRunnable, isStartPlayMusic:%b, isPlayingMusic:%b", new Object[]{Boolean.valueOf(this.oJL.bdn().Qr()), Boolean.valueOf(this.oJL.bdn().Qq())});
            if (this.oJL.bdn().Qr() && !r1) {
                this.oJL.bdn().stopPlay();
            }
        }
    };

    public e() {
        b bVar = this.oJF;
        x.i("MicroMsg.Music.MMMusicNotificationHelper", "initMusicPlayerService");
        bVar.jeX = new b$1(bVar);
        bVar.jeX.ceO();
        ar.CG().a(520, this);
        ar.CG().a(769, this);
        this.oJB = new ArrayList();
    }

    public final void e(asv com_tencent_mm_protocal_c_asv) {
        if (com_tencent_mm_protocal_c_asv == null && this.oJB.size() == 0) {
            x.i("MicroMsg.Music.MusicPlayerManager", "musicWrapper is null && musicList's size is 0");
            return;
        }
        if (com_tencent_mm_protocal_c_asv != null) {
            this.oJB.clear();
            this.oJB.add(g.i(com_tencent_mm_protocal_c_asv));
            this.oJA = 0;
            h.bdA().x(com_tencent_mm_protocal_c_asv);
            if (this.mode == 2) {
                bdq();
            }
        }
        x.i("MicroMsg.Music.MusicPlayerManager", "startPlayNewMusic, threadId:%d", new Object[]{Integer.valueOf(Process.myTid())});
        if (com_tencent_mm_protocal_c_asv == null) {
            com_tencent_mm_protocal_c_asv = bdp();
        }
        if (com_tencent_mm_protocal_c_asv != null) {
            x.i("MicroMsg.Music.MusicPlayerManager", "MusicType %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_asv.wAi)});
        }
        com.tencent.mm.av.a bdo = bdo();
        if (bdo == null || !g.e(bdo)) {
            x.e("MicroMsg.Music.MusicPlayerManager", "music or url is null, do not start music");
            f(com_tencent_mm_protocal_c_asv);
        } else if (bdo.field_isBlock == 1) {
            x.i("MicroMsg.Music.MusicPlayerManager", "not play new music, music is block %s", new Object[]{bdo.field_musicId});
            f(com_tencent_mm_protocal_c_asv);
            f.a(bdo, true);
        } else {
            x.i("MicroMsg.Music.MusicPlayerManager", "music protocol:%s", new Object[]{bdo.field_protocol});
            if (this.oJH != null) {
                ar.CG().c(this.oJH);
            }
            ar.CG().a(940, this);
            this.oJH = new com.tencent.mm.plugin.music.model.e.a(bdo.field_musicType, bdo);
            ar.CG().a(this.oJH, 0);
            d.f(bdo);
            if (d.g(bdo)) {
                x.i("MicroMsg.Music.MusicPlayerManager", "get shake music new url to play");
                FK(bdo.hHQ);
                return;
            }
            b(bdo);
        }
    }

    final void f(asv com_tencent_mm_protocal_c_asv) {
        if (g.m(com_tencent_mm_protocal_c_asv)) {
            this.oJE.w(com_tencent_mm_protocal_c_asv);
        } else if (com_tencent_mm_protocal_c_asv == null || !g.tr(com_tencent_mm_protocal_c_asv.wAi)) {
            this.oJC.w(com_tencent_mm_protocal_c_asv);
        } else {
            this.oJD.w(com_tencent_mm_protocal_c_asv);
        }
    }

    final void b(com.tencent.mm.av.a aVar) {
        if (g.m(aVar.Qn())) {
            x.i("MicroMsg.Music.MusicPlayerManager", "use exoMusicPlayer");
            bdm();
            this.oJE.j(aVar);
        } else if (g.tr(aVar.field_musicType)) {
            x.i("MicroMsg.Music.MusicPlayerManager", "use qqMusicPlayer");
            bdm();
            this.oJD.j(aVar);
        } else {
            x.i("MicroMsg.Music.MusicPlayerManager", "use musicPlayer");
            bdm();
            f fVar = this.oJC;
            x.i("MicroMsg.Music.MusicPlayer", "init and start download");
            fVar.stopPlay();
            f.a(aVar, false);
            x.i("MicroMsg.Music.MusicPlayer", "initIdKeyStatData");
            fVar.oMu = false;
            fVar.oMv = false;
            fVar.oMw = false;
            fVar.oMx = false;
            fVar.oMy = false;
            fVar.oMz = false;
            fVar.oMA = false;
            fVar.oMB = false;
            fVar.oMC = false;
            fVar.oMD = 0;
            fVar.d(aVar, false);
            if (aVar == null) {
                x.i("MicroMsg.Music.MusicPlayer", "music is null");
            } else {
                x.i("MicroMsg.Music.MusicPlayer", "startPlay src:%s", new Object[]{aVar.field_songWifiUrl});
                fVar.oMs = new com.tencent.mm.plugin.music.model.c.a(aVar);
                fVar.oMs.oLs = fVar.oMF;
                fVar.oMs.start();
            }
        }
        if (aVar.field_musicType != 11) {
            bdu();
        }
    }

    private void bdm() {
        if (this.oJC.Qq()) {
            this.oJC.stopPlay();
        }
        if (this.oJD.Qq()) {
            this.oJD.stopPlay();
        }
        if (this.oJE.Qq()) {
            this.oJE.stopPlay();
        }
    }

    public final com.tencent.mm.plugin.music.model.g.c bdn() {
        asv bdp = bdp();
        if (g.m(bdp)) {
            return this.oJE;
        }
        if (bdp == null || !g.tr(bdp.wAi)) {
            return this.oJC;
        }
        return this.oJD;
    }

    public final synchronized void f(List<asv> list, boolean z) {
        if (list != null) {
            if (list.size() != 0) {
                if (z) {
                    this.oJB.clear();
                }
                for (asv com_tencent_mm_protocal_c_asv : list) {
                    this.oJB.add(g.i(com_tencent_mm_protocal_c_asv));
                    h.bdA().x(com_tencent_mm_protocal_c_asv);
                }
            }
        }
        x.i("MicroMsg.Music.MusicPlayerManager", "appendMusicList error");
    }

    public final com.tencent.mm.av.a bdo() {
        if (this.oJB.size() <= this.oJA) {
            return null;
        }
        return h.bdA().Gx((String) this.oJB.get(this.oJA));
    }

    public final asv bdp() {
        if (this.oJB.size() <= this.oJA) {
            return null;
        }
        com.tencent.mm.av.a Gx = h.bdA().Gx((String) this.oJB.get(this.oJA));
        return Gx != null ? Gx.Qn() : null;
    }

    public final void Qo() {
        this.oJC.stopPlay();
        if (this.oJD != null) {
            this.oJD.stopPlay();
        }
        if (this.oJE != null) {
            this.oJE.stopPlay();
        }
        ag.K(this.oJK);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ae.k kVar) {
        String str2;
        com.tencent.mm.av.a aVar;
        if (kVar instanceof com.tencent.mm.plugin.music.model.e.a) {
            x.i("MicroMsg.Music.MusicPlayerManager", "onSceneEnd errCode:%d", new Object[]{Integer.valueOf(i2)});
            ar.CG().b(940, this);
            if (i == 4 && i2 == -24) {
                nf nfVar = ((com.tencent.mm.plugin.music.model.e.a) kVar).oLM;
                if (bdo() != null && nfVar.vVZ.equals(bdo().field_musicId)) {
                    Qo();
                }
                com.tencent.mm.plugin.music.model.h.a bdA = h.bdA();
                str2 = nfVar.vVZ;
                ContentValues contentValues = new ContentValues();
                contentValues.put("isBlock", Integer.valueOf(1));
                bdA.gJP.update("Music", contentValues, "musicId=?", new String[]{str2});
                aVar = (com.tencent.mm.av.a) bdA.oMR.get(str2);
                if (aVar != null) {
                    aVar.field_isBlock = 1;
                }
                x.i("MicroMsg.Music.MusicPlayerManager", "onSceneEnd music is block %s", new Object[]{bdo().field_musicId});
            }
        } else if (kVar instanceof com.tencent.mm.plugin.music.model.e.b) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.music.model.e.b bVar = (com.tencent.mm.plugin.music.model.e.b) kVar;
                afb com_tencent_mm_protocal_c_afb = bVar.oLN;
                String str3 = bVar.fAA.field_musicId;
                if (com_tencent_mm_protocal_c_afb != null && str3 != null) {
                    for (String str22 : this.oJB) {
                        if (str22.equals(str3)) {
                            str3 = n.b(com_tencent_mm_protocal_c_afb.wmW);
                            String b = n.b(com_tencent_mm_protocal_c_afb.wmX);
                            String b2 = n.b(com_tencent_mm_protocal_c_afb.wmV);
                            com.tencent.mm.plugin.music.model.h.a bdA2 = h.bdA();
                            boolean z = bVar.oLO;
                            com.tencent.mm.sdk.e.c Gx = bdA2.Gx(str22);
                            if (Gx == null) {
                                x.e("MicroMsg.Music.MusicStorage", "updateMusicWithLyricResponse can not find music %s", new Object[]{str22});
                            } else {
                                if (!bh.ov(str3)) {
                                    Gx.field_songAlbumUrl = str3;
                                }
                                Gx.field_songHAlbumUrl = b;
                                Gx.field_songLyric = b2;
                                bdA2.c(Gx, new String[]{"songAlbumUrl", "songHAlbumUrl", "songLyric"});
                                bdA2.oMR.put(str22, Gx);
                                bdA2.g(Gx, z);
                            }
                            x.i("MicroMsg.Music.MusicPlayerManager", "get response %s %s %s", new Object[]{str3, b, b2});
                            if (!bh.ov(b)) {
                                com.tencent.mm.sdk.b.b jsVar = new js();
                                jsVar.fAz.action = 6;
                                jsVar.fAz.fAA = bVar.fAA;
                                com.tencent.mm.sdk.b.a.xef.a(jsVar, Looper.getMainLooper());
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        } else if (kVar instanceof c) {
            x.i("MicroMsg.Music.MusicPlayerManager", "GetShakeMusicUrl onSceneEnd errType:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            c cVar = (c) kVar;
            x.i("MicroMsg.Music.MusicPlayerManager", "getShakeMusicUrlScene callback, playUrl:%s, tempPlayUrl:%s", new Object[]{cVar.hHQ, cVar.oLQ});
            if (i == 0 && i2 == 0) {
                d.dw(cVar.hHQ, cVar.oLQ);
            } else {
                g.pQN.a(558, 214, 1, true);
            }
            aVar = bdo();
            if (aVar != null && !TextUtils.isEmpty(aVar.hHQ) && aVar.hHQ.equalsIgnoreCase(cVar.hHQ)) {
                x.i("MicroMsg.Music.MusicPlayerManager", "music playUrl is same, start to play shake music");
                b(aVar);
            } else if (aVar != null) {
                x.i("MicroMsg.Music.MusicPlayerManager", "music playUrl is diff, don't play, current playUrl is %s, netscene playUrl is %s", new Object[]{aVar.hHQ, cVar.hHQ});
            }
        }
    }

    final void FK(String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.Music.MusicPlayerManager", "GetShakeMusicUrl, url is null");
            return;
        }
        if (this.oJI != null) {
            ar.CG().c(this.oJI);
            this.oJI = null;
        }
        x.e("MicroMsg.Music.MusicPlayerManager", "GetShakeMusicUrl, url is %s", new Object[]{str});
        this.oJI = new c(str);
        ar.CG().a(this.oJI, 0);
        g.pQN.a(558, 213, 1, true);
    }

    public final void bdq() {
        com.tencent.mm.sdk.f.e.post(new a(this, (byte) 0), "music_get_list_task");
    }

    public final void bdr() {
        if (this.mode != 1) {
            this.oJA++;
            this.oJA %= this.oJB.size();
            bds();
            e(null);
        }
    }

    public final void bds() {
        if (this.oJC.Qq()) {
            this.oJC.fAC = true;
        }
        if (this.oJD.Qq()) {
            this.oJD.fAC = true;
        }
        if (this.oJE.Qq()) {
            this.oJE.fAC = true;
        }
    }

    public final boolean bdt() {
        return this.oJB.size() > 0 && this.mode == 2;
    }

    public static void bdu() {
        x.i("MicroMsg.Music.MusicPlayerManager", "sendPreemptedEvent");
        com.tencent.mm.sdk.b.b jsVar = new js();
        jsVar.fAz.action = 10;
        jsVar.fAz.state = "preempted";
        jsVar.fAz.appId = "not from app brand appid";
        jsVar.fAz.fAB = true;
        com.tencent.mm.sdk.b.a.xef.a(jsVar, Looper.getMainLooper());
    }

    public final void bdv() {
        x.i("MicroMsg.Music.MusicPlayerManager", "stopMusicDelayIfPaused, delay_ms:%d", new Object[]{Integer.valueOf(600000)});
        ag.K(this.oJK);
        ag.h(this.oJK, 600000);
    }
}
