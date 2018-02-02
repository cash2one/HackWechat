package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import java.io.File;

class c$a implements OnClickListener {
    private String filePath;
    final /* synthetic */ c mTq;

    public c$a(c cVar, String str) {
        this.mTq = cVar;
        this.filePath = str;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(this.filePath)), "video/*");
        try {
            this.mTq.mContext.startActivity(intent);
        } catch (Exception e) {
        }
    }
}
