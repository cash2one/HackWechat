package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.view.ViewPager.e;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.g.a.aj;
import com.tencent.mm.g.a.aq;
import com.tencent.mm.g.a.bz;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.g.a.gl;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.g.a.mr;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiCreateAudioInstance;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.s;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

@a(3)
public class ImageGalleryUI extends MMActivity implements OnClickListener, ak.a {
    protected String chatroomName;
    public long fqm;
    private int juU;
    private int juV;
    public long kGB;
    Bundle kRZ;
    private boolean kSa = false;
    g kSb;
    int kSc = 0;
    int kSd = 0;
    int kSe = 0;
    int kSf = 0;
    private d lET = new 4(this);
    private af mHandler = new af(Looper.getMainLooper());
    protected MMViewPager mTN;
    private c msq = new c<mr>(this) {
        final /* synthetic */ ImageGalleryUI yFy;

        {
            this.yFy = r2;
            this.xen = mr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            mr mrVar = (mr) bVar;
            if (this.yFy.rsB == null || this.yFy.rsC == null) {
                x.e("MicroMsg.ImageGalleryUI", "not in recoging");
            } else if (mrVar == null || !(mrVar instanceof mr)) {
                x.e("MicroMsg.ImageGalleryUI", "receive invalid callbak");
            } else if (mrVar == null || mrVar.fED.filePath.equals(this.yFy.rsC)) {
                x.i("MicroMsg.ImageGalleryUI", "recog result: " + mrVar.fED.result);
                if (!bh.ov(mrVar.fED.result)) {
                    this.yFy.rsF = mrVar.fED.result;
                    this.yFy.juU = mrVar.fED.fqb;
                    this.yFy.juV = mrVar.fED.fqc;
                    if (!(this.yFy.rsF == null || this.yFy.rsB == null)) {
                        this.yFy.rsG = true;
                    }
                    this.yFy.mT(false);
                }
                this.yFy.rsC = null;
            } else {
                x.e("MicroMsg.ImageGalleryUI", "not same filepath");
            }
            return false;
        }
    };
    private ImageView mxv;
    private boolean oqs;
    private com.tencent.mm.ui.widget.g rsB;
    private String rsC;
    private String rsF;
    private boolean rsG = false;
    private c rsI = new 12(this);
    int rzf;
    int rzg;
    int rzh = 0;
    private float rzi = 1.0f;
    private int rzj = 0;
    private int rzk = 0;
    protected String talker;
    public boolean vnK = false;
    protected boolean yAI = false;
    private HashSet<Long> yBx = new HashSet();
    public b yCR;
    private final boolean yDb = false;
    private b.b yEL;
    private RelativeLayout yEM;
    private RelativeLayout yEN;
    private boolean yEO;
    private boolean yEP = false;
    private ImageView yEQ;
    private RelativeLayout yER;
    private RelativeLayout yES;
    private FrameLayout yET;
    View yEU;
    Button yEV;
    Button yEW;
    View yEX;
    private View yEY;
    protected VideoPlayerSeekBar yEZ;
    private MultiTouchImageView yFa;
    int yFb = 0;
    int yFc = 0;
    boolean yFd;
    ArrayList<Integer> yFe = new ArrayList();
    protected boolean yFf = false;
    protected boolean yFg = false;
    private boolean yFh;
    private String yFi = null;
    public a yFj;
    private View yFk;
    private CheckBox yFl;
    private View yFm;
    private boolean yFn = true;
    private int yFo = 0;
    private e yFp = new 5(this);
    boolean yFq = false;
    ak yFr = new ak(new ak.a(this) {
        final /* synthetic */ ImageGalleryUI yFy;

        {
            this.yFy = r1;
        }

        public final boolean uF() {
            if (this.yFy.yFq) {
                this.yFy.cuS();
            }
            return false;
        }
    }, false);
    private HashMap<Long, String> yFs = new HashMap();
    private boolean yFt = false;
    private boolean yFu = false;
    private ak yFv;
    private boolean yFw = false;
    private boolean yFx = false;
    private boolean ysa = false;

