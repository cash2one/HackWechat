package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(7)
public class AppBrandProxyTransparentUI extends MMActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.AppBrandProxyTransparentUI", "onCreate");
        try {
            getIntent().getExtras().setClassLoader(Class.forName(getIntent().getStringExtra("task_class_name")).getClassLoader());
        } catch (ClassNotFoundException e) {
            x.e("MicroMsg.AppBrandProxyTransparentUI", "ClassNotFoundException");
            setResult(1);
            finish();
        }
        final AppBrandProxyTransparentUIProcessTask appBrandProxyTransparentUIProcessTask = (AppBrandProxyTransparentUIProcessTask) getIntent().getParcelableExtra("task_object");
        final String stringExtra = getIntent().getStringExtra("task_id");
        if (appBrandProxyTransparentUIProcessTask != null) {
            appBrandProxyTransparentUIProcessTask.a(this, new AppBrandProxyTransparentUIProcessTask.a(this) {
                final /* synthetic */ AppBrandProxyTransparentUI jbk;

                public final void afh() {
                    x.i("MicroMsg.AppBrandProxyTransparentUI", "onResult");
                    Intent intent = new Intent();
                    intent.putExtra("task_object", appBrandProxyTransparentUIProcessTask);
                    intent.putExtra("task_id", stringExtra);
                    this.jbk.setResult(-1, intent);
                    this.jbk.finish();
                }
            });
            return;
        }
        setResult(1);
        finish();
    }

    public void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.AppBrandProxyTransparentUI", "onDestroy");
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected final void afg() {
        int intExtra = getIntent().getIntExtra("orientation", -1);
        if (intExtra != -1) {
            setRequestedOrientation(intExtra);
        }
    }
}
