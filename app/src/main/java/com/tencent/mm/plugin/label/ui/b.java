package com.tencent.mm.plugin.label.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMTextView;
import java.util.ArrayList;

public final class b extends BaseAdapter {
    private Context mContext;
    String nPC;
    ArrayList<String> nPD = new ArrayList();
    SparseArray<SpannableString> nPE = new SparseArray();

    public final /* synthetic */ Object getItem(int i) {
        return kC(i);
    }

    public b(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.nPD == null ? 0 : this.nPD.size();
    }

    public final String kC(int i) {
        return (this.nPD == null || i >= getCount()) ? null : (String) this.nPD.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.i.deP, viewGroup, false);
            cVar = new c(view);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        MMTextView mMTextView = cVar.nQe;
        Object az = bh.az(kC(i), "");
        int textSize = (int) cVar.nQe.getTextSize();
        int hashCode = az.hashCode();
        CharSequence charSequence = (SpannableString) this.nPE.get(hashCode);
        if (charSequence == null) {
            charSequence = new SpannableString(i.c(this.mContext, az, textSize));
            textSize = az.indexOf(this.nPC);
            if (textSize == -1) {
                x.w("MicroMsg.Label.ContactLabelSearchAdapter", "hight light %s error.", new Object[]{az});
            } else {
                int length = this.nPC.length() + textSize;
                charSequence.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(R.e.bui)), textSize, length, 33);
                charSequence.setSpan(new StyleSpan(1), textSize, length, 33);
                this.nPE.put(hashCode, charSequence);
            }
        }
        mMTextView.setText(charSequence);
        return view;
    }
}
