package com.tencent.mm.plugin.chatroom.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView$t;
import android.support.v7.widget.RecyclerView.a;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;

public final class b extends a<b> implements com.tencent.mm.plugin.chatroom.ui.b.a {
    private final Calendar calendar = Calendar.getInstance();
    private final TypedArray kZa;
    private final a kZb;
    private final a<com.tencent.mm.plugin.chatroom.d.a> kZc;
    private final Collection<com.tencent.mm.plugin.chatroom.d.a> kZd;
    private final Integer kZe;
    private final Integer kZf;
    private final boolean kZg;
    private final Context mContext;

    public final /* synthetic */ RecyclerView$t a(ViewGroup viewGroup, int i) {
        return new b(new com.tencent.mm.plugin.chatroom.ui.b(this.mContext, this.kZa), this);
    }

    public final /* synthetic */ void a(RecyclerView$t recyclerView$t, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = -1;
        com.tencent.mm.plugin.chatroom.ui.b bVar = ((b) recyclerView$t).kZi;
        HashMap hashMap = new HashMap();
        int intValue = (this.kZe.intValue() + (i % 12)) % 12;
        int intValue2 = ((i / 12) + this.calendar.get(1)) + ((this.kZe.intValue() + (i % 12)) / 12);
        if (this.kZc.first != null) {
            i2 = ((com.tencent.mm.plugin.chatroom.d.a) this.kZc.first).kCC;
            i3 = i2;
            i2 = ((com.tencent.mm.plugin.chatroom.d.a) this.kZc.first).month;
            i4 = ((com.tencent.mm.plugin.chatroom.d.a) this.kZc.first).year;
        } else {
            i4 = -1;
            i2 = -1;
            i3 = -1;
        }
        if (this.kZc.kZh != null) {
            int i8 = ((com.tencent.mm.plugin.chatroom.d.a) this.kZc.kZh).kCC;
            i5 = ((com.tencent.mm.plugin.chatroom.d.a) this.kZc.kZh).month;
            i7 = ((com.tencent.mm.plugin.chatroom.d.a) this.kZc.kZh).year;
            i6 = i5;
            i5 = i8;
        } else {
            i6 = -1;
            i5 = -1;
        }
        bVar.leO = 6;
        bVar.requestLayout();
        hashMap.put("selected_begin_year", Integer.valueOf(i4));
        hashMap.put("selected_last_year", Integer.valueOf(i7));
        hashMap.put("selected_begin_month", Integer.valueOf(i2));
        hashMap.put("selected_last_month", Integer.valueOf(i6));
        hashMap.put("selected_begin_day", Integer.valueOf(i3));
        hashMap.put("selected_last_day", Integer.valueOf(i5));
        hashMap.put("year", Integer.valueOf(intValue2));
        hashMap.put("month", Integer.valueOf(intValue));
        hashMap.put("week_start", Integer.valueOf(this.calendar.getFirstDayOfWeek()));
        Collection collection = this.kZd;
        if (collection != null) {
            bVar.laK = collection;
        } else {
            x.e("MicroMsg.SimpleMonthView", "markDateList is null");
        }
        bVar.l(hashMap);
        bVar.invalidate();
    }

    public b(Context context, a aVar, TypedArray typedArray, long j, Collection<com.tencent.mm.plugin.chatroom.d.a> collection) {
        this.kZa = typedArray;
        this.kZf = Integer.valueOf(typedArray.getInt(R.n.faa, this.calendar.get(2) % 12));
        if (-1 != j) {
            this.calendar.setTimeInMillis(j);
        }
        this.kZe = Integer.valueOf(typedArray.getInt(R.n.eZZ, this.calendar.get(2)));
        this.kZg = typedArray.getBoolean(R.n.eZY, false);
        this.kZc = new a();
        this.kZd = collection;
        this.mContext = context;
        this.kZb = aVar;
        if (this.kZa.getBoolean(R.n.eZW, false)) {
            c(new com.tencent.mm.plugin.chatroom.d.a(System.currentTimeMillis()));
        }
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemCount() {
        int i = ((new com.tencent.mm.plugin.chatroom.d.a(this.kZb.axx()).year - this.calendar.get(1)) + 1) * 12;
        if (this.kZe.intValue() != -1) {
            i -= this.kZe.intValue();
        }
        if (this.kZf.intValue() != -1) {
            return i - ((12 - this.kZf.intValue()) - 1);
        }
        return i;
    }

    public final void b(com.tencent.mm.plugin.chatroom.d.a aVar) {
        if (aVar != null) {
            c(aVar);
        }
    }

    private void c(com.tencent.mm.plugin.chatroom.d.a aVar) {
        this.kZb.a(aVar);
        if (!this.kZg) {
            this.kZc.first = aVar;
        } else if (this.kZc.first != null && this.kZc.kZh == null) {
            this.kZc.kZh = aVar;
            if (((com.tencent.mm.plugin.chatroom.d.a) this.kZc.first).month < aVar.month) {
                for (int i = 0; i < (((com.tencent.mm.plugin.chatroom.d.a) this.kZc.first).month - aVar.month) - 1; i++) {
                    this.kZb.a(aVar);
                }
            }
        } else if (this.kZc.kZh != null) {
            this.kZc.first = aVar;
            this.kZc.kZh = null;
        } else {
            this.kZc.first = aVar;
        }
        this.UR.notifyChanged();
    }
}
