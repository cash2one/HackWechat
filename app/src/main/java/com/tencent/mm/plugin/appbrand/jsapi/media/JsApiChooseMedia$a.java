package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.os.Parcelable;
import android.support.b.a;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.l;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONStringer;

final class JsApiChooseMedia$a extends AppBrandProxyUIProcessTask {
    int jmN;
    private r jmO;
    private OnCancelListener jmP;
    private JsApiChooseMedia$ChooseResult jne = new JsApiChooseMedia$ChooseResult();
    private JsApiChooseMedia$ChooseRequest jnf;
    private String jng;
    private String jnh;
    private l jni;

    private JsApiChooseMedia$a() {
    }

    static /* synthetic */ void b(JsApiChooseMedia$a jsApiChooseMedia$a, String str) {
        File file;
        String str2 = null;
        if (TextUtils.isEmpty(jsApiChooseMedia$a.jnh)) {
            x.e("MicroMsg.JsApiChooseMedia", "mThumbFilePath is empty!");
            file = null;
        } else {
            file = new File(jsApiChooseMedia$a.jnh);
        }
        if (file == null || !file.exists()) {
            x.e("MicroMsg.JsApiChooseMedia", "file == null or file not exist for path:%s!", new Object[]{jsApiChooseMedia$a.jnh});
            String name = new File(str).getName();
            if (!TextUtils.isEmpty(name) && name.contains(".")) {
                str2 = name.substring(0, name.lastIndexOf("."));
            }
            if (TextUtils.isEmpty(str2)) {
                jsApiChooseMedia$a.jnh = e.gHu + ("microMsg_" + System.currentTimeMillis()) + ".jpeg";
            } else if (e.gHu == null || !e.gHu.endsWith("/")) {
                jsApiChooseMedia$a.jnh = e.gHu + "/" + str2 + ".jpeg";
            } else {
                jsApiChooseMedia$a.jnh = e.gHu + str2 + ".jpeg";
            }
            if (new File(jsApiChooseMedia$a.jnh).exists()) {
                x.i("MicroMsg.JsApiChooseMedia", "file is exist for path:%s!", new Object[]{jsApiChooseMedia$a.jnh});
                return;
            }
            x.i("MicroMsg.JsApiChooseMedia", "file not exist for path:%s!", new Object[]{jsApiChooseMedia$a.jnh});
            x.i("MicroMsg.JsApiChooseMedia", "create new thumb path:%s!", new Object[]{jsApiChooseMedia$a.jnh});
            Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
            if (createVideoThumbnail == null) {
                x.e("MicroMsg.JsApiChooseMedia", "createVideoThumbnail bitmap fail for path:%s!", new Object[]{jsApiChooseMedia$a.jnh});
                return;
            }
            try {
                d.a(ThumbnailUtils.extractThumbnail(createVideoThumbnail, 690, 400, 2), 30, CompressFormat.JPEG, jsApiChooseMedia$a.jnh, true);
                return;
            } catch (IOException e) {
                x.e("MicroMsg.JsApiChooseMedia", "saveBitmapToImage exist IOException:" + e.getMessage());
                return;
            }
        }
        x.i("MicroMsg.JsApiChooseMedia", "file is exist!, path:%s", new Object[]{jsApiChooseMedia$a.jnh});
    }

    static /* synthetic */ String g(JsApiChooseMedia$a jsApiChooseMedia$a) {
        if (!TextUtils.isEmpty(jsApiChooseMedia$a.jnh)) {
            AppBrandLocalMediaObject attach = AppBrandLocalMediaObjectManager.attach(jsApiChooseMedia$a.jnf.appId, jsApiChooseMedia$a.jnh, true);
            if (attach != null && !bh.ov(attach.fus)) {
                return attach.fus;
            }
            x.e("MicroMsg.JsApiChooseMedia", "addThumbItem error, localId is null");
        }
        return "";
    }

