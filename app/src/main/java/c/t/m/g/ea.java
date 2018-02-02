package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.jdt.annotation.NonNull;

public final class ea {
    public static boolean a = false;

    @SuppressLint({"NewApi"})
    public static boolean a(Context context) {
        try {
            if (VERSION.SDK_INT >= 17) {
                if (Global.getInt(context.getContentResolver(), "airplane_mode_on") == 1) {
                    return true;
                }
                return false;
            } else if (System.getInt(context.getContentResolver(), "airplane_mode_on") != 1) {
                return false;
            } else {
                return true;
            }
        } catch (Throwable th) {
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    public static List<dn> a(cr crVar) {
        try {
            TelephonyManager telephonyManager = crVar.e;
            if (telephonyManager != null) {
                List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
                if (allCellInfo == null) {
                    return null;
                }
                List<dn> arrayList = new ArrayList();
                for (CellInfo cellInfo : allCellInfo) {
                    if (cellInfo.isRegistered()) {
                        arrayList.add(dn.a(crVar, cellInfo));
                    }
                }
                return arrayList;
            }
        } catch (Throwable th) {
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static CellLocation b(cr crVar) {
        boolean z = false;
        TelephonyManager telephonyManager = crVar.e;
        if (telephonyManager != null) {
            try {
                CellLocation cellLocation = telephonyManager.getCellLocation();
                boolean z2 = telephonyManager.getSimState() == 5;
                boolean z3;
                try {
                    if (TextUtils.isEmpty(telephonyManager.getSubscriberId())) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                } catch (Exception e) {
                    z3 = true;
                }
                if (z2 && r3) {
                    if (cellLocation != null) {
                        if (!b(cellLocation)) {
                        }
                    }
                    if (!a(crVar.a)) {
                        z = true;
                    }
                    a = z;
                }
                return cellLocation;
            } catch (Exception e2) {
                a = true;
            }
        }
        return CellLocation.getEmpty();
    }

    public static int a(CellLocation cellLocation) {
        if (cellLocation instanceof CdmaCellLocation) {
            return ((CdmaCellLocation) cellLocation).getBaseStationId();
        }
        try {
            return ((GsmCellLocation) cellLocation).getCid();
        } catch (Exception e) {
            return -1;
        }
    }

    private static boolean b(CellLocation cellLocation) {
        try {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            if (gsmCellLocation.getCid() == 0 && gsmCellLocation.getLac() == 0) {
                return true;
            }
        } catch (ClassCastException e) {
        }
        return false;
    }

    public static boolean a(CellLocation cellLocation, CellLocation cellLocation2) {
        boolean z;
        if (cellLocation == null || cellLocation2 == null) {
            z = true;
        } else {
            z = false;
        }
        if (z || cellLocation.getClass() != cellLocation2.getClass()) {
            return false;
        }
        if (cellLocation instanceof GsmCellLocation) {
            if (((GsmCellLocation) cellLocation).getCid() == ((GsmCellLocation) cellLocation2).getCid()) {
                return true;
            }
            return false;
        } else if (!(cellLocation instanceof CdmaCellLocation)) {
            return false;
        } else {
            if (((CdmaCellLocation) cellLocation).getBaseStationId() == ((CdmaCellLocation) cellLocation2).getBaseStationId()) {
                return true;
            }
            return false;
        }
    }

    public static boolean a(dn dnVar) {
        boolean z;
        if (dnVar == null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        return a(dnVar.a.ordinal(), dnVar.b, dnVar.c, dnVar.d, dnVar.e);
    }

    public static boolean a(int i, int i2, int i3, int i4, int i5) {
        if (b(i)) {
            if (i2 < 0 || i3 < 0 || i4 < 0 || i4 > 65535 || i5 <= 0 || i5 > 65535 || (i3 == 0 && i4 == 0 && i5 == 0)) {
                return false;
            }
            return true;
        } else if (i2 < 0 || i3 < 0 || i4 <= 0 || i4 >= 65535) {
            return false;
        } else {
            if (i5 == 268435455 || i5 == Integer.MAX_VALUE || i5 == 50594049 || i5 == 65535 || i5 <= 0) {
                return false;
            }
            if (i5 == 65535 || i5 <= 0) {
                return false;
            }
            return true;
        }
    }

    public static boolean a(int i, SignalStrength signalStrength, SignalStrength signalStrength2) {
        if (signalStrength == null || signalStrength2 == null) {
            return true;
        }
        int abs = Math.abs(b(i, signalStrength, signalStrength2));
        if (a(i)) {
            if (abs <= 3) {
                return false;
            }
            return true;
        } else if (!b(i)) {
            return false;
        } else {
            if (abs <= 6) {
                return false;
            }
            return true;
        }
    }

    private static int b(int i, SignalStrength signalStrength, SignalStrength signalStrength2) {
        try {
            if (a(i)) {
                return signalStrength.getGsmSignalStrength() - signalStrength2.getGsmSignalStrength();
            }
            if (b(i)) {
                return signalStrength.getCdmaDbm() - signalStrength2.getCdmaDbm();
            }
            return 0;
        } catch (Throwable th) {
        }
    }

    private static boolean a(int i) {
        return i != dn$a.CDMA.ordinal();
    }

    private static boolean b(int i) {
        return i == dn$a.CDMA.ordinal();
    }

    public static void a(@NonNull TelephonyManager telephonyManager, @NonNull int[] iArr) {
        String networkOperator = telephonyManager.getNetworkOperator();
        if (networkOperator != null && networkOperator.length() >= 5) {
            try {
                iArr[0] = Integer.parseInt(networkOperator.substring(0, 3));
                iArr[1] = Integer.parseInt(networkOperator.substring(3, 5));
                return;
            } catch (Throwable th) {
                th.toString();
            }
        }
        iArr[0] = 460;
        iArr[1] = 0;
    }

    public static List<NeighboringCellInfo> c(cr crVar) {
        TelephonyManager telephonyManager = crVar.e;
        if (telephonyManager != null) {
            try {
                return telephonyManager.getNeighboringCellInfo();
            } catch (Exception e) {
            }
        }
        return Collections.emptyList();
    }
}
