package pojos;

public class User {

    public long id;
    public String username;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String phone;
    public int userStatus;

    @Override
    public String toString() {
        return "id: " + this.id + "\n" +
                "username: " + this.username + "\n" +
                "firstName: " + this.firstName + "\n" +
                "lastName: " + this.lastName + "\n" +
                "email: " + this.email + "\n" +
                "password: " + this.password + "\n" +
                "phone: " + this.phone + "\n" +
                "userStatus: " + this.userStatus;
    }

    public static User.Builder getBuilder() {
        return new User().new Builder();
    }

    public class Builder {

        private Builder() {}

        public Builder setId(long id) {
            User.this.id = id;
            return this;
        }

        public Builder setUserName(String userName) {
            User.this.username = userName;
            return this;
        }

        public Builder setFirstName(String firstName) {
            User.this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            User.this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            User.this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            User.this.password = password;
            return this;
        }

        public Builder setPhone(String phone) {
            User.this.phone = phone;
            return this;
        }

        public Builder setUserStatus(int userStatus) {
            User.this.userStatus = userStatus;
            return this;
        }

        public User build() {
            return User.this;
        }

    }
}
