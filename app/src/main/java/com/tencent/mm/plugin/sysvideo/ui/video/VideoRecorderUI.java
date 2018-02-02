package com.tencent.mm.plugin.sysvideo.ui.video;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.bv.a;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.k.b;
import com.tencent.mm.pluginsdk.k.f;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.p;
import com.tencent.mm.z.ar;
import java.io.InputStream;

public class VideoRecorderUI extends MMActivity {
    private static VideoRecorderUI saf;
    private SurfaceView iXo = null;
    private ProgressDialog iln = null;
    private long kEb = -1;
    private ak kEv = new ak(new 1(this), true);
    private boolean qar;
    private String rZM = null;
    private SurfaceHolder rZQ = null;
    private b rZR;
    private ImageButton rZS;
    private boolean rZT = false;
    private boolean rZU = false;
    private TextView rZV;
    private LinearLayout rZW;
    private ImageView rZX;
    private ImageButton rZY = null;
    private ImageView rZZ;
    private TextView saa;
    private TextView sab;
    private TextView sac;
    private int sad = 0;
    private ImageButton sae;
    private boolean sag = false;
    private boolean sah = true;
    private String sai = null;
    private String saj = null;
    private View sak;
    private View sal;
    private af sam = new af(this) {
        final /* synthetic */ VideoRecorderUI sao;

        {
            this.sao = r1;
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            this.sao.sae.setEnabled(true);
        }
    };
    Callback san = new 3(this);
    private String talker = null;
    private String videoPath = null;

