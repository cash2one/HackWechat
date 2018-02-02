package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class m implements e {
    private int audioSampleRate;
    private int bitrate;
    private int mxs;
    private int ouk;
    private String ovE;
    private float ovv;

    public m(int i, String str, float f, int i2, int i3, int i4) {
        this.ouk = i;
        this.ovE = str;
        this.ovv = f;
        this.bitrate = i2;
        this.mxs = i3;
        this.audioSampleRate = i4;
        x.d("MicroMsg.MMSightMP4Muxer", "create MMSightMP4Muxer, bufId: %s, recordPath: %s, fps: %s, bitrate: %s, videoDuration: %s, audioSampleRate%s", new Object[]{Integer.valueOf(i), str, Float.valueOf(f), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
    }

    public final boolean baH() {
        String str;
        long Wq = bh.Wq();
        String Jq = d.Jq(this.ovE);
        try {
            if (!FileOp.bO(Jq)) {
                Jq = null;
            }
            str = Jq;
        } catch (Exception e) {
            str = null;
        }
        x.i("MicroMsg.MMSightMP4Muxer", "start mux, bufId: %s, aacFile: %s", new Object[]{Integer.valueOf(this.ouk), str});
        x.i("MicroMsg.MMSightMP4Muxer", "mux sight end, duration %ds, used %sms", new Object[]{Integer.valueOf(SightVideoJNI.muxing(this.ouk, str, this.audioSampleRate, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, 1, 0, this.ovE, this.ovv, Math.max(1000, this.mxs), this.bitrate, b.qsU, 8, 2, 23.0f, null, 0, false)), Long.valueOf(bh.bA(Wq))});
        if (!bh.ov(str)) {
            try {
                FileOp.deleteFile(str);
            } catch (Exception e2) {
            }
        }
        if (r2 >= 0) {
            return true;
        }
        return false;
    }
}
