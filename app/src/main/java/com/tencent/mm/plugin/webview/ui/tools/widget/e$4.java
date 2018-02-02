package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.stub.c;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.util.HashMap;
import java.util.Map;

class e$4 extends g {
    final /* synthetic */ e tKp;
    private g tKq = new g();

    e$4(e eVar) {
        this.tKp = eVar;
    }

    private g bUQ() {
        g ahF = this.tKp.ahF();
        if (ahF == null) {
            return this.tKq;
        }
        return ahF;
    }

    public final boolean Ar(int i) {
        return bUQ().Ar(i);
    }

    public final boolean n(int i, final Bundle bundle) {
        x.i("MicroMsg.MMWebViewClient", "callback, actionCode = " + i);
        Map hashMap;
        final String string;
        final int i2;
        switch (i) {
            case 90:
                if (this.tKp.tFj != null) {
                    this.tKp.mHandler.post(new Runnable(this) {
                        final /* synthetic */ e$4 tKr;

                        public final void run() {
                            if (this.tKr.tKp.tFj != null) {
                                this.tKr.tKp.tFj.PF(bundle.getString("webview_network_type"));
                            }
                        }
                    });
                    break;
                }
                break;
            case 1002:
                this.tKp.mHandler.post(new 1(this, bundle));
                break;
            case 1003:
                this.tKp.mHandler.post(new 8(this, bundle));
                break;
            case 1006:
                if (this.tKp.tFj != null) {
                    this.tKp.mHandler.post(new 4(this, bundle));
                    break;
                }
                break;
            case 1007:
                long j = bundle.getLong("download_manager_downloadid");
                int i3 = bundle.getInt("download_manager_progress");
                this.tKp.mHandler.post(new 10(this, bundle.getString("download_manager_appid", ""), j, i3));
                break;
            case 1008:
                this.tKp.mHandler.post(new Runnable(this) {
                    final /* synthetic */ e$4 tKr;

                    public final void run() {
                        if (this.tKr.tKp.tFj != null && this.tKr.tKp.tGR != null && this.tKr.tKp.tGR.bSs() != null && this.tKr.tKp.tGR.bSs().gn(42)) {
                            this.tKr.tKp.tFj.f(bundle, "download_removed");
                        }
                    }
                });
                break;
            case 2002:
                hashMap = new HashMap();
                hashMap.put("err_msg", bundle.getString("playResult"));
                hashMap.put("localId", bundle.getString("localId"));
                this.tKp.mHandler.post(new 2(this, hashMap));
                break;
            case 2003:
                string = bundle.getString("webview_jssdk_file_item_local_id");
                i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                this.tKp.mHandler.post(new Runnable(this) {
                    final /* synthetic */ e$4 tKr;

                    public final void run() {
                        if (this.tKr.tKp.tFj != null) {
                            this.tKr.tKp.tFj.cD(string, i2);
                        }
                    }
                });
                break;
            case TXLiveConstants.PLAY_EVT_PLAY_BEGIN /*2004*/:
                string = bundle.getString("webview_jssdk_file_item_local_id");
                i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                this.tKp.mHandler.post(new Runnable(this) {
                    final /* synthetic */ e$4 tKr;

                    public final void run() {
                        if (this.tKr.tKp.tFj != null) {
                            this.tKr.tKp.tFj.cE(string, i2);
                        }
                    }
                });
                break;
            case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
                this.tKp.mHandler.post(new 13(this, bundle.getString("webview_jssdk_file_item_local_id"), bundle.getInt("webview_jssdk_file_item_progreess")));
                break;
            case TXLiveConstants.PLAY_EVT_PLAY_END /*2006*/:
                this.tKp.mHandler.post(new 14(this, bundle.getString("webview_jssdk_file_item_local_id"), bundle.getInt("webview_jssdk_file_item_progreess")));
                break;
            case TXLiveConstants.PLAY_EVT_START_VIDEO_DECODER /*2008*/:
                hashMap = new HashMap();
                hashMap.put("localId", bundle.getString("localId"));
                hashMap.put("err_msg", bundle.getString("recordResult"));
                this.tKp.mHandler.post(new Runnable(this) {
                    final /* synthetic */ e$4 tKr;

                    public final void run() {
                        if (this.tKr.tKp.tFj != null) {
                            this.tKr.tKp.tFj.an(hashMap);
                        }
                    }
                });
                break;
            case 2010:
                this.tKp.mHandler.post(new 15(this, bundle.getString("webview_jssdk_file_item_local_id"), bundle.getInt("webview_jssdk_file_item_progreess")));
                break;
            default:
                x.e("MicroMsg.MMWebViewClient", "undefine action code!!!");
                break;
        }
        bUQ().n(i, bundle);
        return true;
    }

    public final boolean a(c cVar) {
        if (this.tKp.juE == null) {
            return true;
        }
        x.i("MicroMsg.MMWebViewClient", "onSceneEnd, instance hashcode = " + this.tKp.juE.hashCode());
        this.tKp.mHandler.post(new 6(this, cVar));
        return bUQ().a(cVar);
    }

    public final boolean a(String str, String str2, Bundle bundle, boolean z) {
        if (this.tKp.tFj != null) {
            final String str3 = str;
            final String str4 = str2;
            final Bundle bundle2 = bundle;
            final boolean z2 = z;
            this.tKp.mHandler.post(new Runnable(this) {
                final /* synthetic */ e$4 tKr;

                public final void run() {
                    this.tKr.tKp.tFj.a(str3, str4, i.aa(bundle2), z2);
                }
            });
            bUQ().a(str, str2, bundle, z);
        }
        return false;
    }

    public final String bRM() {
        return this.tKp.tKf;
    }

    public final String aeq() {
        return this.tKp.aPk();
    }

    public final String bRN() {
        return bUQ().bRN();
    }

    public final void ko(boolean z) {
        bUQ().ko(z);
    }

    public final void kp(boolean z) {
        bUQ().kp(z);
    }

    public final void p(int i, Bundle bundle) {
        bUQ().p(i, bundle);
    }

    public final void bRO() {
        if (this.tKp.tFj != null) {
            this.tKp.tFj.bRO();
        }
    }

    public final void O(Bundle bundle) {
        bUQ().O(bundle);
    }

    public final void OK(String str) {
        bUQ().OK(str);
    }

    public final void eM(String str, String str2) {
        bUQ().eM(str, str2);
    }

    public final void bRP() {
        if (this.tKp.tFj != null) {
            this.tKp.tFj.bRP();
        }
    }

    public final void e(String str, String str2, int i, int i2) {
        bUQ().e(str, str2, i, i2);
    }

    public final Bundle e(int i, Bundle bundle) {
        return bUQ().e(i, bundle);
    }

    public final void P(Bundle bundle) {
        bUQ().P(bundle);
    }

    public final void kq(boolean z) {
        bUQ().kq(z);
    }

    public final void eN(String str, String str2) {
        bUQ().eN(str, str2);
    }
}
