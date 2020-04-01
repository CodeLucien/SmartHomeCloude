
package com.example.entity;
    /**
    *
    *
    **/
public class UserInfo {
    private String telePhone;
    private String userName;
    private String passWord;
    private String image;

        public String getTelePhone() {
            return telePhone;
        }

        public void setTelePhone(String telePhone) {
            this.telePhone = telePhone;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassWord() {
            return passWord;
        }

        public void setPassWord(String passWord) {
            this.passWord = passWord;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public UserInfo(String telePhone, String userName, String passWord, String image) {

            this.telePhone = telePhone;
            this.userName = userName;
            this.passWord = passWord;
            this.image = image;
        }
    }