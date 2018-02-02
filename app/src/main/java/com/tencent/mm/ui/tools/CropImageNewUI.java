package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import android.util.DisplayMetrics;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ImageDownloadUI;
import com.tencent.mm.ui.e.b.c;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.lang.reflect.Array;
import junit.framework.Assert;

public class CropImageNewUI extends MMActivity {
    private String filePath;
    private int kFm = 0;
    private final int zgZ = 1;
    private final int zha = 0;
    private int zhb;
    private int zhc = 0;
    private FilterImageView zhd;
    private LinearLayout zhe;
    private CropImageView zhf;
    private ImageView zhg;
    private View zhh;
    private int zhi = 0;
    private boolean zhj = false;
    private boolean zhk = false;
    private boolean zhl = false;

    static /* synthetic */ void a(CropImageNewUI cropImageNewUI, CropImageView cropImageView, View view) {
        x.d("MicroMsg.CropImageUI", "doCropImage" + cropImageNewUI.zhl);
        if (cropImageView != null && view != null) {
            if (cropImageNewUI.zhl) {
                x.d("MicroMsg.CropImageUI", "isCroping");
                return;
            }
            cropImageNewUI.zhl = true;
            Bitmap createBitmap = d.createBitmap(cropImageView.mTJ.getWidth(), cropImageView.mTJ.getHeight(), Config.ARGB_8888);
            if (createBitmap == null) {
                cropImageNewUI.setResult(-1);
                cropImageNewUI.finish();
                return;
            }
            Canvas canvas = new Canvas(createBitmap);
            canvas.translate((float) cropImageView.getScrollX(), (float) cropImageView.getScrollY());
            cropImageView.draw(canvas);
            float[] fArr = new float[9];
            cropImageView.getImageMatrix().getValues(fArr);
            int left = view.getLeft();
            int top = view.getTop();
            int width = view.getWidth();
            Math.abs(fArr[0] != 0.0f ? fArr[0] : fArr[1]);
            float[][] b = n.b(b(cropImageView.getImageMatrix()));
            try {
                createBitmap = cropImageNewUI.kFm == 1 ? a(b, (float) left, (float) (((int) (((double) width) * 0.125d)) + top), (float) (left + width), (float) ((top + width) - ((int) (((double) width) * 0.125d))), cropImageView) : a(b, (float) left, (float) top, (float) (left + width), (float) (top + width), cropImageView);
            } catch (Throwable th) {
                createBitmap = null;
            }
            if (createBitmap == null) {
                x.e("MicroMsg.CropImageUI", "doCropImage: error");
            } else {
                x.d("MicroMsg.CropImageUI", "bm w: " + createBitmap.getWidth() + " " + createBitmap.getHeight());
                if (cropImageNewUI.kFm != 1) {
                    int width2 = createBitmap.getWidth();
                    int height = createBitmap.getHeight();
                    if (width2 != height) {
                        createBitmap = width2 > height ? Bitmap.createBitmap(createBitmap, (width2 - height) / 2, 0, height, height) : Bitmap.createBitmap(createBitmap, 0, (height - width2) / 2, width2, width2);
                    }
                }
                String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_OutputPath");
                if (stringExtra == null) {
                    stringExtra = e.gHu + g.s((cropImageNewUI.filePath + System.currentTimeMillis()).getBytes()) + "_crop.jpg";
                }
                if (cropImageNewUI.a(createBitmap, stringExtra, true)) {
                    Intent intent = new Intent();
                    intent.putExtra("CropImage_OutputPath", stringExtra);
                    if (cropImageNewUI.zhd != null) {
                        intent.putExtra("CropImage_filterId", cropImageNewUI.zhd.qQV);
                    }
                    cropImageNewUI.setResult(-1, intent);
                    cropImageNewUI.finish();
                }
            }
            cropImageNewUI.setResult(-1);
            cropImageNewUI.finish();
        }
    }

    static /* synthetic */ void a(CropImageNewUI cropImageNewUI, boolean z) {
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_OutputPath");
        if (t.ov(stringExtra)) {
            stringExtra = cropImageNewUI.filePath;
        } else {
            byte[] d = FileOp.d(cropImageNewUI.filePath, 0, -1);
            FileOp.b(stringExtra, d, d.length);
        }
        Intent intent = new Intent();
        intent.putExtra("CropImage_Compress_Img", z);
        intent.putExtra("CropImage_OutputPath", stringExtra);
        intent.putExtra("CropImage_rotateCount", cropImageNewUI.zhf.fyR % 4);
        if (cropImageNewUI.zhd != null) {
            intent.putExtra("CropImage_filterId", cropImageNewUI.zhd.qQV);
        }
        intent.putExtra("from_source", cropImageNewUI.getIntent().getIntExtra("from_source", 0));
        cropImageNewUI.setResult(-1, intent);
        cropImageNewUI.finish();
    }

