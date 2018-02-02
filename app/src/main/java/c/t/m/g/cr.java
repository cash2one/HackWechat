package c.t.m.g;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.map.geolocation.internal.TencentHttpClient;
import com.tencent.map.geolocation.internal.TencentHttpClientFactory;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.wcdb.FileUtils;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.eclipse.jdt.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class cr {
    private static volatile cr m;
    public final Context a;
    public final cs b;
    public final ExecutorService c;
    final PackageManager d;
    public final TelephonyManager e;
    public final WifiManager f;
    public final LocationManager g;
    public final TencentHttpClient h;
    String i;
    private final HashMap<String, cv> j;
    private CountDownLatch k;
    private final SharedPreferences l;
    private List<ei> n;

    public static cr a(Context context) {
        if (m == null) {
            synchronized (cr.class) {
                if (m == null) {
                    m = new cr(context);
                }
            }
        }
        return m;
    }

    private cr(Context context) {
        this.a = context;
        this.d = context.getPackageManager();
        this.e = (TelephonyManager) context.getSystemService("phone");
        this.f = (WifiManager) context.getSystemService("wifi");
        this.g = (LocationManager) context.getSystemService("location");
        Bundle bundle = new Bundle();
        bundle.putString(DownloadInfoColumns.CHANNELID, j.c(context.getPackageName()));
        this.h = TencentHttpClientFactory.getInstance().getTencentHttpClient(context, bundle);
        this.l = context.getSharedPreferences("LocationSDK", 0);
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(1, 5, 60000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new 1());
        if (VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        this.c = threadPoolExecutor;
        this.j = new HashMap();
        if (VERSION.SDK_INT >= 12) {
            this.j.put("cell", new cw("cell"));
        }
        this.b = new cs();
        try {
            this.b.g = b(context);
        } catch (Exception e) {
        }
        a();
    }

    public final void a() {
        this.k = new CountDownLatch(1);
        new Thread(new 2(this)).start();
    }

    public final boolean b() {
        return this.e != null;
    }

    public final cs c() {
        if (-1 > 0) {
            try {
                if (!this.k.await(-1, TimeUnit.MILLISECONDS)) {
                    return null;
                }
            } catch (InterruptedException e) {
                return null;
            }
        }
        this.k.await();
        return this.b;
    }

    public final cv a(String str) {
        cv cvVar = (cv) this.j.get(str);
        return cvVar != null ? cvVar : cu.a;
    }

    public final Bundle a(String str, byte[] bArr) {
        System.currentTimeMillis();
        Bundle postSync = this.h.postSync(str, bArr);
        System.currentTimeMillis();
        byte[] b = j.b(postSync.getByteArray("data_bytes"));
        String str2 = "{}";
        if (b != null) {
            str2 = new String(b, postSync.getString("data_charset"));
        }
        postSync.remove("data_charset");
        postSync.remove("data_bytes");
        postSync.putString("result", str2);
        return postSync;
    }

    public final String d() {
        if (!cl.a().d("up_apps")) {
            return null;
        }
        int abs;
        try {
            abs = Math.abs(this.i.hashCode()) % 5;
        } catch (Exception e) {
            abs = 0;
        }
        if (((int) ((System.currentTimeMillis() / 86400000) % 5)) != abs) {
            this.l.edit().putBoolean("flag", false).apply();
        } else if (!this.l.getBoolean("flag", false)) {
            try {
                List<PackageInfo> installedPackages = this.d.getInstalledPackages(8192);
                StringBuilder stringBuilder = new StringBuilder();
                for (PackageInfo packageInfo : installedPackages) {
                    int i = packageInfo.applicationInfo.flags;
                    ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                    if ((i & 1) <= 0) {
                        boolean z;
                        String charSequence = packageInfo.applicationInfo.loadLabel(this.d).toString();
                        if (charSequence.length() > 30 || charSequence.startsWith("com.") || charSequence.contains("theme") || charSequence.contains("CheilPengtai")) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            stringBuilder.append(charSequence);
                            stringBuilder.append('_');
                            stringBuilder.append(packageInfo.versionName);
                            stringBuilder.append('|');
                        }
                    }
                }
                this.l.edit().putBoolean("flag", true).apply();
                return b(stringBuilder.toString());
            } catch (Exception e2) {
                this.l.edit().putBoolean("flag", true).apply();
            }
        }
        return null;
    }

    public final synchronized void a(Object obj) {
        Object obj2;
        if (this.n == null) {
            this.n = new ArrayList();
        }
        for (ei eiVar : this.n) {
            if (obj == eiVar.c) {
                obj2 = 1;
                break;
            }
        }
        obj2 = null;
        if (obj2 == null) {
            for (Method method : obj.getClass().getDeclaredMethods()) {
                String name = method.getName();
                if (name.startsWith("on") && name.endsWith("Event")) {
                    Class[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length != 1) {
                        throw new IllegalArgumentException("EventHandler methods must specify a single Object paramter.");
                    }
                    this.n.add(new ei(parameterTypes[0], method, obj));
                }
            }
        }
    }

    public final synchronized void b(Object obj) {
        List<ei> list = this.n;
        if (list != null) {
            List<ei> arrayList = new ArrayList();
            for (ei eiVar : list) {
                Object obj2 = eiVar.c;
                if (obj2 == null || obj2 == obj) {
                    arrayList.add(eiVar);
                }
            }
            for (ei eiVar2 : arrayList) {
                list.remove(eiVar2);
            }
        }
    }

    public final synchronized void c(@Nullable Object obj) {
        if (obj != null) {
            List<ei> list = this.n;
            if (list != null) {
                for (ei eiVar : list) {
                    if (obj.getClass().equals(eiVar.a)) {
                        try {
                            eiVar.b.invoke(eiVar.c, new Object[]{obj});
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }
    }

    private static String b(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), FileUtils.S_IWUSR).metaData;
            if (bundle != null) {
                if (bundle.containsKey("TencentGeoLocationSDK")) {
                    return bundle.getString("TencentGeoLocationSDK");
                }
                if (bundle.containsKey("TencentMapSDK")) {
                    return bundle.getString("TencentMapSDK");
                }
                return "";
            }
        } catch (Exception e) {
        }
        return "";
    }

    final PackageInfo e() {
        try {
            return this.d.getPackageInfo(this.a.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            return new PackageInfo();
        }
    }

    final String f() {
        String string;
        Throwable th;
        String str = "";
        try {
            string = this.l.getString("macaddr", "");
            try {
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
                Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
                str = string;
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
                    if (networkInterface != null && networkInterface.getName().equalsIgnoreCase("wlan0")) {
                        byte[] hardwareAddress = networkInterface.getHardwareAddress();
                        if (!(hardwareAddress == null || hardwareAddress.length == 0)) {
                            StringBuilder stringBuilder = new StringBuilder();
                            int length = hardwareAddress.length;
                            for (int i = 0; i < length; i++) {
                                stringBuilder.append(String.format("%02X:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                            }
                            if (stringBuilder.length() > 0) {
                                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                            }
                            str = stringBuilder.toString();
                            this.l.edit().putString("macaddr", str).apply();
                        }
                    }
                }
                return str;
            } catch (Throwable th2) {
                th = th2;
                th.toString();
                return string;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            string = str;
            th = th4;
        }
    }

    private String b(String str) {
        cs csVar = this.b;
        Map hashMap = new HashMap();
        hashMap.put("version", csVar.d());
        hashMap.put("app_name", c(csVar.h));
        hashMap.put("app_label", c(csVar.i));
        hashMap.put("l", str);
        try {
            cs csVar2 = this.b;
            Map hashMap2 = new HashMap();
            hashMap2.put("imei", c(csVar2.a()));
            hashMap2.put("imsi", c(csVar2.b()));
            hashMap2.put("n", c(j.b(csVar2.d)));
            hashMap2.put("qq", c(j.b(csVar2.f)));
            hashMap2.put("mac", c(csVar2.c().toLowerCase(Locale.ENGLISH)));
            hashMap2.put("model", c(Build.MANUFACTURER + "_" + Build.MODEL));
            return new JSONObject(hashMap).put("attribute", new JSONObject(hashMap2)).toString();
        } catch (JSONException e) {
            return null;
        }
    }

    private static String c(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }
}
