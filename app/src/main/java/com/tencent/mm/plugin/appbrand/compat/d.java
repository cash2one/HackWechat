package com.tencent.mm.plugin.appbrand.compat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds$Builder;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.compat.a.b;
import com.tencent.mm.plugin.appbrand.compat.a.b.c;
import com.tencent.mm.plugin.appbrand.compat.a.b.f;
import com.tencent.mm.plugin.appbrand.compat.a.b.h;
import com.tencent.mm.plugin.appbrand.compat.a.b.i;
import com.tencent.mm.plugin.appbrand.compat.a.b.j;
import com.tencent.mm.plugin.appbrand.compat.a.b.k;
import com.tencent.mm.plugin.appbrand.compat.a.b.l;
import com.tencent.mm.plugin.appbrand.compat.a.b.m;
import com.tencent.mm.plugin.appbrand.compat.a.b.n;
import com.tencent.mm.plugin.appbrand.compat.a.b.o;
import com.tencent.mm.plugin.appbrand.compat.a.b.p;
import com.tencent.mm.plugin.appbrand.compat.a.b.q;
import com.tencent.mm.plugin.location_soso.SoSoMapView;
import com.tencent.tencentmap.mapsdk.map.g;
import com.tencent.tencentmap.mapsdk.map.g$h;
import com.tencent.tencentmap.mapsdk.map.g.a;
import com.tencent.tencentmap.mapsdk.map.g.e;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

final class d implements b {
    final FrameLayout iMa;
    final SoSoMapView iMb = ((SoSoMapView) this.iMa.findViewById(R.h.cks));

    d(Context context) {
        this.iMa = (FrameLayout) LayoutInflater.from(context).inflate(R.i.dal, null);
        this.iMa.setTag(R.h.bKr, this);
    }

    public final View getView() {
        return this.iMa;
    }

    public final boolean a(View view, double d, double d2) {
        this.iMb.addView(view, d, d2);
        return true;
    }

    public final boolean b(View view, double d, double d2) {
        if (view == null) {
            return false;
        }
        this.iMb.updateViewLayout(view, d, d2);
        return true;
    }

    public final f abu() {
        LatLng mapCenter = this.iMb.getMap().getMapCenter();
        return new f(mapCenter.getLatitude(), mapCenter.getLongitude());
    }

    public final f e(double d, double d2) {
        return new f(d, d2);
    }

    public final q abv() {
        return new j(this.iMb.getProjection());
    }

    public final void a(double d, double d2, int i) {
        g map = this.iMb.getMap();
        if (map != null) {
            map.moveCamera(com.tencent.tencentmap.mapsdk.map.b.a(new LatLng(d, d2), (float) i));
        }
    }

    public final void setCenter(double d, double d2) {
        this.iMb.getIController().setCenter(d, d2);
    }

    public final void jM(int i) {
        g map = this.iMb.getMap();
        if (map != null) {
            map.a(com.tencent.tencentmap.mapsdk.map.b.aK((float) i));
        }
    }

    public final void animateTo(double d, double d2) {
        this.iMb.getIController().animateTo(d, d2);
    }

    public final int getZoomLevel() {
        return this.iMb.getMap().getZoomLevel();
    }

    public final void clean() {
        this.iMb.clean();
    }

    public final void c(List<f> list, int i) {
        LatLngBounds$Builder latLngBounds$Builder = new LatLngBounds$Builder();
        Iterable linkedList = new LinkedList();
        for (f fVar : list) {
            if (fVar instanceof f) {
                linkedList.add(((f) fVar).iMk);
            } else {
                linkedList.add(new LatLng(fVar.abC(), fVar.abD()));
            }
        }
        latLngBounds$Builder.include(linkedList);
        this.iMb.getMap().a(com.tencent.tencentmap.mapsdk.map.b.a(latLngBounds$Builder.build(), i));
    }

    public final void a(m mVar) {
        g map = this.iMb.getMap();
        map.mapContext.c().a(new 1(this, mVar));
    }

    public final void a(final l lVar) {
        g map = this.iMb.getMap();
        map.mapContext.h().a(new e(this) {
            final /* synthetic */ d iMd;

            public final void c(LatLng latLng) {
                if (lVar != null) {
                    l lVar = lVar;
                    k.d(latLng);
                    lVar.abJ();
                }
            }
        });
    }

    public final void a(final k kVar) {
        g map = this.iMb.getMap();
        map.mapContext.h().a(new com.tencent.tencentmap.mapsdk.map.g.d(this) {
            final /* synthetic */ d iMd;

            public final void b(CameraPosition cameraPosition) {
                if (kVar != null) {
                    k kVar = kVar;
                    k.d(cameraPosition);
                    kVar.abH();
                }
            }

            public final void c(CameraPosition cameraPosition) {
                if (kVar != null) {
                    k kVar = kVar;
                    k.d(cameraPosition);
                    kVar.abI();
                }
            }
        });
    }

    public final void a(j jVar) {
        g map = this.iMb.getMap();
        map.mapContext.h().a(new 4(this, jVar));
    }

    public final void a(final n nVar) {
        g map = this.iMb.getMap();
        map.mapContext.h().a(new g$h(this) {
            final /* synthetic */ d iMd;

            public final boolean b(Marker marker) {
                return nVar != null && nVar.c(new g(marker));
            }
        });
    }

    public final void a(b.e eVar) {
        a aVar;
        g map = this.iMb.getMap();
        if (eVar == null) {
            aVar = null;
        } else {
            aVar = new 6(this, eVar);
        }
        map.mapContext.h().a(aVar);
    }

    public final i abw() {
        return new h();
    }

    public final h a(i iVar) {
        Marker addMarker;
        if (iVar instanceof h) {
            addMarker = this.iMb.getMap().addMarker(((h) iVar).iMn);
        } else {
            addMarker = null;
            Assert.assertTrue("Should use IAppBrandMapView.createMarkersOptions to initiate MarkerOptions!", true);
        }
        return new g(addMarker);
    }

    public final c abx() {
        return new c();
    }

    public final b.b a(c cVar) {
        Circle addCircle;
        if (cVar instanceof c) {
            addCircle = this.iMb.getMap().addCircle(((c) cVar).iLZ);
        } else {
            addCircle = null;
            Assert.assertTrue("Should use IAppBrandMapView.createMarkersOptions to initiate CircleOptions!", true);
        }
        return new m.a(addCircle);
    }

    public final o a(p pVar) {
        Polyline addPolyline;
        if (pVar instanceof i) {
            addPolyline = this.iMb.getMap().addPolyline(((i) pVar).iMo);
        } else {
            addPolyline = null;
            Assert.assertTrue("Should use IAppBrandMapView.createPolylineOptions to initiate PolylineOptions!", true);
        }
        return new m.b(addPolyline);
    }

    public final p aby() {
        return new i();
    }
}
