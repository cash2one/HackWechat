package com.tencent.mm.plugin.shake.ui;

import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.o;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tenpay.android.wechat.PayuSecureEncrypt;

class ShakeItemListUI$a extends o<d> {
    b hvU = new b(new 1(this));
    private b.b hvV = null;
    final /* synthetic */ ShakeItemListUI qqB;
    private int showType = 0;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (d) obj;
        if (obj == null) {
            obj = new d();
        }
        if (cursor != null) {
            obj.b(cursor);
        }
        return obj;
    }

    public ShakeItemListUI$a(ShakeItemListUI shakeItemListUI, ShakeItemListUI shakeItemListUI2) {
        this.qqB = shakeItemListUI;
        super(shakeItemListUI2, new d());
        Xz();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.hvV == null) {
            this.hvV = new 2(this);
        }
        if (this.hvU != null) {
            this.hvU.a(i, this.hvV);
        }
        if (view == null) {
            aVar = new a(this);
            view = View.inflate(this.context, R.i.dsp, null);
            aVar.hvY = (ImageView) view.findViewById(R.h.cyR);
            aVar.hvZ = (TextView) view.findViewById(R.h.cyX);
            aVar.hwa = (TextView) view.findViewById(R.h.cyU);
            aVar.qqG = (ImageView) view.findViewById(R.h.cyZ);
            aVar.oOY = (TextView) view.findViewById(R.h.cyS);
            aVar.oOZ = (TextView) view.findViewById(R.h.cza);
            aVar.oPa = (ImageView) view.findViewById(R.h.czc);
            aVar.qqH = (TextView) view.findViewById(R.h.cNr);
            aVar.qqF = view.findViewById(R.h.cIf);
            aVar.qqI = (LinearLayout) view.findViewById(R.h.cMF);
            aVar.qqJ = (TextView) view.findViewById(R.h.cMG);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        d dVar = (d) getItem(i);
        if (dVar != null) {
            aVar.clear();
            if (4 == dVar.field_type || (k.we(dVar.field_type) && 6 != dVar.field_type)) {
                if (4 != dVar.field_type) {
                    aVar.hvY.setScaleType(ScaleType.CENTER_CROP);
                }
                e.a(aVar.hvY, dVar.field_sns_bgurl, R.k.dvD, false);
            } else if (11 == dVar.field_type) {
                ShakeItemListUI.g(this.qqB).a(dVar.getProvince(), aVar.hvY);
            } else {
                a.b.a(aVar.hvY, dVar.field_username);
            }
            aVar.hvY.setVisibility(0);
            if (7 != dVar.field_type && 10 != dVar.field_type && 12 != dVar.field_type && 13 != dVar.field_type && (8 != dVar.field_type || !bh.ov(dVar.field_nickname) || !bh.ov(dVar.field_username))) {
                aVar.qqJ.setVisibility(8);
                aVar.qqI.setVisibility(0);
                if (8 == dVar.field_type && bh.ov(dVar.field_nickname)) {
                    dVar.field_nickname = dVar.field_distance;
                    dVar.field_distance = dVar.field_username;
                }
                aVar.hvZ.setText(i.b(this.context, bh.ou(dVar.field_nickname), aVar.hvZ.getTextSize()));
                aVar.hvZ.setVisibility(0);
                int paddingBottom = view.getPaddingBottom();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingLeft = view.getPaddingLeft();
                if (dVar.field_insertBatch == 2) {
                    view.setBackgroundDrawable(com.tencent.mm.bv.a.b(this.context, R.g.bBw));
                } else {
                    view.setBackgroundDrawable(com.tencent.mm.bv.a.b(this.context, R.g.bBx));
                }
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                switch (dVar.field_type) {
                    case 1:
                    case 2:
                    case 3:
                        aVar.qqH.setText(dVar.field_nickname);
                        aVar.qqH.setVisibility(0);
                        break;
                    default:
                        aVar.qqF.setVisibility(0);
                        aVar.oOY.setText(dVar.field_distance);
                        aVar.oOY.setVisibility(0);
                        if (dVar.field_signature == null || dVar.field_signature.trim().equals("")) {
                            aVar.oOZ.setVisibility(8);
                        } else {
                            aVar.oOZ.setVisibility(0);
                            aVar.oOZ.setText(i.b(this.context, dVar.field_signature, aVar.hvZ.getTextSize()));
                        }
                        if (dVar.field_sex == 1) {
                            aVar.qqG.setVisibility(0);
                            aVar.qqG.setImageDrawable(com.tencent.mm.bv.a.b(this.context, R.k.dyN));
                            aVar.qqG.setContentDescription(this.context.getString(R.l.euC));
                        } else if (dVar.field_sex == 2) {
                            aVar.qqG.setVisibility(0);
                            aVar.qqG.setImageDrawable(com.tencent.mm.bv.a.b(this.context, R.k.dyM));
                            aVar.qqG.setContentDescription(this.context.getString(R.l.ehc));
                        } else {
                            aVar.qqG.setVisibility(8);
                        }
                        ar.Hg();
                        af WO = c.EY().WO(dVar.field_username);
                        if (WO == null || !com.tencent.mm.l.a.fZ(WO.field_type)) {
                            aVar.hwa.setVisibility(8);
                        } else {
                            aVar.hwa.setVisibility(0);
                            if (x.Dn(dVar.field_reserved1)) {
                                aVar.hwa.setText(this.context.getString(R.l.exf));
                            } else {
                                aVar.hwa.setText(this.context.getString(R.l.exh));
                            }
                        }
                        if (6 == dVar.field_type) {
                            aVar.oOY.setText(this.context.getString(R.l.eOm));
                            aVar.hwa.setVisibility(8);
                        }
                        if (dVar.field_reserved1 == 0) {
                            aVar.oPa.setVisibility(8);
                            break;
                        }
                        aVar.oPa.setVisibility(0);
                        aVar.oPa.setImageBitmap(BackwardSupportUtil.b.b(ak.a.hfN.gO(dVar.field_reserved1), 2.0f));
                        aVar.qqG.setVisibility(8);
                        break;
                        break;
                }
            }
            if (8 == dVar.field_type) {
                aVar.qqJ.setText(dVar.field_distance);
            } else {
                aVar.qqJ.setText(dVar.field_nickname);
            }
            aVar.qqJ.setVisibility(0);
            aVar.qqI.setVisibility(8);
        } else {
            aVar.clear();
        }
        return view;
    }

    protected final void Xz() {
        aUn();
        Xy();
    }

    public final void Xy() {
        if (ar.Hj()) {
            switch (this.showType) {
                case -12:
                    e brC = m.brC();
                    int intExtra = this.qqB.getIntent().getIntExtra("_ibeacon_new_insert_size", 2);
                    setCursor(brC.rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc limit ? ", new String[]{"11", String.valueOf(intExtra)}));
                    break;
                case -6:
                    setCursor(m.brC().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by shakeItemID desc ", new String[]{"8", "2"}));
                    break;
                case -5:
                    setCursor(m.brC().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by shakeItemID desc ", new String[]{"4", "2"}));
                    break;
                case -1:
                    setCursor(m.brC().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by reserved2 desc, shakeItemID desc ", new String[]{"0", "2"}));
                    break;
                case 0:
                    setCursor(m.brC().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc ", new String[]{"0"}));
                    break;
                case 4:
                    setCursor(m.brC().brr());
                    break;
                case 5:
                    setCursor(m.brC().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type in (?, ?, ?, ?, ?) order by shakeItemID desc ", new String[]{"7", "6", "8", "9", PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT, "12"}));
                    break;
                case 11:
                    setCursor(m.brC().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc ", new String[]{"11"}));
                    break;
                case 100:
                    setCursor(m.brC().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   order by shakeItemID desc ", new String[0]));
                    break;
            }
            super.notifyDataSetChanged();
        }
    }

    protected final void wg(int i) {
        this.showType = i;
        Xz();
    }
}