    static /* synthetic */ void d(CropImageNewUI cropImageNewUI) {
        if (cropImageNewUI.zhd.zig == null) {
            cropImageNewUI.zhd.dt(cropImageNewUI.filePath, cropImageNewUI.zhi);
        }
        cropImageNewUI.zhe.setVisibility(8);
        cropImageNewUI.zhd.setVisibility(0);
        cropImageNewUI.zhg.setTag(Integer.valueOf(cropImageNewUI.zhg.getVisibility()));
        cropImageNewUI.zhg.setVisibility(8);
        cropImageNewUI.zhf.setVisibility(8);
    }

    static /* synthetic */ void g(CropImageNewUI cropImageNewUI) {
        cropImageNewUI.zhd.dt(cropImageNewUI.filePath, cropImageNewUI.zhi);
        cropImageNewUI.zhe.setVisibility(8);
        cropImageNewUI.zhd.setVisibility(0);
        cropImageNewUI.zhg.setTag(Integer.valueOf(cropImageNewUI.zhg.getVisibility()));
        cropImageNewUI.zhg.setVisibility(8);
        cropImageNewUI.zhf.setVisibility(8);
        cropImageNewUI.zhd.findViewById(R.h.bZP).setVisibility(4);
    }

    static /* synthetic */ void h(CropImageNewUI cropImageNewUI) {
        x.d("MicroMsg.CropImageUI", "doShowOrNot");
        if (cropImageNewUI.zhe.getVisibility() == 0) {
            cropImageNewUI.zhe.setVisibility(4);
        } else if (cropImageNewUI.zhe.getVisibility() == 4) {
            cropImageNewUI.zhe.setVisibility(0);
        }
    }

    static /* synthetic */ void k(CropImageNewUI cropImageNewUI) {
        int[] cxG = cropImageNewUI.cxG();
        Bitmap ff = cropImageNewUI.ff(cxG[2], cxG[3]);
        Bitmap ff2 = cropImageNewUI.ff(cxG[0], cxG[1]);
        if (cropImageNewUI.zhi != 0) {
            Bitmap bitmap = ff;
            ff = ff2;
            ff2 = bitmap;
        }
        x.d("MicroMsg.CropImageUI", "docrop degree:" + cropImageNewUI.zhi);
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_bg_vertical");
        String stringExtra2 = cropImageNewUI.getIntent().getStringExtra("CropImage_bg_horizontal");
        if (cropImageNewUI.a(ff, stringExtra, true) && cropImageNewUI.a(r0, stringExtra2, true)) {
            Intent intent = new Intent();
            intent.putExtra("CropImage_bg_vertical", stringExtra);
            intent.putExtra("CropImage_bg_horizontal", stringExtra2);
            if (cropImageNewUI.zhd != null) {
                intent.putExtra("CropImage_filterId", cropImageNewUI.zhd.qQV);
            }
            cropImageNewUI.setResult(-1, intent);
        } else {
            cropImageNewUI.setResult(-1);
        }
        cropImageNewUI.finish();
    }

    static /* synthetic */ void l(CropImageNewUI cropImageNewUI) {
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_OutputPath");
        String str = null;
        Intent intent = new Intent();
        if (cropImageNewUI.zhc == 0) {
            try {
                String s = g.s((System.currentTimeMillis()).getBytes());
                d.a(cropImageNewUI.zhf.mTJ, 100, CompressFormat.PNG, stringExtra + s, false);
                str = g.s(FileOp.d(stringExtra + s, 0, (int) FileOp.me(stringExtra + s)));
                if (com.tencent.mm.a.e.bO(stringExtra + str)) {
                    x.i("MicroMsg.CropImageUI", "file is exist. need no to copy!");
                    b.deleteFile(stringExtra + s);
                } else {
                    FileOp.g(stringExtra, s, str);
                }
                intent.putExtra("emoji_type", 0);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.CropImageUI", e, "", new Object[0]);
                cropImageNewUI.setResult(-2);
            }
        } else if (cropImageNewUI.zhc == 1) {
            byte[] d = FileOp.d(cropImageNewUI.filePath, 0, -1);
            str = g.s(d);
            if (com.tencent.mm.a.e.bO(stringExtra + str)) {
                x.i("MicroMsg.CropImageUI", "file is exist. need no to copy!");
            } else {
                FileOp.b(stringExtra + str, d, d.length);
            }
            intent.putExtra("emoji_type", 1);
        }
        intent.putExtra("CropImage_OutputPath", stringExtra + str);
        if (cropImageNewUI.zhd != null) {
            intent.putExtra("CropImage_filterId", cropImageNewUI.zhd.qQV);
        }
        cropImageNewUI.setResult(-1, intent);
        cropImageNewUI.finish();
    }

