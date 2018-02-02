package com.tencent.mm.compatible.d;

public final class t {
    public int gGj;
    public int gGk;
    public int gGl;
    public int gGm;
    public int gGn;
    public int gGo;
    public int gGp;
    public int gGq;
    public int gGr;
    public int gGs;
    public int gGt;

    public t() {
        reset();
    }

    public final void reset() {
        this.gGj = -1;
        this.gGk = -1;
        this.gGl = -1;
        this.gGm = -1;
        this.gGn = -1;
        this.gGo = -1;
        this.gGp = -1;
        this.gGq = -1;
        this.gGr = -1;
        this.gGs = -1;
        this.gGt = -1;
    }

    public final String toString() {
        return String.format("MMSightRecorderInfo, recorderType: %s, needRotateEachFrame: %s, enableHighResolutionRecord: %s, landscapeRecordModeEnable: %s, transcodeDecoderType: %s, mediaPlayerType : %s strategybit: %s, recorderOption: %s, useMetering: %s, transcodeEncoderType: %s, checkSendVideoBitrate: %s", new Object[]{Integer.valueOf(this.gGj), Integer.valueOf(this.gGk), Integer.valueOf(this.gGl), Integer.valueOf(this.gGm), Integer.valueOf(this.gGn), Integer.valueOf(this.gGo), Integer.valueOf(this.gGp), Integer.valueOf(this.gGq), Integer.valueOf(this.gGr), Integer.valueOf(this.gGs), Integer.valueOf(this.gGt)});
    }
}
