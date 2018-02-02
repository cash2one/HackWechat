package com.tencent.mm.storage;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class aj {
    public String fqR = "-1";
    public boolean hVA;
    public String hVz;
    public long time;
    public String xyA = "";
    public boolean xyz;

    public static String a(String str, long j, boolean z, String str2, boolean z2, String str3) {
        int i = 1;
        StringBuilder append = new StringBuilder().append(str).append(":").append(j).append(":").append(z ? 1 : 0).append(":").append(str2).append(":").append(str3.replace(":", "*#*")).append(":");
        if (!z2) {
            i = 0;
        }
        return append.append(i).append("\n").toString();
    }

    public final String ciN() {
        int i = 1;
        StringBuilder append = new StringBuilder().append(this.hVz).append(":").append(this.time).append(":").append(this.hVA ? 1 : 0).append(":").append(this.fqR).append(":").append(this.xyA).append(":");
        if (!this.xyz) {
            i = 0;
        }
        return append.append(i).append("\n").toString();
    }

    public aj(String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.emoji.EmojiContent", "EmojiContent parse failed. content is null.");
            return;
        }
        try {
            String substring;
            int i;
            if (str.endsWith("\n")) {
                substring = str.substring(0, str.length() - 1);
            } else {
                this.xyA = str.replace(":", "*#*");
                substring = str;
            }
            String[] split = substring.split(":", 6);
            if (split.length == 4 && x.gy(split[0])) {
                i = 1;
            } else {
                i = 0;
            }
            if (split.length > i) {
                this.hVz = split[i];
            }
            if (split.length > i + 1) {
                this.time = bh.getLong(split[i + 1], 0);
            }
            if (split.length > i + 2) {
                this.hVA = split[i + 2].equals("1");
            }
            if (split.length > i + 3) {
                this.fqR = split[i + 3];
            }
            if (split.length > i + 4) {
                this.xyA = split[i + 4].replace("*#*", ":");
            }
            if (split.length > i + 5) {
                this.xyz = split[i + 5].equals("1");
            }
        } catch (Throwable e) {
            this.time = 0;
            x.e("MicroMsg.emoji.EmojiContent", "EmojiContent parse failed. Content:%s Excpetion:%s", new Object[]{str, bh.i(e)});
        }
    }

    public static aj Xp(String str) {
        return new aj(str);
    }
}
