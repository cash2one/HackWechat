package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

public class MailAttachListLinearLayout extends LinearLayout {
    Context context;
    List<String> ptl = new ArrayList();

    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ String ptm;
        final /* synthetic */ String ptn;
        final /* synthetic */ String pto;
        final /* synthetic */ long ptp;
        final /* synthetic */ int ptq;
        final /* synthetic */ String ptr;
        final /* synthetic */ MailAttachListLinearLayout pts;

        AnonymousClass1(MailAttachListLinearLayout mailAttachListLinearLayout, String str, String str2, String str3, long j, int i, String str4) {
            this.pts = mailAttachListLinearLayout;
            this.ptm = str;
            this.ptn = str2;
            this.pto = str3;
            this.ptp = j;
            this.ptq = i;
            this.ptr = str4;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.pts.context, AttachDownloadPage.class);
            intent.putExtra("attach_name", this.ptm);
            intent.putExtra("mail_id", this.ptn);
            intent.putExtra("attach_id", this.pto);
            intent.putExtra("total_size", this.ptp);
            intent.putExtra("is_preview", this.ptq);
            intent.putExtra("is_compress", MailAttachListLinearLayout.HU(this.ptr));
            this.pts.context.startActivity(intent);
        }
    }

    static /* synthetic */ boolean HU(String str) {
        return str != null && str.contains("/cgi-bin/viewcompress");
    }

    public MailAttachListLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    static String dK(String str, String str2) {
        if (str == null || str.length() == 0 || str2.length() == 0) {
            return null;
        }
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return null;
        }
        int indexOf2 = str.indexOf("&", indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        return str.substring((indexOf + str2.length()) + 1, indexOf2);
    }
}
