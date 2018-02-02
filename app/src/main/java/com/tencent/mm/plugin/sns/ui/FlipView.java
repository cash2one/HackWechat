package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.bm.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.aj;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.g.a.mr;
import com.tencent.mm.g.a.qm;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetAudioState;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.b$b;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.z.q;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class FlipView extends LinearLayout implements OnTouchListener, b$b {
    Context context;
    private int fqb;
    private int fqc;
    protected af handler;
    private long hhB = 0;
    protected int infoType = -1;
    private c msq = new c<mr>(this) {
        final /* synthetic */ FlipView rsJ;

        {
            this.rsJ = r2;
            this.xen = mr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            mr mrVar = (mr) bVar;
            if (!this.rsJ.rsA) {
                x.i("MicroMsg.FlipView", "no need to scan image");
            } else if (this.rsJ.rsB == null || this.rsJ.rsC == null) {
                x.e("MicroMsg.FlipView", "not in recoging");
            } else if (mrVar == null || !(mrVar instanceof mr)) {
                x.e("MicroMsg.FlipView", "receive invalid callbak");
            } else if (mrVar.fED.filePath.equals(this.rsJ.rsC)) {
                x.i("MicroMsg.FlipView", "recog result: " + mrVar.fED.result);
                if (!bh.ov(mrVar.fED.result)) {
                    this.rsJ.rsF = mrVar.fED.result;
                    this.rsJ.fqb = mrVar.fED.fqb;
                    this.rsJ.fqc = mrVar.fED.fqc;
                    if (!(this.rsJ.rsF == null || this.rsJ.rsB == null)) {
                        this.rsJ.rsG = true;
                    }
                    this.rsJ.d(this.rsJ.rsC, this.rsJ.rsD, this.rsJ.rsE, false);
                }
                this.rsJ.rsC = null;
            } else {
                x.e("MicroMsg.FlipView", "not same filepath");
            }
            return false;
        }
    };
    float nqU = 0.0f;
    float nqV = 0.0f;
    boolean nqW = false;
    float nqX = 1.0f;
    boolean rsA = false;
    private g rsB;
    private String rsC;
    private String rsD;
    private String rsE;
    private String rsF;
    private boolean rsG = false;
    private a rsH = new a(this);
    private c rsI = new 6(this);
    private double rss = 0.0d;
    private double rst = 0.0d;
    protected v rsu;
    protected t$a rsv;
    protected int rsw;
    protected int rsx;
    private boolean rsy = false;
    private long rsz = 0;

    public abstract long bzm();

    public abstract boolean bzn();

    public abstract int getPosition();

    static /* synthetic */ void LM(String str) {
        b qmVar = new qm();
        qmVar.fHY.fuL = 3;
        qmVar.fHY.fus = str;
        a.xef.m(qmVar);
    }

    static /* synthetic */ void LN(String str) {
        b qmVar = new qm();
        qmVar.fHY.fuL = 1;
        qmVar.fHY.fIb = 2;
        qmVar.fHY.fus = str;
        a.xef.m(qmVar);
    }

    static /* synthetic */ void j(boolean z, String str) {
        b qmVar = new qm();
        qmVar.fHY.fuL = 2;
        qmVar.fHY.fHZ = 14;
        qmVar.fHY.fIa = z;
        qmVar.fHY.fus = str;
        a.xef.m(qmVar);
    }

    public FlipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public FlipView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        this.handler = new af();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.rsw = displayMetrics.widthPixels;
        this.rsx = displayMetrics.heightPixels;
        a.xef.b(this.msq);
        a.xef.b(this.rsI);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            x.d("MicroMsg.FlipView", "onTouchEvent down");
            this.rss = (double) motionEvent.getX();
            this.rst = (double) motionEvent.getY();
            this.hhB = System.currentTimeMillis();
            if (com.tencent.mm.ui.base.g.K(motionEvent) == 1) {
                this.rsy = false;
            }
        }
        if (com.tencent.mm.ui.base.g.K(motionEvent) > 1) {
            this.rsy = true;
        }
        if (motionEvent.getAction() == 1 && !this.rsy) {
            x.d("MicroMsg.FlipView", "onTouchEvent up " + (System.currentTimeMillis() - this.hhB));
            long Wq = bh.Wq();
            x.d("MicroMsg.FlipView", "deltTime: " + (Wq - this.rsz));
            if (Wq - this.rsz < 300) {
                this.handler.removeCallbacks(this.rsH);
                this.handler.post(new 1(this));
                return super.dispatchTouchEvent(motionEvent);
            }
            this.rsz = Wq;
            if (System.currentTimeMillis() - this.hhB < 500 && Math.abs(((double) motionEvent.getX()) - this.rss) <= 10.0d && Math.abs(((double) motionEvent.getY()) - this.rst) <= 10.0d && motionEvent.getY() > 110.0f && motionEvent.getY() < ((float) (this.rsx - 100))) {
                a aVar = this.rsH;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                aVar.x = x;
                aVar.y = y;
                this.handler.postDelayed(this.rsH, 10);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return !com.tencent.mm.ui.base.g.coK() ? false : false;
    }

    public final void JT(String str) {
    }

    public void aE(String str, boolean z) {
    }

    public final void bun() {
    }

    public void aF(String str, boolean z) {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    protected final void d(String str, String str2, String str3, boolean z) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        m Lm = ae.bvv().Lm(str2);
        if (Lm == null) {
            x.e("MicroMsg.FlipView", "error!!show long click Alert snsInfo is null!!");
            return;
        }
        if (Lm.field_type != 21) {
            if (!u.LE(str2)) {
                arrayList.add(this.context.getString(j.ePW));
                arrayList2.add(Integer.valueOf(1));
            }
            if (d.OQ("favorite")) {
                arrayList.add(this.context.getString(j.eAd));
                arrayList2.add(Integer.valueOf(2));
            }
            if (!u.LE(str2)) {
                if (Lm.field_type == 15 || Lm.field_type == 5) {
                    arrayList.add(this.context.getString(j.eHh));
                    arrayList2.add(Integer.valueOf(0));
                } else if (Lm.field_type == 1) {
                    arrayList.add(this.context.getString(j.eHe));
                    arrayList2.add(Integer.valueOf(0));
                } else {
                    arrayList.add(this.context.getString(j.qMa));
                    arrayList2.add(Integer.valueOf(0));
                }
            }
            b dhVar = new dh();
            dhVar.frQ.frH = str2;
            a.xef.m(dhVar);
            if (dhVar.frR.frp) {
                arrayList.add(this.context.getString(j.qJu));
                arrayList2.add(Integer.valueOf(5));
            }
            if (d.OQ("photoedit") && !u.LE(str2) && Lm.field_type == 1) {
                arrayList.add(this.context.getString(j.dRk));
                arrayList2.add(Integer.valueOf(6));
            }
            if (this.rsF != null) {
                arrayList.add(com.tencent.mm.plugin.scanner.a.az(this.fqb, this.rsF) ? this.context.getString(j.qMc) : this.context.getString(j.qMb));
                arrayList2.add(Integer.valueOf(4));
            }
        } else if (!Lm.field_userName.equals(q.FS())) {
            arrayList.add(this.context.getString(j.qKK));
            arrayList2.add(Integer.valueOf(3));
        }
        if (this.rsB == null || !this.rsG) {
            this.rsB = new g(this.context, g.ztp, false);
        } else {
            this.rsG = false;
        }
        this.rsB.rKC = new 2(this, arrayList, arrayList2);
        this.rsB.ztB = new g.a(this) {
            final /* synthetic */ FlipView rsJ;

            {
                this.rsJ = r1;
            }

            public final void onDismiss() {
                b akVar = new ak();
                akVar.fow.filePath = this.rsJ.rsC;
                a.xef.m(akVar);
                this.rsJ.rsB = null;
                this.rsJ.rsC = null;
                this.rsJ.rsD = "";
                this.rsJ.rsE = null;
                this.rsJ.rsF = null;
                this.rsJ.fqb = this.rsJ.fqc = 0;
            }
        };
        this.rsB.rKD = new 4(this, str2, str, str3);
        this.rsB.bUk();
        if (this.rsA && true == z) {
            com.tencent.mm.kernel.g.Dk();
            if (com.tencent.mm.kernel.g.Di().gPJ.Km() != 0) {
                this.rsC = str;
                this.rsD = str2;
                this.rsE = str3;
                b mpVar = new mp();
                mpVar.fEA.filePath = str;
                a.xef.m(mpVar);
            }
        }
    }

    public static String f(String str, Context context) {
        FileOutputStream fileOutputStream;
        Throwable e;
        Throwable th;
        int i = 1;
        if (str == null || str.equals("")) {
            return null;
        }
        String str2 = e.gHu + String.format("%s%d.%s", new Object[]{SlookAirButtonRecentMediaAdapter.IMAGE_TYPE, Integer.valueOf(str.hashCode()), "jpg"});
        String absolutePath = new File(ac.getContext().getCacheDir(), "tmp" + System.currentTimeMillis()).getAbsolutePath();
        if (FileOp.x(str, absolutePath) < 0) {
            return null;
        }
        if (MMNativeJpeg.isProgressive(absolutePath)) {
            try {
                Bitmap decodeAsBitmap = MMNativeJpeg.decodeAsBitmap(absolutePath);
                if (decodeAsBitmap != null) {
                    CompressFormat compressFormat = CompressFormat.JPEG;
                    fileOutputStream = new FileOutputStream(str2);
                    try {
                        decodeAsBitmap.compress(compressFormat, 80, fileOutputStream);
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        try {
                            x.printErrStackTrace("MicroMsg.FlipView", e, "", new Object[0]);
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e3) {
                                }
                            }
                            FileOp.deleteFile(absolutePath);
                            i = 0;
                            if (i != 0) {
                            }
                            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str2))));
                            return str2;
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e4) {
                                }
                            }
                            FileOp.deleteFile(absolutePath);
                            throw th;
                        }
                    } catch (OutOfMemoryError e5) {
                        e = e5;
                        x.printErrStackTrace("MicroMsg.FlipView", e, "", new Object[0]);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e6) {
                            }
                        }
                        FileOp.deleteFile(absolutePath);
                        i = 0;
                        if (i != 0) {
                        }
                        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str2))));
                        return str2;
                    }
                }
                fileOutputStream = null;
                i = 0;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e7) {
                    }
                }
                FileOp.deleteFile(absolutePath);
            } catch (FileNotFoundException e8) {
                e = e8;
                fileOutputStream = null;
                x.printErrStackTrace("MicroMsg.FlipView", e, "", new Object[0]);
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                FileOp.deleteFile(absolutePath);
                i = 0;
                if (i != 0) {
                }
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str2))));
                return str2;
            } catch (OutOfMemoryError e9) {
                e = e9;
                fileOutputStream = null;
                x.printErrStackTrace("MicroMsg.FlipView", e, "", new Object[0]);
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                FileOp.deleteFile(absolutePath);
                i = 0;
                if (i != 0) {
                }
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str2))));
                return str2;
            } catch (Throwable th3) {
                fileOutputStream = null;
                th = th3;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                FileOp.deleteFile(absolutePath);
                throw th;
            }
        }
        i = 0;
        if (i != 0 && FileOp.x(str, str2) < 0) {
            return null;
        }
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str2))));
        return str2;
    }

    protected void onPause() {
        this.rsC = null;
        this.rsD = "";
        this.rsE = null;
        if (this.rsF != null) {
            b ajVar = new aj();
            ajVar.fou.activity = (Activity) this.context;
            ajVar.fou.fov = this.rsF;
            a.xef.m(ajVar);
            this.rsF = null;
            this.fqc = 0;
            this.fqb = 0;
        }
    }

    protected final void onDestroy() {
        a.xef.c(this.msq);
        a.xef.c(this.rsI);
    }

    public aqr bzo() {
        return null;
    }

    public final void LL(String str) {
        if (FileOp.bO(str)) {
            Intent intent = new Intent();
            x.i("MicroMsg.FlipView", "edit image path:%s", new Object[]{str});
            intent.putExtra("before_photo_edit", str);
            intent.putExtra("from_scene", JsApiGetAudioState.CTRL_INDEX);
            intent.putExtra("after_photo_edit", "");
            intent.putExtra("Retr_Compress_Type", 0);
            intent.putExtra("Retr_Msg_Type", 0);
            intent.putExtra("Retr_FromMainTimeline", bzn());
            d.b(this.context, "photoedit", ".ui.MMNewPhotoEditUI", intent);
        }
    }
}
