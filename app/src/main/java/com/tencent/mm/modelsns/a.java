package com.tencent.mm.modelsns;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Bundle;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.pv;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXGameVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.Set;

public final class a {
    public static Set<String> hOn;

    public static class a {
        public String hOo;
        public String hOp;
        public String hOq;
        public int hOr = -1;
        public int hOs = -1;
        public int videoBitRate = -1;
        public int videoFrameRate = -1;
        public int videoHeight = -1;
        public int videoWidth = -1;

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static a mA(String str) {
            MediaFormat mediaFormat = null;
            MediaExtractor mediaExtractor = new MediaExtractor();
            a aVar = new a();
            aVar.hOo = str;
            try {
                mediaExtractor.setDataSource(str);
                int trackCount = mediaExtractor.getTrackCount();
                MediaFormat mediaFormat2 = null;
                for (int i = 0; i < trackCount; i++) {
                    MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                    if (trackFormat.containsKey("mime")) {
                        String string = trackFormat.getString("mime");
                        x.i("MicroMsg.ShareSnsImpl", "find video mime : %s", new Object[]{string});
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
                    } else {
                        x.i("MicroMsg.ShareSnsImpl", "find video mime : not found.");
                    }
                }
                MediaFormat mediaFormat3 = mediaFormat2;
                mediaFormat2 = mediaFormat;
                if (mediaFormat3 != null) {
                    aVar.hOr = !mediaFormat3.containsKey("durationUs") ? 0 : (int) (mediaFormat3.getLong("durationUs") / 1000);
                    aVar.videoHeight = !mediaFormat3.containsKey("height") ? 0 : mediaFormat3.getInteger("height");
                    aVar.videoWidth = !mediaFormat3.containsKey("width") ? 0 : mediaFormat3.getInteger("width");
                    aVar.hOp = !mediaFormat3.containsKey("mime") ? "" : mediaFormat3.getString("mime");
                    aVar.videoBitRate = !mediaFormat3.containsKey(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE) ? 0 : mediaFormat3.getInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE);
                    aVar.hOs = !mediaFormat3.containsKey("i-frame-interval") ? 0 : mediaFormat3.getInteger("i-frame-interval");
                    aVar.videoFrameRate = !mediaFormat3.containsKey("frame-rate") ? 0 : mediaFormat3.getInteger("frame-rate");
                }
                if (mediaFormat2 != null) {
                    aVar.hOq = !mediaFormat2.containsKey("mime") ? "" : mediaFormat2.getString("mime");
                }
                mediaExtractor.release();
            } catch (Exception e) {
                x.i("MicroMsg.ShareSnsImpl", "Video extractor init failed. video path = [%s] e = [%s]", new Object[]{str, e.getMessage()});
            } catch (Throwable th) {
                mediaExtractor.release();
            }
            return aVar;
        }
    }

    public static Intent a(WXMediaMessage wXMediaMessage, String str, String str2) {
        int i;
        x.d("MicroMsg.ShareSnsImpl", "appmsg.description " + wXMediaMessage.description);
        x.d("MicroMsg.ShareSnsImpl", "appmsg.title " + wXMediaMessage.title);
        IMediaObject iMediaObject = wXMediaMessage.mediaObject;
        switch (iMediaObject.type()) {
            case 1:
                i = 2;
                break;
            case 2:
                i = 1;
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 5;
                break;
            case 5:
            case 6:
                i = 3;
                break;
            case 7:
                i = 3;
                break;
            case 38:
            case 39:
                i = 15;
                break;
            default:
                i = -1;
                break;
        }
        Intent intent = new Intent();
        intent.putExtra("KThrid_app", true);
        x.d("MicroMsg.ShareSnsImpl", "TimeLineType " + i + " " + iMediaObject.type());
        intent.putExtra("Ksnsupload_appid", str);
        intent.putExtra("Ksnsupload_appname", str2);
        intent.putExtra("KSnsAction", true);
        intent.putExtra("need_result", true);
        Bundle bundle = new Bundle();
        Req req = new Req();
        req.message = wXMediaMessage;
        req.toBundle(bundle);
        intent.putExtra("Ksnsupload_timeline", bundle);
        if (i == -1) {
            x.d("MicroMsg.ShareSnsImpl", "timeLineType is invalid");
            return null;
        }
        String az;
        String str3;
        String bV;
        StringBuilder stringBuilder;
        Bitmap mz;
        Options UL;
        switch (iMediaObject.type()) {
            case 1:
                intent.putExtra("Kdescription", ((WXTextObject) iMediaObject).text);
                intent.putExtra("Ksnsupload_type", 8);
                return intent;
            case 2:
                WXImageObject wXImageObject = (WXImageObject) iMediaObject;
                intent.putExtra("KBlockAdd", true);
                intent.putExtra("Ksnsupload_type", 0);
                intent.putExtra("sns_kemdia_path", wXImageObject.imagePath);
                return intent;
            case 3:
                WXMusicObject wXMusicObject = (WXMusicObject) iMediaObject;
                az = bh.az(!bh.ov(wXMusicObject.musicUrl) ? wXMusicObject.musicUrl : wXMusicObject.musicLowBandUrl, "");
                bh.az(!bh.ov(wXMusicObject.musicDataUrl) ? wXMusicObject.musicDataUrl : wXMusicObject.musicUrl, "");
                bh.az(!bh.ov(wXMusicObject.musicLowBandDataUrl) ? wXMusicObject.musicLowBandDataUrl : wXMusicObject.musicLowBandUrl, "");
                intent.putExtra("Ksnsupload_link", az);
                intent.putExtra("Ksnsupload_title", "");
                intent.putExtra("Ksnsupload_type", 2);
                intent.putExtra("ksnsis_music", true);
                return intent;
            case 4:
                WXVideoObject wXVideoObject = (WXVideoObject) iMediaObject;
                intent.putExtra("Ksnsupload_link", bh.az(!bh.ov(wXVideoObject.videoUrl) ? wXVideoObject.videoUrl : wXVideoObject.videoLowBandUrl, ""));
                intent.putExtra("Ksnsupload_title", "");
                intent.putExtra("Ksnsupload_type", 1);
                intent.putExtra("ksnsis_video", true);
                return intent;
            case 5:
                intent.putExtra("Ksnsupload_link", ((WXWebpageObject) iMediaObject).webpageUrl);
                intent.putExtra("Ksnsupload_title", bh.az(wXMediaMessage.title, ""));
                intent.putExtra("Ksnsupload_imgbuf", wXMediaMessage.thumbData);
                intent.putExtra("Ksnsupload_type", 1);
                return intent;
            case 6:
                x.e("MicroMsg.ShareSnsImpl", "file is not support!");
                return null;
            case 7:
                return null;
            case 38:
                WXVideoFileObject wXVideoFileObject = (WXVideoFileObject) iMediaObject;
                intent.putExtra("KBlockAdd", true);
                intent.putExtra("Ksnsupload_type", 14);
                az = wXVideoFileObject.filePath;
                str3 = "";
                bV = g.bV(az);
                if (bh.ov(str3) || !FileOp.bO(str3)) {
                    stringBuilder = new StringBuilder();
                    ar.Hg();
                    str3 = stringBuilder.append(c.getAccSnsTmpPath()).append(bV).toString();
                    try {
                        mz = mz(az);
                        if (mz != null) {
                            x.i("MicroMsg.ShareSnsImpl", "getBitmap1 %d %d", new Object[]{Integer.valueOf(mz.getWidth()), Integer.valueOf(mz.getHeight())});
                            d.a(mz, 80, CompressFormat.JPEG, str3, true);
                            UL = d.UL(str3);
                            x.i("MicroMsg.ShareSnsImpl", "getBitmap2 %d %d", new Object[]{Integer.valueOf(UL.outWidth), Integer.valueOf(UL.outHeight)});
                        } else {
                            x.e("MicroMsg.ShareSnsImpl", "thumb null , videoPath %s ", new Object[]{az});
                            return null;
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.ShareSnsImpl", "savebitmap error %s", new Object[]{e.getMessage()});
                    }
                }
                intent.putExtra("KSightPath", az);
                intent.putExtra("KSightThumbPath", str3);
                intent.putExtra("sight_md5", bV);
                return intent;
            case 39:
                WXGameVideoFileObject wXGameVideoFileObject = (WXGameVideoFileObject) iMediaObject;
                intent.putExtra("KBlockAdd", true);
                intent.putExtra("Ksnsupload_type", 14);
                az = wXGameVideoFileObject.filePath;
                String str4 = "";
                x.i("MicroMsg.ShareSnsImpl", "videoPath %s,thumbPath %s,cdnUrl %s,cdnThumbUrl %s", new Object[]{az, str4, wXGameVideoFileObject.videoUrl, wXGameVideoFileObject.thumbUrl});
                String bV2 = g.bV(az);
                if (bh.ov(str4) || !FileOp.bO(str4)) {
                    stringBuilder = new StringBuilder();
                    ar.Hg();
                    str3 = stringBuilder.append(c.getAccSnsTmpPath()).append(bV2).toString();
                    try {
                        mz = mz(az);
                        if (mz != null) {
                            x.i("MicroMsg.ShareSnsImpl", "getBitmap1 %d %d", new Object[]{Integer.valueOf(mz.getWidth()), Integer.valueOf(mz.getHeight())});
                            d.a(mz, 80, CompressFormat.JPEG, str3, true);
                            UL = d.UL(str3);
                            x.i("MicroMsg.ShareSnsImpl", "getBitmap2 %d %d", new Object[]{Integer.valueOf(UL.outWidth), Integer.valueOf(UL.outHeight)});
                        } else {
                            x.e("MicroMsg.ShareSnsImpl", "thumb null , videoPath %s ", new Object[]{az});
                            return null;
                        }
                    } catch (Exception e2) {
                        x.e("MicroMsg.ShareSnsImpl", "savebitmap error %s", new Object[]{e2.getMessage()});
                    }
                } else {
                    str3 = str4;
                }
                intent.putExtra("KSightPath", az);
                intent.putExtra("KSightThumbPath", str3);
                intent.putExtra("sight_md5", bV2);
                intent.putExtra("KSightCdnUrl", bV);
                intent.putExtra("KSightCdnThumbUrl", r5);
                return intent;
            default:
                x.e("MicroMsg.ShareSnsImpl", "none type not support!");
                return null;
        }
    }

    private static Bitmap mz(String str) {
        b pvVar = new pv();
        pvVar.fHy.fHA = str;
        com.tencent.mm.sdk.b.a.xef.m(pvVar);
        return (Bitmap) pvVar.fHz.result;
    }
}
