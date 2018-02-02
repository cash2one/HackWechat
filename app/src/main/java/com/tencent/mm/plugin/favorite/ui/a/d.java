package com.tencent.mm.plugin.favorite.ui.a;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public abstract class d extends BaseAdapter implements OnClickListener {
    private Context context;
    public String muF;
    public List<String> muG = new LinkedList();
    public SparseArray<SpannableString> muH = new SparseArray();

    public abstract void zs(String str);

    public /* synthetic */ Object getItem(int i) {
        return kC(i);
    }

    public d(Context context) {
        this.context = context;
    }

    public int getCount() {
        return this.muG.size();
    }

    private String kC(int i) {
        return (String) this.muG.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = View.inflate(this.context, R.i.dhP, null);
            view.setOnClickListener(this);
        }
        TextView textView = (TextView) view.findViewById(R.h.cJI);
        Object az = bh.az(kC(i), "");
        int textSize = (int) textView.getTextSize();
        int hashCode = az.hashCode();
        CharSequence charSequence = (SpannableString) this.muH.get(hashCode);
        if (charSequence == null) {
            charSequence = new SpannableString(i.c(this.context, az, textSize));
            textSize = az.indexOf(this.muF);
            if (-1 == textSize) {
                x.w("MicroMsg.FavoriteTagSearchAdapter", "high light %s error", new Object[]{az});
            } else {
                int length = this.muF.length() + textSize;
                charSequence.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.e.bui)), textSize, length, 33);
                charSequence.setSpan(new StyleSpan(1), textSize, length, 33);
                this.muH.put(hashCode, charSequence);
            }
        }
        textView.setText(charSequence);
        return view;
    }

    public void onClick(View view) {
        x.d("MicroMsg.FavoriteTagSearchAdapter", "select search tag %s", new Object[]{((TextView) view.findViewById(R.h.cJI)).getText().toString()});
        zs(r0);
    }
}
