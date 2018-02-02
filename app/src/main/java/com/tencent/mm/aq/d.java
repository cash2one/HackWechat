package com.tencent.mm.aq;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.f;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class d implements e, f {
    List<b> hzD = new LinkedList();
    private HashSet<b> hzE = new HashSet();
    b hzF = null;
    private k hzG = null;
    public boolean hzH = false;

    public interface a {
        void a(long j, long j2, int i, int i2, Object obj);

        void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, k kVar);

        void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, k kVar);
    }

    public d() {
        g.Di().gPJ.a(109, this);
    }

    public final boolean a(long j, long j2, int i, Object obj, int i2, a aVar) {
        return a(j, j2, i, obj, i2, aVar, -1) >= 0;
    }

    public final int a(long j, long j2, int i, Object obj, int i2, a aVar, int i3) {
        if (aVar == null) {
            x.e("ModelImage.DownloadImgService", "listener is null");
            return -1;
        }
        b bVar = new b(j, j2, i);
        bVar.hzL = i2;
        if (this.hzE.contains(bVar)) {
            x.e("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] add failed, task already done");
            return -2;
        } else if (this.hzF != null && bVar.equals(this.hzF)) {
            return this.hzF.a(aVar, obj) ? 0 : -3;
        } else {
            int indexOf = this.hzD.indexOf(bVar);
            if (indexOf >= 0 && indexOf < this.hzD.size()) {
                return ((b) this.hzD.get(indexOf)).a(aVar, obj) ? 0 : -4;
            } else {
                x.i("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] no found task, create a new task(" + j + " " + j2 + " " + i + ")");
                bVar.a(aVar, obj);
                this.hzD.add(bVar);
                hI(i3);
                return 0;
            }
        }
    }

    public final boolean a(long j, long j2, int i) {
        b bVar = new b(j, j2, i);
        if ((this.hzF == null || !this.hzF.equals(bVar)) && this.hzD.indexOf(bVar) < 0) {
            return false;
        }
        return true;
    }

    public final boolean a(long j, long j2, a aVar) {
        if (aVar == null) {
            x.e("ModelImage.DownloadImgService", "listener is null");
            return false;
        }
        b bVar = new b(j, j2, 1);
        b bVar2 = null;
        if (this.hzF == null || !this.hzF.equals(bVar)) {
            int indexOf = this.hzD.indexOf(bVar);
            if (-1 != indexOf) {
                bVar2 = (b) this.hzD.get(indexOf);
            }
        } else {
            bVar2 = this.hzF;
        }
        if (bVar2 != null) {
            bVar2.b(aVar);
            a(bVar2);
            x.i("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] task has been canceled, (" + j + ", " + j2 + ", 1)");
            return true;
        }
        x.e("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] task no found, (" + j + ", " + j2 + ", 1)");
        return false;
    }

    public final void a(a aVar) {
        if (aVar == null) {
            x.e("ModelImage.DownloadImgService", "listener is null");
            return;
        }
        x.i("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] cancel all tasks of listener");
        this.hzH = true;
        if (this.hzF != null) {
            this.hzF.b(aVar);
            a(this.hzF);
        }
        List<b> linkedList = new LinkedList();
        for (b add : this.hzD) {
            linkedList.add(add);
        }
        for (b add2 : linkedList) {
            add2.b(aVar);
            a(add2);
        }
        Pc();
    }

    private boolean a(b bVar) {
        if (bVar == null || bVar.hzM.size() > 0) {
            return false;
        }
        return b(bVar);
    }

    public final boolean l(long j, long j2) {
        return b(new b(j, j2, 1));
    }

    final boolean b(b bVar) {
        if (bVar == null) {
            x.e("ModelImage.DownloadImgService", "task is null");
            return false;
        }
        x.i("ModelImage.DownloadImgService", "cancel scene, (" + bVar.hzI + ", " + bVar.hzJ + ", " + bVar.hzK + ")");
        if (this.hzF != null && this.hzF.equals(bVar)) {
            g.Di().gPJ.c(this.hzG);
            this.hzG = null;
            c(this.hzF);
            this.hzF = null;
            hI(-1);
            return true;
        } else if (!this.hzD.contains(bVar)) {
            return false;
        } else {
            b bVar2 = (b) this.hzD.get(this.hzD.indexOf(bVar));
            if (bVar2 != null) {
                this.hzD.remove(bVar2);
                c(bVar2);
            }
            return true;
        }
    }

    private static void c(b bVar) {
        if (bVar == null) {
            x.e("ModelImage.DownloadImgService", "task is null");
        } else if (bVar.hzM == null) {
            x.e("ModelImage.DownloadImgService", "task callback list is null");
        } else {
            for (c cVar : bVar.hzM) {
                if (cVar.hzN != null) {
                    cVar.hzN.a(bVar.hzI, bVar.hzJ, bVar.hzK, bVar.hzL, cVar.hzO);
                }
            }
        }
    }

    public final void Pc() {
        this.hzH = false;
        hI(-1);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.hzG != kVar) {
            x.d("ModelImage.DownloadImgService", "scene changed");
            return;
        }
        this.hzE.add(new b(this.hzF.hzI, this.hzF.hzJ, this.hzF.hzK));
        x.i("ModelImage.DownloadImgService", "scene end, (" + this.hzF.hzI + ", " + this.hzF.hzJ + ", " + this.hzF.hzK + ")");
        for (c cVar : this.hzF.hzM) {
            if (cVar.hzN != null) {
                cVar.hzN.a(this.hzF.hzI, this.hzF.hzJ, this.hzF.hzK, this.hzF.hzL, cVar.hzO, i, i2, str, kVar);
            }
        }
        this.hzF = null;
        this.hzG = null;
        hI(-1);
    }

    public final void a(int i, int i2, k kVar) {
        if (this.hzG != kVar) {
            x.d("ModelImage.DownloadImgService", "scene changed");
            return;
        }
        for (c cVar : this.hzF.hzM) {
            if (cVar.hzN != null) {
                cVar.hzN.a(this.hzF.hzI, this.hzF.hzJ, this.hzF.hzK, this.hzF.hzL, cVar.hzO, i, i2, kVar);
            }
        }
    }

    private void hI(int i) {
        if (this.hzF == null && this.hzD.size() > 0 && true != this.hzH) {
            this.hzF = (b) this.hzD.get(0);
            this.hzD.remove(0);
            this.hzG = new k(this.hzF.hzI, this.hzF.hzJ, this.hzF.hzK, this, i);
            this.hzG.hBr = this.hzF.hzL;
            x.i("ModelImage.DownloadImgService", "do scene, (" + this.hzF.hzI + ", " + this.hzF.hzJ + ", " + this.hzF.hzK + ")");
            g.Di().gPJ.a(this.hzG, 0);
        }
    }
}
