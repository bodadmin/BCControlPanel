/*Copyright (c) 2016-2017 Business on Demand Ltd. All Rights Reserved. This software is the confidential and proprietary information of Business on Demand Ltd. You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with Business on Demand Ltd.*/

package com.bccontrolpanel.bcdata;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;



/**
 * Context generated by hbm2java
 */
@Entity
@Table(name="`context`"
    ,schema="bcdata"
)

public class Context  implements java.io.Serializable {

    private Integer id;
    private Integer contextfileId;
    private String contextname;
    private String contextvalue;
    private Boolean contextenabled;
    private Integer contextId;

    public Context() {
    }


    @Id @GeneratedValue(strategy=IDENTITY)
    

    @Column(name="`ID`", nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    

    @Column(name="`contextfileID`", nullable=false)
    public Integer getContextfileId() {
        return this.contextfileId;
    }
    
    public void setContextfileId(Integer contextfileId) {
        this.contextfileId = contextfileId;
    }

    

    @Column(name="`contextname`")
    public String getContextname() {
        return this.contextname;
    }
    
    public void setContextname(String contextname) {
        this.contextname = contextname;
    }

    

    @Column(name="`contextvalue`")
    public String getContextvalue() {
        return this.contextvalue;
    }
    
    public void setContextvalue(String contextvalue) {
        this.contextvalue = contextvalue;
    }

    

    @Column(name="`contextenabled`")
    public Boolean getContextenabled() {
        return this.contextenabled;
    }
    
    public void setContextenabled(Boolean contextenabled) {
        this.contextenabled = contextenabled;
    }

    

    @Column(name="`contextID`", nullable=false)
    public Integer getContextId() {
        return this.contextId;
    }
    
    public void setContextId(Integer contextId) {
        this.contextId = contextId;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof Context) )
		    return false;

		 Context that = (Context) o;

		 return ( (this.getId()==that.getId()) || ( this.getId()!=null && that.getId()!=null && this.getId().equals(that.getId()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );

         return result;
    }


}

