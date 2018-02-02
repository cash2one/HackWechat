package com.tencent.magicbrush.engine;

import java.nio.ByteBuffer;

public class b {
    protected a bnA;
    protected long bnB;
    protected boolean bnC;

    public b() {
        this.bnA = new a();
        this.bnC = true;
        this.bnB = JsEngine.createVMContext(this.bnA.bnz);
    }

    public final a sB() {
        return this.bnA;
    }

    public b(a aVar) {
        this.bnA = aVar;
        this.bnB = JsEngine.createVMContext(aVar.bnz);
    }

    public void dispose() {
        if (this.bnB != 0) {
            JsEngine.releaseVMContext(this.bnB);
            this.bnB = 0;
            if (this.bnC && this.bnA != null) {
                this.bnA.dispose();
                this.bnA = null;
            }
        }
    }

    public final String by(String str) {
        if (this.bnB == 0) {
            return "";
        }
        return JsEngine.evaluateJavascript(this.bnB, str);
    }

    public final String q(String str, String str2) {
        if (this.bnB == 0) {
            return "";
        }
        return JsEngine.evaluateJavascriptFile(this.bnB, str, str2);
    }

    public final void c(Object obj, String str) {
        if (JsClassUtils.hasJavascriptInterface(obj)) {
            JsEngine.addJsInterface(this.bnB, obj, str);
        }
    }

    public final boolean a(b bVar, String str) {
        return JsEngine.pushObject(this.bnB, bVar.bnB, str);
    }

    public final ByteBuffer ef(int i) {
        ByteBuffer nativeBuffer = JsEngine.getNativeBuffer(i, this.bnA.bnz);
        if (nativeBuffer == null) {
            return ByteBuffer.allocate(0);
        }
        return nativeBuffer;
    }
}
