package com.tencent.mm.z;

import com.tencent.mm.a.f;
import com.tencent.mm.ad.n;
import com.tencent.mm.bq.a;
import com.tencent.mm.g.a.ao;
import com.tencent.mm.g.a.ap;
import com.tencent.mm.g.a.jx;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.chatroom.b.b;
import com.tencent.mm.plugin.chatroom.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.aqw;
import com.tencent.mm.protocal.c.arm;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.protocal.c.me;
import com.tencent.mm.protocal.c.mf;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class m {
    public static f<String, String> hfd = new f(100);

    public static boolean gb(String str) {
        q hD = ((b) g.h(b.class)).Fh().hD(str);
        return hD == null ? false : hD.chV();
    }

    public static boolean b(String str, Map<String, String> map) {
        q hD = ((b) g.h(b.class)).Fh().hD(str);
        if (hD == null) {
            return false;
        }
        for (String str2 : hD.Ms()) {
            map.put(str2, hD.gu(str2));
        }
        return true;
    }

    public static boolean gc(String str) {
        String hF = ((b) g.h(b.class)).Fh().hF(str);
        String FS = q.FS();
        if (bh.ov(hF) || bh.ov(FS) || !hF.equals(FS)) {
            return false;
        }
        return true;
    }

    public static void a(String str, q qVar, boolean z) {
        qVar.lG(z);
        ((b) g.h(b.class)).Fh().c(qVar, new String[0]);
        String FS = q.FS();
        a com_tencent_mm_protocal_c_arm = new arm();
        com_tencent_mm_protocal_c_arm.vYJ = str;
        com_tencent_mm_protocal_c_arm.ksU = FS;
        com_tencent_mm_protocal_c_arm.wza = 1;
        com_tencent_mm_protocal_c_arm.pQk = z ? 1 : 2;
        ((h) g.h(h.class)).EX().b(new e.a(49, com_tencent_mm_protocal_c_arm));
    }

    public static String B(List<String> list) {
        return b((List) list, -1);
    }

    public static String b(List<String> list, int i) {
        if (list == null || list.size() == 0) {
            return "";
        }
        String str = "";
        int i2 = i - 1;
        int i3 = 0;
        while (i3 < list.size()) {
            String str2 = (String) list.get(i3);
            if (str2.length() > 0) {
                str2 = str + ((h) g.h(h.class)).EY().WO(str2).AQ();
                if (i3 == i2 && i3 < list.size()) {
                    return str2 + "...";
                }
                if (i3 < list.size() - 1) {
                    str2 = str2 + ac.getContext().getString(c.a.dQz);
                }
            } else {
                str2 = str;
            }
            i3++;
            str = str2;
        }
        return str;
    }

    public static boolean gd(String str) {
        String str2 = (String) g.Dj().CU().get(2, null);
        List gj = gj(str);
        if (gj == null) {
            x.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is null ");
            return false;
        } else if (gj.size() != 0 && gj.contains(str2)) {
            return true;
        } else {
            x.d("MicroMsg.ChatroomMembersLogic", "getmembsersbychatroomname is list is zero or no contains user  " + gj.size() + " ");
            return false;
        }
    }

    public static boolean ge(String str) {
        if (str == null || !str.toLowerCase().endsWith("@chatroom")) {
            return false;
        }
        if (((b) g.h(b.class)).Fh().hI(str)) {
            List hH = ((b) g.h(b.class)).Fh().hH(str);
            if (hH == null || hH.size() == 0) {
                return true;
            }
            return false;
        }
        x.d("MicroMsg.ChatroomMembersLogic", "state is die");
        return true;
    }

    public static boolean gf(String str) {
        if (str == null || !str.toLowerCase().endsWith("@chatroom")) {
            return false;
        }
        x.d("MicroMsg.ChatroomMembersLogic", "updateFailState chatRoomName %s", str);
        ae Fh = ((b) g.h(b.class)).Fh();
        com.tencent.mm.sdk.e.c hD = Fh.hD(str);
        if (hD == null) {
            return false;
        }
        hD.field_roomflag = 1;
        return Fh.a(hD);
    }

    public static boolean a(String str, String str2, me meVar, String str3, com.tencent.mm.i.a.a.a aVar, com.tencent.mm.sdk.b.b bVar) {
        if ((str.toLowerCase().endsWith("@chatroom") || str.toLowerCase().endsWith("@groupcard") || str.toLowerCase().endsWith("@talkroom")) && meVar.kZx != 0) {
            ar EY = ((h) g.h(h.class)).EY();
            q hD = ((b) g.h(b.class)).Fh().hD(str);
            if (hD != null) {
                aVar.fAZ = hD.chQ();
            }
            List arrayList = new ArrayList();
            x.i("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + str + "] memCnt:" + meVar.kZx);
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = false;
            for (int i = 0; i < meVar.kZx; i++) {
                mf mfVar = (mf) meVar.vUQ.get(i);
                af WO = EY.WO(mfVar.ksU);
                if (WO == null) {
                    x.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember memberlist username is null");
                } else {
                    com.tencent.mm.i.a.a.b bVar2 = new com.tencent.mm.i.a.a.b();
                    bVar2.userName = mfVar.ksU;
                    bVar2.gBN = mfVar.vUX;
                    if (meVar.vUR == 0) {
                        bVar2.gBL = mfVar.vUT;
                        bVar2.gBM = mfVar.vUW;
                        if (!bh.ov(mfVar.vUV)) {
                            com.tencent.mm.ad.h jm = n.JQ().jm(mfVar.ksU);
                            if (jm == null) {
                                jm = new com.tencent.mm.ad.h();
                                jm.username = mfVar.ksU;
                            }
                            jm.hly = mfVar.vUU;
                            jm.hlx = mfVar.vUV;
                            jm.fWe = 3;
                            jm.bA(!bh.ov(mfVar.vUU));
                            n.JQ().a(jm);
                        }
                    }
                    if (hD != null) {
                        com.tencent.mm.i.a.a.b Wu = hD.Wu(mfVar.ksU);
                        if (Wu != null) {
                            bVar2.gBL = Wu.gBL;
                            bVar2.gBM = Wu.gBM;
                            bVar2.gBN = Wu.gBN;
                        }
                    }
                    aVar.gBH.add(bVar2);
                    if (((int) WO.gJd) == 0) {
                        WO.setUsername(mfVar.ksU);
                        if (mfVar.kub != null) {
                            WO.dc(mfVar.kub);
                        }
                        WO.Af();
                        EY.R(WO);
                        z = true;
                    }
                    arrayList.add(WO.field_username);
                }
            }
            x.i("MicroMsg.ChatroomMembersLogic", "summertt SyncAddChatroomMember listUsernames size: " + arrayList.size() + " event: " + bVar + " publish: " + z + " take[" + (System.currentTimeMillis() - currentTimeMillis) + "]ms");
            if (z) {
                com.tencent.mm.sdk.b.a.xef.m(bVar);
            } else if (hD != null) {
                q.chS();
            } else {
                x.i("MicroMsg.ChatroomMembersLogic", "ChatroomId:%s is Need Update All InviteerInfo ", str);
                ((jx) bVar).fAY.fAZ = 0;
                com.tencent.mm.sdk.b.a.xef.m(bVar);
            }
            q hD2 = ((b) g.h(b.class)).Fh().hD(str);
            if (hD2 == null) {
                hD2 = new q();
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            hD2.field_chatroomname = str;
            hD2.field_roomowner = str2;
            q cD = hD2.cD(arrayList);
            cD.field_displayname = B(arrayList);
            cD.a(str3, aVar, meVar.vUR != 0);
            currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis2;
            x.i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember replaceChatroomMember ret : %s , during : %s", Boolean.valueOf(a(hD2)), Long.valueOf(currentTimeMillis2));
            if (hD2.chR()) {
                x.i("MicroMsg.ChatroomMembersLogic", "syncAddChatroomMember OldVer:%d", Integer.valueOf(hD2.chQ()));
                com.tencent.mm.sdk.b.b aoVar = new ao();
                aoVar.foG.username = str;
                com.tencent.mm.sdk.b.a.xef.m(aoVar);
            }
            return r3;
        }
        x.e("MicroMsg.ChatroomMembersLogic", "SyncAddChatroomMember: room:[" + str + "] listCnt:" + meVar.kZx);
        return false;
    }

    public static boolean a(String str, me meVar) {
        if (meVar == null) {
            x.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] memberData is null!");
            return false;
        } else if (bh.ov(str)) {
            x.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] username is null!");
            return false;
        } else if (s.eV(str)) {
            x.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] username is not personal! :%s", str);
            return false;
        } else {
            String a = com.tencent.mm.platformtools.n.a(meVar.vUS);
            if (bh.ov(a)) {
                x.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] chatroomId is null!");
                return false;
            }
            x.i("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] chatroomId:%s size:%s", a, Integer.valueOf(meVar.vUQ.size()));
            q hD = ((b) g.h(b.class)).Fh().hD(a);
            if (hD != null && meVar.vUQ.size() > 0 && hD.Ms().contains(((mf) meVar.vUQ.get(0)).ksU)) {
                com.tencent.mm.i.a.a.b Wu = hD.Wu(((mf) meVar.vUQ.get(0)).ksU);
                if (Wu != null) {
                    x.i("MicroMsg.ChatroomMembersLogic", "oldMember contains:%s displayName:%s", r0, Wu.gBL);
                    Wu.gBN = ((mf) meVar.vUQ.get(0)).vUX;
                    a(hD);
                } else {
                    x.e("MicroMsg.ChatroomMembersLogic", "talker:%s oldMemberData is null!", r0);
                }
                return true;
            } else if (hD == null || meVar.vUQ.size() <= 0) {
                if (meVar.vUQ.size() <= 0) {
                    x.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] memberData.ChatRoomMember.size() <= 0");
                }
                if (hD != null) {
                    x.e("MicroMsg.ChatroomMembersLogic", "[updateChatroomInviteer] oldMember is null!");
                }
                return false;
            } else {
                com.tencent.mm.sdk.b.b apVar = new ap();
                apVar.foH.username = ((mf) meVar.vUQ.get(0)).ksU;
                apVar.foH.foI = ((mf) meVar.vUQ.get(0)).vUX;
                hfd.put(a + "#" + apVar.foH.username, apVar.foH.foI);
                com.tencent.mm.sdk.b.a.xef.m(apVar);
                return false;
            }
        }
    }

    public static String J(String str, String str2) {
        String str3 = str2 + "#" + str;
        if (hfd.bW(str3)) {
            return (String) hfd.get(str3);
        }
        return "";
    }

    public static boolean a(q qVar) {
        if (qVar == null) {
            x.e("MicroMsg.ChatroomMembersLogic", "updateChatroomMember error! member is null");
            return false;
        }
        boolean a = ((b) g.h(b.class)).Fh().a(qVar);
        if (a) {
            String str = qVar.field_chatroomname;
            String str2 = qVar.field_roomowner;
            x.d("MicroMsg.ChatroomMembersLogic", "update contact chatroom type to %d", Integer.valueOf(1));
            ar EY = ((h) g.h(h.class)).EY();
            com.tencent.mm.l.a WO = EY.WO(str);
            if (!(((int) WO.gJd) == 0 || bh.ov(str2) || bh.ov(q.FS()))) {
                if (str2.equals(q.FS())) {
                    WO.ga(1);
                } else {
                    WO.ga(0);
                }
                EY.a(str, WO);
            }
        }
        return a;
    }

    public static boolean a(String str, pw pwVar) {
        if (!str.toLowerCase().endsWith("@chatroom") || pwVar.kZx == 0) {
            x.e("MicroMsg.ChatroomMembersLogic", "DelChatroomMember: room:[" + str + "] listCnt:" + pwVar.kZx);
            return false;
        }
        ae Fh = ((b) g.h(b.class)).Fh();
        com.tencent.mm.sdk.e.c hD = Fh.hD(str);
        List Ww = q.Ww(hD.field_memberlist);
        x.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember before " + Ww.size());
        Iterator it = pwVar.vGF.iterator();
        while (it.hasNext()) {
            Ww.remove(com.tencent.mm.platformtools.n.a(((qf) it.next()).vYO));
        }
        x.d("MicroMsg.ChatroomMembersLogic", "DelChatroomMember after " + Ww.size());
        hD.cD(Ww).field_displayname = B(Ww);
        boolean a = Fh.a(hD);
        x.d("MicroMsg.ChatroomMembersLogic", "delChatroomMember " + a);
        return a;
    }

    public static boolean a(String str, bm bmVar) {
        if (!str.toLowerCase().endsWith("@chatroom") || bmVar.kZx == 0) {
            x.e("MicroMsg.ChatroomMembersLogic", "AddChatroomMember: room:[" + str + "] listCnt:" + bmVar.kZx);
            return false;
        }
        ArrayList arrayList = new ArrayList();
        ar EY = ((h) g.h(h.class)).EY();
        for (int i = 0; i < bmVar.kZx; i++) {
            String a = com.tencent.mm.platformtools.n.a(((aqw) bmVar.vGF.get(i)).vYO);
            if (((aqw) bmVar.vGF.get(i)).wyG == 0) {
                if (bh.ov(a)) {
                    x.e("MicroMsg.ChatroomMembersLogic", "this member name is null! chatRoomName : %s", str);
                } else {
                    af afVar;
                    com.tencent.mm.storage.x WO = EY.WO(a);
                    if (((int) WO.gJd) != 0) {
                        WO.Af();
                        EY.a(WO.field_username, WO);
                        afVar = WO;
                    } else {
                        afVar = a(WO, (aqw) bmVar.vGF.get(i));
                        EY.R(afVar);
                    }
                    arrayList.add(afVar.field_username);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        return a(str, arrayList, null);
    }

    public static boolean gg(String str) {
        if (str.toLowerCase().endsWith("@groupcard")) {
            ar EY = ((h) g.h(h.class)).EY();
            if (EY.WQ(str)) {
                EY.WU(str);
            } else {
                x.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard RoomName not exist:[" + str + "]");
            }
            return gi(str);
        }
        x.e("MicroMsg.ChatroomMembersLogic", "deleteWholeGroupcard: room:[" + str + "]");
        return false;
    }

    public static boolean gh(String str) {
        if (str.toLowerCase().endsWith("@chatroom")) {
            ar EY = ((h) g.h(h.class)).EY();
            if (EY.WQ(str)) {
                EY.WU(str);
            } else {
                x.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom RoomName not exist:[" + str + "]");
            }
            return gi(str);
        }
        x.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom: room:[" + str + "]");
        return false;
    }

    public static boolean a(String str, ArrayList<String> arrayList, String str2) {
        List gj;
        int i = 0;
        ae Fh = ((b) g.h(b.class)).Fh();
        com.tencent.mm.sdk.e.c hE = Fh.hE(str);
        if (str.endsWith("@chatroom")) {
            gj = gj(str);
        } else {
            gj = new LinkedList();
        }
        List linkedList = new LinkedList();
        if (gj != null) {
            for (int i2 = 0; i2 < gj.size(); i2++) {
                linkedList.add(gj.get(i2));
            }
            while (i < arrayList.size()) {
                if (!gj.contains(arrayList.get(i))) {
                    linkedList.add(arrayList.get(i));
                }
                i++;
            }
            if (!bh.ov(str2)) {
                hE.field_roomowner = str2;
            }
            hE.cD(linkedList).field_displayname = B(linkedList);
            return Fh.a(hE);
        }
        while (i < arrayList.size()) {
            linkedList.add(arrayList.get(i));
            i++;
        }
        if (!bh.ov(str2)) {
            hE.field_roomowner = str2;
        }
        hE.cD(linkedList).field_displayname = B(linkedList);
        hE.field_roomowner = str2;
        boolean a = Fh.a(hE);
        x.d("MicroMsg.ChatroomMembersLogic", "insertMembersByChatRoomName " + a);
        return a;
    }

    private static boolean gi(String str) {
        return ((b) g.h(b.class)).Fh().hJ(str);
    }

    public static List<String> gj(String str) {
        if (str == null) {
            x.e("MicroMsg.ChatroomMembersLogic", "chatroomName is null");
            return null;
        } else if (str.toLowerCase().endsWith("@chatroom")) {
            return ((b) g.h(b.class)).Fh().hH(str);
        } else {
            x.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: this is not room:[" + str + "]");
            return null;
        }
    }

    public static List<String> gk(String str) {
        if (str.toLowerCase().endsWith("@chatroom")) {
            return ((b) g.h(b.class)).Fh().hH(str);
        }
        x.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: room:[" + str + "]");
        return null;
    }

    public static int gl(String str) {
        List gj = gj(str);
        if (gj != null) {
            return gj.size();
        }
        x.e("MicroMsg.ChatroomMembersLogic", "getMembersByChatRoomName: get room:[" + str + "] members count fail");
        return 0;
    }

    public static List<String> gm(String str) {
        int i = 0;
        if (str.toLowerCase().endsWith("@chatroom")) {
            List<String> gj = gj(str);
            if (gj == null || gj.size() <= 0) {
                return null;
            }
            String str2 = (String) g.Dj().CU().get(2, null);
            boolean z = str2 != null && str2.length() > 0;
            Assert.assertTrue(z);
            while (i < gj.size()) {
                if (((String) gj.get(i)).equals(str2)) {
                    gj.remove(i);
                    break;
                }
                i++;
            }
            if (gj.size() <= 0) {
                return null;
            }
            return gj;
        }
        x.e("MicroMsg.ChatroomMembersLogic", "getOtherMembersByChatRoomName: room:[" + str + "]");
        return null;
    }

    public static com.tencent.mm.storage.x a(com.tencent.mm.storage.x xVar, aqw com_tencent_mm_protocal_c_aqw) {
        xVar.setUsername(com.tencent.mm.platformtools.n.a(com_tencent_mm_protocal_c_aqw.vYO));
        xVar.dc(com.tencent.mm.platformtools.n.a(com_tencent_mm_protocal_c_aqw.vYO));
        xVar.dd(com.tencent.mm.platformtools.n.a(com_tencent_mm_protocal_c_aqw.vYO));
        xVar.de(com.tencent.mm.platformtools.n.a(com_tencent_mm_protocal_c_aqw.vYx));
        xVar.eD(com_tencent_mm_protocal_c_aqw.hvt);
        xVar.da(com.tencent.mm.platformtools.n.a(com_tencent_mm_protocal_c_aqw.wyH));
        xVar.dh(com.tencent.mm.platformtools.n.a(com_tencent_mm_protocal_c_aqw.wyI));
        xVar.dg(com.tencent.mm.platformtools.n.a(com_tencent_mm_protocal_c_aqw.vYx));
        xVar.eG(com_tencent_mm_protocal_c_aqw.vXS);
        xVar.eI(com_tencent_mm_protocal_c_aqw.hvx);
        xVar.dv(RegionCodeDecoder.ah(com_tencent_mm_protocal_c_aqw.hvC, com_tencent_mm_protocal_c_aqw.hvu, com_tencent_mm_protocal_c_aqw.hvv));
        xVar.dp(com_tencent_mm_protocal_c_aqw.hvw);
        return xVar;
    }

    public static String K(String str, String str2) {
        q hD = ((b) g.h(b.class)).Fh().hD(str2);
        if (hD == null) {
            return null;
        }
        return hD.gu(str);
    }

    public static String gn(String str) {
        q hD = ((b) g.h(b.class)).Fh().hD(str);
        if (hD == null) {
            return null;
        }
        return hD.field_chatroomnotice;
    }

    public static boolean E(String str, int i) {
        q hD = ((b) g.h(b.class)).Fh().hD(str);
        if (hD == null) {
            return false;
        }
        return hD.field_chatroomVersion < i;
    }

    public static String go(String str) {
        q hD = ((b) g.h(b.class)).Fh().hD(str);
        if (hD == null) {
            return null;
        }
        return hD.field_chatroomnoticeEditor;
    }

    public static long gp(String str) {
        q hD = ((b) g.h(b.class)).Fh().hD(str);
        if (hD == null) {
            return -1;
        }
        return hD.field_chatroomnoticePublishTime;
    }

    public static void a(String str, String str2, String str3, long j, int i) {
        ae Fh = ((b) g.h(b.class)).Fh();
        com.tencent.mm.sdk.e.c hD = Fh.hD(str);
        if (hD != null) {
            hD.field_chatroomVersion = i;
            hD.field_chatroomnoticePublishTime = j;
            hD.field_chatroomnoticeEditor = str3;
            hD.field_chatroomnotice = str2;
            Fh.a(hD);
        }
    }

    public static void F(String str, int i) {
        ae Fh = ((b) g.h(b.class)).Fh();
        com.tencent.mm.sdk.e.c hD = Fh.hD(str);
        if (hD != null) {
            com.tencent.mm.i.a.a.a chW = hD.chW();
            chW.type = i;
            hD.a(str, chW, false);
            Fh.a(hD);
        }
    }
}
