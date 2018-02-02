package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.m;
import com.tencent.mm.plugin.webview.a;
import com.tencent.mm.plugin.webview.ui.tools.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e.h;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.xweb.b;
import com.tencent.xweb.c;
import java.io.File;
import java.util.Map;
import org.xwalk.core.R$styleable;

class a$3 extends g {
    final /* synthetic */ a tFo;

    a$3(a aVar) {
        this.tFo = aVar;
    }

    public final void O(Bundle bundle) {
        x.i("MicroMsg.GameFloatWebView", m.NAME);
        try {
            this.tFo.Fl.removeView(this.tFo.juE);
            this.tFo.onDestroy();
        } catch (Exception e) {
        }
    }

    public final Bundle e(int i, Bundle bundle) {
        x.i("MicroMsg.GameFloatWebView", "game float invokeAsResult, actionCode = " + i);
        Bundle bundle2 = new Bundle();
        final String string;
        final int i2;
        boolean z;
        String aeq;
        int init;
        switch (i) {
            case 18:
                bundle2.putString("KPublisherId", d.fGF);
                bundle2.putInt("getA8KeyScene", this.tFo.cB(d.tFK, d.fMy));
                break;
            case 37:
                string = bundle.getString("show_kb_placeholder");
                i2 = bundle.getInt("show_kb_max_length");
                this.tFo.tFg.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ a$3 tFp;

                    public final void run() {
                        this.tFp.tFo.tFg.cA(string, i2);
                    }
                });
                break;
            case R$styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                this.tFo.tFg.runOnUiThread(new 3(this, bundle.getString("set_page_title_text"), d.aK(bundle.getString("set_page_title_color"), this.tFo.tFg.getResources().getColor(R.e.brf))));
                break;
            case 53:
                this.tFo.tFg.runOnUiThread(new 4(this, bundle));
                break;
            case 54:
                z = bundle.getBoolean("add_shortcut_status");
                if (this.tFo.tFj != null) {
                    this.tFo.tFj.kA(z);
                    break;
                }
                break;
            case 79:
                this.tFo.tFg.runOnUiThread(new 2(this, bundle2));
                break;
            case 84:
                CharSequence mMTitle = this.tFo.tFg.mController.getMMTitle();
                aeq = aeq();
                bundle2.putString("webview_current_url", aeq);
                bundle2.putString("webview_current_title", mMTitle != null ? mMTitle.toString() : "");
                bundle2.putString("webview_current_desc", aeq);
                break;
            case R$styleable.AppCompatTheme_colorControlHighlight /*87*/:
                z = this.tFo.tFl.tKk;
                aeq = this.tFo.tFl.mZe;
                Map map = this.tFo.tFl.tKm;
                if (!z) {
                    bundle2.putString("full_url", bh.ou(aeq));
                    if (map != null && map.size() != 0) {
                        bundle2.putInt("set_cookie", 1);
                        c.iO(ac.getContext());
                        b cIj = b.cIj();
                        for (String string2 : map.keySet()) {
                            cIj.setCookie(bh.ou(aeq), string2 + "=" + ((String) map.get(string2)));
                        }
                        c.cIl();
                        c.sync();
                        x.i("MicroMsg.GameFloatWebView", "cookies:%s", cIj.getCookie(bh.ou(aeq)));
                        break;
                    }
                    bundle2.putInt("set_cookie", 0);
                    break;
                }
                bundle2.putString("result", "not_return");
                break;
                break;
            case 95:
                this.tFo.mZw.tFt.Z(bundle);
                x.i("MicroMsg.GameFloatWebView", "set game float page time data");
                break;
            case 99:
                bundle2.putInt("geta8key_scene", d.fMy);
                x.i("MicroMsg.GameFloatWebView", "Key value: getA8KeyScene(%d)", Integer.valueOf(init));
                break;
            case 101:
                bundle.setClassLoader(GameWebViewUI.class.getClassLoader());
                com.tencent.mm.bm.d.b(this.tFo.mContext, bundle.getString("open_ui_with_webview_ui_plugin_name"), bundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(bundle.getBundle("open_ui_with_webview_ui_extras")).putExtra("KPublisherId", d.fGF));
                break;
            case 5001:
                if (this.tFo.tFi.isSDCardAvailable()) {
                    x.i("MicroMsg.GameFloatWebView", "availableSize = %d", Long.valueOf(aw.cgd()));
                    if (aw.cgd() < 524288000) {
                        x.e("MicroMsg.GameFloatWebView", "available size not enough");
                    } else {
                        File file = new File(a.tkT);
                        z = true;
                        if (!file.exists()) {
                            z = file.mkdirs();
                            x.i("MicroMsg.GameFloatWebView", "create proxy cache path : %s, %b", file.getAbsolutePath(), Boolean.valueOf(z));
                        }
                        if (z) {
                            init = FactoryProxyManager.getPlayManager().init(this.tFo.mContext, a.tkT);
                            FactoryProxyManager.getPlayManager().setMaxStorageSize(200);
                        }
                    }
                    init = FactoryProxyManager.getPlayManager().init(this.tFo.mContext, null);
                } else {
                    x.i("MicroMsg.GameFloatWebView", "sdcard not available");
                    init = FactoryProxyManager.getPlayManager().init(this.tFo.mContext, null);
                }
                bundle2.putInt("webview_video_proxy_init", init);
                break;
            case 5002:
                aeq = bundle.getString("webview_video_proxy_cdn_urls");
                String string3 = bundle.getString("webview_video_proxy_fileId");
                int i3 = bundle.getInt("webview_video_proxy_file_size");
                init = FactoryProxyManager.getPlayManager().startPlay(aeq, bundle.getInt("webview_video_proxy_file_type"), string3, (long) i3, bundle.getInt("webview_video_proxy_file_duration"));
                x.i("MicroMsg.GameFloatWebView", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d, playDataId = %d, localUrl = %s", aeq, string3, Integer.valueOf(i3), Integer.valueOf(r6), Integer.valueOf(r2), Integer.valueOf(init), FactoryProxyManager.getPlayManager().buildPlayURLMp4(init));
                bundle2.putInt("webview_video_proxy_play_data_id", init);
                bundle2.putString("webview_video_proxy_local_url", r4);
                break;
            case 5003:
                init = bundle.getInt("webview_video_proxy_play_data_id");
                x.i("MicroMsg.GameFloatWebView", "webview proxy stop play, play id = %d", Integer.valueOf(init));
                if (init > 0) {
                    FactoryProxyManager.getPlayManager().stopPlay(init);
                    break;
                }
                break;
            case 5004:
                FactoryProxyManager.getPlayManager().setPlayerState(bundle.getInt("webview_video_proxy_play_state"));
                break;
            case 5005:
                FactoryProxyManager.getPlayManager().setNetWorkState(bundle.getInt("webview_video_proxy_net_state"));
                break;
            case 5006:
                FactoryProxyManager.getPlayManager().setRemainTime(bundle.getInt("webview_video_proxy_play_data_id"), bundle.getInt("webview_video_proxy_play_remain_time"));
                break;
            case 5007:
                x.i("MicroMsg.GameFloatWebView", "playid = %d, duration = %d", Integer.valueOf(bundle.getInt("webview_video_proxy_play_data_id")), Integer.valueOf(bundle.getInt("webview_video_proxy_preload_duration")));
                bundle2.putInt("webview_video_proxy_pre_load_result", FactoryProxyManager.getPlayManager().preLoad(init, i2));
                break;
            case 6001:
                x.i("MicroMsg.GameFloatWebView", "includeCookie = %b", Boolean.valueOf(bundle.getBoolean("clear_webview_cache_clear_cookie", false)));
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(h.xEp, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                intent.putExtra("tools_clean_webview_cache_ignore_cookie", z);
                this.tFo.mContext.sendBroadcast(intent);
                break;
            case 90001:
                x.i("MicroMsg.GameFloatWebView", "url = %s, cookie = %s", aeq(), b.cIj().getCookie(aeq()));
                bundle2.putString("cookie", aeq);
                break;
            case 90002:
                com.tencent.mm.plugin.webview.ui.tools.g.tyi.eP(bundle.getString("traceid"), bundle.getString("username"));
                break;
            default:
                x.e("MicroMsg.GameFloatWebView", "undefine action code!!!");
                break;
        }
        return bundle2;
    }
}
