import { Card, Divider, Layout, Typography } from "antd";
import { Content } from "antd/es/layout/layout";
import { FC, useState } from "react";
import { getBackgroundImage } from "../../utils/backgroundImage";
import "./login.css";
import { NavLink } from "react-router-dom";
import { logoImg } from "assets";

const VerifyCard: FC = ({}) => {
  const [backgroundImage, setBackgroundImage] = useState(getBackgroundImage());

  return (
    <>
      <Layout
        style={{
          display: "flex",
          backgroundImage: `url(${backgroundImage})`,
          minHeight: "100vh",
          backgroundSize: "cover",
          backgroundRepeat: "no-repeat",
          backgroundPosition: "center",
        }}
      >
        <Content
          style={{
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
            justifyContent: "center",
          }}
        >
          <Card
            className="auth_card"
            style={{
              width: "500px",
              margin: "0 auto",
              padding: "20px",
              display: "flex",
              flexDirection: "column",
              justifyContent: "space-between",
            }}
          >
            <div
              style={{
                alignContent: "center",
                alignItems: "center",
                display: "flex",
                flexDirection: "column",
              }}
            >
              <img width="54px" height="54px" src={logoImg} alt="logo" />
              <Typography
                style={{
                  fontSize: 22,
                  fontWeight: 700,
                }}
              >
                Verify your account!
              </Typography>
            </div>
            <Divider style={{ backgroundColor: "lightgray" }} />
            <Typography style={{ fontSize: 20, textAlign: "center" }}>
              <p>Your account is not verified!,</p>
              verification mail has been sent to your email.
            </Typography>
            <NavLink
              to="/login"
              style={{
                display: "block",
                marginTop: "1.5rem",
                fontSize: 14,
                fontWeight: 700,
                textDecoration: "underline",
                color: "lightskyblue",
              }}
            >
              Back to Login Page
            </NavLink>
          </Card>
        </Content>
      </Layout>
    </>
  );
};

export default VerifyCard;
