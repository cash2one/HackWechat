package com.tencent.mm.permission;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.e.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.lo;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import java.util.ArrayList;
import java.util.List;

class b$1 extends c<lo> {
    final /* synthetic */ b ibN;

    b$1(b bVar) {
        this.ibN = bVar;
        this.xen = lo.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        lo loVar = (lo) bVar;
        if (true == loVar.fCX.fCZ) {
            if (!b.iU(loVar.fCX.type)) {
                if (a.gGY == null) {
                    List<a.b> arrayList = new ArrayList();
                    List<a.a> arrayList2 = new ArrayList();
                    a.a(e.gZK + "permissioncfg.cfg", arrayList, arrayList2);
                    PInt pInt = new PInt(0);
                    PBool pBool = new PBool();
                    for (a.b bVar2 : arrayList) {
                        pInt.value = 0;
                        pBool.value = true;
                        if (a.a(Build.MANUFACTURER, bVar2.gHd, pInt, pBool) && a.a(Build.MODEL, bVar2.model, pInt, pBool)) {
                            a.a(VERSION.RELEASE, bVar2.version, pInt, pBool);
                        }
                        if (pBool.value && pInt.value > 0) {
                            a.gGY = Boolean.valueOf(1 == bVar2.gHb);
                        }
                    }
                    if (a.gGY == null || true != a.gGY.booleanValue()) {
                        for (PackageInfo packageInfo : a.bh(false)) {
                            for (a.a aVar : arrayList2) {
                                pInt.value = 0;
                                pBool.value = true;
                                if (a.a(packageInfo.packageName, aVar.ffw, pInt, pBool)) {
                                    if (aVar.gGZ == 0 && aVar.gHa == 0) {
                                        pBool.value = true;
                                    } else if (aVar.gGZ > packageInfo.versionCode || aVar.gHa < packageInfo.versionCode) {
                                        pBool.value = false;
                                    } else {
                                        pInt.value++;
                                        pBool.value = true;
                                    }
                                }
                                if (pBool.value && pInt.value > 0) {
                                    a.gGY = Boolean.valueOf(1 == aVar.gHb);
                                }
                            }
                            if (a.gGY != null && true == a.gGY.booleanValue()) {
                                break;
                            }
                        }
                        if (a.gGY == null) {
                            a.gGY = Boolean.valueOf(false);
                        }
                    }
                }
                if (a.gGY.booleanValue()) {
                    loVar.fCY.fDb = b.t(loVar.fCX.type, true);
                    b.b(loVar.fCX.type, false, true);
                }
            }
            loVar.fCY.fDb = false;
            b.b(loVar.fCX.type, true, false);
        } else {
            loVar.fCY.fDb = false;
            b.b(loVar.fCX.type, false, loVar.fCX.fDa);
        }
        return false;
    }
}
