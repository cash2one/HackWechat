package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiDestroyInstanceAudio;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetAudioState;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.w;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.o$a;

public class SnsTagPartlyUI extends MMActivity implements e {
    private ListView kGl;
    private a rHf;
    private OnClickListener rHg = new OnClickListener(this) {
        final /* synthetic */ SnsTagPartlyUI rHh;

        {
            this.rHh = r1;
        }

        public final void onClick(View view) {
            if (this.rHh.rHf == null) {
                x.e("MicroMsg.SnsTagPartlyUI", "The adapter is null..");
                return;
            }
            Object tag = view.getTag();
            if (tag == null) {
                x.e("MicroMsg.SnsTagPartlyUI", "The tag is null..");
            } else if (tag instanceof Integer) {
                s sVar = (s) this.rHh.rHf.getItem(((Integer) tag).intValue());
                this.rHh.tipDialog = h.a(this.rHh, null, true, new 1(this));
                g.Dk();
                g.Di().gPJ.a(new w(sVar.field_tagId, sVar.field_tagName), 0);
            } else {
                x.e("MicroMsg.SnsTagPartlyUI", "The tag is not a instance of Integer.");
            }
        }
    };
    protected r tipDialog = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.Dk();
        g.Di().gPJ.a(JsApiSetAudioState.CTRL_INDEX, this);
        g.Dk();
        g.Di().gPJ.a(JsApiDestroyInstanceAudio.CTRL_INDEX, this);
        initView();
    }

    public void onDestroy() {
        g.Dk();
        g.Di().gPJ.b(JsApiSetAudioState.CTRL_INDEX, this);
        g.Dk();
        g.Di().gPJ.b(JsApiDestroyInstanceAudio.CTRL_INDEX, this);
        if (this.rHf != null) {
            this.rHf.aUn();
        }
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        if (this.rHf != null) {
            this.rHf.a("", null);
        }
    }

    protected final void initView() {
        setMMTitle(j.qJM);
        setBackBtn(new 1(this));
        this.kGl = (ListView) findViewById(f.qFv);
        this.kGl.setOnItemClickListener(new 2(this));
        this.rHf = new a(this, this);
        this.kGl.addFooterView(View.inflate(this, i.g.qHV, null));
        this.kGl.setAdapter(this.rHf);
        addTextOptionMenu(0, getString(j.qMm), new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsTagPartlyUI rHh;

            {
                this.rHh = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean z;
                a a = this.rHh.rHf;
                if (this.rHh.rHf.rHj) {
                    z = false;
                } else {
                    z = true;
                }
                a.rHj = z;
                this.rHh.updateOptionMenuText(0, this.rHh.rHf.rHj ? this.rHh.getString(j.dFl) : this.rHh.getString(j.qMm));
                this.rHh.rHf.notifyDataSetChanged();
                return true;
            }
        });
        this.rHf.xIi = new o$a(this) {
            final /* synthetic */ SnsTagPartlyUI rHh;

            {
                this.rHh = r1;
            }

            public final void Xw() {
            }

            public final void Xv() {
                boolean z = true;
                SnsTagPartlyUI snsTagPartlyUI = this.rHh;
                if (this.rHh.rHf.getCount() <= 1) {
                    z = false;
                }
                snsTagPartlyUI.enableOptionMenu(z);
            }
        };
    }

    protected final int getLayoutId() {
        return i.g.qHW;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra("Select_Contact");
                        String stringExtra2 = intent.getStringExtra("Select_room_name");
                        if (stringExtra != null) {
                            Intent intent2 = new Intent();
                            intent2.putExtra("k_sns_tag_id", 0);
                            intent2.putExtra("k_sns_tag_name", bh.az(stringExtra2, ""));
                            intent2.putExtra("k_sns_tag_list", stringExtra);
                            intent2.setClass(this, SnsTagDetailUI.class);
                            startActivity(intent2);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.SnsTagPartlyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (this.rHf != null) {
            this.rHf.a("", null);
        }
    }
}
