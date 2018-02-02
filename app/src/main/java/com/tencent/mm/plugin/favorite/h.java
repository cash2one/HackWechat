package com.tencent.mm.plugin.favorite;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.ae.e;
import com.tencent.mm.g.a.qq;
import com.tencent.mm.g.b.em;
import com.tencent.mm.plugin.fav.a.j;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.l;
import com.tencent.mm.plugin.fav.a.o;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.favorite.a.n;
import com.tencent.mm.plugin.favorite.b.b;
import com.tencent.mm.plugin.favorite.b.c;
import com.tencent.mm.plugin.favorite.b.d;
import com.tencent.mm.plugin.favorite.b.f;
import com.tencent.mm.plugin.favorite.b.g;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import com.tencent.wcdb.FileUtils;
import java.io.File;
import java.util.HashMap;

public final class h implements ap {
    private g mpc;
    private b mpd;
    private c mpe;
    private f mpf;
    private d mpg;
    private com.tencent.mm.plugin.favorite.a.f mph;
    private c mpi = new c();
    private b mpj = new b();
    private g mpk = new g();
    private f mpl = new f();
    private e mpm = new e();
    public em mpn = null;
    private volatile boolean mpo = false;
    private byte[] mpp = new byte[0];
    private com.tencent.mm.sdk.b.c mpq = new 1(this);
    private com.tencent.mm.sdk.b.c mpr = new com.tencent.mm.sdk.b.c<qq>(this) {
        final /* synthetic */ h mps;

        {
            this.mps = r2;
            this.xen = qq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            x.i("MicroMsg.Fav.SubCoreFav", "runService");
            h.aIo().run();
            h.aIr().run();
            h.aIn().run();
            h.aIp().run();
            h.aIu().run();
            return false;
        }
    };

    public static h aIm() {
        ar.Ha();
        h hVar = (h) bp.hY("plugin.favorite");
        if (hVar == null) {
            hVar = new h();
            ar.Ha().a("plugin.favorite", hVar);
        }
        if (hVar.mpo) {
            x.w("MicroMsg.Fav.SubCoreFav", "getCore need reset DB now, befor synchronized %b", new Object[]{Boolean.valueOf(hVar.mpo)});
            synchronized (hVar.mpp) {
                if (hVar.mpo) {
                    hVar.mpn = em.wf();
                    hVar.mpo = false;
                }
                x.i("MicroMsg.Fav.SubCoreFav", "getCore need reset DB now, after synchronized %b", new Object[]{Boolean.valueOf(hVar.mpo)});
            }
        }
        return hVar;
    }

    public static g aIn() {
        if (ar.Hj()) {
            if (aIm().mpc == null) {
                aIm().mpc = new g();
            }
            return aIm().mpc;
        }
        throw new com.tencent.mm.z.b();
    }

    public static c aIo() {
        if (ar.Hj()) {
            if (aIm().mpe == null) {
                aIm().mpe = new c();
            }
            return aIm().mpe;
        }
        throw new com.tencent.mm.z.b();
    }

    public static f aIp() {
        if (ar.Hj()) {
            if (aIm().mpf == null) {
                aIm().mpf = new f();
            }
            return aIm().mpf;
        }
        throw new com.tencent.mm.z.b();
    }

    public static com.tencent.mm.plugin.favorite.a.f aIq() {
        if (ar.Hj()) {
            if (aIm().mph == null) {
                aIm().mph = new com.tencent.mm.plugin.favorite.a.f();
            }
            return aIm().mph;
        }
        throw new com.tencent.mm.z.b();
    }

    public static b aIr() {
        if (ar.Hj()) {
            if (aIm().mpd == null) {
                aIm().mpd = new b();
            }
            return aIm().mpd;
        }
        throw new com.tencent.mm.z.b();
    }

    public static j aIs() {
        return ((r) com.tencent.mm.kernel.g.k(r.class)).getFavCdnStorage();
    }

    public static l aIt() {
        return ((r) com.tencent.mm.kernel.g.k(r.class)).getFavEditInfoStorage();
    }

