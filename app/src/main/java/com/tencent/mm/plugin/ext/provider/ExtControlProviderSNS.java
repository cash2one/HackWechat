package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.by.e;
import com.tencent.mm.g.a.eu;
import com.tencent.mm.g.a.ev;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.ext.a.a;
import com.tencent.mm.pluginsdk.e.a.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public final class ExtControlProviderSNS extends ExtContentProviderBase {
    private static boolean maM = false;
    private static ak maN = new ak(new 1(), false);
    private static final String[] maP = new String[]{"feedId", "desc", SlookSmartClipMetaTag.TAG_TYPE_URL, "nickname", "avatar", "timestamp", "mediaCount", DownloadSettingTable$Columns.TYPE, "bigImgUrl", "firstImgWidth", "firstImgHeight"};
    private static final UriMatcher mal;
    private boolean fue = false;
    private boolean fuf = false;
    private int fug = 0;
    private String maQ = "";

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        mal = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.SNS", "snsInfo", 17);
    }

    private static void cu(boolean z) {
        if (z) {
            maM = true;
            maN.J(15000, 15000);
            return;
        }
        maN.J(0, 0);
    }

    public final boolean onCreate() {
        return false;
    }

    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.i("MicroMsg.ExtControlProviderSNS", "query() " + uri);
        a(uri, getContext(), mal);
        if (uri == null) {
            pp(3);
            return null;
        } else if (bh.ov(this.maf) || bh.ov(aFM())) {
            pp(3);
            return null;
        } else if (maM) {
            x.w("MicroMsg.ExtControlProviderSNS", "isBusy, return null");
            pp(5);
            return null;
        } else {
            cu(true);
            if (!aqY()) {
                cu(false);
                pp(1);
                return this.kuZ;
            } else if (!cz(getContext())) {
                x.w("MicroMsg.ExtControlProviderSNS", "invalid appid ! return null");
                cu(false);
                pp(2);
                return null;
            } else if (strArr2 == null || strArr2.length == 0) {
                x.e("MicroMsg.ExtControlProviderSNS", "invaild selections");
                cu(false);
                pp(3);
                return null;
            } else {
                String str3 = strArr2[0];
                if (bh.ov(str3)) {
                    x.e("MicroMsg.ExtControlProviderSNS", "userIdStr should not be null or nil");
                    cu(false);
                    pp(3);
                    return null;
                }
                try {
                    long j;
                    Cursor cP;
                    if ("0".equals(str3.trim())) {
                        j = 0;
                    } else {
                        j = Long.valueOf(a.zx(str3.trim())).longValue();
                    }
                    switch (mal.match(uri)) {
                        case 17:
                            cP = cP(j);
                            break;
                        default:
                            cP = null;
                            break;
                    }
                    if (cP != null) {
                        pp(0);
                    } else {
                        pp(4);
                    }
                    cu(false);
                    return cP;
                } catch (Throwable e) {
                    x.e("MicroMsg.ExtControlProviderSNS", e.getMessage());
                    x.printErrStackTrace("MicroMsg.ExtControlProviderSNS", e, "", new Object[0]);
                    cu(false);
                    pp(4);
                    return null;
                }
            }
        }
    }

    private Cursor cP(long j) {
        int i = 1;
        x.i("MicroMsg.ExtControlProviderSNS", "handleGetSnsInfo() userId = " + j);
        try {
            af WM;
            x.i("MicroMsg.ExtControlProviderSNS", "startGetSNSInfo, userId=[%s]", new Object[]{Long.valueOf(j)});
            if (j == 0) {
                ar.Hg();
                WM = c.EY().WM(q.FS());
            } else {
                ar.Hg();
                WM = c.EY().fO(j);
            }
            if (WM == null || ((int) WM.gJd) <= 0) {
                x.e("MicroMsg.ExtControlProviderSNS", "ct == null");
                i = 0;
            } else {
                this.fue = com.tencent.mm.l.a.fZ(WM.field_type);
                this.fuf = q.gr(WM.field_username);
                x.d("MicroMsg.ExtControlProviderSNS", "ct.getUsername()=[%s], isFriend=[%s], isSelf=[%s]", new Object[]{WM.field_username, Boolean.valueOf(this.fue), Boolean.valueOf(this.fuf)});
                b bVar = new b();
                bVar.b(10000, new 2(this, WM, bVar));
            }
            if (i == 0) {
                x.w("MicroMsg.ExtControlProviderSNS", "startGetSNSInfo() return false");
                return null;
            }
        } catch (Throwable e) {
            x.e("MicroMsg.ExtControlProviderSNS", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtControlProviderSNS", e, "", new Object[0]);
        }
        return aFR();
    }

    private Cursor aFR() {
        x.i("MicroMsg.ExtControlProviderSNS", new StringBuilder("getSnsCursor() , needDownload = true").toString());
        e eVar = new e(maP, (byte) 0);
        com.tencent.mm.sdk.b.b euVar = new eu();
        euVar.ftu.ftw = this.maQ;
        if (com.tencent.mm.sdk.b.a.xef.m(euVar)) {
            Cursor cursor = euVar.ftv.ftn;
            if (cursor != null) {
                try {
                    int count = cursor.getCount();
                    x.i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), snsCount = " + count);
                    if (count <= 0 || !cursor.moveToFirst()) {
                        x.i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), matrixCursor Count = " + eVar.getCount());
                        cursor.close();
                    } else {
                        do {
                            if (cursor != null) {
                                com.tencent.mm.sdk.b.b evVar = new ev();
                                evVar.ftx.ftz = cursor;
                                if (com.tencent.mm.sdk.b.a.xef.m(evVar)) {
                                    ar.Hg();
                                    com.tencent.mm.l.a WM = c.EY().WM(evVar.fty.ftA);
                                    if (WM != null && ((int) WM.gJd) > 0) {
                                        int i;
                                        Object obj;
                                        Object[] objArr;
                                        String str = "";
                                        String str2 = "";
                                        switch (evVar.fty.ftE) {
                                            case 1:
                                            case 7:
                                            case 8:
                                                i = 2;
                                                break;
                                            case 2:
                                                i = 1;
                                                break;
                                            case 3:
                                                i = 6;
                                                break;
                                            case 4:
                                                i = 3;
                                                break;
                                            case 5:
                                                i = 4;
                                                break;
                                            default:
                                                i = 5;
                                                break;
                                        }
                                        if (!(evVar.fty.ftG == null || evVar.fty.ftG.size() <= 0 || getContext() == null)) {
                                            x.d("MicroMsg.ExtControlProviderSNS", "uris.size() = [%s]", new Object[]{Integer.valueOf(evVar.fty.ftG.size())});
                                            if (i == 2 || i == 6 || i == 3 || i == 4) {
                                                obj = (String) evVar.fty.ftG.get(0);
                                                if (!(evVar.fty.ftH == null || evVar.fty.ftH.size() <= 0 || getContext() == null)) {
                                                    x.d("MicroMsg.ExtControlProviderSNS", "bigImgUris.size() = [%s], firstImgWidth = [%s], firstImgHeight = [%s]", new Object[]{Integer.valueOf(evVar.fty.ftH.size()), Integer.valueOf(evVar.fty.ftI), Integer.valueOf(evVar.fty.ftJ)});
                                                    if (i == 2 || i == 6 || i == 3 || i == 4) {
                                                        str2 = (String) evVar.fty.ftH.get(0);
                                                    }
                                                }
                                                str = com.tencent.mm.ad.b.iW(evVar.fty.ftA);
                                                objArr = new Object[11];
                                                objArr[0] = a.cO((long) evVar.fty.ftB);
                                                objArr[1] = evVar.fty.ftC;
                                                objArr[2] = obj;
                                                objArr[3] = WM.AQ();
                                                if (str == null) {
                                                    str = "";
                                                }
                                                objArr[4] = str;
                                                objArr[5] = Long.valueOf(evVar.fty.ftD);
                                                objArr[6] = Integer.valueOf(evVar.fty.ftF);
                                                objArr[7] = Integer.valueOf(i);
                                                objArr[8] = str2;
                                                objArr[9] = Integer.valueOf(evVar.fty.ftI);
                                                objArr[10] = Integer.valueOf(evVar.fty.ftJ);
                                                eVar.addRow(objArr);
                                            }
                                        }
                                        String str3 = str;
                                        x.d("MicroMsg.ExtControlProviderSNS", "bigImgUris.size() = [%s], firstImgWidth = [%s], firstImgHeight = [%s]", new Object[]{Integer.valueOf(evVar.fty.ftH.size()), Integer.valueOf(evVar.fty.ftI), Integer.valueOf(evVar.fty.ftJ)});
                                        str2 = (String) evVar.fty.ftH.get(0);
                                        str = com.tencent.mm.ad.b.iW(evVar.fty.ftA);
                                        try {
                                            objArr = new Object[11];
                                            objArr[0] = a.cO((long) evVar.fty.ftB);
                                            objArr[1] = evVar.fty.ftC;
                                            objArr[2] = obj;
                                            objArr[3] = WM.AQ();
                                            if (str == null) {
                                                str = "";
                                            }
                                            objArr[4] = str;
                                            objArr[5] = Long.valueOf(evVar.fty.ftD);
                                            objArr[6] = Integer.valueOf(evVar.fty.ftF);
                                            objArr[7] = Integer.valueOf(i);
                                            objArr[8] = str2;
                                            objArr[9] = Integer.valueOf(evVar.fty.ftI);
                                            objArr[10] = Integer.valueOf(evVar.fty.ftJ);
                                            eVar.addRow(objArr);
                                        } catch (Throwable e) {
                                            x.e("MicroMsg.ExtControlProviderSNS", e.getMessage());
                                            x.printErrStackTrace("MicroMsg.ExtControlProviderSNS", e, "", new Object[0]);
                                        }
                                    }
                                } else {
                                    x.w("MicroMsg.ExtControlProviderSNS", "ExtGetSnsDataEvent publish error");
                                }
                            }
                        } while (cursor.moveToNext());
                        x.i("MicroMsg.ExtControlProviderSNS", "in getSnsCursor(), matrixCursor Count = " + eVar.getCount());
                        cursor.close();
                    }
                } catch (Throwable e2) {
                    x.e("MicroMsg.ExtControlProviderSNS", e2.getMessage());
                    x.printErrStackTrace("MicroMsg.ExtControlProviderSNS", e2, "", new Object[0]);
                    if (cursor != null) {
                        cursor.close();
                    }
                    eVar.close();
                    return null;
                }
            }
            return eVar;
        }
        eVar.close();
        return null;
    }

    public final String getType(Uri uri) {
        return null;
    }

    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
