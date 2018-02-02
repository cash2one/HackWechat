package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.a.a$a;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.List;

public final class h extends Preference {
    private Context mContext = null;
    private View mView = null;
    List<a$a> pfi = null;

    public h(Context context) {
        super(context);
        this.mContext = context;
        setLayoutResource(R.i.dpz);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        GridView gridView = (GridView) this.mView.findViewById(R.h.cuN);
        b bVar = new b(this);
        gridView.setAdapter(bVar);
        if (this.pfi != null) {
            List list = this.pfi;
            bVar.pVE.clear();
            bVar.pVI.clear();
            bVar.pVI = list;
            bVar.notifyDataSetChanged();
        }
    }
}
