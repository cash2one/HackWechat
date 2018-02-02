package org.xwalk.core;

import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

public class ClientCertRequestHandler implements ClientCertRequest {
    private Object bridge;
    private ReflectMethod cancelMethod = new ReflectMethod(null, "cancel", new Class[0]);
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod getHostMethod = new ReflectMethod(null, "getHost", new Class[0]);
    private ReflectMethod getKeyTypesMethod = new ReflectMethod(null, "getKeyTypes", new Class[0]);
    private ReflectMethod getPortMethod = new ReflectMethod(null, "getPort", new Class[0]);
    private ReflectMethod getPrincipalsMethod = new ReflectMethod(null, "getPrincipals", new Class[0]);
    private ReflectMethod ignoreMethod = new ReflectMethod(null, "ignore", new Class[0]);
    private ReflectMethod postWrapperMethod;
    private ReflectMethod proceedPrivateKeyListMethod = new ReflectMethod(null, "proceed", new Class[0]);

    protected Object getBridge() {
        return this.bridge;
    }

    public ClientCertRequestHandler(Object obj) {
        this.bridge = obj;
        reflectionInit();
    }

    public void proceed(PrivateKey privateKey, List<X509Certificate> list) {
        try {
            this.proceedPrivateKeyListMethod.invoke(new Object[]{privateKey, list});
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void ignore() {
        try {
            this.ignoreMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public void cancel() {
        try {
            this.cancelMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
        }
    }

    public String getHost() {
        try {
            return (String) this.getHostMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public int getPort() {
        try {
            return ((Integer) this.getPortMethod.invoke(new Object[0])).intValue();
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return 0;
        }
    }

    public String[] getKeyTypes() {
        try {
            return (String[]) this.getKeyTypesMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    public Principal[] getPrincipals() {
        try {
            return (Principal[]) this.getPrincipalsMethod.invoke(new Object[0]);
        } catch (RuntimeException e) {
            if (this.coreWrapper == null) {
                throw new RuntimeException("Crosswalk's APIs are not ready yet");
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            return null;
        }
    }

    void reflectionInit() {
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            return;
        }
        this.proceedPrivateKeyListMethod.init(this.bridge, null, "proceedSuper", new Class[]{PrivateKey.class, List.class});
        this.ignoreMethod.init(this.bridge, null, "ignoreSuper", new Class[0]);
        this.cancelMethod.init(this.bridge, null, "cancelSuper", new Class[0]);
        this.getHostMethod.init(this.bridge, null, "getHostSuper", new Class[0]);
        this.getPortMethod.init(this.bridge, null, "getPortSuper", new Class[0]);
        this.getKeyTypesMethod.init(this.bridge, null, "getKeyTypesSuper", new Class[0]);
        this.getPrincipalsMethod.init(this.bridge, null, "getPrincipalsSuper", new Class[0]);
    }
}
