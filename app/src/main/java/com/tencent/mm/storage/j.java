package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.by.h;
import com.tencent.mm.protocal.c.el;
import com.tencent.mm.protocal.c.em;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j extends i<i> {
    public static final String[] gJN = new String[]{i.a(i.gJc, "BackupMoveTime")};
    public e gJP;

    public j(h hVar) {
        super(hVar, i.gJc, "BackupMoveTime", null);
        this.gJP = hVar;
        long currentTimeMillis = System.currentTimeMillis();
        long dz = hVar.dz(Thread.currentThread().getId());
        long currentTimeMillis2 = System.currentTimeMillis();
        List arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(new String[]{"CREATE INDEX IF NOT EXISTS DeviceIdSessionIndex ON BackupMoveTime ( deviceId,sessionName )"}));
        for (int i = 0; i < arrayList.size(); i++) {
            hVar.fx("BackupMoveTime", (String) arrayList.get(i));
        }
        x.d("MicroMsg.BackupMoveTimeStorage", "build new index last time[%d]", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
        hVar.fS(dz);
        x.i("MicroMsg.BackupMoveTimeStorage", "executeInitSQL last time[%d]", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public final void a(String str, LinkedList<String> linkedList, LinkedList<Long> linkedList2, LinkedList<String> linkedList3, LinkedList<Long> linkedList4) {
        Iterator it = linkedList2.iterator();
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            Object obj = null;
            if (it.hasNext()) {
                long longValue = ((Long) it.next()).longValue();
                if (it.hasNext()) {
                    em emVar;
                    long longValue2 = ((Long) it.next()).longValue();
                    if (longValue2 == 0) {
                        longValue2 = Long.MAX_VALUE;
                    }
                    String str3 = "SELECT * FROM BackupMoveTime WHERE deviceId = \"" + str + "\" AND sessionName = \"" + str2 + "\" ";
                    x.d("MicroMsg.BackupMoveTimeStorage", "getMoveTimeByDeviceIdSession:" + str3);
                    Cursor rawQuery = this.gJP.rawQuery(str3, null);
                    if (rawQuery == null) {
                        x.e("MicroMsg.BackupMoveTimeStorage", "getMoveTimeByDeviceIdSession failed, deviceid:%s, sessionName:%s ", new Object[]{str, str2});
                        emVar = null;
                    } else if (rawQuery.moveToFirst()) {
                        i iVar = new i();
                        iVar.b(rawQuery);
                        rawQuery.close();
                        emVar = iVar.field_moveTime;
                    } else {
                        rawQuery.close();
                        emVar = null;
                    }
                    if (emVar == null || emVar.vJN.size() <= 0 || longValue2 < ((el) emVar.vJN.getFirst()).startTime || longValue > ((el) emVar.vJN.getLast()).endTime) {
                        linkedList3.add(str2);
                        linkedList4.add(Long.valueOf(longValue));
                        linkedList4.add(Long.valueOf(longValue2));
                    } else {
                        Object obj2;
                        LinkedList linkedList5 = emVar.vJN;
                        for (int i = 0; i < linkedList5.size() && longValue <= longValue2; i++) {
                            el elVar = (el) linkedList5.get(i);
                            if (longValue <= elVar.endTime) {
                                if (longValue < elVar.startTime) {
                                    obj = 1;
                                    linkedList3.add(str2);
                                    linkedList4.add(Long.valueOf(longValue));
                                    if (longValue2 < elVar.startTime) {
                                        linkedList4.add(Long.valueOf(longValue2));
                                        longValue = elVar.startTime;
                                        obj2 = 1;
                                        break;
                                    }
                                    linkedList4.add(Long.valueOf(elVar.startTime));
                                }
                                longValue = elVar.endTime;
                            }
                        }
                        obj2 = obj;
                        if (longValue <= longValue2) {
                            linkedList3.add(str2);
                            linkedList4.add(Long.valueOf(longValue));
                            linkedList4.add(Long.valueOf(longValue2));
                            obj2 = 1;
                        }
                        if (obj2 == null) {
                            linkedList3.add(str2);
                            linkedList4.add(Long.valueOf(longValue));
                            linkedList4.add(Long.valueOf(longValue2));
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public final void d(String str, LinkedList<m> linkedList) {
        HashMap hashMap;
        x.i("MicroMsg.BackupMoveTimeStorage", "start mergeDataByDeviceIdSession.");
        HashMap hashMap2 = new HashMap();
        String str2 = "SELECT * FROM BackupMoveTime WHERE deviceId = \"" + str + "\" ";
        x.d("MicroMsg.BackupMoveTimeStorage", "getAllDataByDevice:" + str2);
        Cursor rawQuery = this.gJP.rawQuery(str2, null);
        if (rawQuery == null) {
            x.e("MicroMsg.BackupMoveTimeStorage", "getAllDataByDevice failed, deviceid:%s", new Object[]{str});
            hashMap = hashMap2;
        } else {
            while (rawQuery.moveToNext()) {
                i iVar = new i();
                iVar.b(rawQuery);
                hashMap2.put(iVar.field_sessionName, iVar);
            }
            rawQuery.close();
            hashMap = hashMap2;
        }
        if (this.gJP.delete("BackupMoveTime", "deviceId= ? ", new String[]{str}) < 0) {
            x.e("MicroMsg.BackupMoveTimeStorage", "mergeDataByDeviceId delete db failed, deviceid:%s", new Object[]{str});
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            m mVar = (m) it.next();
            i iVar2 = (i) hashMap.get(mVar.field_sessionName);
            if (iVar2 == null) {
                el elVar = new el();
                elVar.startTime = mVar.field_startTime;
                elVar.endTime = mVar.field_endTime;
                i iVar3 = new i();
                iVar3.field_deviceId = str;
                iVar3.field_sessionName = mVar.field_sessionName;
                iVar3.field_moveTime = new em();
                iVar3.field_moveTime.vJN = new LinkedList();
                iVar3.field_moveTime.vJN.add(elVar);
                hashMap.put(mVar.field_sessionName, iVar3);
            } else {
                a(iVar2.field_moveTime.vJN, mVar);
            }
        }
        for (String str3 : hashMap.keySet()) {
            x.i("MicroMsg.BackupMoveTimeStorage", "summerbak insert BackupMoveTimeStorage ret[%b], sessionName:%s", new Object[]{Boolean.valueOf(b((c) hashMap.get(str3))), str3});
        }
    }

    private static void a(LinkedList<el> linkedList, m mVar) {
        if (mVar.field_startTime <= mVar.field_endTime) {
            el elVar;
            Object obj;
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                elVar = (el) it.next();
                if (mVar.field_startTime < elVar.endTime) {
                    if (mVar.field_endTime < elVar.startTime) {
                        elVar = new el();
                        elVar.startTime = mVar.field_startTime;
                        elVar.endTime = mVar.field_endTime;
                        linkedList.add(elVar);
                        obj = 1;
                    } else {
                        int i;
                        if (mVar.field_startTime < elVar.startTime) {
                            elVar.startTime = mVar.field_startTime;
                        }
                        if (mVar.field_endTime > elVar.endTime) {
                            elVar.endTime = mVar.field_endTime;
                            while (it.hasNext()) {
                                el elVar2 = (el) it.next();
                                if (mVar.field_endTime <= elVar2.startTime) {
                                    break;
                                } else if (mVar.field_endTime <= elVar2.endTime) {
                                    elVar.endTime = elVar2.endTime;
                                    it.remove();
                                    i = 1;
                                    break;
                                } else {
                                    it.remove();
                                }
                            }
                        }
                        i = 1;
                    }
                    if (obj == null) {
                        elVar = new el();
                        elVar.startTime = mVar.field_startTime;
                        elVar.endTime = mVar.field_endTime;
                        linkedList.add(elVar);
                    }
                }
            }
            obj = null;
            if (obj == null) {
                elVar = new el();
                elVar.startTime = mVar.field_startTime;
                elVar.endTime = mVar.field_endTime;
                linkedList.add(elVar);
            }
        }
    }

    public final boolean chL() {
        x.i("MicroMsg.BackupMoveTimeStorage", "deleteAllData, result:%b", new Object[]{Boolean.valueOf(this.gJP.fx("BackupMoveTime", "delete from BackupMoveTime"))});
        return this.gJP.fx("BackupMoveTime", "delete from BackupMoveTime");
    }
}
