package com.tencent.mm.plugin.appbrand.launching.a;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.d;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.i;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

abstract class a {
    abstract void a(Uri uri, int i);

    a() {
    }

    final int a(Context context, String str, int i, Bundle bundle) {
        int i2;
        x.i("MicroMsg.AppBrand.AbsLinkOpener", "handle url = %s", str);
        Uri uri = null;
        if (bh.ov(str)) {
            i2 = a.jyC;
        } else {
            Uri parse = Uri.parse(str);
            String queryParameter;
            String queryParameter2;
            AppBrandStatObject appBrandStatObject;
            if ((bh.getInt(parse.getQueryParameter("debug"), 0) > 0 ? 1 : null) != null) {
                i2 = bh.getInt(parse.getQueryParameter("ret"), 0);
                if (i2 == 1) {
                    i2 = a.jyD;
                    uri = parse;
                } else if (i2 == 2) {
                    i2 = a.jyE;
                    uri = parse;
                } else {
                    queryParameter = parse.getQueryParameter("appid");
                    String queryParameter3 = parse.getQueryParameter("username");
                    String ou = bh.ou(parse.getQueryParameter("path"));
                    String queryParameter4 = parse.getQueryParameter("codeurl");
                    String queryParameter5 = parse.getQueryParameter("md5");
                    String queryParameter6 = parse.getQueryParameter("pageurl");
                    String queryParameter7 = parse.getQueryParameter("pagemd5");
                    long j = bh.getLong(parse.getQueryParameter("test_lifespan"), 7200);
                    if (bh.ov(queryParameter) || bh.ov(queryParameter3) || bh.ov(queryParameter4)) {
                        x.i("MicroMsg.AppBrand.AbsLinkOpener", "appId = %s, username = %s, codeURL = %s, invalid, return", queryParameter, queryParameter3, queryParameter4);
                        i2 = a.jyC;
                        uri = parse;
                    } else {
                        boolean a = f.Zo().a(queryParameter, 1, queryParameter4, queryParameter5, 0, bh.Wo() + j);
                        if (!(bh.ov(queryParameter6) || bh.ov(queryParameter7))) {
                            f.Zo().a(queryParameter, 10000, queryParameter6, queryParameter7, 0, bh.Wo() + j);
                            i2 = com.tencent.mm.plugin.appbrand.dynamic.k.a.bD(0, 1);
                            if (i2 == 10000) {
                                Parcelable bundle2 = new Bundle();
                                bundle2.putString("appId", queryParameter);
                                bundle2.putInt("debugType", i2);
                                com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", bundle2, d.class, null);
                            }
                        }
                        if (a) {
                            com.tencent.mm.plugin.appbrand.task.d.aJ(queryParameter, 1);
                        }
                        queryParameter2 = parse.getQueryParameter("json_extinfo");
                        LaunchParamsOptional launchParamsOptional = new LaunchParamsOptional();
                        launchParamsOptional.hjB = queryParameter2;
                        ((i) f.u(i.class)).m(queryParameter, 1, queryParameter2);
                        appBrandStatObject = new AppBrandStatObject();
                        a(str, i, appBrandStatObject, bundle);
                        AppBrandLaunchProxyUI.a(context, queryParameter3, ou, 1, -1, appBrandStatObject, launchParamsOptional);
                        i2 = a.jyB;
                        uri = parse;
                    }
                }
            } else {
                queryParameter2 = parse.getQueryParameter("username");
                queryParameter = bh.ou(parse.getQueryParameter("path"));
                int i3 = bh.getInt(parse.getQueryParameter("version"), 0);
                int i4 = bh.getInt(parse.getQueryParameter(DownloadSettingTable$Columns.TYPE), 0);
                if (bh.ov(queryParameter2)) {
                    x.i("MicroMsg.AppBrand.AbsLinkOpener", "username = %s, invalid, return", queryParameter2);
                    i2 = a.jyC;
                    uri = parse;
                } else {
                    appBrandStatObject = new AppBrandStatObject();
                    a(str, i, appBrandStatObject, bundle);
                    AppBrandLaunchProxyUI.a(context, queryParameter2, queryParameter, i4, i3, appBrandStatObject, null);
                    i2 = a.jyB;
                    uri = parse;
                }
            }
        }
        a(uri, i2);
        return i2;
    }

    private static void a(String str, int i, AppBrandStatObject appBrandStatObject, Bundle bundle) {
        appBrandStatObject.scene = i;
        appBrandStatObject.fnp = p.encode(str);
        appBrandStatObject.fIs = c.f(i, bundle);
        appBrandStatObject.fIt = c.g(i, bundle);
        if (i == 1037 || i == 1018) {
            appBrandStatObject.fIr = 0;
        } else {
            appBrandStatObject.fIr = i;
        }
    }
}
