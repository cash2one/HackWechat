package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;

public final class h implements e$a {
    private static int oyi = -1;
    long aBM = -1;
    int fFy;
    private Object lock = new byte[0];
    private int otR;
    private int otS;
    String owM;
    long owN = -1;
    int owP = -1;
    Thread owW;
    VideoTransPara oxN;
    private int oxW;
    private int oxX;
    private int oxY;
    private int oxZ;
    private int oya;
    private int oyb;
    a oyc;
    private int oyd = 0;
    MediaExtractor oye;
    int oyf;
    e oyg;
    private boolean oyh = false;
    private MediaFormat oyj;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int bbj() {
        int i = CaptureMMProxy.getInstance().getInt(a.xsO, -1);
        if (i != -1) {
            if (i == 1) {
                if (d.fM(21)) {
                    oyi = 2;
                } else {
                    oyi = 1;
                }
            } else if (i == 2) {
                oyi = 1;
            } else {
                oyi = 3;
            }
            return oyi;
        } else if (oyi != -1) {
            return oyi;
        } else {
            i = q.gGb.gGn;
            if (i == -1) {
                if (d.fM(bh.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightSegCutMinApiLevel"), 21))) {
                    oyi = 1;
                }
                oyi = 3;
            } else if (i == 1) {
                oyi = 1;
            } else if (i == 2) {
                if (d.fM(21)) {
                    oyi = 2;
                } else {
                    oyi = 1;
                }
            }
            return oyi;
        }
    }

    public final int e(MediaFormat mediaFormat) {
        x.i("MicroMsg.MediaCodecFFMpegTranscoder", "initDecoder, format: %s, filePath: %s", new Object[]{mediaFormat, this.owM});
        this.oyj = mediaFormat;
        int bbj = bbj();
        if (bbj == 1) {
            this.oyg = new i(this.oye, mediaFormat, this.oyf);
            this.oyh = false;
        } else if (bbj == 2) {
            this.oyg = new j(this.oye, mediaFormat, this.oyf);
            this.oyh = false;
        } else {
            this.oyg = new b();
            this.oyh = true;
        }
        if (this.oyg == null) {
            x.i("MicroMsg.MediaCodecFFMpegTranscoder", "use default config");
            this.oyg = new i(this.oye, mediaFormat, this.oyf);
            this.oyh = false;
        }
        bbj = this.oyg.q(this.owM, this.aBM, this.owN);
        x.i("MicroMsg.MediaCodecFFMpegTranscoder", "init decoder ret: %s", new Object[]{Integer.valueOf(bbj)});
        if (bbj < 0 && (oyi == 1 || oyi == 2)) {
            x.i("MicroMsg.MediaCodecFFMpegTranscoder", "init mediaCodecDecoder failed, try ffmepg");
            try {
                this.oyg.stop();
                this.oyg = null;
            } catch (Exception e) {
            }
            this.oyg = new b();
            this.oyh = true;
            oyi = 3;
            bbj = this.oyg.q(this.owM, this.aBM, this.owN);
        }
        this.oyg.a(this);
        x.i("MicroMsg.MediaCodecFFMpegTranscoder", "init finish, ret: %d, decoderType: %d", new Object[]{Integer.valueOf(bbj), Integer.valueOf(oyi)});
        return bbj;
    }

    public final void cO(int i, int i2) {
        x.i("MicroMsg.MediaCodecFFMpegTranscoder", "registerDesiredSize: %s, %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.oxW = i;
        this.oxX = i2;
    }

    private static Point n(int i, int i2, int i3, int i4) {
        x.d("MicroMsg.MediaCodecFFMpegTranscoder", "scale() called with: decoderOutputWidth = [" + i + "], decoderOutputHeight = [" + i2 + "], specWidth = [" + i3 + "], specHeight = [" + i4 + "]");
        if (i > i3 || i2 > i4) {
            int max = Math.max(i, i2);
            int min = Math.min(i, i2);
            int max2 = Math.max(i3, i4);
            int min2 = Math.min(i3, i4);
            if (max % 16 == 0 && Math.abs(max - max2) < 16 && min % 16 == 0 && Math.abs(min - min2) < 16) {
                x.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, same len divide by 16, no need scale");
                return null;
            } else if (max / 2 == max2 && min / 2 == min2) {
                x.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, double ratio");
                r0 = i / 2;
                max = i2 / 2;
                if (r0 % 2 != 0) {
                    r0++;
                }
                if (max % 2 != 0) {
                    max++;
                }
                return new Point(r0, max);
            } else {
                r0 = max / 2;
                max = min / 2;
                if (r0 % 16 != 0 || Math.abs(r0 - max2) >= 16 || max % 16 != 0 || Math.abs(max - min2) >= 16) {
                    Point point = new Point();
                    if (i < i2) {
                        max = Math.min(i3, i4);
                        r0 = (int) (((double) i2) / ((((double) i) * 1.0d) / ((double) max)));
                    } else {
                        r0 = Math.min(i3, i4);
                        max = (int) (((double) i) / ((((double) i2) * 1.0d) / ((double) r0)));
                    }
                    if (r0 % 2 != 0) {
                        r0++;
                    }
                    if (max % 2 != 0) {
                        max++;
                    }
                    x.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, outputsize: %s %s", new Object[]{Integer.valueOf(max), Integer.valueOf(r0)});
                    point.x = max;
                    point.y = r0;
                    return point;
                }
                x.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, double ratio divide by 16");
                r0 = i / 2;
                max = i2 / 2;
                if (r0 % 2 != 0) {
                    r0++;
                }
                if (max % 2 != 0) {
                    max++;
                }
                return new Point(r0, max);
            }
        }
        x.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, small or equal to spec size");
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void release() {
        x.i("MicroMsg.MediaCodecFFMpegTranscoder", "release, decoderType: %d", new Object[]{Integer.valueOf(oyi)});
        try {
            if (this.oyg != null) {
                this.oyg.stop();
            }
            MP4MuxerJNI.releaseDataBuf(0);
            oyi = -1;
        } catch (Exception e) {
            x.e("MicroMsg.MediaCodecFFMpegTranscoder", "release error: %s", new Object[]{e.getMessage()});
        } catch (Throwable th) {
            MP4MuxerJNI.releaseDataBuf(0);
            oyi = -1;
        }
    }

    public final void aA(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            x.i("MicroMsg.MediaCodecFFMpegTranscoder", "onYuvDataImp error data is null!!");
            return;
        }
        Point n;
        Point baV = this.oyg.baV();
        this.otR = baV.x;
        this.otS = baV.y;
        if (this.oyb <= 0 || this.oya <= 0) {
            n = n(this.otR, this.otS, this.oxW, this.oxX);
            if (n != null) {
                this.oya = n.x;
                this.oyb = n.y;
            } else {
                this.oya = this.otR;
                this.oyb = this.otS;
            }
            x.i("MicroMsg.MediaCodecFFMpegTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", new Object[]{Integer.valueOf(this.oya), Integer.valueOf(this.oyb), Integer.valueOf(this.otR), Integer.valueOf(this.otS)});
        }
        long Wq = bh.Wq();
        int i = 0;
        int i2 = 0;
        if (this.oyj != null) {
            i = this.oyj.getInteger("width");
            i2 = this.oyj.getInteger("height");
            if (this.oxY <= 0 || this.oxZ <= 0) {
                boolean z;
                n = n(i, i2, this.oxW, this.oxX);
                if (n != null) {
                    this.oxY = n.x;
                    this.oxZ = n.y;
                    z = true;
                } else {
                    if (Math.abs(i2 - baV.y) <= 0 || i != baV.x) {
                        this.oxY = baV.x;
                        this.oxZ = baV.y;
                    } else {
                        this.oxY = i;
                        this.oxZ = i2;
                    }
                    z = false;
                }
                if (z) {
                    this.oya = this.oxY;
                    this.oyb = this.oxZ;
                }
                x.i("MicroMsg.MediaCodecFFMpegTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", new Object[]{Integer.valueOf(this.oxY), Integer.valueOf(this.oxZ), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)});
            }
        }
        this.oyd = this.oyg.baY();
        int writeYuvDataForSegment = MP4MuxerJNI.writeYuvDataForSegment(bArr, baV.x, baV.y, this.oya, this.oyb, this.oyd, i, i2);
        x.i("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment used %sms", new Object[]{Long.valueOf(bh.bA(Wq))});
        if (writeYuvDataForSegment < 0) {
            x.e("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment error: %s", new Object[]{Integer.valueOf(writeYuvDataForSegment)});
        }
        if (this.oyc == null) {
            MP4MuxerJNI.initH264Encoder(this.oxY, this.oxZ, (float) this.oxN.fps, this.oxN.videoBitrate, this.oxN.huf, 8, this.oxN.hue, 23.0f);
            this.oyc = new a(this, (byte) 0);
            this.owW = e.b(this.oyc, "MediaCodecFFMpegTranscoder_Encoder");
            this.owW.start();
            x.i("MicroMsg.MediaCodecFFMpegTranscoder", "initAndStartEncoder");
        }
    }
}
