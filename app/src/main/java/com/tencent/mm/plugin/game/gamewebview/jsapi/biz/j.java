package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import org.json.JSONObject;

public final class j extends a {
    public static final int CTRL_BYTE = 191;
    public static final String NAME = "chooseVideo";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiChooseVideo", "invoke");
        if (jSONObject == null) {
            dVar.E(i, a.e("chooseVideo:fail_invalid_data", null));
        } else {
            a(dVar, jSONObject, i, 0);
        }
    }

    public static void a(d dVar, JSONObject jSONObject, int i, int i2) {
        Context aPh = dVar.aPh();
        if (aPh == null || aPh.isFinishing()) {
            x.e("MicroMsg.GameJsApiChooseVideo", "activity is null");
            return;
        }
        int i3;
        int i4;
        int i5 = 0;
        String optString = jSONObject.optString("sourceType", "");
        x.i("MicroMsg.GameJsApiChooseVideo", "doChooseVideo sourceType = %s, camera = %s, isVideoType:%d", new Object[]{optString, jSONObject.optString("camera", ""), Integer.valueOf(i2)});
        int optInt = jSONObject.optInt("maxDuration", 60);
        if (optString.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM)) {
            i5 = Downloads.RECV_BUFFER_SIZE;
        }
        if (optString.contains("camera")) {
            if (optInt <= 0) {
                dVar.E(i, com.tencent.mm.plugin.game.gamewebview.a.d.e("chooseVideo:fail", null));
                return;
            } else if (r4.equals("front")) {
                i5 |= 16;
            } else {
                i5 |= 256;
            }
        }
        if (i5 == 0) {
            i3 = 4352;
        } else {
            i3 = i5;
        }
        if (i3 == 16 || i3 == 256 || i3 == 4352) {
            if (i2 == 1) {
                x.d("MicroMsg.GameJsApiChooseVideo", " checkPermission checkcamera[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(aPh, "android.permission.CAMERA", 117, "", ""))});
                if (com.tencent.mm.pluginsdk.g.a.a(aPh, "android.permission.CAMERA", 117, "", "")) {
                    x.d("MicroMsg.GameJsApiChooseVideo", " checkPermission checkMicroPhone[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(aPh, "android.permission.RECORD_AUDIO", 118, "", ""))});
                    if (!com.tencent.mm.pluginsdk.g.a.a(aPh, "android.permission.RECORD_AUDIO", 118, "", "")) {
                        return;
                    }
                }
                return;
            }
            x.d("MicroMsg.GameJsApiChooseVideo", " checkPermission checkcamera[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(aPh, "android.permission.CAMERA", 115, "", ""))});
            if (!com.tencent.mm.pluginsdk.g.a.a(aPh, "android.permission.CAMERA", 115, "", "")) {
                return;
            }
        }
        i5 = jSONObject.optInt("quality", 1);
        if (i5 == 0 || i5 == 1) {
            i4 = i5;
        } else {
            i4 = 1;
        }
        if (optInt > 60) {
            i5 = 60;
        } else {
            i5 = optInt;
        }
        x.i("MicroMsg.GameJsApiChooseVideo", "doChooseVideo real scene = %d, select count = %d, video quality = %d, duration = %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(1), Integer.valueOf(i4), Integer.valueOf(i5)});
        Intent intent = new Intent();
        intent.putExtra("key_pick_local_pic_capture", i3);
        intent.putExtra("key_pick_local_pic_count", 1);
        intent.putExtra("key_pick_local_pic_query_source_type", 7);
        intent.putExtra("key_pick_local_media_quality", i4);
        intent.putExtra("key_pick_local_media_duration", i5);
        intent.putExtra("query_media_type", 2);
        intent.putExtra("key_pick_local_media_video_type", i2);
        x.i("MicroMsg.GameJsApiChooseVideo", "doChooseVideo: realScene: %d, count: %d, querySourceType: %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(1), Integer.valueOf(7)});
        aPh.jwN = new 1(dVar, i);
        if (i2 == 1) {
            com.tencent.mm.bm.d.a(aPh, "webview", ".ui.tools.OpenFileChooserUI", intent, 45, false);
        } else {
            com.tencent.mm.bm.d.a(aPh, "webview", ".ui.tools.OpenFileChooserUI", intent, 32, false);
        }
    }
}
