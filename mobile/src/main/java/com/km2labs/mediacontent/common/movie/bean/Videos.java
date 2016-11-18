
package com.km2labs.mediacontent.common.movie.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel(value = Parcel.Serialization.FIELD,
        analyze = {Videos.class})
public class Videos {

    @SerializedName("results")
    @Expose
    List<Video> mVideos = new ArrayList<>();

    /**
     * @return The Videos
     */
    public List<Video> getVideos() {
        return mVideos;
    }

    /**
     * @param videos The Videos
     */
    public void setVideos(List<Video> videos) {
        this.mVideos = videos;
    }

}
