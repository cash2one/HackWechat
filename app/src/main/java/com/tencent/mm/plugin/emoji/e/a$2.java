package com.tencent.mm.plugin.emoji.e;

import android.database.Cursor;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.e;
import java.util.ArrayList;

class a$2 implements Runnable {
    final /* synthetic */ a lvg;

    a$2(a aVar) {
        this.lvg = aVar;
    }

    public final void run() {
        int i;
        String str;
        ArrayList arrayList;
        long currentTimeMillis = System.currentTimeMillis();
        a aVar = this.lvg;
        aVar.clear();
        Cursor cursor = null;
        try {
            cursor = i.aBE().lwV.Tj();
            if (cursor != null && cursor.moveToFirst()) {
                int count = cursor.getCount();
                for (i = 0; i < count; i++) {
                    e eVar = new e();
                    eVar.b(cursor);
                    str = eVar.field_desc;
                    if (!bh.ov(str)) {
                        aVar.lvd.put(str.toLowerCase(), eVar.field_groupID);
                        arrayList = (ArrayList) aVar.lvc.get(eVar.field_groupID);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(eVar.field_desc);
                        aVar.lvc.put(eVar.field_groupID, arrayList);
                    }
                    cursor.moveToNext();
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            x.e("MicroMsg.emoji.EmojiDescNewMgr", bh.i(e));
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        String toLowerCase = w.cfi().toLowerCase();
        String str2 = "default";
        aVar.luY = toLowerCase;
        cursor = null;
        str = "select EmojiInfoDesc.desc,EmojiInfoDesc.md5,EmojiInfoDesc.lang,EmojiGroupInfo.lastUseTime,EmojiInfoDesc.groupId,EmojiGroupInfo.productID,EmojiGroupInfo.idx from EmojiInfoDesc,EmojiGroupInfo where EmojiInfoDesc.groupId=EmojiGroupInfo.productID and EmojiGroupInfo.status='7' order by EmojiGroupInfo.sort desc,EmojiGroupInfo.lastUseTime desc";
        try {
            long currentTimeMillis2 = System.currentTimeMillis();
            cursor = i.aBE().lwN.rawQuery(str, new String[0]);
            x.i("MicroMsg.emoji.EmojiDescNewMgr", "cpan[tryInit]  rawQuery use time:%s", (System.currentTimeMillis() - currentTimeMillis2));
            if (cursor != null && cursor.moveToFirst()) {
                cursor.moveToFirst();
                int count2 = cursor.getCount();
                for (i = 0; i < count2; i++) {
                    str = cursor.getString(cursor.getColumnIndex("desc"));
                    String string = cursor.getString(cursor.getColumnIndex("md5"));
                    String string2 = cursor.getString(cursor.getColumnIndex("lang"));
                    int i2 = cursor.getInt(cursor.getColumnIndex("idx"));
                    if (!(bh.ov(str) || bh.ov(string2) || (!string2.equals(toLowerCase) && !string2.equals(str2)))) {
                        string2 = str.toLowerCase();
                        if (aVar.lve.containsKey(string2)) {
                            arrayList = (ArrayList) aVar.lve.get(string2);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(new a$a(aVar, string, i2));
                        } else {
                            arrayList = new ArrayList();
                            arrayList.add(new a$a(aVar, string, i2));
                            aVar.lve.put(string2, arrayList);
                        }
                        aVar.lvb.put(string, string2);
                    }
                    cursor.moveToNext();
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e2) {
            x.w("MicroMsg.emoji.EmojiDescNewMgr", bh.i(e2));
            this.lvg.mInit = true;
            x.i("MicroMsg.emoji.EmojiDescNewMgr", "cpan[newinit] all use time:%s", (System.currentTimeMillis() - currentTimeMillis));
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        this.lvg.mInit = true;
        x.i("MicroMsg.emoji.EmojiDescNewMgr", "cpan[newinit] all use time:%s", (System.currentTimeMillis() - currentTimeMillis));
    }

    public final String toString() {
        return super.toString() + "|newinit";
    }
}
