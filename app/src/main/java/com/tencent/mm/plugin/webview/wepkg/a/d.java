package com.tencent.mm.plugin.webview.wepkg.a;

import android.database.Cursor;
import com.tencent.mm.by.h;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgVersion;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.List;

public class d extends i<c> {
    public static final String[] gJN = new String[]{i.a(c.iGc, "WepkgVersion")};
    private static volatile d tLD = null;
    private final h hhp;
    public final boolean iYd;

    public static d bVa() {
        if (!ar.Hj()) {
            return new d(null);
        }
        if (tLD == null) {
            synchronized (d.class) {
                if (tLD == null || !tLD.iYd) {
                    ar.Hg();
                    tLD = new d(c.EV());
                }
            }
        }
        return tLD;
    }

    private d(h hVar) {
        super(hVar, c.iGc, "WepkgVersion", c.fMK);
        this.hhp = hVar;
        this.iYd = hVar != null;
        if (!this.iYd) {
            x.e("MicroMsg.Wepkg.WepkgVersionStorage", "storage can not work!!!");
        }
    }

    public final c PR(String str) {
        if (!this.iYd || bh.ov(str)) {
            return null;
        }
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=?", new Object[]{"WepkgVersion", "pkgId"}), new String[]{str});
        if (rawQuery.moveToFirst()) {
            c cVar = new c();
            cVar.b(rawQuery);
            rawQuery.close();
            x.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgid exist record in DB, pkgid:%s, version:%s", new Object[]{cVar.field_pkgId, cVar.field_version});
            return cVar;
        }
        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgid pkgid:%s, no record in DB", new Object[]{str});
        rawQuery.close();
        return null;
    }

    public final c PS(String str) {
        if (!this.iYd || bh.ov(str)) {
            return null;
        }
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=? and %s=0", new Object[]{"WepkgVersion", "pkgId", "disable"}), new String[]{str});
        if (rawQuery.moveToFirst()) {
            c cVar = new c();
            cVar.b(rawQuery);
            rawQuery.close();
            x.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgidWithAble exist record in DB, pkgid:%s, version:%s, disableWvCache:%s, clearPkgTime:%s, checkIntervalTime:%s, domain:%s, bigPackageReady:%s, preloadFilesReady:%s, preloadFilesAtomic:%s, disable:%s", new Object[]{cVar.field_pkgId, cVar.field_version, Boolean.valueOf(cVar.field_disableWvCache), Long.valueOf(cVar.field_clearPkgTime), Long.valueOf(cVar.field_checkIntervalTime), cVar.field_domain, Boolean.valueOf(cVar.field_bigPackageReady), Boolean.valueOf(cVar.field_preloadFilesReady), Boolean.valueOf(cVar.field_preloadFilesAtomic), Boolean.valueOf(cVar.field_disable)});
            cVar.field_accessTime = com.tencent.mm.plugin.webview.wepkg.utils.d.alI();
            super.c(cVar, new String[0]);
            return cVar;
        }
        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgidWithAble pkgid:%s, no record in DB", new Object[]{str});
        rawQuery.close();
        return null;
    }

    public final List<WepkgVersion> bVb() {
        List<WepkgVersion> list = null;
        if (this.iYd) {
            Cursor rawQuery = rawQuery(String.format("select * from %s where %s < ? - %s", new Object[]{"WepkgVersion", "accessTime", "clearPkgTime"}), new String[]{String.valueOf(com.tencent.mm.plugin.webview.wepkg.utils.d.alI())});
            x.i("MicroMsg.Wepkg.WepkgVersionStorage", "getNeedCleanRecords queryStr:%s", new Object[]{r1});
            if (rawQuery == null) {
                x.i("MicroMsg.Wepkg.WepkgVersionStorage", "cursor is null");
            } else if (rawQuery.moveToFirst()) {
                list = new ArrayList();
                do {
                    WepkgVersion wepkgVersion = new WepkgVersion();
                    c cVar = new c();
                    cVar.b(rawQuery);
                    wepkgVersion.a(cVar);
                    list.add(wepkgVersion);
                } while (rawQuery.moveToNext());
                rawQuery.close();
                x.i("MicroMsg.Wepkg.WepkgVersionStorage", "record list size:%s", new Object[]{Integer.valueOf(list.size())});
            } else {
                rawQuery.close();
                x.i("MicroMsg.Wepkg.WepkgVersionStorage", "no record");
            }
        }
        return list;
    }

