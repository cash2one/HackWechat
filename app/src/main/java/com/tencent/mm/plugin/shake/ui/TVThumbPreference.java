package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.shake.e.b;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class TVThumbPreference extends Preference implements a {
    f jKn;
    private ImageView qsG;
    private ImageView qsH;
    private ImageView qsI;
    List<String> qsJ;

    public TVThumbPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qsJ = null;
        setLayoutResource(R.i.dtn);
        setWidgetLayoutResource(0);
        j.a(this);
    }

    public TVThumbPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TVThumbPreference(Context context) {
        this(context, null);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        return super.onCreateView(viewGroup);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.qsG = (ImageView) view.findViewById(R.h.cRf);
        this.qsH = (ImageView) view.findViewById(R.h.cRg);
        this.qsI = (ImageView) view.findViewById(R.h.cRh);
        if (this.qsJ != null && this.qsJ.size() > 0) {
            i bVar = new b((String) this.qsJ.get(0));
            this.qsG.setTag(bVar.Wh());
            Bitmap a = j.a(bVar);
            if (!(a == null || a.isRecycled())) {
                this.qsG.setImageBitmap(a);
            }
            this.qsG.setVisibility(0);
            if (1 < this.qsJ.size()) {
                bVar = new b((String) this.qsJ.get(1));
                this.qsH.setTag(bVar.Wh());
                a = j.a(bVar);
                if (!(a == null || a.isRecycled())) {
                    this.qsH.setImageBitmap(a);
                }
                this.qsH.setVisibility(0);
                if (2 < this.qsJ.size()) {
                    bVar = new b((String) this.qsJ.get(2));
                    this.qsI.setTag(bVar.Wh());
                    a = j.a(bVar);
                    if (!(a == null || a.isRecycled())) {
                        this.qsI.setImageBitmap(a);
                    }
                    this.qsI.setVisibility(0);
                }
            }
        }
    }

    public final void l(String str, final Bitmap bitmap) {
        if (str != null && bitmap != null && !bitmap.isRecycled()) {
            if (this.qsG != null && this.qsG.getTag() != null && str.equals((String) this.qsG.getTag())) {
                this.qsG.post(new Runnable(this) {
                    final /* synthetic */ TVThumbPreference qsK;

                    public final void run() {
                        this.qsK.qsG.setImageBitmap(bitmap);
                        if (this.qsK.jKn != null) {
                            this.qsK.jKn.notifyDataSetChanged();
                        }
                    }
                });
            } else if (this.qsH != null && this.qsH.getTag() != null && str.equals((String) this.qsH.getTag())) {
                this.qsH.post(new Runnable(this) {
                    final /* synthetic */ TVThumbPreference qsK;

                    public final void run() {
                        this.qsK.qsH.setImageBitmap(bitmap);
                        if (this.qsK.jKn != null) {
                            this.qsK.jKn.notifyDataSetChanged();
                        }
                    }
                });
            } else if (this.qsI != null && this.qsI.getTag() != null && str.equals((String) this.qsI.getTag())) {
                this.qsI.post(new Runnable(this) {
                    final /* synthetic */ TVThumbPreference qsK;

                    public final void run() {
                        this.qsK.qsI.setImageBitmap(bitmap);
                        if (this.qsK.jKn != null) {
                            this.qsK.jKn.notifyDataSetChanged();
                        }
                    }
                });
            }
        }
    }
}
