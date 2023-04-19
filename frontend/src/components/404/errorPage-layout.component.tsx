import { FC, useEffect } from "react";
import { Card, Layout, Typography } from "antd";
import { NavLink } from "react-router-dom";

const ErrorPage: FC = () => {

  useEffect(() => {
    document.title = "Error Page";
  }, []);

  return (
    <Layout
      style={{
        backgroundColor: 'white',
        padding: 4,
        height: "100vh",
        alignItems: "center",
        flexDirection: "column",
        justifyContent: "center",
        display: "flex",
      }}
    >
      <Card style={{ maxWidth: 350, border: 0, }}>
        <img src="/static/error-page.svg" width="100%" alt="Error 404" />
      </Card>
      <Typography
        style={{ fontSize: 64, fontWeight: 700, color: "#1976d2", marginTop: 3 }}
      >
        Ooops... 404!
      </Typography>
      <Typography style={{ color: "gray", fontWeight: 600 }}>
        The page you requested could not be found.
      </Typography>

      <NavLink
        to="/"
        style={{
          display: "block",
          marginTop: "1.5rem",
          fontSize: 20,
          fontWeight: 700,
          textDecoration: "underline",
          color: "#1976d2",
        }}
      >
        Back to Home Page
      </NavLink>
    </Layout>
  );
};

export default ErrorPage;
