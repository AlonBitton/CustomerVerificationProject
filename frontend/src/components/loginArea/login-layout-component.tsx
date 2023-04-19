import {
  LockOutlined,
  MailOutlined,
  FacebookOutlined,
  GoogleOutlined,
} from "@ant-design/icons";
import { Button, Divider, Form, Input, Space, Typography } from "antd";
import { Content } from "antd/es/layout/layout";
import { logoImg } from "assets";
import CredentialsModel from "models/CredentialsModel";
import { FC, useState } from "react";
import "./login.css";
import { useNavigate } from "react-router-dom";
import authService from "services/authService";

interface LoginCardProps {
  handleClick?: (event: React.MouseEvent<HTMLAnchorElement>) => void;
}

const LoginCard: FC<LoginCardProps> = ({ handleClick }) => {
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();

  async function send(values: CredentialsModel) {
    setLoading(true);
    const response = await authService.login(values);
    setLoading(false);
    if (response) {     
      if (response.status === 200) {
        navigate("/home");
        return;
      }
      if (response.response.status === 401) {
        navigate("/verify");
        return;
      }
    }
    setLoading(false);
  }

  return (
    <>
      <Content
        style={{
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
          justifyContent: "center",
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
              fontSize: 24,
              fontWeight: 700,
            }}
          >
            Sign In
          </Typography>
        </div>
        <Divider style={{ backgroundColor: "lightgray" }} />

        <Space
          style={{
            display: "flex",
            justifyContent: "center",
            flexWrap: "wrap",
          }}
        >
          <Button
            className="login-with-google-btn"
            // onClick={loginWithGoogle}
          >
            <GoogleOutlined />
            <span style={{ width: "135px" }}>Sign in with Google</span>
          </Button>

          <Button
            className="login-with-facebook-btn"
            // onClick={loginWithFacebook}
          >
            <FacebookOutlined />
            <span style={{ width: "135px" }}>Sign in with Facebook</span>
          </Button>
        </Space>
        <Divider style={{ backgroundColor: "lightgray" }} />
        <Form name="login_form" onFinish={send} style={{ width: "100%" }}>
          <Form.Item
            name="email"
            rules={[{ required: true, message: "Email is required!" }]}
          >
            <Input
              prefix={<MailOutlined />}
              style={{ padding: 10 }}
              size="large"
              type="email"
              placeholder="Email"
            />
          </Form.Item>
          <Form.Item
            name="password"
            rules={[{ required: true, message: "Password is required!" }]}
          >
            <Input
              prefix={<LockOutlined />}
              style={{ padding: 10, marginTop: 10 }}
              size="large"
              type="password"
              placeholder="Password"
            />
          </Form.Item>

          <Form.Item>
            <div style={{ textAlign: "center", padding: 5 }}>
              <Button
                type="primary"
                htmlType="submit"
                loading={loading}
                size="large"
                style={{
                  margin: "0 auto",
                  alignContent: "center",
                }}
              >
                Sign In
              </Button>
            </div>
          </Form.Item>
        </Form>

        <Typography style={{ textAlign: "center", paddingTop: 10 }}>
          Don't have an account?{" "}
          <a href="/" onClick={handleClick}>
            SignUp
          </a>
        </Typography>
      </Content>
    </>
  );
};

export default LoginCard;