    protected final void a(ProcessRequest processRequest) {
        this.jnf = (JsApiChooseMedia$ChooseRequest) processRequest;
        this.jmN = (this.jnf.jmI & this.jnf.jmJ) != 0 ? 8 : 7;
        if ((bh.eY(afe()) > 200 ? 1 : 0) == 0) {
            x.e("MicroMsg.JsApiChooseMedia", "memory is not enough!");
            u.makeText(afe(), ac.getResources().getString(j.iyH), 1).show();
        }
        x.i("MicroMsg.JsApiChooseMedia", "goVideo");
        afe().jwN = this;
        if (this.jnf.jmZ && this.jnf.jna) {
            this.jni = new l(afe());
            this.jni.b(null, new 1(this), new 2(this));
            this.jni.e(new 3(this));
            this.jni.bBX();
        } else if (this.jnf.jmZ) {
            agy();
        } else if (this.jnf.jna) {
            agx();
        } else {
            this.jne.bjW = -2;
            x.e("MicroMsg.JsApiChooseMedia", "parameter is invalid, fail and finish process");
            a(this.jne);
        }
    }

    protected final void afk() {
        super.afk();
        if (this.jmO != null) {
            this.jmO.dismiss();
            this.jmO = null;
        }
        if (this.jni != null) {
            this.jni.dismiss();
            this.jni = null;
        }
    }

