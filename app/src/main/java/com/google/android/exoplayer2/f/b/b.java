package com.google.android.exoplayer2.f.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region.Op;
import android.util.SparseArray;
import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.t;
import com.tencent.mm.plugin.appbrand.jsapi.map.h;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class b {
    private static final byte[] axA = new byte[]{(byte) 0, (byte) 7, (byte) 8, (byte) 15};
    private static final byte[] axB = new byte[]{(byte) 0, (byte) 119, (byte) -120, (byte) -1};
    private static final byte[] axC = new byte[]{(byte) 0, (byte) 17, (byte) 34, (byte) 51, (byte) 68, (byte) 85, (byte) 102, (byte) 119, (byte) -120, (byte) -103, (byte) -86, (byte) -69, (byte) -52, (byte) -35, (byte) -18, (byte) -1};
    private final Paint axD = new Paint();
    private final Paint axE;
    private final Canvas axF;
    private final b axG;
    private final a axH;
    final h axI;
    private Bitmap bitmap;

    public b(int i, int i2) {
        this.axD.setStyle(Style.FILL_AND_STROKE);
        this.axD.setXfermode(new PorterDuffXfermode(Mode.SRC));
        this.axD.setPathEffect(null);
        this.axE = new Paint();
        this.axE.setStyle(Style.FILL);
        this.axE.setXfermode(new PorterDuffXfermode(Mode.DST_OVER));
        this.axE.setPathEffect(null);
        this.axF = new Canvas();
        this.axG = new b(719, 575, 0, 719, 0, 575);
        this.axH = new a(0, la(), lb(), lc());
        this.axI = new h(i, i2);
    }

    public final List<a> e(byte[] bArr, int i) {
        int cT;
        int cT2;
        a b;
        i iVar = new i(bArr, i);
        while (iVar.lA() >= 48 && iVar.cT(8) == 15) {
            h hVar = this.axI;
            int cT3 = iVar.cT(8);
            int cT4 = iVar.cT(16);
            int cT5 = iVar.cT(16);
            int lB = iVar.lB() + cT5;
            if (cT5 * 8 > iVar.lA()) {
                iVar.cS(iVar.lA());
            } else {
                int cT6;
                int cT7;
                d dVar;
                switch (cT3) {
                    case 16:
                        if (cT4 == hVar.ayk) {
                            d dVar2 = hVar.ayr;
                            cT = iVar.cT(8);
                            cT2 = iVar.cT(4);
                            cT6 = iVar.cT(2);
                            iVar.cS(2);
                            cT3 = cT5 - 2;
                            SparseArray sparseArray = new SparseArray();
                            while (cT3 > 0) {
                                cT7 = iVar.cT(8);
                                iVar.cS(8);
                                cT3 -= 6;
                                sparseArray.put(cT7, new e(iVar.cT(16), iVar.cT(16)));
                            }
                            dVar = new d(cT, cT2, cT6, sparseArray);
                            if (dVar.state == 0) {
                                if (!(dVar2 == null || dVar2.version == dVar.version)) {
                                    hVar.ayr = dVar;
                                    break;
                                }
                            }
                            hVar.ayr = dVar;
                            hVar.axU.clear();
                            hVar.aym.clear();
                            hVar.ayn.clear();
                            break;
                        }
                        break;
                    case 17:
                        dVar = hVar.ayr;
                        if (cT4 == hVar.ayk && dVar != null) {
                            f a = a(iVar, cT5);
                            if (dVar.state == 0) {
                                a.a((f) hVar.axU.get(a.id));
                            }
                            hVar.axU.put(a.id, a);
                            break;
                        }
                    case 18:
                        if (cT4 != hVar.ayk) {
                            if (cT4 == hVar.ayl) {
                                b = b(iVar, cT5);
                                hVar.ayo.put(b.id, b);
                                break;
                            }
                        }
                        b = b(iVar, cT5);
                        hVar.aym.put(b.id, b);
                        break;
                        break;
                    case 19:
                        c b2;
                        if (cT4 != hVar.ayk) {
                            if (cT4 == hVar.ayl) {
                                b2 = b(iVar);
                                hVar.ayp.put(b2.id, b2);
                                break;
                            }
                        }
                        b2 = b(iVar);
                        hVar.ayn.put(b2.id, b2);
                        break;
                        break;
                    case 20:
                        if (cT4 == hVar.ayk) {
                            iVar.cS(4);
                            boolean lC = iVar.lC();
                            iVar.cS(3);
                            cT4 = iVar.cT(16);
                            cT5 = iVar.cT(16);
                            if (lC) {
                                cT = iVar.cT(16);
                                cT2 = iVar.cT(16);
                                cT6 = iVar.cT(16);
                                cT7 = iVar.cT(16);
                            } else {
                                cT = 0;
                                cT6 = 0;
                                cT7 = cT5;
                                cT2 = cT4;
                            }
                            hVar.ayq = new b(cT4, cT5, cT, cT2, cT6, cT7);
                            break;
                        }
                        break;
                }
                cT4 = lB - iVar.lB();
                com.google.android.exoplayer2.i.a.an(iVar.aCr == 0);
                iVar.aCq += cT4;
                iVar.lE();
            }
        }
        if (this.axI.ayr == null) {
            return Collections.emptyList();
        }
        b bVar;
        if (this.axI.ayq != null) {
            bVar = this.axI.ayq;
        } else {
            bVar = this.axG;
        }
        if (!(this.bitmap != null && bVar.width + 1 == this.bitmap.getWidth() && bVar.height + 1 == this.bitmap.getHeight())) {
            this.bitmap = Bitmap.createBitmap(bVar.width + 1, bVar.height + 1, Config.ARGB_8888);
            this.axF.setBitmap(this.bitmap);
        }
        List<a> arrayList = new ArrayList();
        SparseArray sparseArray2 = this.axI.ayr.axU;
        for (lB = 0; lB < sparseArray2.size(); lB++) {
            a aVar;
            SparseArray sparseArray3;
            int i2;
            g gVar;
            c cVar;
            c cVar2;
            e eVar = (e) sparseArray2.valueAt(lB);
            f fVar = (f) this.axI.axU.get(sparseArray2.keyAt(lB));
            int i3 = eVar.axV + bVar.axM;
            int i4 = eVar.axW + bVar.axO;
            this.axF.clipRect((float) i3, (float) i4, (float) Math.min(fVar.width + i3, bVar.axN), (float) Math.min(fVar.height + i4, bVar.axP), Op.REPLACE);
            b = (a) this.axI.aym.get(fVar.aya);
            if (b == null) {
                b = (a) this.axI.ayo.get(fVar.aya);
                if (b == null) {
                    aVar = this.axH;
                    sparseArray3 = fVar.aye;
                    for (i2 = 0; i2 < sparseArray3.size(); i2++) {
                        cT5 = sparseArray3.keyAt(i2);
                        gVar = (g) sparseArray3.valueAt(i2);
                        cVar = (c) this.axI.ayn.get(cT5);
                        if (cVar != null) {
                            cVar2 = (c) this.axI.ayp.get(cT5);
                        } else {
                            cVar2 = cVar;
                        }
                        if (cVar2 == null) {
                            Paint paint = cVar2.axQ ? null : this.axD;
                            cT5 = fVar.axZ;
                            cT = i3 + gVar.ayg;
                            cT2 = i4 + gVar.ayh;
                            Canvas canvas = this.axF;
                            int[] iArr = cT5 != 3 ? aVar.axL : cT5 != 2 ? aVar.axK : aVar.axJ;
                            a(cVar2.axR, iArr, cT5, cT, cT2, paint, canvas);
                            a(cVar2.axS, iArr, cT5, cT, cT2 + 1, paint, canvas);
                        }
                    }
                    if (!fVar.axX) {
                        if (fVar.axZ == 3) {
                            cT3 = aVar.axL[fVar.ayb];
                        } else if (fVar.axZ != 2) {
                            cT3 = aVar.axK[fVar.ayc];
                        } else {
                            cT3 = aVar.axJ[fVar.ayd];
                        }
                        this.axE.setColor(cT3);
                        this.axF.drawRect((float) i3, (float) i4, (float) (fVar.width + i3), (float) (fVar.height + i4), this.axE);
                    }
                    arrayList.add(new a(Bitmap.createBitmap(this.bitmap, i3, i4, fVar.width, fVar.height), ((float) i3) / ((float) bVar.width), ((float) i4) / ((float) bVar.height), ((float) fVar.width) / ((float) bVar.width), ((float) fVar.height) / ((float) bVar.height)));
                    this.axF.drawColor(0, Mode.CLEAR);
                }
            }
            aVar = b;
            sparseArray3 = fVar.aye;
            for (i2 = 0; i2 < sparseArray3.size(); i2++) {
                cT5 = sparseArray3.keyAt(i2);
                gVar = (g) sparseArray3.valueAt(i2);
                cVar = (c) this.axI.ayn.get(cT5);
                if (cVar != null) {
                    cVar2 = cVar;
                } else {
                    cVar2 = (c) this.axI.ayp.get(cT5);
                }
                if (cVar2 == null) {
                    if (cVar2.axQ) {
                    }
                    cT5 = fVar.axZ;
                    cT = i3 + gVar.ayg;
                    cT2 = i4 + gVar.ayh;
                    Canvas canvas2 = this.axF;
                    if (cT5 != 3) {
                        if (cT5 != 2) {
                        }
                    }
                    a(cVar2.axR, iArr, cT5, cT, cT2, paint, canvas2);
                    a(cVar2.axS, iArr, cT5, cT, cT2 + 1, paint, canvas2);
                }
            }
            if (!fVar.axX) {
                if (fVar.axZ == 3) {
                    cT3 = aVar.axL[fVar.ayb];
                } else if (fVar.axZ != 2) {
                    cT3 = aVar.axJ[fVar.ayd];
                } else {
                    cT3 = aVar.axK[fVar.ayc];
                }
                this.axE.setColor(cT3);
                this.axF.drawRect((float) i3, (float) i4, (float) (fVar.width + i3), (float) (fVar.height + i4), this.axE);
            }
            arrayList.add(new a(Bitmap.createBitmap(this.bitmap, i3, i4, fVar.width, fVar.height), ((float) i3) / ((float) bVar.width), ((float) i4) / ((float) bVar.height), ((float) fVar.width) / ((float) bVar.width), ((float) fVar.height) / ((float) bVar.height)));
            this.axF.drawColor(0, Mode.CLEAR);
        }
        return arrayList;
    }

    private static f a(i iVar, int i) {
        int cT = iVar.cT(8);
        iVar.cS(4);
        boolean lC = iVar.lC();
        iVar.cS(3);
        int cT2 = iVar.cT(16);
        int cT3 = iVar.cT(16);
        int cT4 = iVar.cT(3);
        int cT5 = iVar.cT(3);
        iVar.cS(2);
        int cT6 = iVar.cT(8);
        int cT7 = iVar.cT(8);
        int cT8 = iVar.cT(4);
        int cT9 = iVar.cT(2);
        iVar.cS(2);
        int i2 = i - 10;
        SparseArray sparseArray = new SparseArray();
        while (i2 > 0) {
            int cT10 = iVar.cT(16);
            int cT11 = iVar.cT(2);
            int cT12 = iVar.cT(2);
            int cT13 = iVar.cT(12);
            iVar.cS(4);
            int cT14 = iVar.cT(12);
            int i3 = i2 - 6;
            int i4 = 0;
            int i5 = 0;
            if (cT11 == 1 || cT11 == 2) {
                i4 = iVar.cT(8);
                i5 = iVar.cT(8);
                i2 = i3 - 2;
            } else {
                i2 = i3;
            }
            sparseArray.put(cT10, new g(cT11, cT12, cT13, cT14, i4, i5));
        }
        return new f(cT, lC, cT2, cT3, cT4, cT5, cT6, cT7, cT8, cT9, sparseArray);
    }

    private static a b(i iVar, int i) {
        int cT = iVar.cT(8);
        iVar.cS(8);
        int i2 = i - 2;
        int[] la = la();
        int[] lb = lb();
        int[] lc = lc();
        while (i2 > 0) {
            int[] iArr;
            int cT2;
            int cT3;
            int cT4;
            int cT5 = iVar.cT(8);
            int cT6 = iVar.cT(8);
            i2 -= 2;
            if ((cT6 & FileUtils.S_IWUSR) != 0) {
                iArr = la;
            } else if ((cT6 & 64) != 0) {
                iArr = lb;
            } else {
                iArr = lc;
            }
            if ((cT6 & 1) != 0) {
                cT2 = iVar.cT(8);
                cT3 = iVar.cT(8);
                cT4 = iVar.cT(8);
                cT6 = iVar.cT(8);
                i2 -= 4;
            } else {
                cT2 = iVar.cT(6) << 2;
                cT3 = iVar.cT(4) << 4;
                cT4 = iVar.cT(4) << 4;
                cT6 = iVar.cT(2) << 6;
                i2 -= 2;
            }
            if (cT2 == 0) {
                cT3 = 0;
                cT4 = 0;
                cT6 = 255;
            }
            iArr[cT5] = h((byte) (255 - (cT6 & 255)), t.u((int) (((double) cT2) + (1.402d * ((double) (cT3 - 128)))), 0, 255), t.u((int) ((((double) cT2) - (0.34414d * ((double) (cT4 - 128)))) - (0.71414d * ((double) (cT3 - 128)))), 0, 255), t.u((int) (((double) cT2) + (1.772d * ((double) (cT4 - 128)))), 0, 255));
        }
        return new a(cT, la, lb, lc);
    }

    private static c b(i iVar) {
        byte[] bArr;
        byte[] bArr2 = null;
        int cT = iVar.cT(16);
        iVar.cS(4);
        int cT2 = iVar.cT(2);
        boolean lC = iVar.lC();
        iVar.cS(1);
        if (cT2 == 1) {
            iVar.cS(iVar.cT(8) * 16);
            bArr = null;
        } else if (cT2 == 0) {
            int cT3 = iVar.cT(16);
            int cT4 = iVar.cT(16);
            if (cT3 > 0) {
                bArr = new byte[cT3];
                iVar.m(bArr, cT3);
            } else {
                bArr = null;
            }
            if (cT4 > 0) {
                bArr2 = new byte[cT4];
                iVar.m(bArr2, cT4);
            } else {
                bArr2 = bArr;
            }
        } else {
            bArr = null;
        }
        return new c(cT, lC, bArr, bArr2);
    }

    private static int[] la() {
        return new int[]{0, -1, WebView.NIGHT_MODE_COLOR, -8421505};
    }

    private static int[] lb() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < 16; i++) {
            if (i < 8) {
                int i2;
                if ((i & 1) != 0) {
                    i2 = 255;
                } else {
                    i2 = 0;
                }
                iArr[i] = h(255, i2, (i & 2) != 0 ? 255 : 0, (i & 4) != 0 ? 255 : 0);
            } else {
                iArr[i] = h(255, (i & 1) != 0 ? 127 : 0, (i & 2) != 0 ? 127 : 0, (i & 4) != 0 ? 127 : 0);
            }
        }
        return iArr;
    }

    private static int[] lc() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i = 0; i < 256; i++) {
            if (i >= 8) {
                switch (i & h.CTRL_INDEX) {
                    case 0:
                        iArr[i] = h(255, ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 64) != 0 ? 170 : 0) + ((i & 4) != 0 ? 85 : 0));
                        break;
                    case 8:
                        iArr[i] = h(127, ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 64) != 0 ? 170 : 0) + ((i & 4) != 0 ? 85 : 0));
                        break;
                    case FileUtils.S_IWUSR /*128*/:
                        iArr[i] = h(255, (((i & 1) != 0 ? 43 : 0) + 127) + ((i & 16) != 0 ? 85 : 0), (((i & 2) != 0 ? 43 : 0) + 127) + ((i & 32) != 0 ? 85 : 0), ((i & 64) != 0 ? 85 : 0) + (((i & 4) != 0 ? 43 : 0) + 127));
                        break;
                    case h.CTRL_INDEX /*136*/:
                        iArr[i] = h(255, ((i & 1) != 0 ? 43 : 0) + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + ((i & 32) != 0 ? 85 : 0), ((i & 64) != 0 ? 85 : 0) + ((i & 4) != 0 ? 43 : 0));
                        break;
                    default:
                        break;
                }
            }
            int i2;
            if ((i & 1) != 0) {
                i2 = 255;
            } else {
                i2 = 0;
            }
            iArr[i] = h(63, i2, (i & 2) != 0 ? 255 : 0, (i & 4) != 0 ? 255 : 0);
        }
        return iArr;
    }

    private static int h(int i, int i2, int i3, int i4) {
        return (((i << 24) | (i2 << 16)) | (i3 << 8)) | i4;
    }

    private static void a(byte[] bArr, int[] iArr, int i, int i2, int i3, Paint paint, Canvas canvas) {
        i iVar = new i(bArr);
        byte[] bArr2 = null;
        byte[] bArr3 = null;
        int i4 = i2;
        while (iVar.lA() != 0) {
            int i5;
            byte[] bArr4;
            Object obj;
            int i6;
            int i7;
            int i8;
            Object obj2;
            switch (iVar.cT(8)) {
                case 16:
                    if (i == 3) {
                        bArr4 = bArr2 == null ? axB : bArr2;
                    } else if (i == 2) {
                        bArr4 = bArr3 == null ? axA : bArr3;
                    } else {
                        bArr4 = null;
                    }
                    obj = null;
                    i6 = i4;
                    while (true) {
                        i4 = iVar.cT(2);
                        if (i4 == 0) {
                            if (!iVar.lC()) {
                                if (!iVar.lC()) {
                                    switch (iVar.cT(2)) {
                                        case 0:
                                            i7 = 0;
                                            i8 = 1;
                                            i5 = 0;
                                            break;
                                        case 1:
                                            i7 = 2;
                                            obj2 = obj;
                                            i5 = 0;
                                            break;
                                        case 2:
                                            i7 = iVar.cT(4) + 12;
                                            obj2 = obj;
                                            i5 = iVar.cT(2);
                                            break;
                                        case 3:
                                            i7 = iVar.cT(8) + 29;
                                            obj2 = obj;
                                            i5 = iVar.cT(2);
                                            break;
                                        default:
                                            i7 = 0;
                                            obj2 = obj;
                                            i5 = 0;
                                            break;
                                    }
                                }
                                i7 = 1;
                                obj2 = obj;
                                i5 = 0;
                            } else {
                                i7 = iVar.cT(3) + 3;
                                obj2 = obj;
                                i5 = iVar.cT(2);
                            }
                        } else {
                            i7 = 1;
                            obj2 = obj;
                            i5 = i4;
                        }
                        if (!(i7 == 0 || paint == null)) {
                            if (bArr4 != null) {
                                i5 = bArr4[i5];
                            }
                            paint.setColor(iArr[i5]);
                            canvas.drawRect((float) i6, (float) i3, (float) (i6 + i7), (float) (i3 + 1), paint);
                        }
                        i5 = i6 + i7;
                        if (obj2 != null) {
                            iVar.lD();
                            i4 = i5;
                            continue;
                        } else {
                            i6 = i5;
                            obj = obj2;
                        }
                    }
                case 17:
                    if (i == 3) {
                        bArr4 = axC;
                    } else {
                        bArr4 = null;
                    }
                    obj = null;
                    i6 = i4;
                    while (true) {
                        i4 = iVar.cT(4);
                        if (i4 == 0) {
                            if (iVar.lC()) {
                                if (iVar.lC()) {
                                    switch (iVar.cT(2)) {
                                        case 0:
                                            i7 = 1;
                                            obj2 = obj;
                                            i5 = 0;
                                            break;
                                        case 1:
                                            i7 = 2;
                                            obj2 = obj;
                                            i5 = 0;
                                            break;
                                        case 2:
                                            i7 = iVar.cT(4) + 9;
                                            obj2 = obj;
                                            i5 = iVar.cT(4);
                                            break;
                                        case 3:
                                            i7 = iVar.cT(8) + 25;
                                            obj2 = obj;
                                            i5 = iVar.cT(4);
                                            break;
                                        default:
                                            i7 = 0;
                                            obj2 = obj;
                                            i5 = 0;
                                            break;
                                    }
                                }
                                i7 = iVar.cT(2) + 4;
                                obj2 = obj;
                                i5 = iVar.cT(4);
                            } else {
                                i4 = iVar.cT(3);
                                if (i4 != 0) {
                                    i7 = i4 + 2;
                                    obj2 = obj;
                                    i5 = 0;
                                } else {
                                    i7 = 0;
                                    i8 = 1;
                                    i5 = 0;
                                }
                            }
                        } else {
                            i7 = 1;
                            obj2 = obj;
                            i5 = i4;
                        }
                        if (!(i7 == 0 || paint == null)) {
                            if (bArr4 != null) {
                                i5 = bArr4[i5];
                            }
                            paint.setColor(iArr[i5]);
                            canvas.drawRect((float) i6, (float) i3, (float) (i6 + i7), (float) (i3 + 1), paint);
                        }
                        i5 = i6 + i7;
                        if (obj2 != null) {
                            iVar.lD();
                            i4 = i5;
                            continue;
                        } else {
                            i6 = i5;
                            obj = obj2;
                        }
                    }
                case 18:
                    obj = null;
                    i8 = i4;
                    while (true) {
                        Object obj3;
                        i4 = iVar.cT(8);
                        if (i4 != 0) {
                            i6 = 1;
                            obj3 = obj;
                            i5 = i4;
                        } else if (iVar.lC()) {
                            i6 = iVar.cT(7);
                            obj3 = obj;
                            i5 = iVar.cT(8);
                        } else {
                            int cT = iVar.cT(7);
                            if (cT != 0) {
                                i6 = cT;
                                obj3 = obj;
                                i5 = 0;
                            } else {
                                i6 = 0;
                                int i9 = 1;
                                i5 = 0;
                            }
                        }
                        if (!(i6 == 0 || paint == null)) {
                            paint.setColor(iArr[i5]);
                            canvas.drawRect((float) i8, (float) i3, (float) (i8 + i6), (float) (i3 + 1), paint);
                        }
                        i5 = i8 + i6;
                        if (obj3 != null) {
                            i4 = i5;
                            continue;
                        } else {
                            i8 = i5;
                            obj = obj3;
                        }
                    }
                case 32:
                    bArr3 = a(4, 4, iVar);
                    continue;
                case 33:
                    bArr2 = a(4, 8, iVar);
                    continue;
                case 34:
                    bArr2 = a(16, 8, iVar);
                    continue;
                case 240:
                    i3 += 2;
                    i5 = i2;
                    break;
                default:
                    i5 = i4;
                    break;
            }
            i4 = i5;
        }
    }

    private static byte[] a(int i, int i2, i iVar) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) iVar.cT(i2);
        }
        return bArr;
    }
}
