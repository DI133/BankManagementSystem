    package com.drashti.bankmanagement.model;

    import java.util.ArrayList;
    import java.util.List;

    public class Customer {
        private String customerId;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String phoneNumber;
        private List<Account> accounts =  new ArrayList<>();

        public Customer(String customerId, String firstName, String lastName, String email, String password, String phoneNumber) {
            this.customerId = customerId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.password = password;
            this.phoneNumber = phoneNumber;
        }

        public Customer(String customerId, String firstName, String lastName, String email, String password, String phoneNumber, List<Account> accounts) {
            this(customerId, firstName, lastName, email, password, phoneNumber);
            if (accounts != null) {
                this.accounts = new ArrayList<>(accounts);
            }
        }

        public String getCustomerId() {
            return customerId;
        }

        // we assign id only once after then no one can change the id
    //    public void setCustomerId(String customerId) {
    //        this.customerId = customerId;
    //    }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public List<Account> getAccounts() {
            // return accounts; someone can clear it so
            return List.copyOf(accounts);
        }

        // instead of this we define other method call addAccount()
    //    public void setAccounts(List<Account> accounts) {
    //        this.accounts = accounts;
    //    }

        public void addAccount(Account account) {
            if (account != null)
                this.accounts.add(account);
        }

        public void removeAccount(Account account) {
            if (account != null)
                this.accounts.remove(account);
        }

        public String getPassword() {
            return password;
        }

        // no one can set password. they can change it through service and repository
    //    public void setPassword(String password) {
    //        this.password = password;
    //    }

        public void updatePassword(String password) {
            this.password = password;
        }


        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            sb.append("Customer Id: ")
                    .append(customerId)
                    .append("\n");

            sb.append("First Name: ")
                    .append(firstName)
                    .append("\n");

            sb.append("Last Name: ")
                    .append(lastName)
                    .append("\n");

            sb.append("Email: ")
                    .append(email)
                    .append("\n");

            sb.append("Phone Number: ")
                    .append(phoneNumber)
                    .append("\n");

            sb.append("Total accounts: ")
                    .append(accounts.size())
                    .append("\n");

            return sb.toString();
        }
    }
