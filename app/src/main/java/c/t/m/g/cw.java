package c.t.m.g;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.LruCache;
import android.util.Pair;

@SuppressLint({"NewApi"})
final class cw extends cv {
    private LruCache<String, Pair<Double, Double>> a = new LruCache(100);

    public cw(String str) {
        super(str, "check cell");
    }

    public final void a() {
        super.a();
        this.a.evictAll();
    }

    protected final boolean a(Bundle bundle) {
        CharSequence string = bundle.getString("cellkey");
        Location location = (Location) bundle.getParcelable("location");
        if (location == null) {
            return true;
        }
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        Pair pair = (Pair) this.a.get(string);
        if (pair != null) {
            return eg.a(location.getLatitude(), location.getLongitude(), ((Double) pair.first).doubleValue(), ((Double) pair.second).doubleValue()) < 6000.0d;
        } else {
            this.a.put(string, Pair.create(Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())));
            return true;
        }
    }
}
