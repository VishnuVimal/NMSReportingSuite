package com.beehyv.nmsreporting.utils;

/**
 * Created by beehyv on 8/3/17.
 */
public class Constants {

    public static final class Roles {
        public static final String MASTER_ADMIN_ROLE = "MASTER_ADMIN";
        public static final String ADMIN_ROLE = "ADMIN";
        public static final String USER_ROLE = "USER";

        private Roles() {

        }
    }

    public static final class Level {
        public static final String NATIONAL_LEVEL = "NATIONAL";
        public static final String STATE_LEVEL = "STATE";
        public static final String DISTRICT_LEVEL = "DISTRICT";
        public static final String BLOCK_LEVEL = "BLOCK";

        private Level() {

        }
    }

    public static final class AccountStatus {
        public static final String ACTIVE = "ACTIVE";
        public static final String PENDING_ACTIVATION = "PENDING";
        public static final String INACTIVE = "INACTIVE";

        private AccountStatus() {

        }
    }

    public static final class Permissions {
        public static final String CREATE_OR_MODIFY_NATIONAL_ACCOUNTS = "CREATE_OR_MODIFY_NATIONAL_ACCOUNTS";
        public static final String CREATE_OR_MODIFY_STATE_ACCOUNTS = "CREATE_OR_MODIFY_STATE_ACCOUNTS";
        public static final String CREATE_OR_MODIFY_DISTRICT_ACCOUNTS = "CREATE_OR_MODIFY_DISTRICT_ACCOUNTS";
        public static final String CREATE_OR_MODIFY_BLOCK_ACCOUNTS = "CREATE_OR_MODIFY_BLOCK_ACCOUNTS";

        private Permissions() {

        }
    }

    private Constants() {

    }
}
