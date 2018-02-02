package c.t.m.g;

import android.annotation.SuppressLint;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.util.Collections;
import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public final class dn extends dq {
    public a a = a.a;
    public int b = 460;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public int g = Integer.MAX_VALUE;
    public int h = Integer.MAX_VALUE;
    private final long i = System.currentTimeMillis();
    private List<NeighboringCellInfo> j;

    private dn() {
    }

    @Nullable
    public static dn a(cr crVar, CellLocation cellLocation, SignalStrength signalStrength) {
        if (!crVar.b() || cellLocation == null) {
            return null;
        }
        TelephonyManager telephonyManager = crVar.e;
        dn dnVar = new dn();
        try {
            if (cellLocation instanceof CdmaCellLocation) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                dnVar.a = a.c;
                dnVar.a(telephonyManager);
                dnVar.c = cdmaCellLocation.getSystemId();
                dnVar.d = cdmaCellLocation.getNetworkId();
                dnVar.e = cdmaCellLocation.getBaseStationId();
                dnVar.g = cdmaCellLocation.getBaseStationLatitude();
                dnVar.h = cdmaCellLocation.getBaseStationLongitude();
                if (signalStrength == null) {
                    dnVar.f = -1;
                    return dnVar;
                }
                dnVar.f = signalStrength.getCdmaDbm();
                return dnVar;
            }
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            dnVar.a = a.b;
            dnVar.a(telephonyManager);
            dnVar.d = gsmCellLocation.getLac();
            dnVar.e = gsmCellLocation.getCid();
            if (signalStrength == null) {
                dnVar.f = -1;
                return dnVar;
            }
            dnVar.f = (signalStrength.getGsmSignalStrength() * 2) - 113;
            return dnVar;
        } catch (Throwable th) {
            th.toString();
            return dnVar;
        }
    }

    @Nullable
    @SuppressLint({"NewApi"})
    public static dn a(cr crVar, CellInfo cellInfo) {
        int i = -88;
        if (cellInfo == null) {
            return null;
        }
        TelephonyManager telephonyManager = crVar.e;
        dn dnVar = new dn();
        try {
            int dbm;
            if (cellInfo instanceof CellInfoCdma) {
                CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
                dnVar.a = a.c;
                dnVar.a(telephonyManager);
                dnVar.c = cellIdentity.getSystemId();
                dnVar.d = cellIdentity.getNetworkId();
                dnVar.e = cellIdentity.getBasestationId();
                dnVar.g = cellIdentity.getLatitude();
                dnVar.h = cellIdentity.getLongitude();
                dbm = cellInfoCdma.getCellSignalStrength().getDbm();
                if (dbm > -110 && dbm < -40) {
                    i = dbm;
                }
                dnVar.f = i;
                return dnVar;
            } else if (cellInfo instanceof CellInfoGsm) {
                CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                dnVar.a = a.b;
                CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                dnVar.d = cellIdentity2.getLac();
                dnVar.e = cellIdentity2.getCid();
                dnVar.b = cellIdentity2.getMcc();
                dnVar.c = cellIdentity2.getMnc();
                dbm = cellInfoGsm.getCellSignalStrength().getDbm();
                if (dbm > -110 && dbm < -40) {
                    i = dbm;
                }
                dnVar.f = i;
                return dnVar;
            } else if (cellInfo instanceof CellInfoWcdma) {
                CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                dnVar.a = a.d;
                CellIdentityWcdma cellIdentity3 = cellInfoWcdma.getCellIdentity();
                dnVar.d = cellIdentity3.getLac();
                dnVar.e = cellIdentity3.getCid();
                dnVar.b = cellIdentity3.getMcc();
                dnVar.c = cellIdentity3.getMnc();
                dbm = cellInfoWcdma.getCellSignalStrength().getDbm();
                if (dbm > -110 && dbm < -40) {
                    i = dbm;
                }
                dnVar.f = i;
                return dnVar;
            } else if (!(cellInfo instanceof CellInfoLte)) {
                return dnVar;
            } else {
                CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                dnVar.a = a.e;
                CellIdentityLte cellIdentity4 = cellInfoLte.getCellIdentity();
                dnVar.d = cellIdentity4.getTac();
                dnVar.e = cellIdentity4.getCi();
                dnVar.b = cellIdentity4.getMcc();
                dnVar.c = cellIdentity4.getMnc();
                dbm = cellInfoLte.getCellSignalStrength().getDbm();
                if (dbm <= -110 || dbm >= -40) {
                    dbm = -88;
                }
                dnVar.f = dbm;
                return dnVar;
            }
        } catch (Throwable th) {
            th.toString();
            return dnVar;
        }
    }

    private void a(TelephonyManager telephonyManager) {
        int[] iArr = new int[2];
        ea.a(telephonyManager, iArr);
        if (iArr[0] > 0 && iArr[1] >= 0) {
            this.b = iArr[0];
            this.c = iArr[1];
        }
    }

    @NonNull
    public final synchronized List<NeighboringCellInfo> a() {
        if (this.j == null) {
            this.j = Collections.emptyList();
        }
        return this.j;
    }

    public final synchronized void a(@Nullable List<NeighboringCellInfo> list) {
        if (list != null) {
            this.j = Collections.unmodifiableList(list);
        } else {
            this.j = Collections.emptyList();
        }
    }

    public final String b() {
        return this.b + this.c + this.d + this.e;
    }

    public final String toString() {
        return "TxCellInfo [PhoneType=" + this.a + ", MCC=" + this.b + ", MNC=" + this.c + ", LAC=" + this.d + ", CID=" + this.e + ", RSSI=" + this.f + ", LAT=" + this.g + ", LNG=" + this.h + ", mTime=" + this.i + "]";
    }
}
