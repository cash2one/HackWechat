package com.tencent.mm.console;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.ClipboardManager;
import android.widget.Toast;
import com.tencent.mm.R;

class b$13 implements OnClickListener {
    final /* synthetic */ Context gIm;
    final /* synthetic */ String gIn;

    b$13(Context context, String str) {
        this.gIm = context;
        this.gIn = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ((ClipboardManager) this.gIm.getSystemService("clipboard")).setText(this.gIn);
        Toast.makeText(this.gIm, R.l.eVp, 0).show();
    }
}
