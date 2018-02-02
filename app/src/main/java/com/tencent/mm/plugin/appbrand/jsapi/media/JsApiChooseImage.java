package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.bm.d;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.base.u;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseImage extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 29;
    public static final String NAME = "chooseImage";
    private static volatile boolean jmE = false;

    private static final class a extends AppBrandProxyUIProcessTask {
        ChooseRequest jmL;
        ChooseResult jmM = new ChooseResult();
        int jmN;
        private r jmO;
        private OnCancelListener jmP;

        private a() {
        }

        static /* synthetic */ void a(a aVar, String str, String str2, Intent intent) {
            aVar.afe().jwN = aVar;
            d.b(aVar.afe(), str, str2, intent, 3);
        }

        protected final void a(ProcessRequest processRequest) {
            boolean z;
            this.jmL = (ChooseRequest) processRequest;
            this.jmL.count = Math.max(1, Math.min(9, this.jmL.count));
            this.jmN = (this.jmL.jmI & this.jmL.jmJ) != 0 ? 8 : 7;
            if (bh.eY(afe()) > 200) {
                int i = 1;
            } else {
                z = false;
            }
            if (i == 0) {
                u.makeText(afe(), ac.getResources().getString(j.iyH), 1).show();
            }
            afe().jwN = this;
            Intent intent = new Intent();
            String str = "key_send_raw_image";
            if (this.jmL.jmI) {
                z = false;
            } else {
                z = true;
            }
            intent.putExtra(str, z);
            intent.putExtra("query_media_type", 1);
            if (this.jmL.jmG && this.jmL.jmH) {
                k.a(afe(), 1, this.jmL.count, this.jmN, intent);
            } else if (this.jmL.jmH) {
                intent.putExtra("show_header_view", false);
                k.a(afe(), 1, this.jmL.count, this.jmN, intent);
            } else if (this.jmL.jmG) {
                k.c(afe(), e.gHu, "microMsg." + System.currentTimeMillis() + ".jpg", 2);
            } else {
                x.e("MicroMsg.JsApiChooseImage", "unknown scene, ignore this request");
                this.jmM.bjW = -2;
                a(this.jmM);
            }
        }

        private void kA(int i) {
            this.jmP = new 1(this);
            Context afe = afe();
            ac.getResources().getString(j.dGO);
            this.jmO = h.a(afe, ac.getResources().getString(i), true, this.jmP);
        }

        private static String sv(String str) {
            int orientationInDegree = Exif.fromFile(str).getOrientationInDegree();
            if (orientationInDegree == 0) {
                return str;
            }
            orientationInDegree %= 360;
            try {
                Options options = new Options();
                Bitmap decodeFile = MMBitmapFactory.decodeFile(str, options, 0);
                if (decodeFile == null) {
                    x.e("MicroMsg.JsApiChooseImage", "rotate image, get null bmp");
                    return str;
                }
                Bitmap b = com.tencent.mm.sdk.platformtools.d.b(decodeFile, (float) orientationInDegree);
                String str2 = e.gHu + "microMsg.tmp." + System.currentTimeMillis() + (com.tencent.mm.plugin.appbrand.q.a.a(options) ? ".jpg" : ".png");
                try {
                    com.tencent.mm.sdk.platformtools.d.a(b, 100, com.tencent.mm.plugin.appbrand.q.a.a(options) ? CompressFormat.JPEG : CompressFormat.PNG, str2, true);
                    if (com.tencent.mm.plugin.appbrand.q.a.a(options) && com.tencent.mm.a.e.bO(str) && com.tencent.mm.a.e.bO(str2)) {
                        try {
                            android.support.b.a aVar = new android.support.b.a(str2);
                            b.a(new android.support.b.a(str), aVar);
                            aVar.setAttribute(android.support.b.a.TAG_ORIENTATION, null);
                            aVar.setAttribute(android.support.b.a.TAG_IMAGE_WIDTH, null);
                            aVar.setAttribute(android.support.b.a.TAG_THUMBNAIL_IMAGE_WIDTH, null);
                            aVar.saveAttributes();
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.JsApiChooseImage", e, "duplicate exif", new Object[0]);
                        }
                    }
                    return str2;
                } catch (Exception e2) {
                    x.e("MicroMsg.JsApiChooseImage", "rotate image, exception occurred when saving | %s", new Object[]{e2});
                    b.deleteFile(str2);
                    return str;
                }
            } catch (OutOfMemoryError e3) {
                return str;
            } catch (NullPointerException e4) {
                return str;
            }
        }

        private static String sw(String str) {
            Bitmap decodeFile;
            String str2 = e.gHu + "microMsg." + System.currentTimeMillis() + ".jpg";
            try {
                decodeFile = MMBitmapFactory.decodeFile(str, 0);
            } catch (OutOfMemoryError e) {
                x.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp oom");
                try {
                    decodeFile = com.tencent.mm.sdk.platformtools.d.decodeFile(str, null);
                } catch (OutOfMemoryError e2) {
                    x.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp oom retry, oom again");
                    decodeFile = null;
                } catch (Exception e3) {
                    x.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp oom retry, e " + e3);
                    decodeFile = null;
                }
            } catch (NullPointerException e4) {
                try {
                    decodeFile = com.tencent.mm.sdk.platformtools.d.decodeFile(str, null);
                } catch (Exception e32) {
                    x.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp npe retry, e " + e32);
                    decodeFile = null;
                }
            } catch (Exception e322) {
                x.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp e " + e322);
                decodeFile = null;
            }
            if (decodeFile == null) {
                x.e("MicroMsg.JsApiChooseImage", "doCompressImage, decode bmp return null");
                return null;
            }
            long Wp = bh.Wp();
            x.i("MicroMsg.JsApiChooseImage", "doCompressImage, ret = %b, cost = %d, %s (%d) -> %s (%d)", new Object[]{Boolean.valueOf(com.tencent.mm.plugin.appbrand.q.a.bE(str2, str)), Long.valueOf(bh.Wp() - Wp), str, Long.valueOf(new File(str).length()), str2, Long.valueOf(new File(str2).length())});
            return com.tencent.mm.plugin.appbrand.q.a.bE(str2, str) ? str2 : str;
        }

        protected final void afk() {
            super.afk();
            if (this.jmO != null) {
                this.jmO.dismiss();
                this.jmO = null;
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void b(int i, int i2, Intent intent) {
            boolean z = true;
            if (i2 == 0) {
                this.jmM.bjW = 0;
                a(this.jmM);
                return;
            }
            String b;
            switch (i) {
                case 1:
                case 3:
                    if (intent == null) {
                        this.jmM.bjW = 0;
                        a(this.jmM);
                        return;
                    }
                    boolean z2;
                    final List<String> stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                    final boolean z3 = (((!this.jmL.jmJ ? 1 : 0) & this.jmL.jmI) == 0 && ((this.jmL.jmI & this.jmL.jmJ) & intent.getBooleanExtra("CropImage_Compress_Img", false)) == 0) ? false : true;
                    if (intent.getBooleanExtra("isTakePhoto", false) || intent.getBooleanExtra("isPreviewPhoto", false)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    x.d("MicroMsg.JsApiChooseImage", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[]{Boolean.valueOf(z2), Boolean.valueOf(this.jmL.jmI), Boolean.valueOf(this.jmL.jmJ), Boolean.valueOf(r6), Boolean.valueOf(z3)});
                    if (z3) {
                        kA(j.iyI);
                    }
                    if (!z3) {
                        boolean z4;
                        if (!bh.cA(stringArrayListExtra)) {
                            for (String b2 : stringArrayListExtra) {
                                if (Exif.fromFile(b2).getOrientationInDegree() != 0) {
                                    z4 = true;
                                    break;
                                }
                            }
                        }
                        z4 = false;
                        break;
                    }
                    z = false;
                    if (z) {
                        kA(j.izN);
                    }
                    c.Dm().F(new Runnable(this) {
                        final /* synthetic */ a jmQ;

                        public final void run() {
                            ArrayList arrayList = new ArrayList(stringArrayListExtra.size());
                            for (String str : stringArrayListExtra) {
                                boolean z;
                                String str2;
                                boolean z2 = z2;
                                String sx;
                                if (z3) {
                                    sx = a.sw(str);
                                    z = z2 | 1;
                                    str2 = sx;
                                } else {
                                    if (z) {
                                        sx = a.sv(str);
                                        if (!sx.equals(str)) {
                                            z = z2 | 1;
                                            str2 = sx;
                                        }
                                    }
                                    boolean z3 = z2;
                                    str2 = str;
                                    z = z3;
                                }
                                AppBrandLocalMediaObject attach = AppBrandLocalMediaObjectManager.attach(this.jmQ.jmL.appId, str2, z);
                                if (attach != null) {
                                    arrayList.add(attach);
                                } else {
                                    x.e("MicroMsg.JsApiChooseImage", "handle chosen list from gallery, get null obj from path: %s", new Object[]{str2});
                                }
                            }
                            ag.y(new 1(this, arrayList));
                        }
                    });
                    return;
                case 2:
                    b2 = k.b(afe().getApplicationContext(), intent, e.gHu);
                    if (bh.ov(b2)) {
                        x.w("MicroMsg.JsApiChooseImage", "take photo, but result is null");
                        this.jmM.bjW = -2;
                        a(this.jmM);
                        return;
                    }
                    x.i("MicroMsg.JsApiChooseImage", "take photo, result[%s]", new Object[]{b2});
                    ag.y(new 3(this, b2));
                    return;
                default:
                    this.jmM.bjW = -2;
                    a(this.jmM);
                    return;
            }
        }
    }

    static /* synthetic */ String i(ArrayList arrayList) {
        if (arrayList.size() == 0) {
            x.e("MicroMsg.JsApiChooseImage", "data is null");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            jSONArray.put(arrayList.get(i));
        }
        return jSONArray.toString();
    }

    static /* synthetic */ JSONArray j(ArrayList arrayList) {
        if (arrayList.size() == 0) {
            x.e("MicroMsg.JsApiChooseImage", "data is null");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            jSONArray.put(arrayList.get(i));
        }
        return jSONArray;
    }

    public final void a(com.tencent.mm.plugin.appbrand.j jVar, JSONObject jSONObject, int i) {
        int i2 = 0;
        if (jmE) {
            jVar.E(i, e("cancel", null));
            return;
        }
        Context a = a(jVar);
        if (a == null) {
            jVar.E(i, e("fail", null));
            return;
        }
        ProcessRequest chooseRequest = new ChooseRequest();
        JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
        String optString = jSONObject.optString("sizeType");
        x.i("MicroMsg.JsApiChooseImage", "doChooseImage sourceType = %s, sizeType = %s, count = %s", new Object[]{optJSONArray, optString, jSONObject.optString("count")});
        if (optJSONArray == null || optJSONArray.length() == 0) {
            chooseRequest.jmG = true;
            chooseRequest.jmH = true;
        } else {
            chooseRequest.jmG = optJSONArray.toString().contains("camera");
            chooseRequest.jmH = optJSONArray.toString().contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
        }
        if (chooseRequest.jmG) {
            com.tencent.mm.plugin.appbrand.a.a(jVar.mAppId, new 3(this, jVar, jSONObject, i));
            Activity a2 = a(jVar);
            if (a2 == null) {
                jVar.E(i, e("fail", null));
            } else {
                i2 = com.tencent.mm.pluginsdk.g.a.a(a2, "android.permission.CAMERA", 113, "", "");
                if (i2 != 0) {
                    com.tencent.mm.plugin.appbrand.a.oR(jVar.mAppId);
                }
            }
            if (i2 == 0) {
                return;
            }
        }
        jmE = true;
        com.tencent.mm.plugin.appbrand.c.a(jVar.mAppId, new 1(this, jVar));
        if (bh.ov(optString)) {
            optString = "compressed";
        }
        chooseRequest.jmI = optString.contains("compressed");
        chooseRequest.jmJ = optString.contains("original");
        chooseRequest.count = bh.getInt(r5, 9);
        chooseRequest.appId = jVar.mAppId;
        com.tencent.mm.plugin.appbrand.ipc.a.b(a, chooseRequest, new 2(this, jVar, i));
    }
}
