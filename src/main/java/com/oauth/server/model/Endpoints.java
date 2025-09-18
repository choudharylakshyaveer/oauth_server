package com.oauth.server.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "security.endpoints")
public class Endpoints {

    private List<String> publicMatchers = List.of();
    private List<RoleBased> roleBased = List.of();

    public List<String> getPublicMatchers() {
        return publicMatchers;
    }

    public void setPublicMatchers(List<String> publicMatchers) {
        this.publicMatchers = publicMatchers;
    }

    public List<RoleBased> getRoleBased() {
        return roleBased;
    }

    public void setRoleBased(List<RoleBased> roleBased) {
        this.roleBased = roleBased;
    }

    public static class RoleBased {
        private String path;
        private List<String> roles = List.of();

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public List<String> getRoles() {
            return roles;
        }

        public void setRoles(List<String> roles) {
            this.roles = roles;
        }
    }
}
