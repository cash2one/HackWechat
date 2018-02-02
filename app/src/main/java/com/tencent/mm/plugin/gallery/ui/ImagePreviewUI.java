package com.tencent.mm.plugin.gallery.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.v;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiDestroyInstanceAudio;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.m;
import com.tencent.mm.plugin.gallery.stub.GalleryStubService;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

@a(19)
@TargetApi(16)
public class ImagePreviewUI extends MMActivity {
    private ServiceConnection lrm = new 1(this);
    private com.tencent.mm.plugin.gallery.stub.a mRJ = null;
    private ArrayList<MediaItem> mRK;
    private boolean mSB;
    private int mSE;
    private long mSJ = 0;
    private HashMap<String, Integer> mSP = new HashMap();
    private TextView mSr;
    private boolean mSx = true;
    private c mTM;
    private MMViewPager mTN;
    private RecyclerView mTO;
    private ArrayList<String> mTP;
    private ArrayList<String> mTQ;
    private Integer mTR;
    private ImageButton mTS;
    private TextView mTT;
    private ak mTU;
    private ImageButton mTV;
    private TextView mTW;
    private ViewGroup mTX;
    private ViewGroup mTY;
    private boolean mTZ = true;
    private boolean mTi;
    private boolean mUa = true;
    private int mUb = 0;
    private TextView mUc;
    private TextView mUd;
    private TextView mUe;
    private TextView mUf;
    private View mUg;
    private TextView mUh;
    private ProgressBar mUi;
    boolean mUj = false;
    private HashSet<String> mUk;

    static /* synthetic */ void a(ImagePreviewUI imagePreviewUI, int i) {
        MediaItem qy = imagePreviewUI.mTM.qy(i);
        if (qy != null) {
            imagePreviewUI.c(qy);
        }
    }

    static /* synthetic */ void a(ImagePreviewUI imagePreviewUI, final int i, String str) {
        if (str != null) {
            f fVar = (f) imagePreviewUI.mTO.fm();
            if (imagePreviewUI.mTi) {
                int indexOf = imagePreviewUI.mTQ.contains(str) ? imagePreviewUI.mTQ.indexOf(str) : -1;
                x.i("MicroMsg.ImagePreviewUI", "[notifyRecycleViewWhenPageSelected] :%s indexInBar:%s %s", new Object[]{Integer.valueOf(i), Integer.valueOf(indexOf), Boolean.valueOf(imagePreviewUI.mTi)});
                fVar.cE(indexOf, i);
                fVar.UR.notifyChanged();
                if (indexOf != -1) {
                    imagePreviewUI.mTO.postDelayed(new 20(imagePreviewUI, indexOf), 66);
                    return;
                }
                return;
            }
            x.i("MicroMsg.ImagePreviewUI", "[notifyRecycleViewWhenPageSelected] :%s %s", new Object[]{Integer.valueOf(i), imagePreviewUI.mTR});
            fVar.cE(i, i);
            fVar.b(imagePreviewUI.mTR.intValue(), new Object());
            fVar.b(i, new Object());
            imagePreviewUI.mTO.postDelayed(new Runnable(imagePreviewUI) {
                final /* synthetic */ ImagePreviewUI mUl;

                public final void run() {
                    this.mUl.mTO.smoothScrollToPosition(i);
                }
            }, 66);
        }
    }

