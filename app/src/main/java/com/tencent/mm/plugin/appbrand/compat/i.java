package com.tencent.mm.plugin.appbrand.compat;

import android.graphics.Bitmap;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mm.plugin.appbrand.compat.a.b.f;
import com.tencent.mm.plugin.appbrand.compat.a.b.p;
import java.util.LinkedList;

final class i implements p {
    final PolylineOptions iMo = new PolylineOptions();

    i() {
    }

    public final void a(Iterable<f> iterable) {
        Iterable linkedList = new LinkedList();
        for (f fVar : iterable) {
            if (fVar instanceof f) {
                linkedList.add(((f) fVar).iMk);
            } else {
                linkedList.add(new LatLng(fVar.abC(), fVar.abD()));
            }
        }
        this.iMo.addAll(linkedList);
    }

    public final void jN(int i) {
        this.iMo.color(i);
    }

    public final void jO(int i) {
        this.iMo.width((float) i);
    }

    public final void setDottedLine(boolean z) {
        this.iMo.setDottedLine(z);
    }

    public final void jP(int i) {
        this.iMo.edgeColor(i);
    }

    public final void jQ(int i) {
        this.iMo.edgeWidth((float) i);
    }

    public final void q(Bitmap bitmap) {
        this.iMo.arrowTexture(new BitmapDescriptor(bitmap));
    }
}
