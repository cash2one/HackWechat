package com.tencent.mm.plugin.mmsight.model;

public final class p {
    public static int otm = 480;
    public static int otn = 640;
    public int fFy;
    public int fps;
    public int hVH;
    public int mlb;
    public int mlc;
    public int oto;
    public int otp;
    public int otq;
    public int otr;
    public int ots;
    public String ott;
    public String otu;
    public String otv;
    public String otw;
    public String otx;
    public int oty;
    public int otz;

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fps=").append(this.fps).append('\n');
        stringBuilder.append("width=").append(this.mlb).append('\n');
        stringBuilder.append("height=").append(this.mlc).append('\n');
        stringBuilder.append("bitrate=").append(this.oto).append('\n');
        stringBuilder.append("rotate=").append(this.fFy).append('\n');
        stringBuilder.append("yuvWidth=").append(this.otq).append('\n');
        stringBuilder.append("yuvHeight=").append(this.otp).append('\n');
        stringBuilder.append("x264Speed=").append(this.otr).append('\n');
        stringBuilder.append("x264Quality=").append(this.ots).append('\n');
        stringBuilder.append("yuvFile=").append(this.ott).append('\n');
        stringBuilder.append("pcmFile=").append(this.otu).append('\n');
        stringBuilder.append("thuFile=").append(this.otv).append('\n');
        stringBuilder.append("x264File=").append(this.otw).append('\n');
        stringBuilder.append("mp4File=").append(this.otx).append('\n');
        stringBuilder.append("videoFrameCnt=").append(this.oty).append('\n');
        stringBuilder.append("videoLength=").append(this.hVH).append('\n');
        stringBuilder.append("cameraCount=").append(this.otz).append('\n');
        return stringBuilder.toString();
    }

    public static p bao() {
        p pVar = new p();
        pVar.fps = 30;
        pVar.fFy = 0;
        pVar.otp = otn;
        pVar.otq = otm;
        pVar.mlc = otn;
        pVar.mlb = otm;
        pVar.oto = 327680;
        pVar.otr = 4;
        pVar.ots = 1;
        pVar.ott = "/sdcard/2.yuv";
        pVar.otx = "/sdcard/2.mp4";
        pVar.otu = "/sdcard/2.pcm";
        pVar.otw = "/sdcard/2.x264";
        pVar.oty = 0;
        pVar.hVH = 0;
        pVar.otz = 0;
        return pVar;
    }
}
