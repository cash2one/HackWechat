package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.l;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import org.json.JSONObject;

public final class i extends a {
    public static final int CTRL_BYTE = 254;
    public static final String NAME = "chooseMedia";
    private MMActivity.a jbn = new 4(this);
    int jcs;
    GameWebViewUI mWF;
    d mWG;

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiChooseMedia", "invoke");
        if (jSONObject == null) {
            x.i("MicroMsg.GameJsApiChooseMedia", "data is null");
            dVar.E(i, a.e("doChooseMedia:fail_invalid_data", null));
            return;
        }
        this.mWG = dVar;
        this.jcs = i;
        this.mWF = dVar.aPh();
        x.i("MicroMsg.GameJsApiChooseMedia", " checkPermission checkcamera[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this.mWF, "android.permission.CAMERA", 119, "", "")));
        x.i("MicroMsg.GameJsApiChooseMedia", " checkPermission checkMicroPhone[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this.mWF, "android.permission.RECORD_AUDIO", 120, "", "")));
        if (com.tencent.mm.pluginsdk.g.a.a(this.mWF, "android.permission.RECORD_AUDIO", 120, "", "") && r0) {
            String str;
            String ou = bh.ou(jSONObject.optString("sourceType"));
            String optString = jSONObject.optString("mediaType", "");
            int min = Math.min(jSONObject.optInt("maxDuration", 10), 10);
            String optString2 = jSONObject.optString("camera", "");
            int optInt = jSONObject.optInt("count", 1);
            String optString3 = jSONObject.optString("sizeType", "");
            x.i("MicroMsg.GameJsApiChooseMedia", "doChooseMedia sourceType:%s, mediaType:%s, maxDuration:%d, camera:%s, count:%d, sizeType:%s", ou, optString, Integer.valueOf(min), optString2, Integer.valueOf(optInt), optString3);
            Intent intent = new Intent();
            intent.putExtra("key_pick_local_pic_count", optInt);
            if (min <= 0) {
                min = 10;
            }
            intent.putExtra("key_pick_local_media_duration", min);
            intent.putExtra("query_media_type", 3);
            intent.putExtra("key_pick_local_media_video_type", 2);
            intent.putExtra("key_pick_local_media_sight_type", optString);
            intent.putExtra("key_pick_local_pic_query_source_type", (optString3.contains("original") ^ optString3.contains("compressed")) != 0 ? 7 : 8);
            intent.putExtra("key_pick_local_pic_send_raw", Boolean.valueOf(optString3.contains("compressed")));
            if (bh.ov(ou)) {
                str = "album|camera";
            } else {
                str = ou;
            }
            if (str.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM) && str.contains("camera")) {
                l lVar = new l(this.mWF);
                lVar.b(null, new 1(this), new 2(this, optString2, intent));
                lVar.e(new 3(this, dVar, i));
                lVar.bBX();
                return;
            } else if (str.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM)) {
                J(intent);
                return;
            } else if (str.contains("camera")) {
                a(optString2, intent);
                return;
            } else {
                dVar.E(i, a.e("chooseMedia:fail_sourceType_error", null));
                return;
            }
        }
        dVar.E(i, a.e("doChooseMedia:fail_no_user_permission", null));
    }

    final void a(String str, Intent intent) {
        int i;
        x.i("MicroMsg.GameJsApiChooseMedia", "chooseMediaFromCamera");
        if (str.equals("front")) {
            i = 16;
        } else {
            i = 256;
        }
        intent.putExtra("key_pick_local_pic_capture", i);
        this.mWF.jwN = this.jbn;
        com.tencent.mm.bm.d.a(this.mWF, "webview", ".ui.tools.OpenFileChooserUI", intent, 65535 & hashCode(), false);
    }

    final void J(Intent intent) {
        x.i("MicroMsg.GameJsApiChooseMedia", "chooseMediaFromAlbum");
        intent.putExtra("key_pick_local_pic_capture", Downloads.RECV_BUFFER_SIZE);
        this.mWF.jwN = this.jbn;
        com.tencent.mm.bm.d.a(this.mWF, "webview", ".ui.tools.OpenFileChooserUI", intent, 65535 & hashCode(), false);
    }
}
