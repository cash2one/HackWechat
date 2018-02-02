package c.t.m.g;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.telephony.NeighboringCellInfo;
import com.tencent.map.geolocation.TencentLocationManagerOptions;
import com.tencent.tencentmap.lbssdk.service.e;
import com.tencent.wcdb.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public final class eg {
    private static final byte[] a = new byte[0];

    public static byte[] a(String str, String str2) {
        try {
            Object a = ec.a(a(str.getBytes("GBK")), str2);
            if (a == null || a.length == 0) {
                return a;
            }
            byte[] bArr = new byte[(a.length + 2)];
            Object obj = new byte[2];
            int length = a.length;
            for (int i = 0; i < 2; i++) {
                obj[i] = Integer.valueOf(length & 255).byteValue();
                length >>= 8;
            }
            System.arraycopy(obj, 0, bArr, 0, 2);
            System.arraycopy(a, 0, bArr, 2, a.length);
            return bArr;
        } catch (Throwable th) {
            th.toString();
            return a;
        }
    }

    public static byte[] a(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return bArr2;
        } catch (Throwable th) {
            return bArr2;
        }
    }

    public static boolean a(int i) {
        return i == 0;
    }

    public static boolean a(Location location, double[] dArr) {
        int latitude = (int) (location.getLatitude() * 1000000.0d);
        int longitude = (int) (location.getLongitude() * 1000000.0d);
        String c = j.c("tencent_loc_lib");
        int i = 0;
        for (int i2 = 0; i2 < c.length(); i2++) {
            i += a(c.charAt(i2));
        }
        double[] dArr2 = new double[2];
        try {
            e.b(latitude ^ i, i ^ longitude, dArr2);
        } catch (UnsatisfiedLinkError e) {
        }
        dArr[0] = dArr2[0];
        dArr[1] = dArr2[1];
        return true;
    }

    public static boolean a(double[] dArr, double[] dArr2) {
        if (TencentLocationManagerOptions.isLoadLibraryEnabled()) {
            try {
                System.loadLibrary("tencentloc");
            } catch (Throwable th) {
                new StringBuilder("LOAD:").append(th.toString());
                return false;
            }
        }
        int i = (int) (dArr[0] * 1000000.0d);
        int i2 = (int) (dArr[1] * 1000000.0d);
        String c = j.c("tencent_loc_lib");
        int i3 = 0;
        for (int i4 = 0; i4 < c.length(); i4++) {
            i3 += a(c.charAt(i4));
        }
        double[] dArr3 = new double[2];
        try {
            e.b(i ^ i3, i3 ^ i2, dArr3);
            dArr2[0] = dArr3[0];
            dArr2[1] = dArr3[1];
            return true;
        } catch (Throwable th2) {
            new StringBuilder("E.B:").append(th2.toString());
            return false;
        }
    }

    private static double a(double d, int i) {
        double d2 = 0.0d;
        try {
            if (!Double.isNaN(d)) {
                d2 = BigDecimal.valueOf(d).setScale(i, RoundingMode.HALF_DOWN).doubleValue();
            }
        } catch (Exception e) {
        }
        return d2;
    }

    private static int a(char c) {
        int i = 256;
        if (c >= 'A' && c <= 'Z') {
            i = c - 65;
        }
        if (c >= 'a' && c <= 'z') {
            i = (c - 97) + 64;
        }
        if (c < '0' || c > '9') {
            return i;
        }
        return (c + FileUtils.S_IWUSR) - 48;
    }

    public static String a(do doVar) {
        if (doVar == null) {
            return "{}";
        }
        Location location = doVar.a;
        StringBuilder stringBuilder = new StringBuilder();
        double a = a(location.getLatitude(), 6);
        double a2 = a(location.getLongitude(), 6);
        double a3 = a(location.getAltitude(), 1);
        double a4 = a((double) location.getAccuracy(), 1);
        double a5 = a((double) location.getBearing(), 1);
        double a6 = a((double) location.getSpeed(), 1);
        stringBuilder.append("{");
        stringBuilder.append("\"latitude\":");
        stringBuilder.append(a);
        stringBuilder.append(",\"longitude\":");
        stringBuilder.append(a2);
        stringBuilder.append(",\"additional\":");
        stringBuilder.append("\"" + a3 + "," + a4 + "," + a5 + "," + a6 + "," + doVar.b + "\"");
        stringBuilder.append(",\"source\":");
        stringBuilder.append(doVar.d - 1);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static String a(dn dnVar, boolean z) {
        if (dnVar == null) {
            return "[]";
        }
        int i = dnVar.b;
        int i2 = dnVar.c;
        int ordinal = dnVar.a.ordinal();
        Iterable arrayList = new ArrayList();
        List<NeighboringCellInfo> a = dnVar.a();
        if (ea.a(ordinal, i, i2, dnVar.d, dnVar.e)) {
            int i3 = dnVar.d;
            int i4 = dnVar.e;
            int i5 = dnVar.f;
            int i6 = dnVar.g;
            int i7 = dnVar.h;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{");
            stringBuilder.append("\"mcc\":");
            stringBuilder.append(i);
            stringBuilder.append(",\"mnc\":");
            stringBuilder.append(i2);
            stringBuilder.append(",\"lac\":");
            stringBuilder.append(i3);
            stringBuilder.append(",\"cellid\":");
            stringBuilder.append(i4);
            stringBuilder.append(",\"rss\":");
            stringBuilder.append(i5);
            stringBuilder.append(",\"seed\":");
            stringBuilder.append(z ? 1 : 0);
            stringBuilder.append(",\"networktype\":");
            stringBuilder.append(ordinal);
            if (!(i6 == Integer.MAX_VALUE || i7 == Integer.MAX_VALUE)) {
                stringBuilder.append(",\"stationLat\":");
                stringBuilder.append(String.format("%.6f", new Object[]{Float.valueOf(((float) i6) / 14400.0f)}));
                stringBuilder.append(",\"stationLng\":");
                stringBuilder.append(String.format("%.6f", new Object[]{Float.valueOf(((float) i7) / 14400.0f)}));
            }
            stringBuilder.append("}");
            arrayList.add(stringBuilder.toString());
        } else {
            a("illeagal main cell! ", i, i2, ordinal, dnVar.d, dnVar.e);
        }
        try {
            for (NeighboringCellInfo neighboringCellInfo : a) {
                i4 = neighboringCellInfo.getLac();
                i5 = neighboringCellInfo.getCid();
                if (ea.a(ordinal, i, i2, i4, i5)) {
                    i3 = (neighboringCellInfo.getRssi() << 1) - 113;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("{");
                    stringBuilder2.append("\"mcc\":");
                    stringBuilder2.append(i);
                    stringBuilder2.append(",\"mnc\":");
                    stringBuilder2.append(i2);
                    stringBuilder2.append(",\"lac\":");
                    stringBuilder2.append(i4);
                    stringBuilder2.append(",\"cellid\":");
                    stringBuilder2.append(i5);
                    stringBuilder2.append(",\"rss\":");
                    stringBuilder2.append(i3);
                    stringBuilder2.append("}");
                    arrayList.add(stringBuilder2.toString());
                } else {
                    a("illeagal neighboringCell! ", i, i2, ordinal, i4, i5);
                }
            }
        } catch (Exception e) {
        }
        StringBuilder stringBuilder3 = new StringBuilder("[");
        stringBuilder3.append(new ed(",").a(new StringBuilder(), arrayList.iterator()).toString());
        stringBuilder3.append("]");
        return stringBuilder3.toString();
    }

    private static void a(String str, int i, int i2, int i3, int i4, int i5) {
        boolean z = true;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getCellInfoWithJsonFormat: ");
        stringBuilder.append(str);
        StringBuilder append = stringBuilder.append("isGsm=");
        if (i3 != 1) {
            z = false;
        }
        append.append(z);
        stringBuilder.append(", mcc,mnc=").append(i).append(",").append(i2);
        stringBuilder.append(", lac,cid=").append(i4).append(",").append(i5);
    }

    public static String a(dr drVar) {
        if (drVar == null || Collections.unmodifiableList(drVar.b) == null) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (Collections.unmodifiableList(drVar.b) == null || Collections.unmodifiableList(drVar.b).size() <= 0) {
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
        List<ScanResult> unmodifiableList = Collections.unmodifiableList(drVar.b);
        int i = 0;
        for (ScanResult scanResult : unmodifiableList) {
            unmodifiableList.size();
            if (i > 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append("{\"mac\":\"").append(scanResult.BSSID.replace(":", "")).append("\",");
            stringBuilder.append("\"rssi\":").append(scanResult.level).append("}");
            i++;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static boolean a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (str.contains("latitude")) {
                return true;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("cells");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                return true;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("wifis");
            if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static double a(double d) {
        return (3.141592653589793d * d) / 180.0d;
    }

    public static double a(double d, double d2, double d3, double d4) {
        double a = a(d);
        double a2 = a(d3);
        double a3 = a(d2) - a(d4);
        return (((double) Math.round(((Math.asin(Math.sqrt(((Math.cos(a) * Math.cos(a2)) * Math.pow(Math.sin(a3 / 2.0d), 2.0d)) + Math.pow(Math.sin((a - a2) / 2.0d), 2.0d))) * 2.0d) * 6378.137d) * 10000.0d)) / 10000.0d) * 1000.0d;
    }
}
