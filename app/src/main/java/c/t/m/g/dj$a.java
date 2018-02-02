package c.t.m.g;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationUtils;

class dj$a {
    double a;
    double b;
    long c;
    int d;

    dj$a() {
    }

    public final String toString() {
        return "[" + this.a + "," + this.b + "]";
    }

    static dj$a a(TencentLocation tencentLocation) {
        int i = 2;
        dj$a c_t_m_g_dj_a = new dj$a();
        c_t_m_g_dj_a.a = tencentLocation.getLatitude();
        c_t_m_g_dj_a.b = tencentLocation.getLongitude();
        c_t_m_g_dj_a.c = tencentLocation.getTime();
        tencentLocation.getSpeed();
        if (TencentLocationUtils.isFromGps(tencentLocation)) {
            if (tencentLocation.getAccuracy() < 100.0f) {
                i = 3;
            }
            c_t_m_g_dj_a.d = i;
        } else {
            if (tencentLocation.getAccuracy() >= 500.0f) {
                i = 1;
            }
            c_t_m_g_dj_a.d = i;
        }
        return c_t_m_g_dj_a;
    }
}
