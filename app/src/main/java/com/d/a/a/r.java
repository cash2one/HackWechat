package com.d.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.d.a.a.d.a;
import java.text.DecimalFormat;
import org.json.JSONObject;
import org.xwalk.core.R$styleable;

final class r extends d {
    private static final DecimalFormat bjA = new DecimalFormat("0000000000000000");
    private static r bjB;
    private static final DecimalFormat bjz = new DecimalFormat("0000000000");
    private String bjC;
    private String bjD;
    private final b bjE = new b((byte) 0);
    private int bjF;
    z bjG;
    private SharedPreferences bjH;
    private f bjI;
    private final Object bjJ = new Object();
    private final d bjK = new d(this, (byte) 0);
    q bjL;
    String bjM;
    private int mRetryCount;

    private static class e extends a {
        private final String bjQ;
        private final long bjR;
        private final long bjU;
        private final boolean bjV;
        private final int bjg;

        private e(r rVar, String str, long j, long j2, int i, boolean z) {
            super(rVar, (byte) 0);
            this.bjQ = str;
            this.bjR = j;
            this.bjU = j2;
            this.bjg = i;
            this.bjV = z;
        }

        public final void run() {
            try {
                r.a(sj(), this.bjQ, this.bjR, this.bjU, this.bjg, this.bjV);
            } catch (Exception e) {
            }
        }
    }

    private r() {
    }

    static r sc() {
        if (bjB == null) {
            bjB = new r();
        }
        return bjB;
    }

    final void U(Context context) {
        try {
            String str = this.bjM;
            if (TextUtils.isEmpty(str)) {
                str = "0000000000";
            }
            this.bjC = bt(str);
            this.bjD = a(Long.valueOf(System.currentTimeMillis() / 1000));
            this.bjI = new f(context);
        } catch (Exception e) {
        }
        this.bjH = context.getSharedPreferences("0-474-85242", 0);
    }

    final void a(Context context, Handler handler, a aVar) {
        this.bjG = z.a(handler);
        sd();
    }

    final void V(Context context) {
    }

    final void rR() {
        this.bjL = null;
    }

    final void sd() {
        if (this.bjG != null) {
            try {
                this.bjG.execute(d.a(this.bjK));
            } catch (Exception e) {
            }
        }
    }

    final void br(String str) {
        if (this.bjG != null) {
            this.bjG.execute(new c(this, str, 0, 1, (byte) 0));
        }
    }

    final boolean se() {
        return this.bjE.code == 1;
    }

    static /* synthetic */ void a(r rVar) {
        try {
            rVar.si();
            if (rVar.se()) {
                rVar.bjF = 0;
            }
        } catch (Exception e) {
        }
    }

    static /* synthetic */ void a(r rVar, String str, long j, long j2, int i, boolean z) {
        if (rVar.bgH) {
            synchronized (rVar.bjJ) {
                String sf = rVar.sf();
                String stringBuilder = str != null ? new StringBuilder(String.valueOf(str)).append(sf).toString() : sf;
                if (stringBuilder.length() > 0) {
                    try {
                        long af = aa.af(j);
                        int i2 = rVar.bjF + 1;
                        rVar.bjF = i2;
                        String str2 = y.bmF;
                        String str3 = y.bmK;
                        boolean z2 = y.bmM;
                        int i3 = y.bmG;
                        int i4 = y.bmH;
                        if (str2 == null || str3 == null) {
                            throw new Exception("StringBuilding: null mode or user name");
                        }
                        sf = new StringBuilder(String.valueOf("ST=" + String.valueOf(af) + ',' + i2 + ',' + str2 + ',' + str3 + ',' + (z2 ? '1' : '0') + ',' + i3 + ',' + i4 + ',' + i)).append(stringBuilder).toString();
                        if (y.bmL) {
                            o.o("data_transaction_log_" + y.bmS, sf);
                        }
                        Object encode = Base64.encode(g.q(sf.getBytes("UTF-8")), 0);
                        Object obj = new byte[(rVar.bjE.bjO.length + encode.length)];
                        System.arraycopy(rVar.bjE.bjO, 0, obj, 0, rVar.bjE.bjO.length);
                        System.arraycopy(encode, 0, obj, rVar.bjE.bjO.length, encode.length);
                        rVar.bjI.imei = rVar.bjM;
                        stringBuilder = new String(rVar.bjL.r(rVar.bjI.p(obj).getBytes("UTF-8")));
                        if (y.bmL) {
                            o.o("data_transaction_log_" + y.bmS, stringBuilder);
                        }
                        p d = d(stringBuilder, j, j2);
                        if (d.bjY) {
                            rVar.sg();
                            rVar.mRetryCount = 0;
                        } else {
                            rVar.mRetryCount++;
                            int length = rVar.sh().getString("1-115-10127", "").length();
                            if (rVar.mRetryCount > 20 || (length > 10240 && rVar.mRetryCount > 3)) {
                                rVar.sg();
                            }
                        }
                        if (d.bjW == 4) {
                            rVar.bjE.code = -1;
                        }
                        rVar.c(d);
                        if (d.bjY) {
                            return;
                        }
                    } catch (Exception e) {
                        rVar.c(new f(0, null, "connection failure", (byte) 0));
                        if (z) {
                            rVar.g(str, aa.af(j));
                        }
                    }
                }
            }
        }
        if (z) {
            rVar.g(str, aa.af(j));
        }
    }

