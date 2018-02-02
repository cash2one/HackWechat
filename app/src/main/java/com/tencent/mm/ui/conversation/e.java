package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.ag.f;
import com.tencent.mm.bm.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;
import com.tencent.mm.z.ak.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import junit.framework.Assert;

public final class e implements OnItemClickListener {
    private Activity activity;
    private ListView yVR;
    private g yWw;

    public e(g gVar, ListView listView, Activity activity) {
        this.yWw = gVar;
        this.yVR = listView;
        this.activity = activity;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean z = false;
        if (i >= this.yVR.getHeaderViewsCount()) {
            int headerViewsCount = i - this.yVR.getHeaderViewsCount();
            ae aeVar = (ae) this.yWw.DC(headerViewsCount);
            if (aeVar == null) {
                x.e("MicroMsg.ConversationClickListener", "null user at position = " + headerViewsCount);
                return;
            }
            boolean z2;
            if (aeVar.gc(16777216)) {
                aeVar.AU();
                ar.Hg();
                c.Fd().a(aeVar, aeVar.field_username);
            }
            if (s.gK(aeVar.field_username)) {
                if (q.Gk()) {
                    d.y(this.activity, "tmessage", ".ui.TConversationUI");
                    z2 = false;
                } else {
                    d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                    z2 = false;
                }
            } else if (s.gL(aeVar.field_username)) {
                if (q.Gj()) {
                    d.y(this.activity, "bottle", ".ui.BottleConversationUI");
                    z2 = false;
                } else {
                    d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                    z2 = false;
                }
            } else if (s.gQ(aeVar.field_username)) {
                MMAppMgr.cancelNotification(aeVar.field_username);
                d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                z2 = false;
            } else {
                if (s.gI(aeVar.field_username)) {
                    g.Dk();
                    if (bh.e((Integer) g.Dj().CU().get(17, null)) == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                        z2 = false;
                    }
                } else if (s.gV(aeVar.field_username)) {
                    if (q.Gp()) {
                        r1 = new Intent();
                        r1.addFlags(67108864);
                        r1.putExtra(DownloadSettingTable$Columns.TYPE, 20);
                        d.b(this.activity, "readerapp", ".ui.ReaderAppUI", r1);
                        z2 = false;
                    } else {
                        d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                        z2 = false;
                    }
                } else if (s.hc(aeVar.field_username)) {
                    if (q.Gq()) {
                        r1 = new Intent();
                        r1.addFlags(67108864);
                        r1.putExtra(DownloadSettingTable$Columns.TYPE, 11);
                        d.b(this.activity, "readerapp", ".ui.ReaderAppUI", r1);
                        z2 = false;
                    } else {
                        d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                        z2 = false;
                    }
                } else if (s.gN(aeVar.field_username)) {
                    d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                    z2 = false;
                } else if (s.gO(aeVar.field_username)) {
                    if (q.Gs()) {
                        d.b(this.activity, "masssend", ".ui.MassSendHistoryUI", new Intent().addFlags(67108864));
                        z2 = false;
                    } else {
                        d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aeVar.field_username));
                        z2 = false;
                    }
                } else if (s.hb(aeVar.field_username)) {
                    if (a.hfO != null) {
                        a.hfO.hL(aeVar.field_username);
                    }
                    z2 = true;
                } else if (s.hd(aeVar.field_username)) {
                    this.activity.startActivity(new Intent(this.activity, BizConversationUI.class));
                    z2 = false;
                } else if (s.gF(aeVar.field_username) && f.jX(aeVar.field_username)) {
                    if (s.gE(aeVar.field_username)) {
                        r1 = new Intent(this.activity, EnterpriseConversationUI.class);
                        r1.putExtra("enterprise_biz_name", aeVar.field_username);
                        r1.putExtra("enterprise_biz_display_name", r.gu(aeVar.field_username));
                        r1.putExtra("enterprise_from_scene", 1);
                        this.activity.startActivity(r1);
                        z2 = false;
                    } else {
                        h.bu(this.activity, this.activity.getString(R.l.ebW));
                        return;
                    }
                } else if (s.gF(aeVar.field_username) && f.eE(aeVar.field_username)) {
                    if (s.gE(aeVar.field_username)) {
                        r1 = new Intent(this.activity, BizChatConversationUI.class);
                        r1.putExtra("Contact_User", aeVar.field_username);
                        r1.putExtra("biz_chat_from_scene", 1);
                        r1.addFlags(67108864);
                        this.activity.startActivity(r1);
                        z2 = false;
                    } else {
                        h.bu(this.activity, this.activity.getString(R.l.ebW));
                        return;
                    }
                } else if (s.hm(aeVar.field_username)) {
                    r1 = new Intent();
                    r1.setClassName(this.activity, "com.tencent.mm.ui.conversation.AppBrandServiceConversationUI");
                    r1.putExtra("Contact_User", aeVar.field_username);
                    r1.putExtra("app_brand_conversation_from_scene", 1);
                    r1.addFlags(67108864);
                    this.activity.startActivity(r1);
                    z2 = false;
                }
                z2 = true;
            }
            if (z2) {
                com.tencent.mm.plugin.report.service.f.vz(9);
                LauncherUI launcherUI = (LauncherUI) this.activity;
                String str = "Launcher should not be empty.";
                if (launcherUI != null) {
                    z = true;
                }
                Assert.assertTrue(str, z);
                launcherUI.startChatting(aeVar.field_username, null, true);
            }
        }
    }
}
