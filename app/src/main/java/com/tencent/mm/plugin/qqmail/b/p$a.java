package com.tencent.mm.plugin.qqmail.b;

import java.util.Map;

public abstract class p$a {
    public abstract void onError(int i, String str);

    public abstract void onSuccess(String str, Map<String, String> map);

    public boolean onReady() {
        return true;
    }

    public void onProgress(int i) {
    }

    public void onComplete() {
    }
}
