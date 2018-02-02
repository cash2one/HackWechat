package com.tencent.mm.plugin.appbrand.compat;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mm.plugin.appbrand.compat.a.b$f;
import com.tencent.mm.plugin.appbrand.compat.a.b.h;

final class g extends m<Marker> implements h {
    final Marker iMl;

    g(Marker marker) {
        super(marker);
        this.iMl = marker;
    }

    public final void qw(String str) {
        if (this.iMl != null) {
            this.iMl.setTag(str);
        }
    }

    public final String getTitle() {
        return this.iMl == null ? "" : this.iMl.getTitle();
    }

    public final String getSnippet() {
        return this.iMl == null ? "" : this.iMl.getSnippet();
    }

    public final boolean isInfoWindowShown() {
        return this.iMl != null && this.iMl.isInfoWindowShown();
    }

    public final void showInfoWindow() {
        if (this.iMl != null) {
            this.iMl.showInfoWindow();
        }
    }

    public final void hideInfoWindow() {
        if (this.iMl != null) {
            this.iMl.hideInfoWindow();
        }
    }

    public final b$f abE() {
        return this.iMl == null ? new b$f(this) {
            final /* synthetic */ g iMm;

            {
                this.iMm = r1;
            }

            public final double abC() {
                return 0.0d;
            }

            public final double abD() {
                return 0.0d;
            }
        } : new f(this.iMl.getPosition());
    }

    public final void b(b$f com_tencent_mm_plugin_appbrand_compat_a_b_f) {
        if (this.iMl == null) {
            return;
        }
        if (com_tencent_mm_plugin_appbrand_compat_a_b_f instanceof f) {
            this.iMl.setPosition(((f) com_tencent_mm_plugin_appbrand_compat_a_b_f).iMk);
        } else {
            this.iMl.setPosition(new LatLng(com_tencent_mm_plugin_appbrand_compat_a_b_f.abC(), com_tencent_mm_plugin_appbrand_compat_a_b_f.abD()));
        }
    }

    public final float getRotation() {
        return this.iMl == null ? 0.0f : this.iMl.getRotation();
    }

    public final void setRotation(float f) {
        if (this.iMl != null) {
            this.iMl.setRotation(f);
        }
    }
}