    public final boolean PQ(String str) {
        if (!this.iYd || bh.ov(str)) {
            return false;
        }
        com.tencent.mm.sdk.e.c cVar = new c();
        cVar.field_pkgId = str;
        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "deleteRecordByPkgid pkgid:%s, ret:%s", new Object[]{str, Boolean.valueOf(super.a(cVar, new String[0]))});
        return super.a(cVar, new String[0]);
    }

    public final boolean PT(String str) {
        if (!this.iYd) {
            return false;
        }
        com.tencent.mm.sdk.e.c PR = PR(str);
        if (PR == null) {
            return false;
        }
        PR.field_nextCheckTime = com.tencent.mm.plugin.webview.wepkg.utils.d.alI() + PR.field_checkIntervalTime;
        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateCheckTime pkgid:%s, ret:%s", new Object[]{str, Boolean.valueOf(super.c(PR, new String[0]))});
        return super.c(PR, new String[0]);
    }

    public final boolean a(String str, boolean z, long j, long j2) {
        if (!this.iYd) {
            return false;
        }
        com.tencent.mm.sdk.e.c PR = PR(str);
        if (PR == null) {
            return false;
        }
        PR.field_disableWvCache = z;
        PR.field_clearPkgTime = j;
        PR.field_nextCheckTime = (PR.field_nextCheckTime - PR.field_checkIntervalTime) + j2;
        PR.field_checkIntervalTime = j2;
        PR.field_disable = false;
        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateConfigInfo pkgid:%s, disableWvCache:%s, clearPkgTime:%s, checkIntervalTime:%s, ret:%s", new Object[]{str, Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(super.c(PR, new String[0]))});
        return super.c(PR, new String[0]);
    }

    public final boolean p(String str, String str2, boolean z) {
        if (!this.iYd || bh.ov(str)) {
            return false;
        }
        com.tencent.mm.sdk.e.c PR = PR(str);
        if (PR == null) {
            return false;
        }
        PR.field_bigPackageReady = z;
        PR.field_pkgPath = str2;
        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateBigPackageReady pkgid:%s, pkgPath:%s, bigPackageReady:%b, ret:%s", new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(super.c(PR, new String[0]))});
        return super.c(PR, new String[0]);
    }

    public final boolean aS(String str, boolean z) {
        if (!this.iYd || bh.ov(str)) {
            return false;
        }
        com.tencent.mm.sdk.e.c PR = PR(str);
        if (PR == null) {
            return false;
        }
        PR.field_preloadFilesReady = z;
        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "updatePreloadFilesReady pkgid:%s, preloadFilesReady:%b, ret:%s", new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(super.c(PR, new String[0]))});
        return super.c(PR, new String[0]);
    }

    public final boolean PU(String str) {
        if (!this.iYd || bh.ov(str)) {
            return false;
        }
        boolean fx = fx("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[]{"WepkgVersion", "autoDownloadCount", "autoDownloadCount", "pkgId", str}));
        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addAutoDownloadCount ret:%s", new Object[]{Boolean.valueOf(fx)});
        return true;
    }

    public final boolean PV(String str) {
        if (!this.iYd || bh.ov(str)) {
            return false;
        }
        com.tencent.mm.sdk.e.c PR = PR(str);
        if (PR == null) {
            return true;
        }
        PR.field_disable = true;
        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "setWepkgDisable pkgid:%s, ret:%s", new Object[]{str, Boolean.valueOf(super.c(PR, new String[0]))});
        return super.c(PR, new String[0]);
    }

    public final boolean PW(String str) {
        if (!this.iYd || bh.ov(str)) {
            return false;
        }
        com.tencent.mm.sdk.e.c PR = PR(str);
        if (PR == null) {
            return false;
        }
        PR.field_createTime = 0;
        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateCreateTimeToZero pkgid:%s, ret:%s", new Object[]{str, Boolean.valueOf(super.c(PR, new String[0]))});
        return super.c(PR, new String[0]);
    }
}
