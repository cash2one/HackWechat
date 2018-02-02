package com.tencent.mm.plugin.mmsight.model;

import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.g.b;
import com.tencent.mm.sdk.platformtools.x;

public final class o {
    public int gGj = 1;
    public VideoTransPara oqJ;
    public int orw = -1;
    public boolean osU = false;
    public int otg = -1;
    public boolean oth = false;
    public boolean oti = false;
    public boolean otj = true;
    public boolean otk = false;
    b otl;
    public int videoBitrate;

    public static o a(int i, VideoTransPara videoTransPara) {
        o oVar;
        switch (i) {
            case 1:
                x.i("MicroMsg.RecoderParameter", "setToPresetConfig1");
                oVar = new o(2, videoTransPara);
                oVar.oti = false;
                break;
            case 2:
                x.i("MicroMsg.RecoderParameter", "setToPresetConfig2");
                oVar = new o(2, videoTransPara);
                oVar.oti = false;
                oVar = oVar.bal().bak();
                break;
            case 3:
                x.i("MicroMsg.RecoderParameter", "setToPresetConfig3");
                oVar = new o(1, videoTransPara);
                oVar.oti = false;
                break;
            case 4:
                x.i("MicroMsg.RecoderParameter", "setToPresetConfig4");
                oVar = new o(1, videoTransPara);
                oVar.oti = false;
                oVar = oVar.bal().bak();
                break;
            case 5:
                x.i("MicroMsg.RecoderParameter", "setToPresetConfig5");
                oVar = new o(2, videoTransPara);
                oVar.oti = true;
                oVar.oth = false;
                oVar = oVar.bak();
                break;
            case 6:
                x.i("MicroMsg.RecoderParameter", "setToPresetConfig6");
                oVar = new o(1, videoTransPara);
                oVar.oti = true;
                oVar = oVar.bak();
                break;
            case 7:
                x.i("MicroMsg.RecoderParameter", "setToPresetConfig7");
                oVar = new o(2, videoTransPara);
                oVar.oti = true;
                oVar = oVar.bam();
                oVar.oth = false;
                break;
            case 8:
                x.i("MicroMsg.RecoderParameter", "setToPresetConfig8");
                oVar = new o(2, videoTransPara);
                oVar.oti = true;
                oVar = oVar.bam();
                oVar.oth = true;
                break;
            case 9:
                oVar = new o(1, videoTransPara);
                oVar.oti = true;
                oVar = oVar.bam();
                oVar.oth = false;
                break;
            case 10:
                x.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
                oVar = new o(1, videoTransPara);
                oVar.oti = true;
                oVar = oVar.bam();
                oVar.oth = true;
                break;
            case 11:
                x.i("MicroMsg.RecoderParameter", "setToPresetConfig10");
                oVar = new o(2, videoTransPara);
                oVar.oti = true;
                oVar = oVar.bam();
                oVar.oth = false;
                oVar = oVar.bal();
                break;
            default:
                return null;
        }
        if (oVar == null) {
            return oVar;
        }
        oVar.otg = i;
        return oVar;
    }

    private o(int i, VideoTransPara videoTransPara) {
        this.oqJ = videoTransPara;
        this.gGj = i;
        this.videoBitrate = videoTransPara.videoBitrate;
        this.orw = videoTransPara.width;
    }

    public final o bak() {
        this.orw = 720;
        return this;
    }

    public final o bal() {
        this.videoBitrate = this.oqJ.videoBitrate * 2;
        this.otk = true;
        return this;
    }

    public final o bam() {
        this.orw = this.oqJ.width * 2;
        return this;
    }

    public final boolean ban() {
        return this.oqJ.width < this.orw;
    }

    public final String toString() {
        return String.format("mediatype %s videoBitrate : %s isEnableLandscapeMode %s needRotateEachFrame %s isNeedRealtimeScale %s resolutionLimit %s videoParams %s", new Object[]{Integer.valueOf(this.gGj), Integer.valueOf(this.videoBitrate), Boolean.valueOf(this.osU), Boolean.valueOf(this.oth), Boolean.valueOf(this.oti), Integer.valueOf(this.orw), this.oqJ});
    }
}
