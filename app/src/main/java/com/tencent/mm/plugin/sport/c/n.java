package com.tencent.mm.plugin.sport.c;

import android.content.Context;
import android.hardware.SensorManager;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.q;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

public final class n {
    public static q rUl;

    public static final String bp(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j));
    }

    public static boolean E(long j, long j2) {
        long j3 = 3600000;
        try {
            JSONObject optJSONObject = g.bDr().optJSONObject("stepCountUploadConfig");
            if (optJSONObject != null) {
                j3 = ((long) (optJSONObject.optInt("backgroundTimeInterval", 60) * 60)) * 1000;
            }
        } catch (Exception e) {
        }
        return j2 - j >= j3;
    }

    public static boolean F(long j, long j2) {
        int i = 500;
        if (j == 0 && j2 > 0) {
            return true;
        }
        try {
            JSONObject optJSONObject = g.bDr().optJSONObject("stepCountUploadConfig");
            if (optJSONObject != null) {
                i = optJSONObject.optInt("backgroundStepCountInterval", 500);
            }
        } catch (Exception e) {
        }
        return j2 - j >= ((long) i);
    }

    public static boolean dz(Context context) {
        if (d.fN(19)) {
            x.i("MicroMsg.Sport.SportUtil", "Not Support SDK VERSION");
            return false;
        } else if (!context.getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter")) {
            x.i("MicroMsg.Sport.SportUtil", "Not Support FEATURE_SENSOR_STEP_COUNTER");
            return false;
        } else if (((SensorManager) context.getSystemService("sensor")).getDefaultSensor(19) == null) {
            x.i("MicroMsg.Sport.SportUtil", "Not Support can not get sensor");
            return false;
        } else if (g.bDr().optInt("deviceStepSwitch") == 1) {
            return true;
        } else {
            x.i("MicroMsg.Sport.SportUtil", "Not Support deviceStepSwitch is off");
            return false;
        }
    }

    public static boolean bDy() {
        if (g.bDr().optInt("extStepApiSwitch") == 1) {
            return true;
        }
        x.i("MicroMsg.Sport.SportUtil", "Not Support extStepApiSwitch is off");
        return false;
    }

    public static boolean bDd() {
        boolean fZ;
        af WO = ((h) g.h(h.class)).EY().WO("gh_43f2581f6fd6");
        if (WO != null) {
            fZ = a.fZ(WO.field_type);
        } else {
            fZ = false;
        }
        if (!fZ) {
            x.i("MicroMsg.Sport.SportUtil", "checkUserInstallWeSportPlugin %b", new Object[]{Boolean.valueOf(fZ)});
        }
        return fZ;
    }
}
