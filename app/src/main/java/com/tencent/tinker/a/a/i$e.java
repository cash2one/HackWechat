package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.a.a;
import java.nio.ByteBuffer;

public final class i$e extends a {
    final /* synthetic */ i Afd;
    private final String name;

    private i$e(i iVar, String str, ByteBuffer byteBuffer) {
        this.Afd = iVar;
        super(byteBuffer);
        this.name = str;
    }

    public final s cGq() {
        a(i.a(this.Afd).AfB, false);
        return super.cGq();
    }

    public final u cGr() {
        a(i.a(this.Afd).Afw, false);
        return super.cGr();
    }

    public final n cGs() {
        a(i.a(this.Afd).Afs, false);
        return super.cGs();
    }

    public final p cGt() {
        a(i.a(this.Afd).Aft, false);
        return super.cGt();
    }

    public final r cGu() {
        a(i.a(this.Afd).Afr, false);
        return super.cGu();
    }

    public final f cGv() {
        a(i.a(this.Afd).Afu, false);
        return super.cGv();
    }

    public final g cGw() {
        a(i.a(this.Afd).AfA, false);
        return super.cGw();
    }

    public final h cGx() {
        a(i.a(this.Afd).AfC, false);
        return super.cGx();
    }

    public final e cGy() {
        a(i.a(this.Afd).Afz, false);
        return super.cGy();
    }

    public final a cGz() {
        a(i.a(this.Afd).AfD, false);
        return super.cGz();
    }

    public final b cGA() {
        a(i.a(this.Afd).Afy, false);
        return super.cGA();
    }

    public final c cGB() {
        a(i.a(this.Afd).Afx, false);
        return super.cGB();
    }

    public final d cGC() {
        a(i.a(this.Afd).AfF, false);
        return super.cGC();
    }

    public final k cGD() {
        a(i.a(this.Afd).AfE, false);
        return super.cGD();
    }

    private void a(t.a aVar, boolean z) {
        if (!aVar.AfM) {
            return;
        }
        if (z) {
            super.Ih((((this.aif.position() + 3) & -4) - this.aif.position()) * 1);
            while ((this.aif.position() & 3) != 0) {
                this.aif.put((byte) 0);
            }
            if (this.aif.position() > this.AfS) {
                this.AfS = this.aif.position();
                return;
            }
            return;
        }
        this.aif.position((this.aif.position() + 3) & -4);
    }

    public final int a(s sVar) {
        a(i.a(this.Afd).AfB, true);
        return super.a(sVar);
    }

    public final int a(u uVar) {
        a(i.a(this.Afd).Afw, true);
        return super.a(uVar);
    }

    public final int a(n nVar) {
        a(i.a(this.Afd).Afs, true);
        return super.a(nVar);
    }

    public final int a(p pVar) {
        a(i.a(this.Afd).Aft, true);
        return super.a(pVar);
    }

    public final int a(r rVar) {
        a(i.a(this.Afd).Afr, true);
        return super.a(rVar);
    }

    public final int a(f fVar) {
        a(i.a(this.Afd).Afu, true);
        return super.a(fVar);
    }

    public final int a(g gVar) {
        a(i.a(this.Afd).AfA, true);
        return super.a(gVar);
    }

    public final int a(h hVar) {
        a(i.a(this.Afd).AfC, true);
        return super.a(hVar);
    }

    public final int a(e eVar) {
        a(i.a(this.Afd).Afz, true);
        return super.a(eVar);
    }

    public final int a(a aVar) {
        a(i.a(this.Afd).AfD, true);
        return super.a(aVar);
    }

    public final int a(b bVar) {
        a(i.a(this.Afd).Afy, true);
        return super.a(bVar);
    }

    public final int a(c cVar) {
        a(i.a(this.Afd).Afx, true);
        return super.a(cVar);
    }

    public final int a(d dVar) {
        a(i.a(this.Afd).AfF, true);
        return super.a(dVar);
    }

    public final int a(k kVar) {
        a(i.a(this.Afd).AfE, true);
        return super.a(kVar);
    }
}
