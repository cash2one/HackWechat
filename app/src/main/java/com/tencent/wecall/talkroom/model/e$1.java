package com.tencent.wecall.talkroom.model;

import android.widget.Toast;
import com.tencent.pb.common.b.a.a.am;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.d;
import com.tencent.pb.common.c.g;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.wecall.talkroom.model.g.a;
import java.util.List;

class e$1 implements a {
    final /* synthetic */ e Ank;

    e$1(e eVar) {
        this.Ank = eVar;
    }

    public final void p(MultiTalkGroup multiTalkGroup) {
        c.m("TalkRoomSdkApi", "onCreateRoom", multiTalkGroup);
        if (com.tencent.pb.common.a.a.zLG) {
            Toast.makeText(d.ssG, "onCreateRoom " + multiTalkGroup, 0).show();
        }
        if (e.a(this.Ank) != null) {
            e.a(this.Ank).e(multiTalkGroup);
        }
    }

    public final void IZ(int i) {
        c.d("TalkRoomSdkApi", "onOpeningChannel", Integer.valueOf(i));
    }

    public final void aWb() {
        c.m("TalkRoomSdkApi", "onInitSeccess");
        if (com.tencent.pb.common.a.a.zLG) {
            Toast.makeText(d.ssG, "onInitSeccess ", 0).show();
        }
        if (e.a(this.Ank) != null) {
            e.a(this.Ank).bcA();
        }
    }

    public final void g(MultiTalkGroup multiTalkGroup) {
        String str = a.cHv().nln;
        String str2 = null;
        if (multiTalkGroup != null) {
            str2 = multiTalkGroup.zQq;
        }
        c.l("TalkRoomSdkApi", "onMemberChange mGroupId: ", str, " groupId: ", str2, multiTalkGroup);
        if (com.tencent.pb.common.a.a.zLG) {
            Toast.makeText(d.ssG, "onMemberChange " + multiTalkGroup, 0).show();
        }
        if (g.fU(str2, str)) {
            c.cHH();
            if (c.abX(str) && a.cHv().state != 3) {
                int i;
                int i2;
                c.cHH();
                int abY = c.abY(str);
                if (abY == 104) {
                    i = -1602;
                    i2 = 325;
                } else if (abY == 2) {
                    i = -1603;
                    i2 = 326;
                } else {
                    i = -1604;
                    i2 = 328;
                }
                c.m("TalkRoomSdkApi", "onMemberChange isMySelfExit finish ", "stopstatus", Integer.valueOf(i), Integer.valueOf(i2), str2, " reason: ", Integer.valueOf(abY));
                h.Jd(i);
                a.cHv().AnF.Jh(i2);
                f cHv = a.cHv();
                abY = a.cHv().nJW;
                long j = a.cHv().Anx;
                boolean z = a.cHv().slT;
                cHv.a(str2, abY, j, false, false, false);
            }
        }
        if (e.a(this.Ank) != null) {
            e.a(this.Ank).g(multiTalkGroup);
        }
    }

    public final void g(int i, Object obj) {
        c.m("TalkRoomSdkApi", "onErr errCode: ", Integer.valueOf(i), " data: ", obj);
        if (e.a(this.Ank) != null) {
            e.a(this.Ank).g(i, obj);
        }
    }

    public final void q(MultiTalkGroup multiTalkGroup) {
        c.m("TalkRoomSdkApi", "onEnterRoom", multiTalkGroup);
        if (e.a(this.Ank) != null) {
            e.a(this.Ank).f(multiTalkGroup);
            if (com.tencent.pb.common.a.a.zLG) {
                Toast.makeText(d.ssG, "onEnterRoom " + multiTalkGroup, 0).show();
            }
        }
    }

    public final void bu(String str, boolean z) {
        c.d("TalkRoomSdkApi", "onExitRoom", str, a.cHv().nln, Boolean.valueOf(z));
    }

    public final void onStateChanged(int i) {
        c.d("TalkRoomSdkApi", "onStateChanged", Integer.valueOf(i));
    }

    public final void cHN() {
        c.d("TalkRoomSdkApi", "onSelfHoldOnBegin");
    }

    public final void cHO() {
        c.d("TalkRoomSdkApi", "onSelfHoldOnEnd");
    }

    public final void dK(String str, int i) {
        c.d("TalkRoomSdkApi", "onModifyGroupInfo", str, Integer.valueOf(i));
    }

    public final void gM(boolean z) {
        c.l("TalkRoomSdkApi", "onMuteStateChange", Boolean.valueOf(z));
        if (e.a(this.Ank) != null) {
            e.a(this.Ank).gM(z);
        }
    }

    public final void b(MultiTalkGroup multiTalkGroup) {
        c.m("TalkRoomSdkApi", "onInviteMultiTalk", multiTalkGroup);
        if (e.a(this.Ank) != null) {
            e.a(this.Ank).b(multiTalkGroup);
            if (com.tencent.pb.common.a.a.zLG) {
                Toast.makeText(d.ssG, "onInviteMultiTalk " + multiTalkGroup, 0).show();
            }
        }
    }

    public final void a(int i, MultiTalkGroup multiTalkGroup) {
        c.m("TalkRoomSdkApi", "onMisscMultiTalk", multiTalkGroup, " time: ", Integer.valueOf(i));
        if (e.a(this.Ank) != null) {
            e.a(this.Ank).d(multiTalkGroup);
            if (com.tencent.pb.common.a.a.zLG) {
                Toast.makeText(d.ssG, "onMisscMultiTalk " + multiTalkGroup, 0).show();
            }
        }
    }

    public final void dK(List<MultiTalkGroup> list) {
        c.l("TalkRoomSdkApi", "onActiveMultiTalkList ", list);
    }

    public final void cHP() {
        c.m("TalkRoomSdkApi", "onSendMsgSucc");
    }

    public final void y(String str, byte[] bArr) {
        int i = 0;
        String str2 = "TalkRoomSdkApi";
        Object[] objArr = new Object[4];
        objArr[0] = "onRcvMultiTalkMsg groupId: ";
        objArr[1] = str;
        objArr[2] = " datas size: ";
        if (bArr != null) {
            i = bArr.length;
        }
        objArr[3] = Integer.valueOf(i);
        c.m(str2, objArr);
    }

    public final void Ja(int i) {
        c.d("TalkRoomSdkApi", "onSwitchMultiTalkVideoSuss bitRate: ", Integer.valueOf(i));
        if (e.a(this.Ank) != null) {
            e.a(this.Ank).bcB();
        }
    }

    public final void bcC() {
        c.d("TalkRoomSdkApi", "onSubscribeLargeVideoSuss");
        if (e.a(this.Ank) != null) {
            e.a(this.Ank).bcC();
        }
    }

    public final void bi(List<am> list) {
        c.d("TalkRoomSdkApi", "onVideoGroupMemberChange videoUserNames: ", list);
        if (e.a(this.Ank) != null) {
            e.a(this.Ank).bi(list);
        }
    }

    public final void tf(int i) {
        c.d("TalkRoomSdkApi", "onNotifyLargeVideoSubscribersChange largeVideoSubscribersCnt: ", Integer.valueOf(i));
        if (e.a(this.Ank) != null) {
            e.a(this.Ank).tf(i);
        }
    }
}
