package com.tencent.mm.plugin.ipcall.a.g;

import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Data;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.platformtools.c;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class b {
    public static final String ldS = new String(Character.toChars(91));
    private static HashMap<String, c> nGG = new HashMap();

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static ArrayList<c> aUd() {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<c> arrayList = new ArrayList();
        if (a.aZ(ac.getContext(), "android.permission.READ_CONTACTS")) {
            Cursor query = ac.getContext().getContentResolver().query(Data.CONTENT_URI, new String[]{"contact_id", SlookAirButtonFrequentContactAdapter.DISPLAY_NAME, "data1"}, "mimetype='vnd.android.cursor.item/phone_v2'", null, null);
            HashMap hashMap = new HashMap();
            x.d("MicroMsg.IPCallAddressBookInfoExtracter", "query FromSystemPhoneBook, time: " + (System.currentTimeMillis() - currentTimeMillis));
            if (query == null) {
                return arrayList;
            }
            try {
                x.d("MicroMsg.IPCallAddressBookInfoExtracter", "getAllAddressItemFromSystemPhoneBook, count: %d", new Object[]{Integer.valueOf(query.getCount())});
                if (query.moveToFirst()) {
                    int columnIndex = query.getColumnIndex("contact_id");
                    int columnIndex2 = query.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME);
                    int columnIndex3 = query.getColumnIndex("data1");
                    while (!query.isAfterLast()) {
                        c a = a(query, columnIndex, columnIndex2, columnIndex3);
                        if (!(a == null || a.nGH == null || a.nGH.size() <= 0 || bh.ov(a.field_contactId))) {
                            if (hashMap.containsKey(a.field_contactId)) {
                                c cVar = (c) hashMap.get(a.field_contactId);
                                if (a.nGH.size() > 0 && !cVar.nGH.contains(a.nGH.get(0))) {
                                    cVar.nGH.add(a.nGH.get(0));
                                }
                            } else {
                                hashMap.put(a.field_contactId, a);
                            }
                        }
                        query.moveToNext();
                    }
                }
                query.close();
            } catch (Exception e) {
                x.e("MicroMsg.IPCallAddressBookInfoExtracter", "getAllAddressItemFromSystemPhoneBook error: %s, class: %s", new Object[]{e.getMessage(), e.getClass().getSimpleName()});
            } catch (Throwable th) {
                query.close();
            }
            arrayList.addAll(hashMap.values());
            nGG = hashMap;
            long currentTimeMillis2 = System.currentTimeMillis();
            x.d("MicroMsg.IPCallAddressBookInfoExtracter", "getAllAddressItemFromSystemPhoneBook, result size: %d, used %dms", new Object[]{Integer.valueOf(arrayList.size()), Long.valueOf(currentTimeMillis2 - currentTimeMillis)});
            return arrayList;
        }
        x.e("MicroMsg.IPCallAddressBookInfoExtracter", "no contact permission");
        return arrayList;
    }

    public static HashMap<String, c> aUe() {
        return nGG;
    }

    public static HashMap<String, c> aUf() {
        aUd();
        return nGG;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static ArrayList<String> CC(String str) {
        ArrayList<String> arrayList = new ArrayList();
        if (a.aZ(ac.getContext(), "android.permission.READ_CONTACTS")) {
            Cursor query = ac.getContext().getContentResolver().query(Phone.CONTENT_URI, null, "contact_id=?", new String[]{str}, null);
            if (query == null) {
                return arrayList;
            }
            try {
                if (query.moveToFirst()) {
                    while (!query.isAfterLast()) {
                        arrayList.add(query.getString(query.getColumnIndex("data1")));
                        query.moveToNext();
                    }
                }
                query.close();
            } catch (Exception e) {
                x.e("MicroMsg.IPCallAddressBookInfoExtracter", "extractAddressItemFromCursor, error: %s, class: %s", new Object[]{e.getMessage(), e.getClass().getSimpleName()});
            } catch (Throwable th) {
                query.close();
            }
            return arrayList;
        }
        x.e("MicroMsg.IPCallAddressBookInfoExtracter", "no contact permission");
        return arrayList;
    }

    private static c a(Cursor cursor, int i, int i2, int i3) {
        String str = null;
        if (a.aZ(ac.getContext(), "android.permission.READ_CONTACTS")) {
            c cVar = new c();
            cVar.nGH = new ArrayList();
            String string = cursor.getString(i);
            String string2 = cursor.getString(i2);
            String string3 = cursor.getString(i3);
            cVar.field_contactId = string;
            cVar.field_systemAddressBookUsername = string2;
            if (!(bh.ov(string3) || cVar.nGH.contains(string3))) {
                cVar.nGH.add(string3);
            }
            if (bh.ov(cVar.field_systemAddressBookUsername) && cVar.nGH.size() > 0) {
                cVar.field_systemAddressBookUsername = (String) cVar.nGH.get(0);
            }
            Iterator it = cVar.nGH.iterator();
            string2 = str;
            while (it.hasNext()) {
                string = com.tencent.mm.plugin.ipcall.b.a.CZ((String) it.next());
                if (bh.ov(string)) {
                    string = string2;
                } else if (!string.endsWith("@stranger")) {
                    break;
                }
                string2 = string;
            }
            string = string2;
            if (!bh.ov(string)) {
                cVar.field_wechatUsername = string;
            }
            if (bh.ov(cVar.field_systemAddressBookUsername)) {
                cVar.field_sortKey = "";
            } else {
                try {
                    str = c.ol(cVar.field_systemAddressBookUsername);
                } catch (Exception e) {
                    x.d("MicroMsg.IPCallAddressBookInfoExtracter", "getFullSpell error: %s, class: %s", new Object[]{e.getMessage(), e.getClass().getSimpleName()});
                }
                if (bh.ov(str)) {
                    cVar.field_sortKey = "";
                } else if (Character.isLetter(str.charAt(0))) {
                    cVar.field_sortKey = str.toUpperCase();
                } else {
                    cVar.field_sortKey = ldS + str.toUpperCase();
                }
            }
            return cVar;
        }
        x.e("MicroMsg.IPCallAddressBookInfoExtracter", "no contact permission");
        return str;
    }
}
