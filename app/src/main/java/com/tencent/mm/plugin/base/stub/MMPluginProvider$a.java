package com.tencent.mm.plugin.base.stub;

import android.content.Context;

protected abstract class MMPluginProvider$a {
    private Context context = null;

    protected MMPluginProvider$a() {
    }

    public boolean cm(Context context) {
        this.context = context;
        return true;
    }
}
