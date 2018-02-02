package com.tencent.mm.plugin.sns.model;

class ao$a {
    String fHV;
    String id;
    String qXy;
    String qXz;
    int type;

    private ao$a() {
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ao$a)) {
            return super.equals(obj);
        }
        ao$a com_tencent_mm_plugin_sns_model_ao_a = (ao$a) obj;
        if (this.id.equals(com_tencent_mm_plugin_sns_model_ao_a.id) && this.type == com_tencent_mm_plugin_sns_model_ao_a.type) {
            return true;
        }
        return false;
    }
}
