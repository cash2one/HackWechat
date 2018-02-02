package com.tencent.mm.plugin.webview.wepkg.model;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.webview.wepkg.a.a;
import com.tencent.mm.plugin.webview.wepkg.a.b;
import com.tencent.mm.plugin.webview.wepkg.a.c;
import com.tencent.mm.plugin.webview.wepkg.a.d;
import com.tencent.mm.plugin.webview.wepkg.model.g.2;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.List;

public class WepkgCrossProcessTask extends BaseWepkgProcessTask {
    public static final Creator<WepkgCrossProcessTask> CREATOR = new 1();
    public Runnable jcI;
    public int pK;
    public WepkgVersion tMS;
    public List<WepkgVersion> tMT;
    public WepkgPreloadFile tMU;
    public List<WepkgPreloadFile> tMV;
    public String tMW;

    public WepkgCrossProcessTask() {
        this.pK = -1;
        this.tMS = new WepkgVersion();
        this.tMT = new ArrayList();
        this.tMU = new WepkgPreloadFile();
        this.tMV = new ArrayList();
    }

    private WepkgCrossProcessTask(Parcel parcel) {
        f(parcel);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Yr() {
        WepkgCrossProcessTask wepkgCrossProcessTask;
        String str = null;
        boolean z = false;
        boolean z2 = true;
        d bVa;
        boolean fx;
        boolean fx2;
        String str2;
        c cVar;
        b bUZ;
        String str3;
        String str4;
        b bUZ2;
        switch (this.pK) {
            case 1001:
                wepkgCrossProcessTask = this;
            case 2001:
                if (this.tMS == null || bh.ov(this.tMS.tNm)) {
                    bVa = d.bVa();
                    if (bVa.iYd) {
                        fx = bVa.fx("WepkgVersion", String.format("delete from %s", new Object[]{"WepkgVersion"}));
                        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord clearWepkg ret:%s", new Object[]{Boolean.valueOf(fx)});
                        fx2 = bVa.fx("WepkgPreloadFiles", String.format("delete from %s", new Object[]{"WepkgPreloadFiles"}));
                        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgPreloadFilesRecord clearWepkg ret:%s", new Object[]{Boolean.valueOf(fx2)});
                    }
                    com.tencent.mm.plugin.webview.wepkg.utils.d.Dm().F(new 2());
                    break;
                }
                str = this.tMS.tNm;
                d.bVa().PQ(str);
                b.bUZ().PQ(str);
                g.Qf(str);
                wepkgCrossProcessTask = this;
                break;
            case 2002:
                if (!(this.tMS == null || bh.ov(this.tMS.tNm))) {
                    str = this.tMS.tNm;
                    d.bVa().PQ(str);
                    b.bUZ().PQ(str);
                    bVa = d.bVa();
                    WepkgVersion wepkgVersion = this.tMS;
                    com.tencent.mm.sdk.e.c cVar2 = new c();
                    cVar2.field_pkgId = wepkgVersion.tNm;
                    cVar2.field_appId = wepkgVersion.appId;
                    cVar2.field_version = wepkgVersion.version;
                    cVar2.field_pkgPath = wepkgVersion.iEa;
                    cVar2.field_disableWvCache = wepkgVersion.tNC;
                    cVar2.field_clearPkgTime = wepkgVersion.tND;
                    cVar2.field_checkIntervalTime = wepkgVersion.tNE;
                    cVar2.field_packMethod = wepkgVersion.tNF;
                    cVar2.field_domain = wepkgVersion.fMh;
                    cVar2.field_md5 = wepkgVersion.fqR;
                    cVar2.field_downloadUrl = wepkgVersion.downloadUrl;
                    cVar2.field_pkgSize = wepkgVersion.tNG;
                    cVar2.field_downloadNetType = wepkgVersion.tMZ;
                    cVar2.field_nextCheckTime = wepkgVersion.tNH;
                    cVar2.field_createTime = wepkgVersion.hVE;
                    cVar2.field_charset = wepkgVersion.charset;
                    cVar2.field_bigPackageReady = wepkgVersion.tNI;
                    cVar2.field_preloadFilesReady = wepkgVersion.tNJ;
                    cVar2.field_preloadFilesAtomic = wepkgVersion.tNK;
                    cVar2.field_totalDownloadCount = wepkgVersion.tNL;
                    if (bVa.iYd && !bh.ov(cVar2.field_pkgId)) {
                        if (bVa.PR(cVar2.field_pkgId) == null) {
                            cVar2.field_nextCheckTime = com.tencent.mm.plugin.webview.wepkg.utils.d.alI() + cVar2.field_checkIntervalTime;
                            cVar2.field_createTime = com.tencent.mm.plugin.webview.wepkg.utils.d.alI();
                            cVar2.field_accessTime = com.tencent.mm.plugin.webview.wepkg.utils.d.alI();
                            fx2 = bVa.b(cVar2);
                            x.i("MicroMsg.Wepkg.WepkgVersionStorage", "insertPkgVersion pkgid:%s, version:%s, ret:%s", new Object[]{cVar2.field_pkgId, cVar2.field_version, Boolean.valueOf(fx2)});
                        } else {
                            cVar2.field_nextCheckTime = com.tencent.mm.plugin.webview.wepkg.utils.d.alI() + cVar2.field_checkIntervalTime;
                            fx2 = bVa.a(cVar2);
                            x.i("MicroMsg.Wepkg.WepkgVersionStorage", "replacePkgVersion pkgid:%s, version:%s, ret:%s", new Object[]{cVar2.field_pkgId, cVar2.field_version, Boolean.valueOf(fx2)});
                        }
                    }
                    if (!bh.cA(this.tMV)) {
                        for (WepkgPreloadFile wepkgPreloadFile : this.tMV) {
                            if (wepkgPreloadFile != null) {
                                b bUZ3 = b.bUZ();
                                com.tencent.mm.sdk.e.c aVar = new a();
                                aVar.field_key = wepkgPreloadFile.aAM;
                                aVar.field_pkgId = wepkgPreloadFile.tNm;
                                aVar.field_version = wepkgPreloadFile.version;
                                aVar.field_filePath = wepkgPreloadFile.filePath;
                                aVar.field_rid = wepkgPreloadFile.tMX;
                                aVar.field_mimeType = wepkgPreloadFile.mimeType;
                                aVar.field_md5 = wepkgPreloadFile.fqR;
                                aVar.field_downloadUrl = wepkgPreloadFile.downloadUrl;
                                aVar.field_size = wepkgPreloadFile.size;
                                aVar.field_downloadNetType = wepkgPreloadFile.tMZ;
                                aVar.field_completeDownload = wepkgPreloadFile.tNn;
                                aVar.field_createTime = wepkgPreloadFile.hVE;
                                if (bUZ3.iYd) {
                                    if (bUZ3.eU(aVar.field_pkgId, aVar.field_rid) == null) {
                                        aVar.field_createTime = com.tencent.mm.plugin.webview.wepkg.utils.d.alI();
                                        fx2 = bUZ3.b(aVar);
                                        x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "insertPreloadFile pkgid:%s, version:%s, rid:%s, ret:%s", new Object[]{aVar.field_pkgId, aVar.field_version, aVar.field_rid, Boolean.valueOf(fx2)});
                                    } else {
                                        fx2 = bUZ3.a(aVar);
                                        x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "relacePreloadFile pkgid:%s, version:%s, rid:%s, ret:%s", new Object[]{aVar.field_pkgId, aVar.field_version, aVar.field_rid, Boolean.valueOf(fx2)});
                                    }
                                }
                            }
                        }
                    }
                    wepkgCrossProcessTask = this;
                }
            case 2003:
                if (this.tMS != null) {
                    d bVa2 = d.bVa();
                    if (bVa2.iYd) {
                        Cursor rawQuery = bVa2.rawQuery(String.format("select * from %s where %s=0 and %s=1 and %s<1 and %s<?", new Object[]{"WepkgVersion", "bigPackageReady", "preloadFilesAtomic", "autoDownloadCount", "packageDownloadCount"}), new String[]{TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL});
                        if (rawQuery == null) {
                            str2 = null;
                        } else if (rawQuery.moveToFirst()) {
                            r1 = rawQuery.getCount();
                            if (r1 > 1) {
                                r1 = bh.eF(r1 - 1, 0);
                            } else {
                                r1 = 0;
                            }
                            rawQuery.move(r1);
                            cVar = new c();
                            cVar.b(rawQuery);
                            rawQuery.close();
                            bVa2.PU(cVar.field_pkgId);
                            x.i("MicroMsg.Wepkg.WepkgVersionStorage", "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, bigPackageReady:false, preloadFilesAtomic:true", new Object[]{cVar.field_pkgId, cVar.field_version});
                            str2 = cVar.field_pkgId;
                        } else {
                            rawQuery.close();
                            rawQuery = bVa2.rawQuery(String.format("select * from %s where %s=0 and %s<1 and %s<?", new Object[]{"WepkgVersion", "bigPackageReady", "autoDownloadCount", "packageDownloadCount"}), new String[]{TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL});
                            if (rawQuery == null) {
                                str2 = null;
                            } else if (rawQuery.moveToFirst()) {
                                r1 = rawQuery.getCount();
                                if (r1 > 1) {
                                    r1 = bh.eF(r1 - 1, 0);
                                } else {
                                    r1 = 0;
                                }
                                rawQuery.move(r1);
                                cVar = new c();
                                cVar.b(rawQuery);
                                rawQuery.close();
                                bVa2.PU(cVar.field_pkgId);
                                x.i("MicroMsg.Wepkg.WepkgVersionStorage", "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, bigPackageReady:false, preloadFilesAtomic:false", new Object[]{cVar.field_pkgId, cVar.field_version});
                                str2 = cVar.field_pkgId;
                            } else {
                                rawQuery.close();
                                x.i("MicroMsg.Wepkg.WepkgVersionStorage", "randomNeedDownloadPkgid no download record in DB");
                                str2 = null;
                            }
                        }
                    } else {
                        str2 = null;
                    }
                    if (bh.ov(str2)) {
                        bUZ = b.bUZ();
                        if (bUZ.iYd) {
                            Cursor rawQuery2 = bUZ.rawQuery(String.format("select * from %s where %s=0 and %s<1 and %s<?", new Object[]{"WepkgPreloadFiles", "completeDownload", "autoDownloadCount", "fileDownloadCount"}), new String[]{TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL});
                            if (rawQuery2 != null) {
                                if (rawQuery2.moveToFirst()) {
                                    int count = rawQuery2.getCount();
                                    if (count > 1) {
                                        count = bh.eF(count - 1, 0);
                                    } else {
                                        count = 0;
                                    }
                                    rawQuery2.move(count);
                                    a aVar2 = new a();
                                    aVar2.b(rawQuery2);
                                    rawQuery2.close();
                                    str3 = aVar2.field_pkgId;
                                    str4 = aVar2.field_rid;
                                    if (!(!bUZ.iYd || bh.ov(str3) || bh.ov(str4))) {
                                        Object[] objArr = new Object[]{"WepkgPreloadFiles", "autoDownloadCount", "autoDownloadCount", "pkgId", str3, "rid", str4};
                                        fx = bUZ.fx("WepkgPreloadFiles", String.format("update %s set %s=%s+1 where %s='%s' and %s='%s'", objArr));
                                        x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord addAutoDownloadCount ret:%s", new Object[]{Boolean.valueOf(fx)});
                                    }
                                    x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, rid:%s", new Object[]{aVar2.field_pkgId, aVar2.field_version, aVar2.field_rid});
                                    str = aVar2.field_pkgId;
                                } else {
                                    rawQuery2.close();
                                    x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "randomNeedDownloadPkgid no download record in DB");
                                }
                            }
                        }
                    } else {
                        str = str2;
                    }
                    if (bh.ov(str)) {
                        d bVa3 = d.bVa();
                        if (bVa3.iYd) {
                            boolean fx3 = bVa3.fx("WepkgVersion", String.format("update %s set %s=0", new Object[]{"WepkgVersion", "autoDownloadCount"}));
                            x.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord resetAutoDownloadCount ret:%s", new Object[]{Boolean.valueOf(fx3)});
                            fx = bVa3.fx("WepkgPreloadFiles", String.format("update %s set %s=0", new Object[]{"WepkgPreloadFiles", "autoDownloadCount"}));
                            x.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgPreloadFilesRecord resetAutoDownloadCount ret:%s", new Object[]{Boolean.valueOf(fx)});
                        }
                    }
                    this.tMS.tNm = str;
                    break;
                }
                break;
            case TXLiveConstants.PLAY_EVT_PLAY_BEGIN /*2004*/:
                if (this.tMS != null) {
                    z2 = d.bVa().PV(this.tMS.tNm);
                    wepkgCrossProcessTask = this;
                }
                break;
            case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
                this.tMT = d.bVa().bVb();
                wepkgCrossProcessTask = this;
                wepkgCrossProcessTask.fnI = z2;
                break;
            case TXLiveConstants.PLAY_EVT_PLAY_END /*2006*/:
                if (this.tMS != null) {
                    bVa = d.bVa();
                    str2 = this.tMS.tNm;
                    if (bVa.iYd && !bh.ov(str2)) {
                        fx2 = bVa.fx("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[]{"WepkgVersion", "totalDownloadCount", "totalDownloadCount", "pkgId", str2}));
                        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addTotalDownloadCount ret:%s", new Object[]{Boolean.valueOf(fx2)});
                        z = true;
                    }
                    this.fnI = z;
                    break;
                }
                break;
            case 3001:
                if (this.tMS != null) {
                    cVar = d.bVa().PR(this.tMS.tNm);
                    if (cVar == null) {
                        this.tMS = null;
                        break;
                    } else {
                        this.tMS.a(cVar);
                        wepkgCrossProcessTask = this;
                    }
                }
                break;
            case 3002:
                if (this.tMS != null) {
                    cVar = d.bVa().PS(this.tMS.tNm);
                    if (cVar == null) {
                        this.tMS = null;
                        break;
                    } else {
                        this.tMS.a(cVar);
                        wepkgCrossProcessTask = this;
                    }
                }
                break;
            case 3003:
                if (this.tMS != null) {
                    z2 = d.bVa().PT(this.tMS.tNm);
                    wepkgCrossProcessTask = this;
                }
                break;
            case TXLiveConstants.PUSH_WARNING_SERVER_DISCONNECT /*3004*/:
                if (this.tMS != null) {
                    z2 = d.bVa().a(this.tMS.tNm, this.tMS.tNC, this.tMS.tND, this.tMS.tNE);
                    wepkgCrossProcessTask = this;
                }
                break;
            case 3005:
                if (this.tMS != null) {
                    z2 = d.bVa().p(this.tMS.tNm, this.tMS.iEa, this.tMS.tNI);
                    wepkgCrossProcessTask = this;
                }
                break;
            case 3006:
                if (this.tMS != null) {
                    z2 = d.bVa().aS(this.tMS.tNm, this.tMS.tNJ);
                    wepkgCrossProcessTask = this;
                }
                break;
            case 3007:
                if (this.tMS != null) {
                    z2 = d.bVa().PW(this.tMS.tNm);
                    wepkgCrossProcessTask = this;
                }
                break;
            case 3008:
                if (this.tMS != null) {
                    bVa = d.bVa();
                    str2 = this.tMS.tNm;
                    if (!bVa.iYd || bh.ov(str2)) {
                        z2 = false;
                    } else {
                        fx2 = bVa.fx("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[]{"WepkgVersion", "packageDownloadCount", "packageDownloadCount", "pkgId", str2}));
                        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addPackageDownloadCount ret:%s", new Object[]{Boolean.valueOf(fx2)});
                    }
                    this.fnI = z2;
                    break;
                }
                break;
            case 3009:
                if (this.tMS != null) {
                    bVa = d.bVa();
                    str2 = this.tMS.tNm;
                    if (!bVa.iYd || bh.ov(str2)) {
                        z2 = false;
                    } else {
                        fx2 = bVa.fx("WepkgVersion", String.format("update %s set %s=0 where %s='%s'", new Object[]{"WepkgVersion", "packageDownloadCount", "pkgId", str2}));
                        x.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord resetPackageDownloadCount ret:%s", new Object[]{Boolean.valueOf(fx2)});
                    }
                    this.fnI = z2;
                    break;
                }
                break;
            case 4001:
                if (!(this.tMS == null || bh.ov(this.tMS.tNm))) {
                    List arrayList;
                    bUZ = b.bUZ();
                    str3 = this.tMS.tNm;
                    if (bUZ.iYd || !bh.ov(str3)) {
                        Cursor rawQuery3 = bUZ.rawQuery(String.format("select * from %s where %s=? and %s=0", new Object[]{"WepkgPreloadFiles", "pkgId", "completeDownload"}), new String[]{str3});
                        x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getNeedDownloadPreLoadFileList queryStr:%s", new Object[]{str4});
                        if (rawQuery3 == null) {
                            x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "cursor is null");
                        } else if (rawQuery3.moveToFirst()) {
                            arrayList = new ArrayList();
                            do {
                                WepkgPreloadFile wepkgPreloadFile2 = new WepkgPreloadFile();
                                a aVar3 = new a();
                                aVar3.b(rawQuery3);
                                wepkgPreloadFile2.a(aVar3);
                                arrayList.add(wepkgPreloadFile2);
                            } while (rawQuery3.moveToNext());
                            rawQuery3.close();
                            x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "record list size:%s", new Object[]{Integer.valueOf(arrayList.size())});
                        } else {
                            rawQuery3.close();
                            x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "no record");
                        }
                    }
                    this.tMV = arrayList;
                    wepkgCrossProcessTask = this;
                }
            case 4002:
                if (this.tMU != null) {
                    z2 = b.bUZ().f(this.tMU.tNm, this.tMU.tMX, this.tMU.filePath, this.tMU.tNn);
                    wepkgCrossProcessTask = this;
                }
                break;
            case 4003:
                if (this.tMS != null) {
                    this.tMV = b.bUZ().PP(this.tMS.tNm);
                    wepkgCrossProcessTask = this;
                }
                break;
            case 4004:
                if (this.tMU != null) {
                    a eU = b.bUZ().eU(this.tMU.tNm, this.tMU.tMX);
                    if (eU == null) {
                        this.tMU = null;
                        break;
                    } else {
                        this.tMU.a(eU);
                        wepkgCrossProcessTask = this;
                    }
                }
                break;
            case 4005:
                if (this.tMU != null) {
                    bUZ2 = b.bUZ();
                    str2 = this.tMU.tNm;
                    str3 = this.tMU.tMX;
                    if (!bUZ2.iYd || bh.ov(str2) || bh.ov(str3)) {
                        z2 = false;
                    } else {
                        Object[] objArr2 = new Object[]{"WepkgPreloadFiles", "fileDownloadCount", "fileDownloadCount", "pkgId", str2, "rid", str3};
                        fx2 = bUZ2.fx("WepkgPreloadFiles", String.format("update %s set %s=%s+1 where %s='%s' and %s='%s'", objArr2));
                        x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord addFileDownloadCount ret:%s", new Object[]{Boolean.valueOf(fx2)});
                    }
                    this.fnI = z2;
                    break;
                }
                break;
            case 4006:
                if (this.tMU != null) {
                    bUZ2 = b.bUZ();
                    str2 = this.tMU.tNm;
                    if (!bUZ2.iYd || bh.ov(str2)) {
                        z2 = false;
                        wepkgCrossProcessTask = this;
                    } else {
                        fx2 = bUZ2.fx("WepkgPreloadFiles", String.format("update %s set %s=0 where %s='%s'", new Object[]{"WepkgPreloadFiles", "fileDownloadCount", "pkgId", str2}));
                        x.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord resetFileDownloadCount ret:%s", new Object[]{Boolean.valueOf(fx2)});
                        wepkgCrossProcessTask = this;
                    }
                }
                break;
        }
        wepkgCrossProcessTask.fnI = z2;
        Dn();
    }

    public final void Ys() {
        if (this.jcI != null) {
            this.jcI.run();
        }
    }

    public final void j(Parcel parcel) {
        this.pK = parcel.readInt();
        this.tMS = (WepkgVersion) parcel.readParcelable(WepkgVersion.class.getClassLoader());
        if (this.tMT == null) {
            this.tMT = new ArrayList();
        }
        parcel.readList(this.tMT, WepkgVersion.class.getClassLoader());
        this.tMU = (WepkgPreloadFile) parcel.readParcelable(WepkgPreloadFile.class.getClassLoader());
        if (this.tMV == null) {
            this.tMV = new ArrayList();
        }
        parcel.readList(this.tMV, WepkgPreloadFile.class.getClassLoader());
        this.tMW = parcel.readString();
    }

    public final void v(Parcel parcel, int i) {
        parcel.writeInt(this.pK);
        parcel.writeParcelable(this.tMS, i);
        parcel.writeList(this.tMT);
        parcel.writeParcelable(this.tMU, i);
        parcel.writeList(this.tMV);
        parcel.writeString(this.tMW);
    }
}
