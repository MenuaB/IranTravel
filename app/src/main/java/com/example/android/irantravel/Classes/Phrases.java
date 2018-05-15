package com.example.android.irantravel.Classes;

import com.orm.SugarRecord;

/**
 * Created by meno on 11/15/2017.
 */

public class Phrases extends SugarRecord<Phrases> {
    String Category;
    String A_Phrase;
    String P_Phrase;
    String F_Phrase;

    public Phrases() {

    }

    public Phrases(String Category, String A_Phrase, String P_Phrase, String F_Phrase) {
        this.Category = Category;
        this.A_Phrase = A_Phrase;
        this.P_Phrase = P_Phrase;
        this.F_Phrase = F_Phrase;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getA_Phrase() {
        return A_Phrase;
    }

    public void setA_Phrase(String a_Phrase) {
        A_Phrase = a_Phrase;
    }

    public String getP_Phrase() {
        return P_Phrase;
    }

    public void setP_Phrase(String p_Phrase) {
        P_Phrase = p_Phrase;
    }

    public String getF_Phrase() {
        return F_Phrase;
    }

    public void setF_Phrase(String f_Phrase) {
        F_Phrase = f_Phrase;
    }
}
