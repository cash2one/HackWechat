package com.tencent.mm.plugin.card.ui;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.z.ar;

@a(3)
public class CardGiftVideoUI extends MMActivity implements com.tencent.mm.plugin.card.b.a.a, f.a {
    private l contextMenuHelper;
    int duration = 0;
    private CardGiftInfo kRT;
    private ImageView kRU;
    private ProgressBar kRX;
    private af kRY = new af(Looper.getMainLooper());
    private Bundle kRZ;
    private boolean kSa = false;
    private g kSb;
    private int kSc = 0;
    private int kSd = 0;
    private int kSe = 0;
    private int kSf = 0;
    private boolean kTc;
    private RelativeLayout kTd;
    private f kTe;
    private RelativeLayout kTf;
    private ImageView kTg;
    TextView kTh;
    private MMPinProgressBtn kTi;
    private TextView kTj;
    private ak kTk = new ak(new 10(this), true);
    private String videoPath;

    class AnonymousClass11 implements Runnable {
        final /* synthetic */ CardGiftVideoUI kTl;
        final /* synthetic */ boolean kTn = true;

        AnonymousClass11(CardGiftVideoUI cardGiftVideoUI, boolean z) {
            this.kTl = cardGiftVideoUI;
        }

        public final void run() {
            x.i("MicroMsg.CardGiftVideoUI", "%d switch video model isVideoPlay %b", new Object[]{Integer.valueOf(this.kTl.hashCode()), Boolean.valueOf(this.kTn)});
            if (this.kTn) {
                ((View) this.kTl.kTe).setVisibility(0);
                this.kTl.kTg.setVisibility(8);
                return;
            }
            ((View) this.kTl.kTe).setVisibility(8);
            this.kTl.kTg.setVisibility(0);
        }
    }

    public void onCreate(Bundle bundle) {
        if (getIntent().getExtras() != null) {
            getIntent().getExtras().setClassLoader(getClass().getClassLoader());
        }
        super.onCreate(bundle);
        this.mController.hideTitleView();
        this.kRZ = bundle;
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        if (ar.ux() != null) {
            ar.ux().wB();
        }
        this.kRT = (CardGiftInfo) getIntent().getParcelableExtra("key_gift_into");
        this.videoPath = getIntent().getStringExtra("key_video_path");
        this.kTc = getIntent().getBooleanExtra("key_is_mute", false);
        String str = "MicroMsg.CardGiftVideoUI";
        String str2 = "cardGiftInfo %s";
        Object[] objArr = new Object[1];
        objArr[0] = this.kRT == null ? "null" : this.kRT.toString();
        x.d(str, str2, objArr);
        x.d("MicroMsg.CardGiftVideoUI", "videoPath:%s, isMute:%b", new Object[]{this.videoPath, Boolean.valueOf(this.kTc)});
        initView();
        com.tencent.mm.plugin.card.b.a.a(this);
        avX();
        if (this.kRT == null) {
            x.e("MicroMsg.CardGiftVideoUI", "cardGiftInfo is null");
        } else if (bh.ov(this.kRT.kKi)) {
            x.e("MicroMsg.CardGiftVideoUI", "fromUserContentVideoUrl is null");
        } else {
            com.tencent.mm.plugin.card.b.a.g(this.kRT.kKj, this.kRT.kKm, this.kRT.kKv, 2);
            com.tencent.mm.plugin.card.b.a.g(this.kRT.kKi, this.kRT.kKl, this.kRT.kKu, 1);
        }
    }

