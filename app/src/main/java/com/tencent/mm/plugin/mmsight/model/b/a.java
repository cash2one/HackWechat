package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public final class a extends com.tencent.mm.plugin.mmsight.api.a {
    private int aef;
    private String filePath;
    private int mxs = -1;
    private MediaExtractor opL;
    private int ouk;
    private int owA = -1;
    private int owB;
    private Point owC = null;
    private HandlerThread owD;
    private a owE;
    private Bitmap owF;
    private byte[] owG = null;
    private byte[] owH = null;
    private c owp;
    private d owq;
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

    private class a extends af {
        final /* synthetic */ a owI;

        public a(a aVar, Looper looper) {
            this.owI = aVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            if (message.what == 1) {
                byte[] bArr = (byte[]) message.obj;
                boolean z = message.arg1 == 1;
                long j = (long) message.arg2;
                if (this.owI.owq != null) {
                    if (this.owI.owC == null) {
                        this.owI.owC = c.baV();
                    }
                    if (this.owI.owF != null) {
                        if (this.owI.owH == null) {
                            if (this.owI.owx == 90 || this.owI.owx == 270) {
                                this.owI.owF = d.b(this.owI.owF, (float) (360 - this.owI.owx));
                            } else if (this.owI.owx == 180) {
                                this.owI.owF = d.b(this.owI.owF, 180.0f);
                            }
                            this.owI.owF = Bitmap.createScaledBitmap(this.owI.owF, this.owI.owC.x, this.owI.owC.y, true);
                            Buffer allocateDirect = ByteBuffer.allocateDirect(this.owI.owF.getRowBytes() * this.owI.owF.getHeight());
                            allocateDirect.position(0);
                            this.owI.owF.copyPixelsToBuffer(allocateDirect);
                            this.owI.owH = allocateDirect.array();
                        }
                        SightVideoJNI.blendYuvFrame(bArr, this.owI.owH, this.owI.owC.x, this.owI.owC.y);
                    }
                    d c = this.owI.owq;
                    int i = this.owI.owC.x;
                    int i2 = this.owI.owC.y;
                    if (z || bArr == null) {
                        c.b(c.owT, true, j);
                    } else {
                        z = (i == c.nUr && i2 == c.mvv) ? false : true;
                        x.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData, needScale: %s, srcSize: [%s, %s], targetSize: [%s, %s], pts: %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(c.nUr), Integer.valueOf(c.mvv), Long.valueOf(j)});
                        if (c.owT == null) {
                            c.owT = new byte[(((c.nUr * c.mvv) * 3) >> 1)];
                        }
                        if (c.otT != 19 || z) {
                            MP4MuxerJNI.yuv420pTo420XXAndScale(bArr, c.owT, c.owU, i, i2, c.nUr, c.mvv);
                        } else {
                            System.arraycopy(bArr, 0, c.owT, 0, bArr.length);
                        }
                        c.owS++;
                        c.b(c.owT, false, j);
                    }
                    j.ouM.D(bArr);
                }
            }
        }
    }

    public a(String str, String str2, int i, int i2, int i3, int i4) {
        if (bh.ov(str) || bh.ov(str2) || i <= 0 || i2 <= 0) {
            x.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4)});
            return;
        }
        this.filePath = str;
        this.owr = str2;
        this.owu = i;
        this.owv = i2;
        this.oww = i3;
        this.owA = i4;
        this.owx = SightVideoJNI.getMp4Rotate(str);
        com.tencent.mm.plugin.sight.base.a Js = com.tencent.mm.plugin.sight.base.d.Js(str);
        if (Js != null) {
            this.ows = Js.width;
            this.owt = Js.height;
            this.mxs = Js.mxs;
            this.videoFps = Js.owg;
        }
        this.owy = 0;
        this.owz = (long) this.mxs;
        x.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s", new Object[]{str, str2, Integer.valueOf(this.ows), Integer.valueOf(this.owt), Integer.valueOf(this.owx), Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public a(String str, String str2, int i, int i2, int i3, int i4, long j, long j2) {
        if (bh.ov(str) || bh.ov(str2) || i <= 0 || i2 <= 0) {
            x.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4)});
            return;
        }
        this.filePath = str;
        this.owr = str2;
        this.owu = i;
        this.owv = i2;
        this.oww = i3;
        this.owA = i4;
        this.owx = SightVideoJNI.getMp4Rotate(str);
        com.tencent.mm.plugin.sight.base.a Js = com.tencent.mm.plugin.sight.base.d.Js(str);
        if (Js != null) {
            this.ows = Js.width;
            this.owt = Js.height;
            this.videoFps = Js.owg;
        }
        this.owy = j;
        this.owz = j2;
        x.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "create MMSightFFMpegMediaCodecRemuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s, startTimeMs: %s, endTimeMs: %s", new Object[]{str, str2, Integer.valueOf(this.ows), Integer.valueOf(this.owt), Integer.valueOf(this.owx), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)});
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
            x.e("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "remux time error, videoDuration: %s, remuxStartTime: %s, remuxEndTime: %s", new Object[]{Integer.valueOf(this.mxs), Long.valueOf(this.owy), Long.valueOf(this.owz)});
            MP4MuxerJNI.releaseDataBuf(this.ouk);
            return -1;
        } else {
            round = this.owp.c(this.filePath, this.owy, this.owz, this.videoFps);
        }
        x.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "decoder init ret: %s", new Object[]{Integer.valueOf(round)});
        if (round < 0) {
            MP4MuxerJNI.releaseDataBuf(this.ouk);
            return -1;
        }
        if (this.owA > 0 && this.owA < this.videoFps) {
            this.owp.owQ = (double) ((int) Math.ceil((double) (((float) this.videoFps) / ((float) this.owA))));
        }
        this.owq = new d(this.ows, this.owt, this.owu, this.owv, this.oww, this.owA > 0 ? Math.min(this.owA, this.videoFps) : this.videoFps);
        this.owp.owL = new c$a(this) {
            final /* synthetic */ a owI;

            {
                this.owI = r1;
            }

            public final void a(byte[] bArr, boolean z, long j) {
                int i = 1;
                if (this.owI.owD == null) {
                    this.owI.owD = e.cZ("remuxer_encode", -2);
                    this.owI.owD.start();
                    this.owI.owE = new a(this.owI, this.owI.owD.getLooper());
                }
                if (this.owI.owE != null) {
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    Object h = bArr != null ? j.ouM.h(Integer.valueOf(bArr.length)) : null;
                    if (h != null) {
                        System.arraycopy(bArr, 0, h, 0, h.length);
                    }
                    obtain.obj = h;
                    if (!z) {
                        i = 0;
                    }
                    obtain.arg1 = i;
                    obtain.arg2 = (int) j;
                    this.owI.owE.sendMessage(obtain);
                }
            }
        };
        this.owq.owR = new 2(this);
        try {
            long j;
            this.owq.sR(this.ouk);
            d dVar = this.owq;
            x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "Start");
            dVar.fAs = true;
            this.owp.baU();
            this.owD.quitSafely();
            this.owD.join();
            this.owE = null;
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
                    this.aef = trackFormat.getInteger("channel-count");
                    this.owB = trackFormat.getInteger("sample-rate");
                    this.opL.selectTrack(i);
                    if (this.owy > 0) {
                        this.opL.seekTo(this.owy * 1000, 0);
                    }
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(trackFormat.getInteger("max-input-size"));
                    while (true) {
                        allocateDirect.clear();
                        int readSampleData = this.opL.readSampleData(allocateDirect, 0);
                        x.d("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "sampleSize: %d", new Object[]{Integer.valueOf(readSampleData)});
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
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMSightFFMpegMediaCodecRemuxer", e, "muxAudio create extractor failed: %s", new Object[]{e.getMessage()});
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
            x.i("MicroMsg.MMSightFFMpegMediaCodecRemuxer", "muxing ret: %s", new Object[]{Integer.valueOf(MP4MuxerJNI.muxing(this.ouk, this.owB, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, this.aef, str4, (((float) this.owq.frameCount) * 1000.0f) / ((float) j), null, 0))});
            if (this.owx > 0) {
                SightVideoJNI.tagRotateVideo(str4, this.owr, this.owx);
                FileOp.deleteFile(str4);
            }
            MP4MuxerJNI.releaseDataBuf(this.ouk);
            j.ouM.Es();
            return round;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.MMSightFFMpegMediaCodecRemuxer", e2, "decode error: %s", new Object[]{e2.getMessage()});
            return -1;
        }
    }

    public final int getType() {
        return 1;
    }
}
