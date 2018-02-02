package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import com.tencent.mm.aw.b;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.c;
import com.tencent.mm.plugin.x.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.ServiceNotifySettingsUI;
import com.tencent.mm.ui.SingleChatInfoUI;
import com.tencent.mm.ui.bizchat.BizChatroomInfoUI;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.e;
import com.tencent.mm.ui.s;

class f$a extends s {
    final /* synthetic */ f yzA;

    f$a(f fVar) {
        this.yzA = fVar;
    }

    public final void bKg() {
        boolean z = false;
        this.yzA.fhr.csq().hideVKB();
        if (com.tencent.mm.z.s.hi(this.yzA.fhr.crz())) {
            this.yzA.fhr.csq().startActivity(new Intent(this.yzA.fhr.csq().getContext(), ServiceNotifySettingsUI.class));
        } else if (this.yzA.fhr.csl()) {
            f.a(this.yzA);
        } else {
            c cVar = this.yzA.ywd;
            Intent intent = new Intent();
            if (cVar.fhr.csd() && !cVar.vnK) {
                intent.putExtra("Chat_User", cVar.fhr.csi().field_username);
                intent.putExtra("RoomInfo_Id", cVar.fhr.crz());
                intent.putExtra("Is_Chatroom", cVar.fhr.cse());
                intent.putExtra("fromChatting", true);
                d.b(cVar.fhr.csq().getContext(), "chatroom", ".ui.ChatroomInfoUI", intent);
                z = true;
            } else if (cVar.vnK) {
                intent.setClass(cVar.fhr.csq().getContext(), BizChatroomInfoUI.class);
                intent.putExtra("Chat_User", cVar.fhr.csi().field_username);
                intent.putExtra("key_biz_chat_id", cVar.cti());
                if (cVar.fhr.csq().thisActivity() instanceof ChattingUI) {
                    intent.putExtra("key_biz_chat_info_from_scene", 1);
                } else {
                    intent.putExtra("key_biz_chat_info_from_scene", 2);
                }
                cVar.fhr.csq().startActivity(intent);
                z = true;
            } else if (com.tencent.mm.z.s.hk(cVar.fhr.crz()) || x.Wx(cVar.fhr.crz()) || x.Wz(cVar.fhr.crz()) || com.tencent.mm.z.s.hg(cVar.fhr.crz()) || x.gy(cVar.fhr.crz()) || cVar.fhr.csi().cia()) {
                intent = new Intent();
                e.l(intent, cVar.fhr.crz());
                intent.putExtra("Kdel_from", 0);
                Intent intent2 = cVar.fhr.csq().getContext().getIntent();
                int intExtra = intent2.getIntExtra("key_temp_session_scene", 5);
                if (intExtra == 16 || intExtra == 17 || intent2.getBooleanExtra("key_biz_profile_stay_after_follow_op", false)) {
                    intent.putExtra("Kdel_from", 1);
                    z = true;
                }
                intent.putExtra("key_biz_profile_stay_after_follow_op", z);
                if (cVar.fhr.csj() && g.Zi(cVar.fhr.crz())) {
                    if (intExtra == 16) {
                        intent.putExtra("Contact_Scene", 92);
                    } else if (intExtra == 17) {
                        intent.putExtra("Contact_Scene", 93);
                    } else if (intExtra == 18) {
                        intent.putExtra("Contact_Scene", 94);
                    } else {
                        intent.putExtra("Contact_Scene", 81);
                    }
                }
                d.b(cVar.fhr.csq().getContext(), "profile", ".ui.ContactInfoUI", intent, c.CTRL_INDEX);
                if (cVar.fhr.crz().equals("gh_43f2581f6fd6")) {
                    com.tencent.mm.plugin.sport.b.d.pY(2);
                    if (a.bfo().ig(b.hIf)) {
                        a.bfm();
                        com.tencent.mm.aw.d.ih(b.hIf);
                    }
                }
                z = true;
            }
            if (!z) {
                Intent intent3 = new Intent();
                intent3.setClass(this.yzA.fhr.csq().getContext(), SingleChatInfoUI.class);
                intent3.putExtra("Single_Chat_Talker", this.yzA.fhr.crz());
                intent3.putExtra("fromChatting", true);
                this.yzA.fhr.csq().startActivity(intent3);
            }
        }
    }
}
