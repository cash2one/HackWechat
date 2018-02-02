package org.xwalk.core;

import java.util.ArrayList;

public class XWalkCookieManager {
    static final /* synthetic */ boolean $assertionsDisabled = (!XWalkCookieManager.class.desiredAssertionStatus());
    private ReflectMethod acceptCookieMethod = new ReflectMethod(null, "acceptCookie", new Class[0]);
    private ReflectMethod allowFileSchemeCookiesMethod = new ReflectMethod(null, "allowFileSchemeCookies", new Class[0]);
    private Object bridge;
    private ArrayList<Object> constructorParams = new ArrayList();
    private ArrayList<Object> constructorTypes = new ArrayList();
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod flushCookieStoreMethod = new ReflectMethod(null, "flushCookieStore", new Class[0]);
    private ReflectMethod getCookieStringMethod = new ReflectMethod(null, "getCookie", new Class[0]);
    private ReflectMethod hasCookiesMethod = new ReflectMethod(null, "hasCookies", new Class[0]);
    private ReflectMethod postWrapperMethod;
    private ReflectMethod removeAllCookieMethod = new ReflectMethod(null, "removeAllCookie", new Class[0]);
    private ReflectMethod removeExpiredCookieMethod = new ReflectMethod(null, "removeExpiredCookie", new Class[0]);
    private ReflectMethod removeSessionCookieMethod = new ReflectMethod(null, "removeSessionCookie", new Class[0]);
    private ReflectMethod setAcceptCookiebooleanMethod = new ReflectMethod(null, "setAcceptCookie", new Class[0]);
    private ReflectMethod setAcceptFileSchemeCookiesbooleanMethod = new ReflectMethod(null, "setAcceptFileSchemeCookies", new Class[0]);
    private ReflectMethod setCookieStringStringMethod = new ReflectMethod(null, "setCookie", new Class[0]);

    protected Object getBridge() {
        return this.bridge;
    }

    public XWalkCookieManager() {
        reflectionInit();
    }

    public void setAcceptCookie(boolean z) {
        try {
            this.setAcceptCookiebooleanMethod.invoke(Boolean.valueOf(z));
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public boolean acceptCookie() {
        try {
            return ((Boolean) this.acceptCookieMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public void setCookie(String str, String str2) {
        try {
            this.setCookieStringStringMethod.invoke(str, str2);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public String getCookie(String str) {
        try {
            return (String) this.getCookieStringMethod.invoke(str);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public void removeSessionCookie() {
        try {
            this.removeSessionCookieMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void removeAllCookie() {
        try {
            this.removeAllCookieMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public boolean hasCookies() {
        try {
            return ((Boolean) this.hasCookiesMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public void removeExpiredCookie() {
        try {
            this.removeExpiredCookieMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void flushCookieStore() {
        try {
            this.flushCookieStoreMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public boolean allowFileSchemeCookies() {
        try {
            return ((Boolean) this.allowFileSchemeCookiesMethod.invoke(new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return false;
        }
    }

    public void setAcceptFileSchemeCookies(boolean z) {
        try {
            this.setAcceptFileSchemeCookiesbooleanMethod.invoke(Boolean.valueOf(z));
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
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
        int size = this.constructorTypes.size();
        Class[] clsArr = new Class[(size + 1)];
        for (int i = 0; i < size; i++) {
            Object obj = this.constructorTypes.get(i);
            if (obj instanceof String) {
                clsArr[i] = this.coreWrapper.getBridgeClass((String) obj);
                this.constructorParams.set(i, this.coreWrapper.getBridgeObject(this.constructorParams.get(i)));
            } else if (obj instanceof Class) {
                clsArr[i] = (Class) obj;
            } else if (!$assertionsDisabled) {
                throw new AssertionError();
            }
        }
        clsArr[size] = Object.class;
        this.constructorParams.add(this);
        try {
            this.bridge = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkCookieManagerBridge"), clsArr).newInstance(this.constructorParams.toArray());
            if (this.postWrapperMethod != null) {
                this.postWrapperMethod.invoke(new Object[0]);
            }
            this.setAcceptCookiebooleanMethod.init(this.bridge, null, "setAcceptCookieSuper", Boolean.TYPE);
            this.acceptCookieMethod.init(this.bridge, null, "acceptCookieSuper", new Class[0]);
            this.setCookieStringStringMethod.init(this.bridge, null, "setCookieSuper", String.class, String.class);
            this.getCookieStringMethod.init(this.bridge, null, "getCookieSuper", String.class);
            this.removeSessionCookieMethod.init(this.bridge, null, "removeSessionCookieSuper", new Class[0]);
            this.removeAllCookieMethod.init(this.bridge, null, "removeAllCookieSuper", new Class[0]);
            this.hasCookiesMethod.init(this.bridge, null, "hasCookiesSuper", new Class[0]);
            this.removeExpiredCookieMethod.init(this.bridge, null, "removeExpiredCookieSuper", new Class[0]);
            this.flushCookieStoreMethod.init(this.bridge, null, "flushCookieStoreSuper", new Class[0]);
            this.allowFileSchemeCookiesMethod.init(this.bridge, null, "allowFileSchemeCookiesSuper", new Class[0]);
            this.setAcceptFileSchemeCookiesbooleanMethod.init(this.bridge, null, "setAcceptFileSchemeCookiesSuper", Boolean.TYPE);
        } catch (UnsupportedOperationException e) {
        }
    }
}
