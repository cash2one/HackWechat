package com.tencent.mm.modelvideo;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class p {
    private boolean hVA;
    public String hVz;
    private long time;

    public static String b(String str, long j, boolean z) {
        return str + ":" + j + ":" + (z ? 1 : 0) + "\n";
    }

    public p(String str) {
        if (str.endsWith("\n")) {
            str = str.substring(0, str.length() - 1);
        }
        String[] split = str.split(":");
        try {
            if (split.length > 0) {
                this.hVz = split[0];
            }
            if (split.length > 1) {
                this.time = bh.getLong(split[1], 0);
            }
            if (split.length > 2) {
                this.hVA = split[2].equals("1");
            }
        } catch (Exception e) {
            if (this.hVz == null) {
                this.hVz = "";
            }
            this.hVA = false;
            this.time = 0;
            x.e("MicroMsg.VideoContent", "VoiceContent parse failed.");
        }
    }
}
