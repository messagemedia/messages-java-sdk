package com.messagemedia.messages.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class VendorAccountId.
 */
public class VendorAccountId 
        implements java.io.Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 2954745266859544570L;
    
    /** The vendor id. */
    private String vendorId;
    
    /** The account id. */
    private String accountId;
    
    /**
     *  GETTER
     * TODO: Write general description for this method.
     *
     * @return the vendor id
     */
    @JsonGetter("vendor_id")
    public String getVendorId ( ) { 
        return this.vendorId;
    }
    
    /**
     *  SETTER
     * TODO: Write general description for this method.
     *
     * @param value the new vendor id
     */
    @JsonSetter("vendor_id")
    public void setVendorId (String value) { 
        this.vendorId = value;
    }
 
    /**
     *  GETTER
     * The account used to submit the original message.
     *
     * @return the account id
     */
    @JsonGetter("account_id")
    public String getAccountId ( ) { 
        return this.accountId;
    }
    
    /**
     *  SETTER
     * The account used to submit the original message.
     *
     * @param value the new account id
     */
    @JsonSetter("account_id")
    public void setAccountId (String value) { 
        this.accountId = value;
    }
 
}
