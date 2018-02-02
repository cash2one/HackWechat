package com.tencent.mm.plugin.webview.fts.c;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.plugin.webview.fts.ui.b.1;
import com.tencent.mm.plugin.webview.fts.ui.b.2;
import com.tencent.mm.plugin.webview.fts.ui.b.4;
import com.tencent.mm.plugin.webview.fts.ui.b.5;
import com.tencent.mm.plugin.webview.fts.ui.b.AnonymousClass3;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements e {
    private Context context;
    public d tlx;
    private b trA;
    com.tencent.mm.plugin.webview.fts.ui.b trE;
    private az<FtsWebVideoView> trF = new az(3);

    public interface a {
        boolean aeG();

        void afA();

        void aga();

        void agt();

        void bPX();

        void bQw();

        void onDestroy();
    }

    public b(Context context, MMWebView mMWebView, b bVar) {
        this.context = context;
        this.trA = bVar;
        this.trE = new com.tencent.mm.plugin.webview.fts.ui.b(mMWebView, bVar);
    }

    public final void v(final int i, String str, String str2) {
        x.i("FtsVideoPlayerMgr", "insert player id %d,viewProps %s,videoProps %s", new Object[]{Integer.valueOf(i), str, str2});
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                x.e("FtsVideoPlayerMgr", "insert args invalid");
                return;
            }
            View ftsWebVideoView;
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(str2);
            View view = (FtsWebVideoView) this.trF.bG();
            if (view == null) {
                ftsWebVideoView = new FtsWebVideoView(this.context, jSONObject2.optBoolean("autoPlay"));
            } else {
                view.stop();
                ftsWebVideoView = view;
            }
            x.i("MicroMsg.FtsWebVideoView", "setIsShowBasicControls isShowBasicControls=%b", new Object[]{Boolean.valueOf(true)});
            ftsWebVideoView.jsx = true;
            ftsWebVideoView.tre = jSONObject2.optInt("fileSize");
            ftsWebVideoView.setMute(jSONObject2.optBoolean("isMute"));
            ftsWebVideoView.sO(jSONObject2.optString("coverUrl"));
            ftsWebVideoView.jsw = i;
            ftsWebVideoView.setAutoPlay(jSONObject2.optBoolean("autoPlay"));
            ftsWebVideoView.cw(c.ae(jSONObject2), jSONObject2.optInt("durationSec"));
            final a 1 = new 1(this, ftsWebVideoView);
            ftsWebVideoView.trb = new com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.a(this) {
                final /* synthetic */ b trH;

                public final void km(boolean z) {
                    com.tencent.mm.plugin.webview.fts.ui.b bVar = this.trH.trE;
                    bc 4 = new 4(bVar, Boolean.valueOf(false), i, 1, z);
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        ((Boolean) 4.b(null)).booleanValue();
                    } else {
                        ((Boolean) 4.b(bVar.mHandler)).booleanValue();
                    }
                }

                public final void ags() {
                    com.tencent.mm.plugin.webview.fts.ui.b bVar = this.trH.trE;
                    bc 5 = new 5(bVar, Boolean.valueOf(false), i);
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        ((Boolean) 5.b(null)).booleanValue();
                    } else {
                        ((Boolean) 5.b(bVar.mHandler)).booleanValue();
                    }
                }

                public final boolean isFullScreen() {
                    return this.trH.trE.lq(i);
                }
            };
            a 3 = new 3(this, ftsWebVideoView);
            ftsWebVideoView.trd = 3;
            this.trA.a(3);
            ftsWebVideoView.trc = new d(ftsWebVideoView, this.trA, this.tlx);
            com.tencent.mm.plugin.webview.fts.ui.b bVar = this.trE;
            bc 12 = new 1(bVar, Boolean.valueOf(false), ftsWebVideoView, i, 0, c.a(jSONObject, this.context), c.k(jSONObject));
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                ((Boolean) 12.b(null)).booleanValue();
            } else {
                ((Boolean) 12.b(bVar.mHandler)).booleanValue();
            }
        } catch (JSONException e) {
            x.e("FtsVideoPlayerMgr", "", new Object[]{e});
        }
    }

    public final void w(int i, String str, String str2) {
        x.i("FtsVideoPlayerMgr", "update player id %d,viewProps %s,videoProps %s", new Object[]{Integer.valueOf(i), str, str2});
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                com.tencent.mm.plugin.webview.fts.ui.b bVar = this.trE;
                bc anonymousClass3 = new AnonymousClass3(bVar, Boolean.valueOf(false), i, c.a(jSONObject, this.context), c.k(jSONObject));
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    ((Boolean) anonymousClass3.b(null)).booleanValue();
                } else {
                    ((Boolean) anonymousClass3.b(bVar.mHandler)).booleanValue();
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject2 = new JSONObject(str2);
                FtsWebVideoView ftsWebVideoView = (FtsWebVideoView) this.trE.lo(i);
                if (ftsWebVideoView == null) {
                    x.i("FtsVideoPlayerMgr", "can not find video View by id %d", new Object[]{Integer.valueOf(i)});
                    return;
                }
                if (jSONObject2.has("autoPlay")) {
                    ftsWebVideoView.setAutoPlay(jSONObject2.optBoolean("autoPlay"));
                }
                if (jSONObject2.has("coverUrl")) {
                    ftsWebVideoView.sO(jSONObject2.optString("coverUrl"));
                }
                if (jSONObject2.has("durationSec")) {
                    FtsWebVideoView.setDuration(jSONObject2.optInt("durationSec"));
                }
                if (jSONObject2.has("playUrl")) {
                    ftsWebVideoView.cw(c.ae(jSONObject2), jSONObject2.optInt("durationSec"));
                }
                if (jSONObject2.has("isMute")) {
                    ftsWebVideoView.setMute(jSONObject2.optBoolean("isMute"));
                }
            }
        } catch (JSONException e) {
            x.e("FtsVideoPlayerMgr", "", new Object[]{e});
        }
    }

    public final void Ah(int i) {
        x.i("FtsVideoPlayerMgr", "remove palyer id %d", new Object[]{Integer.valueOf(i)});
        FtsWebVideoView ftsWebVideoView = (FtsWebVideoView) this.trE.lo(i);
        if (ftsWebVideoView == null) {
            x.w("FtsVideoPlayerMgr", "can not find player by id %d", new Object[]{Integer.valueOf(i)});
        }
        com.tencent.mm.plugin.webview.fts.ui.b bVar = this.trE;
        bc 2 = new 2(bVar, Boolean.valueOf(false), i);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            ((Boolean) 2.b(null)).booleanValue();
        } else {
            ((Boolean) 2.b(bVar.mHandler)).booleanValue();
        }
        if (ftsWebVideoView != null) {
            ftsWebVideoView.stop();
            ftsWebVideoView.trc.clean();
            ftsWebVideoView.trc = null;
            ftsWebVideoView.setVisibility(0);
            ftsWebVideoView.trf = false;
            this.trF.j(ftsWebVideoView);
        }
    }

    public final void aM(int i, String str) {
        x.i("FtsVideoPlayerMgr", "op player id %d,type %s", new Object[]{Integer.valueOf(i), str});
        FtsWebVideoView ftsWebVideoView = (FtsWebVideoView) this.trE.lo(i);
        if (ftsWebVideoView != null) {
            boolean z = true;
            switch (str.hashCode()) {
                case 3443508:
                    if (str.equals("play")) {
                        z = false;
                        break;
                    }
                    break;
                case 3540994:
                    if (str.equals("stop")) {
                        z = true;
                        break;
                    }
                    break;
                case 106440182:
                    if (str.equals("pause")) {
                        z = true;
                        break;
                    }
                    break;
                case 640038740:
                    if (str.equals("setUnMute")) {
                        z = true;
                        break;
                    }
                    break;
                case 1984790939:
                    if (str.equals("setMute")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    ftsWebVideoView.kk(false);
                    return;
                case true:
                    ftsWebVideoView.pause();
                    return;
                case true:
                    ftsWebVideoView.stop();
                    return;
                case true:
                    ftsWebVideoView.setMute(true);
                    return;
                case true:
                    ftsWebVideoView.setMute(false);
                    return;
                default:
                    x.i("FtsVideoPlayerMgr", "unknown op type %s", new Object[]{str});
                    return;
            }
        }
        x.i("FtsVideoPlayerMgr", "can not find player by id %d", new Object[]{Integer.valueOf(i)});
    }
}
