package com.tencent.mapsdk.rastercore.tile;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.tencent.mapsdk.raster.model.Tile;
import com.tencent.mapsdk.raster.model.TileProvider;
import com.tencent.mapsdk.rastercore.e.a.f;
import com.tencent.mapsdk.rastercore.tile.MapTile.MapSource;
import com.tencent.wcdb.FileUtils;
import java.util.Comparator;

public final class a {
    private static final Comparator<a> l = new a((byte) 0);
    private final int a;
    private final int b;
    private final int c;
    private MapSource d;
    private final int e;
    private TileProvider f;
    private Bitmap g;
    private String h;
    private boolean i;
    private volatile boolean j;
    private f k;

    public a(TileProvider tileProvider, int i, int i2, int i3, int i4, MapSource mapSource, String str) {
        this.i = true;
        this.j = false;
        this.f = tileProvider;
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.h = str;
        this.d = mapSource;
        this.e = i4;
    }

    public a(f fVar, int i, int i2, int i3, int i4) {
        this(fVar.f(), i, i2, i3, i4, MapSource.CUSTOMER, fVar.g());
        this.k = fVar;
        this.i = fVar.h();
    }

    public static Comparator<a> k() {
        return l;
    }

    public final String a() {
        return this.h;
    }

    public final void a(Bitmap bitmap) {
        this.g = bitmap;
    }

    public final boolean a(Canvas canvas) {
        if ((this.k != null && !this.k.e()) || this.g == null || this.g.isRecycled()) {
            return false;
        }
        try {
            canvas.drawBitmap(this.g, 0.0f, 0.0f, null);
            return true;
        } catch (Exception e) {
            if (!(this.g == null || this.g.isRecycled())) {
                this.g.recycle();
            }
            this.g = null;
            return false;
        }
    }

    public final boolean a(f fVar) {
        return this.k == null ? false : this.k.equals(fVar);
    }

    public final byte[] a(boolean z, String str) {
        try {
            Tile tile = this.f.getTile(this.a, this.b, this.c, this.d, new Object[]{Integer.valueOf(this.e), str, Boolean.valueOf(z)});
            return tile != null ? tile.getData() : null;
        } catch (Exception e) {
            new StringBuilder("get tile raises exception:").append(e.getMessage());
            return null;
        }
    }

    public final int b() {
        return this.a;
    }

    public final int c() {
        return this.b;
    }

    public final int d() {
        return this.c;
    }

    public final TileProvider e() {
        return this.f;
    }

    public final Bitmap f() {
        return this.g;
    }

    public final boolean g() {
        return this.i;
    }

    public final void h() {
        this.j = true;
        if (!(this.g == null || this.g.isRecycled())) {
            this.g.recycle();
        }
        this.g = null;
    }

    public final boolean i() {
        return this.j;
    }

    public final float j() {
        return this.k != null ? this.k.a() : Float.NEGATIVE_INFINITY;
    }

    public final int l() {
        return this.e;
    }

    public final MapSource m() {
        return this.d;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IWUSR);
        stringBuilder.append(this.a);
        stringBuilder.append("_");
        stringBuilder.append(this.b);
        stringBuilder.append("_");
        stringBuilder.append(this.c);
        stringBuilder.append("_");
        stringBuilder.append(this.d);
        stringBuilder.append("_");
        stringBuilder.append(this.f.getClass().getCanonicalName());
        return stringBuilder.toString();
    }
}
