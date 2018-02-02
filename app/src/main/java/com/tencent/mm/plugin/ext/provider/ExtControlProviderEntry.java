package com.tencent.mm.plugin.ext.provider;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.ext.b;
import com.tencent.mm.pluginsdk.e.a.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bj;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.wcdb.database.SQLiteDatabase;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtControlProviderEntry extends ExtContentProviderBase {
    private static final UriMatcher mal;
    private String[] lZV;
    private int lZW;
    private boolean mam;
    private Context man;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        mal = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.entry", "view_profile", 2);
        mal.addURI("com.tencent.mm.plugin.ext.entry", "to_chatting", 3);
        mal.addURI("com.tencent.mm.plugin.ext.entry", "to_nearby", 4);
        mal.addURI("com.tencent.mm.plugin.ext.entry", "sns_comment_detail", 5);
        mal.addURI("com.tencent.mm.plugin.ext.entry", "share_time_line", 6);
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public ExtControlProviderEntry() {
        this.mam = false;
        this.lZV = null;
        this.lZW = -1;
    }

    public ExtControlProviderEntry(String[] strArr, int i, Context context) {
        this.mam = false;
        this.lZV = null;
        this.lZW = -1;
        this.mam = true;
        this.lZV = strArr;
        this.lZW = i;
        this.man = context;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        x.i("MicroMsg.ExtControlEntryProvider", "ExtControlProviderEntry query() mIsLocalUsed :" + this.mam);
        if (this.mam) {
            a(uri, this.man, this.lZW, this.lZV);
            if (bh.ov(this.maf)) {
                x.e("MicroMsg.ExtControlEntryProvider", "AppID == null");
                cs(3, 7);
                return a.By(7);
            } else if (bh.ov(aFM())) {
                x.e("MicroMsg.ExtControlEntryProvider", "PkgName == null");
                cs(3, 6);
                return a.By(6);
            } else {
                int aFN = aFN();
                if (aFN != 1) {
                    x.e("MicroMsg.ExtControlEntryProvider", "invalid appid ! return code = " + aFN);
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
            return a.By(3);
        } else if (!aqY()) {
            pp(1);
            return this.kuZ;
        } else if (!cz(this.man)) {
            x.w("MicroMsg.ExtControlEntryProvider", "invalid appid ! return null");
            pp(2);
            return null;
        }
        String ou = bh.ou(uri.getQueryParameter("source"));
        if (!this.mam) {
            this.lZW = mal.match(uri);
        }
        switch (this.lZW) {
            case 2:
                return m(strArr2);
            case 3:
                return b(strArr2, ou);
            case 4:
                if (this.man == null) {
                    pp(4);
                    return null;
                }
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI"));
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                this.man.startActivity(intent);
                pp(0);
                return a.By(1);
            case 5:
                return n(strArr2);
            case 6:
                if (strArr2 == null || strArr2.length <= 0) {
                    x.w("MicroMsg.ExtControlEntryProvider", "wrong args");
                    pp(3);
                    return null;
                } else if (this.man == null) {
                    pp(4);
                    return null;
                } else {
                    Intent intent2 = new Intent();
                    intent2.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareToTimeLineUI"));
                    intent2.setAction("android.intent.action.SEND");
                    intent2.addCategory("android.intent.category.DEFAULT");
                    intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    intent2.putExtra("android.intent.extra.TEXT", strArr2[1] == null ? "" : strArr2[1]);
                    if (strArr2[0] != null && strArr2[0].trim().length() > 0) {
                        intent2.putExtra("android.intent.extra.STREAM", Uri.parse(strArr2[0]));
                    }
                    intent2.putExtra("Ksnsupload_empty_img", true);
                    intent2.setType("image/*");
                    this.man.startActivity(intent2);
                    pp(0);
                    return a.By(1);
                }
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

    private Cursor m(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            x.w("MicroMsg.ExtControlEntryProvider", "wrong args");
            pp(3);
            return null;
        }
        String str = strArr[0];
        if (str == null || str.length() <= 0) {
            x.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
            pp(3);
            return null;
        }
        try {
            ar.Hg();
            af fO = c.EY().fO(com.tencent.mm.plugin.ext.a.a.zx(str));
            if (fO == null || ((int) fO.gJd) <= 0 || this.man == null) {
                pp(3);
                return null;
            }
            Intent intent = new Intent();
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra("Contact_User", fO.field_username);
            d.b(this.man, "profile", ".ui.ContactInfoUI", intent);
            pp(0);
            return a.By(1);
        } catch (Throwable e) {
            x.w("MicroMsg.ExtControlEntryProvider", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtControlEntryProvider", e, "", new Object[0]);
            pp(3);
            return null;
        }
    }

    private Cursor b(String[] strArr, String str) {
        x.i("MicroMsg.ExtControlEntryProvider", "toChattingUI");
        if (strArr == null || strArr.length <= 0) {
            x.w("MicroMsg.ExtControlEntryProvider", "wrong args");
            cs(3, 3601);
            return a.By(3601);
        } else if (bh.ov(str)) {
            x.w("MicroMsg.ExtControlEntryProvider", "callSource == null");
            cs(3, 3602);
            return a.By(3602);
        } else {
            String str2 = strArr[0];
            if (str2 == null || str2.length() <= 0) {
                x.w("MicroMsg.ExtControlEntryProvider", "contactId == null");
                cs(3, 3603);
                return a.By(3603);
            }
            af WO;
            boolean z = str != null && str.equalsIgnoreCase("openapi");
            if (z) {
                try {
                    bj XM = b.aFC().XM(str2);
                    if (XM == null || bh.ov(XM.field_openId) || bh.ov(XM.field_username)) {
                        x.e("MicroMsg.ExtControlEntryProvider", "openidInApp is null");
                        cs(3, 3604);
                        return a.By(3604);
                    }
                    ar.Hg();
                    WO = c.EY().WO(XM.field_username);
                } catch (Throwable e) {
                    x.w("MicroMsg.ExtControlEntryProvider", e.getMessage());
                    x.printErrStackTrace("MicroMsg.ExtControlEntryProvider", e, "", new Object[0]);
                    J(5, 4, 12);
                    return a.By(12);
                }
            }
            ar.Hg();
            WO = c.EY().fO(com.tencent.mm.plugin.ext.a.a.zx(str2));
            if (WO == null || ((int) WO.gJd) <= 0 || this.man == null) {
                x.e("MicroMsg.ExtControlEntryProvider", "wrong args ct");
                cs(3, 3605);
                return a.By(3605);
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.chatting.ChattingUI"));
            intent.putExtra("Chat_User", WO.field_username);
            intent.putExtra("finish_direct", true);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.addFlags(67108864);
            this.man.startActivity(intent);
            J(4, 0, 1);
            return a.By(1);
        }
    }

    private Cursor n(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            x.w("MicroMsg.ExtControlEntryProvider", "wrong args");
            pp(3);
            return null;
        }
        String str = strArr[0];
        if (str == null || str.length() <= 0) {
            x.w("MicroMsg.ExtControlEntryProvider", "wrong args");
            pp(3);
            return null;
        }
        try {
            long zx = com.tencent.mm.plugin.ext.a.a.zx(str);
            if (zx <= 0) {
                pp(3);
                return null;
            } else if (this.man == null) {
                pp(4);
                return null;
            } else {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI"));
                intent.putExtra("INTENT_SNS_LOCAL_ID", (int) zx);
                intent.addCategory("android.intent.category.DEFAULT");
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                this.man.startActivity(intent);
                pp(0);
                return a.By(1);
            }
        } catch (Throwable e) {
            x.w("MicroMsg.ExtControlEntryProvider", e.getMessage());
            x.printErrStackTrace("MicroMsg.ExtControlEntryProvider", e, "", new Object[0]);
            pp(3);
            return null;
        }
    }
}
