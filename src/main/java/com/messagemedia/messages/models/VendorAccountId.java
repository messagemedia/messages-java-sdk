package com.messagemedia.messages.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class VendorAccountId 
        implements java.io.Serializable {
    private static final long serialVersionUID = 2954745266859544570L;
    private String vendorId;
    private String accountId;

    @JsonGetter("vendor_id")
    public String getVendorId ( ) { 
        return this.vendorId;
    }
    

    @JsonSetter("vendor_id")
    public void setVendorId (String value) { 
        this.vendorId = value;
    }
 

    @JsonGetter("account_id")
    public String getAccountId ( ) { 
        return this.accountId;
    }
    

    @JsonSetter("account_id")
    public void setAccountId (String value) { 
        this.accountId = value;
    }
 
}
