package com.tencent.mapsdk.rastercore.d;

import android.graphics.Canvas;
import android.view.MotionEvent;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.GroundOverlayOptions;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mapsdk.rastercore.e.a.c;
import com.tencent.mapsdk.rastercore.e.b;
import com.tencent.mapsdk.rastercore.e.d;
import com.tencent.tencentmap.mapsdk.map.e;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class a {
    private static int e = 0;
    private e a;
    private CopyOnWriteArrayList<b> b = new CopyOnWriteArrayList();
    private SortedMap<String, c> c = new TreeMap();
    private a d = new a(this, (byte) 0);
    private int f = 0;

    public a(e eVar) {
        this.a = eVar;
    }

    public static String a(String str) {
        e++;
        return str + e;
    }

    public final c a(MarkerOptions markerOptions) {
        c cVar = new c(this.a, markerOptions);
        this.c.put(cVar.m(), cVar);
        return cVar;
    }

    public final com.tencent.mapsdk.rastercore.e.a a(CircleOptions circleOptions) {
        b aVar = new com.tencent.mapsdk.rastercore.e.a(this.a, circleOptions);
        a(aVar);
        return aVar;
    }

    public final com.tencent.mapsdk.rastercore.e.c a(PolygonOptions polygonOptions) {
        b cVar = new com.tencent.mapsdk.rastercore.e.c(this.a, polygonOptions);
        a(cVar);
        return cVar;
    }

    public final d a(PolylineOptions polylineOptions) {
        b dVar = new com.tencent.mapsdk.rastercore.e.a.d(this.a, polylineOptions);
        a(dVar);
        return dVar;
    }

    public final com.tencent.mapsdk.rastercore.tile.a.b a(GroundOverlayOptions groundOverlayOptions) {
        b bVar = new com.tencent.mapsdk.rastercore.tile.a.b(this.a, groundOverlayOptions);
        a(bVar);
        return bVar;
    }

    public final void a() {
        try {
            for (Entry value : this.c.entrySet()) {
                ((c) value.getValue()).c();
            }
            this.c.clear();
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                ((b) it.next()).destroy();
            }
            this.b.clear();
            com.tencent.mapsdk.rastercore.f.a.a(this.a.c(), 2);
        } catch (Exception e) {
        }
    }

    public final void a(Canvas canvas) {
        int size = this.b.size();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.isVisible() && (size <= 20 || bVar.checkInBounds())) {
                bVar.draw(canvas);
            }
        }
    }

    public final void a(b bVar) {
        b(bVar.getId());
        this.b.add(bVar);
        if (!(bVar instanceof com.tencent.mapsdk.rastercore.e.a)) {
            int i = this.f + 1;
            this.f = i;
            if (i > 0) {
                com.tencent.mapsdk.rastercore.f.a.a(this.a.c(), 1);
            }
        }
        c();
        this.a.a(false, false);
    }

    public final boolean a(MotionEvent motionEvent) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            if (((b) it.next()) instanceof e) {
                this.a.d();
            }
        }
        return false;
    }

    public final boolean a(GeoPoint geoPoint) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            if (((b) it.next()) instanceof e) {
                this.a.d();
            }
        }
        Iterator it2 = this.b.iterator();
        while (it2.hasNext()) {
            it2.next();
        }
        return false;
    }

    public final boolean a(GeoPoint geoPoint, MotionEvent motionEvent) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            if (((b) it.next()) instanceof e) {
                this.a.d();
            }
        }
        return false;
    }

    protected final void b() {
        a();
    }

    public final boolean b(String str) {
        Object obj;
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            obj = (b) it.next();
            if (obj != null && obj.getId().equals(str)) {
                break;
            }
        }
        obj = null;
        if (obj == null) {
            return false;
        }
        boolean remove = this.b.remove(obj);
        if (remove && !(this.b instanceof com.tencent.mapsdk.rastercore.e.a)) {
            int i = this.f - 1;
            this.f = i;
            if (i == 0) {
                com.tencent.mapsdk.rastercore.f.a.a(this.a.c(), 2);
            }
        }
        this.a.a(false, false);
        return remove;
    }

    public final void c() {
        Object[] toArray = this.b.toArray();
        Arrays.sort(toArray, this.d);
        this.b.clear();
        for (Object obj : toArray) {
            this.b.add((b) obj);
        }
    }

    public final boolean c(String str) {
        c cVar = (c) this.c.remove(str);
        if (cVar == null) {
            return false;
        }
        cVar.c();
        return true;
    }
}
