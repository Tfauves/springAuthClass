package com.example.Spring.Auth.models.profile;

import com.example.Spring.Auth.models.Avatar;
import com.example.Spring.Auth.models.auth.User;
import com.example.Spring.Auth.models.report.Report;
import com.example.Spring.Auth.models.servicearea.ServiceArea;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;

    private String profileUsername;

    private String title = "newbie";

    private Integer reportCount = 0;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("id")
    private Avatar profilePic;

    @OneToOne
    private ServiceArea serviceArea;

    @OneToMany
    @JoinColumn(name = "report_id", referencedColumnName = "id")
    private Set<Report> report;

    public Profile() {}

    public Profile(User user, String profileUsername, Avatar profilePic) {
        this.user = user;
        this.profileUsername = profileUsername;
        this.profilePic = profilePic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getProfileUsername() {
        return profileUsername;
    }

    public void setProfileUsername(String profileUsername) {
        this.profileUsername = profileUsername;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Avatar getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(Avatar profilePic) {
        this.profilePic = profilePic;
    }

    public Set<Report> getReport() {
        return report;
    }

    public void setReport(Set<Report> report) {
        this.report = report;
    }

    public Integer getReportCount() {
        return reportCount;
    }

    public void setReportCount(Integer reportCount) {
        this.reportCount = reportCount;
    }

    public ServiceArea getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(ServiceArea serviceArea) {
        this.serviceArea = serviceArea;
    }
}