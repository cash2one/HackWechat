package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h extends a {
    public static final int CTRL_BYTE = 104;
    public static final String NAME = "chooseImage";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiChooseImage", "invoke");
        Context aPh = dVar.aPh();
        if (jSONObject == null) {
            x.i("MicroMsg.GameJsApiChooseImage", "data is null");
            dVar.E(i, a.e("chooseImage:fail_invalid_data", null));
            return;
        }
        int i2;
        Serializable valueOf;
        JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
        int i3 = 0;
        if (optJSONArray != null) {
            x.i("MicroMsg.GameJsApiChooseImage", "sourceType = " + optJSONArray.toString());
            for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                if (optJSONArray.optString(i2).equals(FFmpegMetadataRetriever.METADATA_KEY_ALBUM)) {
                    i3 |= 1;
                } else if (optJSONArray.optString(i2).equals("camera")) {
                    i3 |= 2;
                }
            }
        }
        i2 = i3;
        if (i2 == 0) {
            i2 = 3;
        }
        x.i("MicroMsg.GameJsApiChooseImage", "real scene = %d", Integer.valueOf(i2));
        if (i2 == 2 || i2 == 3) {
            x.d("MicroMsg.GameJsApiChooseImage", " checkPermission checkcamera[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(aPh, "android.permission.CAMERA", 113, "", "")));
            if (!com.tencent.mm.pluginsdk.g.a.a(aPh, "android.permission.CAMERA", 113, "", "")) {
                dVar.E(i, a.e("chooseImage:fail_android_permission_denied", null));
                return;
            }
        }
        int optInt = jSONObject.optInt("count", 0);
        Boolean valueOf2 = Boolean.valueOf(false);
        Boolean valueOf3 = Boolean.valueOf(false);
        JSONArray optJSONArray2 = jSONObject.optJSONArray("sizeType");
        if (optJSONArray2 != null) {
            for (i3 = 0; i3 < optJSONArray2.length(); i3++) {
                if (optJSONArray2.optString(i3).equals("original")) {
                    valueOf2 = Boolean.valueOf(true);
                } else if (optJSONArray2.optString(i3).equals("compressed")) {
                    valueOf3 = Boolean.valueOf(true);
                }
            }
        }
        if (valueOf2.booleanValue() && !r3.booleanValue()) {
            i3 = 7;
            valueOf = Boolean.valueOf(true);
        } else if (valueOf2.booleanValue() || !r3.booleanValue()) {
            i3 = 8;
            r4 = Boolean.valueOf(false);
        } else {
            i3 = 7;
            r4 = Boolean.valueOf(false);
        }
        Intent intent = new Intent();
        intent.putExtra("key_pick_local_pic_capture", i2);
        intent.putExtra("key_pick_local_pic_count", optInt);
        intent.putExtra("key_pick_local_pic_query_source_type", i3);
        intent.putExtra("key_pick_local_pic_send_raw", valueOf);
        intent.putExtra("query_media_type", 1);
        x.i("MicroMsg.GameJsApiChooseImage", "doChooseImage: realScene: %d, count: %d, querySourceType: %d, sendRaw: %b", Integer.valueOf(i2), Integer.valueOf(optInt), Integer.valueOf(i3), valueOf);
        aPh.jwN = new 1(this, dVar, i, aPh);
        com.tencent.mm.bm.d.a(aPh, "webview", ".ui.tools.OpenFileChooserUI", intent, 14, false);
    }
}