    private void wC(String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.CardGiftVideoUI", "the videoPath is null, fail~!!!");
            setResult(0);
            finish();
        } else if (e.bO(str)) {
            this.kTe.setVideoPath(str);
        } else {
            x.e("MicroMsg.CardGiftVideoUI", "the videoPath is %s, the file isn't exist~!!!", new Object[]{str});
            setResult(0);
            finish();
        }
    }

    private void avX() {
        if (this.contextMenuHelper == null) {
            this.contextMenuHelper = new l(this.mController.xIM);
        }
        if (bh.ov(this.videoPath)) {
            x.e("MicroMsg.CardGiftVideoUI", "videoPath is null");
        } else {
            this.contextMenuHelper.a((VideoTextureView) this.kTe, new 1(this), new d(this) {
                final /* synthetic */ CardGiftVideoUI kTl;

                {
                    this.kTl = r1;
                }

                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    switch (menuItem.getItemId()) {
                        case 0:
                            String nG = t.nG(this.kTl.videoPath);
                            if (bh.ov(nG)) {
                                Toast.makeText(this.kTl, this.kTl.getString(R.l.eTd), 1).show();
                                return;
                            }
                            Toast.makeText(this.kTl, this.kTl.getString(R.l.eTe, new Object[]{nG}), 1).show();
                            k.b(nG, this.kTl);
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    protected final void initView() {
        this.kTd = (RelativeLayout) findViewById(R.h.cVB);
        this.kTf = (RelativeLayout) findViewById(R.h.cVu);
        this.kTg = (ImageView) findViewById(R.h.cVw);
        this.kTh = (TextView) findViewById(R.h.cUS);
        this.kTi = (MMPinProgressBtn) findViewById(R.h.cVj);
        this.kRX = (ProgressBar) findViewById(R.h.cVb);
        this.kTj = (TextView) findViewById(R.h.cVz);
        this.kTe = new VideoTextureView(this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.kTe.setMute(this.kTc);
        this.kTe.a(this);
        this.kTf.addView((View) this.kTe, layoutParams);
        this.kRU = (ImageView) findViewById(R.h.ckv);
        this.kRU.setLayerType(2, null);
        this.kTd.setOnTouchListener(new 6(this));
        ((View) this.kTe).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CardGiftVideoUI kTl;

            {
                this.kTl = r1;
            }

            public final void onClick(View view) {
                this.kTl.avV();
            }
        });
        this.kSb = new g(this);
    }

    public void onStart() {
        Bundle bundle = this.kRZ;
        if (!this.kSa) {
            this.kSa = true;
            if (VERSION.SDK_INT < 12) {
                x.e("MicroMsg.CardGiftVideoUI", "version is %d, no animation", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
            } else {
                this.kSc = getIntent().getIntExtra("img_top", 0);
                this.kSd = getIntent().getIntExtra("img_left", 0);
                this.kSe = getIntent().getIntExtra("img_width", 0);
                this.kSf = getIntent().getIntExtra("img_height", 0);
                this.kSb.r(this.kSd, this.kSc, this.kSe, this.kSf);
                if (bundle == null) {
                    this.kTd.getViewTreeObserver().addOnPreDrawListener(new 8(this));
                }
            }
        }
        super.onStart();
    }

    protected void onResume() {
        if (!bh.ov(this.videoPath)) {
            wC(this.videoPath);
        }
        super.onResume();
    }

    protected void onPause() {
        this.kTe.pause();
        super.onPause();
    }

    protected void onDestroy() {
        this.kTe.stop();
        this.kTk.TG();
        com.tencent.mm.plugin.card.b.a.b(this);
        super.onDestroy();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        x.d("MicroMsg.CardGiftVideoUI", "dispatchKeyEvent");
        avV();
        return true;
    }

    public final void avV() {
        this.kSb.r(this.kSd, this.kSc, this.kSe, this.kSf);
        this.kSb.a(this.kTd, this.kRU, new 9(this), null);
    }

    protected final int getLayoutId() {
        return R.i.dce;
    }

    public final void onError(int i, int i2) {
        setResult(0);
        this.kTe.stop();
        x.e("MicroMsg.CardGiftVideoUI", "%d on play video error what %d extra %d.", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final void hX() {
        setResult(-1);
        this.kRY.post(new AnonymousClass11(this, true));
        this.kRY.post(new 12(this));
        this.kTe.start();
        this.duration = this.kTe.getDuration() / 1000;
        this.kTk.J(500, 500);
        x.i("MicroMsg.CardGiftVideoUI", "onPrepared videoView.start duration:%d", new Object[]{Integer.valueOf(this.duration)});
    }

    public final void vh() {
        x.i("MicroMsg.CardGiftVideoUI", "%d on completion", new Object[]{Integer.valueOf(hashCode())});
        this.kTe.q(0.0d);
    }

    public final int cf(int i, int i2) {
        return 0;
    }

    public final void cg(int i, int i2) {
    }

    public final void aW(String str, int i) {
        if (str.equals(this.kRT.kKi)) {
            this.kRY.post(new 2(this, 100, i));
        }
    }

    public final void fail(String str) {
    }

    public final void bU(String str, final String str2) {
        if (str.equals(this.kRT.kKi)) {
            this.kRY.post(new Runnable(this) {
                final /* synthetic */ CardGiftVideoUI kTl;

                public final void run() {
                    this.kTl.kTg.setVisibility(8);
                    this.kTl.videoPath = str2;
                    this.kTl.wC(this.kTl.videoPath);
                    this.kTl.avX();
                }
            });
        } else if (str.equals(this.kRT.kKj)) {
            this.kRY.post(new 4(this, str2));
        } else {
            x.i("MicroMsg.CardGiftVideoUI", "fieldId:%s is unsuitable", new Object[]{str});
        }
    }
}
