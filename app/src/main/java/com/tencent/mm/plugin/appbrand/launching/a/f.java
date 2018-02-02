package com.tencent.mm.plugin.appbrand.launching.a;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class f implements d {
    private static final int[] jyK = new int[]{1025, 1031, 1032};
    private static final int[] jyL = new int[]{HardCoderJNI.FUNC_REG_PRELOAD_BOOT_RESOURCE, HardCoderJNI.FUNC_TERMINATE_APP, HardCoderJNI.FUNC_UNIFY_CPU_IO_THREAD_CORE, 1047, 1049, 1048, 1050};
    private final d jyM = new d();
    private final e jyN = new e();
    private final c jyO = new c();

    public final boolean tb(String str) {
        if (bh.ov(str)) {
            return false;
        }
        b bVar;
        x.i("MicroMsg.WeAppLinkOpener", "handle appLink = %s", new Object[]{str});
        for (b bVar2 : b.values()) {
            if (bh.ov(str) || !str.startsWith(bVar2.hMi)) {
                boolean z = false;
            } else {
                int i = 1;
            }
            if (i != 0) {
                bVar = bVar2;
                break;
            }
        }
        bVar = null;
        if (bVar == null) {
            return false;
        }
        Uri parse;
        try {
            parse = Uri.parse(str);
        } catch (Exception e) {
            x.e("MicroMsg.WeAppLinkOpener", "handle nativeLink = %s, exp = %s", new Object[]{str, e});
            parse = null;
        }
        if (parse == null) {
            return false;
        }
        String queryParameter = parse.getQueryParameter("username");
        String queryParameter2 = parse.getQueryParameter("path");
        if (bh.ov(queryParameter) || !com.tencent.mm.storage.x.fV(queryParameter)) {
            return false;
        }
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = bVar.scene;
        appBrandStatObject.fnp = b.aie();
        appBrandStatObject.fIs = b.aif();
        appBrandStatObject.fIt = b.aig();
        AppBrandLaunchProxyUI.a(null, queryParameter, queryParameter2, 0, -1, appBrandStatObject, null);
        return true;
    }

    public final boolean b(Context context, String str, int i, Bundle bundle) {
        if (a.b(jyK, i)) {
            if (a.a.jyB == this.jyM.a(context, str, i, bundle)) {
                return true;
            }
            return false;
        } else if (a.b(jyL, i)) {
            if (a.a.jyB != this.jyN.a(context, str, i, bundle)) {
                return false;
            }
            return true;
        } else if (1064 != i && 1078 != i) {
            x.e("MicroMsg.WeAppLinkOpener", "handleScanCodeLink, unhandled case link[ %s ], scene[ %d ]", new Object[]{str, Integer.valueOf(i)});
            return false;
        } else if (a.a.jyB != this.jyO.a(context, str, i, bundle)) {
            return false;
        } else {
            return true;
        }
    }
}
