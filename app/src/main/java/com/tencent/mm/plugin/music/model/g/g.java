package com.tencent.mm.plugin.music.model.g;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.wcdb.FileUtils;
import java.util.HashMap;
import java.util.Map;

public final class g {
    private static HashMap<Integer, Boolean> oMK = new HashMap();
    private static HashMap<Integer, Long> oML = new HashMap();

    static {
        oMK.put(Integer.valueOf(0), Boolean.valueOf(false));
        oMK.put(Integer.valueOf(1), Boolean.valueOf(false));
        oMK.put(Integer.valueOf(4), Boolean.valueOf(false));
        oMK.put(Integer.valueOf(5), Boolean.valueOf(false));
        oMK.put(Integer.valueOf(6), Boolean.valueOf(false));
        oMK.put(Integer.valueOf(7), Boolean.valueOf(false));
        oMK.put(Integer.valueOf(8), Boolean.valueOf(false));
        oMK.put(Integer.valueOf(9), Boolean.valueOf(false));
        oML.put(Integer.valueOf(0), Long.valueOf(0));
        oML.put(Integer.valueOf(1), Long.valueOf(0));
        oML.put(Integer.valueOf(4), Long.valueOf(0));
        oML.put(Integer.valueOf(5), Long.valueOf(0));
        oML.put(Integer.valueOf(6), Long.valueOf(0));
        oML.put(Integer.valueOf(7), Long.valueOf(0));
        oML.put(Integer.valueOf(8), Long.valueOf(0));
        oML.put(Integer.valueOf(9), Long.valueOf(0));
    }

    public static boolean tG(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - ((Long) oML.get(Integer.valueOf(i))).longValue() < 10000) {
            return ((Boolean) oMK.get(Integer.valueOf(i))).booleanValue();
        }
        oML.put(Integer.valueOf(i), Long.valueOf(currentTimeMillis));
        c fn = com.tencent.mm.z.c.c.IF().fn("100283");
        if (fn.isValid()) {
            Map chI = fn.chI();
            if (chI == null) {
                x.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer args == null");
                return tH(i);
            } else if (!chI.containsKey("support_player_flag")) {
                x.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer not contain the support_player_flag key");
                return tH(i);
            } else if (TextUtils.isEmpty((CharSequence) chI.get("support_player_flag"))) {
                x.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer not contain the the value is empty");
                return tH(i);
            } else {
                int intValue;
                boolean cX;
                try {
                    intValue = Integer.valueOf((String) chI.get("support_player_flag"), 16).intValue();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Music.MusicPlayerSwitcher", e, "supportQQMusicPlayer", new Object[0]);
                    intValue = 0;
                }
                x.i("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer contain support_player_flag:%s", new Object[]{r0});
                ar.Hg();
                currentTimeMillis = ((Long) com.tencent.mm.z.c.CU().get(a.xuw, Long.valueOf(0))).longValue();
                if (currentTimeMillis == 0) {
                    x.i("MicroMsg.Music.MusicPlayerSwitcher", "sequence is 0");
                    ar.Hg();
                    com.tencent.mm.z.c.CU().a(a.xuw, Long.valueOf(fn.field_sequence));
                    ar.Hg();
                    com.tencent.mm.z.c.CU().a(a.xuv, Integer.valueOf(intValue));
                    cX = cX(i, intValue);
                } else if (currentTimeMillis == fn.field_sequence) {
                    x.i("MicroMsg.Music.MusicPlayerSwitcher", "sequence is equal, check flag from local switch flag");
                    ar.Hg();
                    cX = cX(i, ((Integer) com.tencent.mm.z.c.CU().get(a.xuv, Integer.valueOf(intValue))).intValue());
                } else {
                    x.i("MicroMsg.Music.MusicPlayerSwitcher", "sequence is diff, update local data");
                    ar.Hg();
                    com.tencent.mm.z.c.CU().a(a.xuw, Long.valueOf(fn.field_sequence));
                    ar.Hg();
                    com.tencent.mm.z.c.CU().a(a.xuv, Integer.valueOf(intValue));
                    cX = cX(i, intValue);
                }
                oMK.put(Integer.valueOf(i), Boolean.valueOf(cX));
                return cX;
            }
        }
        x.e("MicroMsg.Music.MusicPlayerSwitcher", "supportQQMusicPlayer item.isValid is false");
        return tH(i);
    }

    private static boolean tH(int i) {
        ar.Hg();
        boolean cX = cX(i, ((Integer) com.tencent.mm.z.c.CU().get(a.xuv, Integer.valueOf(0))).intValue());
        x.i("MicroMsg.Music.MusicPlayerSwitcher", "checkLocalSupportPlayerFlag support_player_flag:%s", new Object[]{Integer.toHexString(r0)});
        oMK.put(Integer.valueOf(i), Boolean.valueOf(cX));
        return cX;
    }

    private static boolean cX(int i, int i2) {
        if (i == 0 && (i2 & 1) > 0) {
            x.i("MicroMsg.Music.MusicPlayerSwitcher", "support CHATTING_UI");
            return true;
        } else if (i == 1 && (i2 & 2) > 0) {
            x.i("MicroMsg.Music.MusicPlayerSwitcher", "support SNS_TIMELINE_UI");
            return true;
        } else if (i == 4 && (i2 & 4) > 0) {
            x.i("MicroMsg.Music.MusicPlayerSwitcher", "support SHAKE_MUSIC_UI");
            return true;
        } else if (i == 5 && (i2 & 8) > 0) {
            x.i("MicroMsg.Music.MusicPlayerSwitcher", "support PRODUCT_UI");
            return true;
        } else if (i == 6 && (i2 & 16) > 0) {
            x.i("MicroMsg.Music.MusicPlayerSwitcher", "support FAVORITE_UI");
            return true;
        } else if (i == 7 && (i2 & 32) > 0) {
            x.i("MicroMsg.Music.MusicPlayerSwitcher", "support WEBVIEW_UI");
            return true;
        } else if (i == 8 && (i2 & 64) > 0) {
            x.i("MicroMsg.Music.MusicPlayerSwitcher", "support SNS_USER_TIMELINE_UI");
            return true;
        } else if (i != 9 || (i2 & FileUtils.S_IWUSR) <= 0) {
            x.i("MicroMsg.Music.MusicPlayerSwitcher", "QQMusicPlayer not support this scene %d", new Object[]{Integer.valueOf(i)});
            return false;
        } else {
            x.i("MicroMsg.Music.MusicPlayerSwitcher", "support SEARCH_TIMELINE_UI");
            return true;
        }
    }
}
