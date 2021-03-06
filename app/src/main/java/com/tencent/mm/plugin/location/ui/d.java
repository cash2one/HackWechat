package com.tencent.mm.plugin.location.ui;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLEncoder;

public final class d {
    public Context context;
    public int hJq = -1;
    private ActivityManager mlI;
    public int nSG = 0;
    public int nSH = 0;
    public boolean nSI = false;

    public static int gm(boolean z) {
        x.d("MicroMsg.MapHelper", new StringBuilder("getDefaultZoom isGoogle : false").toString());
        return 16;
    }

    public d(Context context) {
        this.context = context;
        this.mlI = (ActivityManager) context.getSystemService("activity");
    }

    private static Intent a(LocationInfo locationInfo, LocationInfo locationInfo2, boolean z) {
        if (z || !locationInfo2.aVk()) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.nQx + "," + locationInfo.nQy + "?z=" + locationInfo.zoom));
            intent.setPackage("com.baidu.BaiduMap");
            return intent;
        }
        String format = String.format("intent://map/direction?origin=%f,%f&destination=%f,%f&mode=driving&coord_type=gcj02", new Object[]{Double.valueOf(locationInfo2.nQx), Double.valueOf(locationInfo2.nQy), Double.valueOf(locationInfo.nQx), Double.valueOf(locationInfo.nQy)});
        x.d("MicroMsg.MapHelper", "url " + format);
        try {
            format = format + "&referer=tencent|weixin#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end";
            x.d("MicroMsg.MapHelper", "all: " + format);
            return Intent.getIntent(format);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MapHelper", e, "", new Object[0]);
            return null;
        }
    }

    private static Intent b(LocationInfo locationInfo, LocationInfo locationInfo2, boolean z) {
        if (z || !locationInfo2.aVk()) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.nQx + "," + locationInfo.nQy + "?z=" + locationInfo.zoom));
            intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
            return intent;
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?f=d&saddr=%f,%f&daddr=%f,%f&hl=" + (bh.ov(locationInfo.nQA) ? "zh-cn" : locationInfo.nQA), new Object[]{Double.valueOf(locationInfo2.nQx), Double.valueOf(locationInfo2.nQy), Double.valueOf(locationInfo.nQx), Double.valueOf(locationInfo.nQy)})));
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        return intent;
    }

    private static Intent a(Context context, LocationInfo locationInfo, LocationInfo locationInfo2, boolean z) {
        if (z || !locationInfo2.aVk()) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.nQx + "," + locationInfo.nQy + "?z=" + locationInfo.zoom));
            intent.setPackage("com.tencent.map");
            return intent;
        }
        String str = "&from=%s";
        String str2 = "&to=%s";
        String format = String.format("sosomap://type=nav&fromcoord=%f,%f&tocoord=%f,%f", new Object[]{Double.valueOf(locationInfo2.nQy), Double.valueOf(locationInfo2.nQx), Double.valueOf(locationInfo.nQy), Double.valueOf(locationInfo.nQx)});
        if (!bh.ov(locationInfo2.nQz)) {
            String encode = URLEncoder.encode(locationInfo2.nQz);
            format = format + String.format(str, new Object[]{encode});
        }
        if (!bh.ov(locationInfo.nQz)) {
            str = URLEncoder.encode(locationInfo.nQz);
            format = format + String.format(str2, new Object[]{str});
        }
        x.d("MicroMsg.MapHelper", "tencentluxian, url=%s", format + "&referer=wx_client");
        intent = new Intent("android.intent.action.VIEW", Uri.parse(format));
        intent.setPackage("com.tencent.map");
        if (bh.k(context, intent)) {
            return intent;
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.nQx + "," + locationInfo.nQy));
        intent.setPackage("com.tencent.map");
        return intent;
    }

    private static Intent a(Context context, LocationInfo locationInfo, LocationInfo locationInfo2, boolean z, String str) {
        if (z || !locationInfo2.aVk()) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.nQx + "," + locationInfo.nQy + "?z=" + locationInfo.zoom));
            intent.setPackage(str);
            return intent;
        }
        String str2 = "&from=%s&to=%s";
        String format = String.format("wechatnav://type=nav&fromcoord=%f,%f&tocoord=%f,%f", new Object[]{Double.valueOf(locationInfo2.nQx), Double.valueOf(locationInfo2.nQy), Double.valueOf(locationInfo.nQx), Double.valueOf(locationInfo.nQy)});
        if (!(bh.ov(locationInfo2.nQz) || bh.ov(locationInfo.nQz))) {
            format = format + String.format(str2, new Object[]{locationInfo2.nQz, locationInfo.nQz});
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse(format));
        intent.setPackage(str);
        if (bh.k(context, intent)) {
            return intent;
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.nQx + "," + locationInfo.nQy));
        intent.setPackage(str);
        return intent;
    }

    public final void a(LocationInfo locationInfo, LocationInfo locationInfo2, String str, boolean z) {
        if ("com.tencent.map".equals(str)) {
            if (z) {
                g.pQN.h(11091, Integer.valueOf(4), Integer.valueOf(2));
            } else {
                g.pQN.h(11091, Integer.valueOf(4), Integer.valueOf(1));
            }
        } else if (z) {
            g.pQN.h(11091, Integer.valueOf(5), Integer.valueOf(2));
        } else {
            g.pQN.h(11091, Integer.valueOf(5), Integer.valueOf(1));
        }
        PackageManager packageManager = this.context.getPackageManager();
        Intent b;
        if ("com.google.android.apps.maps".equals(str)) {
            b = b(locationInfo, locationInfo2, false);
            if (!bh.k(this.context, b)) {
                b = b(locationInfo, locationInfo2, true);
            }
            g.pQN.h(10997, "4", "", Integer.valueOf(0), Integer.valueOf(0));
            this.context.startActivity(b);
        } else if ("com.baidu.BaiduMap".equals(str)) {
            b = a(locationInfo, locationInfo2, false);
            if (!bh.k(this.context, b)) {
                b = a(locationInfo, locationInfo2, true);
            }
            r1 = e.aq(this.context, "com.baidu.BaiduMap").applicationInfo.loadLabel(packageManager).toString();
            g.pQN.h(10997, "5", r1, Integer.valueOf(0), Integer.valueOf(0));
            this.context.startActivity(b);
        } else if ("com.tencent.map".equals(str)) {
            b = a(this.context, locationInfo, locationInfo2, false);
            if (!bh.k(this.context, b)) {
                b = a(this.context, locationInfo, locationInfo2, true);
            }
            g.pQN.h(10997, "2", "", Integer.valueOf(0), Integer.valueOf(0));
            this.context.startActivity(b);
        } else if ("com.autonavi.minimap".equals(str)) {
            r2 = e.aq(this.context, str);
            if (r2 != null) {
                b = a(this.context, locationInfo, locationInfo2, false, str);
                if (!bh.k(this.context, b)) {
                    b = a(this.context, locationInfo, locationInfo2, true, str);
                }
                r1 = r2.applicationInfo.loadLabel(packageManager).toString();
                g.pQN.h(10997, "5", r1, Integer.valueOf(0), Integer.valueOf(0));
                this.context.startActivity(b);
            }
        } else if ("com.sogou.map.android.maps".equals(str)) {
            r2 = e.aq(this.context, str);
            if (r2 != null) {
                b = a(this.context, locationInfo, locationInfo2, false, str);
                if (!bh.k(this.context, b)) {
                    b = a(this.context, locationInfo, locationInfo2, true, str);
                }
                r1 = r2.applicationInfo.loadLabel(packageManager).toString();
                g.pQN.h(10997, "5", r1, Integer.valueOf(0), Integer.valueOf(0));
                this.context.startActivity(b);
            }
        }
    }
}
