package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.widget.ActivityChooserView.a;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.wcdb.database.SQLiteGlobal;

class ActivityChooserView$b implements OnClickListener, OnLongClickListener, OnItemClickListener, OnDismissListener {
    final /* synthetic */ ActivityChooserView OK;

    private ActivityChooserView$b(ActivityChooserView activityChooserView) {
        this.OK = activityChooserView;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        switch (((a) adapterView.getAdapter()).getItemViewType(i)) {
            case 0:
                this.OK.en();
                if (!ActivityChooserView.d(this.OK)) {
                    if (!ActivityChooserView.a(this.OK).OO) {
                        i++;
                    }
                    Intent aK = ActivityChooserView.a(this.OK).OL.aK(i);
                    if (aK != null) {
                        aK.addFlags(SQLiteGlobal.journalSizeLimit);
                        this.OK.getContext().startActivity(aK);
                        return;
                    }
                    return;
                } else if (i > 0) {
                    d dVar = ActivityChooserView.a(this.OK).OL;
                    synchronized (dVar.Og) {
                        dVar.eh();
                        d.a aVar = (d.a) dVar.Oh.get(i);
                        d.a aVar2 = (d.a) dVar.Oh.get(0);
                        dVar.a(new d$c(new ComponentName(aVar.resolveInfo.activityInfo.packageName, aVar.resolveInfo.activityInfo.name), System.currentTimeMillis(), aVar2 != null ? (aVar2.weight - aVar.weight) + 5.0f : 1.0f));
                    }
                    return;
                } else {
                    return;
                }
            case 1:
                ActivityChooserView.a(this.OK, Integer.MAX_VALUE);
                return;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final void onClick(View view) {
        if (view == ActivityChooserView.e(this.OK)) {
            this.OK.en();
            Intent aK = ActivityChooserView.a(this.OK).OL.aK(ActivityChooserView.a(this.OK).OL.a(ActivityChooserView.a(this.OK).OL.eg()));
            if (aK != null) {
                aK.addFlags(SQLiteGlobal.journalSizeLimit);
                this.OK.getContext().startActivity(aK);
            }
        } else if (view == ActivityChooserView.f(this.OK)) {
            ActivityChooserView.a(this.OK, false);
            ActivityChooserView.a(this.OK, ActivityChooserView.g(this.OK));
        } else {
            throw new IllegalArgumentException();
        }
    }

    public final boolean onLongClick(View view) {
        if (view == ActivityChooserView.e(this.OK)) {
            if (ActivityChooserView.a(this.OK).getCount() > 0) {
                ActivityChooserView.a(this.OK, true);
                ActivityChooserView.a(this.OK, ActivityChooserView.g(this.OK));
            }
            return true;
        }
        throw new IllegalArgumentException();
    }

    public final void onDismiss() {
        if (ActivityChooserView.h(this.OK) != null) {
            ActivityChooserView.h(this.OK).onDismiss();
        }
        if (this.OK.OC != null) {
            this.OK.OC.o(false);
        }
    }
}
