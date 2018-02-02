package com.tencent.mm.ui.transmit;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.jv;
import com.tencent.mm.pluginsdk.d.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t.a;
import com.tencent.mm.z.l;
import java.util.LinkedList;
import java.util.List;

class MMCreateChatroomUI$3 extends b {
    final /* synthetic */ MMCreateChatroomUI zof;

    MMCreateChatroomUI$3(MMCreateChatroomUI mMCreateChatroomUI) {
        this.zof = mMCreateChatroomUI;
        super(0);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.sdk.b.b bVar) {
        int i3 = 0;
        if (bVar instanceof jv) {
            jv jvVar = (jv) bVar;
            if (MMCreateChatroomUI.e(this.zof) != null) {
                if (MMCreateChatroomUI.f(this.zof) != null) {
                    MMCreateChatroomUI.f(this.zof).dismiss();
                    MMCreateChatroomUI.g(this.zof);
                }
                MMCreateChatroomUI.h(this.zof);
                MMCreateChatroomUI.a(this.zof, false);
                MMCreateChatroomUI.a(this.zof, jvVar.fAL.fAP);
                if (!a.a(this.zof, i, i2, str, 4)) {
                    String i4;
                    if (i == 0 && i2 == 0 && !bh.ov(MMCreateChatroomUI.i(this.zof))) {
                        l.a(MMCreateChatroomUI.i(this.zof), jvVar.fAL.fAU, this.zof.getString(R.l.dQx), false, "");
                        List list = jvVar.fAL.fAT;
                        if (list != null && list.size() > 0) {
                            List linkedList = new LinkedList();
                            while (i3 < list.size()) {
                                linkedList.add(list.get(i3));
                                i3++;
                            }
                            l.a(MMCreateChatroomUI.i(this.zof), linkedList, this.zof.getString(R.l.dQy), true, "weixin://findfriend/verifycontact/" + MMCreateChatroomUI.i(this.zof) + "/");
                        }
                        i4 = MMCreateChatroomUI.i(this.zof);
                        Intent intent = new Intent();
                        if (MMCreateChatroomUI.j(this.zof)) {
                            intent.putExtra("Chat_User", i4);
                            d.a(this.zof, ".ui.chatting.ChattingUI", intent);
                        } else {
                            intent.putExtra("Select_Contact", i4);
                            intent.putExtra("Select_Conv_User", i4);
                            intent.putExtra("Select_Contact", i4);
                            intent.putExtra("need_delete_chatroom_when_cancel", true);
                            this.zof.setResult(-1, intent);
                        }
                        this.zof.finish();
                        return;
                    }
                    String str2 = "";
                    i4 = "";
                    String string = ac.getContext().getString(R.l.dQz);
                    if (i2 == -23) {
                        str2 = this.zof.getString(R.l.eFK);
                        i4 = this.zof.getString(R.l.eFJ);
                    }
                    List list2 = jvVar.fAL.fAT;
                    List list3 = jvVar.fAL.fAR;
                    if (list2 == null || list2.size() <= 0 || (list2.size() != jvVar.fAL.fAO && (list3 == null || list3.size() <= 0 || jvVar.fAL.fAO != list2.size() + list3.size()))) {
                        list2 = jvVar.fAL.fAR;
                        if (list2 != null && list2.size() > 0 && jvVar.fAL.fAO == list2.size()) {
                            str2 = this.zof.getString(R.l.esI);
                            i4 = i4 + this.zof.getString(R.l.eiF, new Object[]{bh.d(MMCreateChatroomUI.dC(list2), string)});
                        }
                        list2 = jvVar.fAL.fAQ;
                        if (list2 != null && list2.size() > 0) {
                            str2 = this.zof.getString(R.l.esI);
                            i4 = i4 + this.zof.getString(R.l.eiI, new Object[]{bh.d(MMCreateChatroomUI.dC(list2), string)});
                        }
                        if (str2 == null || str2.length() <= 0) {
                            Toast.makeText(this.zof, this.zof.getString(R.l.eiv, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                            return;
                        }
                        h.b(this.zof, i4, str2, true);
                        return;
                    }
                    LinkedList linkedList2 = new LinkedList();
                    for (int i5 = 0; i5 < list2.size(); i5++) {
                        linkedList2.add(list2.get(i5));
                    }
                    MMCreateChatroomUI.a(this.zof, linkedList2, list3);
                }
            }
        }
    }
}
