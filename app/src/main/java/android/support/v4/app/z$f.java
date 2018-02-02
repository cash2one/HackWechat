package android.support.v4.app;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.z.g;

public final class z$f implements g {
    private Bitmap se;
    private int su = 0;
    public a sz;

    public final z$d a(z$d android_support_v4_app_z_d) {
        if (VERSION.SDK_INT >= 21) {
            Bundle bundle = new Bundle();
            if (this.se != null) {
                bundle.putParcelable("large_icon", this.se);
            }
            if (this.su != 0) {
                bundle.putInt("app_color", this.su);
            }
            if (this.sz != null) {
                bundle.putBundle("car_conversation", z.bh().a(this.sz));
            }
            if (android_support_v4_app_z_d.mExtras == null) {
                android_support_v4_app_z_d.mExtras = new Bundle();
            }
            android_support_v4_app_z_d.mExtras.putBundle("android.car.EXTENSIONS", bundle);
        }
        return android_support_v4_app_z_d;
    }
}
