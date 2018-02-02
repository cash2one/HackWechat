package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;

class ReaderAppSubscribeUI$a extends BaseAdapter {
    private final Context context;
    final int[] pAP = new int[]{1, 2, 4, 8, 16, 32, 64, FileUtils.S_IWUSR, 256, WXMediaMessage.TITLE_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2048, Downloads.RECV_BUFFER_SIZE, 8192};
    int pAQ;
    private String[] pAR = null;
    int pAS = 0;

    public final /* bridge */ /* synthetic */ Object getItem(int i) {
        return this.pAR[i];
    }

    public ReaderAppSubscribeUI$a(Context context, int i) {
        this.context = context;
        this.pAQ = i;
        this.pAR = context.getString(R.l.eBZ).split(";");
        this.pAS = vi(i);
    }

    public final int getCount() {
        return this.pAR.length;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            a aVar2 = new a();
            view = View.inflate(this.context, R.i.dqn, null);
            aVar2.iiq = (TextView) view.findViewById(R.h.cFP);
            aVar2.iis = (CheckBox) view.findViewById(R.h.cFO);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.iiq.setText(this.pAR[i]);
        aVar.iis.setChecked((this.pAQ & this.pAP[i]) != 0);
        return view;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    private int vi(int i) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.pAP.length) {
            if ((this.pAP[i2] & i) != 0) {
                i3++;
            }
            i2++;
        }
        return i3;
    }
}
