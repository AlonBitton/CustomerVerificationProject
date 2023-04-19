import { Card, Layout } from "antd";
import { Content } from "antd/es/layout/layout";
import { FC, useEffect, useState } from "react";
import ReactCardFlip from "react-card-flip";
import { getBackgroundImage } from "../../utils/backgroundImage";
import LoginCard from "./login-layout-component";
import "./login.css";

import RegistrationCard from "./registration-layout-component";
const AuthLayout: FC = () => {
  useEffect(() => {
    document.title = "Authentication Page";
  }, []);

  const [backgroundImage, setBackgroundImage] = useState(getBackgroundImage());
  const [isFlipped, setIsFlipped] = useState(false);
  const handleClick = (e: { preventDefault: () => void }) => {
    e.preventDefault();
    setIsFlipped(!isFlipped);
  };
  return (
    <Layout
      style={{
        overflow: "hidden",
        display: "flex",
        backgroundImage: `url(${backgroundImage})`,
        minHeight: "100vh",
        backgroundSize: "cover",
        backgroundRepeat: "no-repeat",
        backgroundPosition: "center",
        alignItems: "center",
        flexDirection: "column",
        justifyContent: "center",
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
            height: "600px",
            display: "flex",
            flexDirection: "column",
            justifyContent: "space-between",
          }}
        >
          <ReactCardFlip isFlipped={isFlipped} flipDirection="horizontal">
            <LoginCard handleClick={handleClick} />

            <RegistrationCard handleClick={handleClick} />
          </ReactCardFlip>
        </Card>
      </Content>
    </Layout>
  );
};

export default AuthLayout;
