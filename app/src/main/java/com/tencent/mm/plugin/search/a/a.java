package com.tencent.mm.plugin.search.a;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import com.tencent.wcdb.database.SQLiteGlobal;

public final class a {
    public static final SparseArray<a> qbj;

    static {
        SparseArray sparseArray = new SparseArray();
        qbj = sparseArray;
        sparseArray.put(19, new a(19, -1, ".ui.SnsTimeLineUI", "sns", ""));
        qbj.put(30, new a(19, -1, ".ui.BaseScanUI", "scanner", "", (byte) 0));
        qbj.put(18, new a(18, -1, ".ui.ShakeReportUI", "shake", ""));
        qbj.put(17, new a(17, -1, ".ui.NearbyFriendsIntroUI", "nearby", ""));
        qbj.put(16, new a(16, -1, ".ui.BottleBeachUI", "bottle", ""));
        qbj.put(31, new a(31, -1, ".ui.GameCenterUI", "game", ""));
        qbj.put(20, new a(20, -1, ".plugin.profile.ui.ContactInfoUI", "", "voiceinputapp"));
        qbj.put(21, new a(21, -1, ".plugin.profile.ui.ContactInfoUI", "", "linkedinplugin"));
        qbj.put(26, new a(26, -1, ".plugin.profile.ui.ContactInfoUI", "", "qqfriend"));
        qbj.put(29, new a(29, -1, ".plugin.profile.ui.ContactInfoUI", "", "voipapp"));
        qbj.put(23, new a(23, 1, ".ui.chatting.ChattingUI", "", "qqmail"));
        qbj.put(1, new a(1, -1, ".ui.MallIndexUI", "mall", ""));
        qbj.put(24, new a(24, 8, ".ui.chatting.ChattingUI", "", "weibo"));
        qbj.put(27, new a(27, 65536, ".ui.MassSendHistoryUI", "masssend", "masssendapp"));
        qbj.put(28, new a(28, SQLiteGlobal.journalSizeLimit, ".ui.ReaderAppUI", "readerapp", "newsapp"));
        qbj.put(32, new a(32, -1, ".ui.v2.EmojiStoreV2UI", "emoji", ""));
        qbj.put(33, new a(33, -1, ".ui.FavoriteIndexUI", "favorite", ""));
        qbj.put(34, new a(34, -1, ".ui.MallIndexUI", "mall", ""));
        qbj.put(35, new a(35, -1, ".backupmoveui.BackupUI", "backup", ""));
        qbj.put(38, new a(38, 16, ".ui.chatting.ChattingUI", "", "medianote"));
        qbj.put(39, new a(39, -1, ".ui.chatting.ChattingUI", "", "filehelper"));
        qbj.put(6, new a(6, -1, ".ui.LuckyMoneyIndexUI", "luckymoney", ""));
        qbj.put(41, new a(41, -1, ".ui.WalletOfflineEntranceUI", "offline", ""));
        qbj.put(42, new a(42, -1, ".ui.CollectAdapterUI", "collect", ""));
        qbj.put(40, new a(40, -1, ".balance.ui.WalletBalanceManagerUI", "wallet", ""));
        qbj.put(43, new a(43, -1, ".ui.chatting.ChattingUI", "", "gh_43f2581f6fd6"));
        qbj.put(50, new a(50, -1, ".ui.conversation.BizConversationUI", "app", ""));
        qbj.put(51, new a(51, -1, ".ui.setting.SettingsPrivacyUI", "setting", ""));
    }

    private static boolean ax(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("Contact_User", str);
        d.b(context, "profile", ".ui.ContactInfoUI", intent);
        return true;
    }

    public static boolean K(Context context, int i) {
        if (qbj.indexOfKey(i) < 0) {
            return false;
        }
        if (i == 30 && (com.tencent.mm.p.a.aV(context) || com.tencent.mm.p.a.aU(context))) {
            return false;
        }
        a aVar = (a) qbj.get(i);
        if (aVar.qbk != -1 && (q.Gd() & aVar.qbk) != 0) {
            return ax(context, aVar.username);
        }
        if (!bh.ov(aVar.qbl)) {
            Intent intent = new Intent();
            if (i == 28) {
                intent.putExtra(DownloadSettingTable$Columns.TYPE, 20);
            }
            if (i == 1) {
                intent.putExtra("key_native_url", "wxpay://bizmall/mobile_recharge");
            }
            intent.putExtra("animation_pop_in", aVar.qbm);
            if (i == 32) {
                g.pQN.h(12065, Integer.valueOf(6));
            }
            if (i == 6) {
                intent.putExtra("pay_channel", 15);
            }
            if (i == 31) {
                intent.putExtra("game_report_from_scene", 4);
            }
            if (i == 41) {
                intent.putExtra("key_from_scene", 5);
            }
            if (i == 42) {
                intent.putExtra("key_from_scene", 4);
            }
            if (i == 35) {
                intent.setClassName(context, "com.tencent.mm.plugin.backup.backupmoveui.BackupUI");
                MMWizardActivity.A(context, intent);
            } else if (aVar.qbl.equals("app")) {
                d.a(context, aVar.uri, intent);
            } else {
                d.b(context, aVar.qbl, aVar.uri, intent);
            }
            b.B(context, intent);
            return true;
        } else if (aVar.uri.equals(".ui.chatting.ChattingUI")) {
            String str = aVar.username;
            ar.Hg();
            if (com.tencent.mm.l.a.fZ(c.EY().WO(str).field_type)) {
                Intent intent2 = new Intent();
                intent2.putExtra("Chat_User", str);
                intent2.putExtra("finish_direct", true);
                d.a(context, ".ui.chatting.ChattingUI", intent2);
            } else {
                ax(context, str);
            }
            return true;
        } else if (aVar.uri.equals(".plugin.profile.ui.ContactInfoUI")) {
            return ax(context, aVar.username);
        } else {
            x.e("MicroMsg.Feature", "Error URI of android feature");
            return false;
        }
    }
}
