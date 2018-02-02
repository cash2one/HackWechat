package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.mm.R;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.game.c.dw;
import com.tencent.mm.plugin.game.gamewebview.d.a;
import com.tencent.mm.plugin.game.gamewebview.e.b;
import com.tencent.mm.plugin.game.gamewebview.ipc.CommonLogicTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameMMToClientEvent;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ak;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.model.aa;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.plugin.webview.modeltools.c;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.plugin.webview.ui.tools.f;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.WebViewSearchContentInputFooter;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.akj;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.xg;
import com.tencent.mm.protocal.c.xh;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.v;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.xweb.WebView;
import com.tencent.xweb.j;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class d extends FrameLayout {
    private static final Pattern mZA = Pattern.compile("\"\\s*rgb\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    private static final Pattern mZz = Pattern.compile("\"\\s*rgba\\(\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*,\\s*[0-9]+\\s*\\)\\s*\"");
    String gAb;
    private LinearLayout jCT;
    boolean jDU = false;
    public int jDW;
    public String jDY = "";
    j jFi;
    private MMFalseProgressBar juF;
    private View kK;
    boolean lut = false;
    public af mHandler;
    public String mXZ;
    a mYG;
    public b mYH;
    public e mYI;
    private WebViewKeyboardLinearLayout mYJ;
    private FrameLayout mYK;
    f mYL;
    com.tencent.mm.plugin.game.gamewebview.jsapi.d mYM;
    public b mYN;
    public WebViewInputFooter mYO;
    WebViewSearchContentInputFooter mYP;
    private FrameLayout mYQ;
    MovingImageButton mYR;
    ProgressBar mYS;
    GameMenuImageButton mYT;
    private CustomViewCallback mYU;
    private ProgressBar mYV;
    public e mYW;
    public long mYX = 0;
    private com.tencent.mm.plugin.webview.ui.tools.b mYY;
    com.tencent.mm.plugin.webview.wepkg.a mYZ;
    public GameWebViewUI mYx;
    public boolean mZB = false;
    private com.tencent.mm.plugin.game.gamewebview.model.f mZa;
    private Set<String> mZb;
    private boolean mZc;
    public String mZd;
    public String mZe;
    final c mZf = new c();
    public int mZg;
    public boolean mZh;
    private String mZi;
    private boolean mZj = true;
    boolean mZk = false;
    private Map<String, String> mZl = new HashMap();
    public h mZm;
    public boolean mZn;
    b.a mZo;
    private boolean mZp = true;
    public int mZq;
    String mZr;
    private int mZs = 0;
    com.tencent.xweb.f mZt;
    private boolean mZu;
    String mZv;
    public com.tencent.mm.plugin.webview.ui.tools.game.c mZw = new 1(this);
    public final HashMap<String, String> mZx = new HashMap();
    public final HashMap<String, com.tencent.mm.plugin.webview.ui.tools.jsapi.c.d> mZy = new HashMap();
    public int scene = 0;
    public Bundle vf;

    class AnonymousClass20 implements Runnable {
        final /* synthetic */ d mZC;
        final /* synthetic */ String mZG;
        final /* synthetic */ int mZH;

        public AnonymousClass20(d dVar, String str, int i) {
            this.mZC = dVar;
            this.mZG = str;
            this.mZH = i;
        }

        public final void run() {
            if (!bh.ov(this.mZG)) {
                this.mZC.mYO.setText(this.mZG);
            }
            if (this.mZH >= 0) {
                this.mZC.mYO.Bg(this.mZH);
            }
            this.mZC.mYO.show();
        }
    }

    static /* synthetic */ void a(d dVar, int i, int i2, com.tencent.mm.ae.b bVar) {
        if (dVar.mYx.isFinishing()) {
            x.e("MicroMsg.GameWebPageView", "activity is finish, processGetA8Key return");
            return;
        }
        dVar.fx(true);
        dVar.mZh = false;
        xg xgVar = (xg) bVar.hmg.hmo;
        xh xhVar = (xh) bVar.hmh.hmo;
        int i3 = xhVar.whN != null ? xhVar.whN.wht : 0;
        dVar.mYX = xhVar.whS != null ? xhVar.whS.vYH : -1;
        JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper(n.a(xhVar.whT));
        GeneralControlWrapper generalControlWrapper = new GeneralControlWrapper(i3);
        bdo com_tencent_mm_protocal_c_bdo = xgVar.why;
        String str = "";
        if (com_tencent_mm_protocal_c_bdo != null) {
            str = com_tencent_mm_protocal_c_bdo.toString();
        }
        dVar.mZb.remove(str);
        if (!bh.ov(xhVar.whO)) {
            String str2 = xhVar.whK;
            String str3 = xhVar.whO;
            if (!bh.ov(str2)) {
                dVar.mZl.put(str2, str3);
            }
            dVar.mZl.put(str, str3);
        }
        if ((i == 0 && i2 == 0) || (i == 4 && i2 == -2005)) {
            dVar.mYG.fu(true);
        } else {
            dVar.mYG.fu(false);
        }
        switch (xgVar.whD) {
            case 0:
            case 2:
                if ((i == 0 && i2 == 0) || (i == 4 && i2 == -2005)) {
                    dVar.a(str, xhVar.whK, jsapiPermissionWrapper, generalControlWrapper);
                    dVar.a(xhVar);
                    return;
                }
                if (!(dVar.mYQ == null || dVar.aPg())) {
                    dVar.mYQ.setVisibility(0);
                }
                if (dVar.vf.getBoolean("finishviewifloadfailed", false)) {
                    dVar.fz(false);
                    return;
                }
                return;
            case 1:
            case 5:
                if (i == 0 && i2 == 0) {
                    dVar.a(str, jsapiPermissionWrapper, generalControlWrapper);
                    return;
                } else if (i == 4 && i2 == -2005) {
                    dVar.mYN.stopLoading();
                    dVar.a(str, xhVar.whK, jsapiPermissionWrapper, generalControlWrapper);
                    dVar.a(xhVar);
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    static /* synthetic */ void a(d dVar, WebViewKeyboardLinearLayout webViewKeyboardLinearLayout, int i) {
        if (dVar.mYN.getX5WebViewExtension() == null && VERSION.SDK_INT < 19) {
            return;
        }
        if (i == -3) {
            dVar.mHandler.post(new 12(dVar, webViewKeyboardLinearLayout.txF));
            return;
        }
        dVar.mHandler.post(new 13(dVar));
    }

    static /* synthetic */ boolean aPp() {
        GWMainProcessTask commonLogicTask = new CommonLogicTask();
        commonLogicTask.type = 4;
        GameWebViewMainProcessService.b(commonLogicTask);
        return commonLogicTask.msB.getBoolean("allowDownloadFile", true);
    }

    static /* synthetic */ void d(d dVar, String str) {
        if (dVar.mZg != 0) {
            Map hashMap = new HashMap();
            hashMap.put("text", str);
            dVar.E(dVar.mZg, com.tencent.mm.plugin.game.gamewebview.a.d.e("showKeyboard:ok", hashMap));
        }
    }

    public d(b bVar) {
        super(bVar.getContext());
        x.i("MicroMsg.GameWebPageView", "onCreate");
        this.mYH = bVar;
        this.mHandler = new af();
        this.mYx = (GameWebViewUI) bVar.getContext();
        this.jCT = new LinearLayout(getContext());
        this.jCT.setLayoutParams(new LayoutParams(-1, -1));
        this.jCT.setOrientation(1);
        addView(this.jCT);
        this.mYI = new e(this.mYH);
        this.jCT.addView(this.mYI);
        View inflate = v.fv(getContext()).inflate(R.i.dlq, this, false);
        this.jCT.addView(inflate, new LayoutParams(-1, -1));
        this.mYJ = (WebViewKeyboardLinearLayout) inflate.findViewById(R.h.cnu);
        this.mYL = new f();
        this.mYL.cU(inflate);
        this.mYM = new com.tencent.mm.plugin.game.gamewebview.jsapi.d(this);
        com.tencent.mm.plugin.game.gamewebview.jsapi.d dVar = this.mYM;
        com.tencent.mm.pluginsdk.model.x.a.ef(this.mYx);
        this.mYN = new b(this.mYx, this);
        this.mYN.addJavascriptInterface(dVar, "WXGameJsCore");
        this.mYN.setWebViewClient(new 33(this));
        this.jFi = new 34(this);
        this.mYN.setWebChromeClient(this.jFi);
        this.mYN.setOnTouchListener(new 35(this));
        if (this.mYN.isX5Kernel) {
            this.mYN.setWebViewCallbackClient(new f(this) {
                final /* synthetic */ d mZC;

                {
                    this.mZC = r1;
                }

                public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
                }
            });
            this.mYN.naA = new 3(this);
        }
        this.mYN.setDownloadListener(new DownloadListener(this) {
            final /* synthetic */ d mZC;

            {
                this.mZC = r1;
            }

            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                int i = 1;
                x.i("MicroMsg.GameWebPageView", "onDownloadStart called, url = %s, mimeType = %s, userAgent = %s", new Object[]{str, str4, str2});
                if (this.mZC.mYW != null) {
                    JsapiPermissionWrapper Pj = this.mZC.mYW.Pj(this.mZC.aPk());
                    if (Pj != null) {
                        if (str4 != null) {
                            x.i("MicroMsg.GameWebPageView", "onDownloadStart configOpen:%s", new Object[]{Boolean.valueOf(d.aPp())});
                            CharSequence BC = com.tencent.mm.plugin.game.gamewebview.a.d.BC(str3);
                            int i2 = (BC == null || !Pattern.matches("(?i).*\\.(doc|ppt|xls|docx|pptx|xlsx|wps|dps|et|txt|pdf)$", BC)) ? 0 : 1;
                            boolean contains = com.tencent.mm.plugin.webview.ui.tools.jsapi.a.tGw.contains(str4.toLowerCase());
                            if (!r4 || (i2 == 0 && !contains)) {
                                i = 0;
                            }
                        } else {
                            i = 0;
                        }
                        if (i != 0 || Pj.gn(24)) {
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            try {
                                this.mZC.mYx.startActivity(intent);
                                return;
                            } catch (Exception e) {
                                x.e("MicroMsg.GameWebPageView", "startActivity fail, e = " + e.getMessage());
                                return;
                            }
                        }
                        x.e("MicroMsg.GameWebPageView", "onDownloadStart permission fail");
                        return;
                    }
                }
                x.e("MicroMsg.GameWebPageView", "onDownloadStart fail, mWebViewPermission is null");
            }
        });
        this.mYL.b(this.mYN);
        this.mYK = (FrameLayout) inflate.findViewById(R.h.bYF);
        this.mYO = (WebViewInputFooter) inflate.findViewById(R.h.cYM);
        this.mYO.hide();
        this.mYO.tKS = new 6(this);
        this.mYO.tKT = new 7(this);
        this.mYO.tKU = new 8(this);
        this.mYP = (WebViewSearchContentInputFooter) inflate.findViewById(R.h.cJy);
        this.mYP.tKQ = new WebViewSearchContentInputFooter.a(this) {
            final /* synthetic */ d mZC;

            {
                this.mZC = r1;
            }

            public final void aPu() {
                this.mZC.mYN.setPadding(this.mZC.mYN.getPaddingLeft(), this.mZC.mYN.getPaddingTop(), this.mZC.mYN.getPaddingRight(), 0);
                this.mZC.mYN.clearMatches();
                this.mZC.mYP.bUR();
            }

            public final void a(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
                if (webViewSearchContentInputFooter.getVisibility() == 0) {
                    b(webViewSearchContentInputFooter);
                }
            }

            public final void aPv() {
                g.pQN.a(608, 5, 1, false);
                this.mZC.mYN.findNext(false);
            }

            public final void aPw() {
                g.pQN.a(608, 4, 1, false);
                this.mZC.mYN.findNext(true);
            }

            public final void b(WebViewSearchContentInputFooter webViewSearchContentInputFooter) {
                this.mZC.mYN.clearMatches();
                webViewSearchContentInputFooter.reset();
                this.mZC.mYP.o(0, 0, true);
                this.mZC.mZc = false;
                this.mZC.mYN.findAllAsync(webViewSearchContentInputFooter.bUS());
            }

            public final boolean c(int i, KeyEvent keyEvent) {
                if (i == 67 && keyEvent.getAction() == 0) {
                    g.pQN.a(608, 6, 1, false);
                }
                return false;
            }

            public final void onShow() {
                this.mZC.mYN.setPadding(this.mZC.mYN.getPaddingLeft(), this.mZC.mYN.getPaddingTop(), this.mZC.mYN.getPaddingRight(), this.mZC.mYP.getHeight());
            }
        };
        this.mYN.setFindListener(new 10(this));
        this.mYQ = (FrameLayout) inflate.findViewById(R.h.cHe);
        if (this.mYQ != null) {
            this.mYQ.setOnClickListener(new 31(this));
        }
        this.juF = (MMFalseProgressBar) inflate.findViewById(R.h.cYD);
        this.mYR = (MovingImageButton) inflate.findViewById(R.h.ckl);
        this.mYR.setOnClickListener(new 32(this));
        this.mYS = (ProgressBar) inflate.findViewById(R.h.bZM);
        this.mYJ.xGO = new 11(this);
        com.tencent.mm.plugin.game.gamewebview.model.a.a(this);
        GameMMToClientEvent.qC(hashCode());
        this.mYW = new e(this.mYx, this.mYN);
        this.mZb = new HashSet();
        this.mZm = new h(this.mYx, this.mYN, this.mYW);
        this.mYG = new a(this);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        x.d("MicroMsg.GameWebPageView", "onLayout, changed = %b, left = %d", new Object[]{Boolean.valueOf(z), Integer.valueOf(i)});
        super.onLayout(z, i, i2, i3, i4);
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z;
        if (i == 4) {
            try {
                if (this.kK == null || this.mYU == null || this.jFi == null) {
                    z = false;
                } else {
                    this.jFi.onHideCustomView();
                    z = true;
                }
                if (z) {
                    return true;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.GameWebPageView", e, "onkeydown", new Object[0]);
                return true;
            }
        }
        if (i == 4) {
            if (this.mYO == null || !this.mYO.isShown()) {
                z = false;
            } else {
                this.mYO.hide();
                z = true;
            }
            if (z) {
                return true;
            }
        }
        if (i != 4 || !this.mYN.canGoBack() || !this.mZp) {
            return false;
        }
        this.mZi = "";
        this.mYN.goBack();
        return true;
    }

    public final void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            this.mHandler.post(runnable);
        }
    }

    final void BL(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("state", str);
            cH("activity:state_change", jSONObject.toString());
        } catch (Exception e) {
            x.e("MicroMsg.GameWebviewJsLoader", "onActivityStateChanged, e:" + e.getMessage());
        }
    }

    final void BM(String str) {
        if (this.mYN != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.mYN, new Object[0]);
            } catch (NoSuchMethodException e) {
                x.e("MicroMsg.GameWebPageView", "No such method: " + str + ", " + e.toString());
            } catch (IllegalAccessException e2) {
                x.e("MicroMsg.GameWebPageView", "Illegal Access: " + str + ", " + e2.toString());
            } catch (InvocationTargetException e3) {
                x.e("MicroMsg.GameWebPageView", "Invocation Target Exception: " + str + ", " + e3.toString());
            } catch (Exception e4) {
                x.e("MicroMsg.GameWebPageView", "Exception : " + str + ", " + e4.toString());
            }
        }
    }

    final void aPd() {
        Uri parse = Uri.parse(this.mXZ);
        if (parse == null) {
            x.e("MicroMsg.GameWebPageView", "uri is null");
            return;
        }
        if (parse.getScheme() == null) {
            this.mXZ = "http://" + this.mXZ;
        } else if (!parse.getScheme().startsWith("http")) {
            x.i("MicroMsg.GameWebPageView", "uri scheme not startwith http, scheme = " + parse.getScheme());
            if (aa.Oj(this.mXZ)) {
                this.mYN.loadUrl(this.mXZ);
                return;
            }
            x.f("MicroMsg.GameWebPageView", "canLoadUrl fail, url = " + this.mXZ);
            aPf();
            return;
        }
        if (this.mZk) {
            x.i("MicroMsg.GameWebPageView", "initView, no need to geta8key, loadUrl directly, neverGetA8Key = " + this.mZk);
            if (!aa.Oj(this.mXZ)) {
                x.f("MicroMsg.GameWebPageView", "postBinded 2, canLoadUrl fail, url = " + this.mXZ);
                aPf();
                return;
            } else if (aPg()) {
                aPi();
                BO(this.mXZ);
                return;
            } else {
                this.mYN.loadUrl(this.mXZ);
                return;
            }
        }
        if (aPg()) {
            BO(this.mXZ);
            this.mZd = this.mXZ;
            aPi();
        }
        if (!(this.mYx.isFinishing())) {
            x.i("MicroMsg.GameWebPageView", "not call onDestory, try to geta8key again");
            f(this.mXZ, false, -1);
            x.i("MicroMsg.GameWebPageView", "before geta8key, rawUrl = " + this.mXZ);
        }
    }

    final JSONObject aPe() {
        JSONObject jSONObject = new JSONObject();
        try {
            String string = this.vf.getString("geta8key_username");
            if (!bh.ov(this.vf.getString("srcUsername"))) {
                jSONObject.put("srcUsername", this.vf.getString("srcUsername"));
                jSONObject.put("srcDisplayname", this.vf.getString("srcDisplayname"));
            } else if (!bh.ov(string)) {
                jSONObject.put("srcUsername", string);
            }
            jSONObject.put("message_id", this.vf.getLong("message_id", 0));
            jSONObject.put("message_index", this.vf.getInt("message_index", 0));
            jSONObject.put("scene", com.tencent.mm.plugin.game.gamewebview.a.d.ak(this.scene, string));
            jSONObject.put("pay_channel", this.vf.getInt("pay_channel", 0));
            jSONObject.put("stastic_scene", this.vf.getInt("stastic_scene", 0));
            jSONObject.put("from_scence", this.vf.getInt("from_scence", 0));
            if (!bh.ov(this.vf.getString("KTemplateId"))) {
                jSONObject.put("KTemplateId", this.vf.getString("KTemplateId"));
            }
        } catch (Exception e) {
            x.e("MicroMsg.GameWebPageView", e.getMessage());
        }
        return jSONObject;
    }

    public final void qG(int i) {
        this.mYI.setVisibility(i);
    }

    private boolean BN(String str) {
        x.i("MicroMsg.GameWebPageView", "dealCustomScheme, url = " + str);
        if (str == null || str.length() == 0) {
            return false;
        }
        Uri parse = Uri.parse(str);
        if (!(parse == null || str.startsWith("weixin://") || str.startsWith("http"))) {
            if (str.startsWith(com.tencent.smtt.sdk.WebView.SCHEME_TEL)) {
                return true;
            }
            Intent intent;
            if (str.startsWith("sms:") || str.startsWith("smsto:")) {
                intent = new Intent("android.intent.action.SENDTO", parse);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                try {
                    this.mYx.startActivity(intent);
                    return true;
                } catch (Exception e) {
                    x.e("MicroMsg.GameWebPageView", "start sms app failed:[%s]", new Object[]{e.getMessage()});
                    return true;
                }
            } else if (this.mYW == null || !this.mYW.bSt().cdz()) {
                return true;
            } else {
                if (this.mYx.getIntent().getBooleanExtra("show_openapp_dialog", true)) {
                    return com.tencent.mm.bz.a.post(new 5(this, parse));
                }
                intent = new Intent("android.intent.action.VIEW", parse);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                if (bh.k(this.mYx, intent)) {
                    this.mYx.startActivity(intent);
                    return true;
                }
            }
        }
        return false;
    }

    protected final void BO(String str) {
        Map hashMap = new HashMap(2);
        hashMap.put("Pragma", "no-cache");
        hashMap.put("Cache-Control", "no-cache");
        this.mYN.loadUrl(str, hashMap);
    }

    public final void qH(int i) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.mYO.getLayoutParams();
        if (marginLayoutParams.bottomMargin != i) {
            marginLayoutParams.bottomMargin = i;
            this.mYO.setLayoutParams(marginLayoutParams);
        }
    }

    private void f(String str, boolean z, int i) {
        if (this.mYx.isFinishing()) {
            x.e("MicroMsg.GameWebPageView", "activity is finished");
        } else if (this.mYW == null) {
            x.e("MicroMsg.GameWebPageView", "mWebViewPermission is null");
        } else if ((this.mYW.has(str) || this.mZb.contains(str)) && !z) {
            x.i("MicroMsg.GameWebPageView", "startGetA8Key no need, has url");
        } else {
            if (this.mZa == null) {
                this.mZa = new com.tencent.mm.plugin.game.gamewebview.model.f(this.mXZ, new 14(this));
            }
            x.i("MicroMsg.GameWebPageView", "startGetA8Key, url = %s", new Object[]{str});
            this.mZb.add(str);
            a(str, null, null);
            this.mZh = true;
            this.mZi = str;
            com.tencent.mm.plugin.game.gamewebview.model.f fVar = this.mZa;
            String str2 = this.gAb;
            int i2 = this.mZq;
            int i3 = this.mYN.getX5WebViewExtension() != null ? 1 : 0;
            String bQV = aj.bQV();
            int i4 = this.vf.getInt("geta8key_session_id", (int) System.currentTimeMillis());
            if (i == -1) {
                i = fVar.mXM.BI(str);
            }
            Bundle bundle = new Bundle();
            bundle.putString("geta8key_data_req_url", str);
            bundle.putString("geta8key_data_username", str2);
            bundle.putInt("geta8key_data_scene", i2);
            bundle.putInt("geta8key_data_reason", i);
            bundle.putInt("geta8key_data_flag", i3);
            bundle.putString("geta8key_data_net_type", bQV);
            bundle.putInt("geta8key_session_id", i4);
            XIPCInvoker.a("com.tencent.mm", bundle, com.tencent.mm.plugin.game.gamewebview.model.f.a.class, new f$1(fVar));
            x.d("MicroMsg.GameWebViewGetA8KeyHelp", "runCgi, url = %s, id = %d", new Object[]{str, Integer.valueOf(fVar.hashCode())});
            if (this.mYQ != null) {
                this.mYQ.setVisibility(8);
            }
            fx(false);
            this.mYG.mYh = System.currentTimeMillis();
        }
    }

    private void a(String str, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        if (this.mYW != null) {
            this.mYW.b(str, jsapiPermissionWrapper, generalControlWrapper);
        }
    }

    private void a(String str, String str2, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        if (this.mYW == null) {
            x.e("MicroMsg.GameWebPageView", "mWebViewPermission is null");
            return;
        }
        if (!bh.ov(str2)) {
            a(str2, jsapiPermissionWrapper, generalControlWrapper);
            this.mZe = str2;
        }
        if (aPg()) {
            a(str, jsapiPermissionWrapper, generalControlWrapper);
        }
    }

    private void a(xh xhVar) {
        if (!this.mYx.isFinishing() && this.mYN != null) {
            Map hashMap = new HashMap();
            List<akj> list = xhVar.whV;
            if (!bh.cA(list)) {
                for (akj com_tencent_mm_protocal_c_akj : list) {
                    if (!(bh.ov(com_tencent_mm_protocal_c_akj.vNj) || bh.ov(com_tencent_mm_protocal_c_akj.pQt))) {
                        hashMap.put(com_tencent_mm_protocal_c_akj.vNj, com_tencent_mm_protocal_c_akj.pQt);
                    }
                }
            }
            com.tencent.mm.plugin.game.gamewebview.c.a.h(xhVar.whK, list);
            String str = xhVar.fon;
            int i = xhVar.vEe;
            String str2 = xhVar.whK;
            switch (i) {
                case 6:
                    x.i("MicroMsg.GameWebPageView", "getA8key-special_webview: fullUrl = " + str2);
                    if (str2 == null || str2.length() == 0) {
                        x.e("MicroMsg.GameWebPageView", "getA8key-special_webview fail, invalid fullUrl");
                        return;
                    } else if (aa.Oj(str2)) {
                        this.mYN.loadUrl(str2);
                        this.mYx.showOptionMenu(false);
                        return;
                    } else {
                        x.f("MicroMsg.GameWebPageView", "processGetA8Key special, canLoadUrl fail, url = " + str2);
                        aPf();
                        return;
                    }
                case 7:
                    x.i("MicroMsg.GameWebPageView", "getA8key-webview_no_notice: title = " + str + ", fullUrl = " + str2);
                    if (str2 == null || str2.length() == 0) {
                        x.e("MicroMsg.GameWebPageView", "getA8key-webview_no_notice fail, invalid fullUrl");
                        return;
                    }
                    if (str != null && str.length() > 0) {
                        this.mYI.xv(str);
                    }
                    if (aa.Oj(str2)) {
                        this.mZe = str2;
                        if (aPg()) {
                            this.mHandler.post(new 15(this, hashMap, str2));
                            return;
                        } else if (hashMap.size() > 0) {
                            this.mYN.loadUrl(str2, hashMap);
                            return;
                        } else {
                            this.mYN.loadUrl(str2);
                            return;
                        }
                    }
                    x.f("MicroMsg.GameWebPageView", "processGetA8Key qrcode no notice, canLoadUrl fail, url = " + str2);
                    aPf();
                    return;
                default:
                    return;
            }
        }
    }

    private void aPf() {
        x.d("MicroMsg.GameWebPageView", "forceQuit");
        if (this.mZj) {
            fz(false);
        }
    }

    private void fx(boolean z) {
        this.mYx.setProgressBarIndeterminateVisibility(false);
        if (z) {
            aPi();
        } else if (!aPg()) {
            aPj();
        }
    }

    public final boolean aPg() {
        if (this.mYZ != null) {
            return this.mYZ.PO(this.mXZ);
        }
        return false;
    }

    public final GameWebViewUI aPh() {
        if (this.mYx.isFinishing() || this.mYx.xIq) {
            return null;
        }
        return this.mYx;
    }

    public final String RI() {
        String aPk = aPk();
        if (bh.ov(aPk)) {
            return "";
        }
        String str = (String) this.mZl.get(aPk);
        if (bh.ov(str)) {
            str = (String) this.mZl.get(BQ(aPk));
        }
        return bh.ou(str);
    }

    public final String BP(String str) {
        if (bh.ov(str)) {
            return "";
        }
        String str2 = (String) this.mZl.get(str);
        if (bh.ov(str2)) {
            str2 = (String) this.mZl.get(BQ(str));
        }
        return !bh.ov(str2) ? str2 : str;
    }

    public static String BQ(String str) {
        if (bh.ov(str)) {
            return str;
        }
        int indexOf = str.indexOf("#");
        return indexOf >= 0 ? str.substring(0, indexOf) : str;
    }

    public final void aPi() {
        this.juF.finish();
        this.juF.setVisibility(8);
    }

    public final void aPj() {
        this.juF.start();
        this.juF.setVisibility(0);
    }

    public final void E(final int i, final String str) {
        if (i != -1) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                this.mHandler.post(new Runnable(this) {
                    final /* synthetic */ d mZC;

                    public final void run() {
                        if (this.mZC.mYN != null) {
                            this.mZC.mYN.E(i, str);
                        }
                    }
                });
            } else if (this.mYN != null) {
                this.mYN.E(i, str);
            }
        }
    }

    public final void cH(String str, String str2) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.mHandler.post(new 17(this, str, str2));
        } else if (this.mYN != null) {
            this.mYN.cJ(str, str2);
        }
    }

    public final void cI(String str, String str2) {
        this.mYM.invokeHandler(str, str2, -1, System.currentTimeMillis());
    }

    public final String aPk() {
        if (this.mHandler == null) {
            return this.mZd;
        }
        if (Thread.currentThread().getId() == this.mHandler.getLooper().getThread().getId()) {
            return this.mYN == null ? "" : this.mYN.getUrl();
        } else {
            return (String) new bc<String>(this, "") {
                final /* synthetic */ d mZC;

                protected final /* synthetic */ Object run() {
                    return this.mZC.mYN == null ? "" : this.mZC.mYN.getUrl();
                }
            }.b(this.mHandler);
        }
    }

    public final String aPl() {
        String aPk = aPk();
        if (bh.ov(aPk)) {
            return null;
        }
        return (String) this.mZx.get(BQ(aPk));
    }

    public final String getTitle() {
        if (Thread.currentThread().getId() == this.mHandler.getLooper().getThread().getId()) {
            return this.mYN == null ? "" : this.mYN.getTitle();
        } else {
            return (String) new 19(this, "").b(this.mHandler);
        }
    }

    public final void BR(String str) {
        if (this.mYM != null) {
            this.mYM.mWj.add(str);
        }
    }

    public final void fy(boolean z) {
        if (!z) {
            this.mYP.hide();
        } else if (!this.mYP.isShown()) {
            this.mYP.reset();
            this.mYP.bUR();
            this.mYP.show();
        }
    }

    public final boolean bq(String str, int i) {
        JsapiPermissionWrapper Pj = this.mYW.Pj(aPk());
        if (Pj == null) {
            return false;
        }
        switch (Pj.CF(i)) {
            case 0:
            case 3:
                return false;
            case 1:
                return true;
            case 2:
                if (str.equals(ak.NAME)) {
                    return true;
                }
                return false;
            case 4:
                if (com.tencent.mm.plugin.game.gamewebview.e.a.bx(str, aPk())) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    public final boolean gn(int i) {
        if (this.mYW == null) {
            return false;
        }
        JsapiPermissionWrapper Pj = this.mYW.Pj(aPk());
        if (Pj != null) {
            return Pj.gn(i);
        }
        return false;
    }

    public final void aPm() {
        if (!this.mZB) {
            this.jDW = this.vf.getInt("customize_status_bar_color");
            if (this.jDW != 0) {
                this.jDY = this.vf.getString("status_bar_style");
            } else {
                dw dwVar;
                GameWebViewUI gameWebViewUI = this.mYx;
                x.i("MicroMsg.GameWebViewUI", "getDefaultStatusBarStyle");
                if (gameWebViewUI.nar != null) {
                    x.i("MicroMsg.GameWebViewUI", "color = %s, style = %s", new Object[]{gameWebViewUI.nar.fxA, gameWebViewUI.nar.fxB});
                    dwVar = new dw();
                    dwVar.hbM = gameWebViewUI.nar.fxA;
                    dwVar.neh = gameWebViewUI.nar.fxB;
                } else {
                    dwVar = null;
                }
                if (dwVar != null) {
                    this.jDW = com.tencent.mm.plugin.game.d.c.parseColor(dwVar.hbM);
                }
                if (this.jDW == 0) {
                    this.jDW = android.support.v4.content.a.c(this.mYx, R.e.bre);
                } else {
                    this.jDY = dwVar.neh;
                }
            }
        }
        aPn();
        runOnUiThread(new 28(this));
    }

    public final void aPn() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ d mZC;

            {
                this.mZC = r1;
            }

            public final void run() {
                com.tencent.mm.plugin.game.gamewebview.a.d.b(this.mZC.mYx, this.mZC.jDW, this.mZC.jDY);
            }
        });
    }

    public final boolean aPo() {
        if (this.mYI != null) {
            return this.mYI.aPo();
        }
        return false;
    }

    public final void fz(final boolean z) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ d mZC;

            public final void run() {
                b M = this.mZC.mYH;
                boolean z = z;
                c cVar = M.mYs;
                if (cVar.mYw.peek() == M) {
                    cVar.fw(z);
                    return;
                }
                cVar.mYw.remove(M);
                cVar.a(M);
            }
        });
    }
}
