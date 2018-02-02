package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ae.k;
import com.tencent.mm.aq.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.wallet_core.c.g;
import com.tencent.mm.plugin.wallet_core.c.j;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView.b.1;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.k.c;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.ado;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.protocal.c.th;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import d.a.a.a;
import d.a.a.b;
import d.a.a.f;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class WalletSuccPageAwardWidget extends FrameLayout {
    private static final String sYn = (e.bnF + "wallet/images/");
    private TextView iXX;
    private TextView inw;
    private Button kBV;
    private String lie;
    private b pNe;
    private boolean pYL = true;
    private boolean sIo;
    private CdnImageView sVd;
    private ViewGroup sYa;
    private ImageView sYe;
    private ImageView sYf;
    private WalletScratchShakeView sYg;
    private f sYh;
    private WalletBaseUI sYi;
    private boolean sYj = false;
    private boolean sYk = false;
    private boolean sYl = false;
    private a sYm = null;

    static /* synthetic */ byte[] L(Bitmap bitmap) {
        int i = 0;
        int[] iArr = new int[]{(bitmap.getWidth() / 2) - 3, (bitmap.getWidth() / 2) + 3};
        int[] iArr2 = new int[]{(bitmap.getHeight() / 2) - 3, (bitmap.getHeight() / 2) + 3};
        ByteBuffer order = ByteBuffer.allocate(84).order(ByteOrder.nativeOrder());
        order.put((byte) 1);
        order.put((byte) 2);
        order.put((byte) 2);
        order.put((byte) 9);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(0);
        order.putInt(iArr[0]);
        order.putInt(iArr[1]);
        order.putInt(iArr2[0]);
        order.putInt(iArr2[1]);
        while (i < 9) {
            order.putInt(1);
            i++;
        }
        return order.array();
    }

    static /* synthetic */ void a(WalletSuccPageAwardWidget walletSuccPageAwardWidget, int i, boolean z) {
        x.i("MicroMsg.WalletSuccPageAwardWidget", "doDrawLottery, is_query_other: %s", new Object[]{Integer.valueOf(walletSuccPageAwardWidget.pNe.Avf)});
        if (walletSuccPageAwardWidget.pNe.Avf != 0) {
            walletSuccPageAwardWidget.sYi.b(new g(walletSuccPageAwardWidget.pNe.vZA, i, walletSuccPageAwardWidget.sIo), z);
        }
    }

    static /* synthetic */ void bNf() {
    }

    static /* synthetic */ void e(WalletSuccPageAwardWidget walletSuccPageAwardWidget) {
        boolean z = walletSuccPageAwardWidget.pNe.Avg == 1 || walletSuccPageAwardWidget.pNe.Avg == 3;
        boolean z2 = walletSuccPageAwardWidget.pNe.Avg == 2 || walletSuccPageAwardWidget.pNe.Avg == 3;
        x.i("MicroMsg.WalletSuccPageAwardWidget", "initScratchShakeView, canScratch: %s, canShrake: %s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(walletSuccPageAwardWidget.getContext(), 50);
        WalletScratchShakeView walletScratchShakeView = walletSuccPageAwardWidget.sYg;
        float f = (float) fromDPToPix;
        fromDPToPix /= 2;
        x.i("MicroMsg.WalletScratchShakeView", "init canShake: %s, canScratch: %s", new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z)});
        walletScratchShakeView.sXC = z;
        walletScratchShakeView.sXB = z2;
        if (walletScratchShakeView.sXA != null) {
            walletScratchShakeView.removeView(walletScratchShakeView.sXA);
            walletScratchShakeView.sXA = null;
        }
        walletScratchShakeView.sXA = new WalletScratchShakeView.b(walletScratchShakeView, walletScratchShakeView.getContext());
        walletScratchShakeView.addView(walletScratchShakeView.sXA, new LayoutParams(-1, -1));
        WalletScratchShakeView.b bVar = walletScratchShakeView.sXA;
        x.i("MicroMsg.WalletScratchShakeView", "init inner view");
        bVar.sXF = new Paint();
        bVar.sXF.setAntiAlias(true);
        bVar.sXF.setDither(true);
        Bitmap decodeResource = BitmapFactory.decodeResource(bVar.getResources(), com.tencent.mm.plugin.wxpay.a.e.udX);
        bVar.sXG = new NinePatchDrawable(bVar.getResources(), new NinePatch(decodeResource, WalletScratchShakeView.b.K(decodeResource), "shake_bg"));
        bVar.sXH = new Paint();
        bVar.sXH.setAntiAlias(true);
        bVar.sXH.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        bVar.sXH.setStyle(Style.STROKE);
        bVar.sXH.setStrokeCap(Cap.ROUND);
        bVar.sXH.setStrokeWidth(f);
        bVar.sXI = new Paint();
        bVar.sXI.setAntiAlias(true);
        bVar.sXI.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
        bVar.sXI.setStyle(Style.FILL);
        bVar.sXI.setStrokeCap(Cap.ROUND);
        bVar.sXJ = new Path();
        bVar.sXK = new Path();
        bVar.sXS = 0.0f;
        bVar.sXR = 0.0f;
        bVar.nmE = ViewConfiguration.get(bVar.getContext()).getScaledTouchSlop();
        bVar.sXP = false;
        bVar.sXQ = false;
        bVar.sXT = fromDPToPix;
        if (bVar.sXY.sXB) {
            bVar.oNJ = new c(bVar.getContext());
            bVar.oNJ.a(new 1(bVar));
            bVar.kCU = bh.Wq();
        }
        bVar.invalidate();
        walletScratchShakeView.setClipChildren(false);
        walletSuccPageAwardWidget.sYg.sXD = new 6(walletSuccPageAwardWidget);
    }

    public static boolean a(b bVar) {
        return (bVar == null || bVar.wbt == null || bVar.wbt.size() <= 0) ? false : true;
    }

    public WalletSuccPageAwardWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public WalletSuccPageAwardWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        v.fv(context).inflate(com.tencent.mm.plugin.wxpay.a.g.uFS, this, true);
        this.sYa = (ViewGroup) findViewById(com.tencent.mm.plugin.wxpay.a.f.bYO);
        this.sVd = (CdnImageView) findViewById(com.tencent.mm.plugin.wxpay.a.f.ulU);
        this.inw = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.cyB);
        this.iXX = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.caS);
        this.kBV = (Button) findViewById(com.tencent.mm.plugin.wxpay.a.f.button);
        this.sYg = (WalletScratchShakeView) findViewById(com.tencent.mm.plugin.wxpay.a.f.uwq);
        this.sYe = (ImageView) findViewById(com.tencent.mm.plugin.wxpay.a.f.background);
        this.sVd.vnf = true;
        this.sVd.vng = true;
    }

    public final void a(WalletBaseUI walletBaseUI, b bVar, String str, boolean z, ImageView imageView) {
        boolean z2 = true;
        String str2 = "MicroMsg.WalletSuccPageAwardWidget";
        String str3 = "setWidgetData, exposureInfo: %s, layerInfo==null: %s, hostUIBackgroundView==null:%s, isClickH5OrTinyApp: %s, isF2F: %s";
        Object[] objArr = new Object[5];
        objArr[0] = b(bVar);
        boolean z3 = bVar == null || bVar.Avi == null;
        objArr[1] = Boolean.valueOf(z3);
        if (imageView != null) {
            z2 = false;
        }
        objArr[2] = Boolean.valueOf(z2);
        objArr[3] = Boolean.valueOf(this.sYj);
        objArr[4] = Boolean.valueOf(z);
        x.i(str2, str3, objArr);
        this.sYi = walletBaseUI;
        this.pNe = bVar;
        this.sIo = z;
        this.lie = str;
        this.sYf = imageView;
        bNc();
    }

    private void bNc() {
        int i = 2;
        x.i("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, exposureInfo: %s, isFirstShow: %s", new Object[]{b(this.pNe), Boolean.valueOf(this.pYL)});
        if (this.pNe == null) {
            x.e("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, exposureInfo is null!");
            return;
        }
        x.k("MicroMsg.WalletSuccPageAwardWidget", "setViewByData, user_operation_type: %s, single_exposure_info_list size: %s, isClickH5OrTinyApp: %s", new Object[]{Integer.valueOf(this.pNe.Avg), Integer.valueOf(this.pNe.wbt.size()), Boolean.valueOf(this.sYj)});
        if (this.pNe.Avg > 0 && this.pNe.Avg <= 4 && this.pNe.wbt != null && this.pNe.wbt.size() > 0) {
            if (this.pNe.Avg == 4) {
                bNe();
                if (this.sYg.getVisibility() != 8) {
                    this.sYg.setVisibility(8);
                }
            } else {
                bNe();
                if (this.sYg.getVisibility() != 0) {
                    this.sYg.setVisibility(0);
                    this.sYg.post(new 2(this));
                }
            }
            if (!bh.ov(this.pNe.Avj)) {
                x.i("MicroMsg.WalletSuccPageAwardWidget", "background_img_whole: %s", new Object[]{this.pNe.Avj});
                if (this.sYf != null) {
                    this.sYf.setVisibility(0);
                    com.tencent.mm.aq.a.a.c.a aVar = new com.tencent.mm.aq.a.a.c.a();
                    aVar.hDA = true;
                    aVar.hDz = true;
                    aVar.hDC = Nv(this.pNe.Avj);
                    o.PA().a(this.pNe.Avj, null, aVar.PK(), new 1(this));
                }
            }
            if (this.pYL || this.sYj) {
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(3);
                if (!this.sYj) {
                    i = 1;
                }
                objArr[1] = Integer.valueOf(i);
                gVar.h(15225, objArr);
            }
            this.pYL = false;
        }
    }

    private void bNd() {
        x.i("MicroMsg.WalletSuccPageAwardWidget", "showNetFailedView");
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.inw.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iXX.getLayoutParams();
        layoutParams.addRule(15, -1);
        layoutParams2.addRule(15, 0);
        this.inw.setLayoutParams(layoutParams);
        this.iXX.setLayoutParams(layoutParams2);
        this.inw.setVisibility(0);
        this.iXX.setVisibility(8);
        this.inw.setText(i.uWR);
        this.inw.setTextColor(Color.parseColor("#353535"));
        this.iXX.setTextColor(Color.parseColor("#B2B2B2"));
        this.sYe.setVisibility(8);
        findViewById(com.tencent.mm.plugin.wxpay.a.f.usk).setVisibility(0);
        findViewById(com.tencent.mm.plugin.wxpay.a.f.usl).setVisibility(0);
        this.kBV.setVisibility(8);
        this.sVd.setVisibility(0);
        this.sVd.setImageResource(com.tencent.mm.plugin.wxpay.a.e.udV);
    }

    public final void init() {
        if (this.sYi != null) {
            x.i("MicroMsg.WalletSuccPageAwardWidget", "init");
            this.sYi.ji(1859);
            this.sYi.ji(2547);
            this.sYi.ji(2803);
            this.sYi.ji(2508);
            this.sYi.ji(2529);
            this.sYi.ji(2888);
        }
    }

    public final void onDestroy() {
        int i = 2;
        if (this.sYi != null) {
            this.sYi.jj(1859);
            this.sYi.jj(2547);
            this.sYi.jj(2803);
            this.sYi.jj(2508);
            this.sYi.jj(2529);
            this.sYi.jj(2888);
            x.i("MicroMsg.WalletSuccPageAwardWidget", "onDestroy, isShakeOrScratch: %s, isClickAwardButton: %s", new Object[]{Boolean.valueOf(this.sYk), Boolean.valueOf(this.sYl)});
            if (!(this.sYk || this.sYl)) {
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(6);
                if (!this.sYj) {
                    i = 1;
                }
                objArr[1] = Integer.valueOf(i);
                gVar.h(15225, objArr);
                x.i("MicroMsg.WalletSuccPageAwardWidget", "user do nothing and quit ui, call drawlottery");
                this.sYi.b(new g(this.pNe.vZA, 4, this.sIo), false);
            }
        }
        if (this.sYg != null) {
            WalletScratchShakeView walletScratchShakeView = this.sYg;
            if (walletScratchShakeView.sXA != null) {
                WalletScratchShakeView.b bVar = walletScratchShakeView.sXA;
                x.i("MicroMsg.WalletScratchShakeView", "onDestroy");
                if (bVar.oNJ != null) {
                    bVar.oNJ.aPV();
                }
            }
        }
    }

    public final void onResume() {
        x.i("MicroMsg.WalletSuccPageAwardWidget", "tryDoModifyExposure, isClickH5OrTinyApp: %s", new Object[]{Boolean.valueOf(this.sYj)});
        if (this.sYj) {
            this.sYi.b(new j(this.pNe.wbs, this.sIo), false);
        }
    }

    private static String Nv(String str) {
        if (bh.G(new String[0])) {
            return null;
        }
        FileOp.mh(sYn);
        x.i("MicroMsg.WalletSuccPageAwardWidget", "buildImagePathByUrl, url: %s, path: %s", new Object[]{str, sYn + com.tencent.xweb.util.c.s(str.getBytes())});
        return sYn + com.tencent.xweb.util.c.s(str.getBytes());
    }

    private void bNe() {
        List list = this.pNe.wbt;
        if (list != null && list.size() > 0) {
            boolean z;
            this.sYh = (f) list.get(0);
            x.i("MicroMsg.WalletSuccPageAwardWidget", "singleExposureInfo %s, award_name: %s, award_description: %s, logo: %s", new Object[]{Integer.valueOf(0), this.sYh.Avt, this.sYh.Avu, this.sYh.peY});
            this.sVd.setUrl(this.sYh.peY);
            if (!bh.ov(this.sYh.peY)) {
                this.sVd.setVisibility(0);
            }
            if (bh.ov(this.sYh.Avt)) {
                z = false;
            } else {
                this.inw.setText(this.sYh.Avt);
                this.inw.setVisibility(0);
                try {
                    if (!bh.ov(this.sYh.Avw)) {
                        this.inw.setTextColor(Color.parseColor(this.sYh.Avw));
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", e, "parse award_name_color error: %s", new Object[]{e.getMessage()});
                }
                z = true;
            }
            if (!bh.ov(this.sYh.Avu)) {
                this.iXX.setText(this.sYh.Avu);
                this.iXX.setVisibility(0);
                try {
                    if (!bh.ov(this.sYh.Avx)) {
                        this.iXX.setTextColor(Color.parseColor(this.sYh.Avx));
                    }
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.WalletSuccPageAwardWidget", e2, "parse award_description_color error: %s", new Object[]{e2.getMessage()});
                }
                z = true;
            }
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.inw.getLayoutParams();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iXX.getLayoutParams();
                if (!bh.ov(this.sYh.Avt) && bh.ov(this.sYh.Avu)) {
                    layoutParams.addRule(15, -1);
                    layoutParams2.addRule(15, 0);
                    this.inw.setLayoutParams(layoutParams);
                    this.iXX.setLayoutParams(layoutParams2);
                    this.inw.setVisibility(0);
                    this.iXX.setVisibility(8);
                } else if (!bh.ov(this.sYh.Avt) || bh.ov(this.sYh.Avu)) {
                    layoutParams.addRule(15, 0);
                    layoutParams2.addRule(15, 0);
                    this.inw.setLayoutParams(layoutParams);
                    this.iXX.setLayoutParams(layoutParams2);
                    this.inw.setVisibility(0);
                    this.iXX.setVisibility(0);
                } else {
                    layoutParams.addRule(15, 0);
                    layoutParams2.addRule(15, -1);
                    this.inw.setLayoutParams(layoutParams);
                    this.iXX.setLayoutParams(layoutParams2);
                    this.inw.setVisibility(8);
                    this.iXX.setVisibility(0);
                }
            }
            if (bh.ov(this.sYh.Avv)) {
                this.sYe.setVisibility(8);
                findViewById(com.tencent.mm.plugin.wxpay.a.f.usk).setVisibility(0);
                findViewById(com.tencent.mm.plugin.wxpay.a.f.usl).setVisibility(0);
            } else {
                x.i("MicroMsg.WalletSuccPageAwardWidget", "background_img: %s", new Object[]{this.sYh.Avv});
                com.tencent.mm.aq.a.a.c.a aVar = new com.tencent.mm.aq.a.a.c.a();
                aVar.hDA = true;
                aVar.hDz = true;
                aVar.hDC = Nv(this.sYh.Avv);
                o.PA().a(this.sYh.Avv, null, aVar.PK(), new 3(this));
            }
        }
        String str = "MicroMsg.WalletSuccPageAwardWidget";
        String str2 = "is_show_btn: %s, btn_info: %s, btn_words: %s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.pNe.wbu);
        objArr[1] = this.pNe.wbv;
        objArr[2] = this.pNe.wbv != null ? this.pNe.wbv.Avb : "";
        x.i(str, str2, objArr);
        if (this.pNe.wbu == 0 || this.pNe.wbv == null || bh.ov(this.pNe.wbv.Avb)) {
            this.kBV.setVisibility(8);
        } else {
            a aVar2 = this.pNe.wbv;
            if (aVar2 != null) {
                x.i("MicroMsg.WalletSuccPageAwardWidget", "btn_words: %s, type: %s, color: %s, url: %s", new Object[]{aVar2.Avb, Integer.valueOf(aVar2.Avd), aVar2.Avc, aVar2.url});
                this.kBV.setText(aVar2.Avb);
                if (!bh.ov(aVar2.Avc)) {
                    Drawable drawable = getContext().getResources().getDrawable(com.tencent.mm.plugin.wxpay.a.e.bAb);
                    drawable.setColorFilter(Color.parseColor(aVar2.Avc), Mode.SRC);
                    this.kBV.setBackground(drawable);
                }
                this.kBV.setOnClickListener(new 4(this));
                this.kBV.setVisibility(0);
                if (this.pYL || this.sYj) {
                    com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(1);
                    objArr[1] = Integer.valueOf(this.sYj ? 2 : 1);
                    gVar.h(15225, objArr);
                }
            }
        }
        if (this.inw.getVisibility() == 0) {
            this.inw.post(new Runnable(this) {
                final /* synthetic */ WalletSuccPageAwardWidget sYo;

                {
                    this.sYo = r1;
                }

                public final void run() {
                    if (this.sYo.kBV.getVisibility() == 0 && this.sYo.inw.getRight() >= this.sYo.kBV.getLeft() && !bh.M(this.sYo.inw.getText())) {
                        float textSize = this.sYo.inw.getTextSize();
                        x.i("MicroMsg.WalletSuccPageAwardWidget", "nameTv size exceed, nameTv.getRight(): %s, button.getLeft(): %s", new Object[]{Integer.valueOf(this.sYo.inw.getRight()), Integer.valueOf(this.sYo.kBV.getLeft())});
                        Paint paint = new Paint();
                        paint.setTextSize(textSize);
                        String charSequence = this.sYo.inw.getText().toString();
                        float measureText = paint.measureText(charSequence) - ((float) (this.sYo.inw.getRight() - this.sYo.kBV.getLeft()));
                        int i = 1;
                        while (paint.measureText(charSequence.substring(0, (charSequence.length() - i) - 1)) > measureText && i <= charSequence.length() - 1) {
                            i++;
                        }
                        x.i("MicroMsg.WalletSuccPageAwardWidget", "nameTv, exceed len, final search count: %s, text.length: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(charSequence.length())});
                        CharSequence substring = charSequence.substring(0, (charSequence.length() - i) - 1);
                        if (charSequence.length() > 9 && substring.length() < 9) {
                            substring = charSequence.substring(0, 10);
                        }
                        this.sYo.inw.setText(substring);
                        this.sYo.inw.append("...");
                    }
                }
            });
        }
        if (this.kBV.getVisibility() == 0) {
            CharSequence text = this.inw.getText();
            if (!bh.M(text) && text.length() > 9) {
                this.inw.setText(text.subSequence(0, 9));
                this.inw.append("...");
            }
        } else {
            this.inw.setEllipsize(TruncateAt.END);
        }
        if (this.pNe.Avh != 0) {
            x.i("MicroMsg.WalletSuccPageAwardWidget", "exposureInfo.is_show_layer is true: %s, direct show layer", new Object[]{Integer.valueOf(this.pNe.Avh)});
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        int i3 = 0;
        x.i("MicroMsg.WalletSuccPageAwardWidget", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, kVar});
        int i4;
        if (kVar instanceof com.tencent.mm.plugin.wallet_core.c.i) {
            com.tencent.mm.plugin.wallet_core.c.i iVar = (com.tencent.mm.plugin.wallet_core.c.i) kVar;
            if (i == 0 && i2 == 0) {
                ado com_tencent_mm_protocal_c_ado = iVar.sIt;
                if (com_tencent_mm_protocal_c_ado == null) {
                    x.e("MicroMsg.WalletSuccPageAwardWidget", "getLottery end, response is null!!");
                    return true;
                }
                x.i("MicroMsg.WalletSuccPageAwardWidget", "getLottery ret_code: %s, ret_msg: %s, alert_wording: %s, exposure_info: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_ado.kLO), com_tencent_mm_protocal_c_ado.kLP, com_tencent_mm_protocal_c_ado.wiF, com_tencent_mm_protocal_c_ado.sOJ});
                if (com_tencent_mm_protocal_c_ado.kLO != 0) {
                    x.i("MicroMsg.WalletSuccPageAwardWidget", "getLotteryFailed");
                } else if (bh.ov(com_tencent_mm_protocal_c_ado.wiF)) {
                    if (com_tencent_mm_protocal_c_ado.sOJ != null) {
                        i4 = this.pNe.wbv != null ? this.pNe.wbv.Avd : 0;
                        this.pNe = com_tencent_mm_protocal_c_ado.sOJ;
                        if (!(com_tencent_mm_protocal_c_ado.sOJ.wbv == null || this.pNe.wbv == null)) {
                            x.i("MicroMsg.WalletSuccPageAwardWidget", "getLottery end, btn_op_type: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_ado.sOJ.wbv.Avd)});
                            if (com_tencent_mm_protocal_c_ado.sOJ.wbv.Avd == 4) {
                                x.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
                                this.pNe.wbv.Avd = i4;
                            }
                        }
                        x.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo");
                        bNc();
                    }
                    if (this.sYm != null && this.sYl) {
                        if (this.sYm.Avd == 8) {
                            x.i("MicroMsg.WalletSuccPageAwardWidget", "on getLotteryEnd, btn_op_type==GET_LOTTERY_AND_JUMP_URL, goto h5");
                            com.tencent.mm.wallet_core.ui.e.l(this.sYi, this.sYm.url, false);
                            this.sYj = true;
                        } else if (this.sYm.Avd == 9) {
                            d.a.a.e eVar = this.sYm.Ave;
                            if (eVar != null) {
                                x.i("MicroMsg.WalletSuccPageAwardWidget", "on getLotteryEnd, btn_op_type==GET_LOTTERY_AND_JUMP_MINI_APP, jump tiny app, userName: %s, path: %s, version: %s", new Object[]{eVar.wDr, eVar.wDs, Integer.valueOf(eVar.wDt)});
                                com.tencent.mm.sdk.b.b qpVar = new qp();
                                qpVar.fIi.userName = eVar.wDr;
                                qpVar.fIi.fIk = bh.az(eVar.wDs, "");
                                qpVar.fIi.scene = 1060;
                                qpVar.fIi.fnp = this.lie;
                                qpVar.fIi.fIl = 0;
                                if (eVar.wDt > 0) {
                                    qpVar.fIi.fIm = eVar.wDt;
                                }
                                qpVar.fIi.context = this.sYi;
                                com.tencent.mm.sdk.b.a.xef.m(qpVar);
                                this.sYj = true;
                            }
                        }
                    }
                    this.sYm = null;
                    return true;
                } else {
                    Toast.makeText(getContext(), com_tencent_mm_protocal_c_ado.wiF, 1).show();
                    return true;
                }
            }
            bNd();
            return true;
        } else if (kVar instanceof j) {
            j jVar = (j) kVar;
            if (i == 0 && i2 == 0) {
                th thVar = jVar.sIv;
                if (thVar == null) {
                    x.e("MicroMsg.WalletSuccPageAwardWidget", "modifyExposure end, response is null!!");
                    return true;
                }
                r4 = "MicroMsg.WalletSuccPageAwardWidget";
                r5 = "modifyExposure, ret_code: %s, ret_msg: %s, single_exposure_info_list: %s, is_show_btn: %s, btn_info: %s, btn_op_type: %s";
                r6 = new Object[6];
                r6[0] = Integer.valueOf(thVar.kLO);
                r6[1] = thVar.kLP;
                r6[2] = thVar.wbt;
                r6[3] = Integer.valueOf(thVar.wbu);
                r6[4] = thVar.wbv;
                r6[5] = Integer.valueOf(thVar.wbv != null ? thVar.wbv.Avd : 0);
                x.i(r4, r5, r6);
                if (thVar.kLO == 0) {
                    this.pNe.wbt = thVar.wbt;
                    this.pNe.wbu = thVar.wbu;
                    if (this.pNe.wbv != null) {
                        i4 = this.pNe.wbv.Avd;
                    } else {
                        i4 = 0;
                    }
                    if (thVar.wbv != null) {
                        this.pNe.wbv = thVar.wbv;
                        if (this.pNe.wbv != null && thVar.wbv.Avd == 4) {
                            x.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
                            this.pNe.wbv.Avd = i4;
                        }
                    }
                    x.i("MicroMsg.WalletSuccPageAwardWidget", "after modify, exposureInfo: %s", new Object[]{b(this.pNe)});
                    bNe();
                }
            }
            this.sYj = false;
            return true;
        } else if (!(kVar instanceof g)) {
            return false;
        } else {
            g gVar = (g) kVar;
            if (i == 0 && i2 == 0) {
                rp rpVar = gVar.sIn;
                if (rpVar == null) {
                    x.e("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, response is null!!");
                    return true;
                }
                x.i("MicroMsg.WalletSuccPageAwardWidget", "drawLottery end, retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(rpVar.kLO), rpVar.kLP});
                if (rpVar.sOJ != null) {
                    r4 = "MicroMsg.WalletSuccPageAwardWidget";
                    r5 = "drawLottery end, exposureInfo: %s, btninfo: %s, btn_op_type: %s";
                    r6 = new Object[3];
                    r6[0] = rpVar.sOJ;
                    r6[1] = rpVar.sOJ.wbv;
                    r6[2] = Integer.valueOf(rpVar.sOJ.wbv != null ? rpVar.sOJ.wbv.Avd : 0);
                    x.i(r4, r5, r6);
                    if (this.pNe.wbv != null) {
                        i3 = this.pNe.wbv.Avd;
                    }
                    this.pNe = rpVar.sOJ;
                    if (!(this.pNe.wbv == null || rpVar.sOJ.wbv == null || rpVar.sOJ.wbv.Avd != 4)) {
                        x.i("MicroMsg.WalletSuccPageAwardWidget", "update exposureInfo, new btn_op_type is 4");
                        this.pNe.wbv.Avd = i3;
                    }
                    bNc();
                }
            } else {
                bNd();
            }
            return true;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.sYg != null) {
            WalletScratchShakeView walletScratchShakeView = this.sYg;
            if (walletScratchShakeView.sXA != null ? walletScratchShakeView.sXA.E(motionEvent) : false) {
                walletScratchShakeView = this.sYg;
            } else {
                walletScratchShakeView = this.sYg;
            }
            if (!(walletScratchShakeView.sXA != null ? walletScratchShakeView.sXA.sXW : true)) {
                z = this.sYg.dispatchTouchEvent(motionEvent);
            }
        }
        if (this.sYa == null || r0) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return this.sYa.dispatchTouchEvent(motionEvent);
    }

    private static String b(b bVar) {
        if (bVar == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (bVar.wbt != null && bVar.wbt.size() > 0) {
                Iterator it = bVar.wbt.iterator();
                while (it.hasNext()) {
                    f fVar = (f) it.next();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("logo", fVar.peY);
                    jSONObject2.put("award_name", fVar.Avt);
                    jSONObject2.put("award_description", fVar.Avu);
                    jSONObject2.put("background_img", fVar.Avv);
                    jSONObject2.put("award_name_color", fVar.Avw);
                    jSONObject2.put("award_description_color", fVar.Avx);
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("single_exposure_info_list", jSONArray);
            jSONObject.put("is_query_others", bVar.Avf);
            jSONObject.put("draw_lottery_params", bVar.vZA);
            jSONObject.put("is_show_btn", bVar.wbu);
            JSONObject jSONObject3 = new JSONObject();
            if (bVar.wbv != null) {
                jSONObject3.put("btn_words", bVar.wbv.Avb);
                jSONObject3.put("btn_color", bVar.wbv.Avc);
                jSONObject3.put("btn_op_type", bVar.wbv.Avd);
                jSONObject3.put(SlookSmartClipMetaTag.TAG_TYPE_URL, bVar.wbv.url);
                JSONObject jSONObject4 = new JSONObject();
                if (bVar.wbv.Ave != null) {
                    jSONObject4.put("activity_tinyapp_username", bVar.wbv.Ave.wDr);
                    jSONObject4.put("activity_tinyapp_path", bVar.wbv.Ave.wDs);
                    jSONObject4.put("activity_tinyapp_version", bVar.wbv.Ave.wDt);
                }
                jSONObject3.put("mini_app_info", jSONObject4);
                jSONObject3.put("get_lottery_params", bVar.wbv.wme);
            }
            jSONObject.put("btn_info", jSONObject3);
            jSONObject.put("exposure_info_modify_params", bVar.wbs);
            jSONObject.put("user_opertaion_type", bVar.Avg);
            jSONObject.put("is_show_layer", bVar.Avh);
            jSONObject.put("background_img_whole", bVar.Avj);
            return jSONObject.toString();
        } catch (Exception e) {
            return "";
        }
    }
}
