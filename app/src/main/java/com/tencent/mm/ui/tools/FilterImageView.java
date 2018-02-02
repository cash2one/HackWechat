package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.pointers.PIntArray;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMHorList;
import com.tencent.mm.w.a.f;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import java.io.InputStream;
import java.lang.reflect.Array;

public class FilterImageView extends LinearLayout {
    static c[] zil = new c[]{new c(new b("原图", "原圖", "Normal"), "icon.png", 0, 0, "MatteOrigin.jpg", 0), new c(new b("LOMO", "LOMO", "LOMO"), "nuowei_mask%02d.jpg", 2, 1, "0004.jpg", 2), new c(new b("麦田", "麥田", "Wheat"), "0062_%02d.jpg", 2, 2, "0062.jpg", 20), new c(new b("玻璃镜", "玻璃鏡", "Glossy"), "habi_mask%02d.jpg", 1, 3, "0005.jpg", 4), new c(new b("拍立得", "拍立得", "Polaroid"), "0063_%02d.jpg", 2, 4, "0063.jpg", 21), new c(new b("湖水", "湖水", "Lake"), "0061_%02d.jpg", 1, 5, "0061.jpg", 19), new c(new b("黄昏", "黃昏", "Twilight"), "0030_mask%01d.jpg", 1, 6, "0030.jpg", 7), new c(new b("黑白", "黑白", "B&W"), "0065_%02d.jpg", 1, 7, "0065.jpg", 22), new c(new b("铜版画", "銅版畫", "Aquatint"), "0032_mask%01d.jpg", 1, 8, "0032.jpg", 9), new c(new b("圆珠笔", "圓珠筆", "Pen"), "0035_mask%01d.jpg", 1, 9, "0035.jpg", 18), new c(new b("海报", "海報", "Poster"), "0036_mask%01d.jpg", 0, 10, "0036.jpg", 17), new c(new b("素描", "素描", "Portrait"), "icon.jpg", 0, 11, "0040.jpg", 12)};
    private Activity fAF;
    int qQV = 0;
    int[] zic;
    View zid;
    ImageView zie;
    CropImageView zif;
    Bitmap zig;
    private MMHorList zih;
    private a zii;
    Runnable zij;
    Runnable zik;

    class a extends BaseAdapter {
        int nXs = 0;
        final /* synthetic */ FilterImageView zim;

        a(FilterImageView filterImageView) {
            this.zim = filterImageView;
        }

        public final int getCount() {
            return FilterImageView.zil.length;
        }

