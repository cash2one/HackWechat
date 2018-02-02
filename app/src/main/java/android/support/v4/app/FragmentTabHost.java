package android.support.v4.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import java.util.ArrayList;

public class FragmentTabHost extends TabHost implements OnTabChangeListener {
    private final ArrayList<a> kb = new ArrayList();
    private int mContainerId;
    private Context mContext;
    private m ra;
    private OnTabChangeListener rh;
    private a ri;
    private boolean rj;

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.mContainerId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public void setOnTabChangedListener(OnTabChangeListener onTabChangeListener) {
        this.rh = onTabChangeListener;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        q qVar = null;
        for (int i = 0; i < this.kb.size(); i++) {
            a aVar = (a) this.kb.get(i);
            aVar.pL = this.ra.p(aVar.tag);
            if (!(aVar.pL == null || aVar.pL.isDetached())) {
                if (aVar.tag.equals(currentTabTag)) {
                    this.ri = aVar;
                } else {
                    if (qVar == null) {
                        qVar = this.ra.aS();
                    }
                    qVar.c(aVar.pL);
                }
            }
        }
        this.rj = true;
        q a = a(currentTabTag, qVar);
        if (a != null) {
            a.commit();
            this.ra.executePendingTransactions();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.rj = false;
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.rk = getCurrentTabTag();
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setCurrentTabByTag(savedState.rk);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void onTabChanged(String str) {
        if (this.rj) {
            q a = a(str, null);
            if (a != null) {
                a.commit();
            }
        }
        if (this.rh != null) {
            this.rh.onTabChanged(str);
        }
    }

    private q a(String str, q qVar) {
        a aVar = null;
        int i = 0;
        while (i < this.kb.size()) {
            a aVar2 = (a) this.kb.get(i);
            if (!aVar2.tag.equals(str)) {
                aVar2 = aVar;
            }
            i++;
            aVar = aVar2;
        }
        if (aVar == null) {
            throw new IllegalStateException("No tab known for tag " + str);
        }
        if (this.ri != aVar) {
            if (qVar == null) {
                qVar = this.ra.aS();
            }
            if (!(this.ri == null || this.ri.pL == null)) {
                qVar.c(this.ri.pL);
            }
            if (aVar != null) {
                if (aVar.pL == null) {
                    aVar.pL = Fragment.instantiate(this.mContext, aVar.rl.getName(), aVar.rm);
                    qVar.a(this.mContainerId, aVar.pL, aVar.tag);
                } else {
                    qVar.d(aVar.pL);
                }
            }
            this.ri = aVar;
        }
        return qVar;
    }
}