    static /* synthetic */ void d(VideoRecorderUI videoRecorderUI) {
        Bitmap createVideoThumbnail;
        Throwable e;
        InputStream openRawResource;
        String str;
        TextView textView;
        CharSequence charSequence;
        videoRecorderUI.rZU = false;
        videoRecorderUI.releaseWakeLock();
        videoRecorderUI.rZS.setImageResource(R.g.bHh);
        videoRecorderUI.rZS.setEnabled(false);
        videoRecorderUI.getString(R.l.dGO);
        videoRecorderUI.iln = h.a((Context) videoRecorderUI, videoRecorderUI.getString(R.l.eSS, new Object[]{Integer.valueOf(0)}), true, new 2(videoRecorderUI));
        long elapsedRealtime = SystemClock.elapsedRealtime() - videoRecorderUI.kEb;
        videoRecorderUI.kEv.TG();
        videoRecorderUI.rZV.setVisibility(8);
        videoRecorderUI.rZT = true;
        b bVar = videoRecorderUI.rZR;
        if (bVar.ouJ != null) {
            try {
                bVar.ouJ.stop();
                bVar.ouJ.release();
            } catch (Exception e2) {
                x.e("MicroMsg.SceneVideo", "video[tiger] video stop failed");
            }
            bVar.ouJ = null;
            bVar.qxu.hVH = (int) (elapsedRealtime / 1000);
            bVar.qxu.hVH = bVar.qxu.hVH > 0 ? bVar.qxu.hVH : 1;
            bVar.qxu.oty = bVar.qxu.hVH * bVar.qxu.fps;
            if (!(!e.bO(bVar.qxu.otx) || e.bO(bVar.qxu.otv) || bVar.context == null)) {
                createVideoThumbnail = d.fM(8) ? ThumbnailUtils.createVideoThumbnail(bVar.qxu.otx, 1) : null;
                if (createVideoThumbnail != null) {
                    try {
                        x.d("MicroMsg.SceneVideo", "saveBitmapToImage " + bVar.qxu.otv);
                        com.tencent.mm.pluginsdk.k.e.a(createVideoThumbnail, CompressFormat.JPEG, bVar.qxu.otv);
                    } catch (Throwable e3) {
                        x.printErrStackTrace("MicroMsg.SceneVideo", e3, "", new Object[0]);
                    }
                } else {
                    try {
                        openRawResource = bVar.context.getResources().openRawResource(R.g.bBA);
                        try {
                            com.tencent.mm.pluginsdk.k.e.a(BitmapFactory.decodeStream(openRawResource), CompressFormat.JPEG, bVar.qxu.otv);
                            if (openRawResource != null) {
                                try {
                                    openRawResource.close();
                                } catch (Throwable e32) {
                                    x.printErrStackTrace("MicroMsg.SceneVideo", e32, "", new Object[0]);
                                }
                            }
                        } catch (Exception e4) {
                            e32 = e4;
                            try {
                                x.printErrStackTrace("MicroMsg.SceneVideo", e32, "", new Object[0]);
                                if (openRawResource != null) {
                                    try {
                                        openRawResource.close();
                                    } catch (Throwable e322) {
                                        x.printErrStackTrace("MicroMsg.SceneVideo", e322, "", new Object[0]);
                                    }
                                }
                                if (e.bO(bVar.qxu.otx)) {
                                    bVar.fileSize = e.bN(bVar.qxu.otx);
                                }
                                str = videoRecorderUI.rZR.qxu.otv;
                                if (str != null) {
                                }
                                createVideoThumbnail = null;
                                if (createVideoThumbnail != null) {
                                    videoRecorderUI.iXo.setVisibility(8);
                                    videoRecorderUI.rZX.setVisibility(0);
                                    videoRecorderUI.rZX.setImageBitmap(createVideoThumbnail);
                                }
                                if (videoRecorderUI.iln != null) {
                                    videoRecorderUI.iln.dismiss();
                                    videoRecorderUI.iln = null;
                                }
                                videoRecorderUI.rZV.setVisibility(8);
                                videoRecorderUI.sal.setVisibility(0);
                                textView = videoRecorderUI.sab;
                                elapsedRealtime = (long) videoRecorderUI.rZR.fileSize;
                                charSequence = (elapsedRealtime >> 20) > 0 ? (elapsedRealtime >> 9) > 0 ? elapsedRealtime + "B" : (((float) Math.round((((float) elapsedRealtime) * 10.0f) / 1024.0f)) / 10.0f) + "KB" : (((float) Math.round((((float) elapsedRealtime) * 10.0f) / 1048576.0f)) / 10.0f) + "MB";
                                textView.setText(charSequence);
                                videoRecorderUI.sac.setText(com.tencent.mm.pluginsdk.k.e.iW(videoRecorderUI.rZR.qxu.hVH));
                                videoRecorderUI.rZW.setVisibility(8);
                                videoRecorderUI.rZY.setVisibility(0);
                                videoRecorderUI.sak.setVisibility(8);
                                videoRecorderUI.sae.setVisibility(8);
                                videoRecorderUI.rZS.setVisibility(8);
                                videoRecorderUI.rZS.setEnabled(true);
                                videoRecorderUI.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                                videoRecorderUI.getSupportActionBar().show();
                            } catch (Throwable th) {
                                e322 = th;
                                if (openRawResource != null) {
                                    try {
                                        openRawResource.close();
                                    } catch (Throwable e5) {
                                        x.printErrStackTrace("MicroMsg.SceneVideo", e5, "", new Object[0]);
                                    }
                                }
                                throw e322;
                            }
                        }
                    } catch (Exception e6) {
                        e322 = e6;
                        openRawResource = null;
                        x.printErrStackTrace("MicroMsg.SceneVideo", e322, "", new Object[0]);
                        if (openRawResource != null) {
                            openRawResource.close();
                        }
                        if (e.bO(bVar.qxu.otx)) {
                            bVar.fileSize = e.bN(bVar.qxu.otx);
                        }
                        str = videoRecorderUI.rZR.qxu.otv;
                        if (str != null) {
                        }
                        createVideoThumbnail = null;
                        if (createVideoThumbnail != null) {
                            videoRecorderUI.iXo.setVisibility(8);
                            videoRecorderUI.rZX.setVisibility(0);
                            videoRecorderUI.rZX.setImageBitmap(createVideoThumbnail);
                        }
                        if (videoRecorderUI.iln != null) {
                            videoRecorderUI.iln.dismiss();
                            videoRecorderUI.iln = null;
                        }
                        videoRecorderUI.rZV.setVisibility(8);
                        videoRecorderUI.sal.setVisibility(0);
                        textView = videoRecorderUI.sab;
                        elapsedRealtime = (long) videoRecorderUI.rZR.fileSize;
                        if ((elapsedRealtime >> 20) > 0) {
                        }
                        textView.setText(charSequence);
                        videoRecorderUI.sac.setText(com.tencent.mm.pluginsdk.k.e.iW(videoRecorderUI.rZR.qxu.hVH));
                        videoRecorderUI.rZW.setVisibility(8);
                        videoRecorderUI.rZY.setVisibility(0);
                        videoRecorderUI.sak.setVisibility(8);
                        videoRecorderUI.sae.setVisibility(8);
                        videoRecorderUI.rZS.setVisibility(8);
                        videoRecorderUI.rZS.setEnabled(true);
                        videoRecorderUI.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                        videoRecorderUI.getSupportActionBar().show();
                    } catch (Throwable th2) {
                        e322 = th2;
                        openRawResource = null;
                        if (openRawResource != null) {
                            openRawResource.close();
                        }
                        throw e322;
                    }
                }
            }
            if (e.bO(bVar.qxu.otx)) {
                bVar.fileSize = e.bN(bVar.qxu.otx);
            }
        }
        str = videoRecorderUI.rZR.qxu.otv;
        if (str != null || str.length() <= 0) {
            createVideoThumbnail = null;
        } else {
            Bitmap b = BackwardSupportUtil.b.b(str.trim(), a.getDensity(videoRecorderUI));
            if (b != null) {
                int width = b.getWidth();
                int height = b.getHeight();
                int b2 = BackwardSupportUtil.b.b(videoRecorderUI, 224.0f);
                createVideoThumbnail = Bitmap.createScaledBitmap(b, b2, (int) (((float) height) / (((float) width) / ((float) b2))), true);
                if (b != createVideoThumbnail) {
                    x.i("MicroMsg.SceneVideo", "recycle bitmap:%s", new Object[]{b.toString()});
                    b.recycle();
                }
            } else {
                createVideoThumbnail = b;
            }
        }
        if (createVideoThumbnail != null) {
            videoRecorderUI.iXo.setVisibility(8);
            videoRecorderUI.rZX.setVisibility(0);
            videoRecorderUI.rZX.setImageBitmap(createVideoThumbnail);
        }
        if (videoRecorderUI.iln != null) {
            videoRecorderUI.iln.dismiss();
            videoRecorderUI.iln = null;
        }
        videoRecorderUI.rZV.setVisibility(8);
        videoRecorderUI.sal.setVisibility(0);
        textView = videoRecorderUI.sab;
        elapsedRealtime = (long) videoRecorderUI.rZR.fileSize;
        if ((elapsedRealtime >> 20) > 0) {
        }
        textView.setText(charSequence);
        videoRecorderUI.sac.setText(com.tencent.mm.pluginsdk.k.e.iW(videoRecorderUI.rZR.qxu.hVH));
        videoRecorderUI.rZW.setVisibility(8);
        videoRecorderUI.rZY.setVisibility(0);
        videoRecorderUI.sak.setVisibility(8);
        videoRecorderUI.sae.setVisibility(8);
        videoRecorderUI.rZS.setVisibility(8);
        videoRecorderUI.rZS.setEnabled(true);
        videoRecorderUI.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        videoRecorderUI.getSupportActionBar().show();
    }

