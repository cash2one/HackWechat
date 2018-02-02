package com.tencent.mm.plugin.chatroom.d;

import android.util.Pair;
import com.tencent.mm.ad.h;
import com.tencent.mm.ad.n;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aaw;
import com.tencent.mm.protocal.c.aax;
import com.tencent.mm.protocal.c.mf;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.LinkedList;
import java.util.List;

public final class i extends k implements com.tencent.mm.network.k {
    private final String chatroomName;
    private final b gJQ;
    private e gJT = null;
    private int hEF;
    private int kZr = 0;

    static /* synthetic */ void a(i iVar, int i) {
        iVar.kZr &= i ^ -1;
        if (iVar.kZr == 0) {
            HardCoderJNI.stopPerformace(HardCoderJNI.hcUpdateChatroomEnable, iVar.hEF);
            iVar.hEF = 0;
        }
    }

    public i(String str, int i) {
        int i2;
        a aVar = new a();
        aVar.hmj = new aaw();
        aVar.hmk = new aax();
        aVar.uri = "/cgi-bin/micromsg-bin/getchatroommemberdetail";
        aVar.hmi = 551;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.chatroomName = str;
        ar.Hg();
        int chQ = c.Fh().hE(str).chQ();
        ((aaw) this.gJQ.hmg.hmo).wjU = str;
        aaw com_tencent_mm_protocal_c_aaw = (aaw) this.gJQ.hmg.hmo;
        if (chQ < i) {
            i2 = i;
        } else {
            i2 = chQ;
        }
        com_tencent_mm_protocal_c_aaw.vLa = i2;
        x.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom chatroomName:%s, oldVer:%d, localVer:%d, stack[%s]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(chQ), bh.cgy()});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 551;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.NetSceneGetChatroomMemberDetail", "onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
            aax com_tencent_mm_protocal_c_aax = (aax) this.gJQ.hmh.hmo;
            ar.Hg();
            com.tencent.mm.sdk.e.c hE = c.Fh().hE(this.chatroomName);
            long chQ = (long) hE.chQ();
            long j = 4294967295L & ((long) com_tencent_mm_protocal_c_aax.ksL);
            String str2 = "MicroMsg.NetSceneGetChatroomMemberDetail";
            String str3 = "summerChatRoom svrVer:%d, modCnt:%d， localVer:%d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(com_tencent_mm_protocal_c_aax.ksL);
            objArr[1] = Integer.valueOf(com_tencent_mm_protocal_c_aax.wjV == null ? 0 : com_tencent_mm_protocal_c_aax.wjV.kZx);
            objArr[2] = Long.valueOf(chQ);
            x.i(str2, str3, objArr);
            if (chQ >= j) {
                x.e("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom localVer[%d] serverVer[%d] is new and return", new Object[]{Long.valueOf(chQ), Long.valueOf(j)});
                this.gJT.a(i2, i3, str, this);
                return;
            }
            int i4;
            final LinkedList linkedList;
            int i5 = com_tencent_mm_protocal_c_aax.ksL;
            if (hE.b(hE.xmy)) {
                hE.chP();
            }
            hE.xmy.fAZ = i5;
            try {
                hE.field_roomdata = hE.xmy.toByteArray();
            } catch (Throwable e) {
                x.e("MicroMsg.ChatRoomMember", "exception:%s", new Object[]{bh.i(e)});
            }
            com.tencent.mm.storage.q.chS();
            if (com_tencent_mm_protocal_c_aax.wjV == null) {
                List list = null;
            } else {
                Object obj = com_tencent_mm_protocal_c_aax.wjV.vUQ;
            }
            String str4 = "MicroMsg.NetSceneGetChatroomMemberDetail";
            str2 = "summerChatRoom memInfoList size[%d]";
            Object[] objArr2 = new Object[1];
            objArr2[0] = Integer.valueOf(r15 == null ? -1 : r15.size());
            x.i(str4, str2, objArr2);
            str2 = com.tencent.mm.z.q.FS();
            if (hE.b(hE.xmy)) {
                hE.chP();
            }
            for (mf mfVar : r15) {
                if (hE.hqH.containsKey(mfVar.ksU)) {
                    com.tencent.mm.i.a.a.b bVar = (com.tencent.mm.i.a.a.b) hE.hqH.get(mfVar.ksU);
                    bVar.gBL = mfVar.vUT;
                    bVar.gBM = mfVar.vUW;
                    bVar.gBN = mfVar.vUX;
                }
            }
            hE.xmy.gBH.clear();
            for (String str5 : hE.hqH.keySet()) {
                hE.xmy.gBH.add(hE.hqH.get(str5));
            }
            hE.a(str2, hE.xmy, false);
            ar.Hg();
            c.Fh().a(hE);
            ar.Hg();
            com.tencent.mm.storage.ar EY = c.EY();
            com.tencent.mm.ad.i JQ = n.JQ();
            LinkedList linkedList2 = new LinkedList();
            LinkedList linkedList3 = new LinkedList();
            x.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom memInfoList size[%d]", new Object[]{Integer.valueOf(r15 == null ? -1 : r15.size())});
            if (((long) (r15 == null ? -1 : r15.size())) > HardCoderJNI.hcUpdateChatroomMemberCount) {
                i4 = 0;
            } else {
                int cfD;
                boolean z = HardCoderJNI.hcUpdateChatroomEnable;
                int i6 = HardCoderJNI.hcUpdateChatroomDelay;
                int i7 = HardCoderJNI.hcUpdateChatroomCPU;
                int i8 = HardCoderJNI.hcUpdateChatroomIO;
                if (HardCoderJNI.hcUpdateChatroomThr) {
                    cfD = g.Dm().cfD();
                } else {
                    cfD = 0;
                }
                i4 = HardCoderJNI.startPerformance(z, i6, i7, i8, cfD, HardCoderJNI.hcUpdateChatroomTimeout, 401, HardCoderJNI.hcUpdateChatroomAction, "MicroMsg.NetSceneGetChatroomMemberDetail");
            }
            this.hEF = i4;
            for (mf mfVar2 : r15) {
                if (!(bh.ov(mfVar2.vUV) || bh.ov(mfVar2.ksU))) {
                    h jm = JQ.jm(mfVar2.ksU);
                    if (jm == null) {
                        jm = new h();
                        jm.username = mfVar2.ksU;
                    } else {
                        jm.JH().equals(mfVar2.vUV);
                    }
                    jm.hly = mfVar2.vUU;
                    jm.hlx = mfVar2.vUV;
                    jm.fWe = 3;
                    jm.bA(!bh.ov(mfVar2.vUU));
                    linkedList3.add(jm);
                }
                com.tencent.mm.storage.x WO = EY.WO(mfVar2.ksU);
                if (WO == null) {
                    x.e("MicroMsg.NetSceneGetChatroomMemberDetail", "NetSceneGetChatroomMemberDetail memberlist username is null");
                } else if (WO.AE()) {
                    WO.dc(mfVar2.kub);
                    linkedList2.add(new Pair(mfVar2.ksU, WO));
                }
            }
            x.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update newImgFlagList size:%d, updateList size:%d", new Object[]{Integer.valueOf(linkedList3.size()), Integer.valueOf(linkedList2.size())});
            if (!linkedList3.isEmpty()) {
                this.kZr |= 1;
                linkedList = linkedList3;
                final com.tencent.mm.ad.i iVar = JQ;
                new ak(ar.Dm().oAt.getLooper(), new ak.a(this) {
                    final /* synthetic */ i kZu;

                    public final boolean uF() {
                        int size = linkedList.size() < 25 ? linkedList.size() : 25;
                        x.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img list size:%d, loopCount:%d", new Object[]{Integer.valueOf(linkedList.size()), Integer.valueOf(size)});
                        if (size == 0) {
                            i.a(this.kZu, 1);
                            x.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img done loopCount is 0");
                            return false;
                        } else if (linkedList.isEmpty()) {
                            i.a(this.kZu, 1);
                            x.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img done newImgFlagList is empty");
                            return false;
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            ar.Hg();
                            long dz = c.EV().dz(Thread.currentThread().getId());
                            for (int i = 0; i < size; i++) {
                                h hVar = (h) linkedList.poll();
                                if (hVar == null) {
                                    break;
                                }
                                iVar.a(hVar);
                            }
                            ar.Hg();
                            c.EV().fS(dz);
                            x.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img loopCount:%d, take time:%d(ms)", new Object[]{Integer.valueOf(size), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                            if (!linkedList.isEmpty()) {
                                return true;
                            }
                            i.a(this.kZu, 1);
                            x.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update img done newImgFlagList is empty");
                            return false;
                        }
                    }
                }, true).J(100, 100);
            }
            if (!linkedList2.isEmpty()) {
                this.kZr |= 2;
                linkedList = linkedList2;
                final com.tencent.mm.storage.ar arVar = EY;
                new ak(ar.Dm().oAt.getLooper(), new ak.a(this) {
                    final /* synthetic */ i kZu;

                    public final boolean uF() {
                        int size = linkedList.size() < 25 ? linkedList.size() : 25;
                        x.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg list size:%d, loopCount:%d", new Object[]{Integer.valueOf(linkedList.size()), Integer.valueOf(size)});
                        if (size == 0) {
                            i.a(this.kZu, 2);
                            x.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg done loopCount is 0");
                            return false;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        ar.Hg();
                        long dz = c.EV().dz(Thread.currentThread().getId());
                        for (int i = 0; i < size; i++) {
                            Pair pair = (Pair) linkedList.poll();
                            arVar.a((String) pair.first, (com.tencent.mm.storage.x) pair.second);
                        }
                        ar.Hg();
                        c.EV().fS(dz);
                        x.d("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg loopCount:%d, take time:%d(ms)", new Object[]{Integer.valueOf(size), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        if (!linkedList.isEmpty()) {
                            return true;
                        }
                        i.a(this.kZu, 2);
                        x.i("MicroMsg.NetSceneGetChatroomMemberDetail", "summerChatRoom update ctg done updateList is empty");
                        return false;
                    }
                }, true).J(100, 100);
            }
            this.gJT.a(i2, i3, str, this);
            return;
        }
        x.e("MicroMsg.NetSceneGetChatroomMemberDetail", "onGYNetEnd errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gJT.a(i2, i3, str, this);
    }
}
