package com.tencent.mm.plugin.gallery.model;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

@TargetApi(16)
public final class m implements Runnable {
    public MediaFormat mRB;
    public MediaFormat mRC;
    public VideoMediaItem mRD;
    public a mRE;
    public String path;
    public int position;

    public interface a {
        void a(m mVar);
    }

    public m(String str, int i, VideoMediaItem videoMediaItem, a aVar) {
        this.path = str;
        this.position = i;
        this.mRD = videoMediaItem;
        this.mRE = aVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(this.path);
            int trackCount = mediaExtractor.getTrackCount();
            for (int i = 0; i < trackCount; i++) {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                if (trackFormat.containsKey("mime")) {
                    String string = trackFormat.getString("mime");
                    x.d("VideoAnalysisTask", "find video mime : %s", new Object[]{string});
                    if (string != null) {
                        if (string.startsWith("video/")) {
                            if (this.mRB == null) {
                                this.mRB = trackFormat;
                            }
                        } else if (string.startsWith("audio/") && this.mRC == null) {
                            this.mRC = trackFormat;
                        }
                        if (!(this.mRC == null || this.mRB == null)) {
                            break;
                        }
                    }
                    continue;
                } else {
                    x.d("VideoAnalysisTask", "find video mime : not found.");
                }
            }
            if (this.mRD != null) {
                if (this.mRB != null) {
                    this.mRD.hOr = !this.mRB.containsKey("durationUs") ? 0 : (int) (this.mRB.getLong("durationUs") / 1000);
                    this.mRD.videoHeight = !this.mRB.containsKey("height") ? 0 : this.mRB.getInteger("height");
                    this.mRD.videoWidth = !this.mRB.containsKey("width") ? 0 : this.mRB.getInteger("width");
                    this.mRD.hOp = !this.mRB.containsKey("mime") ? "" : this.mRB.getString("mime");
                    this.mRD.videoBitRate = !this.mRB.containsKey(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE) ? 0 : this.mRB.getInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE);
                    this.mRD.hOs = !this.mRB.containsKey("i-frame-interval") ? 0 : this.mRB.getInteger("i-frame-interval");
                    this.mRD.videoFrameRate = !this.mRB.containsKey("frame-rate") ? 0 : this.mRB.getInteger("frame-rate");
                }
                if (this.mRC != null) {
                    this.mRD.hOq = !this.mRC.containsKey("mime") ? "" : this.mRC.getString("mime");
                }
            }
            mediaExtractor.release();
        } catch (Exception e) {
            x.d("VideoAnalysisTask", "Video extractor init failed. video path = [%s] e = [%s]", new Object[]{this.path, e.getMessage()});
        } catch (Throwable th) {
            mediaExtractor.release();
        }
        if (this.mRE == null) {
            x.d("VideoAnalysisTask", "video analysis end. observer == null, position = [%d], mediaItem = [%s]", new Object[]{Integer.valueOf(this.position), this.mRD});
        } else {
            ag.y(new Runnable(this) {
                final /* synthetic */ m mRF;

                {
                    this.mRF = r1;
                }

                public final void run() {
                    if (this.mRF.mRE != null) {
                        this.mRF.mRE.a(this.mRF);
                    }
                }
            });
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof m) && (this == obj || this.position == ((m) obj).position || (this.path != null && this.path.equals(((m) obj).path)));
    }
}
