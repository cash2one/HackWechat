package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.ChooseRequest;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.ChooseResult;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.base.u;
import java.util.List;

final class JsApiChooseVideo$a extends AppBrandProxyUIProcessTask {
    private r jmO;
    private OnCancelListener jmP;
    private String jng;
    private ChooseResult jnt = new ChooseResult();
    private ChooseRequest jnu;

    private JsApiChooseVideo$a() {
    }

    protected final void a(ProcessRequest processRequest) {
        this.jnu = (ChooseRequest) processRequest;
        this.jnu.maxDuration = Math.min(Math.max(this.jnu.maxDuration, 60), 0);
        if (bh.eY(afe()) > 200) {
            int i = 1;
        } else {
            boolean z = false;
        }
        if (i == 0) {
            u.makeText(afe(), ac.getResources().getString(j.iyJ), 1).show();
        }
        afe().jwN = this;
        Intent intent = new Intent();
        intent.putExtra("key_send_raw_image", false);
        intent.putExtra("query_media_type", 2);
        if (this.jnu.jmG && this.jnu.jmH) {
            this.jng = e.gHu + "microMsg." + System.currentTimeMillis() + ".mp4";
            intent.putExtra("record_video_force_sys_camera", true);
            intent.putExtra("record_video_quality", 1);
            intent.putExtra("record_video_time_limit", this.jnu.maxDuration);
            intent.putExtra("video_full_path", this.jng);
            k.c(afe(), 1, 7, intent);
        } else if (this.jnu.jmG) {
            this.jng = e.gHu + "microMsg." + System.currentTimeMillis() + ".mp4";
            k.a(afe(), this.jng, 5, this.jnu.maxDuration, 1, false);
        } else if (this.jnu.jmH) {
            intent.putExtra("show_header_view", false);
            k.c(afe(), 1, 7, intent);
        } else {
            this.jnt.bjW = -2;
            a(this.jnt);
        }
    }

    protected final void afk() {
        super.afk();
        if (this.jmO != null) {
            this.jmO.dismiss();
            this.jmO = null;
        }
    }

    private void agz() {
        this.jmP = new 1(this);
        Context afe = afe();
        ac.getResources().getString(j.dGO);
        this.jmO = h.a(afe, ac.getResources().getString(j.iyJ), true, this.jmP);
    }

    public final void b(int i, int i2, Intent intent) {
        if (i2 == 0) {
            this.jnt.bjW = 0;
            a(this.jnt);
        } else if (-1 != i2) {
            this.jnt.bjW = -2;
            a(this.jnt);
        } else {
            switch (i) {
                case 4:
                    List stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                    if (!bh.cA(stringArrayListExtra)) {
                        String str = (String) stringArrayListExtra.get(0);
                        agz();
                        c.Dm().F(new 3(this, str));
                        return;
                    }
                    break;
                case 5:
                    if (!bh.ov(this.jng)) {
                        agz();
                        c.Dm().F(new 2(this));
                        return;
                    }
                    break;
            }
            this.jnt.bjW = -2;
            a(this.jnt);
        }
    }

    private AppBrandLocalVideoObject U(String str, boolean z) {
        MediaMetadataRetriever mediaMetadataRetriever;
        if (z) {
            try {
                boolean oy = com.tencent.mm.plugin.a.c.oy(str);
                x.i("MicroMsg.JsApiChooseVideo", "checkRemux, isMp4 = %b", Boolean.valueOf(oy));
                int i = -10000;
                if (oy) {
                    i = SightVideoJNI.shouldRemuxing(str, 660, 500, 26214400, 300000.0d, Constants.MAX_BUFFER_SIZE);
                    x.i("MicroMsg.JsApiChooseVideo", "checkRemux, ret = %d", Integer.valueOf(i));
                }
                if (i == -1 || !oy) {
                    x.i("MicroMsg.JsApiChooseVideo", "fileLength = %d", Integer.valueOf(com.tencent.mm.a.e.bN(str)));
                    i = com.tencent.mm.a.e.bN(str) > 26214400 ? -1 : 1;
                }
                switch (i) {
                    case -6:
                    case -5:
                    case -4:
                    case -3:
                    case -2:
                    case -1:
                        i = -50002;
                        break;
                    case 0:
                        i = -50006;
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        i = 1;
                        break;
                    default:
                        x.e("MicroMsg.JsApiChooseVideo", "unknown check type");
                        i = -50001;
                        break;
                }
                if (i == -50006) {
                    int[] iArr = new int[2];
                    com.tencent.mm.pluginsdk.model.k.d(str, iArr);
                    int i2 = iArr[0];
                    int i3 = iArr[1];
                    String str2 = e.gHu + "microMsg." + System.currentTimeMillis() + ".mp4";
                    i = SightVideoJNI.remuxing(str, str2, i2, i3, b.qsX, b.qsW, 8, 2, 25.0f, b.qsY, null, 0, false);
                    x.i("MicroMsg.JsApiChooseVideo", "remuxIfNeed [%s] to [%s], result %d, resolution:[%d, %d]", str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                    str = str2;
                }
            } catch (Throwable e) {
                x.e("MicroMsg.JsApiChooseVideo", "addVideoItem, remux failed, exp = %s", bh.i(e));
            }
        }
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
        } catch (Exception e2) {
            x.e("MicroMsg.JsApiChooseVideo", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", e2);
            mediaMetadataRetriever = null;
        }
        if (mediaMetadataRetriever == null) {
            x.e("MicroMsg.JsApiChooseVideo", "addVideoItem, null meta data");
            return null;
        }
        int i4 = bh.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
        i2 = bh.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
        i3 = bh.getInt(mediaMetadataRetriever.extractMetadata(9), 0);
        mediaMetadataRetriever.release();
        AppBrandLocalVideoObject attachVideo = AppBrandLocalMediaObjectManager.attachVideo(this.jnu.appId, str);
        if (attachVideo == null) {
            return null;
        }
        attachVideo.duration = (i3 + 500) / 1000;
        attachVideo.width = i4;
        attachVideo.height = i2;
        attachVideo.size = com.tencent.mm.a.e.bN(str);
        x.i("MicroMsg.JsApiChooseVideo", "addVideoItem, return %s", attachVideo);
        return attachVideo;
    }
}
