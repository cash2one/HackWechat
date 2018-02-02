package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@TargetApi(18)
public final class p extends a {
    private int ouk;
    private a$a ozD;
    private a$a ozE;

    public final void a(String str, String str2, VideoTransPara videoTransPara) {
        super.a(str, str2, videoTransPara);
    }

    public final int x(long j, long j2) {
        m.sV(h.bbj());
        int x = super.x(j, j2);
        if (x == -1) {
            m.sW(h.bbj());
        }
        return x;
    }

    protected final int a(MediaExtractor mediaExtractor, List<a$a> list, List<a$a> list2) {
        this.ozD = (a$a) list2.get(0);
        if (!(list == null || list.size() == 0)) {
            this.ozE = (a$a) list.get(0);
        }
        if (a(mediaExtractor, this.oxn <= 0 ? 1048576 : this.oxn, this.ouk, this.oxh) != -1) {
            return 0;
        }
        x.e("VideoClipperAPI18", "transcodeAndMux error");
        release();
        return -1;
    }

    private int a(MediaExtractor mediaExtractor, int i, int i2, String str) {
        Throwable e;
        x.i("VideoClipperAPI18", "VideoClipperAPI18.transcodeAndMux(88) ");
        h hVar = null;
        try {
            h hVar2 = new h();
            try {
                int i3;
                hVar2.aBM = this.oxl;
                hVar2.owN = this.oxm;
                VideoTransPara videoTransPara = this.oxp;
                x.i("MicroMsg.MediaCodecFFMpegTranscoder", "setVideoPara: %s", new Object[]{videoTransPara});
                hVar2.oxN = videoTransPara;
                if (this.oxq == 90 || this.oxq == 270) {
                    hVar2.cO(videoTransPara.height, videoTransPara.width);
                } else {
                    hVar2.cO(videoTransPara.width, videoTransPara.height);
                }
                hVar2.owM = str;
                x.i("MicroMsg.MediaCodecFFMpegTranscoder", "setSrcVideoRotate: %s", new Object[]{Integer.valueOf(this.oxq)});
                hVar2.fFy = i3;
                x.i("VideoClipperAPI18", "VideoClipperAPI18.transcodeAndMux(101) ");
                try {
                    x.i("VideoClipperAPI18", "VideoClipperAPI18.transcodeAndMux(118) ");
                    mediaExtractor.selectTrack(this.ozD.index);
                    mediaExtractor.seekTo(this.oxl * 1000, 0);
                    try {
                        VideoTransPara videoTransPara2 = this.oxp;
                        this.ouk = MP4MuxerJNI.initDataBuf(videoTransPara2.duration > 0 ? videoTransPara2.duration : 10);
                        long Wq = bh.Wq();
                        i3 = this.ozD.index;
                        hVar2.oye = mediaExtractor;
                        hVar2.oyf = i3;
                        if (hVar2.e(this.ozD.owb) < 0) {
                            try {
                                MP4MuxerJNI.releaseDataBuf(this.ouk);
                                mediaExtractor.release();
                                j.ouM.Es();
                            } catch (Exception e2) {
                            }
                            throw new l("init decoder error");
                        }
                        long Wq2;
                        if (!bh.ov(hVar2.owM)) {
                            String simpleMp4Info = SightVideoJNI.getSimpleMp4Info(hVar2.owM);
                            x.i("MicroMsg.MediaCodecFFMpegTranscoder", "src file: %s", new Object[]{simpleMp4Info});
                            if (!bh.ov(simpleMp4Info)) {
                                try {
                                    int i4 = (int) new JSONObject(simpleMp4Info).getDouble("videoFPS");
                                    double d = (hVar2.oxN == null || hVar2.oxN.fps <= 0) ? 30.0d : (double) hVar2.oxN.fps;
                                    hVar2.owP = (int) Math.ceil(((double) i4) / d);
                                    x.i("MicroMsg.MediaCodecFFMpegTranscoder", "frameDropInterval: %s, videoFPS: %s, targetFPS: %s", new Object[]{Integer.valueOf(hVar2.owP), Integer.valueOf(i4), Double.valueOf(d)});
                                } catch (Throwable e3) {
                                    x.printErrStackTrace("MicroMsg.MediaCodecFFMpegTranscoder", e3, "calcFrameDropCount error: %s", new Object[]{e3.getMessage()});
                                }
                            }
                        }
                        hVar2.oyg.sS(hVar2.owP);
                        hVar2.oyg.D(new h$1(hVar2));
                        Wq = bh.bA(Wq);
                        mediaExtractor.unselectTrack(this.ozD.index);
                        boolean z = false;
                        if (this.ozE != null) {
                            long Wq3 = bh.Wq();
                            z = a(mediaExtractor, i, i2);
                            x.i("VideoClipperAPI18", "process audio used %sms, compressAudio: %s", new Object[]{Long.valueOf(bh.bA(Wq3)), Boolean.valueOf(z)});
                        }
                        long Wq4 = bh.Wq();
                        String baW = baW();
                        x.i("VideoClipperAPI18", "process video used %sms", new Object[]{Long.valueOf(Wq)});
                        x.i("VideoClipperAPI18", "start muxing, tempPath: %s", new Object[]{baW});
                        m.B(h.bbj(), Wq);
                        int i5 = 1;
                        int i6 = videoTransPara2.audioSampleRate;
                        int i7 = videoTransPara2.huc;
                        if (!z) {
                            try {
                                i5 = this.ozE.owb.getInteger("channel-count");
                                i6 = this.ozE.owb.getInteger("sample-rate");
                                i7 = i5;
                                int i8 = i6;
                                i6 = this.ozE.owb.getInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE);
                                i3 = i8;
                            } catch (Exception e4) {
                                x.e("VideoClipperAPI18", "get audio channel count error: %s", new Object[]{e4.getMessage()});
                            }
                            x.e("VideoClipperAPI18", "final muxing channel count: %s, aac sample rate: %s, aacBitRate: %s", new Object[]{Integer.valueOf(i7), Integer.valueOf(i3), Integer.valueOf(i6)});
                            if (MP4MuxerJNI.muxingForX264(i3, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, i7, baW, (float) videoTransPara2.fps, (int) (this.oxm - this.oxl), null, 0) >= 0) {
                                x.e("VideoClipperAPI18", "muxingForX264 failed! %d", new Object[]{Integer.valueOf(MP4MuxerJNI.muxingForX264(i3, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, i7, baW, (float) videoTransPara2.fps, (int) (this.oxm - this.oxl), null, 0))});
                                throw new l("muxingForX264 failed!");
                            }
                            if (this.oxq <= 0) {
                                SightVideoJNI.tagRotateVideo(baW(), this.oxg, this.oxq);
                            } else {
                                FileOp.at(baW(), this.oxg);
                            }
                            x.i("VideoClipperAPI18", "mux and tagRotate used %sms", new Object[]{Long.valueOf(bh.bA(Wq4))});
                            Wq2 = bh.Wq();
                            SightVideoJNI.tagMP4Dscp(this.oxg, CaptureMMProxy.getInstance().getWeixinMeta());
                            x.i("VideoClipperAPI18", "tagMP4Dscp used %sms", new Object[]{Long.valueOf(bh.bA(Wq2))});
                            try {
                                MP4MuxerJNI.releaseDataBuf(this.ouk);
                                mediaExtractor.release();
                                j.ouM.Es();
                            } catch (Exception e5) {
                            }
                            try {
                                hVar2.release();
                            } catch (Exception e6) {
                            }
                            return 0;
                        }
                        i3 = i6;
                        i6 = i7;
                        i7 = i5;
                        x.e("VideoClipperAPI18", "final muxing channel count: %s, aac sample rate: %s, aacBitRate: %s", new Object[]{Integer.valueOf(i7), Integer.valueOf(i3), Integer.valueOf(i6)});
                        if (MP4MuxerJNI.muxingForX264(i3, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, i7, baW, (float) videoTransPara2.fps, (int) (this.oxm - this.oxl), null, 0) >= 0) {
                            if (this.oxq <= 0) {
                                FileOp.at(baW(), this.oxg);
                            } else {
                                SightVideoJNI.tagRotateVideo(baW(), this.oxg, this.oxq);
                            }
                            x.i("VideoClipperAPI18", "mux and tagRotate used %sms", new Object[]{Long.valueOf(bh.bA(Wq4))});
                            Wq2 = bh.Wq();
                            SightVideoJNI.tagMP4Dscp(this.oxg, CaptureMMProxy.getInstance().getWeixinMeta());
                            x.i("VideoClipperAPI18", "tagMP4Dscp used %sms", new Object[]{Long.valueOf(bh.bA(Wq2))});
                            MP4MuxerJNI.releaseDataBuf(this.ouk);
                            mediaExtractor.release();
                            j.ouM.Es();
                            hVar2.release();
                            return 0;
                        }
                        x.e("VideoClipperAPI18", "muxingForX264 failed! %d", new Object[]{Integer.valueOf(MP4MuxerJNI.muxingForX264(i3, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, i7, baW, (float) videoTransPara2.fps, (int) (this.oxm - this.oxl), null, 0))});
                        throw new l("muxingForX264 failed!");
                    } catch (Throwable e32) {
                        x.w("VideoClipperAPI18", "The source video file is malformed %s", new Object[]{e32.getMessage()});
                        throw new RuntimeException(e32);
                    } catch (Throwable th) {
                        try {
                            MP4MuxerJNI.releaseDataBuf(this.ouk);
                            mediaExtractor.release();
                            j.ouM.Es();
                        } catch (Exception e7) {
                        }
                    }
                } catch (Throwable e322) {
                    try {
                        x.printErrStackTrace("VideoClipperAPI18", e322, "Transcode and mux failed %s", new Object[]{e322.getMessage()});
                        return -1;
                    } finally {
                        try {
                            hVar2.release();
                        } catch (Exception e8) {
                        }
                    }
                }
            } catch (Exception e9) {
                e322 = e9;
                hVar = hVar2;
                x.printErrStackTrace("VideoClipperAPI18", e322, "trascodeAndMux error", new Object[0]);
                if (hVar != null) {
                    hVar.release();
                }
                return -1;
            }
        } catch (Exception e10) {
            e322 = e10;
            x.printErrStackTrace("VideoClipperAPI18", e322, "trascodeAndMux error", new Object[0]);
            if (hVar != null) {
                hVar.release();
            }
            return -1;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(MediaExtractor mediaExtractor, int i, int i2) {
        if (this.ozE == null) {
            return false;
        }
        mediaExtractor.selectTrack(this.ozE.index);
        mediaExtractor.seekTo(this.oxl * 1000, 0);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i);
        try {
            this.ozE.owb.getInteger("channel-count");
        } catch (Exception e) {
            x.e("VideoClipperAPI18", "get channel count error: %s", new Object[]{Integer.valueOf(1)});
        }
        x.i("VideoClipperAPI18", "audio channel count");
        if (CaptureMMProxy.getInstance().getInt(a.xsP, 0) == 1) {
            g gVar = new g(mediaExtractor, this.ozE.owb, this.oxl, this.oxm, this.oxp);
            gVar.oxO = true;
            try {
                gVar.oxJ = MediaCodec.createDecoderByType(gVar.opJ);
                gVar.oxJ.configure(gVar.oxL, null, null, 0);
                gVar.oxJ.start();
                gVar.oxL = gVar.oxJ.getOutputFormat();
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", e2, "init decoder error: %s", new Object[]{e2.getMessage()});
            }
            try {
                gVar.oxM = new MediaFormat();
                gVar.oxM.setString("mime", "audio/mp4a-latm");
                gVar.oxM.setInteger("aac-profile", 2);
                gVar.oxM.setInteger("sample-rate", gVar.oxN.audioSampleRate);
                gVar.oxM.setInteger("channel-count", 1);
                gVar.oxM.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, gVar.oxN.huc);
                gVar.oxM.setInteger("max-input-size", 16384);
                gVar.oxK = MediaCodec.createEncoderByType(gVar.opJ);
                gVar.oxK.configure(gVar.oxM, null, null, 1);
                gVar.oxJ.start();
            } catch (Exception e3) {
                x.e("MicroMsg.MediaCodecAACTranscoder", "init encoder error: %s", new Object[]{e3.getMessage()});
                gVar.oxO = false;
                gVar.oxP = new ArrayList();
                gVar.oxK.release();
                gVar.oxK = null;
            }
            x.i("MicroMsg.MediaCodecAACTranscoder", "init finish, canEncodeDecodeBothExist: %s", new Object[]{Boolean.valueOf(gVar.oxO)});
            gVar.bbg();
            return true;
        }
        int readSampleData;
        while (true) {
            allocateDirect.clear();
            readSampleData = mediaExtractor.readSampleData(allocateDirect, 0);
            x.d("VideoClipperAPI18", "sampleSize: %d", new Object[]{Integer.valueOf(readSampleData)});
            if (readSampleData <= 0) {
                break;
            } else if (mediaExtractor.getSampleTime() >= this.oxm * 1000) {
                break;
            } else if (mediaExtractor.getSampleTrackIndex() != this.ozE.index) {
                break;
            } else {
                allocateDirect.position(0);
                MP4MuxerJNI.writeAACData(i2, allocateDirect, readSampleData);
                mediaExtractor.advance();
            }
        }
        x.i("VideoClipperAPI18", "VideoClipperAPI18.muxAudio size = %d. Saw eos.", new Object[]{Integer.valueOf(readSampleData)});
        return false;
    }

    public final int Fk(String str) {
        Throwable th;
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                String extractMetadata;
                mediaMetadataRetriever.setDataSource(str);
                if (d.fM(17)) {
                    extractMetadata = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    extractMetadata = SightVideoJNI.getMp4Rotate(str);
                }
                x.d("VideoClipperAPI18", "findRotationMessage sDegree = " + extractMetadata);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(18);
                x.d("VideoClipperAPI18", "findRotationMessage sHeight = " + extractMetadata2);
                x.d("VideoClipperAPI18", "findRotationMessage sWidth = " + extractMetadata3);
                int i = bh.getInt(extractMetadata, 0);
                mediaMetadataRetriever.release();
                return i;
            } catch (Throwable th2) {
                th = th2;
                if (mediaMetadataRetriever != null) {
                    mediaMetadataRetriever.release();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            throw th;
        }
    }
}
