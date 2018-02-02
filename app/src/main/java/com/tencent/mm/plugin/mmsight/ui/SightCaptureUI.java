package com.tencent.mm.plugin.mmsight.ui;

import android.app.ActivityManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.compatible.d.m;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.g.a.lq;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiDestroyInstanceAudio;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.plugin.mmsight.model.a.d$c;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.c;
import com.tencent.mm.plugin.mmsight.model.e;
import com.tencent.mm.plugin.mmsight.model.i;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.1;
import com.tencent.mm.plugin.mmsight.ui.cameraglview.MMSightCameraGLSurfaceView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.protocal.c.aqc;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.a;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;

@a(3)
public class SightCaptureUI extends MMActivity implements d.a, c.a {
    private b hXN;
    private d iou;
    private ObservableTextureView ipx;
    private int jir = -1;
    private boolean jis = false;
    private long jit = -1;
    private com.tencent.mm.remoteservice.d mfB = new com.tencent.mm.remoteservice.d(ac.getContext());
    private View nWC;
    private View oCA;
    private a oCB;
    private boolean oCC = true;
    private aqc oCD = new aqc();
    private byte[] oCE;
    private int oCF;
    private int oCG;
    private int oCH;
    private int oCI;
    private byte[] oCJ;
    private int oCK;
    private c oCL;
    private boolean oCM = false;
    private boolean oCN = false;
    private boolean oCO = false;
    private int oCP = 0;
    private int oCQ = 0;
    private Thread oCR = null;
    private long oCS = -1;
    private boolean oCT = false;
    private boolean oCU = false;
    private Runnable oCV = new 17(this);
    private String oCW;
    private String oCX;
    private boolean oCY;
    private Bundle oCZ;
    private int oCh = 1;
    private boolean oCi = true;
    private e oCj;
    private ViewGroup oCk;
    private MMSightRecordButton oCl;
    private View oCm;
    private View oCn;
    private ViewGroup oCo;
    private ViewGroup oCp;
    private ImageView oCq;
    private ImageView oCr;
    private SurfaceTexture oCs;
    CameraFrontSightView oCt;
    private ViewGroup oCu;
    private ImageView oCv;
    private MMSightCameraGLSurfaceView oCw;
    private com.tencent.mm.plugin.mmsight.ui.cameraglview.a oCx;
    private TextView oCy;
    private MMSightCaptureTouchView oCz;
    private Runnable oDa = new 18(this);
    private int oqI = 2;
    private VideoTransPara oqJ;
    private SightParams ouO;
    private VideoSeekBarEditorView oxA;
    private f.a oxF = new 19(this);
    private VideoPlayerTextureView oxz;

    static /* synthetic */ void C(SightCaptureUI sightCaptureUI) {
        if (bh.bw(sightCaptureUI.oCE) || sightCaptureUI.oCG <= 0 || sightCaptureUI.oCF <= 0) {
            x.e("MicroMsg.SightCaptureUI", "saveCaptureYuvDataToBitmap error");
        } else {
            try {
                Bitmap b;
                YuvImage yuvImage = new YuvImage(sightCaptureUI.oCE, 17, sightCaptureUI.oCF, sightCaptureUI.oCG, null);
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                yuvImage.compressToJpeg(new Rect(0, 0, sightCaptureUI.oCF, sightCaptureUI.oCG), 100, byteArrayOutputStream);
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                Bitmap decodeByteArray = MMBitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
                if (!sightCaptureUI.oCO || sightCaptureUI.oCI == 180) {
                    int i = sightCaptureUI.oCH;
                    if (sightCaptureUI.oCI == 180) {
                        i += 180;
                        if (i > 360) {
                            i -= 360;
                        }
                    }
                    b = com.tencent.mm.sdk.platformtools.d.b(decodeByteArray, (float) i);
                    decodeByteArray.recycle();
                } else if (Math.abs(sightCaptureUI.oCH - sightCaptureUI.oCI) == 0) {
                    b = com.tencent.mm.sdk.platformtools.d.b(decodeByteArray, 180.0f);
                    decodeByteArray.recycle();
                } else {
                    b = decodeByteArray;
                }
                try {
                    com.tencent.mm.sdk.platformtools.d.a(b, 90, CompressFormat.JPEG, sightCaptureUI.iou.bav(), false);
                    x.i("MicroMsg.SightCaptureUI", "bitmap filelen %s", Long.valueOf(FileOp.me(r1)));
                } catch (Exception e) {
                    x.e("MicroMsg.SightCaptureUI", "error for saveBitmapToImage %s", e.getMessage());
                }
                j.ouM.D(sightCaptureUI.oCE);
                sightCaptureUI.oCG = 0;
                sightCaptureUI.oCF = 0;
                sightCaptureUI.oCI = 0;
                sightCaptureUI.oCH = 0;
                sightCaptureUI.oCE = null;
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.SightCaptureUI", e2, "saveCaptureYuvDataToBitmap error: %s", e2.getMessage());
            }
        }
        sightCaptureUI.jis = false;
    }

    static /* synthetic */ void F(SightCaptureUI sightCaptureUI) {
        sightCaptureUI.oCm.animate().translationX(0.0f).setDuration(200).setListener(new 15(sightCaptureUI)).start();
        sightCaptureUI.nWC.animate().translationX(0.0f).setDuration(200).setListener(new 16(sightCaptureUI)).start();
    }

    static /* synthetic */ void L(SightCaptureUI sightCaptureUI) {
        x.i("MicroMsg.SightCaptureUI", "start preview");
        if (sightCaptureUI.hXN != null) {
            sightCaptureUI.hXN.requestFocus();
        }
        sightCaptureUI.oxz.setVisibility(0);
        sightCaptureUI.oxz.setAlpha(0.0f);
        sightCaptureUI.oxz.setVideoPath(sightCaptureUI.iou.getFilePath());
        sightCaptureUI.oxz.ccJ();
        sightCaptureUI.oxz.quG = sightCaptureUI.oxF;
    }

