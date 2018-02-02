package com.tencent.wecall.talkroom.model;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.e.i;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.f;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.g;
import com.tencent.pb.common.c.h;
import com.tencent.pb.common.system.ConnectReceiver;
import com.tencent.pb.talkroom.sdk.a;
import com.tencent.pb.talkroom.sdk.d;
import com.tencent.wecall.talkroom.a.k;
import com.tencent.wecall.talkroom.a.l;
import com.tencent.wecall.talkroom.model.f.b;
import com.tencent.wecall.talkroom.model.g.10;
import com.tencent.wecall.talkroom.model.g.12;
import com.tencent.wecall.talkroom.model.g.14;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class e implements d {
    private static e Anh = null;
    private a Ang = null;
    private ConnectReceiver Ani = new ConnectReceiver();
    private g$a Anj = new 1(this);
    private final String TAG = "TalkRoomSdkApi";

    public static e cHM() {
        if (Anh == null) {
            synchronized (e.class) {
                if (Anh == null) {
                    Anh = new e();
                }
            }
        }
        return Anh;
    }

    private e() {
    }

    public static void iL(Context context) {
        com.tencent.pb.common.c.d.ssG = context;
        i.iK(context);
    }

    public final boolean a(a aVar, com.tencent.pb.talkroom.sdk.e eVar) {
        if (com.tencent.pb.common.c.d.ssG == null) {
            c.m("TalkRoomSdkApi", new Object[]{"init fail context: ", com.tencent.pb.common.c.d.ssG});
            return false;
        }
        try {
            this.Ang = aVar;
            f.a(eVar);
            f cHv = a.cHv();
            g$a com_tencent_wecall_talkroom_model_g_a = this.Anj;
            g gVar = cHv.AnN;
            synchronized (com_tencent_wecall_talkroom_model_g_a) {
                if (gVar.gxL.contains(com_tencent_wecall_talkroom_model_g_a)) {
                } else {
                    gVar.gxL.add(com_tencent_wecall_talkroom_model_g_a);
                }
            }
            f.cCH().zMs = eVar;
            a.cHu();
            a.cHw();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.setPriority(Integer.MAX_VALUE);
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            com.tencent.pb.common.c.d.ssG.registerReceiver(this.Ani, intentFilter);
            c.d("TalkRoomSdkApi", new Object[]{"init"});
            return true;
        } catch (Exception e) {
            c.m("TalkRoomSdkApi", new Object[]{"init ", e});
            return false;
        }
    }

    public final void nL(boolean z) {
        f cHv = a.cHv();
        c.m("TalkRoomService", new Object[]{"setMute isMute: ", Boolean.valueOf(z)});
        cHv.mIsMute = z;
        h.ad(new 14(cHv.AnN, z));
    }

    public final void gS(boolean z) {
        boolean gO;
        a.cHv();
        com.tencent.pb.talkroom.sdk.e cHY = f.cHY();
        if (cHY != null) {
            gO = cHY.gO(z);
        } else {
            gO = false;
        }
        c.d("TalkRoomService", new Object[]{"switchSpeakerPhone", Boolean.valueOf(z), " ret: ", Boolean.valueOf(gO), " realret: ", Boolean.valueOf(f.xQ()), " wxCallBack: ", cHY});
    }

    public final boolean cCX() {
        try {
            c.C(true, 0);
            c.m("TalkRoomSdkApi", new Object[]{"setOpenLog: isOpenSdkLog", Boolean.valueOf(true), " level: ", Integer.valueOf(0)});
            return true;
        } catch (Throwable th) {
            c.m("TalkRoomSdkApi", new Object[]{"setOpenLog: ", th});
            return false;
        }
    }

    public final boolean e(String str, String str2, List<String> list) {
        f cHv = a.cHv();
        String[] dL = f.dL(list);
        if (dL.length > 0) {
            int nextInt;
            if (TextUtils.isEmpty(null)) {
                nextInt = (new Random().nextInt() << 16) | (com.tencent.pb.a.a.a.cCV().hashCode() & 65535);
            } else {
                String str3 = null;
                String str4 = null;
                int charAt = str3.charAt(str4.length() - 1) * 256;
                int i = 0;
                String str5 = null;
                if (str5.length() > 1) {
                    str3 = null;
                    str5 = null;
                    i = str3.charAt(str5.length() - 2);
                }
                nextInt = i + charAt;
            }
            c.m("TalkRoomService", new Object[]{"createTalkRoom cliendId: ", str, " voiceSingle2MultiInfo: ", null, " memeberUuids size: ", Integer.valueOf(dL.length), "routeId", Integer.valueOf(nextInt), " context: ", null, " type: ", Integer.valueOf(0), " playId: ", Long.valueOf(0), " sdkKey: ", null});
            if (!com.tencent.pb.a.a.a.cCW()) {
                c.m("TalkRoomService", new Object[]{"createTalkRoom isAuthed: ", Boolean.valueOf(com.tencent.pb.a.a.a.cCW()), " isBindMobile: ", Boolean.valueOf(true)});
                h.a("", str, 0, 0, new String[]{"create", "req", "false", "noAuth"});
            } else if (!com.tencent.pb.common.b.h.isNetworkConnected()) {
                c.m("TalkRoomService", new Object[]{"createTalkRoom isNetworkConnected is false"});
                h.Jf(-4003);
                h.a("", str, 0, 0, new String[]{"create", "req", "false", "noNetwork"});
            } else if (cHv.bGq()) {
                if (cHv.bGq()) {
                    h.Jf(-4002);
                }
                h.a("", str, 0, 0, new String[]{"create", "req", "false", "isBusy"});
            } else if (TextUtils.isEmpty(str)) {
                c.m("TalkRoomService", new Object[]{"createTalkRoom cliendId is null"});
                h.a("", str, 0, 0, new String[]{"create", "req", "false", "cliendIdnull"});
            } else if (j.acg(str)) {
                if (c.cHH().abU(str) == null) {
                    c.cHH().a(str, str2, 0, 0, dL);
                }
                cHv.cHT();
                cHv.nY(false);
                cHv.cHQ();
                if (cHv.bES()) {
                    cHv.AnF.cIa();
                    cHv.nln = str;
                    cHv.AnR = str;
                    cHv.zMg = nextInt;
                    cHv.Anw = str;
                    cHv.setState(1);
                    cHv.slT = true;
                    f$a com_tencent_wecall_talkroom_model_f_a = new f$a(cHv);
                    com_tencent_wecall_talkroom_model_f_a.groupId = cHv.nln;
                    com_tencent_wecall_talkroom_model_f_a.Aos = dL;
                    com_tencent_wecall_talkroom_model_f_a.Aot = null;
                    com_tencent_wecall_talkroom_model_f_a.zMR = nextInt;
                    com_tencent_wecall_talkroom_model_f_a.type = 0;
                    com_tencent_wecall_talkroom_model_f_a.Aou = 0;
                    com_tencent_wecall_talkroom_model_f_a.Aov = null;
                    com_tencent_wecall_talkroom_model_f_a.Aow = false;
                    com_tencent_wecall_talkroom_model_f_a.Aox = str2;
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    obtain.obj = com_tencent_wecall_talkroom_model_f_a;
                    cHv.mHandler.removeMessages(2);
                    TalkRoom abU = c.cHH().abU(cHv.nln);
                    if (abU == null) {
                        c.m("TalkRoomManager", new Object[]{"isOnlyMySelfInGroup talkroom is null"});
                    } else {
                        List cHB = abU.cHB();
                        if (cHB == null || cHB.size() != 1) {
                            c.m("TalkRoomManager", new Object[]{"isOnlyMySelfInGroup TalkRoomMember list is not match"});
                        } else {
                            d dVar = (d) cHB.get(0);
                            if (dVar == null) {
                                c.m("TalkRoomManager", new Object[]{"isOnlyMySelfInGroup talkRoomMember is null"});
                            } else {
                                boolean cHL = dVar.cHL();
                                c.m("TalkRoomManager", new Object[]{"isOnlyMySelfInGroup ret: ", Boolean.valueOf(cHL)});
                            }
                        }
                    }
                    cHv.mHandler.sendMessage(obtain);
                    cHv.AnT = true;
                    c.m("TalkRoomSdkApi", new Object[]{"createTalkRoom clientId is: ", str, "wXgroupId: ", str2, " creatorUsrName: ", com.tencent.pb.a.a.a.cCV(), " usrnameList: ", list});
                    return str == null;
                } else {
                    c.m("TalkRoomService", new Object[]{"createTalkRoom initEngine fail"});
                    h.a("", str, 0, 0, new String[]{"create", "req", "false", "initEnginefail"});
                    cHv.nY(false);
                }
            } else {
                c.m("TalkRoomService", new Object[]{"createTalkRoom groupId is not cliend id: ", str});
                h.a("", str, 0, 0, new String[]{"create", "req", "false", "isnotcliendId"});
            }
        }
        str = null;
        c.m("TalkRoomSdkApi", new Object[]{"createTalkRoom clientId is: ", str, "wXgroupId: ", str2, " creatorUsrName: ", com.tencent.pb.a.a.a.cCV(), " usrnameList: ", list});
        if (str == null) {
        }
    }

    public final boolean dE(String str, int i) {
        f cHv = a.cHv();
        c.m("TalkRoomSdkApi", new Object[]{"enterMultiTalk multiTalkGroupid:", str, " isAccept: ", Boolean.valueOf(true), " routId: ", Integer.valueOf(i), " ret: ", cHv.a(null, str, cHv.nJW, cHv.Anx, i, 1)});
        if (cHv.a(null, str, cHv.nJW, cHv.Anx, i, 1) == b.Aoy) {
            return true;
        }
        return false;
    }

    public final boolean a(String str, int i, long j, int i2) {
        c.m("TalkRoomSdkApi", new Object[]{"enterMultiTalk multiTalkGroupid:", str, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j), " routId: ", Integer.valueOf(i2), " ret: ", a.cHv().a(null, str, i, j, i2, 100)});
        return a.cHv().a(null, str, i, j, i2, 100) == b.Aoy;
    }

    public final boolean u(String str, List<String> list) {
        if (g.fU(str, a.cHv().nln)) {
            boolean z;
            f cHv = a.cHv();
            String str2 = "TalkRoomService";
            Object[] objArr = new Object[6];
            objArr[0] = "addrTalkRoomMember";
            objArr[1] = str;
            objArr[2] = Integer.valueOf(cHv.nJW);
            objArr[3] = Long.valueOf(cHv.Anx);
            objArr[4] = " users length: ";
            objArr[5] = Integer.valueOf(list == null ? 0 : list.size());
            c.m(str2, objArr);
            cHv.AnT = false;
            if (TextUtils.isEmpty(str) || list == null) {
                z = false;
            } else if (com.tencent.pb.common.b.h.isNetworkConnected()) {
                String[] dL = f.dL(list);
                if (dL.length <= 0) {
                    c.m("TalkRoomService", new Object[]{"addTalkRoomMember users is null"});
                    z = false;
                } else {
                    z = com.tencent.pb.common.b.e.cCE().a(new com.tencent.wecall.talkroom.a.b(str, cHv.nJW, cHv.Anx, dL));
                    cHv.AnF.Q(new String[]{"add", "req", String.valueOf(z), String.valueOf(cHv.state)});
                }
            } else {
                c.m("TalkRoomService", new Object[]{"addTalkRoomMember isNetworkConnected is false"});
                z = false;
            }
            c.m("TalkRoomSdkApi", new Object[]{"addMultiTalkMember ret: ", Boolean.valueOf(z)});
            return z;
        }
        c.m("TalkRoomSdkApi", new Object[]{"addMultiTalkMember groupid is not same; multiTalkGroupid: ", str, a.cHv().nln});
        return false;
    }

    public final boolean Fy(String str) {
        if (g.fU(str, a.cHv().nln)) {
            int i = a.cHv().nJW;
            long j = a.cHv().Anx;
            boolean ah = a.cHv().ah(str, 1, 100);
            c.m("TalkRoomSdkApi", new Object[]{"exitMultiTalk groupId: ", str, " roomId: ", Integer.valueOf(i), " roomKey: ", Long.valueOf(j)});
            return ah;
        }
        c.m("TalkRoomSdkApi", new Object[]{"exitMultiTalk groupid is not same; multiTalkGroupid: ", str, a.cHv().nln});
        if (!a.cHv().acb(str)) {
            return false;
        }
        int i2;
        com.tencent.wecall.talkroom.model.f.e aca = a.cHv().aca(str);
        f cHv = a.cHv();
        if (aca == null) {
            i2 = 0;
        } else {
            i2 = aca.nDx;
        }
        if (aca == null) {
            j = 0;
        } else {
            j = aca.nDy;
        }
        cHv.b(str, i2, j, 1);
        return false;
    }

    public final List<String> aaL(String str) {
        if (g.fU(str, a.cHv().nln)) {
            TalkRoom abU = c.cHH().abU(str);
            if (abU == null) {
                c.m("TalkRoomManager", new Object[]{"getTalkingMember talkroom is null: groupId: ", str});
                return null;
            }
            List<d> cHC = abU.cHC();
            List<String> arrayList = new ArrayList();
            for (d dVar : cHC) {
                if (dVar != null) {
                    int i;
                    f cHv = a.cHv();
                    int cHK = dVar.cHK();
                    if (cHv.AnG != null) {
                        i = (com.tencent.pb.common.a.a.zLH && cHv.AnG.AmY.GetVoiceActivity(cHK) == 1) ? 1 : 0;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        arrayList.add(dVar.cHJ());
                    }
                }
            }
            return arrayList;
        }
        c.m("TalkRoomSdkApi", new Object[]{"getTalkingMember groupid is not same; multiTalkGroupid: ", str, a.cHv().nln});
        return null;
    }

    public final boolean c(int i, int i2, int i3, byte[] bArr) {
        String str = "TalkRoomSdkApi";
        Object[] objArr = new Object[8];
        objArr[0] = "handleMultiTalkResp retCode: ";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = " seq: ";
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = " cmdId: ";
        objArr[5] = Integer.valueOf(i3);
        objArr[6] = " data length: ";
        objArr[7] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        c.m(str, objArr);
        if (i == 0) {
            f.cCH().q(i2, bArr);
        } else {
            f cCH = f.cCH();
            f.a HJ = cCH.HJ(i2);
            if (HJ != null) {
                c.m("NETCMD", new Object[]{"CLTRCV FAIL", Integer.valueOf(i2), HJ.zMv, Integer.valueOf(1), Integer.valueOf(i)});
                cCH.a(HJ, -1, null);
            }
        }
        return true;
    }

    public final boolean bF(byte[] bArr) {
        f.cCH();
        c.m("TalkRoomSdkApi", new Object[]{"handleMultiTalkNotify ret: ", Integer.valueOf(f.bE(bArr))});
        if (f.bE(bArr) == 0) {
            return true;
        }
        return false;
    }

    public final boolean nM(boolean z) {
        c.m("TalkRoomSdkApi", new Object[]{"holadMultiTalk isHold", Boolean.valueOf(z)});
        f cHv;
        if (z) {
            cHv = a.cHv();
            c.d("TalkRoomService", new Object[]{"syscall", "startHoldOn"});
            cHv.Aob = true;
            cHv.nZ(false);
            h.ad(new 10(cHv.AnN));
        } else {
            cHv = a.cHv();
            c.d("TalkRoomService", new Object[]{"syscall", "endHoldOn"});
            cHv.Aob = false;
            cHv.cHR();
            if (cHv.bGq() && cHv.nTK) {
                cHv.nZ(true);
                h.ad(new 12(cHv.AnN));
            }
        }
        return true;
    }

    public final String cCY() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("client_");
        stringBuilder.append(com.tencent.pb.a.a.a.cCV());
        stringBuilder.append("_");
        stringBuilder.append(System.currentTimeMillis());
        c.m("TalkRoomSdkApi", new Object[]{"genMultiTalkClientId clientId: ", stringBuilder.toString()});
        return stringBuilder.toString();
    }

    public final void ba(int i, String str) {
        com.tencent.pb.a.a.a.HK(i);
        com.tencent.pb.a.a.a.aaK(str);
        c.m("TalkRoomSdkApi", new Object[]{"setWxUinAndUsrName uin: ", Integer.valueOf(i), " usrname: ", str});
    }

    public final boolean tg(int i) {
        if (a.cHv().bGq()) {
            c.d("TalkRoomSdkApi", new Object[]{"switchMultiTalkVideo action: ", Integer.valueOf(i)});
            f cHv = a.cHv();
            if (TextUtils.isEmpty(cHv.nln)) {
                c.m("TalkRoomService", new Object[]{"switchMultiTalkVideo mGroupId is null"});
                return false;
            }
            cHv.AnE = i;
            c.d("TalkRoomService", new Object[]{"switchMultiTalkVideo ret: ", Boolean.valueOf(com.tencent.pb.common.b.e.cCE().a(new l(cHv.nln, cHv.nJW, cHv.Anx, i)))});
            return com.tencent.pb.common.b.e.cCE().a(new l(cHv.nln, cHv.nJW, cHv.Anx, i));
        }
        c.m("TalkRoomSdkApi", new Object[]{"switchMultiTalkVideo isWorking is false"});
        return false;
    }

    public final boolean Fq(String str) {
        if (a.cHv().bGq()) {
            c.d("TalkRoomSdkApi", new Object[]{"subscribeLargeVideo ownerUserName: ", str});
            f cHv = a.cHv();
            if (TextUtils.isEmpty(cHv.nln)) {
                c.m("TalkRoomService", new Object[]{"subscribeLargeVideo mGroupId null "});
                return false;
            }
            c.d("TalkRoomService", new Object[]{"subscribeLargeVideo ret: ", Boolean.valueOf(com.tencent.pb.common.b.e.cCE().a(new k(cHv.nln, cHv.nJW, cHv.Anx, str)))});
            return com.tencent.pb.common.b.e.cCE().a(new k(cHv.nln, cHv.nJW, cHv.Anx, str));
        }
        c.m("TalkRoomSdkApi", new Object[]{"subscribeLargeVideo isWorking is false"});
        return false;
    }

    public final int a(byte[] bArr, short s, int i, int i2, int i3, int i4) {
        int SendVideo;
        f cHv = a.cHv();
        if (cHv.AnG != null) {
            c.d("TalkRoomService", new Object[]{"sendVideo ", Integer.valueOf(i), Integer.valueOf(i2)});
            SendVideo = cHv.AnG.AmY.SendVideo(bArr, s, i, i2, i3, i4);
        } else {
            SendVideo = -1;
        }
        String str = "TalkRoomSdkApi";
        Object[] objArr = new Object[12];
        objArr[0] = "sendVideo buffer size: ";
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        objArr[2] = " len: ";
        objArr[3] = Short.valueOf(s);
        objArr[4] = " w: ";
        objArr[5] = Integer.valueOf(i);
        objArr[6] = " h: ";
        objArr[7] = Integer.valueOf(i2);
        objArr[8] = " format: ";
        objArr[9] = Integer.valueOf(i3);
        objArr[10] = " mode: ";
        objArr[11] = Integer.valueOf(i4);
        c.d(str, objArr);
        return SendVideo;
    }

    public final com.tencent.pb.talkroom.sdk.f r(int[] iArr) {
        com.tencent.pb.talkroom.sdk.f fVar;
        int i = 0;
        f cHv = a.cHv();
        if (cHv.AnG != null) {
            c.d("TalkRoomService", new Object[]{"receiveVideo"});
            b bVar = cHv.AnG;
            com.tencent.pb.talkroom.sdk.f fVar2 = new com.tencent.pb.talkroom.sdk.f();
            if (iArr == null) {
                c.m("simon:TalkRoomContext", new Object[]{"receiveVideo imgBuffer is null"});
                fVar = fVar2;
            } else {
                String str;
                String str2;
                Object[] objArr;
                fVar2.ret = bVar.AmY.videoDecode(iArr);
                fVar2.zQx = iArr;
                fVar2.zQy = bVar.AmY.field_remoteImgLength;
                fVar2.zQz = bVar.AmY.field_remoteImgWidth;
                fVar2.zQA = bVar.AmY.field_remoteImgHeight;
                fVar2.zQB = bVar.AmY.field_remoteImgChannel & 16383;
                c cHH = c.cHH();
                Object obj = a.cHv().nln;
                int i2 = fVar2.zQB;
                if (TextUtils.isEmpty(obj)) {
                    c.m("TalkRoomManager", new Object[]{"getUsrNameByMemberId groupId is null memberId: ", Integer.valueOf(i2)});
                } else {
                    TalkRoom abU = cHH.abU(obj);
                    if (abU == null) {
                        c.m("TalkRoomManager", new Object[]{"getUsrNameByMemberId talkRoom is null groupId: ", obj, " memberId: ", Integer.valueOf(i2)});
                    } else {
                        for (av avVar : abU.cHE()) {
                            if (avVar != null && avVar.nEd == i2) {
                                c.d("TalkRoomManager", new Object[]{"getUsrNameByMemberId wxUserName:", avVar.zOC, " groupId: ", obj, " memberId: ", Integer.valueOf(i2)});
                                if (avVar.zOC != null) {
                                    str = avVar.zOC;
                                    fVar2.zQv = str;
                                    str2 = "simon:TalkRoomContext";
                                    objArr = new Object[4];
                                    objArr[0] = "receiveVideo imgBuffer size:";
                                    objArr[1] = Integer.valueOf(iArr != null ? 0 : iArr.length);
                                    objArr[2] = " MultiTalkVideoDecodeInfo: ";
                                    objArr[3] = fVar2;
                                    c.d(str2, objArr);
                                    fVar = fVar2;
                                }
                            }
                        }
                    }
                }
                str = "";
                fVar2.zQv = str;
                str2 = "simon:TalkRoomContext";
                objArr = new Object[4];
                objArr[0] = "receiveVideo imgBuffer size:";
                if (iArr != null) {
                }
                objArr[1] = Integer.valueOf(iArr != null ? 0 : iArr.length);
                objArr[2] = " MultiTalkVideoDecodeInfo: ";
                objArr[3] = fVar2;
                c.d(str2, objArr);
                fVar = fVar2;
            }
        } else {
            fVar = new com.tencent.pb.talkroom.sdk.f();
        }
        String str3 = "TalkRoomSdkApi";
        Object[] objArr2 = new Object[4];
        objArr2[0] = "receiveVideo imgBuffer size: ";
        if (iArr != null) {
            i = iArr.length;
        }
        objArr2[1] = Integer.valueOf(i);
        objArr2[2] = " MultiTalkVideoDecodeInfo: ";
        objArr2[3] = fVar;
        c.d(str3, objArr2);
        return fVar;
    }

    public final com.tencent.pb.talkroom.sdk.g a(byte[] bArr, int i, int i2, int i3, int i4, int[] iArr) {
        f cHv = a.cHv();
        com.tencent.pb.talkroom.sdk.g gVar = new com.tencent.pb.talkroom.sdk.g();
        if (cHv.AnG != null) {
            b bVar = cHv.AnG;
            int videoTrans = bVar.AmY.videoTrans(bArr, i, i2, i3, i4, iArr);
            gVar = new com.tencent.pb.talkroom.sdk.g();
            gVar.zQC = iArr;
            gVar.zQD = bVar.AmY.field_localImgWidth;
            gVar.zQE = bVar.AmY.field_localImgHeight;
            gVar.ret = videoTrans;
        }
        c.d("TalkRoomService", new Object[]{"videoTrans ", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), " multiTalkVideoRGBinfo: ", gVar, " engine: ", cHv.AnG});
        String str = "TalkRoomSdkApi";
        Object[] objArr = new Object[11];
        objArr[0] = "videoTrans recordData size: ";
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        objArr[2] = " len: ";
        objArr[3] = Integer.valueOf(i);
        objArr[4] = " localImg size: ";
        objArr[5] = Integer.valueOf(iArr == null ? 0 : iArr.length);
        objArr[6] = Integer.valueOf(i2);
        objArr[7] = Integer.valueOf(i3);
        objArr[8] = Integer.valueOf(i4);
        objArr[9] = " multiTalkVideoRGBinfo: ";
        objArr[10] = gVar;
        c.d(str, objArr);
        return gVar;
    }

    public final int setAppCmd(int i, byte[] bArr, int i2) {
        int i3;
        f cHv = a.cHv();
        if (cHv.AnG == null) {
            c.m("TalkRoomService", new Object[]{"setAppCmd type: ", Integer.valueOf(i), " engine is null"});
            i3 = -1;
        } else {
            i3 = cHv.AnG.AmY.setAppCmd(i, bArr, i2);
        }
        c.d("TalkRoomSdkApi", new Object[]{"setAppCmd type: ", Integer.valueOf(i), " paramLen: ", Integer.valueOf(i2), " ret: ", Integer.valueOf(i3)});
        return i3;
    }
}
