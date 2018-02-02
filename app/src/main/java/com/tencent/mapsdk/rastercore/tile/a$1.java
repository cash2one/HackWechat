package com.tencent.mapsdk.rastercore.tile;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PointF;
import com.tencent.mapsdk.raster.model.TileOverlayOptions;
import com.tencent.mapsdk.rastercore.b.a;
import com.tencent.mapsdk.rastercore.b.c;
import com.tencent.mapsdk.rastercore.d.b;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.mapsdk.rastercore.e.a.f;
import com.tencent.mapsdk.rastercore.tile.MapTile.MapSource;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public /* synthetic */ class a$1 {
    ArrayList<MapTile> a = null;
    ArrayList<MapTile> b = null;
    ArrayList<MapTile> c = null;
    b d;
    private e e;
    private b f;
    private int g = 0;
    private int h;
    private int i;
    private int j;
    private List<f> k;
    private PaintFlagsDrawFilter l;

    public a$1(e eVar, int i, int i2, int i3) {
        this.e = eVar;
        this.f = eVar.c();
        this.d = new b(eVar);
        this.k = new ArrayList();
        this.h = i;
        this.i = i2;
        this.j = i3;
    }

    private static void a(ArrayList<MapTile> arrayList) {
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((MapTile) it.next()).c();
            }
            arrayList.clear();
        }
    }

    private static void a(ArrayList<MapTile> arrayList, ArrayList<MapTile> arrayList2, ArrayList<MapTile> arrayList3) {
        if (arrayList != null && arrayList.size() != 0) {
            MapTile mapTile;
            for (int i = 0; i < arrayList.size(); i++) {
                mapTile = (MapTile) arrayList.get(i);
                if (mapTile != null) {
                    List b;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                            MapTile mapTile2 = (MapTile) arrayList2.get(i2);
                            if (mapTile2.equals(mapTile)) {
                                b = mapTile2.b();
                                arrayList2.remove(i2);
                                break;
                            }
                        }
                    }
                    b = null;
                    if ((b == null || mapTile.a(b)) && arrayList3 != null) {
                        arrayList3.add(mapTile);
                    }
                }
            }
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    mapTile = (MapTile) it.next();
                    if (!(mapTile == null || mapTile.b() == null)) {
                        try {
                            mapTile.c();
                        } catch (Exception e) {
                        }
                    }
                }
                arrayList2.clear();
            }
        }
    }

    private static void a(List<MapTile> list, f fVar) {
        if (list != null) {
            for (MapTile a : list) {
                a.a(fVar);
            }
        }
    }

    private boolean a(Canvas canvas, ArrayList<MapTile> arrayList) {
        double b = this.f.d().b();
        PointF a = this.f.a();
        boolean z = true;
        if (arrayList != null && arrayList.size() > 0) {
            int a2 = ((MapTile) arrayList.get(0)).a();
            int a3 = this.f.d().a();
            if (this.e.f().e()) {
                a3--;
            }
            b *= Math.pow(2.0d, (double) (a3 - a2));
            if (b != 1.0d) {
                Matrix matrix = new Matrix();
                canvas.save();
                matrix.reset();
                matrix.postScale((float) b, (float) b, a.x, a.y);
                canvas.concat(matrix);
            }
            int i = 0;
            while (i < arrayList.size()) {
                try {
                    MapTile mapTile = (MapTile) arrayList.get(i);
                    boolean z2 = (mapTile == null || mapTile.a(canvas)) ? z : false;
                    i++;
                    z = z2;
                } catch (Throwable th) {
                }
            }
            if (b != 1.0d) {
                canvas.restore();
            }
        }
        return z;
    }

    private static void b(List<MapTile> list, f fVar) {
        if (list != null) {
            for (MapTile b : list) {
                b.b(fVar);
            }
        }
    }

    private ArrayList<MapTile> d(int i) {
        return a(this.f.b(), i, this.f.getWidth(), this.f.getHeight(), this.e.f().d());
    }

    public int a(MapSource mapSource) {
        switch (d.a[mapSource.ordinal()]) {
            case 1:
                return this.i;
            case 2:
                return this.h;
            case 3:
                return this.j;
            default:
                return -1;
        }
    }

    PointF a(int i, int i2, int i3, int i4, PointF pointF, int i5, int i6, int i7, int i8) {
        PointF pointF2 = new PointF();
        if (i < 0 || i2 < 0 || ((double) i) >= Math.pow(2.0d, (double) i8) || ((double) i2) >= Math.pow(2.0d, (double) i8)) {
            return null;
        }
        pointF2.x = ((float) ((i - i3) * i7)) + pointF.x;
        pointF2.y = ((float) ((i2 - i4) * i7)) + pointF.y;
        return (pointF2.x + ((float) i7) <= 0.0f || pointF2.x >= ((float) i5) || pointF2.y + ((float) i7) <= 0.0f || pointF2.y >= ((float) i6)) ? null : pointF2;
    }

    public f a(TileOverlayOptions tileOverlayOptions) {
        f fVar = new f(this.e, tileOverlayOptions);
        this.k.add(fVar);
        a(this.b, fVar);
        a(null, fVar);
        a(this.c, fVar);
        this.e.a(false, false);
        return fVar;
    }

    public ArrayList<MapTile> a(c cVar, int i, int i2, int i3, int i4) {
        int i5 = 0;
        if (this.e.f().e()) {
            i5 = 1;
        }
        double c = a.c((double) (i5 + i));
        MapSource c2 = this.e.f().c();
        new StringBuilder("mapSource:").append(c2);
        int b = (int) ((cVar.b() - -2.003750834E7d) / (((double) i4) * c));
        int a = (int) ((2.003750834E7d - cVar.a()) / (((double) i4) * c));
        c cVar2 = new c((((double) (b * i4)) * c) - 2.1525280871514951E-7d, 2.003750834E7d - (((double) (a * i4)) * c));
        PointF a2 = this.f.a();
        PointF pointF = new PointF();
        pointF.x = (float) (((cVar2.b() - cVar.b()) / c) + ((double) a2.x));
        pointF.y = (float) (((double) a2.y) - ((cVar2.a() - cVar.a()) / c));
        MapTile mapTile = new MapTile(this.e, b, a, i, a(c2), c2, this.k);
        mapTile.a(pointF);
        ArrayList<MapTile> arrayList = new ArrayList();
        arrayList.add(mapTile);
        int i6 = 1;
        while (true) {
            int i7;
            Object obj = null;
            for (i7 = b - i6; i7 <= b + i6; i7++) {
                int i8 = a + i6;
                PointF a3 = a(i7, i8, b, a, pointF, i2, i3, i4, i);
                if (a3 != null) {
                    if (obj == null) {
                        obj = 1;
                    }
                    MapTile mapTile2 = new MapTile(this.e, i7, i8, i, a(c2), c2, this.k);
                    mapTile2.a(a3);
                    arrayList.add(mapTile2);
                }
                i8 = a - i6;
                a3 = a(i7, i8, b, a, pointF, i2, i3, i4, i);
                if (a3 != null) {
                    if (obj == null) {
                        obj = 1;
                    }
                    mapTile2 = new MapTile(this.e, i7, i8, i, a(c2), c2, this.k);
                    mapTile2.a(a3);
                    arrayList.add(mapTile2);
                }
            }
            for (i7 = (a + i6) - 1; i7 > a - i6; i7--) {
                int i9 = b + i6;
                a3 = a(i9, i7, b, a, pointF, i2, i3, i4, i);
                if (a3 != null) {
                    if (obj == null) {
                        obj = 1;
                    }
                    MapTile mapTile3 = new MapTile(this.e, i9, i7, i, a(c2), c2, this.k);
                    mapTile3.a(a3);
                    arrayList.add(mapTile3);
                }
                i9 = b - i6;
                a3 = a(i9, i7, b, a, pointF, i2, i3, i4, i);
                if (a3 != null) {
                    if (obj == null) {
                        obj = 1;
                    }
                    mapTile3 = new MapTile(this.e, i9, i7, i, a(c2), c2, this.k);
                    mapTile3.a(a3);
                    arrayList.add(mapTile3);
                }
            }
            if (obj == null) {
                return arrayList;
            }
            i6++;
        }
    }

    public void a() {
        a(null);
        a(this.b);
        a(this.c);
        this.d.a();
    }

    public void a(int i) {
        this.h = i;
    }

    public void a(boolean z, boolean z2) {
        ArrayList arrayList;
        ArrayList arrayList2;
        if (!z) {
            MapSource mapSource = MapSource.TENCENT;
            mapSource = this.e.l() == 2 ? MapSource.SATELLITE : (e.r() && com.tencent.mapsdk.rastercore.c.a() && !b()) ? MapSource.BING : (!e.r() || this.f.d().a() <= 6 || b()) ? MapSource.TENCENT : MapSource.BING;
            if (this.e.f().c() != mapSource) {
                this.e.f().a(mapSource);
                if (this.b != null) {
                    this.b.clear();
                }
                if (this.c != null) {
                    this.c.clear();
                }
            }
        }
        if (this.e.f().e()) {
            this.e.f().a(WXMediaMessage.TITLE_LENGTH_LIMIT);
        } else {
            this.e.f().a(256);
        }
        int a = this.f.d().a();
        int i = this.e.f().e() ? a - 1 : a;
        if (this.b == null || this.b.size() <= 0) {
            arrayList = null;
            a = -1;
        } else {
            int a2 = ((MapTile) this.b.get(0)).a();
            arrayList = this.b;
            a = a2;
        }
        int i2 = a - i;
        if (i2 != 0 || z2) {
            if (this.c == null || this.c.size() <= 0) {
                arrayList2 = null;
                a2 = -1;
            } else {
                a2 = ((MapTile) this.c.get(0)).a();
                arrayList2 = this.c;
            }
            if (i == a2 && a2 != -1) {
                this.b = arrayList2;
            }
            if (Math.abs(i2) == 1) {
                this.c = arrayList;
            }
        }
        ArrayList arrayList3 = new ArrayList();
        if (this.c != null && this.c.size() > 0) {
            arrayList2 = d(((MapTile) this.c.get(0)).a());
            a(arrayList2, this.c, null);
            this.c = arrayList2;
        }
        arrayList2 = d(i);
        a(arrayList2, this.b, arrayList3);
        this.b = arrayList2;
        this.d.a(arrayList3);
        this.e.c().invalidate();
    }

    public boolean a(Canvas canvas) {
        a(canvas, null);
        a(canvas, this.c);
        if (this.l == null) {
            this.l = new PaintFlagsDrawFilter(0, 2);
        }
        canvas.setDrawFilter(this.l);
        boolean a = a(canvas, this.b);
        canvas.setDrawFilter(null);
        if (!a) {
            return false;
        }
        if (this.c != null) {
            this.c.clear();
        }
        return true;
    }

    public boolean a(f fVar) {
        boolean remove = this.k.remove(fVar);
        if (remove) {
            b(this.b, fVar);
            b(null, fVar);
            b(this.c, fVar);
        }
        this.e.a(false, false);
        return remove;
    }

    public void b(int i) {
        this.i = i;
    }

    public boolean b() {
        boolean z = false;
        c[] b = this.e.b().b();
        int length = b.length;
        int i = 0;
        while (i < length) {
            c cVar = b[i];
            boolean a = com.tencent.mapsdk.rastercore.c.a(cVar.b(), cVar.a()) | z;
            if (a) {
                return true;
            }
            i++;
            z = a;
        }
        return z;
    }

    public void c(int i) {
        this.j = i;
    }
}
