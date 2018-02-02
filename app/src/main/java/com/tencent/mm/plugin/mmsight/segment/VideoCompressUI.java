package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.segment.k.f;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;

@TargetApi(16)
public class VideoCompressUI extends MMBaseActivity {
    private String fvC;
    private d mfB = new d(this);
    private VideoTransPara oxN;
    private ProgressDialog ozF;
    private a ozG = new a(this, (byte) 0);
    private Runnable ozH = new Runnable(this) {
        final /* synthetic */ VideoCompressUI ozI;

        {
            this.ozI = r1;
        }

        public final void run() {
            try {
                VideoCompressUI.a(this.ozI, this.ozI.videoPath);
                Intent intent = new Intent();
                Point o = VideoCompressUI.o(this.ozI.ozG.videoWidth, this.ozI.ozG.videoHeight, this.ozI.oxN.width, this.ozI.oxN.height);
                if (VideoCompressUI.b(this.ozI, this.ozI.oxN) || o != null) {
                    Point point;
                    if (o == null) {
                        point = new Point(this.ozI.ozG.videoWidth, this.ozI.ozG.videoHeight);
                    } else {
                        point = o;
                    }
                    String bbq = VideoCompressUI.bbq();
                    x.i("VideoCompressUI", "need remux, inputVideoSize: [%s %s], out: %s, videoPath: %s, tmpPath: %s", new Object[]{Integer.valueOf(this.ozI.ozG.videoWidth), Integer.valueOf(this.ozI.ozG.videoHeight), point, this.ozI.videoPath, bbq});
                    SightVideoJNI.remuxing(this.ozI.videoPath, bbq, point.x, point.y, this.ozI.oxN.videoBitrate, this.ozI.oxN.huf, 8, this.ozI.oxN.hue, 25.0f, (float) this.ozI.oxN.fps, null, 0, false);
                    intent.putExtra("K_SEGMENTVIDEOPATH", bbq);
                    intent.putExtra("KSEGMENTVIDEOTHUMBPATH", this.ozI.do(bbq, null));
                } else {
                    x.i("VideoCompressUI", "no need remux, directly set result");
                    intent.putExtra("K_SEGMENTVIDEOPATH", this.ozI.videoPath);
                    intent.putExtra("KSEGMENTVIDEOTHUMBPATH", this.ozI.do(this.ozI.videoPath, this.ozI.fvC));
                }
                this.ozI.setResult(-1, intent);
            } catch (Throwable e) {
                x.printErrStackTrace("VideoCompressUI", e, "video compress failed e [%s]", new Object[]{e.getMessage()});
            } finally {
                this.ozI.finish();
                ag.y(new 1(this));
            }
        }
    };
    private String videoPath;

