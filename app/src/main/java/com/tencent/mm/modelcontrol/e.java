package com.tencent.mm.modelcontrol;

import com.tencent.mm.sdk.platformtools.bh;

public final class e {
    protected String hub;
    protected int huc;
    protected int hud;
    protected int hue;
    protected int huf;
    protected boolean hug;
    protected f[] huh;

    protected final void a(String str, String str2, String str3, String str4, String str5, String str6) {
        boolean z;
        this.hub = str;
        this.huc = bh.getInt(str2, 0);
        this.huc = this.huc == 0 ? 64000 : this.huc * 1000;
        this.hud = bh.getInt(str3, 1);
        this.hue = bh.getInt(str4, 2);
        this.huf = bh.getInt(str5, 1);
        if (bh.getInt(str6, 0) > 0) {
            z = true;
        } else {
            z = false;
        }
        this.hug = z;
    }

    protected final boolean Nd() {
        if (bh.ov(this.hub)) {
            return true;
        }
        return b.kK(this.hub);
    }

    protected final VideoTransPara Ne() {
        VideoTransPara videoTransPara = null;
        if (this.huh != null) {
            for (f fVar : this.huh) {
                if (fVar != null && fVar.hui <= 0 && fVar.huj >= 0) {
                    videoTransPara = new VideoTransPara();
                    videoTransPara.width = fVar.huk;
                    videoTransPara.height = fVar.hul;
                    videoTransPara.fps = fVar.hum;
                    videoTransPara.videoBitrate = fVar.hun;
                    videoTransPara.hud = this.hud;
                    videoTransPara.huc = this.huc;
                    videoTransPara.hue = this.hue;
                    videoTransPara.huf = this.huf;
                }
            }
        }
        return videoTransPara;
    }

    public final String toString() {
        return "[ busyTime " + this.hub + " audioBitrate " + this.huc + " iFrame " + this.hud + " profileIndex " + this.hue + " presetIndex " + this.huf + " isStepBr " + this.hug + " ]";
    }
}
