package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ez;
import com.tencent.mm.g.a.fh;
import com.tencent.mm.g.b.af;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice;
import com.tencent.mm.plugin.ext.b;
import com.tencent.mm.pluginsdk.e.a.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bj;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtControlProviderMsg extends ExtContentProviderBase {
    private static final UriMatcher mal;
    private static final String[] mao = new String[]{"msgId", "fromUserId", "fromUserNickName", "msgType", DownloadInfo.CONTENTTYPE, "content", DownloadInfo.STATUS, "createTime"};
    private static final String[] maq = new String[]{"userId", "unReadCount"};
    private static final String[] mar = new String[]{"userId", "unReadCount"};
    private static final String[] mas = new String[]{"userId", "retCode", "msgId"};
    private static final String[] mat = new String[]{"msgId", "retCode"};
    private static final String[] mau = new String[]{"msgId", "retCode"};
    private String[] lZV;
    private int lZW;
    private boolean mam;
    private Context man;
    private MatrixCursor mav;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        mal = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.message", "oneMsg", 7);
        mal.addURI("com.tencent.mm.plugin.ext.message", "unReadCount", 8);
        mal.addURI("com.tencent.mm.plugin.ext.message", "unReadMsgs", 9);
        mal.addURI("com.tencent.mm.plugin.ext.message", "unReadUserList", 10);
        mal.addURI("com.tencent.mm.plugin.ext.message", "recordMsg", 11);
        mal.addURI("com.tencent.mm.plugin.ext.message", JsApiStartPlayVoice.NAME, 12);
        mal.addURI("com.tencent.mm.plugin.ext.message", "setReaded", 13);
        mal.addURI("com.tencent.mm.plugin.ext.message", "sendTextMsg", 14);
    }

    public ExtControlProviderMsg() {
        this.mav = null;
        this.mam = false;
        this.lZV = null;
        this.lZW = -1;
    }

    public ExtControlProviderMsg(String[] strArr, int i, Context context) {
        this.mav = null;
        this.mam = false;
        this.lZV = null;
        this.lZW = -1;
        this.mam = true;
        this.lZV = strArr;
        this.lZW = i;
        this.man = context;
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.i("MicroMsg.ExtControlProviderMsg", "ExtControlProviderMsg query() mIsLocalUsed :" + this.mam);
        if (this.mam) {
            a(uri, this.man, this.lZW, this.lZV);
            if (bh.ov(this.maf)) {
                x.e("MicroMsg.ExtControlProviderMsg", "AppID == null");
                cs(3, 7);
                return a.By(7);
            } else if (bh.ov(aFM())) {
                x.e("MicroMsg.ExtControlProviderMsg", "PkgName == null");
                cs(3, 6);
                return a.By(6);
            } else {
                int aFN = aFN();
                if (aFN != 1) {
                    x.e("MicroMsg.ExtControlProviderMsg", "invalid appid ! return code = " + aFN);
                    cs(2, aFN);
                    return a.By(aFN);
                }
            }
        }
        this.man = getContext();
        a(uri, this.man, mal);
        if (uri == null) {
            pp(3);
            return null;
        } else if (bh.ov(this.maf) || bh.ov(aFM())) {
            pp(3);
            return null;
        } else if (!aqY()) {
            pp(1);
            return this.kuZ;
        } else if (!cz(this.man)) {
            x.w("MicroMsg.ExtControlProviderMsg", "invalid appid ! return null");
            pp(2);
            return null;
        }
        String ou = bh.ou(uri.getQueryParameter("source"));
        String ou2 = bh.ou(uri.getQueryParameter("count"));
        if (!this.mam) {
            this.lZW = mal.match(uri);
        }
        switch (this.lZW) {
            case 7:
                return c(strArr2, ou);
            case 8:
                return o(strArr2);
            case 9:
                return a(strArr2, ou, ou2);
            case 10:
                return aFO();
            case 11:
                return p(strArr2);
            case 12:
                return q(strArr2);
            case 13:
                return r(strArr2);
            case 14:
                return s(strArr2);
            default:
                cs(3, 15);
                return null;
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private Cursor o(String[] strArr) {
        x.d("MicroMsg.ExtControlProviderMsg", "getUnReadCount()");
        if (strArr == null || strArr.length <= 0) {
            x.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            pp(3);
            return null;
        }
        Cursor matrixCursor = new MatrixCursor(maq);
        try {
            int hv;
            if ("*".equals(strArr[0])) {
                ar.Hg();
                hv = c.Fd().hv("");
                matrixCursor.addRow(new Object[]{"0", Integer.valueOf(hv)});
            } else {
                for (String zx : strArr) {
                    long zx2 = com.tencent.mm.plugin.ext.a.a.zx(zx);
                    ar.Hg();
                    af fO = c.EY().fO(zx2);
                    if (fO != null && ((int) fO.gJd) > 0) {
                        ar.Hg();
                        int hv2 = c.Fd().hv(" and ( rconversation.username='" + fO.field_username + "' );");
                        matrixCursor.addRow(new Object[]{Long.valueOf(zx2), Integer.valueOf(hv2)});
                    }
                }
            }
            pp(0);
            return matrixCursor;
        } catch (Throwable e) {
            x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
            matrixCursor.close();
            pp(4);
            return null;
        }
    }

    private Cursor a(String[] strArr, String str, String str2) {
        Throwable e;
        MatrixCursor matrixCursor;
        x.i("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs() ");
        x.d("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs(), %s, %s", new Object[]{str, str2});
        if (strArr == null || strArr.length <= 0) {
            x.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            cs(3, 3701);
            return a.By(3701);
        } else if (bh.ov(str)) {
            x.e("MicroMsg.ExtControlProviderMsg", "callSource == null");
            cs(3, 3702);
            return a.By(3702);
        } else if (bh.ov(str2)) {
            x.e("MicroMsg.ExtControlProviderMsg", "countStr == null");
            cs(3, 3703);
            return a.By(3703);
        } else {
            af WO;
            boolean z = str != null && str.equalsIgnoreCase("openapi");
            if (z) {
                try {
                    bj XM = b.aFC().XM(strArr[0]);
                    if (XM == null || bh.ov(XM.field_openId) || bh.ov(XM.field_username)) {
                        x.e("MicroMsg.ExtControlProviderMsg", "openidInApp is null");
                        cs(3, 3704);
                        return a.By(3704);
                    }
                    ar.Hg();
                    WO = c.EY().WO(XM.field_username);
                } catch (Exception e2) {
                    e = e2;
                    matrixCursor = null;
                    x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                    x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                    if (matrixCursor != null) {
                        matrixCursor.close();
                    }
                    J(3, 4, 12);
                    return a.By(12);
                }
            }
            long zx = com.tencent.mm.plugin.ext.a.a.zx(strArr[0]);
            ar.Hg();
            WO = c.EY().fO(zx);
            if (WO == null || WO.field_username == null || WO.field_username.length() <= 0) {
                x.e("MicroMsg.ExtControlProviderMsg", "contact is null");
                cs(3, 3705);
                return a.By(3705);
            }
            boolean z2;
            Cursor bC;
            String AQ = WO.AQ();
            if (WO.field_username.endsWith("@chatroom")) {
                AQ = r.gu(WO.field_username);
                z2 = true;
            } else {
                z2 = false;
            }
            if (z) {
                int i;
                try {
                    i = bh.getInt(str2, 0);
                } catch (Exception e3) {
                    x.e("MicroMsg.ExtControlProviderMsg", "exception in parseInt(%s)", new Object[]{str2});
                    i = 0;
                }
                if (i <= 0 || i >= 15) {
                    ar.Hg();
                    bC = c.Fa().bC(WO.field_username, 15);
                } else {
                    ar.Hg();
                    bC = c.Fa().bC(WO.field_username, i);
                }
            } else {
                ar.Hg();
                bC = c.Fa().bC(WO.field_username, 3);
            }
            if (bC == null) {
                x.e("MicroMsg.ExtControlProviderMsg", "msgCursor == null");
                J(3, 4, 3706);
                return a.By(3706);
            }
            matrixCursor = new MatrixCursor(mao);
            try {
                if (bC.getCount() <= 0 || !bC.moveToFirst()) {
                    bC.close();
                    J(2, 0, 1);
                    return matrixCursor;
                }
                au auVar = new au();
                do {
                    auVar.b(bC);
                    a(matrixCursor, auVar, WO, z2, AQ, z, strArr[0]);
                } while (bC.moveToNext());
                bC.close();
                J(2, 0, 1);
                return matrixCursor;
            } catch (Exception e4) {
                e = e4;
                x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                if (matrixCursor != null) {
                    matrixCursor.close();
                }
                J(3, 4, 12);
                return a.By(12);
            }
        }
    }

    private Cursor aFO() {
        x.d("MicroMsg.ExtControlProviderMsg", "getUnReadUserList()");
        Object matrixCursor = new MatrixCursor(mar);
        try {
            ar.Hg();
            Cursor aZr = c.Fa().aZr();
            if (aZr != null) {
                if (aZr.moveToFirst()) {
                    do {
                        String string = aZr.getString(aZr.getColumnIndex("talker"));
                        ar.Hg();
                        af WO = c.EY().WO(string);
                        if (!s.eV(string)) {
                            int i = (s.hn(WO.field_username) || s.hl(WO.field_username) || com.tencent.mm.storage.x.Dn(WO.field_verifyFlag) || s.hd(WO.field_username) || s.he(WO.field_username)) ? 0 : 1;
                            if (i == 0) {
                                long j = (long) ((int) WO.gJd);
                                matrixCursor.addRow(new Object[]{com.tencent.mm.plugin.ext.a.a.cO(j), Integer.valueOf(aZr.getInt(aZr.getColumnIndex("unReadCount")))});
                            }
                        }
                    } while (aZr.moveToNext());
                }
                aZr.close();
            }
            pp(0);
            return matrixCursor;
        } catch (Throwable e) {
            x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
            matrixCursor.close();
            pp(4);
            return null;
        }
    }

    private Cursor c(String[] strArr, String str) {
        MatrixCursor matrixCursor;
        Throwable e;
        boolean z = true;
        x.d("MicroMsg.ExtControlProviderMsg", "getOneMsg()");
        if (strArr == null || strArr.length <= 0) {
            x.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            pp(3);
            return null;
        }
        try {
            long zx = com.tencent.mm.plugin.ext.a.a.zx(strArr[0]);
            ar.Hg();
            cf dH = c.Fa().dH(zx);
            ar.Hg();
            af WO = c.EY().WO(dH.field_talker);
            if (WO == null || ((int) WO.gJd) <= 0) {
                pp(3);
                return null;
            }
            boolean z2;
            String AQ = WO.AQ();
            if (WO.field_username.endsWith("@chatroom")) {
                AQ = r.gu(WO.field_username);
                z2 = true;
            } else {
                z2 = false;
            }
            if (str == null || !str.equalsIgnoreCase("openapi")) {
                z = false;
            }
            matrixCursor = new MatrixCursor(mao);
            try {
                a(matrixCursor, dH, WO, z2, AQ, z, strArr[0]);
                pp(0);
                return matrixCursor;
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                if (matrixCursor != null) {
                    matrixCursor.close();
                }
                pp(4);
                return null;
            }
        } catch (Exception e3) {
            e = e3;
            matrixCursor = null;
            x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
            if (matrixCursor != null) {
                matrixCursor.close();
            }
            pp(4);
            return null;
        }
    }

    private Cursor p(String[] strArr) {
        Cursor cursor = null;
        x.d("MicroMsg.ExtControlProviderMsg", "handleRecordMsg()");
        if (strArr == null || strArr.length < 2) {
            x.w("MicroMsg.ExtControlProviderMsg", "wrong args");
            pp(3);
        } else {
            try {
                int intValue = Integer.valueOf(strArr[0]).intValue();
                long zx = com.tencent.mm.plugin.ext.a.a.zx(strArr[1]);
                if (zx <= 0) {
                    pp(3);
                } else {
                    com.tencent.mm.pluginsdk.e.a.b bVar = new com.tencent.mm.pluginsdk.e.a.b();
                    bVar.b(4000, new 1(this, intValue, zx, bVar, strArr));
                    cursor = this.mav;
                }
            } catch (Throwable e) {
                x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                if (this.mav != null) {
                    this.mav.close();
                }
                pp(4);
            }
        }
        return cursor;
    }

    private Cursor q(String[] strArr) {
        MatrixCursor matrixCursor;
        Throwable th;
        x.d("MicroMsg.ExtControlProviderMsg", "handlePlayVoice()");
        if (strArr == null || strArr.length < 2) {
            x.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            pp(3);
            return null;
        }
        try {
            int intValue = Integer.valueOf(strArr[0]).intValue();
            long zx = com.tencent.mm.plugin.ext.a.a.zx(strArr[1]);
            if (zx <= 0) {
                pp(3);
                return null;
            } else if (intValue == 3) {
                MatrixCursor matrixCursor2 = new MatrixCursor(mat);
                try {
                    com.tencent.mm.sdk.b.b fhVar = new fh();
                    fhVar.fux.fqm = zx;
                    com.tencent.mm.sdk.b.a.xef.m(fhVar);
                    if (fhVar.fuy.fileName == null || fhVar.fuy.fileName.length() <= 0) {
                        matrixCursor2.addRow(new Object[]{strArr[1], Integer.valueOf(2)});
                        pp(4);
                        return matrixCursor2;
                    }
                    com.tencent.mm.sdk.b.b ezVar = new ez();
                    ezVar.ftT.op = 1;
                    ezVar.ftT.fileName = fhVar.fuy.fileName;
                    if (com.tencent.mm.sdk.b.a.xef.m(ezVar)) {
                        matrixCursor2.addRow(new Object[]{strArr[1], Integer.valueOf(1)});
                        pp(0);
                    } else {
                        x.e("MicroMsg.ExtControlProviderMsg", "play failed");
                        matrixCursor2.addRow(new Object[]{strArr[1], Integer.valueOf(2)});
                        pp(4);
                    }
                    b.aFz();
                    b.cN(zx);
                    return matrixCursor2;
                } catch (Throwable e) {
                    Throwable th2 = e;
                    matrixCursor = matrixCursor2;
                    th = th2;
                    x.e("MicroMsg.ExtControlProviderMsg", th.getMessage());
                    x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", th, "", new Object[0]);
                    if (matrixCursor != null) {
                        matrixCursor.close();
                    }
                    pp(4);
                    return null;
                }
            } else if (intValue != 4) {
                return null;
            } else {
                com.tencent.mm.sdk.b.b ezVar2 = new ez();
                ezVar2.ftT.op = 2;
                if (com.tencent.mm.sdk.b.a.xef.m(ezVar2)) {
                    x.i("MicroMsg.ExtControlProviderMsg", "stop last playing");
                    pp(0);
                    return null;
                }
                x.i("MicroMsg.ExtControlProviderMsg", "stop last playing fail");
                pp(4);
                return null;
            }
        } catch (Exception e2) {
            th = e2;
            matrixCursor = null;
            x.e("MicroMsg.ExtControlProviderMsg", th.getMessage());
            x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", th, "", new Object[0]);
            if (matrixCursor != null) {
                matrixCursor.close();
            }
            pp(4);
            return null;
        }
    }

    private Cursor r(String[] strArr) {
        x.i("MicroMsg.ExtControlProviderMsg", "setMsgReaded()");
        if (strArr == null || strArr.length <= 0) {
            x.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            cs(3, 3801);
            return a.By(3801);
        }
        int i = 0;
        while (i < strArr.length) {
            try {
                if (strArr[i] == null || strArr[i].length() <= 0) {
                    x.w("MicroMsg.ExtControlProviderMsg", "setMsgReaded() wrongArgs i = " + i);
                } else {
                    long zx = com.tencent.mm.plugin.ext.a.a.zx(strArr[i]);
                    b.aFz();
                    b.cN(zx);
                }
                i++;
            } catch (Throwable e) {
                x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                cs(4, 12);
                return a.By(12);
            }
        }
        cs(0, 1);
        return a.By(1);
    }

    private Cursor s(String[] strArr) {
        x.d("MicroMsg.ExtControlProviderMsg", "sendTextMsg()");
        if (strArr == null || strArr.length <= 0) {
            x.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            pp(3);
            return null;
        }
        try {
            long zx = com.tencent.mm.plugin.ext.a.a.zx(strArr[0]);
            if (zx <= 0) {
                pp(3);
                return null;
            }
            b.aFz();
            com.tencent.mm.l.a cM = b.cM(zx);
            if (cM == null || ((int) cM.gJd) <= 0) {
                x.e("MicroMsg.ExtControlProviderMsg", "toContact is null ");
                pp(3);
                return null;
            }
            this.mav = new MatrixCursor(mau);
            com.tencent.mm.pluginsdk.e.a.b bVar = new com.tencent.mm.pluginsdk.e.a.b();
            bVar.b(15000, new 2(this, cM, strArr, bVar));
            return this.mav;
        } catch (Throwable e) {
            x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
            if (this.mav != null) {
                this.mav.close();
            }
            pp(4);
            return null;
        }
    }

    private void a(MatrixCursor matrixCursor, au auVar, com.tencent.mm.storage.x xVar, boolean z, String str, boolean z2, String str2) {
        if (auVar != null) {
            if (bh.ov(str2)) {
                x.d("MicroMsg.ExtControlProviderMsg", "userOpenId is null");
            } else if (auVar.getType() != 9999 && auVar.getType() != 10000) {
                String str3 = "";
                String str4 = "";
                if (z) {
                    int hO = ba.hO(auVar.field_content);
                    if (hO != -1 && auVar.field_content.length() > hO) {
                        String trim = auVar.field_content.substring(0, hO).trim();
                        if (trim != null && trim.length() > 0 && auVar.field_content.length() >= hO + 2) {
                            str3 = r.gu(trim);
                            str4 = auVar.field_content.substring(hO + 2);
                        }
                    }
                }
                String str5 = "";
                int M = com.tencent.mm.plugin.ext.b.b.M(auVar);
                if (M == 1) {
                    if (z) {
                        str3 = str3 + "!]" + str4;
                    } else {
                        str3 = auVar.field_content;
                    }
                } else if (M == 2) {
                    p iM = m.UD().iM((int) auVar.field_msgId);
                    if (iM == null || iM.fileName == null) {
                        str4 = str5;
                    } else {
                        str4 = q.getFullPath(iM.fileName);
                        x.d("MicroMsg.ExtControlProviderMsg", "voice file = %s", new Object[]{str4});
                    }
                    str3 = str4;
                } else if (!z) {
                    if (this.man != null) {
                        str3 = this.man.getString(R.l.edX);
                    } else {
                        str3 = "";
                    }
                }
                if (!z2) {
                    str2 = com.tencent.mm.plugin.ext.a.a.cO((long) ((int) xVar.gJd));
                }
                try {
                    if (bh.ov(str2)) {
                        x.w("MicroMsg.ExtControlProviderMsg", "userId is null");
                        return;
                    }
                    Object[] objArr = new Object[8];
                    objArr[0] = com.tencent.mm.plugin.ext.a.a.cO(auVar.field_msgId);
                    objArr[1] = str2;
                    objArr[2] = str;
                    objArr[3] = Integer.valueOf(auVar.field_isSend == 0 ? 1 : 2);
                    objArr[4] = Integer.valueOf(M);
                    objArr[5] = str3;
                    objArr[6] = Integer.valueOf(auVar.field_status == 4 ? 1 : 2);
                    objArr[7] = Long.valueOf(auVar.field_createTime);
                    matrixCursor.addRow(objArr);
                } catch (Throwable e) {
                    x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                    x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                }
            }
        }
    }
}