    static /* synthetic */ void a(VideoCompressUI videoCompressUI, String str) {
        MediaFormat mediaFormat = null;
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(str);
            int trackCount = mediaExtractor.getTrackCount();
            MediaFormat mediaFormat2 = null;
            for (int i = 0; i < trackCount; i++) {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                if (trackFormat.containsKey("mime")) {
                    String string = trackFormat.getString("mime");
                    x.i("VideoCompressUI", "find video mime : %s", new Object[]{string});
                    if (string != null) {
                        if (string.startsWith("video/")) {
                            if (mediaFormat2 == null) {
                                mediaFormat2 = trackFormat;
                            }
                        } else if (string.startsWith("audio/") && r0 == null) {
                            mediaFormat = trackFormat;
                        }
                        if (!(mediaFormat == null || r1 == null)) {
                            break;
                        }
                    }
                    continue;
                }
            }
            MediaFormat mediaFormat3 = mediaFormat2;
            mediaFormat2 = mediaFormat;
            try {
                a Js = com.tencent.mm.plugin.sight.base.d.Js(str);
                if (Js == null) {
                    x.e("VideoCompressUI", "Get Media Info failed.");
                    videoCompressUI.finish();
                    return;
                }
                if (videoCompressUI.ozG != null && videoCompressUI.ozG.hOr == -1) {
                    videoCompressUI.ozG.videoBitRate = Js.videoBitrate;
                    videoCompressUI.ozG.audioBitRate = Js.huc;
                    if (mediaFormat3 != null) {
                        videoCompressUI.ozG.hOr = !mediaFormat3.containsKey("durationUs") ? 0 : (int) (mediaFormat3.getLong("durationUs") / 1000);
                        videoCompressUI.ozG.videoHeight = !mediaFormat3.containsKey("height") ? 0 : mediaFormat3.getInteger("height");
                        videoCompressUI.ozG.videoWidth = !mediaFormat3.containsKey("width") ? 0 : mediaFormat3.getInteger("width");
                        videoCompressUI.ozG.hOp = !mediaFormat3.containsKey("mime") ? "" : mediaFormat3.getString("mime");
                        videoCompressUI.ozG.hOs = !mediaFormat3.containsKey("i-frame-interval") ? 0 : mediaFormat3.getInteger("i-frame-interval");
                        videoCompressUI.ozG.videoFrameRate = !mediaFormat3.containsKey("frame-rate") ? 0 : mediaFormat3.getInteger("frame-rate");
                    }
                    if (mediaFormat2 != null) {
                        videoCompressUI.ozG.hOq = !mediaFormat2.containsKey("mime") ? "" : mediaFormat2.getString("mime");
                    }
                }
                mediaExtractor.release();
            } catch (Throwable e) {
                x.printErrStackTrace("VideoCompressUI", e, "Get MediaInfo failed", new Object[0]);
                videoCompressUI.finish();
                mediaExtractor.release();
            }
        } catch (Exception e2) {
            x.e("VideoCompressUI", "Video extractor init failed. video path = [%s] e = [%s]", new Object[]{str, e2.getMessage()});
        } finally {
            mediaExtractor.release();
        }
    }

    static /* synthetic */ boolean b(VideoCompressUI videoCompressUI, VideoTransPara videoTransPara) {
        boolean z;
        if (videoTransPara != null) {
            z = videoTransPara.videoBitrate < videoCompressUI.ozG.videoBitRate;
        } else {
            x.e("VideoCompressUI", "hy: given target trans param is null");
            z = false;
        }
        return z;
    }

    static /* synthetic */ String bbq() {
        String str = CaptureMMProxy.getInstance().getAccVideoPath() + "videoCompressTmp/";
        if (FileOp.bO(str)) {
            FileOp.G(str, true);
        } else {
            FileOp.mh(str);
        }
        x.i("VideoCompressUI", "initAndGetTmpPath: %s", new Object[]{str + "video_send_preprocess_tmp_" + System.currentTimeMillis() + ".mp4"});
        return str + "video_send_preprocess_tmp_" + System.currentTimeMillis() + ".mp4";
    }

    static /* synthetic */ Point o(int i, int i2, int i3, int i4) {
        x.d("VideoCompressUI", "scale() called with: decoderOutputWidth = [" + i + "], decoderOutputHeight = [" + i2 + "], specWidth = [" + i3 + "], specHeight = [" + i4 + "]");
        if (i > i3 || i2 > i4) {
            int max = Math.max(i, i2);
            int min = Math.min(i, i2);
            int max2 = Math.max(i3, i4);
            int min2 = Math.min(i3, i4);
            if (max % 16 != 0 || Math.abs(max - max2) >= 16 || min % 16 != 0 || Math.abs(min - min2) >= 16) {
                int i5 = max / 2;
                max = min / 2;
                if (i5 % 16 != 0 || Math.abs(i5 - max2) >= 16 || max % 16 != 0 || Math.abs(max - min2) >= 16) {
                    Point point = new Point();
                    if (i < i2) {
                        i5 = Math.min(i3, i4);
                        max = (int) (((double) i2) / ((((double) i) * 1.0d) / ((double) i5)));
                    } else {
                        max = Math.min(i3, i4);
                        i5 = (int) (((double) i) / ((((double) i2) * 1.0d) / ((double) max)));
                    }
                    if (max % 2 != 0) {
                        max++;
                    }
                    if (i5 % 2 != 0) {
                        i5++;
                    }
                    x.i("VideoCompressUI", "calc scale, outputsize: %s %s", new Object[]{Integer.valueOf(i5), Integer.valueOf(max)});
                    point.x = i5;
                    point.y = max;
                    return point;
                }
                x.i("VideoCompressUI", "calc scale, double ratio divide by 16");
                i5 = i / 2;
                max = i2 / 2;
                if (i5 % 2 != 0) {
                    i5++;
                }
                if (max % 2 != 0) {
                    max++;
                }
                return new Point(i5, max);
            }
            x.i("VideoCompressUI", "calc scale, same len divide by 16, no need scale");
            return null;
        }
        x.i("VideoCompressUI", "calc scale, small or equal to spec size");
        return null;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(k.d.daM);
        Intent intent = getIntent();
        if (intent == null || bh.ov(intent.getStringExtra("K_SEGMENTVIDEOPATH"))) {
            setResult(0);
            finish();
            return;
        }
        this.ozF = h.a(this, getString(f.dHc), false, null);
        this.videoPath = intent.getStringExtra("K_SEGMENTVIDEOPATH");
        this.fvC = intent.getStringExtra("KSEGMENTVIDEOTHUMBPATH");
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.mfB));
        this.mfB.I(new 1(this));
    }

    private String do(String str, String str2) {
        Throwable e;
        if (!bh.ov(str2)) {
            return str2;
        }
        String str3;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0);
            str3 = CaptureMMProxy.getInstance().getAccVideoPath() + "videoCompressTmpThumb/";
            if (FileOp.bO(str3)) {
                FileOp.G(str3, true);
            } else {
                FileOp.mh(str3);
            }
            str3 = str3 + "video_send_preprocess_thumb_" + System.currentTimeMillis() + ".jpg";
            x.i("VideoCompressUI", "thumbPath: %s", new Object[]{str3});
            try {
                com.tencent.mm.sdk.platformtools.d.a(frameAtTime, 80, CompressFormat.JPEG, str3, true);
                mediaMetadataRetriever.release();
            } catch (Exception e2) {
                e = e2;
                try {
                    x.printErrStackTrace("VideoCompressUI", e, "get thumb error e [%s] videoMediaItem [%s] ", new Object[]{e.getMessage(), this.ozG});
                    return str3;
                } finally {
                    mediaMetadataRetriever.release();
                }
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            str3 = null;
            e = th;
            x.printErrStackTrace("VideoCompressUI", e, "get thumb error e [%s] videoMediaItem [%s] ", new Object[]{e.getMessage(), this.ozG});
            return str3;
        }
        return str3;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mfB != null) {
            this.mfB.release();
        }
    }
}