    static /* synthetic */ void n(VideoRecorderUI videoRecorderUI) {
        videoRecorderUI.mController.hideTitleView();
        videoRecorderUI.rZW.setVisibility(0);
        videoRecorderUI.iXo.setVisibility(0);
        videoRecorderUI.sae.setVisibility(8);
        videoRecorderUI.sal.setVisibility(8);
        videoRecorderUI.rZU = true;
        videoRecorderUI.rZX.setVisibility(8);
        videoRecorderUI.rZY.setVisibility(8);
        videoRecorderUI.sak.setVisibility(0);
        videoRecorderUI.rZV.setVisibility(0);
        videoRecorderUI.kEb = -1;
        videoRecorderUI.kEv.J(300, 300);
        videoRecorderUI.iXo.setKeepScreenOn(true);
        b bVar = videoRecorderUI.rZR;
        SurfaceHolder surfaceHolder = videoRecorderUI.rZQ;
        if (surfaceHolder == null) {
            x.e("MicroMsg.SceneVideo", "start fail, holder is null");
            return;
        }
        Surface surface = surfaceHolder.getSurface();
        bVar.viw = 0;
        bVar.b(surface, bVar.qxu.fps, 0);
    }

    static /* synthetic */ void x(VideoRecorderUI videoRecorderUI) {
        int aGM;
        int aGN;
        LayoutParams layoutParams = (LayoutParams) videoRecorderUI.iXo.getLayoutParams();
        DisplayMetrics displayMetrics = videoRecorderUI.getResources().getDisplayMetrics();
        if (videoRecorderUI.qar) {
            aGM = videoRecorderUI.rZR.aGM();
            aGN = videoRecorderUI.rZR.aGN();
        } else {
            aGM = videoRecorderUI.rZR.aGN();
            aGN = videoRecorderUI.rZR.aGM();
        }
        x.i("MicroMsg.VideoRecorderUI", "resizeLayout priveview[%d, %d], dm[%d, %d]", new Object[]{Integer.valueOf(aGM), Integer.valueOf(aGN), Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels)});
        if (((float) aGM) / ((float) aGN) > ((float) displayMetrics.widthPixels) / ((float) displayMetrics.heightPixels)) {
            x.i("MicroMsg.VideoRecorderUI", "resizeLayout wider");
            aGN = (int) (((float) aGN) * (((float) displayMetrics.widthPixels) / ((float) aGM)));
            aGM = displayMetrics.widthPixels;
        } else {
            x.i("MicroMsg.VideoRecorderUI", "resizeLayout higher");
            aGM = (int) ((((float) displayMetrics.heightPixels) / ((float) aGN)) * ((float) aGM));
            aGN = displayMetrics.heightPixels;
        }
        x.i("MicroMsg.VideoRecorderUI", "resizeLayout width:%d, height:%d", new Object[]{Integer.valueOf(aGM), Integer.valueOf(aGN)});
        layoutParams.width = aGM;
        layoutParams.height = aGN;
        videoRecorderUI.iXo.setLayoutParams(layoutParams);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        p.initLanguage(this);
        saf = this;
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        getSupportActionBar().hide();
        setMMTitle(R.l.eTo);
        a(0, getString(R.l.dGA), new OnMenuItemClickListener(this) {
            final /* synthetic */ VideoRecorderUI sao;

            {
                this.sao = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.putExtra("VideoRecorder_FileName", this.sao.rZR.filename);
                intent.putExtra("VideoRecorder_VideoLength", this.sao.rZR.qxu.hVH);
                intent.putExtra("VideoRecorder_ToUser", this.sao.talker);
                this.sao.setResult(-1, intent);
                this.sao.finish();
                return true;
            }
        }, p.b.xJz);
        setBackBtn(new 6(this));
        this.talker = getIntent().getStringExtra("VideoRecorder_ToUser");
        this.videoPath = getIntent().getStringExtra("VideoRecorder_VideoPath");
        this.rZM = getIntent().getStringExtra("VideoRecorder_VideoFullPath");
        this.sai = getIntent().getStringExtra("VideoRecorder_VideoThumbPath");
        this.saj = getIntent().getStringExtra("VideoRecorder_FileName");
        x.d("MicroMsg.VideoRecorderUI", "talker :" + this.talker);
        x.d("MicroMsg.VideoRecorderUI", "videoPath :" + this.videoPath + " videoFullPath " + this.rZM + " videoThumbPath " + this.sai + " KFileName " + this.saj);
        initView();
        aTU();
        ar.ux().wB();
    }

    public void onStart() {
        super.onStart();
        if (this.qar) {
            setRequestedOrientation(0);
        } else {
            setRequestedOrientation(1);
        }
    }

    protected void onDestroy() {
        saf = null;
        x.v("MicroMsg.VideoRecorderUI", "on destroy");
        ar.ux().wA();
        super.onDestroy();
    }

    protected final void initView() {
        int i = 1;
        this.iXo = (SurfaceView) findViewById(R.h.cPI);
        this.rZW = (LinearLayout) findViewById(R.h.cVo);
        this.rZQ = this.iXo.getHolder();
        this.rZQ.addCallback(this.san);
        this.rZQ.setType(3);
        this.rZZ = (ImageView) findViewById(R.h.cVr);
        this.sae = (ImageButton) findViewById(R.h.cVI);
        this.saa = (TextView) findViewById(R.h.cVp);
        this.sak = findViewById(R.h.cVq);
        this.sal = findViewById(R.h.cVk);
        this.saa.setText(com.tencent.mm.pluginsdk.k.e.iW(0));
        this.rZR = new b();
        this.rZV = (TextView) findViewById(R.h.cVK);
        this.sab = (TextView) findViewById(R.h.cVs);
        this.sac = (TextView) findViewById(R.h.cVl);
        this.rZS = (ImageButton) findViewById(R.h.cVJ);
        this.rZS.setOnClickListener(new 7(this));
        if (com.tencent.mm.compatible.d.d.getNumberOfCameras() > 1) {
            this.sae.setVisibility(0);
        } else {
            this.sae.setVisibility(4);
        }
        this.sae.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VideoRecorderUI sao;

            {
                this.sao = r1;
            }

            public final void onClick(View view) {
                this.sao.sae.setEnabled(false);
                this.sao.sam.sendEmptyMessageDelayed(0, 3000);
                this.sao.sag = true;
                this.sao.rZR.bZK();
                if (this.sao.rZR.a(this.sao, this.sao.sag) != 0 || this.sao.rZR.b(this.sao.rZQ) != 0) {
                    this.sao.bEu();
                }
            }
        });
        this.rZY = (ImageButton) findViewById(R.h.cVh);
        this.rZX = (ImageView) findViewById(R.h.cVn);
        this.rZY.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VideoRecorderUI sao;

            {
                this.sao = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.sao, VideoRecorderPreviewUI.class);
                intent.putExtra("VideoRecorder_FileName", this.sao.rZR.filename);
                intent.putExtra("VideoRecorder_VideoLength", this.sao.rZR.qxu.hVH);
                intent.putExtra("VideoRecorder_VideoSize", this.sao.rZR.fileSize);
                intent.putExtra("VideoRecorder_ToUser", this.sao.talker);
                intent.putExtra("VideoRecorder_VideoFullPath", this.sao.rZM);
                this.sao.startActivityForResult(intent, 0);
                this.sao.overridePendingTransition(0, 0);
            }
        });
        b bVar = this.rZR;
        int i2 = !this.qar ? 1 : 0;
        String str = this.videoPath;
        String str2 = this.rZM;
        String str3 = this.sai;
        String str4 = this.saj;
        bVar.hTT = 0;
        if (1 == bVar.hTT) {
            bVar.qxu = com.tencent.mm.pluginsdk.k.a.bZJ();
        } else {
            bVar.qxu = com.tencent.mm.pluginsdk.k.a.bZI();
        }
        if (q.gFW.gGy) {
            bVar.qxu.otp = q.gFW.mVideoHeight;
            bVar.qxu.otq = q.gFW.mVideoWidth;
            bVar.qxu.oto = q.gFW.gGA;
        }
        bVar.filename = str4;
        bVar.qxu.otx = str2;
        bVar.qxu.otv = str3;
        bVar.qxu.otu = str + "temp.pcm";
        bVar.qxu.ott = str + "temp.yuv";
        bVar.qxu.otw = str + "temp.vid";
        bVar.qxu.otz = com.tencent.mm.compatible.d.d.getNumberOfCameras();
        com.tencent.mm.pluginsdk.k.a aVar = bVar.qxu;
        if (i2 == 0) {
            i = 0;
        }
        aVar.fFy = i;
        bVar.qxu.hVH = 0;
        bVar.viv = new f();
    }

    protected final void dealContentView(View view) {
        ae.c(ae.a(getWindow(), null), this.mController.xIy);
        ((ViewGroup) this.mController.xIy.getParent()).removeView(this.mController.xIy);
        ((ViewGroup) getWindow().getDecorView()).addView(this.mController.xIy, 0);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        x.d("MicroMsg.VideoRecorderUI", "KEYCODE_BACK");
        if (this.rZU) {
            return true;
        }
        bEt();
        return true;
    }

    private void bEt() {
        if (this.rZT) {
            h.a((Context) this, getString(R.l.eTm), getString(R.l.dGO), new 11(this), new 12(this));
        } else {
            finish();
        }
    }

    private void aTU() {
        getSupportActionBar().hide();
        this.saa.setText(com.tencent.mm.pluginsdk.k.e.iW(0));
        this.sak.setVisibility(8);
        this.sal.setVisibility(8);
        this.rZZ.setVisibility(0);
        this.rZT = false;
        this.rZW.setVisibility(0);
        this.iXo.setVisibility(0);
        this.rZV.setVisibility(8);
        this.rZY.setVisibility(8);
        this.saa.setText(com.tencent.mm.pluginsdk.k.e.iW(0));
        this.rZX.setVisibility(8);
        this.rZS.setEnabled(true);
        this.sae.setVisibility(0);
    }

    protected void onResume() {
        if (!(this.sah || (this.rZR.a(this, false) == 0 && this.rZR.b(this.rZQ) == 0))) {
            bEu();
        }
        this.sah = false;
        x.v("MicroMsg.VideoRecorderUI", "onResume");
        super.onResume();
    }

    protected void onPause() {
        if (this.rZU) {
            b bVar = this.rZR;
            if (bVar.ouJ != null) {
                bVar.ouJ.stop();
                bVar.ouJ.release();
                bVar.ouJ = null;
            }
            aTU();
            this.rZU = false;
            releaseWakeLock();
            this.rZS.setImageResource(R.g.bHh);
            this.kEv.TG();
            this.rZV.setVisibility(8);
            this.rZW.setVisibility(0);
            this.iXo.setVisibility(0);
        }
        this.rZR.bZK();
        x.v("MicroMsg.VideoRecorderUI", "onPause");
        super.onPause();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 0) {
                setResult(-1, intent);
                finish();
            }
            super.onActivityResult(i, i2, intent);
        }
    }

    private void bEu() {
        h.a((Context) this, R.l.eSU, R.l.dGO, new 4(this));
    }

    private void releaseWakeLock() {
        this.iXo.setKeepScreenOn(false);
    }

    protected final int getLayoutId() {
        this.qar = com.tencent.mm.compatible.d.d.yl();
        if (!this.qar) {
            return R.i.dtt;
        }
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        setRequestedOrientation(0);
        return R.i.dtu;
    }
}
