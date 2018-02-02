package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;

public final class l implements ITXLivePlayListener {
    boolean gNe = false;
    boolean jkS = false;
    TXCloudVideoView jlj;
    private TXLivePlayConfig jlk;
    TXLivePlayer jll;
    ITXLivePlayListener jlm;
    String jln = "";
    int jlo = 0;
    boolean jlp = false;
    private String jlq = "vertical";
    private String jlr = "fillCrop";
    private String jls = "speaker";
    private float jlt = 1.0f;
    private float jlu = 3.0f;
    boolean jlv = true;
    private boolean jlw = false;
    boolean mAutoPlay = false;
    private Context mContext;
    private int mMode = 1;
    private boolean mMute = false;

    public l(Context context) {
        this.mContext = context;
        this.jlk = new TXLivePlayConfig();
        this.jll = new TXLivePlayer(this.mContext);
        this.jll.setConfig(this.jlk);
        this.jll.setPlayListener(this);
        this.jll.enableHardwareDecode(true);
    }

    public final j ss(String str) {
        boolean z = true;
        if (str == null) {
            return new j(-1, "invalid params");
        }
        x.i("TXLivePlayerJSAdapter", "operateLivePlayer: " + str);
        if (!this.gNe) {
            return new j(-3, "uninited livePlayer");
        }
        if (str.equalsIgnoreCase("play")) {
            this.jll.startPlay(this.jln, this.jlo);
        } else if (str.equalsIgnoreCase("stop")) {
            this.jll.stopPlay(true);
        } else if (str.equalsIgnoreCase("pause")) {
            this.jll.pause();
        } else if (str.equalsIgnoreCase("resume")) {
            this.jll.resume();
        } else if (!str.equalsIgnoreCase("mute")) {
            return new j(-4, "invalid operate command");
        } else {
            if (this.mMute) {
                z = false;
            }
            this.mMute = z;
            this.jll.setMute(this.mMute);
        }
        return new j();
    }

    public final void onPlayEvent(int i, Bundle bundle) {
        if (i == TXLiveConstants.PLAY_EVT_PLAY_END || i == TXLiveConstants.PLAY_ERR_NET_DISCONNECT) {
            ss("stop");
        }
        if (this.jkS && this.jlm != null) {
            this.jlm.onPlayEvent(i, bundle);
        }
    }

    public final void onNetStatus(Bundle bundle) {
        if (this.jlm != null) {
            this.jlm.onNetStatus(bundle);
        }
    }

    final int v(Bundle bundle) {
        this.mMode = bundle.getInt("mode", this.mMode);
        if (this.mMode != 1) {
            return 5;
        }
        if (this.jln == null || this.jln == null) {
            return 0;
        }
        if ((this.jln.startsWith("http://") || this.jln.startsWith("https://")) && this.jln.contains(".flv")) {
            return 1;
        }
        return 0;
    }

    final void w(Bundle bundle) {
        this.mMute = bundle.getBoolean("muted", this.mMute);
        this.jll.setMute(this.mMute);
        this.jlq = bundle.getString("orientation", this.jlq);
        if (this.jlq.equalsIgnoreCase("horizontal")) {
            this.jll.setRenderRotation(270);
        } else if (this.jlq.equalsIgnoreCase("vertical")) {
            this.jll.setRenderRotation(0);
        }
        this.jlr = bundle.getString("objectFit", this.jlr);
        if (this.jlr.equalsIgnoreCase("fillCrop")) {
            this.jll.setRenderMode(0);
        } else if (this.jlr.equalsIgnoreCase("contain")) {
            this.jll.setRenderMode(1);
        }
        this.jls = bundle.getString("soundMode", this.jls);
        if (this.jls.equalsIgnoreCase("speaker")) {
            this.jll.setAudioRoute(0);
        } else if (this.jls.equalsIgnoreCase("ear")) {
            this.jll.setAudioRoute(1);
        }
        this.jlv = bundle.getBoolean("backgroundMute", this.jlv);
        this.jlt = bundle.getFloat("minCache", this.jlt);
        this.jlu = bundle.getFloat("maxCache", this.jlu);
        this.jlk.setAutoAdjustCacheTime(true);
        this.jlk.setCacheTime(this.jlt);
        this.jlk.setMinAutoAdjustCacheTime(this.jlt);
        this.jlk.setMaxAutoAdjustCacheTime(this.jlu);
        this.jll.setConfig(this.jlk);
        this.jkS = bundle.getBoolean("needEvent", this.jkS);
        this.jlw = bundle.getBoolean("debug", this.jlw);
        this.jlj.showLog(this.jlw);
    }

    static void c(String str, Bundle bundle) {
        for (String str2 : bundle.keySet()) {
            if (str2.equalsIgnoreCase("playUrl") || str2.equalsIgnoreCase("orientation") || str2.equalsIgnoreCase("objectFit") || str2.equalsIgnoreCase("soundMode")) {
                str = str + "\n" + str2 + " = " + bundle.getString(str2);
            } else if (str2.equalsIgnoreCase("mode") || str2.equalsIgnoreCase("playType")) {
                str = str + "\n" + str2 + " = " + bundle.getInt(str2);
            } else if (str2.equalsIgnoreCase("minCache") || str2.equalsIgnoreCase("maxCache")) {
                str = str + "\n" + str2 + " = " + bundle.getFloat(str2);
            } else if (str2.equalsIgnoreCase("hide") || str2.equalsIgnoreCase("autoplay") || str2.equalsIgnoreCase("muted") || str2.equalsIgnoreCase("backgroundMute") || str2.equalsIgnoreCase("needEvent") || str2.equalsIgnoreCase("debug")) {
                str = str + "\n" + str2 + " = " + bundle.getBoolean(str2);
            }
        }
        x.i("TXLivePlayerJSAdapter", str);
    }
}
