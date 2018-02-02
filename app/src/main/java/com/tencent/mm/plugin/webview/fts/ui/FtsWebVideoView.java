package com.tencent.mm.plugin.webview.fts.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.webview.fts.c.b.a;
import com.tencent.mm.plugin.webview.fts.c.c;
import com.tencent.mm.plugin.webview.fts.c.d;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;

public class FtsWebVideoView extends RelativeLayout {
    private boolean acS;
    private boolean jsC;
    private boolean jsD;
    private int jsE;
    private String jsF;
    private TextView jsk;
    private LinearLayout jsq;
    private TextView jss;
    private ImageView jst;
    private ImageView jsu;
    public String jsv;
    public int jsw;
    public boolean jsx;
    private boolean jsz;
    public boolean kTc;
    private boolean mAutoPlay;
    private ImageView tpl;
    private b tqQ = b.AUTO;
    public FtsVideoWrapper tqR;
    public FtsWebVideoViewControlBar tqS;
    private View tqT;
    private View tqU;
    private FtsWebDotPercentIndicator tqV;
    private View tqW;
    private Button tqX;
    private TextView tqY;
    private TextView tqZ;
    private a tra;
    public a trb;
    public d trc;
    public a trd;
    public int tre;
    public boolean trf;
    private ImageView trg;
    private long trh;
    private View tri;
    private View trj;
    private int trk = c.trr;
    public BroadcastReceiver trl = new 10(this);
    private String url;

    private enum b {
        AUTO,
        LANDSCAPE,
        PORTRAIT
    }

    static /* synthetic */ void q(FtsWebVideoView ftsWebVideoView) {
        ftsWebVideoView.tqT.setVisibility(0);
        ftsWebVideoView.tqU.setVisibility(8);
        ftsWebVideoView.tqW.setVisibility(0);
        ftsWebVideoView.bQk();
    }

    static /* synthetic */ void v(FtsWebVideoView ftsWebVideoView) {
        ftsWebVideoView.kTc = !ftsWebVideoView.kTc;
        ftsWebVideoView.tqR.setMute(ftsWebVideoView.kTc);
        if (ftsWebVideoView.kTc) {
            ftsWebVideoView.tqS.At();
        } else {
            ftsWebVideoView.tqS.bQp();
        }
    }

    public FtsWebVideoView(Context context, boolean z) {
        super(context);
        setAutoPlay(z);
        init(context);
    }

