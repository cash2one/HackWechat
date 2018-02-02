package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcelable;
import com.tencent.mm.ae.a;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.appcache.r;
import com.tencent.mm.plugin.appbrand.appcache.w;
import com.tencent.mm.plugin.appbrand.ipc.d;
import com.tencent.mm.plugin.appbrand.p.i;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.protocal.c.anz;
import com.tencent.mm.protocal.c.aoa;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.protocal.c.cam;
import com.tencent.mm.protocal.c.cau;
import com.tencent.mm.protocal.c.cbi;
import com.tencent.mm.protocal.c.cbl;
import com.tencent.mm.protocal.c.cbs;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;

final class e extends a<aoa> {
    final b gJQ;
    final String irG;
    volatile u jxG;
    volatile boolean jxH;

    protected final /* bridge */ /* synthetic */ void a(int i, int i2, String str, bdf com_tencent_mm_protocal_c_bdf, k kVar) {
        a(i, i2, str, (aoa) com_tencent_mm_protocal_c_bdf);
    }

    e(String str, boolean z, cam com_tencent_mm_protocal_c_cam, cbs com_tencent_mm_protocal_c_cbs, cbl com_tencent_mm_protocal_c_cbl, String str2, int i) {
        this.jxH = false;
        this.irG = str2;
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_anz = new anz();
        com_tencent_mm_protocal_c_anz.ngo = str;
        com_tencent_mm_protocal_c_anz.wuO = com_tencent_mm_protocal_c_cam;
        com_tencent_mm_protocal_c_anz.wnA = z ? 1 : 2;
        com_tencent_mm_protocal_c_anz.wuR = com_tencent_mm_protocal_c_cbs;
        com_tencent_mm_protocal_c_anz.wuS = com_tencent_mm_protocal_c_cbl;
        cbi com_tencent_mm_protocal_c_cbi = new cbi();
        com_tencent_mm_protocal_c_cbi.wwD = i;
        if (i > 0) {
            r Zu = f.Zu();
            if (Zu != null) {
                c qVar = new q();
                qVar.field_key = "@LibraryAppId";
                qVar.field_version = i;
                if (Zu.b(qVar, new String[]{"key", "version"})) {
                    com_tencent_mm_protocal_c_cbi.vGO = (int) qVar.field_updateTime;
                    com_tencent_mm_protocal_c_cbi.xay = qVar.field_scene;
                }
            }
        }
        com_tencent_mm_protocal_c_anz.wuQ = com_tencent_mm_protocal_c_cbi;
        try {
            if (com.tencent.mm.compatible.d.q.gGc.gCE) {
                x.i("MicroMsg.AppBrand.CgiLaunchWxaApp", "DeviceInfo isLimit benchmarkLevel");
                com_tencent_mm_protocal_c_anz.wuU = -2;
            } else {
                com_tencent_mm_protocal_c_anz.wuU = g.zY().getInt("ClientBenchmarkLevel", 0);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrand.CgiLaunchWxaApp", e, "read performanceLevel", new Object[0]);
        }
        b.a aVar = new b.a();
        aVar.hmi = 1122;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp";
        aVar.hmj = com_tencent_mm_protocal_c_anz;
        aVar.hmk = new aoa();
        b JZ = aVar.JZ();
        this.gJQ = JZ;
        this.gJQ = JZ;
    }

    e(String str, cam com_tencent_mm_protocal_c_cam, String str2, int i) {
        this(str, false, com_tencent_mm_protocal_c_cam, null, null, str2, i);
    }

    private String getAppId() {
        return ((anz) this.gJQ.hmg.hmo).ngo;
    }

    private int ahR() {
        return ((anz) this.gJQ.hmg.hmo).wuO.wtc;
    }

    private boolean ahS() {
        return ((anz) this.gJQ.hmg.hmo).wuO.wwB > 0;
    }

    private anz ahT() {
        return (anz) this.gJQ.hmg.hmo;
    }

    final void ahU() {
        com.tencent.mm.plugin.appbrand.q.c.Dm().F(new 1(this));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void a(int i, int i2, String str, aoa com_tencent_mm_protocal_c_aoa) {
        String str2;
        if (com_tencent_mm_protocal_c_aoa == null) {
            str2 = "NULL";
        } else {
            if (com_tencent_mm_protocal_c_aoa.wuW == null) {
                str2 = "NULL_API_INFO";
            } else {
                Object obj;
                StringBuilder stringBuilder = new StringBuilder("api_info~ fg:");
                if (com_tencent_mm_protocal_c_aoa.wuW.vVV == null) {
                    obj = "NULL";
                } else {
                    obj = Integer.valueOf(com_tencent_mm_protocal_c_aoa.wuW.vVV.oz.length);
                }
                str2 = stringBuilder.append(obj).toString();
                if (com_tencent_mm_protocal_c_aoa.wuW.vVW != null) {
                    if (com_tencent_mm_protocal_c_aoa.wuW.vVW.size() > 0) {
                        str2 = str2 + " | bg:" + ((com.tencent.mm.bq.b) com_tencent_mm_protocal_c_aoa.wuW.vVW.get(0)).oz.length;
                    }
                    if (com_tencent_mm_protocal_c_aoa.wuW.vVW.size() > 1) {
                        str2 = str2 + " | suspend:" + ((com.tencent.mm.bq.b) com_tencent_mm_protocal_c_aoa.wuW.vVW.get(1)).oz.length;
                    }
                }
                str2 = str2 + "~";
            }
            if (com_tencent_mm_protocal_c_aoa.wuV == null) {
                str2 = str2 + " || NULL_LAUNCH";
            } else {
                str2 = str2 + " || launch " + com_tencent_mm_protocal_c_aoa.wuV.vEe;
            }
        }
        x.i("MicroMsg.AppBrand.CgiLaunchWxaApp", "onCgiBack, errType %d, errCode %d, errMsg %s, req[appId %s, bg %B, sync %B, libVersion %d], resp[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, getAppId(), Boolean.valueOf(ahS()), Boolean.valueOf(this.jxH), Integer.valueOf(ahT().wuQ.wwD), str2});
        if (i == 0 && i2 == 0 && com_tencent_mm_protocal_c_aoa != null) {
            u uVar;
            t Zi = f.Zi();
            String appId = getAppId();
            if (bh.ov(appId) || com_tencent_mm_protocal_c_aoa == null) {
                uVar = null;
            } else {
                u uVar2 = new u();
                uVar2.field_appId = appId;
                boolean z = !Zi.a(uVar2, "appId");
                boolean z2 = false;
                if (!i.a(uVar2.field_launchAction, com_tencent_mm_protocal_c_aoa.wuV)) {
                    uVar2.field_launchAction = com_tencent_mm_protocal_c_aoa.wuV;
                    z2 = true;
                }
                if (!i.a(uVar2.field_jsapiInfo, com_tencent_mm_protocal_c_aoa.wuW)) {
                    uVar2.field_jsapiInfo = com_tencent_mm_protocal_c_aoa.wuW;
                    z2 = true;
                }
                com_tencent_mm_protocal_c_aoa.wuX = com_tencent_mm_protocal_c_aoa.wuX == null ? new cau() : com_tencent_mm_protocal_c_aoa.wuX;
                if (!i.a(uVar2.field_hostInfo, com_tencent_mm_protocal_c_aoa.wuX)) {
                    uVar2.field_hostInfo = com_tencent_mm_protocal_c_aoa.wuX;
                    z2 = true;
                }
                if (!(com_tencent_mm_protocal_c_aoa.wuZ == null || i.a(uVar2.field_actionsheetInfo, com_tencent_mm_protocal_c_aoa.wuZ))) {
                    uVar2.field_actionsheetInfo = com_tencent_mm_protocal_c_aoa.wuZ;
                    z2 = true;
                }
                x.i("MicroMsg.LaunchWxaAppCacheStorage", "flush resp, appId %s, apply %B, insert %B", new Object[]{appId, Boolean.valueOf(z2), Boolean.valueOf(z)});
                if (z2) {
                    if (z) {
                        Zi.a(uVar2, false);
                    } else {
                        Zi.b(uVar2, false, "appId");
                    }
                }
                if (z2) {
                }
                if (z) {
                    uVar = null;
                }
                uVar = uVar2;
            }
            this.jxG = uVar;
            this.jxG.jxH = this.jxH;
            w.a(ahT().wuQ.wwD, com_tencent_mm_protocal_c_aoa.wuY);
            if (com_tencent_mm_protocal_c_aoa.wuV != null) {
                if (com_tencent_mm_protocal_c_aoa.wuV.wuM) {
                    f.Zm().a(com.tencent.mm.plugin.appbrand.config.q.qS(getAppId()), ahR(), ahS(), ((anz) this.gJQ.hmg.hmo).wuO.rYW, 1, this.irG);
                }
                if (!this.jxH) {
                    AppBrandLaunchErrorAction$a appBrandLaunchErrorAction$a = AppBrandLaunchErrorAction.CREATOR;
                    Parcelable a = AppBrandLaunchErrorAction$a.a(getAppId(), ahR(), this.jxG);
                    if (a != null) {
                        d.a(a);
                        AppBrandStickyBannerLogic.b.aN(getAppId(), ahR());
                    }
                }
            }
        } else if (this.jxH) {
            int i3 = j.iAX;
            Object[] objArr = new Object[1];
            objArr[0] = String.format(Locale.US, " (%d,%d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            y.ta(y.getMMString(i3, objArr));
        }
    }
}