    private void agx() {
        int i;
        int i2;
        x.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromCamera");
        if (this.jnf.jnc && this.jnf.jnb) {
            i = 0;
        } else if (this.jnf.jnc) {
            i = 1;
        } else if (this.jnf.jnb) {
            i = 2;
        } else {
            i = 0;
        }
        Intent intent = new Intent();
        String str = "KEY_SIGHT_PARAMS";
        String str2 = "microMsg_" + System.currentTimeMillis();
        this.jng = e.gHu + "microMsg." + str2 + ".mp4";
        this.jnh = e.gHu + "microMsg." + str2 + ".jpeg";
        int i3 = this.jnf.maxDuration;
        Parcelable sightParams = new SightParams(3, 1);
        if (this.jnf.isFront) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        sightParams.oqI = i2;
        sightParams.mode = i;
        if (sightParams.oqJ == null) {
            sightParams.oqJ = new VideoTransPara();
        }
        sightParams.oqJ.duration = i3;
        sightParams.oqQ = false;
        sightParams.j(str2, this.jng, this.jnh, e.gHu + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"}));
        intent.putExtra(str, sightParams);
        k.a(afe(), 7, intent, 3, i);
    }

    private void agy() {
        int i = 3;
        boolean z = true;
        x.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromAlbum");
        if (!(this.jnf.jnb && this.jnf.jnc)) {
            if (this.jnf.jnb) {
                i = 1;
            } else if (this.jnf.jnc) {
                i = 2;
            }
        }
        Intent intent = new Intent();
        intent.putExtra("key_can_select_video_and_pic", true);
        String str = "key_send_raw_image";
        if (this.jnf.jmI) {
            z = false;
        }
        intent.putExtra(str, z);
        k.a(afe(), 8, this.jnf.count, this.jmN, i, false, intent);
    }

    public final void b(int i, int i2, Intent intent) {
        if (i2 == 0) {
            x.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult resultCode is canceled");
            this.jne.bjW = 0;
            a(this.jne);
        } else if (-1 != i2) {
            x.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult resultCode is not RESULT_OK");
            this.jne.bjW = -2;
            a(this.jne);
        } else {
            boolean booleanExtra;
            boolean z;
            switch (i) {
                case 7:
                    x.i("MicroMsg.JsApiChooseMedia", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
                    if (intent == null) {
                        x.e("MicroMsg.JsApiChooseMedia", "data is null!");
                        break;
                    }
                    x.i("MicroMsg.JsApiChooseMedia", "data is valid!");
                    SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    if (sightCaptureResult == null) {
                        x.e("MicroMsg.JsApiChooseMedia", "sight capture result is null!");
                        this.jne.bjW = -2;
                        a(this.jne);
                        return;
                    } else if (sightCaptureResult.oqz) {
                        String str = sightCaptureResult.oqH;
                        if (bh.ov(str)) {
                            x.e("MicroMsg.JsApiChooseMedia", "picture_picturePath file is not exist! path:%s", new Object[]{str});
                            this.jne.bjW = -2;
                            a(this.jne);
                            return;
                        }
                        booleanExtra = intent.getBooleanExtra("CropImage_Compress_Img", false);
                        if (((!this.jnf.jmJ ? 1 : 0) & this.jnf.jmI) == 0 && ((this.jnf.jmI & this.jnf.jmJ) & booleanExtra) == 0) {
                            z = false;
                        } else {
                            z = true;
                        }
                        x.d("MicroMsg.JsApiChooseMedia", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[]{Boolean.valueOf(true), Boolean.valueOf(this.jnf.jmI), Boolean.valueOf(this.jnf.jmJ), Boolean.valueOf(booleanExtra), Boolean.valueOf(z)});
                        if (z) {
                            agz();
                        }
                        c.Dm().F(new 6(this, z, str));
                        return;
                    } else {
                        this.jng = sightCaptureResult.oqB;
                        if (bh.ov(this.jng)) {
                            x.e("MicroMsg.JsApiChooseMedia", "mVideoFilePath is null");
                            break;
                        }
                        x.i("MicroMsg.JsApiChooseMedia", "mVideoFilePath:%s", new Object[]{this.jng});
                        if (!sz(this.jnh) && sz(sightCaptureResult.oqC)) {
                            this.jnh = sightCaptureResult.oqC;
                        }
                        agz();
                        c.Dm().F(new Runnable(this) {
                            final /* synthetic */ JsApiChooseMedia$a jnj;

                            {
                                this.jnj = r1;
                            }

                            public final void run() {
                                if (new File(this.jnj.jng).exists()) {
                                    x.i("MicroMsg.JsApiChooseMedia", "take media camera, the mVideoFilePath file exist, success");
                                    this.jnj.jne.bjW = -1;
                                    this.jnj.jne.type = SlookAirButtonRecentMediaAdapter.VIDEO_TYPE;
                                    AppBrandLocalVideoObject a = this.jnj.U(this.jnj.jng, true);
                                    if (a == null) {
                                        x.e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,mVideoFilePath is %s", new Object[]{this.jnj.jng});
                                        this.jnj.jne.bjW = -2;
                                        this.jnj.a(this.jnj.jne);
                                        return;
                                    }
                                    JsApiChooseMedia$a.b(this.jnj, this.jnj.jng);
                                    String g = JsApiChooseMedia$a.g(this.jnj);
                                    this.jnj.jne.jnd = JsApiChooseMedia$a.b(a.fus, g, a.duration, a.height, a.width, a.size);
                                    this.jnj.a(this.jnj.jne);
                                    return;
                                }
                                x.e("MicroMsg.JsApiChooseMedia", "take media camera, mVideoFilePath is %s, the file not exist, fail", new Object[]{this.jnj.jng});
                                this.jnj.jne.bjW = -2;
                                this.jnj.a(this.jnj.jne);
                            }
                        });
                        return;
                    }
                case 8:
                    x.i("MicroMsg.JsApiChooseMedia", "REQUEST_CODE_TAKE_MEDIA_LOCAL");
                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                    if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                        final List stringArrayListExtra2 = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                        if (stringArrayListExtra2 == null || stringArrayListExtra2.size() == 0) {
                            x.e("MicroMsg.JsApiChooseMedia", "chosen is null,  fail");
                            this.jne.bjW = -2;
                            a(this.jne);
                            return;
                        }
                        booleanExtra = intent.getBooleanExtra("CropImage_Compress_Img", false);
                        if (((!this.jnf.jmJ ? 1 : 0) & this.jnf.jmI) == 0 && ((this.jnf.jmI & this.jnf.jmJ) & booleanExtra) == 0) {
                            z = false;
                        } else {
                            z = true;
                        }
                        x.i("MicroMsg.JsApiChooseMedia", "onActivityResult, fromCamera = %b, canCompress = %b, canOriginal = %b, CropImageUI.KCompressImg = %b, doCompress = %b", new Object[]{Boolean.valueOf(false), Boolean.valueOf(this.jnf.jmI), Boolean.valueOf(this.jnf.jmJ), Boolean.valueOf(booleanExtra), Boolean.valueOf(z)});
                        if (z) {
                            agz();
                        }
                        c.Dm().F(new Runnable(this) {
                            final /* synthetic */ JsApiChooseMedia$a jnj;

                            public final void run() {
                                ArrayList arrayList = new ArrayList(stringArrayListExtra2.size());
                                ArrayList arrayList2 = new ArrayList(stringArrayListExtra2.size());
                                for (String str : stringArrayListExtra2) {
                                    String str2;
                                    if (z) {
                                        str2 = JsApiChooseMedia$a.sw(str2);
                                    }
                                    AppBrandLocalMediaObject attach = AppBrandLocalMediaObjectManager.attach(this.jnj.jnf.appId, str2, z | 0);
                                    if (attach != null) {
                                        arrayList.add(Long.valueOf(attach.ieE));
                                        arrayList2.add(attach.fus);
                                    } else {
                                        x.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj from path: %s", new Object[]{str2});
                                    }
                                }
                                if (arrayList2.size() == 0) {
                                    x.e("MicroMsg.JsApiChooseMedia", "handle image from album, get null obj");
                                    this.jnj.jne.bjW = -2;
                                    this.jnj.a(this.jnj.jne);
                                    return;
                                }
                                ag.y(new 1(this, arrayList2, arrayList));
                            }
                        });
                        return;
                    }
                    this.jng = (String) stringArrayListExtra.get(0);
                    if (bh.ov(this.jng)) {
                        x.e("MicroMsg.JsApiChooseMedia", "take media local, mVideoFilePath is  null, fail");
                        break;
                    }
                    agz();
                    c.Dm().F(new 4(this));
                    return;
            }
            this.jne.bjW = -2;
            a(this.jne);
        }
    }

    private void agz() {
        this.jmP = new 8(this);
        Context afe = afe();
        ac.getResources().getString(j.dGO);
        this.jmO = h.a(afe, ac.getResources().getString(j.iyI), true, this.jmP);
    }

    private static String sw(String str) {
        String str2 = e.gHu + "microMsg." + System.currentTimeMillis() + ".jpg";
        try {
            Bitmap decodeFile = MMBitmapFactory.decodeFile(str, 0);
            if (decodeFile == null) {
                x.e("MicroMsg.JsApiChooseMedia", "doCompressImage, decode bmp return null");
                return null;
            }
            long Wp = bh.Wp();
            int a = o.a(decodeFile, 70, str2);
            x.i("MicroMsg.JsApiChooseMedia", "doCompressImage, ret = %d, cost = %d, %s (%d) -> %s (%d)", new Object[]{Integer.valueOf(a), Long.valueOf(bh.Wp() - Wp), str, Long.valueOf(new File(str).length()), str2, Long.valueOf(new File(str2).length())});
            if (a == 1 && com.tencent.mm.a.e.bO(str) && com.tencent.mm.a.e.bO(str2)) {
                try {
                    b.a(new a(str), new a(str2));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.JsApiChooseMedia", e, "duplicate exif", new Object[0]);
                }
            }
            return a == 1 ? str2 : str;
        } catch (OutOfMemoryError e2) {
            x.e("MicroMsg.JsApiChooseMedia", "doCompressImage, decode bmp oom");
            return null;
        }
    }

    private AppBrandLocalVideoObject U(String str, boolean z) {
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            boolean oy = com.tencent.mm.plugin.a.c.oy(str);
            x.i("MicroMsg.JsApiChooseMedia", "checkRemux, isMp4 = %b", new Object[]{Boolean.valueOf(oy)});
            int i = -10000;
            if (oy) {
                i = SightVideoJNI.shouldRemuxing(str, 660, 500, 26214400, 300000.0d, Constants.MAX_BUFFER_SIZE);
                x.i("MicroMsg.JsApiChooseMedia", "checkRemux, ret = %d", new Object[]{Integer.valueOf(i)});
            }
            if (i == -1 || !oy) {
                x.i("MicroMsg.JsApiChooseMedia", "fileLength = %d", new Object[]{Integer.valueOf(com.tencent.mm.a.e.bN(str))});
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
                    x.e("MicroMsg.JsApiChooseMedia", "unknown check type");
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
                x.i("MicroMsg.JsApiChooseMedia", "remuxIfNeed [%s] to [%s], result %d, resolution:[%d, %d]", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                str = str2;
            }
        } catch (Throwable e) {
            x.e("MicroMsg.JsApiChooseMedia", "addVideoItem, remux failed, exp = %s", new Object[]{bh.i(e)});
        }
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
        } catch (Exception e2) {
            x.e("MicroMsg.JsApiChooseMedia", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[]{e2});
            mediaMetadataRetriever = null;
        }
        if (mediaMetadataRetriever == null) {
            x.e("MicroMsg.JsApiChooseMedia", "addVideoItem, null meta data");
            return null;
        }
        int i4 = bh.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
        i2 = bh.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
        i3 = bh.getInt(mediaMetadataRetriever.extractMetadata(9), 0);
        mediaMetadataRetriever.release();
        AppBrandLocalVideoObject attachVideo = AppBrandLocalMediaObjectManager.attachVideo(this.jnf.appId, str);
        if (attachVideo == null) {
            x.e("MicroMsg.JsApiChooseMedia", "attachVideo error, return null");
            return null;
        }
        attachVideo.duration = (i3 + 500) / 1000;
        attachVideo.width = i4;
        attachVideo.height = i2;
        attachVideo.size = com.tencent.mm.a.e.bN(str);
        x.i("MicroMsg.JsApiChooseMedia", "addVideoItem, return %s", new Object[]{attachVideo});
        return attachVideo;
    }

