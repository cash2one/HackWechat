package com.tencent.mm.plugin.multitalk.a;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.tencent.mm.au.b;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.p.a;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.plugin.voip.ui.h;
import com.tencent.mm.pluginsdk.q.f;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import com.tencent.pb.common.b.a.a$bb;
import com.tencent.pb.common.b.a.a.av;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g implements com.tencent.mm.pluginsdk.q.g {
    private List<f> avD = new ArrayList();
    private af handler = new af(Looper.getMainLooper());
    private LinkedList<String> oGF = null;
    private LinkedList<String> oGG = new LinkedList();
    private LinkedList<String> oGH = new LinkedList();

    public final LinkedList<String> bcG() {
        if (this.oGH == null) {
            this.oGH = new LinkedList();
        }
        return this.oGH;
    }

    public final synchronized void a(f fVar) {
        this.avD.add(fVar);
    }

    public final synchronized void b(f fVar) {
        this.avD.remove(fVar);
    }

    public final void Fr(String str) {
        if (s.eV(str) && Ft(str)) {
            x.i("MicroMsg.MultiTalkRoomListMsg", "isKicked! now clean banner and check if i am in multitalk.");
            ar.Hg();
            c.CU().get(2, null);
            if (o.bcV().oGi != null && o.bcV().oGi.zQs.equals(str)) {
                x.i("MicroMsg.MultiTalkRoomListMsg", "yes i am now in multitalk so i exit now!");
                o.bcV().c(false, false, false);
            }
            this.handler.postDelayed(new 1(this, str), 2000);
        }
    }

    public final boolean Fs(String str) {
        b FE = o.bcR().FE(str);
        if (FE == null || FE.field_wxGroupId == null || !FE.field_wxGroupId.equals(str)) {
            return false;
        }
        if (System.currentTimeMillis() - FE.field_createTime <= 21600000) {
            return true;
        }
        x.i("MicroMsg.MultiTalkRoomListMsg", "wxGroupId:" + str + ",is out of time 6 hours..");
        FA(str);
        return false;
    }

    public final boolean Ft(String str) {
        if (this.oGF == null) {
            bcJ();
        }
        if (this.oGF == null || !this.oGF.contains(str)) {
            return false;
        }
        return true;
    }

    public final List<String> Fu(String str) {
        List<com.tencent.mm.plugin.multitalk.b.b> FF = o.bcS().FF(str);
        List linkedList = new LinkedList();
        for (com.tencent.mm.plugin.multitalk.b.b bVar : FF) {
            linkedList.add(bVar.field_userName);
        }
        return linkedList;
    }

    public final boolean dp(String str, String str2) {
        if (o.bcS().ds(str, str2) != null) {
            return true;
        }
        return false;
    }

    public final boolean iF(String str) {
        if (this.oGF != null) {
            x.i("MicroMsg.MultiTalkRoomListMsg", "removewxGroupIdInMap:" + str);
            this.oGF.remove(str);
        } else {
            bcJ();
        }
        return o.bcR().iF(str);
    }

    public final boolean bct() {
        return o.bcV().bct();
    }

    public final boolean bcv() {
        return o.bcV().bcv();
    }

    public final boolean bcH() {
        return o.bcV().bct() && (o.bcV().oGh == e.oIz || o.bcV().oGh == e.oIy);
    }

    public final boolean Fv(String str) {
        com.tencent.mm.plugin.voip.ui.g bGk = d.bGk();
        if (bGk != null) {
            Intent intent = bGk.intent;
            if (intent != null) {
                String stringExtra = intent.getStringExtra("enterMainUiWxGroupId");
                h hVar = bGk.sss;
                if (!com.tencent.pb.common.c.g.AA(stringExtra) && str.equals(stringExtra) && hVar != null && hVar.getVisibility() == 0 && hVar.isShown()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean bcI() {
        return com.tencent.mm.plugin.voip.b.d.bIq() || o.bcV().bcv() || o.bcV().bct() || o.bcV().bcu();
    }

    public final String dq(String str, String str2) {
        com.tencent.mm.plugin.multitalk.b.b ds = o.bcS().ds(str, str2);
        if (ds != null) {
            return ds.field_inviteUserName;
        }
        return null;
    }

    public final String gu(String str) {
        return r.gu(str);
    }

    public final boolean aW(Context context) {
        return a.aW(context);
    }

    public final boolean Fw(String str) {
        b FE = o.bcR().FE(str);
        if (FE != null) {
            return com.tencent.wecall.talkroom.model.a.cHv().b(FE.field_groupId, FE.field_roomId, FE.field_roomKey, 1);
        }
        return false;
    }

    public final void Fx(String str) {
        if (this.oGG == null) {
            this.oGG = new LinkedList();
            if (!this.oGG.contains(str)) {
                this.oGG.add(str);
            }
        } else if (!this.oGG.contains(str)) {
            this.oGG.add(str);
        }
    }

    public final boolean Fy(String str) {
        b FE = o.bcR().FE(str);
        if (FE != null) {
            return o.bcU().oFQ.Fy(FE.field_groupId);
        }
        return false;
    }

    public final boolean Fz(String str) {
        b FE = o.bcR().FE(str);
        if (FE != null) {
            return o.bcU().oFQ.a(FE.field_groupId, FE.field_roomId, FE.field_roomKey, FE.field_routeId);
        }
        return false;
    }

    public final int dr(String str, String str2) {
        com.tencent.mm.plugin.multitalk.b.b ds = o.bcS().ds(str, str2);
        if (ds != null) {
            return ds.field_status;
        }
        return 30;
    }

    public final void FA(String str) {
        if (com.tencent.pb.common.c.g.isNullOrEmpty(str)) {
            x.e("MicroMsg.MultiTalkRoomListMsg", "cleanBanner failure ! wxGroupId is null or empty!");
            return;
        }
        x.i("MicroMsg.MultiTalkRoomListMsg", "cleanBanner  wxGroupId = %s", new Object[]{str});
        iF(str);
        o.bcS().iF(str);
        FD(str);
    }

    public final void a(String str, a$bb com_tencent_pb_common_b_a_a_bb) {
        x.i("MicroMsg.MultiTalkRoomListMsg", "showBanner  wxGroupId = %s", new Object[]{str});
        if (com_tencent_pb_common_b_a_a_bb != null) {
            av[] avVarArr = com_tencent_pb_common_b_a_a_bb.zOe;
            if (avVarArr != null && avVarArr.length > 0) {
                o.bcS().iF(str);
                for (av avVar : avVarArr) {
                    com.tencent.mm.plugin.multitalk.b.b bVar = new com.tencent.mm.plugin.multitalk.b.b();
                    bVar.field_wxGroupId = str;
                    bVar.field_inviteUserName = avVar.zPH;
                    bVar.field_memberUuid = (long) avVar.vCD;
                    bVar.field_userName = avVar.zOC;
                    bVar.field_status = avVar.status;
                    if (!o.bcS().a(bVar)) {
                        x.e("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[]{str, avVar.zOC, Long.valueOf(bVar.field_memberUuid), bVar.field_inviteUserName});
                    }
                    x.i("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[]{str, avVar.zOC, Long.valueOf(bVar.field_memberUuid), bVar.field_inviteUserName});
                }
            }
        }
        if (b(str, com_tencent_pb_common_b_a_a_bb)) {
            x.i("MicroMsg.MultiTalkRoomListMsg", "addwxGroupIdInMap:" + str);
            if (this.oGF == null) {
                bcJ();
                if (this.oGF != null) {
                    this.oGF.add(str);
                }
            } else if (!this.oGF.contains(str)) {
                this.oGF.add(str);
            }
        }
        FD(str);
    }

    public final void FB(String str) {
        if (this.oGG == null) {
            this.oGG = new LinkedList();
        } else {
            this.oGG.remove(str);
        }
    }

    public final boolean FC(String str) {
        if (this.oGG == null) {
            return false;
        }
        return this.oGG.contains(str);
    }

    final void FD(String str) {
        for (f 2 : this.avD) {
            this.handler.post(new 2(this, 2, str));
        }
    }

    public final b FE(String str) {
        return o.bcR().FE(str);
    }

    public final void bcJ() {
        LinkedList bcZ = o.bcR().bcZ();
        x.i("MicroMsg.MultiTalkRoomListMsg", "setMultitalkingwxGroupIdMap reset!");
        this.oGF = new LinkedList();
        Iterator it = bcZ.iterator();
        while (it.hasNext()) {
            this.oGF.add(((b) it.next()).field_wxGroupId);
        }
        com.tencent.mm.sdk.b.b mwVar = new mw();
        mwVar.fEU.type = 1;
        com.tencent.mm.sdk.b.a.xef.m(mwVar);
    }

    private static boolean b(String str, a$bb com_tencent_pb_common_b_a_a_bb) {
        int i = 0;
        if (com_tencent_pb_common_b_a_a_bb == null) {
            return false;
        }
        b bVar = new b();
        bVar.field_wxGroupId = str;
        bVar.field_groupId = com_tencent_pb_common_b_a_a_bb.groupId;
        bVar.field_roomId = com_tencent_pb_common_b_a_a_bb.slB;
        bVar.field_roomKey = com_tencent_pb_common_b_a_a_bb.slC;
        bVar.field_routeId = com_tencent_pb_common_b_a_a_bb.zMR;
        bVar.field_inviteUserName = com_tencent_pb_common_b_a_a_bb.zQd;
        av[] avVarArr = com_tencent_pb_common_b_a_a_bb.zOe;
        if (avVarArr.length > 0) {
            i = avVarArr.length;
        }
        bVar.field_memberCount = i;
        bVar.field_createTime = System.currentTimeMillis();
        if (o.bcR().FE(str) == null) {
            return o.bcR().a(bVar);
        }
        return o.bcR().b(bVar);
    }

    static boolean c(String str, a$bb com_tencent_pb_common_b_a_a_bb) {
        if (com_tencent_pb_common_b_a_a_bb == null) {
            return false;
        }
        av[] avVarArr = com_tencent_pb_common_b_a_a_bb.zOe;
        List linkedList = new LinkedList();
        for (av avVar : avVarArr) {
            linkedList.add(avVar.zOC);
        }
        ar.Hg();
        String str2 = (String) c.CU().get(2, null);
        if (str2 == null) {
            x.i("MicroMsg.MultiTalkRoomListMsg", "myUserName is null , go save delete all logic.");
            b(str, com_tencent_pb_common_b_a_a_bb);
            return true;
        }
        boolean z;
        List<com.tencent.mm.plugin.multitalk.b.b> FF = o.bcS().FF(str);
        LinkedList linkedList2 = new LinkedList();
        com.tencent.mm.plugin.multitalk.b.b bVar = null;
        for (com.tencent.mm.plugin.multitalk.b.b bVar2 : FF) {
            com.tencent.mm.plugin.multitalk.b.b bVar22;
            linkedList2.add(bVar22.field_userName);
            if (!bVar22.field_userName.equals(str2)) {
                bVar22 = bVar;
            }
            bVar = bVar22;
        }
        if (bVar == null || !linkedList.contains(str2)) {
            z = true;
        } else {
            z = true;
            for (av avVar2 : avVarArr) {
                if (!(avVar2.zOC == null || !avVar2.zOC.equals(str2) || avVar2.status == bVar.field_status)) {
                    com.tencent.mm.plugin.multitalk.b.b bVar3 = new com.tencent.mm.plugin.multitalk.b.b();
                    bVar3.field_wxGroupId = str;
                    bVar3.field_inviteUserName = avVar2.zPH;
                    bVar3.field_memberUuid = (long) avVar2.vCD;
                    bVar3.field_userName = avVar2.zOC;
                    bVar3.field_status = avVar2.status;
                    if (!o.bcS().a(bVar3)) {
                        x.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[]{str, avVar2.zOC, Long.valueOf(bVar3.field_memberUuid), bVar3.field_inviteUserName});
                        z = false;
                    }
                    x.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[]{str, avVar2.zOC, Long.valueOf(bVar3.field_memberUuid), bVar3.field_inviteUserName});
                }
            }
        }
        boolean z2 = z;
        for (av avVar3 : avVarArr) {
            if (!linkedList2.contains(avVar3.zOC)) {
                com.tencent.mm.plugin.multitalk.b.b bVar4 = new com.tencent.mm.plugin.multitalk.b.b();
                bVar4.field_wxGroupId = str;
                bVar4.field_inviteUserName = avVar3.zPH;
                bVar4.field_memberUuid = (long) avVar3.vCD;
                bVar4.field_userName = avVar3.zOC;
                bVar4.field_status = avVar3.status;
                if (!o.bcS().a(bVar4)) {
                    x.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[]{str, avVar3.zOC, Long.valueOf(bVar4.field_memberUuid), bVar4.field_inviteUserName});
                    z2 = false;
                }
                x.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[]{str, avVar3.zOC, Long.valueOf(bVar4.field_memberUuid), bVar4.field_inviteUserName});
            }
        }
        Iterator it = linkedList2.iterator();
        z = z2;
        while (it.hasNext()) {
            str2 = (String) it.next();
            if (!linkedList.contains(str2)) {
                if (o.bcS().bP(str, str2)) {
                    x.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete success for wxGroupId = " + str + ", username = " + str2);
                } else {
                    z = false;
                    x.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete fail for wxGroupId = " + str + ", username = " + str2);
                }
            }
            z = z;
        }
        return z;
    }
}
