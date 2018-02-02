package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.a;
import java.util.ArrayList;

class JsApiChooseImage$a$3 implements Runnable {
    final /* synthetic */ String icE;
    final /* synthetic */ a jmQ;

    JsApiChooseImage$a$3(a aVar, String str) {
        this.jmQ = aVar;
        this.icE = str;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.putExtra("key_send_raw_image", !this.jmQ.jmL.jmI);
        intent.putExtra("max_select_count", this.jmQ.jmL.count);
        intent.putExtra("query_source_type", this.jmQ.jmN);
        intent.putExtra("isPreviewPhoto", true);
        intent.putExtra("max_select_count", 1);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(this.icE);
        intent.putStringArrayListExtra("preview_image_list", arrayList);
        intent.putExtra("preview_image", true);
        intent.addFlags(67108864);
        a.a(this.jmQ, "gallery", ".ui.GalleryEntryUI", intent);
    }
}