    private static boolean sz(String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.JsApiChooseMedia", "video thumb file path is null");
            return false;
        }
        File file = new File(str);
        x.i("MicroMsg.JsApiChooseMedia", "thumbFilePath:%s", new Object[]{str});
        if (file.exists()) {
            x.i("MicroMsg.JsApiChooseMedia", "video thumb file is exist");
            return true;
        }
        x.e("MicroMsg.JsApiChooseMedia", "video thumb file is not exist");
        return false;
    }

    private static String a(ArrayList<String> arrayList, ArrayList<Long> arrayList2) {
        if (arrayList == null || arrayList.size() == 0) {
            x.e("MicroMsg.JsApiChooseMedia", "parseImageItemToJson localIds is null");
            return "";
        }
        x.i("MicroMsg.JsApiChooseMedia", "parseImageItemToJson()");
        JSONStringer jSONStringer = new JSONStringer();
        try {
            jSONStringer.array();
            for (int i = 0; i < arrayList.size(); i++) {
                jSONStringer.object();
                String str = (String) arrayList.get(i);
                Long l = (Long) arrayList2.get(i);
                jSONStringer.key("tempFilePath");
                jSONStringer.value(str);
                jSONStringer.key("size");
                jSONStringer.value(String.valueOf(l.longValue()));
                jSONStringer.endObject();
            }
            jSONStringer.endArray();
            return jSONStringer.toString();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.JsApiChooseMedia", e, "", new Object[0]);
            return "";
        }
    }

    private static String b(String str, String str2, int i, int i2, int i3, int i4) {
        if (bh.ov(str)) {
            x.e("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson localId is null");
            return "";
        }
        x.i("MicroMsg.JsApiChooseMedia", "parseVideoItemToJson()");
        JSONStringer jSONStringer = new JSONStringer();
        try {
            jSONStringer.array();
            jSONStringer.object();
            jSONStringer.key("tempFilePath");
            jSONStringer.value(str);
            jSONStringer.key("thumbTempFilePath");
            jSONStringer.value(str2);
            jSONStringer.key(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
            jSONStringer.value(String.valueOf(i));
            jSONStringer.key("height");
            jSONStringer.value(String.valueOf(i2));
            jSONStringer.key("width");
            jSONStringer.value(String.valueOf(i3));
            jSONStringer.key("size");
            jSONStringer.value(String.valueOf(i4));
            jSONStringer.endObject();
            jSONStringer.endArray();
            return jSONStringer.toString();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.JsApiChooseMedia", e, "", new Object[0]);
            return "";
        }
    }
}