    static /* synthetic */ void m(CropImageNewUI cropImageNewUI) {
        String[] strArr = (cropImageNewUI.zhj || cropImageNewUI.zhk) ? new String[]{cropImageNewUI.getString(R.l.dXP)} : new String[]{cropImageNewUI.getString(R.l.dXP)};
        h.a(cropImageNewUI, "", strArr, "", false, new 14(cropImageNewUI));
    }

    static /* synthetic */ void n(CropImageNewUI cropImageNewUI) {
        Context context = cropImageNewUI;
        h.a(context, "", new String[]{cropImageNewUI.getString(R.l.eEG), cropImageNewUI.getString(R.l.eHg)}, "", false, new 13(cropImageNewUI));
    }

    static /* synthetic */ void r(CropImageNewUI cropImageNewUI) {
        long longExtra = cropImageNewUI.getIntent().getLongExtra("CropImage_Msg_Id", 0);
        long longExtra2 = cropImageNewUI.getIntent().getLongExtra("CropImage_Msg_Svr_Id", 0);
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_Username");
        Intent intent = new Intent(cropImageNewUI, ImageDownloadUI.class);
        intent.putExtra("img_msg_id", longExtra);
        intent.putExtra("img_server_id", longExtra2);
        intent.putExtra("img_download_compress_type", 1);
        intent.putExtra("img_download_username", stringExtra);
        cropImageNewUI.startActivity(intent);
    }

    static /* synthetic */ void s(CropImageNewUI cropImageNewUI) {
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_ImgPath");
        int intExtra = cropImageNewUI.getIntent().getIntExtra("CropImage_CompressType", 0);
        int intExtra2 = cropImageNewUI.getIntent().getIntExtra("CropImage_Msg_Id", -1);
        Intent intent = new Intent(cropImageNewUI, MsgRetransmitUI.class);
        intent.putExtra("Retr_File_Name", stringExtra);
        intent.putExtra("Retr_Msg_Id", intExtra2);
        intent.putExtra("Retr_Msg_Type", 0);
        intent.putExtra("Retr_Compress_Type", intExtra);
        cropImageNewUI.startActivity(intent);
    }

    static /* synthetic */ void u(CropImageNewUI cropImageNewUI) {
        long me = FileOp.me(cropImageNewUI.filePath) / 1024;
        h.a(cropImageNewUI, cropImageNewUI.getString(R.l.dXN, new Object[]{Long.toString(me)}), cropImageNewUI.getString(R.l.dGO), new OnClickListener(cropImageNewUI) {
            final /* synthetic */ CropImageNewUI zhm;

            {
                this.zhm = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                CropImageNewUI.a(this.zhm, false);
            }
        }, new 16(cropImageNewUI));
    }

    protected final int getLayoutId() {
        return R.i.dfn;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        initView();
    }

    public void onResume() {
        super.onResume();
        setRequestedOrientation(1);
    }

    public void onDestroy() {
        if (this.zhf != null) {
            CropImageView cropImageView = this.zhf;
            if (!(cropImageView.mTJ == null || cropImageView.mTJ.isRecycled())) {
                x.i("MicroMsg.CropImageView", "recycle bitmap:%s", cropImageView.mTJ.toString());
                cropImageView.mTJ.recycle();
            }
        }
        if (this.zhd != null) {
            FilterImageView filterImageView = this.zhd;
            filterImageView.zic = null;
            if (!(filterImageView.zig == null || filterImageView.zig.isRecycled())) {
                x.i("MicroMsg.FilterView", "recycle bitmap:%s", filterImageView.zig.toString());
                filterImageView.zig.recycle();
            }
            filterImageView.zig = null;
        }
        super.onDestroy();
        x.appenderClose();
        Process.killProcess(Process.myPid());
    }

