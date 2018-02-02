package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.R;

public class FileSelectorFolderView$b extends BaseAdapter {
    private Context mContext;

    public FileSelectorFolderView$b(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return 2;
    }

    public final Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        FileSelectorFolderView$c fileSelectorFolderView$c;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.i.din, null);
            fileSelectorFolderView$c = new FileSelectorFolderView$c(view);
            view.setTag(fileSelectorFolderView$c);
        } else {
            fileSelectorFolderView$c = (FileSelectorFolderView$c) view.getTag();
        }
        switch (i) {
            case 0:
                fileSelectorFolderView$c.ihS.setText(R.l.ehh);
                break;
            case 1:
                fileSelectorFolderView$c.ihS.setText(R.l.ehi);
                break;
            default:
                fileSelectorFolderView$c.ihS.setText(R.l.dEJ);
                break;
        }
        return view;
    }
}
