package com.tencent.tinker.c.a;

import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.tinker.a.a.b;
import com.tencent.tinker.a.a.d;
import com.tencent.tinker.a.a.e;
import com.tencent.tinker.a.a.f;
import com.tencent.tinker.a.a.g;
import com.tencent.tinker.a.a.h;
import com.tencent.tinker.a.a.k;
import com.tencent.tinker.a.a.n;
import com.tencent.tinker.a.a.p;
import com.tencent.tinker.a.a.r;
import com.tencent.tinker.a.a.s;
import com.tencent.tinker.a.a.t;
import com.tencent.tinker.a.a.u;
import com.tencent.tinker.c.a.a.a.i;
import com.tencent.tinker.c.a.a.a.j;
import com.tencent.tinker.c.a.a.a.l;
import com.tencent.tinker.c.a.a.a.m;
import com.tencent.tinker.c.a.a.a.o;
import com.tencent.tinker.c.a.c.c;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public final class a {
    private i<k> AgA;
    private i<d> AgB;
    private final com.tencent.tinker.a.a.i Agj;
    private final com.tencent.tinker.a.a.i Agk;
    private final com.tencent.tinker.c.a.b.a Agl;
    private final c Agm;
    private i<s> Agn;
    private i<Integer> Ago;
    private i<r> Agp;
    private i<n> Agq;
    private i<p> Agr;
    private i<f> Ags;
    private i<u> Agt;
    private i<com.tencent.tinker.a.a.c> Agu;
    private i<b> Agv;
    private i<e> Agw;
    private i<g> Agx;
    private i<h> Agy;
    private i<com.tencent.tinker.a.a.a> Agz;

    public a(InputStream inputStream, InputStream inputStream2) {
        this(new com.tencent.tinker.a.a.i(inputStream), new com.tencent.tinker.c.a.b.a(inputStream2));
    }

    private a(com.tencent.tinker.a.a.i iVar, com.tencent.tinker.c.a.b.a aVar) {
        this.Agj = iVar;
        this.Agl = aVar;
        this.Agk = new com.tencent.tinker.a.a.i(aVar.Ahk);
        this.Agm = new c();
    }

    public final void b(OutputStream outputStream) {
        int i = 0;
        byte[] nX = this.Agj.nX(false);
        if (nX == null) {
            throw new IOException("failed to compute old dex's signature.");
        } else if (this.Agl == null) {
            throw new IllegalArgumentException("patch file is null.");
        } else {
            if (com.tencent.tinker.a.a.b.c.m(nX, this.Agl.AhD) != 0) {
                throw new IOException(String.format("old dex signature mismatch! expected: %s, actual: %s", new Object[]{Arrays.toString(nX), Arrays.toString(this.Agl.AhD)}));
            }
            t tVar = this.Agk.AeT;
            tVar.Afo.dzw = 0;
            tVar.Afo.size = 1;
            tVar.Afv.size = 1;
            tVar.Afp.dzw = this.Agl.Ahm;
            tVar.Afq.dzw = this.Agl.Ahn;
            tVar.Afw.dzw = this.Agl.Aht;
            tVar.Afr.dzw = this.Agl.Aho;
            tVar.Afs.dzw = this.Agl.Ahp;
            tVar.Aft.dzw = this.Agl.Ahq;
            tVar.Afu.dzw = this.Agl.Ahr;
            tVar.Afv.dzw = this.Agl.Ahs;
            tVar.AfB.dzw = this.Agl.Ahy;
            tVar.AfD.dzw = this.Agl.AhA;
            tVar.Afy.dzw = this.Agl.Ahv;
            tVar.Afx.dzw = this.Agl.Ahu;
            tVar.AfF.dzw = this.Agl.AhC;
            tVar.AfE.dzw = this.Agl.AhB;
            tVar.AfC.dzw = this.Agl.Ahz;
            tVar.AfA.dzw = this.Agl.Ahx;
            tVar.Afz.dzw = this.Agl.Ahw;
            tVar.fileSize = this.Agl.Ahk;
            Arrays.sort(tVar.AfG);
            tVar.cGO();
            this.Agn = new com.tencent.tinker.c.a.a.a.n(this.Agl, this.Agj, this.Agk, this.Agm);
            this.Ago = new o(this.Agl, this.Agj, this.Agk, this.Agm);
            this.Agp = new l(this.Agl, this.Agj, this.Agk, this.Agm);
            this.Agq = new j(this.Agl, this.Agj, this.Agk, this.Agm);
            this.Agr = new com.tencent.tinker.c.a.a.a.k(this.Agl, this.Agj, this.Agk, this.Agm);
            this.Ags = new com.tencent.tinker.c.a.a.a.f(this.Agl, this.Agj, this.Agk, this.Agm);
            this.Agt = new com.tencent.tinker.c.a.a.a.p(this.Agl, this.Agj, this.Agk, this.Agm);
            this.Agu = new com.tencent.tinker.c.a.a.a.b(this.Agl, this.Agj, this.Agk, this.Agm);
            this.Agv = new com.tencent.tinker.c.a.a.a.c(this.Agl, this.Agj, this.Agk, this.Agm);
            this.Agw = new com.tencent.tinker.c.a.a.a.e(this.Agl, this.Agj, this.Agk, this.Agm);
            this.Agx = new com.tencent.tinker.c.a.a.a.g(this.Agl, this.Agj, this.Agk, this.Agm);
            this.Agy = new com.tencent.tinker.c.a.a.a.h(this.Agl, this.Agj, this.Agk, this.Agm);
            this.Agz = new com.tencent.tinker.c.a.a.a.a(this.Agl, this.Agj, this.Agk, this.Agm);
            this.AgA = new m(this.Agl, this.Agj, this.Agk, this.Agm);
            this.AgB = new com.tencent.tinker.c.a.a.a.d(this.Agl, this.Agj, this.Agk, this.Agm);
            this.Agn.execute();
            this.Ago.execute();
            this.Agt.execute();
            this.Agp.execute();
            this.Agq.execute();
            this.Agr.execute();
            this.Agz.execute();
            this.Agv.execute();
            this.Agu.execute();
            this.AgB.execute();
            this.Agy.execute();
            this.Agx.execute();
            this.Agw.execute();
            this.AgA.execute();
            this.Ags.execute();
            com.tencent.tinker.a.a.i.e Id = this.Agk.Id(tVar.Afo.dzw);
            Id.write(("dex\n" + "035" + "\u0000").getBytes("UTF-8"));
            Id.writeInt(tVar.hXE);
            Id.write(tVar.Afc);
            Id.writeInt(tVar.fileSize);
            Id.writeInt(MMGIFException.D_GIF_ERR_IMAGE_DEFECT);
            Id.writeInt(305419896);
            Id.writeInt(tVar.AfH);
            Id.writeInt(tVar.AfI);
            Id.writeInt(tVar.Afv.dzw);
            Id.writeInt(tVar.Afp.size);
            Id.writeInt(tVar.Afp.exists() ? tVar.Afp.dzw : 0);
            Id.writeInt(tVar.Afq.size);
            Id.writeInt(tVar.Afq.exists() ? tVar.Afq.dzw : 0);
            Id.writeInt(tVar.Afr.size);
            Id.writeInt(tVar.Afr.exists() ? tVar.Afr.dzw : 0);
            Id.writeInt(tVar.Afs.size);
            Id.writeInt(tVar.Afs.exists() ? tVar.Afs.dzw : 0);
            Id.writeInt(tVar.Aft.size);
            Id.writeInt(tVar.Aft.exists() ? tVar.Aft.dzw : 0);
            Id.writeInt(tVar.Afu.size);
            if (tVar.Afu.exists()) {
                i = tVar.Afu.dzw;
            }
            Id.writeInt(i);
            Id.writeInt(tVar.AfJ);
            Id.writeInt(tVar.AfK);
            tVar.b(this.Agk.Id(tVar.Afv.dzw));
            this.Agk.cGp();
            outputStream.write(this.Agk.aif.array());
            outputStream.flush();
        }
    }
}
