package pl.kkowalewski.restclient.api.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Login implements Serializable {

    /*------------------------ FIELDS REGION ------------------------*/
    public final static long serialVersionUID = 1041720428871730372L;

    private String username;
    private String password;
    private String md5;
    private String sha1;
    private String sha256;
    private Map<String, Object> additionalProperties = new HashMap<>();

    /*------------------------ METHODS REGION ------------------------*/
    public Login() {
    }

    public Login(String username, String password, String md5, String sha1, String sha256,
                 Map<String, Object> additionalProperties) {
        this.username = username;
        this.password = password;
        this.md5 = md5;
        this.sha1 = sha1;
        this.sha256 = sha256;
        this.additionalProperties = additionalProperties;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    public String getSha256() {
        return sha256;
    }

    public void setSha256(String sha256) {
        this.sha256 = sha256;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Login login = (Login) o;

        return new EqualsBuilder()
                .append(username, login.username)
                .append(password, login.password)
                .append(md5, login.md5)
                .append(sha1, login.sha1)
                .append(sha256, login.sha256)
                .append(additionalProperties, login.additionalProperties)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(username)
                .append(password)
                .append(md5)
                .append(sha1)
                .append(sha256)
                .append(additionalProperties)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("username", username)
                .append("password", password)
                .append("md5", md5)
                .append("sha1", sha1)
                .append("sha256", sha256)
                .append("additionalProperties", additionalProperties)
                .toString();
    }
}