    protected final void initView() {
        setMMTitle("");
        this.zhe = (LinearLayout) findViewById(R.h.bZZ);
        this.zhg = (ImageView) findViewById(R.h.bZY);
        com.tencent.mm.platformtools.e.bC(this.zhg);
        this.zhh = findViewById(R.h.bZS);
        this.zhb = getIntent().getIntExtra("CropImageMode", 0);
        Assert.assertTrue("the image mode must be set", this.zhb != 0);
        this.kFm = getIntent().getIntExtra("CropImage_from_scene", 0);
        boolean booleanExtra = getIntent().getBooleanExtra("CropImage_Filter", false);
        boolean booleanExtra2 = getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false);
        if (booleanExtra) {
            b(new 22(this), new 23(this));
        }
        this.zhl = false;
        this.zhf = (CropImageView) findViewById(R.h.caa);
        com.tencent.mm.platformtools.e.bC(this.zhf);
        this.zhf.post(new Runnable(this) {
            final /* synthetic */ CropImageNewUI zhm;

            {
                this.zhm = r1;
            }

            public final void run() {
                if (!this.zhm.cxF()) {
                    return;
                }
                if (!this.zhm.zhj && !this.zhm.zhk && this.zhm.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
                    CropImageNewUI.d(this.zhm);
                    if (!this.zhm.getSharedPreferences(ac.cfs(), 0).getBoolean("CropImage_Filter_Show", true)) {
                        this.zhm.zhd.findViewById(R.h.bZP).setVisibility(4);
                    }
                } else if (1 == this.zhm.zhb) {
                    CropImageNewUI.g(this.zhm);
                }
            }
        });
        this.zhf.zhO = new CropImageView$a(this) {
            final /* synthetic */ CropImageNewUI zhm;

            {
                this.zhm = r1;
            }

            public final void cxH() {
                CropImageNewUI.h(this.zhm);
            }
        };
        ((Button) findViewById(R.h.cab)).setOnClickListener(new 4(this));
        Button button = (Button) findViewById(R.h.cac);
        button.setOnClickListener(new 5(this));
        Button button2 = (Button) findViewById(R.h.cad);
        button2.setOnClickListener(new 6(this));
        ak akVar = new ak(new 7(this), true);
        final ak akVar2 = new ak(new 8(this), true);
        button.setOnTouchListener(new 9(this, akVar));
        button2.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ CropImageNewUI zhm;

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        akVar2.J(200, 200);
                        break;
                    case 1:
                        akVar2.TG();
                        break;
                }
                return false;
            }
        });
        int i = R.l.dXQ;
        switch (this.zhb) {
            case 1:
                b(new 2(this), new 3(this));
                FilterImageView filterImageView = this.zhd;
                if (filterImageView.zif != null) {
                    filterImageView.zif.zhs = false;
                }
                filterImageView = this.zhd;
                if (filterImageView.zif != null) {
                    filterImageView.zif.setScaleType(ScaleType.MATRIX);
                    filterImageView.zif.cxI();
                }
                filterImageView = this.zhd;
                if (filterImageView.zie != null) {
                    filterImageView.zie.setVisibility(0);
                }
                if (this.kFm == 1) {
                    filterImageView = this.zhd;
                    int i2 = R.g.bEg;
                    if (filterImageView.zie != null) {
                        filterImageView.zie.setBackgroundResource(i2);
                        break;
                    }
                }
                break;
            case 2:
                this.zhf.zhP = false;
                findViewById(R.h.bZO).setVisibility(8);
                findViewById(R.h.bZU).setVisibility(8);
                break;
            case 3:
                this.zhe.setVisibility(8);
                break;
            case 5:
                int intExtra = getIntent().getIntExtra("CropImage_CompressType", 1);
                boolean booleanExtra3 = getIntent().getBooleanExtra("CropImage_BHasHD", false);
                if (intExtra != 1 && booleanExtra3) {
                    findViewById(R.h.bZU).setVisibility(0);
                    button = (Button) findViewById(R.h.bZV);
                    button.setBackgroundResource(R.g.bAf);
                    button.setPadding(25, 8, 25, 8);
                    button.setOnClickListener(new View.OnClickListener(this) {
                        final /* synthetic */ CropImageNewUI zhm;

                        {
                            this.zhm = r1;
                        }

                        public final void onClick(View view) {
                            CropImageNewUI.r(this.zhm);
                        }
                    });
                    break;
                }
                findViewById(R.h.bZU).setVisibility(8);
                break;
                break;
        }
        x.d("MicroMsg.CropImageUI", "mode is  " + this.zhb);
        OnMenuItemClickListener 17 = new 17(this, booleanExtra, booleanExtra2);
        if (this.zhb == 5) {
            addIconOptionMenu(0, R.g.bDI, 17);
        } else if (this.zhb == 4) {
            addIconOptionMenu(0, R.g.bDI, 17);
            findViewById(R.h.bZU).setVisibility(0);
            button = (Button) findViewById(R.h.bZV);
            button.setText(R.l.dXM);
            button.setOnClickListener(new 18(this));
        } else {
            a(0, getString(i), 17, p.b.xJz);
        }
        if (booleanExtra && booleanExtra2) {
            a(0, getString(R.l.dXM), 17, p.b.xJz);
        }
        setBackBtn(new 19(this));
        if (this.zhb == 6) {
            findViewById(R.h.bZU).setVisibility(8);
            a(0, getString(R.l.dXQ), new 20(this), p.b.xJz);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        x.d("MicroMsg.CropImageUI", "onConfigurationChanged, config.orientation = " + configuration.orientation);
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            x.v("MicroMsg.CropImageUI", "onConfigurationChanged");
            this.zhf.post(new 21(this));
        }
        super.onConfigurationChanged(configuration);
    }

    private boolean cxF() {
        View findViewById;
        if (1 != this.zhb) {
            findViewById = findViewById(R.h.bZR);
        } else if (this.zhd != null) {
            findViewById = this.zhd.zid;
        } else {
            findViewById = findViewById(R.h.bZS);
        }
        int width = findViewById.getWidth();
        int height = findViewById.getHeight();
        x.v("MicroMsg.CropImageUI", "scrWidth:" + width + " scrHeight:" + height);
        this.filePath = getIntent().getStringExtra("CropImage_ImgPath");
        if (FileOp.bO(this.filePath)) {
            boolean z;
            int i;
            Bitmap decodeFile;
            int i2;
            float f;
            int i3 = 960;
            int i4 = 960;
            if (this.zhb == 2) {
                z = true;
                i3 = height;
                i = width;
            } else if (this.zhb == 3) {
                Options options = new Options();
                options.inJustDecodeBounds = true;
                decodeFile = BitmapFactory.decodeFile(this.filePath, options);
                if (decodeFile != null) {
                    decodeFile.recycle();
                }
                int i5 = options.outWidth;
                i2 = options.outHeight;
                f = 1.0f;
                if (i5 <= 640 && i2 <= 640) {
                    i3 = i2;
                    i = i5;
                } else if (i5 > i2) {
                    f = ((float) i2) / ((float) i5);
                    i = 640;
                    i3 = (int) (((float) i2) * f);
                } else {
                    f = ((float) i5) / ((float) i2);
                    i3 = 640;
                    i = (int) (960.0f * f);
                }
                x.d("MicroMsg.CropImageUI", "w:%d h:%d width:%d height:%d scale:%f", Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i3), Float.valueOf(f));
                Button button = (Button) findViewById(R.h.bZV);
                if (button != null) {
                    button.setVisibility(8);
                }
                z = false;
            } else if (this.zhb == 1) {
                Options options2 = new Options();
                options2.inJustDecodeBounds = true;
                Bitmap decodeFile2 = BitmapFactory.decodeFile(this.filePath, options2);
                if (decodeFile2 != null) {
                    x.i("MicroMsg.CropImageUI", "recycle bitmap:%s", decodeFile2.toString());
                    decodeFile2.recycle();
                }
                if (options2.outWidth > options2.outHeight) {
                    i3 = (int) ((((double) (options2.outWidth * 960)) * 1.0d) / ((double) options2.outHeight));
                    if (i3 > 1920) {
                        i3 = 1920;
                    }
                } else {
                    i4 = (int) ((((double) (options2.outHeight * 960)) * 1.0d) / ((double) options2.outWidth));
                    if (i4 > 1920) {
                        i4 = 1920;
                    }
                }
                i = i3;
                i3 = i4;
                z = false;
            } else {
                Options options3 = new Options();
                options3.inJustDecodeBounds = true;
                d.c(options3);
                Bitmap decodeFile3 = BitmapFactory.decodeFile(this.filePath, options3);
                if (decodeFile3 != null) {
                    x.i("MicroMsg.CropImageUI", "recycle bitmap:%s", decodeFile3.toString());
                    decodeFile3.recycle();
                }
                boolean z2 = t.bt(options3.outWidth, options3.outHeight) && options3.outWidth > 480;
                this.zhj = z2;
                z2 = t.bs(options3.outWidth, options3.outHeight) && options3.outHeight > 480;
                this.zhk = z2;
                if (this.zhj || this.zhk) {
                    i4 = options3.outHeight;
                    i3 = options3.outWidth;
                }
                x.e("MicroMsg.CropImageUI", "width is " + i3 + " height is " + i4);
                i = i3;
                i3 = i4;
                z = false;
            }
            this.zhi = ExifHelper.UJ(this.filePath);
            if (this.zhi == 90 || this.zhi == 270) {
                int i6 = i;
                i = i3;
                i3 = i6;
            }
            decodeFile = d.d(this.filePath, i3, i, z);
            byte[] d = FileOp.d(this.filePath, 0, 10);
            if (com.tencent.mm.sdk.platformtools.p.bo(d)) {
                this.zhc = 1;
            } else {
                this.zhc = 0;
            }
            if (decodeFile == null) {
                finish();
                return false;
            }
            float height2;
            float f2;
            x.d("temBmp crop", "h:" + decodeFile.getHeight() + "w: " + decodeFile.getWidth());
            Bitmap b = d.b(decodeFile, (float) this.zhi);
            Matrix matrix = new Matrix();
            matrix.reset();
            float f3 = 1.0f;
            if (z) {
                f = ((float) b.getWidth()) / ((float) width);
                height2 = ((float) b.getHeight()) / ((float) height);
                f2 = f < height2 ? f : height2;
                f = width > height ? (float) height : (float) width;
                height2 = f / ((float) b.getWidth());
                f /= (float) b.getHeight();
                if (height2 > f) {
                    f = height2;
                }
                if (((double) f2) < 1.0d) {
                    matrix.postScale(f, f);
                }
            } else {
                f = ((float) b.getWidth()) / ((float) b.getHeight());
                f2 = ((float) b.getHeight()) / ((float) b.getWidth());
                x.v("MicroMsg.CropImageUI", "whDiv is " + f + " hwDiv is " + f2);
                if (f2 >= 2.0f && b.getHeight() >= 480) {
                    f2 = ((float) b.getWidth()) / ((float) width);
                    f = ((float) width) / ((float) b.getWidth());
                    if (1 == this.zhb) {
                        f2 = ((float) height) / ((float) b.getHeight());
                        if (f <= f2) {
                            f = f2;
                        }
                        matrix.postScale(f, f);
                        matrix.postTranslate(((((float) width) - (f * ((float) b.getWidth()))) / 2.0f) + ((float) findViewById.getLeft()), (float) findViewById.getTop());
                    } else if (((double) f2) > 1.0d) {
                        matrix.postScale(f, f);
                        b.getHeight();
                        matrix.postTranslate((((float) width) - (f * ((float) b.getWidth()))) / 2.0f, 0.0f);
                    } else {
                        matrix.postScale(1.0f, 1.0f);
                        if (3 == this.zhb) {
                            matrix.postTranslate((float) ((width - b.getWidth()) / 2), (float) ((height - b.getHeight()) / 2));
                        } else {
                            matrix.postTranslate((float) ((width - b.getWidth()) / 2), 0.0f);
                        }
                    }
                } else if (f < 2.0f || b.getWidth() < 480) {
                    f = ((float) width) / ((float) b.getWidth());
                    f2 = ((float) height) / ((float) b.getHeight());
                    float f4 = f < f2 ? f : f2;
                    if (f <= f2) {
                        f = f2;
                    }
                    if (1 == this.zhb) {
                        matrix.postScale(f, f);
                        matrix.postTranslate(((((float) width) - (((float) b.getWidth()) * f)) / 2.0f) + ((float) findViewById.getLeft()), ((((float) height) - (f * ((float) b.getHeight()))) / 2.0f) + ((float) findViewById.getTop()));
                    } else if (this.zhc == 1) {
                        CropImageView cropImageView = this.zhf;
                        String str = this.filePath;
                        try {
                            cropImageView.yfy = true;
                            cropImageView.yfz = c.fP(str, str);
                            cropImageView.setImageDrawable(cropImageView.yfz);
                        } catch (Exception e) {
                            cropImageView.yfy = false;
                        }
                        this.zhf.cxL();
                        this.zhf.cxM();
                        f = ((float) this.zhf.cxL()) / ((float) width);
                        height2 = ((float) this.zhf.cxM()) / ((float) height);
                        if (f <= height2) {
                            f = height2;
                        }
                        if (((double) f) > 1.0d) {
                            matrix.postScale(f, f);
                        } else {
                            f = 1.0f;
                        }
                        matrix.postTranslate((((float) width) - (((float) this.zhf.cxL()) * f)) / 2.0f, (((float) height) - (f * ((float) this.zhf.cxM()))) / 2.0f);
                    } else {
                        f = ((float) b.getWidth()) / ((float) width);
                        height2 = ((float) b.getHeight()) / ((float) height);
                        if (f <= height2) {
                            f = height2;
                        }
                        if (((double) f) > 1.0d) {
                            matrix.postScale(f4, f4);
                            f3 = f4;
                        }
                        matrix.postTranslate((((float) width) - (((float) b.getWidth()) * f3)) / 2.0f, (((float) height) - (((float) b.getHeight()) * f3)) / 2.0f);
                    }
                } else {
                    f = ((float) b.getHeight()) / 480.0f;
                    f2 = 480.0f / ((float) b.getHeight());
                    if (1 == this.zhb) {
                        f = ((float) width) / ((float) b.getWidth());
                        f2 = ((float) height) / ((float) b.getHeight());
                        if (f <= f2) {
                            f = f2;
                        }
                        matrix.postScale(f, f);
                        matrix.postTranslate(((((float) width) - (((float) b.getWidth()) * f)) / 2.0f) + ((float) findViewById.getLeft()), ((((float) height) - (f * ((float) b.getHeight()))) / 2.0f) + ((float) findViewById.getTop()));
                    } else if (((double) f) > 1.0d) {
                        matrix.postScale(f, f2);
                        matrix.postTranslate(0.0f, (float) ((height - 480) / 2));
                    } else {
                        matrix.postScale(1.0f, 1.0f);
                        f = (float) ((height - b.getHeight()) / 2);
                        x.d("MicroMsg.CropImageUI", " offsety " + f);
                        matrix.postTranslate(0.0f, f);
                    }
                }
            }
            if (1 == this.zhb) {
                if (this.zhd != null) {
                    FilterImageView filterImageView = this.zhd;
                    if (filterImageView.zif != null) {
                        filterImageView.zif.setImageMatrix(matrix);
                    }
                    this.zhd.zig = b;
                }
            } else if (this.zhc != 1) {
                this.zhf.setImageMatrix(matrix);
                this.zhf.setImageBitmap(b);
            }
            if (this.zhb == 3) {
                if (com.tencent.mm.sdk.platformtools.p.bo(d)) {
                    this.zhc = 1;
                    try {
                        Drawable cP = com.tencent.mm.plugin.gif.b.aSk().cP(this.filePath, this.filePath);
                        this.zhf.setImageDrawable(cP);
                        cP.start();
                        matrix.reset();
                        i2 = cP.getIntrinsicWidth();
                        i = cP.getIntrinsicHeight();
                        f = ((float) width) / ((float) i2);
                        height2 = ((float) height) / ((float) i);
                        f2 = f < height2 ? f : height2;
                        f = ((float) i2) / ((float) width);
                        height2 = ((float) i) / ((float) height);
                        if (f <= height2) {
                            f = height2;
                        }
                        if (((double) f) > 1.0d) {
                            matrix.postScale(f2, f2);
                            matrix.postTranslate((((float) width) - (((float) i2) * f2)) / 2.0f, (((float) height) - (f2 * ((float) i))) / 2.0f);
                        } else {
                            matrix.postTranslate((float) ((width - i2) / 2), (float) ((height - i) / 2));
                        }
                        this.zhf.setImageMatrix(matrix);
                    } catch (Throwable e2) {
                        x.e("MicroMsg.CropImageUI", bh.i(e2));
                    }
                } else {
                    this.zhc = 0;
                }
                return true;
            }
            if (this.zhj || this.zhk) {
                findViewById(R.h.cab).setVisibility(8);
            }
            if (getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
                findViewById(R.h.bZU).setVisibility(8);
            }
            return true;
        }
        finish();
        return false;
    }

    private void b(Runnable runnable, Runnable runnable2) {
        this.zhd = (FilterImageView) findViewById(R.h.bZQ);
        com.tencent.mm.platformtools.e.bC(this.zhd);
        this.zhd.zij = runnable;
        this.zhd.zik = runnable2;
    }

    private int[] cxG() {
        int i;
        DisplayMetrics displayMetrics;
        int i2;
        int max;
        int i3;
        int i4;
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i5 = rect.top;
        x.e("MicroMsg.CropImageUI", "window TitleBar.h:" + i5);
        if (i5 == 0) {
            try {
                Class cls = Class.forName("com.android.internal.R$dimen");
                i5 = getResources().getDimensionPixelSize(t.getInt(cls.getField("status_bar_height").get(cls.newInstance()).toString(), 0));
                x.e("MicroMsg.CropImageUI", "sbar:" + i5);
                i = i5;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.CropImageUI", e, "", new Object[0]);
            }
            displayMetrics = new DisplayMetrics();
            ((WindowManager) getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            i2 = (int) (((double) (67.0f * displayMetrics.density)) / 1.5d);
            i5 = Math.min(this.zhh.getWidth(), this.zhh.getHeight());
            max = Math.max(this.zhh.getWidth(), this.zhh.getHeight());
            i3 = max - (i2 * 2);
            i4 = (max + i) + i2;
            max = (i5 - (i2 * 2)) - i;
            if (this.zhi != 0) {
                i5 += i + (i2 * 2);
                i = max + i2;
            } else {
                i = max;
            }
            return new int[]{i5, i3, i, i4};
        }
        i = i5;
        displayMetrics = new DisplayMetrics();
        ((WindowManager) getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        i2 = (int) (((double) (67.0f * displayMetrics.density)) / 1.5d);
        i5 = Math.min(this.zhh.getWidth(), this.zhh.getHeight());
        max = Math.max(this.zhh.getWidth(), this.zhh.getHeight());
        i3 = max - (i2 * 2);
        i4 = (max + i) + i2;
        max = (i5 - (i2 * 2)) - i;
        if (this.zhi != 0) {
            i = max;
        } else {
            i5 += i + (i2 * 2);
            i = max + i2;
        }
        return new int[]{i5, i3, i, i4};
    }

    private Bitmap ff(int i, int i2) {
        Bitmap d = d.d(this.filePath, i2, i, true);
        if (this.zhi != 0) {
            Matrix matrix = new Matrix();
            matrix.reset();
            matrix.setRotate((float) this.zhi, (float) (d.getWidth() / 2), (float) (d.getHeight() / 2));
            Bitmap createBitmap = Bitmap.createBitmap(d, 0, 0, d.getWidth(), d.getHeight(), matrix, true);
            if (d != createBitmap) {
                x.i("MicroMsg.CropImageUI", "recycle bitmap:%s", d.toString());
                d.recycle();
            }
            d = createBitmap;
        }
        x.d("MicroMsg.CropImageUI", "getcrop degree:" + this.zhi);
        return d;
    }

    private static Bitmap a(float[][] fArr, float f, float f2, float f3, float f4, CropImageView cropImageView) {
        if (cropImageView == null) {
            return null;
        }
        float[] fArr2 = new float[]{f3, f4, 1.0f};
        float[] a = n.a(fArr, new float[]{f, f2, 1.0f});
        float[] a2 = n.a(fArr, fArr2);
        int min = (int) Math.min(a[0], a2[0]);
        int min2 = (int) Math.min(a[1], a2[1]);
        if (min < 0) {
            min = 0;
        }
        if (min2 < 0) {
            min2 = 0;
        }
        int abs = (int) Math.abs(a[0] - a2[0]);
        int abs2 = (int) Math.abs(a[1] - a2[1]);
        Matrix matrix = new Matrix();
        switch (cropImageView.fyR % 4) {
            case 0:
                matrix.setRotate(0.0f, (float) (abs / 2), (float) (abs2 / 2));
                break;
            case 1:
                matrix.setRotate(90.0f, (float) (abs / 2), (float) (abs2 / 2));
                break;
            case 2:
                matrix.setRotate(180.0f, (float) (abs / 2), (float) (abs2 / 2));
                break;
            case 3:
                matrix.setRotate(270.0f, (float) (abs / 2), (float) (abs2 / 2));
                break;
        }
        Bitmap bitmap = cropImageView.mTJ;
        if (min + abs > bitmap.getWidth()) {
            abs = bitmap.getWidth() - min;
        }
        if (min2 + abs2 > bitmap.getHeight()) {
            abs2 = bitmap.getHeight() - min2;
        }
        x.i("MicroMsg.CropImageUI", "rawWidth:%d, rawHeigth:%d, originalLX:%d, originalTY:%d, realWidth:%d, realHeight:%d", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(min), Integer.valueOf(min2), Integer.valueOf(abs), Integer.valueOf(abs2));
        return Bitmap.createBitmap(bitmap, min, min2, abs, abs2, matrix, true);
    }

    private boolean a(Bitmap bitmap, String str, boolean z) {
        if (!(str == null || str.equals(""))) {
            try {
                if (this.kFm == 1) {
                    d.a(bitmap, 30, CompressFormat.JPEG, str, z);
                    return true;
                }
                d.a(bitmap, 100, CompressFormat.PNG, str, z);
                return true;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.CropImageUI", e, "", new Object[0]);
                x.e("MicroMsg.CropImageUI", "saveBitmapToImage failed:" + e.toString());
            }
        }
        return false;
    }

    private static float[][] b(Matrix matrix) {
        float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, new int[]{3, 3});
        float[] fArr2 = new float[9];
        matrix.getValues(fArr2);
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                fArr[i][i2] = fArr2[(i * 3) + i2];
            }
        }
        return fArr;
    }
}
