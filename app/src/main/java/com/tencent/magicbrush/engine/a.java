package com.tencent.magicbrush.engine;

public final class a {
    protected long bnz = JsEngine.createVM();

    public final void dispose() {
        if (this.bnz != 0) {
            JsEngine.releaseVM(this.bnz);
            this.bnz = 0;
        }
    }
}
