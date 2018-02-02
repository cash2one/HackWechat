package com.tencent.mm.plugin.ipcall.a.g;

import android.database.Cursor;
import com.tencent.mm.by.h;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public final class m {
    public static k b(k kVar) {
        if (kVar == null) {
            return null;
        }
        x.d("MicroMsg.IPCallRecordStorageLogic", "recordCancelCall, localId: %d", new Object[]{Long.valueOf(kVar.xjy)});
        if (kVar.xjy == -1) {
            return kVar;
        }
        kVar.field_status = 7;
        i.aTE().a(kVar);
        return kVar;
    }

    public static k a(k kVar, long j) {
        if (kVar == null) {
            return null;
        }
        x.d("MicroMsg.IPCallRecordStorageLogic", "recordSelfShutdownCall, localId: %d, talkTime: %d", new Object[]{Long.valueOf(kVar.xjy), Long.valueOf(j)});
        if (kVar.xjy == -1) {
            return kVar;
        }
        kVar.field_status = 4;
        kVar.field_duration = j;
        i.aTE().a(kVar);
        return kVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static ArrayList<k> aUh() {
        Cursor query;
        long currentTimeMillis = System.currentTimeMillis();
        l aTE = i.aTE();
        Calendar instance = Calendar.getInstance();
        instance.add(6, -30);
        long timeInMillis = instance.getTimeInMillis();
        Cursor query2 = aTE.gJP.query("IPCallRecord", l.nGQ, "calltime>=?", new String[]{String.valueOf(timeInMillis)}, "addressId, phonenumber", null, "calltime desc");
        if (query2.getCount() < 30) {
            query2.close();
            query = i.aTE().gJP.query("IPCallRecord", l.nGQ, null, null, "addressId, phonenumber", null, "calltime desc");
        } else {
            query = query2;
        }
        x.d("MicroMsg.IPCallRecordStorageLogic", "finish query used %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        HashMap hashMap = new HashMap();
        ArrayList<k> arrayList = new ArrayList();
        if (query.moveToFirst()) {
            while (!query.isAfterLast() && arrayList.size() <= 30) {
                k kVar = new k();
                kVar.b(query);
                if (kVar.field_addressId == -1) {
                    c CE = i.aTD().CE(a.al(ac.getContext(), kVar.field_phonenumber));
                    if (CE != null) {
                        aTE = i.aTE();
                        long dz = aTE.gJP instanceof h ? ((h) aTE.gJP).dz(-1) : -1;
                        query2 = i.aTE().CH(kVar.field_phonenumber);
                        if (query2.moveToFirst()) {
                            while (!query2.isAfterLast()) {
                                k kVar2 = new k();
                                kVar2.b(query2);
                                kVar2.field_addressId = CE.xjy;
                                i.aTE().a(kVar2);
                                query2.moveToNext();
                            }
                        }
                        try {
                            aTE = i.aTE();
                            if ((aTE.gJP instanceof h) && dz != -1) {
                                ((h) aTE.gJP).fS(dz);
                            }
                            if (!hashMap.containsKey(kVar.field_addressId)) {
                                hashMap.put(kVar.field_addressId, kVar);
                                arrayList.add(kVar);
                            }
                        } catch (Exception e) {
                            x.e("MicroMsg.IPCallRecordStorageLogic", "getRecentRecordGroupByUser error: %s", new Object[]{e.getMessage()});
                        } catch (Throwable th) {
                            query.close();
                        }
                    } else if (!hashMap.containsKey(kVar.field_phonenumber)) {
                        hashMap.put(kVar.field_phonenumber, kVar);
                        arrayList.add(kVar);
                    }
                } else if (!hashMap.containsKey(kVar.field_addressId)) {
                    hashMap.put(kVar.field_addressId, kVar);
                    arrayList.add(kVar);
                }
                query.moveToNext();
            }
        }
        query.close();
        x.d("MicroMsg.IPCallRecordStorageLogic", "getRecentRecordGroupByUser, used: %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return arrayList;
    }
}
