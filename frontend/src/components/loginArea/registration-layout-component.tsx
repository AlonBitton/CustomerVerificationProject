import {
  LockOutlined,
  MailOutlined,
  SolutionOutlined,
} from "@ant-design/icons";
import { Button, Divider, Form, Input, Typography } from "antd";
import { Content } from "antd/es/layout/layout";
import { logoImg } from "assets";
import UserModel from "models/userModel";
import { FC, useState } from "react";
import authService from "services/authService";

interface RegistrationCardProps {
  handleClick?: (event: React.MouseEvent<HTMLAnchorElement>) => void;
}

const RegistrationCard: FC<RegistrationCardProps> = ({ handleClick }) => {
  const [loading, setLoading] = useState(false);

  async function send(values: UserModel) {
    setLoading(true);
    const response = await authService.register(values);

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
            Sign Up
          </Typography>
        </div>
        <Divider style={{ backgroundColor: "lightgray" }} />
        <Form onFinish={send} style={{ width: "100%" }} autoComplete="off">
          <Form.Item
            name="email"
            rules={[{ required: true, message: "Email is required!" }]}
          >
            <Input
              style={{ padding: 10 }}
              size="large"
              prefix={<MailOutlined />}
              type="email"
              placeholder="Email"
            />
          </Form.Item>
          <Form.Item
            name="firstName"
            rules={[{ required: true, message: "First Name is required!" }]}
          >
            <Input
              style={{ padding: 10 }}
              size="large"
              prefix={<SolutionOutlined />}
              type="text"
              placeholder="First Name"
            />
          </Form.Item>
          <Form.Item
            name="lastName"
            rules={[{ required: true, message: "Last Name is required!" }]}
          >
            <Input
              style={{ padding: 10 }}
              size="large"
              prefix={<SolutionOutlined />}
              type="text"
              placeholder="Last Name"
            />
          </Form.Item>
          <Form.Item
            name="password"
            rules={[{ required: true, message: "Password is required!" }]}
          >
            <Input
              style={{ padding: 10 }}
              size="large"
              prefix={<LockOutlined className="site-form-item-icon" />}
              type="password"
              placeholder="Password"
            />
          </Form.Item>
          <div style={{ textAlign: "center", padding: 5 }}>
            <Button
              type="primary"
              htmlType="submit"
              loading={loading}
              style={{ margin: "0 auto", alignContent: "center" }}
              size="large"
            >
              Sign Up
            </Button>
          </div>
        </Form>

        <Typography style={{ textAlign: "center", paddingTop: 10 }}>
          Already have an account?{" "}
          <a href="/" onClick={handleClick}>
            Sign-in
          </a>
        </Typography>
      </Content>
    </>
  );
};

export default RegistrationCard;
