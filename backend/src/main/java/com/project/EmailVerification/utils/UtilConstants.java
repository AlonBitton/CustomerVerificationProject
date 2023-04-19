package com.project.EmailVerification.utils;

import java.util.Arrays;
import java.util.List;

public class UtilConstants {

    public static final String JWT_SECRET = "EmailVerificationProject";
    // public static final long EXPIRATION_TIME = 864_000_000; // 10 days

    public static final String CODE_SECRET = "QAzVerificationCodeOLM";

    public static final long EXPIRATION_TIME = 36_000_000; // 10 hours
    // public static final long EXPIRATION_TIME = 3_600_000;// 1 hour
    // public static final long EXPIRATION_TIME = 600_000; // 10 minutes
    public static long EXPIRATION_TIME_CODE =  1_800_000; // 30 minutes
    public static final String BEARER_TOKEN_PREFIX = "Bearer ";
    public static final String AUTH_HEADER = "Authorization";
}