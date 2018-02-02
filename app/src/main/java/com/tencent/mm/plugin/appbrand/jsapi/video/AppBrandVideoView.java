package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoViewControlBar.1;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoViewControlBar.3;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.4;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.5;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppBrandVideoView extends RelativeLayout {
    private int jkR;
    private f jsA;
    a jsB;
    private boolean jsC;
    private boolean jsD;
    private int jsE;
    private String jsF;
    boolean jsG;
    private boolean jsH;
    private boolean jsI;
    private boolean jsJ;
    private boolean jsK;
    private int jsi = -1;
    AppBrandVideoWrapper jsj;
    private TextView jsk;
    private DanmuView jsl;
    AppBrandVideoViewControlBar jsm;
    private View jsn;
    private View jso;
    TextView jsp;
    private LinearLayout jsq;
    private AppBrandDotPercentIndicator jsr;
    private TextView jss;
    private ImageView jst;
    private ImageView jsu;
    String jsv;
    int jsw;
    private boolean jsx;
    e jsy;
    private boolean jsz;
    String mAppId;
    boolean mAutoPlay;
    int mDuration;

    static /* synthetic */ void a(AppBrandVideoView appBrandVideoView, boolean z) {
        boolean z2 = true;
        x.i("MicroMsg.AppBrandVideoView", "updateLiveUI isLive:%b", new Object[]{Boolean.valueOf(z)});
        AppBrandVideoViewControlBar appBrandVideoViewControlBar = appBrandVideoView.jsm;
        boolean z3 = appBrandVideoView.jsJ && z;
        appBrandVideoViewControlBar.cR(z3);
        AppBrandVideoViewControlBar appBrandVideoViewControlBar2 = appBrandVideoView.jsm;
        if (!appBrandVideoView.jsI || z) {
            z2 = false;
        }
        appBrandVideoViewControlBar2.cS(z2);
    }

    static /* synthetic */ boolean h(AppBrandVideoView appBrandVideoView) {
        return appBrandVideoView.jsH && !appBrandVideoView.jsj.agP();
    }

    public AppBrandVideoView(Context context) {
        super(context);
        init(context);
    }

    public AppBrandVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AppBrandVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(h.ixv, this);
        this.jsj = (AppBrandVideoWrapper) findViewById(g.cVC);
        this.jsk = (TextView) findViewById(g.progress);
        this.jsn = findViewById(g.bZm);
        this.jso = findViewById(g.ivG);
        this.jsp = (TextView) findViewById(g.ivH);
        this.jsq = (LinearLayout) findViewById(g.bJx);
        this.jsr = (AppBrandDotPercentIndicator) findViewById(g.bJy);
        this.jss = (TextView) findViewById(g.bJv);
        this.jst = (ImageView) findViewById(g.bJw);
        this.jsu = (ImageView) findViewById(g.bZl);
        ViewGroup viewGroup = this.jsr;
        viewGroup.jrQ = 8;
        viewGroup.removeAllViews();
        for (int i = 0; i < viewGroup.jrQ; i++) {
            viewGroup.addView((ImageView) viewGroup.DF.inflate(h.iwO, viewGroup, false));
        }
        ((ImageView) findViewById(g.ivF)).setOnClickListener(new 1(this));
        this.jsA = new f(getContext(), this, new 5(this));
        this.jsj.jte = new 6(this);
        this.jsm = new AppBrandVideoViewControlBar(getContext());
        this.jsm.setVisibility(8);
        AppBrandVideoViewControlBar appBrandVideoViewControlBar = this.jsm;
        appBrandVideoViewControlBar.jsP.setOnClickListener(new 8(this));
        this.jsm.quk = new b(this) {
            final /* synthetic */ AppBrandVideoView jsL;

            {
                this.jsL = r1;
            }

            public final void agX() {
                x.i("MicroMsg.AppBrandVideoView", "onSeekPre");
            }

            public final void kH(int i) {
                this.jsL.w(i, false);
            }
        };
        this.jsm.i(new 10(this));
        this.jsm.jsV = new 2(this);
        this.jsj.a(this.jsm);
    }

    public final void cP(boolean z) {
        x.i("MicroMsg.AppBrandVideoView", "setLoop loop=%b", new Object[]{Boolean.valueOf(z)});
        this.jsD = z;
    }

    public final void start() {
        x.i("MicroMsg.AppBrandVideoView", "start");
        if (!this.jsj.isPlaying()) {
            if (this.jsx) {
                AppBrandVideoViewControlBar appBrandVideoViewControlBar = this.jsm;
                if (appBrandVideoViewControlBar.jsX == null) {
                    appBrandVideoViewControlBar.jsX = new ak(new 3(appBrandVideoViewControlBar), true);
                }
                appBrandVideoViewControlBar.ahd();
                appBrandVideoViewControlBar.jsX.TG();
                appBrandVideoViewControlBar.jsX.J(500, 500);
            }
            this.jsn.setVisibility(8);
            this.jsj.start();
            if (this.jsl != null && this.jsm.jsZ) {
                this.jsl.show();
            }
        }
    }

    public final void pause() {
        x.i("MicroMsg.AppBrandVideoView", "pause");
        if (this.jsj.isPlaying()) {
            this.jsj.pause();
            if (this.jsl != null && this.jsm.jsZ) {
                this.jsl.pause();
            }
        }
    }

    public final void stop() {
        x.i("MicroMsg.AppBrandVideoView", "stop");
        if (this.jsj.isPlaying()) {
            this.jsj.stop();
            AppBrandVideoViewControlBar appBrandVideoViewControlBar = this.jsm;
            if (appBrandVideoViewControlBar.jsX != null) {
                appBrandVideoViewControlBar.jsX.TG();
            }
            if (this.jsl != null) {
                this.jsl.hide();
            }
        }
    }

    public final void clean() {
        x.i("MicroMsg.AppBrandVideoView", "clean");
        stop();
        this.jsj.ahl();
        if (this.jsl != null) {
            DanmuView danmuView = this.jsl;
            danmuView.status = 3;
            danmuView.ahw();
            danmuView.juf.clear();
            danmuView.invalidate();
        }
        AppBrandVideoViewControlBar appBrandVideoViewControlBar = this.jsm;
        if (appBrandVideoViewControlBar.jsX != null) {
            appBrandVideoViewControlBar.jsX.TG();
        }
        if (appBrandVideoViewControlBar.jsW != null) {
            appBrandVideoViewControlBar.jsW.TG();
        }
    }

    public final void e(String str, boolean z, int i) {
        x.i("MicroMsg.AppBrandVideoView", "setVideoPath path=%s isLive=%s", new Object[]{str, Boolean.valueOf(z)});
        if (bh.ov(str)) {
            x.v("MicroMsg.AppBrandVideoView", "setVideoPath videoPath empty");
            return;
        }
        String str2;
        AppBrandLocalMediaObject itemByLocalId;
        stop();
        this.jsC = z;
        AppBrandVideoWrapper appBrandVideoWrapper = this.jsj;
        if (bh.ov(str)) {
            str2 = str;
        } else if (str.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
            x.i("MicroMsg.AppBrandVideoView", "convertPath appid=%s path=%s", new Object[]{this.mAppId, str});
            itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(this.mAppId, str);
            if (itemByLocalId == null) {
                x.e("MicroMsg.AppBrandVideoView", "convertPath AppBrandLocalMediaObject null");
                str2 = str;
            } else {
                if (bh.ov(itemByLocalId.hhZ)) {
                    x.e("MicroMsg.AppBrandVideoView", "convertPath fileFullPath null");
                    str2 = str;
                } else {
                    str2 = String.format("%s%s", new Object[]{AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX, itemByLocalId.hhZ});
                    x.i("MicroMsg.AppBrandVideoView", "convertPath convertedPath=%s", new Object[]{str2});
                }
            }
        } else {
            str2 = str;
        }
        appBrandVideoWrapper.b(z, str2, i);
        if (this.jsE > 0) {
            this.jsj.kI(this.jsE);
        }
        if (this.mAutoPlay) {
            x.i("MicroMsg.AppBrandVideoView", "setVideoPath autoPlay");
            start();
        }
        if (str.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX) && !bh.ov(str)) {
            if (bh.ov(this.jsF)) {
                itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(this.mAppId, str);
                if (itemByLocalId == null) {
                    x.w("MicroMsg.AppBrandVideoView", "setCover AppBrandLocalMediaObject null");
                    return;
                }
                str2 = itemByLocalId.hhZ;
                if (bh.ov(str2)) {
                    x.w("MicroMsg.AppBrandVideoView", "setCover fileFullPath null");
                    return;
                } else {
                    c.Dm().F(new 3(this, str2));
                    return;
                }
            }
            x.i("MicroMsg.AppBrandVideoView", "setCover mCoverUrl not null");
        }
    }

    public final void w(int i, boolean z) {
        x.i("MicroMsg.AppBrandVideoView", "seek to position=%d current=%d isLive=%b", new Object[]{Integer.valueOf(i), Integer.valueOf(this.jsj.ahk()), Boolean.valueOf(this.jsC)});
        if (!agP()) {
            this.jsn.setVisibility(8);
            if (z) {
                this.jsj.s(i, z);
            } else {
                this.jsj.kI(i);
            }
            if (this.jsl != null && r0 > i) {
                DanmuView danmuView = this.jsl;
                x.i("MicroMsg.DanmuView", "seekToPlayTime playTime=%d", new Object[]{Integer.valueOf(i)});
                danmuView.ahu();
                danmuView.ahw();
                danmuView.prepare();
                e.post(new 5(danmuView, i), "DanmuView-seekToPlayTime");
            }
        }
    }

    public final void cQ(boolean z) {
        x.i("MicroMsg.AppBrandVideoView", "setIsShowBasicControls isShowBasicControls=%b", new Object[]{Boolean.valueOf(z)});
        this.jsx = z;
    }

    public final void sO(String str) {
        x.i("MicroMsg.AppBrandVideoView", "setCover coverUrl=%s", new Object[]{str});
        if (!bh.ov(str)) {
            this.jsF = str;
            com.tencent.mm.modelappbrand.a.b.Jj().a(this.jsu, str, null, null);
        }
    }

    public final void cR(boolean z) {
        boolean z2 = true;
        x.i("MicroMsg.AppBrandVideoView", "setShowLiveBtn %b", new Object[]{Boolean.valueOf(z)});
        this.jsJ = z;
        AppBrandVideoViewControlBar appBrandVideoViewControlBar = this.jsm;
        if (!(z && agP())) {
            z2 = false;
        }
        appBrandVideoViewControlBar.cR(z2);
    }

    public final void cS(boolean z) {
        boolean z2 = true;
        x.i("MicroMsg.AppBrandVideoView", "setShowProgress %b", new Object[]{Boolean.valueOf(z)});
        this.jsI = z;
        AppBrandVideoViewControlBar appBrandVideoViewControlBar = this.jsm;
        if (!z || agP()) {
            z2 = false;
        }
        appBrandVideoViewControlBar.cS(z2);
    }

    public final void cT(boolean z) {
        int i = 0;
        x.i("MicroMsg.AppBrandVideoView", "setShowFullScreenBtn %b", new Object[]{Boolean.valueOf(z)});
        ImageView imageView = this.jsm.jsP;
        if (!z) {
            i = 8;
        }
        imageView.setVisibility(i);
    }

    public final void cU(boolean z) {
        int i = 0;
        x.i("MicroMsg.AppBrandVideoView", "setShowPlayBtn %b", new Object[]{Boolean.valueOf(z)});
        ImageView imageView = this.jsm.quo;
        if (!z) {
            i = 8;
        }
        imageView.setVisibility(i);
    }

    public final void cV(boolean z) {
        x.i("MicroMsg.AppBrandVideoView", "enableProgressGesture %b", new Object[]{Boolean.valueOf(z)});
        this.jsH = z;
    }

    public final void cW(boolean z) {
        int i = 0;
        x.i("MicroMsg.AppBrandVideoView", "setShowCenterPlayBtn %b", new Object[]{Boolean.valueOf(z)});
        this.jsK = z;
        View view = this.jso;
        if (!z) {
            i = 8;
        }
        view.setVisibility(i);
    }

    public final void cX(boolean z) {
        AppBrandVideoViewControlBar appBrandVideoViewControlBar;
        x.i("MicroMsg.AppBrandVideoView", "setShowDanmakuBtn showDanmakuBtn=%b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            if (this.jsl == null) {
                agO();
            }
            appBrandVideoViewControlBar = this.jsm;
            appBrandVideoViewControlBar.jsQ.setOnClickListener(new 1(appBrandVideoViewControlBar, new 4(this)));
        }
        appBrandVideoViewControlBar = this.jsm;
        if (z) {
            appBrandVideoViewControlBar.jsQ.setVisibility(0);
        } else {
            appBrandVideoViewControlBar.jsQ.setVisibility(8);
        }
    }

    public final void sP(String str) {
        x.i("MicroMsg.AppBrandVideoView", "setObjectFit objectFit=%s", new Object[]{str});
        if ("fill".equalsIgnoreCase(str)) {
            this.jsj.a(d.vjZ);
            this.jsu.setScaleType(ScaleType.FIT_XY);
        } else if ("cover".equalsIgnoreCase(str)) {
            this.jsj.a(d.vkb);
            this.jsu.setScaleType(ScaleType.CENTER_CROP);
        } else {
            this.jsj.a(d.vka);
            this.jsu.setScaleType(ScaleType.FIT_CENTER);
        }
    }

    public final void setMute(boolean z) {
        x.i("MicroMsg.AppBrandVideoView", "setMute isMute=%b", new Object[]{Boolean.valueOf(z)});
        this.jsj.setMute(z);
    }

    public final void kD(int i) {
        x.i("MicroMsg.AppBrandVideoView", "setFullScreenDirection %d", new Object[]{Integer.valueOf(i)});
        this.jsi = i;
    }

    public final void cY(boolean z) {
        x.i("MicroMsg.AppBrandVideoView", "setPageGesture pageGesture=%b", new Object[]{Boolean.valueOf(z)});
        this.jsz = z;
    }

    public final void kE(int i) {
        x.i("MicroMsg.AppBrandVideoView", "setInitialTime initialTime=%d", new Object[]{Integer.valueOf(i)});
        this.jsE = i;
    }

    public final void h(JSONArray jSONArray) {
        int i = 0;
        if (jSONArray != null) {
            String str = "MicroMsg.AppBrandVideoView";
            String str2 = "setDanmakuItemList length=%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(jSONArray != null ? jSONArray.length() : 0);
            x.i(str, str2, objArr);
            if (this.jsl == null) {
                x.w("MicroMsg.AppBrandVideoView", " setDanmakuItemList mDanmakuView null");
                agO();
            }
            List arrayList = new ArrayList();
            while (i < jSONArray.length()) {
                com.tencent.mm.plugin.appbrand.jsapi.video.danmu.d s = s(jSONArray.optJSONObject(i));
                if (s != null) {
                    arrayList.add(s);
                }
                i++;
            }
            DanmuView danmuView = this.jsl;
            danmuView.ahu();
            danmuView.ahw();
            danmuView.juf.clear();
            danmuView.prepare();
            if (arrayList.isEmpty()) {
                danmuView.ahv();
                return;
            }
            new 4(danmuView, arrayList).start();
            danmuView.ahv();
        }
    }

    public final boolean bj(String str, String str2) {
        int parseColor;
        if (this.jsl == null) {
            x.w("MicroMsg.AppBrandVideoView", " addDanmaku mDanmakuView null");
            agO();
        }
        try {
            parseColor = Color.parseColor(str2);
        } catch (Exception e) {
            x.d("MicroMsg.AppBrandVideoView", "addDanmakuItemList parse color=%s exp=%s", new Object[]{str2, e});
            parseColor = getResources().getColor(q.d.white);
        }
        com.tencent.mm.plugin.appbrand.jsapi.video.danmu.d aVar = new a(getContext(), new SpannableString(str), parseColor, this.jsj.ahk());
        DanmuView danmuView = this.jsl;
        synchronized (danmuView.jue) {
            danmuView.jue.offerFirst(aVar);
            e.post(new DanmuView$3(danmuView, aVar), "DanmuView-addItemToWaitingHead");
        }
        return true;
    }

    private com.tencent.mm.plugin.appbrand.jsapi.video.danmu.d s(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int parseColor;
        int optInt = jSONObject.optInt("time", 0);
        CharSequence optString = jSONObject.optString("text", "");
        Object optString2 = jSONObject.optString("color", "");
        try {
            parseColor = Color.parseColor(optString2);
        } catch (Exception e) {
            x.d("MicroMsg.AppBrandVideoView", "addDanmakuItemList parse color=%s exp=%s", new Object[]{optString2, e});
            parseColor = getResources().getColor(q.d.white);
        }
        return new a(getContext(), new SpannableString(optString), parseColor, optInt);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.jsz || agN()) {
            if (this.jsA != null) {
                f fVar = this.jsA;
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0) {
                    fVar.jtz = motionEvent.getRawX();
                    fVar.jty = ((AudioManager) fVar.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamVolume(3);
                    fVar.jek = g.bW(fVar.mContext);
                }
                fVar.jtw.onTouchEvent(motionEvent);
                if (actionMasked == 1 || actionMasked == 3) {
                    if (fVar.jtv == f$a.jtH) {
                        fVar.jtx.f(fVar.jtB, motionEvent.getRawX() - fVar.jtz);
                        fVar.jtA = -1;
                        fVar.jtB = 0;
                        fVar.jtz = 0.0f;
                    } else if (fVar.jtv == f$a.jtF) {
                        ((AudioManager) fVar.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).getStreamMaxVolume(3);
                        fVar.jtx.agV();
                    } else if (fVar.jtv == f$a.jtG) {
                        fVar.jtx.agW();
                    }
                    fVar.jtv = f$a.jtE;
                }
            }
            return true;
        }
        if (motionEvent.getAction() == 0 && this.jsx && this.jsn.getVisibility() != 0) {
            this.jsm.ahb();
        }
        if (this.jsG) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void f(boolean z, int i) {
        x.i("MicroMsg.AppBrandVideoView", "operateFullScreen toFullScreen:%b direction:%d", new Object[]{Boolean.valueOf(z), Integer.valueOf(i)});
        if (this.jsB == null) {
            x.w("MicroMsg.AppBrandVideoView", "operateFullScreen mFullScreenDelegate null");
        } else if (z == agN()) {
            x.i("MicroMsg.AppBrandVideoView", "operateFullScreen current same");
        } else {
            int i2;
            if (i == -1) {
                i2 = this.jsi == -1 ? 90 : this.jsi;
                x.i("MicroMsg.AppBrandVideoView", "operateFullScreen target direction:%d", new Object[]{Integer.valueOf(i2)});
            } else {
                i2 = i;
            }
            if (z) {
                this.jkR = i2;
                this.jsB.kz(i2);
                AppBrandVideoViewControlBar appBrandVideoViewControlBar = this.jsm;
                appBrandVideoViewControlBar.jsY = true;
                appBrandVideoViewControlBar.ahc();
                cZ(true);
                return;
            }
            this.jsB.ags();
            this.jsm.ags();
        }
    }

    public final boolean agN() {
        if (this.jsB != null) {
            return this.jsB.isFullScreen();
        }
        x.w("MicroMsg.AppBrandVideoView", "isInFullScreen mFullScreenDelegate null");
        return false;
    }

    private void agO() {
        this.jsl = (DanmuView) findViewById(g.ivJ);
        this.jsl.juc = new 7(this);
        DanmuView danmuView = this.jsl;
        danmuView.jtY = 0.0f;
        danmuView.jtZ = 0.8f;
        this.jsl.jtX = 5;
        this.jsl.jtW = 200;
        this.jsl.hide();
        if (this.jsj != null && this.jsj.getHeight() > 0) {
            danmuView = this.jsl;
            int height = (int) ((danmuView.jtZ - danmuView.jtY) * ((float) this.jsj.getHeight()));
            float bX = com.tencent.mm.plugin.appbrand.jsapi.video.danmu.b.bX(getContext());
            DanmuView danmuView2 = this.jsl;
            danmuView2.jtV = (int) (((float) height) / bX);
            if (danmuView2.jud != null) {
                synchronized (danmuView2.jud) {
                    for (int i = 0; i < danmuView2.jud.size(); i++) {
                        ArrayList arrayList = (ArrayList) danmuView2.jud.get(Integer.valueOf(i));
                        if (arrayList != null) {
                            arrayList.clear();
                        }
                    }
                }
            }
            danmuView2.ahs();
        }
    }

    static String kF(int i) {
        return kG(i / 60) + ":" + kG(i % 60);
    }

    private static String kG(int i) {
        if (i < 10) {
            return "0" + i;
        }
        return String.valueOf(i);
    }

    final void cZ(boolean z) {
        if (this.jsy != null) {
            e eVar = this.jsy;
            try {
                x.i("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%d", new Object[]{Integer.valueOf(this.jsw), Boolean.valueOf(z), Integer.valueOf(this.jkR)});
                JSONObject ahm = eVar.ahm();
                ahm.put("fullScreen", z);
                ahm.put("videoPlayerId", r1);
                ahm.put(TencentLocation.EXTRA_DIRECTION, r2);
                eVar.a(new d(), ahm);
            } catch (JSONException e) {
                x.e("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange e=%s", new Object[]{e});
            }
        }
    }

    private boolean agP() {
        x.i("MicroMsg.AppBrandVideoView", "isLive %b %b", new Object[]{Boolean.valueOf(this.jsC), Boolean.valueOf(this.jsj.agP())});
        if (this.jsC || this.jsj.agP()) {
            return true;
        }
        return false;
    }
}
