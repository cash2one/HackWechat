package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.ll;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.av.a;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.ui.bc.1;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.base.u;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class bb implements a, b {
    protected String filePath;
    private String jKk;
    private Activity mActivity;
    protected ListView nKG;
    private String nlp;
    protected MMPullDownView onH;
    public int qOh = 0;
    private boolean qRc = false;
    private String rIa;
    private boolean rIb;
    private int rIc;
    protected LoadingMoreView rLe;
    private int rLf = 0;
    private boolean rLg = false;
    protected boolean rLh = false;
    public int rLi = 0;
    a rLj;
    private String rLk;
    com.tencent.mm.modelsns.b rLl = null;
    protected SnsHeader raX;
    private boolean rtl;
    protected r tipDialog = null;
    protected String title;

    static /* synthetic */ void e(bb bbVar) {
        View inflate = LayoutInflater.from(bbVar.mActivity).inflate(g.qFf, (ViewGroup) bbVar.mActivity.findViewById(f.qFf));
        u uVar = new u(bbVar.mActivity);
        uVar.setGravity(48, 0, BackwardSupportUtil.b.b(bbVar.mActivity, 200.0f));
        uVar.duration = 1000;
        uVar.setView(inflate);
        uVar.cancel();
        uVar.fhK.TG();
        uVar.kUH = ((int) (uVar.duration / 70)) + 1;
        uVar.fhK.J(70, 70);
    }

    public bb(Activity activity) {
        this.mActivity = activity;
    }

    public final void onCreate() {
        this.qOh = this.mActivity.getWindowManager().getDefaultDisplay().getHeight();
        ae.bvs().start();
        this.nKG = this.rLj.bBK();
        this.nKG.post(new 1(this));
        x.i("MicroMsg.SnsActivity", "list is null ? " + (this.nKG != null));
        this.nKG.setScrollingCacheEnabled(false);
        this.raX = new SnsHeader(this.mActivity);
        this.raX.rBG = new 6(this);
        this.rLe = new LoadingMoreView(this.mActivity);
        this.nKG.addHeaderView(this.raX);
        this.nKG.addFooterView(this.rLe);
        this.nKG.setOnScrollListener(new 7(this));
        this.onH = this.rLj.bBL();
        x.i("MicroMsg.SnsActivity", "pullDownView is null ? " + (this.onH != null));
        this.onH.ycp = new 8(this);
        this.onH.mp(false);
        this.onH.mm(false);
        this.onH.ycB = new 9(this);
        this.onH.ycC = new d(this) {
            final /* synthetic */ bb rLm;

            {
                this.rLm = r1;
            }

            public final boolean azl() {
                View childAt = this.rLm.nKG.getChildAt(this.rLm.nKG.getFirstVisiblePosition());
                if (childAt == null || childAt.getTop() != 0) {
                    return false;
                }
                return true;
            }
        };
        this.onH.mn(false);
        this.onH.ycq = new e(this) {
            final /* synthetic */ bb rLm;

            {
                this.rLm = r1;
            }

            public final boolean azk() {
                x.e("MicroMsg.SnsActivity", "bottomLoad  isAll:" + this.rLm.rLh);
                if (!this.rLm.rLh) {
                    this.rLm.rLj.bBJ();
                }
                return true;
            }
        };
        this.onH.ycR = true;
        MMPullDownView mMPullDownView = this.onH;
        mMPullDownView.bgColor = Color.parseColor("#f4f4f4");
        mMPullDownView.ycT = mMPullDownView.bgColor;
        this.title = this.mActivity.getIntent().getStringExtra("sns_title");
        SnsHeader snsHeader = this.raX;
        Object obj = bh.ov(this.jKk) ? this.rIa : this.jKk;
        String str = this.rIa;
        CharSequence charSequence = this.nlp;
        CharSequence charSequence2 = this.rLk;
        if (obj == null || str == null) {
            x.e("MicroMsg.SnsHeader", "userName or selfName is null ");
        } else {
            snsHeader.userName = obj.trim();
            snsHeader.gze = str.trim();
            snsHeader.fuf = str.equals(obj);
            x.d("MicroMsg.SnsHeader", "userNamelen " + obj.length() + "  " + obj);
            snsHeader.rBF.ksb.setText(obj);
            if (!(snsHeader.rBF == null || snsHeader.rBF.ihQ == null)) {
                com.tencent.mm.pluginsdk.ui.a.b.b(snsHeader.rBF.ihQ, snsHeader.userName, true);
            }
            if (obj != null && obj.length() > 0) {
                snsHeader.rBF.ksb.setText(i.a(snsHeader.context, com.tencent.mm.plugin.sns.data.i.A(charSequence)));
                snsHeader.rBF.rqT.setText(i.b(snsHeader.context, charSequence2, snsHeader.rBF.rqT.getTextSize()));
            }
            snsHeader.rBF.ihQ.setContentDescription(snsHeader.context.getString(j.qKj, new Object[]{snsHeader.rBF.ksb.getText()}));
        }
        SnsHeader snsHeader2 = this.raX;
        int type = this.rLj.getType();
        snsHeader2.type = type;
        if (type == 1 && snsHeader2.rBF.rqT != null) {
            snsHeader2.rBF.rqT.setVisibility(8);
        }
        this.raX.bAT();
        if (VERSION.SDK_INT < 11) {
            x.d("MicroMsg.SnsActivity", "sdk not support dragdrop event");
        } else {
            new 5(this).run();
        }
        ae.bvr().gCl.add(this);
        av.qSu++;
        ae.bvq().a(this);
    }

    public final void iL(boolean z) {
        this.rLj.iL(z);
    }

    public final void a(String str, String str2, String str3, String str4, boolean z, boolean z2, int i) {
        this.rIa = str;
        this.jKk = str2;
        this.nlp = str3;
        this.rLk = str4;
        this.rIb = z;
        this.rtl = z2;
        this.rIc = i;
    }

    public static void onResume() {
        ae.bvq().I(2, false);
        com.tencent.mm.pluginsdk.wallet.i.CB(7);
        com.tencent.mm.sdk.b.b llVar = new ll();
        llVar.fCN.fCO = true;
        com.tencent.mm.sdk.b.a.xef.a(llVar, Looper.getMainLooper());
        x.d("MicroMsg.SnsActivity", "SnsActivity req pause auto download logic");
    }

    public static void onPause() {
        com.tencent.mm.sdk.b.b llVar = new ll();
        llVar.fCN.fCO = false;
        com.tencent.mm.sdk.b.a.xef.a(llVar, Looper.getMainLooper());
        x.d("MicroMsg.SnsActivity", "AppAttachDownloadUI cancel pause auto download logic");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.SnsActivity", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            int a;
            switch (i) {
                case 2:
                    if (intent != null) {
                        com.tencent.mm.kernel.g.Dk();
                        a = bh.a((Integer) com.tencent.mm.kernel.g.Dj().CU().get(68393, null), 0);
                        com.tencent.mm.kernel.g.Dk();
                        com.tencent.mm.kernel.g.Dj().CU().set(68393, Integer.valueOf(a + 1));
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 4);
                        intent2.putExtra("CropImage_Filter", true);
                        intent2.putExtra("CropImage_DirectlyIntoFilter", true);
                        com.tencent.mm.plugin.sns.c.a.ifs.a(this.mActivity, intent, intent2, ae.getAccSnsTmpPath(), 4, new 13(this));
                        return;
                    }
                    return;
                case 4:
                    if (intent != null) {
                        this.filePath = intent.getStringExtra("CropImage_OutputPath");
                        V(intent);
                        return;
                    }
                    return;
                case 5:
                    this.filePath = k.b(this.mActivity.getApplicationContext(), intent, ae.getAccSnsTmpPath());
                    x.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_TAKE_PHOTO  filePath" + this.filePath);
                    if (this.filePath != null) {
                        com.tencent.mm.kernel.g.Dk();
                        a = bh.a((Integer) com.tencent.mm.kernel.g.Dj().CU().get(68392, null), 0);
                        com.tencent.mm.kernel.g.Dk();
                        com.tencent.mm.kernel.g.Dj().CU().set(68392, Integer.valueOf(a + 1));
                        this.qRc = true;
                        V(intent);
                        return;
                    }
                    return;
                case 6:
                    x.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_UPLOAD_MEDIA");
                    if (intent != null) {
                        this.rLj.a(intent.getIntExtra("sns_local_id", -1), null, null);
                        ae.bvr().buj();
                        return;
                    }
                    return;
                case 7:
                    x.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_CHANGE_BG");
                    this.raX.bAT();
                    ae.bvr().buj();
                    return;
                case 8:
                    if (intent != null) {
                        x.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_GALLERY_OP");
                        SnsCmdList snsCmdList = (SnsCmdList) intent.getParcelableExtra("sns_cmd_list");
                        if (snsCmdList != null) {
                            this.rLj.a(-1, snsCmdList.qQO, snsCmdList.qQP);
                            return;
                        }
                        return;
                    }
                    return;
                case 9:
                    ae.bvr().buj();
                    c.a(this.nKG);
                    return;
                case 10:
                    if (intent != null && i2 == -1) {
                        Cursor managedQuery = this.mActivity.managedQuery(intent.getData(), null, null, null, null);
                        if (managedQuery.moveToFirst()) {
                            this.mActivity.startActivity(new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/" + managedQuery.getString(managedQuery.getColumnIndexOrThrow("_id")))));
                            return;
                        }
                        return;
                    }
                    return;
                case 12:
                    a = intent.getIntExtra("sns_gallery_op_id", -1);
                    if (a > 0) {
                        x.d("MicroMsg.SnsActivity", "notify cause by del item");
                        SnsCmdList snsCmdList2 = new SnsCmdList();
                        snsCmdList2.wt(a);
                        this.rLj.a(-1, snsCmdList2.qQO, snsCmdList2.qQP);
                        return;
                    }
                    return;
                case 13:
                    ae.bvA().auv();
                    return;
                case 14:
                    new af(Looper.getMainLooper()).post(new 2(this));
                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                    if ((stringArrayListExtra == null || stringArrayListExtra.size() <= 0) && bh.ov(intent.getStringExtra("K_SEGMENTVIDEOPATH"))) {
                        Serializable stringArrayListExtra2 = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                        if (stringArrayListExtra2 == null || stringArrayListExtra2.size() == 0) {
                            x.i("MicroMsg.SnsActivity", "no image selected");
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        Iterator it = stringArrayListExtra2.iterator();
                        while (it.hasNext()) {
                            if (Exif.fromFile((String) it.next()).getLocation() != null) {
                                arrayList.add(String.format("%s\n%f\n%f", new Object[]{(String) it.next(), Double.valueOf(Exif.fromFile((String) it.next()).getLocation().latitude), Double.valueOf(Exif.fromFile((String) it.next()).getLocation().longitude)}));
                            }
                        }
                        this.qRc = intent.getBooleanExtra("isTakePhoto", false);
                        Intent intent3 = new Intent(this.mActivity, SnsUploadUI.class);
                        intent3.putExtra("KSnsPostManu", true);
                        intent3.putExtra("KTouchCameraTime", bh.Wo());
                        if (this.rLl != null) {
                            this.rLl.b(intent3, "intent_key_StatisticsOplog");
                            this.rLl = null;
                        }
                        if (this.rtl) {
                            intent3.putExtra("Ksnsupload_source", 11);
                        }
                        int intExtra = intent.getIntExtra("CropImage_filterId", 0);
                        intent3.putExtra("sns_kemdia_path_list", stringArrayListExtra2);
                        intent3.putExtra("KFilterId", intExtra);
                        if (this.qRc) {
                            intent3.putExtra("Kis_take_photo", true);
                        }
                        intent3.putStringArrayListExtra("sns_media_latlong_list", arrayList);
                        x.d("MicroMsg.SnsActivity", "shared type %d", Integer.valueOf(intent3.getIntExtra("Ksnsupload_type", -1)));
                        this.mActivity.startActivityForResult(intent3, 6);
                        return;
                    }
                    String stringExtra;
                    if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                        stringExtra = intent.getStringExtra("K_SEGMENTVIDEOPATH");
                    } else {
                        stringExtra = (String) stringArrayListExtra.get(0);
                    }
                    String stringExtra2 = intent.getStringExtra("KSEGMENTVIDEOTHUMBPATH");
                    if (bh.ov(stringExtra2) || !FileOp.bO(stringExtra2)) {
                        stringExtra2 = ae.getAccSnsTmpPath() + com.tencent.mm.a.g.bV(stringExtra);
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        try {
                            mediaMetadataRetriever.setDataSource(stringExtra);
                            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0);
                            if (frameAtTime == null) {
                                x.e("MicroMsg.SnsActivity", "get bitmap error");
                                try {
                                    mediaMetadataRetriever.release();
                                    return;
                                } catch (Exception e) {
                                    return;
                                }
                            }
                            x.i("MicroMsg.SnsActivity", "getBitmap1 %d %d", Integer.valueOf(frameAtTime.getWidth()), Integer.valueOf(frameAtTime.getHeight()));
                            com.tencent.mm.sdk.platformtools.d.a(frameAtTime, 80, CompressFormat.JPEG, stringExtra2, true);
                            Options UL = com.tencent.mm.sdk.platformtools.d.UL(stringExtra2);
                            x.i("MicroMsg.SnsActivity", "getBitmap2 %d %d", Integer.valueOf(UL.outWidth), Integer.valueOf(UL.outHeight));
                            try {
                                mediaMetadataRetriever.release();
                            } catch (Exception e2) {
                            }
                        } catch (Exception e3) {
                            x.e("MicroMsg.SnsActivity", "savebitmap error %s", e3.getMessage());
                        } catch (Throwable th) {
                            try {
                                mediaMetadataRetriever.release();
                            } catch (Exception e4) {
                            }
                        }
                    }
                    x.i("MicroMsg.SnsActivity", "video path %s thumb path %s and %s %s ", stringExtra, stringExtra2, Long.valueOf(FileOp.me(stringExtra)), Long.valueOf(FileOp.me(stringExtra2)));
                    Intent intent4 = new Intent();
                    intent4.putExtra("KSightPath", stringExtra);
                    intent4.putExtra("KSightThumbPath", stringExtra2);
                    intent4.putExtra("sight_md5", com.tencent.mm.a.g.bV(stringExtra));
                    intent4.putExtra("KSnsPostManu", true);
                    intent4.putExtra("KTouchCameraTime", bh.Wo());
                    intent4.putExtra("Ksnsupload_type", 14);
                    intent4.putExtra("Kis_take_photo", false);
                    com.tencent.mm.bm.d.b(this.mActivity, "sns", ".ui.SnsUploadUI", intent4);
                    return;
                case 15:
                    return;
                case 17:
                    SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    if (sightCaptureResult == null) {
                        return;
                    }
                    if (sightCaptureResult.oqz) {
                        this.filePath = sightCaptureResult.oqH;
                        if (!bh.ov(this.filePath)) {
                            this.qRc = true;
                            V(intent);
                            return;
                        }
                        return;
                    }
                    x.i("MicroMsg.SnsActivity", "video path %s thumb path ", sightCaptureResult.oqB, sightCaptureResult.oqC);
                    Intent intent5 = new Intent();
                    intent5.putExtra("KSightPath", sightCaptureResult.oqB);
                    intent5.putExtra("KSightThumbPath", sightCaptureResult.oqC);
                    if (bh.ov(sightCaptureResult.oqE)) {
                        intent5.putExtra("sight_md5", com.tencent.mm.a.g.bV(sightCaptureResult.oqB));
                    } else {
                        intent5.putExtra("sight_md5", sightCaptureResult.oqE);
                    }
                    intent5.putExtra("KSnsPostManu", true);
                    intent5.putExtra("KTouchCameraTime", bh.Wo());
                    intent5.putExtra("Ksnsupload_type", 14);
                    intent5.putExtra("Kis_take_photo", false);
                    try {
                        byte[] toByteArray = sightCaptureResult.oqG.toByteArray();
                        if (toByteArray != null) {
                            intent5.putExtra("KMMSightExtInfo", toByteArray);
                        }
                    } catch (Exception e5) {
                        x.i("MicroMsg.SnsActivity", "put sight extinfo to snsuploadui error: %s", e5.getMessage());
                    }
                    com.tencent.mm.bm.d.b(this.mActivity, "sns", ".ui.SnsUploadUI", intent5);
                    return;
                default:
                    x.e("MicroMsg.SnsActivity", "onActivityResult: not found this requestCode");
                    return;
            }
        } else if (i == 5 || i == 2 || i == 4) {
            new af(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ bb rLm;

                {
                    this.rLm = r1;
                }

                public final void run() {
                    com.tencent.mm.plugin.sns.c.a.ift.uo();
                }
            });
        }
    }

    private void V(Intent intent) {
        new af(Looper.getMainLooper()).post(new 3(this));
        x.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_CHOSE_IMAGE_CONFIRM");
        x.d("MicroMsg.SnsActivity", "CONTEXT_CHOSE_IMAGE_CONFIRM filePath " + this.filePath);
        if (this.filePath != null) {
            int intExtra;
            String str = "pre_temp_sns_pic" + com.tencent.mm.a.g.s((this.filePath + System.currentTimeMillis()).getBytes());
            com.tencent.mm.plugin.sns.storage.r.X(ae.getAccSnsTmpPath(), this.filePath, str);
            this.filePath = ae.getAccSnsTmpPath() + str;
            x.d("MicroMsg.SnsActivity", "newPath " + this.filePath);
            if (intent != null) {
                intExtra = intent.getIntExtra("CropImage_filterId", 0);
            } else {
                intExtra = 0;
            }
            Intent intent2 = new Intent(this.mActivity, SnsUploadUI.class);
            intent2.putExtra("KSnsPostManu", true);
            intent2.putExtra("KTouchCameraTime", bh.Wo());
            if (this.rLl != null) {
                this.rLl.b(intent2, "intent_key_StatisticsOplog");
                this.rLl = null;
            }
            intent2.putExtra("sns_kemdia_path", this.filePath);
            intent2.putExtra("KFilterId", intExtra);
            if (this.qRc) {
                intent2.putExtra("Kis_take_photo", true);
            }
            if (this.rtl) {
                intent2.putExtra("Ksnsupload_source", 11);
            }
            this.mActivity.startActivityForResult(intent2, 6);
            this.qRc = false;
        }
    }

    protected final boolean xQ(int i) {
        int i2 = 3;
        com.tencent.mm.kernel.g.Dk();
        if (com.tencent.mm.kernel.g.Dj().isSDCardAvailable()) {
            x.d("MicroMsg.SnsActivity", "selectPhoto " + i);
            if (i == 2) {
                Intent intent = new Intent();
                intent.putExtra("username", this.rIa);
                intent.setClass(this.mActivity, SettingSnsBackgroundUI.class);
                this.mActivity.startActivityForResult(intent, 7);
                return true;
            } else if (i != 1) {
                return true;
            } else {
                com.tencent.mm.kernel.g.Dk();
                int a = bh.a((Integer) com.tencent.mm.kernel.g.Dj().CU().get(68385, null), 0);
                com.tencent.mm.kernel.g.Dk();
                int a2 = bh.a((Integer) com.tencent.mm.kernel.g.Dj().CU().get(68386, null), 0);
                if (!this.rLg && a < 3 && a2 == 0) {
                    this.rLg = true;
                    Context context = this.mActivity;
                    OnClickListener 4 = new 4(this, i);
                    com.tencent.mm.ui.base.i.a aVar = new com.tencent.mm.ui.base.i.a(context);
                    aVar.Ez(j.qMK);
                    aVar.YG(context.getString(j.qML) + "\n\n" + context.getString(j.qMM));
                    aVar.EC(j.qMQ).a(4);
                    aVar.a(new 1());
                    aVar.akx().show();
                    return true;
                } else if (this.mActivity.getSharedPreferences(ac.cfs(), 0).getString("gallery", "1").equalsIgnoreCase("0")) {
                    k.a(this.mActivity, 2, null);
                    return true;
                } else {
                    a2 = com.tencent.mm.k.g.zY().getInt("SnsCanPickVideoFromAlbum", 1);
                    x.i("MicroMsg.SnsActivity", "takeVideo %d", Integer.valueOf(a2));
                    if (com.tencent.mm.platformtools.r.ien) {
                        a2 = 0;
                    }
                    if (a2 != 1 && a2 == 0) {
                        i2 = 1;
                    }
                    k.a(this.mActivity, 14, 9, 4, i2, false, null);
                    return true;
                }
            }
        }
        u.fI(this.mActivity);
        return false;
    }

    public final void onDestroy() {
        if (this.raX != null) {
            SnsHeader snsHeader = this.raX;
            if (!(snsHeader.rBK == null || snsHeader.rBK.isRecycled())) {
                snsHeader.rBK.recycle();
            }
        }
        com.tencent.mm.kernel.g.Dk();
        if (com.tencent.mm.kernel.g.Dh().Cy()) {
            ae.bvs().K(this.mActivity);
            ae.bvq().b(this);
        }
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        com.tencent.mm.kernel.g.Dk();
        if (com.tencent.mm.kernel.g.Dh().Cy()) {
            ae.bvr().gCl.remove(this);
            av.qSu--;
        }
        this.rLe.setVisibility(8);
        ab.bzE();
        com.tencent.mm.kernel.g.Dk();
        if (com.tencent.mm.kernel.g.Dh().Cy()) {
            ae.bvs().start();
        }
        this.nKG.setAdapter(null);
    }

    public final void JT(String str) {
    }

    public final void aF(String str, boolean z) {
    }

    public final void bun() {
        this.raX.bAT();
    }

    protected final void iE(boolean z) {
        x.d("MicroMsg.SnsActivity", "snsactivty onIsAll ");
        this.rLe.iE(z);
    }

    protected final void xv(int i) {
        x.d("MicroMsg.SnsActivity", "snsactivty onIsRecent ");
        this.rLe.xv(i);
    }

    public final void L(int i, boolean z) {
        this.rLj.L(i, z);
    }

    public final void bwe() {
        if (this.raX != null) {
            this.raX.bAT();
        }
    }

    public final void aE(String str, boolean z) {
        if (this.rLj.getType() == 1 && this.nKG != null && this.nKG.getAdapter() != null && (this.nKG.getAdapter() instanceof ax)) {
            ((ax) this.nKG.getAdapter()).notifyDataSetChanged();
        }
    }

    public final ListView bBK() {
        return this.rLj.bBK();
    }
}
