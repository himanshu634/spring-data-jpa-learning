package com.himanshu.spring.data.jpa.demo.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column( name = "guardian_name" )
        ),
        @AttributeOverride(
                name = "emailAddress",
                column = @Column( name = "guardian_email")
        ),
        @AttributeOverride(
                name = "mobileNumber",
                column = @Column( name = "guardian_mobile_number")
        )
})
public class Guardian {
    private String name;
    private String emailAddress;
    private String mobileNumber;

    public Guardian(String name, String emailAddress, String mobileNumber) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.mobileNumber = mobileNumber;
    }

    public Guardian() {
    }

    public static GuardianBuilder builder() {
        return new GuardianBuilder();
    }

    public String getName() {
        return this.name;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Guardian)) return false;
        final Guardian other = (Guardian) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$emailAddress = this.getEmailAddress();
        final Object other$emailAddress = other.getEmailAddress();
        if (this$emailAddress == null ? other$emailAddress != null : !this$emailAddress.equals(other$emailAddress))
            return false;
        final Object this$mobileNumber = this.getMobileNumber();
        final Object other$mobileNumber = other.getMobileNumber();
        if (this$mobileNumber == null ? other$mobileNumber != null : !this$mobileNumber.equals(other$mobileNumber))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Guardian;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $emailAddress = this.getEmailAddress();
        result = result * PRIME + ($emailAddress == null ? 43 : $emailAddress.hashCode());
        final Object $mobileNumber = this.getMobileNumber();
        result = result * PRIME + ($mobileNumber == null ? 43 : $mobileNumber.hashCode());
        return result;
    }

    public String toString() {
        return "Guardian(name=" + this.getName() + ", emailAddress=" + this.getEmailAddress() + ", mobileNumber=" + this.getMobileNumber() + ")";
    }

    public static class GuardianBuilder {
        private String name;
        private String emailAddress;
        private String mobileNumber;

        GuardianBuilder() {
        }

        public GuardianBuilder name(String name) {
            this.name = name;
            return this;
        }

        public GuardianBuilder emailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public GuardianBuilder mobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public Guardian build() {
            return new Guardian(name, emailAddress, mobileNumber);
        }

        public String toString() {
            return "Guardian.GuardianBuilder(name=" + this.name + ", emailAddress=" + this.emailAddress + ", mobileNumber=" + this.mobileNumber + ")";
        }
    }
}
