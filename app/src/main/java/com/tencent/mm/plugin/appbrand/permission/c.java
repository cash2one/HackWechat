package com.tencent.mm.plugin.appbrand.permission;

import android.support.v4.e.a;
import android.text.TextUtils;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.b.c.7;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public class c {
    private static final int iTK = (-bh.getInt(r.ido, 0));
    private static final a<String, c> jGF = new a();
    private static final c jGG = new 1();
    private final e irP;
    private final LinkedList<b> jGH;

    static /* synthetic */ void a(c cVar) {
        synchronized (cVar.jGH) {
            cVar.jGH.clear();
        }
    }

    static /* synthetic */ void b(c cVar) {
        LinkedList linkedList = new LinkedList();
        synchronized (cVar.jGH) {
            linkedList.addAll(cVar.jGH);
            cVar.jGH.clear();
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(a.ajC());
        }
    }

    public static c r(e eVar) {
        if (eVar == null || TextUtils.isEmpty(eVar.mAppId)) {
            x.e("MicroMsg.AppRuntimeApiPermissionController", "obtain dummy controller, stack %s", new Object[]{bh.i(new Throwable())});
            return jGG;
        }
        c cVar;
        synchronized (jGF) {
            cVar = (c) jGF.get(eVar.mAppId);
            if (cVar == null) {
                cVar = new c(eVar);
                jGF.put(eVar.mAppId, cVar);
            }
        }
        return cVar;
    }

    public static int a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, b bVar) {
        String appId = cVar.getAppId();
        int i = iTK;
        int afq = bVar.afq();
        if (i == -1) {
            x.d("MicroMsg.AppRuntimeApiPermissionController", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm on", new Object[]{appId, Integer.valueOf(afq)});
            return 1;
        } else if (i == -2) {
            x.d("MicroMsg.AppRuntimeApiPermissionController", "getCtrlByte, appId = %s, ctrlIndex = %d, hard code perm off", new Object[]{appId, Integer.valueOf(afq)});
            return 0;
        } else {
            AppBrandSysConfig appBrandSysConfig = cVar.YQ().iqx;
            AppRuntimeApiPermissionBundle appRuntimeApiPermissionBundle = null;
            if (appBrandSysConfig != null) {
                appRuntimeApiPermissionBundle = appBrandSysConfig.iOm;
                if (appRuntimeApiPermissionBundle != null) {
                    byte[] bArr;
                    int i2;
                    if (cVar instanceof j) {
                        switch (5.iGZ[cVar.YQ().iqO.iGV.aas().ordinal()]) {
                            case 1:
                            case 2:
                            case 3:
                                bArr = appRuntimeApiPermissionBundle.jGD;
                                break;
                            default:
                                bArr = appRuntimeApiPermissionBundle.jGC;
                                break;
                        }
                    }
                    bArr = appRuntimeApiPermissionBundle.jGC;
                    if (afq == -2) {
                        i = 1;
                    } else if (afq == -1) {
                        i = (d.vAE || (d.vAz & 255) <= 47) ? 1 : 0;
                        i = i != 0 ? 1 : 0;
                    } else {
                        i = (afq >= bArr.length || afq < 0) ? 0 : bArr[afq];
                    }
                    if (com.tencent.mm.compatible.loader.a.a(m.jcl, bVar.getClass()) || com.tencent.mm.compatible.loader.a.a(m.jcm, bVar.getClass())) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                    }
                    if (i2 != 0) {
                        x.i("MicroMsg.AppRuntimeApiPermissionController", "getCtrlByte, appId = %s, apiName = %s, ctrlIndex = %d, ctrlIndexLength %d, checkRet %d", new Object[]{appId, bVar.getName(), Integer.valueOf(afq), Integer.valueOf(bArr.length), Integer.valueOf(i)});
                    }
                    return i;
                }
            }
            x.e("MicroMsg.AppRuntimeApiPermissionController", "getCtrlByte, appId = %s, apiName = %s, invalid permission data config %s bundle %s", new Object[]{appId, bVar.getName(), appBrandSysConfig, appRuntimeApiPermissionBundle});
            return 0;
        }
    }

    public static boolean b(com.tencent.mm.plugin.appbrand.jsapi.c cVar, b bVar) {
        return a(cVar, bVar) == 1;
    }

    private c(e eVar) {
        this.jGH = new LinkedList();
        this.irP = eVar;
        if (eVar != null) {
            String str = eVar.mAppId;
            com.tencent.mm.plugin.appbrand.c.a(str, new 2(this, str));
            eVar.iqO.a(new 3(this));
        }
    }

    public a a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, b bVar, b bVar2) {
        if (bVar == null || cVar == null) {
            return a.ajB();
        }
        com.tencent.mm.plugin.appbrand.b.a aas = cVar.YQ().iqO.iGV.aas();
        int a = a(cVar, bVar);
        String appId = cVar.getAppId();
        if (a == 6) {
            a.a(cVar.YQ(), bVar);
            return a.ajB();
        } else if (a == 1) {
            if (!(cVar instanceof j) || aas != com.tencent.mm.plugin.appbrand.b.a.iGS || !com.tencent.mm.compatible.loader.a.a(m.jcn, bVar.getClass())) {
                return a.ajC();
            }
            return new a(2, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[]{bVar.getName(), aas.name().toLowerCase(), "permission ok", "network api interrupted in suspend state"}));
        } else if (a == 4) {
            if (b.bx(appId, bVar.getName())) {
                return a.ajC();
            }
            b.a(appId, bVar.getName(), new 4(this, bVar2));
            return a.ajF();
        } else if (a == 7) {
            boolean z;
            com.tencent.mm.sdk.d.d dVar = this.irP.iqO.iGV;
            switch (7.iGZ[dVar.aas().ordinal()]) {
                case 1:
                    z = true;
                    break;
                case 2:
                case 3:
                    z = false;
                    break;
                case 4:
                    z = ((Boolean) new c$5(dVar).b(new af(dVar.xiR.getLooper()))).booleanValue();
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                return a.ajC();
            }
            return new a(2, String.format(Locale.US, "fail: jsapi has no permission, event=%s, runningState=%s, permissionMsg=%s, detail=%s", new Object[]{bVar.getName(), aas.name().toLowerCase(), "permission ok", "jsapi permission required playing audio but current not playing audio in background state"}));
        } else if (a != 8) {
            return a.ajB();
        } else {
            if (bVar2 != null) {
                synchronized (this.jGH) {
                    this.jGH.addLast(bVar2);
                }
            }
            return a.ajF();
        }
    }
}
