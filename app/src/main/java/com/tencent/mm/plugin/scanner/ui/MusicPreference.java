package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class MusicPreference extends Preference {
    private boolean lio;
    private View mView;
    private OnClickListener pGO;
    public String pSu;
    public String pSv;
    public String pSw;
    private ImageButton pVv;
    a pVw;

    public MusicPreference(Context context) {
        this(context, null);
    }

    public MusicPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MusicPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mView = null;
        this.pVv = null;
        this.pSu = "";
        this.pSv = "";
        this.pSw = "";
        setLayoutResource(R.i.dnY);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    public final void hH(boolean z) {
        this.lio = z;
        if (this.pVv == null) {
            return;
        }
        if (z) {
            this.pVv.setImageResource(R.g.bEL);
        } else {
            this.pVv.setImageResource(R.g.bEK);
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.pGO == null) {
            this.pGO = new OnClickListener(this) {
                final /* synthetic */ MusicPreference pVx;

                {
                    this.pVx = r1;
                }

                public final void onClick(View view) {
                    if (this.pVx.pVw != null && view.getId() == R.h.cDl) {
                        if (this.pVx.lio) {
                            this.pVx.lio = false;
                            this.pVx.pVv.setImageResource(R.g.bEK);
                        } else {
                            this.pVx.lio = true;
                            this.pVx.pVv.setImageResource(R.g.bEL);
                        }
                        this.pVx.pVw.d(this.pVx);
                    }
                }
            };
        }
        this.pVv = (ImageButton) view.findViewById(R.h.cDl);
        this.pVv.setOnClickListener(this.pGO);
        if (this.lio) {
            this.pVv.setImageResource(R.g.bEL);
        } else {
            this.pVv.setImageResource(R.g.bEK);
        }
    }
}
