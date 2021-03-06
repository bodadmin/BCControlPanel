/*Copyright (c) 2016-2017 Business on Demand Ltd. All Rights Reserved. This software is the confidential and proprietary information of Business on Demand Ltd. You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with Business on Demand Ltd.*/

package com.bccontrolpanel.bcdata;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Embeddable;


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;



/**
 * ContextfileId generated by hbm2java
 */
@Embeddable
public class ContextfileId  implements java.io.Serializable {

    private String contextName;
    private String contextFileName;

    public ContextfileId() {
    }


    public String getContextName() {
        return this.contextName;
    }
    
    public void setContextName(String contextName) {
        this.contextName = contextName;
    }
    public String getContextFileName() {
        return this.contextFileName;
    }
    
    public void setContextFileName(String contextFileName) {
        this.contextFileName = contextFileName;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof ContextfileId) )
		    return false;

		 ContextfileId that = (ContextfileId) o;

         return ( (this.getContextName()==that.getContextName()) || ( this.getContextName()!=null && that.getContextName()!=null && this.getContextName().equals(that.getContextName()) ) )
 && ( (this.getContextFileName()==that.getContextFileName()) || ( this.getContextFileName()!=null && that.getContextFileName()!=null && this.getContextFileName().equals(that.getContextFileName()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getContextName() == null ? 0 : this.getContextName().hashCode() );
         result = 37 * result + ( getContextFileName() == null ? 0 : this.getContextFileName().hashCode() );

         return result;
    }


}

