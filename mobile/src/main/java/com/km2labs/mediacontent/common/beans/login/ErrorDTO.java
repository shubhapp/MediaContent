package com.km2labs.mediacontent.common.beans.login;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ErrorDTO {

    @SerializedName("status_message")
    @Expose
    private String statusMessage;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("status_code")
    @Expose
    private Integer statusCode;

    /**
     * @return The statusMessage
     */
    public String getStatusMessage() {
        return statusMessage;
    }

    /**
     * @param statusMessage The status_message
     */
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    /**
     * @return The success
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     * @param success The success
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    /**
     * @return The statusCode
     */
    public Integer getStatusCode() {
        return statusCode;
    }

    /**
     * @param statusCode The status_code
     */
    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

}