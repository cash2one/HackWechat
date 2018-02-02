package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.b.af;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class ChatroomContactUI$11 implements OnItemClickListener {
    final /* synthetic */ ChatroomContactUI yRt;

    ChatroomContactUI$11(ChatroomContactUI chatroomContactUI) {
        this.yRt = chatroomContactUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.d("MicroMsg.ChatroomContactUI", "onItemClick " + i + (ChatroomContactUI.d(this.yRt) == null ? ChatroomContactUI.d(this.yRt) : Boolean.valueOf(ChatroomContactUI.d(this.yRt).zqC)));
        if (i >= ChatroomContactUI.b(this.yRt).getHeaderViewsCount()) {
            int headerViewsCount = i - ChatroomContactUI.b(this.yRt).getHeaderViewsCount();
            if (ChatroomContactUI.d(this.yRt) == null || !ChatroomContactUI.d(this.yRt).zqC) {
                ChatroomContactUI.b(this.yRt, ((com.tencent.mm.storage.x) ChatroomContactUI.f(this.yRt).getItem(headerViewsCount)).field_username);
                return;
            }
            boolean qY = ChatroomContactUI.d(this.yRt).qY(headerViewsCount);
            boolean GQ = ChatroomContactUI.d(this.yRt).GQ(headerViewsCount);
            x.d("MicroMsg.ChatroomContactUI", "onItemClick " + GQ);
            if (GQ) {
                ChatroomContactUI.d(this.yRt).aag(ChatroomContactUI.e(this.yRt) == null ? "" : ChatroomContactUI.e(this.yRt).bUS());
            } else if (qY) {
                bek GP = ChatroomContactUI.d(this.yRt).GP(headerViewsCount);
                String str = GP.vYI.wJF;
                ar.Hg();
                af WO = c.EY().WO(str);
                if (a.fZ(WO.field_type)) {
                    r1 = new Intent();
                    r1.putExtra("Contact_User", str);
                    r1.putExtra("Contact_Scene", 3);
                    if (str != null && str.length() > 0) {
                        if (WO.cia()) {
                            g.pQN.k(10298, str + ",3");
                        }
                        e.a(r1, str);
                        d.b(this.yRt, "profile", ".ui.ContactInfoUI", r1);
                        return;
                    }
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("Contact_User", GP.vYI.wJF);
                intent.putExtra("Contact_Alias", GP.hvy);
                intent.putExtra("Contact_Nick", GP.wsB.wJF);
                intent.putExtra("Contact_Signature", GP.hvw);
                intent.putExtra("Contact_RegionCode", RegionCodeDecoder.ah(GP.hvC, GP.hvu, GP.hvv));
                intent.putExtra("Contact_Sex", GP.hvt);
                intent.putExtra("Contact_VUser_Info", GP.wvg);
                intent.putExtra("Contact_VUser_Info_Flag", GP.wvf);
                intent.putExtra("Contact_KWeibo_flag", GP.wvj);
                intent.putExtra("Contact_KWeibo", GP.wvh);
                intent.putExtra("Contact_KWeiboNick", GP.wvi);
                intent.putExtra("Contact_KSnsIFlag", GP.wvl.hvE);
                intent.putExtra("Contact_KSnsBgId", GP.wvl.hvG);
                intent.putExtra("Contact_KSnsBgUrl", GP.wvl.hvF);
                if (GP.wvm != null) {
                    try {
                        intent.putExtra("Contact_customInfo", GP.wvm.toByteArray());
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.ChatroomContactUI", e, "", new Object[0]);
                    }
                }
                if ((GP.wvf & 8) > 0) {
                    g.pQN.k(10298, str + ",3");
                }
                d.b(this.yRt, "profile", ".ui.ContactInfoUI", intent);
            } else {
                af oh = ChatroomContactUI.d(this.yRt).oh(headerViewsCount);
                if (oh == null) {
                    x.e("MicroMsg.ChatroomContactUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[]{Integer.valueOf(ChatroomContactUI.d(this.yRt).getCount()), Integer.valueOf(headerViewsCount)});
                    return;
                }
                u.l(ChatroomContactUI.e(this.yRt).bUS(), 9, 3, headerViewsCount + 1);
                String str2 = oh.field_username;
                r1 = new Intent(this.yRt.mController.xIM, ChattingUI.class);
                r1.addFlags(67108864);
                r1.putExtra("Chat_User", str2);
                r1.putExtra("Chat_Mode", 1);
                this.yRt.mController.xIM.startActivity(r1);
            }
        }
    }
}
