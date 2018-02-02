package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.wcdb.FileUtils;
import java.util.List;

public final class ee {
    private static ee a = null;

    public static ee a() {
        if (a == null) {
            a = new ee();
        }
        return a;
    }

    @SuppressLint({"NewApi"})
    public static int a(Context context) {
        int i;
        Object obj;
        Object obj2;
        boolean isProviderEnabled;
        List allProviders;
        boolean z;
        if (context == null) {
            return -1;
        }
        int i2;
        int i3;
        LocationManager locationManager;
        int i4;
        boolean z2;
        boolean b = b(context);
        try {
            Object obj3;
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null) {
                if (wifiManager.isWifiEnabled()) {
                    i = 1;
                } else {
                    i = 0;
                }
                try {
                    if (VERSION.SDK_INT < 18 || !wifiManager.isScanAlwaysAvailable()) {
                        i2 = 1;
                    } else {
                        obj = 1;
                        obj2 = 1;
                        i3 = i;
                        locationManager = (LocationManager) context.getSystemService("location");
                        if (locationManager == null) {
                            try {
                                i = Secure.getInt(context.getContentResolver(), "location_mode");
                            } catch (Throwable th) {
                                i = 0;
                            }
                            try {
                                isProviderEnabled = locationManager.isProviderEnabled("gps");
                                allProviders = locationManager.getAllProviders();
                                if (allProviders != null) {
                                    z = isProviderEnabled;
                                    i4 = i;
                                    z2 = false;
                                } else {
                                    z = isProviderEnabled;
                                    i4 = i;
                                    z2 = allProviders.contains("gps");
                                }
                            } catch (Exception e) {
                                i2 = i;
                                z2 = false;
                                i4 = i2;
                                z = false;
                                if (b) {
                                    i2 = 1;
                                } else {
                                    i2 = 0;
                                }
                                if (i3 == 0) {
                                    i2 += 2;
                                }
                                if (!z) {
                                    i2 += 4;
                                }
                                if (obj == null) {
                                    i2 += 8;
                                }
                                if (!z2) {
                                    i2 += 16;
                                }
                                if (obj2 == null) {
                                    i2 += 32;
                                }
                                switch (i4) {
                                    case 0:
                                        return i2 + 64;
                                    case 1:
                                        return i2 + FileUtils.S_IWUSR;
                                    case 2:
                                        return i2 + 256;
                                    case 3:
                                        return i2 + WXMediaMessage.TITLE_LENGTH_LIMIT;
                                    default:
                                        return i2;
                                }
                            }
                        }
                        z2 = false;
                        i4 = 0;
                        z = false;
                        if (b) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        if (i3 == 0) {
                            i2 += 2;
                        }
                        if (z) {
                            i2 += 4;
                        }
                        if (obj == null) {
                            i2 += 8;
                        }
                        if (z2) {
                            i2 += 16;
                        }
                        if (obj2 == null) {
                            i2 += 32;
                        }
                        switch (i4) {
                            case 0:
                                return i2 + 64;
                            case 1:
                                return i2 + FileUtils.S_IWUSR;
                            case 2:
                                return i2 + 256;
                            case 3:
                                return i2 + WXMediaMessage.TITLE_LENGTH_LIMIT;
                            default:
                                return i2;
                        }
                    }
                } catch (Throwable th2) {
                    obj = null;
                    obj2 = null;
                    i3 = i;
                    locationManager = (LocationManager) context.getSystemService("location");
                    if (locationManager == null) {
                        i = Secure.getInt(context.getContentResolver(), "location_mode");
                        isProviderEnabled = locationManager.isProviderEnabled("gps");
                        allProviders = locationManager.getAllProviders();
                        if (allProviders != null) {
                            z = isProviderEnabled;
                            i4 = i;
                            z2 = false;
                        } else {
                            z = isProviderEnabled;
                            i4 = i;
                            z2 = allProviders.contains("gps");
                        }
                    } else {
                        z2 = false;
                        i4 = 0;
                        z = false;
                    }
                    if (b) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                    }
                    if (i3 == 0) {
                        i2 += 2;
                    }
                    if (z) {
                        i2 += 4;
                    }
                    if (obj == null) {
                        i2 += 8;
                    }
                    if (z2) {
                        i2 += 16;
                    }
                    if (obj2 == null) {
                        i2 += 32;
                    }
                    switch (i4) {
                        case 0:
                            return i2 + 64;
                        case 1:
                            return i2 + FileUtils.S_IWUSR;
                        case 2:
                            return i2 + 256;
                        case 3:
                            return i2 + WXMediaMessage.TITLE_LENGTH_LIMIT;
                        default:
                            return i2;
                    }
                }
            }
            obj3 = null;
            i = 0;
            obj = obj3;
            obj2 = null;
            i3 = i;
        } catch (Throwable th3) {
            i = 0;
            obj = null;
            obj2 = null;
            i3 = i;
            locationManager = (LocationManager) context.getSystemService("location");
            if (locationManager == null) {
                z2 = false;
                i4 = 0;
                z = false;
            } else {
                i = Secure.getInt(context.getContentResolver(), "location_mode");
                isProviderEnabled = locationManager.isProviderEnabled("gps");
                allProviders = locationManager.getAllProviders();
                if (allProviders != null) {
                    z = isProviderEnabled;
                    i4 = i;
                    z2 = allProviders.contains("gps");
                } else {
                    z = isProviderEnabled;
                    i4 = i;
                    z2 = false;
                }
            }
            if (b) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            if (i3 == 0) {
                i2 += 2;
            }
            if (z) {
                i2 += 4;
            }
            if (obj == null) {
                i2 += 8;
            }
            if (z2) {
                i2 += 16;
            }
            if (obj2 == null) {
                i2 += 32;
            }
            switch (i4) {
                case 0:
                    return i2 + 64;
                case 1:
                    return i2 + FileUtils.S_IWUSR;
                case 2:
                    return i2 + 256;
                case 3:
                    return i2 + WXMediaMessage.TITLE_LENGTH_LIMIT;
                default:
                    return i2;
            }
        }
        try {
            locationManager = (LocationManager) context.getSystemService("location");
            if (locationManager == null) {
                z2 = false;
                i4 = 0;
                z = false;
            } else {
                i = Secure.getInt(context.getContentResolver(), "location_mode");
                isProviderEnabled = locationManager.isProviderEnabled("gps");
                allProviders = locationManager.getAllProviders();
                if (allProviders != null) {
                    z = isProviderEnabled;
                    i4 = i;
                    z2 = allProviders.contains("gps");
                } else {
                    z = isProviderEnabled;
                    i4 = i;
                    z2 = false;
                }
            }
        } catch (Exception e2) {
            i2 = 0;
            z2 = false;
            i4 = i2;
            z = false;
            if (b) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i3 == 0) {
                i2 += 2;
            }
            if (z) {
                i2 += 4;
            }
            if (obj == null) {
                i2 += 8;
            }
            if (z2) {
                i2 += 16;
            }
            if (obj2 == null) {
                i2 += 32;
            }
            switch (i4) {
                case 0:
                    return i2 + 64;
                case 1:
                    return i2 + FileUtils.S_IWUSR;
                case 2:
                    return i2 + 256;
                case 3:
                    return i2 + WXMediaMessage.TITLE_LENGTH_LIMIT;
                default:
                    return i2;
            }
        }
        if (b) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (i3 == 0) {
            i2 += 2;
        }
        if (z) {
            i2 += 4;
        }
        if (obj == null) {
            i2 += 8;
        }
        if (z2) {
            i2 += 16;
        }
        if (obj2 == null) {
            i2 += 32;
        }
        switch (i4) {
            case 0:
                return i2 + 64;
            case 1:
                return i2 + FileUtils.S_IWUSR;
            case 2:
                return i2 + 256;
            case 3:
                return i2 + WXMediaMessage.TITLE_LENGTH_LIMIT;
            default:
                return i2;
        }
    }

    private static boolean b(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return false;
            }
            return telephonyManager.getSimState() == 5;
        } catch (Exception e) {
            return false;
        }
    }
}
