package com.tencent.mm.pluginsdk.k;

@Deprecated
public final class a {
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

    public static a bZI() {
        a aVar = new a();
        aVar.fps = 30;
        aVar.fFy = 0;
        aVar.otp = 640;
        aVar.otq = 480;
        aVar.mlc = 640;
        aVar.mlb = 480;
        aVar.oto = 1440000;
        aVar.otr = 1;
        aVar.ots = 4;
        aVar.ott = "/sdcard/1.yuv";
        aVar.otx = "/sdcard/1.mp4";
        aVar.otu = "/sdcard/1.pcm";
        aVar.otw = "/sdcard/1.x264";
        aVar.oty = 0;
        aVar.hVH = 0;
        aVar.otz = 0;
        return aVar;
    }

    public static a bZJ() {
        a aVar = new a();
        aVar.fps = 30;
        aVar.fFy = 0;
        aVar.otp = otn;
        aVar.otq = otm;
        aVar.mlc = otn;
        aVar.mlb = otm;
        aVar.oto = 327680;
        aVar.otr = 4;
        aVar.ots = 1;
        aVar.ott = "/sdcard/2.yuv";
        aVar.otx = "/sdcard/2.mp4";
        aVar.otu = "/sdcard/2.pcm";
        aVar.otw = "/sdcard/2.x264";
        aVar.oty = 0;
        aVar.hVH = 0;
        aVar.otz = 0;
        return aVar;
    }
}
