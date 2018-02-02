package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.aw;
import com.tencent.pb.common.c.e;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c {
    public static boolean AmZ = false;
    private static final e<c> Ana = new e<c>() {
        protected final /* synthetic */ Object cCT() {
            return new c();
        }
    };
    private static boolean DEBUG = false;
    Map<String, TalkRoom> Anb;
    Map<String, String> Anc;
    g And;

    public static c cHH() {
        return (c) Ana.get();
    }

    private c() {
        this.Anb = new HashMap();
        this.Anc = new HashMap();
        com.tencent.pb.common.c.c.d("TalkRoomManager", new Object[]{"asyncLoadCache"});
    }

    public final boolean bt(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            com.tencent.pb.common.c.c.m("TalkRoomManager", new Object[]{"isGroupActiveExceptMySelf groupid is null"});
            return false;
        }
        TalkRoom abU = abU(str);
        if (abU == null) {
            com.tencent.pb.common.c.c.m("TalkRoomManager", new Object[]{"isGroupActiveExceptMySelf talkRoom is null"});
            return false;
        }
        List<d> cHB = abU.cHB();
        if (cHB == null) {
            com.tencent.pb.common.c.c.m("TalkRoomManager", new Object[]{"isGroupActiveExceptMySelf TalkRoomMember list is null"});
            return false;
        }
        boolean z2 = false;
        boolean z3 = false;
        for (d dVar : cHB) {
            if (dVar != null) {
                boolean z4;
                TalkRoom.cHx();
                if (dVar.getState() != 10) {
                    z4 = z2;
                    z2 = z3;
                } else if (dVar.cHL()) {
                    z4 = true;
                    z2 = z3;
                } else {
                    z4 = z2;
                    z2 = true;
                }
                if (z && z2) {
                    return true;
                }
                if (z4 && z2) {
                    com.tencent.pb.common.c.c.m("TalkRoomManager", new Object[]{"isGroupActiveExceptMySelf is true"});
                    return true;
                }
                z3 = z2;
                z2 = z4;
            }
        }
        return false;
    }

    public final TalkRoom abU(String str) {
        TalkRoom talkRoom = (TalkRoom) this.Anb.get(str);
        if (talkRoom != null || !j.acg(str)) {
            return talkRoom;
        }
        return (TalkRoom) this.Anb.get((String) this.Anc.get(str));
    }

    public final int abV(String str) {
        if (TextUtils.isEmpty(str)) {
            com.tencent.pb.common.c.c.m("TalkRoomManager", new Object[]{"getSelfMemberId invalid groupId"});
            return -1;
        }
        TalkRoom abU = abU(str);
        if (abU == null) {
            com.tencent.pb.common.c.c.m("TalkRoomManager", new Object[]{"getSelfMemberId TalkRoom is null  groupId: ", str});
            return -1;
        }
        d abT = abU.abT(a.cCV());
        if (abT != null) {
            com.tencent.pb.common.c.c.m("TalkRoomManager", new Object[]{"getSelfMemberId TalkRoomMember is not null groupId: ", str, " uuid: ", a.cCV(), " memberId: ", Integer.valueOf(abT.cHK())});
            return abT.cHK();
        }
        com.tencent.pb.common.c.c.m("TalkRoomManager", new Object[]{"getSelfMemberId TalkRoomMember is null"});
        return -1;
    }

    public final int abW(String str) {
        if (TextUtils.isEmpty(str)) {
            com.tencent.pb.common.c.c.m("TalkRoomManager", new Object[]{"getRountIdByGrouId invalid groupId"});
            return 0;
        }
        TalkRoom abU = abU(str);
        if (abU != null) {
            return abU.cHy();
        }
        com.tencent.pb.common.c.c.m("TalkRoomManager", new Object[]{"getRountIdByGrouId TalkRoom is null  groupId: ", str});
        return 0;
    }

    public final boolean a(String str, String str2, int i, int i2, String... strArr) {
        com.tencent.pb.common.c.c.d("TalkRoomManager", new Object[]{"newTmpGroup groupId: ", str});
        if (!j.acg(str)) {
            com.tencent.pb.common.c.c.m("TalkRoomManager", new Object[]{"newTmpGroup invalid clientGroupId"});
            return false;
        } else if (strArr == null || strArr.length == 0) {
            com.tencent.pb.common.c.c.m("TalkRoomManager", new Object[]{"newTmpGroup empty uuid array"});
            return false;
        } else {
            try {
                at atVar = new at();
                atVar.fvx = 0;
                atVar.zPg = str2;
                atVar.zPf = a.cCV();
                TalkRoom talkRoom = new TalkRoom(str, null, atVar);
                int length = strArr.length;
                for (int i3 = 0; i3 != length; i3++) {
                    String str3 = strArr[i3];
                    av avVar = new av();
                    avVar.zOC = str3;
                    avVar.zPH = a.cCV();
                    avVar.status = 20;
                    avVar.nEd = -1;
                    avVar.zPv = (int) (System.currentTimeMillis() / 1000);
                    talkRoom.a(new d(avVar, new aw()));
                }
                this.Anb.put(str, talkRoom);
                cHI();
                return true;
            } catch (Exception e) {
                com.tencent.pb.common.c.c.m("TalkRoomManager", new Object[]{"newTmpGroup err: ", e});
                return false;
            }
        }
    }

    static void cHI() {
        com.tencent.pb.common.c.c.d("TalkRoomManager", new Object[]{"asyncWriteBackCache"});
    }

    public static boolean abX(String str) {
        TalkRoom abU = cHH().abU(str);
        if (abU == null) {
            com.tencent.pb.common.c.c.m("TalkRoomManager", new Object[]{"isMySelfExit talkRoom is null"});
            return true;
        }
        d cHD = abU.cHD();
        if (cHD == null || 20 == cHD.getState()) {
            return true;
        }
        return false;
    }

    public static int abY(String str) {
        TalkRoom abU = cHH().abU(str);
        if (abU == null) {
            com.tencent.pb.common.c.c.m("TalkRoomManager", new Object[]{"getMySelfReason talkRoom is null groupId: ", str});
            return 0;
        }
        int i;
        d cHD = abU.cHD();
        if (cHD == null || cHD.Ane == null) {
            i = 0;
        } else {
            i = cHD.Ane.aAk;
        }
        com.tencent.pb.common.c.c.m("TalkRoomManager", new Object[]{"getMySelfReason groupId: ", str, " reason: ", Integer.valueOf(i)});
        return i;
    }

    public final MultiTalkGroup abZ(String str) {
        TalkRoom abU = abU(str);
        if (abU == null) {
            return null;
        }
        MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
        multiTalkGroup.zQq = abU.zQq;
        multiTalkGroup.zQr = abU.zQr;
        multiTalkGroup.zMg = abU.zMg;
        multiTalkGroup.zQs = abU.zQs;
        multiTalkGroup.zQt = abU.zQt;
        List arrayList = new ArrayList();
        List<d> cHC = abU.cHC();
        if (cHC.size() > 0) {
            for (d dVar : cHC) {
                if (dVar != null) {
                    MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
                    multiTalkGroupMember.zQv = dVar.cHJ();
                    multiTalkGroupMember.zQw = dVar.Ane != null ? dVar.Ane.zPH : "";
                    multiTalkGroupMember.aAk = dVar.Ane != null ? dVar.Ane.aAk : 0;
                    multiTalkGroupMember.status = dVar.getState();
                    int i = (dVar.Ane == null || dVar.Ane.zPv == 0) ? 0 : dVar.Ane.zPv;
                    multiTalkGroupMember.zPv = i;
                    arrayList.add(multiTalkGroupMember);
                }
            }
        }
        multiTalkGroup.zQu = arrayList;
        return multiTalkGroup;
    }
}
