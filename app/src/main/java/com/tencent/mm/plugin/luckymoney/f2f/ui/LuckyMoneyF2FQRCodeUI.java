package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.luckymoney.b.m;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.luckymoney.b.v;
import com.tencent.mm.plugin.luckymoney.f2f.a.1;
import com.tencent.mm.plugin.luckymoney.f2f.a.2;
import com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.6;
import com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.c;
import com.tencent.mm.plugin.luckymoney.particles.b;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.HorizontalListViewV2;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.widget.g;
import com.tencent.qbar.QbarNative;
import com.tencent.wcdb.FileUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

@com.tencent.mm.ui.base.a(1)
public class LuckyMoneyF2FQRCodeUI extends LuckyMoneyBaseUI implements com.tencent.mm.sdk.platformtools.av.a {
    private View Lr;
    private SensorManager bgR;
    private ak iZb;
    private DisplayMetrics icn;
    private TextView iiq;
    private g jLx;
    private String lOX;
    private d llU = new 10(this);
    private Bitmap mBitmap;
    private ImageView nZA;
    private TextView nZB;
    private TextView nZC;
    private HorizontalListViewV2 nZD;
    private List<String> nZE;
    private Map<String, String> nZF;
    private Queue<Pair<String, Integer>> nZG;
    private a nZH;
    private TextView nZI;
    private Button nZJ;
    private View nZK;
    private View nZL;
    private ShuffleView nZM;
    private c nZN;
    private List<View> nZO;
    private ViewGroup nZP;
    private ViewGroup nZQ;
    private View nZR;
    private com.tencent.mm.plugin.luckymoney.f2f.a nZS;
    private long nZT;
    private String nZU;
    private ValueAnimator nZV;
    private float nZW;
    private float nZX;
    private float nZY;
    private int[] nZZ;
    private String nZa;
    private String nZq;
    private int nZr;
    private View nZv;
    private View nZw;
    private ImageView nZx;
    private TextView nZy;
    private TextView nZz;
    private com.tencent.mm.z.bs.a oaa = new 1(this);
    private p.c oab = new 9(this);
    private Bitmap oac;
    private Bitmap oad;
    private Bitmap oae;
    private Bitmap oaf;
    private Bitmap oag;
    private Bitmap oah;
    private Bitmap oai;
    private Bitmap oaj;
    private Bitmap oak;
    private Bitmap oal;
    private Bitmap oam;
    private Bitmap oan;
    private b oao = new b(this) {
        final /* synthetic */ LuckyMoneyF2FQRCodeUI oar;

        {
            this.oar = r1;
        }

        public final com.tencent.mm.plugin.luckymoney.particles.a.b b(Random random) {
            int nextInt = random.nextInt(100);
            if (nextInt < 16) {
                if (this.oar.oaf == null) {
                    this.oar.oaf = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.oar.getResources(), e.ucT), 36, 36, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(this.oar.oaf);
            } else if (nextInt < 33) {
                if (this.oar.oag == null) {
                    this.oar.oag = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.oar.getResources(), e.ucU), 36, 36, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(this.oar.oag);
            } else if (nextInt < 50) {
                if (this.oar.oah == null) {
                    this.oar.oah = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.oar.getResources(), e.ucV), 36, 36, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(this.oar.oah);
            } else if (nextInt < 70) {
                if (this.oar.oac == null) {
                    this.oar.oac = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.oar.getResources(), e.ucO), 36, 36, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(this.oar.oac);
            } else if (nextInt < 90) {
                if (this.oar.oad == null) {
                    this.oar.oad = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.oar.getResources(), e.ucP), 36, 36, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(this.oar.oad);
            } else {
                if (this.oar.oae == null) {
                    this.oar.oae = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.oar.getResources(), e.ucQ), 36, 36, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(this.oar.oae);
            }
        }
    };
    private b oap = new b(this) {
        final /* synthetic */ LuckyMoneyF2FQRCodeUI oar;

        {
            this.oar = r1;
        }

        public final com.tencent.mm.plugin.luckymoney.particles.a.b b(Random random) {
            int nextInt = random.nextInt(100);
            if (nextInt < 10) {
                if (this.oar.oal == null) {
                    this.oar.oal = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.oar.getResources(), e.ucT), 32, 32, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(this.oar.oal);
            } else if (nextInt < 20) {
                if (this.oar.oam == null) {
                    this.oar.oam = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.oar.getResources(), e.ucU), 32, 32, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(this.oar.oam);
            } else if (nextInt < 30) {
                if (this.oar.oan == null) {
                    this.oar.oan = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.oar.getResources(), e.ucV), 32, 32, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(this.oar.oan);
            } else if (nextInt < 50) {
                if (this.oar.oai == null) {
                    this.oar.oai = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.oar.getResources(), e.ucO), 32, 32, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(this.oar.oai);
            } else if (nextInt < 75) {
                if (this.oar.oaj == null) {
                    this.oar.oaj = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.oar.getResources(), e.ucP), 32, 32, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(this.oar.oaj);
            } else {
                if (this.oar.oak == null) {
                    this.oar.oak = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(this.oar.getResources(), e.ucQ), 32, 32, false);
                }
                return new com.tencent.mm.plugin.luckymoney.particles.a.a(this.oar.oak);
            }
        }
    };
    final SensorEventListener oaq = new SensorEventListener(this) {
        float kCe;
        final /* synthetic */ LuckyMoneyF2FQRCodeUI oar;
        final int oav = 3;
        float oaw = ((float) com.tencent.mm.bv.a.aa(ac.getContext(), com.tencent.mm.plugin.wxpay.a.d.bvB));
        int oax;
        ValueAnimator oay;

        {
            this.oar = r3;
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            float f = -3.0f;
            if (sensorEvent.sensor.getType() == 1 && this.oar.nZr > 0) {
                if (this.oax == 0) {
                    this.oax = com.tencent.mm.pluginsdk.e.ci(this.oar) + ((int) this.oaw);
                }
                float f2 = sensorEvent.values[1];
                if (((double) Math.abs(f2 - this.kCe)) >= 0.05d) {
                    this.kCe = f2;
                    x.d("LuckyMoneyF2FQRCodeUI", "[onSensorChanged] y:%s ", new Object[]{Float.valueOf(f2)});
                    if (f2 >= -3.0f) {
                        if (f2 > 0.0f) {
                            f = 0.0f;
                        } else {
                            f = f2;
                        }
                    }
                    f = ((f / 3.0f) * ((float) this.oax)) + ((float) this.oax);
                    x.d("LuckyMoneyF2FQRCodeUI", "paddingTop:%s nowPaddingTop:%s", new Object[]{Float.valueOf(f), Integer.valueOf(this.oar.nZv.getPaddingTop())});
                    if (this.oay != null) {
                        this.oay.cancel();
                    }
                    this.oay = ValueAnimator.ofFloat(new float[]{(float) this.oar.nZv.getPaddingTop(), f}).setDuration(200);
                    this.oay.addUpdateListener(new 1(this));
                    this.oay.start();
                }
            }
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
            x.i("LuckyMoneyF2FQRCodeUI", "onAccuracyChanged");
        }
    };

    private class a extends BaseAdapter {
        final /* synthetic */ LuckyMoneyF2FQRCodeUI oar;

        private a(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
            this.oar = luckyMoneyF2FQRCodeUI;
        }

        public final /* synthetic */ Object getItem(int i) {
            return kC(i);
        }

        public final int getCount() {
            return this.oar.nZE.size();
        }

        private String kC(int i) {
            return (String) this.oar.nZE.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = LayoutInflater.from(this.oar).inflate(com.tencent.mm.plugin.wxpay.a.g.uCu, null);
                ImageView imageView = (ImageView) view.findViewById(f.unL);
                ImageView imageView2 = (ImageView) view.findViewById(f.unF);
                a aVar2 = new a(this);
                aVar2.ijr = imageView;
                aVar2.oaA = imageView2;
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            String str = (String) this.oar.nZF.get(kC(i));
            n.a(aVar.ijr, null, str);
            if (bh.ov(this.oar.nZU) || !this.oar.nZU.equals(str)) {
                aVar.oaA.setVisibility(4);
            } else {
                aVar.oaA.setVisibility(0);
            }
            return view;
        }
    }

    static /* synthetic */ void G(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        luckyMoneyF2FQRCodeUI.nZx = (ImageView) luckyMoneyF2FQRCodeUI.nZw.findViewById(f.upm);
        luckyMoneyF2FQRCodeUI.nZy = (TextView) luckyMoneyF2FQRCodeUI.nZw.findViewById(f.upn);
        luckyMoneyF2FQRCodeUI.nZz = (TextView) luckyMoneyF2FQRCodeUI.nZw.findViewById(f.upj);
        Pair pair = (Pair) luckyMoneyF2FQRCodeUI.nZG.poll();
        if (pair != null) {
            n.a(luckyMoneyF2FQRCodeUI.nZx, null, (String) pair.first);
            n.a(luckyMoneyF2FQRCodeUI, luckyMoneyF2FQRCodeUI.nZy, n.gt((String) pair.first));
            luckyMoneyF2FQRCodeUI.nZz.setText(com.tencent.mm.wallet_core.ui.e.t(((double) ((Integer) pair.second).intValue()) / 100.0d));
            if (!bh.ov(luckyMoneyF2FQRCodeUI.nZU) && luckyMoneyF2FQRCodeUI.nZU.equals(pair.first)) {
                com.tencent.mm.plugin.luckymoney.particles.a.a(luckyMoneyF2FQRCodeUI.nZP, luckyMoneyF2FQRCodeUI.oao).y(800, 100);
                com.tencent.mm.plugin.luckymoney.particles.a.a(luckyMoneyF2FQRCodeUI.nZQ, luckyMoneyF2FQRCodeUI.oap).y(800, 100);
                luckyMoneyF2FQRCodeUI.nZS.ew("most_lucky.m4a");
                if (((Integer) pair.second).intValue() >= 19000) {
                    luckyMoneyF2FQRCodeUI.nZS.ew("whistle.m4a");
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.icn = getResources().getDisplayMetrics();
        this.nZE = new ArrayList();
        this.nZF = new HashMap();
        this.nZG = new LinkedList();
        this.nZO = new ArrayList();
        this.nZZ = new int[6];
        int[] iArr = this.nZZ;
        iArr[0] = iArr[0] + 1;
        this.iZb = new ak(new com.tencent.mm.sdk.platformtools.ak.a(this) {
            final /* synthetic */ LuckyMoneyF2FQRCodeUI oar;

            {
                this.oar = r1;
            }

            public final boolean uF() {
                this.oar.b(new com.tencent.mm.plugin.luckymoney.f2f.a.d(), false);
                return true;
            }
        }, true);
        this.iiq = (TextView) findViewById(f.cSu);
        this.Lr = findViewById(f.unM);
        this.nZv = findViewById(f.uAH);
        this.nZC = (TextView) findViewById(f.unI);
        this.nZB = (TextView) findViewById(f.unJ);
        this.nZY = this.nZC.getAlpha();
        this.nZA = (ImageView) this.Lr.findViewById(f.unH);
        this.nZD = (HorizontalListViewV2) findViewById(f.unK);
        this.nZH = new a();
        this.nZD.setAdapter(this.nZH);
        this.nZD.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ LuckyMoneyF2FQRCodeUI oar;

            {
                this.oar = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Intent intent = new Intent(this.oar, LuckyMoneyDetailUI.class);
                intent.putExtra("key_sendid", this.oar.nZa);
                this.oar.startActivity(intent);
            }
        });
        this.nZD.xYt = new 15(this);
        this.nZJ = (Button) findViewById(f.unG);
        this.nZJ.setOnClickListener(new 16(this));
        this.nZI = (TextView) findViewById(f.unO);
        this.nZw = findViewById(f.unN);
        setBackBtn(new 2(this));
        setMMTitle(getString(i.uKc));
        this.nZK = findViewById(f.bLT);
        this.nZK.setOnClickListener(new 3(this));
        this.nZL = findViewById(f.urH);
        this.nZL.setOnClickListener(new 4(this));
        this.iiq.setText(i.uKc);
        this.nZP = (ViewGroup) findViewById(f.unC);
        this.nZQ = (ViewGroup) findViewById(f.unB);
        this.nZR = findViewById(f.unE);
        this.nZR.setAlpha(0.0f);
        this.bgR = (SensorManager) getSystemService("sensor");
        this.bgR.registerListener(this.oaq, this.bgR.getDefaultSensor(1), 3);
        this.nZS = new com.tencent.mm.plugin.luckymoney.f2f.a();
        this.nZM = (ShuffleView) findViewById(f.unP);
        this.nZN = new c();
        this.nZN.obq = 4;
        this.nZN.obo = 2;
        this.nZN.obp = 4;
        this.nZN.obt = 300;
        this.nZN.obs = 0.0f;
        ShuffleView shuffleView = this.nZM;
        c cVar = this.nZN;
        shuffleView.oaL = cVar;
        shuffleView.oaO = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration((long) cVar.obt);
        shuffleView.oaP = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration((long) cVar.obu);
        ShuffleView.icn = this.icn;
        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(300);
        ShuffleView shuffleView2 = this.nZM;
        if (shuffleView2.oaM != null) {
            shuffleView2.oaM.removeAllListeners();
            shuffleView2.oaM.cancel();
        }
        shuffleView2.oaM = duration;
        if (shuffleView2.oaM != null) {
            shuffleView2.oaM.addUpdateListener(new 6(shuffleView2));
        }
        this.nZM.oaQ = new 5(this);
        this.nZM.oaR = new 6(this);
        aWU();
        this.nZV = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.nZV.setDuration(300);
        this.nZV.setStartDelay(3000);
        this.nZV.addUpdateListener(new 7(this));
        aWT();
        getWindow().addFlags(FileUtils.S_IWUSR);
    }

    private void aWT() {
        if (!bh.ov(this.lOX)) {
            Bitmap bitmap;
            byte[] bArr = new byte[40000];
            int[] iArr = new int[2];
            int a = QbarNative.a(bArr, iArr, this.lOX, 0, 1, "UTF-8");
            QbarNative.nativeRelease();
            if (a > 0) {
                int i;
                int i2;
                int i3;
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                int i4 = displayMetrics.widthPixels;
                int i5 = displayMetrics.heightPixels;
                if (i4 >= i5) {
                    i4 = i5;
                }
                int i6 = (int) (((double) iArr[0]) * 0.1d);
                i4 = ((int) (((double) i4) * 0.8d)) / (iArr[0] + (i6 * 2));
                if (i4 == 0) {
                    i = 1;
                } else {
                    i = i4;
                }
                int i7 = i6 * i;
                i5 = i * (iArr[0] + (i6 * 2));
                int i8 = (iArr[1] * i) + ((i * 2) * i6);
                Bitmap createBitmap = Bitmap.createBitmap(i5, i8, Config.ARGB_8888);
                int[] iArr2 = new int[(i5 * i8)];
                int i9 = (i * 2) + (i / 2);
                int i10 = (i * 3) + (i / 2);
                Canvas canvas = new Canvas(createBitmap);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                Arrays.fill(iArr2, -1);
                int[] iArr3 = new int[]{(i * 3) + (i / 2), (i * 3) + (i / 2), (((iArr[0] - 1) - 3) * i) + (i / 2), (i * 3) + (i / 2), (i * 3) + (i / 2), (((iArr[1] - 1) - 3) * i) + (i / 2)};
                i4 = 0;
                while (i4 < iArr[1]) {
                    int i11 = 0;
                    while (i11 < iArr[0]) {
                        if (bArr[(iArr[0] * i4) + i11] == (byte) 1) {
                            int i12;
                            if ((i4 < 0 || i4 > 6 || i11 < 0 || i11 > 6) && ((i4 < 0 || i4 > 6 || i11 < iArr[0] - 7 || i11 > iArr[0] - 1) && (i4 < iArr[1] - 7 || i4 > iArr[1] - 1 || i11 < 0 || i11 > 6))) {
                                boolean[] zArr = new boolean[10];
                                zArr[5] = true;
                                if (zArr[(int) (Math.random() * 10.0d)]) {
                                    for (i2 = 0; i2 < i; i2++) {
                                        for (i12 = 0; i12 < i; i12++) {
                                            iArr2[((((((i4 * i) + i7) + i2) * i5) + (i11 * i)) + i7) + i12] = -3041484;
                                        }
                                    }
                                } else {
                                    for (i2 = 0; i2 < i; i2++) {
                                        for (i12 = 0; i12 < i; i12++) {
                                            iArr2[((((((i4 * i) + i7) + i2) * i5) + (i11 * i)) + i7) + i12] = -2598591;
                                        }
                                    }
                                }
                            } else {
                                for (i2 = 0; i2 < i; i2++) {
                                    for (i12 = 0; i12 < i; i12++) {
                                        iArr2[((((((i4 * i) + i7) + i2) * i5) + (i11 * i)) + i7) + i12] = -1;
                                    }
                                }
                            }
                        }
                        i11++;
                    }
                    i4++;
                }
                createBitmap.setPixels(iArr2, 0, i5, 0, 0, i5, i8);
                for (i3 = 0; i3 < 3; i3++) {
                    paint.setColor(-2598591);
                    paint.setStyle(Style.FILL);
                    canvas = canvas;
                    canvas.drawCircle((float) ((i * i6) + iArr3[i3 * 2]), (float) ((i * i6) + iArr3[(i3 * 2) + 1]), (float) i10, paint);
                    paint.setColor(-1);
                    canvas = canvas;
                    canvas.drawCircle((float) ((i * i6) + iArr3[i3 * 2]), (float) ((i * i6) + iArr3[(i3 * 2) + 1]), (float) i9, paint);
                }
                for (i2 = 0; i2 < 3; i2++) {
                    paint.setColor(-3041484);
                    paint.setStyle(Style.FILL);
                    Canvas canvas2 = canvas;
                    canvas2.drawRect((float) ((((i * i6) + iArr3[i2 * 2]) - i) - ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i2 * 2) + 1]) - i) - ((i * 1) / 4)), (float) (((i * 1) / 4) + (((i * i6) + iArr3[i2 * 2]) + i)), (float) (((i * 1) / 4) + (((i * i6) + iArr3[(i2 * 2) + 1]) + i)), paint);
                }
                for (i3 = 0; i3 < 3; i3++) {
                    paint.setColor(-1);
                    paint.setStyle(Style.FILL_AND_STROKE);
                    Path path = new Path();
                    path.moveTo((float) ((((i * i6) + iArr3[i3 * 2]) - i) - ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) - i) - ((i * 1) / 4)));
                    path.quadTo((float) ((i * i6) + iArr3[i3 * 2]), (float) (((i * i6) + iArr3[(i3 * 2) + 1]) - i), (float) ((((i * i6) + iArr3[i3 * 2]) + i) + (i / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) - i) - ((i * 1) / 4)));
                    path.lineTo((float) ((((i * i6) + iArr3[i3 * 2]) - i) - ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) - i) - ((i * 1) / 4)));
                    path.close();
                    canvas.drawPath(path, paint);
                    path.moveTo((float) ((((i * i6) + iArr3[i3 * 2]) - i) - ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) - i) - ((i * 1) / 4)));
                    path.quadTo((float) (((i * i6) + iArr3[i3 * 2]) - i), (float) ((i * i6) + iArr3[(i3 * 2) + 1]), (float) ((((i * i6) + iArr3[i3 * 2]) - i) - (i / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) + i) + ((i * 1) / 4)));
                    path.lineTo((float) ((((i * i6) + iArr3[i3 * 2]) - i) - ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) - i) - ((i * 1) / 4)));
                    path.close();
                    canvas.drawPath(path, paint);
                    path.moveTo((float) ((((i * i6) + iArr3[i3 * 2]) + i) + ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) + i) + ((i * 1) / 4)));
                    path.quadTo((float) ((i * i6) + iArr3[i3 * 2]), (float) (((i * i6) + iArr3[(i3 * 2) + 1]) + i), (float) ((((i * i6) + iArr3[i3 * 2]) - i) - (i / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) + i) + ((i * 1) / 4)));
                    path.lineTo((float) ((((i * i6) + iArr3[i3 * 2]) + i) + ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) + i) + ((i * 1) / 4)));
                    path.close();
                    canvas.drawPath(path, paint);
                    path.moveTo((float) ((((i * i6) + iArr3[i3 * 2]) + i) + ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) + i) + ((i * 1) / 4)));
                    path.quadTo((float) (((i * i6) + iArr3[i3 * 2]) + i), (float) ((i * i6) + iArr3[(i3 * 2) + 1]), (float) ((((i * i6) + iArr3[i3 * 2]) + i) + (i / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) - i) - ((i * 1) / 4)));
                    path.lineTo((float) ((((i * i6) + iArr3[i3 * 2]) + i) + ((i * 1) / 4)), (float) ((((i * i6) + iArr3[(i3 * 2) + 1]) + i) + ((i * 1) / 4)));
                    path.close();
                    canvas.drawPath(path, paint);
                }
                if (createBitmap == null) {
                    x.i("MicroMsg.QRCodeBitmapFactory", "createBitmap bm is error result %d %s", new Object[]{Integer.valueOf(a), bh.cgy().toString()});
                } else {
                    x.i("MicroMsg.QRCodeBitmapFactory", "createBitmap %s", new Object[]{createBitmap});
                }
                bitmap = createBitmap;
            } else {
                x.i("MicroMsg.QRCodeBitmapFactory", "result %d %s", new Object[]{Integer.valueOf(a), bh.cgy().toString()});
                bitmap = null;
            }
            this.mBitmap = bitmap;
            this.nZA.setImageBitmap(this.mBitmap);
        }
        if (this.nZr <= 0) {
            this.nZA.setPadding(com.tencent.mm.bv.a.fromDPToPix(this, 5), com.tencent.mm.bv.a.fromDPToPix(this, 5), com.tencent.mm.bv.a.fromDPToPix(this, 5), com.tencent.mm.bv.a.fromDPToPix(this, 5));
            this.nZA.setImageResource(e.ucN);
            this.nZI.setVisibility(8);
            this.nZJ.setVisibility(0);
            this.nZB.setVisibility(4);
            this.nZv.setPadding(this.nZv.getPaddingLeft(), com.tencent.mm.pluginsdk.e.ci(this), this.nZv.getPaddingRight(), this.nZv.getPaddingBottom());
            if (this.nZE.size() > 0) {
                this.nZC.setText(getString(i.uJV));
                return;
            } else {
                this.nZC.setText(getString(i.uJW));
                return;
            }
        }
        this.nZA.setPadding(0, 0, 0, 0);
        this.nZB.setText(getString(i.uKa));
        this.nZB.setVisibility(0);
        this.nZC.setText(getString(i.uKa));
        this.nZI.setText(getString(i.uJZ, new Object[]{Integer.valueOf(this.nZr)}));
        this.nZI.setVisibility(0);
        this.nZJ.setVisibility(8);
    }

    private void aWU() {
        Set hashSet = new HashSet();
        hashSet.add("touch_card.m4a");
        hashSet.add("select_card.m4a");
        for (int i = 1; i <= 8; i++) {
            hashSet.add("music" + i + ".m4a");
        }
        hashSet.add("packet_received.m4a");
        hashSet.add("most_lucky.m4a");
        hashSet.add("whistle.m4a");
        com.tencent.mm.plugin.luckymoney.f2f.a aVar = this.nZS;
        com.tencent.mm.kernel.g.Dm().F(new 1(aVar, hashSet, new WeakReference(this)));
        aVar.nYQ.setOnLoadCompleteListener(new 2(aVar));
    }

    private void aWV() {
        int width = this.nZD.getWidth() - (this.nZE.size() * getResources().getDimensionPixelSize(com.tencent.mm.plugin.wxpay.a.d.bup));
        if (width > 0) {
            this.nZD.setPadding(width / 2, 0, width / 2, 0);
        } else {
            this.nZD.setPadding(0, 0, 0, 0);
        }
    }

    private void aWW() {
        if (this.nZO.size() != this.nZr) {
            int i;
            x.i("LuckyMoneyF2FQRCodeUI", "shuffle cards: %d", new Object[]{Integer.valueOf(this.nZO.size()), Integer.valueOf(this.nZr)});
            this.nZO.clear();
            for (i = 0; i < this.nZr; i++) {
                View inflate = LayoutInflater.from(this).inflate(com.tencent.mm.plugin.wxpay.a.g.uCr, this.nZM, false);
                ((LayoutParams) inflate.getLayoutParams()).gravity = 81;
                this.nZO.add(inflate);
            }
            ShuffleView shuffleView = this.nZM;
            Collection collection = this.nZO;
            shuffleView.oaK.clear();
            shuffleView.oaK.addAll(collection);
            shuffleView.oaV = 0;
            shuffleView.oaU = null;
            shuffleView.oaX = -1;
            shuffleView.oaW = null;
            shuffleView.removeAllViews();
            List list = shuffleView.oaK;
            if (list.size() > 100) {
                shuffleView.oaY = 100;
            } else {
                shuffleView.oaY = list.size();
                if (shuffleView.oaY == 1) {
                    ((View) list.get(0)).findViewById(f.unQ).setVisibility(0);
                }
            }
            for (i = shuffleView.oaY - 1; i >= 0; i--) {
                shuffleView.addView((View) list.get(i));
            }
            shuffleView.addOnLayoutChangeListener(new ShuffleView.1(shuffleView));
        }
    }

    protected void onResume() {
        super.onResume();
        b(new com.tencent.mm.plugin.luckymoney.f2f.a.d(), true);
        this.iZb.J(60000, 60000);
        ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("ffopenwxhb", this.oaa, true);
        ji(1642);
        ji(1990);
        ji(1987);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            attributes.screenBrightness = 0.85f;
            getWindow().setAttributes(attributes);
        }
        av.a(this);
        if (this.bgR != null) {
            this.bgR.registerListener(this.oaq, this.bgR.getDefaultSensor(1), 3);
        }
    }

    protected void onStop() {
        super.onStop();
        this.iZb.TG();
        ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("ffopenwxhb", this.oaa, true);
        jj(1990);
        jj(1642);
        jj(1987);
        av.a(null);
    }

    protected void onPause() {
        super.onPause();
        if (this.bgR != null) {
            this.bgR.unregisterListener(this.oaq);
        }
    }

    protected void onDestroy() {
        com.tencent.mm.plugin.report.service.g.pQN.h(14007, new Object[]{Integer.valueOf(this.nZZ[0]), Integer.valueOf(this.nZZ[1]), Integer.valueOf(this.nZZ[2]), Integer.valueOf(this.nZZ[3]), Integer.valueOf(this.nZZ[4]), Integer.valueOf(this.nZZ[5])});
        com.tencent.mm.plugin.luckymoney.f2f.a aVar = this.nZS;
        aVar.kpn = true;
        aVar.nYQ.release();
        getWindow().clearFlags(FileUtils.S_IWUSR);
        super.onDestroy();
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uCs;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        int i3 = 0;
        x.i("LuckyMoneyF2FQRCodeUI", "errType: %d,errCode: %d,errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.luckymoney.f2f.a.d) {
                x.d("LuckyMoneyF2FQRCodeUI", "sendId:" + this.nZa);
                if (!(bh.G(new String[]{this.nZa, ((com.tencent.mm.plugin.luckymoney.f2f.a.d) kVar).nZa}) || this.nZa.equals(((com.tencent.mm.plugin.luckymoney.f2f.a.d) kVar).nZa))) {
                    this.nZE.clear();
                    this.nZF.clear();
                    this.nZG.clear();
                    this.nZH.notifyDataSetChanged();
                    this.nZU = "";
                }
                if (!bh.ov(((com.tencent.mm.plugin.luckymoney.f2f.a.d) kVar).nZa)) {
                    this.nZa = ((com.tencent.mm.plugin.luckymoney.f2f.a.d) kVar).nZa;
                }
                this.lOX = ((com.tencent.mm.plugin.luckymoney.f2f.a.d) kVar).lOX;
                this.nZr = ((com.tencent.mm.plugin.luckymoney.f2f.a.d) kVar).nZr;
                this.nZq = ((com.tencent.mm.plugin.luckymoney.f2f.a.d) kVar).nZq;
                aWT();
                aWW();
                if (this.nZr == 0) {
                    this.iZb.TG();
                }
                if (this.nZE.size() == 0 && !bh.ov(this.nZa)) {
                    b(new v(this.nZa, 5, 0, null, "v1.0"), false);
                }
            } else if (kVar instanceof com.tencent.mm.plugin.luckymoney.f2f.a.a) {
                this.nZa = "";
                this.lOX = "";
                this.nZr = 0;
                this.nZE.clear();
                this.nZU = "";
                this.nZH.notifyDataSetChanged();
                aWT();
                aWW();
                this.iZb.TG();
                if (!bh.ov(this.nZq)) {
                    h.bu(this, this.nZq);
                }
            } else if (kVar instanceof v) {
                this.nZT = ((v) kVar).ocQ.obS;
                List list = ((v) kVar).ocQ.och;
                if (list != null && list.size() > 0) {
                    while (i3 < list.size()) {
                        m mVar = (m) list.get(i3);
                        if (!(bh.ov(mVar.obV) || this.nZE.contains(mVar.obV))) {
                            this.nZE.add(mVar.obV);
                            String jb = com.tencent.mm.ad.n.JS().jb(mVar.ocE);
                            if (!bh.ov(mVar.ocG)) {
                                this.nZU = jb;
                            }
                            this.nZF.put(mVar.obV, jb);
                        }
                        i3++;
                    }
                    aWV();
                    this.nZH.notifyDataSetChanged();
                }
            }
        } else if (!bh.ov(str)) {
            h.b(this, str, getString(i.dGO), true);
        }
        return true;
    }

    public final void alG() {
        x.i("LuckyMoneyF2FQRCodeUI", "screenShot");
        if (this.nZr > 0) {
            aWT();
            int[] iArr = this.nZZ;
            iArr[1] = iArr[1] + 1;
            h.b(this, getString(i.uKb), null, true);
        }
    }
}
