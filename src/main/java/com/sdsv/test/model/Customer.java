package com.sdsv.test.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Builder
public class Customer {
    public String number;

    public String name;

    public String email;

}
