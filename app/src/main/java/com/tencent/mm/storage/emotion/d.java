package com.tencent.mm.storage.emotion;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Base64;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.by.g;
import com.tencent.mm.by.g.a;
import com.tencent.mm.by.h;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class d extends i<EmojiInfo> implements a {
    public static final String[] gJN = new String[]{i.a(EmojiInfo.gJc, "EmojiInfo"), "CREATE INDEX IF NOT EXISTS emojiinfogrouptempindex  on EmojiInfo  (  groupId,temp )"};
    private static int[] xAB = new int[]{2, 4, 8};
    public e gJP;

    public final /* synthetic */ boolean b(c cVar) {
        return o((EmojiInfo) cVar);
    }

    public d(e eVar) {
        super(eVar, EmojiInfo.gJc, "EmojiInfo", null);
        this.gJP = eVar;
    }

    public final String getTableName() {
        return "EmojiInfo";
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.gJP = gVar;
        }
        return 0;
    }

    public final boolean fl(Context context) {
        x.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init");
        EmojiInfo XU = XU("86cb157e9c44b2c9934e4e430790776d");
        EmojiInfo XU2 = XU("68f9864ca5c0a5d823ed7184e113a4aa");
        x.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,group art custom catalog count:%d", new Object[]{Integer.valueOf(Dx(EmojiInfo.xAh))});
        if (XU != null || ((XU2 != null && XU2.we().length() == 0) || r2 <= 2)) {
            x.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,delete all group for very old version");
            Dz(EmojiInfo.xAg);
            Dz(EmojiInfo.xAj);
            Dz(EmojiInfo.xAi);
        }
        XU = XU("9bd1281af3a31710a45b84d736363691");
        if (XU != null && XU.field_catalog == EmojiInfo.xAg) {
            x.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,delete all group for 5.0");
            Dz(EmojiInfo.xAg);
            Dz(EmojiInfo.xAj);
            Dz(EmojiInfo.xAi);
        }
        InputStream bk = EmojiInfo.bk(context, "icon_002_cover.png");
        if (bk != null) {
            x.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,delete all group for 5.1,update emoji tuzi  for 4.4");
            Dz(EmojiInfo.xAg);
            Dz(EmojiInfo.xAj);
            Dz(EmojiInfo.xAi);
        }
        if (bk != null) {
            try {
                bk.close();
            } catch (Exception e) {
            }
        }
        if (Dx(EmojiInfo.xAg) != 0) {
            return true;
        }
        InputStream inputStream = null;
        try {
            x.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,parse xml start.");
            long currentTimeMillis = System.currentTimeMillis();
            inputStream = context.getAssets().open("custom_emoji/manifest.xml");
            List<EmojiInfo> a = a(new InputStream[]{inputStream});
            x.i("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]parse xml time: %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a.size() > 0 && a.size() > 0) {
                h hVar;
                currentTimeMillis = -1;
                if (this.gJP instanceof h) {
                    h hVar2 = (h) this.gJP;
                    currentTimeMillis = hVar2.dz(Thread.currentThread().getId());
                    hVar = hVar2;
                } else {
                    hVar = null;
                }
                for (EmojiInfo XU3 : a) {
                    if (this.gJP.replace("EmojiInfo", "md5", XU3.vI()) < 0) {
                        if (hVar != null) {
                            hVar.fS(currentTimeMillis);
                        }
                    }
                }
                if (hVar != null) {
                    hVar.fS(currentTimeMillis);
                }
            }
            x.i("MicroMsg.emoji.EmojiInfoStorage", "insert time: %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
            x.d("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init,parse xml end.");
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e2) {
                    x.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[]{bh.i(e2)});
                }
            }
        } catch (IOException e3) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "[oneliang]init, db error. " + e3.getMessage());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e22) {
                    x.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[]{bh.i(e22)});
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e4) {
                    x.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[]{bh.i(e4)});
                }
            }
        }
        return true;
    }

    public final EmojiInfo n(EmojiInfo emojiInfo) {
        if (bh.ov(emojiInfo.Nr()) || emojiInfo.Nr().length() <= 0) {
            x.f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
            return null;
        } else if (!o(emojiInfo)) {
            return null;
        } else {
            Wc("create_emoji_info_notify");
            return emojiInfo;
        }
    }

    public final EmojiInfo b(String str, String str2, int i, int i2, int i3, String str3) {
        return a(str, str2, i, i2, i3, null, null, str3, 1);
    }

    public final EmojiInfo c(String str, String str2, int i, int i2, int i3, String str3) {
        return a(str, str2, i, i2, i3, null, null, str3, 1);
    }

    public final EmojiInfo a(String str, String str2, int i, int i2, int i3, String str3, String str4) {
        return a(str, str2, i, i2, i3, null, str3, str4, 1);
    }

    private EmojiInfo a(String str, String str2, int i, int i2, int i3, String str3, String str4, String str5, int i4) {
        if (str == null || str.length() <= 0) {
            x.f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
            return null;
        }
        EmojiInfo emojiInfo;
        if (str == null || str.length() <= 0) {
            x.f("MicroMsg.emoji.EmojiInfoStorage", "create assertion!, invalid md5");
            emojiInfo = null;
        } else {
            emojiInfo = XU(str);
            if (emojiInfo == null) {
                com.tencent.mm.plugin.emoji.d.aAl();
                emojiInfo = new EmojiInfo(com.tencent.mm.plugin.emoji.d.aAm());
                emojiInfo.field_catalog = i;
            }
            emojiInfo.field_md5 = str;
            emojiInfo.field_svrid = str2;
            emojiInfo.field_type = i2;
            emojiInfo.field_size = i3;
            emojiInfo.field_state = EmojiInfo.xAq;
            emojiInfo.field_reserved1 = null;
            emojiInfo.field_reserved2 = null;
            emojiInfo.field_app_id = str4;
            emojiInfo.field_temp = 1;
            emojiInfo.field_reserved4 = 0;
            if (!TextUtils.isEmpty(str5)) {
                emojiInfo.field_groupId = str5;
            }
        }
        emojiInfo.field_state = EmojiInfo.xAs;
        if (!o(emojiInfo)) {
            return null;
        }
        Wc("create_emoji_info_notify");
        return emojiInfo;
    }

    public final boolean o(EmojiInfo emojiInfo) {
        if (emojiInfo == null || !emojiInfo.cky()) {
            x.f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
            return false;
        }
        long replace = this.gJP.replace("EmojiInfo", "md5", emojiInfo.vI());
        if (replace != -1) {
            Wc(emojiInfo.Nr());
        }
        if (replace >= 0) {
            return true;
        }
        return false;
    }

    public final boolean p(EmojiInfo emojiInfo) {
        if (emojiInfo == null || !emojiInfo.cky()) {
            x.f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
            return false;
        }
        int update = this.gJP.update("EmojiInfo", emojiInfo.vI(), "md5=?", new String[]{emojiInfo.Nr()});
        if (update > 0) {
            Wc(emojiInfo.Nr());
            Wc("event_update_emoji");
        }
        if (update <= 0) {
            return false;
        }
        return true;
    }

    public final boolean q(EmojiInfo emojiInfo) {
        if (emojiInfo == null || !emojiInfo.cky()) {
            x.f("MicroMsg.emoji.EmojiInfoStorage", "insert assertion!, invalid emojiInfo");
            return false;
        }
        if (this.gJP.update("EmojiInfo", emojiInfo.vI(), "md5=?", new String[]{emojiInfo.Nr()}) <= 0) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final EmojiInfo XU(String str) {
        Exception exception;
        Throwable th;
        Cursor cursor = null;
        if (bh.ov(str) || str.length() != 32) {
            x.i("MicroMsg.emoji.EmojiInfoStorage", "md5 is null or invalue. md5:%s", new Object[]{str});
            return null;
        }
        EmojiInfo emojiInfo;
        try {
            Cursor a = this.gJP.a("EmojiInfo", null, "md5=?", new String[]{str}, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        com.tencent.mm.plugin.emoji.d.aAl();
                        EmojiInfo emojiInfo2 = new EmojiInfo(com.tencent.mm.plugin.emoji.d.aAm());
                        emojiInfo2.b(a);
                        emojiInfo = emojiInfo2;
                        if (a != null) {
                            return emojiInfo;
                        }
                        a.close();
                        return emojiInfo;
                    }
                } catch (Exception e) {
                    Exception exception2 = e;
                    emojiInfo = null;
                    cursor = a;
                    exception = exception2;
                    try {
                        x.e("MicroMsg.emoji.EmojiInfoStorage", "[getByMd5]Exception:%s", new Object[]{exception.toString()});
                        if (cursor == null) {
                            return emojiInfo;
                        }
                        cursor.close();
                        return emojiInfo;
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
            emojiInfo = null;
            if (a != null) {
                return emojiInfo;
            }
            a.close();
            return emojiInfo;
        } catch (Exception e2) {
            exception = e2;
            emojiInfo = null;
            x.e("MicroMsg.emoji.EmojiInfoStorage", "[getByMd5]Exception:%s", new Object[]{exception.toString()});
            if (cursor == null) {
                return emojiInfo;
            }
            cursor.close();
            return emojiInfo;
        }
    }

    private int Dx(int i) {
        int i2 = 0;
        Cursor cursor = null;
        try {
            cursor = this.gJP.a("select count(*) from EmojiInfo where groupId= ? and temp=?", new String[]{String.valueOf(i), "0"}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                i2 = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[]{bh.i(e)});
            x.e("MicroMsg.emoji.EmojiInfoStorage", "[countProductId]Count ProductId fail." + e.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return i2;
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
            x.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[]{bh.i(e)});
            x.e("MicroMsg.emoji.EmojiInfoStorage", "[countProductId]Count ProductId fail." + e.getMessage());
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
        x.d("MicroMsg.emoji.EmojiInfoStorage", "count product id use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return i;
    }

    public final int lI(boolean z) {
        int i = 0;
        Cursor cursor = null;
        String str = "select count(*)  from EmojiInfo where catalog=? ";
        String[] strArr = new String[]{EmojiGroupInfo.xAd};
        if (z) {
            str = "select  count(*) from EmojiInfo where catalog=?  or catalog=?";
            strArr = new String[]{String.valueOf(EmojiGroupInfo.xAc), String.valueOf(EmojiGroupInfo.xAd)};
        }
        try {
            cursor = this.gJP.a(str, strArr, 2);
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[]{bh.i(e)});
            x.e("MicroMsg.emoji.EmojiInfoStorage", "[countCustomEmoji]Exception:%s", new Object[]{e.toString()});
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

    public final List<EmojiInfo> ckC() {
        List<EmojiInfo> arrayList = new ArrayList();
        String[] strArr = new String[]{String.valueOf(EmojiGroupInfo.xAc), String.valueOf(EmojiGroupInfo.xAd), String.valueOf(EmojiInfo.xAt)};
        Cursor a = this.gJP.a("select  * from EmojiInfo where catalog=?  or catalog=? and state!=? order by reserved3 asc", strArr, 2);
        if (a.moveToFirst()) {
            do {
                com.tencent.mm.plugin.emoji.d.aAl();
                EmojiInfo emojiInfo = new EmojiInfo(com.tencent.mm.plugin.emoji.d.aAm());
                emojiInfo.b(a);
                arrayList.add(emojiInfo);
            } while (a.moveToNext());
        }
        a.close();
        return arrayList;
    }

    public final List<String> ckD() {
        List<String> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.gJP.a("select md5 from EmojiInfo where catalog=?  order by reserved3 asc", new String[]{EmojiGroupInfo.xAd}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                arrayList.add(cursor.getString(0));
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "get download custom emoji MD5 list failed :%s", new Object[]{bh.i(e)});
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final List<String> ckE() {
        List<String> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.gJP.a("select md5 from EmojiInfo where catalog=? and source=?", new String[]{EmojiGroupInfo.xAd, EmojiInfo.xAw}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                arrayList.add(cursor.getString(0));
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "get download custom emoji MD5 list failed :%s", new Object[]{bh.i(e)});
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final Cursor Dy(int i) {
        return this.gJP.query("EmojiInfo", null, "catalog=? and temp=?", new String[]{String.valueOf(i), "0"}, null, null, null);
    }

    private boolean Dz(int i) {
        if (this.gJP.delete("EmojiInfo", "catalog=?", new String[]{String.valueOf(i)}) >= 0) {
            return true;
        }
        return false;
    }

    public final void a(Context context, EmojiInfo emojiInfo) {
        int available;
        if (emojiInfo.field_catalog == EmojiInfo.xAg || emojiInfo.field_catalog == EmojiInfo.xAj || emojiInfo.field_catalog == EmojiInfo.xAi) {
            InputStream inputStream = null;
            try {
                inputStream = EmojiInfo.bk(context, emojiInfo.getName());
                if (inputStream != null) {
                    available = inputStream.available();
                } else {
                    available = 0;
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e) {
                        x.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[]{bh.i(e)});
                    }
                }
            } catch (Throwable e2) {
                x.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[]{bh.i(e2)});
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        available = 0;
                    } catch (Throwable e22) {
                        x.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[]{bh.i(e22)});
                        available = 0;
                    }
                } else {
                    available = 0;
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e3) {
                        x.e("MicroMsg.emoji.EmojiInfoStorage", "exception:%s", new Object[]{bh.i(e3)});
                    }
                }
            }
        } else {
            available = com.tencent.mm.a.e.bN(emojiInfo.pol + emojiInfo.Nr());
        }
        if (available != 0 && available != emojiInfo.field_size) {
            emojiInfo.field_size = available;
            p(emojiInfo);
        }
    }

    private static List<EmojiInfo> a(InputStream[] inputStreamArr) {
        List<EmojiInfo> arrayList = new ArrayList();
        try {
            DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            for (int i = 0; i <= 0; i++) {
                InputStream inputStream = inputStreamArr[i];
                if (inputStream != null) {
                    NodeList elementsByTagName = newDocumentBuilder.parse(inputStream).getDocumentElement().getElementsByTagName("catalog");
                    for (int i2 = 0; i2 < elementsByTagName.getLength(); i2++) {
                        Element element = (Element) elementsByTagName.item(i2);
                        int intValue = Integer.decode(element.getAttribute(SlookAirButtonFrequentContactAdapter.ID)).intValue();
                        NodeList elementsByTagName2 = element.getElementsByTagName("emoji");
                        for (int i3 = 0; i3 < elementsByTagName2.getLength(); i3++) {
                            com.tencent.mm.plugin.emoji.d.aAl();
                            EmojiInfo emojiInfo = new EmojiInfo(com.tencent.mm.plugin.emoji.d.aAm());
                            element = (Element) elementsByTagName2.item(i3);
                            emojiInfo.field_md5 = element.getAttribute("md5");
                            if (emojiInfo.cky()) {
                                String str;
                                emojiInfo.field_catalog = intValue;
                                emojiInfo.field_groupId = String.valueOf(intValue);
                                emojiInfo.field_name = element.getAttribute("name");
                                emojiInfo.field_type = Integer.decode(element.getAttribute(DownloadSettingTable$Columns.TYPE)).intValue();
                                Node firstChild = element.getFirstChild();
                                String data = firstChild instanceof CharacterData ? ((CharacterData) firstChild).getData() : "";
                                if (emojiInfo.field_type == EmojiInfo.TYPE_TEXT) {
                                    str = new String(Base64.decode(data, 0));
                                } else {
                                    str = data;
                                }
                                emojiInfo.field_content = str;
                                arrayList.add(emojiInfo);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "parse xml error; " + e.getMessage());
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final EmojiInfo XV(String str) {
        EmojiInfo emojiInfo;
        Exception exception;
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor a = this.gJP.a("select * from EmojiInfo where +groupId = ? and temp=? limit 1 ", new String[]{str, "0"}, 2);
            try {
                if (a.moveToFirst()) {
                    com.tencent.mm.plugin.emoji.d.aAl();
                    EmojiInfo emojiInfo2 = new EmojiInfo(com.tencent.mm.plugin.emoji.d.aAm());
                    emojiInfo2.b(a);
                    emojiInfo = emojiInfo2;
                } else {
                    emojiInfo = null;
                }
                if (a != null) {
                    a.close();
                }
            } catch (Exception e) {
                Exception exception2 = e;
                emojiInfo = null;
                cursor = a;
                exception = exception2;
                try {
                    x.e("MicroMsg.emoji.EmojiInfoStorage", "getFirstEmojiByGroupId fail." + exception.getMessage());
                    if (cursor != null) {
                        cursor.close();
                    }
                    return emojiInfo;
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
        } catch (Exception e2) {
            exception = e2;
            emojiInfo = null;
            x.e("MicroMsg.emoji.EmojiInfoStorage", "getFirstEmojiByGroupId fail." + exception.getMessage());
            if (cursor != null) {
                cursor.close();
            }
            return emojiInfo;
        }
        return emojiInfo;
    }

    public final List<EmojiInfo> ye(String str) {
        List<EmojiInfo> arrayList = new ArrayList();
        String str2 = "select * from EmojiInfo where groupId=? and temp=? order by idx asc";
        Cursor cursor = null;
        try {
            cursor = this.gJP.a(str2, new String[]{str, "0"}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                com.tencent.mm.plugin.emoji.d.aAl();
                EmojiInfo emojiInfo = new EmojiInfo(com.tencent.mm.plugin.emoji.d.aAm());
                emojiInfo.b(cursor);
                arrayList.add(emojiInfo);
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Exception e) {
            x.w("MicroMsg.emoji.EmojiInfoStorage", "[getEmojiListByGroupId] Exception:%s", new Object[]{e.toString()});
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final boolean cU(List<String> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE");
        stringBuilder.append(" EmojiInfo ");
        stringBuilder.append(" SET ");
        stringBuilder.append("catalog");
        stringBuilder.append("=");
        stringBuilder.append(EmojiInfo.xAe);
        stringBuilder.append(",");
        stringBuilder.append("source");
        stringBuilder.append("=");
        stringBuilder.append(EmojiInfo.xAv);
        stringBuilder.append(",");
        stringBuilder.append("needupload");
        stringBuilder.append("=");
        stringBuilder.append(EmojiInfo.xAx);
        stringBuilder.append(" where ");
        stringBuilder.append("md5");
        stringBuilder.append(" IN (");
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append("'" + ((String) list.get(i)) + "'");
            if (i < list.size() - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(")");
        x.d("MicroMsg.emoji.EmojiInfoStorage", stringBuilder.toString());
        if (this.gJP.fx("EmojiInfo", stringBuilder.toString())) {
            Wc("delete_emoji_info_notify");
        }
        return true;
    }

    public final boolean cV(List<String> list) {
        x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] begin topCustomEmojiByMd5");
        long currentTimeMillis = System.currentTimeMillis();
        if (list == null || list.size() <= 0) {
            x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] topCustomEmojiByMd5 failed. list is null");
            return false;
        }
        long dz;
        h hVar;
        List<String> ckD = ckD();
        if (this.gJP instanceof h) {
            h hVar2 = (h) this.gJP;
            dz = hVar2.dz(Thread.currentThread().getId());
            hVar = hVar2;
        } else {
            hVar = null;
            dz = -1;
        }
        int i = 1;
        for (String str : list) {
            EmojiInfo XU = XU(str);
            if (!(XU == null || bh.ov(XU.Nr()))) {
                XU.field_reserved3 = i;
                if (!ckD.isEmpty()) {
                    ckD.remove(str);
                }
                i++;
                if (this.gJP.replace("EmojiInfo", "md5", XU.vI()) < 0) {
                    if (hVar != null) {
                        hVar.fS(dz);
                    }
                    x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end topCustomEmojiByMd5 user time:%d faild ", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    return false;
                }
            }
            i = i;
        }
        if (!ckD.isEmpty()) {
            for (String str2 : ckD) {
                EmojiInfo XU2 = XU(str2);
                if (!(XU2 == null || bh.ov(XU2.Nr()))) {
                    XU2.field_reserved3 = i;
                    i++;
                    if (this.gJP.replace("EmojiInfo", "md5", XU2.vI()) < 0) {
                        if (hVar != null) {
                            hVar.fS(dz);
                        }
                        x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] end topCustomEmojiByMd5 user time:%d faild ", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        return false;
                    }
                }
            }
        }
        if (hVar != null) {
            hVar.fS(dz);
        }
        String str3 = "MicroMsg.emoji.EmojiInfoStorage";
        String str4 = "[cpan] end topCustomEmojiByMd5 user time:%d succes. size:%d";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
        objArr[1] = Integer.valueOf(list == null ? 0 : list.size());
        x.i(str3, str4, objArr);
        return true;
    }

    public final boolean k(List<EmojiInfo> list, String str) {
        if (list.size() <= 0) {
            x.i("MicroMsg.emoji.EmojiInfoStorage", "insert emoji list faild. list is null or size is 0.");
            return false;
        }
        long dz;
        h hVar;
        EmojiInfo emojiInfo;
        x.i("MicroMsg.emoji.EmojiInfoStorage", "insertEmojiList groupId:%s size:%d", new Object[]{str, Integer.valueOf(list.size())});
        if (this.gJP instanceof h) {
            h hVar2 = (h) this.gJP;
            dz = hVar2.dz(Thread.currentThread().getId());
            hVar = hVar2;
        } else {
            hVar = null;
            dz = -1;
        }
        List<EmojiInfo> ye = ye(str);
        Map hashMap = new HashMap();
        for (EmojiInfo emojiInfo2 : ye) {
            hashMap.put(emojiInfo2.Nr(), emojiInfo2);
        }
        for (int i = 0; i < list.size(); i++) {
            emojiInfo2 = (EmojiInfo) list.get(i);
            emojiInfo2.field_temp = 0;
            this.gJP.replace("EmojiInfo", "md5", emojiInfo2.vI());
            hashMap.remove(emojiInfo2.Nr());
        }
        for (Entry entry : hashMap.entrySet()) {
            String str2 = (String) entry.getKey();
            emojiInfo2 = (EmojiInfo) entry.getValue();
            emojiInfo2.field_temp = 1;
            this.gJP.update("EmojiInfo", emojiInfo2.vI(), "md5=?", new String[]{str2});
            x.d("MicroMsg.emoji.EmojiInfoStorage", "jacks modify excess emoji to %s", new Object[]{emojiInfo2.field_groupId});
        }
        if (hVar != null) {
            hVar.fS(dz);
        }
        return true;
    }

    public final boolean XW(String str) {
        boolean z = false;
        String str2 = "select * from EmojiInfo where md5=?";
        Cursor cursor = null;
        try {
            cursor = this.gJP.a(str2, new String[]{str}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                z = true;
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "get judge is Exist EmojiInfo fail. md5 id is %s, err: %s", new Object[]{str, e.getMessage()});
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return z;
    }

    public final boolean XX(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (this.gJP.delete("EmojiInfo", "groupId = '" + str + "'", null) >= 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            x.i("MicroMsg.emoji.EmojiInfoStorage", "Delete By ProductId fail." + e.getMessage());
            return false;
        }
    }

    public final List<String> ckF() {
        List<String> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.gJP.a("select md5 from EmojiInfo where catalog=? or temp=?", new String[]{"85", "2"}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                arrayList.add(cursor.getString(0));
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "get need to sync emoji MD5 list failed :%s", new Object[]{bh.i(e)});
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final int ckG() {
        int i = 0;
        Cursor cursor = null;
        try {
            cursor = this.gJP.rawQuery("select md5 from EmojiInfo where catalog=? or temp=?", new String[]{"85", "2"});
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getCount();
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "get need to sync emoji MD5 list failed :%s", new Object[]{bh.i(e)});
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

    public final boolean ax(LinkedList<String> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] updateNeedUploadEmojiList failed. list is null");
            return false;
        }
        x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] updateNeedUploadEmojiList list size :%d.", new Object[]{Integer.valueOf(linkedList.size())});
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UPDATE");
        stringBuilder.append(" EmojiInfo ");
        stringBuilder.append(" SET ");
        stringBuilder.append("needupload");
        stringBuilder.append("=");
        stringBuilder.append(EmojiInfo.xAy);
        stringBuilder.append(" where ");
        stringBuilder.append("md5");
        stringBuilder.append(" IN (");
        for (int i = 0; i < linkedList.size(); i++) {
            stringBuilder.append("'" + ((String) linkedList.get(i)) + "'");
            if (i < linkedList.size() - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(")");
        x.d("MicroMsg.emoji.EmojiInfoStorage", stringBuilder.toString());
        return this.gJP.fx("EmojiInfo", stringBuilder.toString());
    }

    public final ArrayList<String> ckH() {
        ArrayList<String> arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.gJP.a("select md5 from EmojiInfo where needupload=? and catalog=?", new String[]{String.valueOf(EmojiInfo.xAy), String.valueOf(EmojiGroupInfo.xAd)}, 2);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                arrayList.add(cursor.getString(0));
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "get need upload emoji MD5 list failed :%s", new Object[]{bh.i(e)});
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final int ckI() {
        int i = 0;
        Cursor cursor = null;
        try {
            cursor = this.gJP.a("select reserved3 from EmojiInfo where catalog=? order by reserved3 desc limit 1", new String[]{String.valueOf(EmojiGroupInfo.xAd)}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                i = cursor.getInt(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiInfoStorage", "getCustomEmojiMaxIndex :%s", new Object[]{bh.i(e)});
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

    public final ArrayList<EmojiInfo> ckJ() {
        Throwable e;
        Cursor a;
        try {
            a = this.gJP.a("SELECT * FROM EmojiInfo WHERE catalog =?  OR catalog=? OR groupId IS NOT NULL", new String[]{String.valueOf(EmojiGroupInfo.xAd), String.valueOf(EmojiGroupInfo.xAe)}, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        ArrayList<EmojiInfo> arrayList = new ArrayList();
                        do {
                            EmojiInfo emojiInfo = new EmojiInfo();
                            emojiInfo.b(a);
                            if ((emojiInfo.field_reserved4 & EmojiInfo.xAz) != EmojiInfo.xAz) {
                                arrayList.add(emojiInfo);
                            }
                        } while (a.moveToNext());
                        if (a == null) {
                            return arrayList;
                        }
                        a.close();
                        return arrayList;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.emoji.EmojiInfoStorage", "getAllStoreAndCustomEmoji :%s", new Object[]{bh.i(e)});
                        if (a != null) {
                            a.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        throw e;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            x.e("MicroMsg.emoji.EmojiInfoStorage", "getAllStoreAndCustomEmoji :%s", new Object[]{bh.i(e)});
            if (a != null) {
                a.close();
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
        return null;
    }

    public final String getKey() {
        String string;
        Throwable e;
        EmojiInfo emojiInfo;
        Cursor a;
        try {
            a = this.gJP.a("SELECT md5 FROM EmojiInfo WHERE catalog =?", new String[]{"153"}, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        string = a.getString(0);
                        x.i("MicroMsg.emoji.EmojiInfoStorage", "had key :%s" + bh.VT(string));
                        if (a == null) {
                            return string;
                        }
                        a.close();
                        return string;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.emoji.EmojiInfoStorage", "createKey :%s", new Object[]{bh.i(e)});
                        if (a != null) {
                            a.close();
                        }
                        string = bh.eX(ac.getContext());
                        if (bh.ov(string)) {
                            string = com.tencent.mm.a.g.s("com.tencent.mm.key.MicroMsg.Wechat".getBytes());
                        } else {
                            string = com.tencent.mm.a.g.s(string.getBytes());
                        }
                        x.i("MicroMsg.emoji.EmojiInfoStorage", "create key :%s" + bh.VT(string));
                        emojiInfo = new EmojiInfo();
                        emojiInfo.field_md5 = string;
                        emojiInfo.field_catalog = 153;
                        if (o(emojiInfo)) {
                            return string;
                        }
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        throw e;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
            x.e("MicroMsg.emoji.EmojiInfoStorage", "createKey :%s", new Object[]{bh.i(e)});
            if (a != null) {
                a.close();
            }
            string = bh.eX(ac.getContext());
            if (bh.ov(string)) {
                string = com.tencent.mm.a.g.s("com.tencent.mm.key.MicroMsg.Wechat".getBytes());
            } else {
                string = com.tencent.mm.a.g.s(string.getBytes());
            }
            x.i("MicroMsg.emoji.EmojiInfoStorage", "create key :%s" + bh.VT(string));
            emojiInfo = new EmojiInfo();
            emojiInfo.field_md5 = string;
            emojiInfo.field_catalog = 153;
            if (o(emojiInfo)) {
                return string;
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
        string = bh.eX(ac.getContext());
        if (bh.ov(string)) {
            string = com.tencent.mm.a.g.s(string.getBytes());
        } else {
            string = com.tencent.mm.a.g.s("com.tencent.mm.key.MicroMsg.Wechat".getBytes());
        }
        x.i("MicroMsg.emoji.EmojiInfoStorage", "create key :%s" + bh.VT(string));
        emojiInfo = new EmojiInfo();
        emojiInfo.field_md5 = string;
        emojiInfo.field_catalog = 153;
        if (o(emojiInfo)) {
            return null;
        }
        return string;
    }

    public final boolean cW(List<rw> list) {
        int i = 0;
        if (list == null || list.isEmpty()) {
            x.i("MicroMsg.emoji.EmojiInfoStorage", "updateEmojiURL failed. empty list");
            return false;
        }
        long dz;
        h hVar;
        x.i("MicroMsg.emoji.EmojiInfoStorage", "updateEmojiURL size:%d", new Object[]{Integer.valueOf(list.size())});
        if (this.gJP instanceof h) {
            h hVar2 = (h) this.gJP;
            dz = hVar2.dz(Thread.currentThread().getId());
            x.i("MicroMsg.emoji.EmojiInfoStorage", "surround updateEmojiURL in a transaction, ticket = %d", new Object[]{Long.valueOf(dz)});
            hVar = hVar2;
        } else {
            hVar = null;
            dz = -1;
        }
        while (i < list.size()) {
            rw rwVar = (rw) list.get(i);
            EmojiInfo XU = XU(rwVar.vZL);
            if (XU == null) {
                XU = new EmojiInfo();
                XU.field_md5 = rwVar.vZL;
                XU.field_catalog = EmojiInfo.xAe;
                x.i("MicroMsg.emoji.EmojiInfoStorage", "new emoji as received when updateEmoji url");
            }
            XU.field_cdnUrl = rwVar.nfX;
            XU.field_encrypturl = rwVar.vZN;
            XU.field_aeskey = rwVar.vZO;
            XU.field_designerID = rwVar.vZM;
            XU.field_thumbUrl = rwVar.pbP;
            XU.field_groupId = rwVar.vIR;
            p(XU);
            i++;
        }
        if (hVar != null) {
            hVar.fS(dz);
            x.i("MicroMsg.emoji.EmojiInfoStorage", "end updateList transaction");
        }
        return true;
    }
}
