package com.tencent.mm.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.ui.applet.SecurityImage.1;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.i.a;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.k;

public class SecurityImage$a {
    public static SecurityImage a(Context context, int i, int i2, byte[] bArr, String str, String str2, final OnClickListener onClickListener, OnCancelListener onCancelListener, OnDismissListener onDismissListener, b bVar) {
        final SecurityImage securityImage = (SecurityImage) View.inflate(context, h.gYc, null);
        if (securityImage.xWs != null) {
            securityImage.xWs.xWv = null;
        }
        securityImage.xWs = bVar;
        securityImage.xWs.xWv = securityImage;
        securityImage.xWo = (ProgressBar) securityImage.findViewById(g.gWe);
        securityImage.xWp = (ImageView) securityImage.findViewById(g.gVo);
        securityImage.xWq = (Button) securityImage.findViewById(g.gVm);
        securityImage.xWr = (EditText) securityImage.findViewById(g.gVn);
        securityImage.xWq.setOnClickListener(new 1(securityImage));
        securityImage.a(i2, bArr, str, str2);
        a aVar = new a(context);
        aVar.Ez(i);
        aVar.EC(k.dEr).a(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                onClickListener.onClick(dialogInterface, i);
            }
        });
        aVar.d(onCancelListener);
        aVar.dk(securityImage);
        aVar.mi(true);
        SecurityImage.a(securityImage, aVar.akx());
        SecurityImage.c(securityImage).setOnDismissListener(onDismissListener);
        SecurityImage.c(securityImage).show();
        return securityImage;
    }
}
