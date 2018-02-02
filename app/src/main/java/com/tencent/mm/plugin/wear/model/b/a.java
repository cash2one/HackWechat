package com.tencent.mm.plugin.wear.model.b;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.ac;

public final class a {
    public static void K(Bundle bundle) {
        Intent intent = new Intent();
        intent.setPackage(ac.getContext().getPackageName());
        intent.setAction("com.tencent.mm.wear.message");
        intent.putExtras(bundle);
        ac.getContext().sendBroadcast(intent);
    }
}