    public static k getFavConfigStorage() {
        return ((r) com.tencent.mm.kernel.g.k(r.class)).getFavConfigStorage();
    }

    public static d aIu() {
        if (ar.Hj()) {
            if (aIm().mpg == null) {
                aIm().mpg = new d();
            }
            return aIm().mpg;
        }
        throw new com.tencent.mm.z.b();
    }

    public static p aIv() {
        return ((r) com.tencent.mm.kernel.g.k(r.class)).getFavSearchStorage();
    }

    public static o getFavItemInfoStorage() {
        return ((r) com.tencent.mm.kernel.g.k(r.class)).getFavItemInfoStorage();
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        x.i("MicroMsg.Fav.SubCoreFav", "onAccountPostReset updated:%b", new Object[]{Boolean.valueOf(z)});
        this.mpo = true;
        a.xef.b(this.mpi);
        a.xef.b(this.mpj);
        a.xef.b(this.mpl);
        a.xef.b(this.mpk);
        a.xef.b(this.mpr);
        a.xef.b(this.mpm);
        a.xef.a(this.mpq);
        File file = new File(com.tencent.mm.plugin.favorite.a.j.aID());
        if (!(file.exists() && file.isDirectory())) {
            x.i("MicroMsg.Fav.SubCoreFav", "fav root dir not exists, try to make it");
            file.mkdirs();
        }
        file = new File(com.tencent.mm.plugin.favorite.a.j.aIE());
        if (!(file.exists() && file.isDirectory())) {
            x.i("MicroMsg.Fav.SubCoreFav", "fav web dir not exists, try to make it");
            file.mkdirs();
        }
        file = new File(com.tencent.mm.plugin.favorite.a.j.aIG());
        if (!(file.exists() && file.isDirectory())) {
            x.i("MicroMsg.Fav.SubCoreFav", "fav attach dir not exists, try to make it");
            file.mkdirs();
        }
        file = new File(com.tencent.mm.plugin.favorite.a.j.aIF());
        if (!(file.exists() && file.isDirectory())) {
            x.i("MicroMsg.Fav.SubCoreFav", "fav voice dir not exists, try to make it");
            file.mkdirs();
        }
        ((m) com.tencent.mm.kernel.g.k(m.class)).getFTSTaskDaemon().a(-86016, new 2(this));
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        this.mpo = false;
        a.xef.c(this.mpi);
        a.xef.c(this.mpj);
        a.xef.c(this.mpl);
        a.xef.c(this.mpr);
        a.xef.c(this.mpk);
        a.xef.c(this.mpm);
        a.xef.c(this.mpq);
        com.tencent.mm.plugin.fts.d.h.qh(FileUtils.S_IWUSR);
        com.tencent.mm.plugin.fts.d.h.qh(4176);
        b aIr = aIr();
        aIr.vB();
        aIr.flY.TG();
        aIr.flT = 0;
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Di().b(aIr.hsr);
        Object aIo = aIo();
        x.i("MicroMsg.Fav.FavCheckCdnService", "stop");
        aIo.vB();
        aIo.flY.TG();
        ar.CG().b(TencentLocation.ERROR_UNKNOWN, aIo);
        ar.b(aIo.hsr);
        e aIn = aIn();
        x.i("MicroMsg.Fav.FavSendService", "stop");
        aIn.vB();
        aIn.flY.TG();
        aIn.flT = 0;
        ar.CG().b(401, aIn);
        aIn = aIp();
        x.i("MicroMsg.Fav.FavModService", "stop");
        aIn.vB();
        aIn.flY.TG();
        aIn.flT = 0;
        ar.CG().b(426, aIn);
        aIo = aIu();
        x.i("MicroMsg.Fav.FavEditService", "stop");
        ar.CG().b(426, aIo);
        ar.CG().b(401, aIo);
        aIo.mrl.clear();
        n.aIS();
        if (this.mpn != null) {
            this.mpn.ES();
        }
    }

    public final HashMap<Integer, com.tencent.mm.by.h.d> Bn() {
        return null;
    }
}
