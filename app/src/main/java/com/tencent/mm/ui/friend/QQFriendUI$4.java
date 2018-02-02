package com.tencent.mm.ui.friend;

import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.g.a.lz;
import com.tencent.mm.modelfriend.ad;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.k;
import com.tencent.mm.modelfriend.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class QQFriendUI$4 implements OnItemClickListener {
    final /* synthetic */ QQFriendUI zdn;

    QQFriendUI$4(QQFriendUI qQFriendUI) {
        this.zdn = qQFriendUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        k kVar = null;
        if (i >= QQFriendUI.c(this.zdn).getHeaderViewsCount()) {
            x.i("MicroMsg.QQFriendUI", "realpostion is:%d headerViewscount:%d", new Object[]{Integer.valueOf(i - QQFriendUI.c(this.zdn).getHeaderViewsCount()), Integer.valueOf(QQFriendUI.c(this.zdn).getHeaderViewsCount())});
            ad adVar = (ad) QQFriendUI.d(this.zdn).getItem(r0);
            Intent intent;
            if (this.zdn.getIntent().getBooleanExtra("qqgroup_sendmessage", false)) {
                b lzVar = new lz();
                lzVar.fDy.opType = 0;
                lzVar.fDy.fDA = adVar.hwR + "@qqim";
                lzVar.fDy.fDB = adVar.getDisplayName();
                a.xef.m(lzVar);
                if (lzVar.fDz.fpW) {
                    intent = new Intent();
                    intent.putExtra("Chat_User", adVar.hwR + "@qqim");
                    intent.putExtra("key_need_send_video", false);
                    com.tencent.mm.plugin.c.a.ifs.e(intent, this.zdn);
                }
            } else if (adVar.hwS == 1 || adVar.hwS == 2) {
                ar.Hg();
                com.tencent.mm.storage.x WO = c.EY().WO(adVar.getUsername());
                if (WO != null && WO.cia()) {
                    g.pQN.k(10298, adVar.getUsername() + ",12");
                }
                Intent intent2 = new Intent();
                intent2.putExtra("Contact_User", adVar.getUsername());
                intent2.putExtra("Contact_Nick", adVar.vP());
                intent2.putExtra("Contact_Uin", adVar.hwR);
                intent2.putExtra("Contact_QQNick", adVar.getDisplayName());
                intent2.putExtra("Contact_Scene", 12);
                intent2.putExtra("Contact_RemarkName", adVar.Oy());
                l OF = af.OF();
                Cursor a = OF.hhp.a("select friend_ext.username,friend_ext.sex,friend_ext.personalcard,friend_ext.province,friend_ext.city,friend_ext.signature from friend_ext   where friend_ext.username = \"" + bh.ot(adVar.getUsername()) + "\"", null, 2);
                if (a != null) {
                    if (a.moveToFirst()) {
                        kVar = new k();
                        kVar.username = a.getString(0);
                        kVar.fWf = a.getInt(1);
                        kVar.fWo = a.getInt(2);
                        kVar.fWp = a.getString(3);
                        kVar.fWq = a.getString(4);
                        kVar.signature = a.getString(5);
                    }
                    a.close();
                }
                if (kVar != null) {
                    intent2.putExtra("Contact_Sex", kVar.fWf);
                }
                intent2.putExtra("Contact_ShowUserName", false);
                if (bh.ov(adVar.getUsername())) {
                    x.e("MicroMsg.QQFriendUI", "username is null. can't start contact ui. friend is:%s", new Object[]{adVar.toString()});
                    return;
                }
                com.tencent.mm.plugin.c.a.ifs.d(intent2, this.zdn);
            } else if (adVar.hwS == 0) {
                intent = new Intent(this.zdn, InviteFriendUI.class);
                intent.putExtra("friend_type", 0);
                intent.putExtra("friend_user_name", adVar.getUsername());
                intent.putExtra("friend_num", adVar.hwR);
                intent.putExtra("friend_nick", adVar.getDisplayName());
                intent.putExtra("friend_weixin_nick", adVar.vP());
                intent.putExtra("friend_scene", 12);
                this.zdn.startActivity(intent);
            }
        }
    }
}
