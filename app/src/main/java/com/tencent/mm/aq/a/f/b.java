package com.tencent.mm.aq.a.f;

import android.graphics.Bitmap;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.a.c.a;
import com.tencent.mm.aq.a.c.d;
import com.tencent.mm.aq.a.c.e;
import com.tencent.mm.aq.a.c.f;
import com.tencent.mm.aq.a.c.g;
import com.tencent.mm.aq.a.c.i;
import com.tencent.mm.aq.a.c.j;
import com.tencent.mm.aq.a.c.k;
import com.tencent.mm.aq.a.c.l;
import com.tencent.mm.aq.a.c.m;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.InputStream;

public final class b implements Runnable {
    private final com.tencent.mm.aq.a.a.b hCV = this.hEi.hCV;
    public final c hDn;
    private final m hDo;
    private final a hDp;
    private final com.tencent.mm.aq.a.c.b hDq;
    private final f hDr;
    private final j hDs;
    private final e hDu;
    private final com.tencent.mm.aq.a.b hEi;
    public final com.tencent.mm.aq.a.c hEk;
    private final af hEl;
    private final i hEm;
    private final g hEn;
    private final k hEo;
    private final d hEp;
    private final l hEq;
    public final String url;

    public b(String str, com.tencent.mm.aq.a.c cVar, af afVar, c cVar2, i iVar, j jVar, com.tencent.mm.aq.a.b bVar, g gVar, e eVar, d dVar, l lVar) {
        this.url = str;
        this.hEk = cVar;
        this.hEl = afVar;
        this.hEi = bVar;
        this.hEn = gVar;
        if (cVar2 == null) {
            this.hDn = this.hCV.hDn;
        } else {
            this.hDn = cVar2;
        }
        this.hEm = iVar;
        if (jVar == null) {
            this.hDs = this.hCV.hDs;
        } else {
            this.hDs = jVar;
        }
        if (this.hDn.hDq != null) {
            this.hDq = this.hDn.hDq;
        } else {
            this.hDq = this.hCV.hDq;
        }
        this.hDo = this.hCV.hDo;
        this.hDp = this.hCV.hDp;
        this.hDr = this.hCV.hDr;
        this.hEo = this.hCV.hDt;
        if (eVar == null) {
            this.hDu = this.hCV.hDu;
        } else {
            this.hDu = eVar;
        }
        this.hEp = dVar;
        this.hEq = lVar;
    }