    private static f d(String str, long j, long j2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("errorcode", -5);
            if (optInt != 0) {
                return new f(optInt, null, null, (byte) 0);
            }
            long optLong = jSONObject.optLong("hitarea", 0);
            String str2 = new String(Base64.decode(jSONObject.optString("swdata", null), 0), "UTF-8");
            if (y.bmL) {
                o.o("data_transaction_log_" + y.bmS, str2);
            }
            if (str2.length() <= h.bhh || !str2.startsWith("$UP,")) {
                throw new Exception("OnlineModule: parse data upload reply and generate msg: invalid arg");
            }
            switch (str2.charAt(h.bhh)) {
                case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                    return new f(0, null, str2.length() > h.bhi ? str2.substring(h.bhi) : null, (byte) 0);
                case R$styleable.AppCompatTheme_actionButtonStyle /*49*/:
                    if (str2.length() > h.bhi) {
                        x f = f(str2.substring(h.bhi), optLong);
                        f.bmy = j;
                        f.bjU = j2;
                        return new f(1, f, null, (byte) 0);
                    }
                    break;
                case '2':
                    return new f(2, null, str2.length() > h.bhi ? str2.substring(h.bhi) : null, (byte) 0);
                case '3':
                    return new f(3, null, str2.length() > h.bhi ? str2.substring(h.bhi) : null, (byte) 0);
                case '4':
                    return new f(4, null, str2.length() > h.bhi ? str2.substring(h.bhi) : null, (byte) 0);
                case '5':
                    return new f(5, null, str2.length() > h.bhi ? str2.substring(h.bhi) : null, (byte) 0);
                case '6':
                    return new f(6, null, str2.length() > h.bhi ? str2.substring(h.bhi) : null, (byte) 0);
            }
            throw new Exception("OnlineModule: unable to parse data upload reply");
        } catch (Exception e) {
            if (y.bmL) {
                o.o("data_transaction_log_" + y.bmS, "parse json data error");
            }
            throw new Exception("parse json data error");
        }
    }

    private static x f(String str, long j) {
        int i = 0;
        if (str != null) {
            String[] split = str.split(",", -1);
            if (split.length == 10) {
                try {
                    int parseInt;
                    int parseInt2;
                    int parseInt3;
                    double parseDouble = Double.parseDouble(split[0]);
                    double parseDouble2 = Double.parseDouble(split[1]);
                    float parseFloat = Float.parseFloat(split[8]);
                    try {
                        parseInt = Integer.parseInt(split[3]);
                    } catch (NumberFormatException e) {
                        parseInt = i;
                    }
                    try {
                        parseInt2 = Integer.parseInt(split[4]);
                    } catch (NumberFormatException e2) {
                        parseInt2 = i;
                    }
                    try {
                        parseInt3 = Integer.parseInt(split[5]);
                    } catch (NumberFormatException e3) {
                        parseInt3 = i;
                    }
                    try {
                        i = Integer.parseInt(split[7]);
                    } catch (NumberFormatException e4) {
                    }
                    float f = 0.0f;
                    try {
                        f = Float.parseFloat(split[9]);
                    } catch (NumberFormatException e5) {
                    }
                    x xVar = new x();
                    xVar.latitude = parseDouble;
                    xVar.longitude = parseDouble2;
                    xVar.bmv = split[2];
                    xVar.level = parseInt;
                    xVar.bmx = (long) parseInt2;
                    xVar.bmA = parseInt3;
                    xVar.bmw = split[6];
                    xVar.bmB = i;
                    xVar.biF = parseFloat;
                    if (xVar.bmz == null) {
                        xVar.bmz = new x.a();
                    }
                    xVar.bmz.bmC = f;
                    xVar.bjk = j;
                    return xVar;
                } catch (NumberFormatException e6) {
                }
            }
        }
        throw new Exception("OnlineModule: unable to get location from data upload reply");
    }

    private void g(String str, long j) {
        String str2 = null;
        String str3 = "1";
        if (!(str == null || str.startsWith("&OD[]="))) {
            String bw = v.bw(v.bx(str));
            bw = bw == null ? null : bw.replace("&MD=", "|MD,");
            if (bw != null) {
                str2 = bw.replace("&WD[]=", "|WD,");
            }
            str = v.a(str2, j, str3);
        }
        bs(str);
    }

    @SuppressLint({"NewApi"})
    private void bs(String str) {
        if (str != null) {
            synchronized (this.bjJ) {
                try {
                    String stringBuilder = new StringBuilder(String.valueOf(sh().getString("1-115-10127", ""))).append(str).toString();
                    int length = stringBuilder.length() - 307200;
                    if (length > 0) {
                        int indexOf = stringBuilder.indexOf("&OD[]=", length);
                        stringBuilder = indexOf >= length ? stringBuilder.substring(indexOf) : "";
                    }
                    if (VERSION.SDK_INT >= 9) {
                        sh().edit().putString("1-115-10127", stringBuilder).apply();
                    } else {
                        sh().edit().putString("1-115-10127", stringBuilder).commit();
                    }
                } catch (Exception e) {
                } catch (Error e2) {
                    try {
                        if (VERSION.SDK_INT >= 9) {
                            sh().edit().putString("1-115-10127", "").apply();
                        } else {
                            sh().edit().putString("1-115-10127", "").commit();
                        }
                    } catch (Exception e3) {
                    }
                }
            }
        }
    }

    private String sf() {
        try {
            return sh().getString("1-115-10127", "");
        } catch (Exception e) {
            return "";
        }
    }

    @SuppressLint({"NewApi"})
    private void sg() {
        try {
            if (VERSION.SDK_INT >= 9) {
                sh().edit().remove("1-115-10127").apply();
            } else {
                sh().edit().remove("1-115-10127").commit();
            }
        } catch (Exception e) {
        }
    }

    private SharedPreferences sh() {
        if (this.bjH != null) {
            return this.bjH;
        }
        throw new Exception("OnlineModule: data buffer unavailable");
    }

    private synchronized void si() {
        String str = this.bjC;
        String str2 = this.bjD;
        b bVar = this.bjE;
        if (str == null || str2 == null || bVar == null) {
            throw new Exception("OnlineModule: authenticate: null arg");
        }
        System.arraycopy(new StringBuilder(String.valueOf(str)).append(str2).toString().getBytes(), 0, bVar.bjO, 0, 27);
        bVar.code = 1;
    }

    private static String bt(String str) {
        try {
            return "T" + bjA.format(Long.parseLong(str) + System.currentTimeMillis());
        } catch (NumberFormatException e) {
            throw new Exception("OnlineModule: invalid device id, type: 0");
        }
    }

    private static String a(Long l) {
        if (l == null) {
            throw new Exception("OnlineModule: null source id");
        }
        try {
            return bjz.format(l);
        } catch (NumberFormatException e) {
            throw new Exception("OnlineModule: invalid source id");
        }
    }
}
