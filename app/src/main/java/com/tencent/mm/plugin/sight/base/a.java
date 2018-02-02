package com.tencent.mm.plugin.sight.base;

import com.tencent.mm.sdk.platformtools.bh;

public final class a {
    public int height = 0;
    public int huc = 0;
    public int mxs = 0;
    public int owg = 0;
    public int qsT = 0;
    public int videoBitrate = 0;
    public int width = 0;

    public final int bsA() {
        return bh.fM((long) this.mxs);
    }

    public final String toString() {
        return "[ videoDuration: " + this.mxs + " videoBitrate: " + this.videoBitrate + " width: " + this.width + " height: " + this.height + " frameRate: " + this.owg + " audioChannel: " + this.qsT + " audioBitrate: " + this.huc + "]";
    }
}