    static /* synthetic */ class AnonymousClass11 {
        static final /* synthetic */ int[] yDh = new int[b.b.values().length];

        static {
            try {
                yDh[b.b.yDy.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                yDh[b.b.yDx.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                yDh[b.b.yDA.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                yDh[b.b.yDz.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    static /* synthetic */ void a(ImageGalleryUI imageGalleryUI, bz bzVar) {
        int i;
        String str;
        int i2 = 2;
        x.i("MicroMsg.ImageGalleryUI", "talker: %s, chatroom: %s", new Object[]{imageGalleryUI.talker, imageGalleryUI.chatroomName});
        String str2 = "";
        if (!bh.ov(imageGalleryUI.chatroomName) && s.eV(imageGalleryUI.chatroomName)) {
            x.d("MicroMsg.ImageGalleryUI", "is chatroom: %s", new Object[]{imageGalleryUI.chatroomName});
            i = 2;
            str = imageGalleryUI.chatroomName;
        } else if (bh.ov(imageGalleryUI.talker)) {
            x.e("MicroMsg.ImageGalleryUI", "unknow source");
            str = str2;
            i = -1;
        } else {
            if (s.gF(imageGalleryUI.talker)) {
                x.d("MicroMsg.ImageGalleryUI", "is biz: %s", new Object[]{imageGalleryUI.talker});
                i2 = 4;
            } else if (s.eV(imageGalleryUI.talker)) {
                x.d("MicroMsg.ImageGalleryUI", "taler is chatroom: %s", new Object[]{imageGalleryUI.talker});
            } else {
                x.d("MicroMsg.ImageGalleryUI", "is single chat: %s", new Object[]{imageGalleryUI.talker});
                i2 = 1;
            }
            i = i2;
            str = imageGalleryUI.talker;
        }
        bzVar.fqa.fqd = i;
        bzVar.fqa.bhd = str;
    }

    static /* synthetic */ void b(ImageGalleryUI imageGalleryUI, bz bzVar) {
        com.tencent.mm.aq.e f = imageGalleryUI.yCR.f(imageGalleryUI.yCR.cuy(), true);
        if (f != null && !bh.ov(f.hAa)) {
            Map y = bi.y(f.hAa, "msg");
            if (y != null) {
                bzVar.fqa.fqg = (String) y.get(".msg.img.$aeskey");
                bzVar.fqa.imagePath = (String) y.get(".msg.img.$cdnmidimgurl");
            }
        }
    }

    static /* synthetic */ void h(ImageGalleryUI imageGalleryUI) {
        x.i("MicroMsg.ImageGalleryUI", "%d handle single click event.", new Object[]{Integer.valueOf(imageGalleryUI.hashCode())});
        if (imageGalleryUI.cuP()) {
            try {
                if (imageGalleryUI.yCR.cuz().cvl().yGm.getVisibility() == 0) {
                    x.d("MicroMsg.ImageGalleryUI", "%d handle single click event, it is loading video, don't show toolbar", new Object[]{Integer.valueOf(imageGalleryUI.hashCode())});
                    return;
                }
            } catch (Exception e) {
            }
            if (imageGalleryUI.yFq) {
                imageGalleryUI.cuS();
                return;
            } else {
                imageGalleryUI.cuR();
                return;
            }
        }
        imageGalleryUI.onBackPressed();
    }

    static /* synthetic */ void m(ImageGalleryUI imageGalleryUI) {
        if (imageGalleryUI.cuP()) {
            try {
                if (imageGalleryUI.yCR.cuz().cvl().yGk.getVisibility() == 0) {
                    imageGalleryUI.yCR.cuz().cvl().yGk.setVisibility(8);
                    imageGalleryUI.yFt = true;
                }
            } catch (Exception e) {
            }
        }
        if (imageGalleryUI.yFq) {
            imageGalleryUI.cuS();
            imageGalleryUI.yFu = true;
        }
    }

    static /* synthetic */ void q(ImageGalleryUI imageGalleryUI) {
        View a = imageGalleryUI.a(imageGalleryUI.yCR, imageGalleryUI.mTN);
        imageGalleryUI.mTN.yeF = new 18(imageGalleryUI, a);
    }

    static /* synthetic */ void r(ImageGalleryUI imageGalleryUI) {
        if (imageGalleryUI.cuP() && imageGalleryUI.yFt) {
            try {
                if (imageGalleryUI.yCR.cuz().cvl().yGk.getVisibility() == 8) {
                    imageGalleryUI.yCR.cuz().cvl().yGk.setVisibility(0);
                    imageGalleryUI.yFt = false;
                }
            } catch (Exception e) {
            }
        }
        if (imageGalleryUI.yFu) {
            imageGalleryUI.cuR();
            imageGalleryUI.yFu = false;
        }
    }

    static /* synthetic */ void x(ImageGalleryUI imageGalleryUI) {
        x.i("MicroMsg.ImageGalleryUI", "enterPositionAtChatRecords-->talker:%s,magId:%d", new Object[]{imageGalleryUI.talker, Long.valueOf(imageGalleryUI.yCR.FL(imageGalleryUI.yFo).field_msgId)});
        Intent intent = new Intent(imageGalleryUI.mController.xIM, ChattingUI.class);
        intent.putExtra("Chat_User", imageGalleryUI.cuL());
        intent.putExtra("finish_direct", true);
        intent.putExtra("show_search_chat_content_result", true);
        intent.putExtra("key_is_biz_chat", imageGalleryUI.vnK);
        intent.putExtra("key_biz_chat_id", imageGalleryUI.kGB);
        ar.Hg();
        intent.putExtra("need_hight_item", ((Boolean) com.tencent.mm.z.c.CU().get(w.a.xqy, Boolean.valueOf(true))).booleanValue());
        intent.putExtra("msg_local_id", r4);
        intent.putExtra("img_gallery_enter_from_chatting_ui", true);
        imageGalleryUI.startActivity(intent);
        if (imageGalleryUI.yFf) {
            com.tencent.mm.plugin.report.service.g.pQN.a(219, 16, 1, true);
        } else {
            com.tencent.mm.plugin.report.service.g.pQN.a(219, 17, 1, true);
        }
    }

    protected void onPause() {
        x.i("MicroMsg.ImageGalleryUI", "on pause");
        super.onPause();
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(2048, 2048);
        }
        if (!(isFinishing() || this.yCR == null)) {
            b bVar = this.yCR;
            bVar.yCY.yFO.sendEmptyMessageAtTime(1, 200);
            bVar.yCZ.cuG();
        }
        if (this.rsF != null) {
            b ajVar = new aj();
            ajVar.fou.activity = this;
            ajVar.fou.fov = this.rsF;
            com.tencent.mm.sdk.b.a.xef.m(ajVar);
            this.rsF = null;
            this.juV = 0;
            this.juU = 0;
        }
    }

    final ImageGalleryUI cuH() {
        if (this.yEU == null) {
            this.yEU = ((ViewStub) findViewById(R.h.cpa)).inflate();
            this.yEV = (Button) this.yEU.findViewById(R.h.bZV);
            this.yEW = (Button) this.yEU.findViewById(R.h.bZW);
            this.yEX = this.yEU.findViewById(R.h.bZX);
        }
        return this;
    }

    protected final ImageGalleryUI cuI() {
        if (this.yEY == null) {
            this.yEY = ((ViewStub) findViewById(R.h.cUV)).inflate();
            this.yEZ = (VideoPlayerSeekBar) findViewById(R.h.cVi);
            this.yEZ.n(this);
        }
        return this;
    }

    private ImageGalleryUI cuJ() {
        if (this.yER == null) {
            this.yER = (RelativeLayout) ((ViewStub) findViewById(R.h.cnN)).inflate();
        }
        return this;
    }

    private ImageGalleryUI cuK() {
        if (this.yES == null) {
            this.yES = (RelativeLayout) ((ViewStub) findViewById(R.h.coZ)).inflate();
            this.yES.findViewById(R.h.ccv).setOnClickListener(this);
        }
        return this;
    }

    private static void M(View view, int i) {
        if (view != null) {
            view.setVisibility(i);
        }
    }

    private static int dp(View view) {
        if (view != null) {
            return view.getVisibility();
        }
        return 8;
    }

    public final boolean noActionBar() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        long currentTimeMillis = System.currentTimeMillis();
        this.yFn = true;
        super.onCreate(bundle);
        if (com.tencent.mm.compatible.util.d.fM(19)) {
            getWindow().setFlags(201327616, 201327616);
            this.oqs = true;
        } else {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            this.oqs = false;
        }
        initView();
        this.kRZ = bundle;
        com.tencent.mm.sdk.b.a.xef.b(this.msq);
        com.tencent.mm.sdk.b.a.xef.b(this.rsI);
        this.yEP = false;
        x.d("MicroMsg.ImageGalleryUI", "ImageGallery onCreate spent : %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    protected void onResume() {
        super.onResume();
        if (VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(2048);
        }
        if (!(this.yFn || this.yCR == null)) {
            Gb(this.mTN.yF);
        }
        this.yFn = false;
        if (this.yCR != null) {
            this.yCR.cuA();
        }
    }

    public void onStart() {
        this.yFg = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
        if (!this.yEO) {
            Bundle bundle = this.kRZ;
            if (!this.kSa) {
                this.kSa = true;
                if (VERSION.SDK_INT >= 12) {
                    this.kSc = getIntent().getIntExtra("img_gallery_top", 0);
                    this.kSd = getIntent().getIntExtra("img_gallery_left", 0);
                    this.kSe = getIntent().getIntExtra("img_gallery_width", 0);
                    this.kSf = getIntent().getIntExtra("img_gallery_height", 0);
                    if (this.kSc == 0 && this.kSd == 0 && this.kSe == 0 && this.kSf == 0) {
                        au FL = this.yCR.FL(this.mTN.yF);
                        if (FL != null) {
                            b aqVar = new aq();
                            aqVar.foJ.fnB = FL;
                            com.tencent.mm.sdk.b.a.xef.m(aqVar);
                            this.kSe = aqVar.foK.foN;
                            this.kSf = aqVar.foK.foO;
                            this.kSd = aqVar.foK.foL;
                            this.kSc = aqVar.foK.foM;
                        }
                    }
                    this.kSb.r(this.kSd, this.kSc, this.kSe, this.kSf);
                    if (bundle == null) {
                        this.mTN.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                            final /* synthetic */ ImageGalleryUI yFy;

                            {
                                this.yFy = r1;
                            }

                            public final boolean onPreDraw() {
                                this.yFy.mTN.getViewTreeObserver().removeOnPreDrawListener(this);
                                this.yFy.rzf = this.yFy.mTN.getWidth();
                                this.yFy.rzg = this.yFy.mTN.getHeight();
                                if (this.yFy.yCR.cuy().cji()) {
                                    this.yFy.rzg = (int) ((((float) this.yFy.rzf) / ((float) this.yFy.kSe)) * ((float) this.yFy.kSf));
                                }
                                if (this.yFy.yCR.cuy().cje()) {
                                    this.yFy.yFa = this.yFy.yCR.qx(this.yFy.mTN.yF);
                                }
                                if (this.yFy.yFa != null) {
                                    this.yFy.rzg = (int) ((((float) this.yFy.rzf) / ((float) this.yFy.yFa.imageWidth)) * ((float) this.yFy.yFa.imageHeight));
                                    if (this.yFy.rzg > this.yFy.mTN.getHeight()) {
                                        this.yFy.rzg = this.yFy.mTN.getHeight();
                                    }
                                }
                                this.yFy.kSb.fg(this.yFy.rzf, this.yFy.rzg);
                                if (!this.yFy.yFg) {
                                    ImageGalleryUI.m(this.yFy);
                                    this.yFy.yFt = false;
                                    this.yFy.kSb.a(this.yFy.mTN, this.yFy.mxv, new 1(this));
                                }
                                ImageGalleryUI.q(this.yFy);
                                return true;
                            }
                        });
                    }
                }
            }
        }
        super.onStart();
    }

    protected void onDestroy() {
        x.i("MicroMsg.ImageGalleryUI", "%d image gallery ui on destroy", new Object[]{Integer.valueOf(hashCode())});
        if (this.yCR != null) {
            this.yCR.detach();
            this.yCR = null;
        }
        cvb();
        this.yFr.TG();
        com.tencent.mm.sdk.b.a.xef.c(this.msq);
        com.tencent.mm.sdk.b.a.xef.c(this.rsI);
        if (this.yEZ != null) {
            this.yEZ.n(null);
        }
        this.yEZ = null;
        super.onDestroy();
    }

    public void onBackPressed() {
        x.i("MicroMsg.ImageGalleryUI", "onBackPressed");
        if (this.yFf) {
            Gc(1);
            return;
        }
        try {
            g.a.cuF().detach();
            avV();
        } catch (Exception e) {
            x.e("MicroMsg.ImageGalleryUI", e.getMessage());
        }
    }

    private String cuL() {
        return (this.chatroomName == null || this.chatroomName.length() <= 0) ? this.talker : this.chatroomName;
    }

    protected final void initView() {
        this.kSb = new g(this.mController.xIM);
        this.yFv = new ak(this, false);
        this.kSa = false;
        this.talker = getIntent().getStringExtra("img_gallery_talker");
        this.yFf = getIntent().getBooleanExtra("img_gallery_enter_from_grid", false);
        this.yAI = getIntent().getBooleanExtra("img_gallery_enter_from_chatting_ui", false);
        this.yFh = getIntent().getBooleanExtra("img_gallery_enter_from_appbrand_service_chatting_ui", false);
        this.ysa = getIntent().getBooleanExtra("show_search_chat_content_result", false);
        this.vnK = getIntent().getBooleanExtra("key_is_biz_chat", false);
        this.kGB = getIntent().getLongExtra("key_biz_chat_id", -1);
        this.yEO = getIntent().getBooleanExtra("img_preview_only", false);
        if (!this.yEO) {
            Assert.assertTrue("MicroMsg.ImageGalleryUI initView, talker is null, stack = " + bh.cgy(), this.talker != null);
        }
        this.chatroomName = getIntent().getStringExtra("img_gallery_chatroom_name");
        this.yFg = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
        this.yFi = getIntent().getStringExtra("img_gallery_enter_video_opcode");
        boolean booleanExtra = getIntent().getBooleanExtra("img_gallery_is_restransmit_after_download", false);
        String stringExtra = getIntent().getStringExtra("img_gallery_directly_send_name");
        this.fqm = getIntent().getLongExtra("img_gallery_msg_id", 0);
        long longExtra = getIntent().getLongExtra("img_gallery_msg_svr_id", 0);
        if (this.fqm > 0 || longExtra != 0) {
            if (this.fqm == 0) {
                ar.Hg();
                this.fqm = com.tencent.mm.z.c.Fa().F(cuL(), longExtra).field_msgId;
            }
            ar.Hg();
            cf dH = com.tencent.mm.z.c.Fa().dH(this.fqm);
            if (dH.field_msgId <= 0) {
                x.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.fqm + ", msgSvrId = " + longExtra + ", stack = " + bh.cgy());
                finish();
                return;
            }
            this.yCR = new b(this, this.fqm, cuL(), this.vnK, this.kGB, booleanExtra, stringExtra, Boolean.valueOf(this.yFg));
            this.yCR.yDb = false;
            this.yCR.yCV = getIntent().getBooleanExtra("start_chatting_ui", true);
            this.yCR.yDa = new b.c(this) {
                final /* synthetic */ ImageGalleryUI yFy;

                {
                    this.yFy = r1;
                }

                public final void hX() {
                    if (this.yFy.yCR != null) {
                        this.yFy.cuM();
                        this.yFy.yCR.ae(100000);
                    }
                }
            };
            this.yEM = (RelativeLayout) findViewById(R.h.bZU);
            this.yEN = (RelativeLayout) findViewById(R.h.bZT);
            this.yEQ = (ImageView) findViewById(R.h.cUH);
            this.yEQ.setOnClickListener(this);
            Display defaultDisplay = getWindowManager().getDefaultDisplay();
            x.d("MicroMsg.ImageGalleryUI", "%d is vertical screen orient %d [%d, %d]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(defaultDisplay.getWidth() < defaultDisplay.getHeight() ? 1 : 0), Integer.valueOf(defaultDisplay.getWidth()), Integer.valueOf(defaultDisplay.getHeight())});
            if (((defaultDisplay.getWidth() < defaultDisplay.getHeight() ? 1 : 0) == 0 ? null : 1) != null) {
                cvc();
            } else {
                cvd();
            }
            this.mxv = (ImageView) findViewById(R.h.ckv);
            this.mxv.setLayerType(2, null);
            this.mTN = (MMViewPager) findViewById(R.h.ckt);
            this.mTN.setLayerType(2, null);
            this.mTN.setVerticalFadingEdgeEnabled(false);
            this.mTN.setHorizontalFadingEdgeEnabled(false);
            this.mTN.yez = new MMViewPager.e(this) {
                final /* synthetic */ ImageGalleryUI yFy;

                {
                    this.yFy = r1;
                }

                public final void avW() {
                    ImageGalleryUI.h(this.yFy);
                }

                public final void aOz() {
                    this.yFy.avV();
                }
            };
            if (!this.yEO) {
                this.mTN.yeB = this.yFp;
                this.mTN.yeA = new 15(this);
            }
            this.mTN.xe(1);
            this.mTN.a(this.yCR);
            Gb(100000);
            this.mTN.ah(100000);
            this.mTN.postDelayed(new Runnable(this) {
                final /* synthetic */ ImageGalleryUI yFy;

                {
                    this.yFy = r1;
                }

                public final void run() {
                    if (this.yFy.yCR != null) {
                        if (g.a.cuF().yEF && this.yFy.yFl != null) {
                            this.yFy.yFl.setChecked(g.a.cuF().bo(this.yFy.yCR.cuy()));
                            this.yFy.yFm.setOnClickListener(this.yFy);
                        }
                        if (this.yFy.mTN.yF == 100000) {
                            this.yFy.cva();
                            b.b bc = b.bc(this.yFy.yCR.FL(100000));
                            if (!this.yFy.yFg && bc == b.b.yDy) {
                                this.yFy.yCR.FQ(100000);
                            }
                            if (bc == b.b.yDz) {
                                this.yFy.yCR.FU(100000);
                            }
                        }
                    }
                }
            }, 0);
            if (g.a.cuF().yEF) {
                this.yFk = ((ViewStub) findViewById(R.h.cLk)).inflate();
                this.yFk.setVisibility(0);
                this.yFl = (CheckBox) this.yFk.findViewById(R.h.cvv);
                this.yFm = this.yFk.findViewById(R.h.cvw);
            }
            this.yFd = getIntent().getBooleanExtra("img_gallery_enter_PhotoEditUI", false);
            com.tencent.mm.aq.e f = this.yCR.f(dH, true);
            if (f == null) {
                x.e("MicroMsg.ImageGalleryUI", "[initView] imgInfo is null!!! isSoonEnterPhotoEdit:%s", new Object[]{Boolean.valueOf(this.yFd)});
            }
            if (this.yFd && f != null && f.Pd()) {
                cve();
                this.yFd = false;
                return;
            } else if (this.yFd) {
                x.w("MicroMsg.ImageGalleryUI", "img not GetCompleted!");
                return;
            } else {
                return;
            }
        }
        x.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.fqm + ", msgSvrId = " + longExtra + ", stack = " + bh.cgy());
        finish();
    }

    private View a(b bVar, MMViewPager mMViewPager) {
        View view;
        String str = "MicroMsg.ImageGalleryUI";
        String str2 = "get current view adapter is null %b, gallery is null %b";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(bVar == null);
        objArr[1] = Boolean.valueOf(mMViewPager == null);
        x.d(str, str2, objArr);
        if (bVar == null || mMViewPager == null) {
            x.w("MicroMsg.ImageGalleryUI", "%d get current view but adapter or gallery is null", new Object[]{Integer.valueOf(hashCode())});
            view = null;
        } else if (bVar.cuy() == null) {
            return null;
        } else {
            if (bVar.cuy().cje() || bVar.cuy().cjm()) {
                view = bVar.qx(mMViewPager.yF);
            } else {
                if (bVar.cuy().cjh() || bVar.cuy().cji()) {
                    view = bVar.FP(mMViewPager.yF);
                }
                view = null;
            }
        }
        return view;
    }

    private void avV() {
        if (this.yEP || this.yCR == null) {
            x.i("MicroMsg.ImageGalleryUI", "isRunningExitAnimation");
        } else if (this.yEO) {
            finish();
            com.tencent.mm.ui.base.b.fF(this.mController.xIM);
        } else {
            int i;
            int i2;
            x.i("MicroMsg.ImageGalleryUI", "runExitAnimation");
            int width = this.mTN.getWidth() / 2;
            int height = this.mTN.getHeight() / 2;
            this.yCR.cuw();
            b glVar;
            if (this.yFf) {
                glVar = new gl();
                glVar.fwy.fqm = this.yCR.FL(this.mTN.yF).field_msgId;
                com.tencent.mm.sdk.b.a.xef.m(glVar);
                i = glVar.fwz.foN;
                i2 = glVar.fwz.foO;
                width = glVar.fwz.foL;
                height = glVar.fwz.foM;
            } else {
                cf FL = this.yCR.FL(this.mTN.yF);
                if (FL != null) {
                    glVar = new aq();
                    glVar.foJ.fnB = FL;
                    com.tencent.mm.sdk.b.a.xef.m(glVar);
                    i = glVar.foK.foN;
                    i2 = glVar.foK.foO;
                    width = glVar.foK.foL;
                    height = glVar.foK.foM;
                } else {
                    i2 = 0;
                    i = 0;
                }
                if (width == 0 && r0 == 0) {
                    width = this.mTN.getWidth() / 2;
                    height = this.mTN.getHeight() / 2;
                } else if (FL != null) {
                    if (FL.field_isSend == 0) {
                        this.yFb = com.tencent.mm.bv.a.fromDPToPix(this.mController.xIM, 5);
                    }
                    if (FL.field_isSend == 1) {
                        this.yFc = com.tencent.mm.bv.a.fromDPToPix(this.mController.xIM, 5);
                    }
                }
            }
            this.rzf = this.mTN.getWidth();
            this.rzg = this.mTN.getHeight();
            if (this.yCR.cuy() != null) {
                if (this.yCR.cuy().cji() || this.yCR.cuy().cjh()) {
                    this.rzg = (int) ((((float) this.rzf) / ((float) i)) * ((float) i2));
                }
                if (this.yCR.cuy().cje() || this.yCR.cuy().cjm()) {
                    this.yFa = this.yCR.qx(this.mTN.yF);
                }
            }
            if (this.yFa != null) {
                this.rzg = (int) ((((float) this.rzf) / ((float) this.yFa.imageWidth)) * ((float) this.yFa.imageHeight));
                if (this.rzg > this.mTN.getHeight()) {
                    if (((double) this.rzg) < ((double) this.mTN.getHeight()) * 1.5d) {
                        if (this.yFf) {
                            this.rzh = this.rzg - this.mTN.getHeight();
                        } else {
                            i2 = (i2 * this.mTN.getHeight()) / this.rzg;
                        }
                    }
                    this.rzg = this.mTN.getHeight();
                }
            }
            g gVar = this.kSb;
            int i3 = this.yFb;
            int i4 = this.yFc;
            gVar.rpI = i3;
            gVar.rpJ = i4;
            gVar.rpK = 0;
            gVar.rpL = 0;
            this.kSb.rpH = this.rzh;
            this.kSb.fg(this.rzf, this.rzg);
            this.kSb.r(width, height, i, i2);
            View view = this.mTN;
            View a = a(this.yCR, this.mTN);
            if (a == null) {
                a = view;
            } else if (((double) this.rzi) != 1.0d) {
                this.kSb.zkM = 1.0f / this.rzi;
                if (!(this.rzj == 0 && this.rzk == 0)) {
                    this.kSb.fh(((int) (((float) (this.mTN.getWidth() / 2)) * (1.0f - this.rzi))) + this.rzj, (int) (((float) ((this.mTN.getHeight() / 2) + this.rzk)) - (((float) (this.rzg / 2)) * this.rzi)));
                }
            }
            this.kSb.a(a, this.mxv, new 19(this), null);
        }
    }

    protected final void mT(boolean z) {
        if (this.yCR != null && this.yFo >= 0) {
            cf FL = this.yCR.FL(this.yFo);
            int bk = this.yCR.yCX.bk(FL);
            if (bk == 5 || bk == 6) {
                x.w("MicroMsg.ImageGalleryUI", "jacks fail downloaded img, return");
            } else if (this.yCR.bb(FL)) {
                x.w("MicroMsg.ImageGalleryUI", "jacks downloading, return");
            } else if (b.aX(FL) && i.bq(FL) == null) {
                x.w("MicroMsg.ImageGalleryUI", "video info is null, return now.");
            } else {
                final List arrayList = new ArrayList();
                final List arrayList2 = new ArrayList();
                arrayList.add(Integer.valueOf(0));
                arrayList2.add(getString(R.l.eEG));
                if (com.tencent.mm.bm.d.OQ("favorite")) {
                    arrayList.add(Integer.valueOf(2));
                    arrayList2.add(getString(R.l.eAd));
                }
                if (b.aW(FL) || b.ba(FL)) {
                    arrayList.add(Integer.valueOf(1));
                    arrayList2.add(getString(R.l.eHe));
                } else if (b.aX(FL) || b.aY(FL)) {
                    arrayList.add(Integer.valueOf(1));
                    arrayList2.add(getString(R.l.eHh));
                } else {
                    arrayList.add(Integer.valueOf(1));
                    arrayList2.add(getString(R.l.eHg));
                }
                if (b.aW(FL) || b.aY(FL)) {
                    b dhVar = new dh();
                    dhVar.frQ.fqm = FL.field_msgId;
                    com.tencent.mm.sdk.b.a.xef.m(dhVar);
                    if (dhVar.frR.frp || com.tencent.mm.pluginsdk.model.app.g.R(this.mController.xIM, FL.getType())) {
                        arrayList.add(Integer.valueOf(4));
                        arrayList2.add(getString(R.l.dRM));
                    }
                }
                if (b.aW(FL)) {
                    arrayList.add(Integer.valueOf(6));
                    arrayList2.add(getString(R.l.dRk));
                }
                if (!(this.rsF == null || this.yFh)) {
                    Object string;
                    arrayList.add(Integer.valueOf(3));
                    if (com.tencent.mm.plugin.scanner.a.az(this.juU, this.rsF)) {
                        string = getString(R.l.eCr);
                    } else {
                        string = getString(R.l.eCq);
                    }
                    arrayList2.add(string);
                }
                if (!(this.ysa || this.vnK || g.a.cuF().yEF || this.yFh)) {
                    arrayList.add(Integer.valueOf(5));
                    arrayList2.add(getString(R.l.dRj));
                }
                if (this.rsB == null || !this.rsG) {
                    this.rsB = new com.tencent.mm.ui.widget.g(this.mController.xIM, com.tencent.mm.ui.widget.g.ztp, false);
                } else {
                    this.rsG = false;
                }
                this.rsB.rKC = new p.c(this) {
                    final /* synthetic */ ImageGalleryUI yFy;

                    public final void a(n nVar) {
                        nVar.clear();
                        for (int i = 0; i < arrayList.size(); i++) {
                            nVar.f(((Integer) arrayList.get(i)).intValue(), (CharSequence) arrayList2.get(i));
                        }
                    }
                };
                this.rsB.rKD = this.lET;
                this.rsB.bUk();
                this.rsB.ztB = new 3(this);
                if ((b.aW(FL) || b.ba(FL)) && true == z && ar.CG().Km() != 0 && !this.yFh) {
                    String str = null;
                    if (b.aW(FL)) {
                        com.tencent.mm.aq.e f = this.yCR.f(FL, true);
                        if (f != null) {
                            str = d.d(FL, f);
                        }
                    } else {
                        str = b.bg(FL);
                    }
                    if (str != null) {
                        b mpVar = new mp();
                        mpVar.fEA.filePath = str;
                        this.rsC = str;
                        com.tencent.mm.sdk.b.a.xef.m(mpVar);
                    }
                }
            }
        }
    }

    public final void ft(boolean z) {
        int i = 8;
        if (!z || this.yEM.getVisibility() != 0) {
            if (z || this.yEM.getVisibility() != 8) {
                RelativeLayout relativeLayout = this.yEM;
                if (z) {
                    i = 0;
                }
                relativeLayout.setVisibility(i);
                this.yEM.startAnimation(AnimationUtils.loadAnimation(this.mController.xIM, z ? R.a.bpO : R.a.bpP));
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dlE;
    }

    protected final void onCreateBeforeSetContentView() {
        super.onCreateBeforeSetContentView();
    }

    private void cuM() {
        if (this.yCR != null && !this.yEO && this.yCR.cux() && cuJ().yER != null) {
            if (g.a.cuF().yEF) {
                cuO();
            } else if (this.ysa || this.yFh) {
                cuO();
            } else {
                x.d("MicroMsg.ImageGalleryUI", "%d show enter grid is video %b", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(cuP())});
                cuN();
                cva();
            }
        }
    }

    private void cuN() {
        int i = 0;
        M(cuJ().yER, 0);
        View view = cuK().yES;
        if (this.yEL != b.b.yDx) {
            i = 8;
        }
        M(view, i);
    }

    private void cuO() {
        M(cuJ().yER, 8);
        M(cuK().yES, 8);
    }

    private static boolean e(au auVar, com.tencent.mm.aq.e eVar) {
        if (eVar == null) {
            return false;
        }
        try {
            if (b.b(auVar, eVar) == 0 && eVar.Pe() && !auVar.cjs()) {
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            x.e("MicroMsg.ImageGalleryUI", "error:" + e);
            return false;
        }
    }

    public final void Gb(int i) {
        bp(this.yCR.FL(i));
    }

    private boolean cuP() {
        if (this.yEL == b.b.yDy) {
            return true;
        }
        return false;
    }

    protected final void cuQ() {
        if (this.yFq) {
            this.yFr.J(4000, 4000);
        }
    }

    public final void cuR() {
        x.i("MicroMsg.ImageGalleryUI", "show video tool bar");
        ft(true);
        mU(true);
        M(this.yEU, 8);
        M(cuI().yEY, 0);
        M(this.yEQ, 0);
        cuJ().yER.clearAnimation();
        if (this.yEO) {
            cuO();
        } else {
            cuN();
        }
        cvb();
        this.yFq = true;
        cuQ();
    }

    public final void cuS() {
        x.i("MicroMsg.ImageGalleryUI", "hide video tool bar");
        mU(false);
        M(cuI().yEY, 8);
        M(this.yEQ, 8);
        if (cuP()) {
            cvb();
            cuO();
        }
        this.yFq = false;
    }

    private void mU(boolean z) {
        x.d("MicroMsg.ImageGalleryUI", "switch tool bar bg %b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.yEN.setBackgroundResource(R.g.bDd);
            this.yEM.setBackgroundResource(R.g.bDc);
            return;
        }
        dq(this.yEN);
        dq(this.yEM);
    }

    private static void dq(View view) {
        if (com.tencent.mm.compatible.util.d.fM(16)) {
            view.setBackground(null);
        } else {
            view.setBackgroundDrawable(null);
        }
    }

    public final synchronized void bp(au auVar) {
        int i = 0;
        synchronized (this) {
            this.yEL = b.bc(auVar);
            x.i("MicroMsg.ImageGalleryUI", "updateFooterInfo currGalleryType : " + this.yEL);
            if (g.a.cuF().yEF && this.yFl != null) {
                this.yFl.setChecked(g.a.cuF().bo(auVar));
            }
            switch (AnonymousClass11.yDh[this.yEL.ordinal()]) {
                case 1:
                    cuS();
                    M(this.yEU, 8);
                    mV(true);
                    r bq = i.bq(auVar);
                    if (bq != null) {
                        cuI().yEZ.wl(bq.hVH);
                        try {
                            if (!(this.yCR.cuz() == null || this.yCR.cuz().yGl == null)) {
                                i = this.yCR.cuz().yGl.getCurrentPosition() / 1000;
                            }
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.ImageGalleryUI", e, "", new Object[0]);
                        }
                        cuI().yEZ.seek(i);
                        break;
                    }
                    break;
                case 2:
                    com.tencent.mm.aq.e f = this.yCR.f(auVar, false);
                    cuS();
                    cuM();
                    if (f != null) {
                        i = this.mTN.yF;
                        if (e(auVar, f) && !auVar.cjs() && f.Pd()) {
                            cuH().yEV.setVisibility(0);
                            cuH().yEW.setVisibility(8);
                            cuH().yEX.setVisibility(8);
                            String str = (String) this.yFs.get(Long.valueOf(f.hzP));
                            if (str == null) {
                                Map y = bi.y(f.hAa, "msg");
                                if (y == null) {
                                    x.e("MicroMsg.ImageGalleryUI", "parse cdnInfo failed. [%s]", new Object[]{f.hAa});
                                    i = -1;
                                } else {
                                    i = bh.getInt((String) y.get(".msg.img.$hdlength"), 0);
                                }
                                long j = (long) i;
                                if (j < 0) {
                                    str = "";
                                } else {
                                    BigDecimal bigDecimal = new BigDecimal(j);
                                    float floatValue = bigDecimal.divide(new BigDecimal(1048576), 2, 0).floatValue();
                                    str = floatValue > 1.0f ? ((int) floatValue) + "M" : ((int) bigDecimal.divide(new BigDecimal(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT), 2, 0).floatValue()) + "K";
                                }
                                this.yFs.put(Long.valueOf(f.hzP), str);
                            }
                            cuH().yEV.setText(getString(R.l.dXR, new Object[]{str}));
                            M(this.yEU, 0);
                        } else {
                            M(this.yEU, 8);
                        }
                        if (!this.yFd || !f.Pd() || this.yCR.cuy() == null || auVar.field_msgId != this.yCR.cuy().field_msgId) {
                            cf cuy = this.yCR.cuy();
                            String str2 = "MicroMsg.ImageGalleryUI";
                            String str3 = "isSoonEnterPhotoEdit:%s msgId:%s curMsgId:%s getCompleted:%s";
                            Object[] objArr = new Object[4];
                            objArr[0] = Boolean.valueOf(this.yFd);
                            objArr[1] = Long.valueOf(auVar.field_msgId);
                            objArr[2] = cuy == null ? "null" : Long.valueOf(cuy.field_msgId);
                            objArr[3] = Boolean.valueOf(f.Pd());
                            x.w(str2, str3, objArr);
                            break;
                        }
                        x.i("MicroMsg.ImageGalleryUI", "get image successfully! -> gotoPhotoEditUI msgId:%s", new Object[]{Long.valueOf(auVar.field_msgId)});
                        cve();
                        this.yFd = false;
                        break;
                    }
                    x.w("MicroMsg.ImageGalleryUI", "updateFooterInfo img info is null");
                    break;
                    break;
                case 3:
                    cuS();
                    cuM();
                    break;
                case 4:
                    cuS();
                    cuM();
                    M(this.yEU, 8);
                    this.yCR.FU(this.mTN.yF);
                    break;
            }
        }
    }

    private void Gc(int i) {
        x.i("MicroMsg.ImageGalleryUI", "enterGrid source : " + i);
        if (this.yCR == null) {
            x.w("MicroMsg.ImageGalleryUI", "try to enterGrid, but adapter is NULL");
            return;
        }
        com.tencent.mm.plugin.report.service.g.pQN.a(219, 13, 1, true);
        int aCQ = this.yCR.aCQ();
        if (this.yCR.cuy() == null) {
            x.e("MicroMsg.ImageGalleryUI", "msgInfo is null");
            return;
        }
        int FV = this.yCR.yCT.FV(this.mTN.yF);
        if (this.yFf) {
            avV();
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this.mController.xIM, MediaHistoryGalleryUI.class);
        intent.addFlags(67108864);
        intent.putExtra("kintent_intent_source", i);
        intent.putExtra("kintent_talker", cuL());
        intent.putExtra("kintent_image_count", aCQ);
        intent.putExtra("kintent_image_index", FV);
        intent.putExtra("key_biz_chat_id", this.kGB);
        intent.putExtra("key_is_biz_chat", this.vnK);
        startActivity(intent);
        com.tencent.mm.ui.base.b.fF(this.mController.xIM);
        this.mHandler.postDelayed(new 7(this), 50);
    }

    public final int cuT() {
        return this.mTN.yF;
    }

    public void onClick(View view) {
        boolean z = true;
        if (this.yCR != null) {
            if (view.getId() == R.h.cnN) {
                Gc(0);
            } else if (view.getId() == R.h.ccv) {
                x.i("MicroMsg.ImageGalleryUI", "[oreh download_and_save] hdImg suc, curPos:%d", new Object[]{Integer.valueOf(this.mTN.yF)});
                M(cuK().yES, 8);
                au FL = this.yCR.FL(this.mTN.yF);
                com.tencent.mm.aq.e f = this.yCR.f(FL, false);
                int i = this.mTN.yF;
                if (e(FL, f) && !FL.cjs() && f.Pd()) {
                    this.yCR.ah(this.mTN.yF, true);
                } else {
                    b.b(this.mController.xIM, this.yCR.cuy(), true);
                }
            } else if (view.getId() == R.h.bZV) {
                this.yCR.ah(this.mTN.yF, false);
            } else if (view.getId() == R.h.bZW) {
                this.yCR.FT(this.mTN.yF);
                Gb(this.mTN.yF);
                cuX();
                cuY();
                cva();
            } else if (view.getId() == R.h.bIV) {
                onBackPressed();
            } else if (view.getId() == R.h.cUH) {
                onBackPressed();
            } else if (view.getId() == R.h.cvw) {
                boolean isChecked = this.yFl.isChecked();
                if (isChecked || g.a.cuF().yDd.size() < 9) {
                    CheckBox checkBox = this.yFl;
                    if (isChecked) {
                        z = false;
                    }
                    checkBox.setChecked(z);
                    if (this.yFl.isChecked()) {
                        g.a.cuF().bm(this.yCR.cuy());
                        return;
                    } else {
                        g.a.cuF().bn(this.yCR.cuy());
                        return;
                    }
                }
                Toast.makeText(this, getResources().getString(R.l.ely, new Object[]{Integer.valueOf(9)}), 1).show();
            } else if (view.getId() == R.h.cCD) {
                this.yCR.FQ(this.mTN.yF);
            }
        }
    }

    public static void cuU() {
    }

    public final void mV(boolean z) {
        try {
            cuI().yEZ.db(!z);
        } catch (Exception e) {
            x.e("MicroMsg.ImageGalleryUI", "set video state iv error : " + e.toString());
        }
    }

    public final boolean bQg() {
        return cuI().yEZ.fvG;
    }

    public final void Gd(int i) {
        if (cuI().yEY != null) {
            cuI().yEY.post(new 8(this, i));
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 82 || keyEvent.getAction() != 1) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (this.rsB != null) {
            this.rsB.bxh();
            this.rsB = null;
            return true;
        }
        mT(true);
        return true;
    }

    final void cuV() {
        if (cuJ().yER != null && !this.yFw) {
            String str = "MicroMsg.ImageGalleryUI";
            String str2 = "fadeOutEnterGirdBtn: %B";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(this.yER.getVisibility() == 0);
            x.d(str, str2, objArr);
            Animation Ge = Ge(300);
            Ge.setFillAfter(false);
            Ge.setAnimationListener(new 9(this));
            cuJ().yER.startAnimation(Ge);
            this.yFw = true;
        }
    }

    final void cuW() {
        if (cuJ().yET != null && !this.yFx) {
            cuJ().yET.startAnimation(Ge(300));
            this.yFx = true;
        }
    }

    private void cuX() {
        if (cuJ().yER != null && this.yFw && !cuP()) {
            String str = "MicroMsg.ImageGalleryUI";
            String str2 = "fadeInEnterGirdBtn: %B %s";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(cuJ().yER.getVisibility() == 0);
            objArr[1] = bh.cgy();
            x.d(str, str2, objArr);
            cuJ().yER.startAnimation(cuZ());
            cuK().yES.startAnimation(cuZ());
            this.yFw = false;
        }
    }

    private void cuY() {
        boolean z = true;
        if (cuJ().yET != null && this.yFx) {
            String str = "MicroMsg.ImageGalleryUI";
            String str2 = "fadeInPositionAtChatRecordBtn: %B";
            Object[] objArr = new Object[1];
            if (cuJ().yET.getVisibility() != 0) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.d(str, str2, objArr);
            cuJ().yET.startAnimation(cuZ());
            this.yFx = false;
        }
    }

    private static Animation cuZ() {
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(150);
        alphaAnimation.setFillAfter(true);
        return alphaAnimation;
    }

    static Animation Ge(int i) {
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration((long) i);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setInterpolator(new AccelerateInterpolator(10.0f));
        return alphaAnimation;
    }

    public final boolean uF() {
        cuV();
        cuW();
        return false;
    }

    protected final void cva() {
        Object obj = (dp(this.yEU) == 0 && dp(this.yEV) == 0) ? 1 : null;
        if (obj == null && this.yCR != null) {
            x.d("MicroMsg.ImageGalleryUI", "jacks start Hide Timer");
            this.yFv.J(4000, 4000);
        }
    }

    private void cvb() {
        x.d("MicroMsg.ImageGalleryUI", "jacks stop Hide Timer");
        this.yFv.TG();
    }

    public final void Gf(int i) {
        ft(true);
        cuS();
        cuH().yEU.setVisibility(0);
        cuH().yEV.setVisibility(8);
        cuH().yEW.setVisibility(0);
        cuH().yEX.setVisibility(8);
        cuV();
        cuW();
        cuH().yEW.setText(i + "%");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void finish() {
        this.yBx.clear();
        super.finish();
    }

    public final int gm(long j) {
        if (bh.ov(this.yFi)) {
            return 0;
        }
        try {
            int f = t.f(j, this.yFi);
            if (f == -1) {
                this.yFi = null;
                f = 0;
            }
            x.d("MicroMsg.ImageGalleryUI", "get enter video op code %d %s", new Object[]{Integer.valueOf(f), this.yFi});
            return f;
        } catch (Exception e) {
            x.e("MicroMsg.ImageGalleryUI", "get enter video op code error : " + e.toString());
            return 0;
        }
    }

    public final void gn(long j) {
        if (!bh.ov(this.yFi) && j != 0 && t.f(j, this.yFi) == -1) {
            this.yFi = null;
            x.d("MicroMsg.ImageGalleryUI", "reset enter video op code %s", new Object[]{this.yFi});
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            x.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is vertical screen", new Object[]{Integer.valueOf(hashCode())});
            cvc();
        } else if (configuration.orientation == 2) {
            x.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is horizontal screen", new Object[]{Integer.valueOf(hashCode())});
            cvd();
        }
    }

    private void cvc() {
        x.i("MicroMsg.ImageGalleryUI", "%d handleVerticalUI image gallery ui isNavigationBarTint %b isNavBarVisibility %b navBarHeight %d", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(this.oqs), Boolean.valueOf(ae.fy(this)), Integer.valueOf(ae.fx(this))});
        if (this.oqs && r0) {
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.yEM.getLayoutParams());
            layoutParams.addRule(12);
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, r1);
            this.yEM.setLayoutParams(layoutParams);
            layoutParams = new RelativeLayout.LayoutParams(this.yEN.getLayoutParams());
            layoutParams.addRule(10);
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, 0, layoutParams.bottomMargin);
            this.yEN.setLayoutParams(layoutParams);
        }
    }

    private void cvd() {
        boolean fy = ae.fy(this);
        int fx = ae.fx(this);
        x.i("MicroMsg.ImageGalleryUI", "%d handleHorizontalUI image gallery ui isNavigationBarTint %b isNavBarVisibility %b navBarHeight %d", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(this.oqs), Boolean.valueOf(fy), Integer.valueOf(fx)});
        if (this.oqs && fy) {
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.yEM.getLayoutParams());
            layoutParams.addRule(12);
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, fx, 0);
            this.yEM.setLayoutParams(layoutParams);
            layoutParams = new RelativeLayout.LayoutParams(this.yEN.getLayoutParams());
            layoutParams.addRule(10);
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, fx, layoutParams.bottomMargin);
            this.yEN.setLayoutParams(layoutParams);
        }
    }

    private void cve() {
        String stringExtra = getIntent().getStringExtra("GalleryUI_FromUser");
        String stringExtra2 = getIntent().getStringExtra("GalleryUI_ToUser");
        Intent intent = new Intent();
        cf cuy = this.yCR.cuy();
        x.i("MicroMsg.ImageGalleryUI", "edit image path:%s msgId:%s", new Object[]{d.d(cuy, d.bl(cuy)), Long.valueOf(cuy.field_msgId)});
        intent.putExtra("before_photo_edit", r4);
        intent.putExtra("GalleryUI_FromUser", stringExtra);
        intent.putExtra("GalleryUI_ToUser", stringExtra2);
        intent.putExtra("GalleryUI_ToUser", stringExtra2);
        intent.putExtra("from_scene", JsApiCreateAudioInstance.CTRL_INDEX);
        intent.putExtra("after_photo_edit", "");
        com.tencent.mm.bm.d.b(this, "photoedit", ".ui.MMNewPhotoEditUI", intent, 4369);
        overridePendingTransition(0, 0);
    }

    protected final int getForceOrientation() {
        return 2;
    }
}
