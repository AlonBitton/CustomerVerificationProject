import { Button, Card, Layout, Typography } from "antd";
import { FC, useEffect } from "react";
import { NavLink, useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import authService from "services/authService";

export const HomePage: FC = () => {
  const navigate = useNavigate();

  useEffect(() => {
    document.title = "Home Page";
  }, []);

  function logout(): void {
    authService.logout();
    navigate("/login");
    toast.success("You have been logout!");
  }

  return (
    <Layout
      style={{
        maxWidth: "90%",
        margin: "0 auto",
        display: "flex",
        flexDirection: "column",
        justifyContent: "center",
        alignItems: "center",
        height: "100vh",
      }}
    >
      <Card style={{ width: "90%", padding: 24 }}>
        <Typography style={{ fontSize: 24, padding: 15 }}>
          Welcome to my Login Verification Project!
        </Typography>
        <Typography style={{ fontSize: 16, paddingBottom: 15 }}>
          This project is one of my software development projects, aimed at
          implementing email verification for user login. The verification
          process is a vital security feature that ensures the user logging in
          is legitimate and prevents unauthorized access to the system.
        </Typography>
        <Typography style={{ fontSize: 16 }}>
          The login verification feature implemented in this project will be
          used in my future software development projects to ensure the security
          and privacy of user data.
        </Typography>
        <Button type="primary" style={{ marginTop: 15 }}>
          <NavLink
            onClick={logout}
            to="/login"
            style={{
              marginTop: "1.5rem",
              fontSize: 14,
              color: "white",
            }}
          >
            Logout and back to Login page.
          </NavLink>
        </Button>
      </Card>
    </Layout>
  );
};
