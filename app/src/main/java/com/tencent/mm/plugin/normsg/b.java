package com.tencent.mm.plugin.normsg;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.util.Base64;
import android.view.View;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.d.y;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.normsg.utils.NativeLogic;
import com.tencent.mm.plugin.normsg.utils.c;
import com.tencent.mm.plugin.normsg.utils.d;
import com.tencent.mm.plugin.normsg.utils.e;
import com.tencent.mm.plugin.normsg.utils.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;
import org.xwalk.core.R$styleable;

enum b implements com.tencent.mm.plugin.normsg.a.b {
    ;
    
    private static final ag oSo = null;

    private b(String str) {
    }

    static {
        oSo = new ag("NormsgWorker");
    }

    public final String t(boolean z, boolean z2) {
        Context applicationContext = ac.getContext().getApplicationContext();
        String str = applicationContext.getApplicationInfo().sourceDir;
        WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
        String ssid = connectionInfo.getSSID();
        String bssid = connectionInfo.getBSSID();
        int versionCode = getVersionCode();
        int i = bfC() ? 1 : 0;
        int i2 = NativeLogic.bfI() ? 1 : 0;
        int i3 = Debug.isDebuggerConnected() ? 1 : 0;
        g.Dh();
        byte[] bO = NativeLogic.bO(str, a.Cg());
        g.Dh();
        byte[] h = NativeLogic.h(applicationContext, str, a.Cg());
        byte[] dk = NativeLogic.dk(applicationContext);
        String q = c.q(bO, 0, bO.length);
        String q2 = c.q(h, 0, h.length);
        String q3 = c.q(dk, 0, dk.length);
        int i4 = (e.oTF || e.oTG || e.oTH) ? 1 : 0;
        String charSequence = applicationContext.getPackageManager().getApplicationLabel(applicationContext.getApplicationInfo()).toString();
        String str2 = "";
        if (z) {
            Bundle aZ = com.tencent.mm.lib.riskscanner.a.a.aZ(applicationContext);
            if (aZ != null && aZ.getInt("errCode", -100) == 0) {
                dk = aZ.getByteArray("reqBufferBase64");
                if (dk != null) {
                    str2 = Base64.encodeToString(dk, 2);
                }
            }
        }
        String str3 = "";
        if (z2) {
            str3 = ar(applicationContext, ",");
        }
        Map yR = q.yR();
        long bfL = com.tencent.mm.plugin.normsg.utils.a.bfK().bfL();
        com.tencent.mm.plugin.normsg.utils.a.bfK().bfM();
        Object[][] objArr = new Object[49][];
        objArr[0] = new Object[]{"\u001d$\u001b>\"8\u001e2?\u0010.<6", Integer.valueOf(i)};
        objArr[1] = new Object[]{"\u001c!4\u00180 24", Integer.valueOf(i2)};
        objArr[2] = new Object[]{"\u001e'\u001104\u0013>019>.><", Integer.valueOf(i3)};
        objArr[3] = new Object[]{"\u000194\u001c4%?i", q};
        objArr[4] = new Object[]{"\u000194\u001c4%?j", q2};
        objArr[5] = new Object[]{"\u000194\u001c4%?k", q3};
        objArr[6] = new Object[]{"\u0013#'\u0006 %?7?", E(yR)};
        objArr[7] = new Object[]{"\u00011%?8\u0012\"\f>*", q.yM()};
        objArr[8] = new Object[]{"\u001e!\u000119\u00002*", q.yN()};
        objArr[9] = new Object[]{"\u0014\u0013\u001a\u0011", q.yE()};
        objArr[10] = new Object[]{"\u0011=6';>2\u0010\u001c", q.getAndroidId()};
        objArr[11] = new Object[]{"\u00029?93\u00061)384", q.yQ()};
        objArr[12] = new Object[]{"\u00038>82\u0019:>>4", q.yJ()};
        objArr[13] = new Object[]{"\u0016&\"\u0013> 6\u001f2+1,", Integer.valueOf(q.yS())};
        objArr[14] = new Object[]{"\u001f/+\u0011\u000f", G(yR)};
        objArr[15] = new Object[]{"\u001c,(\b>.", H(yR)};
        objArr[16] = new Object[]{"\u0013#'\u00061%?84", I(yR)};
        objArr[17] = new Object[]{"\r80=\u0017\u0018\u001b", q.yG()};
        objArr[18] = new Object[]{"\u0011!%\u001134 .(<+", F(yR)};
        objArr[19] = new Object[]{"\u000e\r\u0016\u001c", ssid};
        objArr[20] = new Object[]{"\f,\u00144=7", q.aJ(applicationContext)};
        objArr[21] = new Object[]{"\u001e\f\r\u0010\u001c", bssid};
        objArr[22] = new Object[]{"\u001f\r\u0012\u00124?7", bfD()};
        objArr[23] = new Object[]{"\u000e6;\u0015;4=", ac.getPackageName()};
        objArr[24] = new Object[]{"\u001c(57>\u001f\b", y.get("ro.build.fingerprint")};
        objArr[25] = new Object[]{"\u0011%8:3\u0016:;)<", Build.BOARD};
        objArr[26] = new Object[]{"\u0014 =?6\u0013?0*13:><*", Build.BOOTLOADER};
        objArr[27] = new Object[]{"\u0011%8:3\u0016';5<", Build.BRAND};
        objArr[28] = new Object[]{"\u0010$9;2\u00111-3:=", Build.DEVICE};
        objArr[29] = new Object[]{"\u001c(57>\u0011\u000f", Build.HARDWARE};
        objArr[30] = new Object[]{"\u0017#><5\u0002!39+<,", Build.PRODUCT};
        objArr[31] = new Object[]{"\u0019 \u000309\"\u00137.", Integer.valueOf(i4)};
        objArr[32] = new Object[]{"\u001879%730((,:*", y.get("ro.product.manufacturer")};
        objArr[33] = new Object[]{"\u0001:<:0\u0018\"5", bfE()};
        objArr[34] = new Object[]{"\u00108(\u000f#)=", bfF()};
        objArr[35] = new Object[]{"\u00153'5\u000798,", com.tencent.mm.compatible.util.e.gZJ};
        Object[] objArr2 = new Object[2];
        objArr2[0] = "\u00182!\u0011!'\u00062?";
        objArr2[1] = Integer.valueOf(d.oTz ? 1 : 0);
        objArr[36] = objArr2;
        objArr2 = new Object[2];
        objArr2[0] = "\u001c6%\u000098'\u000e4>:6/";
        objArr2[1] = Integer.valueOf(f.oTI ? 1 : 0);
        objArr[37] = objArr2;
        objArr[38] = new Object[]{"\u00044\"$?::\u00185==", Integer.valueOf(versionCode)};
        objArr[39] = new Object[]{"\u000b#89+'+\"\u0005)%01\r/>:8.\u0015;4=", ac.getContext().getClassLoader().getClass().getName()};
        objArr[40] = new Object[]{"\u001f-,\u0015;4=", charSequence};
        objArr[41] = new Object[]{"\u0005\u0006\u001a?#,\u0002.!''!\u0002.*<+", hc(false)};
        objArr[42] = new Object[]{"\u001a\"9&\u001f,//\u0012&3\u00071! <*", str2};
        objArr[43] = new Object[]{"\u001b3*\u00193-+", Long.valueOf(NativeLogic.bgg())};
        objArr[44] = new Object[]{"\u0002*$ /%%\u000f,/(98!+?;=!+\u00005#(6?8\u0013?+", NativeLogic.GJ(",")};
        objArr[45] = new Object[]{"\u0005!==)'&  \u0017'\"+\"%8\u0015186+", str3};
        objArr[46] = new Object[]{"\u000f./.9:!%/)-7;\u0002,6=6\u001f4/7,", Long.valueOf(bfL)};
        objArr[47] = new Object[]{"\u0015\u0007\u001d\u001d526428\u0013\u001dm", bfG()};
        objArr[48] = new Object[]{"\u0017;?4>'\u00048.,766", com.tencent.mm.sdk.platformtools.e.CLIENT_VERSION};
        return a(objArr);
    }

