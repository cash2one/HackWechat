package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ag.a.j;
import com.tencent.mm.ag.y;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.b.af;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.viewitems.ar;
import com.tencent.mm.ui.contact.e;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;

public class r$b implements OnClickListener {
    private a yqa;

    public r$b(a aVar) {
        this.yqa = aVar;
    }

    public void onClick(View view) {
        boolean z = false;
        ar arVar = (ar) view.getTag();
        String str = arVar.userName;
        if (str != null && !str.equals("")) {
            Intent intent;
            if (this.yqa.vqi) {
                Context context = this.yqa.getContext();
                intent = new Intent();
                intent.putExtra("Contact_User", str);
                intent.putExtra("Contact_Encryptusername", true);
                intent.putExtra("Contact_IsLBSFriend", true);
                intent.putExtra("Contact_IsLbsChattingProfile", true);
                d.b(context, "profile", ".ui.ContactInfoUI", intent);
            } else if (this.yqa.ywd.vnK) {
                j kk = this.yqa.ywd.ync.kk(str);
                if (kk == null) {
                    return;
                }
                if (kk == null || t.ov(kk.field_profileUrl)) {
                    str = "MicroMsg.ChattingListAvatarListener";
                    String str2 = "onClick userInfo == null:%s";
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(kk == null);
                    x.w(str, str2, objArr);
                    return;
                }
                x.i("MicroMsg.ChattingListAvatarListener", "onClick Url:%s", new Object[]{kk.field_profileUrl});
                y.Ml().aj(kk.field_userId, kk.field_brandUserName);
                intent = new Intent();
                intent.putExtra("rawUrl", kk.field_profileUrl);
                intent.putExtra("useJs", true);
                d.b(this.yqa.thisActivity(), "webview", ".ui.tools.WebViewUI", intent);
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("Contact_User", str);
                a(intent2, arVar);
                com.tencent.mm.z.ar.Hg();
                af WO = c.EY().WO(str);
                if (WO != null && ((int) WO.gJd) > 0 && com.tencent.mm.l.a.fZ(WO.field_type)) {
                    e.a(intent2, str);
                }
                if (s.eV(this.yqa.fAh.field_username)) {
                    com.tencent.mm.z.ar.Hg();
                    q hE = c.Fh().hE(this.yqa.fAh.field_username);
                    intent2.putExtra("Contact_RoomNickname", hE.gu(str));
                    intent2.putExtra("Contact_Scene", 14);
                    intent2.putExtra("Contact_ChatRoomId", this.yqa.fAh.field_username);
                    intent2.putExtra("room_name", this.yqa.fAh.field_username);
                    if (hE.field_roomowner != null) {
                        z = hE.field_roomowner.equals(com.tencent.mm.z.q.FS());
                    }
                    intent2.putExtra("Is_RoomOwner", z);
                }
                if (arVar.fEJ != null) {
                    switch (arVar.fEJ.getType()) {
                        case 55:
                        case 57:
                            intent2.putExtra("Contact_Scene", 34);
                            intent2.putExtra("Contact_IsLBSFriend", true);
                            break;
                    }
                }
                d.b(this.yqa.getContext(), "profile", ".ui.ContactInfoUI", intent2, com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX);
            }
        }
    }

    public void a(Intent intent, ar arVar) {
    }
}