        public final Object getItem(int i) {
            return FilterImageView.zil[i];
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            c cVar = (c) getItem(i);
            if (view == null || !(view.getTag() instanceof a)) {
                view = View.inflate(this.zim.fAF, h.gXi, null);
                a aVar2 = new a(this);
                aVar2.imw = (TextView) view.findViewById(g.gVv);
                aVar2.zin = (ImageView) view.findViewById(g.gVu);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
                if (aVar.zio != null) {
                    x.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[]{aVar.zio.toString()});
                    aVar.zio.recycle();
                }
            }
            TextView textView = aVar.imw;
            b bVar = cVar.zis;
            String cfi = w.cfi();
            CharSequence charSequence = cfi.equals("zh_CN") ? bVar.yEs : (cfi.equals("zh_TW") || cfi.equals("zh_HK")) ? bVar.ziq : bVar.zir;
            textView.setText(charSequence);
            try {
                InputStream open = this.zim.fAF.getAssets().open("filter/" + cVar.fDI);
                aVar.zio = d.decodeStream(open);
                open.close();
                aVar.zin.setImageBitmap(aVar.zio);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FilterView", e, "", new Object[0]);
            }
            view.setLayoutParams(new LayoutParams(-2, -2));
            if (i == this.nXs) {
                view.findViewById(g.gVu).setBackgroundResource(f.gUR);
            } else {
                view.findViewById(g.gVu).setBackgroundResource(f.gUS);
            }
            return view;
        }
    }

    static class c {
        String fDI;
        b zis;
        String zit;
        int ziu;
        int ziv;
        int ziw;

        c(b bVar, String str, int i, int i2, String str2, int i3) {
            this.zis = bVar;
            this.zit = str;
            this.ziu = i;
            this.ziv = i2;
            this.fDI = str2;
            this.ziw = i3;
        }
    }

    public FilterImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fAF = (Activity) context;
        View inflate = View.inflate(this.fAF, h.gXh, this);
        this.zif = (CropImageView) inflate.findViewById(g.gVr);
        this.zie = (ImageView) inflate.findViewById(g.bZY);
        this.zid = inflate.findViewById(g.bZS);
        this.zif.setOnTouchListener(null);
        this.zih = (MMHorList) inflate.findViewById(g.bZP);
        this.zii = new a(this);
        this.zih.setAdapter(this.zii);
        this.zih.invalidate();
        this.zih.setOnItemClickListener(new 1(this));
    }

    public final void dt(String str, int i) {
        x.i("MicroMsg.FilterView", "filePath before fiterBmp:" + str);
        if (this.zig == null || this.zig.isRecycled()) {
            this.zig = d.b(d.d(str, 480, 480, false), (float) i);
        }
        x.d("MicroMsg.FilterView", "filterBmp w:" + this.zig.getWidth() + " h:" + this.zig.getHeight());
        this.zic = new int[(this.zig.getWidth() * this.zig.getHeight())];
        this.zig.getPixels(this.zic, 0, this.zig.getWidth(), 0, 0, this.zig.getWidth(), this.zig.getHeight());
        this.zif.setImageBitmap(this.zig);
    }

    public void setVisibility(int i) {
        if (i == 0) {
            this.zii.notifyDataSetChanged();
            this.zih.invalidate();
        }
        super.setVisibility(i);
    }

    private boolean af(String str, int i, int i2) {
        if (i2 == 0) {
            this.zig.setPixels(this.zic, 0, this.zig.getWidth(), 0, 0, this.zig.getWidth(), this.zig.getHeight());
            this.zif.invalidate();
            return true;
        }
        int width = this.zig.getWidth() * this.zig.getHeight();
        x.d("MicroMsg.FilterView", "len:" + width + "  maskCount:" + i);
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i, width});
        int i3 = 0;
        while (i3 < i) {
            InputStream inputStream = null;
            try {
                inputStream = this.fAF.getAssets().open("filter/" + String.format(str, new Object[]{Integer.valueOf(i3)}));
                byte[] bArr = new byte[width];
                inputStream.read(bArr);
                Bitmap bl = d.bl(bArr);
                inputStream.close();
                if (inputStream != null) {
                    inputStream.close();
                }
                if (bl == null) {
                    return false;
                }
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bl, this.zig.getWidth(), this.zig.getHeight(), true);
                if (bl != createScaledBitmap) {
                    x.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[]{bl.toString()});
                    bl.recycle();
                }
                if (createScaledBitmap == null) {
                    return false;
                }
                createScaledBitmap.getPixels(iArr[i3], 0, createScaledBitmap.getWidth(), 0, 0, createScaledBitmap.getWidth(), createScaledBitmap.getHeight());
                x.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[]{createScaledBitmap.toString()});
                createScaledBitmap.recycle();
                i3++;
            } catch (Exception e) {
                throw e;
            } catch (Throwable th) {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        }
        PIntArray pIntArray = new PIntArray();
        x.e("MicroMsg.FilterView", "src.len:" + this.zic.length);
        for (int i4 = 0; i4 < iArr.length; i4++) {
            x.e("MicroMsg.FilterView", "mask[" + i4 + "].len:" + iArr[i4].length);
        }
        x.e("MicroMsg.FilterView", "before filter");
        ImgFilter.FilterInt(i2, this.zic, iArr, i, this.zig.getWidth(), this.zig.getHeight(), pIntArray);
        x.e("MicroMsg.FilterView", "after filter");
        this.zig.setPixels(pIntArray.value, 0, this.zig.getWidth(), 0, 0, this.zig.getWidth(), this.zig.getHeight());
        this.zif.invalidate();
        return true;
    }
}
