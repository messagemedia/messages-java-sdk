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
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("vendor_id")
    public String getVendorId ( ) { 
        return this.vendorId;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("vendor_id")
    public void setVendorId (String value) { 
        this.vendorId = value;
    }
 
    /** GETTER
     * The account used to submit the original message.
     */
    @JsonGetter("account_id")
    public String getAccountId ( ) { 
        return this.accountId;
    }
    
    /** SETTER
     * The account used to submit the original message.
     */
    @JsonSetter("account_id")
    public void setAccountId (String value) { 
        this.accountId = value;
    }
 
}