    public final void T(int i, int i2, int i3) {
        Context context = ac.getContext();
        if (i2 <= 0 || i2 > 4) {
            throw new IllegalArgumentException("action invalid: " + i2);
        }
        com.tencent.c.e.a.d.a aVar = new com.tencent.c.e.a.d.a(context, i, i2, (byte) 0);
        long j = (long) (i3 * 1000);
        if (j < com.tencent.c.e.a.a.f.zTY) {
            aVar.zTD = com.tencent.c.e.a.a.f.zTY;
        } else if (j > com.tencent.c.e.a.a.f.zTV * 12) {
            aVar.zTD = com.tencent.c.e.a.a.f.zTV * 12;
        }
        aVar.zTD = j;
        com.tencent.c.e.a.e.cDy().a(new com.tencent.c.e.a.d(aVar, (byte) 0));
    }

    public final String a(Object[][] objArr) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<st>");
        for (Object[] objArr2 : objArr) {
            String GH = GH(GG((String) objArr2[0]));
            stringBuilder.append('<').append(GH).append('>').append(GH(String.valueOf(objArr2[1]))).append('<').append('/').append(GH).append('>');
        }
        stringBuilder.append("</st>");
        CRC32 crc32 = new CRC32();
        crc32.update(stringBuilder.toString().getBytes());
        stringBuilder.append("<ccdcc>").append(crc32.getValue()).append("</ccdcc>");
        stringBuilder.append("<ccdts>").append(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())).append("</ccdts>");
        return stringBuilder.toString();
    }

    public final String GG(String str) {
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            stringBuilder.append((char) ((str.charAt(i) ^ -89) ^ ((byte) (((i + 1) ^ length) ^ -1))));
        }
        return stringBuilder.toString();
    }

    private static String GH(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\"':
                    stringBuilder.append("&quot;");
                    break;
                case '&':
                    stringBuilder.append("&amp;");
                    break;
                case '\'':
                    stringBuilder.append("&apos;");
                    break;
                case R$styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                    stringBuilder.append("&#").append(charAt).append(';');
                    break;
                case '<':
                    stringBuilder.append("&lt;");
                    break;
                case '>':
                    stringBuilder.append("&gt;");
                    break;
                default:
                    if (charAt <= '~') {
                        stringBuilder.append(charAt);
                        break;
                    }
                    stringBuilder.append("&#").append(charAt).append(';');
                    break;
            }
        }
        return stringBuilder.toString();
    }

    public final String tX(int i) {
        String str;
        String str2;
        String str3 = "";
        if (g.Dh().Cy()) {
            str = (String) g.Dj().CU().get(79, "");
        } else {
            str = str3;
        }
        g.Dm().g(new 1(this), 5000);
        str3 = "";
        if (g.Dh().Cy()) {
            str2 = g.Dj().gQj.xBn.xAM ? "1" : "0";
        } else {
            str2 = str3;
        }
        Context applicationContext = ac.getContext().getApplicationContext();
        WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
        String ssid = connectionInfo.getSSID();
        String bssid = connectionInfo.getBSSID();
        int i2 = bfC() ? 1 : 0;
        int i3 = NativeLogic.bfI() ? 1 : 0;
        int i4 = Debug.isDebuggerConnected() ? 1 : 0;
        int i5 = (e.oTF || e.oTG || e.oTH) ? 1 : 0;
        int i6 = d.oTz ? 1 : 0;
        int i7 = f.oTI ? 1 : 0;
        byte[] dk = NativeLogic.dk(applicationContext);
        String q = dk != null ? c.q(dk, 0, dk.length) : "";
        int versionCode = getVersionCode();
        String cY = cY(versionCode, i);
        Map yR = q.yR();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<softtype><lctmoc>").append(i2).append("</lctmoc><level>").append(i3).append("</level>").append(str).append("<k1>").append(E(yR)).append("</k1><k2>").append(q.yM()).append("</k2><k3>").append(q.yN()).append("</k3><k4>").append(q.yE()).append("</k4><k5>").append(q.yO()).append("</k5><k6>").append(q.yP()).append("</k6><k7>").append(q.getAndroidId()).append("</k7><k8>").append(q.yQ()).append("</k8><k9>").append(q.yJ()).append("</k9><k10>").append(q.yS()).append("</k10><k11>").append(bh.ou(G(yR))).append("</k11><k12>").append(bh.ou(H(yR))).append("</k12><k13>").append(bh.ou(I(yR))).append("</k13><k14>").append(q.yG()).append("</k14><k15>").append(q.yL()).append("</k15><k16>").append(bh.ou(F(yR))).append("</k16><k18>").append(q).append("</k18><k21>").append(bh.ou(ssid)).append("</k21><k22>").append(bh.ou(q.aJ(applicationContext))).append("</k22><k24>").append(bh.ou(bssid)).append("</k24><k26>").append(i4).append("</k26><k30>").append(bh.ou(bfD())).append("</k30><k33>").append(ac.getPackageName()).append("</k33><k34>").append(bh.ou(y.get("ro.build.fingerprint"))).append("</k34><k35>").append(bh.ou(Build.BOARD)).append("</k35><k36>").append(bh.ou(Build.BOOTLOADER)).append("</k36><k37>").append(bh.ou(Build.BRAND)).append("</k37><k38>").append(bh.ou(Build.DEVICE)).append("</k38><k39>").append(bh.ou(Build.HARDWARE)).append("</k39><k40>").append(bh.ou(Build.PRODUCT)).append("</k40><k41>").append(i5).append("</k41><k42>").append(bh.ou(y.get("ro.product.manufacturer"))).append("</k42><k43>").append(System.getString(ac.getContext().getContentResolver(), "89884a87498ef44f")).append("</k43><k44>0").append("</k44><k45>").append(bfE()).append("</k45><k46>").append(str2).append("</k46><k47>").append(bfF()).append("</k47><k48>").append(q.yE()).append("</k48><k49>").append(com.tencent.mm.compatible.util.e.gZJ).append("</k49><k52>").append(i6).append("</k52><k53>").append(i7).append("</k53><k57>").append(versionCode).append("</k57><k58>").append(bh.ou(cY)).append("</k58><k59>").append(i).append("</k59></softtype>");
        return stringBuilder.toString();
    }

    private static boolean bfC() {
        Context context = ac.getContext();
        if (context == null) {
            x.w("MicroMsg.NormsgSourceImpl", "Failed checking mock location: application context not initialized.");
            return false;
        } else if (Secure.getInt(context.getContentResolver(), "mock_location", 0) != 0) {
            return true;
        } else {
            return false;
        }
    }

    private static String E(Map<String, String> map) {
        String str = (String) map.get("model name");
        if (str == null) {
            return q.yK()[0];
        }
        return str;
    }

    private static String F(Map<String, String> map) {
        String str = (String) map.get("features");
        if (str == null) {
            return (String) map.get("flags");
        }
        return str;
    }

    private static String G(Map<String, String> map) {
        return (String) map.get("hardware");
    }

    private static String H(Map<String, String> map) {
        return (String) map.get("revision");
    }

    private static String I(Map<String, String> map) {
        return (String) map.get("serial");
    }

    private static String bfD() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) ac.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.getExtraInfo();
        }
        return null;
    }

    private static String bfE() {
        String ou = bh.ou(bh.eZ(ac.getContext()));
        if (ou.length() > 0) {
            return com.tencent.mm.a.g.s(ou.getBytes());
        }
        return ou;
    }

    private static String cY(int i, int i2) {
        PackageInfo packageInfo;
        String str = "";
        try {
            packageInfo = ac.getContext().getPackageManager().getPackageInfo(ac.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
            x.w("MicroMsg.NormsgSourceImpl", "app not installed, packageName = " + ac.getPackageName());
        }
        if (packageInfo == null) {
            return str;
        }
        com.tencent.mm.plugin.report.d dVar;
        Object[] objArr;
        try {
            str = com.tencent.mm.c.c.k(new File(packageInfo.applicationInfo.sourceDir));
            if (!bh.ov(str)) {
                return str;
            }
            com.tencent.mm.plugin.report.d.pPH.a(322, 13, 1, true);
            dVar = com.tencent.mm.plugin.report.d.pPH;
            objArr = new Object[2];
            objArr[0] = Integer.valueOf(4013);
            objArr[1] = String.format("%s|%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            dVar.h(11098, objArr);
            return str;
        } catch (Exception e2) {
            x.w("MicroMsg.NormsgSourceImpl", "summertoken getSecurityCode e: " + e2.getMessage());
            str = "0";
            com.tencent.mm.plugin.report.d.pPH.a(322, 12, 1, true);
            dVar = com.tencent.mm.plugin.report.d.pPH;
            objArr = new Object[2];
            objArr[0] = Integer.valueOf(4012);
            objArr[1] = String.format("%s|%s|%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), r9.getMessage()});
            dVar.h(11098, objArr);
            return str;
        }
    }

    private static int getVersionCode() {
        PackageInfo packageInfo;
        try {
            packageInfo = ac.getContext().getPackageManager().getPackageInfo(ac.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
            x.w("MicroMsg.NormsgSourceImpl", "app not installed, packageName = " + ac.getPackageName());
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    private static String bfF() {
        String str = "";
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) ac.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() == 1) {
                return "wifi";
            }
            return activeNetworkInfo.getSubtype();
        } catch (Throwable e) {
            x.e("MicroMsg.NormsgSourceImpl", "getNetTypeStr: %s", new Object[]{bh.i(e)});
            return str;
        }
    }

    private static String bfG() {
        Throwable th;
        Closeable bufferedInputStream;
        String s;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(ac.getContext().getPackageCodePath()));
            try {
                byte[] bArr = new byte[102400];
                int i = 0;
                do {
                    int read = bufferedInputStream.read(bArr, i, 102400 - i);
                    if (read < 0) {
                        break;
                    }
                    i += read;
                } while (i < 102400);
                s = com.tencent.mm.a.g.s(bArr);
                bh.d(bufferedInputStream);
                return s;
            } catch (Throwable th2) {
                th = th2;
                bh.d(bufferedInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            bufferedInputStream = null;
            th = th4;
            bh.d(bufferedInputStream);
            throw th;
        }
    }

    public final String hc(boolean z) {
        Object treeSet = new TreeSet();
        NativeLogic.a(ac.getContext(), treeSet, z);
        StringBuilder stringBuilder = new StringBuilder(8192);
        Iterator it = treeSet.iterator();
        treeSet = 1;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (treeSet != null) {
                treeSet = null;
            } else {
                stringBuilder.append(',');
            }
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public final String bfH() {
        List<PackageInfo> installedPackages = ac.getContext().getPackageManager().getInstalledPackages(0);
        StringBuilder stringBuilder = new StringBuilder(8192);
        for (PackageInfo packageInfo : installedPackages) {
            stringBuilder.append(packageInfo.packageName).append('\n');
        }
        return stringBuilder.toString();
    }

    private String ar(Context context, String str) {
        Context context2 = context;
        while (context2 != null) {
            try {
                if (!(context2 instanceof ContextWrapper)) {
                    break;
                }
                context2 = ((ContextWrapper) context2).getBaseContext();
            } catch (Throwable th) {
                x.printErrStackTrace("MicroMsg.NormsgSourceImpl", th, "unexpected exception.", new Object[0]);
                return "";
            }
        }
        Method declaredMethod = Class.forName(GG("\u001c\u0013\u0010T\u001a\u0016\u001d\u0004\u0018\u001d\u0011\\\u001a\u001e\u0005\u000b\u001d\u0002\f\u0006E\u0007\u001aH%\r\u000b\u0006\u0006\u0012(0+9/4:4")).getDeclaredMethod(GG("./?\u000f\" ;%96\f&/#$,"), new Class[0]);
        declaredMethod.setAccessible(true);
        Object invoke = declaredMethod.invoke(null, new Object[0]);
        Class cls = Class.forName(GG("'+ 1-($a!>b\u0018/;>>50\u00192<07:,\u0013=/3/="));
        Class cls2 = Class.forName(GG("*&-< %)l,3o\u000f\u0005-+>>*"));
        Method declaredMethod2 = cls.getDeclaredMethod(GG("3\"\u00199\"0&=;:="), new Class[]{cls2});
        declaredMethod2.setAccessible(true);
        invoke = declaredMethod2.invoke(null, new Object[]{invoke});
        cls = Class.forName(GG("#+=-c\"..&l\u001007/)?"));
        declaredMethod2 = invoke.getClass().getDeclaredMethod(GG("45%\u00052&#38="), new Class[]{cls});
        declaredMethod2.setAccessible(true);
        invoke = declaredMethod2.invoke(invoke, new Object[]{GG(".<?0;>=")});
        declaredMethod2 = Class.forName(GG("\u001f\u0013\u0018\t\u0015\u0010\u001cY\u0015\u001a\u001a\u0007\u0017\u001f\u0004A\u001e\u0000B\":\b\u000b\f\u0007\u0002\u0001.\u0003\u000f\u00018;/x\b.,:")).getDeclaredMethod(GG("3\"\u00199\"0&=;:="), new Class[]{cls2});
        declaredMethod2.setAccessible(true);
        invoke = declaredMethod2.invoke(null, new Object[]{invoke});
        cls = Class.forName(GG("\u001d\u0011\u001a\u000b\u0017\u0012\u001e[\u0015\u0007\u0006_1\u0003\u0002\u0001\u0005\f\u000f\u001d\u0001\u0004\u00045\u0005\u0004\r\u0000\u0007\u0006/<2>9<*"));
        cls2 = Class.forName(GG("/#(9% ,i'54m\u0001..+;%(\u00127)4"));
        Class cls3 = Class.forName(GG("\u001a\u0016\u001d\f\u0010\u0015\u0019\\\u0010\u001f\u001f\u0002\u0012\u001a\u0001D\u001b\u0005G'?\r\u000e\t\u0002\u0007\u0004+\u0006\n\u0004=>*"));
        Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[]{cls2, cls3});
        declaredConstructor.setAccessible(true);
        invoke = declaredConstructor.newInstance(new Object[]{context2, invoke});
        Method declaredMethod3 = cls.getDeclaredMethod(GG("*+;\u0001'9?%)*\"$\u0011# 7<9:+"), new Class[]{Integer.TYPE});
        declaredMethod3.setAccessible(true);
        List list = (List) declaredMethod3.invoke(invoke, new Object[]{Integer.valueOf(0)});
        if (list == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 1;
        for (Object next : list) {
            int i2;
            if (i != 0) {
                i2 = 0;
            } else {
                stringBuilder.append(str);
                i2 = i;
            }
            String str2 = (String) next.getClass().getDeclaredField(GG("\"03<721\u0015;4=")).get(next);
            Object next2 = next2.getClass().getDeclaredField(GG("7%$?;21+722\u00124?7")).get(next2);
            Class cls4 = Class.forName(GG("\u001a\u0016\u001d\f\u0010\u0015\u0019\\\u0010\u001f\u001f\u0002\u0012\u001a\u0001D\u001b\u0005G>\u000e\u000f\u0006\u0003\u0004\u0005(\u0012\u0002\t,4=7"));
            Class cls5 = Class.forName(GG("\u0019\u0015\u001e\u000f\u0013\u0016\u001a_\u0013\u001c\u001c\u0001\u0011\u0019\u0002G\u0018\u0006D=\r\f\u0005\u0000\u0007\u0006/\u0004\n\u0006\u0001<*"));
            Method declaredMethod4 = cls4.getDeclaredMethod(GG("<<31\u001864<4"), new Class[]{cls5});
            declaredMethod4.setAccessible(true);
            stringBuilder.append(str2).append('#').append(declaredMethod4.invoke(next2, new Object[]{invoke}).toString());
            i = i2;
        }
        return stringBuilder.toString();
    }

    public final boolean bfI() {
        return NativeLogic.bfI();
    }

    public final boolean b(Object obj, Class cls) {
        return NativeLogic.b(obj, cls);
    }

    public final byte[] bfJ() {
        try {
            Context applicationContext = ac.getContext().getApplicationContext();
            String str = applicationContext.getApplicationInfo().sourceDir;
            WifiInfo connectionInfo = ((WifiManager) applicationContext.getSystemService("wifi")).getConnectionInfo();
            String ssid = connectionInfo.getSSID();
            String bssid = connectionInfo.getBSSID();
            int versionCode = getVersionCode();
            int i = bfC() ? 1 : 0;
            int i2 = NativeLogic.bfI() ? 1 : 0;
            int i3 = Debug.isDebuggerConnected() ? 1 : 0;
            g.Dh();
            byte[] bO = NativeLogic.bO(str, a.Cg());
            g.Dh();
            byte[] h = NativeLogic.h(applicationContext, str, a.Cg());
            byte[] dk = NativeLogic.dk(applicationContext);
            String q = c.q(bO, 0, bO.length);
            str = c.q(h, 0, h.length);
            String q2 = c.q(dk, 0, dk.length);
            int i4 = (e.oTF || e.oTG || e.oTH) ? 1 : 0;
            String charSequence = applicationContext.getPackageManager().getApplicationLabel(applicationContext.getApplicationInfo()).toString();
            Map yR = q.yR();
            long bfL = com.tencent.mm.plugin.normsg.utils.a.bfK().bfL();
            com.tencent.mm.plugin.normsg.utils.a.bfK().bfM();
            r15 = new Object[47][];
            r15[0] = new Object[]{"\u001d$\u001b>\"8\u001e2?\u0010.<6", Integer.valueOf(i)};
            r15[1] = new Object[]{"\u001c!4\u00180 24", Integer.valueOf(i2)};
            r15[2] = new Object[]{"\u001e'\u001104\u0013>019>.><", Integer.valueOf(i3)};
            r15[3] = new Object[]{"\u000194\u001c4%?i", q};
            r15[4] = new Object[]{"\u000194\u001c4%?j", str};
            r15[5] = new Object[]{"\u000194\u001c4%?k", q2};
            r15[6] = new Object[]{"\u0013#'\u0006 %?7?", E(yR)};
            r15[7] = new Object[]{"\u00011%?8\u0012\"\f>*", q.yM()};
            r15[8] = new Object[]{"\u001e!\u000119\u00002*", q.yN()};
            r15[9] = new Object[]{"\u0014\u0013\u001a\u0011", q.yE()};
            r15[10] = new Object[]{"\u0011=6';>2\u0010\u001c", q.getAndroidId()};
            r15[11] = new Object[]{"\u00029?93\u00061)384", q.yQ()};
            r15[12] = new Object[]{"\u00038>82\u0019:>>4", q.yJ()};
            r15[13] = new Object[]{"\u0016&\"\u0013> 6\u001f2+1,", Integer.valueOf(q.yS())};
            r15[14] = new Object[]{"\u001f/+\u0011\u000f", G(yR)};
            r15[15] = new Object[]{"\u001c,(\b>.", H(yR)};
            r15[16] = new Object[]{"\u0013#'\u00061%?84", I(yR)};
            r15[17] = new Object[]{"\r80=\u0017\u0018\u001b", q.yG()};
            r15[18] = new Object[]{"\u0011!%\u001134 .(<+", F(yR)};
            r15[19] = new Object[]{"\u000e\r\u0016\u001c", ssid};
            r15[20] = new Object[]{"\f,\u00144=7", q.aJ(applicationContext)};
            r15[21] = new Object[]{"\u001e\f\r\u0010\u001c", bssid};
            r15[22] = new Object[]{"\u001f\r\u0012\u00124?7", bfD()};
            r15[23] = new Object[]{"\u000e6;\u0015;4=", ac.getPackageName()};
            r15[24] = new Object[]{"\u001c(57>\u001f\b", y.get("ro.build.fingerprint")};
            r15[25] = new Object[]{"\u0011%8:3\u0016:;)<", Build.BOARD};
            r15[26] = new Object[]{"\u0014 =?6\u0013?0*13:><*", Build.BOOTLOADER};
            r15[27] = new Object[]{"\u0011%8:3\u0016';5<", Build.BRAND};
            r15[28] = new Object[]{"\u0010$9;2\u00111-3:=", Build.DEVICE};
            r15[29] = new Object[]{"\u001c(57>\u0011\u000f", Build.HARDWARE};
            r15[30] = new Object[]{"\u0017#><5\u0002!39+<,", Build.PRODUCT};
            r15[31] = new Object[]{"\u0019 \u000309\"\u00137.", Integer.valueOf(i4)};
            r15[32] = new Object[]{"\u001879%730((,:*", y.get("ro.product.manufacturer")};
            r15[33] = new Object[]{"\u0001:<:0\u0018\"5", bfE()};
            r15[34] = new Object[]{"\u00108(\u000f#)=", bfF()};
            r15[35] = new Object[]{"\u00153'5\u000798,", com.tencent.mm.compatible.util.e.gZJ};
            Object[] objArr = new Object[2];
            objArr[0] = "\u00182!\u0011!'\u00062?";
            objArr[1] = Integer.valueOf(d.oTz ? 1 : 0);
            r15[36] = objArr;
            objArr = new Object[2];
            objArr[0] = "\u001c6%\u000098'\u000e4>:6/";
            objArr[1] = Integer.valueOf(f.oTI ? 1 : 0);
            r15[37] = objArr;
            r15[38] = new Object[]{"\u00044\"$?::\u00185==", Integer.valueOf(versionCode)};
            r15[39] = new Object[]{"\u000b#89+'+\"\u0005)%01\r/>:8.\u0015;4=", ac.getContext().getClassLoader().getClass().getName()};
            r15[40] = new Object[]{"\u001f-,\u0015;4=", charSequence};
            r15[41] = new Object[]{"\u0005\u0006\u001a?#,\u0002.!''!\u0002.*<+", hc(true)};
            r15[42] = new Object[]{"\u001b3*\u00193-+", Long.valueOf(NativeLogic.bgg())};
            r15[43] = new Object[]{"\u0002*$ /%%\u000f,/(98!+?;=!+\u00005#(6?8\u0013?+", NativeLogic.GJ(",")};
            r15[44] = new Object[]{"\u000f./.9:!%/)-7;\u0002,6=6\u001f4/7,", Long.valueOf(bfL)};
            r15[45] = new Object[]{"\u0015\u0007\u001d\u001d526428\u0013\u001dm", bfG()};
            r15[46] = new Object[]{"\u0017;?4>'\u00048.,766", com.tencent.mm.sdk.platformtools.e.CLIENT_VERSION};
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<st>");
            for (i3 = 0; i3 < 47; i3++) {
                Object[] objArr2 = r15[i3];
                String GH = GH(GG((String) objArr2[0]));
                stringBuilder.append('<').append(GH).append('>').append(GH(String.valueOf(objArr2[1]))).append('<').append('/').append(GH).append('>');
            }
            stringBuilder.append("</st>");
            return stringBuilder.toString().getBytes();
        } catch (Throwable th) {
            Writer stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            printWriter.flush();
            com.tencent.mm.plugin.report.service.g.pQN.c("BriefSecInfoCrash", stringWriter.toString(), null);
            printWriter.close();
            return new byte[0];
        }
    }

    public final boolean bA(Object obj) {
        return NativeLogic.bA(obj);
    }

    public final void a(View view, Class<? extends com.tencent.mm.sdk.b.b> cls) {
        NativeLogic.c(view, cls);
    }

    public final void tY(int i) {
        com.tencent.mm.plugin.normsg.utils.a.bfK().tY(i);
    }
}
