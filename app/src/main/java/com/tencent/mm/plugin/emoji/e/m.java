package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.emoji.b;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreTopicUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.protocal.c.so;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class m {
    public static void a(Context context, so soVar, int i, int i2, int i3, String str, int i4) {
        Intent intent = new Intent();
        intent.setClass(context, EmojiStoreDetailUI.class);
        if (soVar != null) {
            intent.putExtra("extra_id", soVar.vIR);
            intent.putExtra("extra_name", soVar.war);
            intent.putExtra("extra_copyright", soVar.waB);
            intent.putExtra("extra_coverurl", soVar.waz);
            intent.putExtra("extra_description", soVar.was);
            intent.putExtra("extra_price", soVar.wau);
            intent.putExtra("extra_type", soVar.wav);
            intent.putExtra("extra_flag", soVar.waw);
            intent.putExtra("preceding_scence", i4);
            intent.putExtra("call_by", 1);
            intent.putExtra("check_clickflag", false);
            intent.putExtra("download_entrance_scene", i);
            if (i2 != -1) {
                intent.putExtra("extra_status", i2);
            }
            if (i3 != -1) {
                intent.putExtra("extra_progress", -1);
            }
            if (!bh.ov(str)) {
                intent.putExtra("to_talker_name", str);
            }
        } else {
            x.i("MicroMsg.emoji.EmojiUINavigatorMgr", "get detail intent failed. summary is null.");
        }
        context.startActivity(intent);
    }

    private static void a(Context context, sf sfVar, int i, int i2) {
        Intent intent = new Intent();
        intent.setClass(context, EmojiStoreDetailUI.class);
        intent.putExtra("extra_id", sfVar.vIR);
        intent.putExtra("extra_name", sfVar.fon);
        intent.putExtra("extra_description", sfVar.nfe);
        intent.putExtra("preceding_scence", i2);
        intent.putExtra("call_by", 1);
        intent.putExtra("download_entrance_scene", i);
        intent.putExtra("check_clickflag", true);
        context.startActivity(intent);
    }

    public static void a(Context context, sf sfVar, boolean z) {
        if (sfVar == null) {
            x.i("MicroMsg.emoji.EmojiUINavigatorMgr", "banner is null. do nothing");
            return;
        }
        String str;
        int i;
        String str2;
        String str3;
        String str4;
        Intent intent;
        switch (sfVar.wak) {
            case 0:
                x.i("MicroMsg.emoji.EmojiUINavigatorMgr", "MM_EMOTION_BANNER_SET_NULL do nothing");
                g.pQN.h(13223, new Object[]{Integer.valueOf(1), Integer.valueOf(sfVar.fgt), sfVar.fon, Integer.valueOf(0), Integer.valueOf(0)});
                return;
            case 1:
                if (z) {
                    a(context, sfVar, 15, 8);
                } else {
                    a(context, sfVar, 3, 5);
                }
                g.pQN.h(13223, new Object[]{Integer.valueOf(1), Integer.valueOf(sfVar.fgt), sfVar.fon, Integer.valueOf(0), Integer.valueOf(4)});
                return;
            case 2:
                String str5 = sfVar.wai;
                str = sfVar.fon;
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", str5);
                intent2.putExtra("title", str);
                b.ifs.j(intent2, context);
                g.pQN.h(13223, new Object[]{Integer.valueOf(1), Integer.valueOf(sfVar.fgt), sfVar.fon, Integer.valueOf(0), Integer.valueOf(3)});
                return;
            case 3:
                i = sfVar.fgt;
                str = sfVar.fon;
                str2 = sfVar.nfe;
                str3 = sfVar.nfT;
                str4 = sfVar.waj;
                intent = new Intent();
                intent.setClass(context, EmojiStoreTopicUI.class);
                intent.putExtra("topic_id", i);
                intent.putExtra("topic_name", str);
                intent.putExtra("topic_ad_url", str4);
                intent.putExtra("topic_icon_url", str3);
                intent.putExtra("topic_desc", str2);
                if (z) {
                    intent.putExtra("extra_scence", 15);
                } else {
                    intent.putExtra("extra_scence", 3);
                }
                context.startActivity(intent);
                g.pQN.h(13223, new Object[]{Integer.valueOf(1), Integer.valueOf(sfVar.fgt), sfVar.fon, Integer.valueOf(0), Integer.valueOf(2)});
                return;
            case 4:
                i = sfVar.fgt;
                str = sfVar.fon;
                str2 = sfVar.nfe;
                str3 = sfVar.nfT;
                str4 = sfVar.waj;
                intent = new Intent();
                intent.putExtra("set_id", i);
                intent.putExtra("headurl", str4);
                intent.putExtra("set_title", str);
                intent.putExtra("set_iconURL", str3);
                intent.putExtra("set_desc", str2);
                intent.setClass(context, EmojiStoreV2SingleProductUI.class);
                context.startActivity(intent);
                g.pQN.h(13223, new Object[]{Integer.valueOf(1), Integer.valueOf(sfVar.fgt), sfVar.fon, Integer.valueOf(0), Integer.valueOf(1)});
                return;
            default:
                x.i("MicroMsg.emoji.EmojiUINavigatorMgr", "Unkown type do nothing. SetType:%d", new Object[]{Integer.valueOf(sfVar.wak)});
                return;
        }
    }
}
