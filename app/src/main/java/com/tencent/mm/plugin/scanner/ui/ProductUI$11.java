package com.tencent.mm.plugin.scanner.ui;

class ProductUI$11 implements e$a {
    final /* synthetic */ ProductUI pWr;

    ProductUI$11(ProductUI productUI) {
        this.pWr = productUI;
    }

    public final void a(String str, Boolean bool) {
        if (str != null && str.length() > 0) {
            ProductUI.i(this.pWr).put(str, bool);
        }
    }

    public final Boolean ID(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return (Boolean) ProductUI.i(this.pWr).get(str);
    }

    public final void bpf() {
        if (this.pWr.ilB != null) {
            this.pWr.ilB.notifyDataSetChanged();
        }
    }
}
