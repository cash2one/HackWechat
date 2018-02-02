package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask$ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.ChooseResult;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class JsApiChooseImage$2 implements b<ChooseResult> {
    final /* synthetic */ int gOK;
    final /* synthetic */ j iZy;
    final /* synthetic */ JsApiChooseImage jmF;

    JsApiChooseImage$2(JsApiChooseImage jsApiChooseImage, j jVar, int i) {
        this.jmF = jsApiChooseImage;
        this.iZy = jVar;
        this.gOK = i;
    }

    public final /* synthetic */ void c(AppBrandProxyUIProcessTask$ProcessResult appBrandProxyUIProcessTask$ProcessResult) {
        ChooseResult chooseResult = (ChooseResult) appBrandProxyUIProcessTask$ProcessResult;
        if (chooseResult != null) {
            switch (chooseResult.bjW) {
                case -1:
                    ArrayList arrayList = chooseResult.jmK;
                    if (bh.cA(arrayList)) {
                        x.e("MicroMsg.JsApiChooseImage", "onActivityResult, result list is null or nil");
                        break;
                    }
                    ArrayList arrayList2 = new ArrayList(arrayList.size());
                    ArrayList arrayList3 = new ArrayList(arrayList.size());
                    ArrayList arrayList4 = new ArrayList(arrayList.size());
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        AppBrandLocalMediaObject appBrandLocalMediaObject = (AppBrandLocalMediaObject) it.next();
                        if (!(appBrandLocalMediaObject == null || bh.ov(appBrandLocalMediaObject.fus))) {
                            arrayList2.add(appBrandLocalMediaObject.fus);
                            arrayList3.add(Long.valueOf(appBrandLocalMediaObject.ieE));
                            arrayList4.add(appBrandLocalMediaObject.hhZ);
                        }
                    }
                    x.i("MicroMsg.JsApiChooseImage", "onActivityResult, localIds json list string = %s", new Object[]{JsApiChooseImage.i(arrayList2)});
                    Map hashMap = new HashMap(1);
                    hashMap.put("tempFilePaths", JsApiChooseImage.j(arrayList2));
                    hashMap.put("tempFileSizes", JsApiChooseImage.j(arrayList3));
                    if (com.tencent.mm.sdk.a.b.ceK()) {
                        hashMap.put("__realPaths", JsApiChooseImage.j(arrayList4));
                    }
                    this.iZy.E(this.gOK, this.jmF.e("ok", hashMap));
                    return;
                case 0:
                    this.iZy.E(this.gOK, this.jmF.e("cancel", null));
                    return;
            }
        }
        this.iZy.E(this.gOK, this.jmF.e("fail", null));
    }
}
