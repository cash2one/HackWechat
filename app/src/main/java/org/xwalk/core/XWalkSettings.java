package org.xwalk.core;

import java.util.ArrayList;

public class XWalkSettings {
    public static final int LOAD_CACHE_ELSE_NETWORK = 1;
    public static final int LOAD_CACHE_ONLY = 3;
    public static final int LOAD_DEFAULT = -1;
    public static final int LOAD_NO_CACHE = 2;
    private ReflectMethod SetLogCallBackXWalkLogMessageListenerInternalMethod = new ReflectMethod(null, "SetLogCallBack", new Class[0]);
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod enumLayoutAlgorithmClassValueOfMethod = new ReflectMethod();
    private ReflectMethod getAcceptLanguagesMethod = new ReflectMethod(null, "getAcceptLanguages", new Class[0]);
    private ReflectMethod getAllowContentAccessMethod = new ReflectMethod(null, "getAllowContentAccess", new Class[0]);
    private ReflectMethod getAllowFileAccessFromFileURLsMethod = new ReflectMethod(null, "getAllowFileAccessFromFileURLs", new Class[0]);
    private ReflectMethod getAllowFileAccessMethod = new ReflectMethod(null, "getAllowFileAccess", new Class[0]);
    private ReflectMethod getAllowUniversalAccessFromFileURLsMethod = new ReflectMethod(null, "getAllowUniversalAccessFromFileURLs", new Class[0]);
    private ReflectMethod getBlockNetworkImageMethod = new ReflectMethod(null, "getBlockNetworkImage", new Class[0]);
    private ReflectMethod getBlockNetworkLoadsMethod = new ReflectMethod(null, "getBlockNetworkLoads", new Class[0]);
    private ReflectMethod getBuiltInZoomControlsMethod = new ReflectMethod(null, "getBuiltInZoomControls", new Class[0]);
    private ReflectMethod getCacheModeMethod = new ReflectMethod(null, "getCacheMode", new Class[0]);
    private ReflectMethod getDatabaseEnabledMethod = new ReflectMethod(null, "getDatabaseEnabled", new Class[0]);
    private ReflectMethod getDefaultFixedFontSizeMethod = new ReflectMethod(null, "getDefaultFixedFontSize", new Class[0]);
    private ReflectMethod getDefaultFontSizeMethod = new ReflectMethod(null, "getDefaultFontSize", new Class[0]);
    private ReflectMethod getDomStorageEnabledMethod = new ReflectMethod(null, "getDomStorageEnabled", new Class[0]);
    private ReflectMethod getJavaScriptCanOpenWindowsAutomaticallyMethod = new ReflectMethod(null, "getJavaScriptCanOpenWindowsAutomatically", new Class[0]);
    private ReflectMethod getJavaScriptEnabledMethod = new ReflectMethod(null, "getJavaScriptEnabled", new Class[0]);
    private ReflectMethod getLayoutAlgorithmMethod = new ReflectMethod(null, "getLayoutAlgorithm", new Class[0]);
    private ReflectMethod getLoadWithOverviewModeMethod = new ReflectMethod(null, "getLoadWithOverviewMode", new Class[0]);
    private ReflectMethod getLoadsImagesAutomaticallyMethod = new ReflectMethod(null, "getLoadsImagesAutomatically", new Class[0]);
    private ReflectMethod getMediaPlaybackRequiresUserGestureMethod = new ReflectMethod(null, "getMediaPlaybackRequiresUserGesture", new Class[0]);
    private ReflectMethod getSaveFormDataMethod = new ReflectMethod(null, "getSaveFormData", new Class[0]);
    private ReflectMethod getSupportQuirksModeMethod = new ReflectMethod(null, "getSupportQuirksMode", new Class[0]);
    private ReflectMethod getSupportSpatialNavigationMethod = new ReflectMethod(null, "getSupportSpatialNavigation", new Class[0]);
    private ReflectMethod getTextZoomMethod = new ReflectMethod(null, "getTextZoom", new Class[0]);
    private ReflectMethod getUseWideViewPortMethod = new ReflectMethod(null, "getUseWideViewPort", new Class[0]);
    private ReflectMethod getUserAgentStringMethod = new ReflectMethod(null, "getUserAgentString", new Class[0]);
    private ReflectMethod postWrapperMethod;
    private ReflectMethod setAcceptLanguagesStringMethod = new ReflectMethod(null, "setAcceptLanguages", new Class[0]);
    private ReflectMethod setAllowContentAccessbooleanMethod = new ReflectMethod(null, "setAllowContentAccess", new Class[0]);
    private ReflectMethod setAllowFileAccessFromFileURLsbooleanMethod = new ReflectMethod(null, "setAllowFileAccessFromFileURLs", new Class[0]);
    private ReflectMethod setAllowFileAccessbooleanMethod = new ReflectMethod(null, "setAllowFileAccess", new Class[0]);
    private ReflectMethod setAllowUniversalAccessFromFileURLsbooleanMethod = new ReflectMethod(null, "setAllowUniversalAccessFromFileURLs", new Class[0]);
    private ReflectMethod setAppCacheEnabledbooleanMethod = new ReflectMethod(null, "setAppCacheEnabled", new Class[0]);
    private ReflectMethod setAppCachePathStringMethod = new ReflectMethod(null, "setAppCachePath", new Class[0]);
    private ReflectMethod setBlockNetworkImagebooleanMethod = new ReflectMethod(null, "setBlockNetworkImage", new Class[0]);
    private ReflectMethod setBlockNetworkLoadsbooleanMethod = new ReflectMethod(null, "setBlockNetworkLoads", new Class[0]);
    private ReflectMethod setBuiltInZoomControlsbooleanMethod = new ReflectMethod(null, "setBuiltInZoomControls", new Class[0]);
    private ReflectMethod setCacheModeintMethod = new ReflectMethod(null, "setCacheMode", new Class[0]);
    private ReflectMethod setDatabaseEnabledbooleanMethod = new ReflectMethod(null, "setDatabaseEnabled", new Class[0]);
    private ReflectMethod setDefaultFixedFontSizeintMethod = new ReflectMethod(null, "setDefaultFixedFontSize", new Class[0]);
    private ReflectMethod setDefaultFontSizeintMethod = new ReflectMethod(null, "setDefaultFontSize", new Class[0]);
    private ReflectMethod setDomStorageEnabledbooleanMethod = new ReflectMethod(null, "setDomStorageEnabled", new Class[0]);
    private ReflectMethod setInitialPageScalefloatMethod = new ReflectMethod(null, "setInitialPageScale", new Class[0]);
    private ReflectMethod setJavaScriptCanOpenWindowsAutomaticallybooleanMethod = new ReflectMethod(null, "setJavaScriptCanOpenWindowsAutomatically", new Class[0]);
    private ReflectMethod setJavaScriptEnabledbooleanMethod = new ReflectMethod(null, "setJavaScriptEnabled", new Class[0]);
    private ReflectMethod setLayoutAlgorithmLayoutAlgorithmInternalMethod = new ReflectMethod(null, "setLayoutAlgorithm", new Class[0]);
    private ReflectMethod setLoadWithOverviewModebooleanMethod = new ReflectMethod(null, "setLoadWithOverviewMode", new Class[0]);
    private ReflectMethod setLoadsImagesAutomaticallybooleanMethod = new ReflectMethod(null, "setLoadsImagesAutomatically", new Class[0]);
    private ReflectMethod setMediaPlaybackRequiresUserGesturebooleanMethod = new ReflectMethod(null, "setMediaPlaybackRequiresUserGesture", new Class[0]);
    private ReflectMethod setSaveFormDatabooleanMethod = new ReflectMethod(null, "setSaveFormData", new Class[0]);
    private ReflectMethod setSupportMultipleWindowsbooleanMethod = new ReflectMethod(null, "setSupportMultipleWindows", new Class[0]);
    private ReflectMethod setSupportQuirksModebooleanMethod = new ReflectMethod(null, "setSupportQuirksMode", new Class[0]);
    private ReflectMethod setSupportSpatialNavigationbooleanMethod = new ReflectMethod(null, "setSupportSpatialNavigation", new Class[0]);
    private ReflectMethod setSupportZoombooleanMethod = new ReflectMethod(null, "setSupportZoom", new Class[0]);
    private ReflectMethod setTextZoomintMethod = new ReflectMethod(null, "setTextZoom", new Class[0]);
    private ReflectMethod setUseWideViewPortbooleanMethod = new ReflectMethod(null, "setUseWideViewPort", new Class[0]);
    private ReflectMethod setUserAgentStringStringMethod = new ReflectMethod(null, "setUserAgentString", new Class[0]);
    private ReflectMethod supportMultipleWindowsMethod = new ReflectMethod(null, "supportMultipleWindows", new Class[0]);
    private ReflectMethod supportZoomMethod = new ReflectMethod(null, "supportZoom", new Class[0]);
    private ReflectMethod supportsMultiTouchZoomForTestMethod = new ReflectMethod(null, "supportsMultiTouchZoomForTest", new Class[0]);

