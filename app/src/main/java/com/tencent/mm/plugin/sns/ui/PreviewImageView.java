package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i$e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.h;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PreviewImageView extends LinearLayout implements w {
    private final Context context;
    private List<String> list = new ArrayList();
    private TableLayout rvR;
    private final Map<Integer, View> rvS = new HashMap();
    private final Map<Integer, TableRow> rvT = new HashMap();
    private final int rvU = 4;
    private HashMap<String, Bitmap> rvV = new HashMap();
    private w$a rvW;
    private boolean rvX = true;
    private boolean rvY = false;

    class a extends h<String, Integer, Boolean> {
        private ImageView fyg;
        private Bitmap hkT;
        private String path;
        final /* synthetic */ PreviewImageView rvZ;

        public final /* synthetic */ Object buP() {
            if (this.rvZ.rvY) {
                return Boolean.valueOf(false);
            }
            this.hkT = d.d(this.path, ae.bvD(), ae.bvD(), true);
            x.d("MicroMsg.MMAsyncTask", "exifPath : %s degree : %d", new Object[]{this.path, Integer.valueOf(Exif.fromFile(this.path).getOrientationInDegree())});
            this.hkT = d.b(this.hkT, (float) r0);
            return Boolean.valueOf(true);
        }

        public final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Boolean) obj);
            if (!this.rvZ.rvY && i.m(this.hkT)) {
                this.rvZ.rvV.put(this.path, this.hkT);
                if (this.fyg.getTag() != null && (this.fyg.getTag() instanceof String) && this.fyg.getTag().equals(this.path)) {
                    this.fyg.setImageBitmap(this.hkT);
                }
            }
        }

        public a(PreviewImageView previewImageView, ImageView imageView, String str) {
            this.rvZ = previewImageView;
            this.fyg = imageView;
            this.path = str;
        }

        public final af buO() {
            return ae.bvg();
        }
    }

    public PreviewImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public PreviewImageView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public final void bzs() {
        this.rvX = false;
    }

    public final View getView() {
        return this;
    }

    public final void a(w$a com_tencent_mm_plugin_sns_ui_w_a) {
        this.rvW = com_tencent_mm_plugin_sns_ui_w_a;
    }

    private void init() {
        this.rvR = (TableLayout) LayoutInflater.from(this.context).inflate(g.qHJ, this, true).findViewById(f.content);
    }

    public final void clean() {
        this.rvY = true;
        for (Bitmap bitmap : this.rvV.values()) {
            if (i.m(bitmap)) {
                bitmap.recycle();
            }
        }
    }

    public final void bU(List<String> list) {
        long currentTimeMillis = System.currentTimeMillis();
        if (list != null) {
            this.list = list;
            int i = 0;
            this.rvR.removeAllViews();
            int size = list.size() + 1;
            int i2 = 0;
            while (i < size) {
                View view;
                int i3;
                View view2 = (TableRow) this.rvT.get(Integer.valueOf(i2));
                if (view2 == null) {
                    view2 = new TableRow(this.context);
                    this.rvT.put(Integer.valueOf(i2), view2);
                    view = view2;
                } else {
                    view = view2;
                }
                view.removeAllViews();
                for (int i4 = 0; i4 < 4 && i < size; i4++) {
                    if (i >= 9) {
                        i3 = i + 1;
                        break;
                    }
                    String str;
                    view2 = (View) this.rvS.get(Integer.valueOf(i));
                    if (view2 == null) {
                        view2 = View.inflate(this.context, g.qHK, null);
                        this.rvS.put(Integer.valueOf(i), view2);
                    }
                    View view3 = view2;
                    if (i == size - 1) {
                        str = "";
                    } else {
                        str = (String) list.get(i);
                    }
                    ImageView imageView = (ImageView) view3.findViewById(f.qCB);
                    if (i != size - 1) {
                        imageView.setBackgroundDrawable(null);
                        imageView.setTag(str);
                        imageView.setContentDescription(getContext().getString(j.qLc));
                        Bitmap bitmap = (Bitmap) this.rvV.get(str);
                        if (i.m(bitmap)) {
                            imageView.setImageBitmap(bitmap);
                        } else {
                            x.d("MicroMsg.PreviewImageView", "bm is null");
                            new a(this, imageView, str).m(new String[]{""});
                        }
                    } else if (this.rvX) {
                        imageView.setBackgroundResource(i$e.qzI);
                        imageView.setContentDescription(getContext().getString(j.qKf));
                        imageView.setImageDrawable(null);
                    } else {
                        i++;
                    }
                    if (this.rvW != null) {
                        if (i == size - 1) {
                            view3.setTag(Integer.valueOf(-1));
                            view3.setOnClickListener(this.rvW.rtw);
                            view3.setClickable(true);
                        } else {
                            view3.setTag(Integer.valueOf(i));
                            view3.setOnClickListener(this.rvW.rtw);
                            view3.setClickable(true);
                        }
                    }
                    view3.setLayoutParams(new LayoutParams(-2, -2));
                    view.addView(view3);
                    i++;
                }
                i3 = i;
                if (view.getChildCount() > 0) {
                    this.rvR.addView(view);
                }
                x.d("MicroMsg.PreviewImageView", "initlist time : " + (System.currentTimeMillis() - currentTimeMillis));
                i2++;
                i = i3;
            }
        }
    }
}
