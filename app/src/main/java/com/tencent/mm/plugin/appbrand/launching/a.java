package com.tencent.mm.plugin.appbrand.launching;

import android.database.Cursor;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.ai;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Locale;

public final class a extends c<qp> {
    public a() {
        this.xen = qp.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qp qpVar = (qp) bVar;
        if (bh.ov(qpVar.fIi.userName)) {
            qpVar.fIj.fIu = false;
            qpVar.fIj.fIv = "invalid username or appId";
            return true;
        }
        if (!(bh.ov(qpVar.fIi.appId) || bh.ov(qpVar.fIi.fIq.hjB))) {
            ((i) f.u(i.class)).m(qpVar.fIi.appId, qpVar.fIi.fIl, qpVar.fIi.fIq.hjB);
        }
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = qpVar.fIi.scene;
        appBrandStatObject.fnp = qpVar.fIi.fnp;
        appBrandStatObject.fIs = com.tencent.mm.plugin.appbrand.report.c.f(appBrandStatObject.scene, qpVar.fIi.fqh);
        appBrandStatObject.fIt = com.tencent.mm.plugin.appbrand.report.c.g(appBrandStatObject.scene, qpVar.fIi.fqh);
        if (qpVar.fIi.scene == 1037 || qpVar.fIi.scene == 1018) {
            appBrandStatObject.fIr = qpVar.fIi.fIr;
        } else {
            appBrandStatObject.fIr = qpVar.fIi.scene;
        }
        switch (qpVar.fIi.fIl) {
            case 0:
            case 2:
                AppBrandLaunchProxyUI.a(qpVar.fIi.context, qpVar.fIi.userName, qpVar.fIi.appId, qpVar.fIi.fIk, qpVar.fIi.fIl, qpVar.fIi.fIm <= 0 ? -1 : qpVar.fIi.fIm, appBrandStatObject, null, qpVar.fIi.fIq);
                break;
            case 1:
                ai Zo;
                String str;
                int i;
                Cursor a;
                if (!qpVar.fIi.fIo) {
                    if (!bh.ov(qpVar.fIi.appId)) {
                        if (!bh.ov(qpVar.fIi.fvR) && !bh.ov(qpVar.fIi.fIn)) {
                            if (f.Zo().a(qpVar.fIi.appId, qpVar.fIi.fIl, qpVar.fIi.fvR, qpVar.fIi.fIn, 0, 0)) {
                                d.aJ(qpVar.fIi.appId, qpVar.fIi.fIl);
                            } else {
                                boolean z;
                                Zo = f.Zo();
                                str = qpVar.fIi.appId;
                                i = qpVar.fIi.fIl;
                                if (bh.ov(str) || i < 0) {
                                    z = false;
                                } else {
                                    a = Zo.iGs.a("AppBrandWxaPkgManifestRecord", new String[]{"version"}, String.format(Locale.US, "%s=? and %s=?", new Object[]{"appId", "debugType"}), new String[]{str, String.valueOf(i)}, null, null, null, 2);
                                    if (a == null) {
                                        z = false;
                                    } else {
                                        z = a.moveToFirst();
                                        a.close();
                                    }
                                }
                                if (!z) {
                                    qpVar.fIj.fIu = false;
                                    qpVar.fIj.fIv = "install app failed";
                                    return true;
                                }
                            }
                            appBrandStatObject.fnp = qpVar.fIi.fvR;
                            AppBrandLaunchProxyUI.a(qpVar.fIi.context, qpVar.fIi.userName, qpVar.fIi.fIk, qpVar.fIi.fIl, -1, appBrandStatObject, qpVar.fIi.fIq);
                            break;
                        }
                        qpVar.fIj.fIu = false;
                        qpVar.fIj.fIv = "invalid downloadURL or checkSumMd5";
                        return true;
                    }
                    qpVar.fIj.fIu = false;
                    qpVar.fIj.fIv = "invalid username or appId";
                    return true;
                }
                com.tencent.mm.g.a.qp.a aVar = qpVar.fIi;
                str = q.qQ(qpVar.fIi.userName);
                aVar.appId = str;
                if (!bh.ov(str)) {
                    String str2;
                    Zo = f.Zo();
                    str = qpVar.fIi.appId;
                    i = qpVar.fIi.fIl;
                    a = Zo.iGs.query("AppBrandWxaPkgManifestRecord", new String[]{"pkgPath"}, String.format(Locale.US, "%s=? and %s=?", new Object[]{"appId", "debugType"}), new String[]{str, String.valueOf(i)}, null, null, null);
                    if (a == null) {
                        str2 = null;
                    } else {
                        str2 = a.moveToFirst() ? a.getString(0) : null;
                        a.close();
                    }
                    if (!bh.ov(str2) && e.bO(str2)) {
                        qpVar.fIj.fIu = true;
                        AppBrandLaunchProxyUI.a(qpVar.fIi.context, qpVar.fIi.userName, qpVar.fIi.fIk, qpVar.fIi.fIl, 0, appBrandStatObject, qpVar.fIi.fIq);
                        return true;
                    }
                }
                qpVar.fIj.fIu = false;
                qpVar.fIj.fIv = "local pkg not exists";
                if (qpVar.fIi.fIp) {
                    str = null;
                    if (qpVar.fIi.fIl == 1) {
                        str = com.tencent.mm.plugin.appbrand.q.c.getMMString(j.iyL, new Object[0]);
                    } else if (qpVar.fIi.fIl == 2) {
                        str = com.tencent.mm.plugin.appbrand.q.c.getMMString(j.iAj, new Object[0]);
                    }
                    com.tencent.mm.plugin.appbrand.ipc.a.a(qpVar.fIi.context, str, com.tencent.mm.plugin.appbrand.q.c.getMMString(j.dGO, new Object[0]), com.tencent.mm.plugin.appbrand.q.c.getMMString(j.dFU, new Object[0]), "", null, null, null);
                }
                return true;
            default:
                qpVar.fIj.fIu = false;
                qpVar.fIj.fIv = "invalid openType";
                return true;
        }
        qpVar.fIj.fIu = true;
        return true;
    }
}