    private Object ConvertLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        return this.enumLayoutAlgorithmClassValueOfMethod.invoke(new Object[]{layoutAlgorithm.toString()});
    }

    protected Object getBridge() {
        return this.bridge;
    }

    public XWalkSettings(Object obj) {
        this.bridge = obj;
        reflectionInit();
    }

    public void setCacheMode(int i) {
        try {
            this.setCacheModeintMethod.invoke(new Object[]{Integer.valueOf(i)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public int getCacheMode() {
        try {
            return ((Integer) this.getCacheModeMethod.invoke(new Object[0])).intValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return 0;
        }
    }

    public void setBlockNetworkLoads(boolean z) {
        try {
            this.setBlockNetworkLoadsbooleanMethod.invoke(new Object[]{Boolean.valueOf(z)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public boolean getBlockNetworkLoads() {
        try {
            return ((Boolean) this.getBlockNetworkLoadsMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public void setAllowFileAccess(boolean z) {
        try {
            this.setAllowFileAccessbooleanMethod.invoke(new Object[]{Boolean.valueOf(z)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public boolean getAllowFileAccess() {
        try {
            return ((Boolean) this.getAllowFileAccessMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public void setAllowContentAccess(boolean z) {
        try {
            this.setAllowContentAccessbooleanMethod.invoke(new Object[]{Boolean.valueOf(z)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public boolean getAllowContentAccess() {
        try {
            return ((Boolean) this.getAllowContentAccessMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public void setJavaScriptEnabled(boolean z) {
        try {
            this.setJavaScriptEnabledbooleanMethod.invoke(new Object[]{Boolean.valueOf(z)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void setAllowUniversalAccessFromFileURLs(boolean z) {
        try {
            this.setAllowUniversalAccessFromFileURLsbooleanMethod.invoke(new Object[]{Boolean.valueOf(z)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void setAllowFileAccessFromFileURLs(boolean z) {
        try {
            this.setAllowFileAccessFromFileURLsbooleanMethod.invoke(new Object[]{Boolean.valueOf(z)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void setLoadsImagesAutomatically(boolean z) {
        try {
            this.setLoadsImagesAutomaticallybooleanMethod.invoke(new Object[]{Boolean.valueOf(z)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public boolean getLoadsImagesAutomatically() {
        try {
            return ((Boolean) this.getLoadsImagesAutomaticallyMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public void setBlockNetworkImage(boolean z) {
        try {
            this.setBlockNetworkImagebooleanMethod.invoke(new Object[]{Boolean.valueOf(z)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public boolean getBlockNetworkImage() {
        try {
            return ((Boolean) this.getBlockNetworkImageMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public boolean getJavaScriptEnabled() {
        try {
            return ((Boolean) this.getJavaScriptEnabledMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public boolean getAllowUniversalAccessFromFileURLs() {
        try {
            return ((Boolean) this.getAllowUniversalAccessFromFileURLsMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public boolean getAllowFileAccessFromFileURLs() {
        try {
            return ((Boolean) this.getAllowFileAccessFromFileURLsMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        try {
            this.setJavaScriptCanOpenWindowsAutomaticallybooleanMethod.invoke(new Object[]{Boolean.valueOf(z)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public boolean getJavaScriptCanOpenWindowsAutomatically() {
        try {
            return ((Boolean) this.getJavaScriptCanOpenWindowsAutomaticallyMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public void setSupportMultipleWindows(boolean z) {
        try {
            this.setSupportMultipleWindowsbooleanMethod.invoke(new Object[]{Boolean.valueOf(z)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public boolean supportMultipleWindows() {
        try {
            return ((Boolean) this.supportMultipleWindowsMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public void setUseWideViewPort(boolean z) {
        try {
            this.setUseWideViewPortbooleanMethod.invoke(new Object[]{Boolean.valueOf(z)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public boolean getUseWideViewPort() {
        try {
            return ((Boolean) this.getUseWideViewPortMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public void setAppCacheEnabled(boolean z) {
        try {
            this.setAppCacheEnabledbooleanMethod.invoke(new Object[]{Boolean.valueOf(z)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void setAppCachePath(String str) {
        try {
            this.setAppCachePathStringMethod.invoke(new Object[]{str});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void setDomStorageEnabled(boolean z) {
        try {
            this.setDomStorageEnabledbooleanMethod.invoke(new Object[]{Boolean.valueOf(z)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public boolean getDomStorageEnabled() {
        try {
            return ((Boolean) this.getDomStorageEnabledMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public void setDatabaseEnabled(boolean z) {
        try {
            this.setDatabaseEnabledbooleanMethod.invoke(new Object[]{Boolean.valueOf(z)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public boolean getDatabaseEnabled() {
        try {
            return ((Boolean) this.getDatabaseEnabledMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public void setMediaPlaybackRequiresUserGesture(boolean z) {
        try {
            this.setMediaPlaybackRequiresUserGesturebooleanMethod.invoke(new Object[]{Boolean.valueOf(z)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public boolean getMediaPlaybackRequiresUserGesture() {
        try {
            return ((Boolean) this.getMediaPlaybackRequiresUserGestureMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public void setUserAgentString(String str) {
        try {
            this.setUserAgentStringStringMethod.invoke(new Object[]{str});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public String getUserAgentString() {
        try {
            return (String) this.getUserAgentStringMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public void setAcceptLanguages(String str) {
        try {
            this.setAcceptLanguagesStringMethod.invoke(new Object[]{str});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public String getAcceptLanguages() {
        try {
            return (String) this.getAcceptLanguagesMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public void setSaveFormData(boolean z) {
        try {
            this.setSaveFormDatabooleanMethod.invoke(new Object[]{Boolean.valueOf(z)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public boolean getSaveFormData() {
        try {
            return ((Boolean) this.getSaveFormDataMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public void setInitialPageScale(float f) {
        try {
            this.setInitialPageScalefloatMethod.invoke(new Object[]{Float.valueOf(f)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void setTextZoom(int i) {
        if (i > 100) {
            try {
                i = ((i - 100) / 3) + 100;
            } catch (RuntimeException e) {
                if (this.coreWrapper == null) {
                    throw new RuntimeException("Crosswalk's APIs are not ready yet");
                }
                XWalkCoreWrapper.handleRuntimeError(e);
                return;
            }
        }
        this.setTextZoomintMethod.invoke(new Object[]{Integer.valueOf(i)});
    }

    public int getTextZoom() {
        try {
            return ((Integer) this.getTextZoomMethod.invoke(new Object[0])).intValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return 0;
        }
    }

    public void setDefaultFontSize(int i) {
        try {
            this.setDefaultFontSizeintMethod.invoke(new Object[]{Integer.valueOf(i)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public int getDefaultFontSize() {
        try {
            return ((Integer) this.getDefaultFontSizeMethod.invoke(new Object[0])).intValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return 0;
        }
    }

    public void setDefaultFixedFontSize(int i) {
        try {
            this.setDefaultFixedFontSizeintMethod.invoke(new Object[]{Integer.valueOf(i)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public int getDefaultFixedFontSize() {
        try {
            return ((Integer) this.getDefaultFixedFontSizeMethod.invoke(new Object[0])).intValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return 0;
        }
    }

    public void setSupportZoom(boolean z) {
        try {
            this.setSupportZoombooleanMethod.invoke(new Object[]{Boolean.valueOf(z)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public boolean supportZoom() {
        try {
            return ((Boolean) this.supportZoomMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public void setBuiltInZoomControls(boolean z) {
        try {
            this.setBuiltInZoomControlsbooleanMethod.invoke(new Object[]{Boolean.valueOf(z)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public boolean getBuiltInZoomControls() {
        try {
            return ((Boolean) this.getBuiltInZoomControlsMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public boolean supportsMultiTouchZoomForTest() {
        try {
            return ((Boolean) this.supportsMultiTouchZoomForTestMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public void setSupportSpatialNavigation(boolean z) {
        try {
            this.setSupportSpatialNavigationbooleanMethod.invoke(new Object[]{Boolean.valueOf(z)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public boolean getSupportSpatialNavigation() {
        try {
            return ((Boolean) this.getSupportSpatialNavigationMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public void setSupportQuirksMode(boolean z) {
        try {
            this.setSupportQuirksModebooleanMethod.invoke(new Object[]{Boolean.valueOf(z)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public boolean getSupportQuirksMode() {
        try {
            return ((Boolean) this.getSupportQuirksModeMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        try {
            this.setLayoutAlgorithmLayoutAlgorithmInternalMethod.invoke(new Object[]{ConvertLayoutAlgorithm(layoutAlgorithm)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public LayoutAlgorithm getLayoutAlgorithm() {
        try {
            return LayoutAlgorithm.valueOf(this.getLayoutAlgorithmMethod.invoke(new Object[0]).toString());
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public void setLoadWithOverviewMode(boolean z) {
        try {
            this.setLoadWithOverviewModebooleanMethod.invoke(new Object[]{Boolean.valueOf(z)});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public boolean getLoadWithOverviewMode() {
        try {
            return ((Boolean) this.getLoadWithOverviewModeMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public void SetLogCallBack(XWalkLogMessageListener xWalkLogMessageListener) {
        try {
            this.SetLogCallBackXWalkLogMessageListenerInternalMethod.invoke(new Object[]{xWalkLogMessageListener.getBridge()});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                this.SetLogCallBackXWalkLogMessageListenerInternalMethod.setArguments(new Object[]{new ReflectMethod(xWalkLogMessageListener, "getBridge", new Class[0])});
                XWalkCoreWrapper.reserveReflectMethod(this.SetLogCallBackXWalkLogMessageListenerInternalMethod);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    void reflectionInit() {
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            return;
        }
        this.enumLayoutAlgorithmClassValueOfMethod.init(null, this.coreWrapper.getBridgeClass("XWalkSettingsInternal$LayoutAlgorithmInternal"), "valueOf", new Class[]{String.class});
        this.setCacheModeintMethod.init(this.bridge, null, "setCacheModeSuper", new Class[]{Integer.TYPE});
        this.getCacheModeMethod.init(this.bridge, null, "getCacheModeSuper", new Class[0]);
        this.setBlockNetworkLoadsbooleanMethod.init(this.bridge, null, "setBlockNetworkLoadsSuper", new Class[]{Boolean.TYPE});
        this.getBlockNetworkLoadsMethod.init(this.bridge, null, "getBlockNetworkLoadsSuper", new Class[0]);
        this.setAllowFileAccessbooleanMethod.init(this.bridge, null, "setAllowFileAccessSuper", new Class[]{Boolean.TYPE});
        this.getAllowFileAccessMethod.init(this.bridge, null, "getAllowFileAccessSuper", new Class[0]);
        this.setAllowContentAccessbooleanMethod.init(this.bridge, null, "setAllowContentAccessSuper", new Class[]{Boolean.TYPE});
        this.getAllowContentAccessMethod.init(this.bridge, null, "getAllowContentAccessSuper", new Class[0]);
        this.setJavaScriptEnabledbooleanMethod.init(this.bridge, null, "setJavaScriptEnabledSuper", new Class[]{Boolean.TYPE});
        this.setAllowUniversalAccessFromFileURLsbooleanMethod.init(this.bridge, null, "setAllowUniversalAccessFromFileURLsSuper", new Class[]{Boolean.TYPE});
        this.setAllowFileAccessFromFileURLsbooleanMethod.init(this.bridge, null, "setAllowFileAccessFromFileURLsSuper", new Class[]{Boolean.TYPE});
        this.setLoadsImagesAutomaticallybooleanMethod.init(this.bridge, null, "setLoadsImagesAutomaticallySuper", new Class[]{Boolean.TYPE});
        this.getLoadsImagesAutomaticallyMethod.init(this.bridge, null, "getLoadsImagesAutomaticallySuper", new Class[0]);
        this.setBlockNetworkImagebooleanMethod.init(this.bridge, null, "setBlockNetworkImageSuper", new Class[]{Boolean.TYPE});
        this.getBlockNetworkImageMethod.init(this.bridge, null, "getBlockNetworkImageSuper", new Class[0]);
        this.getJavaScriptEnabledMethod.init(this.bridge, null, "getJavaScriptEnabledSuper", new Class[0]);
        this.getAllowUniversalAccessFromFileURLsMethod.init(this.bridge, null, "getAllowUniversalAccessFromFileURLsSuper", new Class[0]);
        this.getAllowFileAccessFromFileURLsMethod.init(this.bridge, null, "getAllowFileAccessFromFileURLsSuper", new Class[0]);
        this.setJavaScriptCanOpenWindowsAutomaticallybooleanMethod.init(this.bridge, null, "setJavaScriptCanOpenWindowsAutomaticallySuper", new Class[]{Boolean.TYPE});
        this.getJavaScriptCanOpenWindowsAutomaticallyMethod.init(this.bridge, null, "getJavaScriptCanOpenWindowsAutomaticallySuper", new Class[0]);
        this.setSupportMultipleWindowsbooleanMethod.init(this.bridge, null, "setSupportMultipleWindowsSuper", new Class[]{Boolean.TYPE});
        this.supportMultipleWindowsMethod.init(this.bridge, null, "supportMultipleWindowsSuper", new Class[0]);
        this.setUseWideViewPortbooleanMethod.init(this.bridge, null, "setUseWideViewPortSuper", new Class[]{Boolean.TYPE});
        this.getUseWideViewPortMethod.init(this.bridge, null, "getUseWideViewPortSuper", new Class[0]);
        this.setAppCacheEnabledbooleanMethod.init(this.bridge, null, "setAppCacheEnabledSuper", new Class[]{Boolean.TYPE});
        this.setAppCachePathStringMethod.init(this.bridge, null, "setAppCachePathSuper", new Class[]{String.class});
        this.setDomStorageEnabledbooleanMethod.init(this.bridge, null, "setDomStorageEnabledSuper", new Class[]{Boolean.TYPE});
        this.getDomStorageEnabledMethod.init(this.bridge, null, "getDomStorageEnabledSuper", new Class[0]);
        this.setDatabaseEnabledbooleanMethod.init(this.bridge, null, "setDatabaseEnabledSuper", new Class[]{Boolean.TYPE});
        this.getDatabaseEnabledMethod.init(this.bridge, null, "getDatabaseEnabledSuper", new Class[0]);
        this.setMediaPlaybackRequiresUserGesturebooleanMethod.init(this.bridge, null, "setMediaPlaybackRequiresUserGestureSuper", new Class[]{Boolean.TYPE});
        this.getMediaPlaybackRequiresUserGestureMethod.init(this.bridge, null, "getMediaPlaybackRequiresUserGestureSuper", new Class[0]);
        this.setUserAgentStringStringMethod.init(this.bridge, null, "setUserAgentStringSuper", new Class[]{String.class});
        this.getUserAgentStringMethod.init(this.bridge, null, "getUserAgentStringSuper", new Class[0]);
        this.setAcceptLanguagesStringMethod.init(this.bridge, null, "setAcceptLanguagesSuper", new Class[]{String.class});
        this.getAcceptLanguagesMethod.init(this.bridge, null, "getAcceptLanguagesSuper", new Class[0]);
        this.setSaveFormDatabooleanMethod.init(this.bridge, null, "setSaveFormDataSuper", new Class[]{Boolean.TYPE});
        this.getSaveFormDataMethod.init(this.bridge, null, "getSaveFormDataSuper", new Class[0]);
        this.setInitialPageScalefloatMethod.init(this.bridge, null, "setInitialPageScaleSuper", new Class[]{Float.TYPE});
        this.setTextZoomintMethod.init(this.bridge, null, "setTextZoomSuper", new Class[]{Integer.TYPE});
        this.getTextZoomMethod.init(this.bridge, null, "getTextZoomSuper", new Class[0]);
        this.setDefaultFontSizeintMethod.init(this.bridge, null, "setDefaultFontSizeSuper", new Class[]{Integer.TYPE});
        this.getDefaultFontSizeMethod.init(this.bridge, null, "getDefaultFontSizeSuper", new Class[0]);
        this.setDefaultFixedFontSizeintMethod.init(this.bridge, null, "setDefaultFixedFontSizeSuper", new Class[]{Integer.TYPE});
        this.getDefaultFixedFontSizeMethod.init(this.bridge, null, "getDefaultFixedFontSizeSuper", new Class[0]);
        this.setSupportZoombooleanMethod.init(this.bridge, null, "setSupportZoomSuper", new Class[]{Boolean.TYPE});
        this.supportZoomMethod.init(this.bridge, null, "supportZoomSuper", new Class[0]);
        this.setBuiltInZoomControlsbooleanMethod.init(this.bridge, null, "setBuiltInZoomControlsSuper", new Class[]{Boolean.TYPE});
        this.getBuiltInZoomControlsMethod.init(this.bridge, null, "getBuiltInZoomControlsSuper", new Class[0]);
        this.supportsMultiTouchZoomForTestMethod.init(this.bridge, null, "supportsMultiTouchZoomForTestSuper", new Class[0]);
        this.setSupportSpatialNavigationbooleanMethod.init(this.bridge, null, "setSupportSpatialNavigationSuper", new Class[]{Boolean.TYPE});
        this.getSupportSpatialNavigationMethod.init(this.bridge, null, "getSupportSpatialNavigationSuper", new Class[0]);
        this.setSupportQuirksModebooleanMethod.init(this.bridge, null, "setSupportQuirksModeSuper", new Class[]{Boolean.TYPE});
        this.getSupportQuirksModeMethod.init(this.bridge, null, "getSupportQuirksModeSuper", new Class[0]);
        this.setLayoutAlgorithmLayoutAlgorithmInternalMethod.init(this.bridge, null, "setLayoutAlgorithmSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkSettingsInternal$LayoutAlgorithmInternal")});
        this.getLayoutAlgorithmMethod.init(this.bridge, null, "getLayoutAlgorithmSuper", new Class[0]);
        this.setLoadWithOverviewModebooleanMethod.init(this.bridge, null, "setLoadWithOverviewModeSuper", new Class[]{Boolean.TYPE});
        this.getLoadWithOverviewModeMethod.init(this.bridge, null, "getLoadWithOverviewModeSuper", new Class[0]);
        this.SetLogCallBackXWalkLogMessageListenerInternalMethod.init(this.bridge, null, "SetLogCallBackSuper", new Class[]{this.coreWrapper.getBridgeClass("XWalkLogMessageListenerBridge")});
    }
}
