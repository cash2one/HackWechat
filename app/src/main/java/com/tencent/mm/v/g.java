package com.tencent.mm.v;

import com.tencent.mm.bz.a;
import java.util.Map;
import org.json.JSONObject;

public final class g {
    private static volatile int gPa = 0;
    private static volatile boolean gPb = false;

    public static void initialize() {
        a.post(new 1());
    }

    public static JSONObject fy(String str) {
        if (!gPb) {
            initialize();
        }
        if (gPa == 1) {
            return new h(str);
        }
        return new JSONObject(str);
    }

    public static c Cd() {
        if (gPa == 1) {
            return new k();
        }
        return new d();
    }

    public static c n(Map map) {
        if (gPa == 1) {
            return new k(map);
        }
        return new d(map);
    }

    public static c fz(String str) {
        if (gPa == 1) {
            return new k(str);
        }
        return new d(str);
    }

    public static a Ce() {
        if (gPa == 1) {
            return new j();
        }
        return new b();
    }

    public static a fA(String str) {
        if (gPa == 1) {
            return new j(str);
        }
        return new b(str);
    }

    public static void gy(int i) {
        gPa = i;
        gPb = true;
    }

    public static int Cf() {
        return gPa;
    }
}