    static /* synthetic */ void N(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.jir == 1 || sightCaptureUI.jir == 2) {
            String bab = sightCaptureUI.oCj.bab();
            if (!bh.ov(bab)) {
                StringBuilder append = new StringBuilder().append(bab + "\n" + String.format("CPU: cur %s max:%s", new Object[]{m.ys(), m.yq()})).append("\n");
                Object[] objArr = new Object[1];
                k.baK();
                objArr[0] = k.baO();
                ag.y(new 11(sightCaptureUI, append.append(String.format("RecorderType %s", objArr)).toString() + "\n" + String.format("MemoryClass: %sMB, TotalMem: %sMB", new Object[]{Integer.valueOf(((ActivityManager) ac.getContext().getSystemService("activity")).getLargeMemoryClass()), Integer.valueOf(com.tencent.mm.plugin.mmsight.d.dc(sightCaptureUI))})));
            }
        }
    }

    static /* synthetic */ void U(SightCaptureUI sightCaptureUI) {
        try {
            Bitmap mz = com.tencent.mm.plugin.mmsight.d.mz(sightCaptureUI.iou.getFilePath());
            if (mz != null && sightCaptureUI.oqJ != null && Math.min(mz.getWidth(), mz.getHeight()) > sightCaptureUI.oqJ.hup) {
                int width = mz.getWidth();
                int height = mz.getHeight();
                int i = sightCaptureUI.oqJ.hup > 0 ? sightCaptureUI.oqJ.hup : sightCaptureUI.oqJ.width;
                if (width < height) {
                    width = (int) (((float) height) / ((((float) width) * 1.0f) / ((float) i)));
                } else {
                    int i2 = i;
                    i = (int) (((float) width) / ((((float) height) * 1.0f) / ((float) i)));
                    width = i2;
                }
                com.tencent.mm.sdk.platformtools.d.a(Bitmap.createScaledBitmap(mz, i, width, true), 60, CompressFormat.JPEG, sightCaptureUI.iou.aNV(), true);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SightCaptureUI", e, "saveNewThumbAfterEdit error: %s", e.getMessage());
        }
    }

    static /* synthetic */ void b(SightCaptureUI sightCaptureUI) {
        sightCaptureUI.cmY();
        sightCaptureUI.DR(8);
        if (sightCaptureUI.ouO == null) {
            x.e("MicroMsg.SightCaptureUI", "sightParams error!");
            return;
        }
        sightCaptureUI.oCP = com.tencent.mm.compatible.d.d.getNumberOfCameras();
        x.i("MicroMsg.SightCaptureUI", "initOnCreate, numCamera: %s", Integer.valueOf(sightCaptureUI.oCP));
        sightCaptureUI.hXN = new b(sightCaptureUI);
        sightCaptureUI.oCi = sightCaptureUI.ouO.oqP;
        sightCaptureUI.oqI = sightCaptureUI.ouO.oqI;
        sightCaptureUI.oCC = sightCaptureUI.oqI == 2;
        k.baK().ouO = sightCaptureUI.ouO;
        sightCaptureUI.oCh = sightCaptureUI.ouO.mode;
        x.i("MicroMsg.SightCaptureUI", "SightCaptureUI onCreate, captureMode: %s, showHint: %s, defaultCamera: %s, scene: %s", Integer.valueOf(sightCaptureUI.oCh), Boolean.valueOf(sightCaptureUI.oCi), Integer.valueOf(sightCaptureUI.oqI), Integer.valueOf(sightCaptureUI.ouO.scene));
        sightCaptureUI.oqJ = sightCaptureUI.ouO.oqJ;
        if (sightCaptureUI.oqJ == null) {
            x.e("MicroMsg.SightCaptureUI", "SightCaptureUI onCreate, cannot get videoParams");
            return;
        }
        x.i("MicroMsg.SightCaptureUI", "SightCaptureUI onCreate, videoParams: %s", sightCaptureUI.oqJ);
        sightCaptureUI.getWindow().addFlags(2097280);
        if (com.tencent.mm.compatible.util.d.fM(19)) {
            sightCaptureUI.getWindow().setFlags(201327616, 201327616);
            com.tencent.mm.plugin.mmsight.d.gB(true);
        } else {
            sightCaptureUI.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            com.tencent.mm.plugin.mmsight.d.gB(false);
        }
        sightCaptureUI.oCL = new c(sightCaptureUI);
        sightCaptureUI.oCL.orM = sightCaptureUI;
        sightCaptureUI.oCL.enable();
        sightCaptureUI.oCk = (ViewGroup) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.cIu);
        sightCaptureUI.oCo = (ViewGroup) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oEv);
        sightCaptureUI.oCp = (ViewGroup) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oEw);
        sightCaptureUI.oCt = (CameraFrontSightView) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oEC);
        sightCaptureUI.ipx = (ObservableTextureView) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oEH);
        sightCaptureUI.oCl = (MMSightRecordButton) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oEI);
        sightCaptureUI.oCm = sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oEL);
        sightCaptureUI.nWC = sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oEM);
        sightCaptureUI.oCn = sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oEu);
        sightCaptureUI.oCu = (ViewGroup) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.cVo);
        sightCaptureUI.oCy = (TextView) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oEs);
        if (sightCaptureUI.oCh == 2) {
            sightCaptureUI.oCy.setText(com.tencent.mm.plugin.u.a.f.oFg);
        } else if (sightCaptureUI.oCh == 1) {
            sightCaptureUI.oCy.setText(com.tencent.mm.plugin.u.a.f.oFh);
        } else if (sightCaptureUI.oCh == 0) {
            sightCaptureUI.oCy.setText(com.tencent.mm.plugin.u.a.f.oFf);
        }
        sightCaptureUI.oxz = (VideoPlayerTextureView) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oEG);
        sightCaptureUI.oCq = (ImageView) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oEO);
        sightCaptureUI.oCr = (ImageView) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oEz);
        sightCaptureUI.oCr.setOnClickListener(new 20(sightCaptureUI));
        sightCaptureUI.oCv = (ImageView) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oER);
        sightCaptureUI.oCw = (MMSightCameraGLSurfaceView) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oEy);
        sightCaptureUI.oCz = (MMSightCaptureTouchView) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oEE);
        sightCaptureUI.oCA = sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oEK);
        sightCaptureUI.oCx = new com.tencent.mm.plugin.mmsight.ui.cameraglview.a(sightCaptureUI.oCw);
        if (sightCaptureUI.oCi) {
            sightCaptureUI.oCy.setVisibility(0);
        } else {
            sightCaptureUI.oCy.setVisibility(8);
        }
        int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(sightCaptureUI.mController.xIM, 120);
        CameraFrontSightView cameraFrontSightView = sightCaptureUI.oCt;
        cameraFrontSightView.oAK = cameraFrontSightView.getLayoutParams();
        if (cameraFrontSightView.oAK != null) {
            cameraFrontSightView.oAK.width = fromDPToPix;
            cameraFrontSightView.oAK.height = fromDPToPix;
        }
        cameraFrontSightView.mWidth = fromDPToPix;
        cameraFrontSightView.mHeight = fromDPToPix;
        cameraFrontSightView.oAI = cameraFrontSightView.mWidth / 2;
        cameraFrontSightView.oAJ = cameraFrontSightView.mHeight / 2;
        cameraFrontSightView.jUU = com.tencent.mm.bv.a.fromDPToPix(cameraFrontSightView.getContext(), 1);
        cameraFrontSightView.fC.setColor(-12206054);
        cameraFrontSightView.fC.setStrokeWidth((float) cameraFrontSightView.jUU);
        if (com.tencent.mm.compatible.util.d.fM(19)) {
            int fx = ae.fx(sightCaptureUI);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) sightCaptureUI.oCl.getLayoutParams();
            marginLayoutParams.bottomMargin += fx;
            sightCaptureUI.oCl.setLayoutParams(marginLayoutParams);
            marginLayoutParams = (MarginLayoutParams) sightCaptureUI.oCn.getLayoutParams();
            marginLayoutParams.bottomMargin += fx;
            sightCaptureUI.oCn.setLayoutParams(marginLayoutParams);
            marginLayoutParams = (MarginLayoutParams) sightCaptureUI.oCm.getLayoutParams();
            marginLayoutParams.bottomMargin += fx;
            sightCaptureUI.oCm.setLayoutParams(marginLayoutParams);
            marginLayoutParams = (MarginLayoutParams) sightCaptureUI.oCr.getLayoutParams();
            marginLayoutParams.bottomMargin += fx;
            sightCaptureUI.oCr.setLayoutParams(marginLayoutParams);
            marginLayoutParams = (MarginLayoutParams) sightCaptureUI.nWC.getLayoutParams();
            marginLayoutParams.bottomMargin = fx + marginLayoutParams.bottomMargin;
            sightCaptureUI.nWC.setLayoutParams(marginLayoutParams);
        }
        if (sightCaptureUI.oCh == 1 || sightCaptureUI.oCh == 0) {
            sightCaptureUI.oCl.oBj = new 21(sightCaptureUI);
            sightCaptureUI.oCl.oBl = new 22(sightCaptureUI);
            sightCaptureUI.oCl.oBk = new 23(sightCaptureUI);
        }
        if (sightCaptureUI.oCh == 0 || sightCaptureUI.oCh == 2) {
            sightCaptureUI.oCl.oBi = new 24(sightCaptureUI);
        }
        if (sightCaptureUI.oCP > 1) {
            sightCaptureUI.oCq.setOnClickListener(new 25(sightCaptureUI));
        } else {
            sightCaptureUI.oCq.setVisibility(8);
        }
        sightCaptureUI.nWC.setOnClickListener(new 26(sightCaptureUI));
        sightCaptureUI.oCm.setOnClickListener(new 2(sightCaptureUI));
        sightCaptureUI.oCn.setOnClickListener(new 3(sightCaptureUI));
        sightCaptureUI.oCz.oAL = new 4(sightCaptureUI);
        sightCaptureUI.updateState(0);
        sightCaptureUI.bbA();
    }

    static /* synthetic */ void f(SightCaptureUI sightCaptureUI) {
        x.i("MicroMsg.SightCaptureUI", "[gotoPhotoEditUI]");
        if (sightCaptureUI.iou == null) {
            x.e("MicroMsg.SightCaptureUI", "mediaRecorder == NULL");
            return;
        }
        String stringExtra = sightCaptureUI.getIntent().getStringExtra("GalleryUI_FromUser");
        String stringExtra2 = sightCaptureUI.getIntent().getStringExtra("GalleryUI_ToUser");
        Intent intent = new Intent();
        intent.putExtra("GalleryUI_FromUser", stringExtra);
        intent.putExtra("GalleryUI_ToUser", stringExtra2);
        if (sightCaptureUI.ouO.scene == 1) {
            intent.putExtra("from_scene", JsApiDestroyInstanceAudio.CTRL_INDEX);
        } else if (sightCaptureUI.ouO.scene == 2) {
            intent.putExtra("from_scene", 289);
        }
        intent.putExtra("before_photo_edit", bh.ov(sightCaptureUI.oCW) ? sightCaptureUI.iou.bav() : sightCaptureUI.oCW);
        intent.putExtra("after_photo_edit", sightCaptureUI.oCX);
        com.tencent.mm.bm.d.b(sightCaptureUI, "photoedit", ".ui.MMNewPhotoEditUI", intent, 4369);
    }

    static /* synthetic */ void g(SightCaptureUI sightCaptureUI) {
        if (MMActivity.fs(sightCaptureUI)) {
            sightCaptureUI.DR(0);
        }
        sightCaptureUI.oxA = (VideoSeekBarEditorView) sightCaptureUI.findViewById(com.tencent.mm.plugin.u.a.d.oEU);
        if (ae.fy(sightCaptureUI)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) sightCaptureUI.oxA.getLayoutParams();
            marginLayoutParams.bottomMargin = ae.fx(sightCaptureUI);
            sightCaptureUI.oxA.setLayoutParams(marginLayoutParams);
        }
        sightCaptureUI.oCB = new a();
        sightCaptureUI.oCB.a(sightCaptureUI, sightCaptureUI.ouO.scene, sightCaptureUI.iou.getFilePath(), sightCaptureUI.oxA, sightCaptureUI.oxz, sightCaptureUI.oCo, sightCaptureUI.oqJ, false);
        sightCaptureUI.oCB.oBM = new 14(sightCaptureUI);
        sightCaptureUI.oCm.setVisibility(8);
        sightCaptureUI.nWC.setVisibility(8);
        sightCaptureUI.oCr.setVisibility(8);
    }

    static /* synthetic */ void l(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.oCy != null && sightCaptureUI.oCi) {
            sightCaptureUI.oCy.animate().alpha(0.0f).setDuration(100).setListener(new 6(sightCaptureUI)).start();
        }
    }

    static /* synthetic */ void m(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.iou != null) {
            x.v("MicroMsg.TestCaptureUiEvent", "startRecord, mediaRecorder.status: %s, %s", sightCaptureUI.iou.baz(), bh.cgy().toString());
            sightCaptureUI.updateState(6);
            if (sightCaptureUI.iou.baz() == d$c.Stop) {
                sightCaptureUI.oCQ = sightCaptureUI.bbB();
                if (sightCaptureUI.oCQ < 0) {
                    sightCaptureUI.bbC();
                    return;
                }
            } else if (sightCaptureUI.oCQ < 0) {
                sightCaptureUI.bbC();
                return;
            }
            sightCaptureUI.updateState(2);
            if (sightCaptureUI.oCj != null) {
                e eVar = sightCaptureUI.oCj;
                x.i("MicroMsg.MMSightCamera", "switchToVideoFocusMode");
                if (eVar.gEB != null && eVar.orS) {
                    try {
                        Parameters parameters = eVar.gEB.getParameters();
                        List supportedFocusModes = parameters.getSupportedFocusModes();
                        if (supportedFocusModes != null && supportedFocusModes.contains("continuous-video")) {
                            x.i("MicroMsg.MMSightCameraSetting", "support continuous video");
                            parameters.setFocusMode("continuous-video");
                        }
                        eVar.gEB.setParameters(parameters);
                    } catch (Exception e) {
                        x.i("MicroMsg.MMSightCamera", "switchToVideoFocusMode error: %s", e.getMessage());
                    }
                }
            }
            MMSightRecordButton mMSightRecordButton = sightCaptureUI.oCl;
            int i = (sightCaptureUI.oqJ.duration * 1000) - 500;
            x.k("MicroMsg.MMSightRecordButton", "startProgress, initProgress: %s, maxProgress: %s, duration: %s, callback: %s", Integer.valueOf(0), Integer.valueOf(100), Integer.valueOf(i), new 8(sightCaptureUI));
            MMSightCircularProgressBar mMSightCircularProgressBar = mMSightRecordButton.oBa;
            x.i("MicroMsg.MMSightCircularProgressBar", "setInitProgress: %s, isStart: %s", Integer.valueOf(0), Boolean.valueOf(mMSightCircularProgressBar.fAs));
            if (!mMSightCircularProgressBar.fAs) {
                mMSightCircularProgressBar.oAN = 0;
            }
            mMSightCircularProgressBar = mMSightRecordButton.oBa;
            x.i("MicroMsg.MMSightCircularProgressBar", "setMaxProgress: %s", Integer.valueOf(100));
            mMSightCircularProgressBar.oAO = 100;
            mMSightCircularProgressBar = mMSightRecordButton.oBa;
            x.i("MicroMsg.MMSightCircularProgressBar", "setDuration: %s", Integer.valueOf(i));
            mMSightCircularProgressBar.duration = i;
            mMSightRecordButton.oBa.setVisibility(0);
            mMSightRecordButton.oBa.oAR = new 1(mMSightRecordButton, r2);
            MMSightCircularProgressBar mMSightCircularProgressBar2 = mMSightRecordButton.oBa;
            x.i("MicroMsg.MMSightCircularProgressBar", "start, initProgress: %s, maxProgress: %s, duration: %s", Integer.valueOf(mMSightCircularProgressBar2.oAN), Integer.valueOf(mMSightCircularProgressBar2.oAO), Integer.valueOf(mMSightCircularProgressBar2.duration));
            mMSightCircularProgressBar2.oAM = 0.0f;
            mMSightCircularProgressBar2.oAQ = new b((float) mMSightCircularProgressBar2.oAN, (float) mMSightCircularProgressBar2.oAO, mMSightCircularProgressBar2.duration);
            b bVar = mMSightCircularProgressBar2.oAQ;
            x.i("MicroMsg.ProgressHandlerAnimator", "setAnimationCallback: %s", new MMSightCircularProgressBar.1(mMSightCircularProgressBar2));
            bVar.oCe = r2;
            b bVar2 = mMSightCircularProgressBar2.oAQ;
            x.i("MicroMsg.ProgressHandlerAnimator", "Start");
            bVar2.fAs = true;
            bVar2.oCc = bh.Wq();
            bVar2.hHu.J(20, 20);
        }
    }

    static /* synthetic */ void o(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.oCj != null && sightCaptureUI.oCj.orS && sightCaptureUI.oCL != null && !sightCaptureUI.jis) {
            if (sightCaptureUI.jit < 0 || bh.bA(sightCaptureUI.jit) <= 300) {
                sightCaptureUI.jis = true;
                if (sightCaptureUI.oCy != null && sightCaptureUI.oCi) {
                    sightCaptureUI.oCy.setVisibility(8);
                }
                sightCaptureUI.updateState(7);
                sightCaptureUI.oCl.gI(false);
                sightCaptureUI.oCO = sightCaptureUI.oCL.aZW();
                sightCaptureUI.oCJ = null;
                sightCaptureUI.oCK = -1;
                sightCaptureUI.oCj.a(new 5(sightCaptureUI), sightCaptureUI.oCO, sightCaptureUI.oCL.getOrientation());
                sightCaptureUI.jit = bh.Wq();
            }
        }
    }

    static /* synthetic */ void r(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.oCS <= 0 || bh.bA(sightCaptureUI.oCS) > 500) {
            x.v("MicroMsg.TestCaptureUiEvent", "switchCameraClick %s, currentState: %s", bh.cgy().toString(), Integer.valueOf(sightCaptureUI.jir));
            sightCaptureUI.bbD();
            sightCaptureUI.oCM = true;
            if (sightCaptureUI.jir == 2) {
                if (sightCaptureUI.iou == null || !sightCaptureUI.iou.baD()) {
                    x.i("MicroMsg.SightCaptureUI", "switchCameraClick, not write camera data!");
                } else {
                    String str = "MicroMsg.SightCaptureUI";
                    String str2 = "switchCameraOnRecord, currentStatus: %s, mediaRecorder.status: %s";
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(sightCaptureUI.jir);
                    objArr[1] = sightCaptureUI.iou != null ? sightCaptureUI.iou.baz() : "";
                    x.i(str, str2, objArr);
                    if (sightCaptureUI.jir == 2 && sightCaptureUI.iou != null && sightCaptureUI.iou.baz() == d$c.Start) {
                        sightCaptureUI.iou.pause();
                        sightCaptureUI.oCj.a(sightCaptureUI, sightCaptureUI.oCs, false);
                        sightCaptureUI.oCC = sightCaptureUI.oCj.osz;
                        if (sightCaptureUI.oCx != null) {
                            sightCaptureUI.oCx.R(sightCaptureUI.oCj.aGM(), sightCaptureUI.oCj.aGN(), sightCaptureUI.oCj.getOrientation());
                        }
                        if (sightCaptureUI.iou.baz() != d$c.Pause) {
                            x.e("MicroMsg.SightCaptureUI", "switchCameraOnRecord, recorder status error: %s", sightCaptureUI.iou.baz());
                        } else {
                            int aGM = sightCaptureUI.oCj.aGM();
                            int aGN = sightCaptureUI.oCj.aGN();
                            int orientation = sightCaptureUI.oCj.getOrientation();
                            Point baB = sightCaptureUI.iou.baB();
                            x.i("MicroMsg.SightCaptureUI", "switchCameraOnRecord, newPreviewSize: [%s, %s], oldPreviewSize: [%s], newOrientation: %s, oldOrientation: %s", Integer.valueOf(aGM), Integer.valueOf(aGN), baB, Integer.valueOf(orientation), Integer.valueOf(sightCaptureUI.iou.baC()));
                            if (!(sightCaptureUI.iou.baC() == orientation && baB.x == aGM && baB.y == aGN)) {
                                x.e("MicroMsg.SightCaptureUI", "error oldOrientation! after switch, size or orientation not match");
                            }
                            sightCaptureUI.iou.m(sightCaptureUI.oCj.aGM(), sightCaptureUI.oCj.aGN(), sightCaptureUI.oCj.osb.x, sightCaptureUI.oCj.osb.y);
                            sightCaptureUI.iou.P(orientation, sightCaptureUI.oCj.osb.x, sightCaptureUI.oCj.osb.y);
                        }
                    }
                    sightCaptureUI.oCN = true;
                }
            } else if (sightCaptureUI.jir == 1) {
                sightCaptureUI.updateState(6);
                if (sightCaptureUI.gK(true)) {
                    sightCaptureUI.updateState(1);
                }
            }
            sightCaptureUI.bbE();
            sightCaptureUI.oCS = bh.Wq();
            return;
        }
        x.i("MicroMsg.SightCaptureUI", "switchCameraClick, switch camera too frequently!!! ignore");
    }

    static /* synthetic */ void s(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.ouO.scene == 1 || sightCaptureUI.ouO.scene == 2) {
            int i = sightCaptureUI.oCM ? sightCaptureUI.oCN ? 2 : 1 : 0;
            g.pQN.h(13820, Integer.valueOf(i), Integer.valueOf(sightCaptureUI.ouO.scene));
        }
        if (sightCaptureUI.ouO != null && sightCaptureUI.oCT) {
            com.tencent.mm.plugin.mmsight.a.a.a(new com.tencent.mm.plugin.mmsight.a.a.a(sightCaptureUI.ouO.scene));
        }
        Intent intent = new Intent();
        String filePath = sightCaptureUI.iou.getFilePath();
        String Jp = com.tencent.mm.plugin.sight.base.d.Jp(filePath);
        if (sightCaptureUI.ouO.oqQ) {
            sightCaptureUI.as(filePath, false);
        }
        if (com.tencent.mm.plugin.mmsight.model.a.aZT() != null) {
            sightCaptureUI.oCD.wwS = com.tencent.mm.plugin.mmsight.model.a.aZT().aZU();
        }
        int baA = sightCaptureUI.iou.baA();
        if (sightCaptureUI.oCT) {
            com.tencent.mm.plugin.sight.base.a Js = com.tencent.mm.plugin.sight.base.d.Js(sightCaptureUI.iou.getFilePath());
            if (Js != null) {
                baA = Math.round(((float) Js.mxs) / 1000.0f);
            }
        }
        intent.putExtra("key_req_result", new SightCaptureResult(sightCaptureUI.oCj.osz, filePath, Jp, sightCaptureUI.iou.getFileName(), sightCaptureUI.iou.Nr(), baA, sightCaptureUI.oCD));
        sightCaptureUI.setResult(-1, intent);
        sightCaptureUI.finish();
    }

    static /* synthetic */ void t(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.oCR != null && sightCaptureUI.oCR.isAlive()) {
            try {
                sightCaptureUI.oCR.join();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SightCaptureUI", e, "wait saveCaptureImageThread error: %s", e.getMessage());
            }
        }
        if (sightCaptureUI.ouO.scene == 1 || sightCaptureUI.ouO.scene == 2) {
            int i = 0;
            if (sightCaptureUI.oCM) {
                i = 1;
            }
            g.pQN.h(13820, Integer.valueOf(i), Integer.valueOf(sightCaptureUI.ouO.scene));
        }
        if (sightCaptureUI.ouO.scene == 1) {
            g.pQN.h(13858, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0));
        } else if (sightCaptureUI.ouO.scene == 2) {
            g.pQN.h(13858, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0));
        }
        Intent intent = new Intent();
        Object obj = (bh.ov(sightCaptureUI.oCX) || sightCaptureUI.iou == null || !sightCaptureUI.oCX.equals(sightCaptureUI.iou.bav())) ? null : 1;
        if (obj == null && sightCaptureUI.ouO.oqQ) {
            x.i("MicroMsg.SightCaptureUI", "is not Photo editted!");
            sightCaptureUI.as(sightCaptureUI.iou.bav(), true);
        }
        intent.putExtra("key_req_result", new SightCaptureResult(sightCaptureUI.oCj.osz, sightCaptureUI.iou.bav()));
        sightCaptureUI.setResult(-1, intent);
        Bundle bundle = sightCaptureUI.oCZ;
        if (bundle == null) {
            x.e("MicroMsg.SightCaptureUI", "[reportPhotoEdit] date == null");
        } else if (sightCaptureUI.oCY) {
            int i2 = bundle.getInt("report_info_emotion_count");
            int i3 = bundle.getInt("report_info_text_count");
            int i4 = bundle.getInt("report_info_mosaic_count");
            int i5 = bundle.getInt("report_info_doodle_count");
            boolean z = bundle.getBoolean("report_info_iscrop");
            int i6 = bundle.getInt("report_info_undo_count");
            boolean z2 = bundle.getBoolean("report_info_is_rotation");
            String str = "MicroMsg.SightCaptureUI";
            String str2 = "[reportPhotoEdit] emojiCount:%s,textCount:%s,mosaicCount:%s,penCount:%s,isCrop:%s,undoCount:%s,isRotation:%s";
            Object[] objArr = new Object[7];
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(i3);
            objArr[2] = Integer.valueOf(i4);
            objArr[3] = Integer.valueOf(i5);
            objArr[4] = Integer.valueOf(z ? 1 : 0);
            objArr[5] = Integer.valueOf(i6);
            objArr[6] = Boolean.valueOf(z2);
            x.i(str, str2, objArr);
            g gVar = g.pQN;
            objArr = new Object[10];
            objArr[0] = Integer.valueOf(1);
            objArr[1] = Integer.valueOf(1);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(i3);
            objArr[4] = Integer.valueOf(i4);
            objArr[5] = Integer.valueOf(i5);
            objArr[6] = Integer.valueOf(z ? 1 : 0);
            objArr[7] = Integer.valueOf(i6);
            objArr[8] = Integer.valueOf(3);
            objArr[9] = Integer.valueOf(z2 ? 1 : 0);
            gVar.h(13857, objArr);
        } else {
            x.i("MicroMsg.SightCaptureUI", "[reportPhotoEdit] reportPhotoEdit == false");
        }
        sightCaptureUI.finish();
    }

    static /* synthetic */ void z(SightCaptureUI sightCaptureUI) {
        x.i("MicroMsg.SightCaptureUI", "setRevertAndSendBtnPos");
        if (sightCaptureUI.oCr.getVisibility() == 8) {
            sightCaptureUI.oCz.setVisibility(8);
        } else {
            sightCaptureUI.oCz.setVisibility(0);
        }
        Point db = com.tencent.mm.plugin.mmsight.d.db(sightCaptureUI);
        int dimensionPixelSize = sightCaptureUI.getResources().getDimensionPixelSize(com.tencent.mm.plugin.u.a.b.oEm);
        int dimensionPixelSize2 = sightCaptureUI.getResources().getDimensionPixelSize(com.tencent.mm.plugin.u.a.b.oEo);
        sightCaptureUI.oCl.getX();
        sightCaptureUI.oCm.setTranslationX(((((float) db.x) / 2.0f) - ((float) dimensionPixelSize2)) - (((float) dimensionPixelSize) / 2.0f));
        sightCaptureUI.nWC.setTranslationX(((((float) (-db.x)) / 2.0f) + ((float) dimensionPixelSize2)) + (((float) dimensionPixelSize) / 2.0f));
        sightCaptureUI.oCm.setEnabled(false);
        sightCaptureUI.nWC.setEnabled(false);
    }

    public void onCreate(Bundle bundle) {
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        this.ouO = (SightParams) getIntent().getParcelableExtra("KEY_SIGHT_PARAMS");
        if (this.ouO == null) {
            x.e("MicroMsg.SightCaptureUI", "error!!!! sightParams is null!!");
            return;
        }
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.mfB));
        this.mfB.I(new 1(this, bh.Wq()));
    }

    protected void onPause() {
        super.onPause();
        x.i("MicroMsg.SightCaptureUI", "onPause, currentState: %s", ta(this.jir));
        if (this.jir == 2) {
            uE();
        } else if (this.jir == 1) {
            bbF();
        } else if (this.jir == 4 && this.oxz != null) {
            this.oxz.pause();
        }
    }

    protected void onResume() {
        boolean z = false;
        super.onResume();
        DR(8);
        String str = "MicroMsg.SightCaptureUI";
        String str2 = "onResume, currentState: %s, textureview available: %s";
        Object[] objArr = new Object[2];
        objArr[0] = ta(this.jir);
        if (this.ipx != null && this.ipx.isAvailable()) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (this.jir == 2 || this.jir == 1) {
            bbA();
        } else if (this.jir == 4) {
            if (this.ipx != null) {
                if (this.ipx.isAvailable()) {
                    this.oCx.bbJ();
                } else {
                    this.ipx.a(new 12(this));
                }
            }
            if (this.oxz != null) {
                this.oxz.start();
            }
        } else if (this.jir == 3) {
            if (this.ipx != null) {
                this.ipx.a(null);
            }
            this.oCx.a(this.oCJ, this.oCO, this.oCK);
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    private void uE() {
        x.k("MicroMsg.SightCaptureUI", "stopRecord, currentStatus: %s", Integer.valueOf(this.jir));
        if (this.jir == 2) {
            updateState(7);
            this.oCl.gI(false);
            this.iou.C(new 9(this, this.oCj.aGM(), this.oCj.aGN()));
        }
    }

    private void bbA() {
        updateState(0);
        this.oCQ = 0;
        this.jis = false;
        this.oCU = false;
        if (this.oxz != null) {
            this.oxz.stop();
            this.oxz.quG = null;
            try {
                LayoutParams layoutParams = this.oxz.getLayoutParams();
                this.oCo.removeView(this.oxz);
                this.oCo.addView(this.oxz, 0, layoutParams);
            } catch (Exception e) {
                x.e("MicroMsg.SightCaptureUI", "clearVideoPlayViewContent, error: %s", e.getMessage());
            }
        }
        if (this.oCB != null) {
            this.oCB.release();
            this.oCB = null;
        }
        this.oCw.setVisibility(0);
        this.oCv.setImageBitmap(null);
        bbF();
        this.oCj = new e(this.oqJ, this.ouO.scene);
        this.oCj.a(this.oCx.oDz);
        if (this.oCj.i(this, this.oCC)) {
            if (this.ipx.isAvailable()) {
                this.oCs = this.ipx.getSurfaceTexture();
                x.i("MicroMsg.SightCaptureUI", "surface already available, directly set local surface: %s", this.oCs);
                if (gK(false)) {
                    updateState(1);
                } else {
                    updateState(8);
                }
            } else {
                this.ipx.a(new 7(this));
            }
            if (this.oCy != null && this.oCi) {
                this.oCy.setAlpha(1.0f);
                this.oCy.setVisibility(0);
            }
            c cVar = this.oCL;
            x.i("MicroMsg.DeviceOrientationListener", "reset");
            cVar.orJ = -1;
            cVar.orientation = -1;
            cVar.orI = -1;
            this.oCM = false;
            this.oCN = false;
            return;
        }
        updateState(8);
    }

    private boolean gK(boolean z) {
        x.j("MicroMsg.SightCaptureUI", "createRecorder, surface: %s", this.oCs);
        this.oCU = false;
        if (this.iou != null) {
            if (this.oCj != null) {
                this.oCj.b(this.iou.bay());
            }
            this.iou.cancel();
        }
        if (this.oCj == null) {
            return false;
        }
        boolean a;
        this.oCD = new aqc();
        this.oCD.wwP = true;
        this.oCD.wwO = com.tencent.mm.plugin.mmsight.model.j.osX.otk;
        if (this.ouO != null) {
            this.oCD.wwR = this.ouO.scene;
        }
        if (z) {
            a = this.oCj.a(this, this.oCs, true);
            this.oCC = this.oCj.osz;
            if (!a) {
                return false;
            }
        } else if (this.oCj.a(this.oCs, true) < 0) {
            return false;
        }
        if (this.oCj.osb == null) {
            return false;
        }
        k.baK();
        this.iou = k.c(this.oqJ);
        if (this.iou == null) {
            x.e("MicroMsg.SightCaptureUI", "create mediaRecorder error");
            this.oCU = true;
            return false;
        }
        com.tencent.mm.plugin.mmsight.d.a(this.iou, this.ouO);
        this.iou.a(this);
        this.oCj.a(this.iou.bay());
        if (this.oCx != null) {
            this.oCx.R(this.oCj.aGM(), this.oCj.aGN(), this.oCj.getOrientation());
        }
        this.iou.m(this.oCj.aGM(), this.oCj.aGN(), this.oCj.osb.x, this.oCj.osb.y);
        a = this.iou.sN(this.oCj.getOrientation());
        x.i("MicroMsg.SightCaptureUI", "preInit result: %s", Boolean.valueOf(a));
        if (!a) {
            this.oCU = true;
        }
        return a;
    }

    private int bbB() {
        x.i("MicroMsg.SightCaptureUI", "startRecordImpl");
        int c = this.iou.c(this.oCj.getOrientation(), this.oCL.aZW(), this.oCL.getOrientation());
        x.i("MicroMsg.SightCaptureUI", "startRecordImpl ret: %d", Integer.valueOf(c));
        if (c >= 0) {
            this.oCj.a(e.a.osC);
        }
        return c;
    }

    private void bbC() {
        this.oCU = true;
        updateState(8);
        if (this.iou != null) {
            try {
                this.iou.cancel();
                this.iou = null;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SightCaptureUI", e, "", new Object[0]);
            }
        }
    }

    private void bbD() {
        k.baK();
        if (k.baN()) {
            TextView textView = (TextView) findViewById(com.tencent.mm.plugin.u.a.d.oES);
            textView.setVisibility(8);
            textView.setText("");
        }
    }

    private void bbE() {
        k.baK();
        if (k.baN()) {
            x.i("MicroMsg.SightCaptureUI", "test for debug " + bh.cgy().toString());
            i.B(new 13(this));
        }
    }

    private String as(String str, boolean z) {
        String on;
        boolean z2 = CaptureMMProxy.getInstance().getBoolean(w.a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, true);
        boolean z3 = CaptureMMProxy.getInstance().getBoolean(w.a.USERINFO_WEIXIN_CAMERASAVEVIDEO_STATE_BOOLEAN, true);
        if (z) {
            on = com.tencent.mm.plugin.mmsight.d.on("jpg");
        } else {
            on = com.tencent.mm.plugin.mmsight.d.on("mp4");
        }
        if ((z2 && z) || (z3 && !z)) {
            x.i("MicroMsg.SightCaptureUI", "auto save src %s dest %s state %s %s", str, on, Boolean.valueOf(z2), Boolean.valueOf(z3));
            FileOp.x(str, on);
            com.tencent.mm.platformtools.d.b(on, this);
        }
        return on;
    }

    private void bbF() {
        if (this.ipx != null) {
            this.ipx.a(null);
        }
        if (this.oCj != null) {
            this.oCC = this.oCj.osz;
            this.oCj.aZX();
            this.oCS = -1;
            this.jit = -1;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.SightCaptureUI", "onDestroy");
        this.mfB.release();
        if (this.iou != null) {
            this.iou.C(null);
        }
        if ((this.jir == -1 ? 1 : null) == null) {
            bbF();
            if (this.oxz != null) {
                this.oxz.stop();
                this.oxz.quG = null;
            }
            if (this.hXN != null) {
                this.hXN.zd();
            }
            if (this.oCB != null) {
                this.oCB.release();
                this.oCB = null;
            }
        }
        if (this.oCL != null) {
            this.oCL.disable();
            this.oCL = null;
        }
        j.ouM.Es();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.u.a.e.oEW;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.SightCaptureUI";
        String str2 = "[onActivityResult] requestCode:%s  resultCode:%s data is null?:";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        x.i(str, str2, objArr);
        switch (i) {
            case 4369:
                x.i("MicroMsg.SightCaptureUI", "[handlePhotoEditResult] resultCode:%s", Integer.valueOf(i2));
                if (i2 == -1 && intent != null && this.iou != null) {
                    this.oCY = true;
                    this.oCZ = intent.getBundleExtra("report_info");
                    this.oCW = intent.getStringExtra("before_photo_edit");
                    this.oCX = intent.getStringExtra("after_photo_edit");
                    x.i("MicroMsg.SightCaptureUI", "rawEditPhotoPath:%s lastEditPhotoPath:%s imageState:%s", this.oCW, this.oCX, Boolean.valueOf(CaptureMMProxy.getInstance().getBoolean(w.a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, true)));
                    if (CaptureMMProxy.getInstance().getBoolean(w.a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, true)) {
                        this.iou.Fj(this.oCX);
                    } else {
                        String subCoreImageFullPath = CaptureMMProxy.getInstance().getSubCoreImageFullPath("photoEdited_" + System.currentTimeMillis());
                        x.i("MicroMsg.SightCaptureUI", "saveFullPath:%s", subCoreImageFullPath);
                        FileOp.x(this.oCX, subCoreImageFullPath);
                        FileOp.deleteFile(this.oCX);
                        com.tencent.mm.platformtools.d.b(this.oCX, this);
                        this.iou.Fj(subCoreImageFullPath);
                        this.oCX = subCoreImageFullPath;
                    }
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(this.oCX, options);
                    x.i("MicroMsg.SightCaptureUI", "rawW:%s rawH:%s", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
                    Bitmap a = com.tencent.mm.sdk.platformtools.d.a(this.oCX, options.outHeight, options.outWidth, true, false, 0);
                    this.oCv.setVisibility(0);
                    this.oCv.setImageBitmap(a);
                    this.oCw.setVisibility(8);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private static String ta(int i) {
        if (i == -1) {
            return "CAPTURE_STATE_BINGDING";
        }
        if (i == 0) {
            return "CAPTURE_STATE_INIT";
        }
        if (i == 1) {
            return "CAPTURE_STATE_CAPTURING";
        }
        if (i == 2) {
            return "CAPTURE_STATE_RECORDING";
        }
        if (i == 3) {
            return "CAPTURE_STATE_PREVIEW_PICTURE";
        }
        if (i == 4) {
            return "CAPTURE_STATE_PREVIEW_VIDEO";
        }
        if (i == 6) {
            return "CAPTURE_STATE_SUPERMAN";
        }
        if (i == 7) {
            return "CAPTURE_STATE_WAIT_TO_PREVIEW";
        }
        if (i == 8) {
            return "CAPTURE_STATE_INIT_ERROR";
        }
        if (i == 9) {
            return "CAPTURE_STATE_STOP_ERROR";
        }
        return "UNKNOW";
    }

    private void updateState(int i) {
        x.i("MicroMsg.SightCaptureUI", "pre state %s %s update state %s %s", Integer.valueOf(this.jir), ta(this.jir), Integer.valueOf(i), ta(i));
        x.i("MicroMsg.TestCaptureUiEvent", "pre state %s %s update state %s %s %s", Integer.valueOf(this.jir), ta(this.jir), Integer.valueOf(i), ta(i), bh.cgy().toString());
        if (i != this.jir) {
            com.tencent.mm.plugin.mmsight.d.Fg("TIME_RECODER_2_PLAY");
            this.jir = i;
            if (this.jir != 7) {
                ag.K(this.oCV);
            }
            if (this.jir == 0) {
                this.oCo.setVisibility(8);
                this.oCr.setVisibility(8);
                this.oCp.setVisibility(8);
                this.oCv.setVisibility(8);
                this.oCu.setVisibility(0);
                if (this.oCP > 1) {
                    this.oCq.setVisibility(0);
                }
                if (this.oCj != null) {
                    this.oCj.a(e.a.osB);
                }
                com.tencent.mm.plugin.mmsight.model.a.reset();
                if (this.oCR != null) {
                    try {
                        this.oCR.interrupt();
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.SightCaptureUI", e, "update to state init, interrupt failed: %s", e.getMessage());
                    }
                    this.oCR = null;
                }
            } else if (this.jir == 1 || this.jir == 2) {
                this.oCo.setVisibility(0);
                this.oCr.setVisibility(8);
                this.oCp.setVisibility(0);
                this.oCp.setClipChildren(false);
                this.oCm.setVisibility(8);
                this.nWC.setVisibility(8);
                this.oCn.setVisibility(0);
                this.oCl.setVisibility(0);
                this.oxz.setVisibility(8);
                if (this.jir == 1) {
                    this.oCl.reset();
                } else {
                    this.oCl.gI(true);
                    MMSightRecordButton mMSightRecordButton = this.oCl;
                    x.i("MicroMsg.MMSightRecordButton", "hideProgressBar");
                    mMSightRecordButton.oAZ.setVisibility(8);
                }
                this.oCA.setVisibility(8);
                this.oCv.setVisibility(8);
                this.oCz.setVisibility(0);
                if (this.oCP > 1) {
                    this.oCq.setVisibility(0);
                }
                this.oCz.bringToFront();
                this.oCq.bringToFront();
                bbD();
                bbE();
            } else if (this.jir == 4 || this.jir == 3) {
                this.oCo.setVisibility(0);
                this.oCp.setVisibility(8);
                this.oCp.setClipChildren(false);
                this.oCm.setVisibility(0);
                this.nWC.setVisibility(0);
                this.oCn.setVisibility(8);
                this.oCl.setVisibility(8);
                if (this.jir == 3) {
                    this.oCr.setVisibility(0);
                    this.oCv.setVisibility(0);
                    this.oxz.setVisibility(8);
                } else {
                    this.oCv.setVisibility(8);
                    this.oxz.setVisibility(0);
                    this.oxz.ccJ();
                    LayoutParams layoutParams = this.oxz.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.oxz.setLayoutParams(layoutParams);
                    if (this.iou.aZW()) {
                        this.oCx.bbJ();
                    }
                    this.oCu.setVisibility(8);
                }
                this.oCz.setVisibility(8);
            } else if (this.jir == 6) {
                this.oCm.setVisibility(8);
                this.nWC.setVisibility(8);
                this.oCr.setVisibility(8);
                this.oCn.setVisibility(8);
                this.oCl.setVisibility(8);
            } else if (this.jir == 7) {
                this.oCm.setVisibility(8);
                this.nWC.setVisibility(8);
                this.oCn.setVisibility(8);
                this.oCq.setVisibility(8);
                this.oCr.setVisibility(8);
                this.oCl.gI(false);
                ag.h(this.oCV, 1500);
                this.oCl.bbt();
            } else if (this.jir == 8) {
                this.oCo.setVisibility(0);
                this.oCp.setVisibility(0);
                this.oCp.setClipChildren(false);
                this.oCm.setVisibility(8);
                this.nWC.setVisibility(8);
                this.oCr.setVisibility(8);
                this.oCn.setVisibility(0);
                if (this.oCP > 1) {
                    this.oCq.setVisibility(0);
                }
                this.oCl.setVisibility(0);
                this.oCz.setVisibility(0);
                this.oxz.setVisibility(8);
                this.oCA.setVisibility(8);
                this.oCv.setVisibility(8);
                if (this.oCU) {
                    Toast.makeText(this, com.tencent.mm.plugin.u.a.f.oFd, 1).show();
                } else {
                    Toast.makeText(this, com.tencent.mm.plugin.u.a.f.iBY, 1).show();
                }
                this.oCl.gI(false);
                this.oCl.setEnabled(false);
            } else if (this.jir == 9) {
                this.oCm.setVisibility(8);
                this.nWC.setVisibility(8);
                this.oCr.setVisibility(8);
                this.oCn.setVisibility(0);
                this.oCq.setVisibility(8);
                this.oCl.reset();
                this.oCl.gI(false);
                this.oCl.setEnabled(false);
                Toast.makeText(this, com.tencent.mm.plugin.u.a.f.oFe, 1).show();
            }
        }
    }

    private void gL(boolean z) {
        x.i("MicroMsg.SightCaptureUI", "[clearPhotoEditCache] isDelete:%s mLastEditPhotoPath:%s mRawEditPhotoPath:%s", Boolean.valueOf(z), this.oCX, this.oCW);
        if (!bh.ov(this.oCX) && z) {
            FileOp.deleteFile(this.oCX);
        }
        if (!bh.ov(this.oCW)) {
            FileOp.deleteFile(this.oCW);
        }
        this.oCX = null;
        this.oCW = null;
        com.tencent.mm.sdk.b.b lqVar = new lq();
        lqVar.fDe.fpr = 0;
        com.tencent.mm.sdk.b.a.xef.m(lqVar);
    }

    public void onBackPressed() {
        x.i("MicroMsg.SightCaptureUI", "onBackPressed %d", Integer.valueOf(this.jir));
        if (this.oCB != null && this.oCB.aeG()) {
            return;
        }
        if (this.oCB != null) {
            this.oCB.release();
            this.oCB = null;
            DR(8);
            this.oCm.setVisibility(0);
            this.nWC.setVisibility(0);
            this.oCr.setVisibility(0);
        } else if (bbG()) {
            super.onBackPressed();
            overridePendingTransition(-1, com.tencent.mm.plugin.u.a.a.oEl);
            gL(true);
        }
    }

    private boolean bbG() {
        return this.jir == 4 || this.jir == 3 || this.jir == 1 || this.jir == 8 || this.jir == 9;
    }

    public final void sL(int i) {
        if (this.oCP > 1 && this.jir != 2) {
            x.i("MicroMsg.SightCaptureUI", "onOrientationChange: %s", Integer.valueOf(i));
            if (i >= 0) {
                float f;
                if (i != 90 && i != 270) {
                    f = (float) i;
                } else if (i == 270) {
                    f = 90.0f;
                } else {
                    f = -90.0f;
                }
                if (this.oCq.getRotation() != f) {
                    this.oCq.animate().rotation(f).setDuration(100).start();
                }
            }
        }
    }

    public final void Yn() {
        x.i("MicroMsg.SightCaptureUI", "onError: %s", Integer.valueOf(1));
        try {
            if (this.iou != null) {
                this.iou.reset();
            }
        } catch (Exception e) {
            x.e("MicroMsg.SightCaptureUI", "onError, reset mediaRecorder error: %s", e.getMessage());
        }
        updateState(9);
    }
}
