package com.tencent.mm.plugin.emoji.e;

import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;

public final class n {
    private static boolean lxh = false;
    private static boolean lxi = false;
    private static boolean lxj = false;
    private static boolean lxk = false;

    public static boolean aBk() {
        if ((g.zY().getInt("EmotionRewardOption", 0) & 1) == 1) {
            return false;
        }
        return true;
    }

    public static boolean aBl() {
        if ((g.zY().getInt("EmotionRewardOption", 0) & 2) == 2) {
            return false;
        }
        return true;
    }

    public static boolean aBm() {
        if ((g.zY().getInt("EmotionRewardOption", 0) & 4) == 4) {
            return true;
        }
        return false;
    }

    public static int aBn() {
        return bh.getInt(g.zY().getValue("CustomEmojiMaxSize"), 150);
    }

    public static String aBo() {
        return g.zY().getValue("C2CEmojiNotAutoDownloadTimeRange");
    }

    public static String aBp() {
        return g.zY().getValue("EmotionPanelConfigName");
    }

    public static boolean aBq() {
        if (!lxh) {
            c fn = com.tencent.mm.z.c.c.IF().fn("100296");
            int i;
            if (fn.isValid()) {
                i = bh.getInt((String) fn.chI().get("EnableEmoticonExternUrl"), 0);
            } else {
                i = 0;
            }
            int i2 = g.zY().getInt("EnableEmoticonExternUrl", 0);
            int errorCode = MMWXGFJNI.getErrorCode();
            if ((i2 & 1) != 1 && (r0 & 1) != 1) {
                lxj = false;
            } else if (aBs() || aBt()) {
                lxj = false;
            } else {
                lxj = true;
            }
            if (errorCode < 0) {
                lxj = false;
                switch (errorCode) {
                    case -906:
                        com.tencent.mm.plugin.report.service.g.pQN.a(711, 10, 1, false);
                        break;
                    case -905:
                        com.tencent.mm.plugin.report.service.g.pQN.a(711, 9, 1, false);
                        break;
                    case -904:
                        com.tencent.mm.plugin.report.service.g.pQN.a(711, 8, 1, false);
                        break;
                    case -903:
                        com.tencent.mm.plugin.report.service.g.pQN.a(711, 7, 1, false);
                        break;
                    case -902:
                        com.tencent.mm.plugin.report.service.g.pQN.a(711, 6, 1, false);
                        break;
                    case -901:
                        com.tencent.mm.plugin.report.service.g.pQN.a(711, 5, 1, false);
                        break;
                }
            }
            lxh = true;
            x.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDownload:%b", new Object[]{Boolean.valueOf(lxj)});
        }
        return lxj;
    }

    public static boolean aBr() {
        if (!lxi) {
            int i = 0;
            c fn = com.tencent.mm.z.c.c.IF().fn("100296");
            if (fn.isValid()) {
                i = bh.getInt((String) fn.chI().get("EnableEmoticonExternUrl"), 0);
            }
            int i2 = g.zY().getInt("EnableEmoticonExternUrl", 0);
            int errorCode = MMWXGFJNI.getErrorCode();
            if ((i2 & 2) == 2 || (r0 & 2) == 2) {
                if (aBs() || aBt()) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(711, 0, 1, false);
                } else {
                    lxk = true;
                    com.tencent.mm.plugin.report.service.g.pQN.a(711, 1, 1, false);
                    if (errorCode < 0) {
                        lxk = false;
                    }
                    lxi = true;
                    x.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDecode:%b", new Object[]{Boolean.valueOf(lxk)});
                }
            }
            lxk = false;
            if (errorCode < 0) {
                lxk = false;
            }
            lxi = true;
            x.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDecode:%b", new Object[]{Boolean.valueOf(lxk)});
        }
        return lxk;
    }

    private static boolean aBs() {
        try {
            ac.getContext().getPackageManager().getPackageInfo("com.google.android.wearable.app.cn", 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private static boolean aBt() {
        try {
            ac.getContext().getPackageManager().getPackageInfo("com.google.android.wearable.app", 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