    static /* synthetic */ void a(ImagePreviewUI imagePreviewUI, Intent intent, boolean z, boolean z2) {
        intent.putExtra("CropImage_Compress_Img", z ? true : z2);
        ArrayList aOx = imagePreviewUI.aOx();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (aOx == null || aOx.size() <= 0) {
            x.i("MicroMsg.ImagePreviewUI", "no img selected. keep current ui.");
            return;
        }
        Iterator it = aOx.iterator();
        while (it.hasNext()) {
            Object obj = (String) it.next();
            MediaItem Bt = c.Bt(obj);
            if (Bt == null || Bt.getType() != 2) {
                if (!(Bt == null || Bt.getType() == 2 || !Bt.mMimeType.equals("edit") || bh.ov(Bt.mRe))) {
                    obj = Bt.mRe;
                }
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        if (z && arrayList.size() == 0 && arrayList2.size() == 1) {
            MediaItem Bt2 = c.Bt((String) arrayList2.get(0));
            if (Bt2 == null || !(Bt2 instanceof VideoMediaItem) || ((VideoMediaItem) Bt2).hOr == -1) {
                x.e("MicroMsg.ImagePreviewUI", "dealWithSend VideoMediaItem not found.");
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("K_SEGMENTVIDEOPATH", Bt2.hOo);
                intent2.putExtra("KSEGMENTVIDEOTHUMBPATH", Bt2.mld);
                d.b(imagePreviewUI, "mmsight", ".segment.VideoCompressUI", intent2, 4371);
                return;
            }
        }
        intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList);
        intent.putStringArrayListExtra("key_select_video_list", arrayList2);
        boolean booleanExtra = imagePreviewUI.getIntent().getBooleanExtra("isTakePhoto", false);
        if (booleanExtra && imagePreviewUI.aOx().size() > 0) {
            Parcelable UK = ExifHelper.UK((String) imagePreviewUI.aOx().get(0));
            Intent intent3 = new Intent(imagePreviewUI, ImagePreviewUI.class);
            x.d("MicroMsg.ImagePreviewUI", "findlatlng %s", new Object[]{r0});
            if (UK != null) {
                x.d("MicroMsg.ImagePreviewUI", "findlatlng %f %f", new Object[]{Float.valueOf(UK.fzt), Float.valueOf(UK.hBL)});
                intent3.putExtra("KlatLng", UK);
            }
        }
        x.d("MicroMsg.ImagePreviewUI", "summersafecdn send image, previewImageCount:%d, chooseForTimeline:%b, forTimeline:%b, beCompress:%b", new Object[]{Integer.valueOf(c.aNL()), Boolean.valueOf(imagePreviewUI.mSx), Boolean.valueOf(z), Boolean.valueOf(z2)});
        try {
            imagePreviewUI.mRJ.aj(11610, (imagePreviewUI.mSx ? 3 : 2) + "," + c.aNL());
        } catch (Throwable e) {
            x.e("MicroMsg.ImagePreviewUI", "report error, %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.ImagePreviewUI", e, "", new Object[0]);
        }
        c.aNK();
        x.d("MicroMsg.ImagePreviewUI", "isTaskPhoto ? " + booleanExtra + " | isPreviewPhoto ? " + intent.getBooleanExtra("isPreviewPhoto", false));
        intent.putExtra("isTakePhoto", booleanExtra);
        String stringExtra = imagePreviewUI.getIntent().getStringExtra("GalleryUI_ToUser");
        if (bh.ov(imagePreviewUI.getIntent().getStringExtra("GalleryUI_FromUser")) || "medianote".equals(stringExtra)) {
            imagePreviewUI.setResult(-1, intent);
            imagePreviewUI.finish();
        } else if (bh.Wq() - imagePreviewUI.mSJ < 1000) {
            x.w("MicroMsg.ImagePreviewUI", "sendimg btn event frequence limit");
        } else {
            imagePreviewUI.mSJ = bh.Wq();
            x.i("MicroMsg.ImagePreviewUI", "switch to SendImgProxyUI");
            intent.setClassName(imagePreviewUI, "com.tencent.mm.ui.chatting.SendImgProxyUI");
            intent.putExtra("GalleryUI_FromUser", imagePreviewUI.getIntent().getStringExtra("GalleryUI_FromUser"));
            intent.putExtra("GalleryUI_ToUser", imagePreviewUI.getIntent().getStringExtra("GalleryUI_ToUser"));
            intent.putExtra("CropImage_limit_Img_Size", 26214400);
            imagePreviewUI.startActivityForResult(intent, 4369);
        }
    }

    static /* synthetic */ void a(ImagePreviewUI imagePreviewUI, boolean z) {
        if (z) {
            imagePreviewUI.fullScreenNoTitleBar(false);
            imagePreviewUI.fs(z);
            imagePreviewUI.ft(true);
            return;
        }
        imagePreviewUI.fullScreenNoTitleBar(true);
        imagePreviewUI.fs(z);
        imagePreviewUI.ft(false);
    }

    static /* synthetic */ void n(ImagePreviewUI imagePreviewUI) {
        String str;
        String stringExtra = imagePreviewUI.getIntent().getStringExtra("GalleryUI_FromUser");
        String stringExtra2 = imagePreviewUI.getIntent().getStringExtra("GalleryUI_ToUser");
        Intent intent = new Intent();
        x.i("MicroMsg.ImagePreviewUI", "edit image path:%s mPosition:%s", new Object[]{imagePreviewUI.mTM.kC(imagePreviewUI.mTR.intValue()), imagePreviewUI.mTR});
        intent.putExtra("GalleryUI_FromUser", stringExtra);
        intent.putExtra("GalleryUI_ToUser", stringExtra2);
        intent.putExtra("GalleryUI_ToUser", stringExtra2);
        intent.putExtra("from_scene", c.aNE().aOh());
        intent.putExtra("preview_image_list", ((f) imagePreviewUI.mTO.fm()).mUw);
        if (c.aNE().aOh() == 4) {
            intent.putExtra("from_scene", 289);
        } else if (c.aNE().aOh() == 3) {
            intent.putExtra("from_scene", JsApiDestroyInstanceAudio.CTRL_INDEX);
        }
        intent.putExtra("preview_select_image_list", imagePreviewUI.mTQ);
        MediaItem qy = imagePreviewUI.mTM.qy(imagePreviewUI.mTR.intValue());
        if (qy != null) {
            x.i("MicroMsg.ImagePreviewUI", "[gotoPhotoEditUI] raw:%s orignal:%s", new Object[]{qy.mRd, qy.hOo});
            str = qy.mRd;
            if (bh.ov(str)) {
                str = qy.hOo;
                intent.putExtra("after_photo_edit", "");
            } else {
                intent.putExtra("after_photo_edit", qy.hOo);
            }
        } else {
            x.i("MicroMsg.ImagePreviewUI", "[gotoPhotoEditUI] item == null mPosition:%s", new Object[]{imagePreviewUI.mTR});
            str = imagePreviewUI.mTM.kC(imagePreviewUI.mTR.intValue());
            qy = MediaItem.a(1, (long) imagePreviewUI.mTR.intValue(), str, str, "edit");
            ArrayList arrayList = new ArrayList();
            arrayList.add(qy);
            c.w(arrayList);
        }
        intent.putExtra("before_photo_edit", str);
        d.b(imagePreviewUI, "photoedit", ".ui.MMNewPhotoEditUI", intent, 4372);
    }

    static /* synthetic */ void v(ImagePreviewUI imagePreviewUI) {
        if (imagePreviewUI.mTU == null || imagePreviewUI.mTU.cfK()) {
            imagePreviewUI.mTU = new ak(new 15(imagePreviewUI), false);
            imagePreviewUI.mTU.J(350, 350);
            return;
        }
        imagePreviewUI.mTU.TG();
    }

    @TargetApi(16)
    public void onCreate(Bundle bundle) {
        long Wq = bh.Wq();
        super.onCreate(bundle);
        fullScreenNoTitleBar(true);
        new af().post(new 12(this, Wq));
        bindService(new Intent(this.mController.xIM, GalleryStubService.class), this.lrm, 1);
        initView();
        x.v("MicroMsg.ImagePreviewUI", "test oncreate: %d", new Object[]{Long.valueOf(bh.bA(Wq))});
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        if (this.mTU != null) {
            this.mTU.TG();
        }
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.dlG;
    }

    protected final void dealContentView(View view) {
        if (b.aK(this)) {
            setContentView(view);
            return;
        }
        ae.c(ae.a(getWindow(), null), this.mController.xIy);
        ((ViewGroup) this.mController.xIy.getParent()).removeView(this.mController.xIy);
        ((ViewGroup) getWindow().getDecorView()).addView(this.mController.xIy, 0);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void initView() {
        this.mUd = (TextView) findViewById(R.h.ckx);
        this.mUe = (TextView) findViewById(R.h.ckz);
        this.mUf = (TextView) findViewById(R.h.crB);
        this.mUg = findViewById(R.h.crC);
        this.mUg.postDelayed(new 21(this), 100);
        this.mUh = (TextView) findViewById(R.h.cky);
        this.mUi = (ProgressBar) findViewById(R.h.cUU);
        this.mSE = getIntent().getIntExtra("max_select_count", 9);
        this.mSx = c.aNE().aOh() == 4;
        Intent intent = getIntent();
        this.mTP = intent.getStringArrayListExtra("preview_image_list");
        this.mTQ = new ArrayList();
        if (this.mTP != null) {
            this.mTQ.addAll(this.mTP);
        }
        this.mRK = c.aNG();
        boolean booleanExtra = intent.getBooleanExtra("preview_all", false);
        String str = "MicroMsg.ImagePreviewUI";
        String str2 = "preview all[%B] mediaitems is null[%B]";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(booleanExtra);
        objArr[1] = Boolean.valueOf(this.mRK == null);
        x.i(str, str2, objArr);
        if (booleanExtra && this.mRK != null) {
            this.mTi = true;
            this.mTR = Integer.valueOf(intent.getIntExtra("preview_position", 0));
            x.i("MicroMsg.ImagePreviewUI", "start position=%d", new Object[]{this.mTR});
        }
        this.mTR = Integer.valueOf(0);
        c.qi(this.mTR.intValue());
        if (this.mTi || !(this.mTQ == null || this.mTQ.size() == 0)) {
            final String str3;
            String str4;
            this.mTS = (ImageButton) findViewById(R.h.cBP);
            this.mSr = (TextView) findViewById(R.h.cBQ);
            this.mTT = (TextView) findViewById(R.h.cUT);
            this.mSB = intent.getBooleanExtra("send_raw_img", false);
            this.mUb = intent.getIntExtra("query_source_type", 0);
            if (this.mSB) {
                this.mTS.setImageResource(R.k.dAr);
            } else {
                this.mTS.setImageResource(R.k.dAq);
            }
            if (this.mTQ != null && this.mTQ.size() == 1) {
                str3 = (String) this.mTQ.get(0);
                if (str3.endsWith(".jpg")) {
                    ag.y(new Runnable(this) {
                        final /* synthetic */ ImagePreviewUI mUl;

                        public final void run() {
                            boolean z = true;
                            try {
                                com.tencent.mm.plugin.gallery.stub.a s = this.mUl.mRJ;
                                String str = str3;
                                String stringExtra = this.mUl.getIntent().getStringExtra("GalleryUI_ToUser");
                                if (!this.mUl.mSx && this.mUl.mSB) {
                                    z = false;
                                }
                                s.a(str, stringExtra, z, 0, true);
                            } catch (Exception e) {
                            }
                        }
                    });
                }
            }
            this.mSr.setText(this.mController.xIM.getString(R.l.elh));
            this.mTS.setOnClickListener(new 22(this));
            this.mTT.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ImagePreviewUI mUl;

                {
                    this.mUl = r1;
                }

                public final void onClick(View view) {
                    String kC = this.mUl.mTM.kC(this.mUl.mTR.intValue());
                    if (bh.ov(kC)) {
                        x.w("MicroMsg.ImagePreviewUI", "get path error, position %d", new Object[]{this.mUl.mTR});
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("key_video_path", kC);
                    intent.putExtra("key_need_clip_video_first", false);
                    d.b(this.mUl.mController.xIM, "mmsight", ".segment.MMSightEditUI", intent, 4370);
                }
            });
            this.mUh.setOnClickListener(new 24(this));
            this.mSr.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ImagePreviewUI mUl;

                {
                    this.mUl = r1;
                }

                public final void onClick(View view) {
                    this.mUl.mTS.performClick();
                }
            });
            setBackBtn(new 26(this));
            a(0, aOw(), new OnMenuItemClickListener(this) {
                final /* synthetic */ ImagePreviewUI mUl;

                {
                    this.mUl = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    int i;
                    boolean z;
                    int i2 = 0;
                    if (this.mUl.mUb == 6) {
                        this.mUl.setResult(1);
                        this.mUl.finish();
                    }
                    Intent intent = new Intent();
                    intent.putExtra("isPreviewPhoto", this.mUl.getIntent().getBooleanExtra("isPreviewPhoto", false));
                    ArrayList k = this.mUl.aOx();
                    if (k == null || k.size() != 0) {
                        i = 0;
                    } else {
                        MediaItem qy = this.mUl.mTM.qy(this.mUl.mTR.intValue());
                        if (!this.mUl.mSx || this.mUl.mTM == null || qy == null || qy.getType() != 2) {
                            this.mUl.mTV.performClick();
                            i = 300;
                        } else {
                            this.mUl.Bx(qy.hOo);
                            i = 0;
                        }
                    }
                    if (this.mUl.mSB) {
                        z = false;
                    } else {
                        z = true;
                    }
                    boolean l = this.mUl.mSx;
                    if (i == 0) {
                        ImagePreviewUI.a(this.mUl, intent, l, z);
                    } else {
                        e aNF = c.aNF();
                        Runnable 1 = new 1(this, intent, l, z);
                        if (i >= 0) {
                            i2 = i;
                        }
                        aNF.aNT().postDelayed(1, (long) i2);
                    }
                    return true;
                }
            }, p.b.xJz);
            this.mTV = (ImageButton) findViewById(R.h.cCx);
            this.mTV.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ImagePreviewUI mUl;

                {
                    this.mUl = r1;
                }

                public final void onClick(View view) {
                    String kC = this.mUl.mTM.kC(this.mUl.mTR.intValue());
                    if (bh.ov(kC)) {
                        x.w("MicroMsg.ImagePreviewUI", "get path error, position %d", new Object[]{this.mUl.mTR});
                        return;
                    }
                    this.mUl.Bx(kC);
                    ImagePreviewUI.a(this.mUl, this.mUl.mTR.intValue());
                    this.mUl.mSr.setText(this.mUl.mController.xIM.getString(R.l.elh) + "");
                    this.mUl.updateOptionMenuText(0, this.mUl.aOw());
                }
            });
            this.mTW = (TextView) findViewById(R.h.cCy);
            this.mTW.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ImagePreviewUI mUl;

                {
                    this.mUl = r1;
                }

                public final void onClick(View view) {
                    this.mUl.mTV.performClick();
                }
            });
            if (this.mSE == 1) {
                this.mTV.setVisibility(8);
                this.mTW.setVisibility(8);
            }
            this.mTX = (ViewGroup) findViewById(R.h.bZZ);
            this.mTY = (ViewGroup) findViewById(R.h.ckw);
            if (this.mTX != null) {
                this.mTX.setVisibility(8);
                this.mTX.setOnClickListener(new 4(this));
            }
            if (this.mTY != null) {
                this.mTY.setVisibility(8);
                this.mTY.setOnClickListener(new 5(this));
            }
            this.mUc = (TextView) findViewById(R.h.cCw);
            this.mUc.setOnClickListener(new 6(this));
            this.mTO = (RecyclerView) findViewById(R.h.cpv);
            this.mTO.Ur.UX = 66;
            this.mTO.a(new 7(this));
            h gVar = new g(this);
            gVar.setOrientation(0);
            this.mTO.a(gVar);
            RecyclerView.a fVar = new f(this, this.mTQ, getResources().getDisplayMetrics().widthPixels / 7, this.mTi);
            this.mTO.a(fVar);
            this.mTO.post(new 8(this));
            if (this.mTQ.size() > 0) {
                this.mTO.setVisibility(0);
            } else {
                this.mTO.setVisibility(8);
            }
            this.mTO.a(new v());
            fVar.mUE.A(this.mTO);
            fVar.mUx = new 9(this);
            this.mTN = (MMViewPager) findViewById(R.h.ckt);
            this.mTN.setVerticalFadingEdgeEnabled(false);
            this.mTN.setHorizontalFadingEdgeEnabled(false);
            this.mTN.yeB = new 13(this);
            this.mTN.yez = new 14(this);
            this.mTM = new c(this);
            ((f) this.mTO.fm()).mUu = this.mTM;
            str3 = "";
            if (this.mTi) {
                c cVar = this.mTM;
                Collection collection = this.mRK;
                cVar.mRK.clear();
                cVar.mRK.addAll(collection);
                cVar.reset();
                cVar.notifyDataSetChanged();
                this.mTM.mTi = true;
                if (this.mTR.intValue() >= this.mRK.size()) {
                    this.mTR = Integer.valueOf(0);
                }
                if (this.mRK.size() > 0) {
                    str4 = ((MediaItem) this.mRK.get(this.mTR.intValue())).hOo;
                }
                str4 = str3;
            } else {
                this.mTM.B(this.mTP);
                this.mTM.mTi = false;
                if (this.mTP.size() > 0) {
                    str4 = (String) this.mTP.get(this.mTR.intValue());
                }
                str4 = str3;
            }
            this.mTN.a(this.mTM);
            this.mTN.ah(this.mTR.intValue());
            ((f) this.mTO.fm()).cE(aOx().indexOf(this.mTM.kC(this.mTR.intValue())), this.mTR.intValue());
            MediaItem Bt = c.Bt(str4);
            a(str4, Bt);
            c(Bt);
            setMMTitle(String.format("%d/%d", new Object[]{Integer.valueOf(this.mTR.intValue() + 1), Integer.valueOf(this.mTM.getCount())}));
            return;
        }
        x.e("MicroMsg.ImagePreviewUI", "not preview all items and imagepaths is null or empty");
        finish();
    }

    private void Bx(String str) {
        if (this.mTQ.contains(str)) {
            this.mTV.setImageResource(R.k.dxP);
            do {
            } while (this.mTQ.remove(str));
            a(this.mTQ.size(), this.mTR.intValue(), str, 1);
        } else if (this.mTQ.size() >= this.mSE) {
            com.tencent.mm.ui.base.h.bu(this.mController.xIM, getResources().getQuantityString(R.j.duw, this.mSE, new Object[]{Integer.valueOf(this.mSE)}));
            this.mTV.setImageResource(R.k.dxP);
        } else {
            this.mTQ.add(str);
            this.mTV.setImageResource(R.k.dxO);
            a(this.mTQ.size(), this.mTR.intValue(), str, 0);
        }
    }

    protected void onActivityResult(int i, int i2, final Intent intent) {
        x.i("MicroMsg.ImagePreviewUI", "test onActivityResult");
        if (i == 4371) {
            if (i2 == -1) {
                setResult(-1, intent);
                finish();
            } else if (this.mTQ.size() > 0) {
                Bx((String) this.mTQ.get(0));
            } else {
                x.e("MicroMsg.ImagePreviewUI", "selectedPath has unexpected size() [%d]", new Object[]{Integer.valueOf(this.mTQ.size())});
            }
        } else if (i == 4370) {
            if (i2 == -1) {
                setResult(-1, intent);
            }
            if (intent != null) {
                setResult(-1, intent.putExtra("GalleryUI_IsSendImgBackground", true));
                finish();
            }
        }
        if (i == 4372) {
            if (i2 == -1 && intent != null) {
                this.mUj = true;
                String stringExtra = intent.getStringExtra("before_photo_edit");
                Iterator it = c.aNI().iterator();
                while (it.hasNext()) {
                    if (stringExtra.equals(((Bundle) it.next()).getString("before_photo_edit"))) {
                        it.remove();
                    }
                }
                c.aNI().add(intent.getBundleExtra("report_info"));
                String stringExtra2 = intent.getStringExtra("after_photo_edit");
                String stringExtra3 = intent.getStringExtra("tmp_photo_edit");
                x.i("MicroMsg.ImagePreviewUI", "rawEditPhotoPath:%s lastEditPhotoPath;%s", new Object[]{stringExtra, stringExtra2});
                if (this.mTP != null) {
                    this.mTP.clear();
                    Collection stringArrayListExtra = intent.getStringArrayListExtra("preview_image_list");
                    if (stringArrayListExtra != null) {
                        this.mTP.addAll(stringArrayListExtra);
                    }
                    MediaItem qy = this.mTM.qy(this.mTR.intValue());
                    if (qy == null) {
                        x.e("MicroMsg.ImagePreviewUI", "item is null!!! mPosition:%s rawEditPhotoPath:%s lastEditPhotoPath:%s", new Object[]{this.mTR, stringExtra, stringExtra2});
                        return;
                    }
                    qy.mRd = stringExtra;
                    qy.hOo = stringExtra2;
                    qy.mld = stringExtra2;
                    qy.mRe = stringExtra3;
                    qy.mMimeType = "edit";
                    c.aNH().add(qy);
                    c.aND().a(new com.tencent.mm.plugin.gallery.model.b.b(this) {
                        final /* synthetic */ ImagePreviewUI mUl;

                        public final void Bs(String str) {
                            new af(this.mUl.getMainLooper()).post(new 1(this));
                            com.tencent.mm.plugin.gallery.model.b bVar = c.aND().mQp;
                            if (bVar.hla != null && bVar.hla.contains(this)) {
                                bVar.hla.remove(this);
                            }
                        }
                    });
                    c.aND().b(stringExtra2, qy.getType(), stringExtra2, qy.mRf);
                    x.i("MicroMsg.ImagePreviewUI", "photo_edit_back!");
                }
            }
        } else if (intent != null) {
            setResult(-1, intent.putExtra("GalleryUI_IsSendImgBackground", true));
            finish();
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    private String aOw() {
        switch (c.aNE().aOh()) {
            case 4:
            case 7:
            case 8:
            case 13:
                if (this.mTQ.size() == 0 || this.mSE <= 1) {
                    return getString(R.l.elj);
                }
                return getString(R.l.elj) + "(" + this.mTQ.size() + "/" + this.mSE + ")";
            case 11:
                return getString(R.l.ebg);
            default:
                if (this.mTQ.size() == 0 || this.mSE <= 1) {
                    return getString(R.l.dGA);
                }
                return getString(R.l.eld, new Object[]{Integer.valueOf(this.mTQ.size()), Integer.valueOf(this.mSE)});
        }
    }

    private ArrayList<String> aOx() {
        if (this.mTi) {
            return this.mTQ;
        }
        ArrayList<String> arrayList = new ArrayList(this.mTQ.size());
        Iterator it = this.mTP.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (this.mTQ.contains(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private void fs(boolean z) {
        if (c.aNE().aOh() != 4) {
            if (this.mTM == null) {
                x.i("MicroMsg.ImagePreviewUI", "[setTopTipVisibility] adapter == null");
                return;
            }
            MediaItem qy = this.mTM.qy(this.mTR.intValue());
            if (!z || qy == null) {
                this.mUg.setVisibility(8);
            } else {
                this.mUg.postDelayed(new 16(this, qy), 400);
            }
        }
    }

    private void ft(boolean z) {
        View findViewById;
        x.d("MicroMsg.ImagePreviewUI", "setFooterVisibility() called with: visible = [" + z + "], selectedNormalFooter = " + this.mTZ);
        if (this.mTZ) {
            findViewById = findViewById(R.h.bZZ);
        } else {
            findViewById = findViewById(R.h.ckw);
        }
        if (findViewById == null) {
            String str;
            String str2 = "MicroMsg.ImagePreviewUI";
            String str3 = "set footer[%s] visibility[%B], but footerbar null";
            Object[] objArr = new Object[2];
            if (this.mTZ) {
                str = "normal";
            } else {
                str = "edit_tips";
            }
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(z);
            x.w(str2, str3, objArr);
        } else if (!z || findViewById.getVisibility() != 0) {
            if (z || findViewById.getVisibility() != 8) {
                if (z) {
                    findViewById.setVisibility(0);
                    findViewById.startAnimation(AnimationUtils.loadAnimation(this, R.a.bpZ));
                } else {
                    findViewById.setVisibility(8);
                    findViewById.startAnimation(AnimationUtils.loadAnimation(this, R.a.bqa));
                }
                if (z && this.mTO.getVisibility() == 8 && this.mTQ.size() > 0) {
                    this.mTO.setVisibility(0);
                    this.mTO.startAnimation(AnimationUtils.loadAnimation(this, R.a.bpZ));
                } else if (!z && this.mTO.getVisibility() == 0) {
                    this.mTO.setVisibility(8);
                    this.mTO.startAnimation(AnimationUtils.loadAnimation(this, R.a.bqa));
                }
            }
        }
    }

    private void goBack() {
        boolean z = true;
        Intent intent = new Intent();
        boolean z2 = !this.mSB;
        String str = "CropImage_Compress_Img";
        if (!this.mSx) {
            z = z2;
        }
        intent.putExtra(str, z);
        intent.putStringArrayListExtra("preview_image_list", aOx());
        intent.putExtra("show_photo_edit_tip", this.mUj);
        setResult(0, intent);
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (c.aNE().aOh() == 3 && getIntent().getBooleanExtra("preview_image", false) && getIntent().getIntExtra("max_select_count", 0) == 1) {
            x.i("MicroMsg.ImagePreviewUI", "clear photo edit cache!");
            sendBroadcast(new Intent("com.tencent.mm.plugin.photoedit.action.clear"));
        }
        if (this.mTM != null) {
            this.mTM.release();
        }
        c.w(null);
        unbindService(this.lrm);
    }

    private void a(String str, MediaItem mediaItem) {
        if (mediaItem != null && mediaItem.getType() == 2 && (c.aNE().aOh() == 4 || c.aNE().aOh() == 13)) {
            boolean z;
            if (mediaItem == null || mediaItem.getType() != 1 || mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
                this.mUc.setVisibility(8);
            } else {
                this.mUc.setVisibility(0);
            }
            VideoMediaItem videoMediaItem = (VideoMediaItem) mediaItem;
            enableOptionMenu(false);
            this.mTZ = false;
            this.mTX.setVisibility(8);
            this.mTY.setVisibility(0);
            this.mUh.setVisibility(8);
            if (FileOp.me(str) > 1073741824) {
                this.mUd.setText(getString(R.l.elp));
                this.mUe.setText(getString(R.l.elo));
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (bh.ov(videoMediaItem.hOp)) {
                    enableOptionMenu(false);
                    this.mTZ = true;
                    this.mTX.setVisibility(0);
                    this.mTY.setVisibility(8);
                    this.mTT.setVisibility(8);
                    b(str, mediaItem);
                    By(str);
                    Runnable mVar = new m(str, this.mTR.intValue(), videoMediaItem, new 17(this));
                    if (com.tencent.mm.sdk.f.e.V(mVar)) {
                        x.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", new Object[]{str});
                        return;
                    }
                    com.tencent.mm.sdk.f.e.post(mVar, "video_analysis");
                    return;
                }
                x.d("MicroMsg.ImagePreviewUI", "got MediaItem directly path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", new Object[]{videoMediaItem.hOo, Integer.valueOf(videoMediaItem.hOr), Integer.valueOf(videoMediaItem.videoHeight), Integer.valueOf(videoMediaItem.videoWidth)});
                a(str, videoMediaItem);
                return;
            }
            return;
        }
        this.mTZ = true;
        this.mTX.setVisibility(0);
        this.mTY.setVisibility(8);
        this.mUi.setVisibility(8);
        b(str, mediaItem);
        By(str);
        enableOptionMenu(true);
        this.mTT.setVisibility(8);
        if (mediaItem == null || mediaItem.getType() != 1 || mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
            boolean booleanExtra = getIntent().getBooleanExtra("preview_image", false);
            x.i("MicroMsg.ImagePreviewUI", "QuerySource:%s isPreViewImage:%s  path:%s", new Object[]{Integer.valueOf(c.aNE().aOh()), Boolean.valueOf(booleanExtra), str});
            if (mediaItem != null || bh.ov(str)) {
                this.mUc.setVisibility(8);
                return;
            } else {
                this.mUc.setVisibility(0);
                return;
            }
        }
        this.mUc.setVisibility(0);
    }

    private void a(String str, VideoMediaItem videoMediaItem) {
        enableOptionMenu(false);
        this.mTZ = false;
        this.mTX.setVisibility(8);
        this.mTY.setVisibility(0);
        this.mUh.setVisibility(8);
        if (c.aNE().aOh() == 13) {
            this.mTY.setVisibility(8);
            this.mTX.setVisibility(8);
            this.mUd.setVisibility(8);
            this.mUe.setVisibility(8);
            enableOptionMenu(true);
            return;
        }
        boolean z;
        if (videoMediaItem == null || videoMediaItem.videoWidth <= 0 || videoMediaItem.videoHeight <= 0 || ((float) videoMediaItem.videoWidth) / ((float) videoMediaItem.videoHeight) > 3.0f || ((float) videoMediaItem.videoWidth) / ((float) videoMediaItem.videoHeight) < 0.5f) {
            if (videoMediaItem != null) {
                x.d("MicroMsg.ImagePreviewUI", "check ratio faild width = [%d], height = [%d]", new Object[]{Integer.valueOf(videoMediaItem.videoWidth), Integer.valueOf(videoMediaItem.videoHeight)});
            }
            this.mUd.setText(getString(R.l.elm));
            this.mUe.setText(getString(R.l.eln));
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            x.d("MicroMsg.ImagePreviewUI", "updateBottomLayoutCheckFormat() called with: item = [%s]", new Object[]{videoMediaItem});
            if (!(videoMediaItem == null || bh.ov(videoMediaItem.hOo))) {
                String str2 = videoMediaItem.hOo;
                if (bh.ov(str2)) {
                    z = true;
                } else {
                    if (this.mUk == null) {
                        this.mUk = new HashSet();
                        this.mUk.add(".h264");
                        this.mUk.add(".h26l");
                        this.mUk.add(".264");
                        this.mUk.add(".avc");
                        this.mUk.add(".mov");
                        this.mUk.add(".mp4");
                        this.mUk.add(".m4a");
                        this.mUk.add(".3gp");
                        this.mUk.add(".3g2");
                        this.mUk.add(".mj2");
                        this.mUk.add(".m4v");
                    }
                    str2 = str2.trim();
                    int lastIndexOf = str2.lastIndexOf(".");
                    z = (lastIndexOf < 0 || lastIndexOf >= str2.length()) ? true : !this.mUk.contains(str2.substring(lastIndexOf));
                }
                if (!z && "video/avc".equalsIgnoreCase(videoMediaItem.hOp) && (bh.ov(videoMediaItem.hOq) || "audio/mp4a-latm".equalsIgnoreCase(videoMediaItem.hOq))) {
                    z = false;
                    if (!z) {
                        x.d("MicroMsg.ImagePreviewUI", "check duration %d", new Object[]{Integer.valueOf(videoMediaItem.hOr)});
                        if (c.aNE().aOh() != 13) {
                            if (videoMediaItem.hOr <= 1000) {
                                this.mUd.setText(getString(R.l.elt));
                                this.mUe.setText(getString(R.l.els));
                                z = true;
                            } else if (videoMediaItem.hOr >= 300000) {
                                this.mUd.setText(getString(R.l.elr));
                                this.mUe.setText(getString(R.l.elq));
                                z = true;
                            } else if (videoMediaItem.hOr >= 10500) {
                                this.mUd.setText(getString(R.l.elg));
                                this.mUe.setText(getString(R.l.elf));
                                this.mUh.setVisibility(0);
                                z = true;
                            }
                            if (z) {
                                enableOptionMenu(true);
                                this.mTZ = true;
                                this.mTX.setVisibility(0);
                                this.mTY.setVisibility(8);
                                this.mTT.setVisibility(0);
                                this.mUi.setVisibility(8);
                                b(str, (MediaItem) videoMediaItem);
                                By(str);
                            }
                        }
                        z = false;
                        if (z) {
                            enableOptionMenu(true);
                            this.mTZ = true;
                            this.mTX.setVisibility(0);
                            this.mTY.setVisibility(8);
                            this.mTT.setVisibility(0);
                            this.mUi.setVisibility(8);
                            b(str, (MediaItem) videoMediaItem);
                            By(str);
                        }
                    }
                }
            }
            String str3 = "MicroMsg.ImagePreviewUI";
            String str4 = "check video format failed, dst format [video/avc], video format [%s]";
            Object[] objArr = new Object[1];
            objArr[0] = videoMediaItem == null ? null : videoMediaItem.hOp;
            x.d(str3, str4, objArr);
            this.mUd.setText(getString(R.l.elk));
            this.mUe.setText(getString(R.l.ell));
            z = true;
            if (!z) {
                x.d("MicroMsg.ImagePreviewUI", "check duration %d", new Object[]{Integer.valueOf(videoMediaItem.hOr)});
                if (c.aNE().aOh() != 13) {
                    if (videoMediaItem.hOr <= 1000) {
                        this.mUd.setText(getString(R.l.elt));
                        this.mUe.setText(getString(R.l.els));
                        z = true;
                    } else if (videoMediaItem.hOr >= 300000) {
                        this.mUd.setText(getString(R.l.elr));
                        this.mUe.setText(getString(R.l.elq));
                        z = true;
                    } else if (videoMediaItem.hOr >= 10500) {
                        this.mUd.setText(getString(R.l.elg));
                        this.mUe.setText(getString(R.l.elf));
                        this.mUh.setVisibility(0);
                        z = true;
                    }
                    if (z) {
                        enableOptionMenu(true);
                        this.mTZ = true;
                        this.mTX.setVisibility(0);
                        this.mTY.setVisibility(8);
                        this.mTT.setVisibility(0);
                        this.mUi.setVisibility(8);
                        b(str, (MediaItem) videoMediaItem);
                        By(str);
                    }
                }
                z = false;
                if (z) {
                    enableOptionMenu(true);
                    this.mTZ = true;
                    this.mTX.setVisibility(0);
                    this.mTY.setVisibility(8);
                    this.mTT.setVisibility(0);
                    this.mUi.setVisibility(8);
                    b(str, (MediaItem) videoMediaItem);
                    By(str);
                }
            }
        }
    }

    private void c(MediaItem mediaItem) {
        if (mediaItem == null) {
            x.e("MicroMsg.ImagePreviewUI", "[updateTopTip] null == item");
        } else if (mediaItem.getType() == 2) {
            VideoMediaItem videoMediaItem = (VideoMediaItem) mediaItem;
            if (bh.ov(videoMediaItem.hOp)) {
                Runnable mVar = new m(mediaItem.hOo, this.mTR.intValue(), videoMediaItem, new 18(this));
                if (com.tencent.mm.sdk.f.e.V(mVar)) {
                    x.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", new Object[]{mediaItem.hOo});
                    return;
                } else {
                    com.tencent.mm.sdk.f.e.post(mVar, "video_analysis");
                    return;
                }
            }
            x.d("MicroMsg.ImagePreviewUI", "path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", new Object[]{videoMediaItem.hOo, Integer.valueOf(videoMediaItem.hOr), Integer.valueOf(videoMediaItem.videoHeight), Integer.valueOf(videoMediaItem.videoWidth)});
            if (videoMediaItem.hOr >= 300000 || (videoMediaItem.hOr > 0 && videoMediaItem.hOr < 1000)) {
                this.mUg.setVisibility(0);
                this.mUf.setText(videoMediaItem.hOr >= 300000 ? getString(R.l.elq) : getString(R.l.els));
                this.mTW.setEnabled(false);
                this.mTV.setEnabled(false);
                this.mTW.setTextColor(getResources().getColor(R.e.buk));
                if (this.mTQ.size() == 0) {
                    enableOptionMenu(false);
                    return;
                }
                return;
            }
            this.mTW.setEnabled(true);
            this.mTV.setEnabled(true);
            this.mTW.setTextColor(getResources().getColor(R.e.buj));
            this.mUg.setVisibility(8);
        } else if (mediaItem.getType() == 1 && !mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
            this.mTW.setEnabled(true);
            this.mTV.setEnabled(true);
            this.mTW.setTextColor(getResources().getColor(R.e.buj));
            if (this.mSB && this.mTQ.contains(mediaItem.hOo) && FileOp.me(mediaItem.hOo) > 26214400) {
                this.mUg.setVisibility(0);
                this.mUf.setText(getString(R.l.elx));
                return;
            }
            this.mUg.setVisibility(8);
        } else if (mediaItem.getType() == 1 && mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
            com.tencent.mm.plugin.gif.e eVar = new com.tencent.mm.plugin.gif.e(mediaItem.hOo);
            int bN = com.tencent.mm.a.e.bN(mediaItem.hOo);
            try {
                if ((!this.mTQ.contains(mediaItem.hOo) || bN == 0 || bN <= this.mRJ.zF()) && eVar.nyI[0] <= this.mRJ.zE() && eVar.nyI[1] <= this.mRJ.zE()) {
                    this.mTW.setTextColor(getResources().getColor(R.e.buj));
                    this.mTW.setEnabled(true);
                    this.mTV.setEnabled(true);
                    return;
                }
                this.mTW.setTextColor(getResources().getColor(R.e.buk));
                this.mTW.setEnabled(false);
                this.mTV.setEnabled(false);
            } catch (Throwable e) {
                x.e("MicroMsg.ImagePreviewUI", bh.i(e));
            }
        }
    }

    private void b(String str, MediaItem mediaItem) {
        if (mediaItem != null && mediaItem.getType() == 2 && c.aNE().aOh() == 4) {
            this.mTV.setVisibility(8);
            this.mTW.setVisibility(8);
            return;
        }
        if (this.mSE == 1) {
            this.mTV.setVisibility(8);
            this.mTW.setVisibility(8);
        } else {
            this.mTV.setVisibility(0);
            this.mTW.setVisibility(0);
        }
        if (this.mTQ.contains(str)) {
            this.mTV.setImageResource(R.k.dxO);
        } else {
            this.mTV.setImageResource(R.k.dxP);
        }
    }

    private void By(String str) {
        Boolean valueOf;
        Boolean.valueOf(false);
        switch (c.aNE().aOh()) {
            case 4:
            case 7:
            case 13:
                valueOf = Boolean.valueOf(true);
                break;
            default:
                valueOf = Boolean.valueOf(false);
                break;
        }
        MediaItem Bt = c.Bt(str);
        if (Bt != null && Bt.getType() == 2) {
            valueOf = Boolean.valueOf(true);
        }
        if (Bt == null && com.tencent.mm.sdk.platformtools.p.UR(str)) {
            valueOf = Boolean.valueOf(true);
        } else if (Bt != null && Bt.mMimeType.equalsIgnoreCase("image/gif")) {
            valueOf = Boolean.valueOf(true);
        }
        if (valueOf.booleanValue()) {
            this.mTS.setVisibility(8);
            this.mSr.setVisibility(8);
            return;
        }
        this.mTS.setVisibility(0);
        this.mSr.setVisibility(0);
    }

    private void a(int i, int i2, String str, int i3) {
        x.i("MicroMsg.ImagePreviewUI", "count:%s selectPosition:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (-1 != i2 && !this.mTi) {
            this.mTO.fm().b(i2, Integer.valueOf(i2));
        } else if (-1 != i2) {
            if (i3 == 0 && i > 0) {
                ((f) this.mTO.fm()).mUw.add(str);
                ((f) this.mTO.fm()).cE(i - 1, this.mTR.intValue());
                this.mTO.fm().bk(i - 1);
                this.mTO.smoothScrollToPosition(i - 1);
            } else if (i3 == 1) {
                int indexOf = ((f) this.mTO.fm()).mUw.indexOf(str);
                if (-1 != indexOf) {
                    ((f) this.mTO.fm()).mUw.remove(indexOf);
                    this.mTO.fm().bl(indexOf);
                }
            }
        }
        int i4;
        if (c.aNE().aOh() == 13) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        MediaItem qy = this.mTM.qy(this.mTR.intValue());
        if (i == 0 || ((this.mSx || r0 != 0) && this.mTM != null && qy != null && qy.getType() == 2)) {
            this.mTO.setVisibility(8);
        } else {
            this.mTO.setVisibility(0);
        }
    }
}
