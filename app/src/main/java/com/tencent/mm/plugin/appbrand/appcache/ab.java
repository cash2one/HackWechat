package com.tencent.mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import com.tencent.mm.pluginsdk.i.a.d.k;
import java.util.concurrent.TimeUnit;

@SuppressLint({"DefaultLocale"})
public class ab extends k {
    public final String appId;
    public final int fvM;
    volatile boolean iFO;
    public final int version;

    public static String ag(String str, int i) {
        return aa.ZZ() + String.format("_%d_%d.wxapkg", new Object[]{Integer.valueOf(str.hashCode()), Integer.valueOf(i)});
    }

    ab(String str, int i, int i2, String str2) {
        this(String.format("WxaPkg_%s_%d", new Object[]{str, Integer.valueOf(i2)}), ag(str, i2), str2, str, i2, i);
    }

    ab(String str, String str2, String str3, String str4, int i, int i2) {
        super(str, str2, String.valueOf(i), "AppBrandWxaPkgDownloader", str3, "GET", 3, 2, 0);
        this.iFO = true;
        this.appId = str4;
        this.version = i;
        this.fvM = i2;
        setConnectTimeout((int) TimeUnit.SECONDS.toMillis(15));
        setReadTimeout((int) TimeUnit.SECONDS.toMillis(30));
    }
}
