package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.tencent.mm.bm.d;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.f;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.launching.ad.1;
import com.tencent.mm.plugin.appbrand.launching.ae.a;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;
import org.json.JSONObject;

public final class c implements Runnable {
    private volatile String appId;
    private final int iGL;
    private final int iKd;
    private final String iNW;
    private final a jwT;
    private AppBrandStatObject jwU;
    private final String username;

    public c(LaunchParcel launchParcel, a aVar) {
        this.jwT = aVar;
        this.iKd = launchParcel.iKd;
        this.appId = launchParcel.appId;
        this.username = launchParcel.username;
        this.iGL = launchParcel.version;
        this.jwU = launchParcel.jyP;
        this.iNW = launchParcel.iNW;
    }

    public c(String str, int i, AppBrandStatObject appBrandStatObject, a aVar) {
        this.jwT = aVar;
        this.appId = str;
        this.iKd = i;
        this.username = null;
        this.iGL = 0;
        this.jwU = appBrandStatObject;
        this.iNW = null;
    }

    public final void run() {
        Pair aic;
        Pair pair;
        WxaAttributes wxaAttributes;
        Throwable e;
        String str;
        v vVar;
        boolean z;
        Intent putExtra;
        Context context;
        int adc;
        a kQ;
        int i;
        AppBrandInitConfig a;
        JSONObject fy;
        AppBrandStatObject appBrandStatObject;
        try {
            aic = new ac(this.username, this.appId, this.iKd, this.iGL, this.jwU == null ? 0 : this.jwU.scene, this.iNW).aic();
            try {
                pair = aic;
                wxaAttributes = (WxaAttributes) aic.first;
            } catch (Exception e2) {
                e = e2;
                x.printErrStackTrace("MicroMsg.AppBrandPreLaunchProcess", e, "get attr ", new Object[0]);
                pair = aic;
                wxaAttributes = null;
                if (wxaAttributes == null) {
                    str = wxaAttributes.field_appId;
                    vVar = new v(str);
                    if (g.zY().getInt("WeAppForbiddenSwitch", 0) == 1) {
                        z = false;
                    } else {
                        x.i("MicroMsg.AppBrand.PreLaunchCheckForOversea", "startApp, WeAppForbiddenSwitch == 1, go webview, appId %s", new Object[]{vVar.appId});
                        putExtra = new Intent().putExtra("rawUrl", l.pp(vVar.appId)).putExtra("forceHideShare", true);
                        context = ac.getContext();
                        if (!(context instanceof Activity)) {
                            putExtra.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        }
                        d.b(context, "webview", ".ui.tools.WebViewUI", putExtra);
                        z = true;
                    }
                    if (z) {
                        if (2 == this.iKd) {
                            z = com.tencent.mm.plugin.appbrand.task.d.un(str);
                            adc = new ae(str, ad.aF(str, 2), ad.aF(str, 10001), z).adc();
                            x.i("MicroMsg.AppBrand.PrepareStepOpBan", "checkDemoInfo, appId %s, ret %d, ignoreCgiError %b", new Object[]{str, Integer.valueOf(adc), Boolean.valueOf(z)});
                            kQ = a.kQ(adc);
                            if (kQ != null) {
                                switch (adc) {
                                    case -13003:
                                        y.kP(j.iyR);
                                        com.tencent.mm.plugin.appbrand.report.a.z(str, 12, 3);
                                        z = false;
                                        break;
                                    case -13002:
                                        y.kP(j.iyQ);
                                        com.tencent.mm.plugin.appbrand.report.a.z(str, 13, 3);
                                        z = false;
                                        break;
                                    default:
                                        if (!z) {
                                            z = true;
                                            break;
                                        }
                                        y.ta(ac.getResources().getString(j.iAW, new Object[]{Integer.valueOf(3), Integer.valueOf(adc)}));
                                        z = false;
                                        break;
                                }
                            } else if (z) {
                                switch (1.jyq[kQ.ordinal()]) {
                                    case 1:
                                        z = true;
                                        break;
                                    case 2:
                                        y.kP(j.iyP);
                                        com.tencent.mm.plugin.appbrand.report.a.z(str, 13, 3);
                                        z = false;
                                        break;
                                    default:
                                        y.kP(j.iyO);
                                        com.tencent.mm.plugin.appbrand.report.a.z(str, 13, 3);
                                        z = false;
                                        break;
                                }
                            } else {
                                z = true;
                            }
                            if (!z) {
                                z = true;
                            }
                        }
                        if (this.iKd == 0) {
                            if (1 == wxaAttributes.acb().iPF) {
                                z = true;
                            } else {
                                AppBrand404PageUI.show(j.iAf);
                                com.tencent.mm.plugin.appbrand.report.a.z(wxaAttributes.field_appId, 14, 1);
                                i = 0;
                            }
                            if (i == 0) {
                                z = true;
                            }
                        }
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        f.abV();
                        a = f.a(wxaAttributes);
                        a.iGA = this.iKd;
                        a.iNY = ((Boolean) pair.second).booleanValue();
                        this.appId = a.appId;
                        if (this.iKd == 0) {
                            a.extInfo = ((i) com.tencent.mm.plugin.appbrand.app.f.u(i.class)).aE(this.appId, this.iKd);
                            try {
                                fy = com.tencent.mm.v.g.fy(a.extInfo);
                                a.iNT = fy.optString("device_orientation");
                                a.iNU = fy.optString("client_js_ext_info");
                                a.iNV = fy.optBoolean("open_remote", false);
                            } catch (Exception e3) {
                            }
                        } else {
                            a.iNT = wxaAttributes.acb().iMG;
                            a.iNU = wxaAttributes.acb().iNU;
                        }
                        if (this.jwU == null) {
                            this.jwU = new AppBrandStatObject();
                        }
                        appBrandStatObject = this.jwU;
                        if (this.jwT == null) {
                            this.jwT.c(a, appBrandStatObject);
                        }
                    }
                    onError();
                    return;
                }
                x.i("MicroMsg.AppBrandPreLaunchProcess", "onGetWxaAttr null return");
                onError();
                return;
            }
        } catch (Exception e4) {
            e = e4;
            aic = null;
            x.printErrStackTrace("MicroMsg.AppBrandPreLaunchProcess", e, "get attr ", new Object[0]);
            pair = aic;
            wxaAttributes = null;
            if (wxaAttributes == null) {
                x.i("MicroMsg.AppBrandPreLaunchProcess", "onGetWxaAttr null return");
                onError();
                return;
            }
            str = wxaAttributes.field_appId;
            vVar = new v(str);
            if (g.zY().getInt("WeAppForbiddenSwitch", 0) == 1) {
                x.i("MicroMsg.AppBrand.PreLaunchCheckForOversea", "startApp, WeAppForbiddenSwitch == 1, go webview, appId %s", new Object[]{vVar.appId});
                putExtra = new Intent().putExtra("rawUrl", l.pp(vVar.appId)).putExtra("forceHideShare", true);
                context = ac.getContext();
                if (context instanceof Activity) {
                    putExtra.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                }
                d.b(context, "webview", ".ui.tools.WebViewUI", putExtra);
                z = true;
            } else {
                z = false;
            }
            if (z) {
                z = true;
            } else {
                if (2 == this.iKd) {
                    z = com.tencent.mm.plugin.appbrand.task.d.un(str);
                    adc = new ae(str, ad.aF(str, 2), ad.aF(str, 10001), z).adc();
                    x.i("MicroMsg.AppBrand.PrepareStepOpBan", "checkDemoInfo, appId %s, ret %d, ignoreCgiError %b", new Object[]{str, Integer.valueOf(adc), Boolean.valueOf(z)});
                    kQ = a.kQ(adc);
                    if (kQ != null) {
                        if (z) {
                            switch (1.jyq[kQ.ordinal()]) {
                                case 1:
                                    z = true;
                                    break;
                                case 2:
                                    y.kP(j.iyP);
                                    com.tencent.mm.plugin.appbrand.report.a.z(str, 13, 3);
                                    z = false;
                                    break;
                                default:
                                    y.kP(j.iyO);
                                    com.tencent.mm.plugin.appbrand.report.a.z(str, 13, 3);
                                    z = false;
                                    break;
                            }
                        }
                        z = true;
                    } else {
                        switch (adc) {
                            case -13003:
                                y.kP(j.iyR);
                                com.tencent.mm.plugin.appbrand.report.a.z(str, 12, 3);
                                z = false;
                                break;
                            case -13002:
                                y.kP(j.iyQ);
                                com.tencent.mm.plugin.appbrand.report.a.z(str, 13, 3);
                                z = false;
                                break;
                            default:
                                if (!z) {
                                    y.ta(ac.getResources().getString(j.iAW, new Object[]{Integer.valueOf(3), Integer.valueOf(adc)}));
                                    z = false;
                                    break;
                                }
                                z = true;
                                break;
                        }
                    }
                    if (z) {
                        z = true;
                    }
                }
                if (this.iKd == 0) {
                    if (1 == wxaAttributes.acb().iPF) {
                        AppBrand404PageUI.show(j.iAf);
                        com.tencent.mm.plugin.appbrand.report.a.z(wxaAttributes.field_appId, 14, 1);
                        i = 0;
                    } else {
                        z = true;
                    }
                    if (i == 0) {
                        z = true;
                    }
                }
                z = false;
            }
            if (z) {
                onError();
                return;
            }
            f.abV();
            a = f.a(wxaAttributes);
            a.iGA = this.iKd;
            a.iNY = ((Boolean) pair.second).booleanValue();
            this.appId = a.appId;
            if (this.iKd == 0) {
                a.iNT = wxaAttributes.acb().iMG;
                a.iNU = wxaAttributes.acb().iNU;
            } else {
                a.extInfo = ((i) com.tencent.mm.plugin.appbrand.app.f.u(i.class)).aE(this.appId, this.iKd);
                fy = com.tencent.mm.v.g.fy(a.extInfo);
                a.iNT = fy.optString("device_orientation");
                a.iNU = fy.optString("client_js_ext_info");
                a.iNV = fy.optBoolean("open_remote", false);
            }
            if (this.jwU == null) {
                this.jwU = new AppBrandStatObject();
            }
            appBrandStatObject = this.jwU;
            if (this.jwT == null) {
                this.jwT.c(a, appBrandStatObject);
            }
        }
        if (wxaAttributes == null) {
            x.i("MicroMsg.AppBrandPreLaunchProcess", "onGetWxaAttr null return");
            onError();
            return;
        }
        str = wxaAttributes.field_appId;
        vVar = new v(str);
        if (g.zY().getInt("WeAppForbiddenSwitch", 0) == 1) {
            x.i("MicroMsg.AppBrand.PreLaunchCheckForOversea", "startApp, WeAppForbiddenSwitch == 1, go webview, appId %s", new Object[]{vVar.appId});
            putExtra = new Intent().putExtra("rawUrl", l.pp(vVar.appId)).putExtra("forceHideShare", true);
            context = ac.getContext();
            if (context instanceof Activity) {
                putExtra.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            d.b(context, "webview", ".ui.tools.WebViewUI", putExtra);
            z = true;
        } else {
            z = false;
        }
        if (z) {
            z = true;
        } else {
            if (2 == this.iKd) {
                z = com.tencent.mm.plugin.appbrand.task.d.un(str);
                adc = new ae(str, ad.aF(str, 2), ad.aF(str, 10001), z).adc();
                x.i("MicroMsg.AppBrand.PrepareStepOpBan", "checkDemoInfo, appId %s, ret %d, ignoreCgiError %b", new Object[]{str, Integer.valueOf(adc), Boolean.valueOf(z)});
                kQ = a.kQ(adc);
                if (kQ != null) {
                    if (z) {
                        switch (1.jyq[kQ.ordinal()]) {
                            case 1:
                                z = true;
                                break;
                            case 2:
                                y.kP(j.iyP);
                                com.tencent.mm.plugin.appbrand.report.a.z(str, 13, 3);
                                z = false;
                                break;
                            default:
                                y.kP(j.iyO);
                                com.tencent.mm.plugin.appbrand.report.a.z(str, 13, 3);
                                z = false;
                                break;
                        }
                    }
                    z = true;
                } else {
                    switch (adc) {
                        case -13003:
                            y.kP(j.iyR);
                            com.tencent.mm.plugin.appbrand.report.a.z(str, 12, 3);
                            z = false;
                            break;
                        case -13002:
                            y.kP(j.iyQ);
                            com.tencent.mm.plugin.appbrand.report.a.z(str, 13, 3);
                            z = false;
                            break;
                        default:
                            if (!z) {
                                y.ta(ac.getResources().getString(j.iAW, new Object[]{Integer.valueOf(3), Integer.valueOf(adc)}));
                                z = false;
                                break;
                            }
                            z = true;
                            break;
                    }
                }
                if (z) {
                    z = true;
                }
            }
            if (this.iKd == 0) {
                if (1 == wxaAttributes.acb().iPF) {
                    AppBrand404PageUI.show(j.iAf);
                    com.tencent.mm.plugin.appbrand.report.a.z(wxaAttributes.field_appId, 14, 1);
                    i = 0;
                } else {
                    z = true;
                }
                if (i == 0) {
                    z = true;
                }
            }
            z = false;
        }
        if (z) {
            onError();
            return;
        }
        f.abV();
        a = f.a(wxaAttributes);
        a.iGA = this.iKd;
        a.iNY = ((Boolean) pair.second).booleanValue();
        this.appId = a.appId;
        if (this.iKd == 0) {
            a.iNT = wxaAttributes.acb().iMG;
            a.iNU = wxaAttributes.acb().iNU;
        } else {
            a.extInfo = ((i) com.tencent.mm.plugin.appbrand.app.f.u(i.class)).aE(this.appId, this.iKd);
            fy = com.tencent.mm.v.g.fy(a.extInfo);
            a.iNT = fy.optString("device_orientation");
            a.iNU = fy.optString("client_js_ext_info");
            a.iNV = fy.optBoolean("open_remote", false);
        }
        if (this.jwU == null) {
            this.jwU = new AppBrandStatObject();
        }
        appBrandStatObject = this.jwU;
        if (this.jwT == null) {
            this.jwT.c(a, appBrandStatObject);
        }
    }

    private void onError() {
        if (this.jwT != null) {
            this.jwT.c(null, null);
        }
    }
}
