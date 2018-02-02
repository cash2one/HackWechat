package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue.JsValueFactory;

public class e {
    private final c zVu;
    private final IX5JsValue zVv;

    private static class a implements JsValueFactory {
        private a() {
        }

        public final String getJsValueClassName() {
            return e.class.getName();
        }

        public final IX5JsValue unwrap(Object obj) {
            return (obj == null || !(obj instanceof e)) ? null : ((e) obj).zVv;
        }

        public final Object wrap(IX5JsValue iX5JsValue) {
            if (iX5JsValue != null) {
                c cDP = c.cDP();
                if (cDP != null) {
                    return new e(cDP, iX5JsValue);
                }
            }
            return null;
        }
    }

    protected e(c cVar, IX5JsValue iX5JsValue) {
        this.zVu = cVar;
        this.zVv = iX5JsValue;
    }

    protected static JsValueFactory cDQ() {
        return new a();
    }

    public String toString() {
        return this.zVv.toString();
    }
}
