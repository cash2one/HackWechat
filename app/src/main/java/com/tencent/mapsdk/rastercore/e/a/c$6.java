package com.tencent.mapsdk.rastercore.e.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mapsdk.raster.model.Marker;

class c$6 implements OnClickListener {
    private /* synthetic */ c a;

    c$6(c cVar) {
        this.a = cVar;
    }

    public final void onClick(View view) {
        if (c.a(this.a).f() != null) {
            c.a(this.a).f().a(new Marker(this.a));
        }
    }
}
