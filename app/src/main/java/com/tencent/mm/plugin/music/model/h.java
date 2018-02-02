package com.tencent.mm.plugin.music.model;

import android.content.ClipboardManager;
import android.content.Intent;
import android.media.AudioManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.by.h.d;
import com.tencent.mm.g.a.ad;
import com.tencent.mm.g.a.ae;
import com.tencent.mm.g.a.e;
import com.tencent.mm.g.b.co;
import com.tencent.mm.plugin.music.model.g.k;
import com.tencent.mm.plugin.music.model.notification.MMMusicPlayerService;
import com.tencent.mm.plugin.music.ui.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import java.util.HashMap;

public final class h implements ap {
    private c bannerOnInitListener = new c<ad>(this) {
        final /* synthetic */ h oKd;

        {
            this.oKd = r2;
            this.xen = ad.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            b aeVar = new ae();
            aeVar.fnV.fnX = new a(ac.getContext());
            com.tencent.mm.sdk.b.a.xef.m(aeVar);
            return false;
        }
    };
    private AudioManager gCe;
    private c<e> mOd = new 5(this);
    private c oJV;
    private e oJW;
    private com.tencent.mm.plugin.music.model.h.a oJX;
    public ClipboardManager oJY;
    private com.tencent.mm.plugin.music.model.h.c oJZ;
    private com.tencent.mm.plugin.music.model.a.a oKa = new com.tencent.mm.plugin.music.model.a.a();
    private com.tencent.mm.plugin.music.model.a.b oKb;
    private c oKc = new 3(this);

    public static h bdy() {
        ar.Ha();
        h hVar = (h) bp.hY("plugin.music");
        if (hVar != null) {
            return hVar;
        }
        Object hVar2 = new h();
        ar.Ha().a("plugin.music", hVar2);
        return hVar2;
    }

    public final HashMap<Integer, d> Bn() {
        HashMap<Integer, d> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("Music".hashCode()), new 1(this));
        hashMap.put(Integer.valueOf("PieceMusicInfo".hashCode()), new d(this) {
            final /* synthetic */ h oKd;

            {
                this.oKd = r1;
            }

            public final String[] wg() {
                return new String[]{i.a(co.vJ(), "PieceMusicInfo")};
            }
        });
        return hashMap;
    }

    public static e bdz() {
        if (bdy().oJW == null) {
            bdy().oJW = new e();
        }
        return bdy().oJW;
    }

    public static com.tencent.mm.plugin.music.model.h.a bdA() {
        if (bdy().oJX == null) {
            h bdy = bdy();
            ar.Hg();
            bdy.oJX = new com.tencent.mm.plugin.music.model.h.a(com.tencent.mm.z.c.EV());
        }
        return bdy().oJX;
    }

    public static AudioManager bdB() {
        if (bdy().gCe == null) {
            bdy().gCe = (AudioManager) ac.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        return bdy().gCe;
    }

    public static c bdC() {
        if (bdy().oJV == null) {
            bdy().oJV = new c();
        }
        return bdy().oJV;
    }

    public static com.tencent.mm.plugin.music.model.h.c bdD() {
        if (bdy().oJZ == null) {
            h bdy = bdy();
            ar.Hg();
            bdy.oJZ = new com.tencent.mm.plugin.music.model.h.c(com.tencent.mm.z.c.EV());
        }
        return bdy().oJZ;
    }

    public static com.tencent.mm.plugin.music.model.a.b bdE() {
        if (bdy().oKb == null) {
            bdy().oKb = new com.tencent.mm.plugin.music.model.a.b();
        }
        return bdy().oKb;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        this.mOd.ceO();
        this.oKc.ceO();
        this.bannerOnInitListener.ceO();
        this.oKa.ceO();
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        if (this.oJW != null) {
            Object obj = this.oJW;
            obj.Qo();
            x.i("MicroMsg.Music.MusicPlayerManager", "release");
            if (obj.oJD != null) {
                k kVar = obj.oJD;
                x.i("MicroMsg.Music.QQMusicPlayer", "release");
                if (kVar.oKD != null) {
                    kVar.oKD.release();
                    kVar.oKD = null;
                }
                kVar.bex();
            }
            if (obj.oJE != null) {
                com.tencent.mm.plugin.music.model.d.a aVar = obj.oJE;
                x.i("MicroMsg.Music.ExoMusicPlayer", "release");
                aVar.oLH.removeMessages(100);
                aVar.bex();
                if (aVar.oLx != null) {
                    aVar.oLx.b(aVar.oLD);
                    aVar.oLx.aeD.remove(aVar);
                    aVar.oLx.release();
                    aVar.oLx = null;
                }
                if (aVar.oLB != null) {
                    aVar.oLB.ke();
                    aVar.oLB = null;
                }
                aVar.oLy = null;
                aVar.oLA = null;
            }
            ag.K(obj.oJK);
            obj.oJB.clear();
            ar.CG().b(520, obj);
            ar.CG().b(940, obj);
            ar.CG().b(769, obj);
            com.tencent.mm.plugin.music.model.notification.b bVar = obj.oJF;
            x.i("MicroMsg.Music.MMMusicNotificationHelper", "uninitMusicPlayerService");
            Intent intent = new Intent();
            intent.setClass(ac.getContext(), MMMusicPlayerService.class);
            ac.getContext().stopService(intent);
            bVar.oLT = null;
            bVar.jeX.dead();
        }
        if (this.oKb != null) {
            com.tencent.mm.plugin.music.model.a.b bVar2 = this.oKb;
            x.i("MicroMsg.Audio.AudioPlayerMgr", "release, clear all cache");
            bVar2.bdF();
            this.oKb = null;
        }
        this.oJW = null;
        this.oJV = null;
        this.oJX = null;
        this.gCe = null;
        this.oJY = null;
        this.oJZ = null;
        com.tencent.mm.sdk.b.a.xef.c(this.oKc);
        com.tencent.mm.sdk.b.a.xef.c(this.oKa);
        this.oKa.dead();
        this.oKc.dead();
        this.bannerOnInitListener.dead();
        this.mOd.dead();
    }
}
