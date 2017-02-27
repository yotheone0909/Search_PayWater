package com.example.yothin_error.search_paywater;

/**
 * Created by Yothin_Error on 27/2/2560.
 */
public class WaterList {

    private String payment_period;
    private String payment_status;
    private String renter_code;
    private String renter_name;
    private String renter_lastname;
    private String renter_image;
    private String stall_name;


    public WaterList(String payment_period, String payment_status, String renter_code, String renter_name, String renter_lastname, String renter_image, String stall_name) {
        this.payment_period = payment_period;
        this.payment_status = payment_status;
        this.renter_code = renter_code;
        this.renter_name = renter_name;
        this.renter_lastname = renter_lastname;
        this.renter_image = renter_image;
        this.stall_name = stall_name;
    }

    public WaterList() {
        
    }

    public String getrenter_code(){
        return renter_code;
    }



    public String getPayment_period() {
        return payment_period;
    }

    public void setPayment_period(String payment_period) {
        this.payment_period = payment_period;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    public String getRenter_code() {
        return renter_code;
    }

    public void setRenter_code(String renter_code) {
        this.renter_code = renter_code;
    }

    public String getRenter_name() {
        return renter_name;
    }

    public void setRenter_name(String renter_name) {
        this.renter_name = renter_name;
    }

    public String getRenter_lastname() {
        return renter_lastname;
    }

    public void setRenter_lastname(String renter_lastname) {
        this.renter_lastname = renter_lastname;
    }

    public String getRenter_image() {
        return renter_image;
    }

    public void setRenter_image(String renter_image) {
        this.renter_image = renter_image;
    }

    public String getStall_name() {
        return stall_name;
    }

    public void setStall_name(String stall_name) {
        this.stall_name = stall_name;
    }
}
