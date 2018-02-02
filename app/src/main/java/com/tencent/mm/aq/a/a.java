package com.tencent.mm.aq.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.aq.a.a.b;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.a.b.g;
import com.tencent.mm.aq.a.c.d;
import com.tencent.mm.aq.a.c.e;
import com.tencent.mm.aq.a.c.i;
import com.tencent.mm.aq.a.c.j;
import com.tencent.mm.aq.a.c.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.ExecutorService;

public final class a {
    private static a hCU = null;
    public b hCR;
    private b hCS;
    private final i hCT = new g();

    public static synchronized a PH() {
        a aVar;
        synchronized (a.class) {
            if (hCU == null) {
                hCU = new a(ac.getContext());
            }
            aVar = hCU;
        }
        return aVar;
    }

    public a(Context context) {
        a(b.bl(context));
    }

    public a(b bVar) {
        a(bVar);
    }

    private synchronized void a(b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("[cpan] image loader configuration is null.");
        } else if (this.hCS == null) {
            this.hCR = new b(bVar);
            this.hCS = bVar;
        } else {
            x.w("MicroMsg.imageloader.ImageLoader", "[cpan] image loader had init.");
        }
    }

    public final void a(String str, ImageView imageView) {
        a(str, imageView, null, null, null, null, null, null, null);
    }

    public final void a(String str, ImageView imageView, com.tencent.mm.aq.a.c.g gVar) {
        a(str, imageView, null, null, null, gVar, null, null, null);
    }

    public final void a(String str, ImageView imageView, c cVar, com.tencent.mm.aq.a.c.g gVar) {
        a(str, imageView, cVar, null, null, gVar, null, null, null);
    }

    public final void a(String str, ImageView imageView, c cVar, i iVar, com.tencent.mm.aq.a.c.g gVar) {
        a(str, imageView, cVar, iVar, null, gVar, null, null, null);
    }

    public final void a(String str, ImageView imageView, c cVar) {
        a(str, imageView, cVar, null, null, null, null, null, null);
    }

    public final void a(String str, ImageView imageView, c cVar, e eVar, d dVar, l lVar) {
        a(str, imageView, cVar, null, null, null, eVar, dVar, lVar);
    }

    public final void a(String str, ImageView imageView, c cVar, i iVar) {
        a(str, imageView, cVar, iVar, null, null, null, null, null);
    }

    public final void a(String str, ImageView imageView, c cVar, i iVar, j jVar, com.tencent.mm.aq.a.c.g gVar, e eVar, d dVar, l lVar) {
        c cVar2;
        i iVar2;
        if (cVar == null) {
            cVar2 = this.hCS.hDn;
        } else {
            cVar2 = cVar;
        }
        if (iVar == null) {
            iVar2 = this.hCT;
        } else {
            iVar2 = iVar;
        }
        c cVar3 = new c(imageView, str);
        if (imageView == null || cVar2 == null) {
            x.w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default background view or options is null.");
        } else {
            Object obj = (cVar2.hDT > 0 || cVar2.hDU != null) ? 1 : null;
            if (obj == null) {
                imageView.setBackgroundDrawable(null);
            } else if (cVar2.hDT == 0) {
                imageView.setBackgroundDrawable(cVar2.hDT != 0 ? this.hCS.hDk.getDrawable(cVar2.hDT) : cVar2.hDU);
            } else {
                imageView.setBackgroundResource(cVar2.hDT);
            }
        }
        if (bh.ov(str)) {
            x.w("MicroMsg.imageloader.ImageLoader", "[cpan load image url is null.]");
            a(imageView, cVar2);
            this.hCR.a(cVar3);
            iVar2.a(str, null, cVar2.hEd);
            return;
        }
        af afVar = cVar2.handler;
        if (afVar == null || Looper.myLooper() == Looper.getMainLooper()) {
            afVar = new af();
        }
        Runnable bVar = new com.tencent.mm.aq.a.f.b(str, cVar3, afVar, cVar2, iVar2, jVar, this.hCR, gVar, eVar, dVar, lVar);
        Bitmap lz = this.hCR.lz(bVar.lE(str));
        if (imageView == null || lz == null || lz.isRecycled()) {
            if (imageView != null) {
                a(imageView, cVar2);
            }
            if (bVar.hDn.hDB || !this.hCR.hCW.vg()) {
                Object obj2;
                b bVar2;
                com.tencent.mm.aq.a.f.b bVar3;
                boolean z;
                b bVar4 = this.hCR;
                if (!bh.ov(str)) {
                    String str2 = (String) bVar4.hCY.get(Integer.valueOf(cVar3.PI()));
                    if (bh.ov(str2) || !str.equals(str2)) {
                        bVar4.hCY.put(Integer.valueOf(cVar3.PI()), str);
                        obj2 = 1;
                        if (obj2 != null) {
                            bVar2 = this.hCR;
                            if (!(bVar2.hCZ == null || bVar.hEk == null)) {
                                bVar3 = (com.tencent.mm.aq.a.f.b) bVar2.hCZ.get(Integer.valueOf(bVar.hEk.PI()));
                                if (!(bVar3 == null || bVar3.hEk == null || bVar.hEk.PI() != bVar3.hEk.PI())) {
                                    bVar2.hCW.remove(bVar3);
                                    x.d("MicroMsg.imageloader.ImageLoaderManager", "remove taks url:%s", bVar3.url);
                                }
                                bVar2.hCZ.put(Integer.valueOf(bVar.hEk.PI()), bVar);
                            }
                            bVar2 = this.hCR;
                            z = cVar2.hDz;
                            if (((ExecutorService) bVar2.hCV.hDv).isShutdown()) {
                                bVar2.hCW = com.tencent.mm.aq.a.a.a.bb(bVar2.hCV.hDl, bVar2.hCV.hDm);
                            }
                            bVar2.hCW.execute(bVar);
                            if (z && com.tencent.mm.aq.a.g.b.PN()) {
                                bVar2.hCX.execute(new com.tencent.mm.aq.a.f.d());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                obj2 = null;
                if (obj2 != null) {
                    bVar2 = this.hCR;
                    bVar3 = (com.tencent.mm.aq.a.f.b) bVar2.hCZ.get(Integer.valueOf(bVar.hEk.PI()));
                    bVar2.hCW.remove(bVar3);
                    x.d("MicroMsg.imageloader.ImageLoaderManager", "remove taks url:%s", bVar3.url);
                    bVar2.hCZ.put(Integer.valueOf(bVar.hEk.PI()), bVar);
                    bVar2 = this.hCR;
                    z = cVar2.hDz;
                    if (((ExecutorService) bVar2.hCV.hDv).isShutdown()) {
                        bVar2.hCW = com.tencent.mm.aq.a.a.a.bb(bVar2.hCV.hDl, bVar2.hCV.hDm);
                    }
                    bVar2.hCW.execute(bVar);
                    if (z) {
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        x.d("MicroMsg.imageloader.ImageLoader", "[cpan] load from cache. not need to load:%s", r5);
        if (cVar2.hDK) {
            lz = com.tencent.mm.sdk.platformtools.d.c(lz, cVar2.hDL);
        }
        imageView.setImageBitmap(lz);
        bVar.bm(0);
        if (gVar != null) {
            gVar.a(str, imageView, new com.tencent.mm.aq.a.d.b(lz));
        }
        this.hCR.a(cVar3);
    }

    public final void bp(int i) {
        x.d("MicroMsg.imageloader.ImageLoader", "[cpan] on scroll state changed :%d", Integer.valueOf(i));
        if (i == 0 || i == 1) {
            x.d("MicroMsg.imageloader.ImageLoader", "[cpan] resume");
            this.hCR.hCW.resume();
            return;
        }
        x.d("MicroMsg.imageloader.ImageLoader", "[cpan] pause");
        this.hCR.hCW.pause();
    }

    public final void detach() {
        if (this.hCR != null) {
            b bVar = this.hCR;
            if (bVar.hCV != null) {
                bVar.hCV.hDo.clear();
                bVar.hCV.hDp.PL();
            }
        }
    }

    public final Bitmap lz(String str) {
        if (this.hCR != null) {
            return this.hCR.lz(str);
        }
        return null;
    }

    public final void i(String str, Bitmap bitmap) {
        if (this.hCR != null) {
            b bVar = this.hCR;
            if (bVar.hCV != null) {
                bVar.hCV.hDo.c(str, bitmap);
            }
        }
    }

    private void a(ImageView imageView, c cVar) {
        if (imageView == null || cVar == null) {
            x.w("MicroMsg.imageloader.ImageLoader", "[cpan] should show default image view or options is null.");
            return;
        }
        Object obj = (cVar.hDP > 0 || cVar.hDQ != null) ? 1 : null;
        if (obj != null) {
            if (cVar.hDP == 0) {
                imageView.setImageDrawable(cVar.hDP != 0 ? this.hCS.hDk.getDrawable(cVar.hDP) : cVar.hDQ);
            } else {
                imageView.setImageResource(cVar.hDP);
            }
        } else if (cVar.hDX) {
            imageView.setImageDrawable(null);
        }
    }

    public final void a(String str, c cVar, com.tencent.mm.aq.a.c.c cVar2) {
        this.hCR.hCW.execute(new com.tencent.mm.aq.a.f.a(str, cVar, this.hCR, cVar2));
    }
}
