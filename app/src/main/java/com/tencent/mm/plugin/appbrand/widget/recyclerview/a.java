package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.support.v7.widget.RecyclerView$a;
import android.support.v7.widget.RecyclerView$c;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.appbrand.widget.k.c;
import java.util.LinkedList;
import java.util.List;

final class a extends RecyclerView$a<t> {
    private static LayoutParams kfT = new LayoutParams(-1, -2);
    RecyclerView$a TU;
    private ViewGroup kfU;
    private ViewGroup kfV;
    List<View> kfW = new LinkedList();
    private List<View> kfX = new LinkedList();
    b kfY;
    private c kfZ;
    RecyclerView$c kga = new RecyclerView$c(this) {
        final /* synthetic */ a kgb;

        {
            this.kgb = r1;
        }

        public final void onChanged() {
            this.kgb.UR.notifyChanged();
        }

        public final void Y(int i, int i2) {
            this.kgb.U((this.kgb.kfW.isEmpty() ? 0 : 1) + i, i2);
        }

        public final void c(int i, int i2, Object obj) {
            this.kgb.b((this.kgb.kfW.isEmpty() ? 0 : 1) + i, i2, obj);
        }

        public final void Z(int i, int i2) {
            this.kgb.W((this.kgb.kfW.isEmpty() ? 0 : 1) + i, i2);
        }

        public final void aa(int i, int i2) {
            this.kgb.X((this.kgb.kfW.isEmpty() ? 0 : 1) + i, i2);
        }

        public final void ab(int i, int i2) {
            int i3;
            int i4 = 0;
            a aVar = this.kgb;
            if (this.kgb.kfW.isEmpty()) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            i3 += i;
            if (!this.kgb.kfW.isEmpty()) {
                i4 = 1;
            }
            aVar.V(i3, i4 + i2);
        }
    };

    a() {
    }

    public final int getItemViewType(int i) {
        if (!this.kfW.isEmpty() && i == 0) {
            return Integer.MAX_VALUE;
        }
        if (!this.kfX.isEmpty() && i == getItemCount() - 1) {
            return 2147483646;
        }
        return this.TU.getItemViewType(i - (this.kfW.isEmpty() ? 0 : 1));
    }

    public final long getItemId(int i) {
        if (getItemViewType(i) == Integer.MAX_VALUE) {
            return (long) "MRecyclerHeaderView".hashCode();
        }
        if (getItemViewType(i) == 2147483646) {
            return (long) "MRecyclerFooterView".hashCode();
        }
        if (!this.TU.US) {
            return (long) i;
        }
        return this.TU.getItemId(i - (this.kfW.isEmpty() ? 0 : 1));
    }

    public final int getItemCount() {
        int itemCount = this.TU.getItemCount();
        if (!this.kfW.isEmpty()) {
            itemCount++;
        }
        if (this.kfX.isEmpty()) {
            return itemCount;
        }
        return itemCount + 1;
    }

    public final void a(t tVar, int i) {
        if (!this.kfW.isEmpty() && i == 0) {
            return;
        }
        if (this.kfX.isEmpty() || i != getItemCount() - 1) {
            int i2 = i - (this.kfW.isEmpty() ? 0 : 1);
            this.TU.a(tVar, i2);
            if (this.kfY != null) {
                tVar.VU.setOnClickListener(new 2(this, tVar, i2));
            }
            if (this.kfZ != null) {
                tVar.VU.setOnLongClickListener(new 3(this, tVar, i2));
            }
        }
    }

    public final void a(final t tVar, int i, List<Object> list) {
        if (!this.kfW.isEmpty() && i == 0) {
            return;
        }
        if (this.kfX.isEmpty() || i != getItemCount() - 1) {
            final int i2 = i - (this.kfW.isEmpty() ? 0 : 1);
            this.TU.a(tVar, i2, list);
            if (this.kfY != null) {
                tVar.VU.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ a kgb;

                    public final void onClick(View view) {
                        if (this.kgb.kfY != null) {
                            b b = this.kgb.kfY;
                            View view2 = tVar.VU;
                            int i = i2;
                            long j = tVar.VW;
                            b.mv(i);
                        }
                    }
                });
            }
            if (this.kfZ != null) {
                tVar.VU.setOnLongClickListener(new OnLongClickListener(this) {
                    final /* synthetic */ a kgb;

                    public final boolean onLongClick(View view) {
                        if (this.kgb.kfZ == null) {
                            return false;
                        }
                        c c = this.kgb.kfZ;
                        View view2 = tVar.VU;
                        long j = tVar.VW;
                        return c.aob();
                    }
                });
            }
        }
    }

    public final t a(ViewGroup viewGroup, int i) {
        ViewGroup viewGroup2;
        if (i == 2147483646) {
            if (this.kfU != null) {
                this.kfU.removeAllViews();
            }
            viewGroup2 = (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(c.jVi, viewGroup, false);
            this.kfU = viewGroup2;
            for (View addView : this.kfX) {
                viewGroup2.addView(addView, kfT);
            }
            return new a(viewGroup2);
        } else if (i != Integer.MAX_VALUE) {
            return this.TU.a(viewGroup, i);
        } else {
            if (this.kfV != null) {
                this.kfV.removeAllViews();
            }
            viewGroup2 = (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(c.jVi, viewGroup, false);
            this.kfV = viewGroup2;
            for (View addView2 : this.kfW) {
                viewGroup2.addView(addView2, kfT);
            }
            return new a(viewGroup2);
        }
    }

    public final int anZ() {
        return this.kfX.size();
    }

    public final void addFooterView(View view) {
        this.kfX.add(view);
        U(getItemCount() - 1, 1);
    }

    public final void c(int i, View view) {
        this.kfX.add(i, view);
        U(getItemCount() - 1, 1);
    }

    public final void cf(View view) {
        this.kfX.remove(view);
        U(getItemCount() - 1, 1);
    }
}
