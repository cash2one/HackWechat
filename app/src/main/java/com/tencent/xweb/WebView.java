package com.tencent.xweb;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebView.FindListener;
import android.widget.FrameLayout;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.xweb.c.d;
import com.tencent.xweb.c.g;
import com.tencent.xweb.c.h;
import com.tencent.xweb.util.e;
import com.tencent.xweb.x5.a.a.a.a.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class WebView extends FrameLayout implements g {
    static c Aqt = c.WV_KIND_NONE;
    static String Aqu = "";
    static com.tencent.xweb.x5.sdk.c Aqy;
    g Aqv;
    c Aqw;
    d Aqx;
    public boolean isX5Kernel;
    OnLongClickListener ztW;

    public static class a {
        public String mExtra;
        public int mType = 0;
    }

    public enum c {
        WV_KIND_NONE,
        WV_KIND_CW,
        WV_KIND_X5,
        WV_KIND_SYS
    }

    static {
        r.initInterface();
    }

    public static void initWebviewCore(Context context, c cVar, String str, b bVar) {
        if (Aqt == c.WV_KIND_NONE) {
            Aqu = str;
            if (str == null) {
                str = "";
            }
            XWalkEnvironment.init(context);
            k.iQ(context);
            if (k.cIo().aco(str) != c.WV_KIND_NONE) {
                cVar = k.cIo().aco(str);
                XWalkEnvironment.addXWalkInitializeLog("XWeb", "use hard code web type = " + cVar);
            } else if (a.acj(str) != c.WV_KIND_NONE) {
                cVar = a.acj(str);
                XWalkEnvironment.addXWalkInitializeLog("XWeb", "module " + str + "use cmd web type = " + cVar);
            }
            a(context, cVar, bVar, true);
        } else if (Aqt != cVar) {
            Log.e("xweb.WebView", "invalid set webview kind to diffrent type");
        }
    }

    private static boolean a(Context context, c cVar, b bVar, boolean z) {
        if (!a(cVar, context, bVar) && z) {
            cVar = c.WV_KIND_NONE;
            c[] cVarArr = new c[]{c.WV_KIND_X5, c.WV_KIND_CW, c.WV_KIND_SYS};
            int i = 0;
            while (i < 3) {
                if (cVarArr[i] != cVar && a(cVarArr[i], context, bVar)) {
                    cVar = cVarArr[i];
                    break;
                }
                i++;
            }
        }
        Aqt = cVar;
        if (c.WV_KIND_NONE != cVar) {
            return true;
        }
        e.cIQ();
        Log.e("xweb.WebView", "_initWebviewCore finally failed type = " + cVar);
        return false;
    }

    private static boolean a(c cVar, Context context, b bVar) {
        try {
            com.tencent.xweb.c.h.a a = h.a(cVar);
            boolean initWebviewCore = a.initWebviewCore(context, bVar);
            if (!initWebviewCore) {
                return initWebviewCore;
            }
            b.cIj().ApL = a.getCookieManager();
            c.ApN = a.getCookieSyncManager();
            e.b(cVar);
            return initWebviewCore;
        } catch (Exception e) {
            Log.e("xweb.WebView", "_DoInit failed type = " + cVar);
            e.c(cVar);
            return false;
        }
    }

    public static boolean hasInited() {
        if (getCurWebType() == c.WV_KIND_NONE || h.a(getCurWebType()) == null) {
            return false;
        }
        return h.a(getCurWebType()).hasInited();
    }

    public static c getCurWebType() {
        return Aqt;
    }

    public WebView(Context context) {
        this(context, null);
    }

    public WebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Aqw = c.WV_KIND_NONE;
        this.isX5Kernel = false;
        init();
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    private void init() {
        if (this.Aqw == c.WV_KIND_NONE) {
            if (getCurWebType() == c.WV_KIND_NONE) {
                a(getContext(), c.WV_KIND_SYS, null, true);
                Log.e("xweb.Webview", "use xweb without init, force to use sys web");
            }
            this.Aqw = getCurWebType();
            this.Aqv = h.a(this.Aqw, this);
            if (this.Aqv == null) {
                c[] cVarArr = new c[]{c.WV_KIND_CW, c.WV_KIND_SYS, c.WV_KIND_X5};
                int i = 0;
                while (i < 3) {
                    if (cVarArr[i] != this.Aqw && a(getContext(), cVarArr[i], null, false)) {
                        this.Aqv = h.a(cVarArr[i], this);
                        if (this.Aqv != null) {
                            this.Aqw = getCurWebType();
                            break;
                        }
                    }
                    i++;
                }
            }
            if (this.Aqv == null) {
                Log.e("xweb.WebView", "init finally failed type = " + this.Aqw);
                e.cIR();
                return;
            }
            addView(this.Aqv.getWebViewUI());
            if (this.Aqw == c.WV_KIND_X5 && this.Aqv.getX5WebViewExtension() != null) {
                this.isX5Kernel = true;
            }
            if (this.Aqv.getCurWebviewClient() != null) {
                this.Aqv.getCurWebviewClient().Aqd = this.Aqv.getDefalutOpProvider();
            }
            if (this.Aqv.getCurWebChromeClient() != null) {
                this.Aqv.getCurWebChromeClient().Aqd = this.Aqv.getDefalutOpProvider();
            }
            this.Aqv.getView().setOnLongClickListener(new OnLongClickListener(this) {
                final /* synthetic */ WebView Aqz;

                {
                    this.Aqz = r1;
                }

                public final boolean onLongClick(View view) {
                    if (this.Aqz.ztW != null) {
                        return this.Aqz.ztW.onLongClick(this.Aqz);
                    }
                    return false;
                }
            });
            try {
                this.Aqx = (d) h.a(c.WV_KIND_CW).excute("STR_CMD_GET_DEBUG_VIEW", new Object[]{this});
                this.Aqx.cIz();
            } catch (Exception e) {
                Log.e("xweb.WebView", "create IDebugView failed, use dummy one ");
                this.Aqx = new 2(this);
            }
        }
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.ztW = onLongClickListener;
    }

    public Object getX5WebViewExtension() {
        return this.Aqv.getX5WebViewExtension();
    }

    public void setWebViewClientExtension(b bVar) {
        this.Aqv.setWebViewClientExtension(bVar);
    }

    public boolean super_onTouchEvent(MotionEvent motionEvent) {
        return this.Aqv.super_onTouchEvent(motionEvent);
    }

    public boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.Aqv.super_onInterceptTouchEvent(motionEvent);
    }

    public void super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
        this.Aqv.super_onOverScrolled(i, i2, z, z2);
    }

    public boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        return this.Aqv.super_dispatchTouchEvent(motionEvent);
    }

    public void super_computeScroll() {
        this.Aqv.super_computeScroll();
    }

    public void super_onScrollChanged(int i, int i2, int i3, int i4) {
        this.Aqv.super_onScrollChanged(i, i2, i3, i4);
    }

    public boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return this.Aqv.super_overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    public void onResume() {
        this.Aqv.onResume();
    }

    public void onPause() {
        this.Aqv.onPause();
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.Aqv.getWebViewUI().setOnTouchListener(onTouchListener);
    }

    public boolean isXWalkKernel() {
        return this.Aqw == c.WV_KIND_CW;
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.Aqv != null) {
            this.Aqv.getWebViewUI().setBackgroundResource(i);
        }
    }

    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        if (this.Aqv != null) {
            this.Aqv.getWebViewUI().setBackgroundColor(i);
        }
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.Aqv != null) {
            this.Aqv.getView().setVisibility(i);
        }
    }

    public Bitmap getBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Config.ARGB_8888);
        if (createBitmap != null) {
            createBitmap.eraseColor(-1);
            Canvas canvas = new Canvas(createBitmap);
            if (isXWalkKernel()) {
                try {
                    Paint paint = new Paint();
                    paint.setXfermode(new PorterDuffXfermode(Mode.SRC_OVER));
                    for (TextureView bitmap : dS(this)) {
                        canvas.drawBitmap(bitmap.getBitmap(), 0.0f, 0.0f, paint);
                    }
                    Bitmap createBitmap2 = Bitmap.createBitmap(getWidth(), getHeight(), Config.ARGB_8888);
                    getTopView().draw(new Canvas(createBitmap2));
                    canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, paint);
                } catch (Exception e) {
                }
            } else {
                draw(canvas);
            }
        }
        return createBitmap;
    }

    private List<TextureView> dS(View view) {
        List<TextureView> arrayList = new ArrayList();
        if (view instanceof TextureView) {
            arrayList.add((TextureView) view);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                arrayList.addAll(dS(viewGroup.getChildAt(i)));
            }
        }
        return arrayList;
    }

    public void setFocusable(boolean z) {
        if (z) {
            setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            super.setFocusable(false);
            return;
        }
        setDescendantFocusability(393216);
        super.setFocusable(false);
    }

    public void setFocusableInTouchMode(boolean z) {
        if (z) {
            setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
            super.setFocusableInTouchMode(false);
            return;
        }
        setDescendantFocusability(393216);
        super.setFocusableInTouchMode(false);
    }

    public void onWebViewScrollChanged(int i, int i2, int i3, int i4) {
    }

    public View getView() {
        return this.Aqv.getView();
    }

    public ViewGroup getTopView() {
        return this.Aqv.getTopView();
    }

    public String getUrl() {
        return this.Aqv.getUrl();
    }

    public void removeJavascriptInterface(String str) {
        this.Aqv.removeJavascriptInterface(str);
    }

    public void stopLoading() {
        this.Aqv.stopLoading();
    }

    public void setWebViewCallbackClient(o oVar) {
        this.Aqv.setWebViewCallbackClient(oVar);
    }

    public a getHitTestResult() {
        return this.Aqv.getHitTestResult();
    }

    public String getTitle() {
        return this.Aqv.getTitle();
    }

    public void clearMatches() {
        this.Aqv.clearMatches();
    }

    public void findNext(boolean z) {
        this.Aqv.findNext(z);
    }

    public void findAllAsync(String str) {
        this.Aqv.findAllAsync(str);
    }

    public String getVersionInfo() {
        return this.Aqv.getVersionInfo();
    }

    public String getAbstractInfo() {
        return this.Aqv.getAbstractInfo();
    }

    public p getCurWebviewClient() {
        return this.Aqv.getCurWebviewClient();
    }

    public j getCurWebChromeClient() {
        return this.Aqv.getCurWebChromeClient();
    }

    public static void setX5Interface(com.tencent.xweb.x5.sdk.c cVar) {
        Aqy = cVar;
    }

    public static int getTbsCoreVersion(Context context) {
        if (Aqy != null) {
            return Aqy.getTbsCoreVersion(context);
        }
        Log.e("xweb.WebView", "getTbsCoreVersion: sImp is null");
        return 0;
    }

    public static int getTbsSDKVersion(Context context) {
        if (Aqy != null) {
            return Aqy.getTbsSDKVersion(context);
        }
        Log.e("xweb.WebView", "getTbsSDKVersion: sImp is null");
        return 0;
    }

    public static String getCrashExtraMessage(Context context) {
        if (Aqy != null) {
            return Aqy.getCrashExtraMessage(context);
        }
        Log.e("xweb.WebView", "getCrashExtraMessage: sImp is null");
        return "";
    }

    public static boolean getCanReboot() {
        if (getCurWebType() == c.WV_KIND_X5) {
            if (Aqy != null) {
                return Aqy.getCanReboot();
            }
            Log.e("xweb.WebView", "getCanReboot: sImp is null");
        }
        return true;
    }

    public void reload() {
        this.Aqv.reload();
    }

    public void clearSslPreferences() {
        this.Aqv.clearSslPreferences();
    }

    public void loadData(String str, String str2, String str3) {
        this.Aqv.loadData(str, str2, str3);
    }

    public int getContentHeight() {
        return this.Aqv.getContentHeight();
    }

    public float getScale() {
        return this.Aqv.getScale();
    }

    public int getWebScrollY() {
        return this.Aqv.getWebScrollY();
    }

    public int getWebScrollX() {
        return this.Aqv.getWebScrollX();
    }

    public boolean isOverScrollStart() {
        return this.Aqv.isOverScrollStart();
    }

    public int getVisibleTitleHeight() {
        return this.Aqv.getVisibleTitleHeight();
    }

    public boolean overlayHorizontalScrollbar() {
        return this.Aqv.overlayHorizontalScrollbar();
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.Aqv.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public boolean zoomOut() {
        return this.Aqv.zoomOut();
    }

    public boolean zoomIn() {
        return this.Aqv.zoomIn();
    }

    @TargetApi(8)
    public void loadUrl(String str, Map<String, String> map) {
        if (this.Aqx.acp(str)) {
            this.Aqv.loadUrl("http://weixin.qq.com/");
        } else {
            this.Aqv.loadUrl(str, map);
        }
    }

    public void addJavascriptInterface(Object obj, String str) {
        this.Aqv.addJavascriptInterface(obj, str);
    }

    public void _enablePlatformNotifications() {
    }

    public void _disablePlatformNotifications() {
    }

    @Deprecated
    public static void enablePlatformNotifications() {
        if (getCurWebType() == c.WV_KIND_SYS) {
            com.tencent.xweb.util.d.gd("android.webkit.WebView", "enablePlatformNotifications");
        }
    }

    @Deprecated
    public static void disablePlatformNotifications() {
        if (getCurWebType() == c.WV_KIND_SYS) {
            com.tencent.xweb.util.d.gd("android.webkit.WebView", "disablePlatformNotifications");
        }
    }

    public n getSettings() {
        return this.Aqv.getSettings();
    }

    public View getWebViewUI() {
        return this.Aqv.getWebViewUI();
    }

    public void setWebViewClient(p pVar) {
        if (pVar != null) {
            pVar.Aqd = this.Aqv.getDefalutOpProvider();
        }
        this.Aqv.setWebViewClient(pVar);
    }

    public void setWebChromeClient(j jVar) {
        if (jVar != null) {
            jVar.Aqd = this.Aqv.getDefalutOpProvider();
        }
        this.Aqv.setWebChromeClient(jVar);
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        this.Aqv.setDownloadListener(downloadListener);
    }

    public void setFindListener(FindListener findListener) {
        this.Aqv.setFindListener(findListener);
    }

    public void loadUrl(String str) {
        if (this.Aqx.acp(str)) {
            this.Aqv.loadUrl("http://weixin.qq.com/");
        } else {
            this.Aqv.loadUrl(str);
        }
    }

    public boolean canGoBack() {
        return this.Aqv.canGoBack();
    }

    public void goBack() {
        this.Aqv.goBack();
    }

    public void clearView() {
        this.Aqv.clearView();
    }

    public void destroy() {
        this.Aqv.destroy();
    }

    public boolean hasEnteredFullscreen() {
        return this.Aqv.hasEnteredFullscreen();
    }

    public void leaveFullscreen() {
        this.Aqv.leaveFullscreen();
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.Aqv.evaluateJavascript(str, valueCallback);
    }

    public com.tencent.xweb.c.b.a getCookieManager() {
        return null;
    }

    public com.tencent.xweb.c.b.b getCookieSyncManager() {
        return null;
    }

    public com.tencent.xweb.c.e getDefalutOpProvider() {
        return null;
    }
}
