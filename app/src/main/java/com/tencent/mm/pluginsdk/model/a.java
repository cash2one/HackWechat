package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.List;

public final class a extends u {
    private final a vcW;
    private final Intent vcX;
    private final y vcY = new y();

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] vcZ = new int[a.values().length];

        static {
            try {
                vcZ[a.vda.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                vcZ[a.vdb.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                vcZ[a.vdc.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                vcZ[a.vdd.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                vcZ[a.vde.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public a(Bundle bundle) {
        if (bundle == null || bundle.getParcelable("key_target_intent") == null) {
            this.vcW = a.vda;
        } else {
            a Bz = a.Bz(bundle.getInt("key_map_app", a.vda.code));
            if (a(ac.getContext(), Bz, null) == null) {
                this.vcW = a.vda;
            } else {
                this.vcW = Bz;
            }
        }
        if (this.vcW == a.vda) {
            this.vcX = null;
        } else {
            this.vcX = (Intent) bundle.getParcelable("key_target_intent");
        }
    }

    private static ResolveInfo a(Context context, a aVar, Intent intent) {
        if (intent == null) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%f,%f", new Object[]{Float.valueOf(0.0f), Float.valueOf(0.0f)})));
        }
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (bh.cA(queryIntentActivities)) {
            return null;
        }
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            if (resolveInfo != null && resolveInfo.activityInfo != null && aVar.getPackage().equals(resolveInfo.activityInfo.packageName)) {
                return resolveInfo;
            }
        }
        return null;
    }

    public final boolean ec(Context context) {
        if (this.vcW == a.vda) {
            return this.vcY.ec(context);
        }
        return a(context, this.vcW, this.vcX) != null;
    }

    public final boolean Rq(String str) {
        return this.vcW.getPackage().equals(str);
    }

    public final String Wg() {
        return this.vcW == a.vda ? "http://softroute.map.qq.com/downloadfile?cid=00008&referer=wx_client" : null;
    }

    public final String bYk() {
        return this.vcW == a.vda ? "TencentMap.apk" : null;
    }

    public final com.tencent.mm.pluginsdk.model.v.a bYl() {
        if (this.vcW == a.vda) {
            return this.vcY.bYl();
        }
        com.tencent.mm.pluginsdk.model.v.a aVar = new com.tencent.mm.pluginsdk.model.v.a();
        aVar.vdT = -1;
        aVar.vdQ = -1;
        ResolveInfo a = a(ac.getContext(), this.vcW, this.vcX);
        if (a == null) {
            return aVar;
        }
        aVar.vdU = a(ac.getContext(), a);
        return aVar;
    }

    public final String a(Context context, ResolveInfo resolveInfo) {
        return this.vcY.a(context, resolveInfo);
    }
}
