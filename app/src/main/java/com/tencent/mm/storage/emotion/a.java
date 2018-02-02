package com.tencent.mm.storage.emotion;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.by.g;
import com.tencent.mm.by.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ak;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public final class a extends i<EmojiGroupInfo> implements com.tencent.mm.by.g.a {
    public static final String[] gJN = new String[]{i.a(EmojiGroupInfo.gJc, "EmojiGroupInfo")};
    public e gJP;

    public final /* synthetic */ boolean b(c cVar) {
        return c((EmojiGroupInfo) cVar);
    }

    public a(e eVar) {
        super(eVar, EmojiGroupInfo.gJc, "EmojiGroupInfo", null);
        this.gJP = eVar;
    }

    public final String getTableName() {
        return "EmojiGroupInfo";
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.gJP = gVar;
        }
        return 0;
    }

    public final boolean fl(Context context) {
        x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init start.");
        fm(context);
        x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init end.");
        return true;
    }

    private ArrayList<EmojiGroupInfo> fm(Context context) {
        InputStream inputStream = null;
        Object arrayList = new ArrayList();
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        try {
            x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init,parse xml start.");
            inputStream = context.getAssets().open("custom_emoji/manifest.xml");
            NodeList elementsByTagName = newInstance.newDocumentBuilder().parse(inputStream).getDocumentElement().getElementsByTagName("catalog");
            for (int i = 0; i < elementsByTagName.getLength(); i++) {
                EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
                Element element = (Element) elementsByTagName.item(i);
                int intValue = Integer.decode(element.getAttribute(SlookAirButtonFrequentContactAdapter.ID)).intValue();
                if (!TextUtils.isEmpty(element.getAttribute("sort"))) {
                    x.d("MicroMsg.emoji.EmojiGroupInfoStorage", "Set Sort id:%d,sort:%d", new Object[]{Integer.valueOf(intValue), Integer.decode(element.getAttribute("sort"))});
                    int i2 = EmojiGroupInfo.xAc;
                    if ((intValue & i2) == i2) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (i2 == 0 || (cjZ() <= 0 && !ckh())) {
                        emojiGroupInfo.field_sort = i + 1;
                    } else {
                        emojiGroupInfo.field_sort = -1;
                        com.tencent.mm.kernel.g.Dj().CU().set(208912, Boolean.valueOf(true));
                        x.d("MicroMsg.emoji.EmojiGroupInfoStorage", "moveCustomEmojiTabToSecond");
                    }
                }
                emojiGroupInfo.field_productID = String.valueOf(intValue);
                emojiGroupInfo.field_packName = element.getAttribute("name");
                if (!TextUtils.isEmpty(element.getAttribute(DownloadSettingTable$Columns.TYPE))) {
                    emojiGroupInfo.field_type = Integer.decode(element.getAttribute(DownloadSettingTable$Columns.TYPE)).intValue();
                }
                if (!TextUtils.isEmpty(element.getAttribute("free"))) {
                    emojiGroupInfo.field_packType = Integer.decode(element.getAttribute("free")).intValue();
                }
                if (emojiGroupInfo.field_type == EmojiGroupInfo.TYPE_SYSTEM || emojiGroupInfo.field_type == EmojiGroupInfo.TYPE_CUSTOM) {
                    arrayList.add(emojiGroupInfo);
                }
            }
            if (arrayList.size() > 0) {
                cT(arrayList);
            }
            x.d("MicroMsg.emoji.EmojiGroupInfoStorage", "[oneliang]init,parse xml end.");
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", e, "", new Object[0]);
                }
            }
        } catch (Throwable e2) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "exception:%s", new Object[]{bh.i(e2)});
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "init emoji group db error." + e2.getMessage());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", e22, "", new Object[0]);
                }
            }
        } catch (Throwable e222) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "exception:%s", new Object[]{bh.i(e222)});
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "parse xml error; " + e222.getMessage());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e2222) {
                    x.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", e2222, "", new Object[0]);
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e3) {
                    x.printErrStackTrace("MicroMsg.emoji.EmojiGroupInfoStorage", e3, "", new Object[0]);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final EmojiGroupInfo bf(String str, boolean z) {
        EmojiGroupInfo emojiGroupInfo;
        Exception e;
        Cursor cursor;
        EmojiGroupInfo emojiGroupInfo2;
        Throwable th;
        String str2 = "select * from EmojiGroupInfo where productID= ?";
        try {
            Cursor a = this.gJP.a(str2, new String[]{str}, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        emojiGroupInfo = new EmojiGroupInfo();
                        emojiGroupInfo.b(a);
                        if (a == null) {
                            return emojiGroupInfo;
                        }
                        a.close();
                        return emojiGroupInfo;
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = a;
                    emojiGroupInfo2 = null;
                    try {
                        x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get getEmojiGroupInof fail. product id is" + str + " " + e.getMessage());
                        if (cursor != null) {
                            emojiGroupInfo = emojiGroupInfo2;
                        } else {
                            cursor.close();
                            emojiGroupInfo = emojiGroupInfo2;
                        }
                        if (emojiGroupInfo != null) {
                            return emojiGroupInfo;
                        }
                        if (z) {
                            return new EmojiGroupInfo();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor = a;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (a != null) {
                a.close();
                emojiGroupInfo = null;
            } else {
                emojiGroupInfo = null;
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
            emojiGroupInfo2 = null;
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get getEmojiGroupInof fail. product id is" + str + " " + e.getMessage());
            if (cursor != null) {
                cursor.close();
                emojiGroupInfo = emojiGroupInfo2;
            } else {
                emojiGroupInfo = emojiGroupInfo2;
            }
            if (emojiGroupInfo != null) {
                return emojiGroupInfo;
            }
            if (z) {
                return new EmojiGroupInfo();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        if (emojiGroupInfo != null) {
            return emojiGroupInfo;
        }
        if (z) {
            return null;
        }
        return new EmojiGroupInfo();
    }

    private int cjZ() {
        int i = 0;
        Cursor cursor = null;
        String str = "select  count(*) from EmojiInfo where catalog=?";
        try {
            cursor = this.gJP.a(str, new String[]{EmojiGroupInfo.xAd}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "Check GroupId Exist Faild." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return i;
    }

    public final boolean cka() {
        boolean z = true;
        Cursor cursor = null;
        try {
            cursor = this.gJP.a("select * from EmojiGroupInfo where type=?", new String[]{EmojiGroupInfo.TYPE_SYSTEM}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
            EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
            emojiGroupInfo.b(cursor);
            if ((emojiGroupInfo.field_flag & 256) > 0) {
                z = false;
            }
            if (cursor == null) {
                return z;
            }
            cursor.close();
            return z;
        } catch (Exception e) {
            x.d("MicroMsg.emoji.EmojiGroupInfoStorage", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final List<EmojiGroupInfo> ckb() {
        Cursor cursor = null;
        List<EmojiGroupInfo> arrayList = new ArrayList();
        try {
            cursor = this.gJP.a("select * from EmojiGroupInfo where " + Dt(EmojiGroupInfo.TYPE_SYSTEM) + " or " + Dt(EmojiGroupInfo.TYPE_CUSTOM) + " order by sort ASC", null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
                emojiGroupInfo.b(cursor);
                arrayList.add(emojiGroupInfo);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get system group fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final List<EmojiGroupInfo> ckc() {
        Cursor cursor = null;
        List<EmojiGroupInfo> arrayList = new ArrayList();
        try {
            cursor = this.gJP.a("select * from EmojiGroupInfo where " + ckk() + " order by sort ASC,lastUseTime DESC", null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
                emojiGroupInfo.b(cursor);
                arrayList.add(emojiGroupInfo);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get all group fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final HashMap<String, EmojiGroupInfo> ckd() {
        Cursor cursor = null;
        HashMap<String, EmojiGroupInfo> hashMap = new HashMap();
        try {
            cursor = this.gJP.a("select * from EmojiGroupInfo where " + ckk() + " order by sort ASC,lastUseTime DESC", null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return hashMap;
            }
            do {
                EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
                emojiGroupInfo.b(cursor);
                hashMap.put(emojiGroupInfo.field_productID, emojiGroupInfo);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return hashMap;
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get all group fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final ArrayList<EmojiGroupInfo> cke() {
        Cursor cursor = null;
        ArrayList<EmojiGroupInfo> arrayList = new ArrayList();
        try {
            cursor = this.gJP.a("select * from EmojiGroupInfo where " + ckl() + " order by sort ASC,lastUseTime DESC", null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
                emojiGroupInfo.b(cursor);
                arrayList.add(emojiGroupInfo);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get all group fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final int ckf() {
        Cursor cursor = null;
        int i = 0;
        try {
            cursor = this.gJP.a("select count(*) from EmojiGroupInfo where " + ckl() + " order by sort ASC,lastUseTime DESC", null, 2);
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "getDownloadGroupListCount fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return i;
    }

    public final HashMap<String, ak> ckg() {
        Cursor cursor = null;
        HashMap<String, ak> hashMap = new HashMap();
        try {
            cursor = this.gJP.a("select * from EmojiGroupInfo where " + ckl() + " order by sort ASC,lastUseTime DESC", null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return hashMap;
            }
            ak akVar = new ak();
            int columnIndex = cursor.getColumnIndex("productID");
            int columnIndex2 = cursor.getColumnIndex("packName");
            do {
                String string = cursor.getString(columnIndex);
                akVar.fqV = string;
                akVar.lEM = cursor.getString(columnIndex2);
                akVar.Do(7);
                hashMap.put(string, akVar);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return hashMap;
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get download group map failed." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final boolean XP(String str) {
        Cursor cursor = null;
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "product id is null.");
        }
        try {
            cursor = this.gJP.a("select count(*) from EmojiGroupInfo where productID = '" + str + "' AND " + ckm() + " AND ( ( ( flag & 256 ) = 0 )  or ( flag is null ) ) ", null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return z;
            }
            if (cursor.getInt(0) > 0) {
                z = true;
            }
            if (cursor != null) {
                cursor.close();
            }
            return z;
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "Check GroupId Exist Faild." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public static boolean ckh() {
        return ((Boolean) com.tencent.mm.kernel.g.Dj().CU().get(208912, Boolean.valueOf(false))).booleanValue();
    }

    public final boolean c(EmojiGroupInfo emojiGroupInfo) {
        if (emojiGroupInfo == null) {
            x.f("MicroMsg.emoji.EmojiGroupInfoStorage", "insert assertion!,invalid emojigroup info.");
            return false;
        }
        emojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
        emojiGroupInfo.field_sort = 1;
        x.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks insert: packname: %s, lasttime: %d", new Object[]{emojiGroupInfo.field_packName, Long.valueOf(emojiGroupInfo.field_lastUseTime)});
        emojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
        if (emojiGroupInfo != null) {
            emojiGroupInfo.field_flag &= -257;
        }
        boolean a = a(emojiGroupInfo);
        if (a) {
            b("event_update_group", 0, bh.cgy().toString());
        }
        return a;
    }

    public final boolean cT(List<EmojiGroupInfo> list) {
        if (list == null || list.size() <= 0) {
            x.d("MicroMsg.emoji.EmojiGroupInfoStorage", "updateList . list is null.");
            return false;
        }
        long dz;
        h hVar;
        if (this.gJP instanceof h) {
            h hVar2 = (h) this.gJP;
            dz = hVar2.dz(Thread.currentThread().getId());
            x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "surround updateList in a transaction, ticket = %d", new Object[]{Long.valueOf(dz)});
            hVar = hVar2;
        } else {
            hVar = null;
            dz = -1;
        }
        for (int i = 0; i < list.size(); i++) {
            x.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks packname: productid: %s, lasttime: %d, sort: %d", new Object[]{r0.field_productID, Long.valueOf(r0.field_lastUseTime), Integer.valueOf(((EmojiGroupInfo) list.get(i)).field_sort)});
            a(r0);
        }
        if (hVar != null) {
            hVar.fS(dz);
            x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "end updateList transaction");
        }
        b("event_update_group", 0, bh.cgy().toString());
        return true;
    }

    public final boolean XQ(String str) {
        boolean z;
        if (!bh.ov(str)) {
            try {
                if (str.equals("com.tencent.xin.emoticon.tusiji")) {
                    str = EmojiGroupInfo.xAb;
                }
                c bf = bf(str, true);
                if (bf == null) {
                    z = false;
                } else {
                    if (bf != null) {
                        if (bf.field_type == EmojiGroupInfo.TYPE_CUSTOM) {
                            x.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks refuse delete custom emoji");
                        } else {
                            bf.field_flag |= 256;
                            bf.field_status = -1;
                            bf.field_sort = 1;
                            bf.field_recommand = 0;
                            bf.field_sync = 0;
                        }
                    }
                    bf.field_lastUseTime = System.currentTimeMillis();
                    bf.field_recommand = 0;
                    bf.field_sync = 0;
                    z = a(bf);
                }
            } catch (Exception e) {
                x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "Delete By ProductId fail." + e.getMessage());
            }
            if (z) {
                b("event_update_group", 0, bh.cgy().toString());
                Wc("delete_group");
            }
            return z;
        }
        z = false;
        if (z) {
            b("event_update_group", 0, bh.cgy().toString());
            Wc("delete_group");
        }
        return z;
    }

    public final void af(ArrayList<String> arrayList) {
        long dz;
        h hVar;
        if (this.gJP instanceof h) {
            h hVar2 = (h) this.gJP;
            dz = hVar2.dz(Thread.currentThread().getId());
            x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "surround deleteByGroupIdList in a transaction, ticket = %d", new Object[]{Long.valueOf(dz)});
            hVar = hVar2;
        } else {
            hVar = null;
            dz = -1;
        }
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                XQ((String) it.next());
            }
        }
        if (hVar != null) {
            hVar.fS(dz);
            x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "end deleteByGroupIdList transaction");
        }
    }

    public final void cki() {
        if (this.gJP.fx("EmojiGroupInfo", "UPDATE EmojiGroupInfo SET sort=-1,lastUseTime=" + System.currentTimeMillis() + " WHERE type=" + (EmojiGroupInfo.TYPE_CUSTOM))) {
            b("event_update_group", 0, bh.cgy().toString());
        }
        com.tencent.mm.kernel.g.Dj().CU().set(208912, Boolean.valueOf(true));
    }

    public final ArrayList<EmojiGroupInfo> ckj() {
        Cursor cursor = null;
        ArrayList<EmojiGroupInfo> arrayList = new ArrayList();
        try {
            cursor = this.gJP.a("select * from EmojiGroupInfo where " + ckl() + " or " + Dt(EmojiGroupInfo.TYPE_SYSTEM) + " or " + Dt(EmojiGroupInfo.TYPE_CUSTOM) + " or " + (" ( recommand = '1" + "' ) ") + " order by sort ASC,idx ASC,lastUseTime DESC", null, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
                emojiGroupInfo.b(cursor);
                arrayList.add(emojiGroupInfo);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get Panel EmojiGroupInfo." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private static String ckk() {
        return Ds(EmojiGroupInfo.TYPE_SYSTEM) + " or " + Ds(EmojiGroupInfo.TYPE_CUSTOM) + " or " + Ds(EmojiGroupInfo.xzY) + " or " + Ds(EmojiGroupInfo.xAa);
    }

    private static final String ckl() {
        return " ( " + Ds(EmojiGroupInfo.xzY) + " and " + ckm() + " ) ";
    }

    private static final String Ds(int i) {
        return " ( type = '" + i + "' ) ";
    }

    private static final String ckm() {
        return " ( status = '7" + "' ) ";
    }

    private static final String Dt(int i) {
        return " ( " + Ds(i) + " and ( ( ( flag & 256 ) = 0 )  or ( flag is null ) )  ) ";
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean ckn() {
        Throwable th;
        String[] strArr = new String[]{EmojiGroupInfo.TYPE_SYSTEM, EmojiGroupInfo.xzY, "0", "7"};
        x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "checkStoreEmojiSync:%s", new Object[]{"select sync from EmojiGroupInfo where (type= ? or type= ? ) and sync=? and status=?"});
        Cursor cursor = null;
        try {
            cursor = this.gJP.a("select sync from EmojiGroupInfo where (type= ? or type= ? ) and sync=? and status=?", strArr, 2);
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    if (cursor == null) {
                        return true;
                    }
                    cursor.close();
                    return true;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            Cursor cursor2 = cursor;
            try {
                x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "checkStoreEmojiSync fail.");
                if (cursor2 != null) {
                    cursor2.close();
                }
                return false;
            } catch (Throwable th2) {
                cursor = cursor2;
                th = th2;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<String> cko() {
        List arrayList = new ArrayList();
        String[] strArr = new String[]{EmojiGroupInfo.xzY, "1"};
        Cursor cursor = null;
        try {
            cursor = this.gJP.a("select productID from EmojiGroupInfo where type=? and sync=?", strArr, 2);
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        arrayList.add(cursor.getString(0));
                    } while (cursor.moveToNext());
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "getNeedToSyncStoreEmojiProductList. exception.%s", new Object[]{bh.cgy()});
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            Cursor cursor2 = cursor;
            Throwable th3 = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th3;
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final List<String> ckp() {
        List arrayList = new ArrayList();
        String[] strArr = new String[]{"0", EmojiGroupInfo.xzY, "7", EmojiGroupInfo.TYPE_SYSTEM, "0"};
        Cursor cursor = null;
        try {
            cursor = this.gJP.a("select productID from EmojiGroupInfo where sync=? and (type=?  and status=?) or (type=? and flag=?)", strArr, 2);
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        arrayList.add(cursor.getString(0));
                    } while (cursor.moveToNext());
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "getNeedToUploadStoreEmojiProductList. exception.%s", new Object[]{bh.cgy()});
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            Cursor cursor2 = cursor;
            Throwable th3 = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th3;
        }
        return arrayList;
    }

    public final ArrayList<EmojiGroupInfo> ckq() {
        ArrayList<EmojiGroupInfo> arrayList = new ArrayList();
        String[] strArr = new String[]{EmojiGroupInfo.xzY, "7", EmojiGroupInfo.TYPE_SYSTEM, "0"};
        Cursor cursor = null;
        try {
            cursor = this.gJP.a(new StringBuilder("select * from EmojiGroupInfo where  (type=?  and status=?) or (type=? and flag=?)  order by sort ASC,idx ASC,lastUseTime DESC").toString(), strArr, 2);
            x.v("MicroMsg.emoji.EmojiGroupInfoStorage", "getNewMineGroupList : ===========");
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
                emojiGroupInfo.b(cursor);
                arrayList.add(emojiGroupInfo);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "get Panel EmojiGroupInfo." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final void ckr() {
        x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "recover heart begin");
        c bf = bf(String.valueOf(EmojiGroupInfo.xAc), false);
        if (bf == null) {
            bf = new EmojiGroupInfo();
        } else {
            x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "EmojiGroupInfo:%s", new Object[]{bf.toString()});
        }
        bf.field_productID = String.valueOf(EmojiGroupInfo.xAc);
        bf.field_packName = "emoji_custom_group";
        bf.field_type = EmojiGroupInfo.TYPE_CUSTOM;
        bf.field_status = 0;
        bf.field_packStatus = 1;
        bf.field_flag = 0;
        a(bf);
        x.i("MicroMsg.emoji.EmojiGroupInfoStorage", "recover heart end");
    }

    public final int ym(String str) {
        int i;
        long currentTimeMillis = System.currentTimeMillis();
        Cursor cursor = null;
        try {
            cursor = this.gJP.a("select count(*) from EmojiInfo where groupId= ? and temp=?", new String[]{str, "0"}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                i = 0;
            } else {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "exception:%s", new Object[]{bh.i(e)});
            x.e("MicroMsg.emoji.EmojiGroupInfoStorage", "[countProductId]Count ProductId fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
                i = 0;
            } else {
                i = 0;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        x.d("MicroMsg.emoji.EmojiGroupInfoStorage", "count product id use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return i;
    }
}
