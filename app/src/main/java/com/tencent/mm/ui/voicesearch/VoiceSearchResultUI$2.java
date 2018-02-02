package com.tencent.mm.ui.voicesearch;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.e;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

class VoiceSearchResultUI$2 implements OnItemClickListener {
    final /* synthetic */ VoiceSearchResultUI zqL;

    VoiceSearchResultUI$2(VoiceSearchResultUI voiceSearchResultUI) {
        this.zqL = voiceSearchResultUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!VoiceSearchResultUI.a(this.zqL)) {
            g.pQN.k(10452, VoiceSearchResultUI.b(this.zqL) + "," + VoiceSearchResultUI.c(this.zqL) + "," + (VoiceSearchResultUI.d(this.zqL) == null ? 0 : VoiceSearchResultUI.d(this.zqL).length) + "," + i);
        }
        af oh = VoiceSearchResultUI.f(this.zqL).oh(i);
        Context context = this.zqL;
        String str = oh.field_username;
        String AQ = oh.AQ();
        if (str != null && str.length() > 0) {
            x.d("MicroMsg.VoiceSearchResultUI", "dealSelectContact " + str);
            Intent intent;
            if (context.showType == 3) {
                intent = new Intent();
                intent.putExtra("Select_Conv_User", str);
                context.setResult(-1, intent);
                context.finish();
            } else if (context.showType != 1 && !s.ho(str) && !s.gF(str) && !s.eV(str) && !s.gC(str) && !VoiceSearchResultUI.aaj(AQ)) {
                Intent intent2 = new Intent(context, SearchConversationResultUI.class);
                intent2.putExtra("SearchConversationResult_User", AQ);
                context.startActivity(intent2);
            } else if (context.showType == 1) {
                intent = new Intent();
                intent.putExtra("Contact_User", str);
                if (s.gC(str)) {
                    intent.putExtra("Is_group_card", true);
                }
                if (str != null && str.length() > 0) {
                    e.a(intent, str);
                    if (context.zqK) {
                        context.a(ChattingUI.class, new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true));
                        context.finish();
                        return;
                    }
                    d.b(context, "profile", ".ui.ContactInfoUI", intent);
                }
            } else if (context.showType != 2) {
            } else {
                if (bh.ov(str)) {
                    x.e("MicroMsg.VoiceSearchResultUI", "username is null " + str);
                } else if (s.gK(str)) {
                    if (q.Gl()) {
                        d.b(context.mController.xIM, "tmessage", ".ui.TConversationUI", new Intent().putExtra("finish_direct", true));
                    } else {
                        d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                    }
                } else if (s.gM(str)) {
                    if (q.Gi()) {
                        d.b(context.mController.xIM, "qmessage", ".ui.QConversationUI", new Intent().putExtra("finish_direct", true));
                    } else {
                        d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                    }
                } else if (s.gL(str)) {
                    d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                } else if (s.gQ(str)) {
                    MMAppMgr.cancelNotification(str);
                    d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                } else if (s.gI(str)) {
                    if (q.Gu()) {
                        context.a(ChattingUI.class, new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true));
                    } else {
                        d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                    }
                } else if (s.gV(str)) {
                    if (q.Gp()) {
                        intent = new Intent();
                        intent.putExtra(DownloadSettingTable$Columns.TYPE, 20);
                        d.b(context, "readerapp", ".ui.ReaderAppUI", intent);
                        return;
                    }
                    d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                } else if (s.hc(str)) {
                    if (q.Gq()) {
                        intent = new Intent();
                        intent.putExtra(DownloadSettingTable$Columns.TYPE, 11);
                        d.b(context, "readerapp", ".ui.ReaderAppUI", intent);
                        return;
                    }
                    d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                } else if (s.gN(str)) {
                    d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                } else if (s.gO(str)) {
                    if (q.Gs()) {
                        d.b(context, "masssend", ".ui.MassSendHistoryUI", new Intent().putExtra("finish_direct", true));
                    } else {
                        d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                    }
                } else if (s.gU(str)) {
                    if (q.Gm()) {
                        context.a(ChattingUI.class, new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true));
                    } else {
                        d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                    }
                } else if (s.gS(str) || s.gT(str) || s.gP(str) || s.gW(str) || s.gX(str) || s.gJ(str) || s.hf(str)) {
                    d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", str));
                } else {
                    context.a(ChattingUI.class, new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true));
                }
            }
        }
    }
}