    public FtsWebVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public FtsWebVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.i.djl, this);
        this.tqR = (FtsVideoWrapper) findViewById(R.h.cVC);
        this.jsk = (TextView) findViewById(R.h.progress);
        this.tqT = findViewById(R.h.cRL);
        this.tqU = findViewById(R.h.cSc);
        this.jsq = (LinearLayout) findViewById(R.h.bJx);
        this.tqV = (FtsWebDotPercentIndicator) findViewById(R.h.bJy);
        this.jss = (TextView) findViewById(R.h.bJv);
        this.jst = (ImageView) findViewById(R.h.bJw);
        this.jsu = (ImageView) findViewById(R.h.bZl);
        this.tri = findViewById(R.h.cVb);
        this.trj = findViewById(R.h.cSd);
        this.tqV.bQj();
        this.tpl = (ImageView) findViewById(R.h.bZn);
        this.tqW = findViewById(R.h.bZu);
        this.tqY = (TextView) findViewById(R.h.cRM);
        this.tqX = (Button) findViewById(R.h.cRN);
        this.tqZ = (TextView) findViewById(R.h.cRP);
        this.trg = (ImageView) findViewById(R.h.cfH);
        this.tqY.setOnClickListener(new 1(this));
        this.trg.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FtsWebVideoView trm;

            {
                this.trm = r1;
            }

            public final void onClick(View view) {
                this.trm.kl(!this.trm.agN());
            }
        });
        this.tqX.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FtsWebVideoView trm;

            {
                this.trm = r1;
            }

            public final void onClick(View view) {
                if (this.trm.trk == c.trs) {
                    this.trm.trf = true;
                }
                this.trm.kk(true);
            }
        });
        this.tqW.setOnClickListener(new 9(this));
        this.tra = new a(getContext(), this, new 12(this));
        this.tqR.jte = new 13(this);
        this.tqS = new FtsWebVideoViewControlBar(getContext());
        this.tqS.setVisibility(8);
        this.tqS.l(new 14(this));
        this.tqS.m(new OnClickListener(this) {
            final /* synthetic */ FtsWebVideoView trm;

            {
                this.trm = r1;
            }

            public final void onClick(View view) {
                this.trm.kl(!this.trm.agN());
            }
        });
        this.tqS.k(new 3(this));
        this.tqS.quk = new 4(this);
        this.tqS.i(new 5(this));
        this.tqS.trx = new 6(this);
        this.tqR.a(this.tqS);
        context.registerReceiver(this.trl, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        bQl();
    }

    private boolean dM(final Context context) {
        int i = this.trk;
        if (!an.isConnected(context)) {
            if (i == c.trt) {
                this.tri.setVisibility(0);
                this.trj.setVisibility(8);
                this.tqT.setVisibility(0);
                postDelayed(new Runnable(this) {
                    final /* synthetic */ FtsWebVideoView trm;

                    public final void run() {
                        this.trm.dN(context);
                    }
                }, 200);
            } else {
                dN(context);
            }
            return false;
        } else if (this.trf || an.isWifi(context)) {
            return true;
        } else {
            String string;
            pause();
            this.trk = c.trs;
            this.tqS.setVisibility(8);
            if (this.tre == 0) {
                string = getContext().getString(R.l.eTh);
            } else {
                Context context2 = getContext();
                int i2 = R.l.eTg;
                Object[] objArr = new Object[1];
                long j = (long) this.tre;
                if (j < 0) {
                    string = "";
                } else {
                    BigDecimal bigDecimal = new BigDecimal(j);
                    float floatValue = bigDecimal.divide(new BigDecimal(1048576), 2, 0).floatValue();
                    if (floatValue > 1.0f) {
                        string = ((int) floatValue) + "M";
                    } else {
                        string = ((int) bigDecimal.divide(new BigDecimal(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT), 2, 0).floatValue()) + "K";
                    }
                }
                objArr[0] = string;
                string = context2.getString(i2, objArr);
            }
            String string2 = context.getString(R.l.eST);
            context.getString(R.l.eSQ);
            eK(string, string2);
            return false;
        }
    }

    private void dN(Context context) {
        this.trk = c.trt;
        pause();
        eK(context.getString(R.l.eTf), context.getString(R.l.eTp));
    }

    private void eK(String str, String str2) {
        bQl();
        this.tri.setVisibility(8);
        this.trj.setVisibility(0);
        this.tqS.setVisibility(8);
        this.tqT.setVisibility(0);
        if (TextUtils.isEmpty(str)) {
            this.tqZ.setVisibility(8);
        } else {
            this.tqZ.setText(str);
            this.tqZ.setVisibility(0);
        }
        if (TextUtils.isEmpty(str2)) {
            this.tqX.setVisibility(8);
        } else {
            this.tqX.setText(str2);
            this.tqX.setVisibility(0);
        }
        this.tqU.setVisibility(0);
        this.tqW.setVisibility(8);
        this.tqY.setVisibility(8);
        bQk();
    }

    private void bQk() {
        if (agN()) {
            this.trg.setVisibility(0);
        } else {
            this.trg.setVisibility(8);
        }
    }

    public final void setAutoPlay(boolean z) {
        x.i("MicroMsg.FtsWebVideoView", "setAutoPlay =%b", new Object[]{Boolean.valueOf(z)});
        this.mAutoPlay = z;
    }

    public static void setDuration(int i) {
        if (i <= 0) {
            x.i("MicroMsg.FtsWebVideoView", "setDuration error duration=%d", new Object[]{Integer.valueOf(i)});
        }
    }

    public final void kk(boolean z) {
        x.i("MicroMsg.FtsWebVideoView", "start");
        bQl();
        if (!z || dM(getContext())) {
            this.trk = c.trr;
            if (!this.tqR.isPlaying()) {
                if (this.jsx) {
                    this.tqS.bQs();
                }
                this.tqR.start();
                if (this.trh == 0) {
                    this.trh = System.currentTimeMillis();
                    return;
                } else {
                    this.trh = Long.MAX_VALUE;
                    return;
                }
            }
            return;
        }
        x.i("MicroMsg.FtsWebVideoView", "start network is not wifi");
    }

    private void bQl() {
        this.tqT.setVisibility(8);
    }

    public final void pause() {
        x.i("MicroMsg.FtsWebVideoView", "pause");
        bQl();
        if (this.tqR.isPlaying()) {
            this.tqR.pause();
        }
    }

    public final void stop() {
        x.i("MicroMsg.FtsWebVideoView", "stop");
        if (this.tqR.isPlaying()) {
            this.tqR.stop();
            this.tqS.bQt();
        }
    }

    public final void cw(String str, int i) {
        x.i("MicroMsg.FtsWebVideoView", "setVideoPath path=%s isLive=%s", new Object[]{str, Boolean.valueOf(false)});
        this.url = str;
        if (bh.ov(str)) {
            x.v("MicroMsg.FtsWebVideoView", "setVideoPath videoPath empty");
            return;
        }
        stop();
        this.jsC = false;
        this.tqR.b(false, str, i);
        if (this.tqS != null) {
            this.tqS.wl(i);
        }
        if (this.jsE > 0) {
            this.tqR.kI(this.jsE);
        }
        if (this.mAutoPlay) {
            x.i("MicroMsg.FtsWebVideoView", "setVideoPath autoPlay");
            kk(false);
        }
        if (str.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX) && !bh.ov(str) && !bh.ov(this.jsF)) {
            x.i("MicroMsg.FtsWebVideoView", "setCover mCoverUrl not null");
        }
    }

    public final void w(int i, boolean z) {
        int ahk = this.tqR.ahk();
        x.i("MicroMsg.FtsWebVideoView", "seek to position=%d current=%d isLive=%b", new Object[]{Integer.valueOf(i), Integer.valueOf(ahk), Boolean.valueOf(this.jsC)});
        if (!agP()) {
            if (z) {
                this.tqR.s(i, z);
            } else {
                this.tqR.kI(i);
            }
        }
    }

    public final void sO(String str) {
        x.i("MicroMsg.FtsWebVideoView", "setCover coverUrl=%s", new Object[]{str});
        if (!bh.ov(str)) {
            this.jsF = str;
            com.tencent.mm.modelappbrand.a.b.Jj().a(this.jsu, str, null, null);
        }
    }

    public final void setMute(boolean z) {
        x.i("MicroMsg.FtsWebVideoView", "setMute isMute=%b", new Object[]{Boolean.valueOf(z)});
        this.kTc = z;
        this.tqR.setMute(z);
        if (z) {
            this.tqS.At();
        } else {
            this.tqS.bQp();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jsz || agN()) {
            if (this.tra != null) {
                a aVar = this.tra;
                if (aVar.tqJ.bQc()) {
                    int actionMasked = motionEvent.getActionMasked();
                    if (actionMasked == 0) {
                        aVar.jtz = motionEvent.getRawX();
                        aVar.jty = ((AudioManager) aVar.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamVolume(3);
                        aVar.jek = c.bW(aVar.mContext);
                    }
                    aVar.jtw.onTouchEvent(motionEvent);
                    if (actionMasked == 1 || actionMasked == 3) {
                        if (aVar.tqI == a$a.tqO) {
                            aVar.tqJ.f(aVar.jtB, motionEvent.getRawX() - aVar.jtz);
                            aVar.jtA = -1;
                            aVar.jtB = 0;
                            aVar.jtz = 0.0f;
                        } else if (aVar.tqI == a$a.tqM) {
                            ((AudioManager) aVar.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamMaxVolume(3);
                            aVar.tqJ.agV();
                        } else if (aVar.tqI == a$a.tqN) {
                            aVar.tqJ.agW();
                        }
                    }
                }
                aVar.tqI = a$a.tqL;
            }
            return true;
        }
        if (motionEvent.getAction() == 0 && bQn()) {
            this.tqS.kn(this.acS);
        }
        return super.onTouchEvent(motionEvent);
    }

    public final int bQm() {
        return ((AudioManager) getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamVolume(3);
    }

    private boolean bQn() {
        return this.jsx && !bQo();
    }

    private boolean bQo() {
        return this.tqT.getVisibility() == 0;
    }

    public final void kl(boolean z) {
        boolean z2 = false;
        x.i("MicroMsg.FtsWebVideoView", "operateFullScreen toFullScreen=%b", new Object[]{Boolean.valueOf(z)});
        if (this.trb == null) {
            x.w("MicroMsg.FtsWebVideoView", "operateFullScreen mFullScreenDelegate null");
        } else if (z == agN()) {
            x.i("MicroMsg.FtsWebVideoView", "operateFullScreen current same");
        } else if (z) {
            a aVar = this.trb;
            if (this.tqQ != b.PORTRAIT) {
                z2 = true;
            }
            aVar.km(z2);
            this.tqS.bQi();
            cZ(true);
        } else {
            this.trb.ags();
            this.tqS.ags();
        }
    }

    public final boolean agN() {
        if (this.trb != null) {
            return this.trb.isFullScreen();
        }
        x.w("MicroMsg.FtsWebVideoView", "isInFullScreen mFullScreenDelegate null");
        return false;
    }

    public final void cZ(boolean z) {
        if (this.trc != null) {
            Object obj = this.tqQ == b.PORTRAIT ? "vertical" : "horizontal";
            d dVar = this.trc;
            try {
                x.i("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%s", new Object[]{Integer.valueOf(this.jsw), Boolean.valueOf(z), obj});
                JSONObject ahm = dVar.ahm();
                ahm.put("fullScreen", z);
                ahm.put(TencentLocation.EXTRA_DIRECTION, obj);
                dVar.af(dVar.a(5, ahm));
            } catch (JSONException e) {
                x.e("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange e=%s", new Object[]{e});
            }
            bQk();
        }
    }

    private boolean agP() {
        x.i("MicroMsg.FtsWebVideoView", "isLive %b %b", new Object[]{Boolean.valueOf(this.jsC), Boolean.valueOf(this.tqR.agP())});
        if (this.jsC || this.tqR.agP()) {
            return true;
        }
        return false;
    }
}
