package com.tencent.mm.plugin.webview.ui.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@a(3)
public class OpenFileChooserUI extends MMActivity {
    private int count;
    private ProgressDialog iln = null;
    private String jio;
    private String jip;
    private int mSF;
    private int mTg;
    private int rMR;
    private boolean twP;
    private int twQ;
    private int twR;
    private boolean twS = false;
    private OnCancelListener twT = null;

    static /* synthetic */ void b(OpenFileChooserUI openFileChooserUI, String str) {
        String str2 = null;
        if (openFileChooserUI.twR == 0) {
            x.e("MicroMsg.OpenFileChooserUI", "don't need thumb image");
            return;
        }
        File file;
        if (TextUtils.isEmpty(openFileChooserUI.jip)) {
            x.e("MicroMsg.OpenFileChooserUI", "thumbFilePath is empty!");
            file = null;
        } else {
            file = new File(openFileChooserUI.jip);
        }
        if (file == null || !file.exists()) {
            x.e("MicroMsg.OpenFileChooserUI", "file == null or file not exist for path:%s!", openFileChooserUI.jip);
            String name = new File(str).getName();
            if (!TextUtils.isEmpty(name) && name.contains(".")) {
                str2 = name.substring(0, name.lastIndexOf("."));
            }
            if (TextUtils.isEmpty(str2)) {
                openFileChooserUI.jip = e.gHu + ("microMsg_" + System.currentTimeMillis()) + ".jpeg";
            } else if (e.gHu == null || !e.gHu.endsWith("/")) {
                openFileChooserUI.jip = e.gHu + "/" + str2 + ".jpeg";
            } else {
                openFileChooserUI.jip = e.gHu + str2 + ".jpeg";
            }
            if (new File(openFileChooserUI.jip).exists()) {
                x.i("MicroMsg.OpenFileChooserUI", "file is exist for path:%s!", openFileChooserUI.jip);
                return;
            }
            x.i("MicroMsg.OpenFileChooserUI", "file not exist for path:%s!", openFileChooserUI.jip);
            x.i("MicroMsg.OpenFileChooserUI", "create new thumb path:%s!", openFileChooserUI.jip);
            Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
            if (createVideoThumbnail == null) {
                x.e("MicroMsg.OpenFileChooserUI", "createVideoThumbnail bitmap fail for path:%s!", openFileChooserUI.jip);
                return;
            }
            try {
                d.a(ThumbnailUtils.extractThumbnail(createVideoThumbnail, 690, 400, 2), 30, CompressFormat.JPEG, openFileChooserUI.jip, true);
                return;
            } catch (IOException e) {
                x.e("MicroMsg.OpenFileChooserUI", "saveBitmapToImage exist IOException:" + e.getMessage());
                return;
            }
        }
        x.i("MicroMsg.OpenFileChooserUI", "file is exist!, path:%s", openFileChooserUI.jip);
    }

    static /* synthetic */ String d(OpenFileChooserUI openFileChooserUI) {
        if (TextUtils.isEmpty(openFileChooserUI.jip)) {
            return "";
        }
        WebViewJSSDKFileItem Ol = WebViewJSSDKFileItem.Ol(openFileChooserUI.jip);
        Ol.jip = openFileChooserUI.jip;
        Ol.iLy = true;
        Ol.ftE = 1;
        f.bRB().b(Ol);
        return Ol.fus;
    }

