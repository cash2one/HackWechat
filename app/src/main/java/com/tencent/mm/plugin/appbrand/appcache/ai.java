package com.tencent.mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import android.database.Cursor;
import com.tencent.mm.by.h;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.d;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.e;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.car;
import com.tencent.mm.protocal.c.cbc;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class ai {
    public static final String[] iGr = new String[]{i.a(ae.iGc, "AppBrandWxaPkgManifestRecord")};
    public final h iGs;
    public final b iGt;

    public ai(h hVar) {
        this.iGs = hVar;
        this.iGt = new b(hVar);
    }

    public final int[] pM(String str) {
        if (bh.ov(str)) {
            return null;
        }
        if (!d$a.jv(0)) {
            return null;
        }
        List<ae> a = a(str, 0, a.iGu, "version");
        if (bh.cA(a)) {
            return null;
        }
        int[] iArr = new int[a.size()];
        int i = 0;
        for (ae aeVar : a) {
            int i2 = i + 1;
            iArr[i] = aeVar.field_version;
            i = i2;
        }
        return iArr;
    }

    final List<ae> a(String str, int i, a aVar, String... strArr) {
        if (bh.ov(str)) {
            return Collections.emptyList();
        }
        Cursor a = this.iGs.a("AppBrandWxaPkgManifestRecord", strArr, String.format(Locale.US, "%s=? and %s=? ", new Object[]{"appId", "debugType"}), new String[]{str, String.valueOf(i)}, null, null, "version " + aVar.name(), 2);
        if (a == null) {
            return Collections.emptyList();
        }
        if (a.moveToFirst()) {
            List<ae> linkedList = new LinkedList();
            do {
                ae aeVar = new ae();
                aeVar.b(a);
                aeVar.field_appId = str;
                aeVar.field_debugType = i;
                linkedList.add(aeVar);
            } while (a.moveToNext());
            a.close();
            return linkedList;
        }
        a.close();
        return Collections.emptyList();
    }

    public final ae a(String str, int i, String... strArr) {
        ae aeVar = null;
        if (!bh.ov(str)) {
            String str2;
            String[] strArr2;
            if (d$a.jv(i)) {
                str2 = "version desc";
            } else if (d$a.hf(i)) {
                str2 = "createTime desc";
            } else {
                throw new RuntimeException("Illegal pkgType " + i);
            }
            h hVar = this.iGs;
            String str3 = "AppBrandWxaPkgManifestRecord";
            if (bh.G(strArr)) {
                strArr2 = null;
            } else {
                strArr2 = strArr;
            }
            Cursor query = hVar.query(str3, strArr2, String.format(Locale.US, "%s=? and %s=?", new Object[]{"appId", "debugType"}), new String[]{str, String.valueOf(i)}, null, null, str2);
            if (query != null) {
                if (query.moveToFirst()) {
                    aeVar = new ae();
                    aeVar.b(query);
                    aeVar.field_appId = str;
                    aeVar.field_debugType = i;
                }
                query.close();
            }
        }
        return aeVar;
    }

    final boolean a(car com_tencent_mm_protocal_c_car, PInt pInt) {
        if (com_tencent_mm_protocal_c_car.version < 0 || bh.ov(com_tencent_mm_protocal_c_car.url) || bh.ov(com_tencent_mm_protocal_c_car.fqR)) {
            x.e("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, invalid resp: version( %d ), url( %s ), md5( %s )", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_car.version), com_tencent_mm_protocal_c_car.url, com_tencent_mm_protocal_c_car.fqR});
            return false;
        }
        if (com_tencent_mm_protocal_c_car.wFT > 0) {
            x.i("MicroMsg.AppBrandWxaPkgStorage", "flushLibPkgVersionInfo, delete manifest.version > %d, ret = %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_car.version), Integer.valueOf(this.iGs.delete("AppBrandWxaPkgManifestRecord", String.format("%s=? and %s=? and %s>?", new Object[]{"appId", "debugType", "version"}), new String[]{"@LibraryAppId", "0", String.valueOf(com_tencent_mm_protocal_c_car.version)}))});
            pInt.value = r0;
        }
        return a("@LibraryAppId", 0, com_tencent_mm_protocal_c_car.version, com_tencent_mm_protocal_c_car.fqR, com_tencent_mm_protocal_c_car.url);
    }

    @SuppressLint({"DefaultLocale"})
    final List<ae> q(String str, int i, int i2) {
        List<ae> list = null;
        if (!bh.ov(str)) {
            Object format;
            if (d$a.jv(0)) {
                format = String.format("order by %s desc", new Object[]{"version"});
            } else {
                String format2 = String.format("order by %s desc", new Object[]{"createTime"});
            }
            String format3 = String.format("limit %d offset %d", new Object[]{Integer.valueOf(Integer.MAX_VALUE), Integer.valueOf(2)});
            Cursor a = this.iGs.a("AppBrandWxaPkgManifestRecord", new String[]{"pkgPath", "version"}, String.format("%s=? and %s=? %s %s", new Object[]{"appId", "debugType", format, format3}), new String[]{str, "0"}, null, null, null, 2);
            if (a != null) {
                list = new ArrayList();
                if (a.moveToFirst()) {
                    do {
                        ae aeVar = new ae();
                        aeVar.field_appId = str;
                        aeVar.field_debugType = 0;
                        aeVar.b(a);
                        list.add(aeVar);
                    } while (a.moveToNext());
                }
                a.close();
            }
        }
        return list;
    }

    public final boolean a(String str, int i, String str2, String str3, long j, long j2) {
        if (bh.ov(str)) {
            x.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaDebugAppVersionInfo, null or nil appId");
            return false;
        }
        x.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaDebugAppVersionInfo, appId %s, type %d, url %s, md5 %s, lifespan[%d, %d]", new Object[]{str, Integer.valueOf(i), str2, str3, Long.valueOf(j), Long.valueOf(j2)});
        if (i == 999) {
            str = "@LibraryAppId";
        }
        ae a = a(str, 1, i, new String[0]);
        if (a == null) {
            ae aeVar = new ae();
            aeVar.field_appId = str;
            aeVar.field_version = 1;
            aeVar.field_debugType = i;
            aeVar.field_downloadURL = str2;
            aeVar.field_versionMd5 = str3;
            aeVar.field_versionState = 0;
            aeVar.field_startTime = j;
            aeVar.field_endTime = j2;
            aeVar.field_createTime = bh.Wo();
            b(aeVar);
            return true;
        }
        if (bh.ov(str3) || bh.ov(a.field_versionMd5) || str3.equals(a.field_versionMd5)) {
            boolean z = false;
        } else {
            int i2 = 1;
        }
        if (str2.equals(a.field_downloadURL)) {
            boolean z2 = false;
        } else {
            int i3 = 1;
        }
        if (i2 != 0) {
            a.field_downloadURL = str2;
            b.deleteFile(a.field_pkgPath);
            a.field_pkgPath = null;
            a.field_createTime = bh.Wo();
            a.field_versionMd5 = str3;
            a.field_startTime = j;
            a.field_endTime = j2;
            c(a);
            r(str, i, 1);
            return true;
        } else if (i3 == 0) {
            return false;
        } else {
            a.field_downloadURL = str2;
            a.field_startTime = j;
            a.field_endTime = j2;
            c(a);
            return false;
        }
    }

    public final boolean a(ae aeVar) {
        boolean z = !bh.ov(aeVar.field_appId) && this.iGt.a(aeVar, ae.iGb);
        if (z) {
            r(aeVar.field_appId, aeVar.field_debugType, aeVar.field_version);
        }
        return z;
    }

    public final String ah(String str, int i) {
        ae a = a(str, i, "downloadURL");
        return a == null ? "" : a.field_downloadURL;
    }

    final int ai(String str, int i) {
        if (bh.ov(str) || !d$a.jv(i)) {
            return 0;
        }
        ae a = a(str, i, "version");
        if (a != null) {
            return a.field_version;
        }
        return 0;
    }

    private boolean a(String str, int i, int i2, String str2, String str3) {
        if (!d$a.jv(i)) {
            return false;
        }
        x.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo for release, appId %s, type %d, version %d, md5 %s, url %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2, str3});
        int ai = ai(str, i);
        if (i2 < ai) {
            x.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, newVersion( %d ) < curMaxVersion( %d ), skip", new Object[]{Integer.valueOf(i2), Integer.valueOf(ai)});
            return false;
        } else if ("@LibraryAppId".equals(str) && i2 == y.VERSION) {
            x.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, given version == local library version %d, skip", new Object[]{Integer.valueOf(y.VERSION)});
            return false;
        } else {
            ae a = a(str, i2, i, new String[0]);
            boolean z = false;
            if (a == null) {
                ae aeVar = new ae();
                aeVar.field_appId = str;
                aeVar.field_version = i2;
                aeVar.field_versionMd5 = str2;
                aeVar.field_downloadURL = str3;
                aeVar.field_debugType = i;
                x.i("MicroMsg.AppBrandWxaPkgStorage", "flushWxaPkgVersionInfo, insert record %b, version %d, url %s, md5 %s", new Object[]{Boolean.valueOf(b(aeVar)), Integer.valueOf(aeVar.field_version), aeVar.field_downloadURL, aeVar.field_versionMd5});
                return b(aeVar);
            }
            Object obj;
            String str4 = a.field_downloadURL;
            String str5 = a.field_versionMd5;
            if (!bh.ou(a.field_versionMd5).equals(str2)) {
                a.field_versionMd5 = str2;
                a.field_version = i2;
                a.field_downloadURL = str3;
                obj = 1;
            } else if (bh.ov(str3) || str3.equals(a.field_downloadURL)) {
                obj = null;
            } else {
                a.field_downloadURL = str3;
                int i3 = 1;
            }
            if (obj != null) {
                z = c(a);
            }
            String str6 = "MicroMsg.AppBrandWxaPkgStorage";
            String str7 = "flushWxaPkgVersionInfo, update record %b, oldVersion %d, newVersion %d, oldURL %s, newURL %s, oldMd5 %s, newMd5 %s";
            Object[] objArr = new Object[7];
            boolean z2 = obj != null && z;
            objArr[0] = Boolean.valueOf(z2);
            objArr[1] = Integer.valueOf(ai);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = str4;
            objArr[4] = str3;
            objArr[5] = str5;
            objArr[6] = str2;
            x.i(str6, str7, objArr);
            if (obj == null || !z) {
                return false;
            }
            return true;
        }
    }

    public final boolean a(String str, cbc com_tencent_mm_protocal_c_cbc, int i) {
        if (bh.ov(str)) {
            x.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaAppVersionInfo, args invalid appId = %s, vInfo = %s", new Object[]{str, com_tencent_mm_protocal_c_cbc});
            return false;
        }
        return a(str, i, com_tencent_mm_protocal_c_cbc.vNa, com_tencent_mm_protocal_c_cbc.xas, com_tencent_mm_protocal_c_cbc.xat);
    }

    public final boolean a(String str, d dVar) {
        if (bh.ov(str) || dVar == null) {
            x.e("MicroMsg.AppBrandWxaPkgStorage", "flushWxaAppVersionInfoV2, args invalid appId = %s, vInfo = %s", new Object[]{str, dVar});
            return false;
        }
        a(str, 0, dVar.fIm, dVar.iPI);
        return a(str, 0, dVar.fIm, dVar.iPG, null);
    }

    public final ae a(String str, int i, int i2, String... strArr) {
        ae aeVar = null;
        String str2 = "";
        for (String str3 : ae.iGb) {
            str2 = str2 + str3 + "=? and ";
        }
        Cursor a = this.iGs.a("AppBrandWxaPkgManifestRecord", bh.G(strArr) ? null : strArr, str2 + "1=1", new String[]{str, String.valueOf(i), String.valueOf(i2)}, null, null, null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                aeVar = new ae();
                aeVar.b(a);
                aeVar.field_appId = str;
            }
            a.close();
        }
        return aeVar;
    }

    private boolean b(ae aeVar) {
        x.i("MicroMsg.AppBrandWxaPkgStorage", "insertManifest, appId %s, type %d, version %d", new Object[]{aeVar.field_appId, Integer.valueOf(aeVar.field_debugType), Integer.valueOf(aeVar.field_version)});
        return this.iGt.b(aeVar);
    }

    private boolean c(ae aeVar) {
        x.i("MicroMsg.AppBrandWxaPkgStorage", "updateManifest, appId %s, version %d, pkgType %d", new Object[]{aeVar.field_appId, Integer.valueOf(aeVar.field_version), Integer.valueOf(aeVar.field_debugType)});
        return this.iGt.c(aeVar, ae.iGb);
    }

    public final void d(List<String> list, List<Integer> list2) {
        if (list.size() > 0 && list2.size() > 0 && list.size() == list2.size()) {
            x.i("MicroMsg.AppBrandWxaPkgStorage", "batchDeleteAppPkg, size %d", new Object[]{Integer.valueOf(list.size())});
            long dz = this.iGs.dz(Thread.currentThread().getId());
            for (int i = 0; i < list.size(); i++) {
                aj((String) list.get(i), ((Integer) list2.get(i)).intValue());
            }
            this.iGs.fS(dz);
        }
    }

    public final void aj(String str, int i) {
        if (!bh.ov(str)) {
            x.i("MicroMsg.AppBrandWxaPkgStorage", "deleteAppPkg, appId %s, debugType %d", new Object[]{str, Integer.valueOf(i)});
            String format = String.format("%s=? and %s=?", new Object[]{"appId", "debugType"});
            String[] strArr = new String[]{str, String.valueOf(i)};
            Cursor a = this.iGs.a("AppBrandWxaPkgManifestRecord", new String[]{"pkgPath"}, format, strArr, null, null, null, 2);
            if (a == null) {
                return;
            }
            if (a.moveToFirst()) {
                List<String> linkedList = new LinkedList();
                do {
                    linkedList.add(a.getString(0));
                } while (a.moveToNext());
                a.close();
                for (String deleteFile : linkedList) {
                    b.deleteFile(deleteFile);
                }
                this.iGs.delete("AppBrandWxaPkgManifestRecord", format, strArr);
                r(str, i, -1);
                return;
            }
            a.close();
        }
    }

    public final void d(ae aeVar) {
        this.iGt.a(aeVar);
    }

    public final boolean a(String str, int i, int i2, List<e> list) {
        if (bh.ov(str) || bh.cA(list)) {
            return false;
        }
        int i3;
        int i4;
        if (d$a.jv(i)) {
            i3 = i2;
        } else {
            i3 = 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');
        for (e eVar : list) {
            stringBuilder.append(',').append(eVar.name).append("::").append(eVar.fqR);
        }
        stringBuilder.append('}');
        x.i("MicroMsg.AppBrandWxaPkgStorage", "updateModuleList, appId %s, type %d, version %d, list %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i3), stringBuilder.toString()});
        String format = String.format(Locale.US, "where %s like '%s$%%' and %s=%d and %s=%d", new Object[]{"appId", str, "debugType", Integer.valueOf(i), "version", Integer.valueOf(i3)});
        Cursor a = this.iGs.a(String.format(Locale.US, "select count(*) from %s %s", new Object[]{"AppBrandWxaPkgManifestRecord", format}), null, 2);
        if (a == null) {
            i4 = 0;
        } else {
            if (a.moveToFirst()) {
                i4 = a.getInt(0);
            } else {
                i4 = 0;
            }
            a.close();
        }
        if (i4 != 0 && i4 == list.size()) {
            return false;
        }
        this.iGs.fx("AppBrandWxaPkgManifestRecord", String.format(Locale.US, "delete from %s %s", new Object[]{"AppBrandWxaPkgManifestRecord", format}));
        for (e eVar2 : list) {
            format = new o(str, eVar2.name).toString();
            if (d$a.jv(i)) {
                a(format, i, i3, eVar2.fqR, null);
            } else {
                a(format, i, null, eVar2.fqR, 0, 0);
            }
        }
        return true;
    }

    private boolean r(String str, int i, int i2) {
        Locale locale = Locale.US;
        String str2 = "where %s like '%s$%%' and %s=%d and %s";
        Object[] objArr = new Object[5];
        objArr[0] = "appId";
        objArr[1] = str;
        objArr[2] = "debugType";
        objArr[3] = Integer.valueOf(i);
        objArr[4] = i2 > 0 ? "version=" + i2 : "1=1";
        String format = String.format(locale, str2, objArr);
        format = String.format(Locale.US, "delete from %s %s", new Object[]{"AppBrandWxaPkgManifestRecord", format});
        x.i("MicroMsg.AppBrandWxaPkgStorage", "deleteModuleList, appId %s, type %d, version %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
        return this.iGs.fx("AppBrandWxaPkgManifestRecord", format);
    }
}
