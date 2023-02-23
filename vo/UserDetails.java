package com.crmsystem.registration.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {
    //private boolean b;
    private String user_name;
    private String city;
    private Long pincode;
    private Long mobile_number;
    private String address1;
    private String address2;
    private String state;

    @JsonIgnore
    private Long user_id;

    public UserDetails(boolean b,String user_name, String city, Long pincode, Long mobile_number, String address1, String address2, String state) {
       // this.b=b;
        this.user_name = user_name;
        this.city = city;
        this.pincode = pincode;
        this.mobile_number = mobile_number;
        this.address1 = address1;
        this.address2 = address2;
        this.state = state;
    }


}
