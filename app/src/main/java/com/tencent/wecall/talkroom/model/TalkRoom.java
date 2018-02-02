package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.google.a.a.e;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.aw;
import com.tencent.pb.common.b.a.a.t;
import com.tencent.pb.common.c.c;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TalkRoom extends MultiTalkGroup {
    at AmW;
    Map<String, d> AmX = new ConcurrentHashMap();

    public static TalkRoom a(String str, String str2, Integer num, int i, long j, at atVar, av[] avVarArr, aw[] awVarArr) {
        c.d("tagorewang:TalkRoom:create", new Object[]{"create groupId: ", str, " tmpId: ", str2});
        TalkRoom talkRoom = new TalkRoom(str, num, atVar);
        talkRoom.abS(str2);
        IY(i);
        gA(j);
        int length = avVarArr == null ? 0 : avVarArr.length;
        int length2 = awVarArr == null ? 0 : awVarArr.length;
        for (int i2 = 0; i2 != length; i2++) {
            av avVar = avVarArr[i2];
            if (avVar == null) {
                c.m("tagorewang:TalkRoom:create", new Object[]{"null member info, index: ", Integer.valueOf(i2)});
            } else {
                aw awVar = null;
                int i3 = 0;
                while (i3 != length2) {
                    awVar = awVarArr[i3];
                    if (awVar != null && awVar.vCD == avVar.vCD) {
                        c.d("tagorewang:TalkRoom:create", new Object[]{"member info: ", avVar, " profile: ", awVar});
                        break;
                    }
                    i3++;
                    awVar = null;
                }
                talkRoom.a(new d(avVar, awVar));
            }
        }
        c.d("tagorewang:TalkRoom:create", new Object[]{"did create"});
        return talkRoom;
    }

    public static TalkRoom a(TalkRoom talkRoom, String str, String str2, Integer num, int i, long j, at atVar, av[] avVarArr, aw[] awVarArr) {
        if (talkRoom == null) {
            c.m("tagorewang:TalkRoom:update", new Object[]{"updateAll null"});
            return null;
        }
        c.d("tagorewang:TalkRoom:update", new Object[]{"updateAll groupId: ", str, " tmpId: ", str2});
        talkRoom.b(str, num);
        talkRoom.abS(str2);
        IY(i);
        gA(j);
        talkRoom.b(atVar);
        int length = avVarArr == null ? 0 : avVarArr.length;
        int length2 = awVarArr == null ? 0 : awVarArr.length;
        if (length == 0 && length2 == 0) {
            c.m("tagorewang:TalkRoom:update", new Object[]{"updateAll null VoiceGroupMem or VoiceGroupUsrProfile array."});
            return talkRoom;
        }
        Set<String> hashSet = new HashSet(talkRoom.AmX.keySet());
        hashSet.remove(a.cCV());
        for (int i2 = 0; i2 != length; i2++) {
            av avVar = avVarArr[i2];
            if (avVar == null) {
                c.m("tagorewang:TalkRoom:update", new Object[]{"null member info, index: ", Integer.valueOf(i2)});
            } else {
                d abT = talkRoom.abT(avVar.zOC);
                if (abT == null) {
                    c.d("tagorewang:TalkRoom:update", new Object[]{"add new member"});
                    abT = new d(avVar);
                    talkRoom.a(abT);
                } else {
                    abT.a(avVar);
                }
                hashSet.remove(abT.cHJ());
            }
        }
        for (String str3 : hashSet) {
            c.d("tagorewang:TalkRoom:update", new Object[]{"keyset", str3});
            c.d("tagorewang:TalkRoom", new Object[]{"remove", talkRoom.AmX.remove(str3)});
        }
        if (hashSet.size() > 0) {
            c.m("tagorewang:TalkRoom:update", new Object[]{"updateAll not update uuid keyset.size(): ", Integer.valueOf(hashSet.size())});
        }
        c.d("tagorewang:TalkRoom:update", new Object[]{"did updateAll"});
        return talkRoom;
    }

    public TalkRoom(String str, Integer num, at atVar) {
        b(str, num);
        b(atVar);
    }

    public static boolean cHx() {
        return false;
    }

    private void abS(String str) {
        if (j.acg(str)) {
            this.zQr = str;
        }
    }

    public final int cHy() {
        return this.zMg == 0 ? 0 : this.zMg;
    }

    private void b(String str, Integer num) {
        if (!TextUtils.isEmpty(str)) {
            if (j.acg(str)) {
                this.zQr = str;
            } else {
                this.zQq = str;
            }
            if (num != null) {
                this.zMg = num.intValue();
            }
        }
    }

    public static int cHz() {
        return j.cId();
    }

    private static void IY(int i) {
        c.d("tagorewang:TalkRoom", new Object[]{"setRoomId: ", Integer.valueOf(i)});
    }

    public static long bHq() {
        return j.cIe();
    }

    private static void gA(long j) {
        c.d("tagorewang:TalkRoom", new Object[]{"setRoomKey: ", Long.valueOf(j)});
    }

    private static t a(at atVar) {
        if (atVar != null) {
            try {
                if (atVar.zOZ != null) {
                    byte[] bArr = atVar.zOZ;
                    return (t) e.a(new t(), bArr, bArr.length);
                }
            } catch (Exception e) {
                c.m("tagorewang:TalkRoom", new Object[]{"toPlayItemInfo err: ", e});
                return null;
            }
        }
        return null;
    }

    private String cHA() {
        if (this.AmW == null || TextUtils.isEmpty(this.AmW.name)) {
            List arrayList = new ArrayList(this.AmX.values());
            arrayList.remove(this.AmX.get(a.cCV()));
            List dJ = dJ(arrayList);
            c.l("tagorewang:TalkRoom", new Object[]{"getOtherMembers size: ", Integer.valueOf(dJ.size()), " all size: ", Integer.valueOf(this.AmX.size())});
            StringBuilder stringBuilder = new StringBuilder();
            if (dJ != null) {
                int size = dJ.size();
                for (int i = 0; i != size; i++) {
                    try {
                        stringBuilder.append(((d) dJ.get(i)).getDisplayName());
                        if (i != size - 1) {
                            stringBuilder.append('、');
                        }
                    } catch (Exception e) {
                        c.m("tagorewang:TalkRoom", new Object[]{"updateRoomNameIfEmpty err and continue: ", e});
                    }
                }
            }
            if (stringBuilder.toString().length() > 0) {
                return stringBuilder.toString();
            }
        }
        if (this.AmW != null && !TextUtils.isEmpty(this.AmW.name)) {
            return this.AmW.name;
        }
        c.m("tagorewang:TalkRoom", new Object[]{"updateRoomNameIfEmpty still empty, groupId: ", this.zQq, " tmpId: ", this.zQr});
        return null;
    }

    private void b(at atVar) {
        if (atVar != null) {
            try {
                this.zQs = atVar.zPg;
                this.zQt = atVar.zPf;
                if (!(this.AmW == null || atVar.fvx == 0)) {
                    t a = a(atVar);
                    t a2 = a(this.AmW);
                    if (a == null) {
                        atVar.zOZ = this.AmW.zOZ;
                    } else if (a.zNI == 0 || a.zNI != a2.zNI) {
                        c.m("tagorewang:TalkRoom", new Object[]{"setRoomInfo bad id: ", Integer.valueOf(a2.zNI), " -> ", Integer.valueOf(a.zNI)});
                        atVar.zOZ = this.AmW.zOZ;
                    }
                }
                this.AmW = atVar;
            } catch (Exception e) {
                c.m("tagorewang:TalkRoom", new Object[]{"setRoomInfo assert failed: ", e});
                this.AmW = atVar;
            }
        }
    }

    public final void a(d dVar) {
        this.AmX.put(dVar.cHJ(), dVar);
    }

    public final List<d> cHB() {
        List<d> dJ = dJ(new ArrayList(this.AmX.values()));
        d cHD = cHD();
        dJ.remove(cHD);
        dJ.add(0, cHD);
        cHD = (d) this.AmX.get(Integer.valueOf(90100));
        if (cHD != null) {
            dJ.remove(cHD);
            dJ.add(cHD);
        }
        return dJ;
    }

    public final List<d> cHC() {
        return new ArrayList(this.AmX.values());
    }

    private static List<d> dJ(List<d> list) {
        if (!list.isEmpty()) {
            Collections.sort(list, new a());
        }
        return list;
    }

    public final d abT(String str) {
        return (d) this.AmX.get(str);
    }

    public final d cHD() {
        return (d) this.AmX.get(a.cCV());
    }

    public final List<av> cHE() {
        List<av> arrayList = new ArrayList();
        for (Entry value : this.AmX.entrySet()) {
            arrayList.add(((d) value.getValue()).Ane);
        }
        return arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String cHA;
            stringBuilder.append("groupId: ").append(this.zQq);
            stringBuilder.append(" tmpId: ").append(this.zQr);
            stringBuilder.append(" routeId: ").append(this.zMg);
            StringBuilder append = stringBuilder.append(" room name: ");
            if (this.AmW == null || TextUtils.isEmpty(this.AmW.name)) {
                cHA = cHA();
            } else {
                cHA = this.AmW.name;
            }
            append.append(cHA);
        } catch (Exception e) {
            stringBuilder.append(" broken by " + e.getMessage());
        }
        return stringBuilder.toString();
    }
}
