package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.api.a;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;

public final class b extends a {
    private int aef;
    private String filePath;
    private int mxs = -1;
    private MediaExtractor opL;
    private int ouk;
    private int owA = -1;
    private int owB;
    private Point owC = null;
    private Bitmap owF;
    private byte[] owG = null;
    private byte[] owH = null;
    private e owJ;
    private c owp;
    private String owr;
    private int ows;
    private int owt;
    private int owu;
    private int owv;
    private int oww;
    private int owx;
    private long owy = -1;
    private long owz = -1;
    private int videoFps;

    public b(String str, String str2, int i, int i2, int i3, int i4) {
        if (bh.ov(str) || bh.ov(str2) || i <= 0 || i2 <= 0) {
            x.e("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4)});
            return;
        }
        this.filePath = str;
        this.owr = str2;
        this.owu = i;
        this.owv = i2;
        this.oww = i3;
        this.owA = i4;
        this.owx = SightVideoJNI.getMp4Rotate(str);
        com.tencent.mm.plugin.sight.base.a Js = d.Js(str);
        if (Js != null) {
            this.ows = Js.width;
            this.owt = Js.height;
            this.mxs = Js.mxs;
            this.videoFps = Js.owg;
        }
        this.owy = 0;
        this.owz = (long) this.mxs;
        x.i("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegX264Remuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s", new Object[]{str, str2, Integer.valueOf(this.ows), Integer.valueOf(this.owt), Integer.valueOf(this.owx), Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public b(String str, String str2, int i, int i2, int i3, int i4, long j, long j2) {
        if (bh.ov(str) || bh.ov(str2) || i <= 0 || i2 <= 0) {
            x.e("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4)});
            return;
        }
        this.filePath = str;
        this.owr = str2;
        this.owu = i;
        this.owv = i2;
        this.oww = i3;
        this.owA = i4;
        this.owx = SightVideoJNI.getMp4Rotate(str);
        com.tencent.mm.plugin.sight.base.a Js = d.Js(str);
        if (Js != null) {
            this.ows = Js.width;
            this.owt = Js.height;
            this.videoFps = Js.owg;
        }
        this.owy = j;
        this.owz = j2;
        x.i("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegX264Remuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s, startTimeMs: %s, endTimeMs: %s", new Object[]{str, str2, Integer.valueOf(this.ows), Integer.valueOf(this.owt), Integer.valueOf(this.owx), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)});
    }

    public final void z(Bitmap bitmap) {
        if (bitmap != null) {
            this.owF = bitmap;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int aZQ() {
        int round = Math.round(((float) this.mxs) / 1000.0f);
        if (this.owy >= 0 && this.owz >= 0) {
            round = Math.round(((float) (this.owz - this.owy)) / 1000.0f) + 1;
        }
        this.ouk = MP4MuxerJNI.initDataBuf(round);
        this.owp = new c();
        if (this.mxs > 0) {
            round = this.owp.c(this.filePath, 0, (long) this.mxs, this.videoFps);
        } else if (this.owy < 0 || this.owz < 0) {
            x.e("MicroMsg.MMSightFFMpegX264Remuxer", "remux time error, videoDuration: %s, remuxStartTime: %s, remuxEndTime: %s", new Object[]{Integer.valueOf(this.mxs), Long.valueOf(this.owy), Long.valueOf(this.owz)});
            MP4MuxerJNI.releaseDataBuf(this.ouk);
            return -1;
        } else {
            round = this.owp.c(this.filePath, this.owy, this.owz, this.videoFps);
        }
        x.i("MicroMsg.MMSightFFMpegX264Remuxer", "decoder init ret: %s", new Object[]{Integer.valueOf(round)});
        if (round < 0) {
            MP4MuxerJNI.releaseDataBuf(this.ouk);
            return -1;
        }
        if (this.owA > 0 && this.owA < this.videoFps) {
            this.owp.owQ = (double) ((int) Math.ceil((double) (((float) this.videoFps) / ((float) this.owA))));
        }
        int min = this.owA > 0 ? Math.min(this.owA, this.videoFps) : this.videoFps;
        this.owp.owL = new 1(this);
        this.owJ = new e(this.ows, this.owt, this.owu, this.owv, this.oww, min, com.tencent.mm.plugin.sight.base.b.qsW);
        e eVar = this.owJ;
        eVar.frameCount = 0;
        MP4MuxerJNI.initH264Encoder(eVar.nUr, eVar.mvv, (float) eVar.owg, eVar.bitrate, eVar.huf, 8, eVar.hue, 23.0f);
        eVar.owV = new e.a(eVar, (byte) 0);
        eVar.owW = e.b(eVar.owV, "MediaCodecFFMpegTranscoder_Encoder");
        eVar.owW.start();
        eVar.fAs = false;
        x.i("MicroMsg.MMSightRemuxX264Encoder", "initAndStartEncoder");
        this.owp.baU();
        e eVar2 = this.owJ;
        if (!(eVar2.owV == null || eVar2.owW == null)) {
            eVar2.owV.owX = true;
            try {
                eVar2.owW.join();
                e.remove(eVar2.owV);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMSightRemuxX264Encoder", e, "waitEncoderFinish, join error: %s", new Object[]{e.getMessage()});
            }
        }
        try {
            long j;
            this.opL = new MediaExtractor();
            try {
                MediaFormat trackFormat;
                String str;
                int i;
                this.opL.setDataSource(this.filePath);
                String str2 = null;
                int i2 = 0;
                while (i2 < this.opL.getTrackCount()) {
                    trackFormat = this.opL.getTrackFormat(i2);
                    String string = trackFormat.getString("mime");
                    if (string.startsWith("audio/")) {
                        str = string;
                        i = i2;
                        break;
                    }
                    i2++;
                    str2 = string;
                }
                i = -1;
                String str3 = str2;
                trackFormat = null;
                str = str3;
                if (i >= 0 && trackFormat != null && !bh.ov(r1)) {
                    int readSampleData;
                    this.aef = trackFormat.getInteger("channel-count");
                    this.owB = trackFormat.getInteger("sample-rate");
                    this.opL.selectTrack(i);
                    if (this.owy > 0) {
                        this.opL.seekTo(this.owy * 1000, 0);
                    }
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(trackFormat.getInteger("max-input-size"));
                    while (true) {
                        allocateDirect.clear();
                        readSampleData = this.opL.readSampleData(allocateDirect, 0);
                        x.d("MicroMsg.MMSightFFMpegX264Remuxer", "sampleSize: %d", new Object[]{Integer.valueOf(readSampleData)});
                        if (readSampleData <= 0) {
                            break;
                        } else if (this.opL.getSampleTime() >= this.owz * 1000) {
                            break;
                        } else if (this.opL.getSampleTrackIndex() != i) {
                            break;
                        } else {
                            allocateDirect.position(0);
                            MP4MuxerJNI.writeAACData(this.ouk, allocateDirect, readSampleData);
                            this.opL.advance();
                        }
                    }
                    x.i("MicroMsg.MMSightFFMpegX264Remuxer", "muxAudio size = %d. Saw eos.", new Object[]{Integer.valueOf(readSampleData)});
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MMSightFFMpegX264Remuxer", e2, "muxAudio create extractor failed: %s", new Object[]{e2.getMessage()});
            }
            String str4 = this.owr;
            if (this.owx > 0) {
                str4 = str4 + "tempRotate.mp4";
            }
            long j2 = (long) this.mxs;
            if (j2 <= 0) {
                j = this.owz - this.owy;
            } else {
                j = j2;
            }
            x.i("MicroMsg.MMSightFFMpegX264Remuxer", "muxing ret: %s", new Object[]{Integer.valueOf(MP4MuxerJNI.muxingForX264(this.owB, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, this.aef, str4, (((float) this.owJ.frameCount) * 1000.0f) / ((float) j), (int) j, null, 0))});
            if (this.owx > 0) {
                SightVideoJNI.tagRotateVideo(str4, this.owr, this.owx);
                FileOp.deleteFile(str4);
            }
            MP4MuxerJNI.releaseDataBuf(this.ouk);
            j.ouM.Es();
            return round;
        } catch (Throwable e22) {
            x.printErrStackTrace("MicroMsg.MMSightFFMpegX264Remuxer", e22, "decode error: %s", new Object[]{e22.getMessage()});
            return -1;
        }
    }

    public final int getType() {
        return 3;
    }
}