    static /* synthetic */ String m(String str, List list) {
        int[] iArr = new int[2];
        k.d(str, iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        PInt pInt3 = new PInt();
        PInt pInt4 = new PInt();
        com.tencent.mm.plugin.sight.base.d.a(str, pInt, pInt2, pInt3, pInt4, new PInt());
        String str2 = e.gHu + "microMsg." + System.currentTimeMillis() + ".mp4";
        x.i("MicroMsg.OpenFileChooserUI", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", str, str2, Integer.valueOf(SightVideoJNI.remuxing(str, str2, i, i2, b.qsX, b.qsW, 8, 2, 25.0f, (float) pInt4.value, null, 0, false)), Integer.valueOf(i), Integer.valueOf(i2));
        WebViewJSSDKFileItem On = WebViewJSSDKFileItem.On(str2);
        On.width = i;
        On.height = i2;
        On.duration = r2;
        On.size = com.tencent.mm.a.e.bN(str2);
        list.add(On.fus);
        f.bRB().b(On);
        return On.fus;
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        Object obj;
        Intent intent;
        super.onCreate(bundle);
        this.count = getIntent().getIntExtra("key_pick_local_pic_count", 0);
        if (this.count <= 0 || this.count > 9) {
            this.count = 9;
        }
        this.rMR = this.count;
        this.mSF = getIntent().getIntExtra("key_pick_local_pic_query_source_type", 8);
        this.mTg = getIntent().getIntExtra("query_media_type", 1);
        this.twP = getIntent().getBooleanExtra("key_pick_local_pic_send_raw", false);
        this.twQ = getIntent().getIntExtra("key_pick_local_pic_capture", 3);
        this.twR = getIntent().getIntExtra("key_pick_local_media_video_type", 0);
        if ((this.mSF == 7 && this.mTg == 2) || this.mTg == 3) {
            if (!bSl()) {
                u.makeText(this, getString(R.l.eWY), 1).show();
                this.twS = true;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("key_send_raw_image", this.twP);
            intent2.putExtra("query_media_type", this.mTg);
            int intExtra;
            int intExtra2;
            if (this.twR == 1) {
                if (this.twQ != Downloads.RECV_BUFFER_SIZE && (this.twQ & Downloads.RECV_BUFFER_SIZE) > 0) {
                    intExtra = getIntent().getIntExtra("key_pick_local_media_quality", 1);
                    intExtra2 = getIntent().getIntExtra("key_pick_local_media_duration", 60);
                    intent2.putExtra("KEY_SIGHT_PARAMS", AB(1));
                    intent2.putExtra("record_video_force_sys_camera", false);
                    intent2.putExtra("show_header_view", true);
                    intent2.putExtra("record_video_is_sight_capture", true);
                    intent2.putExtra("record_video_quality", intExtra);
                    intent2.putExtra("record_video_time_limit", intExtra2);
                    intent2.putExtra("video_full_path", this.jio);
                    com.tencent.mm.pluginsdk.ui.tools.k.c((Activity) this, this.rMR, this.mSF, intent2);
                } else if (this.twQ == 16 || this.twQ == 256) {
                    intent2.putExtra("KEY_SIGHT_PARAMS", AB(1));
                    com.tencent.mm.pluginsdk.ui.tools.k.a((Context) this, 6, intent2, 3, 1);
                } else if (this.twQ == Downloads.RECV_BUFFER_SIZE) {
                    intent2.putExtra("show_header_view", false);
                    com.tencent.mm.pluginsdk.ui.tools.k.c((Activity) this, this.rMR, this.mSF, intent2);
                }
            } else if (this.twR == 2) {
                String ou = bh.ou(getIntent().getStringExtra("key_pick_local_media_sight_type"));
                if (this.twQ != Downloads.RECV_BUFFER_SIZE && (this.twQ & Downloads.RECV_BUFFER_SIZE) > 0) {
                    x.e("MicroMsg.OpenFileChooserUI", "choose media from local or camera is not support");
                    setResult(1);
                    finish();
                } else if (this.twQ == 16 || this.twQ == 256) {
                    intExtra = 0;
                    if (ou.contains(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE) && ou.contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
                        intExtra = 0;
                    } else if (ou.contains(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
                        intExtra = 1;
                    } else if (ou.contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
                        intExtra = 2;
                    }
                    intent2.putExtra("KEY_SIGHT_PARAMS", AB(intExtra));
                    com.tencent.mm.pluginsdk.ui.tools.k.a((Context) this, 7, intent2, 3, intExtra);
                } else if (this.twQ == Downloads.RECV_BUFFER_SIZE) {
                    r4 = 3;
                    if (ou.contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE) && ou.contains(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
                        r4 = 3;
                    } else if (ou.contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
                        r4 = 1;
                    } else if (ou.contains(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
                        r4 = 2;
                    }
                    Intent intent3 = new Intent();
                    intent3.putExtra("key_can_select_video_and_pic", true);
                    intent3.putExtra("key_send_raw_image", this.twP);
                    com.tencent.mm.pluginsdk.ui.tools.k.a((Activity) this, 8, this.rMR, this.mSF, r4, false, intent3);
                }
            } else if (this.twQ != Downloads.RECV_BUFFER_SIZE && (this.twQ & Downloads.RECV_BUFFER_SIZE) > 0) {
                this.jio = e.gHu + "microMsg." + System.currentTimeMillis() + ".mp4";
                intExtra = getIntent().getIntExtra("key_pick_local_media_quality", 1);
                intExtra2 = getIntent().getIntExtra("key_pick_local_media_duration", 60);
                intent2.putExtra("record_video_force_sys_camera", true);
                intent2.putExtra("record_video_quality", intExtra);
                intent2.putExtra("record_video_time_limit", intExtra2);
                intent2.putExtra("video_full_path", this.jio);
                com.tencent.mm.pluginsdk.ui.tools.k.c((Activity) this, this.rMR, this.mSF, intent2);
            } else if (this.twQ == 16 || this.twQ == 256) {
                this.jio = e.gHu + "microMsg." + System.currentTimeMillis() + ".mp4";
                r4 = getIntent().getIntExtra("key_pick_local_media_quality", 1);
                com.tencent.mm.pluginsdk.ui.tools.k.a((Activity) this, this.jio, 5, getIntent().getIntExtra("key_pick_local_media_duration", 60), r4, this.twQ == 16);
            } else if (this.twQ == Downloads.RECV_BUFFER_SIZE) {
                intent2.putExtra("show_header_view", false);
                com.tencent.mm.pluginsdk.ui.tools.k.c((Activity) this, this.rMR, this.mSF, intent2);
            }
            if (this.twQ != Downloads.RECV_BUFFER_SIZE && (this.twQ & Downloads.RECV_BUFFER_SIZE) > 0) {
                obj = 1;
                if (obj == null) {
                    if (!bSl()) {
                        u.makeText(this, getString(R.l.eWY), 1).show();
                        this.twS = true;
                    }
                    intent = new Intent();
                    intent.putExtra("key_send_raw_image", this.twP);
                    intent.putExtra("query_media_type", this.mTg);
                    switch (this.twQ) {
                        case 1:
                            intent.putExtra("show_header_view", false);
                            com.tencent.mm.pluginsdk.ui.tools.k.a((Activity) this, 1, this.rMR, this.mSF, intent);
                            return;
                        case 2:
                            h.a(this, "", new String[]{getString(R.l.eWS)}, "", true, new 1(this), new 2(this));
                            return;
                        case 3:
                            com.tencent.mm.pluginsdk.ui.tools.k.a((Activity) this, 1, this.count, this.mSF, intent);
                            return;
                        default:
                            x.e("MicroMsg.OpenFileChooserUI", "unkown scene, ignore this request");
                            setResult(0);
                            finish();
                            return;
                    }
                }
            } else if (this.twQ == 16 || this.twQ == 256) {
                obj = 1;
                if (obj == null) {
                    if (bSl()) {
                        u.makeText(this, getString(R.l.eWY), 1).show();
                        this.twS = true;
                    }
                    intent = new Intent();
                    intent.putExtra("key_send_raw_image", this.twP);
                    intent.putExtra("query_media_type", this.mTg);
                    switch (this.twQ) {
                        case 1:
                            intent.putExtra("show_header_view", false);
                            com.tencent.mm.pluginsdk.ui.tools.k.a((Activity) this, 1, this.rMR, this.mSF, intent);
                            return;
                        case 2:
                            h.a(this, "", new String[]{getString(R.l.eWS)}, "", true, new 1(this), new 2(this));
                            return;
                        case 3:
                            com.tencent.mm.pluginsdk.ui.tools.k.a((Activity) this, 1, this.count, this.mSF, intent);
                            return;
                        default:
                            x.e("MicroMsg.OpenFileChooserUI", "unkown scene, ignore this request");
                            setResult(0);
                            finish();
                            return;
                    }
                }
            } else if (this.twQ == Downloads.RECV_BUFFER_SIZE) {
                obj = 1;
                if (obj == null) {
                    if (bSl()) {
                        u.makeText(this, getString(R.l.eWY), 1).show();
                        this.twS = true;
                    }
                    intent = new Intent();
                    intent.putExtra("key_send_raw_image", this.twP);
                    intent.putExtra("query_media_type", this.mTg);
                    switch (this.twQ) {
                        case 1:
                            intent.putExtra("show_header_view", false);
                            com.tencent.mm.pluginsdk.ui.tools.k.a((Activity) this, 1, this.rMR, this.mSF, intent);
                            return;
                        case 2:
                            h.a(this, "", new String[]{getString(R.l.eWS)}, "", true, new 1(this), new 2(this));
                            return;
                        case 3:
                            com.tencent.mm.pluginsdk.ui.tools.k.a((Activity) this, 1, this.count, this.mSF, intent);
                            return;
                        default:
                            x.e("MicroMsg.OpenFileChooserUI", "unkown scene, ignore this request");
                            setResult(0);
                            finish();
                            return;
                    }
                }
            }
        }
        obj = null;
        if (obj == null) {
            if (bSl()) {
                u.makeText(this, getString(R.l.eWY), 1).show();
                this.twS = true;
            }
            intent = new Intent();
            intent.putExtra("key_send_raw_image", this.twP);
            intent.putExtra("query_media_type", this.mTg);
            switch (this.twQ) {
                case 1:
                    intent.putExtra("show_header_view", false);
                    com.tencent.mm.pluginsdk.ui.tools.k.a((Activity) this, 1, this.rMR, this.mSF, intent);
                    return;
                case 2:
                    h.a(this, "", new String[]{getString(R.l.eWS)}, "", true, new 1(this), new 2(this));
                    return;
                case 3:
                    com.tencent.mm.pluginsdk.ui.tools.k.a((Activity) this, 1, this.count, this.mSF, intent);
                    return;
                default:
                    x.e("MicroMsg.OpenFileChooserUI", "unkown scene, ignore this request");
                    setResult(0);
                    finish();
                    return;
            }
        }
    }

    private boolean bSl() {
        x.i("MicroMsg.OpenFileChooserUI", "avaiableMem = %d", Long.valueOf(bh.eY(this)));
        if (bh.eY(this) <= 200) {
            return false;
        }
        return true;
    }

    private SightParams AB(int i) {
        String str = "microMsg_" + System.currentTimeMillis();
        this.jio = e.gHu + str + ".mp4";
        this.jip = e.gHu + str + ".jpeg";
        int intExtra = getIntent().getIntExtra("key_pick_local_media_duration", 60);
        SightParams sightParams = new SightParams(3, 1);
        sightParams.oqI = this.twQ == 16 ? 1 : 2;
        sightParams.mode = i;
        if (sightParams.oqJ == null) {
            sightParams.oqJ = new VideoTransPara();
        }
        sightParams.oqJ.duration = intExtra;
        sightParams.j(str, this.jio, this.jip, e.gHu + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"}));
        return sightParams;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.OpenFileChooserUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    com.tencent.mm.pluginsdk.ui.tools.k.c(this.mController.xIM, e.gHu, "microMsg." + System.currentTimeMillis() + ".jpg", 2);
                    return;
                } else {
                    h.a(this, getString(R.l.ezM), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 3(this), null);
                    return;
                }
            default:
                return;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        File file = null;
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            Intent intent2 = new Intent();
            intent2.putExtra("key_pick_local_media_show_memory_warning", this.twS);
            setResult(i2, intent2);
            finish();
            return;
        }
        String b;
        Intent intent3;
        ArrayList arrayList;
        SightCaptureResult sightCaptureResult;
        switch (i) {
            case 1:
            case 3:
                ar.Dm().F(new 4(this, intent, i2));
                return;
            case 2:
                b = com.tencent.mm.pluginsdk.ui.tools.k.b(this.mController.xIM.getApplicationContext(), intent, e.gHu);
                if (bh.ov(b)) {
                    x.w("MicroMsg.OpenFileChooserUI", "take photo, but result is null");
                    setResult(-2, intent);
                    finish();
                    return;
                }
                x.i("MicroMsg.OpenFileChooserUI", "take photo, result[%s]", b);
                intent3 = new Intent();
                intent3.putExtra("key_send_raw_image", this.twP);
                intent3.putExtra("max_select_count", this.rMR);
                intent3.putExtra("query_source_type", this.mSF);
                arrayList = new ArrayList(1);
                arrayList.add(b);
                intent3.putStringArrayListExtra("preview_image_list", arrayList);
                intent3.putExtra("preview_image", true);
                intent3.addFlags(67108864);
                com.tencent.mm.bm.d.b(this, "gallery", ".ui.GalleryEntryUI", intent3, 3);
                return;
            case 4:
                List stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                if (stringArrayListExtra == null || stringArrayListExtra.size() == 0) {
                    x.e("MicroMsg.OpenFileChooserUI", "choose video failed, path is null");
                    setResult(1);
                    finish();
                    return;
                }
                x.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_GALLERY_VIDEO");
                x.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", stringArrayListExtra.get(0));
                if (this.twR == 1 && !sz(this.jip)) {
                    x.i("MicroMsg.OpenFileChooserUI", "video thumb file is not exist");
                }
                Pa((String) stringArrayListExtra.get(0));
                return;
            case 5:
                if (new File(this.jio).exists()) {
                    Pa(this.jio);
                    return;
                }
                x.e("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_VIDEO, file not exist : %s", this.jio);
                setResult(1);
                finish();
                return;
            case 6:
                x.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_SIGHT_VIDEO");
                if (intent != null) {
                    x.i("MicroMsg.OpenFileChooserUI", "data is valid!");
                    sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    if (sightCaptureResult == null) {
                        x.e("MicroMsg.OpenFileChooserUI", "sight capture result is null!");
                        setResult(1);
                        finish();
                        return;
                    }
                    this.jio = sightCaptureResult.oqB;
                    x.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", this.jio);
                    if (!sz(this.jip) && sz(sightCaptureResult.oqC)) {
                        this.jip = sightCaptureResult.oqC;
                    }
                    if (!TextUtils.isEmpty(this.jio)) {
                        file = new File(this.jio);
                    }
                    if (file == null || !file.exists()) {
                        x.e("MicroMsg.OpenFileChooserUI", "video file is not exist! path:%s", this.jio);
                    } else {
                        x.e("MicroMsg.OpenFileChooserUI", "video file is exist! path:%s", this.jio);
                        Pa(this.jio);
                        return;
                    }
                }
                x.e("MicroMsg.OpenFileChooserUI", "data is null!");
                setResult(1);
                finish();
                return;
            case 7:
                x.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
                if (intent != null) {
                    x.i("MicroMsg.OpenFileChooserUI", "data is valid!");
                    sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    if (sightCaptureResult == null) {
                        x.e("MicroMsg.OpenFileChooserUI", "sight capture result is null!");
                        setResult(1);
                        finish();
                        return;
                    } else if (sightCaptureResult.oqz) {
                        b = sightCaptureResult.oqH;
                        if (bh.ov(b)) {
                            x.e("MicroMsg.OpenFileChooserUI", "picture_picturePath file is not exist! path:%s", b);
                            setResult(1);
                            finish();
                            return;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        WebViewJSSDKFileItem Ol = WebViewJSSDKFileItem.Ol(b);
                        Ol.iLy = true;
                        Ol.ftE = 1;
                        f.bRB().b(Ol);
                        arrayList2.add(Ol.fus);
                        x.i("MicroMsg.OpenFileChooserUI", "filepath is : %s, local id is : %s", b, Ol.fus);
                        x.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", ai.Y(arrayList2));
                        intent3 = new Intent();
                        intent3.putExtra("key_pick_local_media_local_ids", b);
                        intent3.putExtra("key_pick_local_media_callback_type", 2);
                        setResult(i2, intent3);
                        finish();
                        return;
                    } else {
                        File file2;
                        this.jio = sightCaptureResult.oqB;
                        x.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", this.jio);
                        if (!sz(this.jip) && sz(sightCaptureResult.oqC)) {
                            this.jip = sightCaptureResult.oqC;
                        }
                        if (TextUtils.isEmpty(this.jio)) {
                            file2 = null;
                        } else {
                            file2 = new File(this.jio);
                        }
                        if (file2 == null || !file2.exists()) {
                            x.e("MicroMsg.OpenFileChooserUI", "video file is not exist! path:%s", this.jio);
                        } else {
                            x.e("MicroMsg.OpenFileChooserUI", "video file is exist! path:%s", this.jio);
                            Pa(this.jio);
                            return;
                        }
                    }
                }
                x.e("MicroMsg.OpenFileChooserUI", "data is null!");
                setResult(1);
                finish();
                return;
            case 8:
                x.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_MEDIA_LOCAL");
                ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("key_select_video_list");
                if (stringArrayListExtra2 == null || stringArrayListExtra2.size() <= 0) {
                    List<String> stringArrayListExtra3 = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                    boolean booleanExtra = intent.getBooleanExtra("CropImage_Compress_Img", true);
                    if (stringArrayListExtra3 == null) {
                        x.e("MicroMsg.OpenFileChooserUI", "chosen is null");
                        setResult(1);
                        finish();
                        return;
                    }
                    arrayList = new ArrayList();
                    for (String b2 : stringArrayListExtra3) {
                        WebViewJSSDKFileItem Ol2 = WebViewJSSDKFileItem.Ol(b2);
                        String str = Ol2.fus;
                        Ol2.iLy = booleanExtra;
                        f.bRB().b(Ol2);
                        x.i("MicroMsg.OpenFileChooserUI", "now filepath is : %s, local id is : %s", b2, str);
                        arrayList.add(str);
                    }
                    x.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", ai.Y(arrayList));
                    intent3 = new Intent();
                    intent3.putExtra("key_pick_local_media_local_ids", b2);
                    intent3.putExtra("key_pick_local_media_show_memory_warning", this.twS);
                    intent3.putExtra("key_pick_local_media_callback_type", 2);
                    setResult(i2, intent3);
                    finish();
                    return;
                }
                Pa((String) stringArrayListExtra2.get(0));
                return;
            default:
                x.e("MicroMsg.OpenFileChooserUI", "unknown request code = %d", Integer.valueOf(i));
                setResult(1);
                finish();
                return;
        }
    }

    private void Pa(String str) {
        this.twT = new 5(this);
        getString(R.l.dGO);
        this.iln = h.a(this, getString(R.l.eWP), true, this.twT);
        ar.Dm().F(new 6(this, str));
    }

    private String Pb(String str) {
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
        } catch (Exception e) {
            x.e("MicroMsg.OpenFileChooserUI", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", e);
            mediaMetadataRetriever = null;
        }
        if (mediaMetadataRetriever == null) {
            return null;
        }
        int i = bh.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
        int i2 = bh.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
        int i3 = bh.getInt(mediaMetadataRetriever.extractMetadata(9), 0);
        mediaMetadataRetriever.release();
        mediaMetadataRetriever.release();
        WebViewJSSDKFileItem On = WebViewJSSDKFileItem.On(str);
        On.duration = (i3 + 500) / 1000;
        On.width = i;
        On.height = i2;
        On.size = com.tencent.mm.a.e.bN(str);
        if (this.twR == 1) {
            On.jip = this.jip;
        }
        f.bRB().b(On);
        return On.fus;
    }

    private int Pc(String str) {
        com.tencent.mm.compatible.i.a.a j;
        Intent intent = new Intent();
        intent.setData(Uri.parse("file://" + str));
        com.tencent.mm.compatible.i.a.a aVar = null;
        an.is2G(this);
        try {
            j = com.tencent.mm.compatible.i.a.j(this, intent);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.OpenFileChooserUI", e, "", new Object[0]);
            j = aVar;
        }
        if (j == null) {
            x.e("MicroMsg.OpenFileChooserUI", "compressVideo filed.");
            return -50005;
        }
        int i;
        String str2 = j.filename;
        boolean oy = c.oy(str2);
        x.i("MicroMsg.OpenFileChooserUI", "isMp4 = %b", Boolean.valueOf(oy));
        int i2 = -10000;
        if (oy) {
            i2 = SightVideoJNI.shouldRemuxing(str2, 660, 500, 26214400, 300000.0d, Constants.MAX_BUFFER_SIZE);
            x.i("MicroMsg.OpenFileChooserUI", "check remuxing, ret %d", Integer.valueOf(i2));
        }
        if (i2 == -1 || !oy) {
            x.i("MicroMsg.OpenFileChooserUI", "fileLenght = %d", Integer.valueOf(com.tencent.mm.a.e.bN(str2)));
            if (com.tencent.mm.a.e.bN(str2) > 26214400) {
                i2 = -1;
            } else {
                i2 = 1;
            }
        }
        switch (i2) {
            case -6:
            case -5:
            case -4:
            case -3:
            case -2:
            case -1:
                return -50002;
            case 0:
                i = 1;
                i2 = 0;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                i = 0;
                i2 = 1;
                break;
            default:
                x.e("MicroMsg.OpenFileChooserUI", "unknown check type");
                return -50001;
        }
        if (i != 0) {
            i2 = -50006;
        }
        i = j.duration / 1000;
        x.i("MicroMsg.OpenFileChooserUI", "finish to import %s  ret %d | duration %d", str2, Integer.valueOf(i2), Integer.valueOf(i));
        return i2;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.iln != null && this.iln.isShowing()) {
            this.iln.dismiss();
        }
    }

    private static boolean sz(String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.OpenFileChooserUI", "video thumb file path is null");
            return false;
        }
        File file = new File(str);
        x.i("MicroMsg.OpenFileChooserUI", "thumbFilePath:%s", str);
        if (file.exists()) {
            x.i("MicroMsg.OpenFileChooserUI", "video thumb file is exist");
            return true;
        }
        x.e("MicroMsg.OpenFileChooserUI", "video thumb file is not exist");
        return false;
    }
}
