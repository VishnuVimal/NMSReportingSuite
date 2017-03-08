package com.beehyv.nmsreporting.utils;

/**
 * Created by beehyv on 8/3/17.
 */
public class Constants {

    public static final class Roles {
        public static final String MASTER_ADMIN_ROLE = "master_admin";
        public static final String ADMIN_ROLE = "admin";
        public static final String USER_ROLE = "user";

        private Roles() {

        }
    }

    public static final class Level {
        public static final String NATIONAL_LEVEL = "national";
        public static final String STATE_LEVEL = "state";
        public static final String DISTRICT_LEVEL = "district";
        public static final String BLOCK_LEVEL = "block";

        private Level() {

        }
    }

    public static final class AccountStatus {
        public static final String ACTIVE = "active";
        public static final String PENDING_ACTIVATION = "pending";
        public static final String INACTIVE = "inactive";

        private AccountStatus() {

        }
    }

    public static final class Permissions {
        public static final String CREATE_OR_MODIFY_NATIONAL_ACCOUNTS = "create_or_modify_national_accounts";
        public static final String CREATE_OR_MODIFY_STATE_ACCOUNTS = "create_or_modify_state_accounts";
        public static final String CREATE_OR_MODIFY_DISTRICT_ACCOUNTS = "create_or_modify_district_accounts";
        public static final String CREATE_OR_MODIFY_BLOCK_ACCOUNTS = "create_or_modify_block_accounts";

        private Permissions() {

        }
    }

    private Constants() {

    }
}
