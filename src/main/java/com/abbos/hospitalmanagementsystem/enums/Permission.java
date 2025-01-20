package com.abbos.hospitalmanagementsystem.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Permission {

    // USER
    VIEW_PROFILE("VIEW_PROFILE", "Permission to view own profile"),
    UPDATE_PROFILE("UPDATE_PROFILE", "Permission to update own profile"),

    // ADMIN
    MANAGE_USERS("MANAGE_USERS", "Permission to manage users"),
    VIEW_PATIENTS("VIEW_PATIENTS", "Permission to view all patients"),
    MANAGE_ROLES_AND_ASSIGNMENTS("MANAGE_ROLES_AND_ASSIGNMENTS", "Permission to manage roles and assignments"),
    CONFIGURE_SETTINGS("CONFIGURE_SETTINGS", "Permission to configure hospital-wide settings"),
    GENERATE_REPORTS("GENERATE_REPORTS", "Permission to generate reports"),

    // DOCTOR
    VIEW_ASSIGNED_PATIENTS("VIEW_ASSIGNED_PATIENTS", "Permission to view assigned patients"),
    UPDATE_DIAGNOSIS("UPDATE_DIAGNOSIS", "Permission to update patient diagnosis"),
    WRITE_PRESCRIPTIONS("WRITE_PRESCRIPTIONS", "Permission to write and update prescriptions"),
    MANAGE_APPOINTMENTS("MANAGE_APPOINTMENTS", "Permission to manage own appointments"),

    // NURSE
    UPDATE_PATIENT_STATUS("UPDATE_PATIENT_STATUS", "Permission to update patient status"),
    ADMINISTER_TREATMENTS("ADMINISTER_TREATMENTS", "Permission to administer prescribed treatments"),


    // STAFF
    SCHEDULE_APPOINTMENTS("SCHEDULE_APPOINTMENTS", "Permission to schedule and manage appointments"),
    UPDATE_INVENTORY("UPDATE_INVENTORY", "Permission to update inventory"),
    MANAGE_BILLING("MANAGE_BILLING", "Permission to manage billing and invoicing");

    private final String access;
    private final String description;
}
