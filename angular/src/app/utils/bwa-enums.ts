export namespace BwaEnums {
  export type LoginStatusEnum = 'LOGGED_OUT' | 'LOGIN_FAILED' | 'LOGGED_IN' | 'NOT_EXISTS';
  export const LoginStatusEnum = {
    LOGGED_OUT: 'LOGGED_OUT' as LoginStatusEnum,
    LOGGED_IN: 'LOGGED_IN' as LoginStatusEnum,
    LOGIN_FAILED: 'LOGIN_FAILED' as LoginStatusEnum,
    NOT_EXISTS: 'NOT_EXISTS' as LoginStatusEnum
  };

  export type SignUpStatusEnum = 'CREATED' | 'ALREADY_EXISTS' | 'CREATION_FAILED' | 'CANCELLED';
  export const SignUpStatusEnum = {
    CREATED: 'CREATED' as SignUpStatusEnum,
    ALREADY_EXISTS: 'ALREADY_EXISTS' as SignUpStatusEnum,
    CREATION_FAILED: 'CREATION_FAILED' as SignUpStatusEnum,
    CANCELLED: 'CANCELLED' as SignUpStatusEnum
  };
}
