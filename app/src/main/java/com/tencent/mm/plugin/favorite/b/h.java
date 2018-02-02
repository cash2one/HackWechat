package com.tencent.mm.plugin.favorite.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.SystemClock;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.f;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.pluginsdk.model.c;
import com.tencent.mm.pluginsdk.ui.tools.g;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.vd;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.z.ar;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class h {
    private static Map<String, a> mrv = new HashMap();
    private static f<String, Bitmap> mrw = new f(10);
    private static z<String, Bitmap> mrx = new z(20);
    public Context context;
    public e mrs;
    public HashMap<String, String[]> mrt = new HashMap();
    private HashMap<String, String[]> mru = new HashMap();

    static /* synthetic */ boolean Al(String str) {
        if (!new File(str).exists()) {
            a aVar = (a) mrv.get(str);
            if (aVar == null) {
                mrv.put(str, new a());
                return true;
            } else if (aVar.zi() > 30000) {
                x.v("MicroMsg.FavoriteImageLogic", "error diff time");
                aVar.gHJ = SystemClock.elapsedRealtime();
                return true;
            }
        }
        return false;
    }

    public h(Context context, int i) {
        this.context = context;
        if (i <= 0) {
            i = 24;
        }
        this.mrs = new e(i);
    }

    public final void destory() {
        g gVar = this.mrs;
        synchronized (gVar.gSF) {
            x.d("MicroMsg.ImageEngine", "do clear mark");
            gVar.vxd.clear();
            gVar.vxe.clear();
            gVar.vxd = new HashMap();
            gVar.vxe = new HashMap();
        }
        this.mrt.clear();
        this.mru.clear();
        this.mrs.destory();
        this.context = null;
        this.mrt = null;
        this.mru = null;
        this.mrs = null;
    }

    public final void a(ImageView imageView, uq uqVar, com.tencent.mm.plugin.fav.a.f fVar, String str, int i, int i2, int i3) {
        String Ac = j.Ac(uqVar.mvG);
        String[] strArr = null;
        if (uqVar.mvG != null) {
            String[] strArr2 = (String[]) this.mru.get(Ac);
            if (strArr2 == null) {
                strArr = new String[]{j.i(uqVar)};
                this.mru.put(Ac, strArr);
            } else {
                strArr = strArr2;
            }
        }
        this.mrs.a(imageView, strArr, str, i, i2, i3);
        if (strArr != null && strArr.length > 0) {
            ar.Dm().F(new 1(this, strArr[0], fVar, uqVar));
        }
    }

    public final void a(ImageView imageView, uq uqVar, com.tencent.mm.plugin.fav.a.f fVar, int i, int i2, int i3) {
        String str = null;
        if (imageView != null) {
            if (!com.tencent.mm.compatible.util.f.ze()) {
                imageView.setImageResource(R.g.bEi);
            } else if (fVar != null) {
                vd vdVar;
                switch (fVar.field_type) {
                    case 4:
                    case 16:
                        if (uqVar != null) {
                            a(imageView, uqVar, fVar, uqVar.fqf, i, i2, i3);
                            return;
                        }
                        return;
                    case 5:
                        vt vtVar = fVar.field_favProto.web;
                        if (uqVar != null) {
                            String str2;
                            if (vtVar != null) {
                                str = vtVar.thumbUrl;
                            }
                            if (bh.ov(str)) {
                                str2 = uqVar.fqf;
                            } else {
                                str2 = str;
                            }
                            a(imageView, uqVar, fVar, str2, i, i2, i3);
                            return;
                        } else if (vtVar != null) {
                            this.mrs.a(imageView, null, vtVar.thumbUrl, i, i2, i3);
                            return;
                        } else {
                            return;
                        }
                    case 7:
                        if (uqVar != null) {
                            a(imageView, uqVar, fVar, uqVar.fqf, i, i2, i3);
                            return;
                        }
                        return;
                    case 10:
                        vdVar = fVar.field_favProto.wed;
                        if (vdVar != null) {
                            this.mrs.a(imageView, null, vdVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    case 11:
                        vdVar = fVar.field_favProto.wed;
                        if (vdVar != null) {
                            this.mrs.a(imageView, null, vdVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    case 15:
                        vn vnVar = fVar.field_favProto.wef;
                        if (vnVar != null) {
                            this.mrs.a(imageView, null, vnVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    default:
                        x.w("MicroMsg.FavoriteImageLogic", "attach thumb, pass type is %d", new Object[]{Integer.valueOf(fVar.field_type)});
                        return;
                }
            }
        }
    }

    public final void b(ImageView imageView, uq uqVar, com.tencent.mm.plugin.fav.a.f fVar, int i, int i2, int i3) {
        String str = null;
        if (imageView != null) {
            if (!com.tencent.mm.compatible.util.f.ze()) {
                imageView.setImageResource(R.g.bEi);
            } else if (fVar == null || uqVar == null) {
                imageView.setImageDrawable(com.tencent.mm.bv.a.b(this.context, i));
            } else {
                vd vdVar;
                switch (uqVar.bjS) {
                    case 4:
                    case 15:
                        a(imageView, uqVar, fVar, uqVar.fqf, i, i2, i3);
                        return;
                    case 5:
                        vt vtVar;
                        String str2;
                        if (uqVar.wdD != null) {
                            vtVar = uqVar.wdD.web;
                        } else {
                            x.w("MicroMsg.FavoriteImageLogic", "webpage: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[]{uqVar.mvG, Long.valueOf(fVar.field_localId), Integer.valueOf(fVar.field_id)});
                            vtVar = null;
                        }
                        if (vtVar != null) {
                            str = vtVar.thumbUrl;
                        }
                        if (bh.ov(str)) {
                            str2 = uqVar.fqf;
                        } else {
                            str2 = str;
                        }
                        a(imageView, uqVar, fVar, str2, i, i2, i3);
                        return;
                    case 7:
                        a(imageView, uqVar, fVar, uqVar.fqf, i, i2, i3);
                        return;
                    case 10:
                        if (uqVar.wdD == null) {
                            x.w("MicroMsg.FavoriteImageLogic", "good: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[]{uqVar.mvG, Long.valueOf(fVar.field_localId), Integer.valueOf(fVar.field_id)});
                            return;
                        }
                        vdVar = uqVar.wdD.wed;
                        if (vdVar != null) {
                            this.mrs.a(imageView, null, vdVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    case 11:
                        if (uqVar.wdD == null) {
                            x.w("MicroMsg.FavoriteImageLogic", "product: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[]{uqVar.mvG, Long.valueOf(fVar.field_localId), Integer.valueOf(fVar.field_id)});
                            return;
                        }
                        vdVar = uqVar.wdD.wed;
                        if (vdVar != null) {
                            this.mrs.a(imageView, null, vdVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    case 14:
                        if (uqVar.wdD == null) {
                            x.w("MicroMsg.FavoriteImageLogic", "tv: get data proto item null, dataid[%s], infoid[%d, %d]", new Object[]{uqVar.mvG, Long.valueOf(fVar.field_localId), Integer.valueOf(fVar.field_id)});
                            return;
                        }
                        vn vnVar = uqVar.wdD.wef;
                        if (vnVar != null) {
                            this.mrs.a(imageView, null, vnVar.thumbUrl, i, i2, i3);
                            return;
                        }
                        return;
                    default:
                        x.w("MicroMsg.FavoriteImageLogic", "attach thumb, pass type is %d", new Object[]{Integer.valueOf(fVar.field_type)});
                        return;
                }
            }
        }
    }

    private static Bitmap a(uq uqVar, boolean z, boolean z2) {
        String i;
        if (z) {
            i = j.i(uqVar);
        } else {
            i = j.h(uqVar);
        }
        if (e.bO(i)) {
            return c.aY(i, z2);
        }
        x.w("MicroMsg.FavoriteImageLogic", "getBitmap file not exist");
        return null;
    }

    public static Bitmap b(uq uqVar, com.tencent.mm.plugin.fav.a.f fVar, int i) {
        if (!com.tencent.mm.compatible.util.f.ze()) {
            return BitmapFactory.decodeResource(ac.getContext().getResources(), R.g.bEi);
        }
        if (uqVar.mvG == null) {
            return null;
        }
        Bitmap bitmap;
        String h = j.h(uqVar);
        if (e.bO(h)) {
            bitmap = (Bitmap) mrw.get(h);
            if (bitmap != null) {
                x.d("MicroMsg.FavoriteImageLogic", "get bm from cache %s", new Object[]{h});
            } else {
                x.d("MicroMsg.FavoriteImageLogic", "get from cache fail, try to decode from file");
                Options options = new Options();
                options.inJustDecodeBounds = true;
                bitmap = BitmapFactory.decodeFile(h, options);
                if (bitmap != null) {
                    x.i("MicroMsg.FavoriteImageLogic", "bitmap recycle %s", new Object[]{bitmap});
                    bitmap.recycle();
                }
                int i2 = options.outWidth;
                int i3 = options.outHeight;
                x.d("MicroMsg.FavoriteImageLogic", "width: %s, height: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                if (i2 > i) {
                    i3 = (options.outHeight * i) / options.outWidth;
                } else {
                    i = i2;
                }
                i2 = Math.max(1, i);
                i3 = Math.max(1, i3);
                x.w("MicroMsg.FavoriteImageLogic", "fit long picture, beg %d*%d, after %d*%d", new Object[]{Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), Integer.valueOf(i2), Integer.valueOf(i3)});
                int UJ = ExifHelper.UJ(h);
                if (UJ == 90 || UJ == 270) {
                    int i4 = i2;
                    i2 = i3;
                    i3 = i4;
                }
                bitmap = d.d(h, i3, i2, false);
                if (bitmap == null) {
                    x.e("MicroMsg.FavoriteImageLogic", "getSuitableBmp fail, temBmp is null, filePath = " + h);
                    bitmap = null;
                } else {
                    bitmap = d.b(bitmap, (float) UJ);
                    mrw.put(h, bitmap);
                }
            }
        } else {
            x.w("MicroMsg.FavoriteImageLogic", "getBitmap file not exist");
            bitmap = null;
        }
        if (bitmap != null) {
            return bitmap;
        }
        ar.Dm().F(new 3(false, j.h(uqVar), fVar, uqVar));
        return bitmap;
    }

    public static Bitmap j(uq uqVar) {
        if (!com.tencent.mm.compatible.util.f.ze()) {
            return BitmapFactory.decodeResource(ac.getContext().getResources(), R.g.bEi);
        }
        if (uqVar.mvG == null) {
            return null;
        }
        return a(uqVar, false, true);
    }

    public static Bitmap a(uq uqVar, com.tencent.mm.plugin.fav.a.f fVar, boolean z) {
        if (!com.tencent.mm.compatible.util.f.ze()) {
            return BitmapFactory.decodeResource(ac.getContext().getResources(), R.g.bEi);
        }
        if (uqVar.mvG == null) {
            return null;
        }
        Bitmap a = a(uqVar, false, false);
        if (a != null) {
            return a;
        }
        ar.Dm().F(new 4(z, j.h(uqVar), fVar, uqVar));
        return a;
    }

    public static Bitmap a(uq uqVar, com.tencent.mm.plugin.fav.a.f fVar) {
        if (!com.tencent.mm.compatible.util.f.ze()) {
            return BitmapFactory.decodeResource(ac.getContext().getResources(), R.g.bEi);
        }
        if (j.Ac(uqVar.mvG) == null) {
            return null;
        }
        Bitmap a = a(uqVar, true, false);
        if (a != null) {
            return a;
        }
        ar.Dm().F(new 5(j.i(uqVar), fVar, uqVar));
        return a;
    }

    public static Bitmap b(String str, int i, int i2, boolean z) {
        Bitmap decodeFile;
        IOException iOException;
        boolean z2 = false;
        if (e.bO(str)) {
            Bitmap bitmap = (Bitmap) mrx.get(str);
            if (bitmap != null || z) {
                String str2 = "MicroMsg.FavoriteImageLogic";
                String str3 = "return bm path %s, bm %s";
                Object[] objArr = new Object[2];
                objArr[0] = str;
                objArr[1] = Boolean.valueOf(bitmap != null);
                x.d(str2, str3, objArr);
                return bitmap;
            }
            try {
                Options options = new Options();
                options.inJustDecodeBounds = true;
                d.decodeFile(str, options);
                int i3 = options.outWidth;
                int i4 = options.outHeight;
                int UJ = ExifHelper.UJ(str);
                if (UJ == 90 || UJ == 270) {
                    z2 = true;
                    int i5 = i3;
                    i3 = i4;
                    i4 = i5;
                }
                options.inSampleSize = 1;
                while (i4 / options.inSampleSize > i2 && i3 / options.inSampleSize > i) {
                    options.inSampleSize++;
                }
                int i6 = (i3 * i2) / i;
                x.d("MicroMsg.FavoriteImageLogic", "decode top region width: %d, height: %d, scaleheight: %d, rotate: %b", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i6), Boolean.valueOf(z2)});
                if (i6 <= 0 || i4 <= i6) {
                    options.inJustDecodeBounds = false;
                    decodeFile = d.decodeFile(str, options);
                } else {
                    Rect rect = new Rect();
                    rect.top = 0;
                    rect.left = 0;
                    if (z2) {
                        rect.right = i6;
                        rect.bottom = i3;
                    } else {
                        rect.right = i3;
                        rect.bottom = i6;
                    }
                    BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(str, true);
                    options.inJustDecodeBounds = false;
                    decodeFile = newInstance.decodeRegion(rect, options);
                }
                if (decodeFile == null || !z2) {
                    bitmap = decodeFile;
                } else {
                    try {
                        bitmap = d.b(decodeFile, (float) UJ);
                    } catch (IOException e) {
                        IOException iOException2 = e;
                        bitmap = decodeFile;
                        iOException = iOException2;
                        x.e("MicroMsg.FavoriteImageLogic", iOException.getMessage());
                        return bitmap;
                    }
                }
                if (bitmap != null) {
                    x.d("MicroMsg.FavoriteImageLogic", "width %d, height %d, tw %d, th %d", new Object[]{Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(i), Integer.valueOf(i2)});
                    mrx.put(str, bitmap);
                    return bitmap;
                }
                x.w("MicroMsg.FavoriteImageLogic", "decode bm fail!");
                return bitmap;
            } catch (IOException e2) {
                iOException = e2;
                x.e("MicroMsg.FavoriteImageLogic", iOException.getMessage());
                return bitmap;
            }
        }
        x.w("MicroMsg.FavoriteImageLogic", "file not exist");
        return null;
    }

    public static void a(ImageView imageView, int i, uq uqVar, com.tencent.mm.plugin.fav.a.f fVar, boolean z, int i2, int i3) {
        if (!com.tencent.mm.compatible.util.f.ze()) {
            imageView.setImageBitmap(BitmapFactory.decodeResource(ac.getContext().getResources(), R.g.bEi));
        }
        if (uqVar.mvG == null) {
            imageView.setImageResource(i);
        }
        Bitmap a = a(uqVar, fVar);
        final String h = j.h(uqVar);
        if (e.bO(h)) {
            a = b(h, i2, i3, true);
        }
        if (a == null) {
            imageView.setImageResource(i);
            imageView.setTag(h);
            final int i4 = i2;
            final int i5 = i3;
            final com.tencent.mm.plugin.fav.a.f fVar2 = fVar;
            final uq uqVar2 = uqVar;
            final boolean z2 = z;
            final ImageView imageView2 = imageView;
            ar.Dm().F(new Runnable() {
                public final void run() {
                    Bitmap b = h.b(h, i4, i5, false);
                    if (b == null) {
                        h.c(fVar2, uqVar2, z2);
                        return;
                    }
                    String str = (String) imageView2.getTag();
                    if (str != null && str.equals(h)) {
                        ar.Dm();
                        ag.y(new 1(this, b));
                    }
                }
            });
            return;
        }
        imageView.setImageBitmap(a);
    }

    private static void c(com.tencent.mm.plugin.fav.a.f fVar, uq uqVar, boolean z) {
        ar.Dm().F(new 7(z, j.h(uqVar), fVar, uqVar));
    }

    public static void a(com.tencent.mm.plugin.fav.a.f fVar, uq uqVar) {
        c(fVar, uqVar, true);
    }
}
