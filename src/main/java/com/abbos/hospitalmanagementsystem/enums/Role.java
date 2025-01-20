package com.abbos.hospitalmanagementsystem.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.abbos.brainwave_matrix_intern.enums.Permission.*;

@Getter
@AllArgsConstructor
public enum Role {

    ADMIN(Set.of(
            MANAGE_USERS,
            VIEW_PATIENTS,
            MANAGE_ROLES_AND_ASSIGNMENTS,
            CONFIGURE_SETTINGS,
            GENERATE_REPORTS
    )),

    STAFF(Set.of(
            SCHEDULE_APPOINTMENTS,
            UPDATE_INVENTORY,
            MANAGE_BILLING
    )),

    DOCTOR(Set.of(
            VIEW_ASSIGNED_PATIENTS,
            UPDATE_DIAGNOSIS,
            WRITE_PRESCRIPTIONS,
            MANAGE_APPOINTMENTS
    )),

    NURSE(Set.of(
            VIEW_ASSIGNED_PATIENTS,
            UPDATE_PATIENT_STATUS,
            ADMINISTER_TREATMENTS
    ));

    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getAccess()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}

