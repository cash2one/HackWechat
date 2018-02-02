package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.webkit.WebSettings.PluginState;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings$TextSize;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings.LayoutAlgorithm;
import com.tencent.smtt.export.external.interfaces.IX5WebSettings.ZoomDensity;
import com.tencent.smtt.utils.o;

public class WebSettings {
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    public static final int LOAD_NORMAL = 0;
    public static final int LOAD_NO_CACHE = 2;
    private static final String LOGTAG = "WebSettings";
    private boolean isUseX5;
    private android.webkit.WebSettings mSystemWebSettings;
    private IX5WebSettings mWebSettingsImpl;

    public enum RenderPriority {
        NORMAL,
        HIGH,
        LOW
    }

    public enum TextSize {
        SMALLEST(50),
        SMALLER(75),
        NORMAL(100),
        LARGER(125),
        LARGEST(150);
        
        int value;

        private TextSize(int i) {
            this.value = i;
        }
    }

    WebSettings(android.webkit.WebSettings webSettings) {
        this.mWebSettingsImpl = null;
        this.mSystemWebSettings = null;
        this.isUseX5 = false;
        this.mWebSettingsImpl = null;
        this.mSystemWebSettings = webSettings;
        this.isUseX5 = false;
    }

    WebSettings(IX5WebSettings iX5WebSettings) {
        this.mWebSettingsImpl = null;
        this.mSystemWebSettings = null;
        this.isUseX5 = false;
        this.mWebSettingsImpl = iX5WebSettings;
        this.mSystemWebSettings = null;
        this.isUseX5 = true;
    }

    @TargetApi(17)
    public static String getDefaultUserAgent(Context context) {
        Object invokeStaticMethod;
        if (af.cFg().cFh()) {
            invokeStaticMethod = af.cFg().cFi().zZb.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getDefaultUserAgent", new Class[]{Context.class}, new Object[]{context});
            return invokeStaticMethod instanceof String ? (String) invokeStaticMethod : null;
        } else if (VERSION.SDK_INT < 17) {
            return null;
        } else {
            invokeStaticMethod = o.b(android.webkit.WebSettings.class, "getDefaultUserAgent", new Class[]{Context.class}, new Object[]{context});
            return invokeStaticMethod == null ? null : (String) invokeStaticMethod;
        }
    }

