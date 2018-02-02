package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebSettings.RenderPriority;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.g.a.k;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.map.c;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiSendAppMessage;
import com.tencent.mm.plugin.webview.model.a.1;
import com.tencent.mm.plugin.webview.model.ag;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.plugin.webview.model.aj$a;
import com.tencent.mm.plugin.webview.model.aj.m;
import com.tencent.mm.plugin.webview.model.y;
import com.tencent.mm.plugin.webview.model.y.c.2;
import com.tencent.mm.plugin.webview.modeltools.WebViewClipBoardHelper;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.stub.e.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.18;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.7;
import com.tencent.mm.plugin.webview.ui.tools.widget.FontChooserView;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.d;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.qqvideo.proxy.api.IUtils;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.xweb.WebView;
import com.tencent.xweb.b;
import com.tencent.xweb.o;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.Thread.State;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.R$styleable;

public class WebViewUI extends MMActivity implements OnCreateContextMenuListener, d {
    private static final Pattern mZA = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    private static final Pattern mZz = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    private static final Set<String> tsq;
    private static final ArrayList<ab> tyW = new ArrayList();
    private static int tzN = 0;
    private static IUtils tzS = null;
    private static RenderPriority tzc = RenderPriority.NORMAL;
    public e fBH = new a(this) {
        final /* synthetic */ WebViewUI tAv;

        {
            this.tAv = r1;
        }

        public final boolean n(int i, final Bundle bundle) {
            x.i("MicroMsg.WebViewUI", "callback, actionCode = " + i);
            final String string;
            Map hashMap;
            switch (i) {
                case 13:
                    if (bundle != null) {
                        bundle.putString("application_language", this.tAv.juQ.getLanguage());
                        this.tAv.tzv = new d(bundle);
                        break;
                    }
                    break;
                case 15:
                    this.tAv.handler.post(new 11(this, bundle.getString("exdevice_device_id"), bundle.getByteArray("exdevice_broadcast_data"), bundle.getBoolean("exdevice_is_complete"), bundle.getBoolean("exdevice_is_lan_device")));
                    break;
                case 16:
                    this.tAv.handler.post(new 13(this, bundle.getString("exdevice_device_id"), bundle.getByteArray("exdevice_data"), bundle.getString("exdevice_brand_name")));
                    break;
                case 17:
                    this.tAv.handler.post(new 14(this, bundle.getString("exdevice_device_id"), bundle.getBoolean("exdevice_is_bound")));
                    break;
                case 18:
                    this.tAv.handler.post(new 15(this, bundle.getBoolean("exdevice_bt_state")));
                    break;
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                case R$styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                case R$styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                case R$styleable.AppCompatTheme_actionDropDownStyle /*45*/:
                case 46:
                    WebViewUI.bTb();
                    break;
                case 47:
                    this.tAv.handler.post(new 16(this, bundle.getBoolean("exdevice_lan_state")));
                    break;
                case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                    String[] stringArray = bundle.getStringArray("msgIds");
                    String[] stringArray2 = bundle.getStringArray("contents");
                    String[] stringArray3 = bundle.getStringArray("senders");
                    int[] intArray = bundle.getIntArray("msgTypes");
                    int[] intArray2 = bundle.getIntArray("msgTimes");
                    JSONArray jSONArray = new JSONArray();
                    int length = stringArray == null ? 0 : stringArray.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("newMsgId", stringArray[i2]);
                            jSONObject.put("content", stringArray2[i2]);
                            jSONObject.put("sender", stringArray3[i2]);
                            jSONObject.put("msgType", intArray[i2]);
                            jSONObject.put("msgTime", intArray2[i2]);
                            jSONArray.put(jSONObject);
                        } catch (JSONException e) {
                            x.e("MicroMsg.WebViewUI", "GetMsgProofItems exception " + e.getMessage());
                        }
                    }
                    this.tAv.handler.post(new 19(this, jSONArray));
                    break;
                case 60:
                case 61:
                case 62:
                case 119:
                case 120:
                case 121:
                case 122:
                case 123:
                case 124:
                case 125:
                case 126:
                case 127:
                case FileUtils.S_IWUSR /*128*/:
                case 130:
                case com.tencent.mm.plugin.appbrand.jsapi.map.d.CTRL_INDEX /*133*/:
                case c.CTRL_INDEX /*134*/:
                case com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX /*135*/:
                case com.tencent.mm.plugin.appbrand.jsapi.map.h.CTRL_INDEX /*136*/:
                case 137:
                case 138:
                case 142:
                case 143:
                case com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX /*144*/:
                case com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX /*145*/:
                case 100001:
                case 100002:
                case 200000:
                case 200001:
                case 200002:
                case 200003:
                    this.tAv.h(i, bundle);
                    break;
                case 70:
                    x.i("MicroMsg.WebViewUI", "on service click, update tid = %s", new Object[]{bundle.getString("service_click_tid")});
                    this.tAv.tzU = string;
                    this.tAv.tzV = System.currentTimeMillis();
                    this.tAv.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 tAx;

                        {
                            this.tAx = r1;
                        }

                        public final void run() {
                            if (this.tAx.tAv.ptK != null) {
                                com.tencent.mm.plugin.normsg.a.d.oSu.a(this.tAx.tAv.ptK, ow.class);
                                if (this.tAx.tAv.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("forceTrigger", false)) {
                                    x.i("MicroMsg.WebViewUI", "on service click, test");
                                    com.tencent.mm.sdk.b.a.xef.m(new ow());
                                }
                            }
                        }
                    });
                    break;
                case 90:
                    this.tAv.handler.post(new 20(this, bundle.getString("webview_network_type")));
                    break;
                case 1001:
                    if (!this.tAv.isFinishing()) {
                        this.tAv.finish();
                        break;
                    }
                    break;
                case 1002:
                    this.tAv.handler.post(new 1(this, bundle));
                    break;
                case 1003:
                    this.tAv.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 tAx;

                        public final void run() {
                            if (this.tAx.tAv.tlx != null && this.tAx.tAv.juR != null && this.tAx.tAv.juR.bSs() != null && this.tAx.tAv.juR.bSs().gn(42)) {
                                this.tAx.tAv.tlx.f(bundle, "download_fail");
                            }
                        }
                    });
                    break;
                case 1004:
                    string = bundle.getString("exdevice_device_id");
                    final int i3 = bundle.getInt("exdevice_on_state_change_state");
                    final Boolean valueOf = Boolean.valueOf(bundle.getBoolean("exdevice_inner_call"));
                    this.tAv.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 tAx;

                        public final void run() {
                            boolean z = false;
                            if (this.tAx.tAv.tlx != null && this.tAx.tAv.juR != null && this.tAx.tAv.juR.bSs() != null) {
                                this.tAx.tAv.juR.bSs();
                                JsapiPermissionWrapper.cdF();
                                this.tAx.tAv.tlx.cC(string, i3);
                            } else if (this.tAx.tAv.tlx == null || !valueOf.booleanValue()) {
                                String str = "MicroMsg.WebViewUI";
                                String str2 = "something null, %s, %s";
                                Object[] objArr = new Object[2];
                                objArr[0] = Boolean.valueOf(this.tAx.tAv.tlx == null);
                                if (this.tAx.tAv.juR == null) {
                                    z = true;
                                }
                                objArr[1] = Boolean.valueOf(z);
                                x.w(str, str2, objArr);
                            } else {
                                this.tAx.tAv.tlx.cC(string, i3);
                            }
                        }
                    });
                    break;
                case 1006:
                    if (this.tAv.tlx != null) {
                        this.tAv.handler.post(new 10(this, bundle));
                        break;
                    }
                    break;
                case 1007:
                    final long j = bundle.getLong("download_manager_downloadid");
                    final int i4 = bundle.getInt("download_manager_progress");
                    final String string2 = bundle.getString("download_manager_appid", "");
                    this.tAv.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 tAx;

                        public final void run() {
                            if (this.tAx.tAv.tlx != null && this.tAx.tAv.juR != null && this.tAx.tAv.juR.bSs() != null && this.tAx.tAv.juR.bSs().gn(42)) {
                                this.tAx.tAv.tlx.g(string2, j, i4);
                            }
                        }
                    });
                    break;
                case 1008:
                    this.tAv.handler.post(new 23(this, bundle));
                    break;
                case 2002:
                    hashMap = new HashMap();
                    hashMap.put("err_msg", bundle.getString("playResult"));
                    hashMap.put("localId", bundle.getString("localId"));
                    this.tAv.handler.post(new 5(this, hashMap));
                    break;
                case 2003:
                    this.tAv.handler.post(new 51(this, bundle.getString("webview_jssdk_file_item_local_id"), bundle.getInt("webview_jssdk_file_item_progreess")));
                    break;
                case TXLiveConstants.PLAY_EVT_PLAY_BEGIN /*2004*/:
                    this.tAv.handler.post(new 53(this, bundle.getString("webview_jssdk_file_item_local_id"), bundle.getInt("webview_jssdk_file_item_progreess")));
                    break;
                case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
                    this.tAv.handler.post(new 2(this, bundle.getString("webview_jssdk_file_item_local_id"), bundle.getInt("webview_jssdk_file_item_progreess")));
                    break;
                case TXLiveConstants.PLAY_EVT_PLAY_END /*2006*/:
                    this.tAv.handler.post(new 3(this, bundle.getString("webview_jssdk_file_item_local_id"), bundle.getInt("webview_jssdk_file_item_progreess")));
                    break;
                case TXLiveConstants.PLAY_EVT_PLAY_LOADING /*2007*/:
                    this.tAv.handler.post(new 7(this));
                    break;
                case TXLiveConstants.PLAY_EVT_START_VIDEO_DECODER /*2008*/:
                    hashMap = new HashMap();
                    hashMap.put("localId", bundle.getString("localId"));
                    hashMap.put("err_msg", bundle.getString("recordResult"));
                    this.tAv.handler.post(new 8(this, hashMap));
                    break;
                case TXLiveConstants.PLAY_EVT_CHANGE_RESOLUTION /*2009*/:
                    this.tAv.handler.post(new 9(this));
                    break;
                case 2010:
                    this.tAv.handler.post(new 4(this, bundle.getString("webview_jssdk_file_item_local_id"), bundle.getInt("webview_jssdk_file_item_progreess")));
                    break;
                case 2011:
                    this.tAv.handler.post(new 50(this, bundle.getString("webview_jssdk_file_item_local_id"), bundle.getInt("webview_jssdk_file_item_progreess")));
                    break;
                case 2100:
                    this.tAv.handler.post(new 52(this, bundle.getString("background_audio_state_player_state"), bundle.getInt("background_audio_state_player_duration"), bundle.getString("background_audio_state_player_src"), bundle.getInt("background_audio_state_player_err_code"), bundle.getString("background_audio_state_player_err_msg"), bundle.getString("background_audio_state_player_src_id")));
                    break;
                case 4007:
                    this.tAv.handler.post(new 6(this, bundle.getInt("nfc_key_on_touch_errcode", 0)));
                    break;
                case 40001:
                    this.tAv.handler.post(new 17(this, bundle.getString("err_msg")));
                    break;
                case 40002:
                    this.tAv.handler.post(new 18(this, bundle.getString("uuid"), bundle.getInt("major"), bundle.getInt("minor"), bundle.getDouble("accuracy"), bundle.getDouble("rssi"), bundle.getFloat("heading")));
                    break;
                case 80001:
                case 80002:
                    this.tAv.s(i, bundle);
                    break;
                default:
                    x.e("MicroMsg.WebViewUI", "undefine action code!!!");
                    break;
            }
            return true;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(final com.tencent.mm.plugin.webview.stub.c cVar) {
            boolean z = false;
            if (!(this.tAv.tze.tBz > 0)) {
                boolean z2;
                if (this.tAv.tzf.tBA > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    if (this.tAv.tzg.tBB > 0) {
                        z = true;
                    }
                    if (!z) {
                    }
                }
            }
            this.tAv.handler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass12 tAx;

                public final void run() {
                    this.tAx.tAv.b(cVar);
                }
            });
            return true;
        }

        public final boolean Ar(int i) {
            this.tAv.handler.post(new 24(this, i));
            return true;
        }

        public final boolean a(String str, String str2, Bundle bundle, boolean z) {
            if (this.tAv.tlx != null) {
                this.tAv.runOnUiThread(new 25(this, str, str2, bundle, z));
            }
            return false;
        }

        public final String bRM() {
            return this.tAv.fIG;
        }

        public final String aeq() {
            return this.tAv.aPk();
        }

        public final String bRN() {
            return this.tAv.getIntent().getStringExtra("srcUsername");
        }

        public final void ko(boolean z) {
            x.d("MicroMsg.WebViewUI", "[cpan] setShareBtnVisible:%d visible:%b  forceHideShare:%b", new Object[]{Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(z), Boolean.valueOf(this.tAv.getIntent().getBooleanExtra("forceHideShare", false))});
            this.tAv.handler.post(new 26(this, r0, z));
        }

        public final void kp(final boolean z) {
            this.tAv.handler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass12 tAx;

                public final void run() {
                    this.tAx.tAv.ku(z);
                }
            });
        }

        public final void bRO() {
            if (this.tAv.tlx != null) {
                this.tAv.tlx.bRO();
            }
        }

        public final void O(Bundle bundle) {
            x.i("MicroMsg.WebViewUI", "IUIController, closeWindow");
            if (bundle != null) {
                Intent intent = new Intent();
                intent.putExtra("result_data", bundle);
                this.tAv.setResult(-1, intent);
            }
            this.tAv.finish();
        }

        public final void OK(String str) {
            int i = 0;
            try {
                i = bh.getInt(str, 0);
            } catch (Exception e) {
                x.e("MicroMsg.WebViewUI", "setFontSizeCb, ex = " + e.getMessage());
            }
            if (this.tAv.ptK == null) {
                x.e("MicroMsg.WebViewUI", "setFontSizeCb fail, viewWV is null");
            } else {
                this.tAv.handler.post(new 28(this, i));
            }
        }

        public final void bRP() {
            if (this.tAv.tlx != null) {
                this.tAv.tlx.bRP();
            }
        }

        public final void e(String str, final String str2, int i, int i2) {
            x.d("MicroMsg.WebViewUI", "result: " + str2);
            if (this.tAv.juW != null && str != null && str.equals(this.tAv.juW.tvd)) {
                if (this.tAv.juW != null) {
                    this.tAv.juW.bRG();
                }
                this.tAv.juU = i;
                this.tAv.juV = i2;
                if (str2 != null && this.tAv.juS != null) {
                    this.tAv.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 tAx;

                        public final void run() {
                            if (this.tAx.tAv.ptK != null) {
                                this.tAx.tAv.juT = str2;
                                this.tAx.tAv.juS.b(this.tAx.tAv.ptK, new 1(this), null);
                                this.tAx.tAv.juS.bBX();
                            }
                        }
                    });
                }
            }
        }

        public final void p(int i, Bundle bundle) {
            this.tAv.handler.post(new 30(this, i, bundle));
        }

        public final void eM(final String str, String str2) {
            this.tAv.handler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass12 tAx;

                public final void run() {
                    if (bh.ov(this.tAx.tAv.ptK.getUrl())) {
                        x.i("MicroMsg.WebViewUI", "setPageOwner, null url");
                        return;
                    }
                    x.i("MicroMsg.WebViewUI", "setPageOwner, userName = " + str);
                    this.tAx.tAv.tzr.put(this.tAx.tAv.ptK.getUrl(), str);
                }
            });
        }

        public final Bundle e(int i, Bundle bundle) {
            x.i("MicroMsg.WebViewUI", "invokeAsResult, actionCode = " + i);
            final Bundle bundle2 = new Bundle();
            Intent intent;
            int b;
            String string;
            String string2;
            boolean z;
            boolean z2;
            CharSequence mMTitle;
            String aeq;
            int init;
            switch (i) {
                case 11:
                    this.tAv.runOnUiThread(new 46(this));
                    break;
                case 12:
                    this.tAv.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 tAx;

                        {
                            this.tAx = r1;
                        }

                        public final void run() {
                            this.tAx.tAv.tzv = null;
                        }
                    });
                    break;
                case 18:
                    bundle2.putString("KPublisherId", this.tAv.fGF);
                    intent = this.tAv.getIntent();
                    if (intent != null) {
                        b = this.tAv.Pp(this.tAv.getIntent().getStringExtra("geta8key_username"));
                        bundle2.putString("preChatName", intent.getStringExtra("preChatName"));
                        bundle2.putInt("preMsgIndex", intent.getIntExtra("preMsgIndex", 0));
                        bundle2.putString("prePublishId", intent.getStringExtra("prePublishId"));
                        bundle2.putString("preUsername", intent.getStringExtra("preUsername"));
                        bundle2.putInt("getA8KeyScene", b);
                        bundle2.putString("referUrl", this.tAv.ttj);
                        break;
                    }
                    break;
                case 22:
                    bundle2.putInt("pay_channel", this.tAv.getIntent().getIntExtra("pay_channel", -1));
                    x.i("MicroMsg.WebViewUI", "key value: pay channel(%d)", new Object[]{Integer.valueOf(this.tAv.getIntent().getIntExtra("pay_channel", -1))});
                    break;
                case 25:
                    bundle2.putInt("scene", this.tAv.getIntent().getIntExtra("scene", -1));
                    x.i("MicroMsg.WebViewUI", "Key value: Scene(%d)", new Object[]{Integer.valueOf(this.tAv.getIntent().getIntExtra("scene", 0))});
                    break;
                case 33:
                    intent = this.tAv.getIntent();
                    if (intent != null) {
                        bundle2.putString("publishIdPrefix", intent.getStringExtra("publishIdPrefix"));
                        bundle2.putString("reportSessionId", intent.getStringExtra("reportSessionId"));
                        break;
                    }
                    break;
                case 34:
                    this.tAv.runOnUiThread(new 35(this));
                    break;
                case 35:
                    this.tAv.runOnUiThread(new 38(this));
                    break;
                case 36:
                    this.tAv.runOnUiThread(new 36(this));
                    break;
                case 37:
                    this.tAv.runOnUiThread(new 40(this, bundle.getString("show_kb_placeholder"), bundle.getInt("show_kb_max_length")));
                    break;
                case 38:
                    if (bundle.getInt("webview_disable_bounce_scroll_top", 0) > 0) {
                        this.tAv.runOnUiThread(new 33(this));
                        break;
                    }
                    break;
                case 39:
                    this.tAv.runOnUiThread(new 39(this));
                    break;
                case R$styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                    this.tAv.runOnUiThread(new 42(this, bundle.getString("set_page_title_text"), d.aK(bundle.getString("set_page_title_color"), this.tAv.bSC())));
                    break;
                case R$styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                    Bitmap bitmap;
                    string = bundle.getString("set_navigation_bar_buttons_text");
                    string2 = bundle.getString("set_navigation_bar_buttons_icon_data");
                    z = bundle.getBoolean("set_navigation_bar_buttons_hide_right_button", false);
                    if (bh.ov(string2)) {
                        bitmap = null;
                    } else {
                        try {
                            bitmap = d.Pe(string2);
                        } catch (Exception e) {
                            bitmap = null;
                            x.e("MicroMsg.WebViewUI", "setNavigationBarButtons, decode base64 image, exception = %s", new Object[]{e});
                        }
                    }
                    this.tAv.runOnUiThread(new 43(this, z, bitmap, string, d.aK(bundle.getString("set_navigation_bar_buttons_left_text_color"), -1)));
                    break;
                case R$styleable.AppCompatTheme_actionDropDownStyle /*45*/:
                    this.tAv.runOnUiThread(new 44(this, bundle));
                    break;
                case 47:
                    this.tAv.runOnUiThread(new 37(this));
                    break;
                case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                case R$styleable.AppCompatTheme_actionButtonStyle /*49*/:
                    break;
                case 53:
                    this.tAv.runOnUiThread(new 48(this, bundle));
                    break;
                case 54:
                    z2 = bundle.getBoolean("add_shortcut_status");
                    if (this.tAv.tlx != null) {
                        this.tAv.tlx.kA(z2);
                        break;
                    }
                    break;
                case R$styleable.AppCompatTheme_listPreferredItemHeightLarge /*71*/:
                    if (bundle.getString("enterprise_action").equals("enterprise_get_context_bizchat")) {
                        bundle2.putString("enterprise_context_biz", this.tAv.getIntent().getStringExtra("enterprise_biz_name"));
                        bundle2.putLong("enterprise_context_bizchatid", this.tAv.getIntent().getLongExtra("biz_chat_chat_id", -1));
                        break;
                    }
                    break;
                case 72:
                    this.tAv.tAe.AF(d.aK(bundle.getString("key_set_bounce_background_color"), this.tAv.getResources().getColor(R.e.buh)));
                    break;
                case 73:
                    intent = this.tAv.getIntent();
                    if (bundle != null) {
                        switch (bundle.getInt("scene")) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 37:
                            case R$styleable.AppCompatTheme_actionDropDownStyle /*45*/:
                                bundle2.putStringArrayList("content", intent.getStringArrayListExtra("k_outside_expose_proof_item_list"));
                                break;
                            case 33:
                                bundle2.putString("newMsgId", String.valueOf(intent.getLongExtra("k_expose_msg_id", 0)));
                                break;
                            case 34:
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("<exposecontent>");
                                stringBuilder.append("<weburl>");
                                if (intent.getStringExtra("k_expose_current_url") != null) {
                                    stringBuilder.append(intent.getStringExtra("k_expose_current_url"));
                                }
                                stringBuilder.append("</weburl>");
                                stringBuilder.append("<webscence>");
                                stringBuilder.append(this.tAv.Pp(this.tAv.getIntent().getStringExtra("geta8key_username")));
                                stringBuilder.append("</webscence>");
                                stringBuilder.append("</exposecontent>");
                                bundle2.putString("content", stringBuilder.toString());
                                break;
                            case 35:
                            case 36:
                            case 38:
                            case 39:
                                break;
                            case 51:
                                bundle2.putString("newMsgId", String.valueOf(intent.getLongExtra("k_expose_msg_id", 0)));
                                bundle2.putStringArrayList("content", intent.getStringArrayListExtra("k_outside_expose_proof_item_list"));
                                bundle2.putInt("msgType", intent.getIntExtra("k_expose_msg_type", 0));
                                break;
                            default:
                                x.d("MicroMsg.WebViewUI", "unknown expose scene: %d", new Object[]{Integer.valueOf(bundle.getInt("scene"))});
                                return bundle2;
                        }
                        bundle2.putString("username", intent.getStringExtra("k_username"));
                        break;
                    }
                    break;
                case 77:
                    bundle2.putString("KSessionId", this.tAv.fqu);
                    bundle2.putString("KUserAgent", this.tAv.jFe);
                    bundle2.putBoolean("KReportPage", this.tAv.tyF);
                    bundle2.putString("KUrl", this.tAv.tAn);
                    break;
                case 79:
                    this.tAv.runOnUiThread(new 41(this, bundle2));
                    break;
                case 81:
                    bundle2.putBoolean("from_shortcut", this.tAv.tyN);
                    break;
                case 84:
                    mMTitle = this.tAv.mController.getMMTitle();
                    aeq = aeq();
                    bundle2.putString("webview_current_url", aeq);
                    bundle2.putString("webview_current_title", mMTitle != null ? mMTitle.toString() : "");
                    bundle2.putString("webview_current_desc", aeq);
                    break;
                case 85:
                    mMTitle = this.tAv.mController.getMMTitle();
                    aeq = aeq();
                    Intent intent2 = this.tAv.getIntent();
                    if (intent2 != null) {
                        bundle2.putString("share_report_pre_msg_url", intent2.getStringExtra("share_report_pre_msg_url"));
                        bundle2.putString("share_report_pre_msg_title", intent2.getStringExtra("share_report_pre_msg_title"));
                        bundle2.putString("share_report_pre_msg_desc", intent2.getStringExtra("share_report_pre_msg_desc"));
                        bundle2.putString("share_report_pre_msg_icon_url", intent2.getStringExtra("share_report_pre_msg_icon_url"));
                        bundle2.putString("share_report_pre_msg_appid", intent2.getStringExtra("share_report_pre_msg_appid"));
                        bundle2.putInt("share_report_from_scene", intent2.getIntExtra("share_report_from_scene", 0));
                        bundle2.putString("share_report_biz_username", intent2.getStringExtra("share_report_biz_username"));
                    }
                    bundle2.putString("share_report_current_url", aeq);
                    bundle2.putString("share_report_current_title", mMTitle != null ? mMTitle.toString() : "");
                    break;
                case 86:
                    bundle2.putBoolean("is_from_keep_top", this.tAv.getIntent().getBooleanExtra("is_from_keep_top", false));
                    break;
                case R$styleable.AppCompatTheme_colorControlHighlight /*87*/:
                    if (!this.tAv.tzF) {
                        bundle2.putString("full_url", bh.ou(this.tAv.mFa));
                        if (this.tAv.tzH != null && this.tAv.tzH.size() != 0) {
                            bundle2.putInt("set_cookie", 1);
                            com.tencent.xweb.c.iO(ac.getContext());
                            b cIj = b.cIj();
                            for (String string22 : this.tAv.tzH.keySet()) {
                                cIj.setCookie(bh.VZ(this.tAv.mFa), string22 + "=" + ((String) this.tAv.tzH.get(string22)));
                            }
                            cIj.setCookie(bh.VZ(this.tAv.mFa), "httponly");
                            com.tencent.xweb.c.cIl();
                            com.tencent.xweb.c.sync();
                            x.i("MicroMsg.WebViewUI", "cookies:%s", new Object[]{cIj.getCookie(bh.VZ(this.tAv.mFa))});
                            break;
                        }
                        bundle2.putInt("set_cookie", 0);
                        break;
                    }
                    bundle2.putString("result", "not_return");
                    break;
                    break;
                case 95:
                    this.tAv.T(bundle);
                    break;
                case 97:
                    bundle2.putInt("web_page_count", WebViewUI.tzN);
                    break;
                case 99:
                    bundle2.putInt("geta8key_scene", this.tAv.getIntent().getIntExtra("geta8key_scene", 0));
                    x.i("MicroMsg.WebViewUI", "Key value: getA8KeyScene(%d)", new Object[]{Integer.valueOf(init)});
                    break;
                case 101:
                    bundle.setClassLoader(WebViewUI.class.getClassLoader());
                    com.tencent.mm.bm.d.b(this.tAv, bundle.getString("open_ui_with_webview_ui_plugin_name"), bundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(bundle.getBundle("open_ui_with_webview_ui_extras")).putExtra("KPublisherId", this.tAv.fGF));
                    break;
                case HardCoderJNI.FUNC_RESET_SCREEN_RESOLUTION /*1009*/:
                    if (this.tAv.tyy != null) {
                        this.tAv.tyy.disable();
                    }
                    this.tAv.screenOrientation = bundle.getInt("screen_orientation", -1);
                    if (this.tAv.screenOrientation == 1001) {
                        this.tAv.screenOrientation = 0;
                        if (this.tAv.tyy != null) {
                            x.i("MicroMsg.WebViewUI", "OrientationListener, start listen orientation change");
                            this.tAv.tyy.enable();
                        }
                    } else if (this.tAv.screenOrientation == 1002) {
                        this.tAv.screenOrientation = 1;
                        if (this.tAv.tyy != null) {
                            x.i("MicroMsg.WebViewUI", "OrientationListener, start listen orientation change");
                            this.tAv.tyy.enable();
                        }
                    }
                    this.tAv.afg();
                    break;
                case 4001:
                case 4002:
                case 4003:
                case 4004:
                case 4005:
                case 4008:
                    final com.tencent.mm.sdk.b.b kVar = new k();
                    kVar.fnb.context = this.tAv.mController.xIM;
                    kVar.fnb.actionCode = i;
                    if (4003 == i) {
                        kVar.fnb.fnd = bundle.getString("apdu");
                    } else if (4004 == i) {
                        aeq = bundle.getString("apdus");
                        z = bundle.getBoolean("breakIfFail", true);
                        boolean z3 = bundle.getBoolean("breakIfTrue", false);
                        kVar.fnb.fnd = aeq;
                        kVar.fnb.fne = z;
                        kVar.fnb.fnf = z3;
                    }
                    kVar.fqI = new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 tAx;

                        public final void run() {
                            bundle2.putAll(kVar.fnc.fng);
                        }
                    };
                    com.tencent.mm.sdk.b.a.xef.m(kVar);
                    break;
                case 5001:
                    if (this.tAv.juQ.isSDCardAvailable()) {
                        x.i("MicroMsg.WebViewUI", "availableSize = %d", new Object[]{Long.valueOf(aw.cgd())});
                        if (aw.cgd() < 524288000) {
                            x.e("MicroMsg.WebViewUI", "available size not enough");
                        } else {
                            File file = new File(com.tencent.mm.plugin.webview.a.tkT);
                            z2 = true;
                            if (!file.exists()) {
                                z2 = file.mkdirs();
                                x.i("MicroMsg.WebViewUI", "create proxy cache path : %s, %b", new Object[]{file.getAbsolutePath(), Boolean.valueOf(z2)});
                            }
                            if (z2) {
                                init = FactoryProxyManager.getPlayManager().init(this.tAv, com.tencent.mm.plugin.webview.a.tkT);
                                FactoryProxyManager.getPlayManager().setMaxStorageSize(200);
                            }
                        }
                        init = FactoryProxyManager.getPlayManager().init(this.tAv, null);
                    } else {
                        x.i("MicroMsg.WebViewUI", "sdcard not available");
                        init = FactoryProxyManager.getPlayManager().init(this.tAv, null);
                    }
                    if (init == 0) {
                        if (WebViewUI.tzS == null) {
                            WebViewUI.tzS = new y(this.tAv, (byte) 0);
                            FactoryProxyManager.getPlayManager().setUtilsObject(WebViewUI.tzS);
                        }
                        b = FactoryProxyManager.getPlayManager().getLocalServerPort();
                        x.i("MicroMsg.WebViewUI", "webview video init result = %d, local port = %d", new Object[]{Integer.valueOf(init), Integer.valueOf(b)});
                        ag n = this.tAv.tzW;
                        if (b <= 0 || b > 65535) {
                            x.e("MicroMsg.WebViewResourceInterrupter", "err port = %d", new Object[]{Integer.valueOf(b)});
                        }
                        if (!n.tsA.contains(Integer.valueOf(b))) {
                            n.tsA.add(Integer.valueOf(b));
                        }
                    }
                    bundle2.putInt("webview_video_proxy_init", init);
                    break;
                case 5002:
                    init = FactoryProxyManager.getPlayManager().startPlay(bundle.getString("webview_video_proxy_cdn_urls"), bundle.getInt("webview_video_proxy_file_type"), bundle.getString("webview_video_proxy_fileId"), (long) bundle.getInt("webview_video_proxy_file_size"), bundle.getInt("webview_video_proxy_file_duration"));
                    x.i("MicroMsg.WebViewUI", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d, playDataId = %d, localUrl = %s", new Object[]{aeq, r3, Integer.valueOf(r8), Integer.valueOf(r6), Integer.valueOf(r2), Integer.valueOf(init), FactoryProxyManager.getPlayManager().buildPlayURLMp4(init)});
                    bundle2.putInt("webview_video_proxy_play_data_id", init);
                    bundle2.putString("webview_video_proxy_local_url", string);
                    break;
                case 5003:
                    init = bundle.getInt("webview_video_proxy_play_data_id");
                    x.i("MicroMsg.WebViewUI", "webview proxy stop play, play id = %d", new Object[]{Integer.valueOf(init)});
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
                    x.i("MicroMsg.WebViewUI", "playid = %d, duration = %d", new Object[]{Integer.valueOf(bundle.getInt("webview_video_proxy_play_data_id")), Integer.valueOf(bundle.getInt("webview_video_proxy_preload_duration"))});
                    bundle2.putInt("webview_video_proxy_pre_load_result", FactoryProxyManager.getPlayManager().preLoad(init, b));
                    break;
                case 6001:
                    x.i("MicroMsg.WebViewUI", "includeCookie = %b", new Object[]{Boolean.valueOf(bundle.getBoolean("clear_webview_cache_clear_cookie", false))});
                    Intent intent3 = new Intent();
                    intent3.setComponent(new ComponentName(com.tencent.mm.ui.e.h.xEp, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                    intent3.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                    intent3.putExtra("tools_clean_webview_cache_ignore_cookie", z2);
                    this.tAv.sendBroadcast(intent3);
                    break;
                case 90000:
                    bundle2.putStringArray("webview_get_route_url_list", this.tAv.tzR.bRH());
                    bundle2.putInt("webview_get_route_url_geta8key_scene", this.tAv.Pp(this.tAv.getIntent().getStringExtra("geta8key_username")));
                    bundle2.putString("geta8key_username", this.tAv.getIntent().getStringExtra("geta8key_username"));
                    break;
                case 90001:
                    x.i("MicroMsg.WebViewUI", "url = %s, cookie = %s", new Object[]{this.tAv.aPk(), b.cIj().getCookie(this.tAv.aPk())});
                    bundle2.putString("cookie", aeq);
                    break;
                case 90002:
                    g.tyi.eP(bundle.getString("traceid"), bundle.getString("username"));
                    break;
                default:
                    x.e("MicroMsg.WebViewUI", "undefine action code!!!");
                    break;
            }
            return bundle2;
        }

        public final void P(Bundle bundle) {
            x.i("MicroMsg.WebViewUI", "setCustomMenu");
            ArrayList stringArrayList = bundle.getStringArrayList("keys");
            ArrayList stringArrayList2 = bundle.getStringArrayList("titles");
            int size = stringArrayList.size();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                arrayList.add(new com.tencent.mm.k.d.b((String) stringArrayList.get(i), (String) stringArrayList2.get(i)));
            }
            if (stringArrayList.size() > 0) {
                String url = this.tAv.ptK.getUrl();
                if (this.tAv.tzs.containsKey(url)) {
                    this.tAv.tzs.remove(url);
                }
                this.tAv.tzs.put(url, arrayList);
            }
        }

        public final void kq(boolean z) {
            this.tAv.kw(z);
        }

        public final void eN(final String str, final String str2) {
            this.tAv.handler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass12 tAx;

                public final void run() {
                    if (!bh.ov(str)) {
                        if (!bh.ov(str2)) {
                            this.tAx.tAv.getIntent().putExtra("view_port_code", str2);
                        }
                        this.tAx.tAv.ptK.loadUrl(str);
                    }
                }
            });
        }
    };
    private String fGF;
    public volatile String fIG = null;
    private int fMy;
    private String fqu = "";
    private int fromScene;
    public af handler;
    private int height;
    private String jFe = "";
    private String jIW;
    private long jIf = 0;
    public int jNd;
    public com.tencent.mm.plugin.webview.stub.d juQ = null;
    public e juR = null;
    com.tencent.mm.ui.tools.l juS;
    String juT;
    int juU;
    int juV;
    g juW;
    WebView.a juX;
    WebView.a juY;
    private final com.tencent.mm.plugin.webview.modeltools.c juZ = new com.tencent.mm.plugin.webview.modeltools.c();
    private g.c jvc = new 28(this);
    private long kCY = 0;
    private ServiceConnection lrm = new 34(this);
    public String mFa;
    public boolean mZp = true;
    private int mZs = 0;
    private List<com.tencent.mm.plugin.webview.ui.tools.jsapi.b> naK = new ArrayList();
    private long naL = 0;
    private Map<String, Integer> naf = new HashMap();
    protected com.tencent.mm.ui.snackbar.b.b nah = new com.tencent.mm.ui.snackbar.b.b(this) {
        final /* synthetic */ WebViewUI tAv;

        {
            this.tAv = r1;
        }

        public final void aPO() {
            try {
                this.tAv.juQ.favEditTag();
            } catch (Exception e) {
                x.e("MicroMsg.WebViewUI", "favorite edittag fail, ex = " + e.getMessage());
            }
        }
    };
    private int networkType;
    public View nmo;
    private View nmp;
    public int nmq = 0;
    public String nmr = null;
    public MMWebView ptK;
    private boolean ryW = true;
    public int screenOrientation = -1;
    @Deprecated
    private boolean tAa = false;
    private int tAb = 0;
    private com.tencent.mm.plugin.webview.modeltools.e.b tAc = new 2(this);
    private boolean tAd = false;
    public final f tAe = new f();
    private boolean tAf;
    private OnLongClickListener tAg = new 25(this);
    String[] tAh;
    private Map<String, SparseBooleanArray> tAi = new HashMap();
    private String tAj = "";
    private volatile String tAk = "";
    private volatile String tAl = null;
    private volatile String tAm = "";
    private volatile String tAn = "";
    private long tAo = 0;
    private r tAp;
    private y.d tAq = new 58(this);
    private y.b tAr = new 59(this);
    private com.tencent.mm.ui.base.k tAs;
    private String[] tAt = null;
    public int tAu = -1;
    public com.tencent.mm.plugin.webview.ui.tools.jsapi.d tlx = null;
    public aj trN = new aj();
    private volatile String ttj;
    protected boolean twI = true;
    private final com.tencent.mm.plugin.webview.modeltools.a txz = new com.tencent.mm.plugin.webview.modeltools.a();
    public WebViewSearchContentInputFooter tyA;
    private boolean tyB;
    private boolean tyC;
    public String tyD = null;
    private boolean tyE = false;
    public boolean tyF = false;
    public boolean tyG = false;
    private boolean tyH = false;
    private boolean tyI = false;
    private boolean tyJ = true;
    private boolean tyK = false;
    private boolean tyL = false;
    private boolean tyM = false;
    private boolean tyN = false;
    private boolean tyO = true;
    private int tyP;
    private String tyQ = null;
    private byte[] tyR = new byte[0];
    private boolean tyS = false;
    private boolean tyT = false;
    View tyU;
    ak tyV;
    private boolean tyX = false;
    private CustomViewCallback tyY;
    private View tyZ;
    protected boolean tyn = false;
    public MMFalseProgressBar tyo;
    public ProgressBar typ;
    private ImageButton tyq;
    private ImageButton tyr;
    private View tys;
    public FrameLayout tyt;
    public FrameLayout tyu;
    public MovingImageButton tyv;
    public boolean tyw = false;
    public boolean tyx = false;
    protected com.tencent.mm.plugin.webview.modeltools.e tyy;
    private WebViewInputFooter tyz;
    private boolean tzA = false;
    private volatile boolean tzB = false;
    private volatile boolean tzC = false;
    private final Set<String> tzD = new HashSet();
    private boolean tzE = false;
    private boolean tzF = false;
    private final Map<String, Map<String, String>> tzG = new ConcurrentHashMap();
    private Map<String, String> tzH;
    private Map tzI;
    private String tzJ = "";
    private boolean tzK = false;
    private final Map<String, String> tzL = new HashMap();
    private final Set<String> tzM = new HashSet();
    public boolean tzO = false;
    private boolean tzP = false;
    private com.tencent.mm.plugin.webview.model.a tzQ = new com.tencent.mm.plugin.webview.model.a(this.trN);
    private com.tencent.mm.plugin.webview.modeltools.j tzR = new com.tencent.mm.plugin.webview.modeltools.j();
    private WebViewClipBoardHelper tzT;
    private volatile String tzU;
    private volatile long tzV;
    private ag tzW = new ag();
    public o tzX = new o(this) {
        final /* synthetic */ WebViewUI tAv;

        {
            this.tAv = r1;
        }

        public final boolean z(MotionEvent motionEvent) {
            if (this.tAv.ptK == null) {
                return false;
            }
            return this.tAv.ptK.O(motionEvent);
        }

        public final boolean a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            if (this.tAv.ptK == null) {
                return false;
            }
            return this.tAv.ptK.b(i, i2, i3, i4, i5, i6, i7, i8, z);
        }

        public final void ahE() {
            if (this.tAv.ptK != null) {
                this.tAv.ptK.cyX();
            }
        }

        @TargetApi(9)
        public final void b(int i, int i2, boolean z, boolean z2) {
            if (this.tAv.ptK != null) {
                this.tAv.ptK.c(i, i2, z, z2);
                if (z2 && this.tAv.trN != null) {
                    this.tAv.trN.t("mm_scroll_bottom", Boolean.valueOf(true));
                }
            }
        }

        public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
            if (this.tAv.ptK != null) {
                this.tAv.ptK.x(i, i2, i3, i4);
                this.tAv.onWebViewScrollChanged(i, i2, i3, i4);
            }
        }

        public final boolean A(MotionEvent motionEvent) {
            if (this.tAv.ptK == null) {
                return false;
            }
            return this.tAv.ptK.P(motionEvent);
        }

        public final boolean B(MotionEvent motionEvent) {
            if (this.tAv.ptK == null) {
                return false;
            }
            return this.tAv.ptK.Q(motionEvent);
        }
    };
    private com.tencent.mm.sdk.b.c<ow> tzY = new 23(this);
    private boolean tzZ = true;
    protected com.tencent.xweb.j tza;
    private ProgressBar tzb;
    public m tzd = new m(null);
    protected n tze = new n(this);
    protected p tzf = new p(this);
    protected r tzg = new r(this);
    private boolean tzh = false;
    private z<String, Bitmap> tzi = new z(12);
    private HashMap<String, String> tzj = new HashMap();
    private b tzk;
    private int tzl = 0;
    private com.tencent.mm.plugin.webview.ui.tools.jsapi.f tzm;
    protected volatile boolean tzn = false;
    private boolean tzo = false;
    private String tzp = "";
    private HashMap<String, Boolean> tzq = new HashMap();
    private HashMap<String, String> tzr = new HashMap();
    private HashMap<String, ArrayList<com.tencent.mm.k.d.b>> tzs = new HashMap();
    private HashMap<String, Boolean> tzt = new HashMap();
    private HashMap<String, Integer> tzu = new HashMap();
    private d tzv;
    private i tzw = null;
    private View tzx;
    protected View tzy = null;
    private String tzz = null;
    private int width;

    private class f implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        final /* synthetic */ WebViewUI tAv;

        private f(WebViewUI webViewUI) {
            this.tAv = webViewUI;
        }

        public final boolean BT(String str) {
            if (bh.ov(str)) {
                return false;
            }
            return s.eE(str, "weixin://critical_update/");
        }

        public final boolean BU(String str) {
            com.tencent.mm.plugin.report.service.g.pQN.a(405, 25, 1, true);
            WebViewUI.g(this.tAv, 1);
            return true;
        }
    }

    private class j implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        final /* synthetic */ WebViewUI tAv;
        private final String tBx;

        private j(WebViewUI webViewUI) {
            this.tAv = webViewUI;
            this.tBx = "weixin://feedback/";
        }

        public final boolean BT(String str) {
            if (bh.ov(str)) {
                return false;
            }
            return s.eE(str, "weixin://feedback/");
        }

        public final boolean BU(String str) {
            Bundle bundle = new Bundle();
            bundle.putInt(u.FLAG_OVERRIDE_ENTER_ANIMATION, 0);
            bundle.putInt(u.FLAG_OVERRIDE_EXIT_ANIMATION, R.a.bqm);
            try {
                this.tAv.juQ.a(7, bundle, this.tAv.hashCode());
            } catch (Exception e) {
                x.w("MicroMsg.WebViewUI", "FeedbackJumpHandler, ex = " + e.getMessage());
            }
            return true;
        }
    }

    private class l implements com.tencent.mm.plugin.webview.ui.tools.jsapi.b {
        final /* synthetic */ WebViewUI tAv;

        private l(WebViewUI webViewUI) {
            this.tAv = webViewUI;
        }

        public final boolean BT(String str) {
            if (bh.ov(str)) {
                return false;
            }
            return s.eE(str, "weixin://connectToFreeWifi/");
        }

        public final boolean BU(String str) {
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("apKey");
            x.i("MicroMsg.WebViewUI", "apKey value = %s", new Object[]{queryParameter});
            String queryParameter2 = parse.getQueryParameter("ticket");
            if (!bh.ov(queryParameter)) {
                Intent intent = new Intent();
                intent.putExtra("free_wifi_schema_uri", parse.toString());
                intent.putExtra("free_wifi_ap_key", queryParameter);
                intent.putExtra("free_wifi_source", 5);
                if (!bh.ov(queryParameter2)) {
                    intent.putExtra("free_wifi_schema_ticket", queryParameter2);
                }
                intent.addFlags(67108864);
                com.tencent.mm.bm.d.b(ac.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent);
            }
            return true;
        }
    }

    protected class n {
        final /* synthetic */ WebViewUI tAv;
        int tBz = 0;

        protected n(WebViewUI webViewUI) {
            this.tAv = webViewUI;
        }

        public final void bTl() {
            if (this.tBz == 0) {
                this.tAv.AH(233);
            }
            this.tBz++;
        }

        public final void bTm() {
            this.tBz--;
            if (this.tBz <= 0) {
                this.tAv.AI(233);
            }
        }
    }

    protected class h extends com.tencent.xweb.x5.a.a.a.a.b {
        final /* synthetic */ WebViewUI tAv;

        public h(WebViewUI webViewUI) {
            this.tAv = webViewUI;
        }

        public Object onMiscCallBack(String str, Bundle bundle) {
            String str2 = null;
            String str3 = "MicroMsg.WebViewUI";
            String str4 = "method = %s, bundler == null ? %b, invoker == null ? %b";
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(bundle == null);
            objArr[2] = Boolean.valueOf(this.tAv.juQ == null);
            x.i(str3, str4, objArr);
            if (bh.ov(str) || bundle == null || this.tAv.juQ == null) {
                return str2;
            }
            String OR;
            try {
                OR = this.tAv.juQ.OR("WebviewEnableTbsDownload");
            } catch (Exception e) {
                x.e("MicroMsg.WebViewUI", "get dynamic config failed");
                OR = str2;
            }
            x.i("MicroMsg.WebViewUI", "enable value = %s", new Object[]{OR});
            if (bh.ov(OR) || !OR.equals("0")) {
                Bundle e2;
                if (str.equals("addDownloadTask")) {
                    try {
                        e2 = this.tAv.juQ.e(14, bundle);
                        if (e2 != null) {
                            return Long.valueOf(e2.getLong("download_id", 0));
                        }
                    } catch (RemoteException e3) {
                        x.e("MicroMsg.WebViewUI", "invoke the add downloadtask failed");
                    }
                }
                if (str.equals(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.f.NAME)) {
                    try {
                        e2 = this.tAv.juQ.e(16, bundle);
                        if (e2 != null) {
                            return Boolean.valueOf(e2.getBoolean("cancel_result", false));
                        }
                    } catch (RemoteException e4) {
                        x.e("MicroMsg.WebViewUI", "invoke the cancel downloadtask failed");
                    }
                }
                if (str.equals("queryDownloadTask")) {
                    try {
                        e2 = this.tAv.juQ.e(15, bundle);
                        if (e2 != null) {
                            return Integer.valueOf(e2.getInt("download_state", 0));
                        }
                    } catch (RemoteException e5) {
                        x.e("MicroMsg.WebViewUI", "invoke the queryDownloadTask downloadtask failed");
                    }
                }
                if (str.equals("installDownloadTask")) {
                    try {
                        e2 = this.tAv.juQ.e(17, bundle);
                        if (e2 != null) {
                            return Boolean.valueOf(e2.getBoolean("install_result"));
                        }
                    } catch (RemoteException e6) {
                        x.e("MicroMsg.WebViewUI", "invoke the install downloadtask failed");
                    }
                }
                if (str.equals("getDrawable")) {
                    str3 = bundle.getString(DownloadInfoColumns.PACKAGENAME);
                    int i = bundle.getInt("resourceId");
                    if (!bh.ov(str3) && i > 0) {
                        try {
                            return com.tencent.mm.bw.a.b(this.tAv.getPackageManager().getResourcesForApplication(str3), i);
                        } catch (Exception e7) {
                            x.e("MicroMsg.WebViewUI", "get resource for package : %s, fail, : %s", new Object[]{str3, e7.getMessage()});
                        }
                    }
                }
                if (!str.equals("getShareUrl")) {
                    return str2;
                }
                try {
                    x.i("MicroMsg.WebViewUI", "getShareUrl by x5 core, shareurl = %s", new Object[]{this.tAv.juQ.BP(this.tAv.ptK.getUrl())});
                    return this.tAv.juQ.BP(this.tAv.ptK.getUrl());
                } catch (Exception e8) {
                    x.e("MicroMsg.WebViewUI", "getShare url failed");
                    return str2;
                }
            }
            x.e("MicroMsg.WebViewUI", "config closed, not allows tbs download");
            return str2;
        }

        public final boolean onTouchEvent(MotionEvent motionEvent, View view) {
            return this.tAv.tzX.z(motionEvent);
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
            return this.tAv.tzX.B(motionEvent);
        }

        public final boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
            return this.tAv.tzX.A(motionEvent);
        }

        public final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
            return this.tAv.tzX.a(i, i2, i3, i4, i5, i6, i7, i8, z);
        }

        public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
            this.tAv.tzX.onScrollChanged(i, i2, i3, i4, view);
        }

        public final void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
            this.tAv.tzX.b(i, i2, z, z2);
        }

        public final void computeScroll(View view) {
            this.tAv.tzX.ahE();
        }

        public final boolean onShowLongClickPopupMenu() {
            if (this.tAv.getIntent().getBooleanExtra("show_long_click_popup_menu", true)) {
                return false;
            }
            return true;
        }
    }

    static /* synthetic */ void R(WebViewUI webViewUI) {
        webViewUI.bSZ();
        if (!webViewUI.aPo()) {
            webViewUI.tzO = true;
            g.tyi.close();
            webViewUI.finish();
        }
    }

    static /* synthetic */ void S(WebViewUI webViewUI) {
        View view = webViewUI.ptK.getView();
        view.scrollTo(view.getScrollX(), 0);
        aj.g bRd = webViewUI.trN.bRd();
        bRd.tsX = new Object[]{webViewUI.fIG, Integer.valueOf(7)};
        bRd.c(webViewUI.juQ);
    }

    static /* synthetic */ void Z(WebViewUI webViewUI) {
        CharSequence url = webViewUI.ptK.getUrl();
        if (url == null || url.length() == 0) {
            x.e("MicroMsg.WebViewUI", "copyLink fail, url is null");
            return;
        }
        CharSequence BP;
        try {
            BP = webViewUI.juQ.BP(url);
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "copy link failed");
            BP = url;
        }
        ClipboardManager clipboardManager = (ClipboardManager) webViewUI.getSystemService("clipboard");
        if (clipboardManager != null) {
            try {
                clipboardManager.setText(BP);
                Toast.makeText(webViewUI, webViewUI.getString(R.l.eXW), 0).show();
                return;
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.WebViewUI", e2, "clip.setText error", new Object[0]);
                return;
            }
        }
        x.e("MicroMsg.WebViewUI", "clipboard manager is null");
    }

    static /* synthetic */ void a(WebViewUI webViewUI, MenuItem menuItem) {
        if (menuItem instanceof com.tencent.mm.ui.base.o) {
            String str = ((com.tencent.mm.ui.base.o) menuItem).jeE;
            if (!bh.ov(str) && !str.equals(webViewUI.ptK.getUrl())) {
                webViewUI.ptK.loadUrl(str);
            }
        }
    }

    static /* synthetic */ void a(WebViewUI webViewUI, WebViewKeyboardLinearLayout webViewKeyboardLinearLayout, int i) {
        if (!webViewUI.tyT) {
            return;
        }
        if (webViewUI.ptK.getX5WebViewExtension() == null && VERSION.SDK_INT < 19) {
            return;
        }
        if (i == -3) {
            webViewUI.handler.post(new 44(webViewUI, webViewKeyboardLinearLayout.txF));
            return;
        }
        webViewUI.handler.post(new Runnable(webViewUI) {
            final /* synthetic */ WebViewUI tAv;

            {
                this.tAv = r1;
            }

            public final void run() {
                if (this.tAv.tlx != null) {
                    this.tAv.tlx.AZ(0);
                }
            }
        });
    }

    static /* synthetic */ void a(WebViewUI webViewUI, String str, long j) {
        Intent intent = new Intent(webViewUI, WebViewDownloadWithX5UI.class);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.putExtra("task_url", str);
        intent.putExtra("page_url", webViewUI.aPk());
        intent.putExtra("task_size", j);
        if (WebView.getTbsCoreVersion(webViewUI) < 43305) {
            webViewUI.startActivity(intent);
        } else {
            QbSdk.fileInfoDetect(webViewUI, str, new 22(webViewUI, intent));
        }
    }

    static /* synthetic */ void a(WebViewUI webViewUI, String str, String str2, int i, int i2) {
        if (webViewUI.juR == null) {
            x.e("MicroMsg.WebViewUI", "startGetReadingModeInfo fail, after onDestroy");
            return;
        }
        p pVar = webViewUI.tzf;
        if (pVar.tBA == 0) {
            pVar.tAv.AH(673);
        }
        pVar.tBA++;
        webViewUI.tzp = str;
        webViewUI.tzo = true;
        Bundle bundle = new Bundle();
        bundle.putString("reading_mode_data_url", str);
        bundle.putString("reading_mode_data_useragent", str2);
        bundle.putInt("reading_mode_data_width", i);
        bundle.putInt("reading_mode_data_height", i2);
        bundle.putInt("webview_binder_id", webViewUI.hashCode());
        boolean z = false;
        try {
            z = webViewUI.juQ.r(673, bundle);
        } catch (Exception e) {
            x.w("MicroMsg.WebViewUI", "startGetReadingModeInfo, ex = " + e.getMessage());
        }
        x.d("MicroMsg.WebViewUI", "startGetReadingModeInfo, doScene ret = " + z);
    }

    static /* synthetic */ void aa(WebViewUI webViewUI) {
        com.tencent.mm.plugin.webview.stub.d dVar = webViewUI.juQ;
        if (webViewUI != null && !webViewUI.isFinishing()) {
            String aPk = webViewUI.aPk();
            if (bh.ov(aPk)) {
                x.e("MicroMsg.BrowserChooserHelper", "open in browser fail, url is null");
                return;
            }
            if (dVar != null) {
                try {
                    aPk = dVar.BP(aPk);
                } catch (Exception e) {
                    x.e("MicroMsg.BrowserChooserHelper", "showAndOpenInBrowser, getShareUrl, exception = %s", new Object[]{e});
                }
            }
            if (!(aPk.startsWith("http://") || aPk.startsWith("https://"))) {
                aPk = "http://" + aPk;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(aPk));
            try {
                if (bh.PT()) {
                    webViewUI.startActivity(intent);
                } else {
                    webViewUI.startActivityForResult(com.tencent.mm.plugin.webview.modeltools.a.a(webViewUI, intent, aPk), 2);
                }
            } catch (Exception e2) {
                x.e("MicroMsg.BrowserChooserHelper", "open in browser failed : %s", new Object[]{e2.getMessage()});
            }
        }
    }

    static /* synthetic */ void ab(WebViewUI webViewUI) {
        webViewUI.tlx.aQ("sendEmail", true);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.tlx;
        if (dVar.tGQ) {
            dVar.tGK.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:share:email", new HashMap(), dVar.tGS, dVar.tGT) + ")", null);
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSendMail fail, not ready");
    }

    static /* synthetic */ void ah(WebViewUI webViewUI) {
        webViewUI.tlx.aQ(GameJsApiSendAppMessage.NAME, true);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.tlx;
        if (dVar.tGQ) {
            dVar.tGK.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:share:appmessage", new HashMap(), dVar.tGS, dVar.tGT) + ")", null);
            try {
                dVar.juQ.E("scene", "wework", dVar.tvn);
                return;
            } catch (Exception e) {
                x.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                return;
            }
        }
        x.e("MicroMsg.JsApiHandler", "onShareWeWork fail, not ready");
    }

    static /* synthetic */ void ai(WebViewUI webViewUI) {
        String str = null;
        try {
            str = webViewUI.juQ.BP(webViewUI.ptK.getUrl());
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "getShareUrl failed : %s", new Object[]{e.getMessage()});
        }
        if (bh.ov(str)) {
            str = webViewUI.fIG;
        }
        try {
            str = "weread://mp?url=" + p.encode(str, ProtocolPackage.ServerEncoding);
        } catch (Exception e2) {
            x.e("MicroMsg.WebViewUI", "encode url failed ; %s", new Object[]{e2.getMessage()});
        }
        x.i("MicroMsg.WebViewUI", "now url = %s", new Object[]{str});
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        if (bh.k(webViewUI.mController.xIM, intent)) {
            webViewUI.startActivity(intent);
        } else {
            x.e("MicroMsg.WebViewUI", "not availble app match this intent");
        }
    }

    static /* synthetic */ void aj(WebViewUI webViewUI) {
        webViewUI.tlx.aQ("shareQQ", true);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.tlx;
        if (dVar.tGQ) {
            dVar.tGK.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:share:qq", new HashMap(), dVar.tGS, dVar.tGT) + ")", null);
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onShareQQ fail, not ready");
    }

    static /* synthetic */ void ak(WebViewUI webViewUI) {
        webViewUI.tlx.aQ("shareWeiboApp", true);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.tlx;
        if (dVar.tGQ) {
            dVar.tGK.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:share:weiboApp", new HashMap(), dVar.tGS, dVar.tGT) + ")", null);
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onShareWeiboApp fail, not ready");
    }

    static /* synthetic */ void al(WebViewUI webViewUI) {
        webViewUI.tlx.aQ("shareQZone", true);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.tlx;
        if (dVar.tGQ) {
            dVar.tGK.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:share:QZone", new HashMap(), dVar.tGS, dVar.tGT) + ")", null);
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onShareQzone fail, not ready");
    }

    static /* synthetic */ void am(WebViewUI webViewUI) {
        webViewUI.tlx.aQ(GameJsApiSendAppMessage.NAME, true);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.tlx;
        if (dVar.tGQ) {
            dVar.tGK.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:share:appmessage", new HashMap(), dVar.tGS, dVar.tGT) + ")", null);
            try {
                dVar.juQ.E("scene", "facebook", dVar.tvn);
                return;
            } catch (Exception e) {
                x.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                return;
            }
        }
        x.e("MicroMsg.JsApiHandler", "onShareFaceBook fail, not ready");
    }

    static /* synthetic */ void an(WebViewUI webViewUI) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("enterprise_action", "enterprise_connectors");
            final Object stringArrayList = webViewUI.juQ.e(71, bundle).getStringArrayList("enterprise_connectors");
            if (stringArrayList != null && stringArrayList.size() > 0) {
                if (stringArrayList.size() == 1) {
                    webViewUI.Pm((String) stringArrayList.get(0));
                    return;
                }
                webViewUI.cq(stringArrayList);
                com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(webViewUI.mController.xIM);
                lVar.a(webViewUI.ptK, webViewUI, null);
                lVar.zlt = new com.tencent.mm.ui.base.p.a(webViewUI) {
                    final /* synthetic */ WebViewUI tAv;

                    {
                        this.tAv = r1;
                    }

                    public final void a(ImageView imageView, MenuItem menuItem) {
                        if (WebViewUI.i(menuItem)) {
                            imageView.setVisibility(8);
                            return;
                        }
                        String str = menuItem.getTitle();
                        if (this.tAv.tzi.get(str) == null || ((Bitmap) this.tAv.tzi.get(str)).isRecycled()) {
                            x.w("MicroMsg.WebViewUI", "on attach icon, load from cache fail");
                            try {
                                String OM = this.tAv.juQ.OM(str);
                                if (!bh.ov(OM)) {
                                    Bitmap Pd = d.Pd(OM);
                                    if (Pd != null && !Pd.isRecycled()) {
                                        imageView.setImageBitmap(Pd);
                                        this.tAv.tzi.put(str, Pd);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            } catch (Exception e) {
                                x.w("MicroMsg.WebViewUI", "getheadimg, ex = " + e.getMessage());
                                return;
                            }
                        }
                        imageView.setImageBitmap((Bitmap) this.tAv.tzi.get(str));
                    }
                };
                lVar.zlu = new 50(webViewUI);
                lVar.b(webViewUI.ptK, new OnCreateContextMenuListener(webViewUI) {
                    final /* synthetic */ WebViewUI tAv;

                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        Iterator it = stringArrayList.iterator();
                        while (it.hasNext()) {
                            contextMenu.add((String) it.next());
                        }
                    }
                }, new 52(webViewUI));
                lVar.bBX();
            }
        } catch (Exception e) {
            x.w("MicroMsg.WebViewUI", "builder add, ex = " + e.getMessage());
        }
    }

    static /* synthetic */ void ao(WebViewUI webViewUI) {
        x.i("MicroMsg.WebViewUI", "JumpToReadArticle");
        if (webViewUI.tlx != null) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.tlx;
            if (dVar.tGQ) {
                x.i("MicroMsg.JsApiHandler", "onArticleReadBtnClicked");
                com.tencent.mm.sdk.platformtools.ag.y(new 18(dVar, com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onArticleReadingBtnClicked", new HashMap(), dVar.tGS, dVar.tGT)));
                return;
            }
            x.e("MicroMsg.JsApiHandler", "onArticleReadBtnClicked fail, not ready");
        }
    }

    static /* synthetic */ void b(WebViewUI webViewUI, int i) {
        if (webViewUI.tyz != null && com.tencent.mm.compatible.util.d.fM(21)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) webViewUI.tyz.getLayoutParams();
            if (marginLayoutParams.bottomMargin != i) {
                marginLayoutParams.bottomMargin = i;
                webViewUI.tyz.setLayoutParams(marginLayoutParams);
            }
        }
    }

    static /* synthetic */ void c(WebViewUI webViewUI, int i) {
        if (webViewUI.tyA != null && com.tencent.mm.compatible.util.d.fM(21)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) webViewUI.tyA.getLayoutParams();
            if (marginLayoutParams.bottomMargin != i) {
                marginLayoutParams.bottomMargin = i;
                webViewUI.tyA.setLayoutParams(marginLayoutParams);
            }
            if (webViewUI.ptK.isX5Kernel) {
                i = webViewUI.tyA.getVisibility() == 0 ? webViewUI.tyA.getHeight() + i : 0;
            } else if (webViewUI.tyA.getVisibility() == 0) {
                i += webViewUI.tyA.getHeight();
            }
            webViewUI.ptK.setPadding(webViewUI.ptK.getPaddingLeft(), webViewUI.ptK.getPaddingTop(), webViewUI.ptK.getPaddingRight(), i);
        }
    }

    static /* synthetic */ void c(WebViewUI webViewUI, String str) {
        if (webViewUI.juQ != null) {
            Bundle bundle = new Bundle(1);
            bundle.putString("show_kb_input_callback_text", bh.ou(str));
            try {
                webViewUI.juQ.a(41, bundle, webViewUI.hashCode());
            } catch (Exception e) {
                x.i("MicroMsg.WebViewUI", "showKbInputCallback, exception = %s, text = %s", new Object[]{e, str});
            }
        }
        if (webViewUI.tyz != null) {
            webViewUI.tyz.hide();
        }
    }

    static /* synthetic */ void e(WebViewUI webViewUI, String str) {
        try {
            webViewUI.juQ.OU(str);
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "sendImgToFriend fail, ex = " + e.getMessage());
        }
    }

    static /* synthetic */ void f(WebViewUI webViewUI, String str) {
        try {
            com.tencent.mm.pluginsdk.model.c.a(webViewUI.juQ.OT(str), 34, (Activity) webViewUI, webViewUI.nah);
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "favoriteUrl fail, ex = " + e.getMessage());
        }
    }

    static /* synthetic */ void g(WebViewUI webViewUI, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("update_type_key", i);
        try {
            webViewUI.juQ.a(1, bundle, webViewUI.hashCode());
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "doUpdate fail, ex = " + e.getMessage());
        }
    }

    static /* synthetic */ void h(WebViewUI webViewUI, String str) {
        if (webViewUI.tlx != null) {
            Bundle bundle = new Bundle();
            bundle.putInt(str, 43);
            com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.tlx;
            try {
                dVar.juQ.a(21, bundle, dVar.tvn);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
                x.w("MicroMsg.JsApiHandler", "updateJsapiArgsBundleKV, ex = " + e);
            }
        }
    }

    static /* synthetic */ void i(WebViewUI webViewUI, String str) {
        webViewUI.tlx.aQ("profile", true);
        webViewUI.tlx.PC(str);
    }

    static /* synthetic */ boolean i(MenuItem menuItem) {
        return menuItem.getItemId() >= 10000;
    }

    static /* synthetic */ void j(WebViewUI webViewUI, String str) {
        if (!(bh.ov(str) || str.equals(webViewUI.ptK.getUrl()))) {
            webViewUI.ptK.loadUrl(str);
        }
        webViewUI.tzo = false;
    }

    static /* synthetic */ void l(WebViewUI webViewUI, String str) {
        webViewUI.tlx.aQ(GameJsApiSendAppMessage.NAME, false);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = webViewUI.tlx;
        if (dVar.tGQ) {
            Map hashMap = new HashMap();
            hashMap.put("scene", "connector");
            dVar.tGK.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:share:appmessage", hashMap, dVar.tGS, dVar.tGT) + ")", null);
            try {
                dVar.juQ.E("connector_local_send", str, dVar.tvn);
                dVar.juQ.E("scene", "connector", dVar.tvn);
                return;
            } catch (Exception e) {
                x.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                return;
            }
        }
        x.e("MicroMsg.JsApiHandler", "onSendToConnector fail, not ready");
    }

    static /* synthetic */ void p(WebViewUI webViewUI) {
        webViewUI.tAe.txQ = new 3(webViewUI);
        f fVar = webViewUI.tAe;
        fVar.iMZ = true;
        if (fVar.txS != null) {
            fVar.txS.setVisibility(0);
            fVar.txS.twm = fVar;
            fVar.txS.twj = true;
            fVar.txS.kr(false);
            fVar.txS.twk = fVar.txT;
        }
        if (fVar.txR != null) {
            fVar.txR.setWillNotDraw(true);
            fVar.txR.setImageResource(f.txU);
            fVar.txR.setVisibility(0);
            fVar.txR.setAlpha(0.0f);
            fVar.txR.setWillNotDraw(false);
            fVar.txR.invalidate();
        }
        if (fVar.tyd != null) {
            fVar.tyd.setVisibility(8);
        }
    }

    static /* synthetic */ void q(WebViewUI webViewUI) {
        if (webViewUI.ptK != null) {
            webViewUI.ptK.evaluateJavascript("javascript:(function(){return window.getComputedStyle(document.body,null).backgroundColor})()", new 4(webViewUI));
        }
    }

    static /* synthetic */ void q(WebViewUI webViewUI, String str) {
        SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) webViewUI.tAi.get(str);
        if (sparseBooleanArray == null) {
            sparseBooleanArray = new SparseBooleanArray();
            webViewUI.tAi.put(str, sparseBooleanArray);
        }
        if (sparseBooleanArray != null) {
            sparseBooleanArray.put(34, true);
        }
    }

    static {
        Set hashSet = new HashSet();
        tsq = hashSet;
        hashSet.add("file:///android_asset/");
        String str = com.tencent.mm.compatible.util.e.gZL;
        if (!bh.ov(str)) {
            str = com.tencent.mm.compatible.util.e.gZL.replace("/data/user/0", "/data/data");
        }
        tsq.add("file://" + new File(com.tencent.mm.plugin.aj.a.g.zR(0)).getAbsolutePath());
        tsq.add("file://" + new File(com.tencent.mm.compatible.util.e.bnF, "fts/res").getAbsolutePath());
        tsq.add("file://" + new File(str, "wenote/res").getAbsolutePath());
        tsq.add("file://" + new File(com.tencent.mm.compatible.util.e.bnF, "wenote/res").getAbsolutePath());
        tsq.add("file://" + new File(str, "wxa_fts/res").getAbsolutePath());
        x.i("MicroMsg.WebViewUI", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s, wxapp : %s", new Object[]{r1.getAbsolutePath(), r2.getAbsolutePath(), r3.getAbsolutePath()});
        tsq.add("file://" + new File(str, "emoji/res").getAbsolutePath());
        tsq.add("file://" + new File(com.tencent.mm.compatible.util.e.bnF, "emoji/res").getAbsolutePath());
        x.i("MicroMsg.WebViewUI", "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[]{r1.getAbsolutePath(), r0.getAbsolutePath()});
        tsq.add("file://" + new File(com.tencent.mm.plugin.aj.a.g.zR(1)).getAbsolutePath());
        tsq.add("file://" + new File(com.tencent.mm.compatible.util.e.bnF, "fts_browse/res").getAbsolutePath());
        x.i("MicroMsg.WebViewUI", "add browse UI FILE URL WHITE LIST data: %s sdcard:%s", new Object[]{r0.getAbsolutePath(), r1.getAbsolutePath()});
        Iterator it = tsq.iterator();
        while (it.hasNext()) {
            x.i("MicroMsg.WebViewUI", "albie: WebViewUI white list path : %s", new Object[]{(String) it.next()});
        }
    }

    public void T(Bundle bundle) {
    }

    public void U(Bundle bundle) {
        int color;
        int i;
        boolean z = bundle.getBoolean("set_navigation_bar_color_reset", false);
        if (z) {
            color = getResources().getColor(R.e.bre);
            i = 255;
        } else {
            color = bundle.getInt("set_navigation_bar_color_color");
            i = bundle.getInt("set_navigation_bar_color_alpha");
        }
        Drawable colorDrawable = new ColorDrawable(color);
        colorDrawable.setAlpha(i);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(colorDrawable);
        }
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(R.h.divider);
            if (findViewById != null && !z) {
                x.i("MicroMsg.WebViewUI", "setNavigationBar set divider half_alpha_white color");
                findViewById.setBackgroundColor(getResources().getColor(R.e.bsL));
            } else if (findViewById != null && z) {
                x.i("MicroMsg.WebViewUI", "setNavigationBar set divider actionbar_devider_color color");
                findViewById.setBackgroundColor(getResources().getColor(R.e.brh));
            }
            customView.setBackgroundDrawable(colorDrawable);
            customView.invalidate();
            if (color == getResources().getColor(R.e.bre)) {
                color = getResources().getColor(R.e.btS);
            } else {
                color = d.j(color, 0.8f);
            }
            setStatusBarColor(color);
            return;
        }
        x.e("MicroMsg.WebViewUI", "setNavigationBar view is null");
    }

    private void BM(String str) {
        if (this.ptK != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.ptK, new Object[0]);
            } catch (NoSuchMethodException e) {
                x.e("MicroMsg.WebViewUI", "No such method: " + str + ", " + e.toString());
            } catch (IllegalAccessException e2) {
                x.e("MicroMsg.WebViewUI", "Illegal Access: " + str + ", " + e2.toString());
            } catch (InvocationTargetException e3) {
                x.e("MicroMsg.WebViewUI", "Invocation Target Exception: " + str + ", " + e3.toString());
            } catch (Exception e4) {
                x.e("MicroMsg.WebViewUI", "Exception : " + str + ", " + e4.toString());
            }
        }
    }

    private void ks(boolean z) {
        if (!z) {
            this.tyX = true;
        }
    }

    public void onResume() {
        super.onResume();
        this.trN.bRa().ttl = bh.Wq();
        g gVar = g.tyi;
        x.v("MicroMsg.WebViewReportUtil", "onResume traceid %s", new Object[]{gVar.rea});
        if (!bh.ov(gVar.rea)) {
            gVar.pY(7);
        }
        if (!this.tzZ) {
            int hashCode = hashCode();
            for (int size = tyW.size() - 1; size >= 0; size--) {
                if (((ab) tyW.get(size)).id == hashCode) {
                    tyW.remove(size);
                    break;
                }
            }
            tyW.add(new ab(this));
        }
        this.tzZ = false;
        if (this.tyX) {
            ks(true);
            this.tyX = false;
        }
        bSI();
        if (this.juQ != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("screen_orientation", this.screenOrientation);
                this.juQ.e(83, bundle);
            } catch (Exception e) {
                x.e("MicroMsg.WebViewUI", "ac_set_screen_orientation : " + e.getMessage());
            }
        }
        if (getIntent().getBooleanExtra("disable_swipe_back", false) && getSwipeBackLayout() != null) {
            getSwipeBackLayout().mEnable = false;
        }
        BM("onResume");
        BL("onResume");
        try {
            if (this.juQ != null) {
                bundle = this.juQ.e(19, null);
                if (bundle != null) {
                    x.i("MicroMsg.WebViewUI", "onResume, has init = %b", new Object[]{Boolean.valueOf(bundle.getBoolean("webview_video_proxy_init"))});
                    if (bundle.getBoolean("webview_video_proxy_init")) {
                        FactoryProxyManager.getPlayManager().appToFront();
                    }
                }
            }
        } catch (Exception e2) {
            x.e("MicroMsg.WebViewUI", "notify app tofront failed : %s", new Object[]{e2.getMessage()});
        }
        this.kCY = bh.Wo();
        com.tencent.mm.modelstat.d.b(3, "WebViewUI_" + Pp(bh.ou(this.tzz)), hashCode());
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.modelstat.d.b(4, "WebViewUI_" + Pp(bh.ou(this.tzz)), hashCode());
        com.tencent.mm.modelstat.d.f("WebViewUI_" + Pp(bh.ou(this.tzz)), this.kCY, bh.Wo());
        com.tencent.mm.plugin.webview.model.aj.j bRa = this.trN.bRa();
        if (bRa.ttl != -1) {
            bRa.jIb += bh.bA(bRa.ttl) / 1000;
        }
        g gVar = g.tyi;
        x.v("MicroMsg.WebViewReportUtil", "onPause traceid %s", new Object[]{gVar.rea});
        if (gVar.hik) {
            x.i("MicroMsg.WebViewReportUtil", "isFinish is true");
        } else if (!bh.ov(gVar.rea)) {
            gVar.pY(6);
        }
        try {
            if (this.juQ != null) {
                Bundle e = this.juQ.e(19, null);
                if (e != null) {
                    x.i("MicroMsg.WebViewUI", "onPause, has init = %b", new Object[]{Boolean.valueOf(e.getBoolean("webview_video_proxy_init"))});
                    if (e.getBoolean("webview_video_proxy_init")) {
                        FactoryProxyManager.getPlayManager().appToBack();
                    }
                }
            }
        } catch (Exception e2) {
            x.e("MicroMsg.WebViewUI", "notify app toback failed : %s", new Object[]{e2.getMessage()});
        }
        bSS();
        BM("onPause");
        BL("onPause");
        if (this.tza != null) {
            x.i("MicroMsg.WebViewUI", "onPause, now try to hide customview");
            try {
                this.tza.onHideCustomView();
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.WebViewUI", e3, "onPause", new Object[0]);
            }
        }
    }

    public void finish() {
        if (this.tyI) {
            setResult(-1);
        }
        try {
            if (this.juQ != null) {
                this.juQ.Au(hashCode());
                this.juQ.Aq(hashCode());
            }
            x.w("MicroMsg.WebViewUI", "invoke onWebViewUIDestroy");
        } catch (Exception e) {
            x.w("MicroMsg.WebViewUI", "onDestroy, remove callback and invoke event on webview destroy, ex = " + e);
        }
        this.tzP = true;
        super.finish();
    }

    public int getLayoutId() {
        return R.i.cYG;
    }

    protected boolean convertActivityFromTranslucent() {
        return getIntent().getBooleanExtra("convertActivityFromTranslucent", true);
    }

    public void setMMTitle(String str) {
        super.setMMTitle(str);
        nR(bSC());
    }

    private void BL(String str) {
        if (this.tlx != null) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.tlx;
            if (dVar.tGQ) {
                x.i("MicroMsg.JsApiHandler", "onActivityStateChanged, state = " + str);
                Map hashMap = new HashMap();
                hashMap.put("state", str);
                String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("activity:state_change", hashMap, dVar.tGS, dVar.tGT);
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    try {
                        dVar.tGK.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        x.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", new Object[]{e.getMessage()});
                    }
                } else {
                    com.tencent.mm.sdk.platformtools.ag.y(new 7(dVar, a));
                }
            } else {
                x.e("MicroMsg.JsApiHandler", "onActivityStateChanged fail, not ready");
            }
            try {
                if (str.equals("onPause")) {
                    this.juQ.Aw(hashCode());
                } else if (str.equals("onResume")) {
                    this.juQ.Av(hashCode());
                }
            } catch (Exception e2) {
                x.w("MicroMsg.WebViewUI", "onResume, ex = " + e2.getMessage());
            }
        }
    }

    public boolean bSj() {
        return false;
    }

    private void bSx() {
        x.i("MicroMsg.WebViewUI", "edw tryBindService");
        bindService(new Intent(this, WebViewStubService.class), this.lrm, 1);
    }

    protected final void onCreateBeforeSetContentView() {
        supportRequestWindowFeature(5);
        supportRequestWindowFeature(9);
        setProgressBarIndeterminateVisibility(false);
    }

    @TargetApi(11)
    public void onCreate(Bundle bundle) {
        String str;
        boolean z;
        super.onCreate(bundle);
        x.i("MicroMsg.WebViewUI", "onCreate" + hashCode());
        this.tyP = getIntent().getIntExtra("geta8key_session_id", (int) System.currentTimeMillis());
        this.tyR = getIntent().getByteArrayExtra("geta8key_cookie");
        this.tyD = bSL();
        this.screenOrientation = getIntent().getIntExtra("screen_orientation", -1);
        this.tyN = getIntent().getBooleanExtra("from_shortcut", false);
        this.nmr = getIntent().getStringExtra("status_bar_style");
        this.nmq = getIntent().getIntExtra("customize_status_bar_color", 0);
        if (getIntent() == null) {
            str = "";
        } else {
            str = getIntent().getStringExtra("custom_action_bar_color");
        }
        if (!bh.ov(str)) {
            Integer valueOf;
            try {
                valueOf = Integer.valueOf(Color.parseColor(str));
            } catch (Exception e) {
                valueOf = null;
            }
            if (valueOf != null) {
                Bundle bundle2 = new Bundle(1);
                bundle2.putInt("set_navigation_bar_color_color", valueOf.intValue());
                bundle2.putInt("set_navigation_bar_color_alpha", 255);
                U(bundle2);
                if (!getIntent().hasExtra("customize_status_bar_color")) {
                    this.nmq = valueOf.intValue();
                }
            }
        }
        this.fIG = bSL();
        this.tzE = getIntent().getBooleanExtra("show_native_web_view", false);
        this.tyC = getIntent().getBooleanExtra("key_trust_url", false);
        x.i("MicroMsg.WebViewUI", "albie: trustUrl : %b.", new Object[]{Boolean.valueOf(this.tyC)});
        tzN++;
        tyW.add(new ab(this));
        if (tyW.size() > 1) {
            ab abVar = (ab) tyW.get(tyW.size() - 2);
            if (!(abVar.rTl == null || abVar.rTl.get() == null)) {
                ((WebViewUI) abVar.rTl.get()).ks(false);
            }
        }
        x.i("MicroMsg.WebViewUI", "initView , rawUrl = %s ", new Object[]{this.fIG});
        this.fGF = bh.ou(getIntent().getStringExtra("KPublisherId"));
        this.fMy = Pp(getIntent().getStringExtra("geta8key_username"));
        m bQW = this.trN.bQW();
        int i = this.fMy;
        String str2 = this.fGF;
        bQW.fMy = i;
        bQW.ttb = str2;
        this.handler = new af();
        if (this.trN != null) {
            aj ajVar = this.trN;
            bundle2 = getIntent().getBundleExtra("mm_report_bundle");
            if (bundle2 != null) {
                if (ajVar.tsR != null) {
                    ajVar.tsR.msB = null;
                }
                ajVar.tsR = new aj$a(ajVar, bundle2);
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        this.tyE = z;
        if (VERSION.SDK_INT >= 11) {
            getWindow().setFlags(16777216, 16777216);
        }
        getWindow().setFormat(-3);
        this.naf.clear();
        this.naf.put("menuItem:share:brand", Integer.valueOf(0));
        this.naf.put("menuItem:share:appMessage", Integer.valueOf(1));
        this.naf.put("menuItem:share:dataMessage", Integer.valueOf(23));
        this.naf.put("menuItem:share:timeline", Integer.valueOf(2));
        this.naf.put("menuItem:favorite", Integer.valueOf(3));
        this.naf.put("menuItem:profile", Integer.valueOf(5));
        this.naf.put("menuItem:addContact", Integer.valueOf(5));
        this.naf.put("menuItem:copyUrl", Integer.valueOf(6));
        this.naf.put("menuItem:openWithSafari", Integer.valueOf(7));
        this.naf.put("menuItem:share:email", Integer.valueOf(8));
        this.naf.put("menuItem:delete", Integer.valueOf(9));
        this.naf.put("menuItem:exposeArticle", Integer.valueOf(10));
        this.naf.put("menuItem:setFont", Integer.valueOf(11));
        this.naf.put("menuItem:editTag", Integer.valueOf(12));
        this.naf.put("menuItem:readMode", Integer.valueOf(14));
        this.naf.put("menuItem:originPage", Integer.valueOf(14));
        this.naf.put("menuItem:share:qq", Integer.valueOf(20));
        this.naf.put("menuItem:share:weiboApp", Integer.valueOf(21));
        this.naf.put("menuItem:share:QZone", Integer.valueOf(22));
        this.naf.put("menuItem:share:Facebook", Integer.valueOf(33));
        this.naf.put("menuItem:share:enterprise", Integer.valueOf(24));
        this.naf.put("menuItem:refresh", Integer.valueOf(28));
        this.naf.put("menuItem:share:wework", Integer.valueOf(25));
        this.naf.put("menuItem:share:weread", Integer.valueOf(26));
        this.naf.put("menuItem:keepTop", Integer.valueOf(30));
        this.naf.put("menuItem:cancelKeepTop", Integer.valueOf(32));
        this.naf.put("menuItem:addShortcut", Integer.valueOf(29));
        this.naf.put("menuItem:search", Integer.valueOf(31));
        this.naf.put("menuItem:readArticle", Integer.valueOf(34));
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.pluginsdk.model.x.a.ef(this);
        x.d("MicroMsg.WebViewUI", "initWebView, check Tbs time consumed = %d(ms)", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        boolean booleanExtra = getIntent().getBooleanExtra("usePlugin", true);
        boolean booleanExtra2 = getIntent().getBooleanExtra("zoom", true);
        boolean booleanExtra3 = getIntent().getBooleanExtra("useJs", true);
        this.ptK = bSE();
        this.ptK.zvI = this;
        if (!(this.ptK == null || this.ptK.isX5Kernel || com.tencent.mm.compatible.util.d.fM(19))) {
            try {
                x.d("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new Object[]{new com.tencent.mm.compatible.loader.c(this.ptK, "mSysWebView", null).get()});
                x.d("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new Object[]{new com.tencent.mm.compatible.loader.c(r0, "mProvider", null).get()});
                x.d("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new Object[]{new com.tencent.mm.compatible.loader.c(r0, "mWebViewCore", null).get()});
                x.d("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new Object[]{new com.tencent.mm.compatible.loader.c(r0, "sWebCoreHandler", null).get()});
                x.d("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new Object[]{new com.tencent.mm.compatible.loader.c(r0, "mLooper", null).get()});
                Object obj = new com.tencent.mm.compatible.loader.c(obj, "mThread", null).get();
                x.d("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, mThread = %s", new Object[]{obj});
                if (obj instanceof Thread) {
                    Thread thread = (Thread) obj;
                    x.i("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", new Object[]{thread.getState()});
                    if (thread.getState() == State.WAITING) {
                        thread.interrupt();
                    }
                }
            } catch (Exception e2) {
                x.e("MicroMsg.WebViewUI", "tryInterruptAwaitingWebCoreThread, exception = %s", new Object[]{e2});
            }
        }
        this.ptK.getSettings().setJavaScriptEnabled(booleanExtra3);
        this.ptK.getSettings().setPluginsEnabled(booleanExtra);
        this.ptK.getSettings().cIw();
        this.ptK.getSettings().setBuiltInZoomControls(booleanExtra2);
        this.ptK.getSettings().setUseWideViewPort(true);
        this.ptK.getSettings().setLoadWithOverviewMode(true);
        this.ptK.getSettings().cIr();
        this.ptK.getSettings().cIq();
        this.ptK.getSettings().setGeolocationEnabled(true);
        this.ptK.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.ptK.getSettings().cIy();
        this.ptK.getSettings().cIu();
        this.ptK.getSettings().setAppCachePath(getDir("webviewcache", 0).getAbsolutePath());
        this.ptK.getSettings().cIt();
        this.ptK.getSettings().cIv();
        this.ptK.getSettings().setDatabasePath(com.tencent.mm.compatible.util.e.gZJ + "databases/");
        b.cIj().cIk();
        b.cIj().b(this.ptK);
        WindowManager windowManager = (WindowManager) getApplicationContext().getSystemService("window");
        try {
            Field declaredField = WebView.class.getDeclaredField("mWebViewCore").getType().getDeclaredField("mBrowserFrame").getType().getDeclaredField("sConfigCallback");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(null);
            if (obj2 != null) {
                declaredField = declaredField.getType().getDeclaredField("mWindowManager");
                declaredField.setAccessible(true);
                declaredField.set(obj2, windowManager);
            }
        } catch (Exception e3) {
        }
        bSx();
        this.juR = new e(this, this.ptK);
        initView();
        BL("onCreate");
        this.jFe = this.ptK.getSettings().getUserAgentString();
        this.fromScene = getIntent().getIntExtra("from_scence", 0);
        x.d("MicroMsg.WebViewUI", " onCreate fromScene %d", new Object[]{Integer.valueOf(this.fromScene)});
        this.fqu = com.tencent.mm.z.u.hz(bh.ou(hashCode()));
        x.i("MicroMsg.WebViewUI", " onCreate sessionId %s", new Object[]{this.fqu});
        if (an.isConnected(this)) {
            if (an.isWifi(this)) {
                this.networkType = 1;
            } else if (an.is4G(this)) {
                this.networkType = 4;
            } else if (an.is3G(this)) {
                this.networkType = 3;
            } else if (an.is2G(this)) {
                this.networkType = 2;
            }
            x.i("MicroMsg.WebViewUI", "get networkType %d", new Object[]{Integer.valueOf(this.networkType)});
        }
        this.width = getResources().getDisplayMetrics().widthPixels;
        this.height = getResources().getDisplayMetrics().heightPixels;
        com.tencent.mm.plugin.webview.model.aj.f bRb = this.trN.bRb();
        int i2 = this.fMy;
        String str3 = this.fGF;
        bRb.fMy = i2;
        bRb.ttb = str3;
        bRb.url = this.fIG;
        aj.c bRh = this.trN.bRh();
        x.i("MicroMsg.WebviewReporter.DomainReporter", "setRawUrl, value = %s", new Object[]{this.fIG});
        try {
            Uri parse = Uri.parse(this.fIG);
            ViewGroup viewGroup;
            if (parse.getScheme() == null || parse.getScheme().toLowerCase().startsWith("http")) {
                str3 = parse.getHost();
                if (str3 == null || str3.toLowerCase().endsWith(".qq.com")) {
                    x.i("MicroMsg.WebviewReporter.DomainReporter", "rawUrl, host is .qq.com, skip, host = %s", new Object[]{str3});
                    try {
                        this.nmo = this.mController.contentView;
                        if (this.nmo != null) {
                            aRv();
                            ((ViewGroup) ((ViewGroup) getWindow().getDecorView()).getChildAt(0)).addOnLayoutChangeListener(new OnLayoutChangeListener(this) {
                                final /* synthetic */ WebViewUI tAv;

                                {
                                    this.tAv = r1;
                                }

                                public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                                    this.tAv.aRv();
                                }
                            });
                        }
                    } catch (Exception e22) {
                        x.e("MicroMsg.WebViewUI", "fixContentMargin error : %s", new Object[]{e22.getMessage()});
                    }
                    try {
                        if (com.tencent.mm.compatible.util.d.fM(21)) {
                            viewGroup = (ViewGroup) ((ViewGroup) getWindow().getDecorView()).getChildAt(0);
                            viewGroup.setOnApplyWindowInsetsListener(new 67(this, viewGroup));
                        } else {
                            ((ViewGroup) getWindow().getDecorView()).setFitsSystemWindows(true);
                        }
                    } catch (Exception e222) {
                        x.e("MicroMsg.WebViewUI", "tryToExpandToStatusBar error : %s", new Object[]{e222.getMessage()});
                    }
                    this.tyy = new com.tencent.mm.plugin.webview.modeltools.e(this, this.tAc);
                    this.tzQ.Dm().F(new Runnable(this) {
                        final /* synthetic */ WebViewUI tAv;

                        {
                            this.tAv = r1;
                        }

                        public final void run() {
                            com.tencent.mm.bx.f.chd();
                            com.tencent.mm.bx.b.cgX();
                        }
                    });
                    this.tzT = new WebViewClipBoardHelper(this);
                    this.tzY.ceO();
                }
                bRh.moK = true;
                this.nmo = this.mController.contentView;
                if (this.nmo != null) {
                    aRv();
                    ((ViewGroup) ((ViewGroup) getWindow().getDecorView()).getChildAt(0)).addOnLayoutChangeListener(/* anonymous class already generated */);
                }
                if (com.tencent.mm.compatible.util.d.fM(21)) {
                    ((ViewGroup) getWindow().getDecorView()).setFitsSystemWindows(true);
                } else {
                    viewGroup = (ViewGroup) ((ViewGroup) getWindow().getDecorView()).getChildAt(0);
                    viewGroup.setOnApplyWindowInsetsListener(new 67(this, viewGroup));
                }
                this.tyy = new com.tencent.mm.plugin.webview.modeltools.e(this, this.tAc);
                this.tzQ.Dm().F(/* anonymous class already generated */);
                this.tzT = new WebViewClipBoardHelper(this);
                this.tzY.ceO();
            }
            x.i("MicroMsg.WebviewReporter.DomainReporter", "rawUrl scheme is not http/https, skip, scheme = %s", new Object[]{parse.getScheme()});
            this.nmo = this.mController.contentView;
            if (this.nmo != null) {
                aRv();
                ((ViewGroup) ((ViewGroup) getWindow().getDecorView()).getChildAt(0)).addOnLayoutChangeListener(/* anonymous class already generated */);
            }
            if (com.tencent.mm.compatible.util.d.fM(21)) {
                viewGroup = (ViewGroup) ((ViewGroup) getWindow().getDecorView()).getChildAt(0);
                viewGroup.setOnApplyWindowInsetsListener(new 67(this, viewGroup));
            } else {
                ((ViewGroup) getWindow().getDecorView()).setFitsSystemWindows(true);
            }
            this.tyy = new com.tencent.mm.plugin.webview.modeltools.e(this, this.tAc);
            this.tzQ.Dm().F(/* anonymous class already generated */);
            this.tzT = new WebViewClipBoardHelper(this);
            this.tzY.ceO();
        } catch (Exception e4) {
            x.e("MicroMsg.WebviewReporter.DomainReporter", "parse rawUrl fail, rawUrl = %s", new Object[]{r3});
        }
    }

    public boolean bSy() {
        return true;
    }

    public final int bSz() {
        if (getResources().getDimensionPixelSize(R.f.bys) > com.tencent.mm.bv.a.fromDPToPix(this, 48)) {
            return getResources().getDimensionPixelSize(R.f.bys);
        }
        if (com.tencent.mm.compatible.util.j.aS(this)) {
            return getResources().getDimensionPixelSize(R.f.buG);
        }
        return getResources().getDimensionPixelSize(R.f.buF);
    }

    protected final void aRv() {
        if (this.nmo != null) {
            Object obj = (this.tyw || this.tyx) ? 1 : null;
            if (obj == null) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.nmo.getLayoutParams();
                int bSA = bSA();
                if (bSA != marginLayoutParams.topMargin) {
                    marginLayoutParams.topMargin = bSA;
                    this.nmo.setLayoutParams(marginLayoutParams);
                }
            }
        }
    }

    public int bSA() {
        return this.jNd + bSz();
    }

    @TargetApi(21)
    public void a(ViewGroup viewGroup, WindowInsets windowInsets) {
        if (this.jNd != windowInsets.getSystemWindowInsetTop()) {
            this.jNd = windowInsets.getSystemWindowInsetTop();
            aRv();
            if (viewGroup instanceof SwipeBackLayout) {
                viewGroup = viewGroup.getChildAt(0);
            }
            int i = R.h.action_bar_container;
            if (i > 0) {
                View findViewById = viewGroup.findViewById(i);
                if (findViewById != null) {
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) findViewById.getLayoutParams();
                    marginLayoutParams.topMargin = windowInsets.getSystemWindowInsetTop();
                    findViewById.setLayoutParams(marginLayoutParams);
                    findViewById.requestLayout();
                }
            }
            if (bSB()) {
                bSD();
            }
        }
    }

    public boolean bSB() {
        return true;
    }

    public int akH() {
        return getResources().getColor(R.e.btS);
    }

    protected final int bSC() {
        if (com.tencent.mm.compatible.util.d.fM(21) && aRw()) {
            return com.tencent.smtt.sdk.WebView.NIGHT_MODE_COLOR;
        }
        return getResources().getColor(R.e.brf);
    }

    private boolean aRw() {
        if (bh.ov(this.nmr) || !this.nmr.equals("black")) {
            return false;
        }
        return true;
    }

    public final void bSD() {
        if (!com.tencent.mm.compatible.util.d.fM(21) || this.nmq == 0) {
            setStatusBarColor(akH());
            return;
        }
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(this.nmq));
        if (aRw()) {
            cmV();
        }
        T(this.nmq, aRw());
    }

    public final void T(int i, boolean z) {
        if (VERSION.SDK_INT >= 23 && !com.tencent.mm.compatible.util.h.zj()) {
            setStatusBarColor(i);
            Window window = getWindow();
            int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
            if (z) {
                systemUiVisibility |= 8192;
            } else {
                systemUiVisibility &= -8193;
            }
            window.getDecorView().setSystemUiVisibility(systemUiVisibility);
        } else if (VERSION.SDK_INT >= 21) {
            if (z) {
                i = d.j(i, 0.78f);
            }
            setStatusBarColor(i);
        }
    }

    @TargetApi(21)
    public final void setStatusBarColor(int i) {
        if (this.jNd > 0 && !com.tencent.mm.compatible.util.d.fN(21)) {
            getWindow().setStatusBarColor(0);
            if (this.nmp == null) {
                this.nmp = new View(this);
                ((ViewGroup) findViewById(16908290)).addView(this.nmp, new LayoutParams(-1, this.jNd));
            } else {
                LayoutParams layoutParams = this.nmp.getLayoutParams();
                if (layoutParams.height != this.jNd) {
                    layoutParams.height = this.jNd;
                    this.nmp.setLayoutParams(layoutParams);
                }
            }
            this.nmp.setBackgroundColor(i);
        }
    }

    public final String aPk() {
        if (this.handler == null) {
            return this.tAl;
        }
        if (Thread.currentThread().getId() == this.handler.getLooper().getThread().getId()) {
            return this.ptK == null ? "" : this.ptK.getUrl();
        } else {
            if (!bh.ov(this.tAl)) {
                return this.tAl;
            }
            this.tAl = (String) new bc<String>(this, "") {
                final /* synthetic */ WebViewUI tAv;

                protected final /* synthetic */ Object run() {
                    return this.tAv.ptK == null ? "" : this.tAv.ptK.getUrl();
                }
            }.b(this.handler);
            return this.tAl;
        }
    }

    public MMWebView bSE() {
        return MMWebView.a.cn(this);
    }

    public void onWebViewScrollChanged(int i, int i2, int i3, int i4) {
        x.v("MicroMsg.WebViewUI", "l=%d t=%d oldl=%d oldt=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
    }

    public void afg() {
        if (VERSION.SDK_INT <= 10) {
            super.afg();
        } else if (this.screenOrientation == -1) {
            this.xIo = getSharedPreferences(ac.cfs(), 4).getBoolean("settings_landscape_mode", false);
            if (this.xIo) {
                setRequestedOrientation(-1);
            } else {
                setRequestedOrientation(1);
            }
        } else {
            setRequestedOrientation(this.screenOrientation);
        }
    }

    public final int getForceOrientation() {
        return this.screenOrientation;
    }

    private View bSF() {
        int identifier;
        View view = null;
        if (com.tencent.mm.compatible.util.d.fM(11)) {
            try {
                identifier = Resources.getSystem().getIdentifier("action_bar_container", SlookAirButtonFrequentContactAdapter.ID, "android");
            } catch (Exception e) {
                x.e("MicroMsg.WebViewUI", "get resId action_bar_container, exp = %s", new Object[]{e});
            }
            if (identifier > 0) {
                view = findViewById(identifier);
            }
            x.i("MicroMsg.WebViewUI", "getActionBarContainer, viewResId = %d, get view = %s", new Object[]{Integer.valueOf(identifier), view});
            return view;
        }
        identifier = -1;
        if (identifier > 0) {
            view = findViewById(identifier);
        }
        x.i("MicroMsg.WebViewUI", "getActionBarContainer, viewResId = %d, get view = %s", new Object[]{Integer.valueOf(identifier), view});
        return view;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.tAb != configuration.orientation) {
            View bSF = bSF();
            bSF = bSF == null ? null : (View) bSF.getParent();
            if (bSF != null) {
                bSF.dispatchConfigurationChanged(configuration);
                bSF.requestLayout();
                this.tAb = configuration.orientation;
            }
        }
    }

    public void onStart() {
        super.onStart();
        x.i("MicroMsg.WebViewUI", "edw onStart");
    }

    protected void onStop() {
        x.i("MicroMsg.WebViewUI", "edw onStop");
        J(true, true);
        super.onStop();
    }

    private void AH(int i) {
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("scene_end_type", i);
            bundle.putInt("scene_end_listener_hash_code", hashCode());
            this.juQ.a(5, bundle, hashCode());
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "addSceneEnd, ex = " + e.getMessage());
        }
    }

    private void AI(int i) {
        try {
            if (this.juQ != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("scene_end_type", i);
                bundle.putInt("scene_end_listener_hash_code", hashCode());
                this.juQ.a(6, bundle, hashCode());
            }
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "removeSceneEnd, ex = " + e.getMessage());
        }
    }

    @TargetApi(11)
    public void onDestroy() {
        x.i("MicroMsg.WebViewUI", "onDestroy " + hashCode());
        super.onDestroy();
        if (this.tyy != null) {
            this.tyy.disable();
        }
        this.tzO = true;
        tzN--;
        int hashCode = hashCode();
        for (int size = tyW.size() - 1; size >= 0; size--) {
            if (((ab) tyW.get(size)).id == hashCode) {
                tyW.remove(size);
                break;
            }
        }
        f("", bh.Wo(), 0);
        com.tencent.mm.plugin.webview.modelcache.o bRo = com.tencent.mm.plugin.webview.modelcache.o.a.bRo();
        bRo.ttN.put(hashCode(), Boolean.valueOf(false));
        aj.g bRd = this.trN.bRd();
        bRd.tsX = new Object[]{this.fIG, Integer.valueOf(2)};
        bRd.c(this.juQ);
        this.trN.c(this.juQ);
        aj ajVar = this.trN;
        ajVar.tsI = null;
        ajVar.tsG = null;
        ajVar.tsH = null;
        ajVar.tsF = null;
        ajVar.tsJ = null;
        ajVar.tsK = null;
        ajVar.tsL = null;
        ajVar.tsM = null;
        if (ajVar.tsR != null) {
            ajVar.tsR.msB = null;
            ajVar.tsR = null;
        }
        BL("onDestroy");
        this.tzq.clear();
        for (SparseBooleanArray sparseBooleanArray : this.tAi.values()) {
            if (sparseBooleanArray != null) {
                sparseBooleanArray.clear();
            }
        }
        this.tAi.clear();
        com.tencent.mm.plugin.webview.model.a aVar = this.tzQ;
        if (!(aVar.trM == null || aVar.trM.oAt.getLooper() == null)) {
            aVar.trM.oAt.getLooper().quit();
        }
        aVar.trM = null;
        ag agVar = this.tzW;
        agVar.tsA.clear();
        agVar.tsB.clear();
        agVar.tsC.clear();
        agVar.tsy.clear();
        agVar.tsz.clear();
        if (this.tAs != null) {
            this.tAs.dismiss();
            this.tAs = null;
        }
        if (this.tAp != null) {
            this.tAp.dismiss();
            this.tAp = null;
        }
        AI(233);
        this.tzr.clear();
        this.tzu.clear();
        this.tzY.dead();
        if (com.tencent.xweb.c.iO(ac.getContext()) != null) {
            x.i("MicroMsg.WebViewUI", "now force sync the cookie between ram and db");
            com.tencent.xweb.c.sync();
        }
        if (bSR()) {
            try {
                if (this.juQ != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("srcUsername", getIntent().getStringExtra("srcUsername"));
                    this.juQ.a(30, bundle, hashCode());
                }
            } catch (Exception e) {
            }
        }
        x.v("MicroMsg.WebViewUI", "on destroy isNeedCallbackMMRpt[%b]", new Object[]{Boolean.valueOf(this.tyE)});
        if (this.tyE) {
            try {
                bundle = getIntent().getBundleExtra("mm_report_bundle");
                if (bh.ov(bundle.getString("mm_event_class"))) {
                    x.w("MicroMsg.WebViewUI", "webview on destroy callback mm but eventclass is null");
                } else if (this.juQ != null) {
                    bundle.putLong("key_activity_browse_time", cmZ());
                    this.juQ.e(250, bundle);
                }
            } catch (Exception e2) {
                x.e("MicroMsg.WebViewUI", "webview on destroy callback mm exception [%s]", new Object[]{e2.toString()});
            }
        }
        try {
            if (this.juQ != null) {
                bundle = new Bundle();
                bundle.putLong("key_activity_browse_time", cmZ());
                this.juQ.e(251, bundle);
            }
        } catch (Exception e22) {
            x.e("MicroMsg.WebViewUI", "webview on destroy callback mm exception [%s]", new Object[]{e22.toString()});
        }
        try {
            if (this.juQ != null) {
                bundle = this.juQ.e(19, null);
                if (bundle != null) {
                    x.i("MicroMsg.WebViewUI", "onDestroy, has init = %b, webviewHoldingCounter = %d", new Object[]{Boolean.valueOf(bundle.getBoolean("webview_video_proxy_init")), Integer.valueOf(tzN)});
                    if (bundle.getBoolean("webview_video_proxy_init") && tzN <= 0) {
                        FactoryProxyManager.getPlayManager().deinit();
                        this.juQ.e(75, null);
                    }
                }
            }
        } catch (Exception e222) {
            x.e("MicroMsg.WebViewUI", "deinit video player failed : %s", new Object[]{e222.getMessage()});
        }
        if (this.lrm != null) {
            try {
                unbindService(this.lrm);
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.WebViewUI", e3, "unbindService", new Object[0]);
            }
        }
        if (this.tlx != null) {
            this.tlx.detach();
        }
        this.naK.clear();
        if (this.tzk != null) {
            b bVar = this.tzk;
            x.i("MicroMsg.WebView.MMSslErrorHandler", "detach");
            bVar.context = null;
            bVar.twx = null;
            bVar.twy.clear();
            bVar.twz.clear();
        }
        if (this.tzm != null) {
            this.tzm.detach();
        }
        if (VERSION.SDK_INT >= 11) {
            this.ptK.removeJavascriptInterface("MicroMsg");
            this.ptK.removeJavascriptInterface("JsApi");
        }
        try {
            this.ptK.setWebChromeClient(null);
            this.ptK.setWebViewClient(null);
            this.ptK.setOnTouchListener(null);
            this.ptK.setOnLongClickListener(null);
            this.ptK.setVisibility(8);
            this.ptK.removeAllViews();
            this.ptK.clearView();
        } catch (Exception e2222) {
            x.e("MicroMsg.WebViewUI", "onDestroy, set web infos to null,  ex = %s", new Object[]{e2222.getMessage()});
        }
        this.tzR.bRI();
        if (this.juR != null) {
            this.juR.detach();
            this.juR = null;
        }
        try {
            this.tAe.release();
        } catch (Exception e22222) {
            x.e("MicroMsg.WebViewUI", "onDestroy, remove view,  ex = " + e22222.getMessage());
        }
        try {
            this.ptK.destroy();
        } catch (Exception e222222) {
            x.w("MicroMsg.WebViewUI", "onDestroy, viewWV destroy, ex = %s", new Object[]{e222222.getMessage()});
        }
        Object obj = this.tzT;
        try {
            obj.tvj.removePrimaryClipChangedListener(obj);
            obj.tvj = null;
        } catch (Exception e4) {
        }
        this.ptK = null;
        System.gc();
    }

    private void aPf() {
        try {
            this.tAe.release();
            this.ptK.stopLoading();
            this.ptK.removeAllViews();
            this.ptK.clearView();
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "forceQuit, ex = " + e.getMessage());
        }
        if (this.tlx != null) {
            this.tlx.detach();
        }
        try {
            this.ptK.destroy();
        } catch (Exception e2) {
            x.w("MicroMsg.WebViewUI", "forceQuit, viewWV destroy, ex = %s", new Object[]{e2.getMessage()});
        }
        this.ptK = null;
        finish();
        x.cfk();
        Process.killProcess(Process.myPid());
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 82 || this.tAd) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.ptK.hasEnteredFullscreen()) {
            this.ptK.leaveFullscreen();
            return true;
        } else if (i != 4 || this.tyZ == null || this.tyY == null || this.tza == null) {
            if (i == 4) {
                boolean z;
                if (this.tyz == null || !this.tyz.isShown()) {
                    z = false;
                } else {
                    this.tyz.hide();
                    bSS();
                    z = true;
                }
                if (z) {
                    return true;
                }
            }
            if (i == 4) {
                if (this.ptK.canGoBack() && this.mZp) {
                    bSG();
                    r1 = this.trN.bRd();
                    r1.tsX = new Object[]{this.fIG, Integer.valueOf(1)};
                    r1.c(this.juQ);
                    return true;
                }
                g.tyi.close();
                bSZ();
            }
            if (i == 4 && aPo()) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        } else {
            try {
                this.tza.onHideCustomView();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WebViewUI", e, "onkeydown", new Object[0]);
            }
            r1 = this.trN.bRd();
            r1.tsX = new Object[]{this.fIG, Integer.valueOf(1)};
            r1.c(this.juQ);
            return true;
        }
    }

    public void bSG() {
        this.ptK.goBack();
        this.tyQ = null;
        if (this.tzo) {
            this.tzo = false;
        }
        g gVar = g.tyi;
        x.v("MicroMsg.WebViewReportUtil", "goBack traceid %s", new Object[]{gVar.rea});
        if (!bh.ov(gVar.rea)) {
            gVar.pY(5);
        }
    }

    public void cA(String str, int i) {
        if (this.tyz != null) {
            this.tyz.show();
            if (!bh.ov(str)) {
                this.tyz.setText(str);
            }
            if (i >= 0) {
                this.tyz.Bg(i);
            }
        }
    }

    public int bSH() {
        if (this.tyz == null) {
            return 0;
        }
        return this.tyz.bUU();
    }

    protected void bSr() {
        int intExtra = getIntent().getIntExtra("webview_bg_color_rsID", -1);
        if (intExtra == -1 || this.mController.contentView == null) {
            this.ptK.setBackgroundDrawable(com.tencent.mm.bv.a.b(this, R.e.btq));
            return;
        }
        setBackGroundColorResource(intExtra);
        this.mController.contentView.setBackgroundResource(intExtra);
        this.ptK.setBackgroundResource(17170445);
        findViewById(R.h.cYR).setBackgroundResource(17170445);
    }

    public void bSI() {
        if (getIntent() != null && getIntent().hasExtra("show_full_screen")) {
            I(getIntent().getBooleanExtra("show_full_screen", false), true);
        }
    }

    private void I(boolean z, boolean z2) {
        this.tyw = z;
        if (z) {
            if (getSupportActionBar() != null) {
                getSupportActionBar().hide();
            }
            if (this.nmo != null) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.nmo.getLayoutParams();
                marginLayoutParams.topMargin = 0;
                this.nmo.setLayoutParams(marginLayoutParams);
            }
            if (this.nmp != null) {
                this.nmp.setVisibility(8);
            }
            getWindow().addFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            View decorView = getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new 5(this, decorView));
            G(decorView, 5894);
            if (z2) {
                this.tyv.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ WebViewUI tAv;

                    {
                        this.tAv = r1;
                    }

                    public final void onClick(View view) {
                        this.tAv.aPz();
                    }
                });
                this.tyv.setVisibility(0);
                return;
            }
            this.tyv.setVisibility(8);
            return;
        }
        this.tyv.setVisibility(8);
        getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        decorView = getWindow().getDecorView();
        if (decorView != null) {
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & -5895);
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().show();
            if (this.nmo != null) {
                marginLayoutParams = (MarginLayoutParams) this.nmo.getLayoutParams();
                marginLayoutParams.topMargin = bSz();
                this.nmo.setLayoutParams(marginLayoutParams);
            }
        }
        if (this.nmp != null) {
            this.nmp.setVisibility(0);
        }
    }

    private static void G(View view, int i) {
        if (view != null) {
            view.setSystemUiVisibility(view.getSystemUiVisibility() | 5894);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && this.tyw) {
            G(getWindow().getDecorView(), 5894);
        }
    }

    public void initView() {
        boolean booleanExtra = getIntent().getBooleanExtra("vertical_scroll", true);
        this.tyM = getIntent().getBooleanExtra("finishviewifloadfailed", false);
        this.tyJ = getIntent().getBooleanExtra("is_favorite_item", false);
        this.ryW = getIntent().getBooleanExtra("isWebwx", true);
        this.tyH = getIntent().getBooleanExtra("neverGetA8Key", false);
        this.tzB = getIntent().getBooleanExtra("neverBlockLocalRequest", false);
        this.tyL = getIntent().getBooleanExtra("KFromLoginHistory", false);
        this.tzx = LayoutInflater.from(this.mController.xIM).inflate(R.i.dsS, null);
        boolean booleanExtra2 = getIntent().getBooleanExtra("show_feedback", false);
        this.tzz = bh.ou(getIntent().getStringExtra("sentUsername"));
        if (booleanExtra2) {
            addTextOptionMenu(1, getString(R.l.eLt), new OnMenuItemClickListener(this) {
                final /* synthetic */ WebViewUI tAv;

                {
                    this.tAv = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    try {
                        this.tAv.ptK.loadUrl(this.tAv.juQ.OW(null));
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.WebViewUI", e, "[oneliang]feedback exception:%s", new Object[]{e.getMessage()});
                    }
                    return false;
                }
            });
        }
        this.typ = (ProgressBar) findViewById(R.h.bZM);
        this.tzy = findViewById(R.h.cHe);
        this.tzy.setOnClickListener(new 8(this));
        if (this.ryW) {
            CharSequence ou = bh.ou(getIntent().getStringExtra("title"));
            if (ou.length() > 0) {
                this.tyn = true;
            }
            super.O(ou);
            nR(bSC());
        } else {
            setMMTitle("");
        }
        ku(false);
        kv(false);
        if (tzc == RenderPriority.NORMAL) {
            x.i("MicroMsg.WebViewUI", "initView, set render priority to HIGH");
            this.ptK.getSettings().setRenderPriority(RenderPriority.HIGH);
            tzc = RenderPriority.HIGH;
        }
        this.tAe.cU(this.mController.contentView);
        this.tAe.b(this.ptK);
        bSr();
        this.tyt = (FrameLayout) findViewById(R.h.cIw);
        this.tyu = (FrameLayout) findViewById(R.h.bYF);
        x.i("MicroMsg.WebViewUI", "Is the current broswer kernel X5, " + this.ptK.isX5Kernel);
        if (this.ptK.isX5Kernel) {
            this.ptK.setWebViewCallbackClient(this.tzX);
            this.ptK.setWebViewClientExtension(new h(this));
            f fVar = this.tAe;
            LogoWebViewWrapper.a 9 = new 9(this);
            if (fVar.txS != null) {
                fVar.txS.twl = 9;
            }
        }
        this.tyz = (WebViewInputFooter) findViewById(R.h.cYM);
        if (this.tyz != null) {
            this.tyz.hide();
            this.tyz.tKS = new 10(this);
            this.tyz.tKT = new 11(this);
            this.tyz.tKU = new 13(this);
        }
        this.tyA = (WebViewSearchContentInputFooter) findViewById(R.h.cJy);
        if (this.tyA != null) {
            this.tyA.tKQ = new 14(this);
            this.ptK.setFindListener(new 15(this));
        }
        this.tyv = (MovingImageButton) findViewById(R.h.ckl);
        this.tyU = findViewById(R.h.cYJ);
        if (this.tyU != null) {
            this.tyU.setVisibility(8);
        }
        if (!booleanExtra) {
            this.ptK.setVerticalScrollBarEnabled(false);
        }
        this.tza = new 16(this);
        this.ptK.setWebChromeClient(this.tza);
        this.ptK.setWebViewClient(new i(this));
        this.ptK.setDownloadListener(new 17(this));
        this.ptK.requestFocus(130);
        this.ptK.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ WebViewUI tAv;

            {
                this.tAv = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.tAv.tys != null && this.tAv.tys.getVisibility() == 0) {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.tAv, R.a.bqc);
                    loadAnimation.setAnimationListener(new 1(this));
                    this.tAv.tys.startAnimation(loadAnimation);
                    this.tAv.tys.setVisibility(8);
                }
                switch (motionEvent.getAction()) {
                    case 0:
                    case 1:
                        if (!view.hasFocus()) {
                            view.requestFocus();
                            break;
                        }
                        break;
                }
                if (this.tAv.ptK != null && (motionEvent.getAction() == 0 || motionEvent.getAction() == 5 || motionEvent.getAction() == 5 || motionEvent.getAction() == 261 || motionEvent.getAction() == 517)) {
                    if (motionEvent.getPointerCount() > 1) {
                        this.tAv.ptK.getSettings().setBuiltInZoomControls(true);
                        this.tAv.ptK.getSettings().setSupportZoom(true);
                    } else {
                        this.tAv.ptK.getSettings().setBuiltInZoomControls(false);
                        this.tAv.ptK.getSettings().setSupportZoom(false);
                    }
                }
                return false;
            }
        });
        this.ptK.getSettings().setUserAgentString(s.aL(this, this.ptK.getSettings().getUserAgentString()));
        this.ptK.cyV();
        this.juS = new com.tencent.mm.ui.tools.l(this.mController.xIM);
        this.juS.a(this.ptK, this, null);
        this.juS.e(new OnCancelListener(this) {
            final /* synthetic */ WebViewUI tAv;

            {
                this.tAv = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.tAv.juW != null && this.tAv.juQ != null) {
                    try {
                        this.tAv.juQ.OV(this.tAv.juW.tvd);
                        this.tAv.juW.bRG();
                    } catch (Exception e) {
                        x.e("MicroMsg.WebViewUI", "cancel capture failed");
                    }
                }
            }
        });
        setBackBtn(new 20(this), bSJ());
        if (bSK()) {
            WebViewKeyboardLinearLayout webViewKeyboardLinearLayout = (WebViewKeyboardLinearLayout) findViewById(R.h.cYR);
            webViewKeyboardLinearLayout.xGO = new 43(this, webViewKeyboardLinearLayout);
        }
        this.tyo = (MMFalseProgressBar) findViewById(R.h.cYD);
        super.aa(new 21(this));
    }

    public int bSJ() {
        return this.tzE ? 0 : R.k.byB;
    }

    public final void AJ(int i) {
        Drawable mutate = getResources().getDrawable(R.g.byB).mutate();
        mutate.setColorFilter(i, Mode.SRC_IN);
        com.tencent.mm.ui.p pVar = this.mController;
        if (pVar.mActionBar != null && pVar.xIV != null && mutate != null) {
            pVar.xIV.setImageDrawable(mutate);
            mutate.invalidateSelf();
        }
    }

    public boolean bSK() {
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.juZ.b(this, i, i2, intent) || !com.tencent.mm.plugin.webview.modeltools.a.b(this, i, i2, intent)) {
        }
    }

    public void onSwipeBack() {
        if (this.ptK != null) {
            if (this.tAf) {
                this.ptK.setOnLongClickListener(this.tAg);
            } else {
                this.ptK.setOnLongClickListener(null);
            }
        }
        aWs();
        super.onSwipeBack();
    }

    public final boolean akK() {
        bSZ();
        return true;
    }

    public void onCancel() {
        if (this.ptK != null) {
            if (this.tAf) {
                this.ptK.setOnLongClickListener(this.tAg);
            } else {
                this.ptK.setOnLongClickListener(null);
            }
        }
        super.onCancel();
    }

    public void onDrag() {
        if (this.ptK != null) {
            this.ptK.setOnLongClickListener(new 24(this));
        }
        super.onDrag();
    }

    private static boolean a(com.tencent.mm.plugin.webview.ui.tools.jsapi.b bVar, String str) {
        if (bh.ov(str) || bVar == null) {
            return false;
        }
        return bVar.BT(str);
    }

    public void akN() {
        String OR;
        boolean z;
        int bSd;
        Map hashMap;
        x.i("MicroMsg.WebViewUI", "edw postBinded");
        bSY();
        com.tencent.mm.plugin.webview.model.a aVar = this.tzQ;
        com.tencent.mm.plugin.webview.stub.d dVar = this.juQ;
        try {
            OR = dVar.OR("DNSAdvanceOpen");
            x.i("MicroMsg.DNSPreGetOptimize", "switch open value : %s", new Object[]{OR});
            if (bh.ov(OR)) {
                x.e("MicroMsg.DNSPreGetOptimize", "get switch value is null or nil");
                z = false;
            } else {
                z = OR.equalsIgnoreCase("1");
            }
            if (z) {
                try {
                    OR = dVar.OR("DNSAdvanceRelateDomain");
                    if (bh.ov(OR)) {
                        x.e("MicroMsg.DNSPreGetOptimize", "domain list is null, just return");
                    } else {
                        aVar.Dm().F(new 1(aVar, OR, dVar));
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.DNSPreGetOptimize", e, "", new Object[0]);
                }
            } else {
                x.i("MicroMsg.DNSPreGetOptimize", "server closed the switch");
            }
        } catch (Exception e2) {
            x.e("MicroMsg.DNSPreGetOptimize", "get dns pre get switch failed");
        }
        if (bSN()) {
            com.tencent.mm.sdk.platformtools.ag.y(new 26(this));
        }
        Bundle bundle = new Bundle();
        Bundle bundleExtra = getIntent().getBundleExtra("jsapiargs");
        if (bundleExtra == null) {
            bundleExtra = new Bundle();
        }
        bundleExtra.putInt("key_download_restrict", getIntent().getIntExtra("key_download_restrict", 0));
        bundleExtra.putString("key_function_id", getIntent().getStringExtra("key_function_id"));
        x.i("MicroMsg.WebViewUI", "KDownloadRestrict = %d, KFunctionID = %s", new Object[]{Integer.valueOf(bundleExtra.getInt("key_download_restrict", 0)), bundleExtra.getString("key_function_id", "")});
        bundle.putBundle("jsapiargs", bundleExtra);
        bundle.putCharSequence("bizofstartfrom", getIntent().getStringExtra("bizofstartfrom"));
        bundle.putBundle("startwebviewparams", getIntent().getBundleExtra("startwebviewparams"));
        bundle.putInt("screen_orientation", this.screenOrientation);
        try {
            this.juQ.a(20, bundle, hashCode());
        } catch (RemoteException e3) {
            x.e("MicroMsg.WebViewUI", "postBinded, invoke AC_SET_INITIAL_ARGS, ex = " + e3.getMessage());
        }
        String stringExtra = getIntent().getStringExtra("geta8key_username");
        int intExtra = getIntent().getIntExtra("preChatTYPE", 0);
        String stringExtra2 = getIntent().getStringExtra("srcUsername");
        long longExtra = getIntent().getLongExtra("message_id", 0);
        int intExtra2 = getIntent().getIntExtra("message_index", 0);
        String stringExtra3 = getIntent().getStringExtra("KsnsViewId");
        String stringExtra4 = getIntent().getStringExtra("KPublisherId");
        String stringExtra5 = getIntent().getStringExtra("KAppId");
        String stringExtra6 = getIntent().getStringExtra("pre_username");
        String stringExtra7 = getIntent().getStringExtra("expid_str");
        String string = bundleExtra.getString("key_snsad_statextstr");
        OR = null;
        if (this.ptK != null) {
            OR = this.ptK.getTitle();
        }
        if (bh.ov(OR)) {
            OR = getIntent().getStringExtra("title");
        }
        if (bh.ov(OR)) {
            OR = getIntent().getStringExtra("webpageTitle");
        }
        com.tencent.mm.plugin.webview.model.aj.j bRa = this.trN.bRa();
        bRa.username = stringExtra;
        bRa.ttk = intExtra;
        bRa.fIG = this.fIG;
        bRa.ttg = intExtra2;
        bRa.scene = Pp(stringExtra);
        bRa.ttf = longExtra;
        bRa.tth = new com.tencent.mm.a.o(longExtra).toString();
        bRa.ttd = stringExtra2;
        bRa.tte = stringExtra3;
        bRa.mXh = stringExtra4;
        bRa.appId = stringExtra5;
        bRa.tti = stringExtra6;
        bRa.ttj = this.ttj;
        bRa.rtA = string;
        bRa.title = bh.az(OR, "");
        bRa.gjO = stringExtra7;
        this.trN.bRc().fIG = this.fIG;
        if (bSR()) {
            try {
                bundleExtra = new Bundle();
                bundleExtra.putString("srcUsername", getIntent().getStringExtra("srcUsername"));
                this.juQ.a(29, bundleExtra, hashCode());
            } catch (Exception e4) {
            }
        }
        if (!bh.ov(stringExtra2)) {
            try {
                this.juQ.OS(stringExtra2);
            } catch (Exception e5) {
                x.e("MicroMsg.WebViewUI", "postBinded, fail triggerGetContact, ex = " + e5.getMessage());
            }
        }
        try {
            if (getIntent().getIntExtra("pay_channel", -1) != -1) {
                x.i("MicroMsg.WebViewUI", "hy: found channel in intent. pay channel: %d", new Object[]{Integer.valueOf(getIntent().getIntExtra("pay_channel", -1))});
            } else {
                bSd = this.juQ.bSd();
                if (bSd != -1) {
                    x.i("MicroMsg.WebViewUI", "hy: found channel in channel helper. pay channel: %d", new Object[]{Integer.valueOf(bSd)});
                    getIntent().putExtra("pay_channel", bSd);
                }
            }
        } catch (Exception e6) {
            x.e("MicroMsg.WebViewUI", "hy: init pay channel failed");
        }
        this.naK.clear();
        MMWebView mMWebView = this.ptK;
        e eVar = this.juR;
        Map hashMap2 = new HashMap();
        hashMap2.put("webview_type", "1");
        hashMap2.put("init_url", this.fIG);
        hashMap2.put("init_font_size", "1");
        hashMap2.put("short_url", bh.ou(getIntent().getStringExtra("shortUrl")));
        this.tlx = new com.tencent.mm.plugin.webview.ui.tools.jsapi.d(mMWebView, eVar, hashMap2, this.juQ, hashCode());
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar2 = this.tlx;
        stringExtra = getIntent().getStringExtra("geta8key_username");
        if (!bh.ov(getIntent().getStringExtra("srcUsername"))) {
            hashMap = new HashMap();
            hashMap.put("srcUsername", getIntent().getStringExtra("srcUsername"));
            hashMap.put("srcDisplayname", getIntent().getStringExtra("srcDisplayname"));
        } else if (bh.ov(stringExtra)) {
            hashMap = new HashMap();
        } else {
            hashMap = new HashMap();
            hashMap.put("srcUsername", stringExtra);
        }
        hashMap.put("message_id", Long.valueOf(getIntent().getLongExtra("message_id", 0)));
        hashMap.put("message_index", Integer.valueOf(getIntent().getIntExtra("message_index", 0)));
        hashMap.put("scene", Integer.valueOf(Pp(stringExtra)));
        hashMap.put("pay_channel", Integer.valueOf(getIntent().getIntExtra("pay_channel", 0)));
        hashMap.put("stastic_scene", Integer.valueOf(getIntent().getIntExtra("stastic_scene", 0)));
        hashMap.put("from_scence", Integer.valueOf(getIntent().getIntExtra("from_scence", 0)));
        if (!bh.ov(getIntent().getStringExtra("KTemplateId"))) {
            hashMap.put("KTemplateId", getIntent().getStringExtra("KTemplateId"));
        }
        int intExtra3 = getIntent().getIntExtra("pay_scene", -1);
        if (intExtra3 != -1) {
            x.i("MicroMsg.WebViewUI", "get pay scene from extra: %s", new Object[]{Integer.valueOf(intExtra3)});
        } else {
            intExtra3 = 3;
            x.i("MicroMsg.WebViewUI", "default pay scene to: %s", new Object[]{Integer.valueOf(3)});
        }
        hashMap.put("pay_scene", Integer.valueOf(intExtra3));
        dVar2.tGP = hashMap;
        if (bSM() != null) {
            bSM().tjq = this.tlx;
        }
        this.ptK.addJavascriptInterface(this.tlx, "__wx");
        this.naK.add(this.tlx);
        this.naK.add(new t(this, (byte) 0));
        this.naK.add(new q(this, (byte) 0));
        this.naK.add(new f());
        this.naK.add(new s(this, (byte) 0));
        this.naK.add(new v(this, (byte) 0));
        this.naK.add(new a(this, (byte) 0));
        this.naK.add(new aa(this, (byte) 0));
        this.naK.add(new u(this, (byte) 0));
        this.naK.add(new j());
        this.naK.add(new b(this, (byte) 0));
        this.naK.add(new e(this, (byte) 0));
        this.naK.add(new c(this, (byte) 0));
        this.naK.add(new com.tencent.mm.plugin.webview.ui.tools.jsapi.e(this.ptK, this.tlx));
        this.naK.add(new z(this, (byte) 0));
        this.naK.add(new w(this, (byte) 0));
        this.naK.add(new o(this, (byte) 0));
        if (getIntent().getBooleanExtra("allow_wx_schema_url", false)) {
            this.naK.add(new l());
        }
        this.naK.add(new g(this, (byte) 0));
        try {
            bSd = bh.getInt(this.juQ.OR("WebviewDisableX5Logo"), 0);
        } catch (Exception e52) {
            x.w("MicroMsg.WebViewUI", "getting flag of x5 logo state failed, ex = " + e52.getMessage());
            bSd = 0;
        }
        x.i("MicroMsg.WebViewUI", "getting flag of x5 logo state, disableX5Logo = %d, disableBounceScroll = %b", new Object[]{Integer.valueOf(bSd), Boolean.valueOf(getIntent().getBooleanExtra("disable_bounce_scroll", false))});
        if (bSd == 1 || r1) {
            this.tAe.kr(true);
        }
        if (getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_disable_over_scroll", false)) {
            this.tAe.kr(true);
        }
        try {
            this.tzl = bh.getInt(this.juQ.OR("OpenJSReadySpeedy"), 0);
        } catch (Exception e522) {
            x.w("MicroMsg.WebViewUI", "postBinded, openJSReadySpeedy, ex = " + e522.getMessage());
        }
        x.i("MicroMsg.WebViewUI", "postBinded, openJSReadySpeedy = %d", new Object[]{Integer.valueOf(this.tzl)});
        aj.H(this.ptK.isX5Kernel, bh.ou(this.fIG).startsWith("https://"));
        if (this.ptK.isX5Kernel) {
            com.tencent.mm.pluginsdk.ui.tools.j.pY(7);
            com.tencent.mm.plugin.report.service.g.pQN.a(64, 64, 1, 0, 1, 1, false);
        } else {
            com.tencent.mm.plugin.report.service.g.pQN.a(64, 0, 1, false);
        }
        this.tzm = new com.tencent.mm.plugin.webview.ui.tools.jsapi.f(this.ptK, this.juQ, this.tlx, new 27(this), getIntent().getBooleanExtra("key_load_js_without_delay", false), bSN());
        try {
            bSd = bh.getInt(this.juQ.OR("WebviewDisableDigestVerify"), 0);
        } catch (Exception e5222) {
            x.w("MicroMsg.WebViewUI", "getting js digest verification config fails, ex = " + e5222.getMessage());
            bSd = 0;
        }
        x.i("MicroMsg.WebViewUI", "js digest verification config = %d", new Object[]{Integer.valueOf(bSd)});
        if (bSd == 0 && getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("wvsha1", true) && bTa()) {
            this.tlx.bUm();
            this.tzW.tsD = this.tlx.tGT;
        }
        if (getIntent().getBooleanExtra("forceHideShare", false)) {
            kt(false);
            x.d("MicroMsg.WebViewUI", "[hakon] postBinded :%d: force hide", new Object[]{Long.valueOf(System.currentTimeMillis())});
        } else {
            kt(getIntent().getBooleanExtra("showShare", true));
            x.d("MicroMsg.WebViewUI", "[cpan] postBinded :%d: show:%b", new Object[]{Long.valueOf(System.currentTimeMillis()), Boolean.valueOf(z)});
        }
        this.tys = LayoutInflater.from(this).inflate(R.i.dtX, null);
        FontChooserView fontChooserView = (FontChooserView) this.tys.findViewById(R.h.ciV);
        View findViewById = this.tys.findViewById(R.h.ciU);
        if (!this.ptK.isX5Kernel) {
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new 63(this));
        }
        fontChooserView.tJY = new k(this, (byte) 0);
        this.tys.setLayoutParams(new FrameLayout.LayoutParams(-1, -2, 80));
        this.tyu.addView(this.tys);
        this.tys.setVisibility(8);
        bSd = 2;
        try {
            if (this.juQ.aOD()) {
                bSd = (bSV() || bSW()) ? bSX() : (bh.ov(this.fIG) || !com.tencent.mm.plugin.webview.a.tkS.matcher(this.fIG).matches()) ? this.juQ.ek(16384, 0) : this.juQ.ek(16388, 0);
            }
        } catch (Exception e7) {
            x.w("MicroMsg.WebViewUI", "initFontChooserView, ex = " + e7.getMessage());
        }
        if (bSd <= 0 || bSd > 4) {
            bSd = 2;
        }
        AN(bSd);
        AO(bSd);
        try {
            this.juQ.a(this.fIG, true, null);
        } catch (Exception e52222) {
            x.w("MicroMsg.WebViewUI", "postBinded, jumpToActivity, ex = " + e52222.getMessage());
        }
        for (com.tencent.mm.plugin.webview.ui.tools.jsapi.b bVar : this.naK) {
            if (a(bVar, this.fIG)) {
                x.i("MicroMsg.WebViewUI", "initView, url handled, result = " + bVar.BU(this.fIG) + ", url = " + this.fIG);
                return;
            }
        }
        if (bSj()) {
            x.w("MicroMsg.WebViewUI", "needDelayLoadUrl is true, do nothing");
            return;
        }
        String stringExtra8 = getIntent().getStringExtra(SlookAirButtonFrequentContactAdapter.DATA);
        if (stringExtra8 != null) {
            x.i("MicroMsg.WebViewUI", stringExtra8);
            if (getIntent().getBooleanExtra("QRDataFlag", true)) {
                try {
                    stringExtra8 = this.juQ.ON(stringExtra8);
                } catch (Exception e522222) {
                    x.w("MicroMsg.WebViewUI", "postBinded, formatQRString, ex = " + e522222.getMessage());
                }
            }
            this.ptK.setOnLongClickListener(this.tAg);
            this.tAf = true;
            this.ptK.getSettings().setUseWideViewPort(false);
            this.ptK.getSettings().setLoadWithOverviewMode(false);
            if (Pr(null)) {
                this.ptK.getSettings().setJavaScriptEnabled(false);
                this.ptK.loadDataWithBaseURL(null, stringExtra8, "text/html", ProtocolPackage.ServerEncoding, null);
                x.i("MicroMsg.WebViewUI", "loadDataWithBaseUrl, data = " + stringExtra8);
                return;
            }
            x.f("MicroMsg.WebViewUI", "postBinded baseUrl, canLoadUrl fail, url = " + null);
            aPf();
            return;
        }
        if (bh.ov(this.fIG)) {
            hb(false);
        }
        if (this.fIG == null || this.fIG.length() == 0) {
            x.e("MicroMsg.WebViewUI", "initView, rawUrl is null, no data or getStringExtra(\"data\") is null");
            return;
        }
        Uri parse = Uri.parse(this.fIG);
        if (parse == null) {
            x.e("MicroMsg.WebViewUI", "initView uri is null");
            return;
        }
        if (parse.getScheme() == null) {
            this.fIG = "http://" + this.fIG;
        } else if (!parse.getScheme().startsWith("http")) {
            x.i("MicroMsg.WebViewUI", "uri scheme not startwith http, scheme = " + parse.getScheme());
            if (!Pr(this.fIG)) {
                x.f("MicroMsg.WebViewUI", "postBinded, canLoadUrl fail, url = " + this.fIG);
                aPf();
                return;
            } else if (bSN()) {
                x.i("MicroMsg.WebViewUI", "webview ispreloaded , do not reload url");
                return;
            } else {
                this.ptK.loadUrl(this.fIG);
                return;
            }
        }
        this.tzd = new m(this.fIG);
        try {
            bundleExtra = this.juQ.e(100000, null);
            if (!(bundleExtra == null || bundleExtra.getString("force_geta8key_host_path") == null)) {
                this.tAh = bundleExtra.getString("force_geta8key_host_path").split(";");
                this.tzd.tAh = this.tAh;
            }
        } catch (Exception e5222222) {
            x.e("MicroMsg.WebViewUI", "get force geta8key paths failed : %s", new Object[]{e5222222.getMessage()});
        }
        if (this.tyH || this.juR.has(this.fIG)) {
            x.i("MicroMsg.WebViewUI", "initView, no need to geta8key, loadUrl directly, neverGetA8Key = " + this.tyH);
            if (!Pr(this.fIG)) {
                x.f("MicroMsg.WebViewUI", "postBinded 2, canLoadUrl fail, url = " + this.fIG);
                aPf();
                return;
            } else if (Pl(this.fIG)) {
                this.tzC = true;
                this.tyo.finish();
                this.tyo.setVisibility(8);
                BO(this.fIG);
                return;
            } else {
                this.ptK.loadUrl(this.fIG);
                return;
            }
        }
        if (Pl(this.fIG)) {
            BO(this.fIG);
            this.tAl = this.fIG;
            this.tzC = true;
            this.tyo.finish();
            this.tyo.setVisibility(8);
        }
        if (!this.tzO && !this.tzP && !isFinishing()) {
            x.i("MicroMsg.WebViewUI", "not call onDestory, try to geta8key again");
            j(this.fIG, false, -1);
            x.i("MicroMsg.WebViewUI", "before geta8key, rawUrl = " + this.fIG);
        }
    }

    public boolean Pl(String str) {
        return com.tencent.mm.plugin.webview.modelcache.o.a(str, this.juQ, hashCode());
    }

    public void BO(String str) {
        Map hashMap = new HashMap(2);
        hashMap.put("Pragma", "no-cache");
        hashMap.put("Cache-Control", "no-cache");
        if (this.ptK != null) {
            this.ptK.loadUrl(str, hashMap);
        }
    }

    public final boolean needShowIdcError() {
        return false;
    }

    private boolean aPB() {
        boolean z = false;
        try {
            if (this.juQ == null) {
                x.w("MicroMsg.WebViewUI", "invoker is null");
            } else {
                z = this.juQ.bSa();
            }
        } catch (RemoteException e) {
            x.e("MicroMsg.WebViewUI", "unable get config for Scan QRCode" + e.getMessage());
        }
        return z;
    }

    private boolean bSe() {
        boolean z = false;
        try {
            if (this.juQ == null) {
                x.w("MicroMsg.WebViewUI", "invoker is null");
            } else {
                z = this.juQ.bSe();
            }
        } catch (RemoteException e) {
            x.e("MicroMsg.WebViewUI", "unable get config for WebViewDownLoadFile" + e.getMessage());
        }
        return z;
    }

    private static String BC(String str) {
        String str2 = null;
        try {
            Matcher matcher = Pattern.compile("(?i)^.*filename=\"?([^\"]+)\"?.*$").matcher(str);
            if (matcher.find() && matcher.groupCount() == 1) {
                str2 = matcher.group(1);
            }
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "getFileNameFromContentDisposition error " + e.getMessage());
        }
        return str2;
    }

    private boolean a(ContextMenu contextMenu, final String str) {
        boolean isSDCardAvailable;
        try {
            isSDCardAvailable = this.juQ.isSDCardAvailable();
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "onCreateContextMenu fail, ex = " + e.getMessage());
            isSDCardAvailable = false;
        }
        if (!isSDCardAvailable) {
            return true;
        }
        contextMenu.setHeaderTitle(R.l.eYq);
        try {
            isSDCardAvailable = this.juQ.aOD();
        } catch (Exception e2) {
            x.e("MicroMsg.WebViewUI", "get has setuin failed : %s", new Object[]{e2.getMessage()});
            isSDCardAvailable = false;
        }
        x.i("MicroMsg.WebViewUI", "hasSetAcc = %b, canShareImage = %b, canFavImage = %b", new Object[]{Boolean.valueOf(isSDCardAvailable), Boolean.valueOf(this.juR.bSt().cdD()), Boolean.valueOf(this.juR.bSt().cdE())});
        if (isSDCardAvailable && r3) {
            contextMenu.add(0, 0, 0, getString(R.l.eBK)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ WebViewUI tAv;

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    try {
                        s.a(this.tAv, str, b.cIj().getCookie(str), this.tAv.juQ.isSDCardAvailable(), new 1(this));
                    } catch (Exception e) {
                        x.e("MicroMsg.WebViewUI", "onMenuItemClick fail, ex = " + e.getMessage());
                    }
                    return true;
                }
            });
        }
        contextMenu.add(0, 0, 0, getString(R.l.eHg)).setOnMenuItemClickListener(new 30(this, str));
        if (isSDCardAvailable && r4) {
            contextMenu.add(0, 0, 0, getString(R.l.eAd)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ WebViewUI tAv;

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    try {
                        boolean isSDCardAvailable = this.tAv.juQ.isSDCardAvailable();
                        String replaceAll = str.replaceAll("tp=webp", "");
                        s.a(this.tAv, replaceAll, b.cIj().getCookie(replaceAll), isSDCardAvailable, new 1(this));
                    } catch (Exception e) {
                        x.e("MicroMsg.WebViewUI", "onMenuItemClick fail, ex = " + e.getMessage());
                    }
                    return true;
                }
            });
        }
        if (this.juT == null) {
            return false;
        }
        contextMenu.add(0, 0, 0, com.tencent.mm.plugin.scanner.a.az(this.juU, this.juT) ? getString(R.l.eCr) : getString(R.l.eCq)).setOnMenuItemClickListener(new 32(this, this.juT, str));
        this.juT = null;
        return true;
    }

    private void a(ContextMenu contextMenu, WebView.a aVar) {
        if (!a(contextMenu, aVar.mExtra) && this.juR.bSt().cdB() && aPB()) {
            this.juY = aVar;
            this.juW = new g();
            this.juW.a(this.ptK, this.jvc);
        }
    }

    private void b(ContextMenu contextMenu, WebView.a aVar) {
        if (!a(contextMenu, aVar.mExtra) && this.juR.bSt().cdB() && aPB()) {
            this.juX = aVar;
            this.juW = new g();
            this.juW.a(this.ptK, this.jvc);
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        WebView.a hitTestResult;
        if (view instanceof android.webkit.WebView) {
            hitTestResult = this.ptK.getHitTestResult();
            if (hitTestResult != null) {
                if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                    b(contextMenu, hitTestResult);
                }
            }
        } else if (view instanceof MMWebView) {
            hitTestResult = ((MMWebView) view).getHitTestResult();
            if (hitTestResult == null) {
                return;
            }
            if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                a(contextMenu, hitTestResult);
            }
        }
    }

    public final String bSL() {
        String str = null;
        try {
            str = getIntent().getStringExtra("rawUrl");
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "getRawUrl exception:%s", new Object[]{e.getMessage()});
            if (e instanceof ClassNotFoundException) {
                finish();
                return str;
            }
        }
        if (str != null && str.length() > 0) {
            return str;
        }
        Uri data = getIntent().getData();
        if (data == null) {
            return "";
        }
        return data.toString();
    }

    public com.tencent.mm.plugin.aj.b bSM() {
        return null;
    }

    public boolean bSN() {
        return false;
    }

    public void bSO() {
    }

    private boolean bSP() {
        boolean z = false;
        try {
            z = this.juQ.OQ("favorite");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WebViewUI", e, "", new Object[z]);
        }
        return z;
    }

    private void cq(List<String> list) {
        Object gu;
        Exception e;
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                if (this.tzi.get(str) != null) {
                    x.i("MicroMsg.WebViewUI", "find %s icon from cache ok", new Object[]{str});
                } else {
                    x.w("MicroMsg.WebViewUI", "not found %s icon from cache, try to load", new Object[]{str});
                    try {
                        String OM = this.juQ.OM(str);
                        if (!bh.ov(OM)) {
                            Bitmap Pd = d.Pd(OM);
                            if (Pd != null) {
                                x.i("MicroMsg.WebViewUI", "load ok, and cache it");
                                this.tzi.put(str, Pd);
                            }
                        }
                    } catch (Exception e2) {
                        x.w("MicroMsg.WebViewUI", "getheadimg, ex = " + e2.getMessage());
                    }
                }
                if (this.tzj.containsKey(str)) {
                    x.i("MicroMsg.WebViewUI", "find %s nick from cache ok", new Object[]{str});
                } else {
                    x.w("MicroMsg.WebViewUI", "not found %s nick from cache, try to load", new Object[]{str});
                    try {
                        gu = this.juQ.gu(str);
                        try {
                            x.i("MicroMsg.WebViewUI", "load nick ok");
                        } catch (Exception e3) {
                            e = e3;
                            x.w("MicroMsg.WebViewUI", "onAttach, ex = " + e.getMessage());
                            this.tzj.put(str, gu);
                        }
                    } catch (Exception e22) {
                        Exception exception = e22;
                        gu = null;
                        e = exception;
                        x.w("MicroMsg.WebViewUI", "onAttach, ex = " + e.getMessage());
                        this.tzj.put(str, gu);
                    }
                    this.tzj.put(str, gu);
                }
            }
        }
    }

    protected final boolean AK(int i) {
        SparseBooleanArray sparseBooleanArray = (SparseBooleanArray) this.tAi.get(this.ptK.getUrl());
        if (sparseBooleanArray == null || !sparseBooleanArray.get(i, false)) {
            return true;
        }
        return false;
    }

    public final void aPJ() {
        String Po = Po(this.tAl);
        String stringExtra = getIntent().getStringExtra("shortcut_user_name");
        if (bh.ov(Po) || bh.ov(stringExtra)) {
            x.e("MicroMsg.WebViewUI", "addShortcut, appid or username is null");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("KAppId", Po);
        bundle.putString("shortcut_user_name", stringExtra);
        bundle.putInt("webviewui_binder_id", hashCode());
        try {
            this.juQ.e(80, bundle);
        } catch (Exception e) {
            x.e("MicroMsg.WebViewUI", "addShortcut, e = " + e.getMessage());
        }
    }

    public void aPz() {
        boolean z;
        com.tencent.mm.ui.widget.g gVar;
        String str = null;
        String url = this.ptK.getUrl();
        ArrayList arrayList = this.tzs.containsKey(url) ? (ArrayList) this.tzs.get(url) : null;
        if (arrayList == null || arrayList.size() <= 0) {
            z = false;
        } else {
            z = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        if (valueOf.booleanValue()) {
            gVar = new com.tencent.mm.ui.widget.g(this.mController.xIM, com.tencent.mm.ui.widget.g.ztp, false);
        } else {
            gVar = new com.tencent.mm.ui.widget.g(this.mController.xIM, com.tencent.mm.ui.widget.g.zto, true);
        }
        gVar.zlt = new 35(this);
        gVar.zlu = new 36(this);
        gVar.rKD = new 37(this);
        gVar.rKC = new 38(this, valueOf, arrayList);
        if (this.ptK != null) {
            str = this.ptK.getUrl();
        }
        if (!bh.ov(str)) {
            if (!bh.ov(Uri.parse(str).getHost())) {
                CharSequence string = getString(R.l.eWX, new Object[]{Uri.parse(str).getHost()});
                if (com.tencent.mm.sdk.a.b.ceK()) {
                    try {
                        if (this.juQ.e(98, null) != null) {
                            string = string + "_NewBridge";
                        }
                    } catch (Exception e) {
                    }
                }
                gVar.e(string, 1);
            }
        }
        if (this.tyw) {
            gVar.tGk = true;
            gVar.tGl = true;
        } else {
            gVar.tGk = false;
            gVar.tGl = false;
        }
        if (this.tyA == null || !this.tyA.isShown()) {
            aWs();
            com.tencent.mm.sdk.platformtools.ag.h(new 40(this, gVar), 100);
            return;
        }
        this.tyA.hide();
        com.tencent.mm.sdk.platformtools.ag.h(new 39(this, gVar), 100);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private LinkedList<com.tencent.mm.k.d.a> bSQ() {
        LinkedList<com.tencent.mm.k.d.a> linkedList = null;
        if (this.ptK == null) {
            x.e("MicroMsg.WebViewUI", "viewwv is null, maybe has destroyed");
        } else {
            String url;
            String str = this.fIG;
            if (this.ptK != null) {
                url = this.ptK.getUrl();
            }
            url = str;
            if (url != null) {
                try {
                    URL url2 = new URL(url);
                    Pattern compile = Pattern.compile(".*(\\.wanggou\\.com|\\.jd\\.com)");
                    CharSequence host = url2.getHost();
                    if (!bh.ov(host)) {
                        if (!host.startsWith(".")) {
                            host = "." + host;
                        }
                        x.d("MicroMsg.WebViewUI", "host = %s", new Object[]{host});
                        if (compile.matcher(host).matches()) {
                            if (this.tzI == null) {
                                boolean z;
                                long currentTimeMillis = System.currentTimeMillis();
                                this.tzI = this.juQ.bRU();
                                String str2 = "MicroMsg.WebViewUI";
                                String str3 = "[hakon] getConfigListMap %b, cost %d";
                                Object[] objArr = new Object[2];
                                if (this.tzI != null) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                objArr[0] = Boolean.valueOf(z);
                                objArr[1] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
                                x.d(str2, str3, objArr);
                            }
                            if (this.tzI != null && this.tzI.size() > 0) {
                                linkedList = com.tencent.mm.k.d.j(this.tzI);
                            }
                        }
                    }
                } catch (Exception e) {
                    x.d("MicroMsg.WebViewUI", "[hakon] getJDMenuItems, ex = ", new Object[]{e.getMessage()});
                }
            }
        }
        return linkedList;
    }

    protected final boolean bSR() {
        String stringExtra = getIntent().getStringExtra("srcUsername");
        String stringExtra2 = getIntent().getStringExtra("bizofstartfrom");
        return (stringExtra == null || stringExtra2 == null || !"enterpriseHomeSubBrand".equals(stringExtra2)) ? false : true;
    }

    protected final void b(String str, Drawable drawable) {
        a(0, str, drawable, new 41(this, bSR(), getIntent().getStringExtra("srcUsername")));
    }

    public void kt(boolean z) {
        this.tAd = z;
        if (this.ptK == null) {
            x.e("MicroMsg.WebViewUI", "viewwv is null, maybe has destroyed");
            return;
        }
        enableOptionMenu(z);
        showOptionMenu(z);
        boolean booleanExtra = getIntent().getBooleanExtra("show_feedback", false);
        if (booleanExtra) {
            showOptionMenu(booleanExtra);
        }
        int i = R.g.bDI;
        if (bSQ() != null) {
            i = R.k.dyY;
        }
        getIntent().getStringExtra("srcUsername");
        bSR();
        if (!getIntent().getBooleanExtra("KRightBtn", false)) {
            addIconOptionMenu(0, i, new 42(this));
        }
        kw(!z);
    }

    public void addIconOptionMenu(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        if (com.tencent.mm.compatible.util.d.fM(21)) {
            Drawable b = android.support.v4.content.a.b(this, i2);
            if (b != null) {
                if (aRw()) {
                    b.setColorFilter(com.tencent.smtt.sdk.WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
                } else {
                    b.clearColorFilter();
                }
                a(i, getString(com.tencent.mm.w.a.k.gYx), b, onMenuItemClickListener);
                return;
            }
            return;
        }
        super.addIconOptionMenu(i, i2, onMenuItemClickListener);
    }

    private void bSS() {
        if (this.tyU != null) {
            this.tyU.setVisibility(8);
        }
        if (this.tyV != null) {
            this.tyV.TG();
        }
    }

    public final void aPD() {
        this.tlx.aQ(GameJsApiSendAppMessage.NAME, true);
        this.tlx.bUr();
        this.trN.Ow("mm_send_friend_count");
    }

    private void Pm(String str) {
        this.tlx.aQ(GameJsApiSendAppMessage.NAME, false);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.tlx;
        if (dVar.tGQ) {
            Map hashMap = new HashMap();
            hashMap.put("scene", "enterprise");
            dVar.tGK.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:share:appmessage", hashMap, dVar.tGS, dVar.tGT) + ")", null);
            try {
                dVar.juQ.E("connector_local_send", str, dVar.tvn);
                dVar.juQ.E("scene", "enterprise", dVar.tvn);
                return;
            } catch (Exception e) {
                x.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                return;
            }
        }
        x.e("MicroMsg.JsApiHandler", "onSendToEnterprise fail, not ready");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bST() {
        getIntent().putExtra("k_username", getIntent().getStringExtra("geta8key_username"));
        getIntent().putExtra("k_expose_url", this.ptK.getUrl());
        getIntent().putExtra("showShare", false);
        String url = this.ptK.getUrl();
        String str = null;
        if (!bh.ov(url)) {
            str = Uri.parse(url).getHost();
        }
        if (bh.ov(str) || !str.startsWith("mp.weixin.qq.com")) {
            getIntent().putExtra("k_expose_current_url", aPk());
            str = null;
        } else {
            try {
                str = String.format("https://mp.weixin.qq.com/mp/infringement?url=%s#wechat_redirect", new Object[]{p.encode(this.ptK.getUrl(), ProtocolPackage.ServerEncoding)});
            } catch (UnsupportedEncodingException e) {
                x.e("MicroMsg.WebViewUI", e.getMessage());
                str = url;
            }
        }
        CharSequence Po = Po(this.ptK.getUrl());
        x.d("MicroMsg.WebViewUI", "doExpose enableReportPageEvent %s", new Object[]{Boolean.valueOf(this.juR.bSt().cdC())});
        if (!(TextUtils.isEmpty(Po) || !r1 || TextUtils.isEmpty(this.ptK.getUrl()))) {
            long Wo = bh.Wo();
            x.d("MicroMsg.WebViewUI", "report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13377), Long.valueOf(Wo), Po, this.ptK.getUrl(), this.fqu, Integer.valueOf(4), Integer.valueOf(1)});
            String str2 = "";
            try {
                str2 = p.encode(this.ptK.getUrl(), "UTF-8");
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.WebViewUI", e2, "", new Object[0]);
            }
            com.tencent.mm.plugin.report.service.g.pQN.h(13377, new Object[]{Long.valueOf(Wo), Po, str2, this.fqu, Integer.valueOf(4), Integer.valueOf(1)});
        }
        if (bh.ov(str)) {
            str = String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(34)});
        }
        this.ptK.loadUrl(str);
    }

    private void AL(int i) {
        CharSequence Po = Po(this.tAn);
        if (TextUtils.isEmpty(this.tAn) || TextUtils.isEmpty(Po)) {
            x.i("MicroMsg.WebViewUI", "stev appId is null or empty");
            return;
        }
        x.i("MicroMsg.WebViewUI", "stev appId %s", new Object[]{Po});
        long Wo = bh.Wo();
        x.d("MicroMsg.WebViewUI", "stev report(%s), clickTimestamp : %d, appID : %s, url : %s, sessionId : %s, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13377), Long.valueOf(Wo), Po, this.tAn, this.fqu, Integer.valueOf(3), Integer.valueOf(i)});
        String str = "";
        try {
            str = p.encode(this.tAn, "UTF-8");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WebViewUI", e, "", new Object[0]);
        }
        com.tencent.mm.plugin.report.service.g.pQN.h(13377, new Object[]{Long.valueOf(Wo), Po, str, this.fqu, Integer.valueOf(3), Integer.valueOf(i)});
    }

    public final void aPK() {
        Bundle bundle = new Bundle();
        bundle.putLong("msg_id", getIntent().getLongExtra("msg_id", Long.MIN_VALUE));
        bundle.putString("sns_local_id", getIntent().getStringExtra("sns_local_id"));
        bundle.putInt("news_svr_id", getIntent().getIntExtra("news_svr_id", 0));
        bundle.putString("news_svr_tweetid", getIntent().getStringExtra("news_svr_tweetid"));
        bundle.putInt("message_index", getIntent().getIntExtra("message_index", 0));
        bundle.putString("rawUrl", this.fIG);
        if (!bh.ov(this.fIG) && this.fIG.endsWith("#rd")) {
            String substring = this.fIG.substring(0, this.fIG.length() - 3);
            if (!(bh.ov(this.tAn) || this.tAn.startsWith(substring))) {
                bundle.putString("rawUrl", this.tAn);
                bundle.putLong("msg_id", Long.MIN_VALUE);
            }
        } else if (!(bh.ov(this.tAn) || this.tAn.startsWith(this.fIG))) {
            bundle.putString("rawUrl", this.tAn);
            bundle.putLong("msg_id", Long.MIN_VALUE);
        }
        Intent intent = getIntent();
        if (intent != null) {
            bundle.putString("preChatName", intent.getStringExtra("preChatName"));
            bundle.putInt("preMsgIndex", intent.getIntExtra("preMsgIndex", 0));
            bundle.putString("prePublishId", intent.getStringExtra("prePublishId"));
            bundle.putString("preUsername", intent.getStringExtra("preUsername"));
        }
        try {
            com.tencent.mm.plugin.webview.stub.b R = this.juQ.R(bundle);
            if (R.bRJ()) {
                this.tlx.aQ(GameJsApiSendAppMessage.NAME, false);
                com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.tlx;
                if (dVar.tGQ) {
                    Map hashMap = new HashMap();
                    hashMap.put("scene", "favorite");
                    dVar.tGK.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:share:appmessage", hashMap, dVar.tGS, dVar.tGT) + ")", null);
                    try {
                        dVar.juQ.E("scene", "favorite", dVar.tvn);
                    } catch (Exception e) {
                        x.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                    }
                } else {
                    x.e("MicroMsg.JsApiHandler", "onFavorite fail, not ready");
                }
                x.i("MicroMsg.WebViewUI", "on favorite simple url");
                return;
            }
            com.tencent.mm.pluginsdk.model.c.a(R.getRet(), 35, (Activity) this, this.nah);
            if (R.getRet() == 0) {
                AL(1);
            } else {
                AL(2);
            }
        } catch (Exception e2) {
            x.e("MicroMsg.WebViewUI", "edw, favoriteUrl fail, ex = " + e2.getMessage());
        }
    }

    private void ku(boolean z) {
        if (findViewById(R.h.cYE) != null) {
            if ((findViewById(R.h.cYE).getVisibility() == 0) != z) {
                findViewById(R.h.cYE).startAnimation(AnimationUtils.loadAnimation(this.mController.xIM, z ? R.a.bpO : R.a.bpP));
            }
            if (z) {
                findViewById(R.h.cYE).setVisibility(0);
                this.tyq = (ImageButton) findViewById(R.h.cYC);
                ImageButton imageButton = this.tyq;
                boolean z2 = this.ptK != null && this.ptK.canGoBack();
                imageButton.setEnabled(z2);
                this.tyq.setOnClickListener(new 54(this));
                this.tyr = (ImageButton) findViewById(R.h.cYF);
                this.tyr.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ WebViewUI tAv;

                    {
                        this.tAv = r1;
                    }

                    public final void onClick(View view) {
                        if (this.tAv.ptK != null) {
                            this.tAv.ptK.reload();
                        }
                    }
                });
                return;
            }
            findViewById(R.h.cYE).setVisibility(8);
        }
    }

    private void kv(boolean z) {
        if (this.tyr != null) {
            this.tyr.setEnabled(z);
        }
    }

    protected final void J(boolean z, boolean z2) {
        enableOptionMenu(z);
        x.d("MicroMsg.WebViewUI", "[cpan] set title enable:%b", new Object[]{Boolean.valueOf(z)});
        setProgressBarIndeterminateVisibility(false);
        if (z2) {
            this.tyo.finish();
        } else if (!this.tzC && !this.tzE) {
            this.tyo.start();
        }
    }

    public void Pn(String str) {
        if (this.juR.bSt().cdA()) {
            Bundle bundle = new Bundle();
            bundle.putInt("fromScene", 100);
            if (this.juQ.a(str, this.juR.bSs().gn(7), bundle)) {
                x.i("MicroMsg.WebViewUI", "shouldOverride, built in url handled, url = " + str);
                return;
            }
            return;
        }
        x.w("MicroMsg.WebViewUI", "shouldOverride, allow inner open url, not allow");
    }

    public boolean BU(String str) {
        for (com.tencent.mm.plugin.webview.ui.tools.jsapi.b bVar : this.naK) {
            if (a(bVar, str)) {
                x.i("MicroMsg.WebViewUI", "url handled, url = " + str);
                if (this.tAj.equals(str)) {
                    x.i("MicroMsg.WebViewUI", "url " + str + " has been handle");
                    return true;
                }
                x.i("MicroMsg.WebViewUI", "url handled, ret = " + bVar.BU(str) + ", url = " + str);
                return true;
            }
        }
        return false;
    }

    public final String Po(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str) || this.juQ == null) {
            return str2;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("webview_binder_id", hashCode());
        bundle.putString("rawUrl", str);
        try {
            str2 = bh.ou(this.juQ.e(76, bundle).getString("appId"));
            x.i("MicroMsg.WebViewUI", "stev cachedAppId %s", new Object[]{str2});
            return str2;
        } catch (RemoteException e) {
            x.w("MicroMsg.WebViewUI", "get cachedAppId error ", new Object[]{e.getMessage()});
            return str2;
        }
    }

    public final void f(String str, long j, int i) {
        Throwable e;
        CharSequence Po = Po(this.tAn);
        if (this.fromScene != 0) {
            this.tAm = " ";
        }
        x.d("MicroMsg.WebViewUI", "webpageVisitInfoReport enableReportPageEvent %s", new Object[]{Boolean.valueOf(this.juR.bSt().cdC())});
        if (this.jIf > 0 && this.tAo > this.jIf && j > this.tAo && !TextUtils.isEmpty(Po) && r4) {
            String encode;
            long j2 = this.tAo - this.jIf;
            long j3 = j - this.tAo;
            x.d("MicroMsg.WebViewUI", "report(%s), clickTimestamp : %d, appID : %s, usedTime : %s, stayTime : %s, networkType : %s, userAgent : %s, url : %s, sessionID : %s, targetAction : %s, targetUrl : %s,scene : %s, refererUrl : %s", new Object[]{Integer.valueOf(13376), Long.valueOf(this.jIf), Po, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(this.networkType), this.jFe, this.tAn, this.fqu, Integer.valueOf(i), str, Integer.valueOf(this.fromScene), this.tAm});
            String str2 = "";
            String str3 = "";
            String str4 = "";
            String str5 = "";
            try {
                str2 = p.encode(bh.ou(this.jFe), "UTF-8");
                str3 = p.encode(bh.ou(this.tAn), "UTF-8");
                encode = p.encode(bh.ou(str), "UTF-8");
                try {
                    str5 = p.encode(bh.ou(this.tAm), "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    e = e2;
                    x.printErrStackTrace("MicroMsg.WebViewUI", e, "", new Object[0]);
                    com.tencent.mm.plugin.report.service.g.pQN.h(13376, new Object[]{Long.valueOf(this.jIf), Po, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(this.networkType), str2, str3, this.fqu, Integer.valueOf(i), encode, Integer.valueOf(this.fromScene), str5});
                    this.fromScene = 0;
                    if (i != 1) {
                        this.tAm = this.tAn;
                        this.tAn = str;
                        this.jIf = j;
                    }
                }
            } catch (Throwable e3) {
                Throwable th = e3;
                encode = str4;
                e = th;
                x.printErrStackTrace("MicroMsg.WebViewUI", e, "", new Object[0]);
                com.tencent.mm.plugin.report.service.g.pQN.h(13376, new Object[]{Long.valueOf(this.jIf), Po, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(this.networkType), str2, str3, this.fqu, Integer.valueOf(i), encode, Integer.valueOf(this.fromScene), str5});
                this.fromScene = 0;
                if (i != 1) {
                    this.tAm = this.tAn;
                    this.tAn = str;
                    this.jIf = j;
                }
            }
            com.tencent.mm.plugin.report.service.g.pQN.h(13376, new Object[]{Long.valueOf(this.jIf), Po, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(this.networkType), str2, str3, this.fqu, Integer.valueOf(i), encode, Integer.valueOf(this.fromScene), str5});
            this.fromScene = 0;
        }
        if (i != 1) {
            this.tAm = this.tAn;
            this.tAn = str;
            this.jIf = j;
        }
    }

    public final x j(String str, boolean z, int i) {
        if (this.tzO || this.tzP || isFinishing()) {
            return x.tBF;
        }
        if (this.tzy != null) {
            this.tzy.setVisibility(8);
        }
        if (this.juR == null) {
            x.e("MicroMsg.WebViewUI", "startGetA8Key fail, after onDestroy");
            return x.tBF;
        } else if (this.tyH) {
            x.i("MicroMsg.WebViewUI", "edw startGetA8Key, nevergeta8key");
            this.juR.b(str, null, null);
            return x.tBD;
        } else {
            Object obj = (this.juQ != null && this.tzD.contains(str) && Pl(str)) ? 1 : null;
            if ((this.juR.has(str) || obj != null) && !z) {
                x.i("MicroMsg.WebViewUI", "edw startGetA8Key no need, wvPerm already has value, url = " + str);
                this.tzh = this.juR.bSs().gn(24);
                return x.tBD;
            }
            int BI;
            String stringExtra = getIntent().getStringExtra("geta8key_username");
            int Pp = Pp(stringExtra);
            if (i == -1) {
                BI = this.tzd.BI(str);
            } else {
                BI = i;
            }
            x.i("MicroMsg.WebViewUI", "edw startGetA8Key, url = %s, scene = %d, username = %s, reason = %d, force = %b, functionid = %s, walletRegion = %d", new Object[]{str, Integer.valueOf(Pp), stringExtra, Integer.valueOf(BI), Boolean.valueOf(z), getIntent().getStringExtra("key_function_id"), Integer.valueOf(getIntent().getIntExtra("key_wallet_region", 0))});
            if (i != 5) {
                J(false, false);
            }
            x.i("MicroMsg.WebViewUI", "edw startGetA8Key, begin, set a default permission");
            this.tzD.add(str);
            this.juR.b(str, null, null);
            this.tzh = this.juR.bSs().gn(24);
            this.tzF = true;
            this.tze.bTl();
            Bundle bundle = new Bundle();
            bundle.putString("geta8key_data_req_url", str);
            bundle.putString("geta8key_data_username", stringExtra);
            bundle.putInt("geta8key_data_scene", Pp);
            bundle.putInt("geta8key_data_reason", BI);
            if (this.ptK.isX5Kernel) {
                bundle.putInt("geta8key_data_flag", 1);
            } else {
                bundle.putInt("geta8key_data_flag", 0);
            }
            bundle.putString("geta8key_data_net_type", aj.bQV());
            bundle.putInt("geta8key_session_id", this.tyP);
            if (!bh.ov(getIntent().getStringExtra("k_share_url"))) {
                bundle.putString("k_share_url", getIntent().getStringExtra("k_share_url"));
                getIntent().putExtra("k_share_url", "");
            }
            bundle.putInt("key_wallet_region", r4);
            bundle.putString("key_function_id", r3);
            bundle.putInt("webview_binder_id", hashCode());
            bundle.putByteArray("k_a8key_cookie", this.tyR);
            this.tyQ = str;
            boolean z2 = false;
            try {
                z2 = this.juQ.r(233, bundle);
            } catch (Exception e) {
                x.w("MicroMsg.WebViewUI", "startGetA8Key, ex = " + e.getMessage());
            }
            x.i("MicroMsg.WebViewUI", "startGetA8Key, doScene ret = " + z2);
            aj.k bQX = this.trN.bQX();
            int i2 = this.fMy;
            String str2 = this.fGF;
            bQX.fMy = i2;
            bQX.ttb = str2;
            if (bh.ov(str)) {
                x.e("MicroMsg.WebviewReporter", "WebviewGetA8keyReporter.startGetA8Key failed, url is null");
            } else if (!bQX.ttm.containsKey(str)) {
                bQX.ttm.put(str, Long.valueOf(bh.Wp()));
            }
            com.tencent.mm.plugin.report.service.g.pQN.a(154, 11, 1, false);
            return x.tBE;
        }
    }

    private int Pp(String str) {
        int intExtra = getIntent().getIntExtra("geta8key_scene", 0);
        if (intExtra == 0) {
            if (str == null || str.length() <= 0) {
                intExtra = 0;
            } else if (this.juQ == null) {
                intExtra = 1;
            } else {
                try {
                    intExtra = this.juQ.hn(str) ? 8 : this.juQ.gF(str) ? 7 : 1;
                } catch (Exception e) {
                    x.e("MicroMsg.WebViewUI", "getScene fail, ex = " + e.getMessage());
                    intExtra = 1;
                }
            }
        }
        x.i("MicroMsg.WebViewUI", "KGetA8KeyScene = %s", new Object[]{Integer.valueOf(intExtra)});
        return intExtra;
    }

    private boolean Pq(String str) {
        if (bh.ov(str)) {
            x.e("MicroMsg.WebViewUI", "search contact err: null or nill url");
            return false;
        }
        AH(106);
        Bundle bundle = new Bundle();
        bundle.putString("search_contact_data_url", str);
        bundle.putInt("webview_binder_id", hashCode());
        try {
            this.juQ.r(106, bundle);
        } catch (Exception e) {
            x.w("MicroMsg.WebViewUI", "startSearchContact, ex = " + e.getMessage());
        }
        return true;
    }

    private boolean BN(String str) {
        x.i("MicroMsg.WebViewUI", "dealCustomScheme, url = " + str);
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            if (this.juQ.cG(str)) {
                x.i("MicroMsg.WebViewUI", "dealCustomScheme, url is handled by QrCodeURLHelper, url = " + str);
                this.juQ.cx(str, hashCode());
                return true;
            }
        } catch (Exception e) {
            x.w("MicroMsg.WebViewUI", "dealCustomScheme, tryHandleEvents, ex = " + e.getMessage());
        }
        Uri parse = Uri.parse(str);
        if (!(parse == null || str.startsWith("weixin://") || str.startsWith("http"))) {
            String replace;
            if (str.startsWith(com.tencent.smtt.sdk.WebView.SCHEME_TEL)) {
                replace = str.replace(com.tencent.smtt.sdk.WebView.SCHEME_TEL, "");
                if (!bh.ov(replace)) {
                    try {
                        this.juQ.cz(replace, hashCode());
                    } catch (Exception e2) {
                        x.w("MicroMsg.WebViewUI", "showPhoneSpanDialog, ex = %s", new Object[]{e2.getMessage()});
                    }
                }
                return true;
            } else if (str.startsWith("sms:") || str.startsWith("smsto:")) {
                r0 = new Intent("android.intent.action.SENDTO", parse);
                r0.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                try {
                    startActivity(r0);
                } catch (Exception e22) {
                    x.e("MicroMsg.WebViewUI", "start sms app failed:[%s]", new Object[]{e22.getMessage()});
                }
                return true;
            } else {
                try {
                    if (this.juR.bSt().cdz() || this.juQ == null || !this.juQ.aOD()) {
                        int intExtra = getIntent().getIntExtra("key_download_restrict", 0);
                        if (!bh.ov(getIntent().getStringExtra("key_function_id"))) {
                            com.tencent.mm.plugin.report.service.g.pQN.h(14596, new Object[]{r4, Integer.valueOf(intExtra), Integer.valueOf(1)});
                        }
                        if (intExtra == 1) {
                            x.e("MicroMsg.WebViewUI", "not allow launch app by custom scheme : %s", new Object[]{str});
                            return true;
                        }
                        x.i("MicroMsg.WebViewUI", "scheme launch interval ; %d", new Object[]{Long.valueOf(bh.Wo() - this.tAo)});
                        if (bh.Wo() - this.tAo <= 2) {
                            replace = aPk();
                            try {
                                replace = p.encode(replace, "UTF-8");
                                str = p.encode(str, "UTF-8");
                            } catch (Exception e3) {
                                x.i("MicroMsg.WebViewUI", "formate url failed");
                            }
                            com.tencent.mm.plugin.report.service.g.pQN.h(13983, new Object[]{Integer.valueOf(4), replace, str});
                        }
                        if (getIntent().getBooleanExtra("show_openapp_dialog", true)) {
                            return com.tencent.mm.bz.a.post(new 57(this, parse));
                        }
                        r0 = new Intent("android.intent.action.VIEW", parse);
                        r0.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        if (bh.k(this, r0)) {
                            startActivity(r0);
                            return true;
                        }
                    }
                    x.e("MicroMsg.WebViewUI", "dealCustomScheme, not allow outer open url");
                    return true;
                } catch (Throwable e4) {
                    x.printErrStackTrace("MicroMsg.WebViewUI", e4, "", new Object[0]);
                }
            }
        }
        return false;
    }

    private void a(String str, String str2, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        if (!bh.ov(str2)) {
            this.juR.b(str2, jsapiPermissionWrapper, generalControlWrapper);
            this.tzD.remove(str2);
            this.tzF = false;
            this.mFa = str2;
        }
        if (eQ(str, str2)) {
            this.juR.b(str, jsapiPermissionWrapper, generalControlWrapper);
            this.tzD.remove(str);
        } else if (this.juQ != null && !bh.ov(str) && Pl(str)) {
            this.juR.b(str, jsapiPermissionWrapper, generalControlWrapper);
            this.tzD.remove(str);
        }
    }

    public void bSU() {
    }

    protected void b(com.tencent.mm.plugin.webview.stub.c cVar) {
        x.i("MicroMsg.WebViewUI", "onSceneEnd, instance hashcode = " + hashCode());
        if (this.ptK == null) {
            x.w("MicroMsg.WebViewUI", "onSceneEnd, viewWV is null, do nothing");
        } else if (isFinishing() || this.juR == null) {
            x.w("MicroMsg.WebViewUI", "onSceneEnd, isFinishing, do nothing");
        } else {
            String str;
            Bundle data;
            int i = 0;
            int i2 = -1;
            int i3 = -1;
            String str2 = null;
            try {
                i = cVar.getType();
                i2 = cVar.bRK();
                i3 = cVar.bRL();
                str2 = cVar.KM();
                str = str2;
                data = cVar.getData();
            } catch (Exception e) {
                x.e("MicroMsg.WebViewUI", "onSceneEnd, ex = " + e.getMessage());
                str = str2;
                data = null;
            }
            if (data == null) {
                data = new Bundle();
            }
            x.i("MicroMsg.WebViewUI", "get hash code = %d, self hash code = %d", new Object[]{Integer.valueOf(data.getInt("scene_end_listener_hash_code")), Integer.valueOf(hashCode())});
            x.i("MicroMsg.WebViewUI", "edw onSceneEnd, type = " + i + ", errCode = " + i3 + ", errType = " + i2);
            if (data.getInt("scene_end_listener_hash_code") != hashCode()) {
                x.e("MicroMsg.WebViewUI", "hash code not equal");
            } else if (i == 233 || i == 131 || i == 106 || i == 673 || i == 666 || i == 1254 || i == 1373) {
                String str3;
                boolean z;
                y.d dVar;
                switch (i) {
                    case 106:
                        finish();
                        return;
                    case 233:
                        this.tze.bTm();
                        JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper(data.getByteArray("geta8key_result_jsapi_perm_control_bytes"));
                        GeneralControlWrapper generalControlWrapper = new GeneralControlWrapper(data.getInt("geta8key_result_general_ctrl_b1"));
                        this.naL = data.getLong("geta8key_result_deep_link_bit_set", 0);
                        int i4 = data.getInt("geta8key_result_reason");
                        x.i("MicroMsg.WebViewUI", "edw geta8key onSceneEnd, req reason = " + i4);
                        str3 = null;
                        switch (i4) {
                            case 0:
                            case 2:
                            case 8:
                            case 9:
                                if ((i2 != 0 || i3 != 0) && (i2 != 4 || i3 != -2005)) {
                                    g.tyi.AG(i2);
                                    str2 = data.getString("geta8key_result_req_url");
                                    if (!(this.tzy == null || Pl(str2))) {
                                        this.tzy.setVisibility(0);
                                        J(true, true);
                                    }
                                    this.trN.bRc().tsV = false;
                                    this.trN.bQX().aO(str2, false);
                                    com.tencent.mm.plugin.report.service.g.pQN.a(154, 12, 1, false);
                                    i = a.Az(i4);
                                    if (-1 != i) {
                                        com.tencent.mm.plugin.report.service.g.pQN.a(154, (long) i, 1, false);
                                    }
                                    if (this.tyM) {
                                        finish();
                                        break;
                                    }
                                }
                                str3 = data.getString("geta8key_result_full_url");
                                a(data.getString("geta8key_result_req_url"), str3, jsapiPermissionWrapper, generalControlWrapper);
                                V(data);
                                this.tzh = jsapiPermissionWrapper.gn(24);
                                this.trN.bRc().tsV = true;
                                this.tyR = data.getByteArray("geta8key_result_cookie");
                                x.d("MicroMsg.WebViewUI", "processGetA8Key, getA8Key = %s", new Object[]{bh.by(this.tyR)});
                                break;
                                break;
                            case 1:
                            case 5:
                                if (i2 != 0 || i3 != 0) {
                                    if (i2 != 4 || i3 != -2005) {
                                        if (i2 != 0 && i3 == -3300) {
                                            x.e("MicroMsg.WebViewUI", "onSceneEnd errType:%d, errCode:%d, disable iframe getA8Key", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
                                            this.tyS = true;
                                            break;
                                        }
                                        com.tencent.mm.plugin.report.service.g.pQN.a(154, 12, 1, false);
                                        com.tencent.mm.plugin.report.service.g.pQN.a(154, (long) a.Az(i4), 1, false);
                                        J(true, true);
                                        break;
                                    }
                                    this.ptK.stopLoading();
                                    str3 = data.getString("geta8key_result_full_url");
                                    a(data.getString("geta8key_result_req_url"), str3, jsapiPermissionWrapper, generalControlWrapper);
                                    V(data);
                                    this.tyR = data.getByteArray("geta8key_result_cookie");
                                    x.d("MicroMsg.WebViewUI", "processGetA8Key, getA8Key = %s", new Object[]{bh.by(this.tyR)});
                                    break;
                                }
                                str3 = data.getString("geta8key_result_req_url");
                                this.juR.b(str3, jsapiPermissionWrapper, generalControlWrapper);
                                this.tzD.remove(str3);
                                if (this.tzK) {
                                    J(true, true);
                                    this.tzK = false;
                                }
                                if (i4 != 5) {
                                    this.tzh = jsapiPermissionWrapper.gn(24);
                                }
                                this.tyR = data.getByteArray("geta8key_result_cookie");
                                x.d("MicroMsg.WebViewUI", "processGetA8Key, getA8Key = %s", new Object[]{bh.by(this.tyR)});
                                break;
                                break;
                        }
                        K(this.juR.Pj(str3).gn(34), this.juR.Pj(str3).gn(75));
                        bSU();
                        return;
                    case 666:
                        r rVar = this.tzg;
                        rVar.tBB--;
                        if (rVar.tBB <= 0) {
                            rVar.tAv.AI(666);
                        }
                        finish();
                        return;
                    case 673:
                        p pVar = this.tzf;
                        pVar.tBA--;
                        if (pVar.tBA <= 0) {
                            pVar.tAv.AI(673);
                        }
                        if (i2 == 0 && i3 == 0) {
                            str3 = data != null ? data.getString("reading_mode_result_url") : null;
                            x.i("MicroMsg.WebViewUI", "[cpan] onsceneend url:%s", new Object[]{str3});
                            if (bh.ov(str3)) {
                                x.i("MicroMsg.WebViewUI", "[cpan] onsceneend failed");
                                return;
                            } else {
                                this.ptK.loadUrl(str3);
                                return;
                            }
                        }
                        x.i("MicroMsg.WebViewUI", "[cpan] onsceneend failed");
                        return;
                    case 1254:
                        z = i2 == 0 && i3 == 0;
                        com.tencent.mm.plugin.webview.stub.d dVar2 = this.juQ;
                        dVar = this.tAq;
                        y.b bVar = this.tAr;
                        int hashCode = hashCode();
                        x.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd suc: %b", new Object[]{Boolean.valueOf(z)});
                        dVar.aCx();
                        bVar.remove(1254);
                        if (!z) {
                            com.tencent.mm.ui.base.h.a(this, str, ac.getContext().getString(R.l.eXq), new 2(dVar));
                            return;
                        } else if (data == null) {
                            x.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd_Tools resp null");
                            return;
                        } else {
                            z = data.getBoolean("is_recent_has_auth");
                            boolean z2 = data.getBoolean("is_silence_auth");
                            if (z || z2) {
                                str2 = data.getString("redirect_url");
                                if (bh.ov(str2)) {
                                    x.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd redirect null");
                                    return;
                                }
                                x.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeSceneEnd isRecentHasAuth:%b isSilenceAuth:%b redirectUrl:%s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str2});
                                dVar.Oi(str2);
                                return;
                            }
                            y$c$3 com_tencent_mm_plugin_webview_model_y_c_3 = new y$c$3(data, dVar, dVar2, bVar, hashCode);
                            if ((this instanceof WebViewUI) && isFinishing()) {
                                x.i("MicroMsg.OauthAuthorizeLogic", "showWebAuthorizeDialog isFinishing");
                                return;
                            } else {
                                new com.tencent.mm.plugin.webview.ui.tools.widget.h(this).a(y.W((ArrayList) data.getSerializable("scope_list")), data.getString("appname"), data.getString("appicon_url"), getString(R.l.eXA), com_tencent_mm_plugin_webview_model_y_c_3);
                                return;
                            }
                        }
                    case 1373:
                        z = i2 == 0 && i3 == 0;
                        dVar = this.tAq;
                        y.b bVar2 = this.tAr;
                        x.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd suc: %b", new Object[]{Boolean.valueOf(z)});
                        bVar2.remove(1373);
                        if (!z) {
                            com.tencent.mm.ui.base.h.a(this, str, ac.getContext().getString(R.l.eXq), new y$c$4(dVar));
                            return;
                        } else if (data == null) {
                            x.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd resp null");
                            return;
                        } else {
                            str3 = data.getString("redirect_url");
                            if (bh.ov(str3)) {
                                x.e("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirect null");
                                return;
                            }
                            dVar.Oi(str3);
                            x.i("MicroMsg.OauthAuthorizeLogic", "onOauthAuthorizeConfirmSceneEnd redirectUrl: %s", new Object[]{str3});
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    private void K(boolean z, boolean z2) {
        if (z) {
            setMMSubTitle(R.l.eXs);
            if (!this.tyK) {
                int i;
                if (ac.cft().getInt("enter_web_pay_over_time", 2) <= 0) {
                    i = 0;
                } else {
                    i = ac.cfu().getInt("enter_web_pay_over_time", 2);
                    if (i > 0) {
                        Editor edit = ac.cfu().edit();
                        edit.putInt("enter_web_pay_over_time", i - 1);
                        edit.commit();
                    }
                }
                switch (i) {
                    case 1:
                        AM(R.i.dtU);
                        break;
                    case 2:
                        AM(R.i.dtV);
                        break;
                }
                this.tyK = true;
            }
        } else if (z2) {
            setMMSubTitle(R.l.eXD);
        } else {
            setMMSubTitle(null);
        }
    }

    private void AM(int i) {
        x.i("MicroMsg.WebViewUI", "showUserEdPage");
        this.tAs = new com.tencent.mm.ui.base.k(this, R.m.eYY);
        LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) getSystemService("layout_inflater")).inflate(i, null);
        ImageView imageView;
        if (i == R.i.dtU) {
            imageView = (ImageView) linearLayout.findViewById(R.h.coh);
            ImageView imageView2 = (ImageView) linearLayout.findViewById(R.h.cdb);
            try {
                if (this.juQ.bRZ()) {
                    imageView2.setImageResource(R.g.bED);
                } else {
                    imageView2.setImageResource(R.g.bEB);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WebViewUI", e, "", new Object[0]);
            }
            try {
                String OM = this.juQ.OM(this.juQ.aN(2, null));
                if (!bh.ov(OM)) {
                    Bitmap a = com.tencent.mm.sdk.platformtools.d.a(d.Pd(OM), false, 1.0f);
                    if (!(a == null || a.isRecycled())) {
                        imageView.setImageBitmap(a);
                    }
                }
            } catch (RemoteException e2) {
                x.e("MicroMsg.WebViewUI", e2.toString());
            }
        } else if (i == R.i.dtV) {
            imageView = (ImageView) linearLayout.findViewById(R.h.cwa);
            try {
                if (this.juQ.bRZ()) {
                    imageView.setImageResource(R.g.bEE);
                } else {
                    imageView.setImageResource(R.g.bEC);
                }
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.WebViewUI", e3, "", new Object[0]);
            }
        }
        linearLayout.setMinimumWidth(10000);
        TextView textView = (TextView) linearLayout.findViewById(R.h.cwl);
        this.tAs.getWindow();
        this.tAs.setCanceledOnTouchOutside(true);
        this.tAs.setOnDismissListener(new 60(this));
        this.tAs.setOnCancelListener(new 61(this));
        textView.setOnClickListener(new 62(this));
        this.tAs.setContentView(linearLayout);
        this.tAs.show();
    }

    private void n(String str, Map<String, String> map) {
        String az = bh.az(aPk(), this.fIG);
        if (bh.ov(az)) {
            x.e("MicroMsg.WebViewUI", "after getA8Key, currentURL is null or nil, wtf");
            this.ptK.loadUrl(str);
        } else if (this.tlx == null) {
            if (map.size() > 0) {
                this.ptK.loadUrl(str, map);
            } else {
                this.ptK.loadUrl(str);
            }
        } else if (!bh.ou(str).contains("#wechat_redirect")) {
            if (!eQ(az, str)) {
                String OC = com.tencent.mm.plugin.webview.modelcache.p.OC(az);
                String OC2 = com.tencent.mm.plugin.webview.modelcache.p.OC(str);
                Object obj = (bh.ov(OC2) || bh.ov(OC) || !OC2.equals(OC) || this.juQ == null || !Pl(az)) ? null : 1;
                if (obj == null) {
                    if (map.size() > 0) {
                        this.ptK.loadUrl(str, map);
                        return;
                    } else {
                        this.ptK.loadUrl(str);
                        return;
                    }
                }
            }
            this.tzL.put(az, str);
            this.tzG.put(az, map);
            this.tlx.o(str, map);
        } else if (map.size() > 0) {
            this.ptK.loadUrl(str, map);
        } else {
            this.ptK.loadUrl(str);
        }
    }

    private boolean eQ(String str, String str2) {
        if (bh.ov(str) || bh.ov(str2)) {
            return false;
        }
        if (com.tencent.mm.plugin.webview.a.tkS.matcher(str).matches() && com.tencent.mm.plugin.webview.a.tkS.matcher(str2).matches()) {
            String replaceFirst = str.replaceFirst("http://", "").replaceFirst("https://", "");
            int indexOf = replaceFirst.indexOf(35);
            if (indexOf > 0) {
                replaceFirst = replaceFirst.substring(0, indexOf);
            }
            if (str2.replaceFirst("http://", "").replaceFirst("https://", "").startsWith(replaceFirst) && this.juQ != null && Pl(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean V(Bundle bundle) {
        String str;
        x.d("MicroMsg.WebViewUI", "[cpan] process a8 key:%d", new Object[]{Long.valueOf(System.currentTimeMillis())});
        int i = bundle.getInt("geta8key_result_action_code");
        String string = bundle.getString("geta8key_result_title");
        String string2 = bundle.getString("geta8key_result_full_url");
        String string3 = bundle.getString("geta8key_result_content");
        String string4 = bundle.getString("geta8key_result_req_url");
        String[] stringArray = bundle.getStringArray("geta8key_result_http_header_key_list");
        String[] stringArray2 = bundle.getStringArray("geta8key_result_http_header_value_list");
        if (getIntent().getBooleanExtra("k_has_http_header", false) && (stringArray == null || stringArray.length == 0 || stringArray2 == null || stringArray2.length == 0)) {
            x.i("MicroMsg.WebViewUI", "use intent httpheader info");
            getIntent().putExtra("k_has_http_header", false);
            stringArray = getIntent().getStringArrayExtra("geta8key_result_http_header_key_list");
            stringArray2 = getIntent().getStringArrayExtra("geta8key_result_http_header_value_list");
            getIntent().putStringArrayListExtra("geta8key_result_http_header_key_list", null);
            getIntent().putStringArrayListExtra("geta8key_result_http_header_value_list", null);
        }
        x.i("MicroMsg.WebViewUI", "processGetA8Key, actionCode = %d, title = %s, fullUrl = %s, content = %s", new Object[]{Integer.valueOf(i), string, string2, string3});
        Map hashMap = new HashMap();
        if (stringArray != null && stringArray2 != null && stringArray.length > 0 && stringArray2.length > 0 && stringArray.length == stringArray2.length) {
            for (int i2 = 0; i2 < stringArray.length; i2++) {
                hashMap.put(stringArray[i2], stringArray2[i2]);
            }
        }
        this.tzH = hashMap;
        if (bh.ov(string2)) {
            str = string4;
        } else {
            str = string2;
        }
        aj.H(this.ptK.isX5Kernel, bh.ou(str).startsWith("https://"));
        this.trN.bQX().aO(string4, true);
        aj.e bQZ = this.trN.bQZ();
        int i3 = this.fMy;
        String str2 = this.fGF;
        bQZ.fMy = i3;
        bQZ.ttb = str2;
        if (bh.ov(string2)) {
            x.e("MicroMsg.WebviewReporter", "WebViewRenderReporter.onPageStart failed, url is null");
        } else {
            bQZ.jIW = string2;
            bQZ.tta = true;
            if (!bQZ.tsY.containsKey(string2)) {
                bQZ.tsY.put(string2, Long.valueOf(bh.Wp()));
            }
            if (!bQZ.tsZ.containsKey(string2)) {
                bQZ.tsZ.put(string2, Long.valueOf(bh.Wp()));
            }
        }
        switch (i) {
            case 1:
                x.i("MicroMsg.WebViewUI", "getA8key-text: " + string3);
                if (string3 == null || string3.length() == 0) {
                    x.e("MicroMsg.WebViewUI", "getA8key-text fail, invalid content");
                    return false;
                }
                this.ptK.getSettings().setJavaScriptEnabled(false);
                this.ptK.loadData(string3, "text/html", ProtocolPackage.ServerEncoding);
                return true;
            case 2:
                x.i("MicroMsg.WebViewUI", "getA8key-webview: title = " + string + ", fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    x.e("MicroMsg.WebViewUI", "getA8key-webview fail, invalid fullUrl");
                    return false;
                }
                if (string != null && string.length() > 0) {
                    setMMTitle(string);
                }
                if (Pr(string2)) {
                    n(string2, hashMap);
                    return true;
                }
                x.f("MicroMsg.WebViewUI", "processGetA8Key qrcode, canLoadUrl fail, url = " + string2);
                aPf();
                return true;
            case 3:
                x.i("MicroMsg.WebViewUI", "getA8key-app: " + string2);
                if (string2 != null && string2.length() != 0) {
                    return BN(string2);
                }
                x.e("MicroMsg.WebViewUI", "getA8key-app, fullUrl is null");
                return false;
            case 4:
                return Pq(string2);
            case 6:
                x.i("MicroMsg.WebViewUI", "getA8key-special_webview: fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    x.e("MicroMsg.WebViewUI", "getA8key-special_webview fail, invalid fullUrl");
                    return false;
                } else if (Pr(string2)) {
                    this.ptK.loadUrl(string2);
                    kt(false);
                    return true;
                } else {
                    x.f("MicroMsg.WebViewUI", "processGetA8Key special, canLoadUrl fail, url = " + string2);
                    aPf();
                    return true;
                }
            case 7:
                x.i("MicroMsg.WebViewUI", "getA8key-webview_no_notice: title = " + string + ", fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    x.e("MicroMsg.WebViewUI", "getA8key-webview_no_notice fail, invalid fullUrl");
                    return false;
                }
                if (string != null && string.length() > 0) {
                    setMMTitle(string);
                }
                if (Pr(string2)) {
                    n(string2, hashMap);
                    return true;
                }
                x.f("MicroMsg.WebViewUI", "processGetA8Key qrcode no notice, canLoadUrl fail, url = " + string2);
                aPf();
                return true;
            case 20:
                if (bh.ov(string2)) {
                    x.e("MicroMsg.WebViewUI", "doJumpEmotionDetailUrlScene err: null or nill url");
                } else {
                    r rVar = this.tzg;
                    if (rVar.tBB == 0) {
                        rVar.tAv.AH(666);
                    }
                    rVar.tBB++;
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("emoji_store_jump_url", string2);
                    bundle2.putInt("webview_binder_id", hashCode());
                    try {
                        this.juQ.r(666, bundle2);
                    } catch (Exception e) {
                        x.w("MicroMsg.WebViewUI", "startSearchContact, ex = " + e.getMessage());
                    }
                }
                return true;
            default:
                x.i("MicroMsg.WebViewUI", "qrcode-getA8key-not_catch: action code = " + i);
                return false;
        }
    }

    public boolean bSV() {
        return false;
    }

    public boolean bSW() {
        return false;
    }

    private int bSX() {
        float f = this.mController.xIM.getSharedPreferences(ac.cfs(), 0).getFloat("current_text_size_scale_key", 1.0f);
        if (f == 0.875f) {
            return 1;
        }
        if (f == 1.125f) {
            return 3;
        }
        if (f == 1.25f || f == 1.375f || f == 1.625f) {
            return 4;
        }
        return 2;
    }

    private void AN(int i) {
        if (i <= 0 || i > 4) {
            i = 2;
        }
        if (this.tlx != null) {
            com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar = this.tlx;
            if (dVar.tGQ) {
                Map hashMap = new HashMap();
                hashMap.put("fontSize", String.valueOf(i));
                dVar.tGK.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:setfont", hashMap, dVar.tGS, dVar.tGT) + ")", null);
            } else {
                x.e("MicroMsg.JsApiHandler", "onFontSizeChanged fail, not ready");
            }
        }
        FontChooserView fontChooserView = (FontChooserView) this.tys.findViewById(R.h.ciV);
        if (fontChooserView != null) {
            fontChooserView.qmR = i - 1;
        }
    }

    private void AO(int i) {
        if (this.ptK != null && this.ptK.getSettings() != null) {
            x.i("MicroMsg.WebViewUI", "localSetFontSize, fontSize = " + i);
            switch (i) {
                case 1:
                    this.ptK.getSettings().a(com.tencent.xweb.n.a.Aqo);
                    return;
                case 3:
                    this.ptK.getSettings().a(com.tencent.xweb.n.a.Aqq);
                    return;
                case 4:
                    this.ptK.getSettings().a(com.tencent.xweb.n.a.Aqr);
                    return;
                default:
                    this.ptK.getSettings().a(com.tencent.xweb.n.a.Aqp);
                    return;
            }
        }
    }

    private final boolean Pr(String str) {
        if (com.tencent.mm.platformtools.r.idq) {
            x.w("MicroMsg.WebViewUI", "skipLoadUrlCheck");
            return true;
        } else if (bh.ov(str)) {
            return true;
        } else {
            if (this.tyC) {
                x.i("MicroMsg.WebViewUI", "albie: trust this url(%s)", new Object[]{str});
                return true;
            }
            String toLowerCase = str.toLowerCase();
            if (!toLowerCase.startsWith("file://")) {
                return true;
            }
            for (String eE : tsq) {
                if (s.eE(toLowerCase, eE)) {
                    return true;
                }
            }
            return false;
        }
    }

    @TargetApi(11)
    private void bSY() {
        if (com.tencent.mm.compatible.util.d.fN(11)) {
            x.i("MicroMsg.WebViewUI", "removeConfigJsInterface, api level too low");
        } else if (this.ptK == null || this.juQ == null) {
            x.i("MicroMsg.WebViewUI", "viewwv is null or invoker is null");
        } else {
            int i;
            try {
                this.ptK.removeJavascriptInterface("searchBoxJavaBridge_");
            } catch (Exception e) {
                x.e("MicroMsg.WebViewUI", "removeConfigJsInterface, ex = %s", new Object[]{e.getMessage()});
            }
            if (this.tAt == null) {
                try {
                    if (this.juQ.aOD()) {
                        this.tAt = this.juQ.bRQ();
                    }
                } catch (Exception e2) {
                    x.e("MicroMsg.WebViewUI", "getRemoveJsInterfaceList, ex = %s", new Object[]{e2.getMessage()});
                }
            }
            String str = "MicroMsg.WebViewUI";
            String str2 = "removeConfigJsInterface, to remove list size = %d";
            Object[] objArr = new Object[1];
            if (this.tAt == null) {
                i = 0;
            } else {
                i = this.tAt.length;
            }
            objArr[0] = Integer.valueOf(i);
            x.i(str, str2, objArr);
            if (this.tAt != null && this.tAt.length != 0) {
                try {
                    for (String str3 : this.tAt) {
                        x.i("MicroMsg.WebViewUI", "removeConfigJsInterface, js interface name = %s", new Object[]{str3});
                        this.ptK.removeJavascriptInterface(str3);
                    }
                } catch (Exception e22) {
                    x.e("MicroMsg.WebViewUI", "removeConfigJsInterface, ex = %s", new Object[]{e22.getMessage()});
                }
            }
        }
    }

    public final void aPG() {
        x.i("MicroMsg.WebViewUI", "doKeepPageTopLogic");
        getIntent().putExtra("is_from_keep_top", true);
        if (this.ptK != null) {
            com.tencent.mm.ui.snackbar.a.h(this.mController.xIM, getString(R.l.eBS));
            if (getIntent().getIntExtra("keep_top_scene", 0) == 2) {
                eR(getIntent().getStringExtra("custom_keep_top_url"), getIntent().getStringExtra("custom_keep_top_title"));
            } else {
                eR(this.ptK.getUrl(), String.valueOf(this.mController.getMMTitle()));
            }
        }
    }

    public final void aPH() {
        eR(null, null);
        com.tencent.mm.ui.snackbar.a.h(this.mController.xIM, getString(R.l.eBN));
    }

    private void eR(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("key_last_page", str);
        bundle.putString("key_last_page_title", str2);
        bundle.putInt("key_keep_top_scene", getIntent().getIntExtra("keep_top_scene", 0));
        try {
            this.juQ.e(82, bundle);
        } catch (RemoteException e) {
            x.e("MicroMsg.WebViewUI", "keepLastPage exp=%s", new Object[]{e.getLocalizedMessage()});
        }
    }

    public final boolean Vb() {
        x.i("MicroMsg.WebViewUI", "hasKeepLastPageTop KIsFromKeepTop=%b", new Object[]{Boolean.valueOf(t.a(getIntent(), "is_from_keep_top", false))});
        if (!t.a(getIntent(), "is_from_keep_top", false)) {
            return false;
        }
        try {
            x.i("MicroMsg.WebViewUI", "hasKeepLastPageTop hasKeep=%b", new Object[]{Boolean.valueOf(this.juQ.e(89, new Bundle()).getBoolean("key_is_webview_keep_top", true))});
            return this.juQ.e(89, new Bundle()).getBoolean("key_is_webview_keep_top", true);
        } catch (RemoteException e) {
            x.e("MicroMsg.WebViewUI", "hasKeepLastPageTop exp=%s", new Object[]{e.getLocalizedMessage()});
            return true;
        }
    }

    public final boolean aPo() {
        if (this.tzv != null) {
            boolean z;
            d dVar = this.tzv;
            if (bh.ov(dVar.tBu)) {
                z = false;
            } else {
                z = dVar.tBu.equals("true");
            }
            if (!(!z || bh.ov(this.tzv.aOS()) || bh.ov(this.tzv.aOT()) || bh.ov(this.tzv.aOU()))) {
                x.i("MicroMsg.WebViewUI", "use js api close window confirm info : %s, %s, %s", new Object[]{this.tzv.aOS(), this.tzv.aOT(), this.tzv.aOU()});
                View inflate = View.inflate(this.mController.xIM, R.i.dnm, null);
                CheckBox checkBox = (CheckBox) inflate.findViewById(R.h.cwc);
                checkBox.setChecked(false);
                checkBox.setVisibility(8);
                TextView textView = (TextView) inflate.findViewById(R.h.cwe);
                textView.setText(r6);
                textView.setTextColor(getResources().getColor(R.e.btv));
                textView = (TextView) inflate.findViewById(R.h.cwd);
                textView.setTextColor(getResources().getColor(R.e.btv));
                textView.setVisibility(8);
                this.tzw = com.tencent.mm.ui.base.h.a(this.mController.xIM, true, "", inflate, r4, r5, new 64(this, checkBox), new 65(this));
                return true;
            }
        }
        return false;
    }

    private void bSZ() {
        if (this.ptK != null) {
            if (getIntent().getIntExtra("keep_top_scene", 0) == 2) {
                x.i("MicroMsg.WebViewUI", "updateKeepTopPage: SCENE_CUSTOM_TOP_URL no update");
            } else if (Vb()) {
                eR(this.ptK.getUrl(), String.valueOf(this.mController.getMMTitle()));
            }
        }
    }

    public void hb(boolean z) {
    }

    public void h(int i, Bundle bundle) {
    }

    public boolean bTa() {
        return true;
    }

    public void s(int i, Bundle bundle) {
        x.i("MicroMsg.WebViewUI", "handleEmojiStoreAction");
    }

    protected static void bTb() {
    }

    public final void kw(boolean z) {
        String url = this.ptK.getUrl();
        if (z) {
            showOptionMenu(0, false);
            this.tzt.put(url, Boolean.valueOf(true));
            return;
        }
        showOptionMenu(0, true);
        if (this.tzt.containsKey(url)) {
            this.tzt.remove(url);
        }
    }

    public final boolean bTc() {
        if (this.tAu == -3) {
            return false;
        }
        showVKB();
        return true;
    }

    public final void aWs() {
        super.aWs();
        this.tAu = -2;
    }

    public final void showVKB() {
        super.showVKB();
        if (this.tAu == -3) {
            this.tAu = -2;
        } else {
            this.tAu = -3;
        }
    }

    public final void setBackBtn(OnMenuItemClickListener onMenuItemClickListener, int i) {
        super.setBackBtn(onMenuItemClickListener, i);
        if (com.tencent.mm.compatible.util.d.fM(21) && aRw()) {
            cmV();
        }
    }

    public void bTd() {
    }
}
