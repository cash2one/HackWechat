package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.storage.w.a;

public final class k {
    private static k ouN = new k();
    public SightParams ouO;

    public static k baK() {
        return ouN;
    }

    public static d c(VideoTransPara videoTransPara) {
        switch (j.osX.gGj) {
            case 1:
                return new l(videoTransPara);
            case 2:
                return new n(videoTransPara);
            default:
                return null;
        }
    }

    public static int baL() {
        return j.osX.videoBitrate;
    }

    public static int baM() {
        return j.osX.orw;
    }

    public static boolean baN() {
        if (CaptureMMProxy.getInstance().getInt(a.xsG, 0) == 1) {
            return true;
        }
        return false;
    }

    public static String baO() {
        switch (j.osX.gGj) {
            case 1:
                return "RECORDER_TYPE_FFMPEG";
            case 2:
                return "ENCODER_MEDIACODEC";
            default:
                return "";
        }
    }
}
