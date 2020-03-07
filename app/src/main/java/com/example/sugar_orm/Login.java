
package com.example.sugar_orm;

import com.orm.SugarRecord;

public class Login extends SugarRecord {

    String password;



    public Login() {
    }

    public Login(String password) {
        this.password = password;

    }






    @Override
    public String toString() {

        return password
                              ;
    }
}