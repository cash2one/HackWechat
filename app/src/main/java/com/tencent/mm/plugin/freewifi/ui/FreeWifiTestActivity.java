package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.h;

public class FreeWifiTestActivity extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.i.diH);
        findViewById(R.h.cjQ).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiTestActivity mIJ;

            {
                this.mIJ = r1;
            }

            public final void onClick(View view) {
                Toast.makeText(ac.getContext(), "test message", 0).show();
            }
        });
        findViewById(R.h.cjR).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiTestActivity mIJ;

            {
                this.mIJ = r1;
            }

            public final void onClick(View view) {
                h.a(this.mIJ, "t12345", "t54331", new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 mIK;

                    {
                        this.mIK = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }, null);
            }
        });
    }
}
