package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class MallOrderDetailObject {
    public String fvL;
    public String lVH;
    public MallTransactionObject oZV;
    public b oZW;
    public ArrayList<ProductSectionItem> oZX;
    public List<a> oZY;
    public List<HelpCenter> oZZ = new LinkedList();
    int paa = -1;
    public String pab;
    public String pac;
    public int pad;

    public static class HelpCenter implements Parcelable {
        public static final Creator<HelpCenter> CREATOR = new 1();
        public boolean fpa;
        public String name;
        public String url;

        protected HelpCenter() {
        }

        protected HelpCenter(Parcel parcel) {
            this.name = parcel.readString();
            this.url = parcel.readString();
            this.fpa = parcel.readByte() != (byte) 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.name);
            parcel.writeString(this.url);
            parcel.writeByte((byte) (this.fpa ? 1 : 0));
        }

        public int describeContents() {
            return 0;
        }
    }

    static ArrayList<ProductSectionItem> N(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("product_section");
        if (jSONObject2 == null) {
            return null;
        }
        JSONArray jSONArray = jSONObject2.getJSONArray("items");
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        ArrayList<ProductSectionItem> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject3 = jSONArray.getJSONObject(i);
            ProductSectionItem productSectionItem = new ProductSectionItem();
            productSectionItem.iconUrl = jSONObject3.optString("icon_url");
            productSectionItem.name = jSONObject3.optString("name");
            try {
                productSectionItem.pbM = O(jSONObject3);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MallOrderDetailObject", e, "", new Object[0]);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MallOrderDetailObject", e2, "", new Object[0]);
            }
            productSectionItem.count = jSONObject3.optInt("count");
            productSectionItem.pbN = jSONObject3.optString("price");
            productSectionItem.jumpUrl = jSONObject3.optString("jump_url");
            productSectionItem.pbO = jSONObject3.optString("pid");
            productSectionItem.scene = jSONObject3.optInt("scene");
            arrayList.add(productSectionItem);
        }
        return arrayList;
    }

    private static List<ProductSectionItem$Skus> O(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("skus");
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        List<ProductSectionItem$Skus> arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            ProductSectionItem$Skus productSectionItem$Skus = new ProductSectionItem$Skus();
            productSectionItem$Skus.aAM = jSONObject2.optString("key");
            productSectionItem$Skus.value = jSONObject2.optString(DownloadSettingTable$Columns.VALUE);
            arrayList.add(productSectionItem$Skus);
        }
        return arrayList;
    }
}
