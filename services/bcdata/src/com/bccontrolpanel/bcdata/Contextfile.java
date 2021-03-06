/*Copyright (c) 2016-2017 Business on Demand Ltd. All Rights Reserved. This software is the confidential and proprietary information of Business on Demand Ltd. You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with Business on Demand Ltd.*/

package com.bccontrolpanel.bcdata;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;



/**
 * Contextfile generated by hbm2java
 */
@Entity
@Table(name="`contextfile`"
    ,schema="bcdata"
)
@IdClass(value=ContextfileId.class)
public class Contextfile  implements java.io.Serializable {

    private String contextName;
    private String contextFileName;
    private String contextDir;
    private String description;

    public Contextfile() {
    }


    @Id 
    

    @Column(name="`ContextName`", nullable=false, insertable=false, updatable=false, length=64)
    public String getContextName() {
        return this.contextName;
    }
    
    public void setContextName(String contextName) {
        this.contextName = contextName;
    }
    @Id 
    

    @Column(name="`ContextFileName`", nullable=false, insertable=false, updatable=false)
    public String getContextFileName() {
        return this.contextFileName;
    }
    
    public void setContextFileName(String contextFileName) {
        this.contextFileName = contextFileName;
    }

    

    @Column(name="`ContextDir`", nullable=false, length=1024)
    public String getContextDir() {
        return this.contextDir;
    }
    
    public void setContextDir(String contextDir) {
        this.contextDir = contextDir;
    }

    

    @Column(name="`Description`", length=1024)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof Contextfile) )
		    return false;

		 Contextfile that = (Contextfile) o;

         return ( (this.getContextName()==that.getContextName()) || ( this.getContextName()!=null && that.getContextName()!=null && this.getContextName().equals(that.getContextName()) ) )
 && ( (this.getContextFileName()==that.getContextFileName()) || ( this.getContextFileName()!=null && that.getContextFileName()!=null && this.getContextFileName().equals(that.getContextFileName()) ) )
 && ( (this.getContextDir()==that.getContextDir()) || ( this.getContextDir()!=null && that.getContextDir()!=null && this.getContextDir().equals(that.getContextDir()) ) )
 && ( (this.getDescription()==that.getDescription()) || ( this.getDescription()!=null && that.getDescription()!=null && this.getDescription().equals(that.getDescription()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getContextName() == null ? 0 : this.getContextName().hashCode() );
         result = 37 * result + ( getContextFileName() == null ? 0 : this.getContextFileName().hashCode() );
         result = 37 * result + ( getContextDir() == null ? 0 : this.getContextDir().hashCode() );
         result = 37 * result + ( getDescription() == null ? 0 : this.getDescription().hashCode() );

         return result;
    }


}

