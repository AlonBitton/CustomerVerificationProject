package com.project.EmailVerification.auth.mail;

public class HTML {

    public static String htmlEmailTemplate(String code){

        // Verify Account URL:
        String url = "http://localhost:8080/api/auth/verify?code=" + code;

        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "  <head>\n" +
                "    <meta charset=\"utf-8\" />\n" +
                "    <meta http-equiv=\"x-ua-compatible\" content=\"ie=edge\" />\n" +
                "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n" +
                "    <title>Email Confirmation</title>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n" +
                "    <style type=\"text/css\">\n" +
                "      @media screen {\n" +
                "        @font-face { \n" +
                "          font-family: \"Source Sans Pro\";\n" +
                "          font-style: normal;\n" +
                "          font-weight: 400;\n" +
                "          src: local(\"Source Sans Pro Regular\"), local(\"SourceSansPro-Regular\"),\n" +
                "            url(https://fonts.gstatic.com/s/sourcesanspro/v10/ODelI1aHBYDBqgeIAH2zlBM0YzuT7MdOe03otPbuUS0.woff)\n" +
                "              format(\"woff\");\n" +
                "        }\n" +
                "        @font-face {\n" +
                "          font-family: \"Source Sans Pro\";\n" +
                "          font-style: normal;\n" +
                "          font-weight: 700;\n" +
                "          src: local(\"Source Sans Pro Bold\"), local(\"SourceSansPro-Bold\"),\n" +
                "            url(https://fonts.gstatic.com/s/sourcesanspro/v10/toadOcfmlt9b38dHJxOBGFkQc6VGVFSmCnC_l7QZG60.woff)\n" +
                "              format(\"woff\");\n" +
                "        }\n" +
                "      }\n" +
                "      /**\n" +
                "   * Avoid browser level font resizing.\n" +
                "   * 1. Windows Mobile\n" +
                "   * 2. iOS / OSX\n" +
                "   */\n" +
                "      body,\n" +
                "      table,\n" +
                "      td,\n" +
                "      a {\n" +
                "        -ms-text-size-adjust: 100%; /* 1 */\n" +
                "        -webkit-text-size-adjust: 100%; /* 2 */\n" +
                "      }\n" +
                "      /**\n" +
                "   * Remove extra space added to tables and cells in Outlook.\n" +
                "   */\n" +
                "      table,\n" +
                "      td {\n" +
                "        mso-table-rspace: 0pt;\n" +
                "        mso-table-lspace: 0pt;\n" +
                "      }\n" +
                "      /**\n" +
                "   * Better fluid images in Internet Explorer.\n" +
                "   */\n" +
                "      img {\n" +
                "        -ms-interpolation-mode: bicubic;\n" +
                "      }\n" +
                "      /**\n" +
                "   * Remove blue links for iOS devices.\n" +
                "   */\n" +
                "      a[x-apple-data-detectors] {\n" +
                "        font-family: inherit !important;\n" +
                "        font-size: inherit !important;\n" +
                "        font-weight: inherit !important;\n" +
                "        line-height: inherit !important;\n" +
                "        color: inherit !important;\n" +
                "        text-decoration: none !important;\n" +
                "      }\n" +
                "      /**\n" +
                "   * Fix centering issues in Android 4.4.\n" +
                "   */\n" +
                "      div[style*=\"margin: 16px 0;\"] {\n" +
                "        margin: 0 !important;\n" +
                "      }\n" +
                "      body {\n" +
                "        width: 100% !important;\n" +
                "        height: 100% !important;\n" +
                "        padding: 0 !important;\n" +
                "        margin-top: 50px !important;" +
                "      }\n" +
                "      /**\n" +
                "   * Collapse table borders to avoid space between cells.\n" +
                "   */\n" +
                "      table {\n" +
                "        border-collapse: collapse !important;\n" +
                "      }\n" +
                "      a {\n" +
                "        color: #1a82e2;\n" +
                "      }\n" +
                "      img {\n" +
                "        height: auto;\n" +
                "        line-height: 100%;\n" +
                "        text-decoration: none;\n" +
                "        border: 0;\n" +
                "        outline: none;\n" +
                "      }\n" +
                "    </style>\n" +
                "  </head>\n" +
                "  <body style=\"background-color: #e9ecef\">\n" +
                "    <div\n" +
                "      class=\"preheader\"\n" +
                "      style=\"\n" +
                "        display: none;\n" +
                "        max-width: 0;\n" +
                "        max-height: 0;\n" +
                "        overflow: hidden;\n" +
                "        font-size: 1px;\n" +
                "        line-height: 1px;\n" +
                "        color: #fff;\n" +
                "        opacity: 0;\n" +
                "      \"\n" +
                "    >\n" +
                "      Verify your account - \n" +
                "    </div>\n" +
                "\n" +
                "    <!-- start body -->\n" +
                "    <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                "\n" +
                "      <!-- start hero -->\n" +
                "      <tr>\n" +
                "        <td align=\"center\" bgcolor=\"#e9ecef\">\n" +
                "          <table\n" +
                "            border=\"0\"\n" +
                "            cellpadding=\"0\"\n" +
                "            cellspacing=\"0\"\n" +
                "            width=\"100%\"\n" +
                "            style=\"max-width: 600px\"\n" +
                "          >\n" +
                "            <tr>\n" +
                "              <td\n" +
                "                align=\"left\"\n" +
                "                bgcolor=\"#ffffff\"\n" +
                "                style=\"\n" +
                "                  padding: 36px 24px 0;\n" +
                "                  font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif;\n" +
                "                  border-top: 3px solid #d4dadf;\n" +
                "                \"\n" +
                "              >\n" +
                "                <h1\n" +
                "                  style=\"\n" +
                "                    margin: 0;\n" +
                "                    font-size: 32px;\n" +
                "                    font-weight: 700;\n" +
                "                    letter-spacing: -1px;\n" +
                "                    line-height: 48px;\n" +
                "                  \"\n" +
                "                >\n" +
                "                  Confirm Your Email Address\n" +
                "                </h1>\n" +
                "              </td>\n" +
                "            </tr>\n" +
                "          </table>\n" +
                "        </td>\n" +
                "      </tr>\n" +
                "      <!-- end hero -->\n" +
                "\n" +
                "      <!-- start copy block -->\n" +
                "      <tr>\n" +
                "        <td align=\"center\" bgcolor=\"#e9ecef\">\n" +
                "          <table\n" +
                "            border=\"0\"\n" +
                "            cellpadding=\"0\"\n" +
                "            cellspacing=\"0\"\n" +
                "            width=\"100%\"\n" +
                "            style=\"max-width: 600px\"\n" +
                "          >\n" +
                "            <!-- start copy -->\n" +
                "            <tr>\n" +
                "              <td\n" +
                "                align=\"left\"\n" +
                "                bgcolor=\"#ffffff\"\n" +
                "                style=\"\n" +
                "                  padding: 24px;\n" +
                "                  font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif;\n" +
                "                  font-size: 16px;\n" +
                "                  line-height: 24px;\n" +
                "                \"\n" +
                "              >\n" +
                "                <p style=\"margin: 0\">\n" +
                "                  Tap the button below to confirm your email address.\n" +
                "                  If you\n" +
                "                  didn't create an account at the website, you can safely delete\n" +
                "                  this email.\n" +
                "                </p>\n" +
                "              </td>\n" +
                "            </tr>\n" +
                "            <!-- end copy -->\n" +
                "\n" +
                "            <!-- start button -->\n" +
                "            <tr style=\"\">\n" +
                "              <td align=\"left\" bgcolor=\"#ffffff\">\n" +
                "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                "                  <tr>\n" +
                "                    <td align=\"center\" bgcolor=\"#ffffff\" style=\"padding: 15px 0px 40px 10px\">\n" +
                "                      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "                        <tr>\n" +
                "                          <td\n" +
                "                            align=\"center\"\n" +
                "                            bgcolor=\"#1a82e2\"\n" +
                "                            style=\"border-radius: 6px\"\n" +
                "                          >\n" +
                "                            <a href='"+ url +"'\n" +
                "                              target=\"_blank\"\n" +
                "                              style=\"\n" +
                "                                display: inline-block;\n" +
                "                                padding: 16px 36px;\n" +
                "                                font-family: 'Source Sans Pro', Helvetica, Arial,\n" +
                "                                  sans-serif;\n" +
                "                                font-size: 16px;\n" +
                "                                color: #ffffff;\n" +
                "                                text-decoration: none;\n" +
                "                                border-radius: 6px;\n" +
                "                              \"\n" +
                "                              >Verify your Account!</a>" +
                "                          </td>\n" +
                "                        </tr>\n" +
                "                      </table>\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                </table>\n" +
                "              </td>\n" +
                "            </tr>\n" +
                "            <!-- end button -->\n" +
                "\n" +
                "          </table>\n" +
                "        </td>\n" +
                "      </tr>\n" +
                "      <!-- end copy block -->\n" +
                "\n" +
                "      <!-- start footer -->\n" +
                "      <tr>\n" +
                "        <td align=\"center\" bgcolor=\"#e9ecef\" style=\"padding: 24px\">\n" +
                "          <table\n" +
                "            border=\"0\"\n" +
                "            cellpadding=\"0\"\n" +
                "            cellspacing=\"0\"\n" +
                "            width=\"100%\"\n" +
                "            style=\"max-width: 600px\"\n" +
                "          >\n" +
                "            <!-- start permission -->\n" +
                "            <tr>\n" +
                "              <td\n" +
                "                align=\"center\"\n" +
                "                bgcolor=\"#e9ecef\"\n" +
                "                style=\"\n" +
                "                  padding: 12px 24px;\n" +
                "                  font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif;\n" +
                "                  font-size: 14px;\n" +
                "                  line-height: 20px;\n" +
                "                  color: #666;\n" +
                "                \"\n" +
                "              >\n" +
                "                <p style=\"margin: 0\">\n" +
                "                  You received this email because we received a request to\n" +
                "                  Verify your account. If you didn't request to\n" +
                "                  verify your account you can safely delete this email.\n" +
                "                </p>\n" +
                "              </td>\n" +
                "            </tr>\n" +
                "            <!-- end permission -->\n" +
                "          </table>\n" +
                "        </td>\n" +
                "      </tr>\n" +
                "      <!-- end footer -->\n" +
                "    </table>\n" +
                "    <!-- end body -->\n" +
                "  </body>\n" +
                "</html>\n";
    }
}
