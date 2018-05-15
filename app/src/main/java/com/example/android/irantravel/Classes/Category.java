package com.example.android.irantravel.Classes;

import com.orm.SugarRecord;

/**
 * Created by meno on 11/22/2017.
 */

public class Category extends SugarRecord<Category> {
    String A_Category;
    String F_Category;
    String P_Category;

    public Category(){
    }

    public Category(String A_Category,String F_Category,String P_Category){
        this.A_Category = A_Category;
        this.F_Category = F_Category;
        this.P_Category = P_Category;
    }

    public String getA_Category() {
        return A_Category;
    }

    public void setA_Category(String a_Category) {
        A_Category = a_Category;
    }

    public String getF_Category() {
        return F_Category;
    }

    public void setF_Category(String f_Category) {
        F_Category = f_Category;
    }

    public String getP_Category() {
        return P_Category;
    }
}
