package com.tencent.map.geolocation.internal;

import android.content.Context;
import android.location.Location;
import c.t.m.g.ch;
import c.t.m.g.j;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.TencentLocationUtils;
import java.io.File;
import org.eclipse.jdt.annotation.Nullable;

public class TencentExtraKeys {
    public static final boolean ALLOW_LISTEN_WIFI_GPS_IN_MAINLOOPER = false;
    public static final boolean ALLOW_NLP_LOCATION = true;
    public static final TencentLog DEFAULT_TENCENT_LOG = new 1();
    public static final boolean DIDI_INTERNAL = false;
    public static final String LOCATION_KEY_ADMIN_LEVEL1 = "admin_level_1";
    public static final String LOCATION_KEY_ADMIN_LEVEL2 = "admin_level_2";
    public static final String LOCATION_KEY_ADMIN_LEVEL3 = "admin_level_3";
    public static final String LOCATION_KEY_LOCALITY = "locality";
    public static final String LOCATION_KEY_NATION = "nation";
    public static final String LOCATION_KEY_ROUTE = "route";
    public static final String LOCATION_KEY_SUBLOCALITY = "sublocality";
    public static final String LOCATION_SOURCE_CELL = "cell";
    public static final String LOCATION_SOURCE_GPS = "gps";
    public static final String LOCATION_SOURCE_WIFI = "wifi";
    public static boolean MOCK_LOCATION_FILTER = true;
    public static final String RAW_DATA = "raw_data";
    public static final String REQUEST_RAW_DATA = "request_raw_data";
    public static final boolean STRICT_CELL_FILTER = true;
    public static final boolean TENCENT_INTERNAL = true;
    private static File sLogDir;
    private static TencentLog sTencentLog;

    public static void enableMockLocationFilter(boolean z) {
        MOCK_LOCATION_FILTER = z;
    }

    public static byte[] getRawData(TencentLocation tencentLocation) {
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getExtra().getByteArray(RAW_DATA);
    }

    public static TencentLocation setRawData(TencentLocation tencentLocation, byte[] bArr) {
        tencentLocation.getExtra().putByteArray(RAW_DATA, bArr);
        return tencentLocation;
    }

    public static String getRawQuery(TencentLocation tencentLocation) {
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getExtra().getString("raw_query");
    }

    public static void setRawQuery(TencentLocation tencentLocation, String str) {
        if (tencentLocation != null) {
            tencentLocation.getExtra().putString("raw_query", str);
        }
    }

    public static Location getRawGps(TencentLocation tencentLocation) {
        if (tencentLocation == null) {
            return null;
        }
        return (Location) tencentLocation.getExtra().getParcelable("raw_gps");
    }

    public static void setRawGps(TencentLocation tencentLocation, Location location) {
        if (tencentLocation != null) {
            try {
                tencentLocation.getExtra().putParcelable("raw_gps", location);
            } catch (Exception e) {
            }
        }
    }

    public static TencentLocationRequest setRequestRawData(TencentLocationRequest tencentLocationRequest, boolean z) {
        if (tencentLocationRequest != null) {
            tencentLocationRequest.getExtras().putBoolean(REQUEST_RAW_DATA, z);
        }
        return tencentLocationRequest;
    }

    public static boolean isRequestRawData(TencentLocationRequest tencentLocationRequest) {
        if (tencentLocationRequest == null) {
            return false;
        }
        return tencentLocationRequest.getExtras().getBoolean(REQUEST_RAW_DATA);
    }

    public static boolean isAllowedLevel(int i) {
        switch (i) {
            case 0:
            case 1:
            case 3:
            case 4:
                return true;
            default:
                return i == 7;
        }
    }

    public static int isInsIllegalApp(Context context) {
        if (context == null) {
            return 0;
        }
        return j.c(context);
    }

    public static String getLocationSource(TencentLocation tencentLocation) {
        if (tencentLocation == null) {
            return "";
        }
        boolean isFromGps = TencentLocationUtils.isFromGps(tencentLocation);
        boolean isFromNetwork = TencentLocationUtils.isFromNetwork(tencentLocation);
        int i = tencentLocation.getExtra().getInt("wifi_ap_num");
        if (isFromGps) {
            return "gps";
        }
        if (!isFromNetwork || i < 3) {
            return "cell";
        }
        return "wifi";
    }

    public static void loadLibrary(String str) {
        System.load(str);
    }

    public static synchronized void setTencentLog(TencentLog tencentLog) {
        synchronized (TencentExtraKeys.class) {
            sTencentLog = tencentLog;
            ch.a(new 2());
        }
    }

    @Nullable
    public static synchronized TencentLog getTencentLog() {
        TencentLog tencentLog;
        synchronized (TencentExtraKeys.class) {
            tencentLog = sTencentLog;
        }
        return tencentLog;
    }

    @Deprecated
    public static synchronized boolean isDebugEnabled() {
        boolean z;
        synchronized (TencentExtraKeys.class) {
            z = sTencentLog != null;
        }
        return z;
    }

    public static synchronized void setLogDir(File file) {
        synchronized (TencentExtraKeys.class) {
            sLogDir = file;
        }
    }

    public static synchronized File getLogDir() {
        File file;
        synchronized (TencentExtraKeys.class) {
            file = sLogDir;
        }
        return file;
    }
}
