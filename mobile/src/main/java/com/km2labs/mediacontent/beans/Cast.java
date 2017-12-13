package com.km2labs.mediacontent.beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel(value = Parcel.Serialization.FIELD,
        analyze = {Cast.class})
public class Cast {

    @SerializedName("cast_id")
    @Expose
    Integer castId;
    @SerializedName("character")
    @Expose
    String character;
    @SerializedName("credit_id")
    @Expose
    String creditId;
    @SerializedName("id")
    @Expose
    Integer id;
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("order")
    @Expose
    Integer order;
    @SerializedName("profile_path")
    @Expose
    String profilePath;

    /**
     * @return The castId
     */
    public Integer getCastId() {
        return castId;
    }

    /**
     * @param castId The cast_id
     */
    public void setCastId(Integer castId) {
        this.castId = castId;
    }

    /**
     * @return The character
     */
    public String getCharacter() {
        return character;
    }

    /**
     * @param character The character
     */
    public void setCharacter(String character) {
        this.character = character;
    }

    /**
     * @return The creditId
     */
    public String getCreditId() {
        return creditId;
    }

    /**
     * @param creditId The credit_id
     */
    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    /**
     * @return The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The order
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * @param order The order
     */
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
     * @return The profilePath
     */
    public String getProfilePath() {
        return profilePath;
    }

    /**
     * @param profilePath The profile_path
     */
    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

}