    public final void run() {
        Bitmap bitmap = null;
        com.tencent.mm.aq.a.d.b bVar = new com.tencent.mm.aq.a.d.b();
        Exception e;
        Bitmap bitmap2;
        com.tencent.mm.aq.a.d.b bVar2;
        InputStream inputStream;
        try {
            Bitmap b;
            long currentTimeMillis;
            String lE = lE(this.url);
            x.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap from disk. key:%s", new Object[]{this.url});
            long currentTimeMillis2 = System.currentTimeMillis();
            int i = this.hDn.hDF;
            boolean z = this.hDn.hDI;
            String str = this.hDn.fqR;
            x.d("MicroMsg.imageloader.ImageLoadTask", "hy: should check md5:" + z);
            x.d("MicroMsg.imageloader.ImageLoadTask", "hy: fileType: %d", new Object[]{Integer.valueOf(i)});
            x.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] test view width:%d height:%d", new Object[]{Integer.valueOf(this.hEk.width), Integer.valueOf(this.hEk.height)});
            switch (i) {
                case 1:
                    String str2 = this.hDn.fvC;
                    if (!this.hDn.hDM || bh.ov(str2) || !com.tencent.mm.a.e.bO(str2)) {
                        if (!bh.ov(this.url)) {
                            if (!com.tencent.mm.a.e.bO(this.url)) {
                                if (this.hDn.hDN) {
                                    this.hDu.e(this.hDn.hEd);
                                }
                                x.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] file does not exist.");
                                break;
                            }
                            if (z) {
                                if (!this.hEo.an(str, this.url)) {
                                    x.w("MicroMsg.imageloader.ImageLoadTask", "hy: file md5 check failed");
                                    bitmap = null;
                                    break;
                                }
                            }
                            if (this.hDn.hEa) {
                                b = com.tencent.mm.aq.a.g.a.b(this.hEk, this.url, this.hDn.hDG, this.hDn.hDH);
                            } else if (this.hEp != null) {
                                b = com.tencent.mm.aq.a.g.a.a(this.hEk, this.hEp.f(this.hDn.hEd), this.hDn.hDG, this.hDn.hDH, this.hDn.hDO, this.hDn.alpha, this.hDn.hDJ);
                            } else {
                                b = com.tencent.mm.aq.a.g.a.a(this.hEk, this.url, this.hDn.hDG, this.hDn.hDH);
                            }
                            if (this.hDn.hEc && r3 == null && this.hEq != null) {
                                if (this.hEp != null) {
                                    b = this.hEq.I(this.hEp.f(this.hDn.hEd));
                                } else {
                                    b = this.hEq.lD(this.url);
                                }
                            }
                            if (b != null && this.hDn.density > 0) {
                                b.setDensity(this.hDn.density);
                            }
                            x.d("MicroMsg.imageloader.ImageLoadTask", "hy: file md5 check success or do not need md5 check");
                            bitmap = b;
                            break;
                        }
                        x.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] url is null.");
                        break;
                    }
                    if (this.hDn.hEa) {
                        b = com.tencent.mm.aq.a.g.a.b(this.hEk, str2, this.hDn.hDG, this.hDn.hDH);
                    } else {
                        b = com.tencent.mm.aq.a.g.a.a(this.hEk, str2, this.hDn.hDG, this.hDn.hDH);
                    }
                    try {
                        if (this.hDn.density <= 0) {
                            bitmap = b;
                            break;
                        }
                        b.setDensity(this.hDn.density);
                        bitmap = b;
                        break;
                    } catch (Exception e2) {
                        e = e2;
                        bitmap2 = b;
                        bVar2 = bVar;
                        break;
                    }
                case 2:
                    bitmap = com.tencent.mm.aq.a.g.a.c(this.hEk, this.url, this.hDn.hDG, this.hDn.hDH);
                    break;
                case 3:
                    bitmap = com.tencent.mm.aq.a.g.a.a(this.hEk, this.hCV.hDk.getIdentifier(this.url, "drawable", this.hCV.packageName), this.hDn.hDG, this.hDn.hDH);
                    break;
                case 4:
                    bitmap = com.tencent.mm.aq.a.g.a.a(this.hEk, Integer.valueOf(this.url).intValue(), this.hDn.hDG, this.hDn.hDH);
                    break;
                case 5:
                    inputStream = null;
                    Object obj = null;
                    inputStream = this.hDp.d(this.url, this.hDn);
                    if (inputStream == null) {
                        bitmap2 = null;
                    } else if (!z || this.hEo.b(str, inputStream)) {
                        Bitmap a;
                        com.tencent.mm.aq.a.c cVar = this.hEk;
                        int i2 = this.hDn.hDG;
                        int i3 = this.hDn.hDH;
                        boolean z2 = this.hDn.hDO;
                        float f = this.hDn.alpha;
                        boolean z3 = this.hDn.hDJ;
                        if (i2 > 0 && i3 > 0) {
                            a = com.tencent.mm.sdk.platformtools.d.a(inputStream, 0.0f, i2, i3);
                        } else if (cVar == null || cVar.width <= 0 || cVar.width <= 0) {
                            a = com.tencent.mm.sdk.platformtools.d.decodeStream(inputStream);
                        } else {
                            a = com.tencent.mm.sdk.platformtools.d.a(inputStream, 0.0f, cVar.width, cVar.height);
                        }
                        if (z2) {
                            a = com.tencent.mm.sdk.platformtools.d.a(a, i2, i3, false, true);
                        }
                        if (f > 0.0f) {
                            a = com.tencent.mm.sdk.platformtools.d.c(a, f);
                        }
                        if (z3) {
                            a = com.tencent.mm.sdk.platformtools.d.S(a);
                        }
                        bitmap2 = a;
                        obj = 1;
                    } else {
                        obj = 1;
                        bitmap2 = null;
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (obj != null && bitmap2 == null) {
                        try {
                            this.hDp.c(this.url, this.hDn);
                            bitmap = bitmap2;
                            break;
                        } catch (Exception e4) {
                            e = e4;
                            bVar2 = bVar;
                            break;
                        }
                    }
                    bitmap = bitmap2;
                    break;
                    break;
                default:
                    x.e("MicroMsg.imageloader.ImageLoadTask", "[cpan] unknow file type :%d", new Object[]{Integer.valueOf(i)});
                    break;
            }
            try {
                currentTimeMillis = System.currentTimeMillis();
            } catch (Exception e5) {
                e = e5;
                bVar2 = bVar;
                bitmap2 = bitmap;
            }
            Bitmap bitmap3;
            String str3;
            int min;
            i iVar;
            com.tencent.mm.aq.a.b bVar3;
            if (bitmap == null || bitmap.isRecycled()) {
                switch (i) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        x.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] run get bitmap failed");
                        bitmap3 = bitmap;
                        break;
                    case 5:
                        currentTimeMillis2 = System.currentTimeMillis();
                        x.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap from memory failed.now try to get from network.");
                        if (this.hEn != null) {
                            g gVar = this.hEn;
                            str3 = this.url;
                            this.hEk.Jr();
                            gVar.lC(str3);
                        }
                        bVar2 = this.hDq.lA(this.url);
                        if (bVar2 == null) {
                            try {
                                bVar = new com.tencent.mm.aq.a.d.b(null, null);
                            } catch (Exception e6) {
                                e = e6;
                                bitmap2 = bitmap;
                                break;
                            }
                        }
                        bVar = bVar2;
                        try {
                            if (bVar.data != null) {
                                if (z) {
                                    if (!this.hEo.i(str, bVar.data)) {
                                        bVar.status = 2;
                                        x.w("MicroMsg.imageloader.ImageLoadTask", "hy: image data md5 check failed");
                                        bitmap3 = null;
                                        break;
                                    }
                                }
                                x.d("MicroMsg.imageloader.ImageLoadTask", "hy: image data md5 check success or do not need md5 check");
                                long currentTimeMillis3 = System.currentTimeMillis();
                                b = com.tencent.mm.aq.a.g.a.a(this.hEk, bVar.data, this.hDn.hDG, this.hDn.hDH, this.hDn.hDO, this.hDn.alpha, this.hDn.hDJ);
                                if (b != null) {
                                    byte[] bArr = bVar.data;
                                    if (this.hDn.hDA) {
                                        this.hDp.a(this.url, bArr, this.hDn);
                                    }
                                    if (this.hDn.hDz) {
                                        this.hDp.a(this.url, bArr, this.hDn);
                                    }
                                    if (this.hDn.hDY) {
                                        if (this.hDn.hDZ != 0.0f) {
                                            b = com.tencent.mm.sdk.platformtools.d.a(b, false, this.hDn.hDZ);
                                        } else if (b.getWidth() == b.getHeight()) {
                                            b = com.tencent.mm.sdk.platformtools.d.a(b, false, (float) (b.getWidth() / 2));
                                        } else {
                                            min = Math.min(b.getWidth(), b.getHeight());
                                            if (min <= 0) {
                                                min = Math.max(b.getWidth(), b.getHeight());
                                            }
                                            b = com.tencent.mm.sdk.platformtools.d.a(b, min, min, true);
                                            b = com.tencent.mm.sdk.platformtools.d.a(b, false, (float) (b.getWidth() / 2));
                                        }
                                    }
                                    b = a(bVar, b);
                                    j(lE, b);
                                    bm(currentTimeMillis3 - currentTimeMillis2);
                                    bitmap3 = b;
                                    break;
                                }
                                try {
                                    bVar.status = 3;
                                    bitmap3 = b;
                                    break;
                                } catch (Exception e7) {
                                    e = e7;
                                    bitmap2 = b;
                                    bVar2 = bVar;
                                    break;
                                }
                            }
                            bVar.status = 1;
                            bitmap3 = bitmap;
                            break;
                        } catch (Exception e8) {
                            e = e8;
                            bVar2 = bVar;
                            bitmap2 = bitmap;
                            break;
                        }
                    default:
                        x.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] run unknow file type");
                        bitmap3 = bitmap;
                        break;
                }
                x.e("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. exception. %s", new Object[]{e.toString()});
                bVar = bVar2;
                bitmap3 = bitmap2;
                if (bitmap3 != null || bitmap3.isRecycled()) {
                    x.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap failed");
                } else {
                    x.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap successs.");
                    if (this.hDn.hDK) {
                        bitmap3 = com.tencent.mm.sdk.platformtools.d.c(bitmap3, this.hDn.hDL);
                    }
                    Runnable cVar2 = new c(this.url, this.hEk, bitmap3, this.hEi, lE(this.url));
                    if (this.hEl != null) {
                        this.hEl.post(cVar2);
                    }
                    bVar.bitmap = bitmap3;
                }
                if (!(this.hEn == null || bVar == null)) {
                    bVar.bitmap = bitmap3;
                    this.hEn.a(this.url, this.hEk.Jr(), bVar);
                }
                iVar = this.hEm;
                str3 = this.url;
                this.hEk.Jr();
                iVar.a(str3, bitmap3, this.hDn.hEd);
                bVar3 = this.hEi;
                if (bVar3.hCZ != null && this != null && this.hEk != null) {
                    bVar3.hCZ.remove(Integer.valueOf(this.hEk.PI()));
                    return;
                }
                return;
            }
            if (!this.hDn.hDY) {
                b = bitmap;
            } else if (this.hDn.hDZ != 0.0f) {
                b = com.tencent.mm.sdk.platformtools.d.a(bitmap, false, this.hDn.hDZ);
            } else if (bitmap.getWidth() == bitmap.getHeight()) {
                b = com.tencent.mm.sdk.platformtools.d.a(bitmap, false, (float) (bitmap.getWidth() / 2));
            } else {
                min = Math.min(bitmap.getWidth(), bitmap.getHeight());
                if (min <= 0) {
                    min = Math.max(bitmap.getWidth(), bitmap.getHeight());
                }
                b = com.tencent.mm.sdk.platformtools.d.a(bitmap, min, min, true);
                b = com.tencent.mm.sdk.platformtools.d.a(b, false, (float) (b.getWidth() / 2));
            }
            b = a(bVar, b);
            j(lE, b);
            bm(currentTimeMillis - currentTimeMillis2);
            x.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap from disk success.");
            bitmap3 = b;
            if (bitmap3 != null) {
            }
            x.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap failed");
            bVar.bitmap = bitmap3;
            this.hEn.a(this.url, this.hEk.Jr(), bVar);
            iVar = this.hEm;
            str3 = this.url;
            this.hEk.Jr();
            iVar.a(str3, bitmap3, this.hDn.hEd);
            bVar3 = this.hEi;
            if (bVar3.hCZ != null) {
            }
        } catch (Exception e9) {
            e = e9;
            bVar2 = bVar;
            bitmap2 = null;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e10) {
                }
            }
        }
    }

    private void j(String str, Bitmap bitmap) {
        if (this.hDn.hDy) {
            x.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. put key %s to memory cache.", new Object[]{this.url});
            this.hDo.c(str, bitmap);
        }
    }

    private Bitmap a(com.tencent.mm.aq.a.d.b bVar, Bitmap bitmap) {
        if (this.hEn == null || bVar == null) {
            return bitmap;
        }
        bVar.bitmap = bitmap;
        g gVar = this.hEn;
        String str = this.url;
        this.hEk.Jr();
        Bitmap a = gVar.a(str, bVar);
        if (a == null || a.isRecycled()) {
            return bitmap;
        }
        return a;
    }

    public final String lE(String str) {
        if (bh.ov(str) || this.hDn == null) {
            return null;
        }
        if (this.hDn.hDY) {
            str = str + "round" + this.hDn.hDZ;
        }
        if (!bh.ov(this.hDn.hDV)) {
            str = str + this.hDn.hDV;
        }
        return str + "size" + this.hDn.hDG + this.hDn.hDH;
    }

    public final void bm(long j) {
        if (this.hDs != null) {
            this.hDs.bm(j);
        }
    }
}