    @Deprecated
    public boolean enableSmoothTransition() {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            return this.mWebSettingsImpl.enableSmoothTransition();
        }
        if (this.isUseX5 || this.mSystemWebSettings == null) {
            return false;
        }
        if (VERSION.SDK_INT < 11) {
            return false;
        }
        Object f = o.f(this.mSystemWebSettings, "enableSmoothTransition");
        return f == null ? false : ((Boolean) f).booleanValue();
    }

    @TargetApi(11)
    public boolean getAllowContentAccess() {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            return this.mWebSettingsImpl.getAllowContentAccess();
        }
        if (this.isUseX5 || this.mSystemWebSettings == null) {
            return false;
        }
        if (VERSION.SDK_INT < 11) {
            return false;
        }
        Object f = o.f(this.mSystemWebSettings, "getAllowContentAccess");
        return f == null ? false : ((Boolean) f).booleanValue();
    }

    @TargetApi(3)
    public boolean getAllowFileAccess() {
        return (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? false : this.mSystemWebSettings.getAllowFileAccess() : this.mWebSettingsImpl.getAllowFileAccess();
    }

    public synchronized boolean getBlockNetworkImage() {
        boolean blockNetworkImage;
        blockNetworkImage = (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? false : this.mSystemWebSettings.getBlockNetworkImage() : this.mWebSettingsImpl.getBlockNetworkImage();
        return blockNetworkImage;
    }

    @TargetApi(8)
    public synchronized boolean getBlockNetworkLoads() {
        boolean z = false;
        synchronized (this) {
            if (this.isUseX5 && this.mWebSettingsImpl != null) {
                z = this.mWebSettingsImpl.getBlockNetworkLoads();
            } else if (!(this.isUseX5 || this.mSystemWebSettings == null || VERSION.SDK_INT < 8)) {
                z = this.mSystemWebSettings.getBlockNetworkLoads();
            }
        }
        return z;
    }

    @TargetApi(3)
    public boolean getBuiltInZoomControls() {
        return (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? false : this.mSystemWebSettings.getBuiltInZoomControls() : this.mWebSettingsImpl.getBuiltInZoomControls();
    }

    public int getCacheMode() {
        return (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? 0 : this.mSystemWebSettings.getCacheMode() : this.mWebSettingsImpl.getCacheMode();
    }

    public synchronized String getCursiveFontFamily() {
        String cursiveFontFamily;
        cursiveFontFamily = (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? "" : this.mSystemWebSettings.getCursiveFontFamily() : this.mWebSettingsImpl.getCursiveFontFamily();
        return cursiveFontFamily;
    }

    @TargetApi(5)
    public synchronized boolean getDatabaseEnabled() {
        boolean databaseEnabled;
        databaseEnabled = (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? false : this.mSystemWebSettings.getDatabaseEnabled() : this.mWebSettingsImpl.getDatabaseEnabled();
        return databaseEnabled;
    }

    @TargetApi(5)
    public synchronized String getDatabasePath() {
        String databasePath;
        databasePath = (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? "" : this.mSystemWebSettings.getDatabasePath() : this.mWebSettingsImpl.getDatabasePath();
        return databasePath;
    }

    public synchronized int getDefaultFixedFontSize() {
        int defaultFixedFontSize;
        defaultFixedFontSize = (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? 0 : this.mSystemWebSettings.getDefaultFixedFontSize() : this.mWebSettingsImpl.getDefaultFixedFontSize();
        return defaultFixedFontSize;
    }

    public synchronized int getDefaultFontSize() {
        int defaultFontSize;
        defaultFontSize = (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? 0 : this.mSystemWebSettings.getDefaultFontSize() : this.mWebSettingsImpl.getDefaultFontSize();
        return defaultFontSize;
    }

    public synchronized String getDefaultTextEncodingName() {
        String defaultTextEncodingName;
        defaultTextEncodingName = (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? "" : this.mSystemWebSettings.getDefaultTextEncodingName() : this.mWebSettingsImpl.getDefaultTextEncodingName();
        return defaultTextEncodingName;
    }

    @TargetApi(7)
    public ZoomDensity getDefaultZoom() {
        return (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? null : ZoomDensity.valueOf(this.mSystemWebSettings.getDefaultZoom().name()) : ZoomDensity.valueOf(this.mWebSettingsImpl.getDefaultZoom().name());
    }

    @TargetApi(11)
    public boolean getDisplayZoomControls() {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            return this.mWebSettingsImpl.getDisplayZoomControls();
        }
        if (this.isUseX5 || this.mSystemWebSettings == null) {
            return false;
        }
        if (VERSION.SDK_INT < 11) {
            return false;
        }
        Object f = o.f(this.mSystemWebSettings, "getDisplayZoomControls");
        return f == null ? false : ((Boolean) f).booleanValue();
    }

    @TargetApi(7)
    public synchronized boolean getDomStorageEnabled() {
        boolean domStorageEnabled;
        domStorageEnabled = (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? false : this.mSystemWebSettings.getDomStorageEnabled() : this.mWebSettingsImpl.getDomStorageEnabled();
        return domStorageEnabled;
    }

    public synchronized String getFantasyFontFamily() {
        String fantasyFontFamily;
        fantasyFontFamily = (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? "" : this.mSystemWebSettings.getFantasyFontFamily() : this.mWebSettingsImpl.getFantasyFontFamily();
        return fantasyFontFamily;
    }

    public synchronized String getFixedFontFamily() {
        String fixedFontFamily;
        fixedFontFamily = (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? "" : this.mSystemWebSettings.getFixedFontFamily() : this.mWebSettingsImpl.getFixedFontFamily();
        return fixedFontFamily;
    }

    public synchronized boolean getJavaScriptCanOpenWindowsAutomatically() {
        boolean javaScriptCanOpenWindowsAutomatically;
        javaScriptCanOpenWindowsAutomatically = (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? false : this.mSystemWebSettings.getJavaScriptCanOpenWindowsAutomatically() : this.mWebSettingsImpl.getJavaScriptCanOpenWindowsAutomatically();
        return javaScriptCanOpenWindowsAutomatically;
    }

    public synchronized boolean getJavaScriptEnabled() {
        boolean javaScriptEnabled;
        javaScriptEnabled = (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? false : this.mSystemWebSettings.getJavaScriptEnabled() : this.mWebSettingsImpl.getJavaScriptEnabled();
        return javaScriptEnabled;
    }

    public synchronized LayoutAlgorithm getLayoutAlgorithm() {
        LayoutAlgorithm valueOf;
        valueOf = (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? null : LayoutAlgorithm.valueOf(this.mSystemWebSettings.getLayoutAlgorithm().name()) : LayoutAlgorithm.valueOf(this.mWebSettingsImpl.getLayoutAlgorithm().name());
        return valueOf;
    }

    public boolean getLightTouchEnabled() {
        return (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? false : this.mSystemWebSettings.getLightTouchEnabled() : this.mWebSettingsImpl.getLightTouchEnabled();
    }

    @TargetApi(7)
    public boolean getLoadWithOverviewMode() {
        return (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? false : this.mSystemWebSettings.getLoadWithOverviewMode() : this.mWebSettingsImpl.getLoadWithOverviewMode();
    }

    public synchronized boolean getLoadsImagesAutomatically() {
        boolean loadsImagesAutomatically;
        loadsImagesAutomatically = (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? false : this.mSystemWebSettings.getLoadsImagesAutomatically() : this.mWebSettingsImpl.getLoadsImagesAutomatically();
        return loadsImagesAutomatically;
    }

    @TargetApi(17)
    public boolean getMediaPlaybackRequiresUserGesture() {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            return this.mWebSettingsImpl.getMediaPlaybackRequiresUserGesture();
        }
        if (this.isUseX5 || this.mSystemWebSettings == null) {
            return false;
        }
        if (VERSION.SDK_INT < 17) {
            return false;
        }
        Object f = o.f(this.mSystemWebSettings, "getMediaPlaybackRequiresUserGesture");
        return f == null ? false : ((Boolean) f).booleanValue();
    }

    public synchronized int getMinimumFontSize() {
        int minimumFontSize;
        minimumFontSize = (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? 0 : this.mSystemWebSettings.getMinimumFontSize() : this.mWebSettingsImpl.getMinimumFontSize();
        return minimumFontSize;
    }

    public synchronized int getMinimumLogicalFontSize() {
        int minimumLogicalFontSize;
        minimumLogicalFontSize = (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? 0 : this.mSystemWebSettings.getMinimumLogicalFontSize() : this.mWebSettingsImpl.getMinimumLogicalFontSize();
        return minimumLogicalFontSize;
    }

    public synchronized int getMixedContentMode() {
        int mixedContentMode;
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            try {
                mixedContentMode = this.mWebSettingsImpl.getMixedContentMode();
            } catch (Throwable th) {
                mixedContentMode = -1;
            }
        } else if (VERSION.SDK_INT < 21) {
            mixedContentMode = -1;
        } else {
            Object b = o.b(this.mSystemWebSettings, "getMixedContentMode", new Class[0], new Object[0]);
            mixedContentMode = b == null ? -1 : ((Integer) b).intValue();
        }
        return mixedContentMode;
    }

    public boolean getNavDump() {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            return this.mWebSettingsImpl.getNavDump();
        }
        if (this.isUseX5 || this.mSystemWebSettings == null) {
            return false;
        }
        Object f = o.f(this.mSystemWebSettings, "getNavDump");
        return f == null ? false : ((Boolean) f).booleanValue();
    }

    @TargetApi(8)
    @Deprecated
    public synchronized PluginState getPluginState() {
        PluginState valueOf;
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            valueOf = PluginState.valueOf(this.mWebSettingsImpl.getPluginState().name());
        } else if (this.isUseX5 || this.mSystemWebSettings == null) {
            valueOf = null;
        } else if (VERSION.SDK_INT >= 8) {
            Object f = o.f(this.mSystemWebSettings, "getPluginState");
            valueOf = f == null ? null : PluginState.valueOf(((PluginState) f).name());
        } else {
            valueOf = null;
        }
        return valueOf;
    }

    @TargetApi(8)
    @Deprecated
    public synchronized boolean getPluginsEnabled() {
        boolean pluginsEnabled;
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            pluginsEnabled = this.mWebSettingsImpl.getPluginsEnabled();
        } else if (this.isUseX5 || this.mSystemWebSettings == null) {
            pluginsEnabled = false;
        } else if (VERSION.SDK_INT <= 17) {
            Object f = o.f(this.mSystemWebSettings, "getPluginsEnabled");
            pluginsEnabled = f == null ? false : ((Boolean) f).booleanValue();
        } else if (VERSION.SDK_INT == 18) {
            pluginsEnabled = PluginState.ON == this.mSystemWebSettings.getPluginState();
        } else {
            pluginsEnabled = false;
        }
        return pluginsEnabled;
    }

    @Deprecated
    public synchronized String getPluginsPath() {
        String pluginsPath;
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            pluginsPath = this.mWebSettingsImpl.getPluginsPath();
        } else if (this.isUseX5 || this.mSystemWebSettings == null) {
            pluginsPath = "";
        } else if (VERSION.SDK_INT <= 17) {
            Object f = o.f(this.mSystemWebSettings, "getPluginsPath");
            pluginsPath = f == null ? null : (String) f;
        } else {
            pluginsPath = "";
        }
        return pluginsPath;
    }

    public synchronized String getSansSerifFontFamily() {
        String sansSerifFontFamily;
        sansSerifFontFamily = (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? "" : this.mSystemWebSettings.getSansSerifFontFamily() : this.mWebSettingsImpl.getSansSerifFontFamily();
        return sansSerifFontFamily;
    }

    public boolean getSaveFormData() {
        return (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? false : this.mSystemWebSettings.getSaveFormData() : this.mWebSettingsImpl.getSaveFormData();
    }

    public boolean getSavePassword() {
        return (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? false : this.mSystemWebSettings.getSavePassword() : this.mWebSettingsImpl.getSavePassword();
    }

    public synchronized String getSerifFontFamily() {
        String serifFontFamily;
        serifFontFamily = (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? "" : this.mSystemWebSettings.getSerifFontFamily() : this.mWebSettingsImpl.getSerifFontFamily();
        return serifFontFamily;
    }

    public synchronized String getStandardFontFamily() {
        String standardFontFamily;
        standardFontFamily = (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? "" : this.mSystemWebSettings.getStandardFontFamily() : this.mWebSettingsImpl.getStandardFontFamily();
        return standardFontFamily;
    }

    public TextSize getTextSize() {
        return (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? null : TextSize.valueOf(this.mSystemWebSettings.getTextSize().name()) : TextSize.valueOf(this.mWebSettingsImpl.getTextSize().name());
    }

    @TargetApi(14)
    public synchronized int getTextZoom() {
        int textZoom;
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            textZoom = this.mWebSettingsImpl.getTextZoom();
        } else if (this.isUseX5 || this.mSystemWebSettings == null) {
            textZoom = 0;
        } else if (VERSION.SDK_INT < 14) {
            textZoom = 0;
        } else {
            try {
                textZoom = this.mSystemWebSettings.getTextZoom();
            } catch (Exception e) {
                Object f = o.f(this.mSystemWebSettings, "getTextZoom");
                textZoom = f == null ? 0 : ((Integer) f).intValue();
            }
        }
        return textZoom;
    }

    @Deprecated
    public boolean getUseWebViewBackgroundForOverscrollBackground() {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            return this.mWebSettingsImpl.getUseWebViewBackgroundForOverscrollBackground();
        }
        if (this.isUseX5 || this.mSystemWebSettings == null) {
            return false;
        }
        Object f = o.f(this.mSystemWebSettings, "getUseWebViewBackgroundForOverscrollBackground");
        return f == null ? false : ((Boolean) f).booleanValue();
    }

    public synchronized boolean getUseWideViewPort() {
        boolean useWideViewPort;
        useWideViewPort = (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? false : this.mSystemWebSettings.getUseWideViewPort() : this.mWebSettingsImpl.getUseWideViewPort();
        return useWideViewPort;
    }

    @TargetApi(3)
    public String getUserAgentString() {
        return (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? "" : this.mSystemWebSettings.getUserAgentString() : this.mWebSettingsImpl.getUserAgentString();
    }

    @TargetApi(11)
    public void setAllowContentAccess(boolean z) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setAllowContentAccess(z);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null && VERSION.SDK_INT >= 11) {
            o.b(this.mSystemWebSettings, "setAllowContentAccess", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
        }
    }

    @TargetApi(3)
    public void setAllowFileAccess(boolean z) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setAllowFileAccess(z);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            this.mSystemWebSettings.setAllowFileAccess(z);
        }
    }

    @TargetApi(16)
    public void setAllowFileAccessFromFileURLs(boolean z) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setAllowFileAccessFromFileURLs(z);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            o.b(this.mSystemWebSettings, "setAllowFileAccessFromFileURLs", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
        }
    }

    @TargetApi(16)
    public void setAllowUniversalAccessFromFileURLs(boolean z) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setAllowUniversalAccessFromFileURLs(z);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            o.b(this.mSystemWebSettings, "setAllowUniversalAccessFromFileURLs", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
        }
    }

    @TargetApi(7)
    public void setAppCacheEnabled(boolean z) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setAppCacheEnabled(z);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            this.mSystemWebSettings.setAppCacheEnabled(z);
        }
    }

    @TargetApi(7)
    public void setAppCacheMaxSize(long j) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setAppCacheMaxSize(j);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            this.mSystemWebSettings.setAppCacheMaxSize(j);
        }
    }

    @TargetApi(7)
    public void setAppCachePath(String str) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setAppCachePath(str);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            this.mSystemWebSettings.setAppCachePath(str);
        }
    }

    public void setBlockNetworkImage(boolean z) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setBlockNetworkImage(z);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            this.mSystemWebSettings.setBlockNetworkImage(z);
        }
    }

    @TargetApi(8)
    public synchronized void setBlockNetworkLoads(boolean z) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setBlockNetworkLoads(z);
        } else if (!(this.isUseX5 || this.mSystemWebSettings == null || VERSION.SDK_INT < 8)) {
            this.mSystemWebSettings.setBlockNetworkLoads(z);
        }
    }

    @TargetApi(3)
    public void setBuiltInZoomControls(boolean z) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setBuiltInZoomControls(z);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            this.mSystemWebSettings.setBuiltInZoomControls(z);
        }
    }

    public void setCacheMode(int i) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setCacheMode(i);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            this.mSystemWebSettings.setCacheMode(i);
        }
    }

    public synchronized void setCursiveFontFamily(String str) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setCursiveFontFamily(str);
        } else if (!(this.isUseX5 || this.mSystemWebSettings == null)) {
            this.mSystemWebSettings.setCursiveFontFamily(str);
        }
    }

    @TargetApi(5)
    public void setDatabaseEnabled(boolean z) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setDatabaseEnabled(z);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            this.mSystemWebSettings.setDatabaseEnabled(z);
        }
    }

    @TargetApi(5)
    @Deprecated
    public void setDatabasePath(String str) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setDatabasePath(str);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            o.b(this.mSystemWebSettings, "setDatabasePath", new Class[]{String.class}, new Object[]{str});
        }
    }

    public synchronized void setDefaultFixedFontSize(int i) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setDefaultFixedFontSize(i);
        } else if (!(this.isUseX5 || this.mSystemWebSettings == null)) {
            this.mSystemWebSettings.setDefaultFixedFontSize(i);
        }
    }

    public synchronized void setDefaultFontSize(int i) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setDefaultFontSize(i);
        } else if (!(this.isUseX5 || this.mSystemWebSettings == null)) {
            this.mSystemWebSettings.setDefaultFontSize(i);
        }
    }

    public synchronized void setDefaultTextEncodingName(String str) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setDefaultTextEncodingName(str);
        } else if (!(this.isUseX5 || this.mSystemWebSettings == null)) {
            this.mSystemWebSettings.setDefaultTextEncodingName(str);
        }
    }

    @TargetApi(7)
    public void setDefaultZoom(ZoomDensity zoomDensity) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setDefaultZoom(ZoomDensity.valueOf(zoomDensity.name()));
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            this.mSystemWebSettings.setDefaultZoom(android.webkit.WebSettings.ZoomDensity.valueOf(zoomDensity.name()));
        }
    }

    @TargetApi(11)
    public void setDisplayZoomControls(boolean z) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setDisplayZoomControls(z);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null && VERSION.SDK_INT >= 11) {
            o.b(this.mSystemWebSettings, "setDisplayZoomControls", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
        }
    }

    @TargetApi(7)
    public void setDomStorageEnabled(boolean z) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setDomStorageEnabled(z);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            this.mSystemWebSettings.setDomStorageEnabled(z);
        }
    }

    @TargetApi(11)
    @Deprecated
    public void setEnableSmoothTransition(boolean z) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setEnableSmoothTransition(z);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null && VERSION.SDK_INT >= 11) {
            o.b(this.mSystemWebSettings, "setEnableSmoothTransition", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
        }
    }

    public synchronized void setFantasyFontFamily(String str) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setFantasyFontFamily(str);
        } else if (!(this.isUseX5 || this.mSystemWebSettings == null)) {
            this.mSystemWebSettings.setFantasyFontFamily(str);
        }
    }

    public synchronized void setFixedFontFamily(String str) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setFixedFontFamily(str);
        } else if (!(this.isUseX5 || this.mSystemWebSettings == null)) {
            this.mSystemWebSettings.setFixedFontFamily(str);
        }
    }

    @TargetApi(5)
    public void setGeolocationDatabasePath(String str) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setGeolocationDatabasePath(str);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            this.mSystemWebSettings.setGeolocationDatabasePath(str);
        }
    }

    @TargetApi(5)
    public void setGeolocationEnabled(boolean z) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setGeolocationEnabled(z);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            this.mSystemWebSettings.setGeolocationEnabled(z);
        }
    }

    public synchronized void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setJavaScriptCanOpenWindowsAutomatically(z);
        } else if (!(this.isUseX5 || this.mSystemWebSettings == null)) {
            this.mSystemWebSettings.setJavaScriptCanOpenWindowsAutomatically(z);
        }
    }

    @Deprecated
    public void setJavaScriptEnabled(boolean z) {
        try {
            if (this.isUseX5 && this.mWebSettingsImpl != null) {
                this.mWebSettingsImpl.setJavaScriptEnabled(z);
            } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
                this.mSystemWebSettings.setJavaScriptEnabled(z);
            }
        } catch (Throwable th) {
        }
    }

    public void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setLayoutAlgorithm(LayoutAlgorithm.valueOf(layoutAlgorithm.name()));
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            this.mSystemWebSettings.setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.valueOf(layoutAlgorithm.name()));
        }
    }

    public void setLightTouchEnabled(boolean z) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setLightTouchEnabled(z);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            this.mSystemWebSettings.setLightTouchEnabled(z);
        }
    }

    @TargetApi(7)
    public void setLoadWithOverviewMode(boolean z) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setLoadWithOverviewMode(z);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            this.mSystemWebSettings.setLoadWithOverviewMode(z);
        }
    }

    public void setLoadsImagesAutomatically(boolean z) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setLoadsImagesAutomatically(z);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            this.mSystemWebSettings.setLoadsImagesAutomatically(z);
        }
    }

    @TargetApi(17)
    public void setMediaPlaybackRequiresUserGesture(boolean z) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setMediaPlaybackRequiresUserGesture(z);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null && VERSION.SDK_INT >= 17) {
            o.b(this.mSystemWebSettings, "setMediaPlaybackRequiresUserGesture", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
        }
    }

    public synchronized void setMinimumFontSize(int i) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setMinimumFontSize(i);
        } else if (!(this.isUseX5 || this.mSystemWebSettings == null)) {
            this.mSystemWebSettings.setMinimumFontSize(i);
        }
    }

    public synchronized void setMinimumLogicalFontSize(int i) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setMinimumLogicalFontSize(i);
        } else if (!(this.isUseX5 || this.mSystemWebSettings == null)) {
            this.mSystemWebSettings.setMinimumLogicalFontSize(i);
        }
    }

    @TargetApi(21)
    public void setMixedContentMode(int i) {
        if ((!this.isUseX5 || this.mWebSettingsImpl == null) && !this.isUseX5 && this.mSystemWebSettings != null && VERSION.SDK_INT >= 21) {
            o.b(this.mSystemWebSettings, "setMixedContentMode", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)});
        }
    }

    public void setNavDump(boolean z) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setNavDump(z);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            o.b(this.mSystemWebSettings, "setNavDump", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
        }
    }

    public void setNeedInitialFocus(boolean z) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setNeedInitialFocus(z);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            this.mSystemWebSettings.setNeedInitialFocus(z);
        }
    }

    @TargetApi(8)
    @Deprecated
    public synchronized void setPluginState(PluginState pluginState) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setPluginState(IX5WebSettings.PluginState.valueOf(pluginState.name()));
        } else if (!(this.isUseX5 || this.mSystemWebSettings == null || VERSION.SDK_INT < 8)) {
            PluginState valueOf = PluginState.valueOf(pluginState.name());
            o.b(this.mSystemWebSettings, "setPluginState", new Class[]{PluginState.class}, new Object[]{valueOf});
        }
    }

    @Deprecated
    public void setPluginsEnabled(boolean z) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setPluginsEnabled(z);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            o.b(this.mSystemWebSettings, "setPluginsEnabled", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
        }
    }

    @Deprecated
    public synchronized void setPluginsPath(String str) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setPluginsPath(str);
        } else if (!(this.isUseX5 || this.mSystemWebSettings == null)) {
            o.b(this.mSystemWebSettings, "setPluginsPath", new Class[]{String.class}, new Object[]{str});
        }
    }

    public void setRenderPriority(RenderPriority renderPriority) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setRenderPriority(com.tencent.smtt.export.external.interfaces.IX5WebSettings.RenderPriority.valueOf(renderPriority.name()));
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            this.mSystemWebSettings.setRenderPriority(android.webkit.WebSettings.RenderPriority.valueOf(renderPriority.name()));
        }
    }

    public synchronized void setSansSerifFontFamily(String str) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setSansSerifFontFamily(str);
        } else if (!(this.isUseX5 || this.mSystemWebSettings == null)) {
            this.mSystemWebSettings.setSansSerifFontFamily(str);
        }
    }

    public void setSaveFormData(boolean z) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setSaveFormData(z);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            this.mSystemWebSettings.setSaveFormData(z);
        }
    }

    public void setSavePassword(boolean z) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setSavePassword(z);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            this.mSystemWebSettings.setSavePassword(z);
        }
    }

    public synchronized void setSerifFontFamily(String str) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setSerifFontFamily(str);
        } else if (!(this.isUseX5 || this.mSystemWebSettings == null)) {
            this.mSystemWebSettings.setSerifFontFamily(str);
        }
    }

    public synchronized void setStandardFontFamily(String str) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setStandardFontFamily(str);
        } else if (!(this.isUseX5 || this.mSystemWebSettings == null)) {
            this.mSystemWebSettings.setStandardFontFamily(str);
        }
    }

    public void setSupportMultipleWindows(boolean z) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setSupportMultipleWindows(z);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            this.mSystemWebSettings.setSupportMultipleWindows(z);
        }
    }

    public void setSupportZoom(boolean z) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setSupportZoom(z);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            this.mSystemWebSettings.setSupportZoom(z);
        }
    }

    public void setTextSize(TextSize textSize) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setTextSize(IX5WebSettings$TextSize.valueOf(textSize.name()));
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            this.mSystemWebSettings.setTextSize(android.webkit.WebSettings.TextSize.valueOf(textSize.name()));
        }
    }

    @TargetApi(14)
    public synchronized void setTextZoom(int i) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setTextZoom(i);
        } else if (!(this.isUseX5 || this.mSystemWebSettings == null || VERSION.SDK_INT < 14)) {
            try {
                this.mSystemWebSettings.setTextZoom(i);
            } catch (Exception e) {
                o.b(this.mSystemWebSettings, "setTextZoom", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)});
            }
        }
    }

    @Deprecated
    public void setUseWebViewBackgroundForOverscrollBackground(boolean z) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setUseWebViewBackgroundForOverscrollBackground(z);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            o.b(this.mSystemWebSettings, "setUseWebViewBackgroundForOverscrollBackground", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
        }
    }

    public void setUseWideViewPort(boolean z) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setUseWideViewPort(z);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            this.mSystemWebSettings.setUseWideViewPort(z);
        }
    }

    public void setUserAgent(String str) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setUserAgent(str);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            this.mSystemWebSettings.setUserAgentString(str);
        }
    }

    @TargetApi(3)
    public void setUserAgentString(String str) {
        if (this.isUseX5 && this.mWebSettingsImpl != null) {
            this.mWebSettingsImpl.setUserAgentString(str);
        } else if (!this.isUseX5 && this.mSystemWebSettings != null) {
            this.mSystemWebSettings.setUserAgentString(str);
        }
    }

    public synchronized boolean supportMultipleWindows() {
        boolean supportMultipleWindows;
        supportMultipleWindows = (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? false : this.mSystemWebSettings.supportMultipleWindows() : this.mWebSettingsImpl.supportMultipleWindows();
        return supportMultipleWindows;
    }

    public boolean supportZoom() {
        return (!this.isUseX5 || this.mWebSettingsImpl == null) ? (this.isUseX5 || this.mSystemWebSettings == null) ? false : this.mSystemWebSettings.supportZoom() : this.mWebSettingsImpl.supportZoom();
    }
}
