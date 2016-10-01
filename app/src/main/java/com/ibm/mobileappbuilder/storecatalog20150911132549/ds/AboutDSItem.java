
package com.ibm.mobileappbuilder.storecatalog20150911132549.ds;

import ibmmobileappbuilder.mvp.model.IdentifiableBean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class AboutDSItem implements Parcelable, IdentifiableBean {

    @SerializedName("about") public String about;
    @SerializedName("id") public String id;

    @Override
    public String getIdentifiableId() {
      return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(about);
        dest.writeString(id);
    }

    public static final Creator<AboutDSItem> CREATOR = new Creator<AboutDSItem>() {
        @Override
        public AboutDSItem createFromParcel(Parcel in) {
            AboutDSItem item = new AboutDSItem();

            item.about = in.readString();
            item.id = in.readString();
            return item;
        }

        @Override
        public AboutDSItem[] newArray(int size) {
            return new AboutDSItem[size];
        }
    };

}


