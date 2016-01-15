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
 * Menusettings generated by hbm2java
 */
@Entity
@Table(name="`menusettings`"
)

public class Menusettings  implements java.io.Serializable {

    private Integer id;
    private String menuItemLabel;
    private String menuItemLink;
    private String menuItemIcon;

    public Menusettings() {
    }


    @Id @GeneratedValue(strategy=IDENTITY)
    

    @Column(name="`ID`", nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    

    @Column(name="`menuItemLabel`", nullable=false)
    public String getMenuItemLabel() {
        return this.menuItemLabel;
    }
    
    public void setMenuItemLabel(String menuItemLabel) {
        this.menuItemLabel = menuItemLabel;
    }

    

    @Column(name="`menuItemLink`", nullable=false)
    public String getMenuItemLink() {
        return this.menuItemLink;
    }
    
    public void setMenuItemLink(String menuItemLink) {
        this.menuItemLink = menuItemLink;
    }

    

    @Column(name="`menuItemIcon`")
    public String getMenuItemIcon() {
        return this.menuItemIcon;
    }
    
    public void setMenuItemIcon(String menuItemIcon) {
        this.menuItemIcon = menuItemIcon;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof Menusettings) )
		    return false;

		 Menusettings that = (Menusettings) o;

		 return ( (this.getId()==that.getId()) || ( this.getId()!=null && that.getId()!=null && this.getId().equals(that.getId()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );

         return result;
    }


}

