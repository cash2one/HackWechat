package c.t.m.g;

import android.location.Location;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import org.json.JSONException;

public class dz$a {
    public String a;
    public dz b;
    public int c;
    public String d = TencentLocation.NETWORK_PROVIDER;
    private Location e;

    public final dz a() {
        Object dzVar;
        if (this.a != null) {
            try {
                dzVar = new dz(this.a, (byte) 0);
            } catch (JSONException e) {
                return dz.a;
            }
        }
        dzVar = dz.c(this.b);
        dz.a(dz.b(dz.b(dzVar, this.c), this.d), this.e);
        TencentExtraKeys.setRawGps(dzVar, this.e);
        return dzVar;
    }

    public final dz$a a(Location location) {
        this.e = new Location(location);
        return this;
    }
}
