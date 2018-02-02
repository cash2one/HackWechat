package com.tencent.mm.ui.bizchat;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ag.a.a;
import com.tencent.mm.ag.a.c;
import com.tencent.mm.ag.a.e;
import com.tencent.mm.ag.a.j;
import com.tencent.mm.ag.y;
import com.tencent.mm.bm.d;
import com.tencent.mm.protocal.c.hn;
import com.tencent.mm.protocal.c.hq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bizchat.BizChatSearchUI.g;

class BizChatSearchUI$2 implements OnItemClickListener {
    final /* synthetic */ BizChatSearchUI ynV;

    BizChatSearchUI$2(BizChatSearchUI bizChatSearchUI) {
        this.ynV = bizChatSearchUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        long j2 = -1;
        g Fl = BizChatSearchUI.a(this.ynV).Fl(i);
        MMActivity mMActivity = this.ynV;
        Intent intent;
        if (Fl.kTK == g.yot || Fl.kTK == g.you) {
            c cVar;
            if (Fl.data instanceof c) {
                cVar = (c) Fl.data;
                j2 = cVar != null ? cVar.field_bizChatLocalId : -1;
            } else if (Fl.data instanceof hn) {
                hq hqVar = ((hn) Fl.data).vNt;
                String str = mMActivity.kGH;
                j jVar = new j();
                jVar.field_userId = hqVar.vNr;
                jVar.field_userName = hqVar.kNz;
                jVar.field_brandUserName = str;
                jVar.field_headImageUrl = hqVar.vNl;
                jVar.field_profileUrl = hqVar.vNz;
                jVar.field_UserVersion = hqVar.ver;
                jVar.field_addMemberUrl = hqVar.vNp;
                if (!y.Mj().b(jVar) ? y.Mj().a(jVar) : true) {
                    cVar = new c();
                    cVar.field_bizChatServId = jVar.field_userId;
                    cVar.field_brandUserName = jVar.field_brandUserName;
                    cVar.field_chatName = jVar.field_userName;
                    cVar.field_chatType = 1;
                    cVar = e.e(cVar);
                    if (cVar != null) {
                        a aS = y.Mi().aS(cVar.field_bizChatLocalId);
                        aS.field_bizChatId = cVar.field_bizChatLocalId;
                        aS.field_unReadCount = 0;
                        if (bh.ov(aS.field_brandUserName)) {
                            aS.field_brandUserName = cVar.field_brandUserName;
                            aS.field_lastMsgTime = System.currentTimeMillis();
                            aS.field_flag = aS.field_lastMsgTime;
                        }
                        if (!y.Mi().b(aS)) {
                            y.Mi().a(aS);
                        }
                        j2 = cVar.field_bizChatLocalId;
                    }
                }
            }
            if (!bh.ov(mMActivity.kGH) && j2 >= 0) {
                intent = new Intent();
                intent.putExtra("Chat_User", mMActivity.kGH);
                intent.putExtra("key_biz_chat_id", j2);
                intent.putExtra("finish_direct", true);
                intent.putExtra("key_need_send_video", false);
                intent.putExtra("key_is_biz_chat", true);
                d.a(mMActivity.mController.xIM, ".ui.chatting.ChattingUI", intent);
            }
        } else if (Fl.kTK != g.yov) {
        } else {
            if (((Integer) Fl.data).intValue() == g.yoz) {
                intent = new Intent(mMActivity.mController.xIM, BizChatSearchUI.class);
                intent.putExtra("enterprise_biz_name", mMActivity.kGH);
                intent.putExtra("biz_chat_search_scene", 2);
                intent.putExtra("biz_chat_search_text", mMActivity.kGa.bUS());
                mMActivity.startActivity(intent);
            } else if (((Integer) Fl.data).intValue() == g.yoA) {
                intent = new Intent(mMActivity.mController.xIM, BizChatSearchUI.class);
                intent.putExtra("enterprise_biz_name", mMActivity.kGH);
                intent.putExtra("biz_chat_search_scene", 3);
                intent.putExtra("biz_chat_search_text", mMActivity.kGa.bUS());
                mMActivity.startActivity(intent);
            }
        }
    }
}
